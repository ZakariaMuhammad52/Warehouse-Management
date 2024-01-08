package web.Pages;

import org.openqa.selenium.By;

import com.dhl.testdata.TestData_Json;
import com.dhl.web.utils.SeleniumActions;

import stepdefinitions.CommonMethods;

@SuppressWarnings("unused")
public class RightNavigationBar extends TestData_Json {

	private static final By byRefreshButton = By.xpath("//ion-button[@data-component-id='refresh-navbar-icons']");
	private static final By byUserProfileButton = By
			.xpath("(//ion-button[@data-component-id='user-profile-navbar-icons'])[2]");
	private static final By byLogoutButton = By.xpath("//ion-item[@data-component-id='logout-btn-profile-popover']");
	private static final By byConfirmLogoutButton = By.xpath("//button[@data-component-id='SignOutConfirm']");
	private static final By byCancelLogoutButton = By.xpath("//button[@data-component-id='SignOutCancel']");

	/**
	 * Function to click RefreshButton
	 */
	public static void clickRefreshButton() {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byRefreshButton, "RefreshButton");
		CommonMethods.waitForPageLoading();
	}

}
