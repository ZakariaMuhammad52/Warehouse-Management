package web.Pages;

import org.openqa.selenium.By;

import com.dhl.driver.DriverManager;
import com.dhl.testdata.TestData_Json;
import com.dhl.web.utils.SeleniumActions;

import stepdefinitions.CommonMethods;

@SuppressWarnings("unused")
public class FooterPanelPage extends TestData_Json {

	private static final By byDetailBtn = By.xpath("//ion-button[@data-component-id='Details-footer-panel']");
	private static final By byDeSelectBtn = By.xpath("//ion-button[@data-component-id='deselect-button-Footer-Actions']");
	private static final By byMoreActionsBtn = By.xpath("//ion-button[@data-component-id='more-actions']");
	private static final By byCycleCount = By.xpath("//button[@data-component-id='CycleCount']");
	private static final By byAssignItemToLocation = By.xpath("//button[@data-component-id='AssignItemToLocation-more-actions']");
	private static final By byOrganizationUsersButton = By.xpath("//button[@data-component-id='OrganizationUsers-footer-panel']");
	private static final By byAdjustProductStatusButton = By
			.xpath("//button[@data-component-id='AdjustProductStatus-more-actions']");
	private static final By byPixDataButton = By.xpath("//*[@data-component-id='PIXData-footer-panel']");
	private static final By byRunWaveButton = By.xpath("//*[@data-component-id='RunWave-footer-panel']");
	private static final By byViewButton = By.xpath("//button[@data-component-id='View-more-actions']");
	private static final By byViewIonButton = By.xpath("//ion-button[@data-component-id='View-footer-panel']");
	private static final By byAssignItemToLocation2 = By
			.xpath("//ion-button[@data-component-id='AssignItemToLocation-footer-panel']");

	/**
	 * Function to click Details button
	 */
	public static void clickDetailsButton() {
		SeleniumActions.click(byDetailBtn, "Details button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click Deselect button
	 */
	public static void clickDeselectButton() {
		if (DriverManager.getDriver().findElements(byDeSelectBtn).size() > 0) {
			SeleniumActions.click(byDeSelectBtn, "Deselect button");
			CommonMethods.waitForPageLoading();
		}
	}

	/**
	 * Function to click More button
	 */
	public static void clickMoreButton() {
		SeleniumActions.click(byMoreActionsBtn, "More button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click byAssignItemToLocation button
	 */
	public static void clickAssignItemToLocationButton() {
		SeleniumActions.click(byAssignItemToLocation, "byAssignItemToLocation button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click OrganizationUsers Button
	 */
	public static void clickOrganizationUsers() {
		SeleniumActions.click(byOrganizationUsersButton, "OrganizationUsers");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click AdjustProductStatus Button
	 */
	public static void clickAdjustProductStatus() {
		SeleniumActions.click(byAdjustProductStatusButton, "AdjustProductStatus button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click PixData button
	 */
	public static void clickPixDataButton() {
		SeleniumActions.click(byPixDataButton, "PixData button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click RunWave button
	 */
	public static void clickRunWaveButton() {
		SeleniumActions.click(byRunWaveButton, "RunWave button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click View button
	 */
	public static void clickViewButton() {
		SeleniumActions.click(byViewButton, "View button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click byAssignItemToLocation2 button
	 */
	public static void clickAssignItemToLocation2Button() {
		SeleniumActions.click(byAssignItemToLocation2, "byAssignItemToLocation2 button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click View IO button
	 */
	public static void clickbyViewIonButton() {
		SeleniumActions.click(byViewIonButton, "View button");
		CommonMethods.waitForPageLoading();
	}
}