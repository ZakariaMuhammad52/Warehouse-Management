package web.Pages;

import org.openqa.selenium.By;

import com.dhl.driver.DriverManager;
import com.dhl.reports.FrameworkLogger;
import com.dhl.reports.LogType;
import com.dhl.testdata.TestData_Json;
import com.dhl.web.utils.SeleniumActions;

import stepdefinitions.CommonMethods;

@SuppressWarnings("unused")
public class CommonWMMobilePage extends TestData_Json {

	private static final By byASNTextField = By.xpath("//input[contains(@data-component-id,'acceptasn_barcodetextfield_asn')]");
	private static final By byScanILPNTextFiled = By
			.xpath("//input[@placeholder='Scan iLPN' or @placeholder='Scan LPN']");
	private static final By byScanItemTextField = By.xpath("//input[@placeholder='Scan Item']");
	private static final By byQuantityTextField = By
			.xpath("//input[contains(@data-component-id,'naturalquantityfield_unit')]");
	private static final By byEnterQuantityField = By
			.xpath("//input[contains(@data-component-id,'naturalquantityfield')]");
	private static final By bySerialNumberTextField = By.xpath("//input[@placeholder='Serial Number']");
	private static final By byScanPalletTextField = By.xpath("//input[@placeholder='Scan Pallet']");
	private static final By byScanLocationTextFiled = By.xpath("//input[@placeholder='Scan Location']");
	private static final By byLocationField = By
			.xpath("//ion-col[contains(@data-component-id,'barcodetextfield_location')]");
	private static final By byExpectedContainerField = By
			.xpath("//ion-col[contains(@data-component-id,'barcodetextfield_expectedcontainer')]");
	private static final By byGoButton = By.xpath("//ion-button[contains(@data-component-id,'_go')]");
	private static final By byExpiryDate = By.xpath("//input[contains(@data-component-id,'_inputDate')]");
	private static final By byBatchNumberTextField = By.xpath("//input[contains(@data-component-id,'batchnumber')]");
	private static final By byScanContainerTextFiled = By.xpath("//input[@placeholder='Scan Container']");
	private static final By byInventoryTypeIdTextField = By
			.xpath("//input[contains(@data-component-id,'inventorytypeid')]");
	private static final By byProductStatusIdTextField = By
			.xpath("//input[contains(@data-component-id,'productstatusid')]");
	private static final By byCountryOfOriginTextField = By
			.xpath("//input[contains(@data-component-id,'countryoforigin')]");
	private static final By byVerifyASNButton = By.xpath("//span[text()='Verify ASN']");
	private static final By byReasonCodeTextField = By.xpath("//input[contains(@data-component-id,'reasoncode')]");
	private static final By byReferenceCodeTextField = By
			.xpath("//input[contains(@data-component-id,'referencecode')]");
	private static final By bySecondaryReferenceCodeTextField = By
			.xpath("//input[contains(@data-component-id,'secondaryreferencecode')]");
	private static final By byExitField = By.xpath("//ion-button[contains(@data-component-id,'action_exit_button')]");
	private static final By byScanOLPNTextFiled = By
			.xpath("//input[@placeholder='Scan oLPN' or @placeholder='Scan LPN']");
	private static final By byItemField = By.xpath("//ion-col[contains(@data-component-id,'barcodetextfield_item')]");
	private static final By byQuantityNeedField = By
			.xpath("//ion-col[contains(@data-component-id,'naturalquantityfield_need')]");
	private static final By byScanToteTextFiled = By.xpath("//input[@placeholder='Scan Tote']");
	private static final By byEnterTaskTextField = By.xpath("//input[@placeholder='Enter Task']");

