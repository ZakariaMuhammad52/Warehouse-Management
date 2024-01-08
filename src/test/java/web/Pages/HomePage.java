package web.Pages;

import org.openqa.selenium.By;

import com.dhl.reports.FrameworkLogger;
import com.dhl.reports.LogType;
import com.dhl.testdata.TestData_Json;
import com.dhl.utils.ConfigurationUtils;
import com.dhl.utils.GeneralUtils;
import com.dhl.web.utils.KeyboardActions;
import com.dhl.web.utils.SeleniumActions;

import stepdefinitions.CommonMethods;

@SuppressWarnings("unused")
public class HomePage extends TestData_Json {

	private static final By byUDCHomePage = By.xpath("//span[contains(text(),'Unified Distribution Control')]");
	private static final By byMenuIcon = By.xpath("//*[contains(@class,'menu-toggle-button')]/ion-icon");
	private static final By bySearchMenu = By.xpath("//*[@id='menu-search']/input");
	private static final By byPurchaseOrdersMenu = By.xpath("//button[contains(@data-component-id,'PurchaseOrders')]");
	private static final By byASNsMenu = By.xpath("//button[contains(@data-component-id,'ASNs-hamburger-menu')]");
	private static final By byILPNsMenu = By.xpath("//button[contains(@data-component-id,'ILPNs')]");
	private static final By byWmMobileMenu = By.xpath("//button[@id='wmMobile']");
	private static final By byStorageLocationMenu = By.xpath("//button[@id='storageLocation']");
	private static final By byLocationInventoryMenu = By.xpath("//button[contains(@data-component-id,'LocationInventory')]");
	private static final By byEditProfile = By.xpath("//*[contains(@class,'orgfacbu-container')]");
	private static final By byBusinessUnit = By.xpath(
			"//autocomplete[@formcontrolname='businessUnit']//input[contains(@class,'native-input sc-ion-input-md')]");
	private static final By byBusinessUnitPopup = By.xpath(
			"//ion-input[@formcontrolname='businessUnit']//input[contains(@class,'native-input sc-ion-input-md')]");
	private static final By bySubmitButton = By.xpath("//*[contains(@data-component-id,'submit')]");
	private static final By byOriginalOrders2Menu = By.xpath("//button[contains(@data-component-id,'OriginalOrders2.0')]");
	private static final By byOriginalOrdersMenu = By.xpath("//button[contains(@data-component-id,'OriginalOrders')]");
	private static final By byOrdersMenu = By.xpath("//button[@data-component-id='OriginalOrders-hamburger-menu' and @id='originalOrders' ]");
	private static final By byOpenAlertButton = By
			.xpath("//ion-button[@data-component-id='global-btn-navbar-icons' and @title='Open Alerts']");
	private static final By byWaveRunsMenu = By
			.xpath("//button[@data-component-id='WaveRuns-hamburger-menu' and @id='OrderPlanningRunStrategy']");
	private static final By byTasksMenu = By.xpath("//button[@data-component-id='Tasks-hamburger-menu']");
	private static final By byContinueButton = By.xpath("//ion-button[normalize-space()='CONTINUE']");
	private static final By byBatchMasterMenu = By.xpath("//button[contains(@data-component-id,'BatchMaster')]");
	private static final By byInventoryDetailsMenu = By.xpath("//button[contains(@data-component-id,'InventoryDetails')]");
	private static final By byInventoryCountMenu = By.xpath("//button[contains(@data-component-id,'InventoryCount')]");
	private static final By byInventoryCountDetailMenu = By
			.xpath("//button[contains(@data-component-id,'InventoryCountDetail')]");
	private static final By bySettingsButton = By.xpath("//ion-button[contains(@data-component-id,'action_settings_button')]");
	private static final By byChangeOrganizationAndBusinessUnitLink = By
			.xpath("//ion-col[contains(@data-component-id,'changeorgfacilitybu')]");
	private static final By byBusinessUnitTextBox = By.xpath("//input[@placeholder='Select Business Unit']");
	private static final By byBusinessUnitWithDynamicText = By.xpath("//ion-label[@title='R-BU01']");
	private static final By byDoneButton = By.xpath("//ion-button[contains(@data-component-id,'action_done_button')]");
	private static final By byInventoryManagementLabel = By
			.xpath("//ion-label[@data-component-id='inventorymanagement']");
	private static final By byPutAwayPlanningStrategyMenu = By
			.xpath("//button[contains(@data-component-id,'PutawayPlanningStrategy')]");
	private static final By byPIXVisibilityMenu = By.xpath("//button[contains(@data-component-id,'PIXVisibility')]");
	private static final By byItemsMenu = By.xpath("//button[contains(@data-component-id,'Items')]");
	private static final By ExpandSideArrow = By.xpath("(//button[@data-component-id='action-closed'])[1]");
	private static final By byManageUserMenu = By.xpath("//button[contains(@data-component-id,'ManageUser')]");
	private static final By byProductStatusMatrixMenu = By.xpath("//button[contains(@data-component-id,'ProductStatusMatrix')]");
	private static final By byInventorySyncMenu = By.xpath("//button[contains(@data-component-id,'InventorySync')]");
	private static final By byItemTemplateMenu = By.xpath("//button[contains(@data-component-id,'ItemTemplate')]");

