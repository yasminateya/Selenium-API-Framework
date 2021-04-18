package tests;


import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class TestBase extends AbstractTestNGCucumberTests {

    public static WebDriver driver;
    public SoftAssert softAssert;

    @BeforeSuite
    public void initiateDriver() {

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.navigate().to("http://automationpractice.com/index.php");
    }

    @BeforeMethod
    void beforeMethod() {

        softAssert = new SoftAssert();

    }

    @AfterMethod
    void afterMethod() {

        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    }

    boolean doAssertEqual(Object Actual, Object Expected, String message) {

        softAssert.assertEquals(Actual, Expected, message);
        return String.valueOf(Expected).equals(String.valueOf(Actual));
    }

    @AfterSuite
    public void quitDriver() {

        driver.quit();
    }
}
