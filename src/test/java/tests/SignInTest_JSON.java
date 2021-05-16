package tests;

import data.JSONDataReader;
import data.UserCredentials;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AuthenticationPage;
import pages.HomePage;

import java.io.IOException;

public class SignInTest_JSON extends TestBase {

    HomePage homePage;
    AuthenticationPage authenticationPage;

//    String validMail = "yasminateya96@gmail.com";
//    String validPassword = "37081128";

    @DataProvider(name = "Json data")
    Object[] userData () throws IOException, ParseException {
        JSONDataReader jsonDataReader = new JSONDataReader();
        return jsonDataReader.jsonReader();
    }

    @Test(priority = 1, dataProvider = "Json data")
    public void signInWithInValidMailOrInValidPass(UserCredentials credential) {

//        Object[] user = jsonData.split(", ");

        homePage = new HomePage(driver);
        homePage.openSignInAndRegisterPage();

        authenticationPage = new AuthenticationPage(driver);
//        authenticationPage.signIn(user[0].toString(), user[1].toString());
        authenticationPage.signIn(credential.mail, credential.password);

        doAssertEqual(authenticationPage.alertLabel.isDisplayed(), true, "The mail or password are valid");
        softAssert.assertAll();
    }

//    @Test(priority = 2)
//    public void signInWithValidMailAndInValidPass() {
//
//        homePage = new HomePage(driver);
//        homePage.openSignInAndRegisterPage();
//
//        authenticationPage = new AuthenticationPage(driver);
//        authenticationPage.signIn(validMail, invalidPassword);
//
//        doAssertEqual(authenticationPage.alertLabelPass.isDisplayed(), true, "The password is valid");
//        softAssert.assertAll();
//    }
//
//    @Test(priority = 3)
//    public void signInWithInValidMailAndValidPass() {
//
//        homePage = new HomePage(driver);
//        homePage.openSignInAndRegisterPage();
//
//        authenticationPage = new AuthenticationPage(driver);
//        authenticationPage.signIn(invalidMail, validPassword);
//
//        doAssertEqual(authenticationPage.alertLabelMail.isDisplayed(), true, "The mail is valid");
//        softAssert.assertAll();
//    }

//    @Test(priority = 4)
//    public void signInWithValidMailAndValidPass() throws InterruptedException {
//
//        homePage = new HomePage(driver);
//        homePage.openSignInAndRegisterPage();
//
//        authenticationPage = new AuthenticationPage(driver);
//        authenticationPage.signIn(validMail, validPassword);
//
//        myAccountPage = new MyAccountPage(driver);
//        Thread.sleep(1000);
//        Assert.assertTrue(myAccountPage.myAccountNavBar.isDisplayed());
//        softAssert.assertAll();
//
//    }

}
