package web.Pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.dhl.constants.FrameworkConstants;
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
public class OriginalOrdersPage extends TestData_Json {

	private static final By byOriginalOrders2Page = By.xpath("//span[contains(text(),'Original Orders 2.0')]");
	private static final By byOriginalOrdersPage = By.xpath("//span[contains(text(),'Original Orders')]");
	private static final By byOrdersPage = By.xpath("//span[contains(text(),'Orders')]");
	private static final By byExportDataLoaderBtn = By.xpath("//button[contains(@data-component-id,'ExportDataLoader')]");
	private static final By byImportDataLoaderBtn = By.xpath("//button[contains(@data-component-id,'ImportDataLoader')]");
	private static final By byChooseFileBtn = By.xpath("//label[contains(text(),'Choose File')]");
	private static final By bySaveBtn = By.xpath("//ion-button[contains(text(),'SAVE')]");
	private static final By byRefreshBtn = By.xpath("//ion-button[contains(@data-component-id,'refresh')]");
	private static final By byRelatedLinks = By.xpath("//*[contains(text(),'Related Links')]");
	private static final By byTaskDetails = By.xpath("//*[text()='Task Details']");
	private static final By byOrderIdClick = By.xpath("//span[contains(@data-component-id,'OriginalOrderId')]");
	private static final By byFirstOrderCardforpickpack = By
			.xpath("(//span[contains(@data-component-id,'MaximumStatusDescription') and @title = 'Allocated'])[1]");
	private static final By byOrderLines = By.xpath("//*[text()='Order Lines']");
	private static final By byFilterClearAllBtn = By.xpath("//button[contains(@data-component-id,'clear-all-btn')]");
	private static final By byRunWaveConfirmMessageText = By.xpath("//div[contains(text(),'submitted')]");
	private static final By byFirstOrderCard = By
			.xpath("(//span[contains(@data-component-id,'MaximumStatusDescription') and @title = 'Released'])[1]");
	private static final By byFirstOrderIdforpickpack = By.xpath(
			"(//span[contains(@data-component-id,'MaximumStatusDescription') and @title = 'Allocated'])[1]/ancestor::card-view//a[contains(@data-component-id,'OrderId')]");
	private static final By byFirstOrderId = By.xpath(
			"(//span[contains(@data-component-id,'MaximumStatusDescription') and @title = 'Released'])[1]/ancestor::card-view//a[contains(@data-component-id,'OrderId')]");
	private static final By byFirstOriginalOrderId = By.xpath(
			"(//span[contains(@data-component-id,'MaximumStatusDescription') and @title = 'Released'])[1]/ancestor::card-view//span[@data-component-id='OriginalOrderId-card-view']");
	private static final By byOriginalOrderField = By.xpath("//ion-input[@data-component-id='OriginalOrderId-filter']/input");
	private static final By byExpandOriginalOrderfield = By
			.xpath("//span[@title='Original order']/following-sibling::ion-button[contains(@data-component-id,'expand-button')]");
	private static final By byItemField = By.xpath("//ion-input[contains(@data-component-id,'OriginalOrderLine.ItemId')]/input");
	private static final By byExpandItemfield = By
			.xpath("//span[@title='Item']/following-sibling::ion-button[contains(@data-component-id,'expand-button')]");
	private static final By byOrderField = By.xpath("//ion-input[@data-component-id='OriginalOrderId-filter']/input");
	private static final By byExpandOrderfield = By
			.xpath("//span[@title='Original order']/following-sibling::ion-button[contains(@data-component-id,'expand-button')]");
	private static final By byOrderStatusDescription = By.xpath("//div[contains(@data-component-id,'MinimumStatusDescription')]");
	private static final By byOrderLinesStatusDescription = By
			.xpath("//div[contains(@data-component-id,'OrderLineStatusDescription')]");
	private static final By byRunWaveBtn = By.xpath("//ion-button[contains(@data-component-id,'RunWave')]");
	private static final By bySubmitBtn = By.xpath("//ion-button[contains(@data-component-id,'submit-btn')]");
	private static final By byATStandardOrderStrategyBtn = By
			.xpath("//button[@data-component-id='ATStandardOrderStrategy-dropdown-list']");
	private static final By byPlanningStrategyId = By
			.xpath("//ion-input[contains(@data-component-id,'PlanningStrategyId')]/input");
	private static final By bytaskStatusfeild = By
			.xpath("//div[contains(@data-component-id,'DetailStatusDescription') and  @title='Created']");
	private static final By bytaskdetailsOrderIDfield = By.xpath("//a[contains(@data-component-id,'OrderId')]");
	private static final By bytaskoLPNfield = By.xpath("//a[contains(@data-component-id,'OlpnId')]");
	private static final By byDetailBtn = By.xpath("//ion-button[contains(@data-component-id,'Details')]");
	private static final By byExpandOrderLineNeed = By.xpath("//span[text()='Order Line Need']");
	private static final By byOrderedQuantity = By.xpath("//span[contains(@data-component-id,'OrderedQuantity')]");
	private static final By byBatchNumber = By.xpath("//div[contains(@data-component-id,'BatchNumber')]");
	private static final By byOrderLineItemID = By.xpath("//span[contains(@data-component-id,'ItemId')]");
	private static final By byOriginalOrderIdClick = By.xpath("//span[contains(text(),' Original order')]");
	private static final By byCloseExportBtn = By.xpath("//button//ion-icon[@name='close']");
	private static final By byMoreActions = By.xpath("//ion-button[contains(@data-component-id,'more-actions')]");
	private static final By byRunWaveButton = By.xpath("//ion-button[contains(@data-component-id,'RunWave')]");
	private static final By byOpenSlideOption = By
			.xpath("//slider-actions[contains(@data-component-id,'Slide-Actions')]//button[contains(@data-component-id,'action-closed')]");
	private static final By byCloseSlideOption = By
			.xpath("//div[contains(@class,'slideOptionList')]/button[contains(@data-component-id,'action-open')]");
	private static final By byupload = By.xpath("//*[@id='documentInputId']");
	private static final By byRequestInventoryAttributeValue = By
			.xpath("//div[contains(@data-component-id,'RequestedInventoryAttributeValue')]");
	private static final By byExpandOrderLineAttributes = By.xpath("//span[text()='Order Line Attributes']");
	private static final By byOrderLineAttributeValue = By
			.xpath("//div[contains(@data-component-id,'OrderLineAttributes-AttributeValue')]");

	private static final By byATStandardOrderStrategyDeselectShort = By
			.xpath("//button[contains(@data-component-id,'ATStandardOrderStrategyDeselectShort')]");

	private static final By byOrderLineIDValue = By
			.xpath("//*[@id='detailForm']//span[@data-component-id='OrderLineId-list-details']");

