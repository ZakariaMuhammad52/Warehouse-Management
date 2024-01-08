package web.Pages;

import org.openqa.selenium.By;

import com.dhl.driver.DriverManager;
import com.dhl.reports.FrameworkLogger;
import com.dhl.reports.LogType;
import com.dhl.testdata.TestData_Json;
import com.dhl.utils.CurrentThreadInstance;
import com.dhl.utils.GeneralUtils;
import com.dhl.utils.Variables;
import com.dhl.web.utils.KeyboardActions;
import com.dhl.web.utils.SeleniumActions;

import stepdefinitions.CommonMethods;

public class WaveRunsPage extends TestData_Json {
	private static final By byWaveRunsPage = By.xpath("//span[contains(text(),'Wave Runs')]");
	private static final By byWaveRunField = By.xpath("//ion-input[contains(@data-component-id,'OrderPlanningRunId')]/input");
	private static final By byExpandWaveRunfield = By
			.xpath("//span[@title='Wave run']/following-sibling::ion-button[contains(@data-component-id,'expand-button')]");
	private static final By byWaveStatusDescription = By.xpath("//div[contains(@data-component-id,'PlanningStatusDescription')]");
	private static final By byRelatedLinks = By.xpath("//*[contains(text(),'Related Links')]");
	private static final By byAllocations = By.xpath("//a[text()='Allocations']");
	private static final By byQuantity = By.xpath("//span[contains(text(),'Quantity')]");
	private static final By byDetailBtn = By.xpath("//ion-button[contains(@data-component-id,'Details')]");
	private static final By byExpandContainerOrQuantity = By.xpath("//span[text()='Container/Quantity']");
	private static final By byExpandItem = By.xpath("//span[text()='Item']");
	private static final By byBatchNumber = By.xpath("//div[@data-component-id='BatchNumber-list-expand']");
	private static final By byAllocationItemID = By.xpath("//div[contains(@data-component-id,'ItemId')]");
	private static final By byOriginalQuantity = By.xpath("//div[contains(@data-component-id,'OriginalQuantity')]");
	private static final By byAllocationQuantity = By.xpath("//div[@data-component-id='Quantity-list-expand']");
	private static final By byCloseExportBtn = By.xpath("//button//ion-icon[@name='close']");
	private static final By byUnplanBtn = By.xpath("//ion-button[contains(@data-component-id,'Unplan')]");
	private static final By byUnplanYesBtn = By
			.xpath("//ion-radio[contains(@data-component-id,'CancelReplenishmentTasks-true')]");
	private static final By bySubmitBtn = By.xpath("//ion-button[contains(@data-component-id,'submit-btn')]");
	private static final By byRunWaveConfirmMessageText = By.xpath("//div[contains(text(),'submitted')]");
	private static final By byAllocationAttributeValue = By
			.xpath("//div[contains(@data-component-id,'InventoryAttributeValue')]");

	private static final By byAllocationContainerID = By.xpath("//*[@data-component-id='InventoryContainerId-list-expand']");

	private static final By byWaveRunsBreadCrumb = By.xpath("//a[@title='Wave Runs']");

	private static final By byOLPN = By.xpath("//span[contains(@data-component-id,'OlpnId')]");
	private static final By byOLPNStatusDescription = By.xpath("//div[contains(@data-component-id,'StatusDescription')]");
	private static final By bywaverunType = By.xpath("//div/card-view[contains(@data-component-id,'Card-View')]");
	private static final By bywaverunTypeDes = By.xpath(
			"//div/card-view[contains(@data-component-id,'Card-View')]//span[contains(@data-component-id,'AllocationTypeDescription')]");

	private static final By byWaveRunId = By.xpath("//span[contains(@data-component-id,'OrderPlanningRunId')]");
	private static final By byAllocationUomValue = By.xpath("//div[contains(@data-component-id,'AllocationUomTypeId')]");

	/**
	 * Function to Verify Wave Run Page is displayed
	 *
	 */
	public static void verifyWaveRunsPageDisplayed() {
		SeleniumActions.verifyElementVisible(byWaveRunsPage, 20, " Wave Runs page");
	}

