package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AuthenticationPage;
import pages.CreateAccountPage;
import pages.HomePage;

public class AuthenticationTest extends TestBase {

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

        doAssertEqual(authenticationPage.alertLabelMail.isDisplayed(), true, "Create an account page is displayed");
        softAssert.assertAll();
    }

    @Test(priority = 2)
    public void registerWithValidMail() throws InterruptedException {

        authenticationPage = new AuthenticationPage(driver);
        authenticationPage.registerWithMail(validMail);

        createAccountPage = new CreateAccountPage(driver);

        Thread.sleep(10000);
        Assert.assertTrue(createAccountPage.genderMr.isDisplayed());
        softAssert.assertAll();
    }

}
