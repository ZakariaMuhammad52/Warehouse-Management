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

@SuppressWarnings("unused")
public class TasksPage extends TestData_Json {

	private static final By byConfirmButtonInPopup = By.xpath("//span[text()='Confirm']");
	private static final By byWarningAlertPopup = By.xpath("//h2[text()='Warning']");
	private static final By byEndILPNButton = By.xpath("//span[text()='End Ilpn']");
	private static final By byEndICountButton = By.xpath("//span[text()='End Count']");
	private static final By byGoButton = By.xpath("//ion-button[contains(@data-component-id,'_go')]");
	private static final By byTasksPage = By.xpath("//span[contains(text(),'Tasks')]");
	private static final By byTaskStatusReadyForAssignmentCheckbox = By
			.xpath("//ion-checkbox[contains(@data-component-id,'ReadyForAssignment')]");
	private static final By byReadyForAssignmentButtonAtFirstIndex = By
			.xpath("(//div[@title='Ready For Assignment'][normalize-space()='Ready For Assign...'])"); // Need to
																											// finetune
																											// the xpath

	private static final By byTransactionTypeAtFirstIndex = By.xpath(
			"(//span[normalize-space()='Transaction type :']//following-sibling::span[contains(text(),'Cycle Count')])[1]");
	private static final By byEnterTaskTextField = By.xpath("//input[@placeholder='Enter Task']");
	private static final By byScanLocationTextFiled = By.xpath("//input[@placeholder='Scan Location']");
	private static final By byScanILPNTextFiled = By.xpath("//input[@placeholder='Scan iLPN']");
	private static final By byScanItemTextField = By.xpath("//input[@placeholder='Scan Item']");
	private static final By byQuantityTextField = By
			.xpath("//input[contains(@data-component-id,'naturalquantityfield_unit')]");
	private static final By byBatchNumberTextField = By.xpath("//input[contains(@data-component-id,'batchnumber')]");
	private static final By byTaskIdAtFirstIndex = By
			.xpath("(//span[normalize-space()='Task :']//following-sibling::span[contains(@data-component-id,'TaskId')])[1]");
	private static final By bySourceLocationAtFirstIndex = By.xpath(
			"(//span[normalize-space()='Source location :']//following-sibling::span[contains(@data-component-id,'SourceLocationId')])[1]");
	private static final By byTaskIdErrorMessage = By
			.xpath("//div[contains(@data-component-id,'popover_error_message')]");
	private static final By byTaskDetailsStatusDescription = By
			.xpath("//div[contains(@data-component-id,'DetailStatusDescription')]");
	private static final By BymoreActionsButton = By.xpath("//ion-button[@data-component-id='more-actions']");
	private static final By ByCancelOption = By.xpath("//button[contains(text(),'Cancel')]");
	private static final By byDetailBtn = By.xpath("//ion-button[contains(@data-component-id,'Details')]");

	private static final By byTask = By.xpath("//span[contains(@data-component-id,'TaskId')]");

	private static final By byStatusDescription = By.xpath("//div[contains(@data-component-id,'StatusDescription')]");
	private static final By byExpandInventoryAndLocationDetails = By
			.xpath("//span[text()='Inventory and location details']");
	private static final By byExpandOrderAndContainerDetails = By.xpath("//span[text()='Order and container details']");
	private static final By byTaskDetailContainerTypeID = By.xpath("//div[contains(@data-component-id,'SourceContainerTypeId')]");
	private static final By byTaskDetailAllocatedInventoryTypeID = By
			.xpath("//div[contains(@data-component-id,'AllocatedInventoryTypeId')]");
	private static final By byCloseExportBtn = By.xpath("//button//ion-icon[@name='close']");

