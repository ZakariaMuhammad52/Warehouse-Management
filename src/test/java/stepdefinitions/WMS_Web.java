package stepdefinitions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import com.dhl.reports.FrameworkLogger;
import com.dhl.reports.LogType;
import com.dhl.testdata.TestData_Json;
import com.dhl.utils.ConfigurationUtils;
import com.dhl.utils.CurrentThreadInstance;
import com.dhl.utils.GeneralUtils;
import com.dhl.utils.RandomUtils;
import com.dhl.utils.Variables;
import com.dhl.web.utils.SeleniumActions;
import com.github.javafaker.Faker;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import web.Pages.ASNDetailsPage;
import web.Pages.ASNs;
import web.Pages.ATPalletPutAwaySystemDirected;
import web.Pages.ATStandardReceiving;
import web.Pages.ATSystemDirectedPutAway;
import web.Pages.ATUserDirectedPutAway;
import web.Pages.AdjustPopup;
import web.Pages.AllocationPage;
import web.Pages.BatchMasterPage;
import web.Pages.CommonPage;
import web.Pages.CommonPopupPage;
import web.Pages.CommonWMMobilePage;
import web.Pages.ContainerTypePage;
import web.Pages.CreateILPN;
import web.Pages.Cubing;
import web.Pages.FNPackILPNDirectedPage;
import web.Pages.FNPutAwaySystemDirected;
import web.Pages.FNTrolleyPutAwayPage;
import web.Pages.FNTrolleyReceivingPage;
import web.Pages.FooterPanelPage;
import web.Pages.HeaderPanelPage;
import web.Pages.HomePage;
import web.Pages.ILPNPopupPage;
import web.Pages.ILPNs;
import web.Pages.InventoryCountDetailsPage;
import web.Pages.InventoryCountPage;
import web.Pages.InventoryDetailsPage;
import web.Pages.ItemsPage;
import web.Pages.ItemsPopupPage;
import web.Pages.LeftPanelPage;
import web.Pages.LocationCapacityUsagePage;
import web.Pages.LocationInventory;
import web.Pages.LocationPopupPage;
import web.Pages.LoginPage;
import web.Pages.ModifyiLPN;
import web.Pages.NotificationPage;
import web.Pages.Olpns;
import web.Pages.OrdersPage;
import web.Pages.OrganizationUsersListPage;
import web.Pages.OriginalOrdersPage;
import web.Pages.PickPackLPNPage;
import web.Pages.PixVisibilityPage;
import web.Pages.PopupWrapper;
import web.Pages.ProductStatusMatrixPage;
import web.Pages.PurchaseOrderLineLookup;
import web.Pages.PurchaseOrders;
import web.Pages.PutAwayPlanningStrategyPage;
import web.Pages.ReceiveLPNLevel;
import web.Pages.RolesListPage;
import web.Pages.StorageLocation;
import web.Pages.SystemDirected;
import web.Pages.TasksPage;
import web.Pages.UserDirected;
import web.Pages.ViewJsonPage;
import web.Pages.WMMobile;
import web.Pages.WaveRunsPage;
import web.Pages.oLPNPage;

@SuppressWarnings("unchecked")
public class WMS_Web extends TestData_Json {
	@And("Login to WMS Manhattan")
	public void login_manhattan() {
		String strUsername = ConfigurationUtils.getFrameworkConfig("appusername");
		String strPassword = ConfigurationUtils.getFrameworkConfig("apppassword");
		LoginPage.enter_Username(strUsername);
		LoginPage.click_SubmitUser();
		LoginPage.enter_password(GeneralUtils.decodeBase64ToString(strPassword));
		LoginPage.click_LoginBt();
		HomePage.verifyUDCPageDisplayed();
	}

	@And("Login to WMS Manhattan via SSO Login")
	public void login_to_wms_manhattan_via_sso_login() {
		LoginPage.click_SsoLogin();
		HomePage.verifyUDCPageDisplayed();
	}

	@And("Navigate to Purchase Orders")
	public void navigate_to_purchase_orders() {
		HomePage.navigate_to_purchaseOrders();
		PurchaseOrders.verifyPurchaseOrdersPageDisplayed();
	}

	@And("Navigate to Location Inventory")
	public void navigate_to_location_inventory() {
		HomePage.navigate_to_LocationInventry();
		LocationInventory.verifyLocationInventoryPageDisplayed();
	}

