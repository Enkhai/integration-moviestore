package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class SinglePage extends MovieStorePage {
    public SinglePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='desc1 span_3_of_2']//p[1]")
    WebElement title;

    @FindBy(xpath = "//h1[contains(text(),'Comments')]")
    WebElement commentIndicator;

    @FindBy(xpath = "//ul[@class='single_list']/li")
    List<WebElement> comments;

    @FindBy(xpath = "//div[@class='col-md-3']//a")
    List<WebElement> similarMovies;

    public String getMovieTitle() {
        return title.getAttribute("innerHTML")
                // Title contains a strong tag
                .replaceAll("<strong>Title: </strong>\n", "")
                // Title has multiple spaces before
                .replaceAll("^ +", "")
                // And after the title name
                .replaceAll(" +$", "");
    }

    public int getNumberOfComments() {
        return Integer.parseInt(commentIndicator
                .getAttribute("innerHTML")
                .replaceAll(" Comments", ""));
    }

    public List<String> getComments() {
        return comments
                .stream()
                .map(webElement -> webElement.findElement(
                        By.tagName("p")).getAttribute("innerHTML")
                ).collect(Collectors.toList());
    }

    public List<String> getSimilarMovies() {
        return similarMovies
                .stream()
                .map(webElement -> webElement.getAttribute("title")
                ).collect(Collectors.toList());
    }

    public void clickSimilarMovie(String movie) {
        WebElement similarMovie = similarMovies
                .stream()
                .filter(webElement -> webElement
                        .getAttribute("title")
                        .equals(movie))
                .findFirst()
                .orElse(null);
        if (similarMovie != null){
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", similarMovie);
            similarMovie.click();
        }
    }
}