	private static final By byAssignBtn = By.xpath("//ion-button[contains(@data-component-id,'Assign')]");
	private static final By byCurrentUserTextBox = By.xpath("//input[@placeholder='Current user']");
	private static final By byTaskFilter = By.xpath("//ion-input[contains(@data-component-id,'TaskId')]/input");
	private static final By byExpandTaskfield = By
			.xpath("//span[@title='Task']/following-sibling::ion-button[contains(@data-component-id,'expand-button')]");
	private static final By bySubmitBtn = By.xpath("//ion-button[contains(@data-component-id,'submit-btn')]");
	private static final By byLaborActivityRfpick = By.xpath("//*[@title='RFPICK']");
	private static final By byLaborActivityReplenishStorage = By.xpath("//*[@title='Replenish Storage']");
	private static final By byPendingBookingButtonAtFirstIndex = By
			.xpath("(//div[@title='Pending Booking'][normalize-space()='Pending Booking'])[1]");
	private static final By byTaskIDFilterTextBox = By
			.xpath("//ion-input[contains(@data-component-id,'TaskId')]/input[@class='native-input sc-ion-input-md']");

	private static final By byLocationText = By.xpath("//*[contains(@data-component-id,'acceptlocation_location')]");
	/**
	 * Function to verify Tasks Page is displayed
	 */
	public static void verifyTasksPageDisplayed() {
		SeleniumActions.verifyElementVisible(byTasksPage, 20, " Tasks page");
	}

	/**
	 * Function to click ReadyForAssignment Checkbox
	 */
	public static void clickReadyForAssignmentCheckbox() {
		SeleniumActions.click(byTaskStatusReadyForAssignmentCheckbox, "ReadyForAssignment checkbox");
	}

	/**
	 * Function to verify ReadyForAssignmentButton At FirstIndex
	 */
	public static void verifyReadyForAssignmentButtonAtFirstIndex() {
		SeleniumActions.verifyElementVisible(byReadyForAssignmentButtonAtFirstIndex, 20, " ReadyForAssignment Button AtFirstIndex");
	}

	/**
	 * Function to verify Transaction Type At FirstIndex
	 */
	public static void verifyTransactionTypeAtFirstIndex() {
		SeleniumActions.verifyElementVisible(byTransactionTypeAtFirstIndex, 20, " Transaction Type as Cycle count");
	}

