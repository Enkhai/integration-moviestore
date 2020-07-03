package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.MovieStorePage;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public abstract class VerifyMovieStorePage<P extends MovieStorePage> {

    protected P page;
    String windowsChromeDriverPath = "webDrivers/chromedriver_win32_83/chromedriver.exe";
    String linuxChromeDriverPath = "webDrivers/chromedriver";
    String windowsFirefoxDriverPath = "webDrivers/geckodriver-v0.26.0-win64/geckodriver.exe";
    String linuxFirefoxDriverPath = "webDrivers/geckodriver";
    protected WebDriver driver;

    @BeforeClass
    @Parameters("browser")
    public void launchBrowser(String browser) {
        String os = System.getProperty("os.name");
        if (browser.equals("chrome")) {
            if (os.contains("Windows"))
                System.setProperty("webdriver.chrome.driver", windowsChromeDriverPath);
            else
                System.setProperty("webdriver.chrome.driver", linuxChromeDriverPath);
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            if (os.contains("Windows"))
                System.setProperty("webdriver.gecko.driver", windowsFirefoxDriverPath);
            else
                System.setProperty("webdriver.gecko.driver", linuxFirefoxDriverPath);
            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
    }

    @BeforeMethod
    abstract public void resetPage();

    @Test
    public void verifyLoginRedirect() {
        page.clickLoginButton();
        String expectedTitle = "MovieStore | Login";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void verifyDropdownCategoryRedirect() {
        List<String> categories = page.getDropdownCategories();
        String category = categories.get(4);
        page.clickDropdownCategory(category);

        String expectedTitle = "MovieStore | Category: " + category;
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void verifyMiscDropdownCategoryRedirect() {
        List<String> categories = Arrays.asList("Upcoming", "Popular", "Top Rated");
        for (String category : categories) {
            resetPage();
            verifyMiscDropdownCategoryRedirect(category);
        }
    }

    public void verifyMiscDropdownCategoryRedirect(String category) {
        page.clickDropdownCategory(category);
        String expectedTitle = "MovieStore | " + category;
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void verifyMovieSearch() throws InterruptedException {
        String movieToSearch = "test";
        page.searchMovie(movieToSearch);
        Thread.sleep(2000);

        String expectedTitle = "MovieStore | Search: " + movieToSearch;
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void verifyFooterCategoryRedirect() {
        List<String> categories = page.getFooterCategories();
        String category = categories.get(
                ThreadLocalRandom.current().nextInt(0, categories.size()));
        page.clickFooterCategory(category);

        String expectedTitle = "MovieStore | Category: " + category;
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void verifyMiscFooterCategoryRedirect() {
        List<String> categories = page.getMiscFooterCategories();
        for (String category : categories) {
            resetPage();
            verifyMiscFooterCategoryRedirect(category);
        }
    }

    public void verifyMiscFooterCategoryRedirect(String category) {
        page.clickMiscFooterCategory(category);

        String expectedTitle = "MovieStore | " + category;
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @AfterClass
    public void terminateBrowser() {
        driver.close();
    }
}
