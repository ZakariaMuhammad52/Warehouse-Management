package web.Pages;

import com.dhl.utils.ConfigurationUtils;
import org.openqa.selenium.By;

import com.dhl.driver.DriverManager;
import com.dhl.reports.FrameworkLogger;
import com.dhl.reports.LogType;
import com.dhl.testdata.TestData_Json;
import com.dhl.web.utils.SeleniumActions;

import stepdefinitions.CommonMethods;

@SuppressWarnings("unused")
public class PutAwayPlanningStrategyPage extends TestData_Json {

	private static final By byPutAwayPlanningStrategyPage = By
			.xpath("//span[contains(text(),'Putaway Planning Strategy')]");
	private static final By byCloseIconForFNPutAwayPlanningStrategy = By.xpath(
			"//span[@data-component-id='PutawayPlanningStrategyId'][normalize-space()='FNPutawayPlanningStrategy']//ancestor::div[contains(@class,'dm-flex-row-layout')]//following-sibling::slider-actions[1]//button");
	private static final By byViewButtonInRightSidePanel = By.xpath("//button[@data-component-id='View']//img");
	private static final By byViewButton2InRightSidePanel = By.xpath("(//button[@data-component-id='View']//img)[2]");
	private static final By byViewButton3InRightSidePanel = By.xpath("(//button[@data-component-id='View']//img)[3]");
	private static final By byContinueButtonInRightSide = By.xpath("//button[normalize-space()='Continue']");
	private static final By byCloseIconForQR1PutAwayPlanningCriteriaItem = By.xpath(
			"//span[@title='QR1']//ancestor::div[contains(@class,'dm-flex-col-layout')]//following-sibling::slider-actions[1]//button");// Need
	private static final By byCloseIconForATPutAwayPlanningStrategy = By.xpath(
			"//span[@data-component-id='PutawayPlanningStrategyId'][normalize-space()='ATPutawayPlanningStrategy']//ancestor::div[contains(@class,'dm-flex-row-layout')]//following-sibling::slider-actions[1]//button");
	private static final By byCloseIconForRBU01PutAwayPlanningCriteriaItem = By.xpath(
			"//span[@title='R-BU01']//ancestor::div[contains(@class,'dm-flex-col-layout')]//following-sibling::slider-actions[1]//button");
	private static final By byCloseIconForPutAwayAtFirstIndex = By.xpath(
			"//span[@data-component-id='PutawayPriorityId']//ancestor::div[2]//following-sibling::slider-actions[1]//button");
	private static final By byAttributeTextField = By.xpath("(//input[@data-component-id='view-label-display'])[2]");
	private static final By byOperatorTextField = By.xpath("(//input[@data-component-id='view-label-display'])[3]");
	private static final By byValueTextField = By.xpath("(//input[@data-component-id='view-label-display'])[4]");
	private static final By byDeterminationModeDescription = By
			.xpath("//span[@data-component-id='DeterminationModeDescription']");
	private static final By byZoneBasedLocationDetermination = By
			.xpath("//span[@title='Zone Based Location Determination']");
	private static final By byPutAwayZone = By.xpath("(//span[@data-component-id='PutawayZone'])[1]");
	private static final By byPutAwayZone2 = By.xpath("(//span[@data-component-id='PutawayZone'])[2]");
	private static final By byPutAwayZone3 = By.xpath("(//span[@data-component-id='PutawayZone'])[3]");
	private static final By byFinishButton = By
			.xpath("//dm-wizard[@data-component-id='PutawayPriorityWizard']//button[normalize-space()='Finish']");
	private static final By byFinishButton2 = By.xpath(
			"//dm-wizard[@data-component-id='PutawayPlanningCriteriaWizard']//button[normalize-space()='Finish']");
	private static final By byFinishButton3 = By.xpath(
			"//dm-wizard[@data-component-id='PutawayPlanningStrategyWizard']//button[normalize-space()='Finish']");
	private static final By byStorageLocations = By.xpath("//button[@data-component-id='StorageLocations']");
	private static final By byDisplayLocation = By.xpath("//span[@data-component-id='DisplayLocation']");
	private static final By byStatus = By.xpath("//span[@data-component-id='Status']");
	private static final By byCurrentLocationId = By.xpath("//span[@data-component-id='CurrentLocationId']");
	private static final By byCurrentLocationTypeId = By.xpath("//span[@data-component-id='CurrentLocationTypeId']");
	private static final By byInventoryDetails = By.xpath("//a[text()='Inventory details']");
	private static final By byInventoryType = By.xpath("//span[contains(@data-component-id,'Inventorytype')]");
	private static final By byFinished = By.xpath("//div[contains(@data-component-id,'Finished')]");
	private static final By byQuarantine = By.xpath("//div[contains(@data-component-id,'Quarantine')]");
	private static final By byCloseIconForBooksPutAwayPlanningCriteriaItem = By.xpath(
			"//span[@title='Books']//ancestor::div[contains(@class,'dm-flex-col-layout')]//following-sibling::slider-actions[1]//button");
	private static final By byCloseIconForUnitPutAwayPriorityItem = By.xpath(
			"//span[@data-component-id='PutawayUomId' and @title='UNIT']//ancestor::div[2]//following-sibling::slider-actions[1]//button");

