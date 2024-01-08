package web.Pages;

import org.openqa.selenium.By;

import com.dhl.testdata.TestData_Json;
import com.dhl.utils.Variables;
import com.dhl.web.utils.SeleniumActions;

@SuppressWarnings("unused")
public class LoginPage extends TestData_Json {

	private static final By byAppUser = By.id("login-username");
	private static final By bySubmitUserBtn = By.xpath("//input[contains(@value,'SUBMIT USERNAME')]");
	private static final By byAppPassword = By.id("login-password");
	private static final By byLoginBtn = By.id("login-submit");
	private static final By bySSOLogin = By.xpath("//a[contains(text(),'SSO Login')]");

	/**
	 * Function to enter username
	 * @param strUsername - value of username
	 */
	public static void enter_Username(String strUsername) {
		SeleniumActions.sendTextToElement(byAppUser, strUsername, "Username");
	}

	/**
	 * Function to click on submit user
	 *
	 */
	public static void click_SubmitUser() {
		SeleniumActions.click(bySubmitUserBtn, "Submit User button");
	}

	/**
	 * Function to enter password
	 * @param strPassword - value of password
	 */
	public static void enter_password(String strPassword) {
		SeleniumActions.sendTextToElement(byAppPassword, strPassword, "Password", true);
	}

	/**
	 * Function to click login button
	 */
	public static void click_LoginBt() {
		Variables.set("mainwindow", SeleniumActions.getCurrentWindowHandle());
		SeleniumActions.click(byLoginBtn, "Login button");
	}
	/**
	 * Function to click ssologin button
	 */
	public static void click_SsoLogin() {
		SeleniumActions.click(bySSOLogin, "SSO Login");
	}
}