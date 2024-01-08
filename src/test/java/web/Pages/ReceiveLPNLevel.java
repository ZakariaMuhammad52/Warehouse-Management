package web.Pages;

import java.util.List;

import org.openqa.selenium.By;

import com.dhl.driver.DriverManager;
import com.dhl.reports.FrameworkLogger;
import com.dhl.reports.LogType;
import com.dhl.testdata.TestData_Json;
import com.dhl.utils.CurrentThreadInstance;
import com.dhl.utils.Variables;
import com.dhl.web.utils.SeleniumActions;

import stepdefinitions.CommonMethods;
import stepdefinitions.ExcelUtil1;

@SuppressWarnings("unused")
public class ReceiveLPNLevel extends TestData_Json {

	private static final By byPageTitle = By.xpath("//ion-title[contains(@data-component-id,'receivelpnlevel')]");

	private static final By byASNSearchField = By.xpath("//input[contains(@data-component-id,'acceptasn_barcodetextfield_asn')]");
	private static final By byASNSearchText = By
			.xpath("//ion-col[contains(@data-component-id,'acceptlpn_barcodetextfield_asn')]");
	private static final By byGoButton = By.xpath("//ion-button[contains(@data-component-id,'barcodetextfield_go')]");
	private static final By byLPNSearchField = By.xpath("//input[contains(@data-component-id,'acceptlpn_barcodetextfield_lpn')]");
	private static final By byLPNSearchText = By
			.xpath("//ion-col[contains(@data-component-id,'acceptitem_barcodetextfield_lpn')]");
	private static final By byScanItemText = By.xpath("//*[contains(@data-component-id,'acceptitem_barcodetextfield_item')]");
	private static final By byScanItemInput = By
			.xpath("//input[contains(@data-component-id,'acceptitem_barcodetextfield_item')]");
	private static final By byUnitInput = By
			.xpath("//input[contains(@data-component-id,'acceptquantity_naturalquantityfield_unit')]");
	private static final By byUnitGoButton = By
			.xpath("//ion-button[contains(@data-component-id,'naturalquantityfield_go')]");
	private static final By byAcceptBatchNumberField = By
			.xpath("//input[contains(@data-component-id,'acceptitemattributes_attributes_batchnumber')]");
	private static final By bySerialNumberField = By
			.xpath("//input[contains(@data-component-id,'acceptprimaryinventoryattribute_barcodetextfield_serialnumber')]");
	private static final By bySerialGoButton = By
			.xpath("//ion-button[contains(@data-component-id,'acceptprimaryinventoryattribute_barcodetextfield_go')]");
	private static final By byAttributesGoButton = By
			.xpath("//ion-button[contains(@data-component-id,'attributes_go')]");
	private static final By byAcceptQtyErrorMessageLabel = By
			.xpath("//div[contains(@data-component-id,'popover_error_message')]");
	private static final By byInventoryItemIdField = By
			.xpath("//input[contains(@data-component-id,'acceptitemattributes_attributes_inventorytypeid')]");
	private static final By byInventoryItemIdSearch = By.xpath("//div[contains(@data-component-id,'inventorytypeid_value')]");
	private static final By byProductStatusId = By
			.xpath("//input[contains(@data-component-id,'acceptitemattributes_attributes_productstatusid')]");
	private static final By byInventoryType = By
			.xpath("//input[contains(@data-component-id,'acceptitemattributes_attributes_inventorytypeid')]");
	private static final By byProductStatus = By
			.xpath("//input[contains(@data-component-id,'acceptitemattributes_attributes_productstatusid')]");
	private static final By byCountryofOrigin = By
			.xpath("//input[contains(@data-component-id,'acceptitemattributes_attributes_countryoforigin')]");
	private static final By byAlertmsg = By.xpath("//div[@class='alert-message sc-ion-alert-md']");
	private static final By byAlertConfirm = By.xpath("//span[text()='Confirm']");
	private static final By byAlertok = By.xpath("//span[text()='ok']");
	private static final By byShippedQty = By
			.xpath("//ion-col[contains(@data-component-id,'acceptquantity_totalshippedquantity')]");
	private static final By byVerifyASN = By.xpath("//span[text()='Verify ASN']");
	private static final By byAcceptBatchExpirationDateField = By
			.xpath("//input[contains(@data-component-id,'acceptdate_inputDate')]");
	private static final By byBatchExpirationDateGoButton = By
			.xpath("//ion-button[contains(@data-component-id,'acceptdate_datefield_go')]");
	private static final By byScanQuantityGoButton = By
			.xpath("//ion-button[contains(@data-component-id,'acceptquantity_naturalquantityfield_go')]");
	private static final By byShippedQtyText = By
			.xpath("//*[contains(@data-component-id,'acceptquantity_naturalquantityfield_totalshippedquantity')]");
	private static final By byShippedQtyInput = By
			.xpath("//input[contains(@data-component-id,'acceptquantity_naturalquantityfield_unit')]");
	private static final By byInformationMessageLabel = By
			.xpath("//div[@class='alert-wrapper ion-overlay-wrapper sc-ion-alert-md']");
	private static final By byInformationOkButton = By
			.xpath("//button[contains(@class,'alert-button ion-focusable ion-activatable sc-ion-alert-md')]");
	private static final By byScanPalletInput = By
			.xpath("//input[contains(@data-component-id,'accepttopallet_barcodetextfield_directtopallet')]");
	private static final By byPalletGoButton = By
			.xpath("//ion-button[contains(@data-component-id,'accepttopallet_barcodetextfield_go')]");
	private static final By byAcceptInventoryTypeIdField = By
			.xpath("//input[contains(@data-component-id,'acceptitemattributes_attributes_inventorytypeid')]");
	private static final By byAcceptProductStatusIdField = By
			.xpath("//input[contains(@data-component-id,'acceptitemattributes_attributes_productstatusid')]");
	private static final By byAcceptCountryOfOriginField = By
			.xpath("//input[contains(@data-component-id,'acceptitemattributes_attributes_countryoforigin')]");
	private static final By byOpenActionButton = By
			.xpath("//ion-icon[contains(@data-component-id,'action_openorclosepopover_icon')]");
	private static final By byActionEndContainerButton = By
			.xpath("//ion-button[contains(@data-component-id,'action_endcontainer_button')]");
	private static final By byAcceptEndContainerIdInput = By
			.xpath("//input[contains(@data-component-id,'acceptcontainer_barcodetextfield_scancontainer')]");
	private static final By byAcceptEndContainerGoButton = By
			.xpath("//ion-button[contains(@data-component-id,'acceptcontainer_barcodetextfield_go')]");
	private static final By byVerifyASNButton = By
			.xpath("//button[contains(@data-component-id,'action_verifyasn_button')]");
	private static final By byVarianceSummaryYesButton = By
			.xpath("//ion-button[contains(@data-component-id,'variancesummary_booleanfield_yes')]");
	private static final By byContainerGoButton = By
			.xpath("//ion-button[contains(@data-component-id,'acceptcontainer_barcodetextfield_go')]");
	private static final By byContainerSearchField = By
			.xpath("//input[contains(@data-component-id,'acceptcontainer_barcodetextfield_container')]");
	private static final By byItemInStdReceiving = By.xpath("(//td[contains(text(),'Item')])[2]");
	private static final By byEndScan = By.xpath("//span[text()='End Scan']");

