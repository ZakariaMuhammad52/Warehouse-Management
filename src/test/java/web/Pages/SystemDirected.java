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
public class SystemDirected extends TestData_Json {

	private static final By byPageTitle = By.xpath("//ion-title[contains(@data-component-id,'f1systemdirected')]");
	private static final By byLPNSearchField = By
			.xpath("//input[contains(@data-component-id,'barcodetextfield_container')]");
	private static final By byGoButton = By.xpath("//ion-button[contains(@data-component-id,'barcodetextfield_go')]");
	private static final By byScanLocText = By.xpath("//*[contains(@data-component-id,'barcodetextfield_location')]");
	private static final By byScanLocInput = By
			.xpath("//input[contains(@data-component-id,'barcodetextfield_scanlocation')]");
	private static final By bybackbutton = By.xpath("//ion-buttons[contains(@data-component-id,'action_back_button')]");
    private static final By byLPNScanContainer = By.xpath("//input[contains(@data-component-id,'barcodetextfield_scancontainer')]");

	/**
	 * Function to verify System Directed Page is displayed/visible
	 */
	public static void verifyPageDisplayed() {
		SeleniumActions.verifyElementVisible(byPageTitle, 20, "System Directed page");
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
	 * Function to search LPN
	 * 
	 * @param strText - LPN value which need to be searched
	 */
	public static void searchLPN(String strText) {
		SeleniumActions.getElement(byLPNSearchField).clear();
		SeleniumActions.sendTextToElement(byLPNSearchField, strText, "Container search field");
		SeleniumActions.click(byGoButton, "Go button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click on back button
	 *
	 */
    public static void clickBackButton() {
        CommonMethods.waitForPageLoading();
        SeleniumActions.getElement(bybackbutton).click();
        CommonMethods.waitForPageLoading();
    }

	/**
	 * Function to search LPN container
	 * @param strText - container value
	 *
	 */
    public static void searchLPNScanContainer(String strText) {
        SeleniumActions.getElement(byLPNScanContainer).clear();
        SeleniumActions.sendTextToElement(byLPNScanContainer, strText, "Container search field");
        SeleniumActions.click(byGoButton, "Go button");
        CommonMethods.waitForPageLoading();
    }
	/**
	 * Function to get scan location and feed to scan location input field and save
	 * value into runtime variable
	 */
	public static void enterScanLocation() {
		// Add code to capture warning error
		String strScanLocation = SeleniumActions.getText(byScanLocText);
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


	public static void enterScanReserveLocation() {
		// Add code to capture warning error
		String strScanLocation = SeleniumActions.getText(byScanLocText);
		if (strScanLocation != null && !strScanLocation.trim().isEmpty()) {
			Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "DisplayLocation", strScanLocation.trim());
			SeleniumActions.getElement(byScanLocInput).clear();
			String strSysScanLocation = strScanLocation.replace("-", "");
			SeleniumActions.sendTextToElement(byScanLocInput, strSysScanLocation.trim(), "Scan location field");
			SeleniumActions.click(byGoButton, "Go button");
			CommonMethods.waitForPageLoading();
		} else {
			FrameworkLogger.log(LogType.FAIL, "Scan location is null or empty");
		}
	}
}