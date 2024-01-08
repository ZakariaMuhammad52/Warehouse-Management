package web.Pages;

import org.openqa.selenium.By;

import com.dhl.driver.DriverManager;
import com.dhl.testdata.TestData_Json;
import com.dhl.web.utils.KeyboardActions;
import com.dhl.web.utils.SeleniumActions;

import stepdefinitions.CommonMethods;

@SuppressWarnings("unused")
public class LeftPanelPage extends TestData_Json {
	private static final By byItemTextField = By
			.xpath("//ion-input[@data-component-id='ItemId-lookup-dialog-filter-input']/input");
	private static final By byExpandItemField = By.xpath(
			"//span[@title='Item ID']/following-sibling::ion-button[contains(@data-component-id,'expand-button')]");
	private static final By byClearAllBtn = By.xpath("//button[contains(@data-component-id,'clear-all-btn')]");
	private static final By byDisplayLocationTextField = By
			.xpath("//ion-input[contains(@data-component-id,'DisplayLocation')]/input");
	private static final By byExpandDisplayLocationField = By.xpath(
			"//span[@title='Display location']/following-sibling::ion-button[contains(@data-component-id,'expand-button')]");
	private static final By byExpandPutAllocationZoneField = By.xpath(
			"//span[@title='Put allocation zone']/following-sibling::ion-button[contains(@data-component-id,'expand-button')]");
	private static final By byPutAllocationZoneTextField = By
			.xpath("//ion-input[contains(@data-component-id,'PutAllocationZoneId')]/input");
	private static final By byiLPNTextField = By.xpath("//ion-input[contains(@data-component-id,'IlpnId')]/input");
	private static final By byExpandILPNField = By
			.xpath("//span[@title='ILPN']/following-sibling::ion-button[contains(@data-component-id,'expand-button')]");
	private static final By byLocationTextField = By
			.xpath("//ion-input[contains(@data-component-id,'LocationId')]/input");
	private static final By byExpandLocationField = By.xpath(
			"//span[@title='Location']/following-sibling::ion-button[contains(@data-component-id,'expand-button')]");
	private static final By byASNTextField = By.xpath("//ion-input[contains(@data-component-id,'AsnId')]/input");
	private static final By byExpandASNfield = By
			.xpath("//span[@title='ASN']/following-sibling::ion-button[contains(@data-component-id,'expand-button')]");

	/*
	 * private static final By byLocationBarcodeTextField = By
	 * .xpath("//ion-input[@data-component-id='LocationBarcode']/input"); private
	 * static final By byExpandLocationBarcodeField = By.xpath(
	 * "//span[@title='Location Barcode']/following-sibling::ion-button[@data-component-id='expand-button']"
	 * ); private static final By byInventoryContainerTextField = By .xpath(
	 * "//ion-input[contains(@data-component-id,'InventoryContainerId')]/input");
	 * private static final By byExpandInventoryContainerField = By.xpath(
	 * "//span[@title='Inventory container']/following-sibling::ion-button[@data-component-id='expand-button']"
	 * ); private static final By byUserIdTextField =
	 * By.xpath("//ion-input[contains(@data-component-id,'UserId')]/input"); private
	 * static final By byExpandUserIdField = By
	 * .xpath("//span[@title='User ID']/following-sibling::ion-button[@data-component-id='expand-button']"
	 * ); private static final By byOrganizationUsersButton =
	 * By.xpath("//button[@data-component-id='OrganizationUsers']"); private static
	 * final By byInventoryAdjustmentCheckbox = By
	 * .xpath("//ion-checkbox[@data-component-id='InventoryAdjustment']"); private
	 * static final By byExpandInBoundLPNField = By
	 * .xpath("//span[@title='Inbound LPN ID']/following-sibling::ion-button[@data-component-id='expand-button']"
	 * ); private static final By byOriginalOrderTextField = By
	 * .xpath("//ion-input[@data-component-id='OriginalOrderId']/input"); private
	 * static final By byExpandOriginalOrderField = By
	 * .xpath("//span[@title='Original order']/following-sibling::ion-button[@data-component-id='expand-button']"
	 * ); private static final By byMaximumStatusReleasedCheckbox = By .xpath(
	 * "//div[@data-component-id='MaximumStatus']//ion-checkbox[@data-component-id='Released']"
	 * ); private static final By byExpandFilter =
	 * By.xpath("//ion-button[contains(@data-component-id,'filter')]"); private
	 * static final By byInvDeAllocAvailableSpecificationCheckbox = By
	 * .xpath("//ion-checkbox[@data-component-id='InvnDeAllocAvailable']"); private
	 * static final By byCompletedStatusCheckbox =
	 * By.xpath("//ion-checkbox[@data-component-id='Completed']"); private static
	 * final By byExpandTaskIDField = By .xpath(
	 * "//span[@title='Task']/following-sibling::ion-button[@data-component-id='expand-button']"
	 * ); private static final By byExpandCountRunIDField = By
	 * .xpath("//span[@title='Count run ID']/following-sibling::ion-button[@data-component-id='expand-button']"
	 * ); private static final By byExpandLaneField = By
	 * .xpath("//span[@title='Lane ID']/following-sibling::ion-button[@data-component-id='expand-button']"
	 * ); private static final By byLaneTextField =
	 * By.xpath("//ion-input[@data-component-id='LaneId']/input"); private static
	 * final By byExpandCarrierField = By .xpath(
	 * "//span[@title='Carrier']/following-sibling::ion-button[@data-component-id='expand-button']"
	 * ); private static final By byCarrierTextField =
	 * By.xpath("//ion-input[@data-component-id='CarrierId']/input");
	 * 
	 * private static final By byOrderIdField =
	 * By.xpath("//ion-input[@data-component-id='OrderId']/input"); private static
	 * final By byExpandOrderIdField = By .xpath(
	 * "//span[@title='Order']/following-sibling::ion-button[@data-component-id='expand-button']"
	 * );
	 * 
	 * private static final By byExpandShipmentField = By
	 * .xpath("//span[@title='Shipment ID']/following-sibling::ion-button[@data-component-id='expand-button']"
	 * ); private static final By byShipmentTextField =
	 * By.xpath("//ion-input[@data-component-id='ShipmentId']/input"); private
	 * static final By byExpandOrderTypeField = By
	 * .xpath("//span[@title='Order Type']/following-sibling::ion-button[@data-component-id='expand-button']"
	 * ); private static final By byOrderTypeTextField =
	 * By.xpath("//ion-input[@data-component-id='OrderType']/input"); private static
	 * final By byShipmentFirstRow = By
	 * .xpath("//card-view[@class='dm-fill-space card-views']//div[contains(@class,'card-row primary')][1]"
	 * ); private static final By byILPNStatusNotAllocatedCheckbox = By
	 * .xpath("//ion-checkbox[@data-component-id='NotAllocated']");
	 */

