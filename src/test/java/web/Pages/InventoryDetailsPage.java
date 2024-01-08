package web.Pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

public class InventoryDetailsPage extends TestData_Json {

	private static final By byInventoryDetailsPage = By.xpath("//span[contains(text(),'Inventory Details')]");
	private static final By byBatchNumberTextField = By
			.xpath("//ion-input[contains(@data-component-id,'BatchNumber')]/input");
	private static final By byItemIdTextField = By.xpath("//ion-input[contains(@data-component-id,'ItemId')]/input");
	private static final By byNoRecordsFoundLabel = By.xpath("//ion-label[contains(text(),'No Records found')]");
	private static final By byCheckboxList = By.xpath("//label[contains(@class, 'datatable-checkbox')]//input");
	private static final By byInventoryDetailsButton = By.xpath("//button[@data-component-id='InventoryDetails-hamburger-menu']");
	private static final By byHeldConditionCode = By.xpath(
			"//div[@class='popupDetails']//span[contains(@data-component-id,'conditioncodes-label')]//following-sibling::span"); // finetuned
	private static final By byCancelButton = By.xpath("//button[contains(@data-component-id,'cancel-btn')]"); // in pld details
	// page
	private static final By byEndCountButton = By.xpath("//span[contains(text(),'End Count')]");
	private static final By byClickConfirm = By.xpath("//span[contains(text(),'Confirm')]");
	private static final By byExpandFilter = By.xpath("//ion-button[contains(@data-component-id,'filter-count-btn')]");
	private static final By byInventoryType = By.xpath("//span[contains(@data-component-id,'Inventorytype')]");
	private static final By byFinished = By
			.xpath("//div[contains(@data-component-id,'Finished')][normalize-space()='Finished']");
	private static final By byQuarantine = By
			.xpath("//div[contains(@data-component-id,'Quarantine')][normalize-space()='Quarantine']");
	private static final By byExpandBatchNumberfield = By
			.xpath("//span[@title='Batch number']/following-sibling::ion-button[contains(@data-component-id,'expand-button')]");
	private static final By byExpandItemIdfield = By
			.xpath("//span[contains(@title,'Item')]/following-sibling::ion-button[contains(@data-component-id,'expand-button')]");
	private static final By byOnHandQuantity = By.xpath(
			"//datatable-header-cell[@title='On hand quantity ']//following::datatable-body//datatable-body-cell[10]//div[contains(@class,'grid-cell')]");// finetuned

	private static final By byAllocatedQuantity = By.xpath(
			"//datatable-header-cell[@title='Allocated quantity ']//following::datatable-body//datatable-body-cell[12]//div[contains(@class,'grid-cell')]");// finetuned

	// finetune
	// the
	// xpath
	private static final By byFilterCountButton = By.xpath(
			"//ion-button[contains(@data-component-id,'filter-count-btn')]//ion-icon[contains(@class,'dmuiIcon filter-arrow md hydrated')]");
	private static final By byClearAll = By.xpath("//button[contains(text(),'Clear All')]");
	private static final By byDisplayLocationTextField = By
			.xpath("//ion-input[contains(@data-component-id,'DisplayLocation')]//input");
	private static final By byExpandDisplayLocation = By.xpath(
			"//span[contains(@title,'Display location')]/following-sibling::ion-button[contains(@data-component-id,'expand-button')]");
	private static final By byRecallConditionCode = By.xpath(
			"//div[@class='popupDetails']//span[contains(@data-component-id,'conditioncodes-label')]//following-sibling::span");// finetuned

	private static final By byExpiryDate = By
			.xpath("//datatable-header-cell[@title='Expiration date ']//following::datatable-body//datatable-body-cell[24]//div[contains(@class,'grid-cell')]");// finetuned

	private static final By byConfirmaction = By
			.xpath("//button[contains(@data-component-id,'action_continuecountaction_button')]");
	private static final By byRelatedLinksInvAttributes = By
			.xpath("//ion-list[@class='md list-md hydrated']//*[contains(text(),'Inventory Attributes')]");

	private static final By byselectinvfirstrow = By
			.xpath("//div[contains(@class,'datatable-row-group')]//input[@type='checkbox']");// Need
	private static final By byselectFirstItem = By
			.xpath("(//div[@class='datatable-body-cell-label']//label//input[@type='checkbox'])[1]");
	private static final By bylocationitemvalue = By
			.xpath("//div[@class='datatable-body-cell-label']//div/a[contains(@data-component-id,'link')]");
	private static final By byInventoryContainerCellValue = By
			.xpath("((//div[contains(@class,'datatable-row-center')])[2]//datatable-body-cell)[7]/div[1]/div");
	private static final By byLPNStatusCellValue = By
			.xpath("((//div[contains(@class,'datatable-row-center')])[2]//datatable-body-cell)[8]/div[1]/div");
	private static final By byOnHandQuantityCellValue = By
			.xpath("//datatable-header-cell[@title='On hand quantity ']//following::datatable-body//datatable-body-cell[10]//div[contains(@class,'grid-cell')]");

	private static final By byInventoryTypeCellValue = By
			.xpath("((//div[contains(@class,'datatable-row-center')])[2]//datatable-body-cell)[34]/div[1]/div");
	private static final By byProductStatusCellValue = By
			.xpath("((//div[contains(@class,'datatable-row-center')])[2]//datatable-body-cell)[35]/div[1]/div");
	// private static final By byCompleteCountAction =
	// By.xpath("//span[text()='Continue Count Action']");
	private static final By byItemCellValue = By
			.xpath("((//div[contains(@class,'datatable-row-center')])[2]//datatable-body-cell)[30]/div[1]/div");
	private static final By byLocationBarCodeCellValue = By
			.xpath("((//div[contains(@class,'datatable-row-center')])[2]//datatable-body-cell)[33]/div[1]/div");
	private static final By byOriginalQuantityDisplay = By
			.xpath("//span[contains(@data-component-id,'OriginalQuantityDisplay')]");
	private static final By byCountQuantityDisplay = By.xpath("//span[contains(@data-component-id,'CountQuantityDisplay')]");
	private static final By byVarianceQuantityDisplay = By
			.xpath("//span[contains(@data-component-id,'VarianceQuantityDisplay')]");
	private static final By byInventoryAttributesAttributeValue = By
			.xpath("//span[contains(@data-component-id,'AttributeValue')]");
	private static final By byCompleteCountAction = By.xpath("//span[text()='Continue Count Action']");
	private static final By byItemTextField = By.xpath("//ion-input[contains(@data-component-id,'ItemId')]/input");
	private static final By byExpandItemField = By
			.xpath("//span[@title='Item']/following-sibling::ion-button[contains(@data-component-id,'expand-button')]");
	private static final By byILPNInventoryContainerNumber = By
			.xpath("(//div[contains(@class,'datatable-row-group')]//datatable-body-cell[7])[1]/div/div/a");
	private static final By byInventoryTypeFinished = By.xpath("(//*[@title='Finished'])[1]");
	private static final By byProductStatus = By.xpath("(//*[@title='Available'])[1]");
	private static final By byOnHandQuantityValue = By.xpath("((//div[contains(@class,'datatable-row-center')])[2]//datatable-body-cell)[10]/div[1]/div");
	/**
	 * Function to verify Inventory details
	 */
	public static void verifyInventoryDetailsPageDisplayed() {
		SeleniumActions.verifyElementVisible(byInventoryDetailsPage, 20, "Inventory Details page");
	}

