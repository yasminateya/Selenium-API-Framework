package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AuthenticationPage;
import pages.HomePage;

public class SignInTest_DataProvider extends TestBase {

    HomePage homePage;
    AuthenticationPage authenticationPage;

    @DataProvider(name = "testData", indices = {0, 1, 2})
    public static Object[][] userData(){

            return new Object[][]{
                    {"yasmin", "123"}, //invalid-invalid
                    {"yasminateya96@gmail.com", "123"}, //valid-invalid
                    {"yasmin", "37081128"}, //invalid-valid
                    {"yasminateya96@gmail.com", "37081128"} //valid-valid
            };

//        JSONObject object = new JSONObject();
//        object.put("name", "Kiss");
//        object.put("year", "1973");
//        return new Object[][] {{object}}; //another way to implement
    }

    @Test(priority = 1, dataProvider = "testData")
    public void signInWithInValidMailAndPass(String mail, String password) {

        homePage = new HomePage(driver);
        homePage.openSignInAndRegisterPage();

        authenticationPage = new AuthenticationPage(driver);
        authenticationPage.signIn(mail, password);

        doAssertEqual(authenticationPage.alertLabel.isDisplayed(), true, "The mail or password are valid");
        softAssert.assertAll();
    }
//
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
//    public void signInSuccessfullyWithValidMailAndValidPass() throws InterruptedException {
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
