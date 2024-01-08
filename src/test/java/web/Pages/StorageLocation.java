package web.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.dhl.driver.DriverManager;
import com.dhl.reports.FrameworkLogger;
import com.dhl.reports.LogType;
import com.dhl.testdata.TestData_Json;
import com.dhl.utils.CurrentThreadInstance;
import com.dhl.utils.Variables;
import com.dhl.web.utils.KeyboardActions;
import com.dhl.web.utils.SeleniumActions;

import stepdefinitions.CommonMethods;

@SuppressWarnings("unused")
public class StorageLocation extends TestData_Json {

	private static final By byStorageLocationsPage = By.xpath("//span[contains(text(),'Storage Locations')]");
	private static final By byStorageLocationDetails = By.xpath("//*[text()='DETAILS ']");
	private static final By byInventryLink = By.xpath("//Span[@data-component-id='Inventory']");
	private static final By byCurrentQuantityTest = By.xpath(
			"//span[contains(@data-component-id,'lpncount')]/parent::div/following-sibling::div//span[contains(@data-component-id,'UNIT')]");
	private static final By byExpandDisplayLocationfield = By.xpath(
			"//span[@title='Display location']/following-sibling::ion-button[@data-component-id='expand-button']");
	private static final By byDisplayLocationField = By
			.xpath("//ion-input[@data-component-id='DisplayLocation']/input");
	private static final By byExpandPutAllocationZoneField = By.xpath(
			"//span[@title='Put allocation zone']/following-sibling::ion-button[@data-component-id='expand-button']");
	private static final By byPutAllocationZoneField = By
			.xpath("//ion-input[@data-component-id='PutAllocationZoneId']/input");
	private static final By byLocationAtFirstIndex = By
			.xpath("(//span[contains(text(),'Location :')])[1]//following-sibling::span[1]");
	private static final By byDisplayLocation = By.xpath("//span[@data-component-id='DisplayLocation']");
	private static final By byStatus = By.xpath("//span[@data-component-id='Status']");
	private static final By byCurrentLocationId = By.xpath("//span[@data-component-id='CurrentLocationId']");
	private static final By byCurrentLocationTypeId = By.xpath("//span[@data-component-id='CurrentLocationTypeId']");
	private static final By byInventoryDetails = By.xpath("//a[text()='Inventory details']");
	private static final By byInventorytype = By.xpath("//span[contains(@data-component-id,'Inventorytype')]");
	private static final By byFinished = By.xpath("//div[contains(@data-component-id,'Finished')]");
	private static final By byQuarantine = By.xpath("//div[contains(@data-component-id,'Quarantine')]");

	private static final By byCurrentQuantity = By
			.xpath("(//div[contains(@class,'datatable-row-group')]//datatable-body-cell[10])[1]/div/div");
	private static final By byBatchNumber = By
			.xpath("(//div[contains(@class,'datatable-row-group')]//datatable-body-cell[31])[1]/div/div/a");
	private static final By byexpandLocationInformation = By.xpath(
			"//div[contains(@class,'expand-header-container ng-star-inserted')]//span[contains(text(),'Location Information')]");
	private static final By byMaxItems = By.xpath("//div[contains(@data-component-id,'MaxItems')]");
	private static final By byAssignItemToLocation2 = By
			.xpath("//ion-button[@data-component-id='AssignItemToLocation']");

	// private static final By byExpandDisplayLocationfield =
	// By.xpath("//span[@title='Display
	// location']/following-sibling::ion-button[@data-component-id='expand-button']");
//    private static final By byDisplayLocationField = By.xpath("//ion-input[@data-component-id='DisplayLocation']/input");

//	private static final By byCurrentQuantity = By
//			.xpath("(//div[contains(@class,'datatable-row-group')]//datatable-body-cell[10])[1]/div/div");
//	private static final By byBatchNumber = By
//			.xpath("(//div[contains(@class,'datatable-row-group')]//datatable-body-cell[31])[1]/div/div/a");

	/**
	 * Function to Verify Storage Locations Page is displayed
	 * 
	 */
	public static void verifyStorageLocationsPageDisplayed() {
		SeleniumActions.verifyElementVisible(byStorageLocationsPage, 20, "Storage Locations page");
	}