	/**
	 * Function to search Wave run in wave runs window
	 *
	 * @param strText - wave run which need to searched
	 */
	public static void searchWaveRuns(String strText) {
		CommonMethods.waitForPageLoading();
		if (DriverManager.getDriver().findElements(byWaveRunField).size() < 1) {
			SeleniumActions.click(byExpandWaveRunfield, "Expand icon");
		}
		SeleniumActions.getElement(byWaveRunField).clear();
		SeleniumActions.sendTextToElement(byWaveRunField, strText, "wave run search field");
		CommonMethods.waitForPageLoading();
		KeyboardActions.pressEnterKey(byWaveRunField);
		CommonMethods.waitForPageLoading();
		// SeleniumActions.click(By.xpath("//span[contains(text(),'" + strText + "')]"),
		// "Wave Card");
	}

	/**
	 * Function to verify  wave status
	 * @param strExpected - expected status value
	 */
	public static void waitAndVerifyWaveStatus(String strExpected) throws InterruptedException {
		GeneralUtils.wait(1 * 1000);
		boolean bTrue = true;
		String strStatus = getWaveStatus();
		if (!strStatus.isEmpty()) {
			int itime = 0;
			while (bTrue == true) {
				GeneralUtils.wait(1 * 1000);
				itime += 2;
				KeyboardActions.pressEnterKey(byWaveRunField);
				strStatus = getWaveStatus();
				if (itime > 240) {
					bTrue = false;
				}
				if (strStatus.equals(strExpected)) {
					bTrue = false;
				}
			}
			SeleniumActions.verifyTextEquals(strStatus, strExpected);
		}
	}

	/**
	 * Function to get current Wave run status from Wave Run window
	 */
	public static String getWaveStatus() {
		String strStatus = SeleniumActions.getText(byWaveStatusDescription);
		if (strStatus != null && !strStatus.trim().isEmpty()) {
			return strStatus.trim();
		} else {
			FrameworkLogger.log(LogType.FAIL, "Wave Status description is null or empty");
		}
		return "";
	}

