package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by David Wright - 27/09/2019
 *
 * Currency search page
 *
 */

public class CurrencySearch {

    private WebDriverWait wait;
    WebDriver driver;


    public CurrencySearch(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,10);
    }

    //Identify elements on the page
    @FindBy(xpath="//div[1]/div/button[@role='button']") public WebElement sourceCurrencyField;
    @FindBy(xpath="//div[3]/div/button[@role='button']") public WebElement targetCurrencyField;
    @FindBy(xpath="//select[@id='sourceCurrency']") public WebElement sourceCurrencyDropDown;
    @FindBy(xpath="//select[@id='targetCurrency']") public WebElement targetCurrencyDropDown;
    @FindBy(id="cc-amount") private WebElement ccAmount;
    @FindBy(id="convert") private WebElement convertBtn;

    //Set a currency for the currency dropdown menus
    public void setCurrency(WebElement currencyDropDown, String currency) {
        Select sel = new Select(currencyDropDown);
        sel.selectByValue(currency);
    }

    //Wait for source currency drop down to be visable
    public void isSourceDropDownVisable() {
        wait.until(ExpectedConditions.visibilityOf(sourceCurrencyField));
    }

    //Wait for target currency drop down to be visable
    public void isTargetDropDownVisable() {
        wait.until(ExpectedConditions.visibilityOf(targetCurrencyField));
    }

    //Clear Amount field
    public void clearAmount() {
        ccAmount.clear();
    }

    //Set an amount to convert
    public void setAmount(double amount) {
        ccAmount.sendKeys(String.valueOf(amount));
    }

    //Click Convert button
    public void clickConvertBtn() {
        convertBtn.click();
    }
}