	@And("Search Purchase Order {string}")
	public void search_purchase_order(String strKey) {
		PurchaseOrders
				.searchPurchaseOrder(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "PO_ID").toString());
		// PurchaseOrders.searchPurchaseOrder(getDataFromFeature("getdata(PO_ID)"));
	}

	@And("Search Purchase Order")
	public void search_purchase_order() {
		PurchaseOrders
				.searchPurchaseOrder(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "PO_ID").toString());
		// PurchaseOrders.searchPurchaseOrder(getDataFromFeature("getdata(PO_ID)"));
	}

	@And("Navigate to ASNs")
	public void navigate_to_asn() {
		HomePage.navigate_to_ASNs();
		ASNs.verifyASNsPageDisplayed();
	}

	@And("Navigate to ILPNs")
	public void navigate_to_ILPNs() {
		HomePage.navigate_to_ILPNs();
		ILPNs.verifyPageDisplayed();
	}

	@And("Navigate to WM Mobile")
	public void navigate_to_wmMobile() {
		HomePage.navigate_to_wmmobile();
		WMMobile.verifyPageDisplayed();
	}

	@And("Navigate to Storeage Location")
	public void navigate_to_storeage_location() {
		HomePage.navigate_to_StorageLocation();
		StorageLocation.verifyStorageLocationsPageDisplayed();
	}

	@And("Enter Details at Create ASN Pop-up")
	public void enterDateInASNPopUp() {
		ASNs.enterDateInASNPopUp();
		PurchaseOrderLineLookup.verifyPageDisplayed();
	}

	@And("Search PO at Purchase Order Line Lookup screen")
	public void searchPOAtPOLine() {
		PurchaseOrderLineLookup
				.searchPO(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "PO_ID").toString());
		// PurchaseOrderLineLookup.searchPO(getDataFromFeature("getdata(PO_ID)"));
	}

	@And("Update ASN with ItemID Quantity Status And No Batch {string}")
	public void updateASNWithItemQtyAndStatusNoBatch(String fileName) throws Exception {
		String AsnId = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(AsnId)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ASN", AsnId);
		FrameworkLogger.log(LogType.INFO, "Set value for ASNID : " + AsnId);
		ArrayList<String> al = new ArrayList<>();
		al.add("Asn::2::3::" + AsnId);
		al.add("AsnLine::2::2::" + AsnId);
		al.add("AsnLine::2::7::" + getDataFromFeature("getdata(ItemID_Line_1)"));
		al.add("AsnLine::2::8::" + getDataFromFeature("getdata(OrdQty_Line1)"));
		al.add("AsnLine::2::19::" + getDataFromFeature("getdata(InventoryTypeID)"));
		al.add("AsnLine::2::20::" + getDataFromFeature("getdata(ProductStatusID)"));
		// al.add("AsnLine::3::2::" + AsnId);
		// al.add("AsnLine::3::7::" + getDataFromFeature("getdata(ItemID_Line_2)"));
		// al.add("AsnLine::3::8::" + getDataFromFeature("getdata(orderLineQuantity)"));
		// al.add("AsnLine::3::19::" + getDataFromFeature("getdata(InventoryTypeID)"));
		// al.add("AsnLine::3::20::" + getDataFromFeature("getdata(ProductStatusID)"));
		ExcelUtil1.setMultipleCellData(fileName, al);
	}

	/*
	 * @And("Search ASN at ASNs") public void searchASNinAsns() {
	 * ASNs.searchASN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "ASN").toString()); }
	 * 
	 * @And("Search Wave run at Wave Runs") public void searchWaveRuninWaveRuns() {
	 * WaveRunsPage.searchWaveRuns(Variables.get(CurrentThreadInstance.
	 * getCurrentScenarioId() + "WaveRun").toString()); }
	 * 
	 * @And("Verify ASN details are displayed") public static void
	 * verifyASNDetailsDisplayed() { ASNs.verifyASNDetailsDisplayed((String)
	 * Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN")); }
	 * 
	 * @And("Update Quantity of LPNs") public static void updateQuantityOfLpns() {
	 * ASNs.updateQuantityOfLpns(1); }
	 * 
	 * @And("Store ASN number in runtime variable") public static void
	 * captureASNNumber() { ASNs.captureASNNumber(); }
	 * 
	 * @And("Search ASN at ILPNs") public void searchASNinILPNs() {
	 * ILPNs.searchASN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "ASN").toString()); }
	 * 
	 * @And("Search iLPN at ILPNs") public void searchiLPNinILPNs() {
	 * ILPNs.searchLPN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "LPN" + 1).toString()); }
	 * 
	 * @And("Store iLPNs to runtime variables as list") public static void
	 * storeILPNsToList() { ILPNs.storeILPNsToList(); }
	 * 
	 * @And("Verify exported excel values") public static void excelValidation() {
	 * ILPNs.excelValidation(); }
	 * 
	 * @And("Search menu {string} at WM Mobile") public void
	 * searchMenuWmMobile(String strText) { WMMobile.searchMenu(strText); }
	 * 
	 * @And("Receive LPNs at WM Mobile using ASN") public void receiveLpns() {
	 * ReceiveLPNLevel.verifyPageDisplayed(); List<String> listOFiLPNs =
	 * (List<String>) Variables .get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "listOFiLPNs"); ReceiveLPNLevel.receiveLPNs(listOFiLPNs);
	 * CommonMethods.waitForPageLoading(); }
	 * 
	 * @And("Verify receiving ASN") public void verifyReceivingASN() {
	 * ASNs.verifyReceivingASN(); }
	 * 
	 * @And("Verify receiving ASN wo buttonpopup") public void
	 * verifyReceivingASNWoButtonpopup() { ASNs.verifyReceivingASNwobuttonpopup(); }
	 * 
	 * @And("Validate ASN status {string}") public void validate_asn_status(String
	 * ASNStatus) { ASNs.verifyASNStatus(ASNStatus); }
	 * 
	 * @And("Put away LPNs") public void putAwayLPNs() {
	 * SystemDirected.verifyPageDisplayed(); List<String> listOFiLPNs = new
	 * ArrayList<>(); if (Variables.get(CurrentThreadInstance.getCurrentScenarioId()
	 * + "listOFiLPNs") instanceof List<?>) { listOFiLPNs = (List<String>)
	 * Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "listOFiLPNs");
	 * } SystemDirected.putAwayLPNs(listOFiLPNs); }
	 * 
	 * @And("Putaway LPN User Directed") public void putaway_lpn_user_directed() {
	 * String strLPN = Variables.get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "LPN" + 0).toString(); UserDirected.putawayLPN(strLPN); }
	 * 
	 * @And("Putaway LPN System Directed") public void putaway_lpn_system_directed()
	 * { String strLPN = Variables.get(CurrentThreadInstance.getCurrentScenarioId()
	 * + "LPN" + 1).toString(); SystemDirected.putawayLPN(strLPN); }
	 * 
	 * @And("Navigate back to Parent window") public static void
	 * backToParentWindow() {
	 * SeleniumActions.switchWindowWithHandle(Variables.get("mainwindow").toString()
	 * ); }
	 * 
	 * @And("Wait for page loading") public static void waitForPageLoading() {
	 * CommonMethods.waitForPageLoading(); }
	 * 
	 * @And("Update Business Unit {string}") public void update_business_unit(String
	 * strText) { HomePage.updateBusinessUnit(getDataFromFeature(strText)); }
	 */

	@And("Search ASN at ASNs")

	public void searchASNinAsns() {
		ASNs.searchASN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN").toString());
	}

	@And("Search Wave run at Wave Runs")
	public void searchWaveRuninWaveRuns() {
		WaveRunsPage.searchWaveRuns(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "WaveRun").toString());
	}

	@And("Verify ASN details are displayed")
	public static void verifyASNDetailsDisplayed() {
		ASNs.verifyASNDetailsDisplayed((String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN"));
	}

	@And("Update Quantity of LPNs")
	public static void updateQuantityOfLpns() {
		ASNs.updateQuantityOfLpns(1);
	}

	@And("Store ASN number in runtime variable")
	public static void captureASNNumber() {
		ASNs.captureASNNumber();
	}

	@And("Search ASN at ILPNs")
	public void searchASNinILPNs() {
		ILPNs.searchASN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN").toString());
	}

	@And("Search iLPN at ILPNs")
	public void searchiLPNinILPNs() {
		ILPNs.searchLPN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "LPN" + 1).toString());
	}

	@And("Store iLPNs to runtime variables as list")
	public static void storeILPNsToList() {
		ILPNs.storeILPNsToList();
	}

	@And("Verify exported excel values")
	public static void excelValidation() {
		ILPNs.excelValidation();
	}

	@And("Search menu {string} at WM Mobile")
	public void searchMenuWmMobile(String strText) {
		WMMobile.searchMenu(strText);
	}

	@And("Receive LPNs at WM Mobile using ASN")
	public void receiveLpns() {
		ReceiveLPNLevel.verifyPageDisplayed();
		List<String> listOFiLPNs = (List<String>) Variables
				.get(CurrentThreadInstance.getCurrentScenarioId() + "listOFiLPNs");
		ReceiveLPNLevel.receiveLPNs(listOFiLPNs);
		CommonMethods.waitForPageLoading();
	}

	@And("Verify receiving ASN")
	public void verifyReceivingASN() {
		ASNs.verifyReceivingASN();
	}

	@And("Verify receiving ASN wo buttonpopup")
	public void verifyReceivingASNWoButtonpopup() {
		ASNs.verifyReceivingASNwobuttonpopup();
	}

	@And("Validate ASN status {string}")
	public void validate_asn_status(String ASNStatus) {
		ASNs.verifyASNStatus(ASNStatus);
	}

	@And("Put away LPNs")
	public void putAwayLPNs() {
		SystemDirected.verifyPageDisplayed();
		List<String> listOFiLPNs = new ArrayList<>();
		if (Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "listOFiLPNs") instanceof List<?>) {
			listOFiLPNs = (List<String>) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "listOFiLPNs");
		}
		SystemDirected.putAwayLPNs(listOFiLPNs);
	}

	@And("Putaway LPN User Directed")
	public void putaway_lpn_user_directed() {
		String strLPN = Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "LPN" + 0).toString();
		UserDirected.putawayLPN(strLPN);
	}

	@And("Putaway LPN System Directed")
	public void putaway_lpn_system_directed() {
		String strLPN = Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "LPN" + 1).toString();
		SystemDirected.putawayLPN(strLPN);
	}

	@And("Navigate back to Parent window")
	public static void backToParentWindow() {
		SeleniumActions.switchWindowWithHandle(Variables.get("mainwindow").toString());
	}

	@And("Wait for page loading")
	public static void waitForPageLoading() {
		CommonMethods.waitForPageLoading();
	}

	@And("Update Business Unit {string}")
	public void update_business_unit(String strText) {
		HomePage.updateBusinessUnit(getDataFromFeature(strText));
	}

	@And("Edit OrgProfile")
	public void edit_org_profile() {
		HomePage.editOrgProfile();
	}

	@And("Complete ATStandardReceiving with produtstatus")
	public void completeATStandardReceivingWithProdutstatus() {
		ReceiveLPNLevel.searchASN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN").toString());
		ReceiveLPNLevel.enterLPN(ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(LPNId)")));
		ReceiveLPNLevel.enterScanItem(getDataFromFeature("getdata(ItemID_Line1)"));
		ReceiveLPNLevel.searchInventory("F");
		ReceiveLPNLevel.searchProductStatus("A");
	}

	@And("Complete ATStandardReceiving and Validate Quantity exceeds error")
	public void complete_at_standard_receiving_and_validate_quantity_exceeds_error() {
		ReceiveLPNLevel.searchASN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN").toString());
		float iReceiveFloat = Integer.valueOf(getDataFromFeature("getdata(OrdQty_Line1)"))
				/ Integer.valueOf(getDataFromFeature("getdata(QtyToAssign_Line1_Valid)"));
		int iRecieveLoop = (int) iReceiveFloat;
		for (int iReceive = 0; iReceive <= iRecieveLoop; iReceive++) {
			if (iReceive < iRecieveLoop) {
				FrameworkLogger.log(LogType.PASS, iReceive + " Loop " + iRecieveLoop);
				ReceiveLPNLevel.atStandardReceiving(null, iReceive,
						getDataFromFeature("getdata(QtyToAssign_Line1_Valid)"));
				ReceiveLPNLevel.verifyErrorNotDisplayed();
			}
			if (iReceive == iRecieveLoop) {
				FrameworkLogger.log(LogType.PASS, iReceive + " error Loop " + iRecieveLoop);
				ReceiveLPNLevel.atStandardReceiving(null, iReceive,
						getDataFromFeature("getdata(QtyToAssign_Line1_InValid)"));
				ReceiveLPNLevel.verifyErrorDisplayed();
			}
		}
	}

	@And("Complete ATStandardReceiving duplicate lines")
	public void complete_at_standard_receiving_duplicate_lines() {
		ReceiveLPNLevel.searchASN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN").toString());
		ReceiveLPNLevel.atStandardReceiving(null, 1, getDataFromFeature("getdata(OrdQty_Line1)"));
		ReceiveLPNLevel.atStandardReceiving(null, 2, getDataFromFeature("getdata(OrdQty_Line2)"));
		ReceiveLPNLevel.verifyErrorNotDisplayed();
	}

	@And("Complete ATStandardReceiving")
	public void complete_at_standard_receiving() {
		ReceiveLPNLevel.searchASN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN").toString());
		ReceiveLPNLevel.atStandardReceiving(null, 1, getDataFromFeature("getdata(OrdQty_Line1)"));
		ReceiveLPNLevel.verifyErrorNotDisplayed();
	}

	@And("Complete ATStandardReceiving With Serial Number")
	public void complete_at_standard_receiving_serial_number() {
		ReceiveLPNLevel.searchASN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN").toString());
		ReceiveLPNLevel.enterLPN(null, 1);
		ReceiveLPNLevel.enterScanItem(getDataFromFeature("getdata(ItemID_Line1)"));
		ReceiveLPNLevel.searchProductStatus(null);
		ReceiveLPNLevel.searchProductStatus(null);
		ReceiveLPNLevel.enterQuantity(Integer.parseInt(getDataFromFeature("getdata(OrdQty_Line1)")));
		int iRecieveLoop = Integer.parseInt(getDataFromFeature("getdata(OrdQty_Line1)"));
		String strSerial = RandomUtils.generateString_WithTimeStamp("SN0", "yyMMddmm");
		for (int iReceive = 1; iReceive <= iRecieveLoop; iReceive++) {
			String strSerial1 = strSerial + iReceive;
			ReceiveLPNLevel.enterSerialNumber(strSerial1);
			Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "SerialNumber" + iReceive, strSerial1);
		}
		ReceiveLPNLevel.verifyErrorNotDisplayed();
	}

	@And("Complete AT BlindReceiving")
	public void complete_at_blind_receiving() {
		ReceiveLPNLevel.searchASN(null);
		ReceiveLPNLevel.enterLPN(null, 1);
		ReceiveLPNLevel.enterScanItem(getDataFromFeature("getdata(ItemID_Line1)"));
		ReceiveLPNLevel.enterBatchnumber(getDataFromFeature("getdata(BatchNo_Line1)"));
		ReceiveLPNLevel.enterQuantity(Integer.parseInt(getDataFromFeature("getdata(OrdQty_Line1)")));
	}

	@And("Verify Inventry updated")
	public void verify_inventry_updated() {
		SeleniumActions.switchToWindowUsingIndex(0);
		HomePage.navigate_to_StorageLocation();
		StorageLocation.saveCurrentQuantity("CurrentQtyUpdated");
		if (Integer.parseInt(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "CurrentQtyBeforeUpdate")
				.toString()) < Integer.parseInt(
						Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "CurrentQtyUpdated").toString())) {
			FrameworkLogger.log(LogType.PASS, "Current Quantity value is updated");
		} else {
			FrameworkLogger.log(LogType.FAIL, "Current Quantity is not updated");
		}
	}

	@And("Validate popup message {string}")
	public void validate_popup_message(String strMsg) {
		PopupWrapper.validatePopupMessage(strMsg);
	}

	@And("Verify Blind receiving")
	public void verify_blind_receiving() {
		PopupWrapper.BlindPopupMessage();
	}

	@And("Verify variance and Accept")
	public void verify_variance_and_accept() {
		PopupWrapper.validateVarianceMessage("Variance exists for ASN "
				+ Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN").toString() + ".");
	}

	@And("Positive Quantity Adjustment")
	public void positive_quantity_adjustment() {
		ModifyiLPN.verifyPageDisplayed();
		String strLPN = Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "LPN" + 1).toString();
		ModifyiLPN.searchLPN(strLPN);
		ModifyiLPN.readCurrentQuantity();
		int iQuantityValue = Integer
				.parseInt(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "CurrentQty").toString())
				+ Integer.parseInt(getDataFromFeature("getdata(PositiveQtyIncrement)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "AdjustedValue", iQuantityValue);
		ModifyiLPN.updateQuantity(iQuantityValue);
		ModifyiLPN.updateCodesQuantity();
		SeleniumActions.closeBrowser();
		SeleniumActions.switchToLastWindow();
	}

	@And("Negative Quantity Adjustment")
	public void negative_quantity_adjustment() {
		ModifyiLPN.verifyPageDisplayed();
		String strLPN = Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "LPN" + 1).toString();
		ModifyiLPN.searchLPN(strLPN);
		ModifyiLPN.readCurrentQuantity();
		int iCurrentQuantity = Integer
				.parseInt(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "CurrentQty").toString());
		if (iCurrentQuantity > Integer.parseInt(getDataFromFeature("getdata(NegativeQtyDecrement)"))) {
			int iQuantityValue = iCurrentQuantity
					- Integer.parseInt(getDataFromFeature("getdata(NegativeQtyDecrement)"));
			Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "AdjustedValue", iQuantityValue);
			ModifyiLPN.updateQuantity(iQuantityValue);
			ModifyiLPN.updateCodesQuantity();
		} else {
			FrameworkLogger.log(LogType.FAIL, Integer.parseInt(getDataFromFeature("getdata(NegativeQtyDecrement)"))
					+ "requested quantity cannot be updated");
		}
		SeleniumActions.closeBrowser();
		SeleniumActions.switchToLastWindow();

	}

	@And("Validate Quantity Adjustment")
	public void validate_quantity_adjustment() {
		ILPNs.searchLPN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "LPN" + 1).toString());
		ILPNs.navigateToLocationInventory();
		ILPNs.validateCurrentQuantity();
	}

	@And("Search Display location at Location Inventory")
	public void search_display_location_at_location_inventory() {
		LocationInventory.searchDisplayLocation(getDataFromFeature("getdata(DisplayLocation)"), true);

	}

	@And("Search Display location With {string} in Location Inventory")
	public void searchDisplayLocationWithInLocationInventory(String location) {
		LocationInventory.searchDisplayLocation(getDataFromFeature(location), false);
	}

	/*
	 * @And("Complete ATStandardReceiving with produtstatus") public void
	 * completeATStandardReceivingWithProdutstatus() {
	 * ReceiveLPNLevel.searchASN(Variables.get(CurrentThreadInstance.
	 * getCurrentScenarioId() + "ASN").toString());
	 * ReceiveLPNLevel.enterLPN(ExcelUtil1.convert_variable_to_timestamp(
	 * getDataFromFeature("getdata(LPNId)")));
	 * ReceiveLPNLevel.enterScanItem(getDataFromFeature("getdata(ItemID_Line1)"));
	 * ReceiveLPNLevel.searchInventory("F");
	 * ReceiveLPNLevel.searchProductStatus("A"); }
	 * 
	 * @And("Complete ATStandardReceiving and Validate Quantity exceeds error")
	 * public void
	 * complete_at_standard_receiving_and_validate_quantity_exceeds_error() {
	 * ReceiveLPNLevel.searchASN(Variables.get(CurrentThreadInstance.
	 * getCurrentScenarioId() + "ASN").toString()); float iReceiveFloat =
	 * Integer.valueOf(getDataFromFeature("getdata(OrdQty_Line1)")) /
	 * Integer.valueOf(getDataFromFeature("getdata(QtyToAssign_Line1_Valid)")); int
	 * iRecieveLoop = (int) iReceiveFloat; for (int iReceive = 0; iReceive <=
	 * iRecieveLoop; iReceive++) { if (iReceive < iRecieveLoop) {
	 * FrameworkLogger.log(LogType.PASS, iReceive + " Loop " + iRecieveLoop);
	 * ReceiveLPNLevel.atStandardReceiving(null, iReceive,
	 * getDataFromFeature("getdata(QtyToAssign_Line1_Valid)"));
	 * ReceiveLPNLevel.verifyErrorNotDisplayed(); } if (iReceive == iRecieveLoop) {
	 * FrameworkLogger.log(LogType.PASS, iReceive + " error Loop " + iRecieveLoop);
	 * ReceiveLPNLevel.atStandardReceiving(null, iReceive,
	 * getDataFromFeature("getdata(QtyToAssign_Line1_InValid)"));
	 * ReceiveLPNLevel.verifyErrorDisplayed(); } } }
	 * 
	 * @And("Complete ATStandardReceiving duplicate lines") public void
	 * complete_at_standard_receiving_duplicate_lines() {
	 * ReceiveLPNLevel.searchASN(Variables.get(CurrentThreadInstance.
	 * getCurrentScenarioId() + "ASN").toString());
	 * ReceiveLPNLevel.atStandardReceiving(null, 1,
	 * getDataFromFeature("getdata(OrdQty_Line1)"));
	 * ReceiveLPNLevel.atStandardReceiving(null, 2,
	 * getDataFromFeature("getdata(OrdQty_Line2)"));
	 * ReceiveLPNLevel.verifyErrorNotDisplayed(); }
	 * 
	 * @And("Complete ATStandardReceiving") public void
	 * complete_at_standard_receiving() {
	 * ReceiveLPNLevel.searchASN(Variables.get(CurrentThreadInstance.
	 * getCurrentScenarioId() + "ASN").toString());
	 * ReceiveLPNLevel.atStandardReceiving(null, 1,
	 * getDataFromFeature("getdata(OrdQty_Line1)"));
	 * ReceiveLPNLevel.verifyErrorNotDisplayed(); }
	 * 
	 * @And("Complete ATStandardReceiving With Serial Number") public void
	 * complete_at_standard_receiving_serial_number() {
	 * ReceiveLPNLevel.searchASN(Variables.get(CurrentThreadInstance.
	 * getCurrentScenarioId() + "ASN").toString()); ReceiveLPNLevel.enterLPN(null,
	 * 1);
	 * ReceiveLPNLevel.enterScanItem(getDataFromFeature("getdata(ItemID_Line1)"));
	 * ReceiveLPNLevel.searchProductStatus(null);
	 * ReceiveLPNLevel.searchProductStatus(null);
	 * ReceiveLPNLevel.enterQuantity(Integer.parseInt(getDataFromFeature(
	 * "getdata(OrdQty_Line1)"))); int iRecieveLoop =
	 * Integer.parseInt(getDataFromFeature("getdata(OrdQty_Line1)")); String
	 * strSerial = RandomUtils.generateString_WithTimeStamp("SN0", "yyMMddmm"); for
	 * (int iReceive = 1; iReceive <= iRecieveLoop; iReceive++) { String strSerial1
	 * = strSerial + iReceive; ReceiveLPNLevel.enterSerialNumber(strSerial1);
	 * Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "SerialNumber" +
	 * iReceive, strSerial1); } ReceiveLPNLevel.verifyErrorNotDisplayed(); }
	 * 
	 * @And("Complete AT BlindReceiving") public void complete_at_blind_receiving()
	 * { ReceiveLPNLevel.searchASN(null); ReceiveLPNLevel.enterLPN(null, 1);
	 * ReceiveLPNLevel.enterScanItem(getDataFromFeature("getdata(ItemID_Line1)"));
	 * ReceiveLPNLevel.enterBatchnumber(getDataFromFeature("getdata(BatchNo_Line1)")
	 * ); ReceiveLPNLevel.enterQuantity(Integer.parseInt(getDataFromFeature(
	 * "getdata(OrdQty_Line1)"))); }
	 * 
	 * @And("Verify Inventry updated") public void verify_inventry_updated() {
	 * SeleniumActions.switchToWindowUsingIndex(0);
	 * HomePage.navigate_to_StorageLocation();
	 * StorageLocation.saveCurrentQuantity("CurrentQtyUpdated"); if
	 * (Integer.parseInt(Variables.get(CurrentThreadInstance.getCurrentScenarioId()
	 * + "CurrentQtyBeforeUpdate") .toString()) < Integer.parseInt(
	 * Variables.get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "CurrentQtyUpdated").toString())) { FrameworkLogger.log(LogType.PASS,
	 * "Current Quantity value is updated"); SeleniumActions.switchToLastWindow();
	 * SeleniumActions.closeBrowser(); SeleniumActions.switchToLastWindow(); } else
	 * { FrameworkLogger.log(LogType.FAIL, "Current Quantity is not updated"); } }
	 * 
	 * @And("Validate popup message {string}") public void
	 * validate_popup_message(String strMsg) {
	 * PopupWrapper.validatePopupMessage(strMsg); }
	 * 
	 * @And("Verify Blind receiving") public void verify_blind_receiving() {
	 * PopupWrapper.BlindPopupMessage(); }
	 * 
	 * @And("Verify variance and Accept") public void verify_variance_and_accept() {
	 * PopupWrapper.validateVarianceMessage("Variance exists for ASN " +
	 * Variables.get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "ASN").toString() + "."); }
	 * 
	 * @And("Positive Quantity Adjustment") public void
	 * positive_quantity_adjustment() { ModifyiLPN.verifyPageDisplayed(); String
	 * strLPN = Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "LPN" +
	 * 1).toString(); ModifyiLPN.searchLPN(strLPN);
	 * ModifyiLPN.readCurrentQuantity(); int iQuantityValue = Integer
	 * .parseInt(Variables.get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "CurrentQty").toString()) +
	 * Integer.parseInt(getDataFromFeature("getdata(PositiveQtyIncrement)"));
	 * Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "AdjustedValue",
	 * iQuantityValue); ModifyiLPN.updateQuantity(iQuantityValue);
	 * ModifyiLPN.updateCodesQuantity(); SeleniumActions.closeBrowser();
	 * SeleniumActions.switchToLastWindow(); }
	 * 
	 * @And("Negative Quantity Adjustment") public void
	 * negative_quantity_adjustment() { ModifyiLPN.verifyPageDisplayed(); String
	 * strLPN = Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "LPN" +
	 * 1).toString(); ModifyiLPN.searchLPN(strLPN);
	 * ModifyiLPN.readCurrentQuantity(); int iCurrentQuantity = Integer
	 * .parseInt(Variables.get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "CurrentQty").toString()); if (iCurrentQuantity >
	 * Integer.parseInt(getDataFromFeature("getdata(NegativeQtyDecrement)"))) { int
	 * iQuantityValue = iCurrentQuantity -
	 * Integer.parseInt(getDataFromFeature("getdata(NegativeQtyDecrement)"));
	 * Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "AdjustedValue",
	 * iQuantityValue); ModifyiLPN.updateQuantity(iQuantityValue);
	 * ModifyiLPN.updateCodesQuantity(); } else { FrameworkLogger.log(LogType.FAIL,
	 * Integer.parseInt(getDataFromFeature("getdata(NegativeQtyDecrement)")) +
	 * "requested quantity cannot be updated"); } SeleniumActions.closeBrowser();
	 * SeleniumActions.switchToLastWindow();
	 * 
	 * }
	 * 
	 * @And("Validate Quantity Adjustment") public void
	 * validate_quantity_adjustment() {
	 * ILPNs.searchLPN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "LPN" + 1).toString()); ILPNs.navigateToLocationInventory();
	 * ILPNs.validateCurrentQuantity(); }
	 * 
	 * @And("Search Display location at Location Inventory") public void
	 * search_display_location_at_location_inventory() {
	 * LocationInventory.searchDisplayLocation(getDataFromFeature(
	 * "getdata(DisplayLocation)"), true);
	 * 
	 * }
	 * 
	 * @And("Search Display location With {string} in Location Inventory") public
	 * void searchDisplayLocationWithInLocationInventory(String location) {
	 * LocationInventory.searchDisplayLocation(getDataFromFeature(location), false);
	 * }
	 */

	@And("Expand Location Information section")

	public void expandLocationInformationSection() {
		StorageLocation.expandLocationInformation();
		CommonMethods.waitForPageLoading();
	}

	@And("Filter with Not Allocated")
	public void filterWithNotAllocated() {
		ILPNs.filterWithNotAllocated();
	}

	@Then("Verify Max Items in Location Information")
	public void verifyMaxItemsInLocationInformation() {
		StorageLocation.verifyMaxItems(getDataFromFeature("getdata(MaxItems)"));
		CommonMethods.waitForPageLoading();
		CommonPopupPage.clickCloseIcon();
	}

	@And("Filter ILPNS by {string}")
	public void filterILPNSByGetdataStrLPNItemID(String strText1) {
		CommonMethods.waitForPageLoading();
		ILPNs.filterLPNByItem(getDataFromFeature(strText1));
		CommonMethods.waitForPageLoading();

	}

	@And("Store ILPNS numbers in runtime variable")
	public void storeILPNSNumbersInRuntimeVariable() {
		ILPNs.captureILPNSNumbers();
	}

	@And("Store ILPNS new numbers in runtime variable")
	public void storeILPNSNewNumbersInRuntimeVariable() {
		ILPNs.captureNewILPNSNumbers();
	}

	@And("Select Storeage Location on Location Inventory")
	public void select_storeage_location_on_location_inventory() {
		SeleniumActions.click(By.xpath("//span[@title='"
				+ Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "SelectedLocation").toString()
				+ "' and @data-component-id='DisplayLocation']"), "Location Inventory Card");
	}

	@And("Positive Quantity Adjustment at Pick Location")
	public void positive_quantity_adjustment_at_pick_location() {
		LocationInventory.selectAdjustInventory();
		AdjustPopup.addAdjustment(getDataFromFeature("getdata(AddQuantity)"),
				getDataFromFeature("getdata(ReasonCode)"));
	}

	@And("Negative Quantity Adjustment at Pick Location")
	public void negative_quantity_adjustment_at_pick_location() {
		LocationInventory.selectAdjustInventory();
		AdjustPopup.removeAdjustment(getDataFromFeature("getdata(RemoveQuantity)"),
				getDataFromFeature("getdata(ReasonCode)"));
	}

	@And("Navigate to Original Orders2")
	public void navigate_to_original_orders2() {
		HomePage.navigate_to_OriginalOrder2();
		OriginalOrdersPage.verifyOriginalOrders2PageDisplayed();
	}

	@And("Navigate to Orders")
	public void navigate_to_orders() {
		HomePage.navigate_to_Orders();
		OriginalOrdersPage.verifyOrdersPageDisplayed();
	}

	@And("Navigate to Wave Runs")
	public void navigate_to_wave_runs() {
		HomePage.navigate_to_waveRuns();
		WaveRunsPage.verifyWaveRunsPageDisplayed();
	}

	@And("Clear Notifications")
	public void clear_notifications() {
		HomePage.clickAlertNotificationIcon();
		NotificationPage.clearAllNotifications();
		HomePage.clickAlertNotificationIcon();
	}

	@And("Verify notification message {string}")
	public void verify_notification_message(String string) {
		GeneralUtils.wait(3 * 1000);
		NotificationPage.verifyNotificationMessage(string);
		GeneralUtils.wait(4 * 1000);
	}

	@And("Update Original Order")
	public void update_original_order() {
		ExcelUtil1.verifyFilePresent("OriginalOrder.xlsx");
		String strOrderValue = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(OriginalOrderID)"));
		ExcelUtil1.writeCellValueForColumn("OriginalOrder.xlsx", "OriginalOrder", "OriginalOrderId", strOrderValue);
		ExcelUtil1.writeCellValueForColumn("OriginalOrder.xlsx", "OriginalOrderLine", "OriginalOrder.OriginalOrderId",
				strOrderValue);
		ExcelUtil1.emptyCellValueForColumn("OriginalOrder.xlsx", "OriginalOrderLine", "BatchNumber");
	}

	@And("Import Data Loader {string}")
	public void import_data_loader(String strFileName) {
		CommonPage.selectFileToImport(strFileName);
	}

	@And("Verify Imported Orders")
	public void verify_imported_orders() {
		OriginalOrdersPage.filterOriginalOrder(
				Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder").toString());
	}

	@And("Validate Positive Quantity Adjustment")
	public void validate_positive_quantity_adjustment() {
		LocationInventory.searchDisplayLocation(
				Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "SelectedLocation").toString(), false);
		LocationInventory.getCurrentQuantity();
		int iCurrentQty = Integer
				.parseInt(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "CurrentQuantityBefore")
						.toString().replace(" UNIT", ""));
		int iCurrentQtyUpdated = Integer
				.parseInt(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "CurrentQuantityPresent")
						.toString().replace(" UNIT", ""));
		int iAdjustedValue = Integer.parseInt(getDataFromFeature("getdata(AddQuantity)"));
		if (iCurrentQtyUpdated == (iCurrentQty + iAdjustedValue)) {
			FrameworkLogger.log(LogType.PASS, "Current quantity is updated to " + Variables
					.get(CurrentThreadInstance.getCurrentScenarioId() + "CurrentQuantityPresent").toString());
		} else {
			FrameworkLogger.log(LogType.FAIL, "Current quantity is not updated,Before update value : " + iCurrentQty
					+ " After update value : " + iCurrentQtyUpdated);
		}
	}

	@And("Validate Negative Quantity Adjustment")
	public void validate_negative_quantity_adjustment() {
		LocationInventory.searchDisplayLocation(
				Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "SelectedLocation").toString(), false);
		LocationInventory.getCurrentQuantity();
		int iCurrentQty = Integer
				.parseInt(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "CurrentQuantityBefore")
						.toString().replace(" UNIT", ""));
		int iCurrentQtyUpdated = Integer
				.parseInt(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "CurrentQuantityPresent")
						.toString().replace(" UNIT", ""));
		int iAdjustedValue = Integer.parseInt(getDataFromFeature("getdata(RemoveQuantity)"));
		if (iCurrentQtyUpdated == (iCurrentQty - iAdjustedValue)) {
			FrameworkLogger.log(LogType.PASS, "Current quantity is updated to " + Variables
					.get(CurrentThreadInstance.getCurrentScenarioId() + "CurrentQuantityPresent").toString());
		} else {
			FrameworkLogger.log(LogType.FAIL, "Current quantity is not updated,Before update value : " + iCurrentQty
					+ " After update value : " + iCurrentQtyUpdated);
		}
	}

	@And("Select Order for RunWave")
	public void select_order_for_run_wave() {
		OrdersPage.selectOrder("Released");
		// OriginalOrdersPage.selectOrder("Released");
	}

	@And("Validate Orders status {string}")
	public void validate_orders_status(String strOrderStatus) {
		OrdersPage.verifyOrderStatus(strOrderStatus);
		// OriginalOrdersPage.verifyOrderStatus(strOrderStatus);
	}

	@And("Validate Orderslines status {string}")
	public void validate_orderslines_status(String strOrderStatus) {
		// OriginalOrdersPage.verifyOrderLinesStatus(strOrderStatus);
		OrdersPage.verifyOrderLinesStatus(strOrderStatus);
	}

	@And("Execute RunWave")
	public void execute_run_wave() {
		OrdersPage.executeRunWave();
		// OriginalOrdersPage.executeRunWave();
	}

	@And("Filter Original Orders2")
	public void filter_original_orders2() {
		OriginalOrdersPage.filterOriginalOrder(null);
	}

	@And("Validate Wave run status till {string}")
	public void validate_wave_run_status_till(String strStatus) throws InterruptedException {
		WaveRunsPage.waitAndVerifyWaveStatus(strStatus);
	}

	@And("Search Order at Orders")
	public void search_order_at_orders() {
		OrdersPage.searchOrdersRuns(
				Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder").toString());
	}

	@And("Get and Search ASN at ASNs {string}")
	public void getAndSearchASNAtASNsGetdataASN(String strText) {
		ASNs.searchASN(getDataFromFeature(strText));
	}

	@And("Verify ASN details are displayed via {string}")
	public void verifyASNDetailsAreDisplayedViaGetdataASN(String strText) {
		ASNs.verifyASNDetailsDisplayed(getDataFromFeature(strText));
	}

	@And("Download ASN file")
	public void downloadASNFile() {
		ExcelUtil1.deleteExistingFile("ASN.xlsx");
		NotificationPage.downloadASNfile();
		HomePage.openAlertNotification();
		ExcelUtil1.verifyFilePresent("ASN.xlsx");
	}

	@And("Import Data Loader for ASN")
	public void importDataLoaderForASN() {
		ASNs.selectFiletoImport();
	}

	@And("Select Order for PickPack")
	public void selectOrderForPickPack() {
		OriginalOrdersPage.selectOrderforpickpack();
	}

	@And("Verify task status and Set the oLPN number")
	public void verifyTaskStatusAndSetTheOLPNNumber() {
		OrdersPage.copyoLPN();
	}

	@And("Pick Pack oLPN User directed")
	public void pickPackOLPNUserDirected() {
		String strolpn = Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "taskoLPN").toString();
		UserDirected.pickpackoLPN(strolpn);
	}

	@And("Search Current Location With {string} in iLPNs Page")
	public void searchCurrentLocationWithInILPNsPage(String text) {
		ILPNs.searchCurrentLocation(getDataFromFeature(text));
	}

	@And("Move iLPN from Storage location to Damage location")
	public void moveILPNFromStorageLocationToDamageLocation() {
		String iLPN = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ILPNIdAtFirstIndex");
		String quantity = (String) Variables
				.get(CurrentThreadInstance.getCurrentScenarioId() + "ILPNQuantityAtFirstIndex");
		String damageLocation = getDataFromFeature("getdata(DamageLocation)");

		UserDirected.searchLPN(iLPN);
		UserDirected.enterQuantity(quantity);
		UserDirected.enterScanLocation(damageLocation);
		// SeleniumActions.switchToLastWindow();
		// SeleniumActions.closeBrowser();
		// SeleniumActions.switchToLastWindow();
	}

	@And("Move iLPN from Damage location to Storage location")
	public void moveILPNFromDamageLocationToStorageLocation() {
		String iLPN = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ILPNIdAtFirstIndex");
		String quantity = (String) Variables
				.get(CurrentThreadInstance.getCurrentScenarioId() + "ILPNQuantityAtFirstIndex");
		String storageLocation = (String) Variables
				.get(CurrentThreadInstance.getCurrentScenarioId() + "ILPNCurrentLocationAtFirstIndex");

		UserDirected.searchLPN(iLPN);
		UserDirected.enterQuantity(quantity);
		UserDirected.enterScanLocation(storageLocation);
		// TasksPage.clickConfirmInPopupIfDisplayed(); Commented by lohith on 28 Oct
		// 2023 504 Gateway Time-out This Step not Required
		// SeleniumActions.switchToLastWindow(); This steps are been moved to feature
		// file
		// SeleniumActions.closeBrowser();
		// SeleniumActions.switchToLastWindow();
	}

	@Then("Verify iLPN moved to Damage location")
	public void verifyILPNMovedToDamageLocation() {
		CommonMethods.waitForPageLoading();
		String iLPN = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ILPNIdAtFirstIndex");
		String quantity = (String) Variables
				.get(CurrentThreadInstance.getCurrentScenarioId() + "ILPNQuantityAtFirstIndex");
		String storageLocation = (String) Variables
				.get(CurrentThreadInstance.getCurrentScenarioId() + "ILPNCurrentLocationAtFirstIndex");
		String damageLocation = getDataFromFeature("getdata(DamageLocation)");
		SeleniumActions.switchToWindowUsingIndex(0);
		LocationInventory.clickClearAllButton();
		ILPNs.searchLPNID(iLPN);
		ILPNs.verifyILPNAtFirstIndex(iLPN);
		ILPNs.verifyILPNQuantityAtFirstIndex(quantity);
		ILPNs.verifyILPNCurrentLocationAtFirstIndex(damageLocation);
		ILPNs.verifyILPNPreviousLocationAtFirstIndex(storageLocation);
	}

	@Then("Verify iLPN moved to Storage location")
	public void verifyILPNMovedToStorageLocation() {
		String iLPN = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ILPNIdAtFirstIndex");
		String quantity = (String) Variables
				.get(CurrentThreadInstance.getCurrentScenarioId() + "ILPNQuantityAtFirstIndex");
		String storageLocation = (String) Variables
				.get(CurrentThreadInstance.getCurrentScenarioId() + "ILPNCurrentLocationAtFirstIndex");
		String damageLocation = getDataFromFeature("getdata(DamageLocation)");
		SeleniumActions.switchToWindowUsingIndex(0);
		LocationInventory.clickClearAllButton();
		ILPNs.searchLPNID(iLPN);
		ILPNs.verifyILPNAtFirstIndex(iLPN);
		ILPNs.verifyILPNQuantityAtFirstIndex(quantity);
		ILPNs.verifyILPNCurrentLocationAtFirstIndex(storageLocation);
		ILPNs.verifyILPNPreviousLocationAtFirstIndex(damageLocation);
	}

	@And("Store iLPN Details to run time Variables")
	public void storeILPNDetailsToRunTimeVariables() {
		ILPNs.storeILPNIdAtFirstIndexToString();
		ILPNs.storeILPNQuantityAtFirstIndexToString();
		ILPNs.storeILPNCurrentLocationAtFirstIndexToString();
	}

	@And("Store iLPN ID to runtime variable as String")
	public static void storeILPNIdToString() {
		ILPNs.storeILPNIdAtFirstIndexToString();
	}

	@And("Store iLPN Quantity to runtime variable as String")
	public static void storeILPNQuantityToString() {
		ILPNs.storeILPNQuantityAtFirstIndexToString();
	}

	@And("Store iLPN Current Location to runtime variable as String")
	public static void storeILPNCurrentLocationToString() {
		ILPNs.storeILPNCurrentLocationAtFirstIndexToString();
	}

	@And("Select the location and select cycle count from the three dot bottom menu")
	public void selectTheLocationAndSelectCycleCountFromTheThreeDotBottomMenu() {
		LocationInventory.selectLocationAndSelectCycleCountFromBottomMenu();
	}

	@And("Update Business Unit in Pop-up {string}")
	public void updateBusinessUnitInPopUpGetdataBUID(String strText) {
		HomePage.updateBusinessUnitInPopup(getDataFromFeature(strText));
	}

	@And("Advance ASN Filter by ASN Level & Status")
	public void filter_asn_by_status() {
		ASNs.filterASNByLevel(getDataFromFeature("getdata(ASNLevel)"));
		ASNs.filterASNByStatus(getDataFromFeature("getdata(ASNStatus)"));
	}

	@And("Download ASN Order")
	public void download_asn_order() {
		ExcelUtil1.deleteExistingFile("ASN.xlsx");
		NotificationPage.downloadAsnOrder();
		HomePage.openAlertNotification();
		ExcelUtil1.verifyFilePresent("ASN.xlsx");
	}

	@And("Update ASN Order")
	public void update_asn_order() {
		ExcelUtil1.verifyFilePresent("ASN.xlsx");
		String strAsnValue = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(AsnId)"));
		ExcelUtil1.writeCellValueForColumn("ASN.xlsx", "Asn", "AsnId", strAsnValue);
		ExcelUtil1.writeCellValueForColumn("ASN.xlsx", "AsnLine", "AsnId", strAsnValue);
	}

	@And("Update ASN without PO and valid Item {string}")
	public void update_asn_without_po_and_valid_item(String strFileName) {
		ExcelUtil1.writeCellValueForColumn1(strFileName, "AsnLine", "PurchaseOrderLineId", "");
		ExcelUtil1.writeCellValueForColumn1(strFileName, "AsnLine", "PurchaseOrderId", "");
		ExcelUtil1.writeCellValueForColumn1(strFileName, "AsnLine", "ItemId",
				getDataFromFeature("getdata(ItemID_Line1)"));
		// ExcelUtil1.writeCellValueForColumn1(strFileName, "AsnLine",
		// "BusinessUnitId",getDataFromFeature("getdata(BUID)"));
		// ExcelUtil1.writeCellValueForColumn1(strFileName, "AsnLine",
		// "FacilityId",ConfigurationUtils.getFrameworkConfig("facility"));
		// ExcelUtil1.writeCellValueForColumn1(strFileName, "Asn", "BusinessUnitId",
		// getDataFromFeature("getdata(BUID)"));
		// ExcelUtil1.writeCellValueForColumn1(strFileName, "Asn",
		// "FacilityId",ConfigurationUtils.getFrameworkConfig("facility"));
		String strAsnValue = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(AsnId)"));
		ExcelUtil1.writeCellValueForColumn(strFileName, "Asn", "AsnId", strAsnValue);
		ExcelUtil1.writeCellValueForColumn(strFileName, "AsnLine", "AsnId", strAsnValue);
	}

	@And("Import ASN Data Loader")
	public void import_asn_data_loader() {
		ASNs.selectFiletoImport();
	}

	@And("Verify Imported ASN Orders")
	public void verify_imported_asn_orders() {
		ASNs.filterAsnOrder(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN").toString());
	}

	@And("Complete ATStandardReceiving with Invalid Item and Verify error message")
	public void complete_at_standard_receiving_with_invalid_item() {
		ReceiveLPNLevel.searchASN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN").toString());
		ReceiveLPNLevel.enterLPN(null, 1);
		ReceiveLPNLevel.enterScanItem(getDataFromFeature("getdata(InvalidItemID_Line1)"));
		PopupWrapper.validateInvalidItemPopupMessage();
	}

	@And("Validate Invalid Item Error")
	public void verify_invalid_item_error() {
		PopupWrapper.validateInvalidItemPopupMessage();
	}

	@And("Navigate to Tasks")
	public void navigateToTasks() {
		HomePage.navigateToTasks();
		TasksPage.verifyTasksPageDisplayed();
		LocationInventory.clickClearAllButton();
	}

	@Then("Verify task created with status ReadyForAssignment for the selected location")
	public void verifyTaskCreatedWithStatusReadyForAssignmentForTheSelectedLocation() {
		CommonMethods.waitForPageLoading();
		TasksPage.verifyReadyForAssignmentButtonAtFirstIndex();
		TasksPage.verifyTransactionTypeAtFirstIndex();
		String location = (String) Variables
				.get(CurrentThreadInstance.getCurrentScenarioId() + "WithoutCycleCountLocationAtFirstIndex");
		TasksPage.verifySourceLocationAtFirstIndex(location);
		TasksPage.storeTaskId();
	}

	@And("Click Submit in confirmation screen with cycle count {string}")
	public void clickSubmitInConfirmationScreenWithCycleCount(String count) {
		HomePage.clickSubmitOnCycleCountConfirmationScreen(getDataFromFeature(count));
	}

	@And("Enter the tasks details in cycle count screen and complete the process")
	public void enterTheTasksDetailsInCycleCountScreenAndCompleteTheProcess() {
		String taskId = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "TaskIdAtFirstIndex");
		String location = (String) Variables
				.get(CurrentThreadInstance.getCurrentScenarioId() + "WithoutCycleCountLocationAtFirstIndex");
		String ilpn = (String) Variables
				.get(CurrentThreadInstance.getCurrentScenarioId() + "WithoutCycleCountILPINIdAtFirstIndex");
		String item = (String) Variables
				.get(CurrentThreadInstance.getCurrentScenarioId() + "WithoutCycleCountItemNameAtFirstIndex");
		String batchNumber = (String) Variables
				.get(CurrentThreadInstance.getCurrentScenarioId() + "BatchNumberInPopup");
		String quantity = (String) Variables
				.get(CurrentThreadInstance.getCurrentScenarioId() + "WithoutCycleCountILPINQuantityAtFirstIndex");
		TasksPage.enterTask(taskId);
		TasksPage.clickGoButton();
		TasksPage.enterScanLocation(location);
		TasksPage.clickGoButton();
		TasksPage.enterILPN(ilpn);
		TasksPage.clickGoButton();
		TasksPage.enterScanItem(item);
		TasksPage.clickGoButton();
		// TasksPage.enterBatchNumberIfDisplayed(batchNumber);
		TasksPage.enterQuantity(quantity);
		TasksPage.clickGoButton();
		TasksPage.clickEndILPNButton();
		TasksPage.clickEndCountButton();
		TasksPage.clickConfirmInPopupIfDisplayed();
	}

	@And("Click on ClearAll button")
	public void clickOnClearAllButton() {
		LeftPanelPage.clickClearAll();
	}

	@And("Complete item and quantity")
	public void completeItemAndQuantity() {
		WMMobile.completeItemandQty();
	}

	@And("Verify prompts olpn is packed and click ok")
	public void verifyPromptsOlpnIsPackedAndClickOk() {
		WMMobile.pickpackprompt();
	}

	@Then("Verify Order status to packed")
	public void verifyOrderStatusToPacked() {
		OriginalOrdersPage.selectOrderforpickpack();
		OriginalOrdersPage.verifyOrderStatus("Packed");
	}

	@And("Search ASNStatus at ASNs from Variables")
	public void searchASNStatusAtASNsFromVariables() {
		ASNs.searchASN((String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "strAsnId"));
		ASNs.verifyASNDetailsDisplayed(
				(String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "strAsnId"));
		ASNs.verifyASNStatus("In Transit");
	}

	@And("Verify import notification message {string}")
	public void verify_notification_import(String string) {
		GeneralUtils.wait(1 * 1000);
		HomePage.refreshAlertNotification();
		HomePage.refreshAlertNotification();
		NotificationPage.verifyNotificationMessage(string);
	}

	@And("Select First Order in Screen")
	public void select_first_order_in_screen() {
		OrdersPage.SelectAllocatedOrder();
	}

	@And("Select First Packed Order in Screen")
	public void select_first_packed_order_in_screen() {
		OrdersPage.SelectPackedOrder();
		;
	}

	@Then("Validate error has one cubiscan product")
	public void validateErrorHasOneCubiscanProduct() {
		ReceiveLPNLevel.ValidateCubiscanAlert();
	}

	@And("Complete ATStandardReceiving with tolerance")
	public void completeATStandardReceivingWithTolerance() {
		ReceiveLPNLevel.searchASN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN").toString());
		ReceiveLPNLevel.enterLPN(ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(LPNId)")));
		ReceiveLPNLevel.enterScanItem(getDataFromFeature("getdata(ItemID_Line1)"));
		ReceiveLPNLevel.searchInventory(getDataFromFeature(getData("inventory_Line1")));
		ReceiveLPNLevel.searchProductStatus(getDataFromFeature(getData("ProductStatus_Line1")));
		ReceiveLPNLevel.searchCOOrigin(getDataFromFeature(getData("CoOrigin_Line1")));
		ReceiveLPNLevel.validateQtyError(getDataFromFeature(getData("OrdQty_Line1")), "No Error");
		ReceiveLPNLevel.enterLPN(ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(LPNId)")));
		ReceiveLPNLevel.enterScanItem(getDataFromFeature("getdata(ItemID_Line2)"));
		ReceiveLPNLevel.searchInventory(getDataFromFeature(getData("inventory_Line2")));
		ReceiveLPNLevel.searchProductStatus(getDataFromFeature(getData("ProductStatus_Line2")));
		ReceiveLPNLevel.searchCOOrigin(getDataFromFeature(getData("CoOrigin_Line2")));
		ReceiveLPNLevel.validateQtyError(getDataFromFeature(getData("OrdQty_Line2")), "RCV::177");
		ReceiveLPNLevel.enterLPN(ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(LPNId)")));
		ReceiveLPNLevel.enterScanItem(getDataFromFeature("getdata(ItemID_Line3)"));
		ReceiveLPNLevel.searchInventory(getDataFromFeature(getData("inventory_Line3")));
		ReceiveLPNLevel.searchProductStatus(getDataFromFeature(getData("ProductStatus_Line3")));
		ReceiveLPNLevel.searchCOOrigin(getDataFromFeature(getData("CoOrigin_Line3")));
		ReceiveLPNLevel.validateQtyError(getDataFromFeature(getData("OrdQty_Line4")), "RCV::175");
	}

	@And("Validate Variance Warning Code")
	public void validateVarianceWarningCode() {
		PopupWrapper.validateVarianceWarningCode("RCV::237");
	}

	@And("Validate item variances and lpn in ASN screen")
	public void validateItemVariancesAndLpnInASNScreen() {
		PopupWrapper.validateitemandlpnVariance();

	}

	@And("Complete ATStandardReceiving entering batch number")
	public void completeATStandardReceivingEnteringBatchNumber() {
		ReceiveLPNLevel.completeAtStandardReceivingWithBatch();
	}

	@And("Validate batchNumber and ExpiryDate in LocationInventory")
	public void validateBatchNumberAndExpiryDateInLocationInventory() {
		ILPNs.searchinventory();
		ILPNs.validateBatchNumandASNExpiryDate(getDataFromFeature("getdata(BatchNo_Line1)"), "null");
	}

	@And("Validate batchNumber and ExpiryDate is displayed in LocationInventory")
	public void validateBatchNumberAndExpiryDateIsDisplayedInLocationInventory() {
		ILPNs.searchinventory();
		ILPNs.validateBatchNumandASNExpiryDate(getDataFromFeature("getdata(BatchNo_Line1)"),
				getDataFromFeature(getData("ExpiryDate_Line1")));
	}

	@And("Navigate to Batch Master")
	public void navigateToBatchMaster() {
		HomePage.navigateToBatchMaster();
		BatchMasterPage.verifyBatchMasterPageDisplayed();
	}

	@And("Store Batch Details to run time Variables")
	public void storeBatchDetailsToRunTimeVariables() {
		BatchMasterPage.storeBatchDetails();
		HomePage.navigateToInventoryDetails();
		InventoryDetailsPage.findBatchNumberWhoIsHavingValidItem();
	}

	@And("Verify Held condition code has a value for the selected Batch Number")
	public void verifyHeldConditionCodeHasAValueForTheSelectedBatchNumber() {
		BatchMasterPage.verifyHeldConditionCodeHasAValueForTheSelectedBatchNumber();
	}

	@And("Click on Hold for the selected Batch Number")
	public void clickOnHoldForTheSelectedBatchNumber() {
		BatchMasterPage.clickMoreButtonAtRightSideForBatchNumber();
		BatchMasterPage.clickHoldButtonAtRightSideForBatchNumber();
		BatchMasterPage.clickYesButtonInHoldPopup();
	}

	@And("Click on Release for the selected Batch Number")
	public void clickOnReleaseForTheSelectedBatchNumber() {
		LocationInventory.clickClearAllButton();
		String batchNumber = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "BatchNumber");
		BatchMasterPage.searchBatchNumber(batchNumber);
		BatchMasterPage.clickCloseButtonAtRightSideForBatchNumber();
		BatchMasterPage.clickMoreButtonAtRightSideForBatchNumber();
		BatchMasterPage.clickReleaseButtonAtRightSideForBatchNumber();
		BatchMasterPage.clickYesButtonInHoldPopup();
	}

	@And("Click on Recall for the selected Batch Number")
	public void clickOnRecallForTheSelectedBatchNumber() {
		BatchMasterPage.clickRecallButtonAtRightSideForBatchNumber();
		BatchMasterPage.clickYesButtonInHoldPopup();
	}

	@Then("Verify that filtered results displayed with Held status also")
	public void verifyThatFilteredResultsDisplayedWithHeldStatusAlso() {
		BatchMasterPage.verifyAllBatchNumbersAreDisplayed();
	}

	@And("Navigate to Inventory Details")
	public void navigateToInventoryDetails() {
		HomePage.navigateToInventoryDetails();
		InventoryDetailsPage.verifyInventoryDetailsPageDisplayed();
	}

	@And("Filter by Batch Number details")
	public void filterByBatchNumberDetails() {
		InventoryDetailsPage.filterByBatchNumberDetails();
	}

	@Then("Verify that all the entries in inventory is locked with the correct Held condition code")
	public void verifyThatAllTheEntriesInInventoryIsLockedWithTheCorrectHeldConditionCode() {
		InventoryDetailsPage.verifyThatAllTheEntriesInInventoryIsLockedWithTheCorrectHeldConditionCode();
	}

	@Then("Verify that all the entries in inventory has no condition code")
	public void verifyThatAllTheEntriesInInventoryHasNoConditionCode() {
		InventoryDetailsPage.verifyThatAllTheEntriesInInventoryHasNoConditionCode();
	}

	@And("Deselect byStatusReleasedCheckbox on BatchMasterPage")
	public void deselectByStatusReleasedCheckboxOnBatchMasterPage() {
		BatchMasterPage.unSelectStatusReleasedCheckbox();
	}

	@And("Search itemfeild in BatchMaster")
	public void searchItemfeildInBatchMaster() {
		ASNs.searchitem(getDataFromFeature(getData("ItemID_Line1")));
	}

	@And("Deselect byStatusHeldCheckbox on BatchMasterPage")
	public void deselectByStatusHeldCheckboxOnBatchMasterPage() {
		BatchMasterPage.unSelectStatusHeldCheckbox();
	}

	@Then("Verify the task has been completed")
	public void verifyTheTaskHasBeenCompleted() {
		TasksPage.verifyTheTaskHasBeenCompleted();
	}

	@And("Navigate to Inventory Count")
	public void navigateToInventoryCount() {
		// SeleniumActions.switchToWindowUsingIndex(0);
		HomePage.navigateToInventoryCount();
	}

	@And("Verify Item with batchnum and Expirationdate in BatchMaster")
	public void verifyItemWithBatchnumAndExpirationdateInBatchMaster() {
	}

//Duplicate declaration
	/*
	 * @And("Update ASN export file for cubisian") public void
	 * updateASNExportFileForCubisian() {
	 * ExcelUtil1.verifyFilePresentfromuserdir(CurrentThreadInstance.
	 * getCurrentScenarioName()+".xlsx"); String AsnIdValue =
	 * ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(ASN)"));
	 * Variables.set(CurrentThreadInstance.getCurrentScenarioId()+"ASN",AsnIdValue
	 * ); String strAsnIdValue = (String)
	 * Variables.get(CurrentThreadInstance.getCurrentScenarioId()+"ASN");
	 * ExcelUtil1.writeCellValueForColumnwoAppend(System.getProperty("user.dir") +
	 * "\\TestData\\Web_excelfiles\\", CurrentThreadInstance.getCurrentScenarioName()+"
	 * .xlsx","Asn","AsnId",strAsnIdValue);
	 * ExcelUtil1.writeCellValueForColumnwoAppend(System.getProperty("user.dir") +
	 * "\\TestData\\Web_excelfiles\\", CurrentThreadInstance.getCurrentScenarioName()+"
	 * .xlsx", "Asn", "AsnStatus","1000");
	 * ExcelUtil1.writeCellValueForColumnwoAppend(System.getProperty("user.dir") +
	 * "\\TestData\\Web_excelfiles\\", CurrentThreadInstance.getCurrentScenarioName()+"
	 * .xlsx", "AsnLine", "AsnId",strAsnIdValue);
	 * ExcelUtil1.deleteRowsfromSheet(System.getProperty("user.dir") +
	 * "\\TestData\\Web_excelfiles\\", CurrentThreadInstance.getCurrentScenarioName()+"
	 * .xlsx", "Lpn"); ExcelUtil1.deleteRowsfromSheet(System.getProperty("user.dir")
	 * +
	 * "\\TestData\\Web_excelfiles\\", CurrentThreadInstance.getCurrentScenarioName()+"
	 * .xlsx", "LpnDetail"); }
	 */

	// Duplicate declaration
	/*
	 * @And("Import Data Loader for ASN in testdata") public void
	 * importDataLoaderForASNInTestdata() {
	 * ASNs.selectFiletoImportfromtestdatadir(); }
	 */

	@And("Update ASN export file with batch number")
	public void updateASNExportFileWithBatchNumber() {
		ExcelUtil1.verifyFilePresentfromuserdir(CurrentThreadInstance.getCurrentScenarioName() + ".xlsx");
		String AsnIdValue = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(ASN)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ASN", AsnIdValue);
		String strAsnIdValue = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN");
		ExcelUtil1.writeCellValueForColumnwoAppend(CurrentThreadInstance.getCurrentScenarioName() + ".xlsx", "Asn",
				"AsnId", strAsnIdValue);
		ExcelUtil1.writeCellValueForColumnwoAppend(CurrentThreadInstance.getCurrentScenarioName() + ".xlsx", "Asn",
				"AsnStatus", "1000");
		ExcelUtil1.writeCellValueForColumnboolean(CurrentThreadInstance.getCurrentScenarioName() + ".xlsx", "Asn",
				"VerificationAttempted", "FALSE");
		ExcelUtil1.writeCellValueForColumnwoAppend(CurrentThreadInstance.getCurrentScenarioName() + ".xlsx", "Asn",
				"ReceivedLpns", "0.000");
		ExcelUtil1.writeCellValueForColumnwoAppend(CurrentThreadInstance.getCurrentScenarioName() + ".xlsx", "AsnLine",
				"AsnId", strAsnIdValue);
		ExcelUtil1.writeCellValueForColumnwoAppend(CurrentThreadInstance.getCurrentScenarioName() + ".xlsx", "AsnLine",
				"BatchNumber", getDataFromFeature(getData("BatchNo_Line1")));
		ExcelUtil1.deleteRowsfromSheet(CurrentThreadInstance.getCurrentScenarioName() + ".xlsx", "Lpn");
		ExcelUtil1.deleteRowsfromSheet(CurrentThreadInstance.getCurrentScenarioName() + ".xlsx", "LpnDetail");

	}

	@Then("Verify the Count status as booked")
	public void verifyTheCountStatusAsBooked() {
		InventoryCountPage.verifyCountStatusAsBooked();
	}

	@And("Verify the count details in Inventory Count details page")
	public void verifyTheCountDetailsInInventoryCountDetailsPage() {
		InventoryCountPage.clickCountRunId();
		InventoryCountDetailsPage.verifyTheCountDetailsInInventoryCountDetailsPage();
	}

	@Then("Verify that filtered results displayed with {string} status also")
	public void verifyThatFilteredResultsDisplayedWithStatusAlso(String status) {
		BatchMasterPage.verifyAllBatchNumbersAreDisplayed();
	}

	@Then("Verify that selected Batch Number is removed from the {string} status list")
	public void verifyThatSelectedBatchNumberIsRemovedFromTheStatusList(String status) {
		BatchMasterPage.verifyThatSelectedBatchNumberIsRemovedInTheFilteredResults(status);
	}

	@Then("Verify that all the entries in inventory is locked with the correct condition codes")
	public void verifyThatAllTheEntriesInInventoryIsLockedWithTheCorrectConditionCodes() {
		InventoryDetailsPage.verifyThatAllTheEntriesInInventoryIsLockedWithTheCorrectConditionCodes();
	}

	@And("Complete ATStandardReceiving for multiple product status")
	public void complete_at_standard_receiving_with_ItemId_And_product_status1() {
		ReceiveLPNLevel.searchASN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN").toString());
		String strProductStatusCount = getDataFromFeature("getdata(ProductStatusCount)");
		for (int i = 1; i <= Integer.parseInt(strProductStatusCount); i++) {
			ReceiveLPNLevel.enterLPN(null, 1);
			ReceiveLPNLevel.enterScanItem(getDataFromFeature("getdata(ItemID_Line" + i + ")"));
			ReceiveLPNLevel.enterInventoryItemId(null);
			ReceiveLPNLevel.enterProductStatus(getDataFromFeature("getdata(ProductStatusId_Line" + i + ")"));
			ReceiveLPNLevel.enterQuantity(Integer.valueOf(getDataFromFeature("getdata(OrdQty_Line" + i + ")")));
		}
	}

	@And("Validate Product Status of each LPN")
	public void validate_product_status_of_each_LPN() {
		List<String> listOFiLPNs = (List<String>) Variables
				.get(CurrentThreadInstance.getCurrentScenarioId() + "listOFiLPNs");
		int i = 1;
		for (String iLpn : listOFiLPNs) {
			ILPNs.openSlideOption(iLpn);
			ILPNs.clickDetails();
			ILPNs.expandInventoryDetails();
			ILPNs.verifyProductStatus(getDataFromFeature("getdata(ProductStatusId_Line" + i + ")"));
			FrameworkLogger.log(LogType.PASS, "Product status of LPN " + iLpn + " is "
					+ getDataFromFeature("getdata(ProductStatusId_Line" + i + ")"));
			ILPNs.closeILPN();
			ILPNs.closeSlideOption();
			i++;
		}
	}

	@And("Complete AT Pick To oLPN")
	public void complete_at_pick_to_o_lpn() {
		String strolpn = Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "taskoLPN").toString();
		UserDirected.pickpackoLPN(strolpn);
		WMMobile.completeItemandQty();
		SeleniumActions.switchToLastWindow();
		SeleniumActions.closeBrowser();
		SeleniumActions.switchToLastWindow();
	}

	@And("Store oLPN number in runtime variable")
	public void store_o_lpn_number_in_runtime_variable() {
		OrdersPage.copyoLPN();
	}

	@And("Validate Task Details status {string}")
	public void validate_task_details_status(String strStatus) {
		TasksPage.verifyTaskDetailsStatus(strStatus);
	}

	@And("Complete Ship Confirm")
	public void complete_ship_confirm() {
		OrdersPage.verifyReceivingASN();
	}

	@And("Update ASN export file for cubisian")
	public void updateASNExportFileForCubisian() {
		ExcelUtil1.verifyFilePresentfromuserdir(CurrentThreadInstance.getCurrentScenarioName() + ".xlsx");
		String AsnIdValue = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(ASN)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ASN", AsnIdValue);
		String strAsnIdValue = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN");
		ExcelUtil1.writeCellValueForColumnwoAppend(CurrentThreadInstance.getCurrentScenarioName() + ".xlsx", "Asn",
				"AsnId", strAsnIdValue);
		ExcelUtil1.writeCellValueForColumnwoAppend(CurrentThreadInstance.getCurrentScenarioName() + ".xlsx", "Asn",
				"AsnStatus", "1000");
		ExcelUtil1.writeCellValueForColumnwoAppend(CurrentThreadInstance.getCurrentScenarioName() + ".xlsx", "AsnLine",
				"AsnId", strAsnIdValue);
		ExcelUtil1.deleteRowsfromSheet(CurrentThreadInstance.getCurrentScenarioName() + ".xlsx", "Lpn");
		ExcelUtil1.deleteRowsfromSheet(CurrentThreadInstance.getCurrentScenarioName() + ".xlsx", "LpnDetail");

	}

	@And("Complete ATStandardReceiving after error displayed")
	public void completeATStandardReceivingAfterErrorDisplayed() {
		ReceiveLPNLevel.searchASN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN").toString());
		ReceiveLPNLevel.enterLPN(ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(LPNId)")));
		ReceiveLPNLevel.enterScanItem(getDataFromFeature("getdata(ItemID_Line3)"));
		ReceiveLPNLevel.searchInventory(getDataFromFeature(getData("inventory_Line3")));
		ReceiveLPNLevel.searchProductStatus(getDataFromFeature(getData("ProductStatus_Line3")));
		ReceiveLPNLevel.searchCOOrigin(getDataFromFeature(getData("CoOrigin_Line3")));
		ReceiveLPNLevel.validateQtyError(getDataFromFeature(getData("OrdQty_Line3")), "RCV::143");
	}

	@And("Update Business Unit {string} in WM Mobile")
	public void updateBusinessUnitGetdataBUIDInWMMobile(String strText) {
		HomePage.updateBusinessUnitInWMMobile(getDataFromFeature(strText));
	}

	@And("Navigate to Inventory Management")
	public void navigateToInventoryManagement() {
		HomePage.navigateToInventoryManagement();
	}

	@And("Create iLPN")
	public void createILPN() {
		CreateILPN.createILPN();
	}

	@Then("Verify iLPN Inventory Details")
	public void verifyILPNInventoryDetails() {
		ILPNs.verifyILPNDetails();
		CommonMethods.waitForPageLoading();
	}

	@And("Navigate to PutAway Planning Strategy Page")
	public void navigateToPutAwayPlanningStrategyPage() {
		HomePage.navigateToPutAwayPlanningStrategyPage();
		PutAwayPlanningStrategyPage.verifyPutAwayPlanningStrategyPage();
	}

	@And("Click on View button for FNPutAwayPlanningStrategy Item")
	public void clickOnViewButtonForFNPutAwayPlanningStrategyItem() {
		PutAwayPlanningStrategyPage.clickCloseIconForFNPutAwayPlanningStrategy();
		PutAwayPlanningStrategyPage.clickViewButton();
	}

	@And("Click on Continue button")
	public void clickOnContinueButton() {
		PutAwayPlanningStrategyPage.clickContinueButton();
	}

	@And("Filter by Batch Number and Item ID")
	public void filterByBatchNumberAndItemID() {
		InventoryDetailsPage.searchBatchNumber(getDataFromFeature("getdata(BatchNo_Line1)"));
		InventoryDetailsPage.searchItemId(getDataFromFeature("getdata(ItemID_Line1)"));
	}

	@And("Verify Batch number is displayed in Released status")
	public void verifyBatchNumberInReleasedStatus() {
		BatchMasterPage.storeBatchNumberStatus();
	}

	@And("Verify notification export Batch Master {string}")
	public void verifyNotificationExportBatchMaster(String string) {
		GeneralUtils.wait(1 * 1000);
		HomePage.openAlertNotification();
		NotificationPage.verifyNotificationMessage(string);
	}

	@And("Download Batch Master file")
	public void downloadBatchMasterFile() {
		ExcelUtil1.deleteExistingFile("BatchMaster.xlsx");
		NotificationPage.downloadBatchMasterfile();
		HomePage.openAlertNotification();
		ExcelUtil1.verifyFilePresent("BatchMaster.xlsx");
	}

	@And("Update Batch Master export file")
	public void updateBatchMasterExportFile() {
		ExcelUtil1.verifyFilePresent("BatchMaster.xlsx");
		String BatchNumberId = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(BatchMasterID)"));
		String ItemId = getDataFromFeature("getdata(ItemID_Line1)");
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ItemId", ItemId);
		ExcelUtil1.writeCellValueForColumn("BatchMaster.xlsx", "BatchMaster", "BatchNumberId", BatchNumberId);
		ExcelUtil1.writeCellValueForColumn1("BatchMaster.xlsx", "BatchMaster", "Status",
				getDataFromFeature("getdata(BatchMasterStatus)"));
	}

	@And("Create new Batch number if it doesnot exists")
	public void createNewBatchNumber() {
		if (Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "isBatchNumberFound").toString() == "false") {
			FrameworkLogger.log(LogType.INFO, "Batch Number doesn't exists, Need to create new Batch Number");
			BatchMasterPage.clickExportDataLoader();
			verifyNotificationExportBatchMaster("File BatchMaster.xlsx from BatchMaster is exported successfully.");
			downloadBatchMasterFile();
			updateBatchMasterExportFile();
			navigateToBatchMaster();
			clear_notifications();
			close_alert_notification_window();
			BatchMasterPage.clickImportDataLoader();
			BatchMasterPage.selectFiletoImport();
			waitForPageLoading();
			verifyNotificationExportBatchMaster("File BatchMaster.xlsx from BatchMaster is imported successfully.");
			close_alert_notification_window();
			InventoryDetailsPage.filterByBatchNumberDetails();
		} else {
			FrameworkLogger.log(LogType.INFO, "Batch Number already exists");
		}
	}

	@And("Filter by Location Details")
	public void filterByLocationDetails() {
		// InventoryDetailsPage.minimizeFilterButton();
		InventoryDetailsPage.searchItemId(getDataFromFeature("getdata(ItemID_Line1)"));
		InventoryDetailsPage.enterDisplayLocation(getDataFromFeature("getdata(Display_Location)"));
		InventoryDetailsPage.filterInventoryContainerType(getDataFromFeature("getdata(InventoryContainerType)"));
		InventoryDetailsPage.searchBatchNumber(getDataFromFeature("getdata(BatchNo_Line1)"));
	}

	@And("Verify Inventory is Available for the Batch Number")
	public void verifyInventoryIsAvailable() {
		InventoryDetailsPage.storeInventoryDetails();
	}

	@And("Create new Inventory if it doesnot exists")
	public void createNewInventory() {
		if ((Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "isBatchNumberFound").toString() == "false")
				|| (Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "isInventoryPresent")
						.toString() == "false")) {
			FrameworkLogger.log(LogType.INFO, "Inventory is not present, Need to create new Inventory");
			HomePage.navigate_to_ASNs();
			ASNs.verifyASNsPageDisplayed();
			ASNs.searchASN(getDataFromFeature("getdata(ASN)"));

			clear_notifications();
			close_alert_notification_window();
			BatchMasterPage.clickExportDataLoader();
			waitForPageLoading();
			verifyNotificationExportBatchMaster("File Asn.xlsx from Asn is exported successfully.");
			download_asn_order();
			if (Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "isBatchNumberFound")
					.toString() == "false") {
				update_asn_with_batchNumber_valid_item(
						Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "BatchNumber").toString());
			} else {
				update_asn_with_batchNumber_valid_item(getDataFromFeature("getdata(BatchNo_Line1)"));
			}
			HomePage.navigate_to_ASNs();
			clear_notifications();
			close_alert_notification_window();
			BatchMasterPage.clickImportDataLoader();
			ASNs.selectFiletoImport();
			waitForPageLoading();
			verifyNotificationExportBatchMaster("File ASN.xlsx from Asn is imported successfully.");
			close_alert_notification_window();
			searchASNinAsns();
			HomePage.navigate_to_wmmobile();
			searchMenuWmMobile(getDataFromFeature("getdata(WM_Receiving)"));
			complete_at_standard_receiving();
			WMMobile.searchMenu(getDataFromFeature("getdata(WM_PutAway)"));
			moveILPNFromDamageLocationToStorageLocation();
		} else {
			FrameworkLogger.log(LogType.INFO, "Inventory already exists");
		}
	}

	/*
	 * @And("Complete ATStandardReceiving") public void
	 * complete_at_standard_receiving() {
	 * ReceiveLPNLevel.searchASN(Variables.get(CurrentThreadInstance.
	 * getCurrentScenarioId() + "ASN").toString());
	 * ReceiveLPNLevel.atStandardReceiving(null, 1,
	 * getDataFromFeature("getdata(OrdQty_Line1)"));
	 * ReceiveLPNLevel.verifyErrorNotDisplayed(); }
	 */

	@And("Update ASN with BatchNumber and valid Item")
	public void update_asn_with_batchNumber_valid_item(String batchNumber) {
		ExcelUtil1.writeCellValueForColumn1("ASN.xlsx", "AsnLine", "BatchNumber", batchNumber);
		ExcelUtil1.writeCellValueForColumn1("ASN.xlsx", "AsnLine", "ItemId",
				getDataFromFeature("getdata(ItemID_Line1)"));
		String strAsnValue = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(AsnId)"));
		ExcelUtil1.writeCellValueForColumn("ASN.xlsx", "Asn", "AsnId", strAsnValue);
		ExcelUtil1.writeCellValueForColumn("ASN.xlsx", "AsnLine", "AsnId", strAsnValue);
	}

	@And("Filter Original Orders2 by Order ID")
	public void filter_original_orders2_Order_ID() {
		OriginalOrdersPage.filterOriginalOrder(getDataFromFeature("getdata(Original_Order_ID)"));
	}

	@And("Verify Original Order is Available for the Inventory")
	public void verifyOriginalOrderIsAvailable() {
		OriginalOrdersPage.isOriginalOrderAvailable(getDataFromFeature("getdata(Original_Order_ID)"));
	}

	@And("Verify Order specifies the Item and the Batch")
	public void verifyOrderHasItemAndBatch() {
		OriginalOrdersPage.selectDetailsInOrderLine();
		OriginalOrdersPage.expandOrderLineNeed();
		OriginalOrdersPage.orderHasItemAndBatchNumber(getDataFromFeature("getdata(Original_Order_ID)"));
	}

	@And("Update Original Order with Batch Number")
	public void update_original_order_with_batch_number() {
		ExcelUtil1.verifyFilePresent("OriginalOrder.xlsx");
		String strOrderValue = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(OriginalOrderID)"));
		ExcelUtil1.writeCellValueForColumn("OriginalOrder.xlsx", "OriginalOrder", "OriginalOrderId", strOrderValue);
		ExcelUtil1.writeCellValueForColumn("OriginalOrder.xlsx", "OriginalOrderLine", "OriginalOrder.OriginalOrderId",
				strOrderValue);
		ExcelUtil1.writeCellValueForColumn1("OriginalOrder.xlsx", "OriginalOrderLine", "BatchNumber",
				getDataFromFeature("getdata(BatchNo_Line1)"));
		ExcelUtil1.writeCellValueForColumn1("OriginalOrder.xlsx", "OriginalOrderLine", "OrderedQuantity",
				getDataFromFeature("getdata(OrderedQuantity)"));
	}

	@And("Update Original Order with New Batch Number")
	public void update_original_order_with_new_batch_number() {
		ExcelUtil1.verifyFilePresent("OriginalOrder.xlsx");
		String strOrderValue = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(OriginalOrderID)"));
		ExcelUtil1.writeCellValueForColumn("OriginalOrder.xlsx", "OriginalOrder", "OriginalOrderId", strOrderValue);
		ExcelUtil1.writeCellValueForColumn("OriginalOrder.xlsx", "OriginalOrderLine", "OriginalOrder.OriginalOrderId",
				strOrderValue);
		ExcelUtil1.writeCellValueForColumn1("OriginalOrder.xlsx", "OriginalOrderLine", "BatchNumber",
				Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "BatchNumber").toString());
		ExcelUtil1.writeCellValueForColumn1("OriginalOrder.xlsx", "OriginalOrderLine", "OrderedQuantity",
				getDataFromFeature("getdata(OrderedQuantity)"));
	}

	@And("Close alert Notification window")
	public void close_alert_notification_window() {
		HomePage.clickAlertNotificationIcon();
	}

	@And("Create new Original Order if it doesnot exists")
	public void createNewOriginalOrder() {
		if ((Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "isOriginalOrderPresent")
				.toString() == "false")
				|| (Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "hasItemAndBatch")
						.toString() == "false")
				|| (Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "isBatchNumberFound")
						.toString() == "false")) {
			FrameworkLogger.log(LogType.INFO,
					"Order doesn't exists or meets criteria, Need to create new Original order");
			filter_original_orders2_Order_ID();
			clear_notifications();
			close_alert_notification_window();
			BatchMasterPage.clickExportDataLoader();
			waitForPageLoading();
			verifyNotificationExportBatchMaster("File OriginalOrder.xlsx from OriginalOrder is exported successfully.");
			// download_original_order();
			if (Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "isBatchNumberFound")
					.toString() == "false") {
				update_original_order_with_new_batch_number();
			} else {
				update_original_order_with_batch_number();
			}
			navigate_to_original_orders2();
			clear_notifications();
			close_alert_notification_window();
			BatchMasterPage.clickImportDataLoader();
			ExcelUtil1.selectFiletoImport(null); // Update Filename that need to be imported by removing null
			// OriginalOrdersPage.selectFiletoImport();
			waitForPageLoading();
			verifyNotificationExportBatchMaster("File OriginalOrder.xlsx from OriginalOrder is imported successfully.");
			close_alert_notification_window();
			verify_imported_orders();
			Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "NewOriginalOrderCreated", "true");
		} else {
			FrameworkLogger.log(LogType.INFO, "Order already exists");
			filter_original_orders2_Order_ID();
		}
	}

	@And("Execute RunWave from Original Orders")
	public void execute_run_wave_original_order() {
		OriginalOrdersPage.clickMoreActions();
		OriginalOrdersPage.executeRunWaveForOrder();
	}

	@And("Execute RunWave from Original Orders in Cubing04")
	public void execute_run_wave_order_in_cubing04() {
		OriginalOrdersPage.executeRunWaveFNCUBING04OrderStrategy();
	}

	@And("Verify wave Run specifies the Correct Quantity and the Batch")
	public void verifyWaveRunHasQuantityAndBatch() {
		WaveRunsPage.selectDetailsInOrderLine();
		WaveRunsPage.expandContainerOrQuantity();
		WaveRunsPage.checkContainerQuantity();
		WaveRunsPage.expandItem();
		WaveRunsPage.AllocationHasItemAndBatchNumber();
		WaveRunsPage.closeAllocation();
	}

	@And("Verify On Hand Quantity is UnChanged and Allocated Quantity is Changed")
	public void verifyOnHandQuantityAndAllocatedQuantity() {
		InventoryDetailsPage.storeOnHandAndAllocatedQuantityAfterWave();
		InventoryDetailsPage.verifyOnHandQuantityAfterWave();
		InventoryDetailsPage.verifyAllocatedQuantityAfterWave();
		CommonMethods.waitForPageLoading();
	}

	@And("Unplan the Selected Wave")
	public void unplan_wave_from_wave_run() {
		WaveRunsPage.unplanWave();
	}

	@And("Verify On Hand Quantity and Allocated Quantity After Cancel WaveRun")
	public void verifyInventoryQuantityAfterCancelWaveRun() {
		InventoryDetailsPage.storeOnHandAndAllocatedQuantityAfterWave();
		InventoryDetailsPage.verifyOnHandQuantityAfterWave();
		InventoryDetailsPage.verifyAllocatedQuantityAfterCancelWave();
	}

	@And("Validate Original Orders status {string}")
	public void validate_original_orders_status(String strOrderStatus) {
		if (Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "NewOriginalOrderCreated")
				.toString() == "true") {
			strOrderStatus = Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder").toString();
		}
		OrdersPage.verifyOrderStatus(strOrderStatus);
	}

	@And("Navigate to Last window")
	public void navigateToLastWindow() {
		CommonMethods.waitForPageLoading();
		SeleniumActions.switchToLastWindow();
		CommonMethods.waitForPageLoading();
	}

	@And("Navigate window using index id {string}")
	public void navigateWindowUsingIndexId(String index) {
		CommonMethods.waitForPageLoading();
		SeleniumActions.switchToWindowUsingIndex(Integer.parseInt(index));
		CommonMethods.waitForPageLoading();
	}

	@Then("Verify Rule details")
	public void verifyRuleDetails() {
		PutAwayPlanningStrategyPage.verifyRules();
	}

	@Then("Verify Determination Mode")
	public void verifyDeterminationMode() {
		PutAwayPlanningStrategyPage.verifyDeterminationMode();
	}

	@Then("Verify PutWay Zone as {string}")
	public void verifyPutWayZoneAsGetdataBUID(String text) {
		PutAwayPlanningStrategyPage.verifyPutAwayZone(getDataFromFeature(text));
	}

	@And("Finish PutWay Zone process")
	public void finishPutWayZoneProcess() {
		PutAwayPlanningStrategyPage.clickFinishButton();
		PutAwayPlanningStrategyPage.clickFinishButton2();
		PutAwayPlanningStrategyPage.clickFinishButton3();
	}

	@Then("Verify Location displayed as {string}")
	public void verifyLocationDisplayedAsGetdataLocation(String text) {
		StorageLocation.verifyLocationAtFirstIndex(getDataFromFeature(text));
	}

	@Then("Verify ILPN Details in ILPN Page")
	public void verifyILPNDetailsInILPNPage() {
		String location = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "CurrentLocation");
		location = location.replaceAll("-", "");
		ILPNs.verifyILPNStatusCodeAtFirstIndex(getDataFromFeature(getData("StatusCode")));
		ILPNs.verifyILPNCurrentLocationAtFirstIndex(location);
		ILPNs.verifyILPNCurrentLocationTypeAtFirstIndex(getDataFromFeature(getData("CurrentLocationTypeId")));
	}

	@And("Verify Product status and Inventory type in Inventory Details Page")
	public void verifyProductStatusAndInventoryTypeInInventoryDetailsPage() {
		HeaderPanelPage.clickRelatedLinksButton();
		HeaderPanelPage.clickInventoryDetailsLink();
		InventoryDetailsPage.verifyInventoryType();
		InventoryDetailsPage.verifyProductStatus();
	}

	@And("Enter ILPN and Location in FN PutAway System Directed Page")
	public void enterILPNAndLocationInFNPutAwaySystemDirectedPage() {
		FNPutAwaySystemDirected.enterILPNAndLocationInFNPutAwaySystemDirectedPage();
	}

	@And("Search Put Allocation Zone with {string}")
	public void searchPutAllocationZoneWith(String text) {
		LeftPanelPage.searchPutAllocationZone(getDataFromFeature(text));
	}

	@Then("Verify Batch number status as {string}")
	public void verifyBatchNumberStatusAs(String status) {
		if (status.equalsIgnoreCase("Released")) {
			BatchMasterPage.verifyBatchNumbersAreDisplayedWhichAreOnlyInReleasedStatus();
		} else if (status.equalsIgnoreCase("Held")) {
			BatchMasterPage.verifyBatchNumbersAreDisplayedWhichAreOnlyInHeldStatus();
		}
	}

	@Then("Verify Batch numbers with all status")
	public void verifyBatchNumbersWithAllStatus() {
		BatchMasterPage.verifyAllBatchNumbersAreDisplayed();
	}

	// Duplicate method
	/*
	 * @And("Complete ATStandardReceiving after error displayed") public void
	 * completeATStandardReceivingAfterErrorDisplayed() {
	 * ReceiveLPNLevel.searchASN(Variables.get(CurrentThreadInstance.
	 * getCurrentScenarioId()+"ASN").toString());
	 * ReceiveLPNLevel.enterLPN(ExcelUtil1.convert_variable_to_timestamp(
	 * getDataFromFeature("getdata(LPNId)")));
	 * ReceiveLPNLevel.enterScanItem(getDataFromFeature("getdata(ItemID_Line3)"));
	 * ReceiveLPNLevel.searchinventory(getDataFromFeature(getData("inventory_Line3")
	 * )); ReceiveLPNLevel.searchproductStatus(getDataFromFeature(getData(
	 * "ProductStatus_Line3")));
	 * ReceiveLPNLevel.searchCOOrigin(getDataFromFeature(getData("CoOrigin_Line3")))
	 * ;
	 * ReceiveLPNLevel.validateQtyError(getDataFromFeature(getData("OrdQty_Line4")),
	 * "RCV::143"); }
	 */

	@And("Search with Location Filter {string}")
	public void searchWithLocationFilterGetdataLocation(String text) {
		LocationInventory.searchLocation(getDataFromFeature(text));
	}

	@And("Search with Item Filter {string}")
	public void searchWithItemFilterGetdataItem(String text) {
		LocationInventory.searchItem(getDataFromFeature(text));

	}

	@And("Store quantity to variable as String")
	public void storeQuantityToVariableAsString() {

		StorageLocation.storeOnHandQuantityToString();
	}

	@Then("Verify OnhandQuantity stored to varaible")
	public void verifyOnhandQuantityStoredToVaraible() {
		String text = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "CurrentOnhandQuantity");
		StorageLocation.verifyOnHandQuantityToString(text);
	}

	@And("Select Cycle count in WM Mobile")
	public void selectCycleCountInWMMobile() {
		WMMobile.cycleCount();
	}

	@And("Store Batch number to varaiable")
	public void storeBatchNumberToVaraiable() {
		StorageLocation.storeBatchNumberToString();
	}

	@Then("Verify batch number stored")
	public void verifyBatchNumberStored() {
		String text = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "CurrentBatchNumber");
		StorageLocation.verifyBatchNumberToString(text);
	}

	@And("Scan Location in Cycle count {string}")
	public void scanLocationInCycleCount(String text) {
		LocationInventory.EnterLocation(getDataFromFeature(text));
	}

	@And("Scan Item in Cycle count {string}")
	public void scanItemInCycleCount(String text) {
		LocationInventory.EnterItem(getDataFromFeature(text));
	}

	@And("Enter Quantity details in cycle count screen")
	public void enterQuantityDetailsInCycleCountScreen() {
		String actualQuantity = (String) Variables
				.get(CurrentThreadInstance.getCurrentScenarioId() + "CurrentOnhandQuantity");
		int quantityValue = Integer.parseInt((actualQuantity).trim());
		int quantityUpdated = quantityValue - 1;
		CommonMethods.waitForPageLoading();
		TasksPage.enterQuantity(String.valueOf(quantityUpdated));
		TasksPage.clickGoButton();

	}

	@And("Enter Batch Number in cycle count screen")
	public void enterBatchNumberInCycleCountScreen() {
		String text = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "CurrentBatchNumber");
		TasksPage.enterBatchNumber(text);
		TasksPage.clickGoButton();

	}

	@And("Click on Confirm in POPup")
	public void clickOnConfirmInPOPup() {
		InventoryDetailsPage.clickConfirmButton();
	}

	@And("Click on End count")
	public void clickOnEndCount() {
		InventoryDetailsPage.clickEndCountButton();
	}

	@And("Switch to last window")
	public void switchToLastWindow() {
		SeleniumActions.closeBrowser();
		SeleniumActions.switchToLastWindow();
	}

	@And("Search with Quick select filter")
	public void searchWithQuickSelectFilter() {
		InventoryCountPage.clickQuickSelect();
	}

	/*
	 * @And("Select Today from Quick select filter") public void
	 * selectTodayFromQuickSelectFilter() {
	 * InventoryCountPage.SelectTodayFromQuickSelect(); }
	 *
	 * @And("Navigate to PIX Visibility") public void navigateToPIXVisibility() {
	 * HomePage.navigateToPIXVisibility(); }
	 *
	 * @And("Select Inventory Adjustment checkbox") public void
	 * selectInventoryAdjustmentCheckbox() {
	 * InventoryCountPage.SelectInventoryAdjustmentPIXVisibility(); }
	 *
	 * @And("Expand PIX Visibility arrow button") public void
	 * expandPIXVisibilityArrowButton() {
	 * InventoryCountPage.expandPIXVisibilityArrowButton(); }
	 *
	 * @And("Select PIX Visibility button") public void selectPIXVisibilityButton()
	 * { InventoryCountPage.SelectPIXVisibilitywButton(); }
	 *
	 * @And("Expand Filter") public void expandFilter() {
	 * InventoryDetailsPage.ExpandFilter(); }
	 *
	 * @And("Store Expiry date to variable") public void storeExpiryDateToVariable()
	 * { InventoryDetailsPage.StoreExpiryDate();
	 *
	 * }
	 *
	 * @And("Enter Expiry date in cycle count screen") public void
	 * enterExpiryDateInCycleCountScreen() { String text = (String)
	 * Variables.get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "StoreExpiryDate"); String[] text1 = text.split("/");
	 *
	 * String day = text1[0]; System.out.println(day); String month = text1[1];
	 * System.out.println(month); String year = text1[2]; System.out.println(year);
	 *
	 * String last2 = year.substring(2, 4);
	 *
	 * System.out.println(last2);
	 *
	 * WMMobile.enterExpiryDate(day, month, last2);
	 *
	 * TasksPage.clickGoButton(); }
	 */
	/*
	 * @And("Click on View button for First PutAway") public void
	 * clickOnViewButtonForFirstPutAway() {
	 * PutAwayPlanningStrategyPage.clickCloseIconForPutAwayAtFirstIndex();
	 * PutAwayPlanningStrategyPage.clickViewButton2(); }
	 *
	 * @Then("Verify Determination Mode as {string}") public void
	 * verifyDeterminationModeAsZoneBasedLocationDetermination(String text) { if
	 * (getDataFromFeature(text).
	 * equalsIgnoreCase("Zone Based Location Determination")) {
	 * PutAwayPlanningStrategyPage.verifyZoneBasedLocationDetermination(
	 * getDataFromFeature(text)); }
	 *
	 * }
	 *
	 * @And("Click on View button for {string} PutAway Planning Strategy Item")
	 * public void clickOnViewButtonForPutAwayPlanningStrategyItem(String text) { if
	 * (text.equalsIgnoreCase("FN")) {
	 * PutAwayPlanningStrategyPage.clickCloseIconForFNPutAwayPlanningStrategy(); }
	 * PutAwayPlanningStrategyPage.clickViewButton(); }
	 *
	 * @And("Click on View button for {string} PutAway Planning Criteria Item")
	 * public void clickOnViewButtonForPutAwayPlanningCriteriaItem(String text) { if
	 * (text.equalsIgnoreCase("BOOKS")) {
	 * PutAwayPlanningStrategyPage.clickCloseIconForBooksPutAwayPlanningCriteriaItem
	 * (); } if (text.equalsIgnoreCase("QR")) {
	 * PutAwayPlanningStrategyPage.clickCloseIconForQR1PutAwayPlanningCriteriaItem()
	 * ; } PutAwayPlanningStrategyPage.clickViewButton(); }
	 *
	 * @Then("Verify ILPNs displayed without current location in ILPN Page") public
	 * void verifyILPNsDisplayedWithoutCurrentLocationInILPNPage() {
	 * ILPNs.verifyILPNsDisplayedWithoutCurrentLocationInILPNPage(); }
	 *
	 * @And("Navigate to Items Page") public void navigateToItemsPage() {
	 * HomePage.navigateToItemsPage(); }
	 *
	 * @And("Search Item With {string}") public void searchItemWith(String text) {
	 * LeftPanelPage.searchItem(getDataFromFeature(text)); }
	 *
	 * @Then("Verify Product class value as {string}") public void
	 * verifyProductClassValueAs(String text) { CommonPage.clickRowAtFirstIndex();
	 * FooterPanelPage.clickDetailsButton();
	 * ItemsPopupPage.clickSpecificationLabel();
	 * ItemsPopupPage.verifyProductClassValue(getDataFromFeature(text));
	 * ItemsPopupPage.clickCloseIcon(); }
	 *
	 * @Then("Verify Matching Criteria data displayed") public void
	 * verifyMatchingCriteriaDataDisplayed() {
	 * CommonMethods.verifyMatchingCriteriaDataDisplayed(); }
	 *
	 * @Then("Verify ILPN Current Location") public void verifyILPNCurrentLocation()
	 * { String location = (String)
	 * Variables.get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "CurrentLocation"); location = location.replaceAll("-", "");
	 * ILPNs.verifyILPNCurrentLocationAtFirstIndex(location); }
	 *
	 * @And("Search Display location") public void searchDisplayLocation() { String
	 * location = (String)
	 * Variables.get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "DisplayLocation"); LeftPanelPage.searchDisplayLocation(location); }
	 *
	 * @And("Verify PutAllocation Zone as {string} in Location Popup Page") public
	 * void
	 * verifyPutAllocationZoneAsGetdataPutAllocationZoneInLocationPopupPage(String
	 * text) { CommonPage.clickRowAtFirstIndex();
	 * FooterPanelPage.clickDetailsButton();
	 * LocationPopupPage.clickZoneAssignmentAndLayoutInformationLabel();
	 * LocationPopupPage.verifyPutAllocationZoneValue(getDataFromFeature(text));
	 * LocationPopupPage.clickCloseIcon();
	 *
	 * }
	 *
	 * @And("Click on Count Run ID") public void clickOnCountRunID() {
	 * InventoryCountPage.clickCountRunId(); }
	 *
	 * @And("Navigate back to Inventory Count window") public void
	 * navigateBackToInventoryCountWindow() {
	 * InventoryCountPage.goBackToInventoryCount(); }
	 *
	 * @And("Expand side arrow button") public void expandSideArrowButton() {
	 * HomePage.ExpandSideArrow(); }
	 *
	 * @And("Create Cycle Count task") public void createCycleCountTask() {
	 * InventoryCountPage.CreateCycleCountTask(); }
	 *
	 * @And("Click on Yes button") public void clickOnYesButton() {
	 * BatchMasterPage.clickYesButtonInHoldPopup(); }
	 *
	 * @And("Select Cycle count checkbox filter") public void
	 * selectCycleCountCheckboxFilter() {
	 * InventoryCountPage.SelectCycleCountCheckbox(); }
	 *
	 * @And("Click on More Actions button") public void clickOnMoreActionsButton() {
	 * TasksPage.moreActionsButton(); }
	 *
	 * @And("Click on Cancel option") public void clickOnCancelOption() {
	 * TasksPage.CancelOption(); }
	 *
	 * @And("Click on Go button") public void clickOnGoButton() {
	 * TasksPage.clickGoButton(); }
	 *
	 * @And("Update ASN with three lines {string}") public void
	 * updateASNWithThreeLines(String fileName) throws Exception { String asnId =
	 * ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(AsnId)")
	 * ); Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ASN",
	 * asnId); FrameworkLogger.log(LogType.INFO, "Set value for ASN : " + asnId);
	 * ArrayList<String> al = new ArrayList<>(); al.add("Asn::2::3::" + asnId);
	 * al.add("AsnLine::2::2::" + asnId); al.add("AsnLine::3::2::" + asnId);
	 * al.add("AsnLine::4::2::" + asnId); ExcelUtil1.setMultipleCellData(fileName,
	 * al); }
	 *
	 * @And("Click on Import DataLoader") public void clickOnImportDataLoader() {
	 * HeaderPanelPage.clickImportDataLoader(); }
	 *
	 * @And("Click on Refresh") public void clickOnRefresh() {
	 * RightNavigationBar.clickRefreshButton(); }
	 *
	 * @And("Verify Product status and Inventory type in ASN Details Page") public
	 * void verifyProductStatusAndInventoryTypeInASNDetailsPage() {
	 * HeaderPanelPage.clickRelatedLinksButton();
	 * HeaderPanelPage.clickASNDetailsLink();
	 * ASNDetailsPage.verifyProductStatusElementCount(Integer.parseInt(getData(
	 * "ProductStatusCount")));
	 * ASNDetailsPage.verifyInventoryTypeElementCount(Integer.parseInt(getData(
	 * "InventoryTypeCount"))); }
	 *
	 * @And("Complete FN Trolley Receiving") public void
	 * completeFNTrolleyReceiving() {
	 * FNTrolleyReceivingPage.completeFNTrolleyReceiving(); }
	 *
	 * @Then("verification attempted for ASN is displayed") public void
	 * verificationAttemptedForASNIsDisplayed() { String asnId = (String)
	 * Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN");
	 * FNTrolleyReceivingPage.verifyASNIsDisplayedInConfirmationPopup(asnId);
	 * CommonPopupPage.clickOkButton(); }
	 *
	 * @And("Verify Inventory details for each LPN") public void
	 * verifyInventoryDetailsForEachLPN() {
	 * ILPNs.verifyInventoryDetailsForEachLPN(); }
	 *
	 * @And("Close browser window And Switch to Last Window") public void
	 * closeBrowserWindowAndSwitchToLastWindow() { SeleniumActions.closeBrowser();
	 * SeleniumActions.switchToLastWindow(); }
	 *
	 * @And("Complete FN Trolley PutAway") public void completeFNTrolleyPutAway() {
	 * FNTrolleyPutAwayPage.completeFNTrolleyPutAway(); }
	 *
	 * @And("Verify PutAway ASN details") public void verifyPutAwayASNDetails() {
	 * HeaderPanelPage.clickRelatedLinksButton();
	 * HeaderPanelPage.clickLPNInventory();
	 * ILPNs.verifyLinkedLPNCountForSamePallet(0);
	 * ILPNs.verifyPreviousLocationForEachLPN(3);
	 * ILPNs.verifyCurrentLocationForEachLPN(); }
	 *
	 * @And("Verify {string} LPNs are liked to same pallet") public void
	 * verifyGetdataLPNsAreLikedToSamePallet(String count) {
	 * HeaderPanelPage.clickRelatedLinksButton();
	 * HeaderPanelPage.clickLPNInventory();
	 * ILPNs.verifyLinkedLPNCountForSamePallet(Integer.parseInt(getDataFromFeature(
	 * count))); }
	 *
	 * @And("Store generated ASN number in runtime variable") public void
	 * storeGeneratedASNNumberInRuntimeVariable() {
	 * ASNs.storeGeneratedAsnNumberToString(); }
	 *
	 * @And("Enter Batch Number manually {string}") public void
	 * enterBatchNumberManually(String text) {
	 * ASNs.EnterBatchNumberManually(getDataFromFeature(text)); }
	 *
	 * @And("Update ASN export file {string}") public void
	 * updateASNExportFile(String fileName) {
	 * ExcelUtil1.verifyFilePresentfromuserdir(fileName); String AsnIdValue =
	 * ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(ASN)"));
	 * Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ASN",
	 * AsnIdValue); String strAsnIdValue = (String)
	 * Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN");
	 * ExcelUtil1.writeCellValueForColumnwoAppend(fileName, "Asn", "AsnId",
	 * strAsnIdValue); ExcelUtil1.writeCellValueForColumnwoAppend(fileName, "Asn",
	 * "AsnStatus", "1000"); ExcelUtil1.writeCellValueForColumnboolean(fileName,
	 * "Asn", "VerificationAttempted", "FALSE");
	 * ExcelUtil1.writeCellValueForColumnwoAppend(fileName, "Asn", "ReceivedLpns",
	 * "0.000"); ExcelUtil1.writeCellValueForColumnwoAppend(fileName, "AsnLine",
	 * "AsnId", strAsnIdValue); ExcelUtil1.deleteRowsfromSheet(fileName, "Lpn");
	 * ExcelUtil1.deleteRowsfromSheet(fileName, "LpnDetail");
	 *
	 * }
	 *
	 * @And("Update ASN import file with batch number and expiry date {string}")
	 * public void updateASNImportFileWithBatchNumberAndExpiryDateRCV(String
	 * fileName) { ExcelUtil1.verifyFilePresentfromuserdir(fileName); String
	 * AsnIdValue =
	 * ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(ASN)"));
	 * Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ASN",
	 * AsnIdValue); String strAsnIdValue = (String)
	 * Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN");
	 * ExcelUtil1.writeCellValueForColumnwoAppend(fileName, "Asn", "AsnId",
	 * strAsnIdValue); ExcelUtil1.writeCellValueForColumnwoAppend(fileName, "Asn",
	 * "AsnStatus", "1000"); ExcelUtil1.writeCellValueForColumnboolean(fileName,
	 * "Asn", "VerificationAttempted", "FALSE");
	 * ExcelUtil1.writeCellValueForColumnwoAppend(fileName, "Asn", "ReceivedLpns",
	 * "0.000"); ExcelUtil1.writeCellValueForColumnwoAppend(fileName, "AsnLine",
	 * "AsnId", strAsnIdValue); ExcelUtil1.writeCellValueForColumnwoAppend(fileName,
	 * "AsnLine", "BatchNumber", getDataFromFeature(getData("BatchNo_Line1")));
	 * ExcelUtil1.writeCellValueForColumnwoAppend(fileName, "AsnLine", "ExpiryDate",
	 * getDataFromFeature(getData("ExpiryDate_Line1")));
	 * ExcelUtil1.deleteRowsfromSheet(fileName, "Lpn");
	 * ExcelUtil1.deleteRowsfromSheet(fileName, "LpnDetail");
	 *
	 * }
	 *
	 * @And("Update ASN export file with batch number {string}") public void
	 * updateASNExportFileWithBatchNumberRCVXlsx(String fileName) {
	 * ExcelUtil1.verifyFilePresentfromuserdir(fileName); String AsnIdValue =
	 * ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(ASN)"));
	 * Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ASN",
	 * AsnIdValue); String strAsnIdValue = (String)
	 * Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN");
	 * ExcelUtil1.writeCellValueForColumnwoAppend(fileName, "Asn", "AsnId",
	 * strAsnIdValue); ExcelUtil1.writeCellValueForColumnwoAppend(fileName, "Asn",
	 * "AsnStatus", "1000"); ExcelUtil1.writeCellValueForColumnboolean(fileName,
	 * "Asn", "VerificationAttempted", "FALSE");
	 * ExcelUtil1.writeCellValueForColumnwoAppend(fileName, "Asn", "ReceivedLpns",
	 * "0.000"); ExcelUtil1.writeCellValueForColumnwoAppend(fileName, "AsnLine",
	 * "AsnId", strAsnIdValue); ExcelUtil1.writeCellValueForColumnwoAppend(fileName,
	 * "AsnLine", "BatchNumber", getDataFromFeature(getData("BatchNo_Line1")));
	 * ExcelUtil1.deleteRowsfromSheet(fileName, "Lpn");
	 * ExcelUtil1.deleteRowsfromSheet(fileName, "LpnDetail");
	 *
	 * }
	 *
	 * @And("Import Data Loader wo robot {string}") public void
	 * importDataLoaderWoRobotRCVXlsx(String fileName) {
	 * ExcelUtil1.selectFiletoImportfromtestdatadir(fileName); }
	 *
	 * @And("Update ASN export file with LPN Receiving Parent LPN {string}") public
	 * void updateASNExportFileWithLPNReceivingParentLPNRCV(String fileName) {
	 * ExcelUtil1.verifyFilePresentfromuserdir(fileName); String AsnIdValue =
	 * ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(ASN)"));
	 * Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ASN",
	 * AsnIdValue); String LPNIdValue =
	 * ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(LPNId)")
	 * ); Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN",
	 * LPNIdValue); String strAsnIdValue = (String)
	 * Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN"); String
	 * strLpnIdValue = (String)
	 * Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "LPN");
	 *
	 * ExcelUtil1.writeCellValueForColumnwoAppend(fileName, "Asn", "AsnId",
	 * strAsnIdValue); ExcelUtil1.writeCellValueForColumnwoAppend(fileName, "Lpn",
	 * "AsnId", strAsnIdValue); ExcelUtil1.writeCellValueForColumnfromdir(fileName,
	 * "Lpn", "LpnId", strLpnIdValue); String parentlpn =
	 * ExcelUtil1.readCellValueForColumnfromdir(fileName, "Lpn", "LpnId", 3); String
	 * lpn1 = ExcelUtil1.readCellValueForColumnfromdir(fileName, "Lpn", "LpnId", 1);
	 * String lpn2 = ExcelUtil1.readCellValueForColumnfromdir(fileName, "Lpn",
	 * "LpnId", 2); Variables.set(CurrentThreadInstance.getCurrentScenarioId() +
	 * "parentlpnId", parentlpn);
	 * Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "lpn1Id", lpn1);
	 * Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "lpn2Id", lpn2);
	 *
	 * ExcelUtil1.writeCellValueForColumntoparticularrow(fileName, "Lpn",
	 * "ParentLpnId", parentlpn, 1);
	 * ExcelUtil1.writeCellValueForColumntoparticularrow(fileName, "Lpn",
	 * "ParentLpnId", parentlpn, 2);
	 * ExcelUtil1.writeCellValueForColumntoparticularrow(fileName, "LpnDetail",
	 * "Lpn.LpnId", lpn1, 1);
	 * ExcelUtil1.writeCellValueForColumntoparticularrow(fileName, "LpnDetail",
	 * "Lpn.LpnId", lpn2, 2); //
	 * ExcelUtil1.writeCellValueForColumnwoAppend(FrameworkConstants.
	 * getTestDataDirPath()+"/Web_excelfiles/",CurrentThreadInstance.
	 * getCurrentScenarioName()+".xlsx", // "LpnDetail", "LpnDetailId",""); }
	 */
	@And("Store ILPNS number in runtime variable")
	public static void captureILPNSNumber() {
		ILPNs.captureILPNSNumber();
	}

	@And("Filter ILPNS by {string} and {string}")
	public void filterILPNsBy(String strText1, String strText2) {
		ILPNs.filterLPNByStatus(getDataFromFeature(strText1));
		ILPNs.filterLPNCurrentLocationIsNull();
		ILPNs.filterLPNByItem(getDataFromFeature(strText2));
	}

	@And("Complete AT System Directed Putaway")
	public void complete_at_system_directed_putaway() {
		SystemDirected.searchLPN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ILPN").toString());
		ReceiveLPNLevel.atStandardReceiving(null, 1, getDataFromFeature("getdata(OrdQty_Line1)"));
		ReceiveLPNLevel.verifyErrorNotDisplayed();
	}

	@And("Putaway LPN AT System Directed")
	public void putaway_lpn_at_system_directed_at() {
		SystemDirected.searchLPN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "LPN").toString());
		SystemDirected.enterScanReserveLocation();
	}

	@And("Verify Current Location updated")
	public void verify_current__location_updated() {
		SeleniumActions.switchToWindowUsingIndex(0);
		HomePage.navigate_to_ILPNs();
		ILPNs.filterLPNByLPNValue(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "LPN").toString());
		StorageLocation.saveCurrentQuantity("CurrentQtyUpdated");
		if (Integer.parseInt(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "CurrentQtyBeforeUpdate")
				.toString()) < Integer.parseInt(
						Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "CurrentQtyUpdated").toString())) {
			FrameworkLogger.log(LogType.PASS, "Current Quantity value is updated");
			SeleniumActions.switchToLastWindow();
			SeleniumActions.closeBrowser();
			SeleniumActions.switchToLastWindow();
		} else {
			FrameworkLogger.log(LogType.FAIL, "Current Quantity is not updated");
		}
	}

	@And("Validate ILPNs Current Display Location")
	public void validate_ILPNs_CurrentDisplayLocation() {
		SeleniumActions.switchToWindowUsingIndex(0);
		HomePage.navigate_to_ILPNs();
		ILPNs.clearFilterMenuILPNs();
		ILPNs.searchLPN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "LPN").toString());
		ILPNs.verifyILPNsCurrentDisplayLocation(
				Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "DisplayLocation").toString());
	}

	@And("Update ASN Value and Asn Line Id Value by file {string}")
	public void update_asn_order_no_asnlineid(String fileName) throws Exception {

		String AsnIdValue = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(ASN)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ASN", AsnIdValue);
		FrameworkLogger.log(LogType.INFO, "Set value for ASN : " + AsnIdValue);

		ArrayList<String> al = new ArrayList<>();
		al.add("Asn::2::3::" + AsnIdValue);
		al.add("AsnLine::2::2::" + AsnIdValue);
		al.add("AsnLine::3::2::" + AsnIdValue);
		al.add("AsnLine::4::2::" + AsnIdValue);
		ExcelUtil1.setMultipleCellData(fileName, al);

	}

	@And("Search Imported ASN at ASNs")
	public void searchImportedASNAtASNs() {
		ASNs.searchASN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "AsnId").toString());
	}

	@And("Complete FN Trolley Receiving Line 1")
	public void completeFNTrolleyReceivingLine1() {
		ReceiveLPNLevel.searchASN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN").toString());
		String LPNIdLine1 = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(LPNIdLine1)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPNIdLine1", LPNIdLine1);
		ReceiveLPNLevel.enterLPN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "LPNIdLine1").toString());
		ReceiveLPNLevel.enterScanItem(getDataFromFeature("getdata(ItemID_Line1)"));
		ReceiveLPNLevel.validateBatchnumber(getDataFromFeature("getdata(BatchNo)"));
		ReceiveLPNLevel.verifyBatchExpirationDateDisplayed();
		ReceiveLPNLevel.enterScanQuantity();
		ReceiveLPNLevel.verifyLPNAllocatedForSorting();
		String strPalletId1 = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(PalletId1)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "PalletId1", strPalletId1);
		ReceiveLPNLevel.enterScanPallet(strPalletId1);
	}

	@And("Complete FN Trolley Receiving Line 2")
	public void completeFNTrolleyReceivingLine2() {
		String LPNIdLine2 = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(LPNIdLine2)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPNIdLine2", LPNIdLine2);
		ReceiveLPNLevel.enterLPN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "LPNIdLine2").toString());
		ReceiveLPNLevel.enterScanItem(getDataFromFeature("getdata(ItemID_Line2)"));
		ReceiveLPNLevel.verifyInventoryTypeIdDisplayed();
		ReceiveLPNLevel.verifyProductStatusIdDisplayed();
		ReceiveLPNLevel.enterScanQuantity();
		ReceiveLPNLevel.verifyLPNAllocatedForSorting();
		ReceiveLPNLevel
				.enterScanPallet(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "PalletId1").toString());
	}

	@And("Complete FN Trolley Receiving Line 3")
	public void completeFNTrolleyReceivingLine3() {
		String LPNIdLine3 = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(LPNIdLine3)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPNIdLine3", LPNIdLine3);
		ReceiveLPNLevel.enterLPN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "LPNIdLine3").toString());
		ReceiveLPNLevel.enterScanItem(getDataFromFeature("getdata(ItemID_Line3)"));
		ReceiveLPNLevel.verifyInventoryTypeIdDisplayed();
		ReceiveLPNLevel.verifyProductStatusIdDisplayed();
		ReceiveLPNLevel.verifyCountryOfOriginDisplayed();
		ReceiveLPNLevel.enterScanQuantity();
		ReceiveLPNLevel.verifyLPNAllocatedForSorting();
		ReceiveLPNLevel.enterScanEndPallet(
				Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "PalletId1").toString());
		ReceiveLPNLevel.enterScanPallet(getDataFromFeature("getdata(PalletId2)"));
		ReceiveLPNLevel.verifyASNinFNTrolleyReceiving();
		ReceiveLPNLevel.verifyRequestVerifyASN();
	}

	@And("Navigate to ASN Related Link LPN Inventory")
	public void NavigateToRelatedLinkLPNInventory() {
		SeleniumActions.switchToWindowUsingIndex(0);
		HomePage.navigate_to_ASNs();
		ASNs.verifyASNsPageDisplayed();
		ASNs.searchASN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN").toString());
		// ASNs.verifyASNStatus("Verified");
		ASNs.selectLPNInventoryRelatedLink();
	}

	@And("Verify ASN>ILPNs details are displayed")
	public static void verifyLPNInventoryDisplayed() {
		ILPNs.verifyPageDisplayed();
	}

	@And("Verify Parent LPN of multiple card")
	public static void verifyMulitpleParentLPN() {
		ILPNs.validateParentLPNinILPNs();
	}

	@And("Verify LPN Inventory Detail in card1")
	public static void verifyLPNINventoryDetailCard1() {
		ILPNs.validateBatchNumberInLPNInventoryTable(getDataFromFeature("getdata(BatchNo)"));
		ILPNs.validateExpiryDateInLPNInventoryTable(getDataFromFeature("getdata(ExpirationDate)"));
		ILPNs.validateOnHandQuantityAndInventoryContainer(getDataFromFeature("getdata(OnHandQty)"),
				Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "LPNIdLine1").toString());
		ILPNs.closeILPN();
	}

	@And("Verify LPN Inventory Detail in card2")
	public static void verifyLPNINventoryDetailCard2() {
		/*
		 * ILPNs.ValidateProductStatus_InventoryTypeAndCountryOfOrigin(
		 * getDataFromFeature("getdata(ProductStatus)"),
		 * getDataFromFeature("getdata(InventoryTypeId)"), null);
		 */
		ILPNs.validateOnHandQuantityAndInventoryContainer(getDataFromFeature("getdata(OnHandQty)"),
				Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "LPNIdLine2").toString());
		ILPNs.closeILPN();
	}

	@And("Verify LPN Inventory Detail in card3")
	public static void verifyLPNINventoryDetailCard3() {
		ILPNs.ValidateProductStatus_InventoryTypeAndCountryOfOrigin(getDataFromFeature("getdata(ProductStatus)"),
				getDataFromFeature("getdata(InventoryTypeId)"), getDataFromFeature("getdata(COO)"));
		ILPNs.validateOnHandQuantityAndInventoryContainer(getDataFromFeature("getdata(OnHandQty)"),
				Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "LPNIdLine3").toString());
		ILPNs.closeILPN();
	}

	@And("Verify ASN Detail in card1")
	public static void verifyASNDetailCard1() {
		ASNs.selectASNCard(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "AsnId").toString());
		ASNs.selectASNDetailRelatedLink();
		ASNs.verifyInventoryAttributesCard1();
		ASNs.verifyAsnLineInventoryAttributeDisplayed();
		ASNs.selectASNsBreadcrumb();
	}

	@And("Select ASN Card at ASNs")
	public void selectASNCardAtASNs() {
		ASNs.selectASNCard(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "AsnId").toString());
	}

	@And("Enter Batch Expiration date manually {string}")
	public void enterBatchExpirationDateManually(String date) {
		WMMobile.enterExpiryDateWithYearAsTwoDigits(getDataFromFeature(date));
		TasksPage.clickGoButton();
	}

	@And("Enter Quantity manually {string}")
	public void enterQuantityManually(String text) {
		WMMobile.enterQuantitymanually(getDataFromFeature(text));
	}

	@And("Verify ASN in WM Mobile")
	public void verifyASNInWMMobile() {
		ASNs.verifyASN();
	}

	@And("Click on Yes button in Proceed for ASN Verification")
	public void clickOnYesButtonInProceedForASNVerification() {
		ASNs.yesbuttonVerifyASN();
	}

	@And("Click on OK button")
	public void clickOnOKButton() {
		CommonPage.clickOkButton();
	}

	@And("Filter by stored ASN number")
	public void filterByStoredASNNumber() {
		String text = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASNNumber");
		ASNs.enterASNnumber(text);

	}

	@And("Select  LPN \\(Inventory) link")
	public void selectLPNInventoryLink() {
		CommonPage.clickRowAtFirstIndex();
		CommonMethods.waitForPageLoading();
		ASNs.selectLPNInventoryRelatedLink();

	}

	@And("Store testData")
	public void storeTestData() {
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "BatchNumber1",
				getDataFromFeature("getdata(BatchNo_Line1)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "BatchNumber2",
				getDataFromFeature("getdata(BatchNo_Line2)"));
	}

	@And("Filter by Batch Number ItemID and Location")
	public void filterByBatchNumberItemIDAndLocation() {
		int noOfBatches = Integer.parseInt(getDataFromFeature("getdata(NumberOfBatches)"));
		for (int i = noOfBatches; i >= 1; i--) {
			InventoryDetailsPage.searchBatchNumber(getDataFromFeature("getdata(BatchNo_Line" + i + ")"));
			InventoryDetailsPage.searchItemId(getDataFromFeature("getdata(ItemID_Line" + i + ")"));
			BatchMasterPage.storeBatchNumberStatus();
			Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "isBatchNumber" + i + "Found", "true");
			Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "BatchNumber" + i,
					getDataFromFeature("getdata(BatchNo_Line" + i + ")"));
			LeftPanelPage.clickClearAll();
		}
	}

	@And("Verify Item ,Batch and Quantity For Order Lines")
	public void verifyItemAndBatchAndQuantityInOrderLines() {
		int orderLineQuantity = Integer.parseInt(getDataFromFeature("getdata(orderLineQuantity)"));
		for (int i = orderLineQuantity; i >= 1; i--) {
			OriginalOrdersPage.selectDetailsForMultipleOrderLine(i);
			OriginalOrdersPage.expandOrderLineNeed();
			Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "OrderLineID" + i,
					OriginalOrdersPage.getOrderLineIDFromOrderLinePopUp());
			OriginalOrdersPage
					.orderHasQuantityInOrderLineNeed(getDataFromFeature("getdata(Order_Line_Quantity" + i + ")"));
			OriginalOrdersPage.orderHasItemIDInOrderLineNeed(getDataFromFeature("getdata(ItemID_Line" + i + ")"));
			OriginalOrdersPage.orderHasBatchNumberInOrderLineNeed(getDataFromFeature("getdata(BatchNo_Line" + i + ")"));
			OriginalOrdersPage.closeOrderLine();
			FooterPanelPage.clickDeselectButton();
		}
	}

	@And("Verify wave Run specifies the Correct Quantity and the Batch in Allocations")
	public void verifyWaveRunHasQuantityAndBatchInAllocations() {
		int orderLineQuantity = Integer.parseInt(getDataFromFeature("getdata(orderLineQuantity)"));
		for (int i = orderLineQuantity; i >= 1; i--) {
			WaveRunsPage.clickOrderLineInAllocations(
					Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "OrderLineID" + i).toString());
//			WaveRunsPage.selectDetailsForMultipleOrderLine(i);
			WaveRunsPage.expandContainerOrQuantity();
			WaveRunsPage.checkContainerQuantity(getDataFromFeature("getdata(Order_Line_Quantity" + i + ")"));
			WaveRunsPage.expandItem();
			WaveRunsPage.allocationItemID(getDataFromFeature("getdata(ItemID_Line" + i + ")"));
			WaveRunsPage.allocationBatchNumber(getDataFromFeature("getdata(BatchNo_Line" + i + ")"));
			WaveRunsPage.closeAllocation();
			FooterPanelPage.clickDeselectButton();
		}
	}

	@And("Filter by Inventory Details")
	public void filterByInventoryDetails(int Quantity) {
		// InventoryDetailsPage.minimizeFilterButton();
		InventoryDetailsPage.searchItemId(getDataFromFeature("getdata(ItemID_Line" + Quantity + ")"));
		InventoryDetailsPage.enterDisplayLocation(getDataFromFeature("getdata(Display_Location" + Quantity + ")"));
		InventoryDetailsPage.filterInventoryContainerType(getDataFromFeature("getdata(InventoryContainerType)"));
		InventoryDetailsPage.searchBatchNumber(getDataFromFeature("getdata(BatchNo_Line" + Quantity + ")"));
	}

	@And("Verify On Hand Quantity is UnChanged and Allocated Quantity is Changed for Batch")
	public void verifyOnHandQuantityAndAllocatedQuantityForBatch() {
		int orderLineQuantity = Integer.parseInt(getDataFromFeature("getdata(orderLineQuantity)"));
		for (int i = 1; i <= orderLineQuantity; i++) {
			filterByInventoryDetails(i);
			InventoryDetailsPage.storeOnHandAndAllocatedQuantityAfterWave1(i);
			InventoryDetailsPage.verifyOnHandQuantityAfterWave1(i);
			InventoryDetailsPage.verifyAllocatedQuantityAfterWave1(i);
			LeftPanelPage.clickClearAll();
			CommonMethods.waitForPageLoading();
		}
	}

	@And("Verify On Hand Quantity and Allocated Quantity After Cancel WaveRun For Batch")
	public void verifyInventoryQuantityAfterCancelWaveRunForBatch() {
		int orderLineQuantity = Integer.parseInt(getDataFromFeature("getdata(orderLineQuantity)"));
		for (int i = 1; i <= orderLineQuantity; i++) {
			filterByInventoryDetails(i);
			InventoryDetailsPage.storeOnHandAndAllocatedQuantityAfterWave1(i);
			InventoryDetailsPage.verifyOnHandQuantityAfterWave1(i);
			InventoryDetailsPage.verifyAllocatedQuantityAfterCancelWave1(i);
			LeftPanelPage.clickClearAll();
			CommonMethods.waitForPageLoading();
		}
	}

	@And("Store Inventory Details for the Batch Number")
	public void verifyInventoryIsAvailableForBatch() {
		int orderLineQuantity = Integer.parseInt(getDataFromFeature("getdata(orderLineQuantity)"));
		for (int i = 1; i <= orderLineQuantity; i++) {
			filterByInventoryDetails(i);
			InventoryDetailsPage.storeInventoryDetailsForBatch(i);
			LeftPanelPage.clickClearAll();
			CommonMethods.waitForPageLoading();
		}
	}

	@And("Update Original Order with two lines {string}")
	public void updateOriginalOrderWithTwoLines(String fileName) throws Exception {
		String strOrderValue = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(OriginalOrderID)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder", strOrderValue);
		FrameworkLogger.log(LogType.INFO, "Set value for Original Order : " + strOrderValue);
		ArrayList<String> al = new ArrayList<>();
		al.add("OriginalOrder::2::3::" + strOrderValue);
		al.add("OriginalOrderLine::2::2::" + strOrderValue);
		al.add("OriginalOrderLine::3::2::" + strOrderValue);
		al.add("OriginalOrderLine::2::11::"
				+ Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "BatchNumber1").toString());
		al.add("OriginalOrderLine::3::11::"
				+ Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "BatchNumber2").toString());
		al.add("OriginalOrderLine::2::7::" + getDataFromFeature("getdata(Order_Line_Quantity1)"));
		al.add("OriginalOrderLine::3::7::" + getDataFromFeature("getdata(Order_Line_Quantity2)"));
		ExcelUtil1.setMultipleCellData(fileName, al);

	}

	@And("Update ASN with two lines {string}")
	public void updateASNWithTwoLines(String fileName) throws Exception {
		String AsnId = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(AsnId)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ASN", AsnId);
		FrameworkLogger.log(LogType.INFO, "Set value for ASNID1 : " + AsnId);
		ArrayList<String> al = new ArrayList<>();
		al.add("Asn::2::3::" + AsnId);
		al.add("AsnLine::2::2::" + AsnId);
		al.add("AsnLine::2::7::" + getDataFromFeature("getdata(ItemID_Line1)"));
		al.add("AsnLine::2::8::" + getDataFromFeature("getdata(Order_Line_Quantity1)"));
		al.add("AsnLine::2::10::"
				+ Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "BatchNumber1").toString());
		al.add("AsnLine::3::2::" + AsnId);
		al.add("AsnLine::3::7::" + getDataFromFeature("getdata(ItemID_Line2)"));
		al.add("AsnLine::3::8::" + getDataFromFeature("getdata(Order_Line_Quantity2)"));
		al.add("AsnLine::3::10::"
				+ Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "BatchNumber2").toString());

		ExcelUtil1.setMultipleCellData(fileName, al);

	}

	@And("Complete ATStandardReceiving with Batches")
	public void complete_at_standard_receiving_with_batch() {
		ReceiveLPNLevel.searchASN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN").toString());
		String lineCount = getDataFromFeature("getdata(orderLineQuantity)");
		for (int i = 1; i <= Integer.parseInt(lineCount); i++) {
			ReceiveLPNLevel.enterLPN(null, 1);
			ReceiveLPNLevel.enterScanItem(getDataFromFeature("getdata(ItemID_Line" + i + ")"));
			ReceiveLPNLevel.validateBatchnumber(
					Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "BatchNumber" + i).toString());
			ReceiveLPNLevel.enterQuantity(Integer.valueOf(getDataFromFeature("getdata(Order_Line_Quantity" + i + ")")));
		}
	}

	@And("Enter ILPN and Location in AT User Directed PutAway")
	public void enterILPNAndLocationInATUserDirectedPutAway() {
		List<String> listOFiLPNs = (List<String>) Variables
				.get(CurrentThreadInstance.getCurrentScenarioId() + "listOFiLPNs");
		int i = 1;
		for (String iLpn : listOFiLPNs) {
			UserDirected.searchLPN(iLpn);
			UserDirected.enterQuantity(getDataFromFeature("getdata(Order_Line_Quantity" + i + ")"));
			UserDirected.enterScanLocationWithWarning(getDataFromFeature("getdata(Display_Location" + i + ")"));
			i++;
		}
	}

	@And("Validate ILPN status {string}")
	public void validate_lpn_status(String ILPNStatus) {
		int orderLineQuantity = Integer.parseInt(getDataFromFeature("getdata(orderLineQuantity)"));
		for (int i = 1; i <= orderLineQuantity; i++) {
			ILPNs.verifyLPNStatus(ILPNStatus, i);
		}
	}

	@And("Enter LPN in AT Blind Receipt WM Mobile menu")
	public void enterLPNInATBlindReceiptWMMobileMenu() {
		String asnid = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASNNumber");
		String lpnid = asnid.replaceAll("ASN", "LP");
		ASNs.enterLNP(lpnid);
	}

	@And("Check Inventory details heading")
	public void checkInventoryDetailsHeading() {
		CommonMethods.waitForPageLoading();
		HomePage.ExpandSideArrow();
		ASNs.inventoryDetailsHeading();
	}

	@Then("Verify Inventory details")
	public void verifyInventoryDetails() {
		ASNs.verifyAsnBatchNumber(getDataFromFeature(getData("BatchNumber")));
	}

	@And("Update ASN with one quantity {string}")
	public void updateASNWithOneQuantity(String fileName) throws Exception {
		String asnId = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(AsnId)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ASN", asnId);
		FrameworkLogger.log(LogType.INFO, "Set value for ASN : " + asnId);
		ArrayList<String> al = new ArrayList<>();
		al.add("Asn::2::3::" + asnId);
		al.add("AsnLine::2::2::" + asnId);
		ExcelUtil1.setMultipleCellData(fileName, al);
	}

	@And("Verify ILPN Details {string} AT System Directed PutAway")
	public void verifyILPNDetailsATSystemDirectedPutAway(String text) {
		if (text.equalsIgnoreCase("BEFORE")) {
			ILPNs.verifyILPNStatusCodeAtFirstIndex(getDataFromFeature(getData("Before StatusCode")));
			ILPNs.verifyILPNStatusAtFirstIndex(getDataFromFeature(getData("Before Status")));
			ILPNs.verifyILPNCurrentLocationAtFirstIndex("");
			ILPNs.verifyILPNCurrentLocationTypeAtFirstIndex("");
			ILPNs.verifyILPNPreviousLocationAtFirstIndex("");
		} else if (text.equalsIgnoreCase("AFTER")) {
			ILPNs.verifyILPNStatusCodeAtFirstIndex(getDataFromFeature(getData("After StatusCode")));
			ILPNs.verifyILPNStatusAtFirstIndex(getDataFromFeature(getData("After Status")));
			String PreviousLocation = (String) Variables
					.get(CurrentThreadInstance.getCurrentScenarioId() + "DisplayLocation");
			PreviousLocation = PreviousLocation.replaceAll("-", "");
			ILPNs.verifyILPNPreviousLocationAtFirstIndex(PreviousLocation);
			ILPNs.verifyILPNPreviousDisplayLocationAtFirstIndex(PreviousLocation);
		}
	}

	@And("Search LPN with Variable Name {string}")
	public void searchLPNWithVariableName(String name) {
		LeftPanelPage.searchLPN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + name).toString());
	}

	@And("Close browser window1")
	public void closeBrowserWindow1() {
		SeleniumActions.closeBrowser();
		SeleniumActions.switchToLastWindow();
	}

	@And("Complete FN LPN Receiving with Container")
	public void completeFNLPNReceivingWithContainer() {
		ReceiveLPNLevel.completeFNLPNReceiving();
	}

	@And("Complete Cycle count with Quantitymismatch")
	public void completeCycleCountWithQuantitymismatch() {
		// LocationInventory
		LocationInventory.EnterLocation(getDataFromFeature(getData("ScanLocation")));
		InventoryDetailsPage.clickConfirmButton();
		InventoryDetailsPage.clickContinuecountactionButton();
		LocationInventory.EnterItem(getDataFromFeature(getData("Item")));
		InventoryDetailsPage.clickConfirmButton();
		LocationInventory.Enterquantityinccyclecountscren();
		LocationInventory
				.ValidateQuantityerror("Quantity Mismatch for Item R01-ITM06. Attribute capture required (INM::706)");
		LocationInventory.EnterItem(getDataFromFeature(getData("Item")));
		// ReceiveLPNLevel.enterQuantity(Integer.parseInt((String)
		// Variables.get(CurrentThreadInstance.getCurrentScenarioId() +
		// "CurrentOnhandQuantity")));
		ReceiveLPNLevel.searchInventory(getDataFromFeature(getData("InventoryTypeId")));
		ReceiveLPNLevel.searchProductStatus(getDataFromFeature(getData("ProductStatusId")));
		InventoryDetailsPage.clickConfirmButton();
		ReceiveLPNLevel.enterQuantity(Integer.parseInt(
				(String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "CurrentOnhandQuantity")));
	}

	@And("Click details button")
	public void clickDetailsButton() {
		CommonPage.clickDetailsbutton();
	}

	@Then("Verify Original and count quantity matches with No Varaince")
	public void verifyOriginalAndCountQuantityMatchesWithNoVaraince() {
		CommonMethods.waitForPageLoading();
		CommonPage.clickAddinfobutton();
		CommonMethods.waitForPageLoading();
		InventoryCountDetailsPage.verifyTheCountDetailsInInventoryCountDetailsPage();
	}

	@And("Extract List of Serial numbers from Inventory attributes")
	public void extractListOfSerialNumbersFromInventoryAttributes() {
		InventoryDetailsPage.extractListOfSerialNumbers();
	}

	@And("Select Particular inventory")
	public void selectParticularInventory() {
		InventoryDetailsPage.setByselectinvfirstrow();
		HeaderPanelPage.clickRelatedLinksButton();
		HeaderPanelPage.clickInventoryAttributes();
	}

	/*
	 * @And("Update ASN with ItemID Quantity Status And No Batch {string}") public
	 * void updateASNWithItemQtyAndStatusNoBatch(String fileName) throws Exception {
	 * String AsnId =
	 * ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(AsnId)")
	 * ); Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ASN",
	 * AsnId); FrameworkLogger.log(LogType.INFO, "Set value for ASNID : " + AsnId);
	 * ArrayList<String> al = new ArrayList<>(); al.add("Asn::2::3::" + AsnId);
	 * al.add("AsnLine::2::2::" + AsnId); al.add("AsnLine::2::7::" +
	 * getDataFromFeature("getdata(ItemID_Line_1)")); al.add("AsnLine::2::8::" +
	 * getDataFromFeature("getdata(OrdQty_Line1)")); al.add("AsnLine::2::19::" +
	 * getDataFromFeature("getdata(InventoryTypeID)")); al.add("AsnLine::2::20::" +
	 * getDataFromFeature("getdata(ProductStatusID)"));
	 *
	 * ExcelUtil1.setMultipleCellData(fileName, al);
	 *
	 * }
	 */
	@And("Update Original Order with serial number {string}")
	public void updateOriginalOrderWithSerialNumber(String fileName) throws Exception {
		String strOrderValue = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(OriginalOrderID)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder", strOrderValue);
		FrameworkLogger.log(LogType.INFO, "Set value for Original Order : " + strOrderValue);
		ArrayList<String> al = new ArrayList<>();
		al.add("OriginalOrder::2::3::" + strOrderValue);
		al.add("OriginalOrderLine::2::2::" + strOrderValue);
		al.add("OriginalOrderLine::2::6::" + getDataFromFeature("getdata(ItemID_Line_1)"));
		al.add("OriginalOrderLine::2::7::" + getDataFromFeature("getdata(OrdQty_Line1)"));
		al.add("OriginalOrderLine::2::9::" + getDataFromFeature("getdata(InventoryTypeID)"));
		al.add("OriginalOrderLine::2::10::" + getDataFromFeature("getdata(ProductStatusID)"));
		al.add("OriginalOrderLine::2::83::" + "SERIAL_NUMBER");
		al.add("OriginalOrderLine::2::84::"
				+ Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "SerialNumber1").toString());
		al.add("OriginalOrderLineAttributes::2::2::" + strOrderValue);
		al.add("OriginalOrderLineAttributes::2::4::" + "SERIAL_NUMBER");
		al.add("OriginalOrderLineAttributes::2::7::"
				+ Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "SerialNumber1").toString());
		al.add("OriginalOrderAttributes::2::2::" + strOrderValue);
		al.add("OriginalOrderAttributes::2::3::" + "SERIAL_NUMBER");
		al.add("OriginalOrderAttributes::2::6::"
				+ Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "SerialNumber1").toString());

		ExcelUtil1.setMultipleCellData(fileName, al);

	}

	@And("Verify Item ID Quantity And Serial Number for the Order")
	public void verifyItemID_Quantity_SerialNumberForOrder() {
		int orderLineQuantity = Integer.parseInt(getDataFromFeature("getdata(originalOrderLineQuantity)"));
		for (int i = orderLineQuantity; i >= 1; i--) {
			OriginalOrdersPage.selectDetailsForMultipleOrderLine(i);
			OriginalOrdersPage.expandOrderLineNeed();
			Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "OrderLineID" + i,
					OriginalOrdersPage.getOrderLineIDFromOrderLinePopUp());
			OriginalOrdersPage.orderHasItemIDInOrderLineNeed(getDataFromFeature("getdata(ItemID_Line_" + i + ")"));
			OriginalOrdersPage
					.orderHasQuantityInOrderLineNeed(getDataFromFeature("getdata(Order_Line_Quantity" + i + ")"));
			OriginalOrdersPage.orderHasSerialNumberInOrderLineNeed(
					Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "SerialNumber" + i).toString());
			OriginalOrdersPage.expandOrderLineAttributes();
			OriginalOrdersPage.orderHasSerialNumberInOrderLineAttributes(
					Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "SerialNumber" + i).toString());
			OriginalOrdersPage.closeOrderLine();
			FooterPanelPage.clickDeselectButton();
		}
	}

	@And("Verify wave Run specifies the Correct Quantity Item and Serial Number")
	public void verifyWaveRunHasQuantityItemAndSerialNumber() {
		int orderLineQuantity = Integer.parseInt(getDataFromFeature("getdata(orderLineQuantity)"));
		for (int i = 1; i <= orderLineQuantity; i++) {
			WaveRunsPage.clickOrderLineInAllocations(
					Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "OrderLineID" + i).toString());
//			WaveRunsPage.selectDetailsForMultipleOrderLine(i);
			WaveRunsPage.expandContainerOrQuantity();
			WaveRunsPage.checkContainerQuantity(getDataFromFeature("getdata(Order_Line_Quantity" + i + ")"));
			WaveRunsPage.expandItem();
			WaveRunsPage.allocationItemID(getDataFromFeature("getdata(ItemID_Line_" + i + ")"));
			WaveRunsPage.allocationItemHasSerialNumber(
					Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "SerialNumber" + i).toString());
			WaveRunsPage.closeAllocation();
			FooterPanelPage.clickDeselectButton();
		}
	}

	@And("Update ASN with one line And Batch Number {string}")
	public void updateASNWithOneLineWithBatch(String fileName) throws Exception {
		String AsnId = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(AsnId)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ASN", AsnId);
		FrameworkLogger.log(LogType.INFO, "Set value for ASNID : " + AsnId);
		ArrayList<String> al = new ArrayList<>();
		al.add("Asn::2::3::" + AsnId);
		al.add("AsnLine::2::2::" + AsnId);
		al.add("AsnLine::2::7::" + getDataFromFeature("getdata(ItemID_Line1)"));
		al.add("AsnLine::2::8::" + getDataFromFeature("getdata(Order_Line_Quantity1)"));
		al.add("AsnLine::2::10::"
				+ Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "BatchNumber1").toString());

		ExcelUtil1.setMultipleCellData(fileName, al);

	}

	@And("Update Original Order with one line with Batch {string}")
	public void updateOriginalOrderWithOneLineAndBatch(String fileName) throws Exception {
		String strOrderValue = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(OriginalOrderID)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder", strOrderValue);
		FrameworkLogger.log(LogType.INFO, "Set value for Original Order : " + strOrderValue);
		ArrayList<String> al = new ArrayList<>();
		al.add("OriginalOrder::2::3::" + strOrderValue);
		al.add("OriginalOrderLine::2::2::" + strOrderValue);
		al.add("OriginalOrderLine::2::11::"
				+ Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "BatchNumber1").toString());
		al.add("OriginalOrderLine::2::7::" + getDataFromFeature("getdata(Order_Line_Quantity1)"));

		ExcelUtil1.setMultipleCellData(fileName, al);

	}

	@And("Update Create ILPN detail")
	public void updateCreateIlpnDetails() {
		ASNs.selectASNsBreadcrumb();
		ASNs.selectCreateILPNs();
		ASNs.updateASNDetailsTable(getDataFromFeature(getData("StdLPNQty")));
		ASNs.enterExpirationDateInCreateIlpnTablePopUp();
		ASNs.selectConfirmCreateIlpns();
		ASNs.verifyCreateILPNsResult();
	}

	@And("Complete FN Standard Receiving")
	public void completeFNStandardReceiving() {
		ReceiveLPNLevel.searchASN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN").toString());
		ReceiveLPNLevel.enterLPN(
				Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ILPNIdAtFirstIndex").toString());
		ReceiveLPNLevel.verifyASNinFNStandardReceiving();
		ReceiveLPNLevel.verifyProceedASNYesinFNStandardReceiving();
		ReceiveLPNLevel.verifyRequestVerifyASN();
	}

	@And("Store Taskid to variable")
	public void storeTaskidToVariable() {
		TasksPage.storeTaskId();
	}

	/*
	 * @And("Validate LPN status and inventory details of first LPN") public void
	 * validateLPNStatusAndInventoryDetailsOfFirstLPN() { String text = (String)
	 * Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "lpn1Id");
	 * String PalletID = (String)
	 * Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "parentlpnId");
	 * ASNs.selectLPNAndVerifyLPNPresent(text, 1);
	 * ILPNs.verifystastusofEachLPN(text, "Not Allocated");
	 * ILPNs.verifyinventorydetailsofLPN(text, PalletID);
	 * ASNs.clickLPNSpagination(); }
	 */
	@And("Validate LPN status and inventory details of second LPN")
	public void validateLPNStatusAndInventoryDetailsOfSecondLPN() {
		String text = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "lpn2Id");
		String PalletID = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "parentlpnId");
		ASNs.selectLPNAndVerifyLPNPresent(text, 2);
		ILPNs.verifystastusofEachLPN(text, "Not Allocated");
		ILPNs.verifyinventorydetailsofLPN(text, PalletID);
		ASNs.clickLPNSpagination();
	}

	@And("Validate LPN status and inventory details of first LPN and second LPN")
	public void validateLPNStatusAndInventoryDetailsOfFirstLPN() {
		String text = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "lpn1Id");
		String PalletID = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "parentlpnId");
		ASNs.selectLPNAndVerifyLPNPresent(text, 1);
		ILPNs.verifystastusofEachLPN(text, "Not Allocated");
		ILPNs.verifyinventorydetailsofLPN(text, PalletID);
		ASNs.clickLPNSpagination();
		String text2 = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "lpn2Id");
		ASNs.selectLPNAndVerifyLPNPresent(text2, 2);
		ILPNs.verifystastusofEachLPN(text2, "Not Allocated");
		ILPNs.verifyinventorydetailsofLPN(text2, PalletID);
		ASNs.clickLPNSpagination();
	}

	@And("Validate LPN status and inventory details of parent Container")
	public void validateLPNStatusAndInventoryDetailsOfParentContainer() {
		String text = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "parentlpnId");
		String PalletID = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "parentlpnId");
		ASNs.selectLPNAndVerifyLPNPresent(text, 3);
		ILPNs.verifystastusofEachLPN(text, "Not Allocated");
		ILPNs.verifyinventorydetailsofparentContainer(text, PalletID);
	}

	@And("Enter Taskid")
	public void enterTaskid() {
		String taskId = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "TaskIdAtFirstIndex");
		TasksPage.enterTask(taskId);
		TasksPage.clickGoButton();
	}

	@And("Click on FNPackILPNDirected")
	public void clickOnFNPackILPNDirected() {
		FNPackILPNDirectedPage.clickFNPackILPNDirected();
	}

	@And("Complete FNPackILPNDirected Process")
	public void completeFNPackILPNDirectedProcess() {
		FNPackILPNDirectedPage.completeFNPackILPNDirectedProcess();
	}

	@And("Search Location with {string}")
	public void searchLocationWith(String location) {
		LeftPanelPage.searchLocation(getDataFromFeature(location));
	}

	@And("Store Quantity to variable {string}")
	public void storeQuantityToVariable(String variable) {
		StorageLocation.storeOnHandQuantity(variable);
	}

	@And("Verify LPN Status as {string}")
	public void verifyLPNStatusAs(String text) {
		ILPNs.verifyILPNStatusAtFirstIndex(getDataFromFeature(text));
	}

	@And("Verify LPN Status Code as {string}")
	public void verifyLPNStatusCodeAs(String text) {
		ILPNs.verifyILPNStatusCodeAtFirstIndex(getDataFromFeature(text));
	}

	@And("Verify LPN Total Quantity as {string}")
	public void verifyLPNTotalQuantityAs(String text) {
		// ILPNs.verifyILPNTotalQuantityAtFirstIndex(getDataFromFeature(text));
	}

	@And("Verify Quantity is matched with diff of {string} for {string} and {string}")
	public void verifyQuantityIsMatchedWithDiffOfForAnd(String diff, String beforeValue, String afterValue) {
		String bv = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + beforeValue);
		String av = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + afterValue);
		Integer df = Integer.valueOf(getDataFromFeature(diff));
		Integer actualDiff = Integer.parseInt(av) - Integer.parseInt(bv);
		if (actualDiff == df) {
			FrameworkLogger.log(LogType.PASS, "TotalQuantity value  Verification passed : " + diff);
		} else {
			FrameworkLogger.log(LogType.FAIL,
					"TotalQuantity value  Verification failed. Expected : " + diff + " , Actual :" + actualDiff);
		}
	}

	@And("Verify Quantity is matched with Difference")
	public void verify_quantity_is_matched_with_difference() {
		String bv = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "Before Quantity");
		String av = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "After Quantity");
		Integer df = Integer.valueOf(getDataFromFeature("getdata(Difference)"));
		Integer actualDiff = Integer.parseInt(av) - Integer.parseInt(bv);
		if (actualDiff == df) {
			FrameworkLogger.log(LogType.PASS, "Quantity difference verification passed, Before Quantity : " + bv
					+ ", After Quantity : " + av + ", Expected difference : " + df);
		} else {
			FrameworkLogger.log(LogType.FAIL,
					"Quantity difference Verification failed. Before Quantity : " + bv + ", After Quantity : " + av
							+ " Expected difference : " + df + " , Actual difference :" + actualDiff);
		}
	}

	@And("Navigate to ASN Homepage")
	public void navigateToASNHomepage() {
		SeleniumActions.switchToWindowUsingIndex(0);
		ASNs.selectASNsBreadcrumb();
		ASNs.verifyASNStatus("Verified");
	}

	@And("Verify Ilpn details in ILPNs")
	public void verifyILPNContentDetails() {
		ILPNs.verifyILPNStatusAtILPNs("Not Allocated");
		// ILPNs.openSlideOption(Variables.get(CurrentThreadInstance.getCurrentScenarioId()
		// + "ILPNIdAtFirstIndex").toString());
		// ILPNs.verifyILPNStatusAtILPNs( "Not Allocated" );
		// ILPNs.openSlideOption(null);
		ILPNs.clickILPNCardInILPN(
				Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ILPNIdAtFirstIndex").toString());
		// ILPNs.clickDetails();
		ILPNs.expandInventoryDetails();
		ILPNs.validateBatchNumberInLPNInventoryTable((getDataFromFeature("getdata(BatchNo_Line1)")));
		ILPNs.closeILPN();
		// ILPNs.closeSlideOption();
	}

	@And("Verify ASN content details in ASN Details page")
	public void verifyASNContentDetails() {
		ASNDetailsPage.verifyASNLineStatus("In Transit");
		ASNDetailsPage.openSlideOption();
		ASNDetailsPage.clickDetails();
		CommonMethods.waitForPageLoading();
		ASNDetailsPage.expandInventoryAttributes();
		ASNDetailsPage.getProductStatusAtInventoryAttributes();
		ASNDetailsPage.getInventoryTypeAtInventoryAttributes();
		ASNDetailsPage.getBatchNumberAtInventoryAttributes();
		ASNDetailsPage.expandInventoryDates();
		ASNDetailsPage.getExpiryDateAtInventoryDates();
		ASNDetailsPage.closeASNLinePopup();

	}

	@And("Update ASN import file with item outbound {string}")
	public void updateASNImportFileWithItemOutboundRCV(String fileName) {
		ExcelUtil1.verifyFilePresentfromuserdir(fileName);
		String AsnIdValue = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(ASN)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ASN", AsnIdValue);
		String strAsnIdValue = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN");
		ExcelUtil1.writeCellValueForColumnwoAppend(fileName, "Asn", "AsnId", strAsnIdValue);
		ExcelUtil1.writeCellValueForColumnwoAppend(fileName, "Asn", "AsnStatus", "1000");
		ExcelUtil1.writeCellValueForColumnboolean(fileName, "Asn", "VerificationAttempted", "FALSE");
		ExcelUtil1.writeCellValueForColumnwoAppend(fileName, "Asn", "ReceivedLpns", "0.000");
		ExcelUtil1.writeCellValueForColumnwoAppend(fileName, "AsnLine", "AsnId", strAsnIdValue);
		ExcelUtil1.writeCellValueForColumnwoAppend(fileName, "AsnLine", "ItemId",
				getDataFromFeature(getData("ItemID_Line1")));
		ExcelUtil1.writeCellValueForColumnwoAppend(fileName, "AsnLine", "InventoryTypeId",
				getDataFromFeature(getData("InventoryTypeId_Line1")));
		ExcelUtil1.writeCellValueForColumnwoAppend(fileName, "AsnLine", "ProductStatusId",
				getDataFromFeature(getData("ProductStatusId_Line1")));
		ExcelUtil1.deleteRowsfromSheet(fileName, "Lpn");
		ExcelUtil1.deleteRowsfromSheet(fileName, "LpnDetail");

	}

	@And("Verify ASN item outbound in ASN Details page")
	public void verifyASNDetailsItemOutbound() {
		ASNDetailsPage.verifyASNLineStatus("In Transit");
		ASNDetailsPage.storeItemIdAtFirstIndexToString();
		ASNDetailsPage.verifyShipQtyUnitAtFirstIndex();
		ASNDetailsPage.verifyProductStatusAtFirstIndex();
		ASNDetailsPage.verifyInventoryTypeAtFirstIndex();
	}

	@And("Verify Attribute Group item outbound in Items page")
	public void verifyAttributeGroupItemOutbound() {
		HomePage.navigateToItemsPage();
		LeftPanelPage.searchItem(getDataFromFeature(getData("ItemID_Line1")));
		ItemsPage.verifyAttributeGroupAtFirstIndex();
		ItemsPage.openSlideOption();
		FooterPanelPage.clickDetailsButton();
		ItemsPage.expandTrackingAttributes();
		ItemsPage.getTrackInventoryTypeAtTrackingAttributes();
		ItemsPage.getTrackProductStatusAtTrackingAttributes();
		ItemsPage.closeItemPopup();
	}

	@And("Complete ATStandardReceiving with Item Serial Number Outbound")
	public void complete_at_standard_receivingWithItemOutbound() {
		ReceiveLPNLevel.searchASN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN").toString());
		ReceiveLPNLevel.enterLPN(ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(LPNId)")));
		ReceiveLPNLevel.enterScanItem(getDataFromFeature(getData("ItemIDcode_Line1")));
		ReceiveLPNLevel.verifyInventoryTypeIdDisplayed();
		ReceiveLPNLevel.verifyProductStatusIdDisplayed();
		ReceiveLPNLevel.enterQuantity(Integer.parseInt(
				(String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ShipQtyUnitAtFirstIndex")));
		ReceiveLPNLevel.verifyASNinFNTrolleyReceiving();
		ReceiveLPNLevel.verifyRequestVerifyASN();
		SeleniumActions.switchToWindowUsingIndex(0);
		CommonMethods.waitForPageLoading();
	}

	@And("Verify Ilpn details of item outbound in ILPNs")
	public void verifyILPNDetailsOfItemOutbound() {
		ILPNs.verifyILPNStatusAtILPNs("Not Allocated");
		ILPNs.captureILPNSNumber();
		ILPNs.openSlideOption(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "LPN").toString());
		ILPNs.clickDetails();
		ILPNs.expandInventoryDetails();
		ILPNs.validateProductStatusAndInventoryType(getDataFromFeature("getdata(ProductStatusCodeId_Line1)"),
				getDataFromFeature("getdata(InventoryTypeId_Line1)"));
		ILPNs.closeILPN();
		ILPNs.closeSlideOption();

	}

	@And("Update Two Line ASN with ItemID Quantity Status And No Batch {string}")

	public void updateTwoLineASNWithItemQtyAndStatusNoBatch(String fileName) throws Exception {
		String AsnId = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(AsnId)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ASN", AsnId);
		FrameworkLogger.log(LogType.INFO, "Set value for ASNID : " + AsnId);
		ArrayList<String> al = new ArrayList<>();
		al.add("Asn::2::3::" + AsnId);
		al.add("AsnLine::2::2::" + AsnId);
		al.add("AsnLine::2::7::" + getDataFromFeature("getdata(ItemID_Line_1)"));
		al.add("AsnLine::2::8::" + getDataFromFeature("getdata(OrdQty_Line1)"));
		al.add("AsnLine::2::19::" + getDataFromFeature("getdata(InventoryTypeID)"));
		al.add("AsnLine::2::20::" + getDataFromFeature("getdata(ProductStatusID)"));
		al.add("AsnLine::3::2::" + AsnId);
		al.add("AsnLine::3::7::" + getDataFromFeature("getdata(ItemID_Line_2)"));
		al.add("AsnLine::3::8::" + getDataFromFeature("getdata(OrdQty_Line2)"));
		al.add("AsnLine::3::19::" + getDataFromFeature("getdata(InventoryTypeID)"));
		al.add("AsnLine::3::20::" + getDataFromFeature("getdata(ProductStatusID)"));

		ExcelUtil1.setMultipleCellData(fileName, al);

	}

	@And("Update Original Order with serial number two lines {string}")
	public void updateOriginalOrderWithSerialNumberTwoLines(String fileName) throws Exception {
		String strOrderValue = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(OriginalOrderID)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder", strOrderValue);
		FrameworkLogger.log(LogType.INFO, "Set value for Original Order : " + strOrderValue);
		ArrayList<String> al = new ArrayList<>();
		al.add("OriginalOrder::2::3::" + strOrderValue);
		al.add("OriginalOrderLine::2::2::" + strOrderValue);
		al.add("OriginalOrderLine::2::6::" + getDataFromFeature("getdata(ItemID_Line_1)"));
		al.add("OriginalOrderLine::2::7::" + getDataFromFeature("getdata(Order_Line_Quantity1)"));
		al.add("OriginalOrderLine::2::9::" + getDataFromFeature("getdata(InventoryTypeID)"));
		al.add("OriginalOrderLine::2::10::" + getDataFromFeature("getdata(ProductStatusID)"));
		al.add("OriginalOrderLine::2::83::" + "SERIAL_NUMBER");
		al.add("OriginalOrderLine::2::84::"
				+ Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "SerialNumber1").toString());
		al.add("OriginalOrderLineAttributes::2::2::" + strOrderValue);
		al.add("OriginalOrderLineAttributes::2::4::" + "SERIAL_NUMBER");
		al.add("OriginalOrderLineAttributes::2::7::"
				+ Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "SerialNumber1").toString());
		al.add("OriginalOrderAttributes::2::2::" + strOrderValue);
		al.add("OriginalOrderAttributes::2::3::" + "SERIAL_NUMBER");
		al.add("OriginalOrderAttributes::2::6::"
				+ Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "SerialNumber1").toString());

//      second line
		al.add("OriginalOrderLine::3::2::" + strOrderValue);
		al.add("OriginalOrderLine::3::6::" + getDataFromFeature("getdata(ItemID_Line_2)"));
		al.add("OriginalOrderLine::3::7::" + getDataFromFeature("getdata(Order_Line_Quantity2)"));
		al.add("OriginalOrderLine::3::9::" + getDataFromFeature("getdata(InventoryTypeID)"));
		al.add("OriginalOrderLine::3::10::" + getDataFromFeature("getdata(ProductStatusID)"));
		al.add("OriginalOrderLine::3::83::" + "SERIAL_NUMBER");
		al.add("OriginalOrderLine::3::84::"
				+ Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "SerialNumber2").toString());
		al.add("OriginalOrderLineAttributes::3::2::" + strOrderValue);
		al.add("OriginalOrderLineAttributes::3::4::" + "SERIAL_NUMBER");
		al.add("OriginalOrderLineAttributes::3::7::"
				+ Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "SerialNumber2").toString());
		al.add("OriginalOrderAttributes::3::2::" + strOrderValue);
		al.add("OriginalOrderAttributes::3::3::" + "SERIAL_NUMBER");
		al.add("OriginalOrderAttributes::3::6::"
				+ Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "SerialNumber2").toString());

		ExcelUtil1.setMultipleCellData(fileName, al);

	}

	@And("Validate Orderslines statuses {string}")
	public void validate_orderslines_statuses(String strOrderStatus) {
		OriginalOrdersPage.verifyOrderLinesStatuses(strOrderStatus);
	}

	@And("Update  ILPN level ASN with three line And Batch Number and ExpiryDate {string}")
	public void updateILPNLevelASNWithThreeLineAndBatchNumberAndExpiryDate(String fileName) throws Exception {
		String asnId = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(ASN)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ASN", asnId);
		FrameworkLogger.log(LogType.INFO, "Set value for ASN : " + asnId);
		String lpnId = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(LPN)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN1", lpnId + 1);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN2", lpnId + 2);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN3", lpnId + 3);
		FrameworkLogger.log(LogType.INFO, "Set value for LPN1 : " + lpnId + 1);
		FrameworkLogger.log(LogType.INFO, "Set value for LPN2 : " + lpnId + 2);
		FrameworkLogger.log(LogType.INFO, "Set value for LPN3 : " + lpnId + 3);
		List<String> listOfILPNs = new ArrayList<>();
		listOfILPNs.add(lpnId + 1);
		listOfILPNs.add(lpnId + 2);
		listOfILPNs.add(lpnId + 3);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "listOfILPNs", listOfILPNs);
		String lpns = String.join(",", listOfILPNs);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "lpns", lpns);
		ArrayList<String> al = new ArrayList<>();
		al.add("Asn::2::3::" + asnId);
		al.add("Lpn::2::2::" + lpnId + 1);
		al.add("Lpn::3::2::" + lpnId + 2);
		al.add("Lpn::4::2::" + lpnId + 3);
		al.add("Lpn::2::6::" + asnId);
		al.add("Lpn::3::6::" + asnId);
		al.add("Lpn::4::6::" + asnId);
		al.add("LpnDetail::2::2::" + lpnId + 1);
		al.add("LpnDetail::3::2::" + lpnId + 2);
		al.add("LpnDetail::4::2::" + lpnId + 3);
		ExcelUtil1.setMultipleCellData(fileName, al);
	}

	@And("Complete ATStandardReceiving three lines of ILPN")
	public void completeATStandardReceivingThreeLinesOfILPN() {
		ReceiveLPNLevel.completeATStandarReceivingwithILPNthreelines();
	}

	/*
	 * @And("Update Location in {string}") public void updateLocationIn(String
	 * fileName) throws Exception { String location =
	 * ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature(
	 * "getdata(Location)")); Faker f = new Faker(); String text =
	 * f.name().firstName().substring(0, 2).toUpperCase(); location = location +
	 * text; Variables.set(CurrentThreadInstance.getCurrentScenarioId() +
	 * "Location", location); FrameworkLogger.log(LogType.INFO,
	 * "Set value for Location : " + location); ArrayList<String> al = new
	 * ArrayList<>(); al.add("Location::2::3::" + location); String
	 * locationReferenceKey = location.split("-")[0] + "--" + location.split("-")[2]
	 * + "-" + location.split("-")[3]; al.add("Location::2::5::" +
	 * locationReferenceKey); al.add("Location::2::6::" + location.replaceAll("-",
	 * "")); al.add("Location::2::9::" + location); al.add("Location::2::15::" +
	 * location.split("-")[0]); al.add("Location::2::17::" +
	 * location.split("-")[1]); al.add("Location::2::18::" +
	 * location.split("-")[2]); al.add("Location::2::19::" +
	 * location.split("-")[3]); ExcelUtil1.setMultipleCellData(fileName, al); }
	 */

	@And("Update ASN export file with LPN Receiving no Parent LPN {string}")
	public void updateASNExportFileWithLPNReceivingNoParentLPN(String fileName) throws Exception {
		String asnId = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(ASN)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ASN", asnId);
		FrameworkLogger.log(LogType.INFO, "Set value for ASN : " + asnId);
		String LPNIdValue = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(LPNId)"));

		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "lpn1Id", LPNIdValue + 1);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "lpn2Id", LPNIdValue + 2);
		FrameworkLogger.log(LogType.INFO, "Set value for LPN1 : " + LPNIdValue + 1);
		FrameworkLogger.log(LogType.INFO, "Set value for LPN2 : " + LPNIdValue + 2);

		ArrayList<String> al = new ArrayList<>();
		al.add("Asn::2::3::" + asnId);
		al.add("AsnLine::2::2::" + asnId);
		al.add("AsnLine::3::2::" + asnId);
		al.add("Lpn::2::2::" + LPNIdValue + 1);
		al.add("Lpn::3::2::" + LPNIdValue + 2);
		al.add("Lpn::2::6::" + asnId);
		al.add("Lpn::3::6::" + asnId);
		al.add("LpnDetail::2::2::" + LPNIdValue + 1);
		al.add("LpnDetail::3::2::" + LPNIdValue + 2);
		ExcelUtil1.setMultipleCellData(fileName, al);

	}

	@And("Validate LPN status and inventory details of first and second LPN wo parent")
	public void validateLPNStatusAndInventoryDetailsOfFirstLPNWoParent() {
		String text = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "lpn1Id");
		ASNs.selectLPNAndVerifyLPNPresent(text, 1);
		ILPNs.verifystastusofEachLPN(text, "Not Allocated");
		ILPNPopupPage.verifyInventorycontainer(text);
		ILPNPopupPage.verifyProductStatusinpop(getDataFromFeature("getData(ProductStatus_Line1)"));
		ILPNPopupPage.verifyInventorytypeinpop(getDataFromFeature("getData(inventory_Line1)"));
		ILPNPopupPage.verifyOnHandQuantity(getDataFromFeature("getData(OrdQty_Line1)"));
		ILPNPopupPage.verifyItem(getDataFromFeature("getData(ItemID_Line1)"));
		ILPNPopupPage.verifyBatchNumber(getDataFromFeature("getData(BatchNo_Line1)"));
		ASNs.clickLPNSpagination();
		String text1 = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "lpn1Id");
		ASNs.selectLPNAndVerifyLPNPresent(text1, 1);
		ILPNs.verifystastusofEachLPN(text1, "Not Allocated");
		ILPNPopupPage.verifyInventorycontainer(text1);
		ILPNPopupPage.verifyProductStatusinpop(getDataFromFeature("getData(ProductStatus_Line2)"));
		ILPNPopupPage.verifyInventorytypeinpop(getDataFromFeature("getData(inventory_Line2)"));
		ILPNPopupPage.verifyOnHandQuantity(getDataFromFeature("getData(OrdQty_Line2)"));
		ILPNPopupPage.verifyItem(getDataFromFeature("getData(ItemID_Line2)"));
		ILPNPopupPage.verifyBatchNumber(getDataFromFeature("getData(BatchNo_Line2)"));
	}

	@And("Update Location in {string}")
	public void updateLocationIn(String fileName) throws Exception {
		String location = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(Location)"));
		Faker f = new Faker();
		String text = f.name().firstName().substring(0, 2).toUpperCase();
		location = location + text;
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "Location", location);
		FrameworkLogger.log(LogType.INFO, "Set value for Location : " + location);
		ArrayList<String> al = new ArrayList<>();
		al.add("Location::2::3::" + location);
		String locationReferenceKey = location.split("-")[0] + "--" + location.split("-")[1] + "-"
				+ location.split("-")[2];
		al.add("Location::2::5::" + locationReferenceKey);
		al.add("Location::2::6::" + location.replaceAll("-", ""));
		al.add("Location::2::9::" + location);
		al.add("Location::2::15::" + location.split("-")[0]);
		al.add("Location::2::17::" + location.split("-")[1]);
		al.add("Location::2::18::" + location.split("-")[2]);
		al.add("Location::2::19::" + location.split("-")[3]);
		ExcelUtil1.setMultipleCellData(fileName, al);
	}

	@And("Click on Related Links")
	public void clickOnRelatedLinks() {
		HeaderPanelPage.clickRelatedLinksButton();
	}

	@And("Click on Location Capacity usage")
	public void clickOnLocationCapacityUsage() {
		HeaderPanelPage.clickLocationCapacityUsageLink();
	}

	@And("Search Location with variable {string} value")
	public void searchLocationWithVariableValue(String text) {
		String location = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + text);
		LeftPanelPage.searchLocation(location);
	}

	@And("Store {string} and {string} from location popup")
	public void storeAndFromLocationPopup(String maxWeight, String maxVolume) {
		StorageLocation.storeMaxWeightAndMaxVolumeFromLocationPopup(maxWeight, maxVolume);
	}

	@And("Store {string} and {string} from location capacity usage page")
	public void storeAndFromLocationCapacityUsagePage(String currentWeight, String currentVolume) {
		LocationCapacityUsagePage.storeCurrentWeightAndCurrentVolumeFromLocationPopup(currentWeight, currentVolume);
	}

	@And("Store {string} and {string} for location")
	public void storeAndForLocation(String availableWeight, String availableVolume) {
		String maxWeightValue = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "MaxWeight");
		String maxVolumeValue = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "MaxVolume");

		String CurrentWeightValue = (String) Variables
				.get(CurrentThreadInstance.getCurrentScenarioId() + "CurrentWeight");
		String CurrentVolumeValue = (String) Variables
				.get(CurrentThreadInstance.getCurrentScenarioId() + "CurrentVolume");

		Float availableWeightValue = Float.valueOf(maxWeightValue) - Float.valueOf(CurrentWeightValue);
		Float availableVolumeValue = Float.valueOf(maxVolumeValue) - Float.valueOf(CurrentVolumeValue);
		FrameworkLogger.log(LogType.INFO, "Available Weight stored in variable, variable name: " + availableWeight
				+ ", variable value: " + availableWeightValue);

		FrameworkLogger.log(LogType.INFO, "Available Volume stored in variable, variable name: " + availableVolume
				+ ", variable value: " + availableVolumeValue);

		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + availableWeight, availableWeightValue);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + availableVolume, availableVolumeValue);
	}

	@And("Add Item {string} to Location")
	public void addItemToLocation(String item) {
		StorageLocation.addItemToLocation(getDataFromFeature(item));
	}

	@Then("Verify LPN Volume is Greater than Location available Volume")
	public void verifyLPNVolumeIsGreaterThanLocationAvailableVolume() {
		ILPNPopupPage.verifyLPNVolumeIsGreaterThanLocationAvailableVolume();
	}

	@Then("Verify LPN Weight and Volume are Less than Location available Weight and Volume")
	public void verifyLPNWeightAndVolumeAreLessThanLocationAvailableWeightAndVolume() {
		ILPNPopupPage.verifyLPNWeightAndVolumeAreLessThanLocationAvailableWeightAndVolume();
	}

	@Then("Verify PutWay Zone as {string} at index {string}")
	public void verifyPutWayZoneAsGetdataPutawayZoneAtIndex(String text, String index) {
		PutAwayPlanningStrategyPage.verifyPutAwayZone(getDataFromFeature(text), index);

	}

	@Then("Verify {string} is redirected to {string} location")
	public void verifyIsRedirectedToLocation(String lpn, String location) {
		if (location.contains("getdata")) {
			location = getDataFromFeature(location);
		}
		CommonWMMobilePage.verifyLPNIsRedirectedToLocation(
				(String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + lpn), location);
	}

	@And("Update ItemId Item Master import file with file by {string}")
	public void updateItemIdImportFileWithPacking(String fileName) throws Exception {
		ExcelUtil1.verifyFilePresentfromuserdir(fileName);

		String ItemIdValue1 = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(ItemId_Line1)"));
		String ItemIdValue2 = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(ItemId_Line2)"));
//Commented below code by lohith on 13 Nov 2023 during merge conflict
//		String ItemIdValue1 = getDataFromFeature("getdata(ItemId_Line1)");
//		String ItemIdValue2 = getDataFromFeature("getdata(ItemId_Line2)");

		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "Item1Id", ItemIdValue1);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "Item2Id", ItemIdValue2);
		FrameworkLogger.log(LogType.INFO, "Set value for Item Id 1: " + ItemIdValue1);
		FrameworkLogger.log(LogType.INFO, "Set value for Item Id 2: " + ItemIdValue2);
		ArrayList<String> al = new ArrayList<>();
		al.add("Item::2::3::" + ItemIdValue1);
		al.add("Item::3::3::" + ItemIdValue2);
		al.add("ItemCode::2::2::" + ItemIdValue1);
		al.add("ItemCode::2::3::" + getDataFromFeature(getData("ItemCodeType")));
		al.add("ItemCode::2::4::" + getDataFromFeature(getData("ItemIdCodeValue_Line1")));
		al.add("ItemCode::3::2::" + ItemIdValue2);
		al.add("ItemCode::3::3::" + getDataFromFeature(getData("ItemCodeType")));
		al.add("ItemCode::3::4::" + getDataFromFeature(getData("ItemIdCodeValue_Line2")));
		al.add("ItemPackage::2::2::" + ItemIdValue1);
		al.add("ItemPackage::2::3::" + getDataFromFeature(getData("StdQtyUomIdPack")));
		al.add("ItemPackage::2::4::" + getDataFromFeature(getData("QuantityPack")));
		al.add("ItemPackage::3::2::" + ItemIdValue1);
		al.add("ItemPackage::3::3::" + getDataFromFeature(getData("StdQtyUomIdPallet")));
		al.add("ItemPackage::3::4::" + getDataFromFeature(getData("QuantityPallet")));
		al.add("ItemPackage::4::2::" + ItemIdValue2);
		al.add("ItemPackage::4::3::" + getDataFromFeature(getData("StdQtyUomIdPack")));
		al.add("ItemPackage::4::4::" + getDataFromFeature(getData("QuantityPack")));
		al.add("ItemPackage::5::2::" + ItemIdValue2);
		al.add("ItemPackage::5::3::" + getDataFromFeature(getData("StdQtyUomIdPallet")));
		al.add("ItemPackage::5::4::" + getDataFromFeature(getData("QuantityPallet")));
		ExcelUtil1.setMultipleCellData(fileName, al);
	}

	@And("Update ASN in {string}")
	public void updateASNIn(String fileName) throws Exception {
		String asnId = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(ASN)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ASN", asnId);
		FrameworkLogger.log(LogType.INFO, "Set value for ASN : " + asnId);
		String lpnId = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(LPN)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "lpn1Id", lpnId + 1);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "lpn2Id", lpnId + 2);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "parentlpnId", lpnId + 3);
		FrameworkLogger.log(LogType.INFO, "Set value for lpn1Id : " + lpnId + 1);
		FrameworkLogger.log(LogType.INFO, "Set value for lpn2Id : " + lpnId + 2);
		FrameworkLogger.log(LogType.INFO, "Set value for parentlpnId : " + lpnId + 3);
		ArrayList<String> al = new ArrayList<>();
		al.add("Asn::2::3::" + asnId);
		al.add("Lpn::2::2::" + lpnId + 1);
		al.add("Lpn::3::2::" + lpnId + 2);
		al.add("Lpn::4::2::" + lpnId + 3);
		al.add("Lpn::2::6::" + asnId);
		al.add("Lpn::3::6::" + asnId);
		al.add("Lpn::4::6::" + asnId);
		al.add("Lpn::2::16::" + lpnId + 3);
		al.add("Lpn::3::16::" + lpnId + 3);
		al.add("LpnDetail::2::2::" + lpnId + 1);
		al.add("LpnDetail::3::2::" + lpnId + 2);
		ExcelUtil1.setMultipleCellData(fileName, al);
	}

	@Then("Verify Parent and Child Lpn details in ILPN Page")
	public void verifyParentAndChildLpnDetailsInILPNPage() {
		HeaderPanelPage.clickRelatedLinksButton();
		HeaderPanelPage.clickLPNInventory();
		ILPNs.verifyParentAndChildLpnDetailsInILPNPage();
	}

	@And("Completed AT Pallet PutAway System Directed with {string}")
	public void completedATPalletPutAwaySystemDirectedWith(String lpn) {
		lpn = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + lpn);
		ATPalletPutAwaySystemDirected.completeATPalletPutAwaySystemDirected(lpn);
	}

	@And("Search ASN with Variable Name {string}")
	public void searchASNWithVariableName(String name) {
		LeftPanelPage.searchASN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + name).toString());
	}

	@Then("Verify ILPNs linked to ASN {string} AT Pallet PutAway System Directed")
	public void verifyILPNsLinkedToASNATPalletPutAwaySystemDirected(String text) {
		ILPNs.verifyILPNsLinkedToASNATPalletPutAwaySystemDirected(text);
	}

	@Then("Verify Container planning mode")
	public void verifyContainerPlanningMode() {
		PutAwayPlanningStrategyPage.verifyContainerPlanningMode();
	}

	@And("Verify Item Id exist")
	public void verifyItemExist() {
		ItemsPage.verifyItemsDisplayed();
	}

	@And("Create {string} iLPNs")
	public void createILPNs(String count) {
		CreateILPN.createILPNs(Integer.valueOf(getDataFromFeature(count)));
	}

	@And("Click on View button for {string} PutAway Priority")
	public void clickOnViewButtonForPutAwayPriority(String putAway) {
		if (putAway.contains("getdata")) {
			putAway = getDataFromFeature(putAway);
		}
		if (putAway.equalsIgnoreCase("UNIT")) {
			PutAwayPlanningStrategyPage.clickCloseIconForUnitPutAwayPriorityItem();
		} else if (putAway.equalsIgnoreCase("LPN")) {
			PutAwayPlanningStrategyPage.clickCloseIconForLPNPutAwayPriorityItem();
		}
		PutAwayPlanningStrategyPage.clickViewButton2();
	}

	@And("Click on Finish button")
	public void clickOnFinishButton() {
		PutAwayPlanningStrategyPage.clickFinishButton();
	}

	@And("Create {string} iLPNs with Batch Number")
	public void createGetdataILPNCountILPNsWithBatchNumber(String count) {
		CreateILPN.createILPNsWithBachNumber(Integer.valueOf(getDataFromFeature(count)));
	}

	@And("Create {string} iLPNs with Serial Number")
	public void createGetdataILPNCountILPNsWithSerialNumber(String count) {
		CreateILPN.createILPNsWithSerialNumber(Integer.valueOf(getDataFromFeature(count)));
	}

	@And("Complete FN LPN Receiving without parent Container")
	public void completeFNLPNReceivingWithoutParentContainer() {
		ReceiveLPNLevel.completeFNLPNReceivingw0parentcontainer();
	}

	@And("Update ASN import file with Item Id LPN Packing by file {string}")
	public void updateASNImportFileWithLPNPacking(String fileName) throws Exception {
		String AsnIdValue = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(ASN)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ASN", AsnIdValue);
		String strAsnIdValue = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN");
		FrameworkLogger.log(LogType.INFO, "Set value for ASN Id : " + strAsnIdValue);

		String LpnIdValue1 = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(LPNId_Line1)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "Lpn1Id", LpnIdValue1);
		FrameworkLogger.log(LogType.INFO, "Set value for LPN 1 Id : " + LpnIdValue1);

		String LpnIdValue2 = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(LPNId_Line2)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "Lpn2Id", LpnIdValue2);

