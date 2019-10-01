package tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CurrencyConvertResults;
import pages.CurrencySearch;
import utilities.BaseTest;
import utilities.Constants;
import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import static utilities.UtilityMethods.readFile;

/**
 * Created by David Wright - 27/09/2019
 *
 * Test currency search:
 * Iterate through 5 currency conversions:
 *      Assert currency From and To H1 in results page
 *      Assert currency conversion values (taking exchange rate to calculate conversion rate for expected results)
 *
 */

public class TestCurrency extends BaseTest {

    Logger logger = Logger.getLogger(TestCurrency.class);

    Constants constants = new Constants();
    CurrencySearch currencySearch;
    CurrencyConvertResults currencyResults;

    @BeforeTest
    public void setUpBeforeTest() {
        super.setUpBeforeTestClass(2);
        currencySearch = PageFactory.initElements(driver, CurrencySearch.class);
        currencyResults = PageFactory.initElements(driver, CurrencyConvertResults.class);

        //Navigate to transferwise.com currency-converter page
        super.driver.get(constants.BASEURL);

        //Wait for currency drop down menus to be visable?
        currencySearch.isSourceDropDownVisable();
        currencySearch.isTargetDropDownVisable();
    }

    @Test
    public void testCurrencies() throws IOException {
        //Read currencies CSV file to a list
        ArrayList<String> currData = readFile(constants.CURRENCIESCSVFILE);

        ArrayList<String> eachCurr = new ArrayList<String>();
        ArrayList<String> headerResults = new ArrayList<String>();
        ArrayList<String> exchangeRate = new ArrayList<String>();

        String currencyHeader;

        //For each currency iteration
        for (String curr:currData) {
            for (String s:curr.split(",")) {
                eachCurr.add(s);
            }

            currencySearch.clearAmount();
            currencySearch.setAmount(Double.parseDouble(eachCurr.get(0)));

            currencySearch.setCurrency(currencySearch.sourceCurrencyDropDown, eachCurr.get(1));
            currencySearch.setCurrency(currencySearch.targetCurrencyDropDown, eachCurr.get(2));

            currencySearch.clickConvertBtn();

            currencyHeader = currencyResults.getCurrencyHeaderText();

            for (String result:currencyHeader.split(" ")) {
                headerResults.add(result);
            }

            logger.info("Expected Currency From: " + eachCurr.get(1) + " - Expected Currency To: " + eachCurr.get(2));
            logger.info("Actual Currency From: " + headerResults.get(0) + " - Actual Currency To: " + headerResults.get(2));

            //Assert Header Currencies to be converted From and To
            Assert.assertEquals(headerResults.get(0), eachCurr.get(1));
            Assert.assertEquals(headerResults.get(2), eachCurr.get(2));

            for(String rate:currencyResults.getExchangeRateValue().split(" ")) {
                exchangeRate.add(rate);
            }

            //Assert Amount From and Amount To (using exchange rate at the time)
            logger.info("Expected amount to convert: " + Double.parseDouble(eachCurr.get(0)) + " - Expected amount converted: " + Double.parseDouble(eachCurr.get(0)) * Double.parseDouble(exchangeRate.get(0)));
            logger.info("Actual amount to convert: " + currencyResults.getAmountFromValue() + " - Actual anount converted: " + currencyResults.getAmountToValue());
            System.out.println("--------------------------------------");

            Assert.assertEquals(currencyResults.getAmountFromValue(), Double.parseDouble(eachCurr.get(0)));
            Assert.assertEquals(currencyResults.getAmountToValue(), Double.parseDouble(eachCurr.get(0)) * Double.parseDouble(exchangeRate.get(0)));

            //Clean array lists after each loop
            eachCurr.clear();
            headerResults.clear();
            exchangeRate.clear();

            super.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            super.driver.get(constants.BASEURL);
        }
    }

    @AfterTest
    public void afterTest() {
        tearDownAfterTestClass();
    }
}
