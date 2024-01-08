package web.Pages;

import org.openqa.selenium.By;

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

import org.openqa.selenium.WebElement;
import stepdefinitions.CommonMethods;
import stepdefinitions.ExcelUtil1;

@SuppressWarnings("unused")
public class OrdersPage extends TestData_Json {

	private static final By byOrdersPage = By.xpath("//span[contains(text(),'Orders')]");
	private static final By byExportDataLoaderBtn = By.xpath("//button[contains(@data-component-id,'ExportDataLoader')]");
	private static final By byImportDataLoaderBtn = By.xpath("//button[contains(@data-component-id,'ImportDataLoader')]");
	private static final By byChooseFileBtn = By.xpath("//label[contains(text(),'Choose File')]");
	private static final By bySaveBtn = By.xpath("//ion-button[contains(text(),'SAVE')]");
	private static final By byRefreshBtn = By.xpath("//ion-button[contains(@data-component-id,'refresh')]");
	private static final By byRelatedLinks = By.xpath("//*[contains(text(),'Related Links')]");
	private static final By byTaskDetails = By.xpath("//*[text()='Task Details']");
	private static final By byOrderIdClick = By.xpath("//span[contains(@data-component-id,'OrderId')]");
	private static final By byFirstOrderCardforpickpack = By
			.xpath("(//span[contains(@data-component-id,'MaximumStatusDescription') and @title = 'Allocated'])[1]");
	private static final By byOrderLines = By.xpath("//*[text()='Order Lines']");
	private static final By byFilterClearAllBtn = By.xpath("//button[contains(@data-component-id,'clear-all-btn')]");
	private static final By byRunWaveConfirmMessageText = By.xpath("//div[contains(text(),'submitted')]");
	private static final By byFirstOrderCard = By
			.xpath("(//span[contains(@data-component-id,'MaximumStatusDescription') and @title='Released'])[1]");
	private static final By byFirstAllocatedOrderCard = By
			.xpath("(//span[contains(@data-component-id,'MaximumStatusDescription') and @title = 'Allocated'])[1]");
	private static final By byFirstOrderIdforpickpack = By.xpath(
			"(//span[contains(@data-component-id,'MaximumStatusDescription') and @title = 'Allocated'])[1]/ancestor::card-view//a[contains(@data-component-id,'OrderId')]");
	private static final By byFirstOrderId = By.xpath(
			"(//span[contains(@data-component-id,'MaximumStatusDescription') and @title = 'Released'])[1]/ancestor::card-view//a[contains(@data-component-id,'OrderId')]");
	private static final By byItemField = By.xpath("//ion-input[contains(@data-component-id,'OrderLine.ItemId')]/input");
	private static final By byExpandItemfield = By
			.xpath("//span[@title='Item']/following-sibling::ion-button[@data-component-id='expand-button']");
	private static final By byOrderField = By.xpath("//ion-input[starts-with(@data-component-id,'OrderId')]/input");
	private static final By byExpandOrderfield = By
			.xpath("//span[@title='Order']/following-sibling::ion-button[contains(@data-component-id,'expand-button')]");
	private static final By byOrderStatusDescription = By.xpath("//div[contains(@data-component-id,'MinimumStatusDescription')]");
	private static final By byOrderMaxStatusLabel = By.xpath("//span[contains(text(),'Maximum status')]");
	private static final By byOrderLinesStatusDescription = By
			.xpath("//div[contains(@data-component-id,'OrderLineStatusDescription')]");
	private static final By byRunWaveBtn = By.xpath("//ion-button[contains(@data-component-id,'RunWave')]");
	private static final By bySubmitBtn = By.xpath("//ion-button[contains(@data-component-id,'submit-btn')]");
	private static final By byATStandardOrderStrategyBtn = By
			.xpath("//button[contains(@data-component-id,'ATStandardOrderStrategy')][1]");
	private static final By byPlanningStrategyId = By
			.xpath("//ion-input[contains(@data-component-id,'PlanningStrategyId')]/input");
	private static final By bytaskStatusfeild = By
			.xpath("//div[contains(@data-component-id,'DetailStatusDescription') and  @title='Created']");
	private static final By bytaskdetailsOrderIDfield = By.xpath("//a[starts-with(@data-component-id,'OrderId')]");
	private static final By bytaskoLPNfield = By.xpath("//a[contains(@data-component-id,'OlpnId')]");
	private static final By byMoreActionsBtn = By.xpath("//ion-button[contains(@data-component-id,'more-actions')]");
	private static final By byShipConfirmBtn = By.xpath("//button[contains(@data-component-id,'ShipConfirm')]");
	private static final By byFirstPackedOrderCard = By
			.xpath("(//span[contains(@data-component-id,'MaximumStatusDescription') and @title = 'Packed'])[1]");

