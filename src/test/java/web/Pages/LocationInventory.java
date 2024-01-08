package web.Pages;

import java.util.List;

import org.openqa.selenium.By;

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
public class LocationInventory extends TestData_Json {
	private static final By byClearAllBtn = By.xpath("//button[contains(@data-component-id,'clear-all-btn')]");
	private static final By byLocationInventoryPage = By.xpath("//span[contains(text(),'Location Inventory')]");
	private static final By byDisplayLocationField = By
			.xpath("//ion-input[contains(@data-component-id,'DisplayLocation')]/input");
	private static final By byExpandDisplayLocationfield = By.xpath(
			"//span[@title='Display location']/following-sibling::ion-button[contains(@data-component-id,'expand-button')]");
	private static final By byRelatedLinks = By.xpath("//*[contains(text(),'Related Links')]");
	private static final By byStorageLocation = By.xpath("//*[text()='Storage Location']");
	private static final By byInventoryDetails = By.xpath("//*[text()='Inventory details']");
	private static final By byFirstlocationinList = By.xpath("(//a[contains(@data-component-id,'displaylocation-link')])[1]");
	private static final By byFirstCurrentQuantity = By.xpath(
			"(//span[contains(text(),'Current Quantity')]//parent::div/following-sibling::div/span[contains(@data-component-id,'UNIT')])[1]");
	private static final By byMoreActionsBtn = By.xpath("//ion-button[@data-component-id='more-actions']");
	private static final By byAdjustBtn = By.xpath("//button[@data-component-id='Adjust-more-actions']");
	private static final By byInventryDetailsCheckbox = By.xpath("//datatable-body//input[@type='checkbox']");
	private static final By byiLPNS = By.xpath("//a[normalize-space()='iLPNs']");
	private static final By byILPNStatusNotAllocatedCheckbox = By
			.xpath("//ion-checkbox[contains(@data-component-id,'NotAllocated')]");
	private static final By byILPNSearchTextBox = By.xpath("//ion-input[contains(@data-component-id,'IlpnId')]//input");
	private static final By byWithoutCycleCountRowAtFirstIndex = By
			.xpath("//inventory-card[contains(@class,'display-card')]/div[contains(@class,'row main-card isChild')]");// Need finetune the xpath
	private static final By byWithoutCycleCountLocationAtFirstIndex = By
			.xpath("//inventory-card[contains(@class,'display-card')]/div[contains(@class,'row main-card isChild')]/div[contains(@class,'space inventory')][not(div)]//preceding-sibling::div//a[contains(@data-component-id,'displaylocation')]");// Need
																														// finetune
																														// the
																														// xpath
	private static final By byWithoutCycleCountItemNameAtFirstIndex = By.xpath(
			"//inventory-card[contains(@class,'display-card')]//div[contains(@class,'space inventory')][not(div)]//preceding-sibling::div//span[contains(@data-component-id,'item-name')]");// Need
																																								// finetune
																																								// the
																																								// xpath
	private static final By byWithoutCycleCountMainArrowIconAtFirstIndex = By.xpath(
			"//div[contains(@class,'dm-flex-row-layout')]//ancestor::div[contains(@class,'cardContent')]//preceding-sibling::div//ion-button[contains(@class,'arrow-button')]");// Need
																																																			// finetune
																																																			// the
																																																			// xpath
	private static final By byWithoutCycleCountChildArrowIconAtFirstIndex = By
			.xpath("//ion-button[contains(@data-component-id,'show-details-btn')]");
	private static final By byWithoutCycleCountILPINIdAtFirstIndex = By
			.xpath("//span[normalize-space()='LPN:']//following-sibling::div[1]/span");
	private static final By byWithoutCycleCountILPINQuantityAtFirstIndex = By
			.xpath("//span[normalize-space()='On Hand Display:']//following-sibling::div/span");// Need finetune the
																									// xpath
	private static final By byWithoutCycleCountILPINDetailsIconAtRightSide = By
			.xpath("//ion-button[@data-component-id='lpn-details-icon-lpn']");
	private static final By byBatchNumberInPopup = By.xpath("//span[@data-component-id='batchnumber-content']");
	private static final By byCancelButtonInPopup = By.xpath("//button[contains(@data-component-id,'cancel-btn')]");
	private static final By byCycleCount = By.xpath("//button[contains(@data-component-id,'CycleCount')]");
	private static final By byLocationField = By.xpath("//ion-input[contains(@data-component-id,'LocationId')]/input");
	private static final By byExpandLocationfield = By
			.xpath("//span[@title='Location']/following-sibling::ion-button[contains(@data-component-id,'expand-button')]");
	private static final By byItemField = By.xpath("//ion-input[contains(@data-component-id,'ItemId')]/input");
	private static final By byExpandItemfield = By
			.xpath("//span[@title='Item']/following-sibling::ion-button[contains(@data-component-id,'expand-button')]");
	private static final By byLocationCycleCount = By
			.xpath("//ion-col/input[@data-component-id='acceptlocation_barcodetextfield_location']");
	private static final By byItemCycleCount = By
			.xpath("//ion-col/input[@data-component-id='acceptitem_barcodetextfield_item']");
	private static final By byClickConfirm = By.xpath("//span[contains(text(),'Confirm')]");
	private static final By byAlertmsg = By.xpath("//div[@class='alert-message sc-ion-alert-md']");
	private static final By byAlertConfirm = By.xpath("//span[text()='Confirm']");
	private static final By byScanLocationCycleCount = By.xpath("//input[@data-component-id='locationconfirmation_barcodetextfield_scanlocation']");
	private static final By byGoButton = By.xpath("//ion-button[@data-component-id='locationconfirmation_barcodetextfield_go']");
	private static final By byILPNCycleCount = By.xpath("//ion-col/input[@data-component-id='acceptilpn_barcodetextfield_ilpn']");

