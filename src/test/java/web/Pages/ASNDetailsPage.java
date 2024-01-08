package web.Pages;

import org.openqa.selenium.By;

import com.dhl.driver.DriverManager;
import com.dhl.reports.FrameworkLogger;
import com.dhl.reports.LogType;
import com.dhl.testdata.TestData_Json;
import com.dhl.utils.CurrentThreadInstance;
import com.dhl.utils.Variables;
import com.dhl.web.utils.SeleniumActions;

import org.openqa.selenium.WebElement;
import stepdefinitions.CommonMethods;

@SuppressWarnings("unused")
public class ASNDetailsPage extends TestData_Json {

	private static final By byProductStatusList = By
			.xpath("//span[contains(text(),'Product status :')]//following-sibling::span[@title='A']");
	private static final By byInventoryTypeList = By
			.xpath("//span[contains(text(),'Inventory type :')]//following-sibling::span[@title='F']");
	private static final By byAsnLineStatus = By.xpath("//div[@data-component-id='AsnLineStatus-card-view']");
	private static final By bySlideOptionDetailBtn = By.xpath("//button[@data-component-id='Details-swipe-panel']");
	private static final By byOpenSlideOption = By.xpath(
			"//slider-actions[contains(@data-component-id,'Slide-Actions')]//button[@data-component-id='action-closed-card-view']");
	private static final By byCloseSlideOption = By.xpath(
			"(//slider-actions[contains(@data-component-id,'Slide-Actions')]//button[@data-component-id='action-open-card-view'])[2]");
	private static final By byExpandInventoryAttributes = By.xpath("//span[contains(text(),'Inventory Attributes')]");
	private static final By byCloseASNLineDetails = By.xpath("//button//ion-icon[@name='close']");
	private static final By byInventoryAttributesBatchNumber = By.xpath(
			"//div[contains(text(),'Batch number :')]//following-sibling::div[@data-component-id='BatchNumber-list-expand']");
	private static final By byInventoryAttributesInventoryType = By.xpath(
			"//div[contains(text(),'Inventory type :')]//following-sibling::div[@data-component-id='InventoryTypeId-list-expand']");
	private static final By byInventoryAttributesProductStatus = By.xpath(
			"//div[contains(text(),'Product status :')]//following-sibling::div[@data-component-id='ProductStatusId-list-expand']");
	private static final By byExpandInventoryDates = By.xpath("//span[contains(text(),'Inventory Dates')]");
	private static final By byInventoryDatesExpiryDate = By
			.xpath("//div[contains(text(),'Expiry date :')]//following-sibling::div[@data-component-id='ExpiryDate-list-expand']");

	private static final By byItemIdList = By.xpath("(//span[contains(text(),'Item :')])[1]//following-sibling::a[1]");
	private static final By byShipQtyUnitList = By.xpath("(//span[contains(text(),'Shipped quantity(unit) :')])[1]//following-sibling::span[1]");

	/**
	 * Function to verify Product status Element count
	 */
	public static void verifyProductStatusElementCount(int count) {
		int actualCount = DriverManager.getDriver().findElements(byProductStatusList).size();
		if (count == actualCount) {
			FrameworkLogger.log(LogType.PASS, "Product status element count verification passed : ");
		} else {
			FrameworkLogger.log(LogType.FAIL, "Product status element count verification failed. Expected:  " + count
					+ ", Actual :" + actualCount);
		}
	}

	/**
	 * Function to verify InventoryType Element count
	 */
	public static void verifyInventoryTypeElementCount(int count) {
		int actualCount = DriverManager.getDriver().findElements(byInventoryTypeList).size();
		if (count == actualCount) {
			FrameworkLogger.log(LogType.PASS, "InventoryType element count verification passed : ");
		} else {
			FrameworkLogger.log(LogType.FAIL, "InventoryType element count verification failed. Expected:  " + count
					+ ", Actual :" + actualCount);
		}
	}

	/**
	 * Function to get current ASN Line status from ASN Details window
	 */
	public static String getASNLineStatus() {
		String strStatus = SeleniumActions.getText(byAsnLineStatus);
		if (strStatus != null && !strStatus.trim().isEmpty()) {
			return strStatus.trim();
		} else {
			FrameworkLogger.log(LogType.FAIL, "ASN Status description is null or empty");
		}
		return "";
	}

	/**
	 * Function to verify ASN Line status displayed from ASN Details window
	 *
	 * @param strExpected - ASN Line status that need to be verified
	 */
	public static void verifyASNLineStatus(String strExpected) {
		String strStatus = getASNLineStatus();
		if (!strStatus.isEmpty()) {
			SeleniumActions.verifyTextEquals(strStatus, strExpected);
		}
	}

	/**
	 * Function to click Details in ASN Detail Slide Screen
	 */
	public static void clickDetails() {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(bySlideOptionDetailBtn, "Details Button");
	}

