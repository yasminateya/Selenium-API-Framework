package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthenticationPage extends PageBase {

    public AuthenticationPage(WebDriver driver) {
        super(driver);
    }

    //Create an account locators
    @FindBy(id = "email_create")
    WebElement emailTextFieldRegister;

    @FindBy(css = "button[id='SubmitCreate'] span")
    WebElement createAnAccountBtn;

    //Already register locators
    @FindBy(css = "button[id='SubmitLogin'] span")
    WebElement emailTextFieldSignIn;

    @FindBy(id = "passwd")
    WebElement passwordTextField;

    @FindBy(css = "button[id='SubmitLogin'] span")
    WebElement signInBtn;

    //Alerts
    @FindBy(xpath = "//li[normalize-space()='Invalid email address.']")
    public WebElement alertLabelMail;

    @FindBy(xpath = "//li[normalize-space()='Invalid password.']")
    public WebElement alertLabelPass;

//***********************************Methods*********************************************//

    public void registerWithMail(String mail) {
        emailTextFieldRegister.sendKeys(mail);
        createAnAccountBtn.click();
    }

    public void signIn(String mail, String password) {
        emailTextFieldSignIn.sendKeys(mail);
        passwordTextField.sendKeys(password);
        signInBtn.click();
    }

}