	private static final By byItemIdList = By.xpath("//span[contains(text(),'Item :')]//following-sibling::a[contains(@data-component-id,'ItemId')]");

	private static final By byOrderQtyList = By.xpath("//span[contains(text(),'Ordered quantity :')]//following-sibling::span[contains(@data-component-id,'OrderedQuantity')]");
	private static final By byATStandardStrategyPartialAllocateBtn = By
			.xpath("//button[contains(@data-component-id,'ATStandardOrderStrategyPartialAllocate')]");
	private static final By byOrderMaximumStatusDescription = By.xpath("//span[contains(@data-component-id,'MaximumStatusDescription')]");
	private static final By byNameField = By.xpath("//ion-input[contains(@data-component-id,'PlanningStrategyId')]/input");

	private static final By byExpandNameField = By.xpath("//span[@title='Name']/following-sibling::ion-button[contains(@data-component-id,'expand-button')]");

	private static final By byOrderSelectionCriteria = By.xpath("//ion-label[contains(@data-component-id,'OrderSelectionCriteria')]");
	private static final By byCubing = By.xpath("//ion-label[contains(@data-component-id,'Cubing')]");
	private static final By byRunWaveBtnFromMoreOptions = By.xpath("//button[contains(@data-component-id,'RunWave')]");
	private static final By bySelectedCubingStrategy = By.xpath("//div[contains(@class,'selected-card')]//span[contains(@data-component-id,'CubingStrategyId')]");
	private static final By byNameFieldAllocation = By.xpath("//ion-input[contains(@data-component-id,'AllocationStrategyId')]/input");

	/**
	 * Function to Verify Original Orders Page is displayed
	 */
	public static void verifyOrdersPageDisplayed() {
		SeleniumActions.verifyElementVisible(byOrdersPage, 20, "Orders page");
	}