	/**
	 * Function to verify source location at first index
	 * 
	 * @param location - value which need to be verified at first index
	 */
	public static void verifySourceLocationAtFirstIndex(String location) {
		String actualLocation = SeleniumActions.getAtrribute(bySourceLocationAtFirstIndex, "title", 20);
		actualLocation = actualLocation.replaceAll("-", "").trim();
		if (location.equals(actualLocation)) {
			FrameworkLogger.log(LogType.PASS, "Source Location Verification passed : " + location);
		} else {
			FrameworkLogger.log(LogType.FAIL,
					"Source Location Verification failed. Expected :+" + location + " , Actual :" + actualLocation);
		}
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
	 * Function to click go button
	 */
	public static void clickGoButton() {
		SeleniumActions.click(byGoButton, "Go button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to verify task has been completed in task page
	 */
	public static void verifyTheTaskHasBeenCompleted() {
		String taskId = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "TaskIdAtFirstIndex");
		enterTask(taskId);
		clickGoButton();
		String status = SeleniumActions.getText(byTaskIdErrorMessage);
		if (status.contains(taskId)) {
			FrameworkLogger.log(LogType.PASS, "Task completed verification passed : " + status);
		} else {
			FrameworkLogger.log(LogType.FAIL,
					"Task completed verification failed. Expected: Task has been completed for :" + taskId
							+ " , Actual :" + status);
		}
	}

	/**
	 * Function to store taskId
	 */
	public static void storeTaskId() {
		WebElement element = DriverManager.getDriver().findElement(byTaskIdAtFirstIndex);
		String text = element.getText().trim();
		System.out.println("byTaskIdAtFirstIndex stored in variable:- " + text);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "TaskIdAtFirstIndex", text);
	}

	/**
	 * Function to enter scan location
	 *
	 * @param text - value which need to be entered
	 */
	public static void enterScanLocation(String text) {
		SeleniumActions.sendTextToElement(byScanLocationTextFiled, text, "Scan location field");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to enter iLPN
	 *
	 * @param text - value which need to be entered
	 */
	public static void enterILPN(String text) {
		SeleniumActions.sendTextToElement(byScanILPNTextFiled, text, "Scan ILPN field");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to enter scan item
	 *
	 * @param text - value which need to be entered
	 */
	public static void enterScanItem(String text) {
		SeleniumActions.sendTextToElement(byScanItemTextField, text.replace("-", ""), "Scan Item field");// replaced "-"
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
	/*
	 * public static void enterBatchNumberIfDisplayed(String text) { if
	 * (DriverManager.getDriver().findElements(byBatchNumberTextField).size() > 0) {
	 * SeleniumActions.sendTextToElement(byBatchNumberTextField, text,
	 * "Batch Number field"); TasksPage.clickGoButton(); } }
	 */
	/**
	 * Function to enter quantity
	 * 
	 * @param text - value which need to be entered
	 */

	/*
	 * public static void enterQuantity(String text) {
	 * SeleniumActions.sendTextToElement(byQuantityTextField, text,
	 * "Quantity field"); CommonMethods.waitForPageLoading(); }
	 */
	/**
	 * Function to click end ILPN button
	 */

	/*
	 * public static void clickEndILPNButton() {
	 * SeleniumActions.click(byEndILPNButton, "End ILPN button"); }
	 */
	/**
	 * Function to click end count button
	 */

	/*
	 * public static void clickEndCountButton() {
	 * SeleniumActions.click(byEndICountButton, "End Count button"); }
	 */
	/**
	 * Function to click confirm button in popup
	 */

	/*
	 * public static void clickConfirmButtonInPopup() {
	 * SeleniumActions.click(byConfirmButtonInPopup, "End Count button");
	 * CommonMethods.waitForPageLoading(); }
	 */
	/**
	 * Function to click confirm button in popup if displayed
	 */
	/*
	 * public static void clickConfirmInPopupIfDisplayed() { if
	 * (DriverManager.getDriver().findElements(byConfirmButtonInPopup).size() > 0) {
	 * clickConfirmButtonInPopup(); CommonMethods.waitForPageLoading(); } } /* /**
	 * 
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
	 * Function to enter quantity
	 *
	 * @param text - value which need to be entered
	 */
	public static void enterQuantity(String text) {
		SeleniumActions.sendTextToElement(byQuantityTextField, text, "Quantity field");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click end ILPN button
	 */
	public static void clickEndILPNButton() {
		SeleniumActions.click(byEndILPNButton, "End ILPN button");
	}

	/**
	 * Function to click end count button
	 */
	public static void clickEndCountButton() {
		SeleniumActions.click(byEndICountButton, "End Count button");
	}

	/**
	 * Function to click confirm button in popup
	 */
	public static void clickConfirmButtonInPopup() {
		SeleniumActions.click(byConfirmButtonInPopup, "End Count button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click confirm button in popup if displayed
	 */
	public static void clickConfirmInPopupIfDisplayed() {
		if (DriverManager.getDriver().findElements(byConfirmButtonInPopup).size() > 0) {
			clickConfirmButtonInPopup();
			CommonMethods.waitForPageLoading();
		}
	}

	/**
	 * Function to verify Task Details status displayed
	 * 
	 * @param strExpected - Task Details status that need to be verified
	 */
	public static void verifyTaskDetailsStatus(String strExpected) {
		CommonMethods.waitForPageLoading();
		String strStatus = getTaskDetailsStatus();
		if (!strStatus.isEmpty()) {
			SeleniumActions.verifyTextEquals(strStatus, strExpected);
		}
	}

	/**
	 * Function to get current Task Details status from Orders/Original Orders
	 * window
	 */
	public static String getTaskDetailsStatus() {
		String strStatus = SeleniumActions.getText(byTaskDetailsStatusDescription);
		if (strStatus != null && !strStatus.trim().isEmpty()) {
			return strStatus.trim();
		} else {
			FrameworkLogger.log(LogType.FAIL, "Task Details Status description is null or empty");
		}
		return "";
	}

	/**
	 * Function to click on more action buton
	 */
	public static void moreActionsButton() {
		SeleniumActions.click(BymoreActionsButton, "More Actions button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click on cancel option
	 */
	public static void CancelOption() {
		SeleniumActions.click(ByCancelOption, "Cancel button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to get current Task status from Wave Run > Tasks window
	 */
	public static String getTasksStatus() {
		String strStatus = SeleniumActions.getText(byStatusDescription);
		if (strStatus != null && !strStatus.trim().isEmpty()) {
			return strStatus.trim();
		} else {
			FrameworkLogger.log(LogType.FAIL, "Wave Status description is null or empty");
		}
		return "";
	}

	/**
	 * Function to verify Olpn status displayed
	 *
	 * @param strExpected - Tasks status that need to be verified
	 */
	public static void verifyTasksStatus(String strExpected) {
		CommonMethods.waitForPageLoading();
		String strStatus = getTasksStatus();
		if (!strStatus.isEmpty()) {
			SeleniumActions.verifyTextEquals(strStatus, strExpected);
		}
	}

	/**
	 * Function to capture OLPN value from Wave Runs>OLPN screen
	 */
	public static void captureTaskNumber() {
		String strOLPN = SeleniumActions.getText(byTask);
		if (strOLPN != null && !strOLPN.trim().isEmpty()) {
			Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "TASK", strOLPN.replace("TASK ID: ", ""));
		} else {
			FrameworkLogger.log(LogType.FAIL, "TASK is null or empty");
		}
	}

	/**
	 * Function to click task in Task Details
	 */
	public static void clickTaskInTaskDetails(String Task) {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(By
				.xpath("//a[contains(text(),'" + Task + "')]//following::div/span[contains(text(),'Source location')]"),
				"Source Location");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byDetailBtn, "Details Button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click Inventory And Location Details
	 */
	public static void expandInventoryAndLocationDetails() {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byExpandInventoryAndLocationDetails, "Expand Inventory and location details");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click Order and container details
	 */
	public static void expandOrderAndContainerDetails() {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byExpandOrderAndContainerDetails, "Expand Order and Container details");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to check Container in Task Detail
	 *
	 * @param expectedContainerTypeID - Continer Type Id to be verified
	 */
	public static void taskDetailContainerId(String expectedContainerTypeID) {
		String actualContainerTypeID;
		CommonMethods.waitForPageLoading();
		CommonMethods.scrollByParticularElement(byTaskDetailContainerTypeID, "Container Type ID");
		actualContainerTypeID = SeleniumActions.getText(byTaskDetailContainerTypeID).trim();
		SeleniumActions.verifyTextEquals(actualContainerTypeID, expectedContainerTypeID);
	}

	/**
	 * Function to check Container in Task Detail
	 *
	 * @param expectedAllocatedInventoryTypeID - allocated Inventory Type Id to be
	 *                                         verified
	 */
	public static void taskDetailAllocatedInventoryTypeId(String expectedAllocatedInventoryTypeID) {
		String actualAllocatedInventoryTypeID;
		CommonMethods.waitForPageLoading();
		CommonMethods.scrollByParticularElement(byTaskDetailAllocatedInventoryTypeID, "Allocated Inventory Type ID");
		actualAllocatedInventoryTypeID = SeleniumActions.getText(byTaskDetailAllocatedInventoryTypeID).trim();
		SeleniumActions.verifyTextEquals(actualAllocatedInventoryTypeID, expectedAllocatedInventoryTypeID);
	}

	/**
	 * Function to click Task Card in Task Details
	 */
	public static void clickTaskCardInTaskDetails(String Task) {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(By
				.xpath("//a[contains(text(),'" + Task + "')]//following::div/span[contains(text(),'Source location')]"),
				"Source location");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to close Task Details
	 */
	public static void closeTaskDetails() {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byCloseExportBtn, "Close Order Line");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to capture Multiple Tasks
	 */
	public static void storeMultipleTasks() {
		List<WebElement> elements = SeleniumActions.getElements(byTask);
		List<String> listOfTasks = new ArrayList<>();
		for (int i = 0; i < elements.size(); i++) {
			String value = elements.get(i).getText().trim();
			listOfTasks.add(value);
		}
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "listOfTasks", listOfTasks);
		FrameworkLogger.log(LogType.INFO, "Set value for listOfTasks : " + listOfTasks);
	}

	/**
	 * Function to verify multiple Task Statuses
	 * 
	 * @param Statuses - Statuses value which need to be verified
	 */
	public static void verifyMultipleTaskStatuses(String Statuses) {
		List<String> expectedStatuses = new ArrayList<String>(Arrays.asList(Statuses.split(",")));
		List<WebElement> elements = DriverManager.getDriver().findElements(byStatusDescription);
		List<String> actualStatuses = new ArrayList<>();
		for (WebElement e : elements) {
			actualStatuses.add(e.getText());
		}
		if (expectedStatuses.equals(actualStatuses)) {
			FrameworkLogger.log(LogType.PASS, "Task Statuses Verification passed : " + expectedStatuses);
		} else {
			FrameworkLogger.log(LogType.FAIL, "Task Statuses Verification failed. Expected :" + expectedStatuses
					+ " , Actual :" + actualStatuses);
		}
	}

	/**
	 * Function to filter by task
	 * @param text - serach value task
	 */
	public static void filerByTask(String text) {
		if (DriverManager.getDriver().findElements(byTaskFilter).size() < 1) {
			SeleniumActions.click(byExpandTaskfield, "Expand icon");
		}
		SeleniumActions.sendTextToElement(byTaskFilter, text, "Task field");
		CommonMethods.waitForPageLoading();
		KeyboardActions.pressEnterKey(byTaskFilter);
	}

	/**
	 * Function to assign task to current User
	 */
	public static void assignTaskDetails(String strEmail) {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byAssignBtn, "Assign");
		CommonMethods.waitForPageLoading();
		SeleniumActions.sendTextToElement(byCurrentUserTextBox, strEmail, "Current User");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(bySubmitBtn, "Submit");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to Verify Labor Activity On Tasks Page
	 */
	public static void verifyLaborActivityOnTaskPage() {
		CommonMethods.waitForPageLoading();
		String LaborActivityRFPick = getDataFromFeature("getdata(LaborActivityRFPick)");
		String LaborActivityReplenish = getDataFromFeature("getdata(LaborActivityReplenish)");
		String textLaborActivityRFPick = SeleniumActions.getText(byLaborActivityRfpick);
		SeleniumActions.verifyTextEquals(textLaborActivityRFPick, LaborActivityRFPick, false);
		String textLaborActivityReplenish = SeleniumActions.getText(byLaborActivityReplenishStorage);
		SeleniumActions.verifyTextEquals(textLaborActivityReplenish, LaborActivityReplenish, false);
	}

	/**
	 * Verify the excluded user error message
	 */
	public static void VerifyTaskIdErrorMessage(String error) {
		String status = SeleniumActions.getText(byTaskIdErrorMessage).trim();
		String[] userError = status.split(" ", 2);
		String userErrorValue =  userError[1];
		SeleniumActions.verifyTextEquals(userErrorValue, error);
	}

	/**
	 * Function to filter task id
	 */
	public static void FilterTaskID() {
		String taskId = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "TaskIdAtFirstIndex");
		SeleniumActions.explicityWaitTillElementVisible(byTaskIDFilterTextBox, 15);
		SeleniumActions.getElement(byTaskIDFilterTextBox).clear();
		SeleniumActions.sendTextToElement(byTaskIDFilterTextBox, taskId, "TaskID");
		CommonMethods.waitForPageLoading();
		KeyboardActions.pressEnterKey(byTaskIDFilterTextBox);
		CommonMethods.waitForPageLoading();
	}
}
