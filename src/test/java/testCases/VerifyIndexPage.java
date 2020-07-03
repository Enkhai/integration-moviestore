package testCases;

import org.junit.After;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.IndexPage;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class VerifyIndexPage extends VerifyMovieStorePage<IndexPage> {

    private final String indexPageUrl = "http://localhost/moviestore";

    @BeforeMethod
    @Override
    public void resetPage() {
        driver.get(indexPageUrl);
        page = PageFactory.initElements(driver, IndexPage.class);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @Test
    public void verifyIndexPageTitle() {
        String expectedTitle = "MovieStore | Home";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void verifyPopularMovieRedirect() {
        List<String> popularMovies = page.getPopularMovies();
        String movie = popularMovies.get(
                ThreadLocalRandom.current().nextInt(0, popularMovies.size()));
        page.clickPopularMovie(movie);

        String expectedTitle = "MovieStore | Movie: " + movie;
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
