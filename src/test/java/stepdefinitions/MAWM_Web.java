package stepdefinitions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import com.dhl.driver.DriverManager;
import com.dhl.reports.FrameworkLogger;
import com.dhl.reports.LogType;
import com.dhl.testdata.TestData_Json;
import com.dhl.utils.ConfigurationUtils;
import com.dhl.utils.CurrentThreadInstance;
import com.dhl.utils.GeneralUtils;
import com.dhl.utils.Variables;
import com.dhl.web.utils.SeleniumActions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import web.Pages.*;

@SuppressWarnings("unchecked")

public class MAWM_Web extends TestData_Json {

	@And("Navigate to Inventory Sync")
	public void navigate_to_inventory_sync() {
		HomePage.navigate_to_Inventory_Sync();
		InventorySync.verifyInventorySyncPageDisplayed();
	}

	@And("Update Configuration on generate inventory pix")
	public void update_configuration_on_generate_inventory_pix() {
		InventorySync.searchItem(getDataFromFeature("getdata(ItemID_Line1)"));
		InventorySync.enableGroupByItem();
		InventorySync.saveConfiguration();
		InventorySync.closeConfiguration();
	}

	@And("Click on Run button")
	public void click_run_button() {
		InventorySync.runInventorySync();
		InventorySync.verifySuccessMessage();
	}

	@And("Add Filter for Specification and Item")
	public void filter_for_specification_and_item() {
		PixVisibilityPage.filterBySpecification(getDataFromFeature("getdata(PIX_Specification)"));
		PixVisibilityPage.filterByItemID(getDataFromFeature("getdata(ItemID_Line1)"));
		PixVisibilityPage.filterByCreatedBy();

	}

	@And("Store generated PIX Data JSON View for the configured Item")
	public void store_PIX_data_for_the_configured_item() {
		PixVisibilityPage.get_latest_processed_Date();
		int pixDataQuantity = (int) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "resultCount");
		for (int i = 1; i <= pixDataQuantity; i++) {
			PixVisibilityPage.openSlideOption(i);
			FooterPanelPage.clickPixDataButton();
			ViewJsonPage.getJSONViewPIXData();
			ViewJsonPage.storePIXDataSubItemFieldAttributes(i);
			CommonPopupPage.clickCloseIcon();
//            FooterPanelPage.clickDeselectButton();
		}
	}

	@And("Update Original Order with Order Quantity greater than On hand Quantity {string}")
	public void updateOriginalOrderWithHigherOrderQuantity(String fileName) throws Exception {
		String strOrderValue = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(OriginalOrderID)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder", strOrderValue);
		String order_line = Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "getOnHandQuantity1")
				.toString();
		int Order_Line_Quantity = (Integer.parseInt(order_line))
				+ Integer.parseInt(getDataFromFeature("getdata(IncreasedByQuantity)"));
		String orderLineQuantity = Integer.toString(Order_Line_Quantity);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "Order_Line_Quantity1", orderLineQuantity);
		FrameworkLogger.log(LogType.INFO, "Set value for Original Order : " + strOrderValue);
		ArrayList<String> al = new ArrayList<>();
		al.add("OriginalOrder::2::3::" + strOrderValue);
		al.add("OriginalOrderLine::2::2::" + strOrderValue);
		al.add("OriginalOrderLine::2::6::" + getDataFromFeature("getdata(ItemID_Line_1)"));
		al.add("OriginalOrderLine::2::7::" + orderLineQuantity);
		ExcelUtil1.setMultipleCellData(fileName, al);

	}

	@And("Filter by Inventory Details with Item ID and Location Type")
	public void filterByInventoryDetailsItemIdAndLocationType(int Quantity) {
		// InventoryDetailsPage.minimizeFilterButton();
		InventoryDetailsPage.searchItemId(getDataFromFeature("getdata(ItemID_Line_" + Quantity + ")"));
		InventoryDetailsPage.filterLocationType(getDataFromFeature("getdata(LocationType)"));
	}

	@And("Store On hand and Allocated Quantity")
	public void storeOnHandAndAllocatedQuantity() {
		filterByInventoryDetailsItemIdAndLocationType(1);
		InventoryDetailsPage.storeInventoryDetailsForBatch(1);
		LeftPanelPage.clickClearAll();
		CommonMethods.waitForPageLoading();
	}

	@And("Verify Item and Quantity value For Order Lines")
	public void verifyItemAndQuantityInOrderLines() {
		int orderLineQuantity = Integer.parseInt(getDataFromFeature("getdata(orderLineQuantity)"));
		for (int i = orderLineQuantity; i >= 1; i--) {
			OriginalOrdersPage.selectDetailsForMultipleOrderLine(i);
			OriginalOrdersPage.expandOrderLineNeed();
			Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "OrderLineID" + i,
					OriginalOrdersPage.getOrderLineIDFromOrderLinePopUp());
			OriginalOrdersPage.orderHasQuantityInOrderLineNeed(
					Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "Order_Line_Quantity1").toString());
			OriginalOrdersPage.orderHasNoSerialNumberInOrderLineNeed(null);
			OriginalOrdersPage.orderHasItemIDInOrderLineNeed(getDataFromFeature("getdata(ItemID_Line_" + i + ")"));
			OriginalOrdersPage.closeOrderLine();
			FooterPanelPage.clickDeselectButton();
		}
	}

	@And("Execute RunWave with Partial Allocate")
	public void execute_run_wave_partial_allocate() {
		OrdersPage.executeRunWavePartialAllocate();
	}

	@And("Verify wave Run specifies the Correct Quantity Item and No Serial Number for One Order")
	public void verifyWaveRunHasQuantityItemAndNoSerialNumber() {
		WaveRunsPage.clickOrderLineInAllocations(
				Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "OrderLineID1").toString());
		WaveRunsPage.expandContainerOrQuantity();
		WaveRunsPage.checkContainerQuantity(
				Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "getOnHandQuantity1").toString());
		WaveRunsPage.expandItem();
		WaveRunsPage.allocationItemID(getDataFromFeature("getdata(ItemID_Line_1)"));
		WaveRunsPage.allocationItemHasSerialNumber(null);
		WaveRunsPage.closeAllocation();
		FooterPanelPage.clickDeselectButton();

	}

	@And("Maximum Order status {string}")
	public void maximum_orders_status(String strOrderStatus) {
		OrdersPage.verifyOrderMaximumStatus(strOrderStatus);
	}

	@And("Validate Ordersline status is {string} and {string}")
	public void validate_orderline_status_multiple(String strOrderStatus1, String strOrderStatus2) {
		OriginalOrdersPage.verifyOrderLinesStatuses(strOrderStatus1, strOrderStatus2);
	}

	@And("Verify Item ID Quantity And Wave Processing for the Allocated Order Line")
	public void verifyItemID_Quantity_For_Allocated_Order_line() {
		OriginalOrdersPage.selectDetailsBasedOnOrderStatus("ALLOCATED");
		OriginalOrdersPage.expandOrderLineNeed();
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "OrderLineID1",
				OriginalOrdersPage.getOrderLineIDFromOrderLinePopUp());
		OriginalOrdersPage.orderHasItemIDInOrderLineNeed(getDataFromFeature("getdata(ItemID_Line_1)"));
		OriginalOrdersPage.orderHasQuantityInOrderLineNeed(
				Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "getOnHandQuantity1").toString());
		OriginalOrdersPage.expandWaveProcessing();
		OriginalOrdersPage
				.orderHasRunNumber(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "WaveRun").toString());
		OriginalOrdersPage.orderHasOriginalRunNumber(
				Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "WaveRun").toString());
		OriginalOrdersPage.verifyAllocatedQuantityinWaveProcessing(
				Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "getOnHandQuantity1").toString());
		OriginalOrdersPage.closeOrderLine();
		FooterPanelPage.clickDeselectButton();
	}

	@And("Verify Item ID Quantity And Wave Processing for the Ready Order Line")
	public void verifyItemID_Quantity_For_Ready_Order_line() {
		OriginalOrdersPage.selectDetailsBasedOnOrderStatus("READY");
		OriginalOrdersPage.expandOrderLineNeed();
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "OrderLineID2",
				OriginalOrdersPage.getOrderLineIDFromOrderLinePopUp());
		OriginalOrdersPage.orderHasItemIDInOrderLineNeed(getDataFromFeature("getdata(ItemID_Line_1)"));
		OriginalOrdersPage.orderHasQuantityInOrderLineNeed(getDataFromFeature("getdata(IncreasedByQuantity)"));
		OriginalOrdersPage.expandWaveProcessing();
		OriginalOrdersPage.orderHasRunNumber(null);
		OriginalOrdersPage.verifyAllocatedQuantityinWaveProcessing(getDataFromFeature("getdata(ZeroQuantity)"));
		OriginalOrdersPage.orderHasOriginalRunNumber(null);
		OriginalOrdersPage.closeOrderLine();
		FooterPanelPage.clickDeselectButton();
	}

	@And("Update Order for Wave multiple orders with rule criteria in {string}")
	public void updateOrderForWaveMultipleOrdersWithRuleCriteriaIn(String fileName) throws Exception {

		String originalOrder = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(OriginalOrder)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder", originalOrder);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder1", originalOrder + 1);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder2", originalOrder + 2);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder3", originalOrder + 3);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder4", originalOrder + 4);
		FrameworkLogger.log(LogType.INFO, "Set value for OriginalOrder : " + originalOrder);
		FrameworkLogger.log(LogType.INFO, "Set value for OriginalOrder1 : " + originalOrder + 1);
		FrameworkLogger.log(LogType.INFO, "Set value for OriginalOrder2 : " + originalOrder + 2);
		FrameworkLogger.log(LogType.INFO, "Set value for OriginalOrder3 : " + originalOrder + 3);
		FrameworkLogger.log(LogType.INFO, "Set value for OriginalOrder4 : " + originalOrder + 4);
		List<String> listOfOrders = new ArrayList<>();
		listOfOrders.add(originalOrder + 4);
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
		al.add("OriginalOrder::5::3::" + originalOrder + 4);
		al.add("OriginalOrderLine::2::2::" + originalOrder + 1);
		al.add("OriginalOrderLine::3::2::" + originalOrder + 2);
		al.add("OriginalOrderLine::4::2::" + originalOrder + 3);
		al.add("OriginalOrderLine::5::2::" + originalOrder + 4);
		ExcelUtil1.setMultipleCellData(fileName, al);
	}

	@And("Search Order with variable {string}")
	public void searchOrderWithVariable(String order) {
		LeftPanelPage.searchOriginalOrder((String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + order));
	}

	@And("Verify Multiple Orders with variable {string}")
	public void verifyMultipleOrdersWithVariable(String orders) {
		OriginalOrdersPage
				.verifyMultipleOrders((String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + orders));
	}

	@And("Verify Multiple Priorities with variable {string}")
	public void verifyMultiplePrioritiesWithVariable(String priorities) {
		OriginalOrdersPage.verifyMultiplePriorities(getDataFromFeature(priorities));
	}

	@And("Verify OrderLineNeed and OrderLineAttributes for multiple orders with variable {string}")
	public void verifyOrderLineNeedAndOrderLineAttributesForMultipleOrdersWithVariable(String orders) {
		OriginalOrdersPage.verifyOrderLineNeedAndOrderLineAttributesForMultipleOrders(
				(String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + orders));
	}

	@And("Navigate to OrderLines Page")
	public void navigateToOrderLinesPage() {
		HomePage.navigateToOrderLinesPage();
	}

	@And("Verify OrderLineNeed and OrderLineAttributes for order")
	public void verifyOrderLineNeedAndOrderLineAttributesForOrder() {
		OriginalOrdersPage.verifyOrderLineNeedAndOrderLineAttributesForOrder();
	}

	@And("Verify Multiple Order Statuses with variable {string}")
	public void verifyMultipleOrderStatusesWithVariable(String statuses) {
		OriginalOrdersPage.verifyMultipleOrderStatuses(getDataFromFeature(statuses));
	}

	@And("Navigate to Order Planning Strategy Page")
	public void navigateToOrderPlanningStrategyPage() {
		HomePage.navigateToOrderPlanningStrategyPage();
	}

	@And("Verify FNWAVETwoOrderStrategy in Order Planning Strategy Page")
	public void completeFNWAVETwoOrderStrategyInOrderPlanningStrategyPage() {
		OrderPlanningStrategyPage.verifyFNWAVETwoOrderStrategyInOrderPlanningStrategyPage();
	}

	@And("Click on FNWAVETwoOrderStrategy in Order Planning Strategy Page")
	public void clickOnFNWAVETwoOrderStrategyInOrderPlanningStrategyPage() {
		OrderPlanningStrategyPage.clickFNWAVE02OrderStrategy();
	}

	@And("Click on RunWave")
	public void clickOnRunWave() {
		FooterPanelPage.clickRunWaveButton();
	}

	@And("Store RunWaveId")
	public void storeRunWaveId() {
		OrdersPage.getWavenumber();
	}

	@And("Search LocationBarcode With {string}")
	public void searchLocationBarcodeWith(String text) {
		LeftPanelPage.searchLocationBarcode(getDataFromFeature(text));
	}

	@And("Click on FNWAVEThreeOrderStrategy in Order Planning Strategy Page")
	public void clickOnFNWAVEThreeOrderStrategyInOrderPlanningStrategyPage() {
		OrderPlanningStrategyPage.clickFNWAVE03OrderStrategy();
	}

	@And("Validate generated PIX are broken by attributes")
	public void validate_pix_data_broken_by_attributes() {
		int pixDataQuantity = (int) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "resultCount");
		PixVisibilityPage.comparePIXBrokenByAttributes(pixDataQuantity);
	}

	@And("Verify FNWAVEThreeOrderStrategy in Order Planning Strategy Page")
	public void verifyFNWAVEThreeOrderStrategyInOrderPlanningStrategyPage() {
		OrderPlanningStrategyPage.editFNWAVEThreeOrderStrategyInOrderPlanningStrategyPage();
		OrderPlanningStrategyPage.verifyFNWAVEThreeOrderStrategyInOrderPlanningStrategyPage();
	}

	@And("Validate generated PIX has No Batch Number")
	public void validate_pix_data_has_no_batch_number() {
		int pixDataQuantity = (int) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "resultCount");
		PixVisibilityPage.verifyBatchNumberIsNull(pixDataQuantity);
	}

	@And("Validate generated PIX is broken by Batch Number")
	public void validate_pix_data_is_broken_by_batch_number() {
		int pixDataQuantity = (int) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "resultCount");
		PixVisibilityPage.verifyBatchNumberIsUnique(pixDataQuantity);
	}

	@And("Update LPN level ASN with one line in {string}")
	public void updateLPNLevelASNWithOneLineIn(String fileName) throws Exception {
		String asnId = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(ASN)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ASN", asnId);
		FrameworkLogger.log(LogType.INFO, "Set value for ASN : " + asnId);
		String lpnId = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(LPN)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN1", lpnId + 1);
		FrameworkLogger.log(LogType.INFO, "Set value for LPN1 : " + lpnId + 1);
		List<String> listOfILPNs = new ArrayList<>();
		listOfILPNs.add(lpnId + 1);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "listOfILPNs", listOfILPNs);
		ArrayList<String> al = new ArrayList<>();
		al.add("Asn::2::3::" + asnId);
		al.add("Lpn::2::2::" + lpnId + 1);
		al.add("Lpn::2::6::" + asnId);
		al.add("LpnDetail::2::2::" + lpnId + 1);
		ExcelUtil1.setMultipleCellData(fileName, al);

	}

	@And("Update ASN for two orders single piece for the same client in {string}")
	public void updateASNForTwoOrdersSinglePieceForTheSameClientIn(String fileName) throws Exception {

		String asnId = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(ASN)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ASN", asnId);
		FrameworkLogger.log(LogType.INFO, "Set value for ASN : " + asnId);
		String lpnId = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(LPN)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN1", lpnId + 1);
		FrameworkLogger.log(LogType.INFO, "Set value for LPN1 : " + lpnId + 1);
		List<String> listOfILPNs = new ArrayList<>();
		listOfILPNs.add(lpnId + 1);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN", lpnId);
		FrameworkLogger.log(LogType.INFO, "Set value for LPN : " + lpnId);
		ArrayList<String> al = new ArrayList<>();
		al.add("Asn::2::3::" + asnId);
		al.add("Lpn::2::2::" + lpnId);
		al.add("Lpn::2::6::" + asnId);
		al.add("LpnDetail::2::2::" + lpnId);
		ExcelUtil1.setMultipleCellData(fileName, al);

	}

	@And("Update Order Single line in {string}")
	public void updateOrderSingleLineIn(String fileName) throws Exception {
		String originalOrder = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(OriginalOrder)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder", originalOrder);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder1", originalOrder + 1);
		FrameworkLogger.log(LogType.INFO, "Set value for OriginalOrder : " + originalOrder);
		FrameworkLogger.log(LogType.INFO, "Set value for OriginalOrder1 : " + originalOrder + 1);
		List<String> listOfOrders = new ArrayList<>();
		listOfOrders.add(originalOrder + 1);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "listOfOrders", listOfOrders);
		String orders = String.join(",", listOfOrders);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "Orders", orders);
		ArrayList<String> al = new ArrayList<>();
		al.add("OriginalOrder::2::3::" + originalOrder + 1);
		al.add("OriginalOrderLine::2::2::" + originalOrder + 1);
		ExcelUtil1.setMultipleCellData(fileName, al);


	}