	private static final By byOriginalOrder2BreadCrumb = By.xpath("//a[@title='Original Orders 2.0']");
	private static final By byExpandWaveProcessing = By.xpath("//span[text()='Wave Processing']");
	private static final By byRunNumber = By.xpath("//div[@data-component-id='OrderPlanningRunId-list-expand']");
	private static final By byOriginalRunNumber = By.xpath("//div[@data-component-id='OriginalOrderPlanningRunId-list-expand']");
	private static final By byWaveAllocatedQuantity = By.xpath("//div[contains(@data-component-id,'AllocatedQuantity')]");
	private static final By byOrderPlanningStrategyPage = By
			.xpath("//span[contains(text(),'Order Planning Strategy')]");
	private static final By byCubingStrategyPage = By.xpath("//span[contains(@data-component-id,'CubingStrategy')]");
	private static final By byFNCUBING01OrderStrategy = By
			.xpath("//button[contains(@data-component-id,'FNCUBING01OrderStrategy')]");
	private static final By byOrdersList = By.xpath("//span[contains(@data-component-id,'OriginalOrderId')]");
	private static final By byPrioritiesList = By.xpath("//span[contains(@data-component-id,'Priority')]");
	private static final By byItemsList = By.xpath("//span[contains(@data-component-id,'ItemId')]");
	private static final By byOrderStatusesList = By.xpath("//span[contains(@data-component-id,'StatusDescription')]");
	private static final By byFNCUBING02OrderStrategy = By
			.xpath("//button[contains(@data-component-id,'FNCUBING02OrderStrategy')]");
	private static final By byFNCUBING03OrderStrategy = By
			.xpath("//button[contains(@data-component-id,'FNCUBING03OrderStrategy')]");
	private static final By byFNCUBING04OrderStrategy = By
			.xpath("//button[contains(@data-component-id,'FNCUBING04OrderStrategy')]");
	private static final By byATPickCartStrategy = By.xpath("//button[contains(@data-component-id,'ATPickCartStrategy')]");
	private static final By byRunWaveButtonwoMoreActions = By
			.xpath("//button[contains(@data-component-id,'FNCUBING03OrderStrategy')]");
	private static final By byATFP01 = By.xpath("//button[contains(@data-component-id,'ATFP01')]");
	private static final By byAllocationStrategyPage = By.xpath("//span[contains(text(),'Allocation Strategy')]");
	private static final By byOrderAtFirstIndex = By.xpath("(//span[contains(@data-component-id,'OriginalOrderId')])[1]");

	private static final By byRoutingStrategyPage = By.xpath("//*[@title='Routing Strategy']");
	private static final By byShipViaPage = By.xpath("//*[@title='Ship Via']");
	private static final By byFNROUTINGOrderStrategyBtn = By
			.xpath("//button[contains(@data-component-id,'FNROUTINGOrderStrategy')]");
	private static final By byFNCUBING06OrderStrategy = By
			.xpath("//button[contains(@data-component-id,'FNCUBING06OrderStrategy')]");

	private static final By byMoreActionsBtn = By.xpath("//ion-button[contains(@data-component-id,'more-actions')]");
	private static final By byRunWaveBtnFromMoreOptions = By.xpath("//ion-button[contains(@data-component-id,'RunWave')]");
	private static final By byOrderTextField = By.xpath("//ion-input[@data-component-id='OriginalOrderId-filter']/input");
	private static final By byExpandOrderField = By
			.xpath("//span[@title='Original order']/following-sibling::ion-button[contains(@data-component-id,'expand-button')]");
	private static final By byorderquantity = By.xpath("//modal-container//*[@data-component-id='OriginalOrderedQuantity-list-expand']");
	private static final By byProductStatus = By.xpath("//modal-container//*[contains(@data-component-id,'ProductStatusId')]");
	private static final By byInventory = By.xpath("//modal-container//*[contains(@data-component-id,'InventoryTypeId')]");
	private static final By byOrderStatus = By.xpath("//*[contains(@class,'neutral-button')]//*[@title='Released']");

	private static final By byFNROUTING06OrderStrategy = By
			.xpath("//button[contains(@data-component-id,'FNROUTING06OrderStrategy')]");

	private static final By byOriginalOrdersIds = By.xpath("//span[@data-component-id='OriginalOrderId-card-view']");
	private static final By byFNROUTINGOrderStrategy = By
			.xpath("//button[contains(@data-component-id,'FNROUTINGOrderStrategy')]");

	private static final By byOrderLineValue = By.xpath("//span[@data-component-id='OrderLineId-card-view']");

	/**
	 * Function to Verify Original Orders 2.0 Page is displayed
	 */
	public static void verifyOriginalOrders2PageDisplayed() {
		SeleniumActions.verifyElementVisible(byOriginalOrders2Page, 20, "Original Orders 2.0 page");
	}

	/**
	 * Function to Verify Original Orders Page is displayed
	 */
	public static void verifyOrdersPageDisplayed() {
		SeleniumActions.verifyElementVisible(byOrdersPage, 20, "Orders page");
	}

	/**
	 * Function to Verify Original Orders Page is displayed
	 */
	public static void verifyOriginalOrdersPageDisplayed() {
		SeleniumActions.verifyElementVisible(byOriginalOrdersPage, 20, "Original Orders page");
	}

	/**
	 * Function to select file to import
	 * 
	 * @param importFileName - file name
	 */
	public static void selectFiletoImport1(String importFileName) {
		SeleniumActions.click(byChooseFileBtn, "click Choose File button");
		GeneralUtils.wait(5 * 1000);
		String ImportFilePath = FrameworkConstants.getProjectPath() + "\\TestData\\ImportFiles\\";
		FrameworkLogger.log(LogType.INFO, "" + ImportFilePath + importFileName);
		ExcelUtil1.sendTextWithRobot(ImportFilePath + importFileName);// "OriginalOrder.xlsx");
		GeneralUtils.wait(5 * 1000);
		KeyboardActions.pressKeyboardKeyWithRobot(KeyboardKeys.ENTER);
		GeneralUtils.wait(5 * 1000);
		SeleniumActions.click(bySaveBtn, "click Save button");
	}

