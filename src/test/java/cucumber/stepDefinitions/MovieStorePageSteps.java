package cucumber.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import pageObjects.IndexPage;
import pageObjects.MovieStorePage;
import testCases.VerifyMovieStorePage;

public class MovieStorePageSteps {

    VerifyMovieStorePage<MovieStorePage> genericPageSteps = new VerifyMovieStorePage<MovieStorePage>() {
        @BeforeMethod
        @Override
        public void resetPage() {
            driver.get("http://localhost/moviestore");
            page = PageFactory.initElements(driver, IndexPage.class);
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
        }
    };

    @Given("The browser opens and a generic page loads")
    public void theBrowserOpensAndAGenericPageLoads() {
        genericPageSteps.launchBrowser("chrome");
    }

    @Given("the generic page reloads")
    public void theGenericPageReloads() {
        genericPageSteps.resetPage();
    }

    @Then("verify the user is redirected to the login page")
    public void verifyRedirectedToTheLoginPage() {
        genericPageSteps.verifyLoginRedirect();
    }

    @Then("verify the user can view a category from the dropdown menu")
    public void verifyCanViewACategoryFromDropdown() {
        genericPageSteps.verifyDropdownCategoryRedirect();
    }

    @Then("verify the user can view each of the Popular, Upcoming and Top Rated categories from the dropdown menu")
    public void verifyCanViewMiscCategoriesFromDropdown() {
        genericPageSteps.verifyMiscDropdownCategoryRedirect();
    }

    @Then("verify the user can search for a specific movie by title")
    public void verifyTheUserCanSearchForMovie() throws InterruptedException {
        genericPageSteps.verifyMovieSearch();
    }

    @Then("verify the user can view a category from the footer")
    public void verifyCanViewACategoryFromFooter() {
        genericPageSteps.verifyFooterCategoryRedirect();
    }

    @Then("verify the user can view each of the Popular, Upcoming and Top Rated categories from the footer")
    public void verifyCanViewMiscCategoriesFromFooter() {
        genericPageSteps.verifyMiscFooterCategoryRedirect();
    }

    @After("@genericPageScenario")
    public void closeTheGenericPageBrowser() {
        genericPageSteps.terminateBrowser();
    }
}
