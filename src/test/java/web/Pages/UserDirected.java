package web.Pages;

import java.util.List;

import org.openqa.selenium.By;

import com.dhl.reports.FrameworkLogger;
import com.dhl.reports.LogType;
import com.dhl.testdata.TestData_Json;
import com.dhl.utils.CurrentThreadInstance;
import com.dhl.utils.Variables;
import com.dhl.web.utils.SeleniumActions;

import stepdefinitions.CommonMethods;

@SuppressWarnings("unused")
public class UserDirected extends TestData_Json {

	private static final By byPageTitle = By.xpath("//ion-title[@data-component-id='atuserdirectedputaway']");
	private static final By byLPNSearchField = By
			.xpath("//input[contains(@data-component-id,'barcodetextfield_container')]");
	private static final By byoLPNSearchField = By
			.xpath("//input[contains(@data-component-id,'barcodetextfield_olpn')]");
	private static final By byGoButton = By.xpath("//ion-button[contains(@data-component-id,'barcodetextfield_go')]");
	private static final By byEnterQuantityInput = By
			.xpath("//input[@data-component-id='acceptitemquantity_naturalquantityfield_units']");
	private static final By byQtyGoButton = By
			.xpath("//ion-button[contains(@data-component-id,'naturalquantityfield_go')]");
	private static final By byScanLocInput = By
			.xpath("//input[contains(@data-component-id,'barcodetextfield_location')]");
	private static final By byVerifyASNButton = By
			.xpath("//button[contains(@data-component-id,'action_verifyasn_button')]");
	private static final By byConfirmButton = By.xpath("//span[text()='Confirm']");

	/**
	 * Function to verify System Directed Page is displayed/visible
	 */
	public static void verifyPageDisplayed() {
		SeleniumActions.verifyElementVisible(byPageTitle, 20, "User Directed page");
	}

	/**
	 * Function to Putaway LPNs
	 * 
	 * @param listOfLpns - LPN List
	 */
	public static void putAwayLPNs(List<String> listOfLpns) {
		if (listOfLpns.size() > 0) {
			for (String eachLpn : listOfLpns) {
				searchLPN(eachLpn.trim());
				enterScanLocation();
			}
		} else {
			FrameworkLogger.log(LogType.FAIL, "LPNs list is empty!");
		}
	}

	/**
	 * Function to Putaway LPN
	 * 
	 * @param lpn - LPN value
	 */
	public static void putawayLPN(String lpn) {
		if (lpn.isEmpty()) {
			FrameworkLogger.log(LogType.FAIL, "LPN is empty!");
		} else {
			searchLPN(lpn.trim());
			enterScanLocation();
		}
	}

	/**
	 * Function to search oLPN
	 * @param olpn - search value
	 */
	public static void pickpackoLPN(String olpn) {
		if (olpn.isEmpty()) {
			FrameworkLogger.log(LogType.FAIL, "LPN is empty!");
		} else {
			searchoLPN(olpn.trim());
		}
	}

	/**
	 * Function to search LPN
	 * 
	 * @param strText - LPN value which need to be searched
	 */
	public static void searchLPN(String strText) {
		SeleniumActions.getElement(byLPNSearchField).clear();
		SeleniumActions.sendTextToElement(byLPNSearchField, strText, "Container search field");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byGoButton, "Go button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to search olpn
	 * @param strText - serach value
	 */
	public static void searchoLPN(String strText) {
		SeleniumActions.getElement(byoLPNSearchField).clear();
		SeleniumActions.sendTextToElement(byoLPNSearchField, strText, "Container search field");
		SeleniumActions.click(byGoButton, "Go button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to get scan location and feed to scan location input field
	 */
	public static void enterScanLocation() {
		SeleniumActions.sendTextToElement(byEnterQuantityInput, getDataFromFeature("getdata(QtyToAssign_Line1_Valid)"),
				"Enter Quantity location field");
		SeleniumActions.click(byQtyGoButton, "Go button");
		String strScanLocation = getDataFromFeature("getdata(UserScanLocation)");
		if (strScanLocation != null && !strScanLocation.trim().isEmpty()) {
			Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "DisplayLocation", strScanLocation.trim());
			SeleniumActions.switchToWindowUsingIndex(0);
			HomePage.navigate_to_StorageLocation();
			StorageLocation.saveCurrentQuantity("CurrentQtyBeforeUpdate");
			SeleniumActions.switchToLastWindow();
			SeleniumActions.getElement(byScanLocInput).clear();
			String strSysScanLocation = strScanLocation.replace("-", "");
			SeleniumActions.sendTextToElement(byScanLocInput, strSysScanLocation.trim(), "Scan location field");
			SeleniumActions.click(byGoButton, "Go button");
			CommonMethods.waitForPageLoading();
		} else {
			FrameworkLogger.log(LogType.FAIL, "Scan location is null or empty");
		}
	}

	/**
	 * Function to enter scan location text field
	 * 
	 * @param location - value which need to be entered
	 */
	public static void enterScanLocation(String location) {
		CommonMethods.waitForPageLoading();
		SeleniumActions.sendTextToElement(byScanLocInput, location, "Scan location field");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byGoButton, "Go button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to enter quantity text field
	 * 
	 * @param quantity - value which need to be entered
	 */
	public static void enterQuantity(String quantity) {
		CommonMethods.waitForPageLoading();
		SeleniumActions.sendTextToElement(byEnterQuantityInput, quantity, "Enter Quantity field");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byQtyGoButton, "Go button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to enter scan location text field with warning
	 * 
	 * @param location - value which need to be entered
	 */
	public static void enterScanLocationWithWarning(String location) {
		CommonMethods.waitForPageLoading();
		String strSysScanLocation = location.replace("-", "");
		SeleniumActions.sendTextToElement(byScanLocInput, strSysScanLocation, "Scan location field");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byGoButton, "Go button");
		CommonMethods.waitForPageLoading();
		// This step is creating 504 Gateway Timeout error commented this code by
		/*
		 * if (DriverManager.getDriver().findElements(byConfirmButton).size() > 0) {
		 * SeleniumActions.click(byConfirmButton, "Confirm Button"); }
		 * CommonMethods.waitForPageLoading();
		 */
	}

}