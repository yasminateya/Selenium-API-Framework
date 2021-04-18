package tests;

import org.testng.annotations.Test;
import pages.AuthenticationPage;
import pages.CreateAccountPage;
import pages.HomePage;

public class SignInTest extends TestBase {

    HomePage homePage;
    AuthenticationPage authenticationPage;
    CreateAccountPage createAccountPage;
    String validMail = "yasminateya96@gmail.com";
    String invalidMail = "yasmin";
    String validPassword = "37081128";
    String invalidPassword = "123";

    @Test(priority = 1)
    public void signInWithInValidMailAndInValidPass() {

        homePage = new HomePage(driver);
        homePage.openSignInAndRegisterPage();

        authenticationPage = new AuthenticationPage(driver);
        authenticationPage.signIn(invalidMail, invalidPassword);

        doAssertEqual(authenticationPage.alertLabelMail.isDisplayed(), true, "The mail is valid");
        softAssert.assertAll();
    }
}
