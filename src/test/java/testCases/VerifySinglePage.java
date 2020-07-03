package testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.SinglePage;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class VerifySinglePage extends VerifyMovieStorePage<SinglePage> {

    private String singlePageUrl = "http://localhost/moviestore" +
            "/single.php?movieId=475430";

    @BeforeMethod
    @Override
    public void resetPage() {
        driver.get(singlePageUrl);
        page = PageFactory.initElements(driver, SinglePage.class);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @Test
    public void verifyMovieTitle() {
        String expectedTitle = "MovieStore | Movie: " + page.getMovieTitle();
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void verifyHomePageRedirect() {
        page.clickHomeButton();
        String expectedTitle = "MovieStore | Home";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void verifyCommentNumberIsCorrect() {
        Assert.assertEquals(page.getComments().size(), page.getNumberOfComments());
    }


    @Test
    public void verifySimilarMovieRedirect() {
        List<String> similarMovies = page.getSimilarMovies();
        String similarMovie = similarMovies.get(
                ThreadLocalRandom.current().nextInt(0, similarMovies.size()));
        page.clickSimilarMovie(similarMovie);

        String expectedTitle = "MovieStore | Movie: " + similarMovie;
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
