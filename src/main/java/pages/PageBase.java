package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public PageBase(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 1000);
    }

    public boolean checkElementIsDisplayed(By element) {

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            driver.findElement(element).isDisplayed();
        } catch (Exception e) {
            System.out.println("Couldn't find element" + element);
            return false;
        }
        return true;
    }

    public void visibilityWait(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void visibilityWait(By element) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
}
