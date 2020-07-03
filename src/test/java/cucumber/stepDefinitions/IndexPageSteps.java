package cucumber.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import testCases.VerifyIndexPage;

public class IndexPageSteps{

    VerifyIndexPage indexTestCases = new VerifyIndexPage();

    @Given("The browser opens and the index page loads")
    public void theBrowserOpensAndTheIndexPageLoads() {
        indexTestCases.launchBrowser("chrome");
    }

    @Given("the index page reloads")
    public void theIndexPageReloads() {
        indexTestCases.resetPage();
    }

    @Then("verify the index page title")
    public void verifyTheIndexPageTitle() {
        indexTestCases.verifyIndexPageTitle();
    }

    @Then("verify the user can view a popular movie")
    public void verifyTheUserCanViewAPopularMovie() {
        indexTestCases.verifyPopularMovieRedirect();
    }

    @After("@indexPageScenario")
    public void closeTheIndexPageBrowser() {
        indexTestCases.terminateBrowser();
    }
}