//
	/*
	 * String asnId =
	 * ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(ASN)"));
	 * Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ASN", asnId);
	 * FrameworkLogger.log(LogType.INFO, "Set value for ASN : " + asnId); String
	 * lpnId =
	 * ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(LPN)"));
	 * Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN", lpnId );
	 * FrameworkLogger.log(LogType.INFO, "Set value for LPN : " + lpnId);
	 * ArrayList<String> al = new ArrayList<>(); al.add("Asn::2::3::" + asnId);
	 * al.add("Lpn::2::2::" + lpnId ); al.add("Lpn::2::6::" + asnId);
	 * al.add("LpnDetail::2::2::" + lpnId );
	 * ExcelUtil1.setMultipleCellData(fileName, al);
	 */

	@And("Complete ATUserDirectedPutAway with single LPN")
	public void completeATUserDirectedPutAwayWithSingleLPN() {
		String lpn = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "LPN");
		ATUserDirectedPutAway.completeATUserDirectedPutAway(lpn);
	}

	@And("Verify OnHandQuantity in Inventory details page")
	public void verifyOnHandQuantityInInventoryDetailsPage() {
		InventoryDetailsPage.verifyOnHandQuantity();
	}

	@And("Click on Row At First Index")
	public void clickOnRowAtFirstIndex() {
		CommonPage.clickRowAtFirstIndex();
	}

	@And("Update Order for two orders single piece for the same client in {string}")
	public void updateOrderForTwoOrdersSinglePieceForTheSameClientIn(String fileName) throws Exception {
		String originalOrder = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(OriginalOrder)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder", originalOrder);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder1", originalOrder + 1);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder2", originalOrder + 2);
		FrameworkLogger.log(LogType.INFO, "Set value for OriginalOrder : " + originalOrder);
		FrameworkLogger.log(LogType.INFO, "Set value for OriginalOrder1 : " + originalOrder + 1);
		FrameworkLogger.log(LogType.INFO, "Set value for OriginalOrder2 : " + originalOrder + 2);
		List<String> listOfOrders = new ArrayList<>();
		listOfOrders.add(originalOrder + 2);
		listOfOrders.add(originalOrder + 1);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "listOfOrders", listOfOrders);
		String orders = String.join(",", listOfOrders);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "Orders", orders);
		ArrayList<String> al = new ArrayList<>();
		al.add("OriginalOrder::2::3::" + originalOrder + 1);
		al.add("OriginalOrder::3::3::" + originalOrder + 2);
		al.add("OriginalOrderLine::2::2::" + originalOrder + 1);
		al.add("OriginalOrderLine::3::2::" + originalOrder + 2);
		ExcelUtil1.setMultipleCellData(fileName, al);
	}

	@And("Complete {string} Order strategy")
	public void completeOrderStrategy(String strategy) {
		OriginalOrdersPage.completeOrderStrategy(strategy);
	}

	@Then("Verify Row count as {int}")
	public void verifyRowCountAs(int count) {
		CommonPage.verifyRowCount(count);
	}

	@And("Click on Menu with title {string}")
	public void clickOnMenuWithTitle(String title) {
		CommonPage.clickMenuWithTitle(title);
	}

	@And("Store Multiple OLPNs to variable")
	public void storeMultipleOLPNsToVariable() {
		oLPNPage.storeOLPNs();
	}

	@And("Click on Allocations Link")

	public void clickOnAllocationsLink() {
		HeaderPanelPage.clickAllocationsLink();
	}

	@And("Click on Tasks Link")

	public void clickOnTasksLink() {
		HeaderPanelPage.clickTasksLink();
	}

	@And("Enter the tasks details in Pick to Tote screen and complete the process")
	public void enterTheTasksDetailsInPickToToteScreenAndCompleteTheProcess() {
		PickToTotePage.completePickToTote();
	}

	@And("Enter the tasks details in Pick to Tote screen and complete the process with scan location")
	public void enterTheTasksDetailsInPickToToteScreenAndCompleteTheProcess_withScanLocation() {
		PickToTotePage.completePickToTote_withScanLocation();
	}

	@And("Click on Orders Link")
	public void clickOnOrdersLink() {
		HeaderPanelPage.clickOrdersLink();
	}

	@And("Verify Multiple oLPNs Statuses with variable {string}")
	public void verifyMultipleOLPNsStatusesWithVariable(String statuses) {
		oLPNPage.verifyMultipleOLPNStatuses(getDataFromFeature(statuses));
	}

	/**
	 * Click Function
	 *
	 * @param strBy      - 'by' variable of webelement
	 * @param strAppPage - Page class name
	 */
	@And("Click {string} on {string} WaitForPageLoading")
	public void click_element_on_page(String strBy, String strAppPage) {
		CommonMethods.waitForPageLoading();
		By byFromPage = GeneralUtils.getByFromPage(getDataFromFeature(strBy), getDataFromFeature(strAppPage));
		SeleniumActions.click(SeleniumActions.getElement(byFromPage), byFromPage.toString());
		CommonMethods.waitForPageLoading();
	}

	@And("Update Original Order with Order ID and Item {string}")
	public void updateOriginalOrderWithTwoLines(String fileName) throws Exception {
		String strOrderValue = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(OriginalOrderID)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder", strOrderValue);
		FrameworkLogger.log(LogType.INFO, "Set value for Original Order : " + strOrderValue);
		ArrayList<String> al = new ArrayList<>();
		al.add("OriginalOrder::2::3::" + strOrderValue);
		al.add("OriginalOrderLine::2::2::" + strOrderValue);
		al.add("OriginalOrderLine::2::6::" + getDataFromFeature("getdata(Item)"));
		al.add("OriginalOrderLine::2::7::" + getDataFromFeature("getdata(Order_Line_Quantity)"));
		ExcelUtil1.setMultipleCellData(fileName, al);

	}

	@And("Store OLPN number in runtime variable as List")
	public static void captureOLPNNumber() {
		Olpns.storeOLPNsToList();
	}

	@And("Validate OLPNS statuses {string}")
	public void validate_orderslines_statuses(String strOrderStatus) {
		Olpns.verifyOLPNStatuses(strOrderStatus);
	}

	@And("Complete Packing in AT Pick OLPN")
	public static void completePackingATPickOlpn() {
		List<String> listOFoLPNs = (List<String>) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "OLPN");
		PickPackLPNPage.verifyAtPickOlpnPageDisplayed();
		for (String oLPN : listOFoLPNs) {
			CommonMethods.waitForPageLoading();
			CommonWMMobilePage.enterScanOLPN(oLPN);
			CommonWMMobilePage.clickGoButton();
			CommonWMMobilePage.enterScanItem(CommonWMMobilePage.getItemText().replaceAll("-", ""));
			CommonWMMobilePage.clickGoButton();
			CommonWMMobilePage.enterQuantity(CommonWMMobilePage.getQuantityNeedText().trim());
			CommonWMMobilePage.clickGoButton();
			PickPackLPNPage.verifyInformationEndOfOlpn();
		}
	}

	@And("Verify Ilpn status as {string}")
	public void verifyIlpnStatusAs(String status) {
		ILPNs.verifyILPNStatusAtFirstIndex(getDataFromFeature(status));
	}

	@And("Navigate to Pack station {string}")
	public void navigateToPackStation(String station) {
		HomePage.navigateToPackStation(getDataFromFeature(station));
	}

	@And("Complete Packing for multiple oLPNs")
	public void completePackingForMultipleOLpns() {
		PackStationPage.completePackingForMultipleOLpns();
	}

	@And("Wait and Validate Order status is {string}")
	public void wait_and_validate_order_status_till(String strStatus) throws InterruptedException {
		OrdersPage.waitAndVerifyOrderStatus(strStatus);
	}

	@And("Complete Packing in AT Pick OLPN with serial number")
	public void completePackingInATPickOLPNWithSerialNumber() {
		List<String> listOFoLPNs = (List<String>) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "OLPN");
		PickPackLPNPage.verifyAtPickOlpnPageDisplayed();
		for (String oLPN : listOFoLPNs) {
			CommonMethods.waitForPageLoading();
			CommonWMMobilePage.enterScanOLPN(oLPN);
			CommonWMMobilePage.clickGoButton();
			CommonWMMobilePage.enterScanItem(CommonWMMobilePage.getItemText().replaceAll("-", ""));
			CommonWMMobilePage.clickGoButton();
			CommonWMMobilePage.enterQuantity(CommonWMMobilePage.getQuantityNeedText().trim());
			CommonWMMobilePage.clickGoButton();
			CommonWMMobilePage.enterSerialNumber(getDataFromFeature("getData(SerialNumber)"));
			CommonWMMobilePage.clickGoButton();
			PickPackLPNPage.verifyInformationEndOfOlpn();
		}
	}

	@And("Update ASN for one order multi piece with Serial Number in {string}")
	public void updateASNForOneOrderMultiPieceWithSerialNumberIn(String fileName) throws Exception {
		String asnId = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(ASN)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ASN", asnId);
		FrameworkLogger.log(LogType.INFO, "Set value for ASN : " + asnId);
		ArrayList<String> al = new ArrayList<>();
		al.add("Asn::2::3::" + asnId);
		al.add("AsnLine::2::2::" + asnId);
		al.add("AsnLine::3::2::" + asnId);
		ExcelUtil1.setMultipleCellData(fileName, al);
	}

	@And("Complete ATStandardReceiving with ASN and multiple LPNs with Serial Numbers")
	public void completeATStandardReceivingWithASNAndMultipleLPNsWithSerialNumbers() {
		ATStandardReceiving.completeATStandardReceivingWithMultipleLPNsWithSerialNumbers();
	}

	@And("Update Order for one order multi piece with Serial Number in {string}")
	public void updateOrderForOneOrderMultiPieceWithSerialNumberIn(String fileName) throws Exception {
		String originalOrder = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(OriginalOrder)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder", originalOrder);
		FrameworkLogger.log(LogType.INFO, "Set value for OriginalOrder : " + originalOrder);
		List<String> listOfOrders = new ArrayList<>();
		listOfOrders.add(originalOrder);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "listOfOrders", listOfOrders);
		String orders = String.join(",", listOfOrders);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "Orders", orders);
		ArrayList<String> al = new ArrayList<>();
		al.add("OriginalOrder::2::3::" + originalOrder);
		al.add("OriginalOrderLine::2::2::" + originalOrder);
		al.add("OriginalOrderLine::3::2::" + originalOrder);
		ExcelUtil1.setMultipleCellData(fileName, al);
	}

	@And("Complete Pick to Tote process with multiple items with serial number")
	public void completePickToToteProcessWithMultipleItemsWithSerialNumber() {
		PickToTotePage.completePickToToteWithMultipleItemsWithSerialNumber();
	}

	@And("Complete Packing for multiple items with serial number")
	public void completePackingForMultipleItemsWithSerialNumber() {
		PackStationPage.completePackingForMultipleItemsWithSerialNumber();
	}

	@And("Update Order for Multi-SKU, multi-units for the same client, both with serial number in {string}")
	public void updateOrderForMultiSKUMultiUnitsForTheSameClientBothWithSerialNumberIn(String fileName)
			throws Exception {
		String originalOrder = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(OriginalOrder)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder1", originalOrder + 1);
		FrameworkLogger.log(LogType.INFO, "Set value for OriginalOrder1 : " + originalOrder + 1);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder2", originalOrder + 2);
		FrameworkLogger.log(LogType.INFO, "Set value for OriginalOrder2 : " + originalOrder + 2);

		List<String> listOfOrders = new ArrayList<>();
		listOfOrders.add(originalOrder + 2);
		listOfOrders.add(originalOrder + 1);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "listOfOrders", listOfOrders);
		String orders = String.join(",", listOfOrders);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "Orders", orders);
		ArrayList<String> al = new ArrayList<>();
		al.add("OriginalOrder::2::3::" + originalOrder + 1);
		al.add("OriginalOrder::3::3::" + originalOrder + 2);
		al.add("OriginalOrderLine::2::2::" + originalOrder + 1);
		al.add("OriginalOrderLine::3::2::" + originalOrder + 1);
		al.add("OriginalOrderLine::4::2::" + originalOrder + 2);
		al.add("OriginalOrderLine::5::2::" + originalOrder + 2);
		ExcelUtil1.setMultipleCellData(fileName, al);
	}

	@And("Store Multiple Tasks to variable")
	public void storeMultipleTasksToVariable() {
		TasksPage.storeMultipleTasks();
	}

	@And("Complete Pick to Tote process with multiple items with serial number for multiple Tasks")
	public void completePickToToteProcessWithMultipleItemsWithSerialNumberForMultipleTasks() {
		PickToTotePage.completePickToToteWithMultipleItemsWithSerialNumberForMultipleTasks();
	}

	@And("Verify Multiple Tasks status as {string}")
	public void verifyMultipleTasksStatusAs(String statuses) {
		TasksPage.verifyMultipleTaskStatuses(getDataFromFeature(statuses));
	}

	@And("Complete Packing for multiple items with serial number for multiple Totes")
	public void completePackingForMultipleItemsWithSerialNumberForMultipleTotes() {
		PackStationPage.completePackingForMultipleItemsWithSerialNumberForMultipleTotes();
	}

	@And("Browser Refresh")
	public void browserRefresh() {
		DriverManager.getDriver().navigate().refresh();
		CommonMethods.waitForPageLoading();
	}

	@And("Update ASN and single LPN  by file {string}")
	public void updateASNImportFileWithSingleLPN(String fileName) {
		ExcelUtil1.verifyFilePresentfromuserdir(fileName);
		String AsnIdValue = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(ASN)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ASN", AsnIdValue);
		String strAsnIdValue = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN");
		ExcelUtil1.writeCellValueForColumnwoAppend(fileName, "Asn", "AsnId", strAsnIdValue);
		String LpnIdValue = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(LPN)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN", LpnIdValue);
		ExcelUtil1.emptyCellValueForColumn(fileName, "Asn", "AsnId");
		ExcelUtil1.emptyCellValueForColumn(fileName, "Lpn", "LpnId");
		ExcelUtil1.emptyCellValueForColumn(fileName, "LpnDetail", "Lpn.LpnId");

		ExcelUtil1.writeCellValueForColumntoparticularrow(fileName, "Lpn", "LpnId", LpnIdValue, 1);
		ExcelUtil1.writeCellValueForColumntoparticularrow(fileName, "Lpn", "AsnId", strAsnIdValue, 1);
		ExcelUtil1.writeCellValueForColumntoparticularrow(fileName, "LpnDetail", "Lpn.LpnId", LpnIdValue, 1);
	}

	@And("Filter by Inventory Details with Item ID {string}")
	public void filterByInventoryDetailsWithItemID(String str) {
		InventoryDetailsPage.minimizeFilterButton();
		InventoryDetailsPage.searchItemId(getDataFromFeature(str));
	}

	@And("Update one OriginalOrder with one Orderline {string}")
	public void updateTwoOriginalOrdersWithTwoLines(String fileName) throws Exception {
		String strOrderValue = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(OriginalOrderID)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder", strOrderValue);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder1", strOrderValue + 1);
		FrameworkLogger.log(LogType.INFO, "Set value for Original Order1 : " + strOrderValue + 1);
		ArrayList<String> al = new ArrayList<>();
		al.add("OriginalOrder::2::3::" + strOrderValue + 1);
		al.add("OriginalOrderLine::2::2::" + strOrderValue + 1);
		ExcelUtil1.setMultipleCellData(fileName, al);
	}

	@And("Navigate to OLPNS 2.0")
	public void navigate_to_ILPNs2_0() {
		HomePage.navigateToOLPNS2_O();
		Olpns.verifyoLPNSPageDisplayed();
	}

	@And("Search Order with variable {string} in OLPNS2 page")
	public void searchOrderWithVariableInOLPNSPage(String order) {
		Olpns.searchOriginalOrder((String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + order));
	}

	@And("Select First Shipped Order OLPNS2 page")
	public void selectFirstShippedOrderOLPNSPage() {
		Olpns.SelectShippedOrder();
	}

	@When("Click on Details Button in OLPNS2 page")
	public void clickOnDetailsButtonInOLPNSPage() {
		Olpns.ClickDetailsButton();
	}

	@Then("Validate Inventory Type and Product Status under OLPN Details")
	public void validateInventoryTypeAndProductStatusUnderOLPNDetails() {
		Olpns.verifyOLpnsInventoryTypeAndProductStatus();
	}

	@And("Verify Wave Run as pickpack for the Order")
	public void verifyWaveRunAsPickpackForTheOrder() {
		if (WaveRunsPage.getWaveTypeDes(1).trim().contains("Pick/Pack")) {
			WaveRunsPage.expandContainerOrQuantity();
			WaveRunsPage.verifyAllocationUomValue(getDataFromFeature("getdata(AllocationUom)"));
			WaveRunsPage.expandItem();
			WaveRunsPage.closeAllocation();
			FooterPanelPage.clickDeselectButton();
		}
	}

	@And("Select Details in Wave Run Allocations page")
	public void selectDetailsInWaveRunAllocationsPage() {
		CommonPage.clickRowAtFirstIndex();
		WaveRunsPage.clickAllocationDetailsbutton();
		CommonMethods.waitForPageLoading();
	}

	@And("validate OLPNs count {int}")
	public void validateOLPNsCount(int actualcount) {
		String expectedCount1 = String.valueOf(CommonPage.getRowCount());
		String actualCount1 = String.valueOf(actualcount);
		System.out.println("expceted: " + expectedCount1 + "  actual:" + actualCount1);
		SeleniumActions.verifyTextEquals(expectedCount1, actualCount1);
	}

	@And("Verify Item with variable {string}")
	public void verifyItemWithVariable(String item) {
		ItemsPage.verifyItemAtFirstIndex((String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + item));
	}

	@And("Search Item With variable {string}")
	public void searchItemWithVariable(String item) {
		LeftPanelPage.searchItem((String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + item));
	}

	@And("Store Item Template data to variable {string}")
	public void storeItemTemplateDataToVariable(String name) {
		ItemTemplatePage.storeItemTemplateData(name);
	}

	@And("Verify NoRecords found label displayed")
	public void verifyNoRecordsFoundLabelDisplayed() {
		CommonPage.verifyNoRecordsLabelDisplayed();
	}

	@And("Verify Attribute values for Normal Item Template with variable {string}")
	public void verifyAttributeValuesForNormalItemTemplateWithVariable(String template) {
		ItemsPopupPage.verifyAttributeValuesForNormalItemTemplate(template);
	}

	@And("Update ASN for normal order via standard process with no special peculiarities in {string}")
	public void updateASNForNormalOrderViaStandardProcessWithNoSpecialPeculiaritiesIn(String fileName)
			throws Exception {
		String asnId = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(ASN)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ASN", asnId);
		FrameworkLogger.log(LogType.INFO, "Set value for ASN : " + asnId);
		String lpnId = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(LPN)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN1", lpnId + 1);
		FrameworkLogger.log(LogType.INFO, "Set value for LPN1 : " + lpnId + 1);
		List<String> listOfILPNs = new ArrayList<>();
		listOfILPNs.add(lpnId + 1);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN", lpnId);
		FrameworkLogger.log(LogType.INFO, "Set value for LPN : " + lpnId);
		ArrayList<String> al = new ArrayList<>();
		al.add("Asn::2::3::" + asnId);
		al.add("Lpn::2::2::" + lpnId);
		al.add("Lpn::2::6::" + asnId);
		al.add("LpnDetail::2::2::" + lpnId);
		ExcelUtil1.setMultipleCellData(fileName, al);
	}

	@And("Update Original Orders in {string}")
	public void updateOriginalOrdersIn(String fileName) throws Exception {
		String itemId = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "Item");
		String originalOrder = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(OriginalOrder)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder", originalOrder);
		FrameworkLogger.log(LogType.INFO, "Set value for OriginalOrder : " + originalOrder);
		List<String> listOfOrders = new ArrayList<>();
		listOfOrders.add(originalOrder);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "listOfOrders", listOfOrders);
		String orders = String.join(",", listOfOrders);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "Orders", orders);
		ArrayList<String> al = new ArrayList<>();
		al.add("OriginalOrder::2::3::" + originalOrder);
		al.add("OriginalOrderLine::2::2::" + originalOrder);
		al.add("OriginalOrderLine::2::6::" + itemId);
		ExcelUtil1.setMultipleCellData(fileName, al);
	}

	@And("Expand Container Quantity section And Verify Allocation UOM")
	public void expandContainerQuantitySectionAndVerifyAllocationUOM() {
		AllocationPage.verifyAllocationUOM();
		CommonMethods.waitForPageLoading();
		CommonPopupPage.clickCloseIcon();
	}

	@Then("Verify Pix Visibility Data")
	public void verifyPixVisibilityData() {
		ViewJsonPage.verifyPixDataContent();
		CommonPopupPage.clickCloseIcon();
	}

	@And("Verify Attribute values for BatchTRK Item Template with variable {string}")
	public void verifyAttributeValuesForBatchTRKItemTemplateWithVariable(String template) {
		ItemsPopupPage.verifyAttributeValuesForBatchTRKItemTemplate(template);
	}

	@And("Verify Attribute values for SerialTRK Item Template with variable {string}")
	public void verifyAttributeValuesForSerialTRKItemTemplateWithVariable(String template) {
		ItemsPopupPage.verifyAttributeValuesForSerialTRKItemTemplate(template);
	}

	@And("Navigate to Order Template Page")
	public void navigateToOrderTemplatePage() {
		HomePage.navigateToOrderTemplatePage();
	}

	@And("Store Order Template sample data  to variable {string}")
	public void storeOrderTemplateSampleDataToVariable(String name) {
		OrderTemplatePage.storeOrderTemplateSampleData(name);
	}

	@And("Verify Order Template data and entity id and store to variable {string}")
	public void verifyAndStoreOrderTemplateAndEntityDataToVariable(String OrderTemplate) {
		OrderTemplatePage.storeOrderTemplateAndEntityDataAndVerify(OrderTemplate, "EntityID");
	}

	@And("Verify Order with variable {string}")
	public void verifyOrderWithVariable(String order) {
		OriginalOrdersPage
				.verifyOrderAtFirstIndex((String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + order));
	}

	@And("Verify Extended Attribute values for Original order header with variable {string}")
	public void verifyExtendedAttributeValuesForOriginalOrderHeaderWithVariable(String template) {
		OriginalOrderPopupPage.verifyAttributeValuesForOriginalOrderHeaderTemplateInOriginalOrder(template);
	}

	@And("Verify Extended Attribute values are empty in Original order popup")
	public void verifyExtendedAttributeValuesAreEmptyInOriginalOrdersPopup() {
		OriginalOrderPopupPage.verifyExtendedAttributeValuesForOriginalOrderLineTemplateInOriginalOrder();
	}

	@And("Login to WMS Manhattan via LDAP")
	public void login_manhattan_LDAP() {
		String strUsername = ConfigurationUtils.getFrameworkConfig("appusername");
		LoginPage.enter_Username(strUsername);
		LoginPage.click_SubmitUser();
		HomePage.verifyUDCPageDisplayed();
	}

	@And("Verify Labor Activity For Each Tasks")
	public void verifyLaborActivityOnTasksPage() {
		TasksPage.verifyLaborActivityOnTaskPage();
	}

	@And("Edit ItemId Item Master of Inventory import file with file by {string}")
	public void updateItemIdAndImportFile(String fileName) throws Exception {
		String item = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(Item)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "Item", item);
		FrameworkLogger.log(LogType.INFO, "Set value for Item : " + item);
		ArrayList<String> al = new ArrayList<>();
		al.add("Item::2::3::" + item);
		al.add("ItemCode::2::2::" + item);
		al.add("ItemPackage::2::2::" + item);
		al.add("ItemPackage::3::2::" + item);
		ExcelUtil1.setMultipleCellData(fileName, al);
	}

	@And("Update ASN for normal order via standard process with Newly Generated ItemId in {string}")
	public void updateASNForNormalOrderViaStandardProcessWithNewlyGeneratedItemIdIn(String fileName) throws Exception {
		String itemId = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "Item");
		String asnId = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(ASN)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ASN", asnId);
		FrameworkLogger.log(LogType.INFO, "Set value for ASN : " + asnId);
		String lpnId = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(LPN)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN1", lpnId + 1);
		FrameworkLogger.log(LogType.INFO, "Set value for LPN1 : " + lpnId + 1);
		List<String> listOfILPNs = new ArrayList<>();
		listOfILPNs.add(lpnId + 1);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN", lpnId);
		FrameworkLogger.log(LogType.INFO, "Set value for LPN : " + lpnId);
		ArrayList<String> al = new ArrayList<>();
		al.add("Asn::2::3::" + asnId);
		al.add("Lpn::2::2::" + lpnId);
		al.add("Lpn::2::6::" + asnId);
		al.add("LpnDetail::2::2::" + lpnId);
		al.add("LpnDetail::2::6::" + itemId);
		ExcelUtil1.setMultipleCellData(fileName, al);
	}

	@And("Verify OrderLineNeed and OrderLineAttributes for order with order template json {string}")
	public void verifyOrderLineNeedAndOrderLineAttributesForOrderWithOrderTemplateJson(String template) {
		OrderLinePopupPage.verifyOrderLineNeedAndOrderLineAttributesForOrder_OrderTemplateJson(template);
	}

	@And("Validate Order line data with Json {string}")
	public void validateOrderLineDataWithJson(String filename) throws IOException {
		OrderLinePopupPage.verifyOrderLineDataWithJson(filename);
	}

	@And("Verify the Inventory Count Pending Booking Status")
	public void VerifyCountStatusAsPendingBookingStatus() {
		InventoryCountPage.VerifyCountStatusAsPendingBooking();
	}

	@And("Verify the Inventory Count Booking Rejected Status")
	public void VerifyCountStatusAsBookingRejectedStatus() {
		InventoryCountPage.VerifyCountStatusAsBookingRejected();
	}

	@And("Verify Excluded User Error Message {string}")
	public void VerifyExcludedUserErrorMessage(String errormsg) {
		TasksPage.VerifyTaskIdErrorMessage(errormsg);
	}

	@And("Expand Task Filter")
	public void ExpandTaskFilter() {
		LeftPanelPage.expandTaskIDField();
	}

	@And("Filter TaskID In UI Page")
	public void FilterTaskIDInUIPage() {
		TasksPage.FilterTaskID();
	}

	@And("Navigate To Inventory Count Details")
	public void NavigateToInventoryCountDetails() {
		HomePage.navigateToInventoryCountDetail();
	}

	@And("Store CountRunID To Variable")
	public void StoreCountRunIDToVariable() {
		InventoryCountPage.SetCountRunID();
	}

	@And("Expand CountRunID Filter")
	public void ExpandCountRunID() {
		LeftPanelPage.expandCountRunIDField();
	}

	@And("Filter Completed Task Status")
	public void FilterCompletedTaskStatus() {
		LeftPanelPage.checkCompletedStatusCheckbox();
	}

	@And("Validate Original Quantity And Count Quantity Match")
	public void ValidateOriginalQuantityAndCountQuantityMatch() {
		InventoryDetailsPage.validateOriginalAndCountQuantitiesMatch();
	}

	@And("Validate Variance Quantity Is Zero")
	public void ValidateVarianceQuantityIsZero() {
		InventoryDetailsPage.validateVarianceQuantityMatchesZero();
	}

	@And("Verify Task Status {string}")
	public void VerifyTaskStatus(String expTaskStatus) {
		String actualStatus = TasksPage.getTasksStatus();
		SeleniumActions.verifyTextEquals(actualStatus, expTaskStatus);
	}

	@And("Search ASN With variable {string}")
	public void searchAsnWithVariable(String asn) {
		LeftPanelPage.searchASN((String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + asn));
	}

	@Then("Validate ASN data with Json {string}")
	public void verifyCorrectFieldsArePopulatedIntoTheASNJson(String filename) throws IOException {
		FooterPanelPage.clickDetailsButton();
		CommonMethods.waitForPageLoading();
		ASNs.verifyAsnDataWithJson(filename);
	}

	@And("Navigate To ASN Details Page")
	public void navigateToASNDetailsLink() {
		CommonMethods.waitForPageLoading();
		HeaderPanelPage.clickRelatedLinksButton();
		HeaderPanelPage.clickASNDetailsLink();
		CommonMethods.waitForPageLoading();
	}

	@And("Verify ASNID and ShippedQuantity for multiple ASNs with File {string} and Variable {string}")
	public void verifyASNIDAndShippedQuantityForMultipleAsns(String filename, String asn) throws IOException {
		ASNs.verifyASNIDAndShippedQuantityForMultipleAsns(filename, asn);
	}

	@And("Update ASN File With two LPNs{string}")
	public void updateASNFileWithTwoLPNsAndItems(String fileName) throws Exception {
		String asn = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(AsnId)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ASN", asn);
		String itemId = Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "Item").toString();
		String lpn = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(LpnId)"));
