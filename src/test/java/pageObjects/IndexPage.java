package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class IndexPage extends MovieStorePage {

    @FindBy(xpath = "//div[@class='grid_3']//a[text()]")
    private List<WebElement> popularMovieLinks;

    public IndexPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getPopularMovies() {
        return popularMovieLinks
                .stream()
                .map(webElement -> webElement.getAttribute("title"))
                .collect(Collectors.toList());
    }

    public void clickPopularMovie(String movieName) {
        WebElement popularMovie = popularMovieLinks
                .stream()
                .filter(webElement -> webElement.getAttribute("title").equals(movieName))
                .findFirst()
                .orElse(null);
        if (popularMovie != null) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", popularMovie);
            popularMovie.click();
        }
    }
}