	private static final By byLocationBarcodeTextField = By
			.xpath("//ion-input[contains(@data-component-id,'LocationBarcode')]/input");
	private static final By byExpandLocationBarcodeField = By.xpath(
			"//span[@title='Location Barcode']/following-sibling::ion-button[contains(@data-component-id,'expand-button')]");
	private static final By byInventoryContainerTextField = By
			.xpath("//ion-input[contains(@data-component-id,'InventoryContainerId')]/input");
	private static final By byExpandInventoryContainerField = By.xpath(
			"//span[@title='Inventory container']/following-sibling::ion-button[contains(@data-component-id,'expand-button')]");
	private static final By byUserIdTextField = By.xpath("//ion-input[contains(@data-component-id,'UserId')]/input");
	private static final By byExpandUserIdField = By.xpath(
			"//span[@title='User ID']/following-sibling::ion-button[contains(@data-component-id,'expand-button')]");
	private static final By byExpandInBoundLPNField = By.xpath(
			"//span[@title='Inbound LPN ID']/following-sibling::ion-button[contains(@data-component-id,'expand-button')]");
	private static final By byOriginalOrderTextField = By
			.xpath("//ion-input[@data-component-id='OriginalOrderId-filter']/input");
	private static final By byExpandOriginalOrderField = By.xpath(
			"//span[@title='Original order']/following-sibling::ion-button[@data-component-id='expand-button-filter-field-header']");
	private static final By byExpandFilter = By
			.xpath("//ion-button[contains(@data-component-id,'filter-arrow-header-panel')]");
	private static final By byCompletedStatusCheckbox = By
			.xpath("//ion-checkbox[contains(@data-component-id,'Completed')]");
	private static final By byExpandTaskIDField = By
			.xpath("//span[@title='Task']/following-sibling::ion-button[contains(@data-component-id,'expand-button')]");
	private static final By byExpandCountRunIDField = By.xpath(
			"//span[@title='Count run ID']/following-sibling::ion-button[contains(@data-component-id,'expand-button')]");
	private static final By byExpandLaneField = By.xpath(
			"//span[@title='Lane ID']/following-sibling::ion-button[contains(@data-component-id,'expand-button')]");
	private static final By byLaneTextField = By.xpath("//ion-input[contains(@data-component-id,'LaneId')]/input");
	private static final By byExpandCarrierField = By.xpath(
			"//span[@title='Carrier']/following-sibling::ion-button[contains(@data-component-id,'expand-button')]");
	private static final By byCarrierTextField = By
			.xpath("//ion-input[contains(@data-component-id,'CarrierId')]/input");

