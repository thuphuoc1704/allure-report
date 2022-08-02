package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.aventstack.extentreports.model.Report;

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

   
    public  LoginPage loginToNopcomerce(String username, String password) {
        writeText(userNameId, username);
        writeText(passwordId, password);
        click(loginButtonId);
        return this;
    }
}