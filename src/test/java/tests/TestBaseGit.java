package tests;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import utilities.Helper;

import java.util.concurrent.TimeUnit;

public class TestBaseGit {

    public static WebDriver driver;
    public SoftAssert softAssert;

    @BeforeClass
    public void initiateDriver() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
//        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.navigate().to("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);
        
    }

    @BeforeMethod
    void beforeMethod() {

        softAssert = new SoftAssert();

    }

    @AfterMethod
    void afterMethod() {

        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void screenshotOnFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("Failed!");
            System.out.println("Taking Screenshot....");
            Helper.captureScreenshot(driver, result.getName());
        }
    }

    boolean doAssertEqual(Object Actual, Object Expected, String message) {

        softAssert.assertEquals(Actual, Expected, message);
        return String.valueOf(Expected).equals(String.valueOf(Actual));
    }

    @AfterClass
    public void quitDriver() {

        driver.quit();
    }

}
