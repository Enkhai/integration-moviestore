package cucumber.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import testCases.VerifyMoviePage;

public class MoviePageSteps {

    VerifyMoviePage movieTestCases = new VerifyMoviePage();

    @Given("The browser opens and the movie page loads")
    public void theBrowserOpensAndTheMoviePageLoads() {
        movieTestCases.launchBrowser("chrome");
    }

    @After("@moviePageScenario")
    public void closeTheMoviePageBrowser() {
        movieTestCases.terminateBrowser();
    }

}