//		ExcelUtil1.writeCellValueForColumntoparticularrow(fileName, "Lpn", "LpnId", LpnIdValue1, 1);
//		ExcelUtil1.writeCellValueForColumntoparticularrow(fileName, "Lpn", "LpnId", LpnIdValue2, 2);
//		ExcelUtil1.writeCellValueForColumntoparticularrow(fileName, "Lpn", "AsnId", strAsnIdValue, 1);
//		ExcelUtil1.writeCellValueForColumntoparticularrow(fileName, "Lpn", "AsnId", strAsnIdValue, 2);
//		ExcelUtil1.writeCellValueForColumntoparticularrow(fileName, "LpnDetail", "Lpn.LpnId", LpnIdValue1, 1);
//		ExcelUtil1.writeCellValueForColumntoparticularrow(fileName, "LpnDetail", "Lpn.LpnId", LpnIdValue2, 2);
//		ExcelUtil1.emptyCellValueForColumn(fileName, "LpnDetail", "LpnDetailId");
//		ExcelUtil1.writeCellValueForColumntoparticularrow(fileName, "LpnDetail", "ItemId",
//				getDataFromFeature(getData("ItemId_Line1")), 1);
//		ExcelUtil1.writeCellValueForColumntoparticularrow(fileName, "LpnDetail", "ItemId",
//				getDataFromFeature(getData("ItemId_Line2")), 2);
//
//		String ShippedQtyValueLine1 = ExcelUtil1
//				.convert_variable_to_timestamp(getDataFromFeature("getdata(ShippedQty_Line1)"));
//		String ShippedQtyValueLine2 = ExcelUtil1
//				.convert_variable_to_timestamp(getDataFromFeature("getdata(ShippedQty_Line2)"));
//		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ShippedQtyValue1", ShippedQtyValueLine1);
//		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ShippedQtyValue2", ShippedQtyValueLine2);
//		ExcelUtil1.writeCellValueForColumntoparticularrow(fileName, "LpnDetail", "ShippedQuantity",
//				ShippedQtyValueLine1, 1);
//		ExcelUtil1.writeCellValueForColumntoparticularrow(fileName, "LpnDetail", "ShippedQuantity",
//				ShippedQtyValueLine2, 2);
//Commented below code by lohith on 13 Nov 2023 during merge conflict
		/*
		 * String ShippedQtyLine1 = getDataFromFeature("getdata(ShippedQty_Line1)");
		 * String ShippedQtyLine2 = getDataFromFeature("getdata(ShippedQty_Line2)");
		 * Variables.set(CurrentThreadInstance.getCurrentScenarioId() +
		 * "ShippedQtyValue1", ShippedQtyLine1);
		 * Variables.set(CurrentThreadInstance.getCurrentScenarioId() +
		 * "ShippedQtyValue2", ShippedQtyLine2);
		 * ExcelUtil1.writeCellValueForColumntoparticularrow(fileName, "LpnDetail",
		 * "ShippedQuantity", ShippedQtyLine1, 1);
		 * ExcelUtil1.writeCellValueForColumntoparticularrow(fileName, "LpnDetail",
		 * "ShippedQuantity", ShippedQtyLine2, 2);
		 */

		FrameworkLogger.log(LogType.INFO, "Set value for LPN 2 Id : " + LpnIdValue2);

		String ShippedQtyLine1 = getDataFromFeature("getdata(ShippedQty_Line1)");
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ShippedQtyValue1", ShippedQtyLine1);
		FrameworkLogger.log(LogType.INFO, "Set value for Shipped Quantity value : " + ShippedQtyLine1);

		String ShippedQtyLine2 = getDataFromFeature("getdata(ShippedQty_Line2)");
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ShippedQtyValue2", ShippedQtyLine2);
		FrameworkLogger.log(LogType.INFO, "Set value for Shipped Quantity value : " + ShippedQtyLine2);

		ArrayList<String> al = new ArrayList<>();
		al.add("Asn::2::3::" + strAsnIdValue);
		al.add("Asn::2::8::" + "1000");
		al.add("Asn::2::24::" + "0.000");
		al.add("Lpn::2::2::" + LpnIdValue1);
		al.add("Lpn::2::6::" + strAsnIdValue);
		al.add("Lpn::3::2::" + LpnIdValue2);
		al.add("Lpn::3::6::" + strAsnIdValue);
		al.add("LpnDetail::2::2::" + LpnIdValue1);
		al.add("LpnDetail::2::6::" + getDataFromFeature(getData("ItemId_Line1")));
		al.add("LpnDetail::2::9::" + ShippedQtyLine1);
		al.add("LpnDetail::3::2::" + LpnIdValue2);
		al.add("LpnDetail::3::6::" + getDataFromFeature(getData("ItemId_Line2")));
		al.add("LpnDetail::3::9::" + ShippedQtyLine2);
		ExcelUtil1.setMultipleCellData(fileName, al);
	}

	@And("Complete ATStandardReceiving with Item Packing")
	public void completeATStandardReceivingWithItemPacking() {
		String asn = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN");
		String lpn1 = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "Lpn1Id");
		String lpn2 = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "Lpn2Id");
		ATStandardReceiving.completeATStandardReceivingWithTwoLpn(asn, lpn1, lpn2);

	}

	@And("Complete ATUserDirectedPutaway with Item Packing for line 1 and line 2")
	public void completeATUserDirectedPutawayWithItemPacking() {
		String iLPN1 = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "Lpn1Id");
		String quantityLine1 = (String) Variables
				.get(CurrentThreadInstance.getCurrentScenarioId() + "ShippedQtyValue1");
		String locationInventory1 = getDataFromFeature("getdata(ScanLocation_Line1)");
		String iLPN2 = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "Lpn2Id");
		String quantityLine2 = (String) Variables
				.get(CurrentThreadInstance.getCurrentScenarioId() + "ShippedQtyValue2");
		String locationInventory2 = getDataFromFeature("getdata(ScanLocation_Line2)");
		UserDirected.searchLPN(iLPN1);
		UserDirected.enterQuantity(quantityLine1);
		UserDirected.enterScanLocation(locationInventory1);
		UserDirected.searchLPN(iLPN2);
		UserDirected.enterQuantity(quantityLine2);
		UserDirected.enterScanLocation(locationInventory2);
	}

	@And("Filter Item is exist in InventoryDetails")
	public void verifyFilterByItemDetailsExistAtInventoryDetails() {
		// InventoryDetailsPage.minimizeFilterButton();
		InventoryDetailsPage.searchItemId(getDataFromFeature("getdata(ItemId_Line1)"));
		InventoryDetailsPage.enterDisplayLocation(getDataFromFeature("getdata(Display_Location)"));
		InventoryDetailsPage.filterInventoryContainerType(getDataFromFeature("getdata(InventoryContainerType)"));
		InventoryDetailsPage.searchBatchNumber(getDataFromFeature("getdata(BatchNo_Line1)"));
	}

	@And("Update Original Order 2.0 import file with Item Id LPN Packing by file {string}")
	public void updateOriginalOrderImportFileWithItemLPNPacking(String fileName) throws Exception {
		String OrderIdValue = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(OriginalOrder)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder", OrderIdValue);
		String strOrderIdValue = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder");

//		ExcelUtil1.writeCellValueForColumnwoAppend(fileName, "OriginalOrder", "OriginalOrderId", strOrderIdValue);
//		ExcelUtil1.writeCellValueForColumntoparticularrow(fileName, "OriginalOrderLine",
//				"OriginalOrder.OriginalOrderId", strOrderIdValue, 1);
//		ExcelUtil1.writeCellValueForColumntoparticularrow(fileName, "OriginalOrderLine",
//				"OriginalOrder.OriginalOrderId", strOrderIdValue, 2);
//		ExcelUtil1.writeCellValueForColumntoparticularrow(fileName, "OriginalOrderLine", "OriginalOrderLineId", "'01",
//				1);
//		ExcelUtil1.writeCellValueForColumntoparticularrow(fileName, "OriginalOrderLine", "OriginalOrderLineId", "'02",
//				2);
//		ExcelUtil1.writeCellValueForColumntoparticularrow(fileName, "OriginalOrderLine", "ItemId",
//				getDataFromFeature(getData("ItemId_Line1")), 1);
//		ExcelUtil1.writeCellValueForColumntoparticularrow(fileName, "OriginalOrderLine", "ItemId",
//				getDataFromFeature(getData("ItemId_Line2")), 2);
		String ShippedQtyValueLine1 = getDataFromFeature("getdata(ShippedQty_Line1)");
		String ShippedQtyValueLine2 = getDataFromFeature("getdata(ShippedQty_Line2)");

		FrameworkLogger.log(LogType.INFO, "Set value for Original Order Id : " + strOrderIdValue);

		// String ShippedQtyValueLine1 =
		// getDataFromFeature("getdata(ShippedQty_Line1)");

		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ShippedQtyValue1", ShippedQtyValueLine1);
		FrameworkLogger.log(LogType.INFO, "Set value for Shipped Quantity value : " + ShippedQtyValueLine1);

		// String ShippedQtyValueLine2 =
		// getDataFromFeature("getdata(ShippedQty_Line2)");
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ShippedQtyValue2", ShippedQtyValueLine2);
		FrameworkLogger.log(LogType.INFO, "Set value for Shipped Quantity value : " + ShippedQtyValueLine2);

		ArrayList<String> al = new ArrayList<>();
		al.add("OriginalOrder::2::3::" + strOrderIdValue);
		al.add("OriginalOrderLine::2::2::" + strOrderIdValue);
		al.add("OriginalOrderLine::2::3::" + "'01");
		al.add("OriginalOrderLine::2::6::" + getDataFromFeature(getData("ItemId_Line1")));
		al.add("OriginalOrderLine::2::7::" + ShippedQtyValueLine1);
		al.add("OriginalOrderLine::3::2::" + strOrderIdValue);
		al.add("OriginalOrderLine::3::3::" + "'02");
		al.add("OriginalOrderLine::3::6::" + getDataFromFeature(getData("ItemId_Line2")));
		al.add("OriginalOrderLine::3::7::" + ShippedQtyValueLine2);
		ExcelUtil1.setMultipleCellData(fileName, al);

	}

	@And("Verify Item Id and Order Quantity at Original Order 2.0 in Order Lines Page")
	public void verifyItemIdAndOrderQtyInOrderLinesPage() {
		OrdersPage.verifyItemIdElementCount(Integer.parseInt(getData("ItemIdCount")));
		OrdersPage.verifyOrderQtyElementCount(Integer.parseInt(getData("OrderQtyCount")));
		OriginalOrdersPage.selectOriginalOrderBreadcrumb();
		CommonMethods.waitForPageLoading();
		OriginalOrdersPage.clickOrderCardInOriginalOrder(
				Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder").toString());
	}

	@And("Verify wave Run specifies the Correct Quantity and the Container in Allocations")
	public void verifyWaveRunHasQuantityAndContainerInAllocations() {
		int orderLineQuantity = Integer.parseInt(getDataFromFeature("getdata(orderLineQuantity)"));
		for (int i = orderLineQuantity; i >= 1; i--) {
//commented below line by lohith on 13 Noc 2023 during merge
//			WaveRunsPage.clickOrderLineInAllocations(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "OrderLineID" + i).toString());
			// WaveRunsPage.clickOrderLineInAllocations(Variables.get(CurrentThreadInstance.getCurrentScenarioId()
			// + "OrderLineID" + i).toString());
			WaveRunsPage.clickOrderLineInAllocations(getDataFromFeature("getdata(ItemId_Line" + i + ")"));
			WaveRunsPage.expandContainerOrQuantity();
			WaveRunsPage.checkContainerQuantity(getDataFromFeature("getdata(Order_Line_Quantity" + i + ")"));
			WaveRunsPage.allocationContainerLocation(getDataFromFeature("getdata(ContainerLocation_Line" + i + ")"));
			WaveRunsPage.expandItem();
			WaveRunsPage.allocationItemID(getDataFromFeature("getdata(ItemId_Line" + i + ")"));
			WaveRunsPage.closeAllocation();
			FooterPanelPage.clickDeselectButton();
			// WaveRunsPage.selectWaveRunsBreadcrumb();
		}
	}

	@And("Validate LPN status and inventory details of LPN")
	public void validateLPNStatusAndInventoryDetailsOfLPN() {
		List<String> listOFiLPNs = (List<String>) Variables
				.get(CurrentThreadInstance.getCurrentScenarioId() + "listOFiLPNs");
		int j = 1;
		for (String iLpn : listOFiLPNs) {
			ASNs.selectLPNAndVerifyLPNPresent(iLpn, j);
			ILPNs.verifystastusofEachLPN(iLpn, "Not Allocated");
			ILPNPopupPage.verifyInventorycontainer(iLpn);
			ILPNPopupPage.verifyProductStatusinpop(getDataFromFeature("getData(ProductStatus_Line" + j + ")"));
			ILPNPopupPage.verifyInventorytypeinpop(getDataFromFeature("getData(inventory_Line" + j + ")"));
			ILPNPopupPage.verifyOnHandQuantity(getDataFromFeature("getData(OrdQty_Line" + j + ")"));
			ILPNPopupPage.verifyItem(getDataFromFeature("getData(ItemID_Line" + j + ")"));
			ASNs.clickLPNSpagination();
			j++;
		}
	}

	@And("Enter ILPN and Location in AT User Directed PutAway for ilpn with later expiry date first")
	public void enterILPNAndLocationInATUserDirectedPutAwayForIlpnWithLaterExpiryDateFirst() {
		List<String> listOFiLPNs = (List<String>) Variables
				.get(CurrentThreadInstance.getCurrentScenarioId() + "listOFiLPNs");
		int j = 3;
		for (int i = listOFiLPNs.size() - 1; i >= 0; i--) {
			UserDirected.searchLPN(listOFiLPNs.get(i));
			UserDirected.enterQuantity(getDataFromFeature("getdata(OrdQty_Line" + j + ")"));
			UserDirected.enterScanLocationWithWarning(getDataFromFeature("getdata(Display_Location" + j + ")"));
			j--;
		}
	}

	@And("Extract Serial numbers from Inventory attributes")
	public void extractSerialNumbersFromInventoryAttributes() {
		InventoryDetailsPage.setByselectinvfirstrow();
		HeaderPanelPage.clickRelatedLinksButton();
		HeaderPanelPage.clickInventoryAttributes();
	}

	@And("Execute RunWave from Original Orders for ATStandardOrderStrategyDeselectShort")
	public void executeRunWaveFromOriginalOrdersForATStandardOrderStrategyDeselectShort() {
//		OriginalOrdersPage.clickMoreActions();
		OriginalOrdersPage.executeRunWaveForOrderATStandardOrderStrategyDeselectShort();
	}

	@And("Select First Row")
	public void selectFirstRow() {
		CommonPage.clickRowAtFirstIndex();
	}

	@And("Select to the Message Logging")
	public void selectToTheMessageLogging() {
		CommonMethods.scrollByParticularElement(By.xpath(
				"//ion-item[@class='ng-star-inserted item md item-lines-default item-fill-none in-list hydrated']//a[text()='Message Logging']"),
				"Message Logging");
		SeleniumActions.click(By.xpath(
				"//ion-item[@class='ng-star-inserted item md item-lines-default item-fill-none in-list hydrated']//a[text()='Message Logging']"),
				"Message Logging");
	}

	@And("Validate OLPN status {string}")
	public void validateOlpnstatus(String OLPNStatus) {
		WaveRunsPage.verifyOLPNStatus(OLPNStatus);
	}

	@And("Store OLPN number in runtime variable")
	public static void captureOLPNNumber() {
		WaveRunsPage.captureOLPNNumber();
	}

	@And("Complete {string} Packing in AT Pick OLPN")
	public static void completePackingATPickOlpn(String count) {
		PickPackLPNPage.verifyAtPickOlpnPageDisplayed();
		PickPackLPNPage.completeATPickOlpnProcess(Integer.valueOf(getDataFromFeature(count)));
		PickPackLPNPage.verifyInformationEndOfOlpn();
	}

	@And("Verify Item Packing Details at Inventory Details")
	public void verifyItemPackingDetailsAtInventoryDetails() {
		LeftPanelPage.searchItem(getDataFromFeature("getdata(ItemId_Line1)"));
		LeftPanelPage.searchLocationBarcode(getDataFromFeature("getdata(ScanLocation_Line1)"));
		InventoryDetailsPage.validateLocationBarcodeAndItemBarcode(getDataFromFeature("getdata(ScanLocation_Line1)"),
				getDataFromFeature("getdata(ItemIdCodeValue_Line1)"));
		LeftPanelPage.searchItem(getDataFromFeature("getdata(ItemId_Line2)"));
		LeftPanelPage.searchLocationBarcode(getDataFromFeature("getdata(ScanLocation_Line2)"));
		InventoryDetailsPage.validateLocationBarcodeAndItemBarcode(getDataFromFeature("getdata(ScanLocation_Line2)"),
				getDataFromFeature("getdata(ItemIdCodeValue_Line2)"));

	}

	@And("Navigate to Wave Runs Homepage")
	public void navigateToWaveRunsHomepage() {
		WaveRunsPage.selectWaveRunsBreadcrumb();
	}

	@And("Verify Item with {string}")
	public void verifyItemWith(String item) {
		ItemsPage.verifyItemAtFirstIndex(getDataFromFeature(item));
	}

	@And("Update ASN for Product Status Adjustment iLPN in {string}")
	public void updateASNForProductStatusAdjustmentILPNIn(String fileName) throws Exception {
		String asnId = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(ASN)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ASN", asnId);
		FrameworkLogger.log(LogType.INFO, "Set value for ASN : " + asnId);
		String lpnId = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(LPN)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN", lpnId);
		FrameworkLogger.log(LogType.INFO, "Set value for LPN : " + lpnId);
		String item = getDataFromFeature(getData("Item"));
		ArrayList<String> al = new ArrayList<>();
		al.add("Asn::2::3::" + asnId);
		al.add("Lpn::2::2::" + lpnId);
		al.add("Lpn::2::6::" + asnId);
		al.add("LpnDetail::2::2::" + lpnId);
		al.add("LpnDetail::2::6::" + item);
		ExcelUtil1.setMultipleCellData(fileName, al);
	}

	@And("Verify ILPN linked to ASN with variable  {string}")
	public void verifyILPNLinkedToASNWithVariable(String lpn) {
		HeaderPanelPage.clickRelatedLinksButton();
		CommonMethods.waitForPageLoading();
		HeaderPanelPage.clickLPNInventory();
		CommonMethods.waitForPageLoading();
		lpn = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + lpn);
		ILPNs.verifyILPNAtFirstIndex(lpn);
	}

	@And("Verify Product status and Inventory type in LPNPopup Page")
	public void verifyProductStatusAndInventoryTypeInLPNPopupPage() {
		ILPNPopupPage.verifyProductStatusAndInventoryTypeInLPNPopupPage();
	}

	@And("Verify SKU ,Product status, Quantity and Inventory type in LPNPopup Page")
	public void verifySKUProductStatusQuantityAndInventoryTypeInLPNPopupPage() {
		ILPNPopupPage.verifySKUProductStatusQuantityAndInventoryTypeInLPNPopupPage();
	}

	@And("Complete ATStandardReceiving with ASN and LPN")
	public void completeATStandardReceivingWithASNAndLPN() {
		String asn = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN");
		String lpn = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "LPN");
		ATStandardReceiving.completeATStandardReceiving(asn, lpn);
	}

	@And("Verify LPN details in Inventory Details page")
	public void verifyLPNDetailsInInventoryDetailsPage() {
		InventoryDetailsPage.verifyLPNDetailsInventoryDetailsPage();
	}

	@And("Search Inventory Container with variable {string}")
	public void searchInventoryContainerWithVariable(String lpn) {
		lpn = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + lpn);
		LeftPanelPage.searchInventoryContainer(lpn);
	}

	@And("Navigate to Manage User")
	public void navigateToManageUser() {
		HomePage.navigateToManageUserPage();
	}

	@And("Search with UserId")
	public void searchWithUserId() {
		String strUsername = ConfigurationUtils.getFrameworkConfig("appusername");
		LeftPanelPage.searchUserId(strUsername);
	}

	@And("Store RoleId to variable {string}")
	public void storeRoleIdToVariable(String name) {
		CommonPage.clickRowAtFirstIndex();
		FooterPanelPage.clickMoreButton();
		FooterPanelPage.clickOrganizationUsers();
		OrganizationUsersListPage.clickCloseIconForPrimaryOrganizationId();
		OrganizationUsersListPage.clickRoles();
		RolesListPage.storeRoleId(name);
		CommonPage.clickClose2Icon();
		CommonPopupPage.clickYesButton();
		CommonPage.clickCloseIcon();
		CommonPopupPage.clickYesButton();
	}

	@And("Navigate to Product status matrix")
	public void navigateToProductStatusMatrix() {
		HomePage.navigateToProductStatusMatrixPage();
	}

	@And("Select user {string}")
	public void selectUser(String role) {
		role = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + role);
		ProductStatusMatrixPage.selectRole(role);
	}

	@And("Verify user have valid moves")
	public void verifyUserHaveValidMoves() {
		ProductStatusMatrixPage.verifyUserHasValidMoves();
	}

	@And("Adjust Product status to {string}")
	public void adjustProductStatusTo(String adjustProductStatus) {
		InventoryDetailsPage.adjustProductStatus(getDataFromFeature(adjustProductStatus));
	}

	@And("Create Duplicate tab")
	public void createDuplicateTab() {
		CommonMethods.waitForPageLoading();
		GeneralUtils.wait(20);
		CommonMethods.createDuplicateTab();
	}

	@And("Search Inbound LPNID with Variable Name {string}")
	public void searchInboundLPNIDWithVariableName(String name) {
		LeftPanelPage.searchInBoundLPNID(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + name).toString());
	}

	@Then("Verify PixData for {string}")
	public void verifyPixDataFor(String adjustProductStatus) {
		PixVisibilityPage.verifyPixDataForAdjustment(getDataFromFeature(adjustProductStatus));
	}

	@And("Verify LPN Details for multiple ILPN")
	public void verifyLPNCard() {
		int orderLPNCard = Integer.parseInt(getDataFromFeature("getdata(orderLPNCard)"));
		for (int i = orderLPNCard; i >= 1; i--) {
			ILPNs.clickILPNCardInILPN(
					Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "LPNIdLine" + i).toString());
			ILPNs.expandInventoryDetails();
			{
				if (i == 1) {
					verifyLPNINventoryDetailCard1();
				} else if (i == 2) {
					verifyLPNINventoryDetailCard2();
				} else {
					verifyLPNINventoryDetailCard3();
				}
			}
			FooterPanelPage.clickDeselectButton();

		}
	}

	@And("Update Original Order with one line {string}")
	public void updateOriginalOrderWithOneLine(String fileName) throws Exception {
		String strOrderValue = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(OriginalOrderID)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder", strOrderValue);
		FrameworkLogger.log(LogType.INFO, "Set value for Original Order : " + strOrderValue);
		ArrayList<String> al = new ArrayList<>();
		al.add("OriginalOrder::2::3::" + strOrderValue);
		al.add("OriginalOrderLine::2::2::" + strOrderValue);
		ExcelUtil1.setMultipleCellData(fileName, al);

	}

	@And("Execute RunWave from Original Orders for ATStandardOrderStrategy")
	public void executeRunWaveFromOriginalOrdersForATStandardOrderStrategy() {
		OriginalOrdersPage.executeRunWaveForOrderATStandardOrderStrategy();

	}

	@And("Verify Item ID Quantity Batch number and expiry date of Order")
	public void verifyItemIDQuantityBatchNumberAndExpiryDateOfOrder() {
		int orderLineQuantity = Integer.parseInt(getDataFromFeature("getdata(orderLineQuantity)"));
		for (int i = orderLineQuantity; i >= 1; i--) {
			OriginalOrdersPage.selectDetailsForMultipleOrderLine(i);
			OriginalOrdersPage.expandOrderLineNeed();
			Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "OrderLineID" + i,
					OriginalOrdersPage.getOrderLineIDFromOrderLinePopUp());
			OriginalOrdersPage.orderHasItemIDInOrderLineNeed(getDataFromFeature("getdata(ItemID_Line" + i + ")"));
			OriginalOrdersPage
					.orderHasQuantityInOrderLineNeed(getDataFromFeature("getdata(Order_Line_Quantity" + i + ")"));
			OriginalOrdersPage.orderHasBatchNumberInOrderLineNeed(getDataFromFeature("getData(BatchNumber)"));
			OriginalOrdersPage.closeOrderLine();
			FooterPanelPage.clickDeselectButton();
		}
	}

	@And("Verify two wave Runs for Relenishment and pickpack specifiesCorrect Quantity Item and Batch Number")
	public void verifyTwoWaveRunsForRelenishmentAndPickpackSpecifiesCorrectQuantityItemAndBatchNumber() {
		int waverunsType = WaveRunsPage.getwavenumberType();
		for (int i = 1; i <= waverunsType; i++) {
			/*
			 * if (WaveRunsPage.getWaveTypeDes(i).trim().equalsIgnoreCase("Replenishment"))
			 * { WaveRunsPage.selectDetailsForMultipleOrderLine(1);
			 * WaveRunsPage.expandContainerOrQuantity();
			 * WaveRunsPage.checkContainerQuantity(getDataFromFeature(
			 * "getdata(Order_Line_Quantity" + i + ")")); WaveRunsPage.expandItem();
			 * WaveRunsPage.allocationItemID(getDataFromFeature("getdata(ItemID_Line" + i +
			 * ")")); WaveRunsPage.allocationBatchNumber(getDataFromFeature(
			 * "getdata(BatchNo_Line2)")); }
			 */
			if (WaveRunsPage.getWaveTypeDes(i).trim().contains("Pick/Pack")) {
				WaveRunsPage.selectDetailsForMultipleOrderLine(1);
				WaveRunsPage.expandContainerOrQuantity();
				WaveRunsPage.checkContainerQuantity(getDataFromFeature("getdata(Order_Line_Quantity" + i + ")"));
				WaveRunsPage.expandItem();
				WaveRunsPage.allocationItemID(getDataFromFeature("getdata(ItemID_Line" + i + ")"));
				OriginalOrdersPage.orderHasBatchNumberInOrderLineNeed(getDataFromFeature("getdata(BatchNumber)"));
			}
			WaveRunsPage.closeAllocation();
			FooterPanelPage.clickDeselectButton();
		}
	}

	@And("Select Wave Run card")
	public void selectWaveRunCardinWaveRuns() {
		WaveRunsPage.clickWaveRunCardInWaveRun(
				Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "WaveRun").toString());
	}

	@And("Click on oLPNs Links")
	public void clickOnOLPNsLink() {
		CommonMethods.waitForPageLoading();
		HeaderPanelPage.clickOLPNSLink();
	}

	@And("Update ASN for Wave multiple orders with ILPN level with three line {string}")
	public void updateASNForWaveMultipleOrdersWithILPNLevelWithThreeLine(String fileName) throws Exception {
		String asnId = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(ASN)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ASN", asnId);
		FrameworkLogger.log(LogType.INFO, "Set value for ASN : " + asnId);
		String lpnId = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(LPN)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN1", lpnId + 1);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN2", lpnId + 2);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN3", lpnId + 3);
		FrameworkLogger.log(LogType.INFO, "Set value for LPN1 : " + lpnId + 1);
		FrameworkLogger.log(LogType.INFO, "Set value for LPN2 : " + lpnId + 2);
		FrameworkLogger.log(LogType.INFO, "Set value for LPN3 : " + lpnId + 3);
		List<String> listOfILPNs = new ArrayList<>();
		listOfILPNs.add(lpnId + 1);
		listOfILPNs.add(lpnId + 2);
		listOfILPNs.add(lpnId + 3);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "listOfILPNs", listOfILPNs);
		ArrayList<String> al = new ArrayList<>();
		al.add("Asn::2::3::" + asnId);
		al.add("Lpn::2::2::" + lpnId + 1);
		al.add("Lpn::3::2::" + lpnId + 2);
		al.add("Lpn::4::2::" + lpnId + 3);
		al.add("Lpn::2::6::" + asnId);
		al.add("Lpn::3::6::" + asnId);
		al.add("Lpn::4::6::" + asnId);
		al.add("LpnDetail::2::2::" + lpnId + 1);
		al.add("LpnDetail::3::2::" + lpnId + 2);
		al.add("LpnDetail::4::2::" + lpnId + 3);
		ExcelUtil1.setMultipleCellData(fileName, al);
	}

	@And("Verify the inventory attributes for non serial number item")
	public void verifyTheInventoryAttributesForNonSerialNumberItem() {
		CommonPage.selectCheckBoxAtFirstIndex();
		HeaderPanelPage.clickRelatedLinksButton();
		HeaderPanelPage.clickInventoryAttributes();
		CommonPage.verifyNoRecordsLabelDisplayed();

	}

	@And("Search with Display location Filter {string}")
	public void searchWithDisplayLocationFilter(String text) {
		LocationInventory.searchDisplayLocation(getDataFromFeature(text));
	}

	@And("Verify OnhandQuantity and attributes in inventory details in item")
	public void verifyOnhandQuantityAndAttributesInInventoryDetailsInItem(int itemcount) {
		int orderLineQuantity = Integer.parseInt(getDataFromFeature("getdata(orderLineQuantity)"));
		for (int i = orderLineQuantity; i >= 1; i--) {
			List<String> listOFiLPNs = (List<String>) Variables
					.get(CurrentThreadInstance.getCurrentScenarioId() + "listOFiLPNs");
			for (String iLpn : listOFiLPNs) {
				ILPNPopupPage.verifyInventorycontainer(iLpn);
				ILPNPopupPage
						.verifyProductStatusinpop(getDataFromFeature("getData(ProductStatus_Line" + itemcount + ")"));
				ILPNPopupPage.verifyInventorytypeinpop(getDataFromFeature("getData(inventory_Line" + itemcount + ")"));
				ILPNPopupPage.verifyOnHandQuantity(getDataFromFeature("getData(OrdQty_Line" + itemcount + ")"));
				ILPNPopupPage.verifyItem(getDataFromFeature("getData(ItemID_Line" + itemcount + ")"));

			}

		}
	}

	@And("Update Order for Wave multiple orders with ILPN level with three line {string}")
	public void updateOrderForWaveMultipleOrdersWithILPNLevelWithThreeLine(String fileName) throws Exception {
		String originalOrder = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(OriginalOrder)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder", originalOrder);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder1", originalOrder + 1);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder2", originalOrder + 2);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder3", originalOrder + 3);
		FrameworkLogger.log(LogType.INFO, "Set value for OriginalOrder : " + originalOrder);
		FrameworkLogger.log(LogType.INFO, "Set value for OriginalOrder1 : " + originalOrder + 1);
		FrameworkLogger.log(LogType.INFO, "Set value for OriginalOrder2 : " + originalOrder + 2);
		FrameworkLogger.log(LogType.INFO, "Set value for OriginalOrder3 : " + originalOrder + 3);
		List<String> listOfOrders = new ArrayList<>();
		listOfOrders.add(originalOrder + 3);
		listOfOrders.add(originalOrder + 2);
		listOfOrders.add(originalOrder + 1);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "listOfOrders", listOfOrders);
		String orders = String.join(",", listOfOrders);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "Orders", orders);
		ArrayList<String> al = new ArrayList<>();
		al.add("OriginalOrder::2::3::" + originalOrder + 1);
		al.add("OriginalOrder::3::3::" + originalOrder + 2);
		al.add("OriginalOrder::4::3::" + originalOrder + 3);
		al.add("OriginalOrderLine::2::2::" + originalOrder + 1);
		al.add("OriginalOrderLine::3::2::" + originalOrder + 2);
		al.add("OriginalOrderLine::4::2::" + originalOrder + 3);
		ExcelUtil1.setMultipleCellData(fileName, al);
	}

	@And("Verify Imported Orders with variable name {string}")
	public void verifyImportedOrdersWithVariableName(String name) {
		OriginalOrdersPage
				.filterOriginalOrder(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + name).toString());
	}

	@And("Verify Item and Quantity For Order Lines")
	public void verifyItemAndQuantityForOrderLines(int i) {
		int orderLineQuantity = Integer.parseInt(getDataFromFeature("getdata(orderLineQuantity)"));

		OriginalOrdersPage.selectDetailsForMultipleOrderLine(i);
		OriginalOrdersPage.expandOrderLineNeed();
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "OrderLineID" + i,
				OriginalOrdersPage.getOrderLineIDFromOrderLinePopUp());
		OriginalOrdersPage.orderHasQuantityInOrderLineNeed(getDataFromFeature("getdata(OrderLineQuantity" + i + ")"));
		OriginalOrdersPage.orderHasItemIDInOrderLineNeed(getDataFromFeature("getdata(ItemID_Line" + i + ")"));
		OriginalOrdersPage.closeOrderLine();
		FooterPanelPage.clickDeselectButton();

	}

	@And("Verify wave Run specifies the Correct Quantity Item")
	public void verifyWaveRunSpecifiesTheCorrectQuantityItem() {
		int orderLineQuantity = Integer.parseInt(getDataFromFeature("getdata(orderLineQuantity)"));
		for (int i = 1; i <= orderLineQuantity; i++) {
			WaveRunsPage.clickOrderLineInAllocations(
					Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "OrderLineID" + i).toString());
//			WaveRunsPage.selectDetailsForMultipleOrderLine(i);
			WaveRunsPage.expandContainerOrQuantity();
			WaveRunsPage.checkContainerQuantity(getDataFromFeature("getdata(Order_Line_Quantity" + i + ")"));
			WaveRunsPage.expandItem();
			WaveRunsPage.allocationItemID(getDataFromFeature("getdata(ItemID_Line_" + i + ")"));
			WaveRunsPage.closeAllocation();
			FooterPanelPage.clickDeselectButton();
		}
	}

	@And("Verify Item and Quantity with variable {string} and Order size {int}")
	public void verifyItemAndQuantityWithVariableAndOrderSize(String name, int i) {
		int orderLineQuantity = Integer.parseInt(getDataFromFeature("getdata(orderLineQuantity)"));
		Variables.get(CurrentThreadInstance.getCurrentScenarioId() + name).toString();
		OriginalOrdersPage.selectDetailsForMultipleOrderLine(orderLineQuantity);
		OriginalOrdersPage.expandOrderLineNeed();
		OriginalOrdersPage.orderHasQuantityInOrderLineNeed(getDataFromFeature("getdata(OrderLineQuantity" + i + ")"));
		OriginalOrdersPage.orderHasItemIDInOrderLineNeed(getDataFromFeature("getdata(ItemID_Line" + i + ")"));
		OriginalOrdersPage.closeOrderLine();
		FooterPanelPage.clickDeselectButton();

	}

	@And("Update ASN for Wave multiple orders with rule criteria in {string}")
	public void updateASNForWaveMultipleOrdersWithRuleCriteriaIn(String fileName) throws Exception {

		String asnId = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(ASN)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ASN", asnId);
		FrameworkLogger.log(LogType.INFO, "Set value for ASN : " + asnId);
		String lpnId = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(LPN)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN1", lpnId + 1);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN2", lpnId + 2);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN3", lpnId + 3);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN4", lpnId + 4);
		FrameworkLogger.log(LogType.INFO, "Set value for LPN1 : " + lpnId + 1);
		FrameworkLogger.log(LogType.INFO, "Set value for LPN2 : " + lpnId + 2);
		FrameworkLogger.log(LogType.INFO, "Set value for LPN3 : " + lpnId + 3);
		FrameworkLogger.log(LogType.INFO, "Set value for LPN4 : " + lpnId + 4);
		List<String> listOfILPNs = new ArrayList<>();
		listOfILPNs.add(lpnId + 1);
		listOfILPNs.add(lpnId + 2);
		listOfILPNs.add(lpnId + 3);
		listOfILPNs.add(lpnId + 4);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "listOfILPNs", listOfILPNs);
		ArrayList<String> al = new ArrayList<>();
		al.add("Asn::2::3::" + asnId);
		al.add("Lpn::2::2::" + lpnId + 1);
		al.add("Lpn::3::2::" + lpnId + 2);
		al.add("Lpn::4::2::" + lpnId + 3);
		al.add("Lpn::5::2::" + lpnId + 4);
		al.add("Lpn::2::6::" + asnId);
		al.add("Lpn::3::6::" + asnId);
		al.add("Lpn::4::6::" + asnId);
		al.add("Lpn::5::6::" + asnId);
		al.add("LpnDetail::2::2::" + lpnId + 1);
		al.add("LpnDetail::3::2::" + lpnId + 2);
		al.add("LpnDetail::4::2::" + lpnId + 3);
		al.add("LpnDetail::5::2::" + lpnId + 4);
		ExcelUtil1.setMultipleCellData(fileName, al);
	}

	@And("Verify Multiple Items with {string}")
	public void verifyMultipleItemsWith(String items) {
		ItemsPage.verifyMultipleItems(getDataFromFeature(items));
	}

	@And("Verify ILPNs linked to ASN with variable  {string}")
	public void verifyILPNsLinkedToASNWithVariable(String lpns) {
		List<String> listOfILPNs = (List<String>) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + lpns);
		HeaderPanelPage.clickRelatedLinksButton();
		HeaderPanelPage.clickLPNInventory();
		ILPNs.verifyMultipleLPNs(listOfILPNs);
	}

	@And("Verify Product status and Inventory type for multiple lpns in LPNPopup Page")
	public void verifyProductStatusAndInventoryTypeForMultipleLpnsInLPNPopupPage() {
		ILPNPopupPage.verifyProductStatusAndInventoryTypeForMultipleLpnsInLPNPopupPage();
	}

	@And("Complete ATStandardReceiving with ASN and multiple LPNs")
	public void completeATStandardReceivingWithASNAndMultipleLPNs() {
		String asn = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN");
		List<String> listOfILPNs = (List<String>) Variables
				.get(CurrentThreadInstance.getCurrentScenarioId() + "listOfILPNs");
		ATStandardReceiving.completeATStandardReceivingWithMultipleLPNs(asn, listOfILPNs);
	}

	@And("Complete ATUserDirectedPutAway with multiple LPNs")
	public void completeATUserDirectedPutAwayWithMultipleLPNs() {
		List<String> listOfILPNs = (List<String>) Variables
				.get(CurrentThreadInstance.getCurrentScenarioId() + "listOfILPNs");
		ATUserDirectedPutAway.completeATUserDirectedPutAwayWithMultipleLPNs(listOfILPNs);

	}

	@And("Verify Multiple Items details in Inventory Details page")
	public void verifyMultipleItemsDetailsInInventoryDetailsPage() {
		InventoryDetailsPage.verifyMultipleItemDetailsInventoryDetailsPage();
	}

	@And("Update ASN export file with LPN {string}")
	public void updateASNExportFileWithLPN(String fileName) throws Exception {
		String asnId = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(AsnId)"));
		String lpnId = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(LpnId)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ASN", asnId);
		FrameworkLogger.log(LogType.INFO, "Set value for ASN : " + asnId);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN1", lpnId + 1);
		FrameworkLogger.log(LogType.INFO, "Set value for LPN1 : " + lpnId + 1);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN2", lpnId + 2);
		FrameworkLogger.log(LogType.INFO, "Set value for LPN2 : " + lpnId + 2);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN3", lpnId + 3);
		FrameworkLogger.log(LogType.INFO, "Set value for LPN3 : " + lpnId + 3);
		ArrayList<String> al = new ArrayList<>();
		al.add("Asn::2::3::" + asnId);
		al.add("Lpn::2::6::" + asnId);
		al.add("Lpn::3::6::" + asnId);
		al.add("Lpn::4::6::" + asnId);
		al.add("Lpn::2::2::" + lpnId + 1);
		al.add("Lpn::3::2::" + lpnId + 2);
		al.add("Lpn::4::2::" + lpnId + 3);
		al.add("LpnDetail::2::2::" + lpnId + 1);
		al.add("LpnDetail::3::2::" + lpnId + 2);
		al.add("LpnDetail::4::2::" + lpnId + 3);
		ExcelUtil1.setMultipleCellData(fileName, al);

	}

	@And("Complete ATStandardReceiving with LPNs")
	public void completeATStandardReceivingWithLPNs() {
		ReceiveLPNLevel.searchASN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN").toString());
		ReceiveLPNLevel.enterLPN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "LPN1").toString());
		ReceiveLPNLevel.enterLPN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "LPN2").toString());
		ReceiveLPNLevel.enterLPN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "LPN3").toString());
		// ReceiveLPNLevel.enterLPN(ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(LPNId)")));

	}

	@And("Enter correct Quantity in cycle count screen")
	public void enterCorrectQuantityInCycleCountScreen() {
		String actualQuantity = (String) Variables
				.get(CurrentThreadInstance.getCurrentScenarioId() + "CurrentOnhandQuantity");
		int quantityValue = Integer.parseInt((actualQuantity).trim());
		TasksPage.enterQuantity(String.valueOf(quantityValue));
		TasksPage.clickGoButton();

	}

	@And("Update Original Orders with three lines {string}")
	public void updateOriginalOrdersWithThreeLines(String fileName) throws Exception {
		String strOrderValue = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(OriginalOrderID)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder1", strOrderValue + 1);
		FrameworkLogger.log(LogType.INFO, "Set value for Original Order1 : " + strOrderValue + 1);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder2", strOrderValue + 3);
		FrameworkLogger.log(LogType.INFO, "Set value for Original Order2 : " + strOrderValue + 3);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder3", strOrderValue + 2);
		FrameworkLogger.log(LogType.INFO, "Set value for Original Order3 : " + strOrderValue + 2);

		List<String> listOfOrders = new ArrayList<>();
		listOfOrders.add(strOrderValue + 1);
		listOfOrders.add(strOrderValue + 2);
		listOfOrders.add(strOrderValue + 3);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "listOfOrders", strOrderValue);
		String orders = String.join(",", listOfOrders);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "Orders", orders);

		ArrayList<String> al = new ArrayList<>();
		al.add("OriginalOrder::2::3::" + strOrderValue + 1);
		al.add("OriginalOrder::3::3::" + strOrderValue + 2);
		al.add("OriginalOrder::4::3::" + strOrderValue + 3);
		al.add("OriginalOrderLine::2::2::" + strOrderValue + 1);
		al.add("OriginalOrderLine::3::2::" + strOrderValue + 2);
		al.add("OriginalOrderLine::4::2::" + strOrderValue + 3);

		ExcelUtil1.setMultipleCellData(fileName, al);

	}

	@And("Verify the Imported Orders")
	public void verifyTheImportedOrders() {
		OriginalOrdersPage.filterOriginalOrder(
				Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder1").toString());
		OriginalOrdersPage.filterOriginalOrder(
				Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder2").toString());
		OriginalOrdersPage.filterOriginalOrder(
				Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder3").toString());

	}

	@And("Verify Order Line Need and Order Line Attributes")
	public void verifyOrderLineNeedAndOrderLineAttributes() {
		OriginalOrdersPage.selectDetailsInOrderLine();
		OriginalOrdersPage.expandOrderLineNeed();
		OriginalOrdersPage.expandOrderLineAttributes();
		OriginalOrdersPage.closeOrderLine();
		FooterPanelPage.clickDeselectButton();
		OriginalOrdersPage.selectOriginalOrderBreadcrumb();
	}

	@And("Navigate to Order Planning Strategy")
	public void navigateToOrderPlanningStrategy() {
		HomePage.navigate_to_OrderPlanningStrategy();
		OriginalOrdersPage.verifyOrderPlanningStrategyPage();
	}

	@And("View FNCUBING wave Strategy {string}")
	public void viewFNCUBINGWaveStrategy(String text) {
		OrdersPage.filterByNameWaveStrategy(getDataFromFeature(text));
		CommonPage.clickRowAtFirstIndex();
		CommonPage.selectThreeDots();
		CommonPage.selectViewButton();

	}

	@And("Select Order Selection Criteria")
	public void selectOrderSelectionCriteria() {
		OrdersPage.selectOrderSelectionCriteria();
		CommonPage.selectContinueButton();
		OrdersPage.selectCubing();
		CommonPage.selectContinueButton();

	}

	@And("Navigate to Cubing Strategy")
	public void navigateToCubingStrategy() {
		HomePage.navigate_to_CubingStrategy();
		OriginalOrdersPage.verifyCubingStrategyPage();
	}

	@And("View FNCubing Cubing Strategy {string}")
	public void viewFNCubingCubingStrategy(String text) {
		Cubing.filterByNameCubingStrategy(getDataFromFeature(text));
		CommonPage.clickRowAtFirstIndex();
		// Cubing.selectFNCUBING01OrderStrategy();
		Cubing.selectViewButton();
	}

	@And("View Cube To Capacity Criteria")
	public void viewCubeToCapacityCriteria() {
		Cubing.selectCubeToCapacityCriteria();
		Cubing.ExpandSideArrow();
		CommonPage.selectViewButton();
		Cubing.selectCubingMethod();
		Cubing.selectResidualCubingParameters();
	}

	@And("Verify Cubing method parameters in cube to capacity")
	public void verifyCubingMethodParameters_CubeToCapacity() {
		Cubing.selectCubeToCapacityCriteria();
		Cubing.ExpandSideArrow();
		CommonPage.selectViewButton();
		Cubing.selectCubingMethod();
		Cubing.verifyCubingMethodParameters();
	}

	@And("Verify Residential parameters in cube to capacity")
	public void verifyResidentialParameters_CubeToCapacity() {
		Cubing.selectResidualCubingParameters();
		Cubing.verifyResidentialParameters();
	}

	@And("select BreakByCritera And Verify Configuration")
	public void selectBreakByCriteraAndVerifyConfiguration() {
		Cubing.verifyBreakByAttributeConfig();
	}

	@And("Navigate to Container Type")
	public void navigateToContainerType() {
		HomePage.navigate_to_ContainerType();
		Cubing.verifyContainerTypePage();
	}

	@And("View Container Size Definition {string}")
	public void viewContainerSizeDefinition(String text) {
		Cubing.filterByContainerType(getDataFromFeature(text));
		CommonPage.clickRowAtFirstIndex();
		Cubing.selectViewButton();
		Cubing.selectContainerSizeDefinition();
	}

	@And("verify Container Size Definition details")
	public void verifyDataInContainerSizeDefinition() {
		CommonMethods.waitForPageLoading();
		ContainerTypePage.verifyContainerSizeDefinitionDetails();
	}

	@And("Execute RunWave for Orders")
	public void executeRunWaveForOrders() {
		Cubing.selectMult1ipleOrders();
		OriginalOrdersPage.executeRunWaveFNCUBING01OrderStrategy();
	}

	@And("Navigate back to Original Orders")
	public void navigateBackToOriginalOrders() {
		HomePage.navigate_Back_to_OriginalOrder2();
		OriginalOrdersPage.verifyOriginalOrders2PageDisplayed();

	}

	@And("Select Olpns Option")
	public void selectOlpnsOption() {
		SeleniumActions.click(By.xpath(
				"//ion-item[@class='ng-star-inserted item md item-lines-default item-fill-none in-list hydrated']//a[text()='oLPNs']"),
				"Message Logging");
	}

	@And("Login to WMS Manhattan without passowrd")
	public void loginToWMSManhattanWithoutPassowrd() {
		String strUsername = ConfigurationUtils.getFrameworkConfig("appusername");
		// String strPassword = ConfigurationUtils.getFrameworkConfig("apppassword");
		LoginPage.enter_Username(strUsername);
		LoginPage.click_SubmitUser();
		// LoginPage.enter_password(GeneralUtils.decodeBase64ToString(strPassword));
		// LoginPage.click_LoginBt();
		HomePage.verifyUDCPageDisplayed();

	}

	@And("Update ASN file with LPN {string}")
	public void updateASNFileWithLPN(String fileName) throws Exception {
		String asnId = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(AsnId)"));
		String lpnId = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(LpnId)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ASN", asnId);
		FrameworkLogger.log(LogType.INFO, "Set value for ASN : " + asnId);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN", lpnId);
		FrameworkLogger.log(LogType.INFO, "Set value for LPN : " + lpnId);
		ArrayList<String> al = new ArrayList<>();
		al.add("Asn::2::3::" + asnId);
		al.add("Lpn::2::6::" + asnId);
		al.add("Lpn::2::2::" + lpnId);
		al.add("LpnDetail::2::2::" + lpnId);
		ExcelUtil1.setMultipleCellData(fileName, al);
	}

	@And("Update ORG Profile in WM Mobile")
	public void updateORGProfileInWMMobile() {
		CommonMethods.waitForPageLoading();
		HomePage.updateProfileInWMMobile();
	}

	@And("Execute FNCUBINGIIOrderStrategy RunWave for Orders")
	public void executeFNCUBINGIIOrderStrategyRunWaveForOrders() {

		Cubing.selectOrder();
		OriginalOrdersPage.executeRunWaveFNCUBING02OrderStrategy();
	}

	@And("View Wave Strategy")
	public void viewWaveStrategy() {
		Cubing.selectFNCUBING02OrderStrategy();
		CommonPage.selectThreeDots();
		CommonPage.selectViewButton();
	}

	@And("Update ItemId Item Master of Task import file with file by {string}")
	public void updateItemIdImportFileWithSingleTask(String fileName) throws Exception {
		// ExcelUtil1.verifyFilePresentfromuserdir(fileName);
		String ItemIdValue1 = getDataFromFeature("getdata(ItemId_Line1)");
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "Item1Id", ItemIdValue1);
		FrameworkLogger.log(LogType.INFO, "Set value for Item Id : " + ItemIdValue1);
		ArrayList<String> al = new ArrayList<>();
		al.add("Item::2::3::" + ItemIdValue1);
		al.add("ItemCode::2::2::" + ItemIdValue1);
		al.add("ItemCode::2::3::" + getDataFromFeature(getData("ItemCodeType")));
		al.add("ItemCode::2::4::" + getDataFromFeature(getData("ItemIdCodeValue_Line1")));
		al.add("ItemPackage::2::2::" + ItemIdValue1);
		al.add("ItemPackage::2::3::" + getDataFromFeature(getData("StdQtyUomIdPack")));
		al.add("ItemPackage::2::4::" + getDataFromFeature(getData("QuantityPack")));
		al.add("ItemPackage::3::2::" + ItemIdValue1);
		al.add("ItemPackage::3::3::" + getDataFromFeature(getData("StdQtyUomIdPallet")));
		al.add("ItemPackage::3::4::" + getDataFromFeature(getData("QuantityPallet")));
		ExcelUtil1.setMultipleCellData(fileName, al);
	}

	@And("Update ASN import file with Item Id LPN Task by file {string}")
	public void updateASNImportFileWithSingleLPNTask(String fileName) throws Exception {
		String AsnIdValue = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(ASN)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ASN", AsnIdValue);
		String strAsnIdValue = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN");
		FrameworkLogger.log(LogType.INFO, "Set value for ASN Id : " + strAsnIdValue);

		String LpnIdValue1 = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(LPNId_Line1)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN", LpnIdValue1);
		FrameworkLogger.log(LogType.INFO, "Set value for LPN Id : " + LpnIdValue1);

		String ShippedQtyLine1 = getDataFromFeature("getdata(ShippedQty_Line1)");
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ShippedQtyValue1", ShippedQtyLine1);
		FrameworkLogger.log(LogType.INFO, "Set value for Shipped Quantity value : " + ShippedQtyLine1);

		ArrayList<String> al = new ArrayList<>();
		al.add("Asn::2::3::" + strAsnIdValue);
		al.add("Asn::2::8::" + "1000");
		al.add("Asn::2::24::" + "0.000");
		al.add("Lpn::2::2::" + LpnIdValue1);
		al.add("Lpn::2::6::" + strAsnIdValue);
		al.add("LpnDetail::2::2::" + LpnIdValue1);
		al.add("LpnDetail::2::6::" + getDataFromFeature(getData("ItemId_Line1")));
		al.add("LpnDetail::2::9::" + ShippedQtyLine1);
		ExcelUtil1.setMultipleCellData(fileName, al);
	}

	@And("Verify Single Item Task Details at Inventory Details")
	public void verifyItemTaskDetailsAtInventoryDetails() {
		LeftPanelPage.searchItem(getDataFromFeature("getdata(ItemId_Line1)"));
		LeftPanelPage.searchLocationBarcode(
				Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ScanLocation").toString());
		InventoryDetailsPage.validateLocationBarcodeAndItemBarcode(
				Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ScanLocation").toString(),
				getDataFromFeature("getdata(ItemIdCodeValue_Line1)"));

	}

	@And("Update Original Order 2.0 import file with Task Single Item Id  by file {string}")
	public void updateOriginalOrderImportFileWithSingleItemTask(String fileName) throws Exception {
		String OrderIdValue = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(OriginalOrder)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder", OrderIdValue);
		String strOrderIdValue = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder");
		FrameworkLogger.log(LogType.INFO, "Set value for Original Order : " + strOrderIdValue);

		String OrderedQtyValueLine1 = getDataFromFeature("getdata(OrderedQty_Line1)");
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "OrderedQtyValue1", OrderedQtyValueLine1);
		FrameworkLogger.log(LogType.INFO, "Set value for Ordered Quantity : " + OrderedQtyValueLine1);

		ArrayList<String> al = new ArrayList<>();
		al.add("OriginalOrder::2::3::" + strOrderIdValue);
		al.add("OriginalOrderLine::2::2::" + strOrderIdValue);
		al.add("OriginalOrderLine::2::3::" + "'01");
		al.add("OriginalOrderLine::2::6::" + getDataFromFeature(getData("ItemId_Line1")));
		al.add("OriginalOrderLine::2::7::" + OrderedQtyValueLine1);
		ExcelUtil1.setMultipleCellData(fileName, al);

	}

	@And("Validate Task status {string}")
	public void validateTaskStatus(String tasksStatus) {
		CommonMethods.waitForPageLoading();
		TasksPage.verifyTasksStatus(tasksStatus);
	}

	@And("Store Task number in runtime variable")
	public static void captureTaskNumber() {
		TasksPage.captureTaskNumber();
	}

	@And("Verify Task specifies the Correct Inventory and the Container in Task Details")
	public void verifyTaskHasInventoryAndContainerInTaskDetails() {
		int orderLineQuantity = Integer.parseInt(getDataFromFeature("getdata(orderLineQuantity)"));
		for (int i = orderLineQuantity; i >= 1; i--) {
			// TasksPage.clickTaskInTaskDetails(Variables.get(CurrentThreadInstance.getCurrentScenarioId()
			// + "TASK" + i).toString());
			TasksPage.expandInventoryAndLocationDetails();
			TasksPage.taskDetailAllocatedInventoryTypeId(
					getDataFromFeature("getdata(AllocatedInventoryType_Line" + i + ")"));
			TasksPage.expandOrderAndContainerDetails();
			TasksPage.taskDetailContainerId(getDataFromFeature("getdata(ContainerType_Line" + i + ")"));
			TasksPage.closeTaskDetails();
			FooterPanelPage.clickDeselectButton();
		}
	}

	@And("Select Task card")
	public void selectTaskCardinTaskDetails() {
		TasksPage.clickTaskInTaskDetails(
				Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "TASK").toString());

	}

	@And("Complete ATSystemDirectedPutAway with single LPN")
	public void completeATSystemDirectedPutAwayWithSingleLPN() {
		String lpn = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "LPN");
		ATSystemDirectedPutAway.completeATSystemDirectedPutAway(lpn);
	}

	@And("Verify wave Run specifies the Correct Quantity and the Container in Wave Allocations")
	public void verifyWaveRunHasQuantityAndContainerInWaveAllocations() {
		int orderLineQuantity = Integer.parseInt(getDataFromFeature("getdata(orderLineQuantity)"));
		for (int i = orderLineQuantity; i >= 1; i--) {
			// WaveRunsPage.clickOrderLineInAllocations(Variables.get(CurrentThreadInstance.getCurrentScenarioId()
			// + "OrderLineID" + i).toString());
			WaveRunsPage.clickOrderLineInAllocations(getDataFromFeature("getdata(ItemId_Line" + i + ")"));
			WaveRunsPage.expandContainerOrQuantity();
			WaveRunsPage.checkContainerQuantity(getDataFromFeature("getdata(Order_Line_Quantity" + i + ")"));
			// WaveRunsPage.allocationContainerLocation(Variables.get(CurrentThreadInstance.getCurrentScenarioId()
			// + "ScanLocation").toString());
			WaveRunsPage.expandItem();
			WaveRunsPage.allocationItemID(getDataFromFeature("getdata(ItemId_Line" + i + ")"));
			WaveRunsPage.closeAllocation();
			FooterPanelPage.clickDeselectButton();
			// WaveRunsPage.selectWaveRunsBreadcrumb();
		}
	}

	@And("Click on Tasks Links")
	public void clickOnTasksLink() {
		CommonMethods.waitForPageLoading();
		HeaderPanelPage.clickTasksLink();
		CommonMethods.waitForPageLoading();
	}

	@And("Click on Task Details Links")
	public void clickOnTaskDetailsLink() {
		HeaderPanelPage.clickTaskDetailsLink();
	}

	@And("View FNCUBINGRETAIL Cubing Method")
	public void viewFNCUBINGRETAILCubingMethod() {
		Cubing.selectCubeToCapacityCriteria();
		Cubing.selectFNCUBING03RETAIL();
		Cubing.ExpandSideArrow();
		CommonPage.selectViewButton();
		Cubing.selectCubingMethod();
		Cubing.selectResidualCubingParameters();
		Cubing.backToCubingStrategy();

	}

	@And("View FNCUBINGBB Cubing Method")
	public void viewFNCUBINGBBCubingMethod() {
		// Cubing.selectCubeToCapacityCriteria();
		Cubing.expandSideArrow3();
		CommonPage.selectViewButton();
		Cubing.selectCubingMethod();
		Cubing.selectResidualCubingParameters();
		Cubing.backToCubingStrategy1();
	}

	@And("View FNCUBINGBC Cubing Method")
	public void viewFNCUBINGBCCubingMethod() {
		// Cubing.selectCubeToCapacityCriteria();
		Cubing.expandSideArrow3();
		CommonPage.selectViewButton();
		Cubing.selectCubingMethod();
		Cubing.selectResidualCubingParameters();
	}

	@And("View Container Size Definitions")
	public void viewContainerSizeDefinitions() {
		Cubing.selectFNCUBING0301();
		Cubing.selectViewButton();
		Cubing.selectContainerSizeDefinition();
		Cubing.backToContainerType();
		Cubing.selectFNCUBING0302();
		Cubing.selectViewButton();
		Cubing.selectContainerSizeDefinition();
		Cubing.backToContainerType();
		Cubing.selectFNCUBING0303();
		Cubing.selectViewButton();
		Cubing.selectContainerSizeDefinition();
	}

	@And("Navigate Back to Container Type")
	public void navigateBackToContainerType() {
		HomePage.navigate_Back_to_ContainerType();
		Cubing.verifyContainerTypePage();
	}

	@And("Execute RunWave for Order in Cubing")
	public void executeRunWaveForOrderInCubing() {
		Cubing.selectMult1ipleOrders();
		OriginalOrdersPage.executeRunWaveFNCUBING03OrderStrategy();
	}

	@And("Execute RunWave for Order in Cubing04strategy")
	public void executeRunWaveForOrderInCubing04strategy() {
		OriginalOrdersPage.executeRunWaveFNCUBING04OrderStrategy();
	}

	@And("Click on particular waverun")
	public void clickOnParticularWaverun() {
		WaveRunsPage.clickWaverunId();
	}

	@And("Update ASN for process shipping {string}")
	public void updateASNForProcessShipping(String fileName) throws Exception {
		updateASNForProductStatusAdjustmentILPNIn(fileName);
	}

	@And("Verify Wave Run for pickpack specifies correct Quantity")
	public void verifyWaveRunForPickpackSpecifiesCorrectQuantity() {

		int waverunsType = WaveRunsPage.getwavenumberType();
		CommonMethods.waitForPageLoading();
		for (int i = 1; i <= waverunsType; i++) {
			if (WaveRunsPage.getWaveTypeDes(i).trim().contains("Pick/Pack")) {
				WaveRunsPage.selectDetailsForMultipleOrderLine(1);
				WaveRunsPage.expandContainerOrQuantity();
				WaveRunsPage.checkContainerQuantity(getDataFromFeature("getdata(OrderedQuantity)"));
				WaveRunsPage.expandItem();
				WaveRunsPage.allocationItemID(getDataFromFeature("getdata(Item" + i + ")"));
			}
			WaveRunsPage.closeAllocation();
			FooterPanelPage.clickDeselectButton();
		}
	}

	@And("Update Asn and two Lpn {string}")
	public void updateAsnAndTwoLpn(String fileName) throws Exception {
		String asnId = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(AsnId)"));
		String lpnId = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(LpnId)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ASN", asnId);
		FrameworkLogger.log(LogType.INFO, "Set value for ASN : " + asnId);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN1", lpnId + 1);
		FrameworkLogger.log(LogType.INFO, "Set value for LPN1 : " + lpnId + 1);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN2", lpnId + 2);
		FrameworkLogger.log(LogType.INFO, "Set value for LPN2 : " + lpnId + 2);
		List<String> listOfILPNs = new ArrayList<>();
		listOfILPNs.add(lpnId + 1);
		listOfILPNs.add(lpnId + 2);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "listOfILPNs", listOfILPNs);
		ArrayList<String> al = new ArrayList<>();
		al.add("Asn::2::3::" + asnId);
		al.add("Lpn::2::6::" + asnId);
		al.add("Lpn::3::6::" + asnId);
		al.add("Lpn::2::2::" + lpnId + 1);
		al.add("Lpn::3::2::" + lpnId + 2);
		al.add("LpnDetail::2::2::" + lpnId + 1);
		al.add("LpnDetail::3::2::" + lpnId + 2);
		ExcelUtil1.setMultipleCellData(fileName, al);
	}

	@And("Complete ATStandardReceiving with two LPN")
	public void completeATStandardReceivingWithTwoLPN() {
		ReceiveLPNLevel.searchASN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN").toString());
		ReceiveLPNLevel.enterLPN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "LPN1").toString());
		ReceiveLPNLevel.enterLPN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "LPN2").toString());
	}

	@And("Update Original Order for two Orders {string}")
	public void updateOriginalOrderForTwoOrdersTASKOriginalOrderXlsx(String fileName) throws Exception {
		String strOrderValue = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(OriginalOrderID)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder1", strOrderValue + 1);
		FrameworkLogger.log(LogType.INFO, "Set value for Original Order1 : " + strOrderValue + 1);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder2", strOrderValue + 2);
		FrameworkLogger.log(LogType.INFO, "Set value for Original Order2 : " + strOrderValue + 2);
		ArrayList<String> al = new ArrayList<>();
		al.add("OriginalOrder::2::3::" + strOrderValue + 1);
		al.add("OriginalOrder::3::3::" + strOrderValue + 2);
		al.add("OriginalOrderLine::2::2::" + strOrderValue + 1);
		al.add("OriginalOrderLine::3::2::" + strOrderValue + 1);
		al.add("OriginalOrderLine::4::2::" + strOrderValue + 2);
		al.add("OriginalOrderLine::5::2::" + strOrderValue + 2);
		ExcelUtil1.setMultipleCellData(fileName, al);
	}

	@And("Execute AT Pick Cart Strategy RunWave for Orders")
	public void executeATPickCartStrategyRunWaveForOrders() {
		Cubing.selectTwoOrders();
		OriginalOrdersPage.executeRunWaveATPickCartStrategy();
	}

	@And("Verify the two Imported Orders")
	public void verifyTheTwoImportedOrders() {
		OriginalOrdersPage.filterOriginalOrder(
				Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder1").toString());
		OriginalOrdersPage.filterOriginalOrder(
				Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder2").toString());

	}

	@And("Select Details in Allocations page")
	public void selectDetailsInAllocationsPage() {
		CommonPage.clickRowAtFirstIndex();
		HomePage.ExpandSideArrow();
		CommonPage.clickDetailsbutton();
		CommonMethods.waitForPageLoading();
		OriginalOrdersPage.closeOrderLine();
	}

	@And("Enter ILPN and Location For Two LPNs in FN PutAway System Directed Page")
	public void enterILPNAndLocationForTwoLPNsInFNPutAwaySystemDirectedPage() {
		FNPutAwaySystemDirected.enterILPNAndLocationForTwoLPNInFNPutAwaySystemDirectedPage();

	}

	@And("Execute AT FP Strategy RunWave for Orders")
	public void executeATFPStrategyRunWaveForOrders() {
		Cubing.selectOrder();
		OriginalOrdersPage.executeRunWaveATFP01();
	}

	@And("Update ItemId Item Master of Inventory import file with file by {string}")
	public void updateItemIdImportFileWithMulitipleInventory(String fileName) throws Exception {
		// ExcelUtil1.verifyFilePresentfromuserdir(fileName);
		String ItemIdValue1 = getDataFromFeature("getdata(ItemId_Line1)");
		String ItemIdValue2 = getDataFromFeature("getdata(ItemId_Line2)");
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "Item1Id", ItemIdValue1);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "Item2Id", ItemIdValue2);
		FrameworkLogger.log(LogType.INFO, "Set value for Item Id : " + ItemIdValue1);
		FrameworkLogger.log(LogType.INFO, "Set value for Item Id : " + ItemIdValue2);
		ArrayList<String> al = new ArrayList<>();
		al.add("Item::2::3::" + ItemIdValue1);
		al.add("Item::3::3::" + ItemIdValue2);
		al.add("ItemCode::2::2::" + ItemIdValue1);
		al.add("ItemCode::2::3::" + getDataFromFeature(getData("ItemCodeType")));
		al.add("ItemCode::2::4::" + getDataFromFeature(getData("ItemIdCodeValue_Line1")));
		al.add("ItemCode::3::2::" + ItemIdValue2);
		al.add("ItemCode::3::3::" + getDataFromFeature(getData("ItemCodeType")));
		al.add("ItemCode::3::4::" + getDataFromFeature(getData("ItemIdCodeValue_Line2")));
		al.add("ItemPackage::2::2::" + ItemIdValue1);
		al.add("ItemPackage::2::3::" + getDataFromFeature(getData("StdQtyUomIdPack")));
		al.add("ItemPackage::2::4::" + getDataFromFeature(getData("QuantityPack")));
		al.add("ItemPackage::3::2::" + ItemIdValue1);
		al.add("ItemPackage::3::3::" + getDataFromFeature(getData("StdQtyUomIdPallet")));
		al.add("ItemPackage::3::4::" + getDataFromFeature(getData("QuantityPallet")));
		al.add("ItemPackage::4::2::" + ItemIdValue2);
		al.add("ItemPackage::4::3::" + getDataFromFeature(getData("StdQtyUomIdPack")));
		al.add("ItemPackage::4::4::" + getDataFromFeature(getData("QuantityPack")));
		al.add("ItemPackage::5::2::" + ItemIdValue2);
		al.add("ItemPackage::5::3::" + getDataFromFeature(getData("StdQtyUomIdPallet")));
		al.add("ItemPackage::5::4::" + getDataFromFeature(getData("QuantityPallet")));
		ExcelUtil1.setMultipleCellData(fileName, al);
	}

	@And("Update ASN import file with Item Id LPN Inventory by file {string}")
	public void updateASNImportFileWithMulitpleLPNInventory(String fileName) throws Exception {
		String AsnIdValue = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(ASN)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ASN", AsnIdValue);
		String strAsnIdValue = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN");
		FrameworkLogger.log(LogType.INFO, "Set value for ASN Id : " + strAsnIdValue);

		String LpnIdValue1 = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(LPNId_Line1)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN1", LpnIdValue1);
		FrameworkLogger.log(LogType.INFO, "Set value for LPN 1 Id : " + LpnIdValue1);

		String LpnIdValue2 = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(LPNId_Line2)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN2", LpnIdValue2);
		FrameworkLogger.log(LogType.INFO, "Set value for LPN 2 Id : " + LpnIdValue2);

		String LpnIdValue3 = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(LPNId_Line3)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN3", LpnIdValue3);
		FrameworkLogger.log(LogType.INFO, "Set value for LPN 3 Id : " + LpnIdValue3);

		String ShippedQtyLine1 = getDataFromFeature("getdata(ShippedQty_Line1)");
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ShippedQtyValue1", ShippedQtyLine1);
		FrameworkLogger.log(LogType.INFO, "Set value for Shipped Quantity value : " + ShippedQtyLine1);

		String ShippedQtyLine2 = getDataFromFeature("getdata(ShippedQty_Line2)");
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ShippedQtyValue2", ShippedQtyLine2);
		FrameworkLogger.log(LogType.INFO, "Set value for Shipped Quantity value : " + ShippedQtyLine2);

		String ShippedQtyLine3 = getDataFromFeature("getdata(ShippedQty_Line3)");
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ShippedQtyValue3", ShippedQtyLine3);
		FrameworkLogger.log(LogType.INFO, "Set value for Shipped Quantity value : " + ShippedQtyLine3);

		ArrayList<String> al = new ArrayList<>();
		al.add("Asn::2::3::" + strAsnIdValue);
		al.add("Asn::2::8::" + "1000");
		al.add("Asn::2::24::" + "0.000");
		al.add("Lpn::2::2::" + LpnIdValue1);
		al.add("Lpn::2::6::" + strAsnIdValue);
		al.add("Lpn::3::2::" + LpnIdValue2);
		al.add("Lpn::3::6::" + strAsnIdValue);
		al.add("Lpn::4::2::" + LpnIdValue3);
		al.add("Lpn::4::6::" + strAsnIdValue);
		al.add("LpnDetail::2::2::" + LpnIdValue1);
		al.add("LpnDetail::2::6::" + getDataFromFeature(getData("ItemId_Line1")));
		al.add("LpnDetail::2::9::" + ShippedQtyLine1);
		al.add("LpnDetail::3::2::" + LpnIdValue2);
		al.add("LpnDetail::3::6::" + getDataFromFeature(getData("ItemId_Line1")));
		al.add("LpnDetail::3::9::" + ShippedQtyLine2);
		al.add("LpnDetail::4::2::" + LpnIdValue3);
		al.add("LpnDetail::4::6::" + getDataFromFeature(getData("ItemId_Line2")));
		al.add("LpnDetail::4::9::" + ShippedQtyLine3);
		ExcelUtil1.setMultipleCellData(fileName, al);
	}

	@And("Process ATStandardReceiving with Item with two LPN Halfway")
	public void processATStandardReceivingWithTwoLPNHalfway() {

		String asn = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN");
		String lpn1 = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "LPN1");
		String lpn2 = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "LPN2");
		ATStandardReceiving.processATStandardReceivingWithTwoLpnHalfway(asn, lpn1, lpn2);

	}

	@And("Complete ATUserDirectedPutAway with inventory single LPN")
	public void completeATUserDirectedPutAwayWithSingleLPNInventory() {
		String lpn = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "LPN1");
		ATUserDirectedPutAway.completeATUserDirectedPutAway(lpn);
		CommonPopupPage.clickConfirmButton();
	}

	@And("Complete Edit LPN Size Type in each ILPN")
	public void completeEditLPNSizeType() {
		HomePage.ExpandMultipleSideArrow(1);
		HomePage.clickEditSwipeMenu();
		ILPNs.clickLPNSizePalletEuro();
		CommonMethods.waitForPageLoading();
		HomePage.ExpandMultipleSideArrow(2);
		HomePage.clickEditSwipeMenu();
		ILPNs.clickLPNSizeBoxMedium();
		CommonMethods.waitForPageLoading();
		HomePage.ExpandMultipleSideArrow(3);
		HomePage.clickEditSwipeMenu();
		ILPNs.clickLPNSizePalletCHEP();
		CommonMethods.waitForPageLoading();
	}

	@And("Verify each LPN Size Type in ILPN Card")
	public void verifyLPNSizeTypeInILPNCard() {
		int orderLPNCard = Integer.parseInt(getDataFromFeature("getdata(orderLPNCard)"));
		for (int i = 1; i <= orderLPNCard; i++) {
			ILPNs.clickILPNCardInILPN(
					Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "LPN" + i).toString());
			ILPNs.expandLPNAttributes();
			ILPNs.validateLPNSizeType(getDataFromFeature("getdata(LPNSizeType_LPN" + i + ")"));
			ILPNs.closeILPNDetails();
			FooterPanelPage.clickDeselectButton();
		}
	}

	@And("Verify Status of multiple LPN card")
	public void verifyStatusofMultipleLpnCard() {
		ILPNs.verifyLPNStatus("In Transit", 1);
		ILPNs.verifyLPNStatus("Consumed", 2);
		ILPNs.verifyLPNStatus("Not Allocated", 3);
	}

	@And("Click on Menu in WM mobile")
	public void clickOnMenuInWmMobile() {
		WMMobile.clickExitButtonOrMenu();
	}

	@And("Click on back arrow in WM mobile")
	public void clickOnBackArrowInWmMobile() {
		WMMobile.clickBackArrowOrButton();
	}

	@And("Confirm prompt in WM mobile")
	public void confirmPromptInWmMobile() {
		WMMobile.confirmPrompt();
	}

	@And("Click ok in popup message in WM mobile")
	public void clickOKInPopup() {
		CommonPopupPage.clickOkButton();
	}

	@And("SignOut And Login With Other credentials")
	public void signoutAndLoginWithOtherCredentials() {
		HomePage.SignOutAndLoginSecondUser();
	}

	/**
	 * To enter Expiry date in MMDDYYYY format
	 */
	@And("Enter Expiry date in SeedCycle count screen")
	public void enterExpiryDateInSeedCycleCountScreenInMMDDYYYY() {
		String text = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "StoreExpiryDate");
		String[] text1 = text.split("/");
		String day = text1[0];
		String month = text1[1];
		String year = text1[2];
		String last2 = year.substring(2, 4);
		WMMobile.enterExpiryDate(month, day, last2);
		TasksPage.clickGoButton();
	}

	@And("Filter by Task")
	public void filterByTask() {
		String taskId = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "TaskIdAtFirstIndex");
		TasksPage.filerByTask(taskId);

	}

	@And("Verify Quantity Adjustment")
	public void verifyQuantityAdjustment() {
		InventoryDetailsPage.validateUpdatedQuantity();
	}

	@And("Select Second Row")
	public void selectSecondRow() {
		CommonPage.clickRowAtSecondIndex();
	}

	@And("Select Third Row")
	public void selectThirdRow() {
		CommonPage.clickRowAtThirdIndex();
	}

	@And("Select Fourth Row")
	public void selectFourthRow() {
		CommonPage.clickRowAtFourthIndex();
	}

	@And("Update ASN File With Four LPNs{string}")
	public void updateASNFileWithFourLPNsAndItems(String fileName) throws Exception {
		String asn = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(AsnId)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ASN", asn);

		String lpn = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(LpnId)"));
//		String items = getDataFromFeature("getdata(Items)");
//		String[] splitItems = items.split(",");
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ILPN1", lpn);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ILPN2", lpn + 1);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ILPN3", lpn + 2);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ILPN4", lpn + 3);
		FrameworkLogger.log(LogType.INFO, "Set value for ILPN1 : " + lpn);
		FrameworkLogger.log(LogType.INFO, "Set value for ILPN2 : " + lpn + 1);
		FrameworkLogger.log(LogType.INFO, "Set value for ILPN3 : " + lpn + 2);
		FrameworkLogger.log(LogType.INFO, "Set value for ILPN4 : " + lpn + 3);

		List<String> listOfILPNs = new ArrayList<>();
		listOfILPNs.add(lpn);
		listOfILPNs.add(lpn + 1);
		listOfILPNs.add(lpn + 2);
		listOfILPNs.add(lpn + 3);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "listOfILPNs", listOfILPNs);
		String lpns = String.join(",", listOfILPNs);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "Lpns", lpns);
		ArrayList<String> al = new ArrayList<>();
		al.add("ASN::2::3::" + asn);
		al.add("LPN::2::2::" + lpn);
		al.add("LPN::3::2::" + lpn + 1);
		al.add("LPN::4::2::" + lpn + 2);
		al.add("LPN::5::2::" + lpn + 3);
		al.add("LPN::2::6::" + asn);
		al.add("LPN::3::6::" + asn);
		al.add("LPN::4::6::" + asn);
		al.add("LPN::5::6::" + asn);
		al.add("LpnDetail::2::2::" + lpn);
		al.add("LpnDetail::3::2::" + lpn + 1);
		al.add("LpnDetail::4::2::" + lpn + 2);
		al.add("LpnDetail::5::2::" + lpn + 3);