	private static final By byCloseIconForLPNPutAwayPriorityItem = By.xpath(
			"//span[@data-component-id='PutawayUomId' and @title='LPN']//ancestor::div[2]//following-sibling::slider-actions[1]//button");
	private static final By byCloseIconForATPltPutAwayPlanningStrategy = By.xpath(
			"//span[@data-component-id='PutawayPlanningStrategyId'][normalize-space()='ATPltPutaway']//ancestor::div[contains(@class,'dm-flex-row-layout')]//following-sibling::slider-actions[1]//button");
	private static final By byContainerPlanningMode = By.xpath("//div[contains(text(),'Putaway Entire Pallet')]");
	private static final By byCloseIconForATPltPutAwayPlanningCriteriaItem = By.xpath(
			"//span[@title='ATPltPutawayPlanningCriteria']//ancestor::div[contains(@class,'dm-flex-col-layout')]//following-sibling::slider-actions[1]//button");// Need
	private static final By byFirstPutawayPlanningstrategyFromNavigationList = By.xpath("(//a[@title='Putaway Planning Strategy'])[5]");
	/**
	 * Function to verify Inventory Count Detail Page is displayed
	 */
	public static void verifyPutAwayPlanningStrategyPage() {
		SeleniumActions.verifyElementVisible(byPutAwayPlanningStrategyPage, 20, " PutAway PlanningStrategy Page");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click Close Icon ForFNPutAwayPlanningStrategy
	 */
	public static void clickCloseIconForFNPutAwayPlanningStrategy() {
		CommonMethods.scrollByParticularElement(byCloseIconForFNPutAwayPlanningStrategy,
				"Close Icon For FNPutAwayPlanningStrategy");
		SeleniumActions.click(byCloseIconForFNPutAwayPlanningStrategy, "Close Icon For FNPutAwayPlanningStrategy");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click View button
	 */
	public static void clickViewButton() {
		SeleniumActions.click(byViewButtonInRightSidePanel, "View button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click View button
	 */
	public static void clickViewButton2() {
		SeleniumActions.click(byViewButton2InRightSidePanel, "View button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to continue button
	 */
	public static void clickContinueButton() {
		SeleniumActions.click(byContinueButtonInRightSide, "Continue button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to Finish button
	 */
	public static void clickFinishButton() {
		SeleniumActions.click(byFinishButton, "Finish button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to Finish button
	 */
	public static void clickFinishButton2() {
		SeleniumActions.click(byFinishButton2, "Finish button2");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to Finish button
	 */
	public static void clickFinishButton3() {
		SeleniumActions.click(byFinishButton3, "Finish button3");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click CloseIcon For QR1 PutAway Planning Criteria Item
	 */
	public static void clickCloseIconForQR1PutAwayPlanningCriteriaItem() {
		CommonMethods.scrollByParticularElement(byCloseIconForQR1PutAwayPlanningCriteriaItem,
				"Close Icon For QR1 PutAway Planning Criteria Item");
		SeleniumActions.click(byCloseIconForQR1PutAwayPlanningCriteriaItem,
				"Close Icon For QR1 PutAway Planning Criteria Item ");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click CloseIcon For Determination Mode
	 */
	public static void clickCloseIconForPutAwayAtFirstIndex() {
		SeleniumActions.click(byCloseIconForPutAwayAtFirstIndex, "Close Icon For PutAway At FirstIndex");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to verify Rules
	 */
	public static void verifyRules() {
		SeleniumActions.verifyElementVisible(byAttributeTextField, 10, "Attribute Text Field");
		SeleniumActions.verifyElementVisible(byOperatorTextField, 10, "Operator Text Field");
		SeleniumActions.verifyElementVisible(byValueTextField, 10, "Value Text Field");
	}

	/**
	 * Function to verify DeterminationMode
	 */
	public static void verifyDeterminationMode() {
		SeleniumActions.verifyElementVisible(byDeterminationModeDescription, 10, "Determination Mode ");
	}

	/**
	 * Function to verify PutAwayZone
	 * 
	 * @param text - value which need to be verified
	 */
	public static void verifyPutAwayZone(String text) {
		String actualText = SeleniumActions.getAtrribute(byPutAwayZone, "title", Integer.parseInt(ConfigurationUtils.getFrameworkConfig("implicitlywait")));
		if (text.equals(actualText)) {
			FrameworkLogger.log(LogType.PASS, "PutAwayZone Verification passed : " + actualText);
		} else {
			FrameworkLogger.log(LogType.FAIL,
					"PutAwayZone Verification failed. Expected :+" + text + " , Actual :" + actualText);
		}
	}

	/**
	 * Function to click CloseIcon For Books PutAway Planning Criteria Item
	 */
	public static void clickCloseIconForBooksPutAwayPlanningCriteriaItem() {
		CommonMethods.scrollByParticularElement(byCloseIconForBooksPutAwayPlanningCriteriaItem,
				"Close Icon For Books PutAway Planning Criteria Item");
		SeleniumActions.click(byCloseIconForBooksPutAwayPlanningCriteriaItem,
				"Close Icon For Books PutAway Planning Criteria Item ");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to verify Zone Based Location Determination
	 * 
	 * @param text - Value to be verified
	 */
	public static void verifyZoneBasedLocationDetermination(String text) {
		String actualText = DriverManager.getDriver().findElement(byZoneBasedLocationDetermination)
				.getAttribute("title");
		if (text.equals(actualText)) {
			FrameworkLogger.log(LogType.PASS, "Zone Based Location Determination Verification passed : " + text);
		} else {
			FrameworkLogger.log(LogType.FAIL, "Zone Based Location Determination Verification failed. Expected :+"
					+ text + " , Actual :" + actualText);
		}
	}

	/**
	 * Function to click Close Icon For AT PutAwayPlanningStrategy
	 */
	public static void clickCloseIconForATPutAwayPlanningStrategy() {
		CommonMethods.scrollByParticularElement(byCloseIconForATPutAwayPlanningStrategy,
				"Close Icon For AT PutAwayPlanningStrategy");
		SeleniumActions.click(byCloseIconForATPutAwayPlanningStrategy, "Close Icon For ATPutAwayPlanningStrategy");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click CloseIcon For RBU01 PutAway Planning Criteria Item
	 */
	public static void clickCloseIconForRBU01PutAwayPlanningCriteriaItem() {
		CommonMethods.scrollByParticularElement(byCloseIconForRBU01PutAwayPlanningCriteriaItem,
				"Close Icon For RBU01 PutAway Planning Criteria Item");
		SeleniumActions.click(byCloseIconForRBU01PutAwayPlanningCriteriaItem,
				"Close Icon For RBU01 PutAway Planning Criteria Item ");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click CloseIcon For UNIT PutAway Priority Item
	 */
	public static void clickCloseIconForUnitPutAwayPriorityItem() {
		SeleniumActions.click(byCloseIconForUnitPutAwayPriorityItem,
				"Close Icon For UNIT PutAway Priority Item");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click CloseIcon For LPN PutAway Priority Item
	 */
	public static void clickCloseIconForLPNPutAwayPriorityItem() {
		CommonMethods.scrollByParticularElement(byCloseIconForLPNPutAwayPriorityItem,
				"Close Icon For LPN PutAway Priority Item");
		SeleniumActions.click(byCloseIconForLPNPutAwayPriorityItem,
				"Close Icon For LPN PutAway Priority Item");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click View button
	 */
	public static void clickViewButton3() {
		SeleniumActions.click(byViewButton3InRightSidePanel, "View button");
		CommonMethods.waitForPageLoading();
	}


	/**
	 * Function to verify PutAwayZone
	 *
	 * @param text - value which need to be verified
	 * @param index - index value
	 */
	public static void verifyPutAwayZone(String text, String index) {
		String actualText =null;
		if(Integer.parseInt(index)==1){
			actualText = SeleniumActions.getAtrribute(byPutAwayZone, "title", Integer.parseInt(ConfigurationUtils.getFrameworkConfig("implicitlywait")));
		}else if(Integer.parseInt(index)==2){
			 actualText = SeleniumActions.getAtrribute(byPutAwayZone2, "title", Integer.parseInt(ConfigurationUtils.getFrameworkConfig("implicitlywait")));
		}else if(Integer.parseInt(index)==3){
			actualText = SeleniumActions.getAtrribute(byPutAwayZone3, "title", Integer.parseInt(ConfigurationUtils.getFrameworkConfig("implicitlywait")));
		}
		if (text.equals(actualText)) {
			FrameworkLogger.log(LogType.PASS, "PutAwayZone Verification passed : " + actualText);
		} else {
			FrameworkLogger.log(LogType.FAIL,
					"PutAwayZone Verification failed. Expected :+" + text + " , Actual :" + actualText);
		}
	}


	/**
	 * Function to click CloseIcon For ATPlt PutAway Planning Criteria Item
	 */
	public static void clickCloseIconForATPltPutAwayPlanningCriteriaItem() {
		SeleniumActions.click(byCloseIconForATPltPutAwayPlanningCriteriaItem,
				"Close Icon For ATPlt PutAway Planning Criteria Item ");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to verify ContainerPlanningMode
	 */
	public static void verifyContainerPlanningMode() {
		SeleniumActions.verifyElementVisible(byContainerPlanningMode, 10, "ContainerPlanning Mode ");
	}

	/**
	 * Function to click Close Icon For ATPlt PutAwayPlanningStrategy
	 */
	public static void clickCloseIconForATPltPutAwayPlanningStrategy() {
		CommonMethods.scrollByParticularElement(byCloseIconForATPltPutAwayPlanningStrategy,
				"Close Icon For ATPlt PutAwayPlanningStrategy");
		SeleniumActions.click(byCloseIconForATPltPutAwayPlanningStrategy, "Close Icon For ATPlt PutAwayPlanningStrategy");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click on putway strategy
	 *
	 */
	public static void clickFirstPutwayStrategyFromNavigationList() {
		SeleniumActions.click(byFirstPutawayPlanningstrategyFromNavigationList, "Clicked first putaway heading from navigation list");
		CommonMethods.waitForPageLoading();
	}
}