	private static final By byOrderIdField = By
			.xpath("//ion-input[@data-component-id='OrderId-lookup-dialog-filter-input']/input");
	private static final By byExpandOrderIdField = By.xpath(
			"//span[@title='Order']/following-sibling::ion-button[@data-component-id='expand-button-filter-field-header']");
	private static final By byShipmentTextField = By.xpath("//ion-input[@data-component-id='ShipmentId-filter']/input");
	private static final By byExpandOrderTypeField = By.xpath(
			"//span[@title='Order Type']/following-sibling::ion-button[contains(@data-component-id,'expand-button')]");
	private static final By byOrderTypeTextField = By
			.xpath("//ion-input[contains(@data-component-id,'OrderType')]/input");

	/**
	 * Function to search item
	 *
	 * @param strText - value to be searched
	 */
	public static void searchItem(String strText) {
		CommonMethods.waitForPageLoading();
		if (DriverManager.getDriver().findElements(byItemTextField).size() < 1) {
			SeleniumActions.click(byExpandItemField, "Expand icon");
		}
		SeleniumActions.getElement(byItemTextField).clear();
		SeleniumActions.sendTextToElement(byItemTextField, strText, "Item ID Text Field");
		CommonMethods.waitForPageLoading();
		KeyboardActions.pressEnterKey(byItemTextField);
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to search Display Location
	 *
	 * @param strText - value which need to searched
	 */
	public static void searchDisplayLocation(String strText) {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byClearAllBtn, "Clear All Filter");
		CommonMethods.waitForPageLoading();
		if (DriverManager.getDriver().findElements(byDisplayLocationTextField).size() < 1) {
			SeleniumActions.click(byExpandDisplayLocationField, "Expand Display Location icon");
		}
		SeleniumActions.getElement(byDisplayLocationTextField).clear();
		SeleniumActions.sendTextToElement(byDisplayLocationTextField, strText, "Display Location Text field");
		CommonMethods.waitForPageLoading();
		KeyboardActions.pressEnterKey(byDisplayLocationTextField);
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to search PutAllocation Zone
	 *
	 * @param strText - value which need to searched
	 */
	public static void searchPutAllocationZone(String strText) {
		CommonMethods.waitForPageLoading();
		if (DriverManager.getDriver().findElements(byPutAllocationZoneTextField).size() < 1) {
			SeleniumActions.click(byExpandPutAllocationZoneField, "Expand icon");
		}
		SeleniumActions.getElement(byPutAllocationZoneTextField).clear();
		SeleniumActions.sendTextToElement(byPutAllocationZoneTextField, strText, "Put AllocationZone Text Field");
		CommonMethods.waitForPageLoading();
		KeyboardActions.pressEnterKey(byPutAllocationZoneTextField);
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click clear All Button
	 */
	public static void clickClearAll() {
		SeleniumActions.click(byClearAllBtn, "Clear All Filter");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to search searchLPN
	 *
	 * @param strText - value which need to searched
	 */
	public static void searchLPN(String strText) {
		CommonMethods.waitForPageLoading();
		if (DriverManager.getDriver().findElements(byiLPNTextField).size() < 1) {
			SeleniumActions.click(byExpandILPNField, "Expand icon");
		}
		SeleniumActions.getElement(byiLPNTextField).clear();
		SeleniumActions.sendTextToElement(byiLPNTextField, strText, "LPN Text field");
		CommonMethods.waitForPageLoading();
		KeyboardActions.pressEnterKey(byiLPNTextField);
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to search Location
	 * 
	 * @param strText - value which need to searched
	 */
	public static void searchLocation(String strText) {
		CommonMethods.waitForPageLoading();
		if (DriverManager.getDriver().findElements(byLocationTextField).size() < 1) {
			SeleniumActions.click(byExpandLocationField, "Expand Location icon");
		}
		SeleniumActions.getElement(byLocationTextField).clear();
		SeleniumActions.sendTextToElement(byLocationTextField, strText, "Location Text field");
		CommonMethods.waitForPageLoading();
		KeyboardActions.pressEnterKey(byLocationTextField);
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to search ASN in ASN window
	 *
	 * @param strText - ASN which need to searched
	 */
	public static void searchASN(String strText) {
		CommonMethods.waitForPageLoading();
		if (DriverManager.getDriver().findElements(byASNTextField).size() < 1) {
			SeleniumActions.click(byExpandASNfield, "Expand icon");
		}
		SeleniumActions.getElement(byASNTextField).clear();
		SeleniumActions.sendTextToElement(byASNTextField, strText, "ASN search field");
		CommonMethods.waitForPageLoading();
		KeyboardActions.pressEnterKey(byASNTextField);
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to search Location Barcode
	 *
	 * @param strText - value to be searched
	 */
	public static void searchLocationBarcode(String strText) {
		CommonMethods.waitForPageLoading();
		if (DriverManager.getDriver().findElements(byLocationBarcodeTextField).size() < 1) {
			SeleniumActions.click(byExpandLocationBarcodeField, "Expand icon");
		}
		SeleniumActions.getElement(byLocationBarcodeTextField).clear();
		SeleniumActions.sendTextToElement(byLocationBarcodeTextField, strText, "Location Barcode Field");
		CommonMethods.waitForPageLoading();
		KeyboardActions.pressEnterKey(byLocationBarcodeTextField);
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to search InventoryContainer
	 * 
	 * @param strText - value which need to searched
	 */
	public static void searchInventoryContainer(String strText) {
		CommonMethods.waitForPageLoading();
		if (DriverManager.getDriver().findElements(byInventoryContainerTextField).size() < 1) {
			SeleniumActions.click(byExpandInventoryContainerField, "Expand InventoryContainer icon");
		}
		SeleniumActions.getElement(byInventoryContainerTextField).clear();
		SeleniumActions.sendTextToElement(byInventoryContainerTextField, strText, "InventoryContainer Text field");
		CommonMethods.waitForPageLoading();
		KeyboardActions.pressEnterKey(byInventoryContainerTextField);
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to search User id
	 * 
	 * @param strText - value which need to searched
	 */
	public static void searchUserId(String strText) {
		CommonMethods.commonSearch(byExpandUserIdField, byUserIdTextField, strText, "User ID");
	}

	/**
	 * Function to search Inbound LPN ID
	 * 
	 * @param strText - value which need to searched
	 */
	public static void searchInBoundLPNID(String strText) {
		CommonMethods.commonSearch(byExpandInBoundLPNField, byiLPNTextField, strText, "In bound LPN ID");
	}

	/**
	 * Function to search Original Order
	 * 
	 * @param strText - value which need to searched
	 */
	public static void searchOriginalOrder(String strText) {
		CommonMethods.commonSearch(byExpandOriginalOrderField, byOriginalOrderTextField, strText, "Original Order");
	}

	/**
	 * Function to check the completed status
	 */
	public static void checkCompletedStatusCheckbox() {
		SeleniumActions.click(byCompletedStatusCheckbox, "CompletedStatusCheckbox");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to expand taskid field
	 */
	public static void expandTaskIDField() {
		SeleniumActions.getElement(byExpandTaskIDField).click();
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to expand count run field
	 */
	public static void expandCountRunIDField() {
		SeleniumActions.getElement(byExpandCountRunIDField).click();
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to search Lane ID
	 * 
	 * @param strText - LANE id which need to searched
	 */
	public static void searchLane(String strText) {
		CommonMethods.waitForPageLoading();
		if (DriverManager.getDriver().findElements(byLaneTextField).size() < 1) {
			SeleniumActions.click(byExpandLaneField, "Expand icon");
		}
		SeleniumActions.getElement(byLaneTextField).clear();
		SeleniumActions.sendTextToElement(byLaneTextField, strText, "Lane ID Text Field");
		CommonMethods.waitForPageLoading();
		KeyboardActions.pressEnterKey(byLaneTextField);
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to search Carrier ID
	 * 
	 * @param strText - Carrier id which need to searched
	 */
	public static void searchCarrier(String strText) {
		CommonMethods.waitForPageLoading();
		if (DriverManager.getDriver().findElements(byCarrierTextField).size() < 1) {
			SeleniumActions.click(byExpandCarrierField, "Expand icon");
		}
		SeleniumActions.getElement(byCarrierTextField).clear();
		SeleniumActions.sendTextToElement(byCarrierTextField, strText, "Carrier ID Text Field");
		CommonMethods.waitForPageLoading();
		KeyboardActions.pressEnterKey(byCarrierTextField);
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to search order in OLPNS
	 * 
	 * @param strText - search value
	 */
	public static void searchOrderinOlpns(String strText) {
		CommonMethods.waitForPageLoading();
		CommonMethods.commonSearch(byExpandOrderIdField, byOrderIdField, strText, "Original Order");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to search Shipment ID
	 * 
	 * @param strText - Shipment id which need to searched
	 */
	public static void searchShipment(String strText) {
		CommonMethods.waitForPageLoadAndToLoadWebElements();
		SeleniumActions.getElement(byShipmentTextField).clear();
		CommonMethods.waitForPageLoadAndToLoadWebElements();
		SeleniumActions.sendTextToElement(byShipmentTextField, strText, "ShipmentID Text Field");
		CommonMethods.waitForPageLoadAndToLoadWebElements();
		KeyboardActions.pressEnterKey(byShipmentTextField);
		CommonMethods.waitForPageLoadAndToLoadWebElements();
	}

	/**
	 * Function to search Order Type
	 * 
	 * @param strText - value which need to searched
	 */
	public static void searchOrderType(String strText) {
		CommonMethods.commonSearch(byExpandOrderTypeField, byOrderTypeTextField, strText, "Order Type");

	}
}