//		al.add("LpnDetail::2::6::" + item1);
//		al.add("LpnDetail::3::6::" + item1);
//		al.add("LpnDetail::4::6::" + item3);
//		al.add("LpnDetail::5::6::" + item3);
		ExcelUtil1.setMultipleCellData(fileName, al);
	}

	@And("Update order File With order in four rows {string}")
	public void updateOrderFileWithOrderInFourRows(String fileName) throws Exception {
		String originalOrder = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(OriginalOrderID)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder", originalOrder);
		FrameworkLogger.log(LogType.INFO, "Set value for original order : " + originalOrder);
		ArrayList<String> al = new ArrayList<>();
		al.add("OriginalOrder::2::3::" + originalOrder);
		al.add("OriginalOrderLine::2::2::" + originalOrder);
		al.add("OriginalOrderLine::3::2::" + originalOrder);
		al.add("OriginalOrderLine::4::2::" + originalOrder);
		al.add("OriginalOrderLine::5::2::" + originalOrder);
		ExcelUtil1.setMultipleCellData(fileName, al);
	}

	@And("Verify multiple Ilpns Data In Inventory Details_with ListOfItems")
	public void verifyMultipleIlpnsDataInInventoryDetails_withListOfItems() {
		InventoryDetailsPage.verifyMultipleItemDetailsInventoryDetailsPage_FromListOfItems();
	}

	@And("Filter by Inventory Details with InventoryReservation and Location Type")
	public void filterByInventoryDetailsInventoryReservationAndLocationType() {
		InventoryDetailsPage.filterLocationType(getDataFromFeature("getdata(LocationType)"));
		InventoryDetailsPage.filterInventoryReservationType(getDataFromFeature("getdata(InventoryReservationType)"));
	}

	@And("Select selection criteria, cubing and verify Selected Cubing Strategy")
	public void ClickOrderSelectionCriteriaCubing_AndVerifySelectedCubingStrategy() {
		OrdersPage.selectOrderSelectionCriteria();
		CommonMethods.waitForPageLoading();
		CommonPage.selectContinueButton();
		CommonMethods.waitForPageLoading();
		OrdersPage.selectCubing();
		OrdersPage.getSelectedCubingStrategy(getDataFromFeature("getdata(CubingStrategy)"));
	}

	@And("Navigate to Item Template Page")
	public void navigateToItemTemplatePage() {
		HomePage.navigateToItemTemplatePage();
	}

	@And("Navigate to Allocation Strategy")
	public void navigateToAllocationStrategy() {
		HomePage.navigate_to_AllocationStrategy();
		OriginalOrdersPage.verifyAllocationStrategyPage();
	}

	@And("View FNCubing Allocation Strategy {string}")
	public void viewFNCubingAllocationStrategy(String text) {
		OrdersPage.filterByNameAllocationStrategy(getDataFromFeature(text));
		CommonPage.clickRowAtFirstIndex();
		Cubing.selectViewButton();
		CommonMethods.waitForPageLoading();

	}

	@And("View FNCUBING wave Strategy")
	public void viewFNCUBINGWaveStrategy() {
		Cubing.selectFNCUBING06OrderStrategy();
		// CommonPage.clickRowAtFirstIndex();
		CommonPage.selectThreeDots();
		CommonPage.selectViewButton();
	}

	@And("Select Allocation Zone Priorities")
	public void selectAllocationZonePriorities() {

		Cubing.selectOrderCriteriaSideArrow();
		Cubing.selectOrderCriteriaViewButton();
		Cubing.selectAllocationZonePriorities();

	}

	@And("Navigate back to Cubing Strategy")
	public void navigateBackToCubingStrategy() {
		HomePage.navigate_Backto_CubingStrategy();
		OriginalOrdersPage.verifyCubingStrategyPage();
	}

	@And("View CubeByUOMCriteria Cubing Method")
	public void viewCubeByUOMCriteriaCubingMethod() {
		Cubing.selectCubeByUOMCriteria();
		Cubing.ExpandSideArrow();
		CommonPage.selectViewButton();
		Cubing.selectCubingCriteriaRules();
		Cubing.backToCubingStrategy();
	}

	@And("View the Cube To Capacity Criteria")
	public void viewTheCubeToCapacityCriteria() {

		Cubing.selectCubeToCapacityCriteria();
		Cubing.expandSideArrow1();
		CommonPage.selectViewButton();
		Cubing.selectCubingMethod();
		Cubing.selectResidualCubingParameters();
	}

	@And("Navigate back to Order Planning Strategy")
	public void navigateBackToOrderPlanningStrategy() {
		HomePage.navigateBack_to_OrderPlanningStrategy();
		OriginalOrdersPage.verifyOrderPlanningStrategyPage();
	}

	@And("Run FNCUBING wave Strategy {string}")
	public void runFNCUBINGWaveStrategy(String text) {
		OrdersPage.filterByNameWaveStrategy(getDataFromFeature(text));
		CommonPage.clickRowAtFirstIndex();
		Cubing.runWave();
	}

	@And("Store Serial Numbers to runtime variables as list")
	public static void storeSerialNumberToList() {
		InventoryDetailsPage.storeSerialNumberToList();
	}

	@And("Enter Serial Numbers in cycle count screen")
	public void enterSerialNumberInCycleCountScreen() {
		ReceiveLPNLevel.completeSeedCycleCountIdSerialNumber();
	}

	@And("Complete Cycle count with Quantitymismatch and Serial Number")
	public void completeCycleCountWithQuantitymismatchAndSerialNumber() {
		CommonWMMobilePage.enterScanLocation(getDataFromFeature(getData("ScanLocationId")));
		CommonWMMobilePage.clickGoButton();
		InventoryDetailsPage.clickConfirmButton();
		InventoryDetailsPage.clickContinuecountactionButton();
		CommonWMMobilePage.enterScanItem(getDataFromFeature(getData("ItemId")));
		CommonWMMobilePage.clickGoButton();
		InventoryDetailsPage.clickConfirmButton();
		LocationInventory.enterLowerQuantityInCycleCountScreen(2);
		// LocationInventory
		// .ValidateQuantityerror("Quantity Mismatch for Item"
		// +getDataFromFeature(getData("Item"))+". Attribute capture required
		// (INM::706)");
		LocationInventory.validateQuantityErrorMessage("Quantity Mismatch for Item "
				+ getDataFromFeature(getData("Item")) + ". Attribute capture required (INM::706)");
		CommonWMMobilePage.enterScanItem(getDataFromFeature(getData("ItemId")));
		CommonWMMobilePage.clickGoButton();
		CommonWMMobilePage.enterInventoryType(getDataFromFeature(getData("InventoryTypeId")));
		CommonWMMobilePage.clickGoButton();
		CommonWMMobilePage.enterProductStatus(getDataFromFeature(getData("ProductStatusId")));
		CommonWMMobilePage.clickGoButton();
		LocationInventory.enterLowerQuantityInCycleCountScreen(2);
		// ReceiveLPNLevel.enterQuantity(Integer.parseInt((String)
		// Variables.get(CurrentThreadInstance.getCurrentScenarioId() +
		// "CurrentOnhandQuantity")));
		ReceiveLPNLevel.completeSeedCycleCountIdSerialNumber();
	}

	@And("Get generated PIX Data JSON View for the cycle count")
	public void getPixDataFromCycleCount() {
		PixVisibilityPage.clickFirstPixVisibilityCard();
		FooterPanelPage.clickPixDataButton();
		ViewJsonPage.getJSONViewPIXData();
		/*
		 * ViewJsonPage.getCountPixAttribute(); int pixDataAttribute = (int)
		 * Variables.get(CurrentThreadInstance.getCurrentScenarioId() +
		 * "resultCountAttributeName"); for (int i = 1; i <= pixDataAttribute; i++) {
		 * ViewJsonPage.storePIXDataInventoryAttributes(i); }
		 */
		CommonPopupPage.clickCloseIcon();

	}

	@And("Wait for wave to load")
	public void waitForWaveToLoad() throws InterruptedException {
		Thread.sleep(120000);
	}

	@And("Filter ILPNS by Status and Item {string} and {string}")
	public void filterILPNSByStatusAndItem(String strText1, String strText2) {
		ILPNs.filterLPNByStatus(getDataFromFeature(strText1));
		ILPNs.filterLPNByItem(getDataFromFeature(strText2));

	}

	@And("Update ItemId for Putaway based on volume in {string}")
	public void updateItemIdForPutawayBasedOnVolumeInPUTAWAYItemXlsx(String fileName) throws Exception {
		String Item = ExcelUtil.convert_variable_to_timestamp(getDataFromFeature("getdata(Item)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "Item", Item);
		FrameworkLogger.log(LogType.INFO, "Set value for Item : " + Item);
		ArrayList<String> al = new ArrayList<>();
		al.add("Item::2::3::" + Item);
		al.add("Item::2::38::" + Item.replaceAll("-", ""));
		al.add("ItemPackage::2::2::" + Item);
		al.add("ItemPackage::3::2::" + Item);
		al.add("ItemPackage::4::2::" + Item);
		al.add("ItemPackage::5::2::" + Item);
		ExcelUtil1.setMultipleCellData(fileName, al);
	}

	@And("Add Item with variable {string} to Location")
	public void addItemWithVariableItemToLocation(String item) {
		StorageLocation.addItemToLocation((String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + item));
	}

	@And("Update ItemId {string}")
	public void updateItemIdCOUNTItemXlsx(String fileName) throws Exception {
		String Item = ExcelUtil.convert_variable_to_timestamp(getDataFromFeature("getdata(Item)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "Item", Item);
		FrameworkLogger.log(LogType.INFO, "Set value for Item : " + Item);
		ArrayList<String> al = new ArrayList<>();
		al.add("Item::2::3::" + Item);
		al.add("Item::2::38::" + Item.replaceAll("-", ""));
		al.add("ItemPackage::2::2::" + Item);
		al.add("ItemPackage::3::2::" + Item);
		al.add("ItemPackage::4::2::" + Item);
		ExcelUtil1.setMultipleCellData(fileName, al);
	}

	@And("Search with Location")
	public void searchWithLocation() {
		String location = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "Location");
		LocationInventory.searchLocation(location);
	}

	@And("Search with Item Filter")
	public void searchWithItemFilter() {
		String Item = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "Item");
		LocationInventory.searchItem(Item);
	}

	@And("Update ASN file with LPN and Item {string}")
	public void updateASNFileWithLPNAndItem(String fileName) throws Exception {
		String asnId = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(AsnId)"));
		String lpnId = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(LpnId)"));
		String item = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "Item");
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ASN", asnId);
		FrameworkLogger.log(LogType.INFO, "Set value for ASN : " + asnId);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN", lpnId);
		FrameworkLogger.log(LogType.INFO, "Set value for LPN : " + lpnId);
		ArrayList<String> al = new ArrayList<>();
		al.add("Asn::2::3::" + asnId);
		al.add("Lpn::2::6::" + asnId);
		al.add("Lpn::2::2::" + lpnId);
		al.add("LpnDetail::2::2::" + lpnId);
		al.add("LpnDetail::2::6::" + item);
		ExcelUtil1.setMultipleCellData(fileName, al);
	}

	@And("Enter ILPN and Location AT User Directed PutAway")
	public void enterILPNAndLocationATUserDirectedPutAway() {
		String ilpn = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "LPN1");
		String location = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "Location");
		location = location.replaceAll("-", "");
		String quantity = getDataFromFeature("getdata(Quantity1)");
		UserDirected.searchLPN(ilpn);
		UserDirected.enterQuantity(quantity);
		UserDirected.enterScanLocationWithWarning(location);

	}

	@And("Scan Location in Cycle count")
	public void scanLocationInCycleCount() {
		String location = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "Location");
		location = location.replaceAll("-", "");
		LocationInventory.EnterLocation(location);
	}

	@And("Scan Item in Cycle count")
	public void scanItemInCycleCount() {
		String Item = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "Item");
		Item = Item.replaceAll("-", "");
		LocationInventory.EnterItem(Item);
	}

	@And("Create {string} iLPN with Batch Number")
	public void createILPNWithBatchNumber(String count) {
		CreateILPN.createILPNWithBachNumber(Integer.valueOf(getDataFromFeature(count)));
	}

	@And("Complete ATStandardReceiving with ASN and multiple LPNs with Serial Numbers and Batch Number")
	public void completeATStandardReceivingWithMultipleLPNsWithBatchAndSerialNumbers() {
		ATStandardReceiving.completeATStandardReceivingWithMultipleLPNsWithBatchAndSerialNumbers();

	}

	@And("Assign Task to current user")
	public void assignTaskToCurrentUser() {
		String strUsername = ConfigurationUtils.getFrameworkConfig("appusername");
		TasksPage.assignTaskDetails(strUsername);

	}

	@And("Complete Packing in AT Pick OLPN With Serial Number")
	public static void completePackingATPickToOlpnWithSerialNumber() {
		PickPackLPNPage.completeATPickToOlpnWithSerialNumber();

	}

	@And("Complete action Ship Confirm")
	public void completeActionShipConfirm() {
		OrdersPage.verifyShipConfirm();
	}

	@And("Navigate to Olpns 2.0")
	public void navigateToOLPNs2_0() {
		HomePage.navigateToOLPNS2_O();
		Olpns.verifyoLPNSPageDisplayed();
	}

	@And("Verify each Serial Number in OLPN 2.0 Cardview")
	public void verifyOlpnSerialNumberInOlpnsCard() {
		List<String> listOFoLPNs = (List<String>) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "OLPN");
		int j = 1;
		for (String oLPN : listOFoLPNs) {
			Olpns.clickOLPNCardInOLPN(oLPN);
			Olpns.expandOlpnDetails();
			waitForPageLoading();
			Olpns.checkOlpnDetailCheckbox();
			Olpns.expandOlpnDetailsAttributes();
			waitForPageLoading();
			Olpns.validateSerialNumber(
					(String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "serialNumber" + j));
			Olpns.clickCloseIconOlpnDetails();
			FooterPanelPage.clickDeselectButton();
			j++;
		}
	}

	@And("Verify Inventory details for each LPN with Batch Number")
	public void verifyInventoryDetailsForEachLPNWithBatchNumber() {
		ILPNs.verifyInventoryDetailsForEachLPNWithBatchNumber();
	}

	@And("Verify Allocation details")
	public void verifyAllocationDetails() {
		AllocationPage.verifyAllocationDetails();
	}

	@And("Verify atleast {string} replenishment is created")
	public void verifyAtleastReplenishmentIsCreated(String count) {
		AllocationPage.verifyReplenishmentCount(count);
	}

	@And("Verify atleast {string} pick_pack is created")
	public void verifyAtleastPick_packIsCreated(String count) {
		AllocationPage.verifyPickPackCount(count);
	}

	@And("Verify ASN Details in Related Links")
	public void verifyASNDetailsInRelatedLinks() {
		ASNs.selectASNCard(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN").toString());
		ASNs.selectASNDetailRelatedLink();
		ASNs.verifyInventoryAttributesCard1();
		ASNs.verifyAsnLineInventoryAttribute();
		ASNDetailsPage.closeASNLinePopup();
		ASNs.selectASNsBreadcrumb();
	}

	@And("Verify Product status OnHand Quantity and Inventory type")
	public void verifyProductStatusOnHandQuantityAndInventoryType() {
		ILPNPopupPage.verifyProductStatusinpop(getDataFromFeature("getData(ProductStatus_Line1)"));
		ILPNPopupPage.verifyInventorytypeinpop(getDataFromFeature("getData(inventory_Line1)"));
		ILPNPopupPage.verifyOnHandQuantity(getDataFromFeature("getData(OrdQty_Line)"));
	}

	/*
	 * @And("Validate popup message {string}") public void
	 * validate_popup_message(String strMsg) {
	 * PopupWrapper.validatePopupMessage(strMsg); }
	 */

	/*
	 * @And("Verify Blind receiving") public void verify_blind_receiving() {
	 * PopupWrapper.BlindPopupMessage(); }
	 */
	@And("Close browser window And Switch to Last Window")
	public void closeBrowserWindowAndSwitchToLastWindow() {
		CommonMethods.waitForPageLoading();
		SeleniumActions.closeBrowser();
		SeleniumActions.switchToLastWindow();
		CommonMethods.waitForPageLoading();
	}

	/*
	 * @And("Verify Inventry updated") public void verify_inventry_updated() { //
	 * SeleniumActions.switchToWindowUsingIndex(0);
	 * HomePage.navigate_to_StorageLocation();
	 * StorageLocation.saveCurrentQuantity("CurrentQtyUpdated"); if
	 * (Integer.parseInt(Variables.get(CurrentThreadInstance.getCurrentScenarioId()
	 * + "CurrentQtyBeforeUpdate") .toString()) < Integer.parseInt(
	 * Variables.get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "CurrentQtyUpdated").toString())) { FrameworkLogger.log(LogType.PASS,
	 * "Current Quantity value is updated"); //
	 * SeleniumActions.switchToLastWindow(); // SeleniumActions.closeBrowser(); //
	 * SeleniumActions.switchToLastWindow(); } else {
	 * FrameworkLogger.log(LogType.FAIL, "Current Quantity is not updated"); } }
	 */

	/*
	 * @And("Complete ATStandardReceiving duplicate lines") public void
	 * complete_at_standard_receiving_duplicate_lines() {
	 * ReceiveLPNLevel.searchASN(Variables.get(CurrentThreadInstance.
	 * getCurrentScenarioId() + "ASN").toString());
	 * ReceiveLPNLevel.atStandardReceiving(null, 1,
	 * getDataFromFeature("getdata(OrdQty_Line1)"));
	 * ReceiveLPNLevel.atStandardReceiving(null, 2,
	 * getDataFromFeature("getdata(OrdQty_Line2)"));
	 * ReceiveLPNLevel.verifyErrorNotDisplayed(); }
	 */

	/*
	 * @And("Complete ATStandardReceiving With Serial Number") public void
	 * complete_at_standard_receiving_serial_number() {
	 * ReceiveLPNLevel.searchASN(Variables.get(CurrentThreadInstance.
	 * getCurrentScenarioId() + "ASN").toString()); ReceiveLPNLevel.enterLPN(null,
	 * 1);
	 * ReceiveLPNLevel.enterScanItem(getDataFromFeature("getdata(ItemID_Line1)"));
	 * ReceiveLPNLevel.searchProductStatus(null);
	 * ReceiveLPNLevel.searchProductStatus(null);
	 * ReceiveLPNLevel.enterQuantity(Integer.parseInt(getDataFromFeature(
	 * "getdata(OrdQty_Line1)"))); int iRecieveLoop =
	 * Integer.parseInt(getDataFromFeature("getdata(OrdQty_Line1)")); String
	 * strSerial = RandomUtils.generateString_WithTimeStamp("SN", "yyMMddmmhhmm");
	 * for (int iReceive = 1; iReceive <= iRecieveLoop; iReceive++) { String
	 * strSerial1 = strSerial + iReceive;
	 * ReceiveLPNLevel.enterSerialNumber(strSerial1);
	 * Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "SerialNumber" +
	 * iReceive, strSerial1); } ReceiveLPNLevel.verifyErrorNotDisplayed(); }
	 */

	@And("GF_Complete ATStandardReceiving With Serial Number")
	public void gf_complete_at_standard_receiving_serial_number() {
		ReceiveLPNLevel.searchASN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN").toString());
		ReceiveLPNLevel.enterLPN(null, 1);
		ReceiveLPNLevel.enterScanItem(getDataFromFeature("getdata(ItemID_Line1)"));
		// ReceiveLPNLevel.searchProductStatus(null);
		// ReceiveLPNLevel.searchProductStatus(null);
		ReceiveLPNLevel.enterQuantity(Integer.parseInt(getDataFromFeature("getdata(OrdQty_Line1)")));
		int iRecieveLoop = Integer.parseInt(getDataFromFeature("getdata(OrdQty_Line1)"));
		String strSerial = RandomUtils.generateString_WithTimeStamp("SN", "yyMMddmmhhmm");
		for (int iReceive = 1; iReceive <= iRecieveLoop; iReceive++) {
			String strSerial1 = strSerial + iReceive;
			ReceiveLPNLevel.enterSerialNumber(strSerial1);
			Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "SerialNumber" + iReceive, strSerial1);
		}
		ReceiveLPNLevel.verifyErrorNotDisplayed();
	}

	@And("Complete ATStandardReceiving With Serial Number in ALLOC")
	public void complete_at_standard_receiving_serial_number_in_alloc() {
		ReceiveLPNLevel.searchASN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN").toString());
		ReceiveLPNLevel.enterLPN(null, 1);
		ReceiveLPNLevel.enterScanItem(getDataFromFeature("getdata(ItemID_Line1)"));
		ReceiveLPNLevel.searchProductStatus(null);
		ReceiveLPNLevel.searchProductStatus(null);
		ReceiveLPNLevel.enterQuantity(Integer.parseInt(getDataFromFeature("getdata(OrdQty_Line1)")));
		int iRecieveLoop = Integer.parseInt(getDataFromFeature("getdata(OrdQty_Line1)"));
		String strSerial = RandomUtils.generateString_WithTimeStamp("SN0", "yyMMddmm");
		for (int iReceive = 1; iReceive <= iRecieveLoop; iReceive++) {
			String strSerial1 = strSerial + iReceive;
			ReceiveLPNLevel.enterSerialNumber(strSerial1);
			Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "SerialNumber" + iReceive, strSerial1);
		}
		ReceiveLPNLevel.verifyErrorNotDisplayed();
	}

	/*
	 * @And("Complete AT BlindReceiving") public void complete_at_blind_receiving()
	 * { ReceiveLPNLevel.searchASN(null); ReceiveLPNLevel.enterLPN(null, 1);
	 * ReceiveLPNLevel.enterScanItem(getDataFromFeature("getdata(ItemID_Line1)"));
	 * ReceiveLPNLevel.enterBatchnumber(getDataFromFeature("getdata(BatchNo_Line1)")
	 * ); ReceiveLPNLevel.enterQuantity(Integer.parseInt(getDataFromFeature(
	 * "getdata(OrdQty_Line1)"))); }
	 */
	/*
	 * @And("Verify variance and Accept") public void verify_variance_and_accept() {
	 * PopupWrapper.validateVarianceMessage("Variance exists for ASN " +
	 * Variables.get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "ASN").toString() + "."); }
	 */
	/*
	 * @And("Positive Quantity Adjustment") public void
	 * positive_quantity_adjustment() { ModifyiLPN.verifyPageDisplayed(); String
	 * strLPN = Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "LPN" +
	 * 1).toString(); ModifyiLPN.searchLPN(strLPN);
	 * ModifyiLPN.readCurrentQuantity(); int iQuantityValue = Integer
	 * .parseInt(Variables.get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "CurrentQty").toString()) +
	 * Integer.parseInt(getDataFromFeature("getdata(PositiveQtyIncrement)"));
	 * Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "AdjustedValue",
	 * iQuantityValue); ModifyiLPN.updateQuantity(iQuantityValue);
	 * ModifyiLPN.updateCodesQuantity(); SeleniumActions.closeBrowser();
	 * SeleniumActions.switchToLastWindow(); }
	 */
	/*
	 * @And("Negative Quantity Adjustment") public void
	 * negative_quantity_adjustment() { ModifyiLPN.verifyPageDisplayed(); String
	 * strLPN = Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "LPN" +
	 * 1).toString(); ModifyiLPN.searchLPN(strLPN);
	 * ModifyiLPN.readCurrentQuantity(); int iCurrentQuantity = Integer
	 * .parseInt(Variables.get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "CurrentQty").toString()); if (iCurrentQuantity >
	 * Integer.parseInt(getDataFromFeature("getdata(NegativeQtyDecrement)"))) { int
	 * iQuantityValue = iCurrentQuantity -
	 * Integer.parseInt(getDataFromFeature("getdata(NegativeQtyDecrement)"));
	 * Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "AdjustedValue",
	 * iQuantityValue); ModifyiLPN.updateQuantity(iQuantityValue);
	 * ModifyiLPN.updateCodesQuantity(); } else { FrameworkLogger.log(LogType.FAIL,
	 * Integer.parseInt(getDataFromFeature("getdata(NegativeQtyDecrement)")) +
	 * "requested quantity cannot be updated"); } SeleniumActions.closeBrowser();
	 * SeleniumActions.switchToLastWindow();
	 * 
	 * }
	 */
	/*
	 * @And("Validate Quantity Adjustment") public void
	 * validate_quantity_adjustment() {
	 * ILPNs.searchLPN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "LPN" + 1).toString()); ILPNs.navigateToLocationInventory();
	 * ILPNs.validateCurrentQuantity(); }
	 */

	/*
	 * @And("Search Display location at Location Inventory") public void
	 * search_display_location_at_location_inventory() {
	 * LocationInventory.searchDisplayLocation(getDataFromFeature(
	 * "getdata(DisplayLocation)"), true); }
	 */

	/*
	 * @And("Search Display location With {string} in Location Inventory") public
	 * void searchDisplayLocationWithInLocationInventory(String location) {
	 * LocationInventory.searchDisplayLocation(getDataFromFeature(location), false);
	 * }
	 */

	/*
	 * @And("Complete ATStandardReceiving and Validate Quantity exceeds error")
	 * public void
	 * complete_at_standard_receiving_and_validate_quantity_exceeds_error() {
	 * ReceiveLPNLevel.searchASN(Variables.get(CurrentThreadInstance.
	 * getCurrentScenarioId() + "ASN").toString()); float iReceiveFloat =
	 * Integer.valueOf(getDataFromFeature("getdata(OrdQty_Line1)")) /
	 * Integer.valueOf(getDataFromFeature("getdata(QtyToAssign_Line1_Valid)")); int
	 * iRecieveLoop = (int) iReceiveFloat; for (int iReceive = 0; iReceive <=
	 * iRecieveLoop; iReceive++) { if (iReceive < iRecieveLoop) {
	 * FrameworkLogger.log(LogType.PASS, iReceive + " Loop " + iRecieveLoop);
	 * ReceiveLPNLevel.atStandardReceiving(null, iReceive,
	 * getDataFromFeature("getdata(QtyToAssign_Line1_Valid)"));
	 * ReceiveLPNLevel.verifyErrorNotDisplayed(); } if (iReceive == iRecieveLoop) {
	 * FrameworkLogger.log(LogType.PASS, iReceive + " error Loop " + iRecieveLoop);
	 * ReceiveLPNLevel.atStandardReceiving(null, iReceive,
	 * getDataFromFeature("getdata(QtyToAssign_Line1_InValid)"));
	 * ReceiveLPNLevel.verifyErrorDisplayed(); } } }
	 */

	@And("Navigate to Items Page")
	public void navigateToItemsPage() {
		HomePage.navigateToItemsPage();
	}

	@And("Search Item With {string}")
	public void searchItemWith(String text) {
		LeftPanelPage.searchItem(getDataFromFeature(text));
	}

	@And("Update ASN export file {string}")
	public void updateASNExportFile(String fileName) throws Exception {
		String asnId = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(ASN)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ASN", asnId);
		FrameworkLogger.log(LogType.INFO, "Set value for ASN : " + asnId);
		ArrayList<String> al = new ArrayList<>();
		al.add("Asn::2::3::" + asnId);
		al.add("AsnLine::2::2::" + asnId);
		ExcelUtil1.setMultipleCellData(fileName, al);

	}

	/*
	 * @And("Complete ATStandardReceiving with produtstatus") public void
	 * completeATStandardReceivingWithProdutstatus() {
	 * ReceiveLPNLevel.searchASN(Variables.get(CurrentThreadInstance.
	 * getCurrentScenarioId() + "ASN").toString());
	 * ReceiveLPNLevel.enterLPN(ExcelUtil1.convert_variable_to_timestamp(
	 * getDataFromFeature("getdata(LPNId)")));
	 * ReceiveLPNLevel.enterScanItem(getDataFromFeature("getdata(ItemID_Line1)"));
	 * ReceiveLPNLevel.searchInventory("F");
	 * ReceiveLPNLevel.searchProductStatus("A"); }
	 */

	@And("Update ASN import file with batch number and expiry date {string}")
	public void updateASNImportFileWithBatchNumberAndExpiryDateRCV(String fileName) throws Exception {

		String AsnIdValue = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(ASN)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ASN", AsnIdValue);
		FrameworkLogger.log(LogType.INFO, "Set value for ASNID : " + AsnIdValue);
		ArrayList<String> al = new ArrayList<>();
		al.add("Asn::2::3::" + AsnIdValue);
		al.add("AsnLine::2::2::" + AsnIdValue);
		al.add("AsnLine::2::10::" + getDataFromFeature("getdata(BatchNo_Line1)"));
		al.add("AsnLine::2::13::" + getDataFromFeature("getdata(ExpiryDate_Line1)"));
		ExcelUtil1.setMultipleCellData(fileName, al);
	}

	@And("Update ASN export file with batch number {string}")
	public void updateASNExportFileWithBatchNumberRCVXlsx(String fileName) throws Exception {

		String AsnIdValue = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(ASN)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ASN", AsnIdValue);
		FrameworkLogger.log(LogType.INFO, "Set value for ASNID : " + AsnIdValue);
		ArrayList<String> al = new ArrayList<>();
		al.add("Asn::2::3::" + AsnIdValue);
		al.add("AsnLine::2::2::" + AsnIdValue);
		al.add("AsnLine::2::10::" + getDataFromFeature("getdata(BatchNo_Line1)"));
		ExcelUtil1.setMultipleCellData(fileName, al);

	}

	@And("Update ASN export file with LPN Receiving Parent LPN {string}")
	public void updateASNExportFileWithLPNReceivingParentLPNRCV(String fileName) throws Exception {

		String asnId = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(ASN)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ASN", asnId);
		FrameworkLogger.log(LogType.INFO, "Set value for ASN : " + asnId);
		String LPNIdValue = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(LPNId)"));

		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "lpn1Id", LPNIdValue + 1);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "lpn2Id", LPNIdValue + 2);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "parentlpnId", LPNIdValue + 3);
		FrameworkLogger.log(LogType.INFO, "Set value for LPN1 : " + LPNIdValue + 1);
		FrameworkLogger.log(LogType.INFO, "Set value for LPN2 : " + LPNIdValue + 2);
		FrameworkLogger.log(LogType.INFO, "Set value for LPN3 : " + LPNIdValue + 3);

		ArrayList<String> al = new ArrayList<>();
		al.add("Asn::2::3::" + asnId);
		al.add("Lpn::2::2::" + LPNIdValue + 1);
		al.add("Lpn::3::2::" + LPNIdValue + 2);
		al.add("Lpn::4::2::" + LPNIdValue + 3);
		al.add("Lpn::2::6::" + asnId);
		al.add("Lpn::3::6::" + asnId);
		al.add("Lpn::4::6::" + asnId);
		al.add("Lpn::2::16::" + LPNIdValue + 3);
		al.add("Lpn::3::16::" + LPNIdValue + 3);
		al.add("LpnDetail::2::2::" + LPNIdValue + 1);
		al.add("LpnDetail::3::2::" + LPNIdValue + 2);
