package tests;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.model.Status;
import java.lang.reflect.Method;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.listeners.TestListener;

@Listeners({ TestListener.class })
@Epic("EPIC LOGIN")
@Feature("FEATURE LOGIN")

public class LoginTests extends BaseTest {
	@Owner("Vo Thi Thu Phuoc")
	@Link(url="https://demo.nopcommerce.com/")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Đây là description của testcase")
	@Test(priority = 0, description = "Loginwith wrong username and password.")
	public void InvalidUserNameInvalidPassword(Method method) throws InterruptedException {
		Allure.step("Mở trang Nopcomerce");
		homePage.goToNopcommerce().goToLoginPage().loginToNopcomerce("thuphuoc@gmail.com", "15011998");
		Thread.sleep(3000);
		Allure.step("Verify title của trang web", Status.FAILED);
		Assert.assertEquals(driver.getTitle(), "nopCommerce demo store. Login");

	}

	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 1, description = "Login with empty username and password.")
	public void EmptyUserEmptyPassword(Method method) throws InterruptedException {
		Allure.step("Mở trang Nopcomerce");
		homePage.goToNopcommerce().goToLoginPage().loginToNopcomerce("", "");
		Thread.sleep(3000);
		Allure.step("Verify title của trang web", Status.FAILED);
		Assert.assertEquals(driver.getTitle(), "nopCommerce demo store. Loginddee");
	}

}