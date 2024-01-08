package web.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.dhl.driver.DriverManager;
import com.dhl.reports.FrameworkLogger;
import com.dhl.reports.LogType;
import com.dhl.testdata.TestData_Json;
import com.dhl.utils.CurrentThreadInstance;
import com.dhl.utils.Variables;
import com.dhl.web.utils.SeleniumActions;

import stepdefinitions.CommonMethods;

public class Olpns extends TestData_Json {

	private static final By byOLPNS = By.xpath("//span[@data-component-id='oLPNs-navbar-section-nosubtitle']");
	private static final By byOLPNStatusDescription = By
			.xpath("//div[@data-component-id='StatusDescription-card-view']");
	private static final By byOLPNSPage = By.xpath("//span[contains(text(),' oLPNs 2.0 ')]"); // Not able to find this
																								// object
	private static final By byOlpnsClearAllFilterBtn = By.xpath("//button[@data-component-id='clear-all-btn']"); // This
																													// object
																													// present
																													// in
																													// LeftPanelPage
	private static final By byExpandOrderField = By.xpath(
			"//span[@title='Order']/following-sibling::ion-button[@data-component-id='expand-button-filter-field-header']");

	private static final By byOrderTextField = By
			.xpath("//ion-input[@data-component-id='OrderId-lookup-dialog-filter-input']/input");

	private static final By byFirstShippedOrderCard = By
			.xpath("(//span[@data-component-id='LpnType' and @title = 'OLPN'])");
	private static final By byDetailsButton = By.xpath("(//ion-button[@data-component-id='Details-footer-panel'])");
	private static final By byOlpnsDetailsIconExpand = By
			.xpath("//span[contains(text(),'oLPN Details')]//parent::div/ion-icon"); // By.xpath("(//div[@data-component-id='oLPNDetails']/ion-icon)");
	private static final By byScrolloLpnsDetailTable = By.xpath("(//datatable-header-cell[@title='oLPN Detail '])");
	private static final By byScrollInventoryType = By
			.xpath("(//span[@data-component-id='com-manh-cp-pickpack-OlpnDetail-grid-view-InventoryType'])");
	private static final By byInventoryTypeValue = By
			.xpath("(//div[@role='table']/datatable-body/datatable-selection//div[@title='F'])"); // Hardcoded value
	private static final By byInventoryTypeValue1 = By.xpath("(//div[contains(@data-component-id,'InventoryTypeId')]"); // newly
																														// added
																														// to
																														// replace
																														// byInventoryTypeValue
	private static final By byProductStatusValue = By
			.xpath("(//div[@role='table']/datatable-body/datatable-selection//div[@title='A'])"); // Hardcoded value
	private static final By byBatchNumber = By
			.xpath("(//span[@data-component-id='com-manh-cp-pickpack-OlpnDetail-grid-view-BatchNumber'])");
	private static final By byOlpnDetailsDataCheckbox = By
			.xpath("//div[@data-component-id='oLPNDetails-expand-content']//input[@type='checkbox']");
	private static final By byOlpnDetailAttribute = By.xpath("//span[contains(text(),'OLPN DETAIL ATTRIBUTES')]");
	private static final By byAttributeNameSerialNumber = By
			.xpath("//div[contains(@data-component-id,'SERIAL_NUMBER')]");
	private static final By byCloseIconOlpnDetails = By
			.xpath("//button[@data-component-id='com-manh-cp-pickpack-NestedOlpnDetail-list-details-close-icon']");
	private static final By byOlpnDetailsButton = By
			.xpath("((//ion-button[@data-component-id='Details-footer-panel'])[2]");
	private static final By byProductStatusList = By.xpath("//div[contains(@data-component-id,'ProductStatusId')]");
	private static final By byProductClassList = By.xpath("//div[contains(@data-component-id,'ProductClassId')]");
	private static final By byCloseOILPNsPopup = By
			.xpath("//button[@data-component-id='com-manh-cp-pickpack-DMOlpn-list-details-close-icon']");
	private static final By byOlpnDetailsAttribute_popup = By.xpath("//span[contains(text(),'oLPN Details')]");
	private static final By byShipViaIDField = By.xpath("//span[@data-component-id='ShipVia-list-details']");