//		al.add("LpnDetail::4::2::" + lpnId + 3);
		ExcelUtil1.setMultipleCellData(fileName, al);

	}

	@And("Click on View button for First PutAway")
	public void clickOnViewButtonForFirstPutAway() {
		PutAwayPlanningStrategyPage.clickCloseIconForPutAwayAtFirstIndex();
		PutAwayPlanningStrategyPage.clickViewButton2();
	}

	@Then("Verify Determination Mode as {string}")
	public void verifyDeterminationModeAsZoneBasedLocationDetermination(String text) {
		if (getDataFromFeature(text).equalsIgnoreCase("Zone Based Location Determination")) {
			PutAwayPlanningStrategyPage.verifyZoneBasedLocationDetermination(getDataFromFeature(text));
		}
	}

	@And("Click on View button for {string} PutAway Planning Strategy Item")
	public void clickOnViewButtonForPutAwayPlanningStrategyItem(String text) {
		if (text.contains("getdata")) {
			text = getDataFromFeature(text);
		}
		if (text.equalsIgnoreCase("FN")) {
			PutAwayPlanningStrategyPage.clickCloseIconForFNPutAwayPlanningStrategy();
		}
		if (text.equalsIgnoreCase("AT")) {
			PutAwayPlanningStrategyPage.clickCloseIconForATPutAwayPlanningStrategy();
		}
		PutAwayPlanningStrategyPage.clickViewButton();
	}

	@And("Click on View button for {string} PutAway Planning Criteria Item")
	public void clickOnViewButtonForPutAwayPlanningCriteriaItem(String text) {
		if (text.contains("getdata")) {
			text = getDataFromFeature(text);
		}
		if (text.equalsIgnoreCase("BOOKS")) {
			PutAwayPlanningStrategyPage.clickCloseIconForBooksPutAwayPlanningCriteriaItem();
		}
		if (text.equalsIgnoreCase("QR")) {
			PutAwayPlanningStrategyPage.clickCloseIconForQR1PutAwayPlanningCriteriaItem();
		}
		if (text.equalsIgnoreCase("R-BU01")) {
			PutAwayPlanningStrategyPage.clickCloseIconForRBU01PutAwayPlanningCriteriaItem();
		}
		PutAwayPlanningStrategyPage.clickViewButton();
	}

	@Then("Verify ILPNs displayed without current location in ILPN Page")
	public void verifyILPNsDisplayedWithoutCurrentLocationInILPNPage() {
		ILPNs.verifyILPNsDisplayedWithoutCurrentLocationInILPNPage();
	}

	@Then("Verify Product class value as {string}")
	public void verifyProductClassValueAs(String text) {
		CommonPage.clickRowAtFirstIndex();
		FooterPanelPage.clickDetailsButton();
		ItemsPopupPage.clickSpecificationLabel();
		ItemsPopupPage.verifyProductClassValue(getDataFromFeature(text));
		CommonPopupPage.clickCloseIcon();
	}

	@Then("Verify Matching Criteria data displayed")
	public void verifyMatchingCriteriaDataDisplayed() {
		CommonMethods.verifyMatchingCriteriaDataDisplayed();
	}

	@Then("Verify ILPN Current Location")
	public void verifyILPNCurrentLocation() {
		String location = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "CurrentLocation");
		location = location.replaceAll("-", "");
		ILPNs.verifyILPNCurrentLocationAtFirstIndex(location);
	}

	@And("Search Display location")
	public void searchDisplayLocation() {
		String location = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "DisplayLocation");
		LeftPanelPage.searchDisplayLocation(location);
	}

	@And("Verify PutAllocation Zone as {string} in Location Popup Page")
	public void verifyPutAllocationZoneAsGetdataPutAllocationZoneInLocationPopupPage(String text) {
		CommonPage.clickRowAtFirstIndex();
		FooterPanelPage.clickDetailsButton();
		LocationPopupPage.clickZoneAssignmentAndLayoutInformationLabel();
		LocationPopupPage.verifyPutAllocationZoneValue(getDataFromFeature(text));
		LocationPopupPage.clickCloseIcon();
	}

	@And("Update ASN with three lines {string}")
	public void updateASNWithThreeLines(String fileName) throws Exception {
		String asnId = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(AsnId)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ASN", asnId);
		FrameworkLogger.log(LogType.INFO, "Set value for ASN : " + asnId);
		ArrayList<String> al = new ArrayList<>();
		al.add("Asn::2::3::" + asnId);
		al.add("AsnLine::2::2::" + asnId);
		al.add("AsnLine::3::2::" + asnId);
		al.add("AsnLine::4::2::" + asnId);
		ExcelUtil1.setMultipleCellData(fileName, al);
	}

	@And("Verify Product status and Inventory type in ASN Details Page")
	public void verifyProductStatusAndInventoryTypeInASNDetailsPage() {
		HeaderPanelPage.clickRelatedLinksButton();
		HeaderPanelPage.clickASNDetailsLink();
		ASNDetailsPage.verifyProductStatusElementCount(Integer.parseInt(getData("ProductStatusCount")));
		ASNDetailsPage.verifyInventoryTypeElementCount(Integer.parseInt(getData("InventoryTypeCount")));
	}

	@And("Complete FN Trolley Receiving")
	public void completeFNTrolleyReceiving() {
		FNTrolleyReceivingPage.completeFNTrolleyReceiving();
	}

	@Then("Verification attempted for ASN is displayed")
	public void verificationAttemptedForASNIsDisplayed() {
		String asnId = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN");
		FNTrolleyReceivingPage.verifyASNIsDisplayedInConfirmationPopup(asnId);
		CommonPopupPage.clickOkButton();
	}

	@And("Verify {string} LPNs are liked to same pallet")
	public void verifyGetdataLPNsAreLikedToSamePallet(String count) {
		HeaderPanelPage.clickRelatedLinksButton();
		HeaderPanelPage.clickLPNInventory();
		ILPNs.verifyLinkedLPNCountForSamePallet(Integer.parseInt(getDataFromFeature(count)));
	}

	@And("Verify Inventory details for each LPN")
	public void verifyInventoryDetailsForEachLPN() {
		ILPNs.verifyInventoryDetailsForEachLPN();
	}

	@And("Complete FN Trolley PutAway")
	public void completeFNTrolleyPutAway() {
		FNTrolleyPutAwayPage.completeFNTrolleyPutAway();
	}

	@And("Verify PutAway ASN details")
	public void verifyPutAwayASNDetails() { //
		// HeaderPanelPage.clickRelatedLinksButton(); Commented by Lohith to maintain //
		// uniformity in coding on 28 Oct 2023 // HeaderPanelPage.clickLPNInventory();
		CommonMethods.waitForPageLoading();
		ILPNs.verifyLinkedLPNCountForSamePallet(0);
		ILPNs.verifyPreviousLocationForEachLPN(3);
		ILPNs.verifyCurrentLocationForEachLPN();
	}

	@And("Expand side arrow button")
	public void expandSideArrowButton() {
		CommonMethods.waitForPageLoading();
		HomePage.ExpandSideArrow();
	}

	@And("Select Today from Quick select filter")
	public void selectTodayFromQuickSelectFilter() {
		InventoryCountPage.SelectTodayFromQuickSelect();
	}

	@And("Navigate to PIX Visibility")
	public void navigateToPIXVisibility() {
		HomePage.navigateToPIXVisibility();
	}

	@And("Select Inventory Adjustment checkbox")
	public void selectInventoryAdjustmentCheckbox() {
		InventoryCountPage.SelectInventoryAdjustmentPIXVisibility();
	}

	@And("Expand PIX Visibility arrow button")
	public void expandPIXVisibilityArrowButton() {
		InventoryCountPage.expandPIXVisibilityArrowButton();
	}

	@And("Select PIX Visibility button")
	public void selectPIXVisibilityButton() {
		InventoryCountPage.SelectPIXVisibilitywButton();
	}

	@And("Expand Filter")
	public void expandFilter() {
		InventoryDetailsPage.
		/**
		 * Function to click on end count button
		 */
				ExpandFilter();
	}

	@And("Store Expiry date to variable")
	public void storeExpiryDateToVariable() {
		InventoryDetailsPage.StoreExpiryDate();
	}

	/**
	 * To enter Expiry date in DDMMYYYY format
	 */
	@And("Enter Expiry date in cycle count screen")
	public void enterExpiryDateInCycleCountScreenInDDMMYYYY() {
		String text = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "StoreExpiryDate");
		String[] text1 = text.split("/");
		String day = text1[0];
		String month = text1[1];
		String year = text1[2];
		String last2 = year.substring(2, 4);
		WMMobile.enterExpiryDate(day, month, last2);
		TasksPage.clickGoButton();
	}

	@And("Click on Count Run ID")
	public void clickOnCountRunID() {
		InventoryCountPage.clickCountRunId();
	}

	@And("Navigate back to Inventory Count window")
	public void navigateBackToInventoryCountWindow() {
		InventoryCountPage.goBackToInventoryCount();
	}

	@And("Create Cycle Count task")
	public void createCycleCountTask() {
		InventoryCountPage.CreateCycleCountTask();
	}

	@And("Click on Yes button")
	public void clickOnYesButton() {
		BatchMasterPage.clickYesButtonInHoldPopup();
	}

	@And("Select Cycle count checkbox filter")
	public void selectCycleCountCheckboxFilter() {
		InventoryCountPage.SelectCycleCountCheckbox();
	}

	@And("Click on More Actions button")
	public void clickOnMoreActionsButton() {
		TasksPage.moreActionsButton();
	}

	@And("Click on Cancel option")
	public void clickOnCancelOption() {
		TasksPage.CancelOption();
	}

	@And("Store generated ASN number in runtime variable")
	public void storeGeneratedASNNumberInRuntimeVariable() {
		ASNs.storeGeneratedAsnNumberToString();
	}

	@And("Enter Batch Number manually {string}")
	public void enterBatchNumberManually(String text) {
		ASNs.enterBatchNumberManually(getDataFromFeature(text));
	}

	@And("Complete ATStandardReceiving Without Serial Number")
	public void completeATStandardReceivingWithoutSerialNumber() {
		ReceiveLPNLevel.searchASN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN").toString());
		ReceiveLPNLevel.enterLPN(null, 1);
		ReceiveLPNLevel.enterScanItem(getDataFromFeature("getdata(ItemID_Line1)"));
		ReceiveLPNLevel.searchProductStatus(null);
		ReceiveLPNLevel.searchProductStatus(null);
		ReceiveLPNLevel.enterQuantity(Integer.parseInt(getDataFromFeature("getdata(OrdQty_Line1)")));
	}

	@And("Click on Import DataLoader")
	public void clickOnImportDataLoader() {
		HeaderPanelPage.clickImportDataLoader();
	}

	@And("Update ASN with ItemID Quantity Status {string}")
	public void updateASNWithItemIDQuantityStatus(String fileName) throws Exception {
		String AsnId = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(AsnId)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ASN", AsnId);
		String itemnumber = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "Item");
		FrameworkLogger.log(LogType.INFO, "Set value item : " + itemnumber);
		// item1 = item1.replaceAll("-", "");
		FrameworkLogger.log(LogType.INFO, "Set value for ASNID : " + AsnId);
		ArrayList<String> al = new ArrayList<>();
		al.add("Asn::2::3::" + AsnId);
		al.add("AsnLine::2::2::" + AsnId);
		al.add("AsnLine::2::7::" + itemnumber);
		al.add("AsnLine::2::8::" + getDataFromFeature("getdata(OrdQty_Line1)"));
		al.add("AsnLine::2::19::" + getDataFromFeature("getdata(InventoryTypeID)"));
		al.add("AsnLine::2::20::" + getDataFromFeature("getdata(ProductStatusID)"));
		// al.add("AsnLine::3::2::" + AsnId);
		// al.add("AsnLine::3::7::" + getDataFromFeature("getdata(ItemID_Line_2)"));
		// al.add("AsnLine::3::8::" + getDataFromFeature("getdata(orderLineQuantity)"));
		// al.add("AsnLine::3::19::" + getDataFromFeature("getdata(InventoryTypeID)"));
		// al.add("AsnLine::3::20::" + getDataFromFeature("getdata(ProductStatusID)"));
		ExcelUtil1.setMultipleCellData(fileName, al);
	}

	@And("Update Original Order with Order and Item {string}")
	public void updateOriginalOrderWithOrderAndItem(String fileName) throws Exception {
		String strOrderValue = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(OriginalOrderID)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder", strOrderValue);
		FrameworkLogger.log(LogType.INFO, "Set value for Original Order : " + strOrderValue);
		String itemnumber = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "Item");
		ArrayList<String> al = new ArrayList<>();
		al.add("OriginalOrder::2::3::" + strOrderValue);
		al.add("OriginalOrderLine::2::2::" + strOrderValue);
		al.add("OriginalOrderLine::2::6::" + itemnumber);
		ExcelUtil1.setMultipleCellData(fileName, al);
	}

	@And("Complete ATStandardReceiving without LPNs")
	public void completeATStandardReceivingWithoutLPNs() {
		{
			ReceiveLPNLevel.searchASN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN").toString());
			ReceiveLPNLevel.enterLPN(null, 1);
			String item = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "Item");
			ReceiveLPNLevel.enterScanItem(item.replaceAll("-", ""));
			// ReceiveLPNLevel.enterScanItem(getDataFromFeature("getdata(ItemID_Line1)"));
			ReceiveLPNLevel.enterQuantity(Integer.parseInt(getDataFromFeature("getdata(OrdQty_Line1)")));

		}
	}

	@And("Add Item {string} to the Location")
	public void addItemItemToTheLocation(String item) {
		StorageLocation
				.addItemToImportedLocation((String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + item));

	}

	@Then("Verify LPNs are directed as per Location available capacity")
	public void verifyLPNsAreDirectedAsPerLocationAvailableCapacity() {
		String LPN1 = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ILPN1");
		SystemDirected.searchLPN(LPN1);
		CommonWMMobilePage.verifyLPNIsRedirectedTotheLocation(
				(String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "Location"));

		SystemDirected.clickBackButton();
		SystemDirected.searchLPNScanContainer(
				Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ILPN2").toString());
		CommonWMMobilePage.verifyLPNIsRedirectedToOtherLocation(
				(String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "Location"));

		SystemDirected.clickBackButton();
		SystemDirected.searchLPNScanContainer(
				Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ILPN3").toString());
		CommonWMMobilePage.verifyLPNIsRedirectedToOtherLocation(
				(String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "Location"));

		SystemDirected.clickBackButton();
		SystemDirected.searchLPNScanContainer(
				Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ILPN4").toString());
		CommonWMMobilePage.verifyLPNIsRedirectedToOtherLocation(
				(String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "Location"));

	}

	@And("Clear Filter Menu ILPNs")
	public void clearFilterMenuILPNs() {
		ILPNs.clearFilterMenuILPNs();

	}

	@And("Update ItemId for three Items {string}")
	public void updateItemIdForThreeItemsItemPUTAWAYXlsx(String fileName) throws Exception {
		String Item = ExcelUtil.convert_variable_to_timestamp(getDataFromFeature("getdata(Item)"));
		String Item1 = Item + 1;
		String Item2 = Item + 2;
		String Item3 = Item + 3;
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "Item1", Item1);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "Item2", Item2);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "Item3", Item3);
		FrameworkLogger.log(LogType.INFO, "Set value for Item1 : " + Item1);
		FrameworkLogger.log(LogType.INFO, "Set value for Item2 : " + Item2);
		FrameworkLogger.log(LogType.INFO, "Set value for Item3 : " + Item3);

		ArrayList<String> al = new ArrayList<>();
		al.add("Item::2::3::" + Item1);
		al.add("Item::2::38::" + Item1.replaceAll("-", ""));
		al.add("Item::3::3::" + Item2);
		al.add("Item::3::38::" + Item2.replaceAll("-", ""));
		al.add("Item::4::3::" + Item3);
		al.add("Item::4::38::" + Item3.replaceAll("-", ""));
		al.add("ItemPackage::2::2::" + Item1);
		al.add("ItemPackage::3::2::" + Item1);
		al.add("ItemPackage::4::2::" + Item1);
		al.add("ItemPackage::5::2::" + Item2);
		al.add("ItemPackage::6::2::" + Item2);
		al.add("ItemPackage::7::2::" + Item2);
		al.add("ItemPackage::8::2::" + Item3);
		al.add("ItemPackage::9::2::" + Item3);
		al.add("ItemPackage::10::2::" + Item3);
		ExcelUtil1.setMultipleCellData(fileName, al);
	}

	@And("Filter ILPNS by Status and Item")
	public void filterILPNSByStatusAndItem() {
		String item = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "Item1");

		ILPNs.filterLPNByStatus(getDataFromFeature("getdata(LPNStatus)"));
		ILPNs.filterLPNByItem(getDataFromFeature(item));
	}

	@And("Filter ILPNS by Item {string}")
	public void filterILPNSByItemItem(String item) {
		CommonMethods.waitForPageLoading();
		ILPNs.filterLPNByItem((String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + item));
		CommonMethods.waitForPageLoading();
	}

	@And("Update ASN With Four LPNs{string}")
	public void updateASNWithFourLPNsAsnPUTAWAYXlsx(String fileName) throws Exception {
		String asn = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(AsnId)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ASN", asn);

		String lpn = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(LpnId)"));
//		String items = getDataFromFeature("getdata(Items)");
//		String[] splitItems = items.split(",");
		String item1 = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "Item1");
		String item2 = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "Item2");
		String item3 = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "Item3");

		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ILPN1", lpn + 1);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ILPN2", lpn + 2);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ILPN3", lpn + 3);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ILPN4", lpn + 4);
		FrameworkLogger.log(LogType.INFO, "Set value for ILPN1 : " + lpn + 1);
		FrameworkLogger.log(LogType.INFO, "Set value for ILPN2 : " + lpn + 2);
		FrameworkLogger.log(LogType.INFO, "Set value for ILPN3 : " + lpn + 3);
		FrameworkLogger.log(LogType.INFO, "Set value for ILPN4 : " + lpn + 4);

		List<String> listOfILPNs = new ArrayList<>();
		listOfILPNs.add(lpn + 1);
		listOfILPNs.add(lpn + 2);
		listOfILPNs.add(lpn + 3);
		listOfILPNs.add(lpn + 4);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "listOfILPNs", listOfILPNs);
		String lpns = String.join(",", listOfILPNs);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "Lpns", lpns);
		ArrayList<String> al = new ArrayList<>();
		al.add("ASN::2::3::" + asn);
		al.add("LPN::2::2::" + lpn + 1);
		al.add("LPN::3::2::" + lpn + 2);
		al.add("LPN::4::2::" + lpn + 3);
		al.add("LPN::5::2::" + lpn + 4);
		al.add("LPN::2::6::" + asn);
		al.add("LPN::3::6::" + asn);
		al.add("LPN::4::6::" + asn);
		al.add("LPN::5::6::" + asn);
		al.add("LpnDetail::2::2::" + lpn + 1);
		al.add("LpnDetail::3::2::" + lpn + 2);
		al.add("LpnDetail::4::2::" + lpn + 3);
		al.add("LpnDetail::5::2::" + lpn + 4);
		al.add("LpnDetail::2::6::" + item1);
		al.add("LpnDetail::3::6::" + item1);
		al.add("LpnDetail::4::6::" + item2);
		al.add("LpnDetail::5::6::" + item2);
		ExcelUtil1.setMultipleCellData(fileName, al);
	}

	@And("Verify Cubing method parameter in cube to capacity")
	public void verifyCubingMethodParameterInCubeToCapacity() {
		Cubing.selectCubeToCapacityCriteria();
		Cubing.expandSideArrow1();
		CommonPage.selectViewButton();
		Cubing.selectCubingMethod();
		Cubing.verifyCubingMethodParameters();

	}

	@And("Verify Allocation Strategy")
	public void verifyAllocationStrategy() {
		CommonMethods.waitForPageLoading();
		Cubing.selectSetOrderCriteria();
		Cubing.verifyAllocationStrategy();
		Cubing.ExpandSideArrow();
		CommonPage.selectViewButton();
	}

	@And("Verify Inventory Criteria")
	public void verifyInventoryCriteria() {
		Cubing.selectSelectionRules();
		Cubing.verifySelectionRules();
		Cubing.selectSetInventoryCriteria();
		Cubing.verifyInventoryCriteria();
		CommonMethods.waitForPageLoading();
	}

	@And("verify Container Sizes Definition details")
	public void verifyContainerSizesDefinitionDetails() {
		CommonMethods.waitForPageLoading();
		ContainerTypePage.verifyContainerSizeDefinitionDetails();
	}

	@And("Verify Container Details In OLPNs Page")
	public void verifyContainerDetailsInOLPNsPage() {
		oLPNPage.validateContainerTypeInOLPNPage(getDataFromFeature("getdata(ContainerTypeId)"));
		oLPNPage.validateContainerSizeInOLPNPage(getDataFromFeature("getdata(ContainerSize)"));
		oLPNPage.validateLPNQuantityInOLPNPage(getDataFromFeature("getdata(LPNQuantity)"));

	}

	@And("Verify Allocation Zone Priorities")
	public void verifyAllocationZonePriorities() {
		CommonMethods.waitForPageLoading();
		Cubing.VerifyAllocationZonePrioritiesForTwoRecord();
		CommonMethods.waitForPageLoading();
		Cubing.selectBackToAllocationStrategy();
		Cubing.ExpandSideArrow();
		CommonPage.selectViewButton();
		Cubing.selectSelectionRules();

		Cubing.verifySelectionRules2();
		Cubing.selectSetInventoryCriteria();
		Cubing.verifyInventoryCriteria2();
		Cubing.ExpandSideArrow();
		Cubing.selectOrderCriteriaViewButton();
		Cubing.selectAllocationZonePriorities();
		Cubing.VerifyAllocationZonePriorities();
	}

	@And("Update ASN for Item Shipping in {string}")
	public void updateASNForItemFNShippingIn(String fileName) throws Exception {
		String asnId = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(ASN)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ASN", asnId);
		FrameworkLogger.log(LogType.INFO, "Set value for ASN : " + asnId);
		String lpnId = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(LPN)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN", lpnId);
		FrameworkLogger.log(LogType.INFO, "Set value for LPN : " + lpnId);
		String item = getDataFromFeature(getData("Item"));
		ArrayList<String> al = new ArrayList<>();
		al.add("Asn::2::3::" + asnId);
		al.add("AsnLine::2::2::" + asnId);
		al.add("AsnLine::2::7::" + item);
		al.add("Lpn::2::2::" + lpnId);
		al.add("Lpn::2::6::" + asnId);
		al.add("LpnDetail::2::2::" + lpnId);
		al.add("LpnDetail::2::6::" + item);
		ExcelUtil1.setMultipleCellData(fileName, al);
	}

	@And("Enter ILPN and Location in AT User Directed PutAway of Shipping Item")
	public void enterILPNAndLocationInATUserDirectedPutAwayOfShippingItem() {
		List<String> listOFiLPNs = (List<String>) Variables
				.get(CurrentThreadInstance.getCurrentScenarioId() + "listOFiLPNs");
		int i = 1;
		for (String iLpn : listOFiLPNs) {
			UserDirected.searchLPN(iLpn);
			UserDirected.enterQuantity(getDataFromFeature("getdata(Order_Line_Quantity" + i + ")"));
			UserDirected.enterScanLocationWithWarning(getDataFromFeature("getdata(Display_Location" + i + ")"));
			CommonPopupPage.clickConfirmButton();
			i++;
		}
	}

	@And("Click on Task Link")
	public void clickOnTaskLink() {
		HeaderPanelPage.clickTaskLink();
	}

	@And("Run FNCUBING Wave for three Orders")
	public void runFNCUBINGWaveForThreeOrders() {
		Cubing.selectThreeOrders();
		OriginalOrdersPage.executeRunWaveFNCUBING06ForThreeOrders();
	}

	@And("Verify Container Details In OLPNs Page for First Order")
	public void verifyContainerDetailsInOLPNsPageForFirstOrder() {
		oLPNPage.validateContainerTypeInOLPNPage(getDataFromFeature("getdata(ContainerTypeId1)"));
		oLPNPage.validateContainerSizeInOLPNPage(getDataFromFeature("getdata(ContainerSize)"));
		oLPNPage.validateLPNQuantityInOLPNPage(getDataFromFeature("getdata(LPNQuantity)"));

	}

	@And("Verify Container Details In OLPNs Page for Second Order")
	public void verifyContainerDetailsInOLPNsPageForSecondOrder() {
		oLPNPage.validateContainerType1InOLPNPage(getDataFromFeature("getdata(ContainerTypeId)"));
		oLPNPage.validateContainerSize1InOLPNPage(getDataFromFeature("getdata(SizeMED)"));
		oLPNPage.validateTotalLPNQuantityInOLPNPageformultipleolpn();
	}

	@And("Verify Container Details In OLPNs Page for Third Order")
	public void verifyContainerDetailsInOLPNsPageForThirdOrder() throws InterruptedException {

		oLPNPage.validateContainerTypeInOLPNPage(getDataFromFeature("getdata(ContainerTypeId)"));
		// oLPNPage.validateContainerSize1InOLPNPage(getDataFromFeature("getdata(SizeMED)"));
		oLPNPage.validateTotalLPNQuantityInOLPNPageformultipleolpn();
	}

	@Then("Verify PixData for lot of tracked items")
	public void verifyPixDataForLotOfTrackedItems() {
		ViewJsonPage.verifyContentForCount07Scenario();
	}

	@Then("Verify PixData status as {string}")
	public void verifyPixDataStatusAs(String status) {
		PixVisibilityPage.verifyPixDataStatus(getDataFromFeature(status));
	}

	@And("Update ASN for Item Count in {string}")
	public void updateASNForItemCountIn(String fileName) throws Exception {
		String asnId = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(ASN)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ASN", asnId);
		FrameworkLogger.log(LogType.INFO, "Set value for ASN : " + asnId);
		String item = getDataFromFeature(getData("Item"));
		String quantity = getDataFromFeature(getData("Quantity"));
		ArrayList<String> al = new ArrayList<>();
		al.add("Asn::2::3::" + asnId);
		al.add("AsnLine::2::2::" + asnId);
		al.add("AsnLine::2::7::" + item);
		al.add("AsnLine::2::8::" + quantity);
		ExcelUtil1.setMultipleCellData(fileName, al);
	}

	@And("Complete ATStandardReceiving with ASN and single LPNs with multiple Serial Numbers")
	public void completeATStandardReceivingWithSingleLPNsWithSerialNumbers() {
		ATStandardReceiving.completeATStandardReceivingWithSingleLPNsWithMultipleSerialNumbers();

	}

	@And("Enter ILPN and Location in AT User Directed PutAway of Count Item")
	public void enterILPNAndLocationInATUserDirectedPutAwayOfCountItem() {

		String strLpn = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "LPN");
		UserDirected.searchLPN(strLpn);
		UserDirected.enterQuantity(getDataFromFeature("getdata(Quantity)"));
		UserDirected.enterScanLocationWithWarning(getDataFromFeature("getdata(ScanLocation)"));
		CommonPopupPage.clickConfirmButton();
	}

	@Then("Verify {string} value at column {string} in Selection Rules")
	public void verifyValueAtColumnInSelectionRules(String value, String column) {
		CommonPage.verifyValueInRules(column, getDataFromFeature(value));
	}

	@And("Verify multiple Ilpns Data In Inventory Details_with Items")
	public void verifyMultipleIlpnsDataInInventoryDetails_withItems() {
		InventoryDetailsPage.verifyMultipleItemDetailsInventoryDetailsPage_FromItems();

	}

	@And("Complete ATStandardReceiving with produtstatus and Inventory type")
	public void completeATStandardReceivingWithProdutstatusAndInventoryType() {
		String LpnId = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(LPNId)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN1", LpnId);

		ReceiveLPNLevel.searchASN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN").toString());
		ReceiveLPNLevel.enterLPN(LpnId);
		String Itemnumber = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "Item");
		ReceiveLPNLevel.enterScanItem(Itemnumber.replaceAll("-", ""));
		ReceiveLPNLevel.searchInventory("F");
		ReceiveLPNLevel.searchProductStatus("A");
		ReceiveLPNLevel.enterQuantity(Integer.parseInt(getDataFromFeature("getdata(OrdQty_Line1)")));

	}

	@And("Verify message line starting with the text Allocation result for OrderLine")
	public void verifyMessageLineStartingWithTheTextAllocationResultForOrderLine() {
		CommonMethods.waitForPageLoading();
		AllocationPage.verifyAllocationResultForOrderLine();
	}

	@And("Verify message line starting with the text Complete Order deselected")
	public void verifyMessageLineStartingWithTheTextCompleteOrderOrderIDDeselected() {
		CommonMethods.waitForPageLoading();
		AllocationPage.verifyCompleteOrderWithOrderIDdeselected();
	}

	@And("Verify multiple Ilpns Data In Inventory")
	public void verifyMultipleIlpnsDataInInventory() {
		InventoryDetailsPage.verifyMultipleItemDetailsInInventoryDetailsPage();
	}

	@And("Navigate to Container Type Page")
	public void navigateToContainerTypePage() {
		HomePage.navigate_to_ContainerTypePage();
		Cubing.verifyContainerTypePage();
	}

	@And("Verify Exterior volume of the Container")
	public void verifyExteriorVolumeOfTheContainer() {
		CommonMethods.waitForPageLoading();
		Cubing.expandSideArrow5();
		CommonPage.selectViewButton();
		CommonMethods.waitForPageLoading();
		ContainerTypePage.verifyExteriorVolumeOfTheContainerForLargeBox();
		CommonMethods.waitForPageLoading();
		CommonPage.clickonOkbutton();
		CommonMethods.waitForPageLoading();

		Cubing.expandSideArrow5();
		CommonMethods.waitForPageLoading();
		CommonPage.selectViewButton();
		ContainerTypePage.verifyExteriorVolumeOfTheContainerForGiantox();
		CommonMethods.waitForPageLoading();
		CommonPage.clickonOkbutton();
		CommonMethods.waitForPageLoading();

	}

	@And("Store Order Line ID")
	public void storeOrderLineID() {
		OriginalOrdersPage.getOrderLineValue();
	}

	@And("Execute RunWave from OriginalOrders for ATStandardOrderStrategy")
	public void executeRunWaveFromOriginalOrderForATStandardOrderStrategy() {
		OriginalOrdersPage.executeRunWaveForOrdersATStandardOrderStrategy();

	}
}
