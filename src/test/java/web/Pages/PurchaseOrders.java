package web.Pages;

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
public class PurchaseOrders extends TestData_Json {

	private static final By byPurchaseOrdersPage = By.xpath("//span[contains(text(),'Purchase Orders')]");
	private static final By bySearchField = By.xpath("//ion-input[@data-component-id='PurchaseOrderId-filter']/input");
	private static final By byPOCard = By.xpath("//*[contains(text(),'Purchase Order :')]");
	// private static final By byRelatedLinks =
	// By.xpath("//*[contains(text(),'Related Links')]"); // this object reference
	// availabel under HeaderPanelPage
	private static final By byPurchaseOrderLine = By.xpath("//*[text()='Purchase Order Line']");
	private static final By byExpandPurchasefield = By.xpath(
			"//span[@title='Purchase Order']/following-sibling::ion-button[@data-component-id='expand-button-filter-field-header']");
	private static final By byTaskDetails = By.xpath("//a[text()='Task Details']");

	/**
	 * Function to verify purchase order page is displayed
	 */
	public static void verifyPurchaseOrdersPageDisplayed() {
		SeleniumActions.verifyElementVisible(byPurchaseOrdersPage, 20, "Purchase Orders page");
	}

	/**
	 * Function to search purchase order
	 * 
	 * @param strPO - Purchase order value to be searched
	 */
	public static void searchPurchaseOrder(String strPO) {
		CommonMethods.waitForPageLoading();
		if (DriverManager.getDriver().findElements(bySearchField).size() < 1) {
			SeleniumActions.click(byExpandPurchasefield, "Expand icon");
		}
		SeleniumActions.sendTextToElement(bySearchField, strPO, "PO search field");
		KeyboardActions.pressEnterKey(bySearchField);
		CommonMethods.waitForPageLoading();
		if (!SeleniumActions.isElementPresent(byPOCard, 10)) {
			FrameworkLogger.log(LogType.FAIL, "Expected PO \"" + strPO + "\" is not displayed!");
		} else {
			FrameworkLogger.log(LogType.PASS, "Expected PO \"" + strPO + "\" is displayed!");
		}
		SeleniumActions.click(byPOCard, "PO Card");
	}

	/**
	 * Function to verify purchase order line elements are visible/exist
	 */
	public static void verifyPurchaseOrderLine() {
		String strBusiness = Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "BUID").toString();
		String ItemID_Line1 = Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ItemID_Line1").toString();
		String LineID_Line1 = Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "LineID_Line1").toString();
		String OrdQty_Line1 = Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "OrdQty_Line1").toString();
		String LineID_Line2 = Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "LineID_Line2").toString();
		String OrdQty_Line2 = Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "OrdQty_Line2").toString();
		String strXpathBusiness = "//div[normalize-space()='Business Unit : " + strBusiness + "']";
		String strXpathItem1 = "//div[normalize-space()='Item : " + ItemID_Line1 + "']";
		String strXpathLineId1 = "//div[normalize-space()='Purchase Order Line : " + LineID_Line1 + "']";
		String strXpathOrdQty1 = "//div[normalize-space()='Order quantity : " + OrdQty_Line1 + " UNIT']";
		String strXpathLineId2 = "//div[normalize-space()='Purchase Order Line : " + LineID_Line2 + "']";
		String strXpathOrdQty2 = "//div[normalize-space()='Order quantity : " + OrdQty_Line2 + " UNIT']";
		SeleniumActions.verifyElementExist(By.xpath(strXpathBusiness), 2, "Business Unit : " + strBusiness);
		SeleniumActions.verifyElementExist(By.xpath(strXpathItem1), 2, "Item :" + ItemID_Line1);
		SeleniumActions.verifyElementExist(By.xpath(strXpathLineId1), 2, "Purchase Order Line : " + LineID_Line1);
		SeleniumActions.verifyElementExist(By.xpath(strXpathOrdQty1), 2, "Order Quantity : " + OrdQty_Line1 + " UNIT");
		SeleniumActions.verifyElementExist(By.xpath(strXpathLineId2), 2, "Purchase Order Line : " + LineID_Line2);
		SeleniumActions.verifyElementExist(By.xpath(strXpathOrdQty2), 2, "Order Quantity : " + OrdQty_Line2 + " UNIT");
	}
}