//		String items = getDataFromFeature("getdata(Items)");
//		String[] splitItems = items.split(",");

		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ILPN1", lpn+1);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ILPN2", lpn+2);
		FrameworkLogger.log(LogType.INFO, "Set value for ILPN1 : " + lpn+1);
		FrameworkLogger.log(LogType.INFO, "Set value for ILPN2 : " + lpn+2);

		List<String> listOfILPNs = new ArrayList<>();
		listOfILPNs.add(lpn+1);
		listOfILPNs.add(lpn+2);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "listOfILPNs", listOfILPNs);
		String lpns = String.join(",", listOfILPNs);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "Lpns", lpns);
		ArrayList<String> al = new ArrayList<>();
		al.add("ASN::2::3::" + asn);
		al.add("ASN::2::4::" + getDataFromFeature("getdata(FacilityID)"));
		al.add("ASN::2::5::" + getDataFromFeature("getdata(BUID)"));
		al.add("ASN::2::13::" + getDataFromFeature("getdata(FacilityID)"));
		al.add("LPN::2::2::" + lpn+1);
		al.add("LPN::3::2::" + lpn+2);
		al.add("LPN::2::6::" + asn);
		al.add("LPN::3::6::" + asn);
		al.add("LPN::2::3::" + getDataFromFeature("getdata(FacilityID)"));
		al.add("LPN::3::3::" + getDataFromFeature("getdata(FacilityID)"));
		al.add("LPN::2::4::" + getDataFromFeature("getdata(BUID)"));
		al.add("LPN::3::4::" + getDataFromFeature("getdata(BUID)"));
		al.add("LPN::2::21::" + getDataFromFeature("getdata(FacilityID)"));
		al.add("LPN::3::21::" + getDataFromFeature("getdata(FacilityID)"));
		al.add("LpnDetail::2::2::" + lpn+1);
		al.add("LpnDetail::3::2::" + lpn+2);
		al.add("LpnDetail::2::6::" + itemId);
		al.add("LpnDetail::3::6::" + itemId);
		al.add("LpnDetail::2::4::" + getDataFromFeature("getdata(FacilityID)"));
		al.add("LpnDetail::3::4::" + getDataFromFeature("getdata(FacilityID)"));
		al.add("LpnDetail::2::5::" + getDataFromFeature("getdata(BUID)"));
		al.add("LpnDetail::3::5::" + getDataFromFeature("getdata(BUID)"));
		ExcelUtil1.setMultipleCellData(fileName, al);
	}

	@And("Update ItemId for Putaway based xlsx {string}")
	public void updateItemIdForPUTAWAYItemXlsx(String fileName) throws Exception {
		String Item = ExcelUtil.convert_variable_to_timestamp(getDataFromFeature("getdata(Item)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "Item", Item);
		FrameworkLogger.log(LogType.INFO, "Set value for Item : " + Item);
		ArrayList<String> al = new ArrayList<>();
		al.add("Item::2::3::" + Item);
		al.add("Item::2::38::" + Item.replaceAll("-", ""));
		al.add("ItemPackage::2::2::" + Item);
		al.add("ItemPackage::3::2::" + Item);
		al.add("ItemCode::2::2::" + Item);
		al.add("ItemCode::2::4::" + Item.replaceAll("-", ""));
		ExcelUtil1.setMultipleCellData(fileName, al);
	}

	@Then("Validate LPN Volume is Greater than Location available Volume")
	public void validateLPNVolumeIsGreaterThanLocationAvailableVolume() {
		ILPNPopupPage.validateLPNVolumeIsGreaterThanLocationAvailableVolume();
	}

	@Then("Click first putaway from navigation list")
	public void clickFirstPutwayStrategyFromNavigationList() {
		PutAwayPlanningStrategyPage.clickFirstPutwayStrategyFromNavigationList();
	}

	@Then("Validate BatchNumber {string} in OLPN Details")
	public void validateBatchNumberInOLPNDetails(String batch) {
		Olpns.verifyBatchNumberInOLPNDetails(getDataFromFeature(batch));
	}

	@Then("Validate BatchNumber {string} in iLPN Inventory Details")
	public void validateBatchNumberInILPNInventoryDetails(String batch) {
		ILPNs.verifyBatchInILPNDetails(getDataFromFeature(batch));
	}

	@And("Search Order with variable {string} in Order Page")
	public void searchOrderWithVariableInOrderPage(String order) {
		Olpns.searchOriginalOrder((String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + order));
	}

	@And("Verify order notes data with order notes templates with variable {string} {string}")
	public void verifyOrderNotesDataWithNoteTemplateInOriginalOrderPopup(String template_TS, String template_UC) {
		OriginalOrderPopupPage.verifyOrderNotesDataWithOrderNotesTemplate(template_TS, template_UC);
	}

	@And("Verify order lines note data with order notes templates with variable {string} {string}")
	public void verifyOrderLineNotesDataWithNoteTemplateInOriginalOrderPopup(String template_TS, String template_UC) {
		OriginalOrderPopupPage.verifyOrderLineNotesDataWithOrderNotesTemplate(template_TS, template_UC);
	}

	@And("Click order line header in order line popup")
	public void clickOrderLineHeaderInOrderLinePopup() {
		OrderLinePopupPage.clickOrderLineHeader();
	}

	@And("Click {string} on {string} ScrollByParticularElement")
	public void click_element_on_page_scrollbyparticularelement(String strBy, String strAppPage) {
		By byFromPage = GeneralUtils.getByFromPage(getDataFromFeature(strBy), getDataFromFeature(strAppPage));
		CommonMethods.scrollByParticularElement(SeleniumActions.getElement(byFromPage), byFromPage.toString());
		SeleniumActions.click(SeleniumActions.getElement(byFromPage), byFromPage.toString());
		CommonMethods.waitForPageLoading();
	}

	/*
	 * @And("Update ASN for one order multi piece with Serial Number in {string}")
	 * public void updateASNForOneOrderMultiPieceWithSerialNumberIn(String fileName)
	 * throws Exception { String asnId =
	 * ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(ASN)"));
	 * Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ASN", asnId);
	 * FrameworkLogger.log(LogType.INFO, "Set value for ASN : " + asnId);
	 * ArrayList<String> al = new ArrayList<>(); al.add("Asn::2::3::" + asnId);
	 * al.add("AsnLine::2::2::" + asnId); al.add("AsnLine::3::2::" + asnId);
	 * ExcelUtil1.setMultipleCellData(fileName, al); }
	 */

	@And("Assign Task {string} to current user {string}")
	public void assignTaskToCurrentUser(String strTaskStatus, String strCurrentuser) {
		if (TasksPage.getTasksStatus().equalsIgnoreCase(strTaskStatus)) {
			TasksPage.assignTaskDetails(strCurrentuser);
		}
	}

	@And("Click on details button For Allocations")
	public void clickOnDetailsButtonForAllocations() {
		FooterPanelPage.clickDetailsButton();
		CommonMethods.waitForPageLoading();
	}

	@And("Click on cancel OLPN button")
	public void clickOnCancelOLPNButton() {
		oLPNPage.clickOnCancelOLPNButtonWithReasonCode();

	}

	@And("Click On Pix Data Button")
	public void clickOnPixDataButton() {
		FooterPanelPage.clickPixDataButton();
	}

	@And("Verify Order Template data and entity id and store to variable")
	public void verifyAndStoreOrderTemplateAndEntityDataToVariable() {
		OrderTemplatePage.storeOrderTemplateAndEntityDataAndVerify("OrderTemplate", "EntityID");
	}

	@And("Click on Row At Second Index")
	public void clickOnRowAtSecondIndex() {
		CommonPage.clickRowAtSecondIndex();
	}

	@And("Filter Inventory Count Run ID")
	public void FilterInventoryCountRunID() {
		InventoryCountPage.filterCountRunID();
	}

	@And("Click Popup Confirm")
	public void ClickPopupConfirm() {
		CommonPopupPage.clickConfirmButton();
	}

	@And("Enter Scan Location {string}")
	public void enterScanLocation(String scanLocation) {
		LocationInventory.EnterScanLocation(getDataFromFeature(scanLocation));
	}

	@And("Verify Inventory Details for multiple ilpns")
	public void verifyInventoryDetailsForMultipleIlpns() {
		CommonMethods.waitForPageLoading();
		HeaderPanelPage.clickRelatedLinksButton();
		HeaderPanelPage.clickLPNInventory();
		CommonMethods.waitForPageLoading();
		ILPNs.verifyInventoryDetailsForMultipleIlpn();
	}

	@And("Verify Inventory Details All Cell Value for ListOfItems")
	public void verifyMultipleIlpnsDataInInventoryDetails_withListOfItems() {
		CommonMethods.waitForPageLoading();
		InventoryDetailsPage.verifyInventoryDetailsCellValueForEachItems();
		CommonMethods.waitForPageLoading();
	}

	@And("Validate LPN status and inventory details of LPN with no parent")
	public void validateLPNStatusAndInventoryDetailsOfLPNWithNoParent() {
		ILPNs.verifyILPStatusAndInventoryDetailsWithoutParentILPN();
	}

	@And("Search orders With {string}")
	public void searchOrdersWith(String text) {
		LeftPanelPage.searchOriginalOrder(getDataFromFeature(text));
	}

	@And("Verify Order Line Details for multiple Orders")
	public void verifyOrderLineDetailsForMultipleOrders() {
		CommonMethods.waitForPageLoading();
		OriginalOrdersPage.verifyOrderLineDetailsForMultipleOrders();
	}

	@And("Store Inventory Container ILPN To Variable")
	public void StoreInventoryContainerILPNToVariable() {
		InventoryDetailsPage.storeInventoryContainerNumberToString();
	}

	@And("Enter Inventory Container ILPN")
	public void enterInventoryContainerILPN() {
		String text = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "Inventory Container ILPN");
		LocationInventory.EnterILPN(text);
	}

	@And("Click On End ILPN Button")
	public void clickOnEndILPNButton() {
		WMMobile.clickEndILPNButton();
		CommonMethods.waitForPageLoading();
	}

	@And("View FNROUTING wave Strategy {string}")
	public void viewFNCUBINGWaveStrategy(String text) {
		OrdersPage.filterByNameWaveStrategy(getDataFromFeature(text));
		CommonPage.clickRowAtFirstIndex();
		CommonPage.selectThreeDots();
		CommonPage.selectViewButton();

	}

	@And("Select Order Selection Criteria For Routing")
	public void selectOrderSelectionCriteriaForRouting() {
		OrdersPage.selectOrderSelectionCriteria();
		CommonMethods.waitForPageLoading();
		CommonPage.selectContinueButton();
		CommonMethods.waitForPageLoading();
		OrderPlanningStrategyPage.selectRoutingAndVerifyAtRoutingStrategy();
		CommonMethods.waitForPageLoading();
	}

	@And("Navigate to Routing Strategy")
	public void navigateToRoutingStrategy() {
		HomePage.navigate_to_RoutingStrategy();
		OriginalOrdersPage.verifyRoutingStrategyPage();
	}

	@And("View ATROUTING Strategy {string}")
	public void viewATRoutingStrategy(String text) {
		RoutingStrategyPage.filterByNameRoutingStrategy(getDataFromFeature(text));
		CommonPage.clickRowAtFirstIndex();
		FooterPanelPage.clickbyViewIonButton();
		CommonMethods.waitForPageLoading();
	}

	@And("Set Routing Criteria For Routing And Verify Destination Country Rule")
	public void setRoutingCriteriaForRouting() {
		RoutingStrategyPage.selectRoutingCriteria();
		RoutingStrategyPage.openSlideOption();
		FooterPanelPage.clickViewButton();
		CommonMethods.waitForPageLoading();
		OrdersPage.selectOrderSelectionCriteria();
		RoutingStrategyPage.verifyCountryRule();
		CommonPage.selectContinueButton();
		CommonMethods.waitForPageLoading();
	}

	@And("Navigate to Ship Via")
	public void navigateToShipVia() {
		HomePage.navigate_to_shipVia();
		ShipViaPage.verifyShipViaPage();
	}

	@Then("Check Ship Vias And Verify the CarrierID {string}")
	public void checkShipViasAndVerifyTheCarrierID(String text) {
		ShipViaPage.filterByCarrierID(getDataFromFeature(text));
		ShipViaPage.verifyCarrierAtFirstIndex(getDataFromFeature(text));
	}

	@And("Update Order for three orders single piece for the same client in {string}")
	public void updateOrderForThreeOrdersSinglePieceForTheSameClientIn(String fileName) throws Exception {
		String originalOrder = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(OriginalOrderID)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder1", originalOrder + 1);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder2", originalOrder + 2);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder3", originalOrder + 3);
		FrameworkLogger.log(LogType.INFO, "Set value for OriginalOrder1 : " + originalOrder + 1);
		FrameworkLogger.log(LogType.INFO, "Set value for OriginalOrder2 : " + originalOrder + 2);
		FrameworkLogger.log(LogType.INFO, "Set value for OriginalOrder3 : " + originalOrder + 3);
		List<String> listOfOrders = new ArrayList<>();
		listOfOrders.add(originalOrder + 1);
		listOfOrders.add(originalOrder + 2);
		listOfOrders.add(originalOrder + 3);
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

	@Then("verify Container Size Definition details for multiple container")
	public void verifyDataInContainerSizeDefinition() {
		CommonMethods.waitForPageLoading();
		ContainerTypePage.verifyContainerSizeDefinitionDetailsForMultipleContainer();
	}

	@And("Verify Order Line Details for imported Orders {string}")
	public void verifyOrderLineDetailsForimportedOrders(String orders) {
		CommonMethods.waitForPageLoading();
		OriginalOrdersPage.verifyOrderLineDetailsForimportedOrders(orders);
	}

	@Then("Verify Each OLPNs Container sizes based on the container quantity for {string}")
	public void verifyEachOLPNsContainerSizesBasedOnTheContainerQuantityFor(String orders) {
		oLPNPage.verifyMultipleOLPNSSizesBasedOnTheQuantityForOrders(orders);
	}
	@And("Navigate to LANE Page")
	public void navigateToLanePage() {
		HomePage.navigateToLanePage();
	}

	@And("Search Lane With {string}")
	public void searchLaneWith(String text) {
		LeftPanelPage.searchLane(getDataFromFeature(text));
	}

	@And("Click on Routing Lane Option Links")
	public void clickOnRoutingLaneOptionLinks() {
		HeaderPanelPage.clickRoutingLaneOptionLink();
	}

	@And("Search Carrier With {string}")
	public void searchCarrierWithGetdataCarrier(String text) {
		LeftPanelPage.searchCarrier(getDataFromFeature(text));
	}

	@And("Validate Carrier Shipment Details for ATL1E and ATL2E")
	public void validateCarrierShipmentDetailsForATL1EAndATL2E() {
		LanePage.verifyCarrierShipmentDetailsInRoutingLaneOption();
	}

	@And("Update Two Original Order with Two Lines {string}")
	public void updateTwoOriginalOrderWithTwoLinesFNORDERROUTINGXlsx(String fileName) throws Exception {
		String strOrderValue = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(OriginalOrderID)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder", strOrderValue);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder1", strOrderValue + 1);
		FrameworkLogger.log(LogType.INFO, "Set value for Original Order1 : " + strOrderValue + 1);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder2", strOrderValue + 2);
		FrameworkLogger.log(LogType.INFO, "Set value for Original Order2 : " + strOrderValue + 2);
		ArrayList<String> al = new ArrayList<>();
		al.add("OriginalOrder::2::3::" + strOrderValue + 1);
		al.add("OriginalOrder::3::3::" + strOrderValue + 2);
		al.add("OriginalOrderLine::2::2::" + strOrderValue + 1);
		al.add("OriginalOrderLine::3::2::" + strOrderValue + 2);
		ExcelUtil1.setMultipleCellData(fileName, al);
	}
	@And("Execute RunWave {string} by Selecting Multiple orders {string}")
	public void executeRunWaveBySelectingMultipleOrdersAnd(String strategy ,String originalOrder) {
		String order = Variables.get(CurrentThreadInstance.getCurrentScenarioId() + originalOrder).toString();
		String searchOrderValue = order+"*";
		OriginalOrdersPage.filterMultipleOriginalOrder(searchOrderValue);
		OriginalOrdersPage.executeRunWaveForMultipleOrders(getDataFromFeature(strategy));
	}
	@And("verify Product Status And Class List for olpn {string} {string}")
	public void verifyProductStatusAndClassList_olpn(String productStatus,String productClass) {
		Olpns.verifyProductStatusAndProductClassList(productStatus,productClass);
	}
	@And("Verify OrderID For OLPNs In OLPN Page {string}")
	public void verifyOrderIDForOLPNsInOLPNPage(String Order) {
		oLPNPage.validateOLPNsOrderID((String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + Order));
	}
	@And("Verify Container Details In OLPN Page")
	public void verifyContainerDetailsInOLPNPage() {
		oLPNPage.validateContainerTypeInOLPNPage(getDataFromFeature("getdata(ContainerTypeId)"));
		oLPNPage.validateContainerSizeInOLPNPage(getDataFromFeature("getdata(ContainerSize)"));
		oLPNPage.validateLPNQuantityInOLPNPage(getDataFromFeature("getdata(LPNQuantity)"));
	}
	@And("Verify LPN details in Inventory Details page with location")
	public void VerifyLPNDetailsInventoryDetailswithocation() {
		InventoryDetailsPage.verifyLPNDetailsInventoryDetailsPagewithLocation();
	}
	@And("Verify Multiple OLPNS size and quantity")
	public void VerifyMultipleOLPNSSizeAndQuantityInOLPNPage() {
		oLPNPage.verifyTwoSameOLpnsWithSameQuantityAndOneWithDiffQuantity();
	}

	@And("Verify Order Line Need And Attribute Details for imported Orders {string}")
	public void verifyOrderLineNeedAndAttributeDetailsForimportedOrders(String orders) {
		CommonMethods.waitForPageLoading();
		OriginalOrdersPage.verifyOrderLineNeedAndAttributesDetailsForimportedOrders(orders);
	}

	@Then("Verify Cubing method parameters and residential parameters for each cube to capacity criteria type")
	public void verifyCubingMethodParametersAndResidentialParametersForEachCubeToCapacityCriteriaType() {
		Cubing.verifyFNCUBINRETAILDisplay();
		Cubing.verifyCubingMethodAndCubingParameterForEachCubeToCapacityCriteria();

	}

	@Then("verify Container Size Definition details for multiple container type")
	public void verifyContainerSizeDefinitiondetailsforeachcontainertype() {
		CommonMethods.waitForPageLoading();
		ContainerTypePage.verifyContainerTypeDetailsForEachContainerTypeId();
	}

	@And("Navigate Container Type")
	public void navigateToContainerType() {
		HomePage.navigateto_ContainerType();
		Cubing.verifyContainerTypePage();
	}

	@And("Verify Each OLPN has unique container type and size as per the cube capacity for {string}")
	public void verifyEachOLPNHasUniqueContainerTypeAndSizeAsPerTheCubeCapacityFor(String orders) {
		CommonMethods.waitForPageLoading();
		oLPNPage.validateAllOlpnsOfEachOderWithContainerTypeContainerSizeAndCubeValue(orders);
	}

	@And("Verify Carrier Id {string} and {string} exist")
	public void verifyCarrierIdAndExist(String carrier1, String carrier2) {
		LanePage.verifyCarrierIDDisplayed(getDataFromFeature(carrier1),getDataFromFeature(carrier2));

	}

	@And("Select Cube To Capacity Criteria")
	public void selectCubeToCapacityCriteria() {
		Cubing.selectCubeToCapacityCriteria();
		CommonMethods.waitForPageLoading();
	}


	@And("Search Order in OLPNs with variable {string}")
	public void searchOrderInOLPNsWithVariable(String order) {
		CommonMethods.waitForPageLoading();
		LeftPanelPage.searchOrderinOlpns((String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + order));
		CommonMethods.waitForPageLoading();
	}
	@And("Update ASN file with Single Asn and Single LPN {string}")
	public void updateASNFileWithLPN(String fileName) throws Exception {
		String asnId = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(ASN)"));
		String lpnId = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(LPN)"));
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
	@And("Validate Carrier Shipment Details for ATL4E")
	public void validateCarrierShipmentDetailsForATLE() {
		LanePage.verifyCarrierShipmentATL4EDetailsInRoutingLaneOption();
	}
	@And("Navigate to Shipments Page")
	public void navigateToShipmentPage() {
		HomePage.navigateToShipmentsPage();
	}
	@And("Search Shipment With {string} in Shipment Page")
	public void searchShipmentWith(String text) {
		LeftPanelPage.searchShipment(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + text).toString());
	}

	@And("Validate Carrier ATL4E in Shipment Page with {string}")
	public void validateCarrierATLEInShipmentPageWith(String olpnId) {
		LanePage.verifyCarrierShipmentDetailsInShipmentPage(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + olpnId).toString());

	}

	@And("Store Multiple TotalLPNQuantity to variable")
	public void storeMultipleTotalLPNQuantityToVariable() {
		oLPNPage.storeTotalLPNQuantity();
	}

	@And("Store Multiple OLPNS and TotalLPNQuantity to variable")
	public void storeMultipleOLPNSAndTotalLPNQuantityToVariable() {
		oLPNPage.storeOLPNsAndTotalLPNQuantity();
	}
	@And("Verify Carrier Id {string} and {string} exist in Lane Page")
	public void verifyCarrierIdAndExistInLanPage(String carrier1, String carrier2) {
		LanePage.verifyCarrierIDDisplayedAtSecondAndThirdIndex(getDataFromFeature(carrier1),getDataFromFeature(carrier2));
	}
	@And("Validate Carrier Shipment Details for ATL4E and ATL5E")
	public void validateCarrierShipmentDetailsForATL4EAndATL5E() {
		LanePage.verifyCarrierShipmentDetailsForATL4EAndATL5EInRoutingLaneOption();
	}
	@And("Validate OrderID And ShipVia Details Of OLPN In RoutingLaneOption {string} {string}")
	public void validateOrderIDAndShipViaDetailsOfOlpnInRoutingLaneOption(String carrier, String order) {
		LanePage.verifyCarrierShipmentOrderIDAndShipViaInRoutingLaneOption(getDataFromFeature(carrier),getDataFromFeature(order));

	}

	@And("Verify Inventory Details Location Barcode")
	public void verifyInventoryDetailsLocationBarcode() {
		InventoryDetailsPage.verifyInventoryDetailsLocationBarcode();
	}

	@And("Select Parcel Determination Strategy")
	public void selectParcelDeterminationStrategy() {
        CommonMethods.waitForPageLoading();
		RoutingStrategyPage.selectParcelDeterminationStrategy();
		CommonMethods.waitForPageLoading();
	}

	@Then("Verify Parcel Determination Strategy")
	public void verifyParcelDeterminationStrategy() {
		CommonMethods.waitForPageLoading();
		RoutingStrategyPage.verifyParcelDeterminationStrategy();
		CommonMethods.waitForPageLoading();
	}

	@And("Navigate to Parcel Determination Strategy")
	public void navigateToParcelDeterminationStrategy() {
		HomePage.navigate_to_ParcelDeterminationStrategy();
		CommonMethods.waitForPageLoading();
		HomePage.verifyParcelDeterminationStrategy();
		CommonMethods.waitForPageLoading();
	}

	@And("View FNParcelDeterminationStrategy")
	public void viewFNParcelDeterminationStrategy() {
        Routing.clickFNParcelDeterminationStrategy();
		CommonMethods.waitForPageLoading();
		Cubing.selectViewButton();
		CommonMethods.waitForPageLoading();
		Routing.clickSetParcelResource();
		CommonMethods.waitForPageLoading();
	}

	@And("Select and View Parcel resources")
	public void selectAndViewParcelResources() {
		Cubing.expandSideArrow3();
		CommonMethods.waitForPageLoading();
		CommonPage.selectViewButton();
		CommonMethods.waitForPageLoading();
		Routing.verifyShipViaDetails();
		CommonMethods.waitForPageLoading();
	}

	@And("Select and Verify Order Selection Criteria")
	public void selectAndVerifyOrderSelectionCriteria() {
		Routing.clickOrderSelectionCriteria();
		CommonMethods.waitForPageLoading();
		Routing.verifyOrderSelectionRuleValue();
		CommonMethods.waitForPageLoading();
	}

	@And("Select and View Second Parcel resource")
	public void selectAndViewSecondParcelResource() {
		Cubing.ExpandSideArrow();
		CommonMethods.waitForPageLoading();
		CommonPage.selectViewButton();
		CommonMethods.waitForPageLoading();
		Routing.verifyShipViaDetailsForSecondResource();
		CommonMethods.waitForPageLoading();
	}

	@And("Select and Verify Order Selection Criteria For Second Resource")
	public void selectAndVerifyOrderSelectionCriteriaForSecondResource() {
		Routing.clickOrderSelectionCriteria();
		CommonMethods.waitForPageLoading();
		Routing.verifyOrderSelectionRuleValueForSecondResource();
		CommonMethods.waitForPageLoading();
	}

	@And("Run FNCUBING Wave for two Orders")
	public void runFNCUBINGWaveForTwoOrders() {
		CommonMethods.waitForPageLoading();
		Cubing.selectTwoOrders();
		CommonMethods.waitForPageLoading();
		OriginalOrdersPage.executeRunWaveFNRoutingForTwoOrders();
		CommonMethods.waitForPageLoading();
	}
	@And("Update ASN with orders tracking Country of origin and Product status and Inventory Type in {string}")
	public void updateASNTrackingCountryProductStatusAndInventoryType(String fileName) throws Exception {
		String asnId = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(ASN)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ASN1", asnId+1);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ASN2", asnId+2);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ASN3", asnId+3);
		FrameworkLogger.log(LogType.INFO, "Set value for ASN1 : " + asnId+1);
		FrameworkLogger.log(LogType.INFO, "Set value for ASN2 : " + asnId+2);
		FrameworkLogger.log(LogType.INFO, "Set value for ASN3 : " + asnId+3);
		List<String> listOfASNs = new ArrayList<>();
		listOfASNs.add(asnId + 1);
		listOfASNs.add(asnId + 2);
		listOfASNs.add(asnId + 3);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "listOfAsns", listOfASNs);
		String asnS = String.join(",", listOfASNs);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ASNs", asnS);
		ArrayList<String> al = new ArrayList<>();
		al.add("Asn::2::3::" + asnId+1);
		al.add("Asn::3::3::" + asnId+2);
		al.add("Asn::4::3::" + asnId+3);
		al.add("AsnLine::2::2::" + asnId+1);
		al.add("AsnLine::3::2::" + asnId+2);
		al.add("AsnLine::4::2::" + asnId+3);
		ExcelUtil1.setMultipleCellData(fileName, al);
	}

	@And("Complete ATStandardReceiving with Country Of Origin")
	public void complete_at_standard_receiving_with_country_of_origin() {
		int orderLineQuantity = Integer.parseInt(getDataFromFeature("getdata(orderLineQuantity)"));
		for (int i = 1; i <= orderLineQuantity; i++) {
			ReceiveLPNLevel.searchASN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN" + i).toString());
			ReceiveLPNLevel.enterLPN(null, 1);
			ReceiveLPNLevel.enterScanItem(getDataFromFeature("getdata(ItemID_Line" + i + ")"));
			ReceiveLPNLevel.enterInventoryItemId(null);
			ReceiveLPNLevel.searchProductStatus(null);
			ReceiveLPNLevel.searchCOOrigin(null);
			ReceiveLPNLevel.enterQuantity(Integer.valueOf(getDataFromFeature("getdata(OrdQty_Line" + i + ")")));
			CommonWMMobilePage.clickVerifyASNButton();
			CommonPopupPage.verifyPopupMessageContains(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN" + i).toString());
			CommonPopupPage.clickOkButton();
		}
	}

	@And("Complete ATSystemDirectedPutAway with Multiple LPN")
	public void completeATSystemDirectedPutAwayWithMultipleLPN() {
		List<String> listOFiLPNs = new ArrayList<>();
		if (Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "listOFiLPNs") instanceof List<?>) {
			listOFiLPNs = (List<String>) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "listOFiLPNs");
		}
		if (listOFiLPNs.size() > 0) {
			for (String eachLpn : listOFiLPNs) {
				SystemDirected.searchLPN(eachLpn.trim());
				SystemDirected.enterScanReserveLocation();
			}
		}
	}
	@And("Update Mutiple ASN with Multiple Lpn {string}")
	public void updateMutipleASNWithMultipleLpn(String fileName) throws Exception {
		String asnId = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(AsnId)"));
		String lpnId = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(LpnId)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ASN", asnId);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN", lpnId);
		List<String> listOfAsnAtExcel = new ArrayList<String>();
		List<String> listOfLpnAtExcel = new ArrayList<String>();
		listOfAsnAtExcel=ExcelUtil1.getSpecificColumnValues("FN-ASNROUTING-08-TestScenarioDefinition.xlsx","Asn","AsnId");
		for(int i=1;i<=listOfAsnAtExcel.size();i++){
			Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ASN"+i, asnId + i);
			String asnIdValue= Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN"+i).toString();
			ArrayList<String> al = new ArrayList<>();
			int b = i+1;
			al.add("Asn::"+b+"::3::" + asnIdValue );
			ExcelUtil1.setMultipleCellData(fileName, al);
		}
		listOfLpnAtExcel=ExcelUtil1.getSpecificColumnValues("FN-ASNROUTING-08-TestScenarioDefinition.xlsx","Lpn","LpnId");
		System.out.println("listOfLpnAtExcel="+listOfLpnAtExcel.size());
		for(int i=1;i<=listOfLpnAtExcel.size();i++){
			Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN"+i, lpnId + i);
			String lpnIdValue= Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "LPN"+i).toString();
			System.out.println("lpnIdValue="+lpnIdValue);
			List<String> listOfILPNsValues = new ArrayList<>();
			listOfILPNsValues.add(lpnIdValue);
			Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ListOfILPNsValues", listOfILPNsValues);

			ArrayList<String> al = new ArrayList<>();
			int b = i+1;
			al.add("Lpn::"+b+"::2::" + lpnIdValue );
			al.add("LpnDetail::"+b+"::2::" + lpnIdValue );
			if(i==1){
				al.add("Lpn::"+b+"::6::" + Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN1").toString());
			}else if(i==2){
				al.add("Lpn::"+b+"::6::" + Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN1").toString());
			}else if(i==3){
				al.add("Lpn::"+b+"::6::" + Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN2").toString());
			}else if(i==4){
				al.add("Lpn::"+b+"::6::" + Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN3").toString());
			}else if(i==5){
				al.add("Lpn::"+b+"::6::" + Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN3").toString());
			}else if(i==6){
				al.add("Lpn::"+b+"::6::" + Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN4").toString());
			}else if(i==7){
				al.add("Lpn::"+b+"::6::" + Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN5").toString());
			}else if(i==8){
				al.add("Lpn::"+b+"::6::" + Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN6").toString());
			}else if(i==9){
				al.add("Lpn::"+b+"::6::" + Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN6").toString());
			}


			ExcelUtil1.setMultipleCellData(fileName, al);
		}

		List<String> listOfAsnsValues = new ArrayList<>();
		listOfAsnsValues=ExcelUtil1.getSpecificColumnValues("FN-ASNROUTING-08-TestScenarioDefinition.xlsx","Asn","AsnId");
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ListOfASNsValues", listOfAsnsValues);

		List<String> listLpnsValues = new ArrayList<>();
		listLpnsValues=ExcelUtil1.getSpecificColumnValues("FN-ASNROUTING-08-TestScenarioDefinition.xlsx","Lpn","LpnId");
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ListOfLPNValues", listLpnsValues);
	}

	@And("Search Multiple ASN at ASNs")
	public void searchMultipleASNAtASNs() {
		String str = Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN").toString();
		String strvalue = str+"*";
		ASNs.searchMultipleASN(strvalue);
	}

	@Then("Verify Multiple ASN details are displayed with variable {string}")
	public void verifyMultipleASNDetailsAreDisplayedWithVariable(String asnIdValue) {
		ASNs.verifyMultipleASNDisplayed((List<String>) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + asnIdValue));
	}

	@And("Complete ATStandardReceiving with Multiple ASN and Multiple LPN")
	public void completeATStandardReceivingWithMultipleASNAndMultipleLPN() {
		List<String> listOfAsn = new ArrayList<>();
		listOfAsn=ExcelUtil1.getSpecificColumnValues("FN-ASNROUTING-08-TestScenarioDefinition.xlsx","Lpn","AsnId");
		System.out.println("listOfAsn in WM MOBILE="+listOfAsn.size());
		System.out.println("listOfAsn in WM MOBILE="+listOfAsn);
		for(int i=1;i<=listOfAsn.size();i++){
			if(i==1){
				CommonMethods.waitForPageLoading();
				ReceiveLPNLevel.searchASN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN1").toString());
				CommonMethods.waitForPageLoading();
				ReceiveLPNLevel.enterLPN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "LPN1").toString());
				CommonMethods.waitForPageLoading();
				ReceiveLPNLevel.enterLPN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "LPN2").toString());
				CommonMethods.waitForPageLoading();
				CommonWMMobilePage.clickVerifyASNButton();
				PopupWrapper.validatePopupMessage("Verification request has been submitted for ASN");

			}else if(i==3){
				CommonMethods.waitForPageLoading();
				ReceiveLPNLevel.searchASN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN2").toString());
				CommonMethods.waitForPageLoading();
				ReceiveLPNLevel.enterLPN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "LPN3").toString());
				CommonMethods.waitForPageLoading();
				CommonWMMobilePage.clickVerifyASNButton();
				PopupWrapper.validatePopupMessage("Verification request has been submitted for ASN");
			}else if(i==4){
				CommonMethods.waitForPageLoading();
				ReceiveLPNLevel.searchASN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN3").toString());
				CommonMethods.waitForPageLoading();
				ReceiveLPNLevel.enterLPN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "LPN4").toString());
				CommonMethods.waitForPageLoading();
				ReceiveLPNLevel.enterLPN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "LPN5").toString());
				CommonMethods.waitForPageLoading();
				CommonWMMobilePage.clickVerifyASNButton();
				PopupWrapper.validatePopupMessage("Verification request has been submitted for ASN");
			}else if(i==6){
				CommonMethods.waitForPageLoading();
				ReceiveLPNLevel.searchASN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN4").toString());
				CommonMethods.waitForPageLoading();
				ReceiveLPNLevel.enterLPN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "LPN6").toString());
				CommonMethods.waitForPageLoading();
				CommonWMMobilePage.clickVerifyASNButton();
				PopupWrapper.validatePopupMessage("Verification request has been submitted for ASN");
			}else if(i==7){
				CommonMethods.waitForPageLoading();
				ReceiveLPNLevel.searchASN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN5").toString());
				CommonMethods.waitForPageLoading();
				ReceiveLPNLevel.enterLPN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "LPN7").toString());
				CommonMethods.waitForPageLoading();
				CommonWMMobilePage.clickVerifyASNButton();
				PopupWrapper.validatePopupMessage("Verification request has been submitted for ASN");
			}else if(i==8){
				CommonMethods.waitForPageLoading();
				ReceiveLPNLevel.searchASN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN6").toString());
				CommonMethods.waitForPageLoading();
				ReceiveLPNLevel.enterLPN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "LPN8").toString());
				CommonMethods.waitForPageLoading();
				ReceiveLPNLevel.enterLPN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "LPN9").toString());
				CommonMethods.waitForPageLoading();
				CommonWMMobilePage.clickVerifyASNButton();
				PopupWrapper.validatePopupMessage("Verification request has been submitted for ASN");
			}
		}
	}

	@And("Click on Action Menu Icon in WM Mobile Page")
	public void clickOnActionMenuIconInWMMobilePage() {
		ReceiveLPNLevel.clickOnMenuWmMobile();
	}


	@And("Enter Multiple ILPNs and Location in AT System Directed Putaway Page with {string}")
	public void enterMultipleILPNsAndLocationInATSystemDirectedPutawayPageWith(String lpns) {
		List<String> listOfILPNs = (List<String>) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + lpns);
		FNPutAwaySystemDirected.enterMultipleILPNAndLocationForATSystemDirected(listOfILPNs);
	}

	@And("Update Multiple OriginalOrder with Multiple Orderline in {string}")
	public void updateMultipleOriginalOrderWithMultipleOrderlineIn(String fileName) throws Exception {

		String strOrderValue = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(OriginalOrderID)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder", strOrderValue);

		System.out.println("OriginalOrder="+Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder").toString());

		List<String> listOfOriginalOrders = new ArrayList<String>();
		listOfOriginalOrders=ExcelUtil1.getSpecificColumnValues("FN-ORDERROUTING-08-TestScenarioDefinition.xlsx","OriginalOrder","OriginalOrderId");

		for(int i=1;i<=listOfOriginalOrders.size();i++){
			Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder"+i, strOrderValue +i);
			String orderVal= Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder"+i).toString();
			ArrayList<String> al = new ArrayList<>();
			int b=i+1;
			al.add("OriginalOrder::"+b+"::3::" + orderVal);
			al.add("OriginalOrderLine::"+b+"::2::" + orderVal);
			ExcelUtil1.setMultipleCellData(fileName, al);
		}
		List<String> listOfOriginalOrderValues = new ArrayList<>();
		listOfOriginalOrderValues=ExcelUtil1.getSpecificColumnValues("FN-ORDERROUTING-08-TestScenarioDefinition.xlsx","OriginalOrder","OriginalOrderId");
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ListOrderValues", listOfOriginalOrderValues);
		System.out.println("listOfOriginalOrderValues="+listOfOriginalOrderValues);
	}

	@Then("Verify Multiple OriginalOrders details are displayed with variable {string}")
	public void verifyMultipleOriginalOrdersDetailsAreDisplayedWithVariable(String orderValue)  {
		OriginalOrdersPage.verifyMultipleOriginalOrderDisplayed((List<String>) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + orderValue));
	}

	@And("Search Original Order with variable name {string}")
	public void searchOriginalOrderWithVariableName(String name) {
		String str = Variables.get(CurrentThreadInstance.getCurrentScenarioId() + name).toString();
		String strValue = str + "*";
		OriginalOrdersPage.filterMultipleOriginalOrder(strValue);
	}

	@And("Validate Carrier Shipment Details in Carton Attributes")
	public void validateCarrierShipmentDetailsInCartonAttributes() {
		LanePage.verifyMultipleShipmentInCartonAttribute();
	}

	@And("Click Navigate Lane Link")
	public void clickNavigateLaneLink() {
		LanePage.clickNavigationLaneLink();
	}

	@And("Validate Country and Postcode for Shipvis ATL7E and ATDHLENZ")
	public void validateCountryAndPostcodeForShipvisATLEAndATDHLENZ() {
		LanePage.verifyATL7EAndATDHLENZ();
	}

    @And("Navigate to Transportation Zone")
    public void navigateToTransportationZone() {
		HomePage.navigateToTransportationZone();
    }

	@And("Validate PostCode Range for country VIC and QLD")
	public void validatePostCodeRangeForCountryVICAndQLD() {
		LanePage.verifyPostCodeInTranportationZone();
	}

	@Then("Check Ship Vias And Verify the ShipViaID {string}")
	public void checkShipViasAndVerifyTheShipViaID(String text) {

		ShipViaPage.filterByShipViaID(getDataFromFeature(text));
		ShipViaPage.verifyShipID(getDataFromFeature(text));
	}

	@And("Run FNROUTING Wave for two Orders")
	public void runFNROUTINGWaveForTwoOrders() {
		CommonMethods.waitForPageLoading();
		Cubing.selectTwoOrders();
		CommonMethods.waitForPageLoading();
		OriginalOrdersPage.executeRunWaveFNRoutingStrategyForTwoOrders();
		CommonMethods.waitForPageLoading();
	}

	@And("Update ASN with Multiple LPN tracking Batch number in {string}")
	public void updateASNWithMultipleLPNTrackingBatchNumber(String fileName) throws Exception {
		String asnId = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(ASN)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ASN", asnId + 1);

		String lpnId = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(LPN)"));

		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN1", lpnId + 1);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN2", lpnId + 2);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN3", lpnId + 3);

		FrameworkLogger.log(LogType.INFO, "Set value for ASN : " + asnId + 1);
		FrameworkLogger.log(LogType.INFO, "Set value for LPN1 : " + lpnId + 1);
		FrameworkLogger.log(LogType.INFO, "Set value for LPN2 : " + lpnId + 2);
		FrameworkLogger.log(LogType.INFO, "Set value for LPN3 : " + lpnId + 3);

		List<String> listOfLPNs = new ArrayList<>();
		listOfLPNs.add(lpnId + 1);
		listOfLPNs.add(lpnId + 2);
		listOfLPNs.add(lpnId + 3);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "listOfILPNs", listOfLPNs);

		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ASN", asnId + 1);

		ArrayList<String> al = new ArrayList<>();
		al.add("Asn::2::3::" + asnId + 1);
		al.add("LPN::2::2::" + lpnId + 1);
		al.add("LPN::3::2::" + lpnId + 2);
		al.add("LPN::4::2::" + lpnId + 3);
		al.add("LPN::2::6::" + asnId + 1);
		al.add("LPN::3::6::" + asnId + 1);
		al.add("LPN::4::6::" + asnId + 1);
		al.add("LpnDetail::2::2::" + lpnId + 1);
		al.add("LpnDetail::3::2::" + lpnId + 2);
		al.add("LpnDetail::4::2::" + lpnId + 3);
		ExcelUtil1.setMultipleCellData(fileName, al);
	}
	@And("Set routing criteria for ATrouting and verify display of criterias")
	public void selectSetRoutingCriteriaforAtRoutingAndVerifyCriterias(){
		Routing.clickSetRoutingCriteria();
		Routing.viewRoutingCriteria("AusCriteria");
		Routing.clickOrderSelectionCriteria();
		Routing.verifyShippedOrdersCountry("Country1");
		Routing.clickRoutingCriteriaLabel2Navigation();
		Routing.viewRoutingCriteria("NZCriteria");
		Routing.clickOrderSelectionCriteria();
		Routing.verifyShippedOrdersCountry("Country2");
		CommonMethods.waitForPageLoading();
		Routing.clickRoutingCriteriaLabel2Navigation();
		Routing.clickRoutingCriteriaLabel1Navigation();
	}
	@And("Search ship via ID {string}")
	public void searchShipViaID(String shipViaID){
		ShipViaPage.filterByShipViaID(getDataFromFeature(shipViaID));
	}

	@And("Verify display of shipvia ID {string}")
	public void verifyShipViaIDisDisplayed(String shipviaID){
		ShipViaPage.verifyShipID(getDataFromFeature("getdata("+shipviaID+")"));
	}
	@And("Navigate to Ship Via from routing")
	public void navigateToShipViaFromRouting() {
		HomePage.navigateToShipViaFromSearchMenu();
		ShipViaPage.verifyShipViaPage();
	}
	@And("Verify shipVia ID of OLPNs")
	public void verifyShipViaIDOfOlpns() {
		Olpns.verifyShipViaIDOfOLPNs();
	}
	@And("Verify Replenishment details")
	public void verifyReplenishmentDetails() {
		AllocationPage.verifyReplenishmentDetails();
	}

	@And("Update ASN export file {string} with multiple ASNId for ASNLine")
	public void updateASNExportFile(String fileName) throws Exception{
		String asnId = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(ASN)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ASN", asnId);
		FrameworkLogger.log(LogType.INFO, "Set value for ASN : " + asnId);
		ArrayList<String> al = new ArrayList<>();
		al.add("Asn::2::3::" + asnId);
		al.add("AsnLine::2::2::" + asnId);
		al.add("AsnLine::3::2::" + asnId);
		al.add("AsnLine::4::2::" + asnId);
		ExcelUtil1.setMultipleCellData(fileName, al);

	}
}
