package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public abstract class MovieStorePage {
    WebDriver driver;

    public MovieStorePage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@class='col-sm-3 logo']/a")
    WebElement movieStoreButton;

    @FindBy(className = "dropdown")
    WebElement categoryDropdown;

    @FindBy(xpath = "//div[@class='col-sm-6 nav']//p/a")
    List<WebElement> categoriesDropdown;

    @FindBy(linkText = "Login here")
    WebElement loginButton;

    @FindBy(xpath = "//input[@name='search']")
    WebElement searchBox;

    @FindBy(xpath = "//div[@class='footer_box']/div[1]//a")
    List<WebElement> footerCategories;

    @FindBy(xpath = "//div[@class='footer_box']/div[2]//a")
    List<WebElement> miscFooterCategories;

    public void clickHomeButton() {
        movieStoreButton.click();
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public List<String> getDropdownCategories() {
        return categoriesDropdown
                .stream()
                .map(webElement -> webElement.getAttribute("innerHTML"))
                .collect(Collectors.toList());
    }

    public void clickDropdownCategory(String categoryName) {
        Actions action = new Actions(driver);
        action.moveToElement(categoryDropdown).perform();

        categoriesDropdown
                .stream()
                .filter(categoryElement -> categoryElement.getAttribute("innerHTML").equals(categoryName))
                .findFirst()
                .ifPresent(WebElement::click);
    }

    public void searchMovie(String movieName) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchBox);
        searchBox.click();
        searchBox.sendKeys(movieName);
        searchBox.sendKeys(Keys.RETURN);
    }

    public List<String> getFooterCategories() {
        return footerCategories
                .stream()
                .map(categoryElement -> categoryElement.getAttribute("innerHTML"))
                .collect(Collectors.toList());
    }

    public void clickFooterCategory(String categoryName) {
        WebElement footerCategory = footerCategories
                .stream()
                .filter(categoryElement -> categoryElement.getAttribute("innerHTML").equals(categoryName))
                .findFirst()
                .orElse(null);

        if (footerCategory != null) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", footerCategory);
            footerCategory.click();
        }
    }

    public List<String> getMiscFooterCategories() {
        return miscFooterCategories
                .stream()
                .map(categoryElement -> categoryElement.getAttribute("innerHTML"))
                .collect(Collectors.toList());
    }

    public void clickMiscFooterCategory(String categoryName) {
        WebElement miscFooterCategory = miscFooterCategories
                .stream()
                .filter(categoryElement -> categoryElement.getAttribute("innerHTML").equals(categoryName))
                .findFirst()
                .orElse(null);
        if (miscFooterCategory != null){
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", miscFooterCategory);
            miscFooterCategory.click();
        }
    }
}