	/**
	 * Function to select file to import
	 */
	public static void selectFiletoImport() {
		SeleniumActions.click(byChooseFileBtn, "click Choose File button");
		GeneralUtils.wait(5 * 1000);
		String demo = System.getProperty("user.home") + "\\Downloads\\";
		ExcelUtil1.sendTextWithRobot(demo + "OriginalOrder.xlsx");
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
	 * Function to select allocated order
	 */
	public static void SelectAllocatedOrder() {
		SeleniumActions.click(byFirstAllocatedOrderCard, "Order Card");
	}

	/**
	 * Function to select packed order
	 */
	public static void SelectPackedOrder() {
		SeleniumActions.click(byFirstPackedOrderCard, "Order Card");
	}

	/**
	 * Function to select order for pickpack
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
		CommonMethods.waitForPageLoading();
		String strStatus = getOrderStatus();
		if (!strStatus.isEmpty()) {
			SeleniumActions.verifyTextEquals(strStatus, strExpected);
			// SeleniumActions.click(byOrderIdClick,"click On Order");
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
	 */
	public static void executeRunWave() {
		CommonMethods.waitForPageLoading();
		WebElement runElement = DriverManager.getDriver().findElement(byRunWaveBtn);
		boolean isElementPresent = runElement.isDisplayed();
		if (isElementPresent) {
			CommonMethods.waitForPageLoading();
			SeleniumActions.click(byRunWaveBtn, "Run Wave button");
		}else{
			FooterPanelPage.clickMoreButton();
			SeleniumActions.click(byRunWaveBtnFromMoreOptions, "RunWave button from More Options");
		}
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byPlanningStrategyId, "Order Planning Strategy ID");
		CommonMethods.waitForPageLoading();
		GeneralUtils.wait(5 * 1000);
		SeleniumActions.click(byATStandardOrderStrategyBtn, "Select ATStandardOrderStrategyBtn");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(bySubmitBtn, "Submit button");
		CommonMethods.waitForPageLoading();
		OrdersPage.getWavenumber();
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to copy olpn
	 */
	public static void copyoLPN() {
		CommonMethods.waitForPageLoading();
		// if (DriverManager.getDriver().findElements(bytaskStatusfeild).size() < 1) {
		SeleniumActions.click(bytaskStatusfeild, "Expand icon");
		// }
		// if(SeleniumActions.getText(bytaskdetailsOrderIDfield.equals())){
		String taskoLPNValue = SeleniumActions.getText(bytaskoLPNfield);
		if (taskoLPNValue != null && !taskoLPNValue.trim().isEmpty()) {
			taskoLPNValue.trim();
		} else {
			FrameworkLogger.log(LogType.FAIL, "OLPN is empty");
		}
		// }
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "taskoLPN", taskoLPNValue.trim());
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
	 * Function to get current Order status from Orders/Original Orders window
	 */
	public static String getWavenumber() {
		String strWaveNumber = null;
		String strWaveMessage = SeleniumActions.getText(byRunWaveConfirmMessageText);
		if (strWaveMessage != null && !strWaveMessage.trim().isEmpty()) {
			FrameworkLogger.log(LogType.INFO, "Wave :" + strWaveMessage.trim());

			if (strWaveMessage.contains("is submitted (info)")) {
				int iStart = strWaveMessage.indexOf("Wave") + "Wave".length();
				int iEnd = strWaveMessage.indexOf("is submitted");
				strWaveNumber = strWaveMessage.substring(iStart, iEnd);
				// strWaveNumber = strWaveMessage.replace("Wave", "");
				// strWaveNumber = strWaveNumber.replace("is submitted (info)", "");
			} else if (strWaveMessage.contains("planning run")) {
				int iStart = strWaveMessage.indexOf("planning run") + "planning run".length();
				int iEnd = strWaveMessage.indexOf("submitted");
				strWaveNumber = strWaveMessage.substring(iStart, iEnd);
				// strWaveNumber = strWaveMessage.replace("run", "");
				// strWaveNumber = strWaveNumber.replace("submitted", "");
			}
			Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "WaveRun", strWaveNumber.trim());
			return strWaveNumber.trim();
		} else {
			FrameworkLogger.log(LogType.FAIL, "Wave Status description is null or empty");
		}
		return "";
	}

	/**
	 * Function to verify Ship Confirm is performed by selecting 'Ship Confirm'
	 * button
	 */
	public static void verifyReceivingASN() {
		SeleniumActions.click(byMoreActionsBtn, "More actions");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byShipConfirmBtn, "Ship Confirm action");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to verify Item Id Element count
	 */
	public static void verifyItemIdElementCount(int count) {
		int actualCount = DriverManager.getDriver().findElements(byItemIdList).size();
		String actualItemId = SeleniumActions.getText(byItemIdList);
		if (count == actualCount) {
			FrameworkLogger.log(LogType.PASS, "Item Id element count verification passed : "+actualItemId);
		} else {
			FrameworkLogger.log(LogType.FAIL, "Product status element count verification failed. Expected:  " + count
					+ ", Actual :" + actualCount);
		}
	}

	/**
	 * Function to verify Order Quantity Element count
	 * @param count - value of expected count
	 */
	public static void verifyOrderQtyElementCount(int count) {
		int actualCount = DriverManager.getDriver().findElements(byOrderQtyList).size();
		String actualOrderQty = SeleniumActions.getText(byOrderQtyList);
		if (count == actualCount) {
			FrameworkLogger.log(LogType.PASS, "Order Quantity element count verification passed : "+actualOrderQty);
		} else {
			FrameworkLogger.log(LogType.FAIL, "Order Quantity element count verification failed. Expected:  " + count
					+ ", Actual :" + actualCount);
		}
	}