	/**
	 * Function to close slide options in ILPN Page
	 */
	public static void closeSlideOption() {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byCloseSlideOption, "Close Slide option");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to close slide options in ILPN Page
	 */
	public static void openSlideOption() {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byOpenSlideOption, "Open Slide option");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to verify Inventory Attribute is expanding the details.
	 */
	public static void expandInventoryAttributes() {
		SeleniumActions.click(byExpandInventoryAttributes, "Inventory Attributes is expanding");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to get current product status from ASN Details>ASN line>Inventory
	 * Attributes
	 */
	public static String getProductStatusAtInventoryAttributes() {
		String strProductStatus = SeleniumActions.getText(byInventoryAttributesProductStatus);
		if (strProductStatus != null && !strProductStatus.trim().isEmpty()) {
			return strProductStatus.trim();
		} else {
			FrameworkLogger.log(LogType.FAIL, "Product Status is null or empty");
		}
		return "";
	}

	/**
	 * Function to get current inventory type from ASN Details>ASN line>Inventory
	 * Attributes
	 */
	public static String getInventoryTypeAtInventoryAttributes() {
		String strInventoryType = SeleniumActions.getText(byInventoryAttributesInventoryType);
		if (strInventoryType != null && !strInventoryType.trim().isEmpty()) {
			return strInventoryType.trim();
		} else {
			FrameworkLogger.log(LogType.FAIL, "Inventory Type is null or empty");
		}
		return "";
	}

	/**
	 * Function to get current batch number from ASN Details>ASN line>Inventory
	 * Attributes
	 */
	public static String getBatchNumberAtInventoryAttributes() {
		String strBatchNumber = SeleniumActions.getText(byInventoryAttributesBatchNumber);
		if (strBatchNumber != null && !strBatchNumber.trim().isEmpty()) {
			return strBatchNumber.trim();
		} else {
			FrameworkLogger.log(LogType.FAIL, "Batch Number is null or empty");
		}
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "BatchNo", strBatchNumber.trim());
		return "";
	}

	/**
	 * Function to verify Inventory Attribute is expanding the details.
	 */
	public static void expandInventoryDates() {
		SeleniumActions.click(byExpandInventoryDates, "Inventory Dates is expanding");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to get current batch number from ASN Details>ASN line>Inventory
	 * Attributes
	 */
	public static String getExpiryDateAtInventoryDates() {
		String strExpiryDate = SeleniumActions.getText(byInventoryDatesExpiryDate);
		if (strExpiryDate != null && !strExpiryDate.trim().isEmpty()) {
			return strExpiryDate.trim();
		} else {
			FrameworkLogger.log(LogType.FAIL, "Expiry Date is null or empty");
		}
		return "";
	}

	/**
	 * Function to close ASN Line details popup.
	 */
	public static void closeASNLinePopup() {
		SeleniumActions.click(byCloseASNLineDetails, "ASN Line popup is close");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to store Item Id from ASN details card.
	 */
	public static void storeItemIdAtFirstIndexToString() {
		WebElement element = DriverManager.getDriver().findElement(byItemIdList);
		String text = element.getText().trim();
		FrameworkLogger.log(LogType.INFO, "Item Id stored in variable:- " + text);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ItemIdAtFirstIndex", text);
	}

	/**
	 * Function to ShipQtyUnit from ASN Details card
	 */
	public static String verifyShipQtyUnitAtFirstIndex() {
		String strShipQtyUnit = SeleniumActions.getText(byShipQtyUnitList);
		if (strShipQtyUnit != null && !strShipQtyUnit.trim().isEmpty()) {
			Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ShipQtyUnitAtFirstIndex", strShipQtyUnit.trim());
			return strShipQtyUnit.trim();
		} else {
			FrameworkLogger.log(LogType.FAIL, "Ship Quantity Unit is null or empty");
		}
		return "";
	}

	/**
	 * Function to Inventory Type from ASN Details card
	 */
	public static String verifyInventoryTypeAtFirstIndex() {
		String strInventoryType = SeleniumActions.getText(byInventoryTypeList);
		if (strInventoryType != null && !strInventoryType.trim().isEmpty()) {
			Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "InventoryTypeAtFirstIndex", strInventoryType.trim());
			return strInventoryType.trim();
		} else {
			FrameworkLogger.log(LogType.FAIL, "Inventory Type is null or empty");
		}
		return "";
	}

	/**
	 * Function to Inventory Type from ASN Details card
	 */
	public static String verifyProductStatusAtFirstIndex() {
		String strProductStatus = SeleniumActions.getText(byProductStatusList);
		if (strProductStatus != null && !strProductStatus.trim().isEmpty()) {
			Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ProductStatusAtFirstIndex", strProductStatus.trim());
			return strProductStatus.trim();
		} else {
			FrameworkLogger.log(LogType.FAIL, "Product Status is null or empty");
		}
		return "";
	}

}
