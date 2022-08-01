package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;
import utils.logs.Log;

public class LoginPage extends BasePage {
    /**Constructor*/
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**Web Elements*/
    By userNameId = By.xpath("//input[@id='Email']");
    By passwordId = By.xpath("//input[@id='Password']");
    By loginButtonId = By.xpath("//button[text()='Log in']");

    @Step("Input username: {0} password:  {1}")
    public LoginPage loginToNopcomerce(String username, String password) {
        Log.info("Login to nopcomerce ne nha.");
        writeText(userNameId, username);
        writeText(passwordId, password);
        click(loginButtonId);
        return this;
    }
}