package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase{

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public By myAccountPageTitle = By.xpath("//h1[normalize-space()='My account']");
    public By myWishLists = By.xpath("//span[normalize-space()='My wishlists']");

    @FindBy(xpath = "//span[@class='navigation_page']")
    public WebElement myAccountNavBar;




}
