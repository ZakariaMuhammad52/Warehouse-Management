package web.Pages;

import org.openqa.selenium.By;

import com.dhl.driver.DriverManager;
import com.dhl.reports.FrameworkLogger;
import com.dhl.reports.LogType;
import com.dhl.testdata.TestData_Json;
import com.dhl.web.utils.SeleniumActions;

import stepdefinitions.CommonMethods;

@SuppressWarnings("unused")
public class CommonPopupPage extends TestData_Json {

	private static final By byOkButton = By.xpath("//span[contains(text(),'Ok')]");
	private static final By byPopupMessage = By.xpath("//div[contains(@class,'alert-message')]");
	private static final By byCloseIcon = By.xpath("//button//ion-icon[@name='close']");
	private static final By byConfirmButton = By.xpath("//span[contains(text(),'Confirm')]");
	private static final By bySubmitButton = By.xpath("//*[contains(@data-component-id,'submit-btn')]");
	private static final By bySubmit2Button = By.xpath("(//ion-button[contains(@data-component-id,'submit-btn')])[2]");
	private static final By byYesButton = By.xpath("//*[contains(@data-component-id,'yes-btn')]");
	private static final By byToastMessage = By.xpath("//div[contains(@class,'ion-text-wrap')]");
	private static final By byDismissButton = By.xpath("//*[contains(text(),'DISMISS')]");
	private static final By byGoButton = By.xpath("//*[contains(@data-component-id,'go-btn')]");

	/**
	 * Function to click ok button
	 */
	public static void clickOkButton() {
		SeleniumActions.click(byOkButton, "Ok button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click Confirm button
	 */
	public static void clickConfirmButton() {
		CommonMethods.waitForPageLoading();
		if (DriverManager.getDriver().findElements(byConfirmButton).size() > 0) {
			SeleniumActions.click(byConfirmButton, "Confirm button");
			CommonMethods.waitForPageLoading();
		}
	}

	/**
	 * Function to verify Popup Message Contains
	 * 
	 * @param message - value to verify
	 */
	public static void verifyPopupMessageContains(String message) {
		String actualMessage = SeleniumActions.getText(byPopupMessage);
		if (actualMessage != null && !actualMessage.trim().isEmpty()) {
			if (actualMessage.contains(message)) {
				FrameworkLogger.log(LogType.PASS, "Verification of Popup message passed. " + actualMessage);
			} else {
				FrameworkLogger.log(LogType.FAIL,
						"Verification of Popup message failed. Expected : " + message + ", Actual : " + actualMessage);
			}
		} else {
			FrameworkLogger.log(LogType.FAIL, "Verification of Popup message failed. popup message is null or empty");
		}
	}

	/**
	 * Function to click Close Icon
	 */
	public static void clickCloseIcon() {
		SeleniumActions.click(byCloseIcon, "Close Icon ");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click Submit button
	 */
	public static void clickSubmitButton() {
		SeleniumActions.click(bySubmitButton, "Submit button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click Submit2 button
	 */
	public static void clickSubmit2Button() {
		SeleniumActions.click(bySubmit2Button, "Submit2 button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click Yes button
	 */
	public static void clickYesButton() {
		SeleniumActions.click(byYesButton, "Yes button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to verify Toast Message Contains
	 * 
	 * @param message - value to verify
	 */
	public static void verifyToastMessageContains(String message) {
		String actualMessage = SeleniumActions.getText(byToastMessage);
		if (actualMessage != null && !actualMessage.trim().isEmpty()) {
			if (actualMessage.contains(message)) {
				FrameworkLogger.log(LogType.PASS, "Verification of Toast message passed. " + actualMessage);
			} else {
				FrameworkLogger.log(LogType.FAIL,
						"Verification of Toast message failed. Expected : " + message + ", Actual : " + actualMessage);
			}
		} else {
			FrameworkLogger.log(LogType.FAIL, "Verification of Toast message failed. popup message is null or empty");
		}
	}

	/**
	 * Function to click Dismiss button
	 */
	public static void clickDismissButton() {
		SeleniumActions.click(byDismissButton, "Dismiss button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click Go button
	 */
	public static void clickGoButton() {
		SeleniumActions.click(byGoButton, "Go button");
		CommonMethods.waitForPageLoading();
	}
}