	/**
	 * Function to execute run wave for partial allocated
	 */
	public static void executeRunWavePartialAllocate() {
		SeleniumActions.click(byRunWaveBtn, "RunWave button");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byPlanningStrategyId, "Order Planning Strategy ID");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byATStandardStrategyPartialAllocateBtn, "Select ATStandardOrderStrategyPartialAllocationBtn");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(bySubmitBtn, "Submit button");
		CommonMethods.waitForPageLoading();
		OrdersPage.getWavenumber();
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to get current Order Maximum status from Orders/Original Orders window
	 */
	public static String getOrderMaximumStatus() {
		String strStatus = SeleniumActions.getText(byOrderMaximumStatusDescription);
		if (strStatus != null && !strStatus.trim().isEmpty()) {
			return strStatus.trim();
		} else {
			FrameworkLogger.log(LogType.FAIL, "Order Maximum Status description is null or empty");
		}
		return "";
	}

	/**
	 * Function to verify Order Maximum status displayed
	 *
	 * @param strExpected - Order status that need to be verified
	 */
	public static void verifyOrderMaximumStatus(String strExpected) {
		CommonMethods.waitForPageLoading();
		String strStatus = getOrderMaximumStatus();
		if (!strStatus.isEmpty()) {
			SeleniumActions.verifyTextEquals(strStatus, strExpected);
		}
	}

	/**
	 * Function to filter by wave strategy
	 * @param strText - search value
	 */
	public static void filterByNameWaveStrategy(String strText) {
		CommonMethods.waitForPageLoading();
		if (DriverManager.getDriver().findElements(byNameField).size() < 1) {
			SeleniumActions.click(byExpandNameField, "Expand icon");
		}
		SeleniumActions.getElement(byNameField).clear();
		SeleniumActions.sendTextToElement(byNameField, strText, "Name search field");
		CommonMethods.waitForPageLoading();
		KeyboardActions.pressEnterKey(byNameField);
		CommonMethods.waitForPageLoading();
		}

	/**
	 * Function to select order selection criteria
	 */
	public static void selectOrderSelectionCriteria() {
		SeleniumActions.click(byOrderSelectionCriteria, "OrderSelectionCriteria button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to select cubing
	 */
	public static void selectCubing() {
		SeleniumActions.click(byCubing, "Cubing button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to cverify order status
	 * @param strExpected - expected order status
	 */
	public static void waitAndVerifyOrderStatus(String strExpected) throws InterruptedException {
		Thread.sleep(180000);
		boolean bTrue = true;
		String strStatus = getOrderStatus();
		if (!strStatus.isEmpty()) {
			int itime = 0;
			while (bTrue == true) {
				GeneralUtils.wait(2 * 2000);
				itime += 2;
				KeyboardActions.pressEnterKey(byOrderField);
				strStatus = getOrderStatus();
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
	 * Function to get selected cubing strategy
	 * @param cubingStrategy - value cubing strategy
	 */
	public static void getSelectedCubingStrategy(String cubingStrategy) {
		String actualCubingStrategy = SeleniumActions.getText(bySelectedCubingStrategy);
		if (actualCubingStrategy.equalsIgnoreCase(cubingStrategy)) {
			FrameworkLogger.log(LogType.PASS, "Selected cubing strategy is "+actualCubingStrategy);
		} else {
			FrameworkLogger.log(LogType.FAIL, "Selected cubing strategy is not "+cubingStrategy);
		}
	}
	/**
	 * Function to filter allocation strategy
	 * @param strText - search value
	 */

	public static void filterByNameAllocationStrategy(String strText) {
		CommonMethods.waitForPageLoading();
		if (DriverManager.getDriver().findElements(byNameFieldAllocation).size() < 1) {
			SeleniumActions.click(byExpandNameField, "Expand icon");
		}
		SeleniumActions.getElement(byNameFieldAllocation).clear();
		SeleniumActions.sendTextToElement(byNameFieldAllocation, strText, "Name search field");
		CommonMethods.waitForPageLoading();
		KeyboardActions.pressEnterKey(byNameFieldAllocation);
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to verify Ship Confirm is performed by selecting 'Ship Confirm'
	 * button
	 */
	public static void verifyShipConfirm() {
		SeleniumActions.click(byMoreActionsBtn, "More actions");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byShipConfirmBtn, "Ship Confirm action");
		CommonMethods.waitForPageLoading();
	}


}
