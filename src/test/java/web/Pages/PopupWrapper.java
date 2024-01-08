package web.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.dhl.driver.DriverManager;
import com.dhl.reports.FrameworkLogger;
import com.dhl.reports.LogType;
import com.dhl.testdata.TestData_Json;
import com.dhl.utils.CurrentThreadInstance;
import com.dhl.utils.Variables;
import com.dhl.web.utils.SeleniumActions;

import stepdefinitions.CommonMethods;

@SuppressWarnings("unused")
public class PopupWrapper extends TestData_Json {

	private static final By byAlertPopupWindow = By
			.xpath("//div[@class='alert-wrapper ion-overlay-wrapper sc-ion-alert-md']");
	private static final By byAlertTitleText = By.xpath(
			"//div[@class='alert-wrapper ion-overlay-wrapper sc-ion-alert-md']//h2[contains(@class,'alert-title')]");
	private static final By byAlertMessageText = By.xpath(
			"//div[@class='alert-wrapper ion-overlay-wrapper sc-ion-alert-md']//div[contains(@class,'alert-message')]");

	private static final By byAlertOkButton = By.xpath(
			"//div[@class='alert-wrapper ion-overlay-wrapper sc-ion-alert-md']//div[contains(@class,'alert-button')]");
	private static final By byVarianceText = By
			.xpath("//error-validation-popup//td[contains(text(),'Variance exists for ASN')]");
	private static final By byItemVariance = By.xpath("//span[contains(text(),'Item Variance')]");
	private static final By byLPNVariance = By.xpath("//span[contains(text(),'LPN Variance'])");
	// a[contains(text(),'FN02-BOOK-1')]
	private static final By byitemsinVariance = By.xpath("//*[@class='datatable-row-wrapper ng-star-inserted']//a");

	private static final By byVarianceWarningCode = By.xpath("//error-validation-popup//td[@class='codeWidth']");
	private static final By byVarianceAcceptButton = By
			.xpath("//error-validation-popup//ion-button[contains(@class,'accept-btn right')]");
	// error-validation-popup//td[contains(text(),'Variance exists for ASN')]
	private static final By byVerifyASNBtnPopup = By.xpath("//ion-button[contains(@data-component-id,'verify-btn')]");
	private static final By byErrorPopup = By.xpath("//div[contains(@data-component-id,'popover_error_message')]");
	/**
	 * Function to Validate item and lpn message /** Function to validate popup
	 * message
	 * 
	 * @param strMsg - message to be validated
	 */
	public static void validatePopupMessage(String strMsg) {
		String strAlertTitle = SeleniumActions.getText(byAlertTitleText);
		if (strAlertTitle != null && !strAlertTitle.trim().isEmpty()) {
			String strAlertmessage = SeleniumActions.getText(byAlertMessageText);
			// Add method to validate message text based on title
			FrameworkLogger.log(LogType.PASS, "Popup Confirmation " + strAlertTitle + " message " + strAlertmessage);
			SeleniumActions.click(byAlertOkButton, "OK button");
		} else {
			FrameworkLogger.log(LogType.FAIL, "Popup Title is null or empty");
		}
	}

	/**
	 * Function to validate popup message
	 * 
	 * @param //strMsg - message to be validated
	 */
	public static void validateWarningPopupMessage() {
		String strAlertTitle = SeleniumActions.getText(byAlertTitleText);
		if (strAlertTitle != null && !strAlertTitle.trim().isEmpty()) {
			String strAlertmessage = SeleniumActions.getText(byAlertMessageText);
			FrameworkLogger.log(LogType.PASS, strAlertTitle + " message " + strAlertmessage);
			SeleniumActions.click(byAlertOkButton, "OK button");
			SeleniumActions.closeBrowser();
			SeleniumActions.switchToLastWindow();
		} else {
			FrameworkLogger.log(LogType.INFO, "Popup Title is null or empty");
		}
	}

