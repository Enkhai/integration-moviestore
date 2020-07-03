package cucumber.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import testCases.VerifyLoginPage;

public class LoginPageSteps {

    VerifyLoginPage loginTestCases = new VerifyLoginPage();

    @Given("The browser opens and the login page loads")
    public void theBrowserOpensAndTheSinglePageLoads() {
        loginTestCases.launchBrowser("chrome");
    }

    @Given("the login page reloads")
    public void theIndexPageReloads() {
        loginTestCases.resetPage();
    }


    @Then("verify the user is redirected to sign up")
    public void verifyTheUserIsRedirectedToSignUp() {
        loginTestCases.verifySignUpRedirect();
    }
    
    @Then("verify the user is redirected for a new password")
    public void verifyTheUserIsRedirectedForANewPassword() {
        loginTestCases.verifyForgotPasswordRedirect();
    }

    @Then("verify the user should be able to login and then log out")
    public void verifyTheUserShouldBeAbleToLoginAndThenLogOut() throws InterruptedException {
        loginTestCases.verifySuccessfulLoginAndLogout();
    }

    @Then("verify a Wrong Credentials message is displayed")
    public void verifyAWrongCredentialsMessageIsDisplayed() {
        loginTestCases.verifyUnsuccessfulLogin();
    }

    @After("@loginPageScenario")
    public void closeTheLoginPageBrowser() {
        loginTestCases.terminateBrowser();
    }
}
