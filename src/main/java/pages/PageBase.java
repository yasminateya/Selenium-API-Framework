package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageBase {

    protected WebDriver driver;

    public PageBase(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    public boolean checkElementIsDisplayed(By element) {
        try {
            wait(1000);
            driver.findElement(element).isDisplayed();
            return true;
        } catch (Exception e) {
            System.out.println("Couldn't find element" + element);
        }
        return false;
    }
}