	/**
	 * Function to search Orders in Orders window
	 *
	 * @param strText - which need to searched
	 */
	public static void selectOrder(String strText) {
		CommonMethods.waitForPageLoading();
		String strOrderNumber = Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder")
				.toString(); // SeleniumActions.getText(byFirstOrderId);
		CommonMethods.waitForPageLoading();
		if (DriverManager.getDriver().findElements(byOrderField).size() < 1) {
			SeleniumActions.click(byExpandOrderfield, "Expand icon");
		}
		SeleniumActions.getElement(byOrderField).clear();
		SeleniumActions.sendTextToElement(byOrderField, strOrderNumber, "Order search field");
		CommonMethods.waitForPageLoading();
		KeyboardActions.pressEnterKey(byOrderField);
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byFirstOrderCard, "Order Card");
	}

	/**
	 * Function to select order for pick pack
	 *
	 */
	public static void selectOrderforpickpack() {
		CommonMethods.waitForPageLoading();
		String strOrderNumber = Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder")
				.toString();
		CommonMethods.waitForPageLoading();
		if (DriverManager.getDriver().findElements(byOrderField).size() < 1) {
			SeleniumActions.click(byExpandOrderfield, "Expand icon");
		}
		SeleniumActions.getElement(byOrderField).clear();
		SeleniumActions.sendTextToElement(byOrderField, strOrderNumber, "Order search field");
		CommonMethods.waitForPageLoading();
		KeyboardActions.pressEnterKey(byOrderField);
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byFirstOrderCardforpickpack, "Order Card");
	}

	/**
	 * Function to get current Order status from Orders/Original Orders window
	 */
	public static String getOrderStatus() {
		String strStatus = SeleniumActions.getText(byOrderStatusDescription);
		if (strStatus != null && !strStatus.trim().isEmpty()) {
			return strStatus.trim();
		} else {
			FrameworkLogger.log(LogType.FAIL, "Order Status description is null or empty");
		}
		return "";
	}

	/**
	 * Function to get current Orderlines status from Orders/Original Orders window
	 */
	public static String getOrderLinesStatus() {
		String strStatus = SeleniumActions.getText(byOrderLinesStatusDescription);
		if (strStatus != null && !strStatus.trim().isEmpty()) {
			return strStatus.trim();
		} else {
			FrameworkLogger.log(LogType.FAIL, "Order Status description is null or empty");
		}
		return "";
	}

	/**
	 * Function to verify Order status displayed
	 *
	 * @param strExpected - Order status that need to be verified
	 */
	public static void verifyOrderStatus(String strExpected) {
		String strStatus = getOrderStatus();
		if (!strStatus.isEmpty()) {
			SeleniumActions.verifyTextEquals(strStatus, strExpected);
			SeleniumActions.click(byOrderIdClick, "click On Order");
		}
	}

	/**
	 * Function to verify Order status displayed
	 *
	 * @param strExpected - Order status that need to be verified
	 */
	public static void verifyOrderLinesStatus(String strExpected) {
		String strStatus = getOrderLinesStatus();
		if (!strStatus.isEmpty()) {
			SeleniumActions.verifyTextEquals(strStatus, strExpected);
		}
	}

	/**
	 * Function to execute run wave
	 *
	 */
	public static void executeRunWave() {
		SeleniumActions.click(byRunWaveBtn, "RunWave button");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byPlanningStrategyId, "Order Planning Strategy ID");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byATStandardOrderStrategyBtn, "Select ATStandardOrderStrategyBtn");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(bySubmitBtn, "Submit button");
		CommonMethods.waitForPageLoading();
		OriginalOrdersPage.getWavenumber();
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to filter original order
	 *
	 */
	public static void filterOriginalOrder(String strText) {
		String strOrderNumber;
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byFilterClearAllBtn, "Clear All Filter button");
		CommonMethods.waitForPageLoading();
		if (strText != null && !strText.trim().isEmpty()) {
			strOrderNumber = strText;
		} else {
			strOrderNumber = SeleniumActions.getText(byFirstOriginalOrderId);
		}
		CommonMethods.waitForPageLoading();
		if (DriverManager.getDriver().findElements(byOriginalOrderField).size() < 1) {
			SeleniumActions.click(byExpandOriginalOrderfield, "Expand icon");
		}
		SeleniumActions.getElement(byOriginalOrderField).clear();
		SeleniumActions.sendTextToElement(byOriginalOrderField, strOrderNumber, "Original Order search field");
		CommonMethods.waitForPageLoading();
		KeyboardActions.pressEnterKey(byOriginalOrderField);
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(By.xpath("//span[contains(text(),'" + strOrderNumber + "')]"), "Original Order Card");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to copy olpn
	 *
	 */
	public static void copyoLPN() {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(bytaskStatusfeild, "Expand icon");
		CommonMethods.waitForPageLoading();
		String taskoLPNValue = SeleniumActions.getText(bytaskoLPNfield);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "taskoLPN", taskoLPNValue);
	}

	/**
	 * Function to search Wave run in wave runs window
	 *
	 * @param strText - wave run which need to searched
	 */
	public static void searchOrdersRuns(String strText) {
		CommonMethods.waitForPageLoading();
		if (DriverManager.getDriver().findElements(byOrderField).size() < 1) {
			SeleniumActions.click(byExpandOrderfield, "Expand icon");
		}
		SeleniumActions.getElement(byOrderField).clear();
		SeleniumActions.sendTextToElement(byOrderField, strText, "Orders search field");
		CommonMethods.waitForPageLoading();
		KeyboardActions.pressEnterKey(byOrderField);
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to check Original order is Available
	 *
	 * @param strOriginalOrder - order which need to be searched
	 */
	public static void isOriginalOrderAvailable(String strOriginalOrder) {
		String strOrderNumber;
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byFilterClearAllBtn, "Clear All Filter button");
		CommonMethods.waitForPageLoading();
		if (DriverManager.getDriver().findElements(byOriginalOrderField).size() < 1) {
			SeleniumActions.click(byExpandOriginalOrderfield, "Expand icon");
		}
		SeleniumActions.getElement(byOriginalOrderField).clear();
		SeleniumActions.sendTextToElement(byOriginalOrderField, strOriginalOrder, "Original Order search field");
		CommonMethods.waitForPageLoading();
		KeyboardActions.pressEnterKey(byOriginalOrderField);
		CommonMethods.waitForPageLoading();
		if (DriverManager.getDriver().findElements(By.xpath("//span[contains(text(),'" + strOriginalOrder + "')]"))
				.size() > 0) {
			if (SeleniumActions.getText(byOrderStatusDescription).equals("Released")) {
				SeleniumActions.click(By.xpath("//span[contains(text(),'" + strOriginalOrder + "')]"),
						"Original Order Card");
				Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "isOriginalOrderPresent", "true");
			} else {
				Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "isOriginalOrderPresent", "false");
			}
		}
	}

	/**
	 * Function to click Details in Order Line
	 */
	public static void selectDetailsInOrderLine() {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byOriginalOrderIdClick, "Original Order Id");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byDetailBtn, "Details Button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to expand Order Line Need in Order Line
	 */
	public static void expandOrderLineNeed() {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byExpandOrderLineNeed, "Expand Order Line Need");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click More Actions in Original Orders
	 */
	public static void clickMoreActions() {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byMoreActions, "More Actions:");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to Execute Run Wave from Orders
	 */
	public static void executeRunWaveForOrder() {
		if (DriverManager.getDriver().findElements(byRunWaveButton).size() > 0) {
			SeleniumActions.click(byRunWaveButton, "RunWave button");
		} else {
			SeleniumActions.click(byRunWaveBtn, "RunWave button");
		}
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byPlanningStrategyId, "Order Planning Strategy ID");
		CommonMethods.waitForPageLoading();
		GeneralUtils.wait(5 * 1000);
		SeleniumActions.click(byATStandardOrderStrategyBtn, "Select ATStandardOrderStrategyBtn");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(bySubmitBtn, "Submit button");
		CommonMethods.waitForPageLoading();
		OriginalOrdersPage.getWaveNumberFromOriginalOrder();
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to check order has Item and Batch Number
	 *
	 * @param strOriginalOrder - order which need to be searched
	 */
	public static void orderHasItemAndBatchNumber(String strOriginalOrder) {
		String strOrderNumber;
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byFilterClearAllBtn, "Clear All Filter button");
		CommonMethods.waitForPageLoading();
		if (DriverManager.getDriver().findElements(byBatchNumber).size() > 0) {
			Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "orderedQuantity",
					SeleniumActions.getText(byOrderedQuantity));
			if (SeleniumActions.getText(byOrderLineItemID).equals(getDataFromFeature("getdata(ItemID_Line1)"))) {
				if (SeleniumActions.getText(byBatchNumber).equals(getDataFromFeature("getdata(BatchNo_Line1)"))) {
					Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "hasItemAndBatch", "true");
				}
			} else {
				Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "hasItemAndBatch", "false");
			}
		}
		SeleniumActions.click(byCloseExportBtn, "Close Order Line");
		CommonMethods.waitForPageLoading();

	}

	/**
	 * Function to get Wave Number status from Orders/Original Orders window
	 */
	public static String getWaveNumberFromOriginalOrder() {
		String strWaveMessage = SeleniumActions.getText(byRunWaveConfirmMessageText);
		String strWaveNumber = "";
		if (strWaveMessage != null && !strWaveMessage.trim().isEmpty()) {
			FrameworkLogger.log(LogType.INFO, "Wave :" + strWaveMessage.trim());
			strWaveNumber = strWaveMessage.replace("Order planning run", "");
			strWaveNumber = strWaveNumber.replace(" submitted (DCO::169)", "");
			Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "WaveRun", strWaveNumber.trim());
		}
		return strWaveNumber.trim();
	}

	/**
	 * Function to get wave number
	 *
	 */
	public static String getWavenumber() {
		String strWaveMessage = SeleniumActions.getText(byRunWaveConfirmMessageText);
		if (strWaveMessage != null && !strWaveMessage.trim().isEmpty()) {
			FrameworkLogger.log(LogType.INFO, "Wave :" + strWaveMessage.trim());
			String strWaveNumber = strWaveMessage.replace("Wave", "");
			strWaveNumber = strWaveNumber.replace("is submitted (info)", "");
			Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "WaveRun", strWaveNumber.trim());
			return strWaveNumber.trim();
		} else {
			FrameworkLogger.log(LogType.FAIL, "Wave Status description is null or empty");
		}
		return "";
	}

	/**
	 * Function to click Details for Multiple Order Line
	 * 
	 * @param lineQuantity - line quantity
	 */
	public static void selectDetailsForMultipleOrderLine(int lineQuantity) {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(
				By.xpath(
						"//span[@data-component-id='OriginalOrderLineId-card-view' and contains(text(),'" + lineQuantity + "')]"),
				"Original Order Id");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byDetailBtn, "Details Button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to check order has Item and Batch Number for Multiple Line
	 *
	 * @param batchNumber - batchNumber which need to be verified
	 * @param itemID      - itemId which need to be verified
	 */
	public static void orderHasItemAndBatchNumberMultipleLine(String batchNumber, String itemID, String quantity) {
		String strOrderNumber;
		CommonMethods.waitForPageLoading();
		if (DriverManager.getDriver().findElements(byBatchNumber).size() > 0) {
			if (SeleniumActions.getText(byOrderLineItemID).equals(itemID)) {
				if (SeleniumActions.getText(byBatchNumber).equals(batchNumber)) {
					if (SeleniumActions.getText(byOrderedQuantity).equals(quantity)) {
						Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "hasItemBatchAndQuantity", "true");
					}
				}
			} else {
				Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "hasItemBatchAndQuantity", "false");
			}
		}
		SeleniumActions.click(byCloseExportBtn, "Close Order Line");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to check Item ID in Orders Line Need
	 *
	 * @param expectedItemID - Item ID to be verified
	 */
	public static void orderHasItemIDInOrderLineNeed(String expectedItemID) {
		String actualItemID;
		CommonMethods.waitForPageLoading();
		CommonMethods.scrollByParticularElement(byOrderLineItemID, "Item ID");
		actualItemID = SeleniumActions.getText(byOrderLineItemID).trim();
		SeleniumActions.verifyTextEquals(actualItemID, expectedItemID);
	}

	/**
	 * Function to check Batch Number in Orders Line Need
	 *
	 * @param expectedBatchNumber - Batch Number to be verified
	 */
	public static void orderHasBatchNumberInOrderLineNeed(String expectedBatchNumber) {
		String actualBatchNumber;
		CommonMethods.waitForPageLoading();
		CommonMethods.scrollByParticularElement(byBatchNumber, "Batch Number");
		CommonMethods.waitForPageLoading();
		actualBatchNumber = DriverManager.getDriver().findElement(byBatchNumber).getText();
		SeleniumActions.verifyTextEquals(actualBatchNumber, expectedBatchNumber);
	}

	/**
	 * Function to check Quantity in Orders Line Need
	 *
	 * @param expectedQuantity - Quantity to be verified
	 */
	public static void orderHasQuantityInOrderLineNeed(String expectedQuantity) {
		String actualQuantity;
		CommonMethods.waitForPageLoading();
		CommonMethods.scrollByParticularElement(byOrderedQuantity, "Quantity");
		actualQuantity = SeleniumActions.getText(byOrderedQuantity).trim();
		SeleniumActions.verifyTextEquals(actualQuantity, expectedQuantity);
	}

	/**
	 * Function to check Serial Number in Orders Line Need
	 *
	 * @param expectedSerialNumber - Serial Number to be verified
	 */
	public static void orderHasSerialNumberInOrderLineNeed(String expectedSerialNumber) {
		String actualSerialNumber;
		CommonMethods.waitForPageLoading();
		CommonMethods.scrollByParticularElement(byRequestInventoryAttributeValue, "Request Inventory Attribute Value");
		actualSerialNumber = SeleniumActions.getText(byRequestInventoryAttributeValue).trim();
		SeleniumActions.verifyTextEquals(actualSerialNumber, expectedSerialNumber);
	}

	/**
	 * Function to expand Order Line Attributes in Order Line
	 */
	public static void expandOrderLineAttributes() {
		CommonMethods.scrollByParticularElement(byExpandOrderLineAttributes, "Order Line Attributes");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byExpandOrderLineAttributes, "Expand Order Line Attributes");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to check Serial Number in Orders Line Attributes
	 *
	 * @param expectedSerialNumber - Serial Number to be verified
	 */
	public static void orderHasSerialNumberInOrderLineAttributes(String expectedSerialNumber) {
		String actualSerialNumber;
		CommonMethods.waitForPageLoading();
		CommonMethods.scrollByParticularElement(byOrderLineAttributeValue, "Order Line Attribute Value");
		actualSerialNumber = SeleniumActions.getText(byOrderLineAttributeValue).trim();
		SeleniumActions.verifyTextEquals(actualSerialNumber, expectedSerialNumber);
	}

	/**
	 * Function to close Order Line
	 */
	public static void closeOrderLine() {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byCloseExportBtn, "Close Order Line");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to get all Orderlines statuses from Orders/Original Orders window
	 */
	public static List<String> getAllOrderLinesStatus() {
		List<WebElement> orderLineStatus = DriverManager.getDriver().findElements(byOrderLinesStatusDescription);
		List<String> listOfOrderLineStatus = new ArrayList<>();
		for (WebElement element : orderLineStatus) {
			listOfOrderLineStatus.add(element.getText().trim());
		}
		FrameworkLogger.log(LogType.INFO, "list Of order line status stored in variables:- " + listOfOrderLineStatus);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "listOfOrderLineStatus", listOfOrderLineStatus);
		return listOfOrderLineStatus;
	}

	/**
	 * Function to verify OrderLine status displayed
	 *
	 * @param strExpected - Order Line status that needs to be verified
	 */
	public static void verifyOrderLinesStatuses(String strExpected) {
		List<String> strStatus = getAllOrderLinesStatus();
		for (String status : strStatus) {
			SeleniumActions.verifyTextEquals(status, strExpected);
		}
	}

	/**
	 * Function to execute run wave for order for AT standerd strategy
	 *
	 */
	public static void executeRunWaveForOrderATStandardOrderStrategyDeselectShort() {
		CommonMethods.waitForPageLoading();
		WebElement runElement = DriverManager.getDriver().findElement(byRunWaveBtn);
		boolean isElementPresent = runElement.isDisplayed();
		if (isElementPresent) {
			CommonMethods.waitForPageLoading();
			SeleniumActions.click(byRunWaveBtn, "Run Wave button");
		} else {
			FooterPanelPage.clickMoreButton();
			SeleniumActions.click(byRunWaveButton, "RunWave button from More Options");
		}

//		SeleniumActions.click(byRunWaveButton, "RunWave button");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byPlanningStrategyId, "Order Planning Strategy ID");
		CommonMethods.waitForPageLoading();
		GeneralUtils.wait(5 * 1000);
		SeleniumActions.click(byATStandardOrderStrategyDeselectShort, "Select ATStandardOrderStrategyBtn");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(bySubmitBtn, "Submit button");
		CommonMethods.waitForPageLoading();
		OriginalOrdersPage.getWaveNumberFromOriginalOrder();
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to Store Order Line from Order Line Popup Window
	 */
	public static String getOrderLineIDFromOrderLinePopUp() {
		CommonMethods.waitForPageLoading();
		String orderLineID = SeleniumActions.getText(byOrderLineIDValue).trim();
		CommonMethods.waitForPageLoading();
		return orderLineID;
	}

	/**
	 * Function to select Original Order 2.0 breadcrumb.
	 */
	public static void selectOriginalOrderBreadcrumb() {
		SeleniumActions.click(byOriginalOrder2BreadCrumb, "Back to Original Order 2.0 main page");

	}

	/**
	 * Function tO submit Runwave using ATStandardOrderStrategy
	 */
	public static void executeRunWaveForOrderATStandardOrderStrategy() {

		if (DriverManager.getDriver().findElements(byRunWaveBtn).size() > 0) {
			SeleniumActions.click(byRunWaveBtn, "RunWave button");
		} else {
			OriginalOrdersPage.clickMoreActions();
			SeleniumActions.click(byRunWaveButton, "RunWave button");
		}

		/*
		 * if (SeleniumActions.isElementPresent(byRunWaveButtonwoMoreActions, 5) ==
		 * true) { SeleniumActions.click(byRunWaveButtonwoMoreActions,
		 * "RunWave button"); } else { OriginalOrdersPage.clickMoreActions();
		 * SeleniumActions.click(byRunWaveButton, "RunWave button"); }
		 */
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byPlanningStrategyId, "Order Planning Strategy ID");
		CommonMethods.waitForPageLoading();
		GeneralUtils.wait(5 * 1000);
		SeleniumActions.click(byATStandardOrderStrategyBtn, "Select ATStandardOrderStrategyBtn");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(bySubmitBtn, "Submit button");
		CommonMethods.waitForPageLoading();
		OriginalOrdersPage.getWaveNumberFromOriginalOrder();
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click Order Card in Original Order
	 * 
	 * @param OriginalOrder - original order id
	 */
	public static void clickOrderCardInOriginalOrder(String OriginalOrder) {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(By.xpath(
				"//span[contains(text(),'" + OriginalOrder + "')]//following::div/span[contains(text(),'Order type')]"),
				"Order type");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to check no Serial Number in Orders Line Need
	 * 
	 * @param expectedSerialNumber - expected serial number
	 */
	public static void orderHasNoSerialNumberInOrderLineNeed(String expectedSerialNumber) {
		String actualSerialNumber;
		CommonMethods.waitForPageLoading();
		CommonMethods.scrollByParticularElement(byRequestInventoryAttributeValue, "Request Inventory Attribute Value");
		if (expectedSerialNumber == null) {
			if (DriverManager.getDriver().findElements(byRequestInventoryAttributeValue).size() == 0) {
				FrameworkLogger.log(LogType.PASS, "Serial number is not displayed as expected");
			}
		}
	}

	/**
	 * Function to verify OrderLine with different statuses displayed
	 *
	 * @param strExpected1 - Order Line status that needs to be verified
	 */
	public static void verifyOrderLinesStatuses(String strExpected1, String strExpected2) {
		List<String> strStatus = getAllOrderLinesStatus();
		SeleniumActions.verifyTextEquals(strStatus.get(0), strExpected1);
		SeleniumActions.verifyTextEquals(strStatus.get(1), strExpected2);
	}

	/**
	 * Function to expand Wave processing in Order Line
	 */
	public static void expandWaveProcessing() {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byExpandWaveProcessing, "Expand Wave Processing");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to check Wave Run Number in Wave Processing
	 *
	 * @param expectedRunNumber - Run Number to be verified
	 */
	public static void orderHasRunNumber(String expectedRunNumber) {
		String actualRunNumber;
		CommonMethods.scrollByParticularElement(byRunNumber, "Run Number");
		if (expectedRunNumber == null) {
			if (DriverManager.getDriver().findElements(byRunNumber).size() == 0) {
				FrameworkLogger.log(LogType.PASS, "Run wave number is not displayed as expected");
			}
		} else {
			CommonMethods.waitForPageLoading();
			actualRunNumber = SeleniumActions.getText(byRunNumber).trim();
			SeleniumActions.verifyTextEquals(actualRunNumber, expectedRunNumber);
			FrameworkLogger.log(LogType.PASS, "Run wave number is displayed as expected");
		}
	}

	/**
	 * Function to check Original Run Number in Wave Processing
	 *
	 * @param expectedOriginalRunNumber - Original Run Number to be verified
	 */
	public static void orderHasOriginalRunNumber(String expectedOriginalRunNumber) {
		String actualOriginalRunNumber;
		CommonMethods.waitForPageLoading();
		CommonMethods.scrollByParticularElement(byOriginalRunNumber, "Original Run Number");
		if (expectedOriginalRunNumber == null) {
			if (DriverManager.getDriver().findElements(byRunNumber).size() == 0) {
				FrameworkLogger.log(LogType.PASS, "Original Run number is not displayed as expected");
			}
		} else {
			actualOriginalRunNumber = SeleniumActions.getText(byOriginalRunNumber).trim();
			SeleniumActions.verifyTextEquals(actualOriginalRunNumber, expectedOriginalRunNumber);
			FrameworkLogger.log(LogType.PASS, "Original Run number is displayed as expected");
		}
	}

	/**
	 * Function to check Allocated Quantity in Wave Processing
	 *
	 * @param expectedAllocatedQuantity - Allocated Quantity to be verified
	 */
	public static void verifyAllocatedQuantityinWaveProcessing(String expectedAllocatedQuantity) {
		String actualAllocatedQuantity;
		CommonMethods.waitForPageLoading();
		CommonMethods.scrollByParticularElement(byWaveAllocatedQuantity, "Wave Allocated Quantity");
		actualAllocatedQuantity = SeleniumActions.getText(byWaveAllocatedQuantity).trim();
		SeleniumActions.verifyTextEquals(actualAllocatedQuantity, expectedAllocatedQuantity);
		FrameworkLogger.log(LogType.PASS,
				"Allocated Quantity" + expectedAllocatedQuantity + "is displayed as expected");
	}

	/**
	 * Function to click Details based on Order Line Status
	 * 
	 * @param OrderLineStatus - order line status
	 */
	public static void selectDetailsBasedOnOrderStatus(String OrderLineStatus) {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(By.xpath("//div[contains(@data-component-id,'OrderLineStatusDescription') and @title='"
				+ OrderLineStatus + "']//ancestor::card-view//span[@data-component-id='OrderLineId-card-view']"),
				"Original Order Id");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byDetailBtn, "Details Button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to verify order planning strategy
	 *
	 */
	public static void verifyOrderPlanningStrategyPage() {
		SeleniumActions.verifyElementVisible(byOrderPlanningStrategyPage, 20, "Order Planning Strategy Page");
	}

	/**
	 * Function to verify cubing strategy
	 *
	 */
	public static void verifyCubingStrategyPage() {
		SeleniumActions.verifyElementVisible(byCubingStrategyPage, 20, "Cubing Strategy Page");
	}

	/**
	 * Function to verify container type
	 *
	 */
	public static void verifyContainerType() {
		SeleniumActions.verifyElementVisible(byCubingStrategyPage, 20, "Container Type Page");
	}

	/**
	 * Function to execute run wave for FNCUBING01
	 *
	 */
	public static void executeRunWaveFNCUBING01OrderStrategy() {
		CommonMethods.waitForPageLoading();
		WebElement runElement = DriverManager.getDriver().findElement(byRunWaveBtn);
		boolean isElementPresent = runElement.isDisplayed();
		if (isElementPresent) {
			CommonMethods.waitForPageLoading();
			SeleniumActions.click(byRunWaveBtn, "Run Wave button");
		} else {
			FooterPanelPage.clickMoreButton();
			SeleniumActions.click(byRunWaveButton, "RunWave button from More Options");
		}
//		SeleniumActions.click(byRunWaveBtn, "RunWave button");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byPlanningStrategyId, "Order Planning Strategy ID");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byFNCUBING01OrderStrategy, "Select FNCUBING01OrderStrategy");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(bySubmitBtn, "Submit button");
		CommonMethods.waitForPageLoading();
		OriginalOrdersPage.getWaveNumberFromOriginalOrder();
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to verify multiple Orders
	 *
	 * @param Orders - value which need to be verified
	 */
	public static void verifyMultipleOrders(String Orders) {
		List<String> expectedOrders = new ArrayList<>(Arrays.asList(Orders.split(",")));
		List<WebElement> elements = DriverManager.getDriver().findElements(byOrdersList);
		List<String> actualOrders = new ArrayList<>();
		for (WebElement e : elements) {
			actualOrders.add(e.getText());
		}
		if (expectedOrders.equals(actualOrders)) {
			FrameworkLogger.log(LogType.PASS, "Orders Verification passed : " + expectedOrders);
		} else {
			FrameworkLogger.log(LogType.FAIL,
					"Orders Verification failed. Expected :" + expectedOrders + " , Actual :" + actualOrders);
		}
	}

	/**
	 * Function to verify multiple Priorities
	 *
	 * @param priorities - value which need to be verified
	 */
	public static void verifyMultiplePriorities(String priorities) {
		List<String> expectedPriorities = new ArrayList<String>(Arrays.asList(priorities.split(",")));
		List<WebElement> elements = DriverManager.getDriver().findElements(byPrioritiesList);
		List<String> actualPriorities = new ArrayList<>();
		for (WebElement e : elements) {
			actualPriorities.add(e.getText());
		}
		if (expectedPriorities.equals(actualPriorities)) {
			FrameworkLogger.log(LogType.PASS, "Priorities Verification passed : " + expectedPriorities);
		} else {
			FrameworkLogger.log(LogType.FAIL, "Priorities Verification failed. Expected :" + expectedPriorities
					+ " , Actual :" + actualPriorities);
		}
	}

	/**
	 * Function to verify multiple Items
	 *
	 * @param Items - value which need to be verified
	 */
	public static void verifyMultipleItems(String Items) {
		List<String> expectedItems = new ArrayList<String>(Arrays.asList(Items.split(",")));
		List<WebElement> elements = DriverManager.getDriver().findElements(byItemsList);
		List<String> actualItems = new ArrayList<>();
		for (WebElement e : elements) {
			actualItems.add(e.getText());
		}
		if (expectedItems.equals(actualItems)) {
			FrameworkLogger.log(LogType.PASS, "Items Verification passed : " + expectedItems);
		} else {
			FrameworkLogger.log(LogType.FAIL,
					"Items Verification failed. Expected :" + expectedItems + " , Actual :" + actualItems);
		}
	}

	/**
	 * Function to verify multiple Order Statuses
	 *
	 * @param Statuses - Statuses value which need to be verified
	 */
	public static void verifyMultipleOrderStatuses(String Statuses) {
		List<String> expectedStatuses = new ArrayList<String>(Arrays.asList(Statuses.split(",")));
		List<WebElement> elements = DriverManager.getDriver().findElements(byOrderStatusesList);
		List<String> actualStatuses = new ArrayList<>();
		for (WebElement e : elements) {
			actualStatuses.add(e.getText());
		}
		if (expectedStatuses.equals(actualStatuses)) {
			FrameworkLogger.log(LogType.PASS, "Order Statuses Verification passed : " + expectedStatuses);
		} else {
			FrameworkLogger.log(LogType.FAIL, "Order Statuses Verification failed. Expected :" + expectedStatuses
					+ " , Actual :" + actualStatuses);
		}
	}

	/**
	 * Function to verify verifyOrderLineNeed And OrderLineAttributes
	 *
	 * @param orders - value which need to be verified
	 */
	public static void verifyOrderLineNeedAndOrderLineAttributesForMultipleOrders(String orders) {

		List<WebElement> elements = CommonPage.getRowElements();
		for (WebElement e : elements) {
			CommonMethods.scrollByParticularElement(e, "Order Row element");
			e.click();
			CommonMethods.waitForPageLoading();
			FooterPanelPage.clickDetailsButton();
			OrderLinePopupPage.clickOrderLineNeedHeader();
			String orderedQuantity = getDataFromFeature("getdata(OrderedQuantity)");
			String inventoryType = getDataFromFeature("getdata(InventoryTypeID)");
			String productStatus = getDataFromFeature("getdata(ProductStatusID)");
			CommonMethods.waitForPageLoading();
			OrderLinePopupPage.verifyOrderedQuantity(orderedQuantity);
			CommonMethods.waitForPageLoading();
			OrderLinePopupPage.verifyProductStatus(productStatus);
			CommonMethods.waitForPageLoading();
			OrderLinePopupPage.verifyInventoryType(inventoryType);
			OrderLinePopupPage.clickOrderLineNeedAttributes();
			OrderLinePopupPage.verifyNoDataToDisplayLabel();
			CommonPopupPage.clickCloseIcon();
			e.click();
			CommonMethods.waitForPageLoading();
		}
	}

	/**
	 * Function to verify verifyOrderLineNeed And OrderLineAttributes
	 *
	 * @param orders - value which need to be verified
	 */
	public static void NotWorking_verifyOrderLineNeedAndOrderLineAttributesForMultipleOrders(String orders) {

		List<WebElement> elments = CommonPage.getRowElements();
		for (WebElement e : elments) {
			CommonMethods.scrollByParticularElement(e, "Order Row element");
			e.click();
			CommonMethods.waitForPageLoading();
			HeaderPanelPage.clickRelatedLinksButton();
			HeaderPanelPage.clickOrderLinesLink();
			CommonPage.clickRowAtFirstIndex();
			FooterPanelPage.clickDetailsButton();
			OrderLinePopupPage.clickOrderLineNeedHeader();
			String inventoryType = getDataFromFeature("getdata(InventoryTypeID)");
			String productStatus = getDataFromFeature("getdata(ProductStatusID)");
			OrderLinePopupPage.verifyProductStatus(productStatus);
			OrderLinePopupPage.verifyInventoryType(inventoryType);
			OrderLinePopupPage.clickOrderLineNeedAttributes();
			OrderLinePopupPage.verifyNoDataToDisplayLabel();
			CommonPopupPage.clickCloseIcon();
			CommonPage.clickMenuWithTitle("Original Orders 2.0");
			elments = CommonPage.getRowElements();
			CommonMethods.waitForPageLoading();
		}
	}

	/**
	 * Function to verify verifyOrderLineNeed And OrderLineAttributes
	 */
	public static void verifyOrderLineNeedAndOrderLineAttributesForOrder() {
		String inventoryType = getDataFromFeature("getdata(InventoryTypeID)");
		String productStatus = getDataFromFeature("getdata(ProductStatusID)");
		String batchNumber = getDataFromFeature("getdata(BatchNumber)");
		CommonPage.clickRowAtFirstIndex();
		FooterPanelPage.clickDetailsButton();
		OrderLinePopupPage.clickOrderLineNeedHeader();
		OrderLinePopupPage.verifyProductStatus(productStatus);
		OrderLinePopupPage.verifyInventoryType(inventoryType);
		OrderLinePopupPage.verifyBatchNumber(batchNumber);
		OrderLinePopupPage.clickOrderLineNeedAttributes();
		OrderLinePopupPage.verifyNoDataToDisplayLabel();
		CommonPopupPage.clickCloseIcon();
	}

	/**
	 * Function to execute run wave for FNCUBING02 strategy
	 *
	 */
	public static void executeRunWaveFNCUBING02OrderStrategy() {
		WebElement runElement = DriverManager.getDriver().findElement(byRunWaveBtn);
		boolean isElementPresent = runElement.isDisplayed();
		if (isElementPresent) {
			CommonMethods.waitForPageLoading();
			SeleniumActions.click(byRunWaveBtn, "Run Wave button");
		} else {
			FooterPanelPage.clickMoreButton();
			SeleniumActions.click(byRunWaveButton, "RunWave button from More Options");
		}
//		OriginalOrdersPage.clickMoreActions();
		// OriginalOrdersPage.executeRunWaveForOrder();
//		SeleniumActions.click(byRunWaveButton, "RunWave button");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byPlanningStrategyId, "Order Planning Strategy ID");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byFNCUBING02OrderStrategy, "Select FNCUBING02OrderStrategy");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(bySubmitBtn, "Submit button");
		CommonMethods.waitForPageLoading();
		OriginalOrdersPage.getWaveNumberFromOriginalOrder();
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to execute run wave for FNCUBING03 strategy
	 *
	 */
	public static void executeRunWaveFNCUBING03OrderStrategy() {
		SeleniumActions.click(byRunWaveBtn, "RunWave button");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byPlanningStrategyId, "Order Planning Strategy ID");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byFNCUBING03OrderStrategy, "Select FNCUBING03OrderStrategy");
		CommonMethods.waitForPageLoading();

	}

	/**
	 * Function to execute run wave for FNCUBING04 strategy
	 *
	 */
	public static void executeRunWaveFNCUBING04OrderStrategy() {
		SeleniumActions.click(byRunWaveBtn, "RunWave button");
		CommonMethods.waitForPageLoading();
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byPlanningStrategyId, "Order Planning Strategy ID");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byFNCUBING04OrderStrategy, "Select FNCUBING04OrderStrategy");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(bySubmitBtn, "Submit button");
		CommonMethods.waitForPageLoading();
		OriginalOrdersPage.getWaveNumberFromOriginalOrder();
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to completeOrderStrategy
	 *
	 * @param strategy - value which need to be verified
	 */
	public static void completeOrderStrategy(String strategy) {
		List<WebElement> elements = CommonPage.getRowElements();
		for (WebElement e : elements) {
			CommonMethods.scrollByParticularElement(e, "Row element");
			e.click();
			CommonMethods.waitForPageLoading();
		}
		FooterPanelPage.clickRunWaveButton();
		CommonMethods.waitForPageLoading();
		selectOrderPlanningStrategyId(strategy);

		SeleniumActions.click(bySubmitBtn, "Submit button");
		CommonMethods.waitForPageLoading();
		OriginalOrdersPage.getWaveNumberFromOriginalOrder();
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to selectOrderPlanningStrategyId
	 *
	 * @param strategy -value to be selected
	 */
	public static void selectOrderPlanningStrategyId(String strategy) {
		SeleniumActions.click(byPlanningStrategyId, "Order Planning Strategy ID");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(By.xpath("//button[@data-component-id='" + strategy + "']"), strategy);
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to run AT Pick Cart Strategy
	 */
	public static void executeRunWaveATPickCartStrategy() {
		SeleniumActions.click(byRunWaveBtn, "RunWave button");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byPlanningStrategyId, "Order Planning Strategy ID");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byATPickCartStrategy, "Select AT Pick Cart Strategy");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(bySubmitBtn, "Submit button");
		CommonMethods.waitForPageLoading();
		OriginalOrdersPage.getWaveNumberFromOriginalOrder();
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to execute run wave for ATFP01
	 *
	 */
	public static void executeRunWaveATFP01() {
		if (DriverManager.getDriver().findElements(byRunWaveBtn).size() > 0) {
			SeleniumActions.click(byRunWaveBtn, "RunWave button");
		} else {
			OriginalOrdersPage.clickMoreActions();
			SeleniumActions.click(byRunWaveButton, "RunWave button");
		}
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byPlanningStrategyId, "Order Planning Strategy ID");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byATFP01, "Select ATFP01");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(bySubmitBtn, "Submit button");
		CommonMethods.waitForPageLoading();
		OriginalOrdersPage.getWaveNumberFromOriginalOrder();
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to verify allocation strategy
	 *
	 */
	public static void verifyAllocationStrategyPage() {
		SeleniumActions.verifyElementVisible(byAllocationStrategyPage, 20, "Allocation Strategy Page");
	}

	public static void verifyOrderAtFirstIndex(String order) {
		order = order.replaceAll("-", "");
		String actualItem = DriverManager.getDriver().findElement(byOrderAtFirstIndex).getText();
		actualItem = actualItem.replaceAll("-", "");
		if (order.equals(actualItem)) {
			FrameworkLogger.log(LogType.PASS, "Order Verification passed : " + order);
		} else {
			FrameworkLogger.log(LogType.FAIL,
					"Order Verification failed. Expected :" + order + " , Actual :" + actualItem);
		}

	}

	/**
	 * Function to Verify Order line details for multiple orders
	 */
	public static void verifyOrderLineDetailsForMultipleOrders() {
		String listoforders = getDataFromFeature("getdata(Orders)");
//		final By byOrderTextField = By.xpath("//ion-input[contains(@data-component-id,'OriginalOrderId')]/input");
//		final By byExpandOrderField = By.xpath("//span[@title='Original order']/following-sibling::ion-button[contains(@data-component-id,'expand-button')]");

		List<String> expectedorders = new ArrayList<String>(Arrays.asList(listoforders.split(",")));

		for (String singleItem : expectedorders) {
			final By bylistoforder = By.xpath("(//*[@title='" + singleItem + "'])[1]");

			CommonMethods.waitForPageLoading();
			if (DriverManager.getDriver().findElements(byOrderTextField).size() < 1) {
				SeleniumActions.click(byExpandOrderField, "Expand icon");
			}
			SeleniumActions.getElement(byOrderTextField).clear();
			SeleniumActions.sendTextToElement(byOriginalOrderField, singleItem, "Item ID Text Field");
			CommonMethods.waitForPageLoading();
			KeyboardActions.pressEnterKey(byOriginalOrderField);
			CommonMethods.waitForPageLoading();
			SeleniumActions.click(bylistoforder, "Select the Order");
			HeaderPanelPage.clickRelatedLinksButton();
			HeaderPanelPage.clickOrderLinesLink();
			CommonMethods.waitForPageLoading();
			OriginalOrdersPage.selectDetailsInOrderLine();
			OriginalOrdersPage.expandOrderLineNeed();
			OriginalOrdersPage.expandOrderLineAttributes();
			OriginalOrdersPage.closeOrderLine();
			FooterPanelPage.clickDeselectButton();
			OriginalOrdersPage.selectOriginalOrderBreadcrumb();
			CommonMethods.waitForPageLoading();
		}

	}

	/**
	 * Function to Verify Routing Strategy Page
	 */
	public static void verifyRoutingStrategyPage() {
		SeleniumActions.verifyElementVisible(byRoutingStrategyPage, 20, "Routing Strategy Page");
	}

	/**
	 * Function to Verify Order line details for imported orders
	 */
	public static void verifyOrderLineDetailsForimportedOrders(String Orders) {
		String listoforders = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + Orders);
		List<String> expectedorders = new ArrayList<String>(Arrays.asList(listoforders.split(",")));

		for (String singleOrder : expectedorders) {
			final By bylistoforder = By.xpath("(//*[@title='" + singleOrder + "'])[1]");

			CommonMethods.waitForPageLoading();
			if (DriverManager.getDriver().findElements(byOrderTextField).size() < 1) {
				SeleniumActions.click(byExpandOrderField, "Expand icon");
			}
			SeleniumActions.getElement(byOrderTextField).clear();
			SeleniumActions.sendTextToElement(byOrderTextField, singleOrder, "Item ID Text Field");
			CommonMethods.waitForPageLoading();
			KeyboardActions.pressEnterKey(byOrderTextField);
			CommonMethods.waitForPageLoading();
			SeleniumActions.click(bylistoforder, "Select the Order");
			HeaderPanelPage.clickRelatedLinksButton();
			HeaderPanelPage.clickOrderLinesLink();
			CommonMethods.waitForPageLoading();
			OriginalOrdersPage.selectDetailsInOrderLine();
			OriginalOrdersPage.expandOrderLineNeed();
			OriginalOrdersPage.expandOrderLineAttributes();
			OriginalOrdersPage.closeOrderLine();
			FooterPanelPage.clickDeselectButton();
			OriginalOrdersPage.selectOriginalOrderBreadcrumb();
			CommonMethods.waitForPageLoading();
		}

	}

	/**
	 * Function to FILTER multiple original orders
	 *
	 * @param strText - original order value
	 */
	public static void filterMultipleOriginalOrder(String strText) {
		String strOrderNumber;
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byFilterClearAllBtn, "Clear All Filter button");
		CommonMethods.waitForPageLoading();
		if (strText != null && !strText.trim().isEmpty()) {
			strOrderNumber = strText;
		} else {
			strOrderNumber = SeleniumActions.getText(byFirstOriginalOrderId);
		}
		CommonMethods.waitForPageLoading();
		if (DriverManager.getDriver().findElements(byOriginalOrderField).size() < 1) {
			SeleniumActions.click(byExpandOriginalOrderfield, "Expand icon");
		}
		SeleniumActions.getElement(byOriginalOrderField).clear();
		SeleniumActions.sendTextToElement(byOriginalOrderField, strOrderNumber, "Original Order search field");
		CommonMethods.waitForPageLoading();
		KeyboardActions.pressEnterKey(byOriginalOrderField);
		CommonMethods.waitForPageLoading();
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to execute RunWave For MultipleOrders
	 *
	 */
	public static void executeRunWaveForMultipleOrders(String strategy) {
		List<WebElement> elements = DriverManager.getDriver().findElements(byOriginalOrdersIds);
		for (WebElement e : elements) {
			CommonMethods.waitForPageLoading();
			SeleniumActions.click(e, "Select Elements in Original order Page");
			CommonMethods.waitForPageLoading();
		}
		WebElement runElement = DriverManager.getDriver().findElement(byRunWaveBtn);
		boolean isElementPresent = runElement.isDisplayed();
		if (isElementPresent) {
			CommonMethods.waitForPageLoading();
			SeleniumActions.click(byRunWaveBtn, "Run Wave button");
		} else {
			FooterPanelPage.clickMoreButton();
			SeleniumActions.click(byRunWaveButton, "RunWave button from More Options");
		}
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byPlanningStrategyId, "Order Planning Strategy ID");
		CommonMethods.waitForPageLoading();
		GeneralUtils.wait(5 * 1000);
		final By byWaveOrderStrategyDropDownValue = By.xpath("//button[contains(@data-component-id,'" + strategy + "')]");
		SeleniumActions.click(byWaveOrderStrategyDropDownValue, "Select Strategy " + strategy);
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(bySubmitBtn, "Submit button");
		CommonMethods.waitForPageLoading();
		OriginalOrdersPage.getWaveNumberFromOriginalOrder();
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to Verify Order line Need And Attributes details for imported orders
	 * 
	 * @param Orders - pass current orders
	 */
	public static void verifyOrderLineNeedAndAttributesDetailsForimportedOrders(String Orders) {
		String listOfOrders = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + Orders);
		String item = getDataFromFeature("getdata(Items)");
		String titleOrderStatus = getDataFromFeature("getdata(OrderStatus)");
		List<String> expectedOrders = new ArrayList<String>(Arrays.asList(listOfOrders.split(",")));

		for (String singleOrder : expectedOrders) {
			final By byListOfOrder = By.xpath("(//*[@title='" + singleOrder + "'])[1]");

			CommonMethods.waitForPageLoading();
			if (DriverManager.getDriver().findElements(byOrderTextField).size() < 1) {
				SeleniumActions.click(byExpandOrderField, "Expand icon");
			}
			SeleniumActions.getElement(byOrderTextField).clear();
			SeleniumActions.sendTextToElement(byOrderTextField, singleOrder, "Order Id Text Field");
			CommonMethods.waitForPageLoading();
			KeyboardActions.pressEnterKey(byOrderTextField);
			CommonMethods.waitForPageLoading();
			SeleniumActions.click(byListOfOrder, "Select the Order");
			CommonMethods.waitForPageLoading();
			String actualOrderstatus = SeleniumActions.getText(byOrderStatus);
			SeleniumActions.verifyTextContains(actualOrderstatus, titleOrderStatus, false);
			CommonMethods.waitForPageLoading();
			HeaderPanelPage.clickRelatedLinksButton();
			HeaderPanelPage.clickOrderLinesLink();
			CommonMethods.waitForPageLoading();
			OriginalOrdersPage.selectDetailsInOrderLine();
			SeleniumActions.verifyElementVisible(By.xpath("//modal-container//*[text()=' " + item + " ']"), 10, "Item");
			OriginalOrdersPage.expandOrderLineNeed();
			String actualOrderedQuantity = SeleniumActions.getText(byorderquantity);
			SeleniumActions.verifyTextContains(actualOrderedQuantity, getDataFromFeature("getdata(Ordered quantity)"),
					false);
			String actualProductStatus = SeleniumActions.getText(byProductStatus);
			SeleniumActions.verifyTextContains(actualProductStatus, getDataFromFeature("getdata(ProductStatusID)"),
					false);
			String actualInventory = SeleniumActions.getText(byInventory);
			SeleniumActions.verifyTextContains(actualInventory, getDataFromFeature("getdata(InventoryTypeId)"), false);
			OriginalOrdersPage.expandOrderLineAttributes();
			OriginalOrdersPage.closeOrderLine();
			FooterPanelPage.clickDeselectButton();
			OriginalOrdersPage.selectOriginalOrderBreadcrumb();
			CommonMethods.waitForPageLoading();
			SeleniumActions.click(byRefreshBtn, "Refresh Button");

		}

	}

	/**
	 * Function to execute run wave for FNCUBING06 strategy
	 *
	 */
	public static void executeRunWaveFNCUBING06ForThreeOrders() {
		SeleniumActions.click(byRunWaveBtn, "RunWave button");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byPlanningStrategyId, "Order Planning Strategy ID");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byFNCUBING06OrderStrategy, "Select FNCUBING06OrderStrategy");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(bySubmitBtn, "Submit button");
		CommonMethods.waitForPageLoading();
		OriginalOrdersPage.getWaveNumberFromOriginalOrder();
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to execute run wave for FNRouting06 for 2 orders
	 *
	 */
	public static void executeRunWaveFNRoutingForTwoOrders() {
		SeleniumActions.click(byRunWaveBtn, "RunWave button");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byPlanningStrategyId, "Order Planning Strategy ID");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byFNROUTING06OrderStrategy, "Select FNROUTING06OrderStrategy");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(bySubmitBtn, "Submit button");
		CommonMethods.waitForPageLoading();
		OriginalOrdersPage.getWaveNumberFromOriginalOrder();
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to verify multiple original order displayed
	 *
	 */
	public static void verifyMultipleOriginalOrderDisplayed(List<String> orderValue) {
		Collections.reverse(orderValue);
		List<WebElement> elements = DriverManager.getDriver().findElements(byOriginalOrdersIds);
		List<String> actualOrders = new ArrayList<>();
		for (WebElement e : elements) {
			CommonMethods.waitForPageLoading();
			String val = e.getText();
			if (!val.isEmpty()) {
				CommonMethods.waitForPageLoading();
				actualOrders.add(val);
			}
			CommonMethods.waitForPageLoading();
		}
		if (orderValue.equals(actualOrders)) {
			FrameworkLogger.log(LogType.PASS, "Orders Verification passed : " + orderValue);
		} else {
			FrameworkLogger.log(LogType.FAIL,
					"Orders Verification failed. Expected :" + orderValue + " , Actual :" + actualOrders);
		}
	}

	/**
	 * Function to execute run wave for FNRouting for 2 orders
	 *
	 */
	public static void executeRunWaveFNRoutingStrategyForTwoOrders() {
		SeleniumActions.click(byRunWaveBtn, "RunWave button");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byPlanningStrategyId, "Order Planning Strategy ID");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byFNROUTINGOrderStrategy, "Select FNROUTINGOrderStrategy");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(bySubmitBtn, "Submit button");
		CommonMethods.waitForPageLoading();
		OriginalOrdersPage.getWaveNumberFromOriginalOrder();
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to get OrderLine ID value
	 */
	public static void getOrderLineValue() {
		CommonMethods.waitForPageLoading();
		String strOrderLine = SeleniumActions.getText(byOrderLineValue);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "orderLine", strOrderLine);
		CommonMethods.waitForPageLoading();
	}

	public static void executeRunWaveForOrdersATStandardOrderStrategy() {
		CommonMethods.waitForPageLoading();
		WebElement runElement = DriverManager.getDriver().findElement(byRunWaveBtn);
		boolean isElementPresent = runElement.isDisplayed();
		if (isElementPresent) {
			CommonMethods.waitForPageLoading();
			SeleniumActions.click(byRunWaveBtn, "Run Wave button");
		} else {
			FooterPanelPage.clickMoreButton();
			SeleniumActions.click(byRunWaveButton, "RunWave button from More Options");
		}
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byPlanningStrategyId, "Order Planning Strategy ID");
		CommonMethods.waitForPageLoading();
		GeneralUtils.wait(5 * 1000);
		SeleniumActions.click(byATStandardOrderStrategyBtn, "Select ATStandardOrderStrategyBtn");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(bySubmitBtn, "Submit button");
		CommonMethods.waitForPageLoading();
		OriginalOrdersPage.getWaveNumberFromOriginalOrder();
		CommonMethods.waitForPageLoading();
	}
}
