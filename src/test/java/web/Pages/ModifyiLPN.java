package web.Pages;

import org.openqa.selenium.By;

import com.dhl.reports.FrameworkLogger;
import com.dhl.reports.LogType;
import com.dhl.testdata.TestData_Json;
import com.dhl.utils.CurrentThreadInstance;
import com.dhl.utils.Variables;
import com.dhl.web.utils.SeleniumActions;

import stepdefinitions.CommonMethods;

@SuppressWarnings("unused")
public class ModifyiLPN extends TestData_Json {

	private static final By byFNModifyILPNSPage = By.xpath("//ion-title[contains(@data-component-id,'fnmodifyilpnid')]");
	private static final By byiLPNField = By.xpath("//input[contains(@data-component-id,'acceptilpn_barcodetextfield_ilpn')]");
	private static final By byGoButton = By.xpath("//ion-button[contains(@data-component-id,'barcodetextfield_go')]");
	private static final By byiLPNText = By.xpath("//*[contains(@data-component-id,'acceptquantity_naturalquantityfield_ilpn')]");
	private static final By byItemText = By.xpath("//*[contains(@data-component-id,'acceptquantity_naturalquantityfield_item')]");
	private static final By byBatchNumberText = By
			.xpath("//*[contains(@data-component-id,'acceptquantity_naturalquantityfield_batchnumber')]");
	private static final By byCurrentQuantityText = By
			.xpath("//*[contains(@data-component-id,'acceptquantity_naturalquantityfield_currentquantity')]");
	private static final By byEnterQtyInput = By
			.xpath("//input[contains(@data-component-id,'acceptquantity_naturalquantityfield_unit')]");
	private static final By byAcceptGoButton = By
			.xpath("//ion-button[contains(@data-component-id,'acceptquantity_naturalquantityfield_go')]");
	private static final By byReasonCodeText = By
			.xpath("//*[contains(@data-component-id,'acceptreasoncode_lookuptextfield_reasoncode')]");
	private static final By byReasonCodeDropdown = By
			.xpath("//span[contains(@data-component-id,'acceptreasoncode_lookuptextfield_presentlookupmodal')]");
	private static final By byloststockReasonCode = By.xpath("//div[contains(@data-component-id,'(10)loststock(-)')]");
	private static final By byfoundReasonCode = By.xpath("//div[contains(@data-component-id,'(11)found(+)')]");
	private static final By bykitconversionReasonCode = By
			.xpath("//div[contains(@data-component-id,'(12)kitconversion(+/-)')]");
	private static final By byoutboundshipmentReasonCode = By
			.xpath("//div[contains(@data-component-id,'(13)outboundshipment(-)')]");
	private static final By byDisposeReasonCode = By.xpath("//div[contains(@data-component-id,'(14) Dispose (-)')]");
	private static final By byInboundDeliveryDiscrepanciesReasonCode = By
			.xpath("//div[contains(@data-component-id,'(21) Inbound delivery discrepancies')]"); //finetune // not Used anywhere


	/**
	 * Function to verify Page is displayed
	 */
	public static void verifyPageDisplayed() {
		SeleniumActions.verifyElementVisible(byFNModifyILPNSPage, 20, "FN Modify iLPN Id page");
	}

	/**
	 * Function to search LPN
	 * 
	 * @param strText - LPN value
	 */
	public static void searchLPN(String strText) {
		SeleniumActions.getElement(byiLPNField).clear();
		SeleniumActions.sendTextToElement(byiLPNField, strText, "LPN search field");
		SeleniumActions.click(byGoButton, "Go button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to Read current quantity populated in the screen
	 */
	public static void readCurrentQuantity() {
		CommonMethods.waitForPageLoading();
		String strcurrentQuantity = SeleniumActions.getText(byCurrentQuantityText);
		if (strcurrentQuantity != null && !strcurrentQuantity.trim().isEmpty()) {
			Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "CurrentQty",
					strcurrentQuantity.replace(" UNIT", ""));
		} else {
			FrameworkLogger.log(LogType.FAIL, "ASN is null or empty");
		}
	}

	/**
	 * Function to update Positive Quantity in Enter Quantity field
	 * 
	 * @param iQuantity - Quantity to be updated with respect to current quantity
	 */
	public static void updateQuantity(int iQuantity) {
		CommonMethods.waitForPageLoading();
		SeleniumActions.sendTextToElement(byEnterQtyInput, String.valueOf(iQuantity), "Enter Quantity field");
		SeleniumActions.click(byAcceptGoButton, "Accept Quantity Go button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to update Reason code and reference codes
	 */
	public static void updateCodesQuantity() {
		CommonMethods.waitForPageLoading();
		SeleniumActions.sendTextToElement(byReasonCodeText, String.valueOf(getDataFromFeature("getdata(ReasonCode)")),
				"Enter Reason code field");
		SeleniumActions.click(byGoButton, "Reason Code Go button");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byGoButton, "Reference Accepted Go button");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byGoButton, "Secondary Reference Go button");
		CommonMethods.waitForPageLoading();
	}

}
