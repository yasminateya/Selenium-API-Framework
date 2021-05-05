package tests;

import data.ExcelReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AuthenticationPage;
import pages.HomePage;
import pages.MyAccountPage;

import java.io.IOException;

public class SignInTest_Excel extends TestBase {

    HomePage homePage;
    AuthenticationPage authenticationPage;
    MyAccountPage myAccountPage;

    @DataProvider (name = "Excel data")
    public Object[][] userData() throws IOException {
        ExcelReader excelReader = new ExcelReader();
        return excelReader.getExcelData();
    }

    @Test(priority = 1, dataProvider = "Excel data")
    public void signInWithInValidMailAndInValidPass(String mail, String password) {

        homePage = new HomePage(driver);
        homePage.openSignInAndRegisterPage();

        authenticationPage = new AuthenticationPage(driver);
        authenticationPage.signIn(mail, password);

        doAssertEqual(authenticationPage.alertLabelMail.isDisplayed(), true, "The mail is valid");
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
//
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
