package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AuthenticationPage;
import pages.CreateAccountPage;
import pages.HomePage;


public class AuthenticationTestGit extends TestBaseGit {

    HomePage homePage;
    AuthenticationPage authenticationPage;
    CreateAccountPage createAccountPage;
    String validMail = "yasminateya96@gmail.com";
    String invalidMail = "yasmin";

    @Test(priority = 1)
    public void registerWithInValidMail() {

        homePage = new HomePage(driver);
        homePage.openSignInAndRegisterPage();

        authenticationPage = new AuthenticationPage(driver);
        authenticationPage.registerWithMail(invalidMail);

        authenticationPage.visibilityWait(authenticationPage.alertLabelMail);

        Assert.assertFalse(authenticationPage.alertLabelMail.isDisplayed(), "Create an account page is displayed");
//todo: make it assertTrue
    }

    @Test(priority = 2)
    public void registerWithValidMail() {

        authenticationPage = new AuthenticationPage(driver);
        authenticationPage.registerWithMail(validMail);

        createAccountPage = new CreateAccountPage(driver);

        createAccountPage.visibilityWait(createAccountPage.genderMr);

        Assert.assertTrue(createAccountPage.genderMr.isDisplayed()); //I can use the assertTrue method directly also

    }




}