	private static final By byScanningInfo = By.xpath("//span[contains(text(),'Scanning')]");
	private static final By byExitWmMobileBtn = By.xpath("//ion-button[contains(@data-component-id,'action_exit_button')]");
	private static final By byWarningConfirmButton = By.xpath("//button[contains(@data-component-id,'popover_confirm')]");
	private static final By byMenuWmMobileBtn = By.xpath("//ion-button[contains(@data-component-id,'action_menu_button')]");



	/**
	 * Function to verify Receive LPN Page is displayed
	 */
	public static void verifyPageDisplayed() {
		SeleniumActions.verifyElementVisible(byPageTitle, 20, "Receive LPN page");
	}

	/**
	 * Function to perform Receive LPN
	 *
	 * @param listOfLpns - list of LPN's
	 */
	public static void receiveLPNs(List<String> listOfLpns) {
		if (listOfLpns.size() > 0) {
			searchASN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN").toString());
			for (String eachLpn : listOfLpns) {
				searchLPN(eachLpn.trim());
				enterScanItem("");
				enterQuantity(1);
			}
		} else {
			FrameworkLogger.log(LogType.FAIL, "LPNs list is empty!");
		}
	}

	/**
	 * Function to search ASN
	 *
	 * @param strText - ASN value
	 */
	public static void searchASN(String strText) {
		if (strText != null) {
			SeleniumActions.getElement(byASNSearchField).clear();
			SeleniumActions.sendTextToElement(byASNSearchField, strText, "ASN search field");
			SeleniumActions.click(byGoButton, "Go button");
			CommonMethods.waitForPageLoading();
		} else {
			SeleniumActions.click(byGoButton, "Go button");
			CommonMethods.waitForPageLoading();
			String strASN = SeleniumActions.getText(byASNSearchText);
			Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ASN", strASN);
			FrameworkLogger.log(LogType.INFO, strASN + " ASN value is auto generated");
		}
	}

