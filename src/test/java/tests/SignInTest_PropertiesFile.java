package tests;

import data.LoadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AuthenticationPage;
import pages.HomePage;
import pages.MyAccountPage;

public class SignInTest_PropertiesFile extends TestBase {

    HomePage homePage;
    AuthenticationPage authenticationPage;
    MyAccountPage myAccountPage;

    //load data from userdata.properties file
    String inValidMail = LoadProperties.userData.getProperty("inValidMail");
    String inValidPassword = LoadProperties.userData.getProperty("inValidPassword");
    String validMail = LoadProperties.userData.getProperty("validMail");
    String validPassword = LoadProperties.userData.getProperty("validPassword");

    @Test(priority = 1)
    public void signInWithInValidMailAndInValidPass() {

        homePage = new HomePage(driver);
        homePage.openSignInAndRegisterPage();

        authenticationPage = new AuthenticationPage(driver);
        authenticationPage.signIn(inValidMail, inValidPassword);

        doAssertEqual(authenticationPage.alertLabelMail.isDisplayed(), true, "The mail is valid");
        softAssert.assertAll();
    }

    @Test(priority = 2)
    public void signInWithValidMailAndInValidPass() {

        homePage = new HomePage(driver);
        homePage.openSignInAndRegisterPage();

        authenticationPage = new AuthenticationPage(driver);
        authenticationPage.signIn(validMail, inValidPassword);

        doAssertEqual(authenticationPage.alertLabelPass.isDisplayed(), true, "The password is valid");
        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void signInWithInValidMailAndValidPass() {

        homePage = new HomePage(driver);
        homePage.openSignInAndRegisterPage();

        authenticationPage = new AuthenticationPage(driver);
        authenticationPage.signIn(inValidMail, validPassword);

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
        Thread.sleep(1000);
        Assert.assertTrue(myAccountPage.myAccountNavBar.isDisplayed());
        softAssert.assertAll();

    }

}