	/**
	 * Function to enter batch number
	 *
	 * @param text - value which need to be entered
	 */
	public static void enterBatchNumber(String text) {
		if (DriverManager.getDriver().findElements(byBatchNumberTextField).size() < 1) {
			SeleniumActions.click(byExpandBatchNumberfield, "Expand icon");
		}
		SeleniumActions.clear(byBatchNumberTextField, "Batch Number");
		CommonMethods.waitForPageLoading();
		SeleniumActions.sendTextToElement(byBatchNumberTextField, text, "Batch Number");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to enter item id
	 *
	 * @param text - value which need to be entered
	 */
	public static void enterItemId(String text) {
		if (DriverManager.getDriver().findElements(byItemIdTextField).size() < 1) {
			SeleniumActions.click(byExpandItemIdfield, "Expand icon");
		}
		SeleniumActions.clear(byItemIdTextField, "Item Id");
		CommonMethods.waitForPageLoading();
		SeleniumActions.sendTextToElement(byItemIdTextField, text, "Item Id");
		KeyboardActions.pressEnterKey(byItemIdTextField);
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click inventory details button
	 */
	public static void clickInventoryDetailsButton() {
		SeleniumActions.click(byInventoryDetailsButton, "Inventory Details");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click cancel button
	 */
	public static void clickCancelButton() {
		SeleniumActions.click(byCancelButton, "Cancel button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to search batch number
	 *
	 * @param text - value which need to be searched
	 */
	public static void searchBatchNumber(String text) {
		enterBatchNumber(text);
		KeyboardActions.pressEnterKey(byBatchNumberTextField);
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to enter item id
	 *
	 * @param text - value which need to be searched
	 */
	public static void searchItemId(String text) {
		enterItemId(text);
		// KeyboardActions.pressEnterKey(byItemIdTextField);
		// CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to find batch number who is having valid item
	 */
	public static void findBatchNumberWhoIsHavingValidItem() {
		boolean isBatchNumberFound = false;
		List<String> listOfBatchNumbers = (List<String>) Variables
				.get(CurrentThreadInstance.getCurrentScenarioId() + "listOfBatchNumbers");
		List<String> listOfItemIds = (List<String>) Variables
				.get(CurrentThreadInstance.getCurrentScenarioId() + "listOfItemIds");
		List<String> listOfHeldConditionCodes = (List<String>) Variables
				.get(CurrentThreadInstance.getCurrentScenarioId() + "listOfHeldConditionCodes");

		for (int i = 0; i < listOfBatchNumbers.size(); i++) {
			String heldConditionCode = listOfHeldConditionCodes.get(i);
			if (heldConditionCode == null || heldConditionCode.isEmpty()) {
				continue;
			}
			String batchNumber = listOfBatchNumbers.get(i);
			searchBatchNumber(batchNumber);
			if (DriverManager.getDriver().findElements(byNoRecordsFoundLabel).size() <= 0) {
				FrameworkLogger.log(LogType.INFO, "Batch Number stored in variable:- " + batchNumber);
				Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "BatchNumber", batchNumber);
				Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ItemId", listOfItemIds.get(i));
				isBatchNumberFound = true;
				break;
			}
		}
		if (!isBatchNumberFound) {
			FrameworkLogger.log(LogType.FAIL, "Batch Number Not found Who Is Having Valid Item");
		}
	}

	/**
	 * Function to filter results by Batch Number and ItemId
	 */
	public static void filterByBatchNumberDetails() {
		String batchNumber = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "BatchNumber");
		String itemId = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ItemId");
		searchBatchNumber(batchNumber);
		searchItemId(itemId);
		LocationInventory.selectILPNStatusNotAllocatedCheckbox();
	}
	// Commented below code by lohith on 13 Nov 2023 during merge
	/*
	 * for (int i = 0; i < listOfBatchNumbers.size(); i++) { String
	 * heldConditionCode = listOfHeldConditionCodes.get(i); if (heldConditionCode ==
	 * null || heldConditionCode.isEmpty()) { continue; } String batchNumber =
	 * listOfBatchNumbers.get(i); searchBatchNumber(batchNumber);
	 * CommonMethods.waitForPageLoading(); FrameworkLogger.log(LogType.INFO,
	 * "Test reporter:- " + batchNumber); if
	 * (DriverManager.getDriver().findElements(byNoRecordsFoundLabel).size() <= 0) {
	 * FrameworkLogger.log(LogType.INFO, "Batch Number stored in variable:- " +
	 * batchNumber); Variables.set(CurrentThreadInstance.getCurrentScenarioId() +
	 * "BatchNumber", batchNumber);
	 * Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ItemId",
	 * listOfItemIds.get(i)); isBatchNumberFound = true; break; } } if
	 * (!isBatchNumberFound) { FrameworkLogger.log(LogType.FAIL,
	 * "Batch Number Not found Who Is Having Valid Item"); } }
	 */

	/**
	 * Function to Verify all the entries in inventory is locked with correct held
	 * condition code
	 */
	public static void verifyThatAllTheEntriesInInventoryIsLockedWithTheCorrectHeldConditionCode() {
		String heldConditionCode = (String) Variables
				.get(CurrentThreadInstance.getCurrentScenarioId() + "HeldConditionCode");
		List<WebElement> checkboxElements = DriverManager.getDriver().findElements(byCheckboxList);
		for (WebElement element : checkboxElements) {
			SeleniumActions.click(element,"click on Element");
			//element.click();
			CommonMethods.waitForPageLoading();
			clickInventoryDetailsButton();
			CommonMethods.scrollByParticularElement(byHeldConditionCode, "Held ConditionCode in LPN Details popup");
			String actualHeldConditionCode = SeleniumActions.getText(byHeldConditionCode);
			if (actualHeldConditionCode == null || actualHeldConditionCode.isEmpty()) {
				FrameworkLogger.log(LogType.FAIL,
						"Held ConditionCode is NULL or EMPTY.  Held ConditionCode Verification failed. Expected : "
								+ heldConditionCode + " , Actual : " + actualHeldConditionCode);
			}
			if (heldConditionCode.equals(actualHeldConditionCode.trim())) {
				FrameworkLogger.log(LogType.PASS, "Held ConditionCode Verification passed : " + heldConditionCode);
			} else {
				FrameworkLogger.log(LogType.FAIL, "Held ConditionCode Verification failed. Expected : "
						+ heldConditionCode + " , Actual : " + actualHeldConditionCode);
			}
			clickCancelButton();
			SeleniumActions.click(element,"click on Element");
			//element.click();
			CommonMethods.waitForPageLoading();
		}
	}

	/**
	 * Function to Verify all the entries in inventory has no condition code
	 */
	public static void verifyThatAllTheEntriesInInventoryHasNoConditionCode() {
		List<WebElement> checkboxElements = DriverManager.getDriver().findElements(byCheckboxList);
		for (WebElement element : checkboxElements) {
			element.click();
			CommonMethods.waitForPageLoading();
			clickInventoryDetailsButton();
			CommonMethods.scrollByParticularElement(byHeldConditionCode, "HeldConditionCode in LPN Details popup");
			String actualHeldConditionCode = SeleniumActions.getText(byHeldConditionCode);
			if ("-".equals(actualHeldConditionCode.trim())) {
				FrameworkLogger.log(LogType.PASS, "No Condition Code Verification passed");
			} else {
				FrameworkLogger.log(LogType.FAIL,
						"No Condition Code Verification failed. Expected No condition code, but Actual :"
								+ actualHeldConditionCode);
			}
			clickCancelButton();
			element.click();
			CommonMethods.waitForPageLoading();
		}
	}

	/**
	 * Function to Verify all the entries in inventory is locked with correct
	 * condition codes
	 */
	public static void verifyThatAllTheEntriesInInventoryIsLockedWithTheCorrectConditionCodes() {
		String heldConditionCode = (String) Variables
				.get(CurrentThreadInstance.getCurrentScenarioId() + "HeldConditionCode");
		String recallConditionCode = (String) Variables
				.get(CurrentThreadInstance.getCurrentScenarioId() + "RecallConditionCode");

		List<WebElement> checkboxElements = DriverManager.getDriver().findElements(byCheckboxList);
		for (WebElement element : checkboxElements) {
			element.click();
			CommonMethods.waitForPageLoading();
			clickInventoryDetailsButton();
			CommonMethods.scrollByParticularElement(byHeldConditionCode, "Held ConditionCode in LPN Details popup");
			String actualHeldConditionCode = SeleniumActions.getText(byHeldConditionCode);
			String actualRecallConditionCode = SeleniumActions.getText(byRecallConditionCode);

			if (actualHeldConditionCode == null || actualHeldConditionCode.isEmpty()) {
				FrameworkLogger.log(LogType.FAIL,
						"Held ConditionCode is NULL or EMPTY.  Held ConditionCode Verification failed. Expected : "
								+ heldConditionCode + " , Actual : " + actualHeldConditionCode);
			}
			if (heldConditionCode.equals(actualHeldConditionCode.replaceAll(" ", "").replaceAll(",", "").trim())) {
				FrameworkLogger.log(LogType.PASS, "Held ConditionCode Verification passed : " + heldConditionCode);
			} else {
				FrameworkLogger.log(LogType.FAIL, "Held ConditionCode Verification failed. Expected :"
						+ heldConditionCode + " , Actual :" + actualHeldConditionCode);
			}

			if (actualRecallConditionCode == null || actualRecallConditionCode.isEmpty()) {
				FrameworkLogger.log(LogType.FAIL,
						"Recall ConditionCode is NULL or EMPTY.  Recall ConditionCode Verification failed. Expected : "
								+ recallConditionCode + " , Actual : " + actualRecallConditionCode);
			}
			if (recallConditionCode.equals(actualRecallConditionCode.replaceAll(" ", "").replaceAll(",", "").trim())) {
				FrameworkLogger.log(LogType.PASS, "Recall ConditionCode Verification passed : " + recallConditionCode);
			} else {
				FrameworkLogger.log(LogType.FAIL, "Recall ConditionCode Verification failed. Expected :"
						+ recallConditionCode + " , Actual : " + actualRecallConditionCode);
			}
			clickCancelButton();
			element.click();
			CommonMethods.waitForPageLoading();
		}
	}

	/**
	 * Function to minimize filter button in inventory details
	 */
	public static void minimizeFilterButton() {
		CommonMethods.waitForPageLoading();
		if (DriverManager.getDriver().findElements(byFilterCountButton).size() > 0) {
			SeleniumActions.click(byFilterCountButton, "Filter icon");
		}
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to select inventory container type
	 *
	 * @param strContainerType - Type which need to searched
	 */
	public static void filterInventoryContainerType(String strContainerType) {
		CommonMethods.waitForPageLoading();
		if (DriverManager.getDriver().findElements(byItemIdTextField).size() < 1) {
			SeleniumActions.click(byExpandItemIdfield, "Expand icon");
		}
		SeleniumActions.click(
				By.xpath("//div[contains(@data-component-id,'InventoryContainerTypeId')]/div//ion-checkbox[@data-component-id='"
						+ strContainerType + "']"),
				"Inventory Container Type");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to Store OnHand and Allocated Quantity in Inventory Details
	 */
	public static void storeInventoryDetails() {
		if (DriverManager.getDriver().findElements(byCheckboxList).size() > 0) {
			CommonMethods.scrollByParticularElement(byOnHandQuantity, "OnHandQuantity");
			String onHandQuantity = SeleniumActions.getText(byOnHandQuantity);
			String[] onHandQuantityUnit = onHandQuantity.split(" ", 0);
			Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "getOnHandQuantity", onHandQuantityUnit[0]);
			String onAllocatedQuantity = SeleniumActions.getText(byAllocatedQuantity);
			String[] onAllocatedQuantityUnit = onAllocatedQuantity.split(" ", 0);
			Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "getAllocatedQuantity",
					onAllocatedQuantityUnit[0]);
			Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "isInventoryPresent", "true");
		} else {
			Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "isInventoryPresent", "false");
		}
	}

	/**
	 * Function to verify Inventory Type
	 */
	public static void verifyInventoryType() {
		CommonMethods.scrollByParticularElement(byFinished, "Inventory Type");
		SeleniumActions.verifyElementVisible(byFinished, 10, "Inventory Type as Finished");
	}

	/**
	 * Function to Store On Hand Quantity And Allocated ]After Wave
	 */
	public static void storeOnHandAndAllocatedQuantityAfterWave() {
		CommonMethods.waitForPageLoading();
		CommonMethods.scrollByParticularElement(byOnHandQuantity, "OnHandQuantity");
		String onHandQuantityAfterWave = SeleniumActions.getText(byOnHandQuantity);
		String[] onHandQuantityUnitAfterWave = onHandQuantityAfterWave.split(" ", 0);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "getOnHandQuantityAfterWave",
				onHandQuantityUnitAfterWave[0]);
		String onAllocatedQuantityAfterWave = SeleniumActions.getText(byAllocatedQuantity);
		String[] onAllocatedQuantityUnitAfterWave = onAllocatedQuantityAfterWave.split(" ", 0);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "getAllocatedQuantityAfterWave",
				onAllocatedQuantityUnitAfterWave[0]);
	}

	/**
	 * Function to verify ProductStatus
	 */
	public static void verifyProductStatus() {
		CommonMethods.scrollByParticularElement(byQuarantine, "ProductStatus as Quarantine");
		SeleniumActions.verifyElementVisible(byQuarantine, 10, "ProductStatus as Quarantine");
	}

	/**
	 * Function to Store On Hand Quantity And Allocated Quantity After Wave
	 */
	/*
	 * public static void storeOnHandAndAllocatedQuantityAfterWave() {
	 * CommonMethods.waitForPageLoading();
	 * CommonMethods.scrollByParticularElement(byOnHandQuantity, "OnHandQuantity");
	 * String onHandQuantityAfterWave = SeleniumActions.getText(byOnHandQuantity);
	 * String[] onHandQuantityUnitAfterWave = onHandQuantityAfterWave.split(" ", 0);
	 * Variables.set(CurrentThreadInstance.getCurrentScenarioId() +
	 * "getOnHandQuantityAfterWave", onHandQuantityUnitAfterWave[0]); String
	 * onAllocatedQuantityAfterWave = SeleniumActions.getText(byAllocatedQuantity);
	 * String[] onAllocatedQuantityUnitAfterWave =
	 * onAllocatedQuantityAfterWave.split(" ", 0);
	 * Variables.set(CurrentThreadInstance.getCurrentScenarioId() +
	 * "getAllocatedQuantityAfterWave", onAllocatedQuantityUnitAfterWave[0]); }
	 */
	/**
	 * Function to Verify On Hand Quantity After Wave
	 */
	public static void verifyOnHandQuantityAfterWave() {
		CommonMethods.waitForPageLoading();
		if (Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "getOnHandQuantity").toString()
				.equals(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "getOnHandQuantityAfterWave")
						.toString())) {
			FrameworkLogger.log(LogType.PASS, "On Hand Quantity is Unchanged");
		} else {
			FrameworkLogger.log(LogType.FAIL, "On Hand Quantity is Changed");
		}
	}

	/**
	 * Function to Verify Allocated Quantity After Wave
	 */
	public static void verifyAllocatedQuantityAfterWave() {
		CommonMethods.scrollByParticularElement(byOnHandQuantity, "OnHandQuantity");
		CommonMethods.waitForPageLoading();
		int ExpectedallocatedQuantityAfterWave = (Integer.parseInt(
				Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "getAllocatedQuantity").toString())
				+ Integer.parseInt(getDataFromFeature("getdata(OrderedQuantity)")));
		int ActualallocatedQuantityAfterWave = Integer.parseInt(Variables
				.get(CurrentThreadInstance.getCurrentScenarioId() + "getAllocatedQuantityAfterWave").toString());
		if (ExpectedallocatedQuantityAfterWave == ActualallocatedQuantityAfterWave) {
			FrameworkLogger.log(LogType.PASS,
					"Allocated Quantity is Increased by " + getDataFromFeature("getdata(OrderedQuantity)"));
		} else {
			FrameworkLogger.log(LogType.FAIL,
					"Allocated Changed is not Increased by " + getDataFromFeature("getdata(OrderedQuantity)"));
		}
	}

	/**
	 * Function to Verify Allocated Quantity After Cancel Wave
	 */
	public static void verifyAllocatedQuantityAfterCancelWave() {
		CommonMethods.waitForPageLoading();
		int ExpectedallocatedQuantityAfterWave = Integer.parseInt(
				Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "getAllocatedQuantity").toString());
		int ActualallocatedQuantityAfterWave = Integer.parseInt(Variables
				.get(CurrentThreadInstance.getCurrentScenarioId() + "getAllocatedQuantityAfterWave").toString());
		if (ExpectedallocatedQuantityAfterWave == ActualallocatedQuantityAfterWave) {
			FrameworkLogger.log(LogType.PASS,
					"Allocated Quantity is Decreased by " + getDataFromFeature("getdata(OrderedQuantity)"));
		} else {
			FrameworkLogger.log(LogType.FAIL,
					"Allocated Changed is not Decreased by " + getDataFromFeature("getdata(OrderedQuantity)"));
		}
	}

	/**
	 * Function to Search Display Location
	 *
	 * @param strLocation - Display Location which need to searched
	 */
	public static void enterDisplayLocation(String strLocation) {
		if (DriverManager.getDriver().findElements(byDisplayLocationTextField).size() < 1) {
			SeleniumActions.click(byExpandDisplayLocation, "Display Location Expand icon");
		}
		SeleniumActions.clear(byDisplayLocationTextField, "Display Location");
		CommonMethods.waitForPageLoading();
		SeleniumActions.sendTextToElement(byDisplayLocationTextField, strLocation, "Display Location");
		CommonMethods.waitForPageLoading();
		KeyboardActions.pressEnterKey(byDisplayLocationTextField);
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click confirm button in WM mOBILE SCREEN
	 */
	public static void clickConfirmButton() {
		try {
			WebElement ele = DriverManager.getDriver().findElement(byClickConfirm);
			boolean iselepresent = ele.isDisplayed();
			if (iselepresent) {
				CommonMethods.waitForPageLoading();
				SeleniumActions.click(byClickConfirm, "Confirm button");
			} else {
				System.out.println("Ele not present");
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Function to click on end count button
	 */
	public static void clickEndCountButton() {
		SeleniumActions.click(byEndCountButton, "End Count button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to expand filter
	 */
	public static void ExpandFilter() {
		try {
			WebElement ele = DriverManager.getDriver().findElement(byExpandFilter);
			boolean iselepresent = ele.isDisplayed();

			if (iselepresent) {
				CommonMethods.waitForPageLoading();
				SeleniumActions.click(byExpandFilter, "Expand Filter");
			} else {
				System.out.println("Ele not present");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Function to store expiry date
	 */
	public static void StoreExpiryDate() {
		WebElement element = DriverManager.getDriver().findElement(byExpiryDate);

		String text = element.getText().trim();
		// text=text.replaceAll("/","");
		FrameworkLogger.log(LogType.INFO, "Expiry Date in variable:- " + text);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "StoreExpiryDate", text);
	}

	/**
	 * Function to Store On Hand Quantity And Allocated Quantity After Wave
	 * @param i = index i
	 */
	public static void storeOnHandAndAllocatedQuantityAfterWave1(int i) {
		CommonMethods.waitForPageLoading();
		CommonMethods.scrollByParticularElement(byOnHandQuantity, "OnHandQuantity");
		String onHandQuantityAfterWave = SeleniumActions.getText(byOnHandQuantity);
		String[] onHandQuantityUnitAfterWave = onHandQuantityAfterWave.split(" ", 0);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "getOnHandQuantityAfterWave" + i + "",
				onHandQuantityUnitAfterWave[0]);
		String onAllocatedQuantityAfterWave = SeleniumActions.getText(byAllocatedQuantity);
		String[] onAllocatedQuantityUnitAfterWave = onAllocatedQuantityAfterWave.split(" ", 0);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "getAllocatedQuantityAfterWave" + i + "",
				onAllocatedQuantityUnitAfterWave[0]);
	}

	/**
	 * Function to Verify On Hand Quantity After Wave
	 */
	public static void verifyOnHandQuantityAfterWave1(int i) {
		CommonMethods.waitForPageLoading();
		if (Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "getOnHandQuantity" + i + "").toString()
				.equals(Variables
						.get(CurrentThreadInstance.getCurrentScenarioId() + "getOnHandQuantityAfterWave" + i + "")
						.toString())) {
			FrameworkLogger.log(LogType.PASS, "On Hand Quantity is Unchanged");
		} else {
			FrameworkLogger.log(LogType.FAIL, "On Hand Quantity is Changed");
		}
	}

	/**
	 * Function to Verify Allocated Quantity After Wave
	 */
	public static void verifyAllocatedQuantityAfterWave1(int i) {
		CommonMethods.scrollByParticularElement(byOnHandQuantity, "OnHandQuantity");
		CommonMethods.waitForPageLoading();
		int ExpectedAllocatedQuantityAfterWave = (Integer.parseInt(Variables
				.get(CurrentThreadInstance.getCurrentScenarioId() + "getAllocatedQuantity" + i + "").toString())
				+ Integer.parseInt(getDataFromFeature("getdata(Order_Line_Quantity" + i + ")")));
		int ActualAllocatedQuantityAfterWave = Integer.parseInt(
				Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "getAllocatedQuantityAfterWave" + i + "")
						.toString());
		if (ExpectedAllocatedQuantityAfterWave == ActualAllocatedQuantityAfterWave) {
			FrameworkLogger.log(LogType.PASS, "Allocated Quantity is Increased by "
					+ getDataFromFeature("getdata(Order_Line_Quantity" + i + ")"));
		} else {
			FrameworkLogger.log(LogType.FAIL, "Allocated Changed is not Increased by "
					+ getDataFromFeature("getdata(Order_Line_Quantity" + i + ")"));
		}
	}

	/**
	 * Function to Verify Allocated Quantity After Cancel Wave
	 */
	public static void verifyAllocatedQuantityAfterCancelWave1(int i) {
		CommonMethods.waitForPageLoading();
		int ExpectedallocatedQuantityAfterWave = Integer.parseInt(Variables
				.get(CurrentThreadInstance.getCurrentScenarioId() + "getAllocatedQuantity" + i + "").toString());
		int ActualallocatedQuantityAfterWave = Integer.parseInt(
				Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "getAllocatedQuantityAfterWave" + i + "")
						.toString());
		if (ExpectedallocatedQuantityAfterWave == ActualallocatedQuantityAfterWave) {
			FrameworkLogger.log(LogType.PASS, "Allocated Quantity is Decreased by "
					+ getDataFromFeature("getdata(Order_Line_Quantity" + i + ")"));
		} else {
			FrameworkLogger.log(LogType.FAIL, "Allocated Changed is not Decreased by "
					+ getDataFromFeature("getdata(Order_Line_Quantity" + i + ")"));
		}
	}

	/**
	 * Function to Store OnHand and Allocated Quantity in Inventory Details
	 */
	public static void storeInventoryDetailsForBatch(int i) {
		if (DriverManager.getDriver().findElements(byCheckboxList).size() > 0) {
			CommonMethods.scrollByParticularElement(byOnHandQuantity, "OnHandQuantity");
			String onHandQuantity = SeleniumActions.getText(byOnHandQuantity);
			String[] onHandQuantityUnit = onHandQuantity.split(" ", 0);
			Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "getOnHandQuantity" + i + "",
					onHandQuantityUnit[0]);
			String onAllocatedQuantity = SeleniumActions.getText(byAllocatedQuantity);
			String[] onAllocatedQuantityUnit = onAllocatedQuantity.split(" ", 0);
			Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "getAllocatedQuantity" + i + "",
					onAllocatedQuantityUnit[0]);
			Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "isInventoryPresentForBatch" + i + "", "true");
		} else {
			Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "isInventoryPresentForBatch" + i + "",
					"false");
		}
	}

	/**
	 * Function to click continue action button on WM Mobile Cycle count screen
	 */
	public static void clickcontinuecountactionButton() {
		try {
			WebElement ele = DriverManager.getDriver().findElement(byConfirmaction);
			boolean iselepresent = ele.isDisplayed();

			if (iselepresent) {
				CommonMethods.waitForPageLoading();
				SeleniumActions.click(byConfirmaction, "Confirm button");
			} else {
				System.out.println("Ele not present");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Function to select first row in inventory details page
	 *
	 */
	public static void setByselectinvfirstrow() {
		WebElement element = DriverManager.getDriver().findElement(byselectinvfirstrow);
		SeleniumActions.click(byselectinvfirstrow, "select inventory first row");
		FrameworkLogger.log(LogType.INFO, "Select particular inventory");
	}

	/**
	 * Function to validate value in the cell table
	 * @params LocationBarcode - value to verify
	 * @params ItemBarcode - value to verify
	 */
	public static void validateLocationBarcodeAndItemBarcode(String LocationBarcode, String ItemBarcode) {
		SeleniumActions.verifyElementExist(bylocationitemvalue, 5, "Item Value should be displayed");
		By by = By.xpath("(//datatable-header-cell[@role='columnheader'])");
		List<WebElement> header = DriverManager.getDriver().findElements(by);
		int i = header.size();
		for (i = 2; i >= 0 && i <= 64; i++) {
			WebElement ele = DriverManager.getDriver()
					.findElement(By.xpath("(//datatable-header-cell[@role='columnheader'])[" + i + "]"));
			if (ele.getAttribute("title").trim().equalsIgnoreCase("Location Barcode")) {
				WebElement ele1 = DriverManager.getDriver().findElement(By.xpath("(//div[@class='datatable-body-cell-label']//div)[" + i + "-1]"));
				CommonMethods.scrollByParticularElement(ele1, "Location Barcode");

				if (ele1.getText().trim().equals(LocationBarcode)) {
					FrameworkLogger.log(LogType.PASS, "Location Barcode is displayed. Value: " + LocationBarcode);
				} else {
					FrameworkLogger.log(LogType.FAIL, "Location Barcode is NOT displayed. Expected :+" + LocationBarcode + " , Actual :" + ele1.getText().trim());
				}
			}
			if (ele.getAttribute("title").trim().equalsIgnoreCase("Item Barcode")) {
				WebElement ele2 = DriverManager.getDriver().findElement(By.xpath("(//div[@class='datatable-body-cell-label']//div)[" + i + "-1]"));
				CommonMethods.scrollByParticularElement(ele2, "Item Barcode");

				if (ele2.getText().trim().equals(ItemBarcode)) {
					FrameworkLogger.log(LogType.PASS, "Item Barcode is displayed. Value: " +ItemBarcode);
				} else {
					FrameworkLogger.log(LogType.FAIL, "Item Barcode is NOT displayed. Expected :+" + ItemBarcode + " , Actual :" + ele2.getText().trim());
				}
			}
		}
	}

	/**
	 * Function to verify LPNDetails in InventoryDetailsPage
	 */
	public static void verifyLPNDetailsInventoryDetailsPage() {
		String lpn = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "LPN");
		String lpnStatus = getDataFromFeature("getdata(LPNStatus)");
		String inventoryType = getDataFromFeature("getdata(InventoryTypeDescription)");
		String productStatus = getDataFromFeature("getdata(ProductStatus)");
		String quantity = getDataFromFeature("getdata(OnHandQuantity)");
		verifyInventoryContainer(lpn);
		verifyLPNStatus(lpnStatus);
		verifyOnHandQuantityCellValue(quantity);
		verifyProductStatus(productStatus);
		verifyInventoryType(inventoryType);
	}

	/**
	 * Function to verify InventoryContainer
	 *
	 * @params text - value to verify
	 */
	public static void verifyInventoryContainer(String text) {
		String actualText = SeleniumActions.getText(byInventoryContainerCellValue);
		//SeleniumActions.verifyTextEquals(actualText, text, "InventoryContainer CellValue", false);
		SeleniumActions.verifyTextEquals(actualText, text, false);
	}

	/**
	 * Function to verify LPNStatus
	 *
	 * @params text - value to verify
	 */
	public static void verifyLPNStatus(String text) {
		String actualText = SeleniumActions.getText(byLPNStatusCellValue);
		SeleniumActions.verifyTextEquals(actualText, text, false);
	}

	/**
	 * Function to verify OnHandQuantityCellValue
	 *
	 * @params text - value to verify
	 */
	public static void verifyOnHandQuantityCellValue(String text) {
		String actualText = SeleniumActions.getText(byOnHandQuantityCellValue);
		SeleniumActions.verifyTextContains(actualText, text,  false);
	}

	/**
	 * Function to verify InventoryType
	 *
	 * @params text - value to verify
	 */
	public static void verifyInventoryType(String text) {
		String actualText = SeleniumActions.getText(byInventoryTypeCellValue);
		SeleniumActions.verifyTextEquals(actualText, text, false);
	}

	/**
	 * Function to verify ProductStatus
	 *
	 * @params text - value to verify
	 */
	public static void verifyProductStatus(String text) {
		String actualText = SeleniumActions.getText(byProductStatusCellValue);
		SeleniumActions.verifyTextEquals(actualText, text, false);
	}

	/**
	 * Function to adjust ProductStatus
	 *
	 * @params text - value to adjust
	 */
	public static void adjustProductStatus(String adjustProductStatus) {
		String reasonCode = getDataFromFeature("getdata(ReasonCode)");
		String referenceCode = getDataFromFeature("getdata(ReferenceCode)");
		String errorMessage = getDataFromFeature("getdata(ErrorMessage)");
		if (adjustProductStatus.equalsIgnoreCase("Damaged")) {
			SeleniumActions.checkSingleCheckbox(byCheckboxList, "Checkbox");
			FooterPanelPage.clickMoreButton();
			FooterPanelPage.clickAdjustProductStatus();
			AdjustProductStatusPopup.selectProductStatus(adjustProductStatus);
			AdjustProductStatusPopup.selectReasonCode(reasonCode);
			AdjustProductStatusPopup.enterReferenceCode(referenceCode);
			CommonPopupPage.clickSubmitButton();
		}
		if (adjustProductStatus.equalsIgnoreCase("Available")) {
			SeleniumActions.checkSingleCheckbox(byCheckboxList, "Checkbox");
			FooterPanelPage.clickMoreButton();
			FooterPanelPage.clickAdjustProductStatus();
			AdjustProductStatusPopup.selectProductStatus(adjustProductStatus);
			AdjustProductStatusPopup.selectReasonCode(reasonCode);
			AdjustProductStatusPopup.enterReferenceCode(referenceCode);
			CommonPopupPage.clickSubmitButton();
			CommonPopupPage.verifyToastMessageContains(errorMessage);
			CommonPopupPage.clickDismissButton();
		}
		if (adjustProductStatus.equalsIgnoreCase("Inspection")) {
			AdjustProductStatusPopup.selectProductStatus(adjustProductStatus);
			AdjustProductStatusPopup.selectReasonCode(reasonCode);
			AdjustProductStatusPopup.enterReferenceCode(referenceCode);
			CommonPopupPage.clickSubmitButton();
		}
	}

	/**
	 * Function to click continuecount action button in WM mOBILE SCREEN
	 */
	public static void clickContinuecountactionButton() {
		try {

			WebElement ele1 = DriverManager.getDriver().findElement(byCompleteCountAction);
			boolean iselepresent1 = ele1.isDisplayed();

			if (iselepresent1) {
				CommonMethods.waitForPageLoading();
				SeleniumActions.click(byCompleteCountAction, "Continue Count Action");
			} else {
				System.out.println("Continue count action Ele not present");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Function to select Location type
	 *
	 * @param strLocationType - Type which need to searched
	 */
	public static void filterLocationType(String strLocationType) {
		CommonMethods.waitForPageLoading();
		if (DriverManager.getDriver().findElements(byItemIdTextField).size() < 1) {
			SeleniumActions.click(byExpandItemIdfield, "Expand icon");
		}
		SeleniumActions
				.click(By.xpath("//div[contains(@data-component-id,'LocationTypeId')]/div//ion-checkbox[@data-component-id='"
						+ strLocationType + "']"), "Location type");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to verify Multiple Item Details in InventoryDetailsPage
	 */
	public static void verifyMultipleItemDetailsInventoryDetailsPage() {
		String items = getDataFromFeature("getdata(Items)");
		String inventoryType = getDataFromFeature("getdata(InventoryType)");
		String productStatus = getDataFromFeature("getdata(ProductStatus)");
		String lpnStatus = getDataFromFeature("getdata(LPNStatus)");
		String quantity = null;
		String locationBarCode = null;
		String item = null;
		int j, k = 0;
		for (int i = 0; i < items.split(",").length; i++) {
			j = i + 1;
			k = i + 2;
			item = getDataFromFeature("getdata(Item" + j + ")");
			locationBarCode = getDataFromFeature("getdata(LocationBarCode" + j + ")");
			quantity = getDataFromFeature("getdata(Quantity" + j + ")");

			String actualLPNStatus = DriverManager.getDriver().findElement(By.xpath(
							"((//div[contains(@class,'datatable-row-center')])[" + k + "]//datatable-body-cell)[8]/div[1]/div"))
					.getText();
			SeleniumActions.verifyTextContains(
actualLPNStatus, lpnStatus,  false);

			String actualOnHandQuantity = DriverManager.getDriver()
					.findElement(By.xpath("((//div[contains(@class,'datatable-row-center')])[" + k
							+ "]//datatable-body-cell)[10]/div[1]/div"))
					.getText();
			actualOnHandQuantity = actualOnHandQuantity.replaceAll("UNIT", "").trim();
			CommonMethods.verifyValue(actualOnHandQuantity, quantity, "OnHandQuantity CellValue", "GreaterThanOrEqual");

			String actualItem = DriverManager.getDriver()
					.findElement(By.xpath("((//div[contains(@class,'datatable-row-center')])[" + k
							+ "]//datatable-body-cell)[30]/div[1]/div"))
					.getText();
			SeleniumActions.verifyTextContains(
actualItem, item,  false);

			String actualLocationBarCode = DriverManager.getDriver()
					.findElement(By.xpath("((//div[contains(@class,'datatable-row-center')])[" + k
							+ "]//datatable-body-cell)[33]/div[1]/div"))
					.getText();
			SeleniumActions.verifyTextContains(
actualLocationBarCode, locationBarCode,
					false);

			String actualInventoryType = DriverManager.getDriver()
					.findElement(By.xpath("((//div[contains(@class,'datatable-row-center')])[" + k
							+ "]//datatable-body-cell)[34]/div[1]/div"))
					.getText();
			SeleniumActions.verifyTextContains(
actualInventoryType, inventoryType,  false);

			String actualProductStatus = DriverManager.getDriver()
					.findElement(By.xpath("((//div[contains(@class,'datatable-row-center')])[" + k
							+ "]//datatable-body-cell)[35]/div[1]/div"))
					.getText();
			SeleniumActions.verifyTextContains(
actualProductStatus, productStatus,  false);

		}

		CommonMethods.scrollByParticularElement(byLPNStatusCellValue, "LPN Status Cell Value");

		String actualLPNStatus = DriverManager.getDriver().findElement(By.xpath(
						"((//div[contains(@class,'datatable-row-center')])[" + k + "]//datatable-body-cell)[8]/div[1]/div"))
				.getText();
		SeleniumActions.verifyTextContains(
actualLPNStatus, lpnStatus,  false);

		CommonMethods.scrollByParticularElement(byOnHandQuantityCellValue, "On Hand Quantity Cell Value");
		String actualOnHandQuantity = DriverManager.getDriver().findElement(By.xpath(
						"((//div[contains(@class,'datatable-row-center')])[" + k + "]//datatable-body-cell)[10]/div[1]/div"))
				.getText();
		actualOnHandQuantity = actualOnHandQuantity.replaceAll("UNIT", "").trim();
		CommonMethods.verifyValue(actualOnHandQuantity, quantity, "OnHandQuantity CellValue", "GreaterThanOrEqual");

		CommonMethods.scrollByParticularElement(byItemCellValue, "Item CellValue");
		String actualItem = DriverManager.getDriver().findElement(By.xpath(
						"((//div[contains(@class,'datatable-row-center')])[" + k + "]//datatable-body-cell)[30]/div[1]/div"))
				.getText();
		SeleniumActions.verifyTextContains(
actualItem, item,  false);

		CommonMethods.scrollByParticularElement(byLocationBarCodeCellValue, "LocationBarCode CellValue");
		String actualLocationBarCode = DriverManager.getDriver().findElement(By.xpath(
						"((//div[contains(@class,'datatable-row-center')])[" + k + "]//datatable-body-cell)[33]/div[1]/div"))
				.getText();
		SeleniumActions.verifyTextContains(
actualLocationBarCode, locationBarCode,  false);

		CommonMethods.scrollByParticularElement(byInventoryTypeCellValue, "InventoryType CellValue");
		String actualInventoryType = DriverManager.getDriver().findElement(By.xpath(
						"((//div[contains(@class,'datatable-row-center')])[" + k + "]//datatable-body-cell)[34]/div[1]/div"))
				.getText();
		SeleniumActions.verifyTextContains(
actualInventoryType, inventoryType,  false);

		CommonMethods.scrollByParticularElement(byProductStatusCellValue, "ProductStatus CellValue");
		String actualProductStatus = DriverManager.getDriver().findElement(By.xpath(
						"((//div[contains(@class,'datatable-row-center')])[" + k + "]//datatable-body-cell)[35]/div[1]/div"))
				.getText();
		SeleniumActions.verifyTextContains(
actualProductStatus, productStatus,  false);
	}

	/**
	 * Function to Extract list of Serial Numbers to Variables
	 */
	public static void extractListOfSerialNumbers() {
		String items = getDataFromFeature("getdata(Items)");
		String inventoryType = getDataFromFeature("getdata(InventoryType)");
		String productStatus = getDataFromFeature("getdata(ProductStatus)");
		String lpnStatus = getDataFromFeature("getdata(LPNStatus)");
		String quantity = null;
		String locationBarCode = null;
		String item = null;
		int j, k = 0;
		for (int i = 0; i < items.split(",").length; i++) {
			j = i + 1;
			k = i + 2;
			item = getDataFromFeature("getdata(Item" + j + ")");
			locationBarCode = getDataFromFeature("getdata(LocationBarCode" + j + ")");
			quantity = getDataFromFeature("getdata(Quantity" + j + ")");
			String actualItem = DriverManager.getDriver()
					.findElement(By.xpath("((//div[contains(@class,'datatable-row-center')])[" + k
							+ "]//datatable-body-cell)[30]/div[1]/div"))
					.getText();
			SeleniumActions.verifyTextContains(
actualItem, item,  false);

			String actualLocationBarCode = DriverManager.getDriver()
					.findElement(By.xpath("((//div[contains(@class,'datatable-row-center')])[" + k
							+ "]//datatable-body-cell)[33]/div[1]/div"))
					.getText();
			SeleniumActions.verifyTextContains(
actualLocationBarCode, locationBarCode,
					false);

			String actualInventoryType = DriverManager.getDriver()
					.findElement(By.xpath("((//div[contains(@class,'datatable-row-center')])[" + k
							+ "]//datatable-body-cell)[34]/div[1]/div"))
					.getText();
			SeleniumActions.verifyTextContains(
actualInventoryType, inventoryType,  false);

			String actualProductStatus = DriverManager.getDriver()
					.findElement(By.xpath("((//div[contains(@class,'datatable-row-center')])[" + k
							+ "]//datatable-body-cell)[35]/div[1]/div"))
					.getText();
			SeleniumActions.verifyTextContains(
actualProductStatus, productStatus,  false);
		}
	}

	/**
	 * Function to verify OnHandQuantity in InventoryDetailsPage
	 */
	public static void verifyOnHandQuantity() {
		String quantity = getDataFromFeature("getdata(Quantity)");
		String actualOnHandQuantity = DriverManager.getDriver()
				.findElement(byOnHandQuantityValue).getText();
		actualOnHandQuantity = actualOnHandQuantity.replaceAll("UNIT", "").trim();
		CommonMethods.verifyValue(actualOnHandQuantity, quantity, "OnHandQuantity CellValue", "GreaterThanOrEqual");
	}

	/**
	 * Function to verify OnHandQuantity in InventoryDetailsPage
	 */
	/*
	 * public static void verifyOnHandQuantity() { String quantity =
	 * getDataFromFeature("getdata(Quantity)"); String actualOnHandQuantity =
	 * DriverManager.getDriver() .findElement(By.xpath(
	 * "((//div[contains(@class,'datatable-row-center')])[2]//datatable-body-cell)[10]/div[1]/div"
	 * )) .getText(); actualOnHandQuantity = actualOnHandQuantity.replaceAll("UNIT",
	 * "").trim(); CommonMethods.verifyValue(actualOnHandQuantity, quantity,
	 * "OnHandQuantity CellValue", "GreaterThanOrEqual"); }
	 */

	/**
	 * Function to verify the updated quantity
	 */
	public static void validateUpdatedQuantity() {
		CommonMethods.scrollByParticularElement(byOnHandQuantity, "OnHandQuantity");
		CommonMethods.waitForPageLoading();
		String strCurrentQuantity = SeleniumActions.getText(byOnHandQuantity);
		if (strCurrentQuantity != null && !strCurrentQuantity.trim().isEmpty()) {
			strCurrentQuantity.replace(" UNIT", "");
			if (strCurrentQuantity.equals(
					Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "CurrentOnhandQuantity").toString())) {
			}
			FrameworkLogger.log(LogType.PASS, "Current Quantity is " + strCurrentQuantity);
		} else {
			FrameworkLogger.log(LogType.FAIL, "Current Quantity is updated");
		}
	}

	/**
	 * Function to verify item details , inventory details for multiple items
	 */
	public static void verifyMultipleItemDetailsInventoryDetailsPage_FromListOfItems() {
		String items = getDataFromFeature("getdata(Items)");
		String inventoryType = getDataFromFeature("getdata(InventoryType)");
		String productStatus = getDataFromFeature("getdata(ProductStatus)");
		String quantity = null;
		String locationBarCode = null;
		String item = null;
		String[] splitItems = items.split(",");
		String actualItem;
		int j, k = 0;
		for (int i = 0; i < splitItems.length; i++) {
			j = i + 1;
			k = i + 2;
			locationBarCode = getDataFromFeature("getdata(LocationBarCode" + j + ")");
			quantity = getDataFromFeature("getdata(Quantity" + j + ")");

			CommonMethods.scrollByParticularElement(byItemCellValue, "Item CellValue");
			actualItem = DriverManager.getDriver()
					.findElement(By.xpath("((//div[contains(@class,'datatable-row-center')])[" + k
							+ "]//datatable-body-cell)[30]/div[1]/div"))
					.getText();
			SeleniumActions.verifyTextContains(
actualItem, splitItems[i],  false);

			CommonMethods.scrollByParticularElement(byOnHandQuantityCellValue, "On Hand Quantity Cell Value");
			String actualOnHandQuantity = DriverManager.getDriver()
					.findElement(By.xpath("((//div[contains(@class,'datatable-row-center')])[" + k
							+ "]//datatable-body-cell)[10]/div[1]/div"))
					.getText();
			actualOnHandQuantity = actualOnHandQuantity.replaceAll("UNIT", "").trim();
			CommonMethods.verifyValue(actualOnHandQuantity, quantity, "OnHandQuantity CellValue", "GreaterThanOrEqual");

			CommonMethods.scrollByParticularElement(byLocationBarCodeCellValue, "LocationBarCode CellValue");
			String actualLocationBarCode = DriverManager.getDriver()
					.findElement(By.xpath("((//div[contains(@class,'datatable-row-center')])[" + k
							+ "]//datatable-body-cell)[33]/div[1]/div"))
					.getText();
			SeleniumActions.verifyTextContains(
actualLocationBarCode, locationBarCode,
					false);

			CommonMethods.scrollByParticularElement(byInventoryTypeCellValue, "InventoryType CellValue");
			String actualInventoryType = DriverManager.getDriver()
					.findElement(By.xpath("((//div[contains(@class,'datatable-row-center')])[" + k
							+ "]//datatable-body-cell)[34]/div[1]/div"))
					.getText();
			SeleniumActions.verifyTextContains(
actualInventoryType, inventoryType, false);

			CommonMethods.scrollByParticularElement(byProductStatusCellValue, "ProductStatus CellValue");
			String actualProductStatus = DriverManager.getDriver()
					.findElement(By.xpath("((//div[contains(@class,'datatable-row-center')])[" + k
							+ "]//datatable-body-cell)[35]/div[1]/div"))
					.getText();
			SeleniumActions.verifyTextContains(
actualProductStatus, productStatus,  false);

		}

	}

	/**
	 * Function to filter inventory reservation type
	 * @param strInventoryReservationType - inventory reservation type
	 */
	public static void filterInventoryReservationType(String strInventoryReservationType) {
		CommonMethods.waitForPageLoading();
		if (DriverManager.getDriver().findElements(byItemIdTextField).size() < 1) {
			SeleniumActions.click(byExpandItemIdfield, "Expand icon");
		}
		SeleniumActions.click(
				By.xpath("//div[@data-component-id='InventoryReservationTypeId']/div//ion-checkbox[@data-component-id='"
						+ strInventoryReservationType + "']"),
				"Location type");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to store serial number to list
	 */
	public static void storeSerialNumberToList() {
		List<WebElement> listOfElements = DriverManager.getDriver().findElements(byInventoryAttributesAttributeValue);
		List<String> listOfSerialNumbers = new ArrayList<>();
		for (WebElement element : listOfElements) {
			listOfSerialNumbers.add(element.getText().trim());
		}
		FrameworkLogger.log(LogType.INFO, "Serial Number stored in variables:- " + listOfSerialNumbers);
		System.out.println("Serial Number stored in variables:- " + listOfSerialNumbers);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "listOfSerialNumbers", listOfSerialNumbers);
	}

	/**
	 * Function to validate quantity
	 */
	public static void validateOriginalAndCountQuantitiesMatch() {
		String OriginalQuantity = SeleniumActions.getText(byOriginalQuantityDisplay).trim();
		String CountQuantity = SeleniumActions.getText(byCountQuantityDisplay).trim();
		SeleniumActions.verifyTextEquals(OriginalQuantity, CountQuantity);
	}

	/**
	 * Function to validate VarianceQuantity with 0 Unit
	 */
	public static void validateVarianceQuantityMatchesZero() {
		String VarianceQuantity = SeleniumActions.getText(byVarianceQuantityDisplay).trim();
		SeleniumActions.verifyTextEquals(VarianceQuantity, "0 UNIT");
	}

	/**
	 * Function to verify Inventory details Cell value for Each Items
	 */
	public static void verifyInventoryDetailsCellValueForEachItems() {
		String listOfItems = getDataFromFeature("getdata(Items)");

		List<String> expectedItems = new ArrayList<String>(Arrays.asList(listOfItems.split(",")));

		for (String singleItem: expectedItems){
			final By byListOfItems = By.xpath("(//*[@title='"+singleItem+"'])[1]");

			CommonMethods.waitForPageLoading();
			if (DriverManager.getDriver().findElements(byItemTextField).size() < 1) {
				SeleniumActions.click(byExpandItemField, "Expand icon");
			}
			SeleniumActions.getElement(byItemTextField).clear();
			SeleniumActions.sendTextToElement(byItemTextField, singleItem, "Item ID Text Field");
			CommonMethods.waitForPageLoading();
			KeyboardActions.pressEnterKey(byItemTextField);
			CommonMethods.waitForPageLoading();

			CommonMethods.scrollByParticularElement(byOnHandQuantity, "OnHandQuantity");
			String onHandQuantity = SeleniumActions.getText(byOnHandQuantity);
			String[] onHandQuantityUnit = onHandQuantity.split(" ", 0);
			Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "getOnHandQuantity", onHandQuantityUnit[0]);
			int valueonHandQuantityUnit=Integer.parseInt(onHandQuantityUnit[0]);
			if (valueonHandQuantityUnit > 0) {
				FrameworkLogger.log(LogType.PASS, "On Hand Quantity is Greater than 0 and on Hand Quantity is: " + valueonHandQuantityUnit);
			}
			CommonMethods.waitForPageLoading();
			CommonMethods.scrollByParticularElement(byListOfItems, "Item CellValue");
			String actualItemId = DriverManager.getDriver().findElement(byListOfItems).getText();
			SeleniumActions.verifyTextContains(
actualItemId, singleItem,  false);

		}

	}

	/**
	 * Function to store inventory container number
	 */
	public static void storeInventoryContainerNumberToString() {
		WebElement element = DriverManager.getDriver().findElement(byILPNInventoryContainerNumber);
		String text = element.getText().trim();
		FrameworkLogger.log(LogType.INFO, "Current Inventory container ILPN in variable:- " + text);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "Inventory Container ILPN", text);
		System.out.println("Inventory Container stored in variables:- " + text);
	}
	/**
	 * Function to verify lpn details , inventory details
	 */
	public static void verifyLPNDetailsInventoryDetailsPagewithLocation() {
		String inventoryType = getDataFromFeature("getdata(InventoryTypeDescription)");
		String productStatus = getDataFromFeature("getdata(ProductStatus)");
		CommonMethods.waitForPageLoading();
		verifyInventoryContainer(getDataFromFeature(getData("InventoryContainer")));
		if(!SeleniumActions.getText(byOnHandQuantity).isEmpty()){
			FrameworkLogger.log(LogType.INFO, "On hand quantity is not empty");
		}
		verifyProductStatus(productStatus);
		verifyInventoryType(inventoryType);
	}

	/**
	 * Function to verify Inventory details, location barcode
	 */
	public static void verifyInventoryDetailsLocationBarcode() {
		String inventoryType = getDataFromFeature("getdata(ScanLocation)");
        final By byLocationBarcode = By.xpath("(//*[@title='"+inventoryType+"'])[1]");
		CommonMethods.scrollByParticularElement(byLocationBarcode, "Location Barcode CellValue");
		String actualInventoryType = DriverManager.getDriver().findElement(byLocationBarcode).getText();
		SeleniumActions.verifyTextContains(
actualInventoryType, inventoryType,  false);

	}

	/**
	 * Function to verify inventory details for multiple items
	 */
	public static void verifyMultipleItemDetailsInventoryDetailsPage_FromItems() {
		String items = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "Item");
		String inventoryType = getDataFromFeature("getdata(InventoryType)");
		String productStatus = getDataFromFeature("getdata(ProductStatus)");
		String quantity = null;
		String item = null;
		String[] splitItems = items.split(",");
		String actualItem;
		int j, k = 0;
		for (int i = 0; i < splitItems.length; i++) {
			j = i + 1;
			k = i + 2;
			String locationBarCode = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "Location".replaceAll("-", ""));

			quantity = getDataFromFeature("getdata(Quantity" + j + ")");

			CommonMethods.scrollByParticularElement(byItemCellValue, "Item CellValue");
			actualItem = DriverManager.getDriver()
					.findElement(By.xpath("((//div[contains(@class,'datatable-row-center')])[" + k
							+ "]//datatable-body-cell)[30]/div[1]/div"))
					.getText();
			SeleniumActions.verifyTextContains(
actualItem, splitItems[i],  false);

			CommonMethods.scrollByParticularElement(byOnHandQuantityCellValue, "On Hand Quantity Cell Value");
			String actualOnHandQuantity = DriverManager.getDriver()
					.findElement(By.xpath("((//div[contains(@class,'datatable-row-center')])[" + k
							+ "]//datatable-body-cell)[10]/div[1]/div"))
					.getText();
			actualOnHandQuantity = actualOnHandQuantity.replaceAll("UNIT", "").trim();
			CommonMethods.verifyValue(actualOnHandQuantity, quantity, "OnHandQuantity CellValue", "GreaterThanOrEqual");

			CommonMethods.scrollByParticularElement(byInventoryTypeCellValue, "InventoryType CellValue");
			String actualInventoryType = DriverManager.getDriver()
					.findElement(By.xpath("((//div[contains(@class,'datatable-row-center')])[" + k
							+ "]//datatable-body-cell)[34]/div[1]/div"))
					.getText();
			SeleniumActions.verifyTextContains(
actualInventoryType, inventoryType, false);

			CommonMethods.scrollByParticularElement(byProductStatusCellValue, "ProductStatus CellValue");
			String actualProductStatus = DriverManager.getDriver()
					.findElement(By.xpath("((//div[contains(@class,'datatable-row-center')])[" + k
							+ "]//datatable-body-cell)[35]/div[1]/div"))
					.getText();
			SeleniumActions.verifyTextContains(
actualProductStatus, productStatus, false);

		}

	}
	public static void verifyMultipleItemDetailsInInventoryDetailsPage() {
		String items = getDataFromFeature("getdata(Items)");
		String inventoryType = getDataFromFeature("getdata(InventoryType)");
		String productStatus = getDataFromFeature("getdata(ProductStatus)");
		String quantity = null;
		String locationBarCode = null;
		String item = null;
		String[] splitItems = items.split(",");
		String actualItem;
		int j, k = 0;
		for (int i = 0; i < splitItems.length; i++) {
			j = i + 1;
			k = i + 2;
			locationBarCode = getDataFromFeature("getdata(LocationBarCode" + j + ")");
			quantity = getDataFromFeature("getdata(Quantity" + j + ")");

			CommonMethods.scrollByParticularElement(byItemCellValue, "Item CellValue");
			actualItem = DriverManager.getDriver()
					.findElement(By.xpath("((//div[contains(@class,'datatable-row-center')])[" + k
							+ "]//datatable-body-cell)[30]/div[1]/div"))
					.getText();
			SeleniumActions.verifyTextContains(
actualItem, splitItems[i],  false);

			CommonMethods.scrollByParticularElement(byOnHandQuantityCellValue, "On Hand Quantity Cell Value");
			String actualOnHandQuantity = DriverManager.getDriver()
					.findElement(By.xpath("((//div[contains(@class,'datatable-row-center')])[" + k
							+ "]//datatable-body-cell)[10]/div[1]/div"))
					.getText();
			System.out.println(actualOnHandQuantity);
			FrameworkLogger.log(LogType.INFO, "Current On Hand Quantity:- " + actualOnHandQuantity);

			//CommonMethods.getData(actualOnHandQuantity);
//			actualOnHandQuantity = actualOnHandQuantity.replaceAll("UNIT", "").trim();
//			CommonMethods.verifyValue(actualOnHandQuantity, quantity, "OnHandQuantity CellValue", "GreaterThanOrEqual");

			CommonMethods.scrollByParticularElement(byLocationBarCodeCellValue, "LocationBarCode CellValue");
			String actualLocationBarCode = DriverManager.getDriver()
					.findElement(By.xpath("((//div[contains(@class,'datatable-row-center')])[" + k
							+ "]//datatable-body-cell)[33]/div[1]/div"))
					.getText();
			SeleniumActions.verifyTextContains(
actualLocationBarCode, locationBarCode,
					false);

			CommonMethods.scrollByParticularElement(byInventoryTypeCellValue, "InventoryType CellValue");
			String actualInventoryType = DriverManager.getDriver()
					.findElement(By.xpath("((//div[contains(@class,'datatable-row-center')])[" + k
							+ "]//datatable-body-cell)[34]/div[1]/div"))
					.getText();
			SeleniumActions.verifyTextContains(
actualInventoryType, inventoryType,  false);

			CommonMethods.scrollByParticularElement(byProductStatusCellValue, "ProductStatus CellValue");
			String actualProductStatus = DriverManager.getDriver()
					.findElement(By.xpath("((//div[contains(@class,'datatable-row-center')])[" + k
							+ "]//datatable-body-cell)[35]/div[1]/div"))
					.getText();
			SeleniumActions.verifyTextContains(
actualProductStatus, productStatus,  false);

		}

	}

}