	/**
	 * Function to store olpns into list
	 */
	public static void storeOLPNsToList() {
		List<WebElement> listOfElements = DriverManager.getDriver().findElements(byOLPNS);
		List<String> listOfOLPNs = new ArrayList<>();
		for (WebElement element : listOfElements) {
			listOfOLPNs.add(element.getText().trim());
		}
		System.out.println("oLPNS stored in variables:- " + listOfOLPNs);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "OLPN", listOfOLPNs);
	}

	/**
	 * Function to verify olpns status
	 */
	public static void verifyOLPNStatuses(String strExpected) {
		List<String> strStatus = getAllOLPNStatus();
		for (String status : strStatus) {
			SeleniumActions.verifyTextEquals(status, strExpected);
		}
	}

	/**
	 * Function to get all OLPN statuses from wave runs
	 */
	public static List<String> getAllOLPNStatus() {
		List<WebElement> oLPNStatus = DriverManager.getDriver().findElements(byOLPNStatusDescription);
		List<String> listOfOLPNStatus = new ArrayList<>();
		for (WebElement element : oLPNStatus) {
			listOfOLPNStatus.add(element.getText().trim());
		}
		FrameworkLogger.log(LogType.INFO, "list Of OLPN status stored in variables:- " + listOfOLPNStatus);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "listOfOLPNStatus", listOfOLPNStatus);
		return listOfOLPNStatus;
	}

	/**
	 * Function to verify oLPNS2.0 page is displayed
	 */
	public static void verifyoLPNSPageDisplayed() {
		SeleniumActions.verifyElementVisible(byOLPNSPage, 20, "oLPNs 2.0");
	}

	/**
	 * Function to search with Original OrderId in Order Field
	 * 
	 * @param strText - value to be search
	 */
	public static void searchOriginalOrder(String strText) {
		CommonMethods.commonSearch(byExpandOrderField, byOrderTextField, strText, "Order");
	}

	/**
	 * Function to Select the Order with status shipped
	 */
	public static void SelectShippedOrder() {
		SeleniumActions.click(byFirstShippedOrderCard, "OLPN2.0 Card");
	}

	/**
	 * Function to click the Detail button for the selected order in oLPNS Page
	 */
	public static void ClickDetailsButton() {
		SeleniumActions.click(byDetailsButton, "Details");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to validate Inventory Type and Product Status in oLPNS2.0 page
	 */
	public static void verifyOLpnsInventoryTypeAndProductStatus() {

		CommonMethods.scrollByParticularElement(byOlpnsDetailsIconExpand, "oLpns Details Expand Icon");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byOlpnsDetailsIconExpand, "oLPN Details");
		CommonMethods.waitForPageLoading();
		CommonMethods.scrollByParticularElement(byScrolloLpnsDetailTable, "oLpns Detail Table");
		CommonMethods.waitForPageLoading();
		CommonMethods.scrollByParticularElement(byScrollInventoryType, "Inventory Type");
		CommonMethods.waitForPageLoading();

		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "InventoryType",
				SeleniumActions.getText(byInventoryTypeValue).strip().trim());
		CommonMethods.scrollByParticularElement(byInventoryTypeValue, "Scroll to Inventory Type value");
		if (Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "InventoryType")
				.equals(getDataFromFeature("getdata(InventoryTypeID)"))) {
			FrameworkLogger.log(LogType.PASS, " InventoryType is displayed as Expected");

		} else {
			FrameworkLogger.log(LogType.FAIL, " InventoryType is Not displayed as Expected");
		}

		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ProductStatus",
				SeleniumActions.getText(byProductStatusValue).strip().trim());
		CommonMethods.scrollByParticularElement(byProductStatusValue, "Scroll to Product Status value");
		if (Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ProductStatus")
				.equals(getDataFromFeature("getdata(ProductStatus)"))) {
			FrameworkLogger.log(LogType.PASS, " Product Status is displayed as Expected");

		} else {
			FrameworkLogger.log(LogType.FAIL, " Product Status is Not displayed as Expected");
		}

	}

	/**
	 * Function to validate Batch number in oLPNS2.0 page
	 * 
	 * @param batchNumber - value of batch no
	 */
	public static void verifyBatchNumberInOLPNDetails(String batchNumber) {
		CommonMethods.scrollByParticularElement(byOlpnsDetailsIconExpand, "oLpns Details Expand Icon");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byOlpnsDetailsIconExpand, "oLPN Details");
		CommonMethods.waitForPageLoading();
		CommonMethods.scrollByParticularElement(byScrolloLpnsDetailTable, "oLpns Detail Table");
		CommonMethods.waitForPageLoading();
		CommonMethods.scrollByParticularElement(byBatchNumber, "Batch Number");
		CommonMethods.waitForPageLoading();
		if (SeleniumActions.isElementPresent(By.xpath("//div[@data-component-id='" + batchNumber + "']"), 4)) {
			FrameworkLogger.log(LogType.PASS, " Batch Number is displayed as Expected");

		} else {
			FrameworkLogger.log(LogType.FAIL, " Batch Number is Not displayed as Expected");
		}
	}

	/**
	 * Function to expand LPN Attributes
	 */
	public static void expandOlpnDetails() {
		CommonMethods.waitForPageLoading();
		CommonMethods.scrollByParticularElement(byOlpnsDetailsIconExpand, "oLPN Details");
		SeleniumActions.click(byOlpnsDetailsIconExpand, "oLPN Details");
		CommonMethods.scrollByParticularElement(byOlpnsDetailsIconExpand, "oLPN Details");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to check Olpn Detail checkbox
	 */
	public static void checkOlpnDetailCheckbox() {
		CommonMethods.scrollByParticularElement(byOlpnDetailsDataCheckbox, "Scroll OLPN Details checkbox");
		SeleniumActions.checkSingleCheckbox(byOlpnDetailsDataCheckbox, "Select a OLPN Details checkbox");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byOlpnDetailsButton, "Olpn Details Button");
		CommonMethods.waitForPageLoading();

	}

	/**
	 * Function to expand OLPN Details Attributes
	 */
	public static void expandOlpnDetailsAttributes() {
		SeleniumActions.click(byOlpnDetailAttribute, "OLPN DETAIL ATTRIBUTES");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to validate serial number in Olpn Detail attribute table.
	 * 
	 * @param serialNumber - value of serial no
	 */
	public static void validateSerialNumber(String serialNumber) {
		SeleniumActions.verifyElementExist(byAttributeNameSerialNumber, 5, "Header Serial Number should be displayed");
//        By by = By.xpath("(//datatable-header[@role='rowgroup'])[2]");
//        List<WebElement> header = DriverManager.getDriver().findElements(by);
//        int i = header.size();
		// for (i = 2; i >= 0 && i <= 15; i++) {
		for (int i = 52; i <= 55; i++) {
			WebElement eleValueSerialnumberHeader = DriverManager.getDriver()
					.findElement(By.xpath("(//datatable-header-cell[@role='columnheader'])[" + i + "]"));
			if (eleValueSerialnumberHeader.getAttribute("title").trim().equalsIgnoreCase("Attribute Value")) {
				WebElement eleValueSerialnumber = DriverManager.getDriver()
						.findElement(By.xpath("(//div[@class='datatable-body-cell-label']//div)[" + i + "-2]"));
				if (eleValueSerialnumber.getText().trim().equals(serialNumber)) {
					FrameworkLogger.log(LogType.PASS,
							"Serial Number is displayed as expected: " + eleValueSerialnumber.getText().trim() + ","
									+ "Actual Serial Number is displayed: " + serialNumber);
				} else {
					FrameworkLogger.log(LogType.FAIL,
							"Serial Number is NOT displayed as expected: " + eleValueSerialnumber.getText().trim() + ","
									+ "Actual Serial Number is displayed: " + serialNumber);
				}
			}
		}

	}

	/**
	 * Function to click Close Icon
	 */
	public static void clickCloseIconOlpnDetails() {
		SeleniumActions.click(byCloseIconOlpnDetails, "Close Icon Olpn Details");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click Olpn Card in Olpn
	 * 
	 * @param OLPN - olpn value
	 */
	public static void clickOLPNCardInOLPN(String OLPN) {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(By.xpath("//span[contains(text(),'" + OLPN + "')]"), "oLPN");
		FrameworkLogger.log(LogType.INFO, " OlpnId is: " + OLPN);
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byDetailsButton, "Details Button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to verify product status and product class
	 * 
	 * @param ProductStatus - value product status
	 * @param ProductClass  - value product class
	 */
	public static void verifyProductStatusAndProductClassList(String ProductStatus, String ProductClass) {
		ClickDetailsButton();
		SeleniumActions.click(byOlpnDetailsAttribute_popup, "Click OLPNs details attribute in popup");
		CommonMethods.waitForPageLoading();
		List<WebElement> productStatus = DriverManager.getDriver().findElements(byProductStatusList);
		List<WebElement> productClass = DriverManager.getDriver().findElements(byProductClassList);
		for (WebElement e : productStatus) {
			CommonMethods.scrollByParticularElement(e, "oLpns Product Status");
			if (e.getText().trim().equalsIgnoreCase(getDataFromFeature(getData(ProductStatus)))) {
				FrameworkLogger.log(LogType.PASS, "oLPN product status is : " + e.getText());
			}
		}
		for (WebElement e : productClass) {
			CommonMethods.scrollByParticularElement(e, "oLpns Product Class");
			if (e.getText().trim().equalsIgnoreCase(getDataFromFeature(getData(ProductClass)))) {
				FrameworkLogger.log(LogType.PASS, "oLPN product class is : " + e.getText());
			}
		}
		SeleniumActions.click(byCloseOILPNsPopup, "Close OLPNs popup");
		CommonMethods.waitForPageLoading();
	}

	public static void verifyShipViaIDOfOLPNs() {
		List<String> oLPNsList = (List<String>) Variables
				.get(CurrentThreadInstance.getCurrentScenarioId() + "listOfOLPNs");
		SeleniumActions.click(byExpandOrderField, "Expand order Input Field");

		for (int i = 1; i <= oLPNsList.size(); i++) {
			DriverManager.getDriver().findElement(byOrderTextField).sendKeys(
					(CharSequence) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder" + i));
			DriverManager.getDriver().findElement(byOrderTextField).sendKeys(Keys.ENTER);
			FrameworkLogger.log(LogType.PASS, "Filtered with order " + i + " : "
					+ Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder" + i));
			CommonMethods.waitForPageLoading();
			if (SeleniumActions.getText(byShipViaIDField)
					.equalsIgnoreCase(getDataFromFeature(getData("ShipViaOrder" + i)))) {
				FrameworkLogger.log(LogType.PASS, "ShipVia ID is : " + SeleniumActions.getText(byShipViaIDField));
			}
			DriverManager.getDriver().findElement(byOrderTextField).clear();
		}
	}
}
