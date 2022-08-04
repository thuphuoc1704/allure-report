package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Allure;
import utils.logs.Log;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    String baseURL = "https://demo.nopcommerce.com/";

    By signInButtonClass = By.xpath("//a[text()='Log in']");
    public HomePage goToNopcommerce() {
        driver.get(baseURL);
        return this;
    }

    //Go to LoginPage
    public LoginPage goToLoginPage() {
    	Allure.step("Click to Link login");
        click(signInButtonClass);
        return new LoginPage(driver);
    }
}