package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class VerifyLoginPage extends VerifyMovieStorePage<LoginPage> {

    private final String loginPageUrl = "http://localhost/moviestore/login.php";

    @BeforeMethod
    @Override
    public void resetPage() {
        driver.get(loginPageUrl);
        page = PageFactory.initElements(driver, LoginPage.class);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @Test
    @Override
    public void verifyMovieSearch() {
        // Login page does not implement movie search
    }

    @Test
    public void verifySignUpRedirect() {
        String signUpURL = "https://www.themoviedb.org/account/signup";
        page.clickSignUp();
        Assert.assertEquals(driver.getCurrentUrl(), signUpURL);
    }

    @Test
    public void verifyForgotPasswordRedirect() {
        String forgotPasswordURL = "https://www.themoviedb.org/account/reset-password";
        page.clickForgotPasswordButton();
        Assert.assertEquals(driver.getCurrentUrl(), forgotPasswordURL);
    }

    @Test
    public void verifySuccessfulLoginAndLogout() throws InterruptedException {
        String dummyUser = "dummySelenium";
        String dummyPassword = "12345";

        page.login(dummyUser, dummyPassword);
        Thread.sleep(2000);
        Assert.assertEquals(driver.getTitle(), "MovieStore | Home");
        Assert.assertNotNull(driver.findElement(By.linkText(dummyUser)));

        driver.findElement(By.xpath("//i[@class='edit']//a")).click();
        // User should no longer be found / logged in the app
        Assert.assertEquals(driver.findElements(By.linkText(dummyUser)).size(), 0);
    }

    @Test
    public void verifyUnsuccessfulLogin() {
        String dummyUser = "dummySelenium";
        String dummyPassword = "123456789";

        page.login(dummyUser, dummyPassword);
        Assert.assertEquals(page.getWarningText(), "Wrong credentials");
    }
}
