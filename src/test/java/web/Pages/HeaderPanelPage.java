package web.Pages;

import org.openqa.selenium.By;

import com.dhl.testdata.TestData_Json;
import com.dhl.web.utils.SeleniumActions;

import stepdefinitions.CommonMethods;

@SuppressWarnings("unused")
public class HeaderPanelPage extends TestData_Json {

	private static final By byRelatedLinks = By.xpath("//*[contains(text(),'Related Links')]");
	private static final By byInventoryDetailsLink = By.xpath("//*[text()='Inventory details']");
	private static final By byImportDataLoaderButton = By.xpath("//button[@data-component-id='ImportDataLoader-header-panel']");
	private static final By byChooseFileButton = By.xpath("//label[contains(text(),'Choose File')]");
	private static final By byASNDetailsLink = By.xpath("//*[text()='ASN Details']");
	private static final By byLPNInventory = By.xpath("//a[text()='LPN (Inventory)']");
	private static final By byInventoryAttributesLink = By.xpath("//a[contains(text(),'Inventory Attributes')]");
	private static final By byLocationCapacityUsageLink = By.xpath("//*[text()='Location Capacity Usage']");
	private static final By byOrderLines= By.xpath("//*[contains(text(),'Order Lines')]");
	private static final By byOLPNs = By.xpath("//a[text()='oLPNs']");
	private static final By byOrdersLink = By.xpath("//*[contains(text(),'Orders')]");
	private static final By byTasksLinks = By.xpath("//*[contains(text(),'Tasks')]");
	private static final By byAllocations = By.xpath("//*[contains(text(),'Allocations')]");
	private static final By byLPNs = By.xpath("//a[text()='LPN']");
	private static final By byTasks = By.xpath("//a[text()='Tasks']");
	private static final By byTaskDetails = By.xpath("//a[text()='Task Details']");
	private static final By byRoutingLaneOptionLink = By.xpath("//a[text()='Routing Lane Option']");
	private static final By byTask = By.xpath("//a[text()='Task']");
	private static final By byOLPNLink = By.xpath("//a[text()='oLPN']");
	private static final By byOrder = By.xpath("//a[text()='Order']");

	/**
	 * Function to click Related Links
	 */
	public static void clickRelatedLinksButton() {
		SeleniumActions.click(byRelatedLinks, "Related Links");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click InventoryDetails Link
	 */
	public static void clickInventoryDetailsLink() {
		SeleniumActions.click(byInventoryDetailsLink, "Inventory Details Link");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click import data loader
	 */
	public static void clickImportDataLoader() {
		SeleniumActions.click(byImportDataLoaderButton, "Import data loader button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click ASNDetails Link
	 */
	public static void clickASNDetailsLink() {
		SeleniumActions.click(byASNDetailsLink, "ASNDetails Link");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click LPN Inventory
	 */
	public static void clickLPNInventory() {
		SeleniumActions.click(byLPNInventory, "LPN Inventory");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click clickInventoryAttributes Link
	 */
	public static void clickInventoryAttributes() {
		CommonMethods.scrollByParticularElement(byInventoryAttributesLink, "Inventory Attributes");
		SeleniumActions.click(byInventoryAttributesLink, "Inventory Attributes");
	}

	/**
	 * Function to click LocationCapacityUsage Link
	 */
	public static void clickLocationCapacityUsageLink() {
		SeleniumActions.click(byLocationCapacityUsageLink, "Location CapacityUsage Link");
		CommonMethods.waitForPageLoading();
	}


	/**
	 * Function to click oLPNs link
	 */
	public static void clickOLPNSLink() {
		SeleniumActions.click(byOLPNs, "oLPNs Link");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click OrderLines Links
	 */
	public static void clickOrderLinesLink() {
		SeleniumActions.click(byOrderLines, "OrderLines Link");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click Tasks link
	 */
	public static void clickTasksLink() {
		SeleniumActions.click(byTasksLinks, "Tasks Link");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click Tasks Details link
	 */
	public static void clickTaskDetailsLink() {
		SeleniumActions.click(byTaskDetails, "Tasks Link");
		CommonMethods.waitForPageLoading();
	}

	/**
	 Function to click Allocations Link
	 */
	public static void clickAllocationsLink() {
		SeleniumActions.click(byAllocations, "Allocations Link");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click Orders Link
	 */
	public static void clickOrdersLink() {
		SeleniumActions.click(byOrdersLink, "Orders Link");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click Routing Lane Option Link from Drop Down box
	 */
	public static void clickRoutingLaneOptionLink() {
		SeleniumActions.click(byRoutingLaneOptionLink, "Routing Lane Option Link");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click Task Link
	 */
	public static void clickTaskLink() {
		SeleniumActions.click(byTask, "Task Link");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click order Link
	 */
	public static void clickOrderLink() {
		SeleniumActions.click(byOrder, "Order Link");
		CommonMethods.waitForPageLoading();
	}

}
