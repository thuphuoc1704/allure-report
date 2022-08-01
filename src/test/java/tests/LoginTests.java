package tests;

import static utils.extentreports.ExtentTestManager.startTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.listeners.TestListener;

//In order to eliminate attachment problem for Allure, you should add @Listener line.
//link: https://github.com/allure-framework/allure1/issues/730
@Listeners({ TestListener.class })
@Epic("Regression Tests")
@Feature("Login Tests")

public class LoginTests extends BaseTest {
    @Test(priority = 0, description = "Invalid Login Scenario with wrong username and password.")
    public void InvalidUserNameInvalidPassword(Method method) throws InterruptedException {
        startTest(method.getName(), "Invalid Login Scenario with invalid username and password.");
        homePage
            .goToNopcommerce()
            .goToLoginPage()
            .loginToNopcomerce("thuphuoc@gmail.com", "15011998");
            Thread.sleep(3000);
		    Assert.assertEquals(driver.getTitle(), "nopCommerce demo store. Login");
    }

    @Test(priority = 1, description = "Invalid Login Scenario with empty username and password.")
    public void EmptyUserEmptyPassword(Method method) throws InterruptedException {
        startTest(method.getName(), "Invalid Login Scenario with empty username and password.");
        homePage
            .goToNopcommerce()
            .goToLoginPage()
            .loginToNopcomerce("", "");
        Thread.sleep(3000);
	    Assert.assertEquals(driver.getTitle(), "nopCommerce demo store. Login");
    }
    
}