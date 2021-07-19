package tests;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import io.github.bonigarcia.wdm.WebDriverManager;

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

    boolean doAssertEqual(Object Actual, Object Expected, String message) {
        softAssert.assertEquals(Actual, Expected, message);
        if (!String.valueOf(Expected).equals(String.valueOf(Actual))) {
            saveScreenshotPNG();
            return false;
        }

        return true;
    }

    @AfterClass
    public void quitDriver() {

        driver.quit();
    }

    public void saveScreenshotPNG() {
        ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

}