	private static final By byOrganization = By.xpath(
			"//autocomplete[@formcontrolname='organization']//input[contains(@class,'native-input sc-ion-input-md')]");
	private static final By byFacility = By.xpath(
			"//autocomplete[@formcontrolname='facility']//input[contains(@class,'native-input sc-ion-input-md')]");
	private static final By byProfile = By.xpath(
			"//autocomplete[@formcontrolname='profile']//input[contains(@class,'native-input sc-ion-input-md')]");
	private static final By byOrderPlanningStrategy = By.xpath("//button[contains(@data-component-id,'OrderPlanningStrategy')]");
	private static final By byCubingStrategy = By.xpath("//button[contains(@data-component-id,'CubingStrategy')]");
	private static final By byContainerType = By.xpath("//button[contains(@data-component-id,'ContainerType')]");
	private static final By byHomeIcon = By.xpath("(//*[contains(@class,'menu-toggle-button')]/ion-icon)[2]");
	private static final By byHomeIcon2 = By.xpath("(//*[contains(@class,'menu-toggle-button')]/ion-icon)[3]");
	private static final By byOrdersLineMenu = By.xpath("//button[contains(@data-component-id,'OrderLines')]");

	private static final By byOrderPlanningStrategyMenu = By
			.xpath("//button[contains(@data-component-id,'OrderPlanningStrategy')]");
	private static final By byWMMobileOrg = By.xpath("//input[@placeholder='Select Organization']");
	private static final By byWMMobileFaciity = By.xpath("//input[@placeholder='Select Location']");
	private static final By byPackStationMenu = By.xpath("//button[contains(@data-component-id,'PackStation')]");
	private static final By byEditButton = By.xpath("//button[@data-component-id='Edit']");

	private static final By byProfileButton = By.xpath("(//ion-button[contains(@data-component-id,'user-profile')])[2]");
	private static final By bySignOutButton = By
			.xpath("//ion-item[contains(@data-component-id,'logout-btn')]//span[contains(text(),'Sign out')]");
	private static final By bySignOutConfirm = By.xpath("//*[@data-component-id='SignOutConfirm']");
	private static final By byoLPNs2Menu = By.xpath("//button[contains(@data-component-id,'oLPNs2.0')]");
	private static final By byAllocationStrategy = By.xpath("//button[contains(@data-component-id,'AllocationStrategy')]");
	private static final By byOrderTemplateMenu = By.xpath("//button[contains(@data-component-id,'OrderTemplate')]");

	private static final By byDetailButton = By.xpath("//button[contains(@data-component-id,'Details')]");
	private static final By byRoutingStrategy = By.xpath("//button[contains(@data-component-id,'RoutingStrategy')]");
	private static final By byShipVia = By.xpath("//button[contains(@data-component-id,'ShipVia')]");
	private static final By byLaneMenu = By.xpath("//button[contains(@data-component-id,'Lane')]");
	private static final By byShipmentsMenu = By.xpath("//button[contains(@data-component-i,'Shipment')]");
	private static final By byParcelDeterminationStrategy = By
			.xpath("//button[contains(@data-component-id,'ParcelDeterminationStrategy')]");
	private static final By byParcelDeterminationStrategyPage = By
			.xpath("//span[contains(text(),'Parcel Determination Strategy')]");

