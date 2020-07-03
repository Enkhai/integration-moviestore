package cucumber.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import testCases.VerifySinglePage;

public class SinglePageSteps {

    VerifySinglePage singleTestCases = new VerifySinglePage();

    @Given("The browser opens and the single page loads")
    public void theBrowserOpensAndTheSinglePageLoads() {
        singleTestCases.launchBrowser("chrome");
    }

    @Given("the single page reloads")
    public void theIndexPageReloads() {
        singleTestCases.resetPage();
    }

    @Then("verify the single page title")
    public void verifyTheIndexPageTitle() {
        singleTestCases.verifyMovieTitle();
    }

    @Then("verify the user can go to the home page")
    public void verifyTheUserCanGoToTheHomePage() {
        singleTestCases.verifyHomePageRedirect();
    }

    @Then("verify the number of comments displayed is correct")
    public void verifyTheNumberOfCommentsDisplayedIsCorrect() {
        singleTestCases.verifyCommentNumberIsCorrect();
    }

    @Then("verify the user can view a similar movie")
    public void verifyTheUserCanViewASimilarMovie() {
        singleTestCases.verifySimilarMovieRedirect();
    }

    @After("@singlePageScenario")
    public void closeTheIndexPageBrowser() {
        singleTestCases.terminateBrowser();
    }
}
