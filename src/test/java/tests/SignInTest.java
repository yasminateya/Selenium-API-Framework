package tests;

import org.testng.annotations.Test;
import pages.AuthenticationPage;
import pages.HomePage;
import pages.MyAccountPage;

public class SignInTest extends TestBase {

    HomePage homePage;
    AuthenticationPage authenticationPage;
    MyAccountPage myAccountPage;

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

    @Test(priority = 2)
    public void signInWithValidMailAndInValidPass() {

        homePage = new HomePage(driver);
        homePage.openSignInAndRegisterPage();

        authenticationPage = new AuthenticationPage(driver);
        authenticationPage.signIn(validMail, invalidPassword);

        doAssertEqual(authenticationPage.alertLabelPass.isDisplayed(), true, "The password is valid");
        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void signInWithInValidMailAndValidPass() {

        homePage = new HomePage(driver);
        homePage.openSignInAndRegisterPage();

        authenticationPage = new AuthenticationPage(driver);
        authenticationPage.signIn(invalidMail, validPassword);

        doAssertEqual(authenticationPage.alertLabelMail.isDisplayed(), true, "The mail is valid");
        softAssert.assertAll();
    }

    @Test(priority = 4)
    public void signInWithValidMailAndValidPass() throws InterruptedException {

        homePage = new HomePage(driver);
        homePage.openSignInAndRegisterPage();

        authenticationPage = new AuthenticationPage(driver);
        authenticationPage.signIn(validMail, validPassword);

        myAccountPage = new MyAccountPage(driver);
        doAssertEqual(myAccountPage.checkElementIsDisplayed(myAccountPage.myAccountPageTitle), true,"Mail and password " +
                "are not valid");
        softAssert.assertAll();

    }

}
