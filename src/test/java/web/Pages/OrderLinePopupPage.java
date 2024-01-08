package web.Pages;

import com.dhl.constants.FrameworkConstants;
import com.dhl.driver.DriverManager;
import com.dhl.reports.FrameworkLogger;
import com.dhl.reports.LogType;
import com.dhl.testdata.TestData_Json;
import com.dhl.utils.CurrentThreadInstance;
import com.dhl.utils.Variables;
import com.dhl.web.utils.KeyboardActions;
import com.dhl.web.utils.SeleniumActions;
import com.jayway.jsonpath.JsonPath;
import org.openqa.selenium.By;
import stepdefinitions.CommonMethods;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@SuppressWarnings("unused")
public class OrderLinePopupPage extends TestData_Json {

	private static final By byOrderLineNeedHeader = By.xpath("//span[text()='Order Line Need']");
	private static final By byOrderLineAttributesHeader = By.xpath("//span[text()='Order Line Attributes']");
	private static final By byNoDataToDisplayLabel = By.xpath("//div[@class='visible']//div[text()='No data to display']");
	private static final By byInventoryType = By.xpath("//div[contains(@data-component-id,'InventoryTypeId')]");
	private static final By byProductStatus = By.xpath("//div[contains(@data-component-id,'ProductStatusId')]");
	private static final By byOrderedQuantity = By.xpath("//div[starts-with(@data-component-id,'OrderedQuantity')]");
	private static final By byItem_OrderlineNeed = By.xpath("//div[starts-with(@data-component-id,'Description')]");
	private static final By byDisplayOrderQuantityUom = By.xpath("//div[contains(@data-component-id,'DisplayQuantityUomId')]");
	private static final By bySelectTextField = By.xpath("//input[@placeholder='Select']");
	private static final By byCloseExportBtn = By.xpath("//button//ion-icon[@name='close']");
	private static final By byOrderedQtyAtSecondOrderLine = By.xpath("//div[@class='dm-flex-col-layout dm-fill-space ng-star-inserted'][1]//span[contains(@data-component-id,'OrderedQuantity')]"); //this xpath is pointing to 1st row.check the test case validation
	private static final By byBatchNumber = By.xpath("//div[contains(@data-component-id,'BatchNumber')]");

