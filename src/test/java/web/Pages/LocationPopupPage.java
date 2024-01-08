package web.Pages;

import org.openqa.selenium.By;

import com.dhl.reports.FrameworkLogger;
import com.dhl.reports.LogType;
import com.dhl.testdata.TestData_Json;
import com.dhl.web.utils.SeleniumActions;

import stepdefinitions.CommonMethods;

@SuppressWarnings("unused")
public class LocationPopupPage extends TestData_Json {

	private static final By byZoneAssignmentAndLayoutInformationLabel = By
			.xpath("//span[normalize-space()='Zone Assignment and Layout Information']");
	private static final By byPutAllocationZone = By.xpath("//div[@data-component-id='PutAllocationZoneId']");
	private static final By byCloseIcon = By
			.xpath("//button[contains(@data-component-id,'close-icon')]//ion-icon[@name='close']");
	private static final By byLocationInformationLabel = By
			.xpath("//span[normalize-space()='Location Information']");
	private static final By byMaxWeight = By
			.xpath("//div[contains(@data-component-id,'MaxWeight')]");
	private static final By byMaxVolume = By
			.xpath("//div[contains(@data-component-id,'MaxVolume')]");

	/**
	 * Function to verify Put Allocation Zone
	 * 
	 * @param text - value to verify
	 */
	public static void verifyPutAllocationZoneValue(String text) {

		String allocationZone = SeleniumActions.getText(byPutAllocationZone);
		if (allocationZone.equals(text)) {
			FrameworkLogger.log(LogType.PASS, "Put AllocationZone Verification passed : " + allocationZone);
		} else {
			FrameworkLogger.log(LogType.FAIL,
					"Put AllocationZone Verification failed. Expected :+" + text + " , Actual :" + allocationZone);
		}
	}

	/**
	 * Function to click ZoneAssignment And LayoutInformation Label
	 */
	public static void clickZoneAssignmentAndLayoutInformationLabel() {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byZoneAssignmentAndLayoutInformationLabel,
				"click ZoneAssignment And LayoutInformation Label");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click Close Icon
	 */
	public static void clickCloseIcon() {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byCloseIcon, "Close icon");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click Location Information Label
	 */
	public static void clickLocationInformationLabel() {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byLocationInformationLabel,
				"click Location Information Label");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to get Max Weight
	 * @return
	 */
	public static String getMaxWeight() {
		return SeleniumActions.getText(byMaxWeight).trim();
	}

	/**
	 * Function to get Max Volume
	 * @return
	 */
	public static String getMaxVolume() {
		return SeleniumActions.getText(byMaxVolume).trim();
	}

}