	/**
	 * Function to search LPN
	 *
	 * @param strText - LPN value
	 */
	public static void searchLPN(String strText) {
		SeleniumActions.getElement(byLPNSearchField).clear();
		SeleniumActions.sendTextToElement(byLPNSearchField, strText, "LPN search field");
		SeleniumActions.click(byGoButton, "Go button");
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN", strText);
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to search LPN
	 *
	 * @param strText - LPN value
	 */
	public static void enterLPN(String strText, int iDigit) {
		if (strText != null) {
			SeleniumActions.getElement(byLPNSearchField).clear();
			SeleniumActions.sendTextToElement(byLPNSearchField, strText, "LPN search field");
			SeleniumActions.click(byGoButton, "Go button");
			Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN", strText);
			CommonMethods.waitForPageLoading();
		} else {
			SeleniumActions.click(byGoButton, "Go button");
			CommonMethods.waitForPageLoading();
			String strLPN = SeleniumActions.getText(byLPNSearchText);
			Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN" + iDigit, strLPN);
			FrameworkLogger.log(LogType.INFO, strLPN + " LPN value is auto generated");
		}
	}

	/**
	 * Function to search LPN
	 *
	 * @param strText - LPN value
	 */
	public static void enterLPN(String strText) {
		enterLPN(strText, 1);
	}

	/**
	 * Function to enter item details to be scanned
	 *
	 * @param strScanItem - Item value
	 */
	public static void enterScanItem(String strScanItem) {
		if (strScanItem.isEmpty()) {
			strScanItem = SeleniumActions.getText(byScanItemText);
		}
		if (strScanItem != null && !strScanItem.trim().isEmpty()) {
			// strScanItem.replace("-", ""); // Added this code on 07 Nov 2023 by Lohith
			SeleniumActions.getElement(byScanItemInput).clear();
			SeleniumActions.sendTextToElement(byScanItemInput, strScanItem.replace("-", "").trim(), "Scan Item field");
			SeleniumActions.click(byGoButton, "Go button");
			CommonMethods.waitForPageLoading();
		} else {
			FrameworkLogger.log(LogType.FAIL, "Scan item is null or empty");
		}
	}

	/**
	 * Function to enter expected batch number is populated in the screen
	 *
	 * @param strBatchNo - Batch number should be entered
	 */
	public static void validateBatchnumber(String strBatchNo) {
		CommonMethods.waitForPageLoading();
		String strScanBatchNo = SeleniumActions.getText(byAcceptBatchNumberField);
		SeleniumActions.click(byAttributesGoButton, "Go button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to enter batch number in the field
	 *
	 * @param strBatchNo - Batch number to be updated/entered
	 */
	public static void enterBatchnumber(String strBatchNo) {
		CommonMethods.waitForPageLoading();
		SeleniumActions.sendTextToElement(byAcceptBatchNumberField, String.valueOf(strBatchNo), "Batch number field");
		SeleniumActions.click(byAttributesGoButton, "Go button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to update accept quantity value
	 *
	 * @param iQuantity - quantity that need to be received
	 */
	public static void enterQuantity(int iQuantity) {
		SeleniumActions.getElement(byUnitInput).clear();
		SeleniumActions.sendTextToElement(byUnitInput, String.valueOf(iQuantity), "Quantity field");
		SeleniumActions.click(byUnitGoButton, "Go button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to verify error message is displayed while receiving ASN
	 *
	 */
	public static void verifyErrorDisplayed() {
		String strErrormessage = SeleniumActions.getText(byAcceptQtyErrorMessageLabel);
		if (strErrormessage != null && !strErrormessage.trim().isEmpty()) {
			FrameworkLogger.log(LogType.PASS, strErrormessage + " Error message is displayed");
			SeleniumActions.closeBrowser();
			SeleniumActions.switchToLastWindow();
		} else {
			FrameworkLogger.log(LogType.FAIL, "Error message is not displayed");
		}
	}

	/**
	 * Function to verify search inventory in WM Mobile
	 * @param strText - inventory type to be search
	 *
	 */
	public static void searchInventory(String strText) {

		if (strText != null) {
			SeleniumActions.getElement(byInventoryType).clear();
			SeleniumActions.sendTextToElement(byInventoryType, strText, "Inventory Type field");
			SeleniumActions.click(byAttributesGoButton, "Go button");
		} else {
			SeleniumActions.click(byAttributesGoButton, "Go button");
			CommonMethods.waitForPageLoading();
		}

	}

	/**
	 * Function to validate cubisian alert in verify asn screen
	 *
	 */
	public static void ValidateCubiscanAlert() {

		if (SeleniumActions.getText(byAlertmsg).contains("(RCV:DHL:1102)")) {
			SeleniumActions.click(byAlertConfirm, "Alert seen");
			enterQuantity(200);
			SeleniumActions.closeBrowser();
			SeleniumActions.switchToLastWindow();
			FrameworkLogger.log(LogType.PASS, "CubiScan Alert is displayed");
		} else {
			FrameworkLogger.log(LogType.FAIL, "CubiScan Alert not displayed");
		}
	}

	/**
	 * Function to search and enter product status
	 * @param strText - status which need to be search
	 *
	 */
	public static void searchProductStatus(String strText) {
		if (strText != null) {
			SeleniumActions.getElement(byProductStatus).clear();
			SeleniumActions.sendTextToElement(byProductStatus, strText, "Product Status search field");
			SeleniumActions.click(byAttributesGoButton, "Go button");
		} else {
			SeleniumActions.click(byAttributesGoButton, "Go button");
			CommonMethods.waitForPageLoading();
		}
	}

	/**
	 * Function to search and enter Country of Origin
	 * @param strText - country of origin
	 *
	 */
	public static void searchCOOrigin(String strText) {

		if (strText != null) {
			SeleniumActions.getElement(byCountryofOrigin).clear();
			SeleniumActions.sendTextToElement(byCountryofOrigin, strText, "Country of Origin search field");
			SeleniumActions.click(byAttributesGoButton, "Go button");
		} else {
			SeleniumActions.click(byAttributesGoButton, "Go button");
			CommonMethods.waitForPageLoading();
		}
	}

	/**
	 * Function to verify receiving ASN is completed without any error
	 */
	public static void verifyErrorNotDisplayed() {
		if (SeleniumActions.isElementPresent(byAcceptQtyErrorMessageLabel, 10)) {
			String strErrormessage = SeleniumActions.getText(byAcceptQtyErrorMessageLabel);
			if (strErrormessage != null && !strErrormessage.trim().isEmpty()) {
				FrameworkLogger.log(LogType.FAIL, strErrormessage + " Error message is displayed");
			}
		} else {
			FrameworkLogger.log(LogType.PASS, "Operation successfully completed");
		}
	}

	/**
	 * Function to enter serial number value
	 *
	 * @param strSerialNumber - serial number that need to be received
	 */
	public static void enterSerialNumber(String strSerialNumber) {
		SeleniumActions.getElement(bySerialNumberField).clear();
		SeleniumActions.sendTextToElement(bySerialNumberField, String.valueOf(strSerialNumber), "Serial number field");
		SeleniumActions.click(bySerialGoButton, "Go button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to verify Tolerance error on verify asn
	 */
	public static void verifyToleranceErrorDisplayed() {
		if (SeleniumActions.isElementPresent(byAcceptQtyErrorMessageLabel, 10)) {
			String strErrormessage = SeleniumActions.getText(byAcceptQtyErrorMessageLabel);
			if (strErrormessage != null && !strErrormessage.trim().isEmpty()) {
				FrameworkLogger.log(LogType.FAIL, strErrormessage + " Error message is displayed");
			}
		} else {
			FrameworkLogger.log(LogType.PASS, "Operation successfully completed");
		}
	}

	/**
	 * Function to perform AT Standard receiving in WM Mobile with batch
	 */
	public static void completeAtStandardReceivingWithBatch() {
		searchASN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN").toString());
		enterLPN(ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(LPNId)")));
		enterScanItem(getDataFromFeature("getdata(ItemIDcode_Line1)"));
		enterBatchnumber(getDataFromFeature("getdata(BatchNo_Line1)"));
		enterQuantity(Integer.parseInt(getDataFromFeature("getdata(OrdQty_Line1)")));
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byVerifyASN, "Clicked on verify ASN");
		if (SeleniumActions.getText(byAlertmsg).contains("RCV::277")) {
			SeleniumActions.closeBrowser();
			SeleniumActions.switchToLastWindow();
			FrameworkLogger.log(LogType.PASS, "ASN Verification has been submitted");
		} else {
			FrameworkLogger.log(LogType.FAIL, "ASN Verification has not been submitted");

		}

	}

	/**
	 * Function to validate Quantity error for Tolerance
	 * @param OrderQuantity - order quantity
	 * @param strAct - alert message
	 */
	public static void validateQtyError(String OrderQuantity, String strAct) {
		int x = Integer.parseInt(OrderQuantity);
		switch (x) {
			case 205:
				SeleniumActions.waitForPageLoading();
				// GeneralUtils.wait(2000);
				enterQuantity(Integer.parseInt(OrderQuantity));
				SeleniumActions.waitForPageLoading();
				// verifyErrorNotDisplayed();
				break;
			case 215:
				SeleniumActions.waitForPageLoading();
				enterQuantity(Integer.parseInt(OrderQuantity));
				SeleniumActions.waitForPageLoading();
				SeleniumActions.verifyElementVisible(byAlertmsg, 5, "10% tolerance Error");
				if (SeleniumActions.getText(byAlertmsg).contains(strAct)) {
					SeleniumActions.click(byAlertConfirm, "alert confirmed");
					FrameworkLogger.log(LogType.PASS, "Tolerance error is displayed");
				} else {
					FrameworkLogger.log(LogType.FAIL, "Tolerance error is not displayed");
				}
				break;
			case 252:
				SeleniumActions.waitForPageLoading();
				enterQuantity(Integer.parseInt(OrderQuantity));
				SeleniumActions.waitForPageLoading();
				SeleniumActions.verifyElementVisible(byAcceptQtyErrorMessageLabel, 5, "15% tolerance Error");
				if (SeleniumActions.getText(byAcceptQtyErrorMessageLabel).contains(strAct)) {
					// KeyboardActions.pressKeyboardKeyWithRobot(KeyboardKeys.ESCAPE);
					SeleniumActions.closeBrowser();
					SeleniumActions.switchToLastWindow();
					FrameworkLogger.log(LogType.PASS, "Tolerance error is displayed");
				} else {
					FrameworkLogger.log(LogType.FAIL, "Tolerance error is not displayed");
				}
				break;
			case 200:
				SeleniumActions.waitForPageLoading();
				enterQuantity(Integer.parseInt(OrderQuantity));
				SeleniumActions.waitForPageLoading();
				SeleniumActions.click(byVerifyASN, "clicked verify ASN");
				if (SeleniumActions.getText(byAcceptQtyErrorMessageLabel).contains("RCV::143")) {
					SeleniumActions.closeBrowser();
					SeleniumActions.switchToLastWindow();
					FrameworkLogger.log(LogType.PASS, "Error143 is displayed");
				} else {
					FrameworkLogger.log(LogType.FAIL, "Error143 is displayed");
				}
				break;
		}

	}

	/**
	 * Function to enter inventory item id to be scanned
	 *
	 * @param strInventoryItemId - Item value
	 */
	public static void enterInventoryItemId(String strInventoryItemId) {
		if (strInventoryItemId != null && !strInventoryItemId.trim().isEmpty()) {
			SeleniumActions.getElement(byInventoryItemIdField).clear();
			SeleniumActions.sendTextToElement(byInventoryItemIdField, strInventoryItemId,
					"InventoryItemId search field");
			SeleniumActions.click(byAttributesGoButton, "Go button");
			CommonMethods.waitForPageLoading();
		} else {
			SeleniumActions.click(byAttributesGoButton, "Go button");
			CommonMethods.waitForPageLoading();
			String strLPN = SeleniumActions.getText(byInventoryItemIdSearch);
			FrameworkLogger.log(LogType.INFO, strLPN + " InventoryItemId is auto generated");
		}
	}

	/**
	 * Function to enter product status for inventory
	 *
	 * @param strProductStatus - Product status that need to be received
	 */
	public static void enterProductStatus(String strProductStatus) {
		if (strProductStatus != null && !strProductStatus.trim().isEmpty()) {
			SeleniumActions.getElement(byProductStatusId).clear();
			SeleniumActions.sendTextToElement(byProductStatusId, strProductStatus, "InventoryItemId search field");
			SeleniumActions.click(byAttributesGoButton, "Go button");
			CommonMethods.waitForPageLoading();
		} else {
			SeleniumActions.click(byGoButton, "Go button");
			CommonMethods.waitForPageLoading();
			FrameworkLogger.log(LogType.INFO, strProductStatus + " ProductStatus is auto generated");
		}
	}

	/*
	 * public static void searchinventory(String strText) { if (strText != null) {
	 * SeleniumActions.getElement(byInventoryType).clear();
	 * SeleniumActions.sendTextToElement(byInventoryType, strText,
	 * "inventory field"); SeleniumActions.click(byAttributesGoButton, "Go button");
	 * /*Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN",
	 * strText); CommonMethods.waitForPageLoading();
	 */
	/*
	 * } else { SeleniumActions.click(byAttributesGoButton, "Go button");
	 * CommonMethods.waitForPageLoading(); /*String strLPN =
	 * SeleniumActions.getText(byLPNSearchText);
	 * Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN" + iDigit,
	 * strLPN); FrameworkLogger.log(LogType.INFO, strLPN +
	 * " LPN value is auto generated");
	 */
	/*
	 * } }
	 */

	/*
	 * public static void ValidateCubiscanAlert() { if
	 * (SeleniumActions.getText(byAlertmsg).contains("(RCV:DHL:1102)")) {
	 * SeleniumActions.click(byAlertConfirm, "Alert seen"); enterQuantity(200);
	 * SeleniumActions.closeBrowser(); SeleniumActions.switchToLastWindow();
	 * FrameworkLogger.log(LogType.PASS, "CubiScan Alert is displayed"); } else {
	 * FrameworkLogger.log(LogType.FAIL, "CubiScan Alert not displayed"); } }
	 */

	/*
	 * public static void searchproductStatus(String strText) { if (strText != null)
	 * { SeleniumActions.getElement(byProductStatus).clear();
	 * SeleniumActions.sendTextToElement(byProductStatus, strText,
	 * "ProductStatus search field"); SeleniumActions.click(byAttributesGoButton,
	 * "Go button"); /*Variables.set(CurrentThreadInstance.getCurrentScenarioId() +
	 * "LPN", strText); CommonMethods.waitForPageLoading();
	 */
	/*
	 * } else { SeleniumActions.click(byAttributesGoButton, "Go button");
	 * CommonMethods.waitForPageLoading(); /*String strLPN =
	 * SeleniumActions.getText(byLPNSearchText);
	 * Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN" + iDigit,
	 * strLPN); FrameworkLogger.log(LogType.INFO, strLPN +
	 * " LPN value is auto generated");
	 */
	/*
	 * } }
	 */

	/*
	 * public static void searchCOOrigin(String strText) { if (strText != null) {
	 * SeleniumActions.getElement(byCountryofOrigin).clear();
	 * SeleniumActions.sendTextToElement(byCountryofOrigin, strText,
	 * "ProductStatus search field"); SeleniumActions.click(byAttributesGoButton,
	 * "Go button"); /*Variables.set(CurrentThreadInstance.getCurrentScenarioId() +
	 * "LPN", strText); CommonMethods.waitForPageLoading();
	 */
	/*
	 * } else { SeleniumActions.click(byAttributesGoButton, "Go button");
	 * CommonMethods.waitForPageLoading(); /*String strLPN =
	 * SeleniumActions.getText(byLPNSearchText);
	 * Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN" + iDigit,
	 * strLPN); FrameworkLogger.log(LogType.INFO, strLPN +
	 * " LPN value is auto generated");
	 */
	/*
	 * } }
	 */

	/*
	 * public static void completeatstandardreceivingwithbatch() {
	 * searchASN(Variables.get(CurrentThreadInstance.getCurrentScenarioId()+"ASN").
	 * toString());
	 * enterLPN(ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature(
	 * "getdata(LPNId)")));
	 * enterScanItem(getDataFromFeature("getdata(ItemID_Line1)"));
	 * enterBatchnumber(getDataFromFeature("getdata(BatchNo_Line1)"));
	 * enterQuantity(Integer.parseInt(getDataFromFeature("getdata(OrdQty_Line1)")));
	 * CommonMethods.waitForPageLoading();
	 * SeleniumActions.click(byVerifyASN,"Clicked on verify ASN");
	 * if(SeleniumActions.getText(byAlertmsg).contains("RCV::277")){
	 * SeleniumActions.closeBrowser(); SeleniumActions.switchToLastWindow();
	 * FrameworkLogger.log(LogType.PASS, "ASN Verification has been submitted"); }
	 * else { FrameworkLogger.log(LogType.FAIL,
	 * "ASN Verification has not been submitted"); } }
	 */

	/**
	 * Function to verify receiving ASN is completed without any error
	 */
	/*
	 * public static void verifyErrorNotDisplayed() { if
	 * (SeleniumActions.isElementPresent(byAcceptQtyErrorMessageLabel, 10)) { String
	 * strErrormessage = SeleniumActions.getText(byAcceptQtyErrorMessageLabel); if
	 * (strErrormessage != null && !strErrormessage.trim().isEmpty()) {
	 * FrameworkLogger.log(LogType.FAIL, strErrormessage +
	 * " Error message is displayed"); } } else { FrameworkLogger.log(LogType.PASS,
	 * "Operation successfully completed"); } }
	 */

	/**
	 * Function to enter serial number value
	 *
	 * //* @param strSerialNumber - serial number that need to be received
	 */
	/*
	 * public static void enterSerialNumber(String strSerialNumber) {
	 * SeleniumActions.getElement(bySerialNumberField).clear();
	 * SeleniumActions.sendTextToElement(bySerialNumberField,
	 * String.valueOf(strSerialNumber), "Serial number field");
	 * SeleniumActions.click(bySerialGoButton, "Go button");
	 * CommonMethods.waitForPageLoading(); }
	 */
	/*
	 * public static void atStandardReceiving(String strLPN, int iLPNPosition,
	 * String OrderQuantity) { enterLPN(strLPN, iLPNPosition);
	 * enterScanItem(getDataFromFeature("getdata(ItemID_Line1)"));
	 * validateBatchnumber(getDataFromFeature("getdata(BatchNo_Line1"));
	 * enterQuantity(Integer.parseInt(OrderQuantity)); //verifyErrorNotDisplayed();
	 * } public static void verifytoleranceErrorDisplayed() { if
	 * (SeleniumActions.isElementPresent(byAcceptQtyErrorMessageLabel, 10)) { String
	 * strErrormessage = SeleniumActions.getText(byAcceptQtyErrorMessageLabel); if
	 * (strErrormessage != null && !strErrormessage.trim().isEmpty()) {
	 * FrameworkLogger.log(LogType.FAIL, strErrormessage +
	 * " Error message is displayed"); } } else { FrameworkLogger.log(LogType.PASS,
	 * "Operation successfully completed"); } }
	 */

	/*
	 * public static void validateQtyError(String OrderQuantity, String strAct) {
	 * int x=Integer.parseInt(OrderQuantity); switch (x) { case 205 :
	 * SeleniumActions.waitForPageLoading(); // GeneralUtils.wait(2000);
	 * enterQuantity(Integer.parseInt(OrderQuantity));
	 * SeleniumActions.waitForPageLoading(); //verifyErrorNotDisplayed(); break;
	 * case 215 : SeleniumActions.waitForPageLoading();
	 * enterQuantity(Integer.parseInt(OrderQuantity));
	 * SeleniumActions.waitForPageLoading();
	 * SeleniumActions.verifyElementVisible(byAlertmsg, 5, "10% tolerance Error");
	 * if (SeleniumActions.getText(byAlertmsg).contains(strAct)) {
	 * SeleniumActions.click(byAlertConfirm,"alert confirmed");
	 * FrameworkLogger.log(LogType.PASS, "Tolerance error is displayed"); } else {
	 * FrameworkLogger.log(LogType.FAIL, "Tolerance error is not displayed"); }
	 * break; case 252 : SeleniumActions.waitForPageLoading();
	 * enterQuantity(Integer.parseInt(OrderQuantity));
	 * SeleniumActions.waitForPageLoading();
	 * SeleniumActions.verifyElementVisible(byAcceptQtyErrorMessageLabel, 5,
	 * "15% tolerance Error"); if
	 * (SeleniumActions.getText(byAcceptQtyErrorMessageLabel).contains(strAct)) {
	 * //SeleniumActions.click(byAlertConfirm,"Comfirming Alert");
	 * enterQuantity(200); SeleniumActions.click(byVerifyASN, "clicked verify ASN");
	 * if
	 * (SeleniumActions.getText(byAcceptQtyErrorMessageLabel).contains("RCV::143"))
	 * { SeleniumActions.closeBrowser(); SeleniumActions.switchToLastWindow();
	 * FrameworkLogger.log(LogType.PASS, "Error143 is displayed"); } else {
	 * FrameworkLogger.log(LogType.FAIL, "Error143 is displayed"); }
	 * FrameworkLogger.log(LogType.PASS, "Tolerance error is displayed"); } else {
	 * FrameworkLogger.log(LogType.FAIL, "Tolerance error is not displayed"); }
	 * break; } }
	 */


	public static void atStandardReceiving(String strLPN, int iLPNPosition, String OrderQuantity) {
		enterLPN(strLPN, iLPNPosition);
		enterScanItem(getDataFromFeature("getdata(ItemID_Line1)"));
		validateBatchnumber(getDataFromFeature("getdata(BatchNo_Line1"));
		enterQuantity(Integer.parseInt(OrderQuantity));
		// verifyErrorNotDisplayed();
	}

	/**
	 * Function to enter ASN
	 * @param strText - asn value
	 *
	 */
	public static void enterASN(String strText) {
		SeleniumActions.getElement(byASNSearchField).clear();
		SeleniumActions.sendTextToElement(byASNSearchField, strText, "ASN search field");
		SeleniumActions.click(byGoButton, "Go button");
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "AsnId", strText);
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to enter item id
	 * @param strText - Item id need to search
	 *
	 */
	public static void enterItemId(String strText) {
		SeleniumActions.getElement(byScanItemInput).clear();
		SeleniumActions.sendTextToElement(byScanItemInput, strText, "Item Id scan field");
		SeleniumActions.click(byGoButton, "Go button");
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPNIdLine1", strText);
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to verify Batch Expiration Date is displayed while receiving.
	 *
	 */
	public static void verifyBatchExpirationDateDisplayed() {
		String strBatchExpirationDate = SeleniumActions.getText(byAcceptBatchExpirationDateField);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ExpiryDate", strBatchExpirationDate);
		if (strBatchExpirationDate != null) {
			FrameworkLogger.log(LogType.PASS, strBatchExpirationDate + " Batch Expiration Date is displayed");
			SeleniumActions.click(byBatchExpirationDateGoButton, "Go button");
		} else {
			FrameworkLogger.log(LogType.FAIL, "Expiration date is not present in ASN");
		}
	}

	/**
	 * Function to get scan shipped quantity and feed to scan shipped quantity input
	 * field and save value into runtime variable
	 */
	public static void enterScanQuantity() {
		// Add code to capture warning error
		String strScanQuantity = SeleniumActions.getText(byShippedQtyText);
		if (strScanQuantity != null && !strScanQuantity.trim().isEmpty()) {
			Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ShippedQty", strScanQuantity.trim());
			/*
			 * SeleniumActions.switchToWindowUsingIndex(0);
			 * HomePage.navigate_to_StorageLocation();
			 * StorageLocation.saveCurrentQuantity("CurrentQtyBeforeUpdate");
			 * SeleniumActions.switchToLastWindow();
			 */
			SeleniumActions.getElement(byShippedQtyInput).clear();
			String strSysScanQuantity = strScanQuantity.replace("-", "");
			SeleniumActions.sendTextToElement(byShippedQtyInput, strSysScanQuantity.trim(),
					"Scan quantity shipped field");
			Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "OnHandQty", strSysScanQuantity);
			SeleniumActions.click(byScanQuantityGoButton, "Go button");
			CommonMethods.waitForPageLoading();
		} else {
			FrameworkLogger.log(LogType.FAIL, "Scan Shipped Quantity is null or empty");
		}
	}

	/**
	 * Function to verify LPN Allocated Sorting message is displayed
	 *
	 */
	public static void verifyLPNAllocatedForSorting() {
		String strLPNInformation = SeleniumActions.getText(byInformationMessageLabel);
		if (strLPNInformation != null && !strLPNInformation.trim().isEmpty()) {
			FrameworkLogger.log(LogType.PASS, strLPNInformation + " LPN Allocated Sorting Done");
			SeleniumActions.click(byInformationOkButton, "Go button");
		} else {
			FrameworkLogger.log(LogType.FAIL, "Information LPN Allocated Sorting message is not displayed");
		}
	}

	/**
	 * Function to enter pallet details to be scanned
	 *
	 * @param strPalletId - Pallet id value
	 */
	public static void enterScanPallet(String strPalletId) {

		CommonMethods.waitForPageLoading();
		SeleniumActions.sendTextToElement(byScanPalletInput, String.valueOf(strPalletId), "Pallet number field");
		SeleniumActions.click(byPalletGoButton, "Go button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to verify inventory type Id is displayed while receiving.
	 *
	 */
	public static void verifyInventoryTypeIdDisplayed() {
		String strInventoryTypeId = SeleniumActions.getText(byAcceptInventoryTypeIdField);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "InventoryTypeId", strInventoryTypeId);
		if (strInventoryTypeId != null) {
			FrameworkLogger.log(LogType.PASS, strInventoryTypeId + " Inventory Type Id is displayed");
			SeleniumActions.click(byAttributesGoButton, "Go button");
		} else {
			FrameworkLogger.log(LogType.FAIL, "Item is not present in ASN");
		}
	}

	/**
	 * Function to verify Product status Id is displayed while receiving.
	 *
	 */
	public static void verifyProductStatusIdDisplayed() {
		String strProductStatusId = SeleniumActions.getText(byAcceptProductStatusIdField);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ProductStatus", strProductStatusId);
		if (strProductStatusId != null) {
			FrameworkLogger.log(LogType.PASS, strProductStatusId + " Product Status is displayed");
			SeleniumActions.click(byAttributesGoButton, "Go button");
		} else {
			FrameworkLogger.log(LogType.FAIL, "Product Status is not present in ASN");
		}
	}

	/**
	 * Function to verify Product status Id is displayed while receiving.
	 *
	 */
	public static void verifyCountryOfOriginDisplayed() {
		String strCountryOfOrigin = SeleniumActions.getText(byAcceptCountryOfOriginField);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "COO", strCountryOfOrigin);
		if (strCountryOfOrigin != null) {
			FrameworkLogger.log(LogType.PASS, strCountryOfOrigin + " Country of Origin is displayed");
			SeleniumActions.click(byAttributesGoButton, "Go button");
		} else {
			FrameworkLogger.log(LogType.FAIL, "Item is not present in ASN");
		}
	}

	/**
	 * Function to enter pallet details to be scanned
	 *
	 * @param strPalletId - Pallet id value
	 */
	public static void enterScanEndPallet(String strPalletId) {

		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byOpenActionButton, "Open Action button");
		SeleniumActions.click(byActionEndContainerButton, "Open Action button");
		SeleniumActions.getElement(byAcceptEndContainerIdInput).clear();
		SeleniumActions.sendTextToElement(byAcceptEndContainerIdInput, String.valueOf(strPalletId),
				"End Pallet number field");
		SeleniumActions.click(byAcceptEndContainerGoButton, "Go button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click Verify ASN button
	 */
	public static void verifyASNinFNTrolleyReceiving() {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byVerifyASNButton, "Verify ASN button clicked");
	}

	/**
	 * Function to verify request verify ASN submitted message is displayed
	 *
	 */
	public static void verifyRequestVerifyASN() {
		String strASNInformation = SeleniumActions.getText(byInformationMessageLabel);
		if (strASNInformation != null && !strASNInformation.trim().isEmpty()) {
			FrameworkLogger.log(LogType.PASS, strASNInformation + " ASN verification request has been submitted done");
			SeleniumActions.click(byInformationOkButton, "Ok button");
		} else {
			FrameworkLogger.log(LogType.FAIL, "Information ASN verification request message is not displayed");
		}
	}

	/**
	 * Function to complete FN LPN Receiving
	 *
	 */
	public static void completeFNLPNReceiving() {
		searchASN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN").toString());
		enterContainer(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "parentlpnId").toString());
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byVerifyASN, "Clicked on verify ASN");
		if (SeleniumActions.getText(byAlertmsg).contains("RCV::277")) {
			// SeleniumActions.closeBrowser();
			// SeleniumActions.switchToLastWindow();
			FrameworkLogger.log(LogType.PASS, "ASN Verification has been submitted");
		} else {
			FrameworkLogger.log(LogType.FAIL, "ASN Verification has not been submitted");
		}

	}

	/**
	 * Function to validate Quantity error for Tolerance
	 */

	/*
	 * public static void validateQtyError(String OrderQuantity, String strAct) {
	 *
	 * int x = Integer.parseInt(OrderQuantity); switch (x) { case 205:
	 * SeleniumActions.waitForPageLoading(); // GeneralUtils.wait(2000);
	 * enterQuantity(Integer.parseInt(OrderQuantity));
	 * SeleniumActions.waitForPageLoading(); // verifyErrorNotDisplayed(); break;
	 * case 215: SeleniumActions.waitForPageLoading();
	 * enterQuantity(Integer.parseInt(OrderQuantity));
	 * SeleniumActions.waitForPageLoading();
	 * SeleniumActions.verifyElementVisible(byAlertmsg, 5, "10% tolerance Error");
	 * if (SeleniumActions.getText(byAlertmsg).contains(strAct)) {
	 * SeleniumActions.click(byAlertConfirm, "alert confirmed");
	 * FrameworkLogger.log(LogType.PASS, "Tolerance error is displayed"); } else {
	 * FrameworkLogger.log(LogType.FAIL, "Tolerance error is not displayed"); }
	 * break; case 252: SeleniumActions.waitForPageLoading();
	 * enterQuantity(Integer.parseInt(OrderQuantity));
	 * SeleniumActions.waitForPageLoading();
	 * SeleniumActions.verifyElementVisible(byAcceptQtyErrorMessageLabel, 5,
	 * "15% tolerance Error"); if
	 * (SeleniumActions.getText(byAcceptQtyErrorMessageLabel).contains(strAct)) {
	 * KeyboardActions.pressKeyboardKeyWithRobot(KeyboardKeys.ESCAPE);
	 * SeleniumActions.closeBrowser(); SeleniumActions.switchToLastWindow();
	 * FrameworkLogger.log(LogType.PASS, "Tolerance error is displayed");
	 *
	 * } else { FrameworkLogger.log(LogType.FAIL,
	 * "Tolerance error is not displayed"); } break; case 200:
	 * SeleniumActions.waitForPageLoading();
	 * enterQuantity(Integer.parseInt(OrderQuantity));
	 * SeleniumActions.waitForPageLoading(); SeleniumActions.click(byVerifyASN,
	 * "clicked verify ASN");
	 *
	 * if
	 * (SeleniumActions.getText(byAcceptQtyErrorMessageLabel).contains("RCV::143"))
	 * { SeleniumActions.closeBrowser(); SeleniumActions.switchToLastWindow();
	 * FrameworkLogger.log(LogType.PASS, "Error143 is displayed"); } else {
	 * FrameworkLogger.log(LogType.FAIL, "Error143 is displayed"); } break; }
	 *
	 * }
	 */

	/**
	 * Function to enter inventory item id to be scanned
	 *
	 * @param strInventoryItemId - Item value
	 */
	/*
	 * public static void enterInventoryItemId(String strInventoryItemId) { if
	 * (strInventoryItemId != null && !strInventoryItemId.trim().isEmpty()) {
	 * SeleniumActions.getElement(byInventoryItemIdField).clear();
	 * SeleniumActions.sendTextToElement(byInventoryItemIdField, strInventoryItemId,
	 * "InventoryItemId search field"); SeleniumActions.click(byAttributesGoButton,
	 * "Go button"); CommonMethods.waitForPageLoading(); } else {
	 * SeleniumActions.click(byAttributesGoButton, "Go button");
	 * CommonMethods.waitForPageLoading(); String strLPN =
	 * SeleniumActions.getText(byInventoryItemIdSearch);
	 * FrameworkLogger.log(LogType.INFO, strLPN +
	 * " InventoryItemId is auto generated"); } }
	 */

	/**
	 * Function to enter product status for inventory
	 *
	 * @param strProductStatus - Product status that need to be received
	 */
	/*
	 * public static void enterProductStatus(String strProductStatus) { if
	 * (strProductStatus != null && !strProductStatus.trim().isEmpty()) {
	 * SeleniumActions.getElement(byProductStatusId).clear();
	 * SeleniumActions.sendTextToElement(byProductStatusId, strProductStatus,
	 * "InventoryItemId search field"); SeleniumActions.click(byAttributesGoButton,
	 * "Go button"); CommonMethods.waitForPageLoading(); } else {
	 * SeleniumActions.click(byGoButton, "Go button");
	 * CommonMethods.waitForPageLoading(); FrameworkLogger.log(LogType.INFO,
	 * strProductStatus + " ProductStatus is auto generated"); } }
	 */

	/*
	 * public static void atStandardReceiving(String strLPN, int iLPNPosition,
	 * String OrderQuantity) { enterLPN(strLPN, iLPNPosition);
	 * enterScanItem(getDataFromFeature("getdata(ItemID_Line1)"));
	 * validateBatchnumber(getDataFromFeature("getdata(BatchNo_Line1"));
	 * enterQuantity(Integer.parseInt(OrderQuantity)); // verifyErrorNotDisplayed();
	 * }
	 */

	/*
	 * public static void enterASN(String strText) {
	 * SeleniumActions.getElement(byASNSearchField).clear();
	 * SeleniumActions.sendTextToElement(byASNSearchField, strText,
	 * "ASN search field"); SeleniumActions.click(byGoButton, "Go button");
	 * Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "AsnId",
	 * strText); CommonMethods.waitForPageLoading(); }
	 */

	/*
	 * public static void enterItemId(String strText) {
	 * SeleniumActions.getElement(byScanItemInput).clear();
	 * SeleniumActions.sendTextToElement(byScanItemInput, strText,
	 * "Item Id scan field"); SeleniumActions.click(byGoButton, "Go button");
	 * Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPNIdLine1",
	 * strText); CommonMethods.waitForPageLoading(); }
	 */

	/**
	 * Function to verify Batch Expiration Date is displayed while receiving.
	 *
	 */
	/*
	 * public static void verifyBatchExpirationDateDisplayed() { String
	 * strBatchExpirationDate =
	 * SeleniumActions.getText(byAcceptBatchExpirationDateField);
	 * Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ExpiryDate",
	 * strBatchExpirationDate); if (strBatchExpirationDate != null) {
	 * FrameworkLogger.log(LogType.PASS, strBatchExpirationDate +
	 * " Batch Expiration Date is displayed");
	 * SeleniumActions.click(byBatchExpirationDateGoButton, "Go button"); } else {
	 * FrameworkLogger.log(LogType.FAIL, "Item is not present in ASN"); } }
	 */

	/**
	 * Function to get scan shipped quantity and feed to scan shipped quantity input
	 * field and save value into runtime variable
	 */
	/*
	 * public static void enterScanQuantity() { // Add code to capture warning error
	 * String strScanQuantity = SeleniumActions.getText(byShippedQtyText); if
	 * (strScanQuantity != null && !strScanQuantity.trim().isEmpty()) {
	 * Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ShippedQty",
	 * strScanQuantity.trim()); /* SeleniumActions.switchToWindowUsingIndex(0);
	 * HomePage.navigate_to_StorageLocation();
	 * StorageLocation.saveCurrentQuantity("CurrentQtyBeforeUpdate");
	 * SeleniumActions.switchToLastWindow();
	 */
	/*
	 * SeleniumActions.getElement(byShippedQtyInput).clear(); String
	 * strSysScanQuantity = strScanQuantity.replace("-", "");
	 * SeleniumActions.sendTextToElement(byShippedQtyInput,
	 * strSysScanQuantity.trim(), "Scan quantity shipped field");
	 * Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "OnHandQty",
	 * strSysScanQuantity); SeleniumActions.click(byScanQuantityGoButton,
	 * "Go button"); CommonMethods.waitForPageLoading(); } else {
	 * FrameworkLogger.log(LogType.FAIL, "Scan Shipped Quantity is null or empty");
	 * } }
	 */

	/**
	 * Function to verify LPN Allocated Sorting message is displayed
	 *
	 */
	/*
	 * public static void verifyLPNAllocatedForSorting() { String strLPNInformation
	 * = SeleniumActions.getText(byInformationMessageLabel); if (strLPNInformation
	 * != null && !strLPNInformation.trim().isEmpty()) {
	 * FrameworkLogger.log(LogType.PASS, strLPNInformation +
	 * " LPN Allocated Sorting Done"); SeleniumActions.click(byInformationOkButton,
	 * "Go button"); } else { FrameworkLogger.log(LogType.FAIL,
	 * "Information LPN Allocated Sorting message is not displayed"); } }
	 */

	/**
	 * Function to enter pallet details to be scanned
	 *
	 * @param strPalletId - Pallet id value
	 */
	/*
	 * public static void enterScanPallet(String strPalletId) {
	 *
	 * CommonMethods.waitForPageLoading();
	 * SeleniumActions.sendTextToElement(byScanPalletInput,
	 * String.valueOf(strPalletId), "Pallet number field");
	 * SeleniumActions.click(byPalletGoButton, "Go button");
	 * CommonMethods.waitForPageLoading(); }
	 */

	/**
	 * Function to verify inventory type Id is displayed while receiving.
	 *
	 */
	/*
	 * public static void verifyInventoryTypeIdDisplayed() { String
	 * strInventoryTypeId = SeleniumActions.getText(byAcceptInventoryTypeIdField);
	 * Variables.set(CurrentThreadInstance.getCurrentScenarioId() +
	 * "InventoryTypeId", strInventoryTypeId); if (strInventoryTypeId != null) {
	 * FrameworkLogger.log(LogType.PASS, strInventoryTypeId +
	 * " Inventory Type Id is displayed");
	 * SeleniumActions.click(byAttributesGoButton, "Go button"); } else {
	 * FrameworkLogger.log(LogType.FAIL, "Item is not present in ASN"); } }
	 */

	/**
	 * Function to verify Product status Id is displayed while receiving.
	 *
	 */
	/*
	 * public static void verifyProductStatusIdDisplayed() { String
	 * strProductStatusId = SeleniumActions.getText(byAcceptProductStatusIdField);
	 * Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ProductStatus",
	 * strProductStatusId); if (strProductStatusId != null) {
	 * FrameworkLogger.log(LogType.PASS, strProductStatusId +
	 * " Product Status is displayed"); SeleniumActions.click(byAttributesGoButton,
	 * "Go button"); } else { FrameworkLogger.log(LogType.FAIL,
	 * "Product Status is not present in ASN"); } }
	 */

	/**
	 * Function to verify Product status Id is displayed while receiving.
	 *
	 */
	/*
	 * public static void verifyCountryOfOriginDisplayed() { String
	 * strCountryOfOrigin = SeleniumActions.getText(byAcceptCountryOfOriginField);
	 * Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "COO",
	 * strCountryOfOrigin); if (strCountryOfOrigin != null) {
	 * FrameworkLogger.log(LogType.PASS, strCountryOfOrigin +
	 * " Country of Origin is displayed");
	 * SeleniumActions.click(byAttributesGoButton, "Go button"); } else {
	 * FrameworkLogger.log(LogType.FAIL, "Item is not present in ASN"); } }
	 */

	/**
	 * Function to enter pallet details to be scanned
	 *
	 * @param strPalletId - Pallet id value
	 */
	/*
	 * public static void enterScanEndPallet(String strPalletId) {
	 *
	 * CommonMethods.waitForPageLoading(); SeleniumActions.click(byOpenActionButton,
	 * "Open Action button"); SeleniumActions.click(byActionEndContainerButton,
	 * "Open Action button");
	 * SeleniumActions.getElement(byAcceptEndContainerIdInput).clear();
	 * SeleniumActions.sendTextToElement(byAcceptEndContainerIdInput,
	 * String.valueOf(strPalletId), "End Pallet number field");
	 * SeleniumActions.click(byAcceptEndContainerGoButton, "Go button");
	 * CommonMethods.waitForPageLoading(); }
	 */

	/**
	 * Function to click Verify ASN button
	 */
	/*
	 * public static void verifyASNinFNTrolleyReceiving() {
	 * CommonMethods.waitForPageLoading(); SeleniumActions.click(byVerifyASNButton,
	 * "Verify ASN button clicked"); }
	 */

	/**
	 * Function to verify request verify ASN submitted message is displayed
	 *
	 */
	/*
	 * public static void verifyRequestVerifyASN() { String strASNInformation =
	 * SeleniumActions.getText(byInformationMessageLabel); if (strASNInformation !=
	 * null && !strASNInformation.trim().isEmpty()) {
	 * FrameworkLogger.log(LogType.PASS, strASNInformation +
	 * " ASN verification request has been submitted done");
	 * SeleniumActions.click(byInformationOkButton, "Ok button"); } else {
	 * FrameworkLogger.log(LogType.FAIL,
	 * "Information ASN verification request message is not displayed"); } }
	 */

	/**
	 * Function to complete FN LPN Receiving
	 *
	 */
	/*
	 * public static void completeFNLPNReceiving() {
	 * searchASN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "ASN").toString());
	 * enterContainer(Variables.get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "parentlpnId").toString()); CommonMethods.waitForPageLoading();
	 * SeleniumActions.click(byVerifyASN, "Clicked on verify ASN"); if
	 * (SeleniumActions.getText(byAlertmsg).contains("RCV::277")) {
	 * SeleniumActions.closeBrowser(); SeleniumActions.switchToLastWindow();
	 * FrameworkLogger.log(LogType.PASS, "ASN Verification has been submitted"); }
	 * else { FrameworkLogger.log(LogType.FAIL,
	 * "ASN Verification has not been submitted"); } }
	 */

	/**
	 * Function to search ILPN Container
	 *
	 * @param strText - LPN value
	 */
	public static void enterContainer(String strText) {
		SeleniumActions.getElement(byContainerSearchField).clear();
		SeleniumActions.sendTextToElement(byContainerSearchField, strText, "LPN Container search field");
		SeleniumActions.click(byContainerGoButton, "Go button");
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN", strText);
		CommonMethods.waitForPageLoading();
		FrameworkLogger.log(LogType.INFO, "Container LPN value from create ILPN");
	}

	/**
	 * Function to click Verify ASN button
	 */
	public static void verifyASNinFNStandardReceiving() {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byVerifyASNButton, "Verify ASN button clicked");
	}

	/**
	 * Function to click Proceed for ASN Verification button
	 */
	public static void verifyProceedASNYesinFNStandardReceiving() {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byVarianceSummaryYesButton, "Proceed for ASN Verification clicked");
	}

	/**
	 * Function to complete ATStandard Receiving with ILPN 3 lines
	 *
	 */
	public static void completeATStandarReceivingwithILPNthreelines() {
		searchASN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN").toString());
		List<String> listOFiLPNs = (List<String>) Variables
				.get(CurrentThreadInstance.getCurrentScenarioId() + "listOFiLPNs");
		for (String iLpn : listOFiLPNs) {
			enterLPN(iLpn);
		}
		SeleniumActions.click(byVerifyASN, "Clicked on verify ASN");
		if (SeleniumActions.getText(byAlertmsg).contains("RCV::277")) {
			SeleniumActions.closeBrowser();
			SeleniumActions.switchToLastWindow();
			FrameworkLogger.log(LogType.PASS, "ASN Verification has been submitted");
		} else {
			FrameworkLogger.log(LogType.FAIL, "ASN Verification has not been submitted");

		}

	}

	/**
	 * Function to complete FN LPN Receiving without parent container
	 *
	 */
	public static void completeFNLPNReceivingw0parentcontainer() {
		searchASN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN").toString());
		List<String> listOFiLPNs = (List<String>) Variables
				.get(CurrentThreadInstance.getCurrentScenarioId() + "listOFiLPNs");
		for (String iLpn : listOFiLPNs) {
			enterContainer(iLpn);
			CommonMethods.waitForPageLoading();
		}
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byVerifyASN, "Clicked on verify ASN");
		CommonMethods.waitForPageLoading();
		if (SeleniumActions.getText(byAlertmsg).contains("RCV::277")) {
			SeleniumActions.closeBrowser();
			SeleniumActions.switchToLastWindow();
			FrameworkLogger.log(LogType.PASS, "ASN Verification has been submitted");
		} else {
			FrameworkLogger.log(LogType.FAIL, "ASN Verification has not been submitted");
		}
	}

	/**
	 * Function to click item details
	 */
	public static void clickItem() {
		if (DriverManager.getDriver().findElements(byItemInStdReceiving).size() > 0) {
			SeleniumActions.click(byItemInStdReceiving, "Business Unit in AT standard receiving");
		}
	}

	/**
	 * Function to complete Cycle Count for Serial number
	 *
	 */
	public static void completeSeedCycleCountIdSerialNumber() {
		List<String> listOfSerialNumbers = (List<String>) Variables
				.get(CurrentThreadInstance.getCurrentScenarioId() + "listOfSerialNumbers");
		for (String serialnumber : listOfSerialNumbers) {
			if (DriverManager.getDriver().findElements(byScanningInfo).size() > 0) {
				verifyScanningInfoDisplayed();
				enterSerialNumber(serialnumber);
				FrameworkLogger.log(LogType.PASS, "Serial number has been submitted: "+serialnumber);
				CommonMethods.waitForPageLoading();
			}
			else
				FrameworkLogger.log(LogType.INFO, "Serial number has been completely submitted");

		}
	}

	/**
	 * Function to verify Scanning info is displayed
	 */
	public static void verifyScanningInfoDisplayed() {
		SeleniumActions.verifyElementVisible(byScanningInfo, 20, "Scanning Info is showing");
	}
	/**
	 * Function clicks on Menu action button in WM mobile page
	 */
	public static void clickOnMenuWmMobile() {
		SeleniumActions.click(byExitWmMobileBtn,"WM mobile Menu Exit action Button");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byWarningConfirmButton, "Confirm button");
		CommonMethods.waitForPageLoading();
	}

}
