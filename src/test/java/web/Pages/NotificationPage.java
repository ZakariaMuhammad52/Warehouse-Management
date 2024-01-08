package web.Pages;

import org.openqa.selenium.By;

import com.dhl.driver.DriverManager;
import com.dhl.reports.FrameworkLogger;
import com.dhl.reports.LogType;
import com.dhl.testdata.TestData_Json;
import com.dhl.utils.GeneralUtils;
import com.dhl.web.utils.SeleniumActions;

import stepdefinitions.CommonMethods;

@SuppressWarnings("unused")
public class NotificationPage extends TestData_Json {
	private static final By byNotificationsPage = By.xpath("//h1[contains(text(),'Notifications')]");
	private static final By byClearAll = By.xpath("//button[contains(text(),'CLEAR ALL')]");
	private static final By byNoMoreNotificationText = By.xpath("//p[contains(text(),'No More Notifications')]");
	private static final By byShowMore = By.xpath("(//span[contains(text(),'SHOW MORE')])[1]");
	private static final By byOriginalOrderDownloadlink = By.xpath("//a[contains(text(),'OriginalOrder.xlsx')]");
	private static final By byASNDownloadlink = By.xpath("(//a[contains(text(),'Asn.xlsx')])[1]");
	private static final By byLessThanMinuteAgo = By.xpath("//span[contains(text(),'Less than a minute ago')]"); // a
																													// minute
																													// ago
	private static final By bySuccessfullyMessage = By.xpath("//p[contains(text(),'successfully.')]");
	private static final By byPurchaseOrderLine = By.xpath("//*[text()='Purchase Order Line']");
	private static final By byExpandPurchasefield = By
			.xpath("//span[@title='Purchase Order']/following-sibling::ion-button[@data-component-id='expand-button']");
	private static final By byAsnOrderDownloadlink = By.xpath("//a[contains(text(),'Asn.xlsx')]");
	private static final By byBatchMasterDownloadlink = By.xpath("(//a[contains(text(),'BatchMaster.xlsx')])[1]");

	/**
	 * * Function to verify Notifications popup is displayed
	 */
	public static void verifyNotificationsPageDisplayed() {
		SeleniumActions.verifyElementVisible(byNotificationsPage, 20, "Notifications popup");
	}

	/**
	 * Function to click clear all notification
	 */
	public static void clearAllNotifications() {
		SeleniumActions.click(byClearAll, "Clear All");
		CommonMethods.waitForPageLoading();
		if (!SeleniumActions.isElementPresent(byNoMoreNotificationText, 1)) {
			FrameworkLogger.log(LogType.FAIL, "No More Notifications is not displayed!");
		} else {
			FrameworkLogger.log(LogType.PASS, "No More Notifications is displayed!");
		}
	}

	/**
	 * Function to click Show More notification
	 */
	public static void showMoreNotifications() {
		SeleniumActions.click(byShowMore, "SHOW MORE");
		CommonMethods.waitForPageLoading();

	}

	/**
	 * Function to verify notification message
	 * @param notificationMessage - value of notification message
	 */
	public static void verifyNotificationMessage(String notificationMessage) {
		int iPresent = 0;
		HomePage.clickAlertNotificationIcon();
		CommonMethods.waitForPageLoading();
		while (DriverManager.getDriver().findElements(byShowMore).size() < 1) {
			GeneralUtils.wait(1 * 1000);
			HomePage.refreshAlertNotification();
			iPresent += 1;
			FrameworkLogger.log(LogType.INFO, "Notification iteration : " + iPresent);
			if (iPresent > 5) {
				FrameworkLogger.log(LogType.FAIL, "Notification is not displayed");
				break;
			}
		}
		SeleniumActions.click(byShowMore, "SHOW MORE");
		CommonMethods.waitForPageLoading();
		String strNotificationMsg = SeleniumActions.getText(bySuccessfullyMessage);
		if (strNotificationMsg != null && !strNotificationMsg.trim().isEmpty()) {
			SeleniumActions.verifyTextContains(strNotificationMsg, notificationMessage);
		} else {
			FrameworkLogger.log(LogType.FAIL, "Notification is null or empty");
		}
		HomePage.clickAlertNotificationIcon();
	}

	/*
	 * Function to verify Notifications popup is displayed
	 */
	/*
	 * public static void verifyNotificationsPageDisplayed() {
	 * SeleniumActions.verifyElementVisible(byNotificationsPage, 20,
	 * "Notifications popup"); }
	 */

	/**
	 * Function to click clear all notification
	 */
	/*
	 * public static void clearAllNotifications() {
	 * SeleniumActions.click(byClearAll, "Clear All");
	 * CommonMethods.waitForPageLoading(); if
	 * (!SeleniumActions.isElementPresent(byNoMoreNotificationText, 1)) {
	 * FrameworkLogger.log(LogType.FAIL, "No More Notifications is not displayed!");
	 * } else { FrameworkLogger.log(LogType.PASS,
	 * "No More Notifications is displayed!"); } }
	 */

	/**
	 * Function to click Show More notification
	 */
	/*
	 * public static void showMoreNotifications() {
	 * SeleniumActions.click(byShowMore, "SHOW MORE");
	 * CommonMethods.waitForPageLoading(); }
	 */

	/**
	 * Function to verify notification message
	 */
	/*
	 * public static void verifyNotificationMessage(String notificationMessage) {
	 * int iPresent = 0; GeneralUtils.wait(2 * 1000);
	 * HomePage.openAlertNotification(); while
	 * (DriverManager.getDriver().findElements(byShowMore).size() < 1) {
	 * GeneralUtils.wait(1 * 1000); HomePage.refreshAlertNotification(); iPresent +=
	 * 1; if (iPresent > 5) { FrameworkLogger.log(LogType.FAIL,
	 * "Notification is not displayed"); break; } }
	 * SeleniumActions.click(byShowMore, "SHOW MORE");
	 * CommonMethods.waitForPageLoading(); String strNotificationMsg =
	 * SeleniumActions.getText(bySuccessfullyMessage);
	 * HomePage.openAlertNotification(); if (strNotificationMsg != null &&
	 * !strNotificationMsg.trim().isEmpty()) {
	 * SeleniumActions.verifyTextContains(notificationMessage, strNotificationMsg);
	 * } else { FrameworkLogger.log(LogType.FAIL, "Notification is null or empty");
	 * } }
	 */

	/**
	 * Function to Download OriginalOrder from notification
	 */
	public static void downloadOriginalOrder() {
		SeleniumActions.click(byOriginalOrderDownloadlink, "Download Original Order");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to Download ASN from notification
	 */
	public static void downloadAsnOrder() {
		SeleniumActions.click(byAsnOrderDownloadlink, "Download ASN Order");
	}

	/**
	 * Function to download ASN file
	 */
	public static void downloadASNfile() {
		SeleniumActions.click(byASNDownloadlink, "Download ASN");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to Download Batch Master from notification
	 */
	public static void downloadBatchMasterfile() {
		SeleniumActions.click(byBatchMasterDownloadlink, "Download Batch Master");
		CommonMethods.waitForPageLoading();
	}
}
