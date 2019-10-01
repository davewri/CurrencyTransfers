package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by David Wright - 27/09/2019
 *
 * Currency conversion results page
 *
 */

public class CurrencyConvertResults {

    private WebDriverWait wait;
    WebDriver driver;

    public CurrencyConvertResults(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,10);
    }

    @FindBy(xpath="//div[@class='cc__bg-primary cc__bg-primary--wrapped p-b-5']/div[@class='container']//h1") public WebElement currenciesHeader;
    @FindBy(css="[class='cc__source-to-target m-t-2'] span:nth-of-type(3)") public WebElement exchangeRate;
    @FindBy(id="cc-amount-from") public WebElement amountFrom;
    @FindBy(id="cc-amount-to") public WebElement amountTo;

    public String getCurrencyHeaderText() {
        return currenciesHeader.getAttribute("innerHTML");
    }

    public String getExchangeRateValue() {
        return exchangeRate.getAttribute("innerHTML");
    }

    public double getAmountFromValue() {
        return Double.parseDouble(amountFrom.getAttribute("value"));
    }

    public double getAmountToValue() {
        return Double.parseDouble(amountTo.getAttribute("value"));
    }

}
