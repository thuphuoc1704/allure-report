package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import utils.logs.Log;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By userNameId = By.xpath("//input[@id='Email']");
    By passwordId = By.xpath("//input[@id='Password']");
    By loginButtonId = By.xpath("//button[text()='Log in']");

   
    public  LoginPage loginToNopcomerce(String username, String password) {
    	Allure.step("Nhập username:"+ username +", password: "+password);
        writeText(userNameId, username);
        writeText(passwordId, password);
        Allure.step("Click to login button");
        click(loginButtonId);
        return this;
    }
}