	/**
	 * Function to Blind Receive confirmation not available
	 *
	 */
	public static void BlindPopupMessage() {
		FrameworkLogger.log(LogType.PASS, "Popup Confirmation not available for Blind receive");
		SeleniumActions.closeBrowser();
		SeleniumActions.switchToLastWindow();
	}

	/**
	 * Function to Validate variance message
	 * 
	 * @param strMsg - variance message
	 */
	public static void validateVarianceMessage(String strMsg) {
		String strAlertmessage = SeleniumActions.getText(byVarianceText);
		if (strAlertmessage != null && !strAlertmessage.trim().isEmpty()) {
			if (strAlertmessage.equalsIgnoreCase(strMsg)) {
				FrameworkLogger.log(LogType.PASS, "Variance message " + strAlertmessage);
				SeleniumActions.click(byVarianceAcceptButton, "Accept button");
				CommonMethods.waitForPageLoading();
			} else {
				FrameworkLogger.log(LogType.FAIL,
						"Variance message is different, Actual : " + strAlertmessage + "Expected : " + strMsg);
			}
		} else {
			FrameworkLogger.log(LogType.FAIL, "Variance message is null or empty");
		}
	}

	/**
	 * Function to verify item and lpn variance in VerifyASN screen
	 *
	 */
	public static void validateitemandlpnVariance() {
		CommonMethods.waitForPageLoading();
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byItemVariance, "Expand Item Variance");
		List<WebElement> ls = DriverManager.getDriver().findElements(byitemsinVariance);

		if (ls.size() == 2) {
			for (int i = 1; i <= ls.size(); i++) {
				String text = SeleniumActions
						.getText(By.xpath("(//*[@class='datatable-row-wrapper ng-star-inserted']//a)[" + i + "]"));
				text.equalsIgnoreCase(getDataFromFeature(getData("ItemID1_Line" + i + "")));
				FrameworkLogger.log(LogType.PASS, "Variances displayed");
			}
		} else {
			FrameworkLogger.log(LogType.FAIL, "Wrong Variances displayed");
		}
		SeleniumActions.click(byVerifyASNBtnPopup, "clicked on verify button");
	}

	/**
	 * Function to verify error message for Invalid Item
	 *
	 */
	public static void validateInvalidItemPopupMessage() {
		String strActualErrormessage = SeleniumActions.getText(byErrorPopup);
		String strExpectedErrorMessage = "Item " + getDataFromFeature("getdata(InvalidItemID_Line1)")
				+ " is not present on ASN "
				+ (Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN").toString()) + ". (RCV::117)";

		if (SeleniumActions.verifyTextEquals(strActualErrormessage, strExpectedErrorMessage)) {
			FrameworkLogger.log(LogType.PASS, "Expected error message is " + strActualErrormessage);
		} else {
			FrameworkLogger.log(LogType.FAIL, "Invalid error message is " + strActualErrormessage);
		}
		CommonMethods.waitForPageLoading();
		// SeleniumActions.closeBrowser();
		// SeleniumActions.switchToLastWindow();
	}

	/**
	 * Function to verify Variance Warning Code in VerifyASN screen
	 * @param strMsg - alert message
	 *
	 */
	public static void validateVarianceWarningCode(String strMsg) {
		String strAlertmessage = SeleniumActions.getText(byVarianceWarningCode);
		if (strAlertmessage != null && !strAlertmessage.trim().isEmpty()) {
			if (strAlertmessage.equalsIgnoreCase(strMsg)) {
				FrameworkLogger.log(LogType.PASS, "Variance message " + strAlertmessage);

				CommonMethods.waitForPageLoading();
			} else {
				FrameworkLogger.log(LogType.FAIL,
						"Variance message is different, Actual : " + strAlertmessage + "Expected : " + strMsg);
			}
		} else {
			FrameworkLogger.log(LogType.FAIL, "Variance message is null or empty");
		}
	}
}