	/**
	 * Function to search Display Location in Storage locations window
	 * 
	 * @param strText - Storage Location which need to searched
	 */
	public static void searchDisplayLocation(String strText) {
		CommonMethods.waitForPageLoading();
		if (DriverManager.getDriver().findElements(byDisplayLocationField).size() < 1) {
			SeleniumActions.click(byExpandDisplayLocationfield, "Expand icon");
		}
		SeleniumActions.getElement(byDisplayLocationField).clear();
		SeleniumActions.sendTextToElement(byDisplayLocationField, strText, "Display Location search field");
		CommonMethods.waitForPageLoading();
		KeyboardActions.pressEnterKey(byDisplayLocationField);
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(By.xpath("//span[contains(text(),'" + strText + "')]"), "Display Location Card");
	}


	public static void saveCurrentQuantity(String VarName) {
		verifyStorageLocationsPageDisplayed();
		searchDisplayLocation(
				Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "DisplayLocation").toString());
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byStorageLocationDetails, "Storage Locations Details");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byInventryLink, "Storage Locations Inventry");
		CommonMethods.waitForPageLoading();
		if (DriverManager.getDriver().findElements(byCurrentQuantityTest).size() > 0) {
			String strCurrentQuantity = SeleniumActions.getText(byCurrentQuantityTest);
			if (strCurrentQuantity != null && !strCurrentQuantity.trim().isEmpty()) {
				Variables.set(CurrentThreadInstance.getCurrentScenarioId() + VarName,
						strCurrentQuantity.replace(" UNIT", ""));
			} else {
				FrameworkLogger.log(LogType.FAIL, "Current Quantity is null or empty");
			}
		} else {
			String strCurrentQuantity = "0";
			Variables.set(CurrentThreadInstance.getCurrentScenarioId() + VarName, strCurrentQuantity);
			FrameworkLogger.log(LogType.INFO,
					Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "DisplayLocation").toString()
							+ " Location is null or empty");
		}

	}

	/**
	 * Function to search PutAllocation Zone
	 * 
	 * @param strText - Put Allocation Zone which need to searched
	 */
	public static void searchPutAllocationZone(String strText) {
		CommonMethods.waitForPageLoading();
		if (DriverManager.getDriver().findElements(byPutAllocationZoneField).size() < 1) {
			SeleniumActions.click(byExpandPutAllocationZoneField, "Expand icon");
		}
		SeleniumActions.getElement(byPutAllocationZoneField).clear();
		SeleniumActions.sendTextToElement(byPutAllocationZoneField, strText, "Put AllocationZone Field");
		CommonMethods.waitForPageLoading();
		KeyboardActions.pressEnterKey(byPutAllocationZoneField);
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to verify location at first index
	 * 
	 * @param location - value which need to be verified
	 */
	public static void verifyLocationAtFirstIndex(String location) {
		String actualLocation = SeleniumActions.getAtrribute(byLocationAtFirstIndex, "title", 20);
		if (location.equals(actualLocation)) {
			FrameworkLogger.log(LogType.PASS, "Location Verification passed : " + location);
		} else {
			FrameworkLogger.log(LogType.FAIL,
					"Location Verification failed. Expected :" + location + " , Actual :" + actualLocation);
		}
	}

	/**
	 * Function to store on hand quantity
	 *
	 */
	public static void storeOnHandQuantityToString() {
		WebElement element = DriverManager.getDriver().findElement(byCurrentQuantity);
		String text = element.getText().trim();
		text = text.replaceAll(" UNIT", "");
		FrameworkLogger.log(LogType.INFO, "Current quantity stored in variable:- " + text);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "CurrentOnhandQuantity", text);

	}

	/**
	 * Function to verify on hand quantity
	 * @param Quantity - quantity value
	 *
	 */
	public static void verifyOnHandQuantityToString(String Quantity) {
		String actualQuantity = SeleniumActions.getAtrribute(byCurrentQuantity, "title", 20);
		actualQuantity = actualQuantity.replaceAll(" UNIT", "");
		if (Quantity.equals(actualQuantity)) {
			FrameworkLogger.log(LogType.PASS, " Verification passed : " + Quantity);
		} else {
			FrameworkLogger.log(LogType.FAIL,
					" Verification failed. Expected :+" + Quantity + " , Actual :" + actualQuantity);
		}
	}

	/**
	 * Function to verify batch number
	 * @param BatchNumber -batch number
	 *
	 */
	public static void verifyBatchNumberToString(String BatchNumber) {
		String actualBatchNumber = SeleniumActions.getAtrribute(byBatchNumber, "title", 20);
		actualBatchNumber = actualBatchNumber.trim();
		if (BatchNumber.equals(actualBatchNumber)) {
			FrameworkLogger.log(LogType.PASS, " Verification passed : " + BatchNumber);
		} else {
			FrameworkLogger.log(LogType.FAIL,
					" Verification failed. Expected :+" + BatchNumber + " , Actual :" + actualBatchNumber);
		}
	}

	/**
	 * Function to store on batch number
	 *
	 */
	public static void storeBatchNumberToString() {
		WebElement element = DriverManager.getDriver().findElement(byBatchNumber);
		String text = element.getText().trim();
		FrameworkLogger.log(LogType.INFO, "Current Batch number in variable:- " + text);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "CurrentBatchNumber", text);
	}

	/**
	 * Function to storeOnHandQuantity
	 * 
	 * @param variable - name of the variable to stored
	 */
	public static void storeOnHandQuantity(String variable) {
		WebElement element = DriverManager.getDriver().findElement(byCurrentQuantity);
		String text = element.getText().trim();
		text = text.replaceAll(" UNIT", "");
		FrameworkLogger.log(LogType.INFO,
				"On Hand Quantity stored in variable, variable name: " + variable + ", variable value: " + text);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + variable, text);
	}

	/**
	 * Function to store MaxWeight And MaxVolume From Location
	 * 
	 * @param maxWeight - variable name that we need to store maxWeight
	 * @param maxVolume - variable name that we need to store maxVolume
	 */
	public static void storeMaxWeightAndMaxVolumeFromLocationPopup(String maxWeight, String maxVolume) {
		CommonPage.clickRowAtFirstIndex();
		FooterPanelPage.clickDetailsButton();
		LocationPopupPage.clickLocationInformationLabel();
		String maxWeightValue = LocationPopupPage.getMaxWeight();
		String maxVolumeValue = LocationPopupPage.getMaxVolume();

		FrameworkLogger.log(LogType.INFO,
				"MaxWeight stored in variable, variable name: " + maxWeight + ", variable value: " + maxWeightValue);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + maxWeight, maxWeightValue);
		FrameworkLogger.log(LogType.INFO,
				"MaxVolume stored in variable, variable name: " + maxVolume + ", variable value: " + maxVolumeValue);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + maxVolume, maxVolumeValue);
		CommonPopupPage.clickCloseIcon();
	}

	/**
	 * Function to addItem ToLocation
	 * 
	 * @param item - item value to be added
	 */
	public static void addItemToLocation(String item) {
		if (DriverManager.getDriver().findElement(byAssignItemToLocation2).isDisplayed()) {
			FooterPanelPage.clickAssignItemToLocation2Button();
		} else {
			FooterPanelPage.clickMoreButton();
			FooterPanelPage.clickAssignItemToLocationButton();
		}
		AssignItemToLocationPopupPage.searchItemName(item);
		SeleniumActions.click(By.xpath("//div[@data-component-id='" + item + "']"), "Item row");
		CommonPopupPage.clickSubmit2Button();
		CommonPopupPage.clickSubmitButton();
	}

	/**
	 * Function to expand location information
	 *
	 */
	public static void expandLocationInformation() {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byexpandLocationInformation, "Expand Location Information");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to verify item id
	 * @param expectedItemID - expected item id
	 *
	 */
	public static void verifyMaxItems(String expectedItemID) {
		String actualItemID;
		CommonMethods.waitForPageLoading();
		CommonMethods.scrollByParticularElement(byMaxItems, "Item ID");
		actualItemID = SeleniumActions.getText(byMaxItems).trim();
		SeleniumActions.verifyTextEquals(actualItemID, expectedItemID);
	}

	/**
	 * Function to add item to imported location
	 * @param item - item id to add
	 *
	 */
	public static void addItemToImportedLocation(String item) {
		CommonMethods.waitForPageLoading();
		WebElement assignItemElement = DriverManager.getDriver().findElement(byAssignItemToLocation2);
		boolean isElementPresent = assignItemElement.isDisplayed();
		if (isElementPresent) {
			CommonMethods.waitForPageLoading();
			SeleniumActions.click(byAssignItemToLocation2, "Assign Item to Location button");
		} else {
			FooterPanelPage.clickMoreButton();
			FooterPanelPage.clickAssignItemToLocationButton();
		}

		AssignItemToLocationPopupPage.searchItemName(item);
		SeleniumActions.click(By.xpath("//div[@data-component-id='" + item + "']"), "Item row");
		CommonPopupPage.clickSubmit2Button();
		CommonPopupPage.clickSubmitButton();
	}
}
