package web.Pages;

import com.dhl.driver.DriverManager;
import com.dhl.reports.FrameworkLogger;
import com.dhl.reports.LogType;
import com.dhl.utils.CurrentThreadInstance;
import com.dhl.utils.Variables;
import org.openqa.selenium.By;
import com.dhl.testdata.TestData_Json;
import com.dhl.web.utils.SeleniumActions;
import org.openqa.selenium.WebElement;
import stepdefinitions.CommonMethods;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unused")
public class ItemsPage extends TestData_Json {
	private static final By byRowAtFirstIndex = By
			.xpath("(//card-view[@class='dm-fill-space card-views']//div[contains(@class,'card-row primary')])[1]");
	private static final By byAttributeGroupList = By.xpath("//span[contains(text(),'Attribute Group :')]//following-sibling::span[@title='Outbound only major serial tracking']");
	private static final By byOpenSlideOption = By.xpath("//slider-actions[contains(@data-component-id,'Slide-Actions')]//button[@data-component-id='action-closed-card-view']");
	private static final By byCloseSlideOption = By.xpath("(//slider-actions[contains(@data-component-id,'Slide-Actions')]//button[@data-component-id='action-open-card-view'])[2]");
	private static final By byExpandTrackingAttributes = By.xpath("//span[contains(text(),'Tracking Attributes')]");
	private static final By byTrackingAttributesTrackProductStatus = By.xpath("//div[@data-component-id='TrackProductStatus-list-expand']");
	private static final By byTrackingAttributesTrackInventoryType = By.xpath("//div[@data-component-id='TrackInventoryType-list-expand']");
	private static final By byCloseItemDetails = By.xpath("//button//ion-icon[@name='close']");
	private static final By byItemAtFirstIndex = By.xpath("(//span[@data-component-id='ItemId-card-view'])[1]");
	private static final By byItemsList = By.xpath("//span[@data-component-id='ItemId-card-view']");

	/**
	 * Function to click Row At FirstIndex
	 */
	public static void clickRowAtFirstIndex() {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byRowAtFirstIndex, "Row At FirstIndex");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to Attribute Group from Items card
	 */
	public static String verifyAttributeGroupAtFirstIndex() {
		String strAttributeGroup = SeleniumActions.getText(byAttributeGroupList);
		if (strAttributeGroup != null && !strAttributeGroup.trim().isEmpty()) {
			Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "AttributeGroupAtFirstIndex", strAttributeGroup.trim());
			return strAttributeGroup.trim();
		} else {
			FrameworkLogger.log(LogType.FAIL, "Attribute Group is null or empty");
		}
		return "";
	}
	/**
	 * Function to open slide options in Items Page
	 */
	public static void openSlideOption() {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byOpenSlideOption, "Open Slide option");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to close slide options in ILPN Page
	 */
	public static void closeSlideOption() {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byCloseSlideOption, "Close Slide option");
		CommonMethods.waitForPageLoading();
	}


	/**
	 * Function to verify Tracking Attribute is expanding the details.
	 */
	public static void expandTrackingAttributes() {
		SeleniumActions.click(byExpandTrackingAttributes, "Tracking Attributes is expanding");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to get current track product status from Items detail
	 * Attributes
	 */
	public static String getTrackProductStatusAtTrackingAttributes() {
		String strTrackProductStatus = SeleniumActions.getText(byTrackingAttributesTrackProductStatus);
		if (strTrackProductStatus != null && !strTrackProductStatus.trim().isEmpty()) {
			return strTrackProductStatus.trim();
		} else {
			FrameworkLogger.log(LogType.FAIL, "Track Product Status is null or empty");
		}
		return "";
	}

	/**
	 * Function to get current inventory type from ASN Details>ASN line>Inventory
	 * Attributes
	 */
	public static String getTrackInventoryTypeAtTrackingAttributes() {
		String strTrackInventoryType = SeleniumActions.getText(byTrackingAttributesTrackInventoryType);
		if (strTrackInventoryType != null && !strTrackInventoryType.trim().isEmpty()) {
			return strTrackInventoryType.trim();
		} else {
			FrameworkLogger.log(LogType.FAIL, "Track Inventory Type is null or empty");
		}
		return "";
	}
	/**
	 * Function to close Item details popup.
	 */
	public static void closeItemPopup() {
		SeleniumActions.click(byCloseItemDetails, "Item popup is close");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to verify Items displayed
	 */
	public static void verifyItemsDisplayed() {
		SeleniumActions.verifyElementVisible(byRowAtFirstIndex, 20, "Items card displayed");
	}

	/** Function to verify item at first index
	 * @param item - value which need to be verified
	 */
	public static void verifyItemAtFirstIndex(String item) {
		item = item.replaceAll("-", "");
		String actualItem = DriverManager.getDriver().findElement(byItemAtFirstIndex)
				.getText();
		actualItem = actualItem.replaceAll("-", "");
		if (item.equals(actualItem)) {
			FrameworkLogger.log(LogType.PASS, "Item Verification passed : " + item);
		} else {
			FrameworkLogger.log(LogType.FAIL, "Item Verification failed. Expected :" + item
					+ " , Actual :" + actualItem);
		}
	}

	/** Function to verify multiple items
	 * @param items - items value which need to be verified
	 */
	public static void verifyMultipleItems(String items) {
		List<String> expectedItems = new ArrayList<String>(Arrays.asList(items.split(",")));
		List<WebElement> elements = DriverManager.getDriver().findElements(byItemsList);
		List<String> actualItems = new ArrayList<>();
		for (WebElement e: elements){
			actualItems.add(e.getText());
		}
		if (expectedItems.equals(actualItems)) {
			FrameworkLogger.log(LogType.PASS, "Items Verification passed : " + expectedItems);
		} else {
			FrameworkLogger.log(LogType.FAIL, "Items Verification failed. Expected :" + expectedItems
					+ " , Actual :" + actualItems);
		}
	}
}