	/**
	 * Function to enter scan location
	 *
	 * @param text - value which need to be entered
	 */
	public static void enterScanLocation(String text) {
		SeleniumActions.sendTextToElement(byScanLocationTextFiled, text, "Scan location Text field");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to enter scan iLPN
	 *
	 * @param text - value which need to be entered
	 */
	public static void enterScanILPN(String text) {
		SeleniumActions.sendTextToElement(byScanILPNTextFiled, text, "Scan ILPN Text field");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to enter scan item
	 *
	 * @param text - value which need to be entered
	 */
	public static void enterScanItem(String text) {
		SeleniumActions.sendTextToElement(byScanItemTextField, text, "Scan Item field");
		CommonMethods.waitForPageLoading();
		if (text != null && !text.trim().isEmpty()) {
			SeleniumActions.getElement(byScanItemTextField).clear();
			SeleniumActions.sendTextToElement(byScanItemTextField, text.replace("-", "").trim(), "Scan Item field");
			CommonMethods.waitForPageLoading();
		} else {
			FrameworkLogger.log(LogType.FAIL, "Scan item is null or empty");
		}
	}

	/**
	 * Function to enter asn
	 *
	 * @param text - value which need to be entered
	 */
	public static void enterASN(String text) {
		SeleniumActions.sendTextToElement(byASNTextField, text, "ASN Text field");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click on Verify ASN button
	 */
	public static void clickVerifyASNButton() {
		SeleniumActions.click(byVerifyASNButton, "Verify ASN button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click go button
	 */
	public static void clickGoButton() {
		SeleniumActions.click(byGoButton, "Go button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to enter quantity
	 *
	 * @param text - value which need to be entered
	 */
	public static void enterQuantity(String text) {
		SeleniumActions.sendTextToElement(byQuantityTextField, text, "Quantity Text field");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to enter SerialNumber
	 *
	 * @param text - value which need to be entered
	 */
	public static void enterSerialNumber(String text) {
		SeleniumActions.sendTextToElement(bySerialNumberTextField, text, "SerialNumber Text field");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to enter quality field
	 *
	 * @param text - value which need to be entered
	 */
	public static void enterQuantityField(String text) {
		SeleniumActions.sendTextToElement(byEnterQuantityField, text, "Quantity Text field");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to enter Scan Pallet
	 *
	 * @param text - value which need to be entered
	 */
	public static void enterScanPallet(String text) {
		SeleniumActions.sendTextToElement(byScanPalletTextField, text, "Pallet Text field");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to enter Expiry date WithYearAsTwoDigits
	 *
	 * @param date - value which need to be entered
	 */
	public static void enterExpiryDateWithYearAsTwoDigits(String date) {
		String day = date.split("/")[0];
		String month = date.split("/")[1];
		String year = date.split("/")[2].substring(2, 4);
		SeleniumActions.sendTextToElement(byExpiryDate, day + month + year, "Expiry Date Text field");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to enter Expiry date
	 *
	 * @param date - value which need to be entered
	 */
	public static void enterExpiryDate(String date) {
		SeleniumActions.sendTextToElement(byExpiryDate, date, "Expiry Date Text field");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to enter batch number
	 *
	 * @param text - value which need to be entered
	 */
	public static void enterBatchNumber(String text) {
		SeleniumActions.sendTextToElement(byBatchNumberTextField, text, "Batch Number field");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to enter batch number if it is displayed iLPN
	 *
	 * @param text - value which need to be entered
	 */
	public static void enterBatchNumberIfDisplayed(String text) {
		if (DriverManager.getDriver().findElements(byBatchNumberTextField).size() > 0) {
			SeleniumActions.sendTextToElement(byBatchNumberTextField, text, "Batch Number field");
			TasksPage.clickGoButton();
		}
	}

	/**
	 * Function to enter scan container
	 *
	 * @param text - value which need to be entered
	 */
	public static void enterScanContainer(String text) {
		SeleniumActions.sendTextToElement(byScanContainerTextFiled, text, "Scan container Text field");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to enter InventoryType
	 *
	 * @param text - value which need to be entered
	 */
	public static void enterInventoryType(String text) {
		SeleniumActions.sendTextToElement(byInventoryTypeIdTextField, text, "InventoryType Text field");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to enter Product status
	 *
	 * @param text - value which need to be entered
	 */
	public static void enterProductStatus(String text) {
		SeleniumActions.sendTextToElement(byProductStatusIdTextField, text, "Product status Text field");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to enter CountryOfOrigin
	 *
	 * @param text - value which need to be entered
	 */
	public static void enterCountryOfOrigin(String text) {
		SeleniumActions.sendTextToElement(byCountryOfOriginTextField, text, "CountryOfOrigin Text field");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to get Location text
	 * @return get text of location field
	 */
	public static String getLocationText() {
		return SeleniumActions.getText(byLocationField);
	}

	/**
	 * Function to get Expected container text
	 *  @return get text of container field
	 */
	public static String getExpectedContainerText() {
		return SeleniumActions.getText(byExpectedContainerField);
	}

	/**
	 * Function to select Reason code
	 *
	 * @param text - value which need to selected
	 */
	public static void selectReasonCode(String text) {
		SeleniumActions.sendTextToElement(byReasonCodeTextField, text, "Reason code field");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to enter reference code
	 *
	 * @param text - value which need to be entered
	 */
	public static void enterReferenceCodeTextField(String text) {
		SeleniumActions.sendTextToElement(byReferenceCodeTextField, text, "ReferenceCode TextField");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to enter secondary reference code
	 *
	 * @param text - value which need to be entered
	 */
	public static void enterSecondaryReferenceCodeTextField(String text) {
		SeleniumActions.sendTextToElement(bySecondaryReferenceCodeTextField, text, "Secondary ReferenceCode TextField");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to verify LPN Is RedirectedToLocation
	 * 
	 * @param lpn - lpn value to verify
	 * @param location - location value to verify
	 */
	public static void verifyLPNIsRedirectedToLocation(String lpn, String location) {
		enterScanContainer(lpn);
		clickGoButton();
		String actualLocation = SeleniumActions.getText(byLocationField).trim();
		actualLocation = actualLocation.substring(0, 1);
		SeleniumActions.verifyTextEquals(actualLocation, location.substring(0, 1));
		clickExit();
		CommonPopupPage.clickConfirmButton();
	}

	/**
	 * Function to click Exit Field
	 */
	public static void clickExit() {
		SeleniumActions.click(byExitField, "Exit Field");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to enter scan oLPN
	 *
	 * @param text - value which need to be entered
	 */
	public static void enterScanOLPN(String text) {
		SeleniumActions.sendTextToElement(byScanOLPNTextFiled, text, "Scan OLPN Text field");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to get Item text
	 *  @return get item field
	 */
	public static String getItemText() {
		return SeleniumActions.getText(byItemField);
	}

	/**
	 * Function to get Quantity text
	 *  @return get text of quantity field
	 */
	public static String getQuantityNeedText() {
		return SeleniumActions.getText(byQuantityNeedField);
	}

	/**
	 * Function to enter ScanTote
	 * 
	 * @param text - value which need to be entered
	 */
	public static void enterScanTote(String text) {
		SeleniumActions.sendTextToElement(byScanToteTextFiled, text, "Scan Tote Text field");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to enter taskId
	 * 
	 * @param taskId - value which need to be entered
	 */
	public static void enterTask(String taskId) {
		SeleniumActions.sendTextToElement(byEnterTaskTextField, taskId, "Enter Task Text Field");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to Verify expected location equals to the actual location
	 *
	 * @param location - value which need to verify with expected location
	 */
	public static void verifyLPNIsRedirectedTotheLocation(String location) {
		String actualLocation = SeleniumActions.getText(byLocationField).trim();
		SeleniumActions.verifyTextEquals(actualLocation, location);
	}

	/**
	 * Function to Verify expected location not equals to the actual location
	 *
	 * @param location - value which need to verify location is not equal
	 */
	public static void verifyLPNIsRedirectedToOtherLocation(String location) {
		String actualLocation = SeleniumActions.getText(byLocationField).trim();
		SeleniumActions.verifyTextNotEquals(actualLocation, location);
	}

	/**
	 * Function to Verify Location field is visible
	 *
	 */
	public static void verifyLPNIsRedirectedToAnyLocation() {
		SeleniumActions.verifyElementVisible(byLocationField, 2000,"Location");
		CommonMethods.waitForPageLoading();
	}

}