package stepsDefinition;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.AuthenticationPage;
import pages.CreateAccountPage;
import pages.HomePage;
import tests.TestBase;

public class UserRegistrationSteps extends TestBase {

    HomePage homePage;
    AuthenticationPage authenticationPage;
    CreateAccountPage createAccountPage;

    @Given("^the user is on the home page$")
    public void the_user_is_on_the_home_page(){
        homePage  = new HomePage(driver);
        homePage.openSignInAndRegisterPage();
    }

    @When("^I click on the sign in link$")
    public void I_click_on_the_sign_in_link(){
        Assert.assertTrue(driver.getCurrentUrl().contains("my-account"));
    }

//    @When("^I entered the user data$")
//    public void I_entered_the_user_data(){
//        authenticationPage = new AuthenticationPage(driver);
//        authenticationPage.registerWithMail("yasminateya96@gmail.com"); // static data
//    }

    @When("^I entered \"([^\"]*)\"$")
    public void i_entered(String mail) {
        authenticationPage = new AuthenticationPage(driver);
        authenticationPage.registerWithMail(mail);
    }

    @Then("^The registration page is displayed$")
    public void The_registration_page_is_displayed(){
        createAccountPage = new CreateAccountPage(driver);
        Assert.assertTrue(createAccountPage.genderMr.isDisplayed());
    }
}
