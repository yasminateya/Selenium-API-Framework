package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends PageBase{
    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//label[normalize-space()='Mr.']")
    public WebElement genderMr;

    @FindBy(xpath = "//input[@id='customer_firstname']")
    public WebElement firstName;
}