	/**
	 * Function to click Details in Order Line
	 */
	public static void selectDetailsInOrderLine() {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byQuantity, "Quantity");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byDetailBtn, "Details Button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click Container/Quantity
	 */
	public static void expandContainerOrQuantity() {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byExpandContainerOrQuantity, "Expand Container/Quantity");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click Container/Quantity
	 */
	public static void expandItem() {
		CommonMethods.waitForPageLoading();
		CommonMethods.scrollByParticularElement(byExpandItem, "Item");
		SeleniumActions.click(byExpandItem, "Expand Item");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to check Allocation has Item and Batch Number
	 */
	public static void AllocationHasItemAndBatchNumber() {
		CommonMethods.waitForPageLoading();
		SeleniumActions.verifyElementVisible(byAllocationItemID, 5, getDataFromFeature("getdata(ItemID_Line1)"));
		SeleniumActions.verifyElementVisible(byBatchNumber, 5, getDataFromFeature("getdata(BatchNo_Line1)"));

	}

	/**
	 * Function to check Container/Quantity has Quantity
	 */
	public static void checkContainerQuantity() {
		CommonMethods.waitForPageLoading();
		SeleniumActions.verifyElementVisible(byOriginalQuantity, 5, getDataFromFeature("getdata(OrderedQuantity)"));
		SeleniumActions.verifyElementVisible(byAllocationQuantity, 5, getDataFromFeature("getdata(OrderedQuantity)"));
	}

	/**
	 * Function to close Allocations
	 */
	public static void closeAllocation() {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byCloseExportBtn, "Close Order Line");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to perform Unplan Wave
	 */
	public static void unplanWave() {
		String ExpectedUnplanWaveMessage = "Undo Request submitted Eligible orders will be unplanned for OrderPlanningRunId "
				+ Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "WaveRun").toString() + " (DCO::101)";
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(
				By.xpath("//span[contains(text(),'"
						+ Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "WaveRun").toString() + "')]"),
				"Wave Card");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byUnplanBtn, "Unplan Button");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byUnplanYesBtn, "Yes Radio Button");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(bySubmitBtn, "Submit Button");
		String ActualWaveMessage = SeleniumActions.getText(byRunWaveConfirmMessageText);
		SeleniumActions.verifyTextEquals(ActualWaveMessage, ExpectedUnplanWaveMessage);
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click Details for multiple Order Line
	 */
	public static void selectDetailsForMultipleOrderLine(int lineQuantity) {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(By.xpath("(//span[contains(text(),'Quantity')])[" + lineQuantity + "]"), "Order Line");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byDetailBtn, "Details Button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to check Container/Quantity has Quantity
	 */
	public static void checkContainerQuantityAllLines(String quantity) {
		CommonMethods.waitForPageLoading();
		SeleniumActions.verifyElementVisible(byOriginalQuantity, 5, quantity);
		SeleniumActions.verifyElementVisible(byAllocationQuantity, 5, quantity);

	}

	/**
	 * Function to check Allocation has Item and Batch Number
	 */
	public static void AllocationHasItemAndBatchNumberAllLines(String batchNumber, String itemID) {
		CommonMethods.waitForPageLoading();
		SeleniumActions.verifyElementVisible(byAllocationItemID, 5, itemID);
		SeleniumActions.verifyElementVisible(byBatchNumber, 5, batchNumber);
	}

	/**
	 * Function to check Item in Allocations
	 *
	 * @param expectedItemID - Serial Number to be verified
	 */
	public static void allocationItemID(String expectedItemID) {
		String actualItemID;
		CommonMethods.waitForPageLoading();
		CommonMethods.scrollByParticularElement(byAllocationItemID, "Item ID");
		actualItemID = SeleniumActions.getText(byAllocationItemID).trim();
		SeleniumActions.verifyTextEquals(actualItemID, expectedItemID);
	}

	/**
	 * Function to check BatchNumber in Allocations
	 *
	 * @param expectedBatchNumber - Serial Number to be verified
	 */
	public static void allocationBatchNumber(String expectedBatchNumber) {
		String actualBatchNumber;
		CommonMethods.waitForPageLoading();
		CommonMethods.scrollByParticularElement(byBatchNumber, "Batch Number");
		actualBatchNumber = SeleniumActions.getText(byBatchNumber).trim();
		SeleniumActions.verifyTextEquals(actualBatchNumber, expectedBatchNumber);
	}

	/**
	 * Function to check Serial Number in Allocations
	 *
	 * @param expectedSerialNumber - Serial Number to be verified
	 */
	public static void allocationItemHasSerialNumber(String expectedSerialNumber) {
		String actualSerialNumber;
		CommonMethods.waitForPageLoading();
		CommonMethods.scrollByParticularElement(byAllocationAttributeValue, "Order Line Attribute Value");
		if (expectedSerialNumber == null) {
			if (DriverManager.getDriver().findElements(byAllocationAttributeValue).size() == 0) {
				FrameworkLogger.log(LogType.PASS, "Serial number is not displayed as expected");
			}
		} else {
			actualSerialNumber = SeleniumActions.getText(byAllocationAttributeValue).trim();
			SeleniumActions.verifyTextEquals(actualSerialNumber, expectedSerialNumber);
			FrameworkLogger.log(LogType.PASS, "Serial number is displayed as expected");
		}
	}

	/**
	 * Function to check Quantity in Container/Quantity
	 *
	 * @param expectedQuantity - Serial Number to be verified
	 */
	public static void checkContainerQuantity(String expectedQuantity) {
		String actualOriginalQuantity;
		String actualAllocationQuantity;
		CommonMethods.waitForPageLoading();
		CommonMethods.scrollByParticularElement(byAllocationAttributeValue, "Order Line Attribute Value");
		actualOriginalQuantity = SeleniumActions.getText(byOriginalQuantity).trim();
		actualAllocationQuantity = SeleniumActions.getText(byOriginalQuantity).trim();
		SeleniumActions.verifyTextEquals(actualOriginalQuantity, expectedQuantity);
		SeleniumActions.verifyTextEquals(actualAllocationQuantity, expectedQuantity);
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click order line in Allocations
	 */
	public static void clickOrderLineInAllocations(String OrderLine) {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(By.xpath(
				"//a[contains(text(),'" + OrderLine + "')]//following::div/span[contains(text(),'Source location')]"),
				"Source Location");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byDetailBtn, "Details Button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to check Item in Allocations
	 *
	 * @param expectedContainerLocation - Container Location to be verified
	 */
	public static void allocationContainerLocation(String expectedContainerLocation) {
		String actualContainerLocation;
		CommonMethods.waitForPageLoading();
		CommonMethods.scrollByParticularElement(byAllocationContainerID, "Container Location");
		actualContainerLocation = SeleniumActions.getText(byAllocationContainerID).trim();
		SeleniumActions.verifyTextEquals(actualContainerLocation, expectedContainerLocation);
	}

	/**
	 * Function to select Original Order 2.0 breadcrumb.
	 */
	public static void selectWaveRunsBreadcrumb() {
		SeleniumActions.click(byWaveRunsBreadCrumb, "Back to Original Order 2.0 main page");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to capture OLPN value from Wave Runs>OLPN screen
	 */
	public static void captureOLPNNumber() {
		String strOLPN = SeleniumActions.getText(byOLPN);
		if (strOLPN != null && !strOLPN.trim().isEmpty()) {
			Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "OLPN", strOLPN.replace("OLPN ID: ", ""));
		} else {
			FrameworkLogger.log(LogType.FAIL, "OLPN is null or empty");
		}
	}

	/**
	 * Function to get current Olpn status from Wave Run > Olpn window
	 */
	public static String getOLPNStatus() {
		String strStatus = SeleniumActions.getText(byOLPNStatusDescription);
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
	 * @param strExpected - OLPN status that need to be verified
	 */
	public static void verifyOLPNStatus(String strExpected) {
		String strStatus = getOLPNStatus();
		if (!strStatus.isEmpty()) {
			SeleniumActions.verifyTextEquals(strStatus, strExpected);
		}
	}

	/**
	 * Function to waverunTYpe and number of waveruns
	 */
	public static int getwavenumberType() {
		int waveTypeQty = DriverManager.getDriver().findElements(bywaverunType).size();
		return waveTypeQty;

	}

	/**
	 * Function to verify wave allocation details based on wave type
	 */
	public void verifyWaveAllocationDetailsbasedonWaveType() {
		int waverunsType = WaveRunsPage.getwavenumberType();
		for (int i = 1; i <= waverunsType; i++) {
			WaveRunsPage.selectDetailsForMultipleOrderLine(i);
			WaveRunsPage.expandContainerOrQuantity();
			WaveRunsPage.checkContainerQuantity(getDataFromFeature("getdata(Order_Line_Quantity" + i + ")"));
			WaveRunsPage.expandItem();
			WaveRunsPage.allocationItemID(getDataFromFeature("getdata(ItemID_Line" + i + ")"));
			WaveRunsPage.allocationBatchNumber(getDataFromFeature("getdata(BatchNo_Line2)"));
			WaveRunsPage.closeAllocation();
			FooterPanelPage.clickDeselectButton();

		}
	}

	/**
	 * Function to verify WAVE type
	 * @param lineQuantity - quantiy
	 */
	public static String getWaveTypeDes(int lineQuantity) {
		CommonMethods.waitForPageLoading();
		String waveDes = SeleniumActions.getText(By.xpath(
				"(//div/card-view[contains(@data-component-id,'Card-View')]//span[contains(@data-component-id,'AllocationTypeDescription')])["
						+ lineQuantity + "]"));
		return waveDes;
	}

	/**
	 * Function to click Wave Run Card in Wave Run
	 * @param WaveRun - wave run type
	 */
	public static void clickWaveRunCardInWaveRun(String WaveRun) {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(
				By.xpath(
						"//span[contains(text(),'" + WaveRun + "')]//following::div/span[contains(text(),'Pipeline')]"),
				"Pipeline");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click current Wave run status from Wave Run window
	 */
	public static void clickWaverunId() {

		SeleniumActions.click(byWaveRunId, "Clicked on wave Status");

		FrameworkLogger.log(LogType.PASS, "Clicked on wave run status");

	}

	/**
	 * Function to verify Allocation UOM is LPN under waverun allocations page
	 *
	 * @param expectedAllocationUomValue - expected Allocation UOM to be verified
	 */
	public static void verifyAllocationUomValue(String expectedAllocationUomValue) {

		String actualAllocationUomValue = SeleniumActions.getText(byAllocationUomValue).trim();
		SeleniumActions.verifyTextEquals(actualAllocationUomValue, expectedAllocationUomValue);
		CommonMethods.waitForPageLoading();

	}

	/**
	 * Function to Navigate to Allocation details Page
	 */
	public static void clickAllocationDetailsbutton() {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byDetailBtn, "Clicked on details button");
		CommonMethods.waitForPageLoading();
	}
}
