package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends MovieStorePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@class='acount-btn']")
    WebElement signUpButton;

    @FindBy(linkText = "Forgot Your Password?")
    WebElement forgotPasswordButton;

    @FindBy(xpath = "//input[@value='Login']")
    WebElement loginButton;

    @FindBy(xpath = "//input[@name='user']")
    WebElement userTextBox;

    @FindBy(xpath = "//input[@name='pass']")
    WebElement passwordTextBox;

    @FindBy(xpath = "//form/label")
    WebElement warningLabel;

    @Override
    public void searchMovie(String movieName) {
        // Login page does not implement movie search
    }

    public void clickSignUp() {
        signUpButton.click();
    }

    public void clickForgotPasswordButton() {
        forgotPasswordButton.click();
    }

    public void login(String username, String password) {
        userTextBox.sendKeys(username);
        passwordTextBox.sendKeys(password);
        loginButton.click();
    }

    public String getWarningText() {
        return warningLabel.getAttribute("innerHTML");
    }
}
