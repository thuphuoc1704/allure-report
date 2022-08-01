package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.logs.Log;

public class HomePage extends BasePage {
    /**
     * Constructor
     */
    public HomePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Variables
     */
    String baseURL = "https://demo.nopcommerce.com/";

    /**
     * Web Elements
     */
    By signInButtonClass = By.xpath("//a[text()='Log in']");

    /**
     * Page Methods
     */
    //Go to Homepage
    public HomePage goToNopcommerce() {
        Log.info("Opening Nopcomerce Website.");
        driver.get(baseURL);
        return this;
    }

    //Go to LoginPage
    public LoginPage goToLoginPage() {
        Log.info("Click to login link");
        click(signInButtonClass);
        return new LoginPage(driver);
    }
}