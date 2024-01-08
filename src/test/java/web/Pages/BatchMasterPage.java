package web.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.dhl.driver.DriverManager;
import com.dhl.enums.KeyboardKeys;
import com.dhl.reports.FrameworkLogger;
import com.dhl.reports.LogType;
import com.dhl.testdata.TestData_Json;
import com.dhl.utils.CurrentThreadInstance;
import com.dhl.utils.GeneralUtils;
import com.dhl.utils.Variables;
import com.dhl.web.utils.KeyboardActions;
import com.dhl.web.utils.SeleniumActions;

import stepdefinitions.CommonMethods;
import stepdefinitions.ExcelUtil1;

@SuppressWarnings("unused")
public class BatchMasterPage extends TestData_Json {

	private static final By byStatusHeldCheckbox = By.xpath("//ion-checkbox[@data-component-id='Held-multi-select-filter']");
	private static final By byStatusReleasedCheckbox = By.xpath("//ion-checkbox[@data-component-id='Released-multi-select-filter']");
	private static final By byBatchMasterPage = By.xpath("//span[contains(text(),'Batch Master')]");
	private static final By byReleasedStatusList = By.xpath("//span[@title='Released']");
	private static final By byHeldStatusList = By.xpath("//span[@title='Held']");
	private static final By byBatchStatusList = By.xpath("//span[contains(text(),'Batch status')]");
	private static final By byShowingLabel = By.xpath("//span[starts-with(text(), 'Showing')]");
	private static final By byBatchNumber = By.xpath("//span[@data-component-id='BatchNumberId-card-view']");
	private static final By byItemId = By.xpath("//a[@data-component-id='ItemId-card-view']");
	private static final By byHeldStatusConditionCode = By
			.xpath("//span[@data-component-id='HeldStatusConditionCodeId-card-view']");
	private static final By byRecallConditionCode = By.xpath("//span[@data-component-id='RecallConditionCodeId-card-view']");
	private static final By byExpiredConditionCode = By.xpath("//span[@data-component-id='ExpiredConditionCodeId-card-view']");
	private static final By byBatchNumberTextField = By
			.xpath("//ion-input[contains(@data-component-id,'BatchNumber')]/input");
	private static final By byCloseButtonAtRightSide = By.xpath("(//button[@data-component-id='action-closed-card-view'])[1]");
	private static final By byOpenButtonAtRightSide = By.xpath("(//button[@data-component-id='action-open-card-view'])[1]");
	private static final By byEditButton = By.xpath("//button[@data-component-id='Edit-swipe-panel']//img");
	private static final By byMoreActionsButton = By.xpath("//ion-button[@data-component-id='more-actions-swipe-panel']//span");
	private static final By byHoldButton = By.xpath("//more-actions-popover//button[@data-component-id='Hold-more-actions']");
	private static final By byReleaseButton = By.xpath("//more-actions-popover//button[@data-component-id='Release-more-actions']");
	private static final By byRecallButton = By.xpath("//button[@data-component-id='Recall-swipe-panel']");
	private static final By byYesButtonHoldPopup = By.xpath("//button[@data-component-id='yes-btn-confirmation-popup']"); // in hold popup
	private static final By byRecallConditionCodeIdInBatchMasterPopup = By
			.xpath("//ion-col//ion-input[@data-component-id='RecallConditionCodeId-dynamic-ui-builder-dropdown']");
	private static final By byExpiredConditionCodeIdInBatchMasterPopup = By
			.xpath("//ion-col//ion-input[@data-component-id='ExpiredConditionCodeId-dynamic-ui-builder-dropdown']");
	private static final By byHeldConditionCodeIdInBatchMasterPopup = By
			.xpath("//ion-col//ion-input[@data-component-id='HeldStatusConditionCodeId-dynamic-ui-builder-dropdown']");
	private static final By byCloseButtonInBatchMasterPopup = By
			.xpath("//button[contains(@data-component-id,'BatchMaster')]//ion-icon[@name='close']");
	private static final By byExportDataLoaderBtn = By.xpath("//button[@data-component-id='ExportDataLoader-header-panel']");
	private static final By byImportDataLoaderBtn = By.xpath("//button[@data-component-id='ImportDataLoader-header-panel']");
	private static final By byChooseFileBtn = By.xpath("//label[contains(text(),'Choose File')]");
	private static final By bySaveBtn = By.xpath("//ion-button[contains(text(),'SAVE')]");
	private static final By byRefreshBtn = By.xpath("//ion-button[@data-component-id='refresh-navbar-icons']");

