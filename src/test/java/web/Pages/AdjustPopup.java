package web.Pages;

import org.openqa.selenium.By;

import com.dhl.testdata.TestData_Json;
import com.dhl.web.utils.KeyboardActions;
import com.dhl.web.utils.SeleniumActions;

import stepdefinitions.CommonMethods;

@SuppressWarnings("unused")
public class AdjustPopup extends TestData_Json {

	private static final By byAdjustPopUpTitle = By.xpath("//ion-title[@data-component-id='Adjust-header']");
	private static final By byADDRadioBtn = By.xpath("//ion-radio[@data-component-id='resetvalue-radio-btn-content']");
	private static final By byRemoveRatioBtn = By
			.xpath("//ion-radio[@data-component-id='negativeinventory-radio-btn-content']");
	private static final By byCurrentQuantityText = By.xpath("//span[contains(@data-component-id,'UNIT')]");
	private static final By byAddField = By
			.xpath("//input[contains(@data-component-id,'additemremainder-input-number')]");
	private static final By byRemoveField = By
			.xpath("//input[contains(@data-component-id,'removeitemremainder-input-number')]");
	private static final By bySubmitBtn = By.xpath("//button[contains(@data-component-id,'submit-btn')]");
	private static final By byCancelBtn = By.xpath("//button[contains(@data-component-id,'cancel-btn')]");
	private static final By byReasonCodeField = By.xpath("//autocomplete[@formcontrolname='ReasonCode']//input");

	/**
	 * Function to perform ADD adjustment
	 */
	public static void addAdjustment(String strAddValue, String strReasonCode) {
		CommonMethods.waitForPageLoading();
		SeleniumActions.sendTextToElement(byAddField, strAddValue, "ADD field");
		SeleniumActions.sendTextToElement(byReasonCodeField, strReasonCode, "Reason code field");
		CommonMethods.waitForPageLoading();
		KeyboardActions.pressEnterKey(byReasonCodeField);
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(bySubmitBtn, "Submit button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to perform Remove adjustment
	 */
	public static void removeAdjustment(String strAddValue, String strReasonCode) {
		CommonMethods.waitForPageLoading();
		SeleniumActions.selectRadioButton(byRemoveRatioBtn, null);
		SeleniumActions.sendTextToElement(byRemoveField, strAddValue, "Remove field");
		SeleniumActions.sendTextToElement(byReasonCodeField, strReasonCode, "Reason code field");
		CommonMethods.waitForPageLoading();
		KeyboardActions.pressEnterKey(byReasonCodeField);
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(bySubmitBtn, "Submit button");
		CommonMethods.waitForPageLoading();

	}
}
