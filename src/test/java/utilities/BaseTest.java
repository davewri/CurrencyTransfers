package utilities;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    /**
     * Created by David Wright - 27/09/2019
     *
     * Base Test class
     *
     */

    public WebDriver driver;
    Constants constants = new Constants();

    public void setUpBeforeTestClass(int browser) {
        switch (browser) {
            case 1:
                //Firefox browser
                //I do not have Firefox on my machine to test with...
                System.setProperty("webdriver.gecko.driver", constants.GECKODRIVER);
                driver = new FirefoxDriver();
                break;
            case 2:
                //Chrome browser
                System.setProperty("webdriver.chrome.driver", constants.CHROMEDRIVER);
                driver = new ChromeDriver();
                break;
            case 3:
                //code for IE
                //I do not have IE on my machine to test with...
                driver = new InternetExplorerDriver();
                break;
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        PropertyConfigurator.configure(constants.LOG4JPROPERTIES);
    }

    public void tearDownAfterTestClass() {
        driver.quit();
    }
}