	/**
	 * Function to Verify Location Inventory Page is displayed
	 */
	public static void verifyLocationInventoryPageDisplayed() {
		SeleniumActions.verifyElementVisible(byLocationInventoryPage, 20, " Location Inventory page");
	}

	/**
	 * Function to search display location
	 * @param strText - search value
	 * @param bClick - give boolean value
	 */
	public static void searchDisplayLocation(String strText, boolean bClick) {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byClearAllBtn, "Clear All Filter");
		CommonMethods.waitForPageLoading();
		if (DriverManager.getDriver().findElements(byDisplayLocationField).size() < 1) {
			SeleniumActions.click(byExpandDisplayLocationfield, "Expand icon");
		}
		SeleniumActions.getElement(byDisplayLocationField).clear();
		SeleniumActions.sendTextToElement(byDisplayLocationField, strText, "Display Location search field");
		CommonMethods.waitForPageLoading();
		KeyboardActions.pressEnterKey(byDisplayLocationField);
		CommonMethods.waitForPageLoading();
		if (bClick == true) {
			String strSearchLocation = SeleniumActions.getText(byFirstlocationinList);
			Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "SelectedLocation", strSearchLocation);
			String strBeforeCurrentQuantity = SeleniumActions.getText(byFirstCurrentQuantity);
			Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "CurrentQuantityBefore",
					strBeforeCurrentQuantity);
			SeleniumActions.click(By.xpath("//a[contains(text(),'" + strSearchLocation + "')]"),
					"Location Inventory Card");
		}
	}

	/**
	 * Function to get current quantity
	 *
	 */
	public static void getCurrentQuantity() {
		String strPresentCurrentQuantity = SeleniumActions.getText(byFirstCurrentQuantity);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "CurrentQuantityPresent",
				strPresentCurrentQuantity);
	}

	/**
	 * Function to adjust inventory is performed by selecting 'Adjust' button
	 */
	public static void selectAdjustInventory() {

		SeleniumActions.click(byMoreActionsBtn, "More actions");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byAdjustBtn, "Adjust action");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to search ILPN
	 * 
	 * @param strText - value which need to be searched
	 */
	public static void searchILPN(String strText) {
		List<String> listOfILPNs = (List<String>) Variables
				.get(CurrentThreadInstance.getCurrentScenarioId() + "listOFiLPNs");
		String iLPN = listOfILPNs.get(0);
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byClearAllBtn, "Clear All Filter");
		CommonMethods.waitForPageLoading();
		SeleniumActions.getElement(byILPNSearchTextBox).clear();
		SeleniumActions.sendTextToElement(byILPNSearchTextBox, strText, "ILPN text box");
		KeyboardActions.pressEnterKey(byILPNSearchTextBox);
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click clear all button
	 */
	public static void clickClearAllButton() {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byClearAllBtn, "Clear All Filter");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click cycle count button from bottom menu
	 */
	public static void selectLocationAndSelectCycleCountFromBottomMenu() {
		CommonMethods.waitForPageLoading();
		if (DriverManager.getDriver().findElements(byWithoutCycleCountMainArrowIconAtFirstIndex).size() <= 0) {
			FrameworkLogger.log(LogType.FAIL,
					"Test data NOT available. Location not available to execute scenario( Requirement : location with Facility status \"Not Allocated\" and there should not be any open cycle count task ) ");
		}
		CommonMethods.scrollByParticularElement(byWithoutCycleCountMainArrowIconAtFirstIndex, "Main Arrow");
		SeleniumActions.clickByJS(byWithoutCycleCountMainArrowIconAtFirstIndex, "Main Arrow");
		CommonMethods.waitForPageLoading();
		SeleniumActions.clickByJS(byWithoutCycleCountChildArrowIconAtFirstIndex, "Child Arrow");
		CommonMethods.waitForPageLoading();

		String location = DriverManager.getDriver().findElement(byWithoutCycleCountLocationAtFirstIndex).getText()
				.trim();
		location = location.replaceAll("-", "");
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "WithoutCycleCountLocationAtFirstIndex", location);

		String item = DriverManager.getDriver().findElement(byWithoutCycleCountItemNameAtFirstIndex).getText().trim();
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "WithoutCycleCountItemNameAtFirstIndex", item);

		String iLPN = DriverManager.getDriver().findElement(byWithoutCycleCountILPINIdAtFirstIndex).getText().trim();
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "WithoutCycleCountILPINIdAtFirstIndex", iLPN);

		String quantity = DriverManager.getDriver().findElement(byWithoutCycleCountILPINQuantityAtFirstIndex).getText()
				.trim();
		quantity = quantity.replaceAll(" Units", "");
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "WithoutCycleCountILPINQuantityAtFirstIndex",
				quantity);

		CommonMethods.scrollByParticularElement(byWithoutCycleCountILPINDetailsIconAtRightSide,
				"Details Icon Right side");
		SeleniumActions.clickByJS(byWithoutCycleCountILPINDetailsIconAtRightSide, "Details Icon Right side");
		CommonMethods.waitForPageLoading();

		if (DriverManager.getDriver().findElement(byBatchNumberInPopup).isDisplayed()) {
			String batchNumber = DriverManager.getDriver().findElement(byBatchNumberInPopup).getText().trim();
			Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "BatchNumberInPopup", batchNumber);
		}

		SeleniumActions.click(byCancelButtonInPopup, "Cancel button in popup");
		CommonMethods.waitForPageLoading();

		CommonMethods.scrollByParticularElement(byWithoutCycleCountRowAtFirstIndex,
				"Without Cycle count, Location Row at First index");
		SeleniumActions.click(byWithoutCycleCountRowAtFirstIndex, "Without Cycle count, Location Row at First index");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byMoreActionsBtn, "More Actions button");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byCycleCount, "Cycle count");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to select ILPN Status NotAllocated Checkbox
	 */
	public static void selectILPNStatusNotAllocatedCheckbox() {
		SeleniumActions.checkSingleCheckbox(byILPNStatusNotAllocatedCheckbox, "NotAllocated check box");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to search location in FN cycle count
	 * @param strText - value which need to be searched
	 */
	public static void searchLocation(String strText) {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byClearAllBtn, "Clear All Filter");
		CommonMethods.waitForPageLoading();
		if (DriverManager.getDriver().findElements(byLocationField).size() < 1) {
			SeleniumActions.click(byExpandLocationfield, "Expand icon");
		}
		SeleniumActions.getElement(byLocationField).clear();
		SeleniumActions.sendTextToElement(byLocationField, strText, "Display Location search field");
		CommonMethods.waitForPageLoading();
		KeyboardActions.pressEnterKey(byLocationField);
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to search item in FN cycle count
	 * @param strText - value which need to be searched
	 */
	public static void searchItem(String strText) {
		CommonMethods.waitForPageLoading();
		if (DriverManager.getDriver().findElements(byItemField).size() < 1) {
			SeleniumActions.click(byExpandItemfield, "Expand icon");
		}
		SeleniumActions.getElement(byItemField).clear();
		SeleniumActions.sendTextToElement(byItemField, strText, "Item search field");
		CommonMethods.waitForPageLoading();
		KeyboardActions.pressEnterKey(byItemField);
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to enter location in FN cycle count
	 * @param strText - value which need to be searched
	 */
	public static void EnterLocation(String strText) {
		CommonMethods.waitForPageLoading();

		SeleniumActions.getElement(byLocationCycleCount).clear();
		SeleniumActions.sendTextToElement(byLocationCycleCount, strText, "Location search field");
		CommonMethods.waitForPageLoading();
		KeyboardActions.pressEnterKey(byLocationCycleCount);
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to enter item in FN cycle count
	 * @param strText - value which need to be searched
	 */
	public static void EnterItem(String strText) {
		CommonMethods.waitForPageLoading();
		SeleniumActions.getElement(byItemCycleCount).clear();
		SeleniumActions.sendTextToElement(byItemCycleCount, strText, "Item search field");
		CommonMethods.waitForPageLoading();
		KeyboardActions.pressEnterKey(byItemCycleCount);
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to validate quantity error in FN cycle count
	 * @param strText - value which need to be searched
	 */
	public static void ValidateQuantityerror(String strText) {
		SeleniumActions.waitForPageLoading();
		SeleniumActions.verifyElementVisible(byAlertmsg, 5, "Quantity mismatch Error");
		if (SeleniumActions.getText(byAlertmsg).equalsIgnoreCase(strText)) {
			SeleniumActions.click(byAlertConfirm, "alert confirmed");
			FrameworkLogger.log(LogType.PASS, "Quantity mismatch error is displayed");
		} else {
			FrameworkLogger.log(LogType.FAIL, "Quantity mismatch error error is not displayed");
		}

	}

	/**
	 * Function to enter Quantity in FN cycle count
	 */
	public static void Enterquantityinccyclecountscren() {
		String actualQuantity = (String) Variables
				.get(CurrentThreadInstance.getCurrentScenarioId() + "CurrentOnhandQuantity");
		int quantityValue = Integer.parseInt((actualQuantity).trim());
		int quantityUpdated = quantityValue + 1;
		TasksPage.enterQuantity(String.valueOf(quantityUpdated));
		TasksPage.clickGoButton();
	}

	/**
	 * Function to enter expected Quantity in FN cycle count
	 */
	public static void Enterexpectedquantity() {
		String actualQuantity = (String) Variables
				.get(CurrentThreadInstance.getCurrentScenarioId() + "CurrentOnhandQuantity");
		int quantityValue = Integer.parseInt((actualQuantity).trim());
		int quantityUpdated = quantityValue + 1;
		TasksPage.enterQuantity(String.valueOf(quantityUpdated));
		TasksPage.clickGoButton();
	}

	/**
	 * Function to search Display Location in filter
	 * @param strText - value which need to be searched
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
	}

	/**
	 * Function to enter lower Quantity in cycle count screen
	 * @param quantityCount - value of quantity count
	 */
	public static void enterLowerQuantityInCycleCountScreen(int quantityCount) {
		String actualQuantity = (String) Variables
				.get(CurrentThreadInstance.getCurrentScenarioId() + "CurrentOnhandQuantity");
		int quantityValue = Integer.parseInt((actualQuantity).trim());
		int quantityUpdated = quantityValue - quantityCount;
		TasksPage.enterQuantity(String.valueOf(quantityUpdated));
		TasksPage.clickGoButton();
	}
	/**
	 * Function to enter scan location in FN cycle count
	 * @param strText - value which need to be searched
	 *
	 */
	public static void EnterScanLocation(String strText) {
		CommonMethods.waitForPageLoading();
		SeleniumActions.getElement(byScanLocationCycleCount).clear();
		SeleniumActions.sendTextToElement(byScanLocationCycleCount, strText, "Location search field");
		SeleniumActions.getElement(byGoButton).click();
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to enter ILPN in FN cycle count
	 * @param strText - value which need to be searched
	 */
	public static void EnterILPN(String strText) {
		CommonMethods.waitForPageLoading();

		SeleniumActions.getElement(byILPNCycleCount).clear();
		SeleniumActions.sendTextToElement(byILPNCycleCount, strText, "ILPN search field");
		CommonMethods.waitForPageLoading();
		KeyboardActions.pressEnterKey(byILPNCycleCount);
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to validate quantity error in FN cycle count
	 * @param strText - value which need to be searched
	 */
	public static void validateQuantityErrorMessage(String strText) {
		SeleniumActions.waitForPageLoading();
		SeleniumActions.verifyElementVisible(byAlertmsg, 5, "Quantity mismatch Error");
		String alertText = SeleniumActions.getText(byAlertmsg).trim();
		if (SeleniumActions.getText(byAlertmsg).trim().equalsIgnoreCase(strText)) {
			SeleniumActions.click(byAlertConfirm, "alert confirmed");
			FrameworkLogger.log(LogType.PASS, "Quantity mismatch error is displayed. "  + "Expected: " + alertText + ". Actual: "+strText);
		} else {
			FrameworkLogger.log(LogType.FAIL, "Quantity mismatch error error is not displayed. " + "Expected: " + alertText + ".Actual: "+strText);
		}

	}
}