	/**
	 * Function to verify Batch Master Page Displayed
	 **/
	public static void verifyBatchMasterPageDisplayed() {
		SeleniumActions.verifyElementVisible(byBatchMasterPage, 20, "Batch Master page");
	}

	/**
	 * Function to search batch number
	 * 
	 * @param text - value which need to be searched
	 */
	public static void searchBatchNumber(String text) {
		enterBatchNumber(text);
		CommonMethods.waitForPageLoading();
		KeyboardActions.pressEnterKey(byBatchNumberTextField);
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to enter batch number
	 * 
	 * @param text - value which need to be entered
	 */
	public static void enterBatchNumber(String text) {
		SeleniumActions.clear(byBatchNumberTextField, "Batch Number");
		SeleniumActions.sendTextToElement(byBatchNumberTextField, text, "Batch Number Text Field");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to select Status Released Checkbox
	 **/
	public static void selectStatusReleasedCheckbox() {
		SeleniumActions.checkSingleCheckbox(byStatusReleasedCheckbox, "Released check box");
	}

	/**
	 * Function to select Status Held Checkbox
	 **/
	public static void selectStatusHeldCheckbox() {
		SeleniumActions.checkSingleCheckbox(byStatusHeldCheckbox, "Held check box");
	}

	/**
	 * Function to unselect Status Released Checkbox
	 **/
	public static void unSelectStatusReleasedCheckbox() {
		CommonMethods.uncheckSingleCheckbox(byStatusReleasedCheckbox, "Released check box");
	}

	/**
	 * Function to unselect Status Held Checkbox
	 **/
	public static void unSelectStatusHeldCheckbox() {
		CommonMethods.uncheckSingleCheckbox(byStatusHeldCheckbox, "Held check box");
	}

	/**
	 * Function to Verify selected Batch Number is removed from the filtered results
	 * @param status- Give status (eg - Released, Held)
	 */
	public static void verifyThatSelectedBatchNumberIsRemovedInTheFilteredResults(String status) {
		LocationInventory.clickClearAllButton();
		if (status.equalsIgnoreCase("Released")) {
			selectStatusReleasedCheckbox();
		}
		if (status.equalsIgnoreCase("Held")) {
			selectStatusHeldCheckbox();
		}
		CommonMethods.waitForPageLoading();
		List<WebElement> batchNumberElements = DriverManager.getDriver().findElements(byBatchNumber);
		List<String> listOfBatchNumbers = new ArrayList<>();
		for (WebElement element : batchNumberElements) {
			listOfBatchNumbers.add(element.getText().trim());
		}
		String batchNumber = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "BatchNumber");
		if (listOfBatchNumbers.contains(batchNumber)) {
			FrameworkLogger.log(LogType.FAIL,
					"Verification of Selected BatchNumber in the Filtered Results Failed. It should not display, but its displaying: "
							+ batchNumber);
		} else {
			FrameworkLogger.log(LogType.PASS,
					"Verification of Selected BatchNumber in the Filtered Results Passed. Selected Batch Number is disappeared. it is expected behaviour");
		}
	}

	/**
	 * Function to click Edit button for batch number
	 */
	public static void clickEditForBatchNumber() {
		SeleniumActions.click(byEditButton, "Edit button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click CloseButton AtRightSide For BatchNumber
	 */
	public static void clickCloseButtonAtRightSideForBatchNumber() {
		SeleniumActions.click(byCloseButtonAtRightSide, "Close button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click OpenButton AtRightSide For BatchNumber
	 */
	public static void clickOpenButtonAtRightSideForBatchNumber() {
		SeleniumActions.click(byOpenButtonAtRightSide, "Open button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click CloseButton in BatchNumber Popup
	 */
	public static void clickCloseButtonInBatchMasterPopup() {
		SeleniumActions.click(byCloseButtonInBatchMasterPopup, " Close Button In BatchMasterPopup");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click MoreButton AtRightSide For BatchNumber
	 */
	public static void clickMoreButtonAtRightSideForBatchNumber() {
		SeleniumActions.click(byMoreActionsButton, "More Button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 *  Function to click clear all button
	 */
	public static void clickHoldButtonAtRightSideForBatchNumber() {
		SeleniumActions.click(byHoldButton, "Hold Button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 *  Function to click ReleaseButton AtRightSide For BatchNumber
	 */
	public static void clickReleaseButtonAtRightSideForBatchNumber() {
		SeleniumActions.click(byReleaseButton, "Release Button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 *  Function to click RecallButton AtRightSide For BatchNumber
	 */
	public static void clickRecallButtonAtRightSideForBatchNumber() {
		SeleniumActions.click(byRecallButton, "Recall Button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 *  Function to click YesButton In HoldPopup
	 */
	public static void clickYesButtonInHoldPopup() {
		SeleniumActions.click(byYesButtonHoldPopup, "Yes Button in Hold popup");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to Verify Held condition code has vale for the Batch Number
	 */
	public static void verifyHeldConditionCodeHasAValueForTheSelectedBatchNumber() {
		String batchNumber = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "BatchNumber");
		searchBatchNumber(batchNumber);
		clickCloseButtonAtRightSideForBatchNumber();
		clickEditForBatchNumber();
		String heldConditionCode = SeleniumActions.getAtrribute(byHeldConditionCodeIdInBatchMasterPopup, "title", 20);
		if (heldConditionCode == null || heldConditionCode.isEmpty()) {
			FrameworkLogger.log(LogType.FAIL, "Held ConditionCode is EMPTY OR NULL In BatchMasterPopup");
		}
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "HeldConditionCode", heldConditionCode);
		FrameworkLogger.log(LogType.INFO,
				"Held ConditionCode In BatchMasterPopup stored in variable:- " + heldConditionCode);

		String recallConditionCode = SeleniumActions.getAtrribute(byRecallConditionCodeIdInBatchMasterPopup, "title",
				20);
		if (recallConditionCode == null || recallConditionCode.isEmpty()) {
			FrameworkLogger.log(LogType.FAIL, "Recall ConditionCode is EMPTY OR NULL In BatchMasterPopup");
		}
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "RecallConditionCode", recallConditionCode);
		FrameworkLogger.log(LogType.INFO,
				"Recall ConditionCode In BatchMasterPopup stored in variable:- " + recallConditionCode);
		clickCloseButtonInBatchMasterPopup();
	}

	/**
	 * Function to Verify All Batch Numbers are displayed
	 */
	public static void verifyAllBatchNumbersAreDisplayed() {
		List<WebElement> batchStatusElements = SeleniumActions.getElements(byBatchStatusList);
		int batchStatusElementsCount = batchStatusElements.size();
		String label = SeleniumActions.getText(byShowingLabel);
		int showingLabelCount = Integer.parseInt(((label.split("-")[1]).split("of")[0]).trim());
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "showingLabelCount", showingLabelCount);
		if (batchStatusElementsCount == showingLabelCount) {
			FrameworkLogger.log(LogType.PASS,
					"Verification of all Batch Numbers including Held is passed : " + showingLabelCount);
		} else {
			FrameworkLogger.log(LogType.FAIL, "Verification of all Batch Numbers including Held is failed. Expected :+"
					+ showingLabelCount + " , Actual :" + batchStatusElementsCount);
		}
	}

	/**
	 * Function to Verify Batch Numbers are displayed with Released status
	 */
	public static void verifyBatchNumbersAreDisplayedWhichAreOnlyInReleasedStatus() {
		List<WebElement> batchStatusReleasedElements = SeleniumActions.getElements(byReleasedStatusList);
		int batchStatusReleasedElementsCount = batchStatusReleasedElements.size();
		String label = SeleniumActions.getText(byShowingLabel);
		int showingLabelCount = Integer.parseInt(((label.split("-")[1]).split("of")[0]).trim());
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "showingLabelCount", showingLabelCount);
		if (batchStatusReleasedElementsCount == showingLabelCount) {
			FrameworkLogger.log(LogType.PASS,
					"Batch Numbers are displayed which are only in Released status Verification passed : "
							+ showingLabelCount);
		} else {
			FrameworkLogger.log(LogType.FAIL,
					"Batch Numbers are displayed which are only in Released status Verification failed. Expected :+"
							+ showingLabelCount + " , Actual :" + batchStatusReleasedElementsCount);
		}
	}

	/**
	 * Function to Verify Batch Numbers are displayed with Held status
	 */
	public static void verifyBatchNumbersAreDisplayedWhichAreOnlyInHeldStatus() {
		List<WebElement> batchStatusHeldElements = SeleniumActions.getElements(byHeldStatusList);
		int batchStatusHeldElementsCount = batchStatusHeldElements.size();
		String label = SeleniumActions.getText(byShowingLabel);
		int showingLabelCount = Integer.parseInt(((label.split("-")[1]).split("of")[0]).trim());
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "showingLabelCount", showingLabelCount);
		if (batchStatusHeldElementsCount == showingLabelCount) {
			FrameworkLogger.log(LogType.PASS,
					"Batch Numbers are displayed which are only in Held status Verification passed : "
							+ showingLabelCount);
		} else {
			FrameworkLogger.log(LogType.FAIL,
					"Batch Numbers are displayed which are only in Held status Verification failed. Expected :+"
							+ showingLabelCount + " , Actual :" + batchStatusHeldElementsCount);
		}
	}

	/**
	 * Function to Store Batch Details
	 */
	public static void storeBatchDetails() {
		List<WebElement> batchNumberElements = DriverManager.getDriver().findElements(byBatchNumber);
		List<String> listOfBatchNumbers = new ArrayList<>();
		for (WebElement element : batchNumberElements) {
			listOfBatchNumbers.add(element.getText().trim());
		}
		FrameworkLogger.log(LogType.INFO, "list Of BatchNumbers stored in variables:- " + listOfBatchNumbers);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "listOfBatchNumbers", listOfBatchNumbers);

		List<WebElement> itemIdElements = DriverManager.getDriver().findElements(byItemId);
		List<String> listOfItemIds = new ArrayList<>();
		for (WebElement element : itemIdElements) {
			listOfItemIds.add(element.getText().trim());
		}
		FrameworkLogger.log(LogType.INFO, "list Of ItemIds stored in variables:- " + listOfItemIds);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "listOfItemIds", listOfItemIds);

		List<WebElement> heldStatusConditionCodeElements = DriverManager.getDriver()
				.findElements(byHeldStatusConditionCode);
		List<String> listOfHeldConditionCodes = new ArrayList<>();
		for (WebElement element : heldStatusConditionCodeElements) {
			listOfHeldConditionCodes.add(element.getText().trim());
		}
		FrameworkLogger.log(LogType.INFO,
				"list Of Held ConditionCodes stored in variables:- " + listOfHeldConditionCodes);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "listOfHeldConditionCodes",
				listOfHeldConditionCodes);

		List<WebElement> recallConditionCodeElements = DriverManager.getDriver().findElements(byRecallConditionCode);
		List<String> listOfRecallConditionCodes = new ArrayList<>();
		for (WebElement element : recallConditionCodeElements) {
			listOfRecallConditionCodes.add(element.getText().trim());
		}
		FrameworkLogger.log(LogType.INFO,
				"list Of RecallConditionCodes stored in variables:- " + listOfRecallConditionCodes);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "listOfRecallConditionCodes",
				listOfRecallConditionCodes);

		List<WebElement> expiredConditionCodeElements = DriverManager.getDriver().findElements(byExpiredConditionCode);
		List<String> listOfExpiredConditionCodes = new ArrayList<>();
		for (WebElement element : expiredConditionCodeElements) {
			listOfExpiredConditionCodes.add(element.getText().trim());
		}
		FrameworkLogger.log(LogType.INFO,
				"list Of ExpiredConditionCodes stored in variables:- " + listOfExpiredConditionCodes);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "listOfExpiredConditionCodes",
				listOfExpiredConditionCodes);
	}

	/**
	 * Function to check Batch Number in Released Status
	 */
	public static void storeBatchNumberStatus() {
		if (DriverManager.getDriver().findElements(byReleasedStatusList).size() > 0) {
			Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "isBatchNumberFound", "true");
		} else {
			Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "isBatchNumberFound", "false");
		}
	}

	/**
	 * Function to click Export Data Loaded
	 */
	public static void clickExportDataLoader() {
		SeleniumActions.click(byExportDataLoaderBtn, "Export Data Loader");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click Import Data Loaded
	 */
	public static void clickImportDataLoader() {
		SeleniumActions.click(byImportDataLoaderBtn, "Import Data Loader");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to select Batch Master file to import
	 *
	 */
	public static void selectFiletoImport() {
		SeleniumActions.click(byChooseFileBtn, "click Choose File button");
		GeneralUtils.wait(5 * 1000);
		String demo = System.getProperty("user.home") + "\\Downloads\\";
		ExcelUtil1.sendTextWithRobot(demo + "BatchMaster.xlsx");
		GeneralUtils.wait(5 * 1000);
		KeyboardActions.pressKeyboardKeyWithRobot(KeyboardKeys.ENTER);
		GeneralUtils.wait(5 * 1000);
		SeleniumActions.click(bySaveBtn, "click Save button");
	}

	/**
	 * Function to click Refresh Data Loaded
	 */
	public static void clickRefreshDataLoader() {
		SeleniumActions.click(byRefreshBtn, "Refresh Button");
		CommonMethods.waitForPageLoading();
	}
}
