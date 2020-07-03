package testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import pageObjects.MoviePage;

public class VerifyMoviePage extends VerifyMovieStorePage<MoviePage> {
    private String moviePageUrl = "http://localhost/moviestore" +
            "/movie.php?type=genre&genreId=36";

    @BeforeMethod
    @Override
    public void resetPage() {
        driver.get(moviePageUrl);
        page = PageFactory.initElements(driver, MoviePage.class);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }
}