	private static final By byTransportationZone = By.xpath("//button[contains(@data-component-id,'TransportationZone')]");

	/**
	 * Function to update Business Unit for the login instance
	 *
	 * @param strText - Business unit value
	 */
	public static void updateBusinessUnit(String strText) {
		SeleniumActions.click(byEditProfile, "Edit Org/Profile");

		CommonMethods.waitForPageLoading();
		SeleniumActions.sendTextToElement(byBusinessUnit, strText, "Business Unit lookup field");
		CommonMethods.waitForPageLoading();
		KeyboardActions.pressTabKey(byBusinessUnit);
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(bySubmitButton, "Submit button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to update Business Unit popup
	 *
	 * @param strText - Business unit value
	 */
	public static void updateBusinessUnitInPopup(String strText) {
		SeleniumActions.click(byBusinessUnitPopup, "Business UnitPopup");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(By.xpath("//p[normalize-space()='" + strText + "']"), "Business Unit");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byContinueButton, "Continue button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to update Business Unit in WMmobile
	 *
	 * @param strText - Business unit value
	 */
	public static void updateBusinessUnitInWMMobile(String strText) {
		SeleniumActions.click(bySettingsButton, "Settings button");
		CommonMethods.waitForPageLoading();
		CommonMethods.scrollByParticularElement(byChangeOrganizationAndBusinessUnitLink,
				"Change Organization and BusinessUnit link");
		SeleniumActions.clickByJS(byChangeOrganizationAndBusinessUnitLink, "Change Organization and BusinessUnit link");
		CommonMethods.waitForPageLoading();
		SeleniumActions.clear(byBusinessUnitTextBox, "Business Unit Text box");
		SeleniumActions.sendTextToElement(byBusinessUnitTextBox, strText, "Business Unit Text box");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(By.xpath("//ion-label[@title='" + strText + "']"), "Business Unit");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(bySubmitButton, "Submit button");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byDoneButton, "Done button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click submit button on confirmation screen with count
	 *
	 * @param count - value which need to be displayed on confirmation screen
	 */
	public static void clickSubmitOnCycleCountConfirmationScreen(String count) {
		CommonMethods.waitForPageLoading();
		SeleniumActions.verifyElementVisible(
				By.xpath("//span[contains(@data-component-id,'numberoflocations')]//following-sibling::span[normalize-space()='"
						+ count + "']"),
				20, "Count confirmation screen message");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(bySubmitButton, "Submit button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to verify UDC page is displayed/visible
	 */
	public static void verifyUDCPageDisplayed() {
		SeleniumActions.verifyElementVisible(byUDCHomePage, 60, "UDC page");
	}

	/**
	 * Function to navigate to iLPN screen
	 */
	public static void navigate_to_ILPNs() {
		searchMenu("ILPNs");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byILPNsMenu, "ILPNs");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to navigate to WM Mobile application screen
	 */
	public static void navigate_to_wmmobile() {
		searchMenu("WM Mobile");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byWmMobileMenu, "WM Mobile");
		CommonMethods.waitForPageLoading();
		SeleniumActions.switchToLastWindow();
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to search and select specified menu item
	 *
	 * @param strMenuText - menu item which need to be searched and selected
	 */
	public static void searchMenu(String strMenuText) {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byMenuIcon, "Menu icon");
		CommonMethods.waitForPageLoading();
		SeleniumActions.clear(bySearchMenu, "Search Field");
		CommonMethods.waitForPageLoading();
		SeleniumActions.sendTextToElement(bySearchMenu, strMenuText, "Search field");
	}

	/**
	 * Function to navigate to Storage Location screen
	 */
	public static void navigate_to_StorageLocation() {
		searchMenu("Storage Locations");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byStorageLocationMenu, "Storage Location");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to navigate to Location Inventory screen
	 */
	public static void navigate_to_LocationInventry() {
		searchMenu("Location Inventory");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byLocationInventoryMenu, "Location Inventory");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to navigate to Original Order 2.0 screen
	 */
	public static void navigate_to_OriginalOrder2() {
		searchMenu("Original Orders 2.0");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byOriginalOrders2Menu, "Original Orders 2.0");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to navigate to OriginalOrder screen
	 */
	public static void navigate_to_OriginalOrder() {
		searchMenu("Original Orders");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byOriginalOrdersMenu, "Original Orders");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to navigate to Orders screen
	 */
	public static void navigate_to_Orders() {
		searchMenu("Orders");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byOrdersMenu, "Orders");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to open alert
	 */
	public static void openAlertNotification() {
		SeleniumActions.click(byOpenAlertButton, "Open Alert Notification");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to Click on Alert notification icon
	 */
	public static void clickAlertNotificationIcon() {
		SeleniumActions.click(byOpenAlertButton, "Click Alert Notification icon");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to close and open alert notification
	 */
	public static void refreshAlertNotification() {
		SeleniumActions.click(byOpenAlertButton, "Close Alert Notification");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byOpenAlertButton, "Open Alert Notification");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to navigate to purchase order screen
	 */
	public static void navigate_to_waveRuns() {
		searchMenu("Wave Runs");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byWaveRunsMenu, "Wave Runs");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to navigate to purchase order screen
	 */
	public static void navigate_to_purchaseOrders() {
		searchMenu("Purchase Orders");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byPurchaseOrdersMenu, "Purchase Orders");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to navigate to ASN screen
	 */
	public static void navigate_to_ASNs() {
		searchMenu("ASNs");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byASNsMenu, "ASNs");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to navigate to iLPN screen
	 */
	/*
	 * public static void navigate_to_ILPNs() { searchMenu("ILPNs");
	 * CommonMethods.waitForPageLoading(); SeleniumActions.click(byILPNsMenu,
	 * "ILPNs"); CommonMethods.waitForPageLoading(); }
	 */

	/**
	 * Function to navigate to WM Mobile application screen
	 */
	/*
	 * public static void navigate_to_wmmobile() { searchMenu("WM Mobile");
	 * CommonMethods.waitForPageLoading(); SeleniumActions.click(byWmMobileMenu,
	 * "WM Mobile"); CommonMethods.waitForPageLoading();
	 * SeleniumActions.switchToLastWindow(); CommonMethods.waitForPageLoading(); }
	 */
	/**
	 * Function to search and select specified menu item
	 *
	 * @param strMenuText - menu item which need to be searched and selected
	 */
	/*
	 * public static void searchMenu(String strMenuText) {
	 * CommonMethods.waitForPageLoading(); SeleniumActions.click(byMenuIcon,
	 * "Menu icon"); CommonMethods.waitForPageLoading();
	 * SeleniumActions.clear(bySearchMenu, "Search Field");
	 * CommonMethods.waitForPageLoading();
	 * SeleniumActions.sendTextToElement(bySearchMenu, strMenuText, "Search field");
	 * }
	 */

	/**
	 * Function to navigate to Storage Location screen
	 */
	/*
	 * public static void navigate_to_StorageLocation() {
	 * searchMenu("Storage Locations"); CommonMethods.waitForPageLoading();
	 * SeleniumActions.click(byStorageLocationMenu, "Storage Location");
	 * CommonMethods.waitForPageLoading(); }
	 */

	/**
	 * Function to navigate to Location Inventory screen
	 */
	/*
	 * public static void navigate_to_LocationInventry() {
	 * searchMenu("Location Inventory"); CommonMethods.waitForPageLoading();
	 * SeleniumActions.click(byLocationInventoryMenu, "Location Inventory");
	 * CommonMethods.waitForPageLoading(); }
	 */
	/**
	 * Function to navigate to Original Order 2.0 screen
	 */
	/*
	 * public static void navigate_to_OriginalOrder2() {
	 * searchMenu("Original Orders 2.0"); CommonMethods.waitForPageLoading();
	 * SeleniumActions.click(byOriginalOrders2Menu, "Original Orders 2.0");
	 * CommonMethods.waitForPageLoading(); }
	 */

	/**
	 * Function to navigate to Items page
	 */
	public static void navigateToItemsPage() {
		searchMenu("Items");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byItemsMenu, "Items Menu");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to navigate to OriginalOrder screen
	 */
	/*
	 * public static void navigate_to_OriginalOrder() {
	 * searchMenu("Original Orders"); CommonMethods.waitForPageLoading();
	 * SeleniumActions.click(byOriginalOrdersMenu, "Original Orders");
	 * CommonMethods.waitForPageLoading(); }
	 */

	/**
	 * Function to navigate to Orders screen
	 */
	/*
	 * public static void navigate_to_Orders() { searchMenu("Orders");
	 * CommonMethods.waitForPageLoading(); SeleniumActions.click(byOrdersMenu,
	 * "Orders"); CommonMethods.waitForPageLoading(); }
	 */
	/**
	 * Function to open alert
	 */
	/*
	 * public static void openAlertNotification() {
	 * SeleniumActions.click(byOpenAlertButton, "Open Alert Notification");
	 * CommonMethods.waitForPageLoading(); }
	 */

	/**
	 * Function to close and open alert notification
	 */
	/*
	 * public static void refreshAlertNotification() {
	 * SeleniumActions.click(byOpenAlertButton, "Open Alert Notification");
	 * CommonMethods.waitForPageLoading(); SeleniumActions.click(byOpenAlertButton,
	 * "Open Alert Notification"); CommonMethods.waitForPageLoading(); }
	 */

	/**
	 * Function to navigate to Tasks page
	 */
	public static void navigateToTasks() {
		searchMenu("Tasks");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byTasksMenu, "Tasks");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to navigate to Batch Master page
	 */
	public static void navigateToBatchMaster() {
		searchMenu("Batch Master");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byBatchMasterMenu, "Batch Master");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to navigate to Inventory Details page
	 */
	public static void navigateToInventoryDetails() {
		searchMenu("Inventory Details");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byInventoryDetailsMenu, "Inventory Details");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to navigate to Inventory Count page
	 */
	public static void navigateToInventoryCount() {
		searchMenu("Inventory Count");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byInventoryCountMenu, "Inventory Count");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to navigate to Inventory Count Detail page
	 */
	public static void navigateToInventoryCountDetail() {
		searchMenu("Inventory Count Detail");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byInventoryCountDetailMenu, "Inventory Count Detail");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to navigate to Inventory Management page
	 */
	public static void navigateToInventoryManagement() {
		CommonMethods.waitForPageLoading();
		CommonMethods.scrollByParticularElement(byInventoryManagementLabel, "Inventory Management Label");
		SeleniumActions.click(byInventoryManagementLabel, "Inventory Management Label");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to navigate to PutAway PlanningStrategy page
	 */
	public static void navigateToPutAwayPlanningStrategyPage() {
		searchMenu("Putaway Planning Strategy");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byPutAwayPlanningStrategyMenu, "Putaway Planning Strategy");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to navigate to Pix visibility
	 */
	public static void navigateToPIXVisibility() {
		searchMenu("PIX Visibility");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byPIXVisibilityMenu, "PIX Visibility");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to navigate to Items page
	 */
	/*
	 * public static void navigateToItemsPage() { searchMenu("Items");
	 * CommonMethods.waitForPageLoading(); SeleniumActions.click(byItemsMenu,
	 * "Items Menu"); CommonMethods.waitForPageLoading(); }
	 */
	/**
	 * Function to open alert
	 */
	/*
	 * public static void clickAlertNotificationIcon() {
	 * SeleniumActions.click(byOpenAlertButton, "Click Alert Notification icon");
	 * CommonMethods.waitForPageLoading(); }
	 */

	/**
	 * Function to Expand side arrow
	 */
	public static void ExpandSideArrow() {
		SeleniumActions.click(ExpandSideArrow, "Expand Side Arrow");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to update business unit
	 * 
	 * @param strText- value to update
	 */
	public static void AsnUpdateBusinessUnitInPopup(String strText) {
		SeleniumActions.click(byBusinessUnitPopup, "Business UnitPopup");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(By.xpath("//p[normalizthane-space()='" + strText + "']"), "Business Unit");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byContinueButton, "Continue button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to navigate to Manage User page
	 */
	public static void navigateToManageUserPage() {
		searchMenu("Manage User");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byManageUserMenu, "Manage User Menu");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to navigate to ProductStatusMatrix page
	 */
	public static void navigateToProductStatusMatrixPage() {
		searchMenu("Product Status Matrix");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byProductStatusMatrixMenu, "Product Status Matrix Menu");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to navigate to Inventory Sync screen
	 */
	public static void navigate_to_Inventory_Sync() {
		searchMenu("Inventory Sync");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byInventorySyncMenu, "Inventory Sync");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to navigate to order planning strategy
	 */
	public static void navigate_to_OrderPlanningStrategy() {
		searchMenu("Order Planning Strategy");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byOrderPlanningStrategy, "byOrderPlanningStrategy");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to navigate to cubing strategy
	 */
	public static void navigate_to_CubingStrategy() {
		searchMenuIcon("Cubing Strategy");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byCubingStrategy, "Cubing Strategy");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to navigate to container type back from olpns page
	 */
	public static void navigate_to_ContainerType() {
		searchIcon("Container Type");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byContainerType, "Container Type");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to search menu
	 * 
	 * @param strMenuText - Menu name to be search
	 */
	public static void searchMenuIcon(String strMenuText) {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byHomeIcon, "Menu icon");
		CommonMethods.waitForPageLoading();
		SeleniumActions.clear(bySearchMenu, "Search Field");
		CommonMethods.waitForPageLoading();
		SeleniumActions.sendTextToElement(bySearchMenu, strMenuText, "Search field");
	}

	/**
	 * Function to search field
	 * 
	 * @param strMenuText - search value
	 */
	public static void searchIcon(String strMenuText) {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byHomeIcon2, "Menu icon");
		CommonMethods.waitForPageLoading();
		SeleniumActions.clear(bySearchMenu, "Search Field");
		CommonMethods.waitForPageLoading();
		SeleniumActions.sendTextToElement(bySearchMenu, strMenuText, "Search field");
	}

	/**
	 * Function to navigate back to original order2
	 */
	public static void navigate_Back_to_OriginalOrder2() {
		searchMenuIcon("Original Orders 2.0");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byOriginalOrders2Menu, "Original Orders 2.0");

	}

	/**
	 * Function to navigate to OrderLines page
	 */
	public static void navigateToOrderLinesPage() {
		searchMenu("Order Lines");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byOrdersLineMenu, "OrderLines Page");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to navigate to Order PlanningStrategy page
	 */
	public static void navigateToOrderPlanningStrategyPage() {
		searchMenu("Order Planning Strategy");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byOrderPlanningStrategyMenu, "Order PlanningStrategy Page");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to edit organization profile
	 *
	 */
	public static void editOrgProfile() {

		String strOrganization = ConfigurationUtils.getFrameworkConfig("organization");
		String strFacility = ConfigurationUtils.getFrameworkConfig("facility");
		String strBusinessUnit = ConfigurationUtils.getFrameworkConfig("businessunit");// getDataFromFeature("getdata(BUID)");
		String strProfile = ConfigurationUtils.getFrameworkConfig("profile");
		System.out.println("Organization Value : " + strOrganization);
		System.out.println("Facility Value : " + strFacility);
		System.out.println("Profile Value : " + strProfile);

		SeleniumActions.click(byEditProfile, "Edit Org/Profile");
		if (strOrganization.equalsIgnoreCase(SeleniumActions.getText(byOrganization))) {
			FrameworkLogger.log(LogType.INFO, "Organaisation is " + SeleniumActions.getText(byOrganization));
		} else {
			SeleniumActions.clear(byOrganization, "Organization Field");
			CommonMethods.waitForPageLoading();
			SeleniumActions.sendTextToElement(byOrganization, strOrganization, "Organization lookup field");
			CommonMethods.waitForPageLoading();
			KeyboardActions.pressEnterKey(byOrganization);
			CommonMethods.waitForPageLoading();
		}
		if (strFacility.equalsIgnoreCase(SeleniumActions.getText(byFacility))) {
			FrameworkLogger.log(LogType.INFO, "Facility is " + SeleniumActions.getText(byFacility));
		} else {
			SeleniumActions.clear(byFacility, "Facility Field");
			CommonMethods.waitForPageLoading();
			SeleniumActions.sendTextToElement(byFacility, strFacility, "Facility lookup field");
			CommonMethods.waitForPageLoading();
			KeyboardActions.pressEnterKey(byFacility);
			CommonMethods.waitForPageLoading();
		}
		if (strBusinessUnit.equalsIgnoreCase(SeleniumActions.getText(byBusinessUnit))) {
			FrameworkLogger.log(LogType.INFO, "Business is " + SeleniumActions.getText(byBusinessUnit));
		} else {
			SeleniumActions.clear(byBusinessUnit, "Business Unit Field");
			CommonMethods.waitForPageLoading();
			SeleniumActions.sendTextToElement(byBusinessUnit, strBusinessUnit, "Business Unit lookup field");
			CommonMethods.waitForPageLoading();
			KeyboardActions.pressEnterKey(byBusinessUnit);
			CommonMethods.waitForPageLoading();
		}
		if (strProfile.equalsIgnoreCase(SeleniumActions.getText(byProfile))) {
			FrameworkLogger.log(LogType.INFO, "Profile is " + SeleniumActions.getText(byProfile));
		} else {
			SeleniumActions.clear(byProfile, "Profile Field");
			CommonMethods.waitForPageLoading();
			SeleniumActions.sendTextToElement(byProfile, strProfile, "Profile lookup field");
			CommonMethods.waitForPageLoading();
			KeyboardActions.pressEnterKey(byProfile);
			CommonMethods.waitForPageLoading();
		}
		SeleniumActions.click(bySubmitButton, "Submit button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to update profile in wm mobile
	 */
	public static void updateProfileInWMMobile() {
		String strOrganization = ConfigurationUtils.getFrameworkConfig("organization");
		String strFacility = ConfigurationUtils.getFrameworkConfig("facility");
		String strBusinessUnit = ConfigurationUtils.getFrameworkConfig("businessunit");// getDataFromFeature("getdata(BUID)");
		String strProfile = ConfigurationUtils.getFrameworkConfig("profile");
		System.out.println("Organization Value : " + strOrganization);
		System.out.println("Facility Value : " + strFacility);
		System.out.println("Profile Value : " + strProfile);
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(bySettingsButton, "Settings button");
		CommonMethods.waitForPageLoading();
		CommonMethods.scrollByParticularElement(byChangeOrganizationAndBusinessUnitLink,
				"Change Organization and BusinessUnit link");
		CommonMethods.waitForPageLoading();
		SeleniumActions.clickByJS(byChangeOrganizationAndBusinessUnitLink, "Change Organization and BusinessUnit link");

		CommonMethods.waitForPageLoading();
		SeleniumActions.clear(byWMMobileOrg, "Organization Text box");
		CommonMethods.waitForPageLoading();
		SeleniumActions.sendTextToElement(byWMMobileOrg, strOrganization, "Organization Text box");
		CommonMethods.waitForPageLoading();
		KeyboardActions.pressEnterKey(byWMMobileOrg);
		CommonMethods.waitForPageLoading();

		SeleniumActions.clear(byWMMobileFaciity, "Organization Text box");
		CommonMethods.waitForPageLoading();
		SeleniumActions.sendTextToElement(byWMMobileFaciity, strFacility, "Business Unit Text box");
		CommonMethods.waitForPageLoading();
		KeyboardActions.pressEnterKey(byWMMobileFaciity);
		CommonMethods.waitForPageLoading();

		SeleniumActions.clear(byBusinessUnitTextBox, "Organization Text box");
		CommonMethods.waitForPageLoading();
		SeleniumActions.sendTextToElement(byBusinessUnitTextBox, strBusinessUnit, "Business Unit Text box");
		CommonMethods.waitForPageLoading();
		KeyboardActions.pressEnterKey(byBusinessUnitTextBox);
		CommonMethods.waitForPageLoading();

		SeleniumActions.click(bySubmitButton, "Submit button");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byDoneButton, "Done button");
		CommonMethods.waitForPageLoading();

	}

	/**
	 * Function to navigate back to container type
	 */
	public static void navigate_Back_to_ContainerType() {
		searchMenuIcon("Container Type");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byContainerType, "Container Type");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to navigate to pack station
	 * 
	 * @param station - station name
	 */
	public static void navigateToPackStation(String station) {
		searchMenu("Pack Station");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byPackStationMenu, "Pack Station");
		CommonMethods.waitForPageLoading();
		PackStationPage.selectPackingStation(station);
	}

	/**
	 * Function to click Edit at swipe menu
	 */
	public static void clickEditSwipeMenu() {
		SeleniumActions.click(byEditButton, "Click Edit button at swipe menu");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click expand side arrow
	 */
	public static void ExpandMultipleSideArrow(int lineQuantity) {
		SeleniumActions.click(By.xpath("(//button[contains(@data-component-id,'action-closed')])[" + lineQuantity + "]"),
				"Expand Side Arrow at line " + lineQuantity);
		CommonMethods.waitForPageLoading();
	}

	/*
	 * Function to Logout and login with other id
	 */
	public static void SignOutAndLoginSecondUser() {
		SeleniumActions.click(byProfileButton, "Profile button");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(bySignOutButton, "SignOutButton");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(bySignOutConfirm, "SignOutConfirm");
		CommonMethods.waitForPageLoading();

		String strUsername = ConfigurationUtils.getFrameworkConfig("appusername2");
		String strPassword = ConfigurationUtils.getFrameworkConfig("apppassword2");
		LoginPage.enter_Username(strUsername);
		LoginPage.click_SubmitUser();
		LoginPage.enter_password(GeneralUtils.decodeBase64ToString(strPassword));
		LoginPage.click_LoginBt();
		// HomePage.verifyUDCPageDisplayed();
	}

	/**
	 * Function to navigate to OLPNS2.0 Page
	 *
	 */
	public static void navigateToOLPNS2_O() {
		searchMenu("oLPNs 2.0");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byoLPNs2Menu, "oLPNs 2.0");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to navigate to Items Template page
	 */
	public static void navigateToItemTemplatePage() {
		searchMenu("Item Template");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byItemTemplateMenu, "Item Template Menu");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to navigate to allocation strategy
	 */
	public static void navigate_to_AllocationStrategy() {
		searchMenuIcon("Allocation Strategy");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byAllocationStrategy, "byAllocationStrategy");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to navigate back to cubing strategy
	 */
	public static void navigate_Backto_CubingStrategy() {
		searchIcon("Cubing Strategy");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byCubingStrategy, "Cubing Strategy");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to navigate to order planning strategy
	 */
	public static void navigateBack_to_OrderPlanningStrategy() {
		searchMenuIcon("Order Planning Strategy");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byOrderPlanningStrategyMenu, "Order PlanningStrategy Page");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to navigate to Porder template page
	 */
	public static void navigateToOrderTemplatePage() {
		searchMenu("Order Template");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byOrderTemplateMenu, "Order Template Menu");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click Edit at swipe menu
	 */
	public static void clickDetailSwipeMenu() {
		SeleniumActions.click(byDetailButton, "Click Detail button at swipe menu");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click on Routing Strategy menu
	 */
	public static void navigate_to_RoutingStrategy() {
		searchMenuIcon("Routing Strategy");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byRoutingStrategy, "byRoutingStrategy");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click on Ship Via Menu
	 */
	public static void navigate_to_shipVia() {
		searchIcon("Ship Via");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byShipVia, "byShipVia");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to Navigate to Lane Menu
	 */
	public static void navigateToLanePage() {
		searchMenu("Lane");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byLaneMenu, "Lane Menu");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to navigate to container type
	 */
	public static void navigateto_ContainerType() {
		searchMenu("Container Type");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byContainerType, "Container Type");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to Navigate to Shipments Menu
	 */
	public static void navigateToShipmentsPage() {
		searchMenu("Shipment");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byShipmentsMenu, "Shipment Menu");
	}

	/**
	 * Function to navigate to [parcel determination strategy
	 */
	public static void navigate_to_ParcelDeterminationStrategy() {
		searchMenu("Parcel Determination Strategy");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byParcelDeterminationStrategy, "Parcel Determination Strategy");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to verify parcel determination strategy
	 */
	public static void verifyParcelDeterminationStrategy() {
		SeleniumActions.verifyElementVisible(byParcelDeterminationStrategyPage, 20, "Order Planning Strategy Page");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to Navigate to Transportation Zone Menu
	 */
	public static void navigateToTransportationZone() {
		searchMenu("Transportation Zone");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byTransportationZone, "TransportationZone Menu");
		CommonMethods.waitForPageLoading();
	}
	/**
	 * Function to Navigate to Container Type
	 */
	public static void navigate_to_ContainerTypePage() {
		searchMenu("Container Type");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byContainerType, "Container Type");
		CommonMethods.waitForPageLoading();
	}
	public static void navigateToShipViaFromSearchMenu() {
		searchMenu("Ship Via");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byShipVia, "byShipVia");
		CommonMethods.waitForPageLoading();
	}
}