	/**
	 * Function to click OrderLineNeed Header
	 */
	public static void clickOrderLineNeedHeader() {
		SeleniumActions.click(byOrderLineNeedHeader, "OrderLineNeed Header");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click OrderLine Attributes Header
	 */
	public static void clickOrderLineNeedAttributes() {
		CommonMethods.scrollByParticularElement(byOrderLineAttributesHeader, "OrderLine Attributes Header");
		SeleniumActions.click(byOrderLineAttributesHeader, "OrderLine Attributes Header");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to verify NoDataToDisplay Label
	 */
	public static void verifyNoDataToDisplayLabel() {
		SeleniumActions.verifyElementVisible(byNoDataToDisplayLabel, 10,"No data to display Label");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to verify InventoryType
	 * @param text - value to verify
	 */
	public static void verifyInventoryType(String text) {
		String actualText = SeleniumActions.getText(byInventoryType);
		SeleniumActions.verifyTextEquals(actualText,text,false);
	}

	/**
	 * Function to verify ProductStatus
	 * @param text - value to verify
	 */
	public static void verifyProductStatus(String text) {
		String actualText = SeleniumActions.getText(byProductStatus);
		SeleniumActions.verifyTextEquals(actualText,text,false);
	}

	/**
	 * Function to verify OrderedQuantity
	 * @param text - value to verify
	 */
	public static void verifyOrderedQuantity(String text) {
		String actualText = SeleniumActions.getText(byOrderedQuantity);
		CommonMethods.verifyValue(actualText,text,"OrderedQuantity ","GreaterThanOrEqual");
	}

	/**
	 * Function to verify order line need and order line attributes for order template
	 * @param template -value template name
	 *
	 */
	public static void verifyOrderLineNeedAndOrderLineAttributesForOrder_OrderTemplateJson(String template) {
		String json=(String) Variables.get(CurrentThreadInstance.getCurrentScenarioId()+template);
		String expectedInventoryType = JsonPath.read(json, "$.InventoryTypeId");
		String expectedProductStatus = JsonPath.read(json, "$.ProductStatusId");
		CommonPage.clickRowAtFirstIndex();
		FooterPanelPage.clickDetailsButton();
		OrderLinePopupPage.clickOrderLineNeedHeader();
		String actualInventoryType = SeleniumActions.getText(byInventoryType);
		SeleniumActions.verifyTextEquals(actualInventoryType, expectedInventoryType,false);
		String actualProductStatus = SeleniumActions.getText(byProductStatus);
		SeleniumActions.verifyTextEquals(actualProductStatus, expectedProductStatus,false);
		OrderLinePopupPage.clickOrderLineNeedAttributes();
		OrderLinePopupPage.verifyNoDataToDisplayLabel();
	}

	/**
	 * Function to verify order line data with json
	 * @param filename - value json filename
	 */
	public static void verifyOrderLineDataWithJson(String filename) throws IOException, IOException {
		String jsonPath = new String(Files.readAllBytes(Paths.get(FrameworkConstants.getApiRequestsDirectory()+filename)));
		String expectedItemId = getDataFromFeature(getData("Item_ID"));
//		String expectedItemId = JsonPath.read(jsonPath, "$.Data[0].OriginalOrderLine[0].ItemId");
		FrameworkLogger.log(LogType.INFO, "Item Id from Json : " + expectedItemId);
		String expectedOrderedQuantity = JsonPath.read(jsonPath, "$.Data[0].OriginalOrderLine[0].OrderedQuantity");
		FrameworkLogger.log(LogType.INFO, "Order quantity from Json : " + expectedOrderedQuantity);
		String expectedQuantityUom = JsonPath.read(jsonPath, "$.Data[0].OriginalOrderLine[0].QuantityUomId");
		FrameworkLogger.log(LogType.INFO, "Quantity UOM from Json : " + expectedQuantityUom);
		String actualItemId = SeleniumActions.getText(byItem_OrderlineNeed);
		SeleniumActions.verifyTextContains(actualItemId, expectedItemId,false);
		String actualOrderedQuantity = SeleniumActions.getText(byOrderedQuantity);
		SeleniumActions.verifyTextEquals(actualOrderedQuantity, expectedOrderedQuantity,false);
		String actualQuantityUom = SeleniumActions.getText(byDisplayOrderQuantityUom);
		SeleniumActions.verifyTextEquals(actualQuantityUom, expectedQuantityUom,false);
		CommonPopupPage.clickCloseIcon();
	}

	/**
	 * Function to verify OrderedQuantity for Second order Line
	 * @param filename - verify Json file data
	 */
	public static void verifyOrderedQuantityForSecondLineOrder(String filename) throws IOException, IOException{
		String jsonPath = new String(Files.readAllBytes(Paths.get(FrameworkConstants.getApiRequestsDirectory()+filename)));
		String expectedOrderedQty = JsonPath.read(jsonPath, "$.Data[0].OriginalOrderLine[1].OrderedQuantity");
		FrameworkLogger.log(LogType.INFO, "OrderedQuantity from Json : " + expectedOrderedQty);
		SeleniumActions.clear(bySelectTextField, "Select Text field");
		CommonMethods.waitForPageLoading();
		SeleniumActions.sendTextToElement(bySelectTextField, "Created date time", "Select Drop down field");
		CommonMethods.waitForPageLoading();
		KeyboardActions.pressEnterKey(bySelectTextField);
		CommonMethods.waitForPageLoading();
		String actualOrderedQty = SeleniumActions.getText(byOrderedQtyAtSecondOrderLine).trim();
		CommonMethods.waitForPageLoading();
		SeleniumActions.verifyTextEquals(actualOrderedQty, expectedOrderedQty);
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to verify RESET value of OrderedQuantity for  Second order Line
	 * @param filename - verify Json file data
	 */
	public static void verifyUpdatedOrderedQuantityWithResetActionOnSecondOrderLine(String filename) throws IOException, IOException{
		String jsonPath = new String(Files.readAllBytes(Paths.get(FrameworkConstants.getApiRequestsDirectory()+filename)));
		String expectedOrderedQty = JsonPath.read(jsonPath, "$.Data[0].OriginalOrderLine[0].OrderedQuantity");
		FrameworkLogger.log(LogType.INFO, "OrderedQuantity from Json : " + expectedOrderedQty);
		String expectedInventoryType = JsonPath.read(jsonPath, "$.Data[0].OriginalOrderLine[0].InventoryTypeId");
		FrameworkLogger.log(LogType.INFO, "Inventory Type from Json : " + expectedInventoryType);
		String expectedProductStatus = JsonPath.read(jsonPath, "$.Data[0].OriginalOrderLine[0].ProductStatusId");
		FrameworkLogger.log(LogType.INFO, "Product Status from Json : " + expectedProductStatus);
		CommonPage.clickRowAtFirstIndex();
		CommonMethods.waitForPageLoading();
		FooterPanelPage.clickDetailsButton();
		CommonMethods.waitForPageLoading();
		OrderLinePopupPage.clickOrderLineNeedHeader();
		CommonMethods.waitForPageLoading();
		String actualOrderedQty = SeleniumActions.getText(byOrderedQuantity).trim();
		SeleniumActions.verifyTextEquals(actualOrderedQty, expectedOrderedQty);
		String actualInventoryType = SeleniumActions.getText(byInventoryType).trim();
		SeleniumActions.verifyTextEquals(actualInventoryType, expectedInventoryType);
		String actualProductStatus = SeleniumActions.getText(byProductStatus).trim();
		SeleniumActions.verifyTextEquals(actualProductStatus, expectedProductStatus);
		CommonPopupPage.clickCloseIcon();
	}

	/**
	 * Function to verify BatchNumber
	 * @param text - value to verify
	 */
	public static void verifyBatchNumber(String text) {
		String actualText = DriverManager.getDriver().findElement(byBatchNumber).getText();
		SeleniumActions.verifyTextEquals(actualText,text,false);
	}

	/**
	 * Function to click order line header
	 */
	public static void clickOrderLineHeader(){
		OrderLinePopupPage.clickOrderLineNeedHeader();
		CommonMethods.waitForPageLoading();
	}
}
