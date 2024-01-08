package web.Pages;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.dhl.driver.DriverManager;
import com.dhl.reports.FrameworkLogger;
import com.dhl.reports.LogType;
import com.dhl.utils.CurrentThreadInstance;
import com.dhl.utils.GeneralUtils;
import com.dhl.utils.Variables;
import com.dhl.web.utils.KeyboardActions;
import com.dhl.web.utils.SeleniumActions;

import io.cucumber.java.en.And;
import stepdefinitions.CommonMethods;

public class DeletedCodeDuringMerge {
	/*
	 * 
	 * // iLPN.class
	 * 
	 * <<<<<<<HEAD private static final By byLPNStatus =
	 * By.xpath("//ion-checkbox[@data-component-id='\" + strLPNStatus + \"']");
	 * 
	 * private static final By byLPNItemId =
	 * By.xpath("//ion-input[@data-component-id='\" + strLPNItemID + \"']");
	 * 
	 * private static final By byLPNCurrentLocation = By
	 * .xpath("//ion-checkbox[@data-component-id='\" + strLPNStatus + \"']");
	 * 
	 * private static final By byExpandLPNStatusfield = By
	 * .xpath("//span[@title='LPN status']/following-sibling::ion-button[@data-component-id='expand-button']"
	 * );
	 * 
	 * private static final By byExpandItemfield = By .xpath(
	 * "//span[@title='Item']/following-sibling::ion-button[@data-component-id='expand-button']"
	 * );
	 * 
	 * private static final By bySearchItemIDField =
	 * By.xpath("//ion-input[@data-component-id='ItemId']/input");
	 * 
	 * private static final By byFirstILPNsCard = By.xpath(
	 * "(//div[@data-component-id='IlpnStatusDescription' and @title = 'Not Allocated'])[1]/ancestor::card-view//span[@data-component-id='IlpnTypeDescription']"
	 * );
	 * 
	 * private static final By byExpandILPNCurrentLocationfield = By.xpath(
	 * "//span[@title='Current location']/following-sibling::ion-button[@data-component-id='expand-button']"
	 * );
	 * 
	 * private static final By byCurrentDisplayLocationILPNCard = By
	 * .xpath("//span[@data-component-id='CurrentDisplayLocation']");
	 * 
	 * private static final By byCurrentLocationCheckbox =
	 * By.xpath("//ion-col[@class='checkbox-container md hydrated']");
	 * 
	 * private static final By byClearAllFilterBtn =
	 * By.xpath("//button[@data-component-id='clear-all-btn']");
	 * 
	 * private static final By byParentLPNIdILPNsCard1 =
	 * By.xpath("(//span[@data-component-id='ParentLpnId'])[1]"); private static
	 * final By byParentLPNIdILPNsCard2 =
	 * By.xpath("(//span[@data-component-id='ParentLpnId'])[2]"); private static
	 * final By byParentLPNIdILPNsCard3 =
	 * By.xpath("(//span[@data-component-id='ParentLpnId'])[3]");
	 * 
	 * private static final By bySlideILPNsCard1Btn = By
	 * .xpath("(//div[contains(@class,'list-card-action-left-arrow')])[1]"); private
	 * static final By bySlideILPNsCard2Btn = By
	 * .xpath("(//div[contains(@class,'list-card-action-left-arrow')])[2]"); private
	 * static final By bySlideILPNsCard3Btn = By
	 * .xpath("(//div[contains(@class,'list-card-action-left-arrow')])[3]");
	 * 
	 * private static final By bySlideCardDetailsBtn =
	 * By.xpath("//button[@data-component-id='Details']"); private static final By
	 * byExpandInventoryDetailsSection =
	 * By.xpath("//div[@data-component-id='Inventorydetails']");
	 * 
	 * private static final By byInventoryDetails =
	 * By.xpath("//span[contains(text(),'INVENTORY DETAILS')]"); private static
	 * final By byProductStatus =
	 * By.xpath("//span[contains(@data-component-id,'Productstatus')]"); private
	 * static final By byCloseInventoryDetails =
	 * By.xpath("//button//ion-icon[@name='close']"); private static final By
	 * bySlideOptionDetailBtn = By.xpath("//button[@data-component-id='Details']");
	 * private static final By byCloseSlideOption = By .xpath(
	 * "//div[contains(@class,'slideOptionList')]/button[@data-component-id='action-open']"
	 * ); private static final By byleftarrowbutton =
	 * By.xpath("//div[contains(@class,'list-card-action-left-arrow')]"); private
	 * static final By byDetailBtnleftarrow =
	 * By.xpath("//img[contains(@src,'Icon_Details.svg')]"); private static final By
	 * bylocationitemvalue = By .xpath(
	 * "//div[@class='datatable-body-cell-label']//div/a[@data-component-id='link']"
	 * ); private static final By byExpandInventoryitemsfield =
	 * By.xpath("//span[text()='INVENTORY DETAILS']"); private static final By
	 * byfilterWithNotAllocated =
	 * By.xpath("//ion-checkbox[@data-component-id='NotAllocated']");
	 * 
	 * private static final By byILPNS1 =
	 * By.xpath("(//span[@data-component-id='IlpnId'])[1]"); private static final By
	 * byILPNS2 = By.xpath("(//span[@data-component-id='IlpnId'])[2]"); private
	 * static final By byilpnstatusDescription =
	 * By.xpath("//div[@data-component-id='IlpnStatusDescription']"); private static
	 * final By byRelatedlinksInventoryDetails =
	 * By.xpath("//a[contains(text(),'Inventory details')]"); private static final
	 * By byNorecordsmsg = By.xpath("//ion-label[text()=' No Records found ']");
	 * 
	 * public static void verifyPageDisplayed() {
	 * SeleniumActions.verifyElementVisible(byILPNSPage, 20, "ILPNs page"); }
	 * 
	 * public static void searchASN(String strText) {
	 * CommonMethods.waitForPageLoading(); if
	 * (DriverManager.getDriver().findElements(byASNField).size() < 1) {
	 * SeleniumActions.click(byExpandASNfield, "Expand icon"); }
	 * SeleniumActions.getElement(byASNField).clear();
	 * SeleniumActions.sendTextToElement(byASNField, strText, "ASN search field");
	 * CommonMethods.waitForPageLoading();
	 * KeyboardActions.pressEnterKey(byASNField);
	 * CommonMethods.waitForPageLoading(); }
	 * 
	 * public static void searchLPN(String strText) {
	 * CommonMethods.waitForPageLoading(); if
	 * (DriverManager.getDriver().findElements(byiLPNField).size() < 1) {
	 * SeleniumActions.click(byExpandILPNfield, "Expand icon"); }
	 * SeleniumActions.getElement(byiLPNField).clear();
	 * SeleniumActions.sendTextToElement(byiLPNField, strText, "LPN search field");
	 * CommonMethods.waitForPageLoading();
	 * KeyboardActions.pressEnterKey(byiLPNField);
	 * CommonMethods.waitForPageLoading();
	 * SeleniumActions.click(By.xpath("//span[contains(text(),'" + strText + "')]"),
	 * "LPN Card"); }
	 * 
	 * public static void storeILPNsToList() { List<WebElement> listOfElements =
	 * DriverManager.getDriver().findElements(byILPNS); List<String> listOfILPNs =
	 * new ArrayList<>(); for (WebElement element : listOfElements) {
	 * listOfILPNs.add(element.getText().trim()); }
	 * System.out.println("iLPNS stored in variables:- " + listOfILPNs);
	 * Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "listOFiLPNs",
	 * listOfILPNs); }
	 * 
	 * public static void excelValidation() { List<String> listOfILPNs =
	 * (List<String>) Variables .get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "listOFiLPNs"); File fileLatestDownload = GeneralUtils
	 * .getLatestFilefromDir("C:\\Users\\" + GeneralUtils.getCurrentUser() + "\\
	 * Downloads", "ILpn.*.csv"); List<String> listOfLPNsAtCSV =
	 * CommonMethods.getColumnValuesFromCsv(fileLatestDownload.getPath(), "ILPN");
	 * Collections.sort(listOfILPNs); Collections.sort(listOfLPNsAtCSV); if
	 * (listOfILPNs.equals(listOfLPNsAtCSV)) {
	 * System.out.println("LPNs are exported as expected!");
	 * FrameworkLogger.log(LogType.PASS, "LPNs are exported as expected!"); } else {
	 * System.out .println("Exported LPNs " + listOfLPNsAtCSV +
	 * " are not matching with UI LPNs list " + listOfILPNs);
	 * FrameworkLogger.log(LogType.FAIL, "Exported LPNs " + listOfLPNsAtCSV +
	 * " are not matching with UI LPNs list " + listOfILPNs); } }
	 * 
	 * /** Function to verify LPN Details displayed/visible in the screen
	 * 
	 * public static void verifyLPNDetailsDisplayed() {
	 * CommonMethods.waitForPageLoading(); By by =
	 * By.xpath("//span[contains(text(),'" +
	 * Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "LPN" +
	 * 1).toString() + "')]"); SeleniumActions.verifyElementVisible(by, 5,
	 * "LPN Details"); }
	 * 
	 * public static void navigateToLocationInventory() {
	 * CommonMethods.waitForPageLoading(); SeleniumActions.click(byDetailBtn,
	 * "Details Button"); CommonMethods.waitForPageLoading();
	 * SeleniumActions.click(byLocationInventryLink, "Location Inventory Link");
	 * CommonMethods.waitForPageLoading(); }
	 * 
	 * public static void validateCurrentQuantity() {
	 * CommonMethods.waitForPageLoading(); String strCurrentQuantity =
	 * SeleniumActions.getText(byCurrentQuantityText); if (strCurrentQuantity !=
	 * null && !strCurrentQuantity.trim().isEmpty()) {
	 * strCurrentQuantity.replace(" UNIT", ""); if (strCurrentQuantity
	 * .equals(Variables.get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "AdjustedValue").toString())) { } FrameworkLogger.log(LogType.PASS,
	 * "Current Quantity is " + strCurrentQuantity); } else {
	 * FrameworkLogger.log(LogType.FAIL, "Current Quantity is null or empty"); } }
	 * 
	 * public static void storeILPNIdAtFirstIndexToString() { WebElement element =
	 * DriverManager.getDriver().findElement(byILPNIdAtFirstIndex); String text =
	 * element.getText().trim(); FrameworkLogger.log(LogType.INFO,
	 * "ILPN Id stored in variable:- " + text);
	 * Variables.set(CurrentThreadInstance.getCurrentScenarioId() +
	 * "ILPNIdAtFirstIndex", text); }
	 * 
	 * public static void storeILPNQuantityAtFirstIndexToString() { WebElement
	 * element = DriverManager.getDriver().findElement(byILPNQuantityAtFirstIndex);
	 * String text = element.getText().trim(); FrameworkLogger.log(LogType.INFO,
	 * "ILPN Quantity stored in variable:- " + text);
	 * Variables.set(CurrentThreadInstance.getCurrentScenarioId() +
	 * "ILPNQuantityAtFirstIndex", text); }
	 * 
	 * public static void storeILPNCurrentLocationAtFirstIndexToString() {
	 * WebElement element =
	 * DriverManager.getDriver().findElement(byILPNCurrentLocationAtFirstIndex);
	 * String text = element.getText().trim(); text = text.replaceAll("-", "");
	 * FrameworkLogger.log(LogType.INFO,
	 * "ILPN Current Location stored in variable:- " + text);
	 * Variables.set(CurrentThreadInstance.getCurrentScenarioId() +
	 * "ILPNCurrentLocationAtFirstIndex", text); }
	 * 
	 * /** Function to search Current location
	 * 
	 * @param strText - location value which need to be searched
	 * 
	 * public static void searchCurrentLocation(String strText) {
	 * CommonMethods.waitForPageLoading(); if
	 * (DriverManager.getDriver().findElements(byCurrentLocationTextField).size() <
	 * 1) { SeleniumActions.click(byExpandCurrentLocationField, "Expand icon"); }
	 * SeleniumActions.sendTextToElement(byCurrentLocationTextField, strText,
	 * "Current Location Text field"); CommonMethods.waitForPageLoading();
	 * KeyboardActions.pressEnterKey(byCurrentLocationTextField);
	 * CommonMethods.waitForPageLoading();
	 * 
	 * }
	 * 
	 * /** Function to search iLPN
	 *
	 * @param strText - lpn value which need to be searched
	 * 
	 * public static void searchLPNID(String strText) {
	 * CommonMethods.waitForPageLoading(); if
	 * (DriverManager.getDriver().findElements(byiLPNField).size() < 1) {
	 * SeleniumActions.click(byExpandILPNfield, "Expand icon"); }
	 * SeleniumActions.getElement(byiLPNField).clear();
	 * SeleniumActions.sendTextToElement(byiLPNField, strText, "LPN search field");
	 * CommonMethods.waitForPageLoading();
	 * KeyboardActions.pressEnterKey(byiLPNField);
	 * CommonMethods.waitForPageLoading(); }
	 * 
	 * /** Function to verify iLPN at first index
	 * 
	 * @param iLPN - value which need to be verified
	 * 
	 * public static void verifyILPNAtFirstIndex(String iLPN) { String actualILPN =
	 * SeleniumActions.getAtrribute(byILPNIdAtFirstIndex, "title", 20); actualILPN =
	 * actualILPN.trim(); if (iLPN.equals(actualILPN)) {
	 * FrameworkLogger.log(LogType.PASS, "iLPN Verification passed : " + iLPN); }
	 * else { FrameworkLogger.log(LogType.FAIL,
	 * "iLPN Verification failed. Expected : " + iLPN + " , Actual :" + actualILPN);
	 * } }
	 * 
	 * /** Function to verify quantity at first index
	 * 
	 * @param quantity - value which need to be verified
	 * 
	 * public static void verifyILPNQuantityAtFirstIndex(String quantity) { String
	 * actualQuantity = SeleniumActions.getAtrribute(byILPNQuantityAtFirstIndex,
	 * "title", 20); actualQuantity = actualQuantity.trim(); if
	 * (quantity.equals(actualQuantity)) { FrameworkLogger.log(LogType.PASS,
	 * "Quantity Verification passed : " + quantity); } else {
	 * FrameworkLogger.log(LogType.FAIL, "Quantity Verification failed. Expected : "
	 * + quantity + " , Actual :" + actualQuantity); } }
	 * 
	 * /** Function to verify current location at first index
	 * 
	 * @param location - value which need to be verified
	 * 
	 * public static void verifyILPNCurrentLocationAtFirstIndex(String location) {
	 * // String actualLocation = //
	 * SeleniumActions.getAtrribute(byILPNCurrentLocationAtFirstIndex, "title", 20);
	 * String actualLocation =
	 * DriverManager.getDriver().findElement(byILPNCurrentLocationAtFirstIndex).
	 * getText(); actualLocation = actualLocation.replaceAll("-", ""); if
	 * (location.equals(actualLocation)) { FrameworkLogger.log(LogType.PASS,
	 * "Current Location Verification passed : " + location); } else {
	 * FrameworkLogger.log(LogType.FAIL,
	 * "Current Location Verification failed. Expected :" + location + " , Actual :"
	 * + actualLocation); } }
	 * 
	 * /** Function to verify previous location at first index
	 * 
	 * @param location - value which need to be verified
	 * 
	 * public static void verifyILPNPreviousLocationAtFirstIndex(String location) {
	 * // String actualLocation = //
	 * SeleniumActions.getAtrribute(byILPNPreviousLocationAtFirstIndex, "title", //
	 * 20); String actualLocation =
	 * DriverManager.getDriver().findElement(byILPNPreviousLocationAtFirstIndex).
	 * getText(); actualLocation = actualLocation.replaceAll("-", ""); if
	 * (location.equals(actualLocation)) { FrameworkLogger.log(LogType.PASS,
	 * "Previous Location Verification passed : " + location); } else {
	 * FrameworkLogger.log(LogType.FAIL,
	 * "Previous Location Verification failed. Expected :" + location +
	 * " , Actual :" + actualLocation); } }
	 * 
	 * /** Function to open slide options in ILPN Page
	 * 
	 * public static void openSlideOption(String strILpn) {
	 * CommonMethods.waitForPageLoading(); SeleniumActions.click(
	 * By.xpath("(//span[contains(text(),'" + strILpn +
	 * "')]//following::slider-actions)[1]//button"), "Open Slide Option of " +
	 * strILpn); CommonMethods.waitForPageLoading(); }
	 * 
	 * /** Function to close slide options in ILPN Page
	 * 
	 * public static void closeSlideOption() { CommonMethods.waitForPageLoading();
	 * SeleniumActions.click(byCloseSlideOption, "Close Slide option");
	 * CommonMethods.waitForPageLoading(); }
	 * 
	 * /** Function to click Details in ILPN Slide Screen
	 * 
	 * public static void clickDetails() { CommonMethods.waitForPageLoading();
	 * SeleniumActions.click(bySlideOptionDetailBtn, "Details Button"); }
	 * 
	 * /** Function to expand Inventory Details
	 * 
	 * public static void expandInventoryDetails() {
	 * CommonMethods.waitForPageLoading();
	 * CommonMethods.scrollByParticularElement(byInventoryDetails,
	 * "Inventory Details"); SeleniumActions.click(byInventoryDetails,
	 * "Inventory Details"); CommonMethods.waitForPageLoading(); }
	 * 
	 * /** Function to verify Product Status in Inventory Details
	 * 
	 * @param strProductStatus - Product status that needs to be verified
	 * 
	 * public static void verifyProductStatus(String strProductStatus) { String
	 * strExpectedProductStatus = getProductStatusDescription(strProductStatus);
	 * CommonMethods.waitForPageLoading(); if
	 * (!SeleniumActions.getText(By.xpath("//div[contains(@data-component-id,'" +
	 * strExpectedProductStatus + "')]")) .isEmpty()) {
	 * FrameworkLogger.log(LogType.PASS, "Expected Product status " +
	 * strExpectedProductStatus + " is displayed"); } else {
	 * FrameworkLogger.log(LogType.FAIL, "Expected Product status " +
	 * strExpectedProductStatus + " is not displayed"); } }
	 * 
	 * /** Function for each product description
	 * 
	 * public static String getProductStatusDescription(String strProductStatus) {
	 * // remaining product statuses to be added based on the usage in test case
	 * String strProductDescription; char strChar; strChar =
	 * strProductStatus.charAt(0); switch (String.valueOf(strChar).toUpperCase()) {
	 * case "A": strProductDescription = "Available"; break; case "D":
	 * strProductDescription = "Damaged"; break; case "E": strProductDescription =
	 * "Expired"; break; case "H": strProductDescription = "On Hold"; break; case
	 * "I": strProductDescription = "Inspection"; break; case "R":
	 * strProductDescription = "Return"; break; default: throw new
	 * IllegalArgumentException("Product Status NOT supported"); } return
	 * strProductDescription; }
	 * 
	 * /** Function to capture LPN value from ILPNS screen
	 * 
	 * public static void captureILPNSNumber() { String strILPNS =
	 * SeleniumActions.getText(byILPNS); if (strILPNS != null &&
	 * !strILPNS.trim().isEmpty()) {
	 * Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN",
	 * strILPNS.replace("LPN ID: ", "")); } else { FrameworkLogger.log(LogType.FAIL,
	 * "LPN is null or empty"); } }
	 * 
	 * public static void filterLPNByStatus(String strText) { String strLPNStatus =
	 * strText; // String strLPNId; CommonMethods.waitForPageLoading();
	 * SeleniumActions.click(By.xpath("//ion-checkbox[@data-component-id='" +
	 * strLPNStatus + "']"), "ILPN Status"); // CommonMethods.waitForPageLoading();
	 * /* strLPNId = SeleniumActions.getText(byFirstLPNId);
	 * CommonMethods.waitForPageLoading();
	 * 
	 * }
	 * 
	 * public static void filterLPNByItem(String strText) { String strLPNItemId =
	 * strText; if
	 * (DriverManager.getDriver().findElements(bySearchItemIDField).size() < 1) {
	 * SeleniumActions.click(byExpandItemfield, "Expand icon"); }
	 * SeleniumActions.getElement(bySearchItemIDField).clear();
	 * SeleniumActions.sendTextToElement(bySearchItemIDField, strLPNItemId,
	 * "LPN Item ID search field"); CommonMethods.waitForPageLoading();
	 * KeyboardActions.pressEnterKey(bySearchItemIDField);
	 * CommonMethods.waitForPageLoading(); SeleniumActions.click(byFirstILPNsCard,
	 * "ILPNS First Card"); }
	 * 
	 * public static void filterLPNByLPNValue(String strText) { String strILPNS =
	 * SeleniumActions.getText(byILPNS);
	 * 
	 * // CommonMethods.waitForPageLoading(); /* if
	 * (DriverManager.getDriver().findElements(byiLPNField).size() < 1) {
	 * SeleniumActions.click(byExpandItemfield, "Expand icon"); }
	 * 
	 * CommonMethods.waitForPageLoading(); if (strILPNS != null &&
	 * !strILPNS.trim().isEmpty()) {
	 * Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN",
	 * strILPNS.replace("LPN ID: ", "")); } else { FrameworkLogger.log(LogType.FAIL,
	 * "LPN is null or empty"); } SeleniumActions.getElement(byiLPNField).clear();
	 * SeleniumActions.sendTextToElement(byiLPNField, strILPNS, "LPN search field");
	 * KeyboardActions.pressEnterKey(byiLPNField); //
	 * CommonMethods.waitForPageLoading(); }
	 * 
	 * /** Function to verify ILPNs Current Display Location
	 * 
	 * @param strExpected - LPNs Current Display Location that need to be verified
	 * 
	 * public static void verifyILPNsCurrentDisplayLocation(String strExpected) {
	 * String strStatus = getILPNsCurrentDisplayLocation(); if
	 * (!strStatus.isEmpty()) { SeleniumActions.verifyTextEquals(strStatus,
	 * strExpected); } }
	 * 
	 * public static String getILPNsCurrentDisplayLocation() { String
	 * strILPNsCurrentLocationDisplay =
	 * SeleniumActions.getText(byCurrentDisplayLocationILPNCard); if
	 * (strILPNsCurrentLocationDisplay != null &&
	 * !strILPNsCurrentLocationDisplay.trim().isEmpty()) { return
	 * strILPNsCurrentLocationDisplay.trim(); } else {
	 * FrameworkLogger.log(LogType.FAIL,
	 * "Current Display Location is null or empty"); } return ""; }
	 * 
	 * public static void filterLPNCurrentLocationIsNull() { if
	 * (DriverManager.getDriver().findElements(byCurrentLocationCheckbox).size() <
	 * 1) { SeleniumActions.click(byExpandILPNCurrentLocationfield, "Expand icon");
	 * } SeleniumActions.checkSingleCheckbox(byCurrentLocationCheckbox,
	 * "Checked Current Location is Null");
	 * 
	 * }
	 * 
	 * public static void clearFilterMenuILPNs() {
	 * CommonMethods.waitForPageLoading();
	 * SeleniumActions.click(byClearAllFilterBtn,
	 * "Clear all filtered in ILPNS menu");
	 * 
	 * }
	 * 
	 * /** Function to verify Parent LPN for multiple card
	 * 
	 * public static void validateParentLPNinILPNs() {
	 * CommonMethods.waitForPageLoading(); String strParentLpnIdCard1 =
	 * SeleniumActions.getText(byParentLPNIdILPNsCard1);
	 * Variables.set(CurrentThreadInstance.getCurrentScenarioId() +
	 * "ParentLpnIdCard1", strParentLpnIdCard1); String strParentLpnIdCard2 =
	 * SeleniumActions.getText(byParentLPNIdILPNsCard2);
	 * Variables.set(CurrentThreadInstance.getCurrentScenarioId() +
	 * "ParentLpnIdCard2", strParentLpnIdCard2); String strParentLpnIdCard3 =
	 * SeleniumActions.getText(byParentLPNIdILPNsCard3);
	 * Variables.set(CurrentThreadInstance.getCurrentScenarioId() +
	 * "ParentLpnIdCard3", strParentLpnIdCard3);
	 * 
	 * /* if (strParentLpnIdCard1 == strParentLpnIdCard2) {
	 * FrameworkLogger.log(LogType.PASS, "Both Parent LPN is "+strParentLpnIdCard1);
	 * } else { FrameworkLogger.log(LogType.FAIL,
	 * "Both Parent LPN is different from Parent LPN 1 and Parent LPN 2"); }
	 * 
	 * if (strParentLpnIdCard2 != strParentLpnIdCard3) {
	 * FrameworkLogger.log(LogType.PASS, "Parent LPN 3 is "+strParentLpnIdCard3); }
	 * else { FrameworkLogger.log(LogType.FAIL,
	 * "Both Parent LPN is having same Parent LPN"); }
	 * 
	 * 
	 * if (strParentLpnIdCard1 != null && !strParentLpnIdCard1.trim().isEmpty()) {
	 * if (strParentLpnIdCard1.equalsIgnoreCase(strParentLpnIdCard2)) {
	 * FrameworkLogger.log(LogType.PASS, "Parent LPN Id : " + strParentLpnIdCard1);
	 * } else { FrameworkLogger.log(LogType.FAIL,
	 * "Parent LPN Id is different, Actual : " + strParentLpnIdCard1 + "Expected : "
	 * + strParentLpnIdCard2); } } else { FrameworkLogger.log(LogType.FAIL,
	 * "Parent LPN Id is null or empty");
	 * 
	 * }
	 * 
	 * if (strParentLpnIdCard3 != null && !strParentLpnIdCard3.trim().isEmpty()) {
	 * if (strParentLpnIdCard3.equalsIgnoreCase(strParentLpnIdCard2)) {
	 * FrameworkLogger.log(LogType.FAIL, "Parent LPN Id is same, Actual : " +
	 * strParentLpnIdCard3 + "Expected : " + strParentLpnIdCard2); } else {
	 * FrameworkLogger.log(LogType.PASS, "Parent LPN Id : " + strParentLpnIdCard3);
	 * } } else { FrameworkLogger.log(LogType.FAIL,
	 * "Parent LPN Id is null or empty");
	 * 
	 * }
	 * 
	 * }
	 * 
	 * /** Function to Validate variance message
	 * 
	 * @param strMsg - variance message
	 * 
	 * /* public static void validateVarianceMessage(String strMsg) { String
	 * strAlertmessage = SeleniumActions.getText(byVarianceText); if
	 * (strAlertmessage != null && !strAlertmessage.trim().isEmpty()) { if
	 * (strAlertmessage.equalsIgnoreCase(strMsg)) {
	 * FrameworkLogger.log(LogType.PASS, "Variance message " + strAlertmessage );
	 * SeleniumActions.click(byVarianceAcceptButton, "Accept button");
	 * CommonMethods.waitForPageLoading(); } else {
	 * FrameworkLogger.log(LogType.FAIL, "Variance message is different, Actual : "+
	 * strAlertmessage + "Expected : " +strMsg); } }else {
	 * FrameworkLogger.log(LogType.FAIL, "Variance message is null or empty");
	 * 
	 * } }
	 * 
	 * 
	 * /** Function to verify LPN Inventory card is opening the details.
	 * 
	 * public static void verifyInventoryDetailCard1() {
	 * SeleniumActions.click(bySlideILPNsCard1Btn,
	 * "Slide button card 1 is clicked");
	 * SeleniumActions.click(bySlideCardDetailsBtn, "Details button is clicked");
	 * SeleniumActions.click(byExpandInventoryDetailsSection,
	 * "Expand Inventory Details"); CommonMethods.waitForPageLoading();
	 * 
	 * }
	 * 
	 * /** Function to verify LPN Inventory card is opening the details.
	 * 
	 * public static void verifyInventoryDetailCard2() {
	 * SeleniumActions.click(bySlideILPNsCard2Btn,
	 * "Slide button card 2 is clicked");
	 * SeleniumActions.click(bySlideCardDetailsBtn, "Details button is clicked");
	 * SeleniumActions.click(byExpandInventoryDetailsSection,
	 * "Expand Inventory Details"); CommonMethods.waitForPageLoading();
	 * 
	 * }
	 * 
	 * /** Function to verify LPN Inventory card is opening the details.
	 * 
	 * public static void verifyInventoryDetailCard3() {
	 * SeleniumActions.click(bySlideILPNsCard3Btn,
	 * "Slide button card 3 is clicked");
	 * SeleniumActions.click(bySlideCardDetailsBtn, "Details button is clicked");
	 * SeleniumActions.click(byExpandInventoryDetailsSection,
	 * "Expand Inventory Details"); CommonMethods.waitForPageLoading();
	 * 
	 * }
	 * 
	 * /* public static void ValidateBatchNumandASNExpiryDate(String batchNo,String
	 * Expirydate) { SeleniumActions.verifyElementExist(bylocationitemvalue, 5,
	 * "Item Value shouldbe displayed"); By by =
	 * By.xpath("(//datatable-header-cell[@role='columnheader'])"); List<WebElement>
	 * header = DriverManager.getDriver().findElements(by); int i = header.size();
	 * for (i = 2; i>= 0 && i<=15 ; i++) { WebElement ele =
	 * DriverManager.getDriver().findElement(By.xpath(
	 * "(//datatable-header-cell[@role='columnheader'])["+i+"]")); if
	 * (ele.getAttribute("title").trim().equalsIgnoreCase("Batch number")) {
	 * WebElement ele1 = DriverManager.getDriver().findElement(By.xpath(
	 * "(//div[@class='datatable-body-cell-label']//div)["+i+"-1]")); if
	 * (ele1.getText().trim().equals(batchNo)) { FrameworkLogger.log(LogType.PASS,
	 * "Batch Number displayed"); } else { FrameworkLogger.log(LogType.FAIL,
	 * "Batch Number NOT displayed"); } } if
	 * (ele.getAttribute("title").trim().equalsIgnoreCase("Expiration date")) {
	 * WebElement ele2 = DriverManager.getDriver().findElement(By.xpath(
	 * "(//div[@class='datatable-body-cell-label']//div)["+i+"-1]")); if
	 * (ele2.getAttribute("title").trim().equalsIgnoreCase(Expirydate)) {
	 * FrameworkLogger.log(LogType.PASS, "Expiry date is null"); } else {
	 * FrameworkLogger.log(LogType.FAIL, "Expiry date is not null"); } } } }
	 * 
	 * public static void validateBatchNumberInLPNInventoryTable(String BatchNo) {
	 * SeleniumActions.verifyElementExist(bylocationitemvalue, 5,
	 * "Item Value shouldbe displayed"); By by =
	 * By.xpath("(//datatable-header-cell[@role='columnheader'])"); List<WebElement>
	 * header = DriverManager.getDriver().findElements(by); int i = header.size();
	 * for (i = 2; i >= 0 && i <= 27; i++) { WebElement ele =
	 * DriverManager.getDriver()
	 * .findElement(By.xpath("(//datatable-header-cell[@role='columnheader'])[" + i
	 * + "]")); ele.getAttribute("title").trim().equalsIgnoreCase("Batch number");
	 * WebElement ele1 = DriverManager.getDriver()
	 * .findElement(By.xpath("(//div[@class='datatable-body-cell-label']//div)[" + i
	 * + "-1]")); if (ele1.getText().trim().equals(BatchNo)) {
	 * FrameworkLogger.log(LogType.PASS, "Batch Number displayed"); } else {
	 * FrameworkLogger.log(LogType.FAIL, "Batch Number NOT displayed"); } }
	 * 
	 * }
	 * 
	 * public static void validateExpiryDateInLPNInventoryTable(String Expirydate) {
	 * SeleniumActions.verifyElementExist(bylocationitemvalue, 5,
	 * "Item Value shouldbe displayed"); By by =
	 * By.xpath("(//datatable-header-cell[@role='columnheader'])"); List<WebElement>
	 * header = DriverManager.getDriver().findElements(by); int i = header.size();
	 * for (i = 2; i >= 0 && i <= 27; i++) { WebElement ele =
	 * DriverManager.getDriver()
	 * .findElement(By.xpath("(//datatable-header-cell[@role='columnheader'])[" + i
	 * + "]")); if
	 * (ele.getAttribute("title").trim().equalsIgnoreCase("Expiration date")) {
	 * WebElement ele2 = DriverManager.getDriver()
	 * .findElement(By.xpath("(//div[@class='datatable-body-cell-label']//div)[" + i
	 * + "-1]")); if
	 * (ele2.getAttribute("title").trim().equalsIgnoreCase(Expirydate)) {
	 * FrameworkLogger.log(LogType.PASS, "Expiry date is not null"); } else {
	 * FrameworkLogger.log(LogType.FAIL, "Expiry date is null"); } } } }
	 * 
	 * public static void
	 * ValidateProductStatus_InventoryTypeAndCountryOfOrigin(String ProductStatus,
	 * String InventoryType, String CountryOfOrigin) {
	 * SeleniumActions.verifyElementExist(bylocationitemvalue, 5,
	 * "Item Value should be displayed"); By by =
	 * By.xpath("(//datatable-header-cell[@role='columnheader'])"); List<WebElement>
	 * header = DriverManager.getDriver().findElements(by); int i = header.size();
	 * for (i = 2; i >= 0 && i <= 27; i++) { WebElement ele =
	 * DriverManager.getDriver()
	 * .findElement(By.xpath("(//datatable-header-cell[@role='columnheader'])[" + i
	 * + "]")); if
	 * (ele.getAttribute("title").trim().equalsIgnoreCase("Product status")) {
	 * WebElement ele1 = DriverManager.getDriver()
	 * .findElement(By.xpath("(//div[@class='datatable-body-cell-label']//div)[" + i
	 * + "-1]")); if (ele1.getText().trim().equals(ProductStatus)) {
	 * FrameworkLogger.log(LogType.PASS, "Product status displayed"); } else {
	 * FrameworkLogger.log(LogType.FAIL, "Product status NOT displayed"); } } if
	 * (ele.getAttribute("title").trim().equalsIgnoreCase("Inventory type")) {
	 * WebElement ele2 = DriverManager.getDriver()
	 * .findElement(By.xpath("(//div[@class='datatable-body-cell-label']//div)[" + i
	 * + "-1]")); if
	 * (ele2.getAttribute("title").trim().equalsIgnoreCase(InventoryType)) {
	 * FrameworkLogger.log(LogType.PASS, "Inventory type is displayed"); } else {
	 * FrameworkLogger.log(LogType.FAIL, "Inventory type is NOT displayed"); } } if
	 * (ele.getAttribute("title").trim().equalsIgnoreCase("Country of origin")) {
	 * WebElement ele3 = DriverManager.getDriver()
	 * .findElement(By.xpath("(//div[@class='datatable-body-cell-label']//div)[" + i
	 * + "-1]")); if
	 * (ele3.getAttribute("title").trim().equalsIgnoreCase(CountryOfOrigin)) {
	 * FrameworkLogger.log(LogType.PASS, "COO is displayed"); } else {
	 * FrameworkLogger.log(LogType.FAIL, "COO is NOT displayed"); } } } }
	 * 
	 * /** Function to close ILPN screen
	 * 
	 * public static void closeILPN() {
	 * SeleniumActions.click(byCloseInventoryDetails, "Close Inventory Details");
	 * CommonMethods.waitForPageLoading(); }
	 * 
	 * /** Function to click ILPN Card in ASN>ILPN
	 * 
	 * public static void clickILPNCardInILPN(String ILPN) {
	 * CommonMethods.waitForPageLoading(); SeleniumActions.click(
	 * By.xpath("//span[contains(text(),'" + ILPN +
	 * "')]//following::div/span[contains(text(),'Parent LPN')]"), "Parent LPN");
	 * CommonMethods.waitForPageLoading(); SeleniumActions.click(byDetailBtn,
	 * "Details Button"); CommonMethods.waitForPageLoading(); }
	 * 
	 * /** Function to verify multiple lpns
	 * 
	 * @param lpns - lpns value which need to be verified
	 * 
	 * public static void verifyMultipleLPNs(List<String> lpns) {
	 * 
	 * /** Function to verify ILPNs Linked To ASN ATPalletPutAwaySystemDirected
	 * 
	 * @param text - value which need to be used to compare
	 * 
	 * public static void verifyILPNsLinkedToASNATPalletPutAwaySystemDirected(String
	 * text) { String parentlpnId = (String)
	 * Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "parentlpnId");
	 * String lpn1Id = (String)
	 * Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "lpn1Id");
	 * String lpn2Id = (String)
	 * Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "lpn2Id");
	 * 
	 * List<WebElement> elements = DriverManager.getDriver().findElements(byILPNS);
	 * List<String> listOfLPNs = new ArrayList<>(); for (WebElement element :
	 * elements) { listOfLPNs.add(element.getText().trim()); } if
	 * (text.equalsIgnoreCase("Before")) { if (listOfLPNs.contains(lpn1Id) &&
	 * listOfLPNs.contains(lpn2Id) && listOfLPNs.contains(lpn1Id)) {
	 * FrameworkLogger.log(LogType.PASS, "LPNs Verification Passed. " + listOfLPNs);
	 * 
	 * } else { FrameworkLogger.log(LogType.FAIL, "LPNs Verification Failed. " +
	 * listOfLPNs); } } if (text.equalsIgnoreCase("After")) { if
	 * (listOfLPNs.contains(parentlpnId)) { FrameworkLogger.log(LogType.FAIL,
	 * "Parent LPN Verification Failed. It should not display, but its displayed: "
	 * + parentlpnId); } else { FrameworkLogger.log(LogType.PASS,
	 * "Parent LPN Verification Passed. it should be disappeared. it is expected behaviour"
	 * ); } }
	 * 
	 * <<<<<<< HEAD }=======
	 * 
	 * List<WebElement> elements = DriverManager.getDriver().findElements(byILPNS);
	 * List<String> listOfLPNs = new ArrayList<>();for( WebElement element:elements)
	 * { listOfLPNs.add(element.getText().trim());
	 * }if(text.equalsIgnoreCase("Before")) { if (listOfLPNs.contains(lpn1Id) &&
	 * listOfLPNs.contains(lpn2Id) && listOfLPNs.contains(lpn1Id)) {
	 * FrameworkLogger.log(LogType.PASS, "LPNs Verification Passed. " + listOfLPNs);
	 * 
	 * } else { FrameworkLogger.log(LogType.FAIL, "LPNs Verification Failed. " +
	 * listOfLPNs); } }if(text.equalsIgnoreCase("After")) { if
	 * (listOfLPNs.contains(parentlpnId)) { FrameworkLogger.log(LogType.FAIL,
	 * "Parent LPN Verification Failed. It should not display, but its displayed: "
	 * + parentlpnId); } else { FrameworkLogger.log(LogType.PASS,
	 * "Parent LPN Verification Passed. it should be disappeared. it is expected behaviour"
	 * ); } }
	 * 
	 * List<WebElement> elements = DriverManager.getDriver().findElements(byILPNS);
	 * List<String> actualLPNs = new ArrayList<>();for( WebElement e:elements) {
	 * actualLPNs.add(e.getText()); }if(lpns.equals(actualLPNs)) {
	 * FrameworkLogger.log(LogType.PASS, "LPNs Verification passed : " + lpns);
	 * }else { FrameworkLogger.log(LogType.FAIL,
	 * "LPNs Verification failed. Expected :" + lpns + " , Actual :" + actualLPNs);
	 * } }
	 * 
	 * /** Function to click ILPN Card in ASN>ILPN
	 * 
	 * public static void clickILPNCardInILPN(String ILPN) {
	 * CommonMethods.waitForPageLoading();
	 * SeleniumActions.click(By.xpath("//span[contains(text(),'" + ILPN +
	 * "')]//following::div/span[contains(text(),'Parent LPN')]"), "Parent LPN");
	 * CommonMethods.waitForPageLoading(); SeleniumActions.click(byDetailBtn,
	 * "Details Button"); CommonMethods.waitForPageLoading(); }
	 * 
	 * /** Function to verify multiple lpns
	 * 
	 * @param lpns - lpns value which need to be verified
	 * 
	 * public static void verifyMultipleLPNs(List<String> lpns) { List<WebElement>
	 * elements = DriverManager.getDriver().findElements(byILPNS); List<String>
	 * actualLPNs = new ArrayList<>(); for (WebElement e: elements){
	 * actualLPNs.add(e.getText()); } if (lpns.equals(actualLPNs)) {
	 * FrameworkLogger.log(LogType.PASS, "LPNs Verification passed : " + lpns); }
	 * else { FrameworkLogger.log(LogType.FAIL,
	 * "LPNs Verification failed. Expected :" + lpns + " , Actual :" + actualLPNs);
	 * } }>>>>>>>origin/DEV
	 * 
	 * <<<<<<<HEAD}=======
	 * 
	 * List<WebElement> elements = DriverManager.getDriver().findElements(byILPNS);
	 * List<String> listOfLPNs = new ArrayList<>();for( WebElement
	 * element:elements){listOfLPNs.add(element.getText().trim());
	 * }if(text.equalsIgnoreCase("Before")){if(listOfLPNs.contains(lpn1Id)&&
	 * listOfLPNs.contains(lpn2Id)&&listOfLPNs.contains(lpn1Id)){FrameworkLogger.log
	 * (LogType.PASS,"LPNs Verification Passed. "+listOfLPNs);
	 * 
	 * }else{FrameworkLogger.log(LogType.FAIL,"LPNs Verification Failed. "
	 * +listOfLPNs);}}if(text.equalsIgnoreCase("After")){if(listOfLPNs.contains(
	 * parentlpnId)){FrameworkLogger.log(LogType.
	 * FAIL,"Parent LPN Verification Failed. It should not display, but its displayed: "
	 * +parentlpnId);}else{FrameworkLogger.log(LogType.
	 * PASS,"Parent LPN Verification Passed. it should be disappeared. it is expected behaviour"
	 * );}}}
	 * 
	 * public static void
	 * ValidateProductStatus_InventoryTypeAndCountryOfOrigin(String ProductStatus,
	 * String InventoryType, String CountryOfOrigin) {
	 * SeleniumActions.verifyElementExist(bylocationitemvalue, 5,
	 * "Item Value should be displayed"); By by =
	 * By.xpath("(//datatable-header-cell[@role='columnheader'])"); List<WebElement>
	 * header = DriverManager.getDriver().findElements(by); int i = header.size();
	 * for (i = 2; i >= 0 && i <= 27; i++) { WebElement ele =
	 * DriverManager.getDriver()
	 * .findElement(By.xpath("(//datatable-header-cell[@role='columnheader'])[" + i
	 * + "]")); if
	 * (ele.getAttribute("title").trim().equalsIgnoreCase("Product status")) {
	 * WebElement ele1 = DriverManager.getDriver()
	 * .findElement(By.xpath("(//div[@class='datatable-body-cell-label']//div)[" + i
	 * + "-1]")); if (ele1.getText().trim().equals(ProductStatus)) {
	 * FrameworkLogger.log(LogType.PASS, "Product status displayed"); } else {
	 * FrameworkLogger.log(LogType.FAIL, "Product status NOT displayed"); } } if
	 * (ele.getAttribute("title").trim().equalsIgnoreCase("Inventory type")) {
	 * WebElement ele2 = DriverManager.getDriver()
	 * .findElement(By.xpath("(//div[@class='datatable-body-cell-label']//div)[" + i
	 * + "-1]")); if
	 * (ele2.getAttribute("title").trim().equalsIgnoreCase(InventoryType)) {
	 * FrameworkLogger.log(LogType.PASS, "Inventory type is displayed"); } else {
	 * FrameworkLogger.log(LogType.FAIL, "Inventory type is NOT displayed"); } } if
	 * (ele.getAttribute("title").trim().equalsIgnoreCase("Country of origin")) {
	 * WebElement ele3 = DriverManager.getDriver()
	 * .findElement(By.xpath("(//div[@class='datatable-body-cell-label']//div)[" + i
	 * + "-1]")); if
	 * (ele3.getAttribute("title").trim().equalsIgnoreCase(CountryOfOrigin)) {
	 * FrameworkLogger.log(LogType.PASS, "COO is displayed"); } else {
	 * FrameworkLogger.log(LogType.FAIL, "COO is NOT displayed"); } } } }
	 * 
	 * /** Function to close ILPN screen
	 * 
	 * public static void closeILPN() {
	 * SeleniumActions.click(byCloseInventoryDetails, "Close Inventory Details");
	 * CommonMethods.waitForPageLoading(); }
	 * 
	 * /** Function to validate batch number and Expire date in Location Inventory
	 * screen
	 * 
	 * 
	 * public static void ValidateBatchNumandASNExpiryDate(String batchNo, String
	 * Expirydate) { SeleniumActions.verifyElementExist(bylocationitemvalue, 5,
	 * "Item Value shouldbe displayed"); By by =
	 * By.xpath("(//datatable-header-cell[@role='columnheader'])"); List<WebElement>
	 * header = DriverManager.getDriver().findElements(by); int i = header.size();
	 * for (i = 2; i >= 0 && i <= 15; i++) { WebElement ele =
	 * DriverManager.getDriver()
	 * .findElement(By.xpath("(//datatable-header-cell[@role='columnheader'])[" + i
	 * + "]")); if
	 * (ele.getAttribute("title").trim().equalsIgnoreCase("Batch number")) {
	 * WebElement ele1 = DriverManager.getDriver()
	 * .findElement(By.xpath("(//div[@class='datatable-body-cell-label']//div)[" + i
	 * + "-1]")); if (ele1.getText().trim().equals(batchNo)) {
	 * FrameworkLogger.log(LogType.PASS, "Batch Number displayed"); } else {
	 * FrameworkLogger.log(LogType.FAIL, "Batch Number NOT displayed"); } } if
	 * (ele.getAttribute("title").trim().equalsIgnoreCase("Expiration date")) {
	 * WebElement ele2 = DriverManager.getDriver()
	 * .findElement(By.xpath("(//div[@class='datatable-body-cell-label']//div)[" + i
	 * + "-1]")); String s = ele2.getAttribute("title"); String s2 = ele2.getText();
	 * if (s.equals(Expirydate)) {
	 * 
	 * FrameworkLogger.log(LogType.PASS, "Expiry date is displayed as expected"); }
	 * else { FrameworkLogger.log(LogType.FAIL,
	 * "Expiry date is not displayed as expected" + s2 + "--Expected Date :" +
	 * Expirydate + "-- Title:" + s); } } } }
	 * 
	 * public static void searchinventory() { CommonMethods.waitForPageLoading();
	 * SeleniumActions.click(byleftarrowbutton, "Details button displayed");
	 * CommonMethods.waitForPageLoading();
	 * SeleniumActions.click(byDetailBtnleftarrow, "Go to LPN deatils");
	 * CommonMethods.waitForPageLoading();
	 * SeleniumActions.click(byExpandInventoryitemsfield, "Expand icon");
	 * CommonMethods.waitForPageLoading(); }
	 * 
	 * /** Function to verify ILPN Details
	 * 
	 * public static void verifyILPNDetails() { CommonMethods.waitForPageLoading();
	 * SeleniumActions.click(byDetailBtn, "Details button ");
	 * CommonMethods.waitForPageLoading();
	 * SeleniumActions.click(byInventoryDetailsButton, "Inventory Details Button");
	 * CommonMethods.waitForPageLoading();
	 * CommonMethods.scrollByParticularElement(byProductStatus, "Product Status");
	 * CommonMethods.waitForPageLoading(); String productStatus =
	 * getDataFromFeature("getdata(ProductStatus)"); String inventoryType =
	 * getDataFromFeature("getdata(InventoryTypeId)"); String actualProductStatus =
	 * SeleniumActions.getAtrribute(byProductStatusCellValue, "title", 20); String
	 * actualInventoryType = SeleniumActions.getAtrribute(byInventoryTypeCellValue,
	 * "title", 20); if (productStatus.equals(actualProductStatus.trim())) {
	 * FrameworkLogger.log(LogType.PASS, "Product Status Verification passed : " +
	 * actualProductStatus); } else { FrameworkLogger.log(LogType.FAIL,
	 * "Product Status Verification failed. Expected :+" + productStatus +
	 * " , Actual :" + actualProductStatus); } if
	 * (inventoryType.equals(actualInventoryType.trim())) {
	 * FrameworkLogger.log(LogType.PASS, "Inventory Type Verification passed : " +
	 * actualInventoryType); } else { FrameworkLogger.log(LogType.FAIL,
	 * "Inventory Type Verification failed. Expected :+" + inventoryType +
	 * " , Actual :" + actualInventoryType); }
	 * SeleniumActions.click(byCloseInventoryDetails, "Close icon");
	 * CommonMethods.waitForPageLoading(); }
	 * 
	 * /** Function to verify statusCode at first index
	 * 
	 * @param statusCode - value which need to be verified
	 * 
	 * public static void verifyILPNStatusCodeAtFirstIndex(String statusCode) {
	 * String actualstatusCode =
	 * SeleniumActions.getAtrribute(byILPNStatusCodeAtFirstIndex, "title", 20);
	 * actualstatusCode = actualstatusCode.trim(); if
	 * (statusCode.equals(actualstatusCode)) { FrameworkLogger.log(LogType.PASS,
	 * "Status code Verification passed : " + statusCode); } else {
	 * FrameworkLogger.log(LogType.FAIL,
	 * "Status code Verification failed. Expected : " + statusCode + " , Actual :" +
	 * actualstatusCode); } }
	 * 
	 * InventryDetailspage.class
	 * 
	 * public static void validateLocationBarcodeAndItemBarcode(String
	 * LocationBarcode, String ItemBarcode) {
	 * SeleniumActions.verifyElementExist(bylocationitemvalue, 5,
	 * "Item Value should be displayed"); By by =
	 * By.xpath("(//datatable-header-cell[@role='columnheader'])"); List<WebElement>
	 * header = DriverManager.getDriver().findElements(by); int i = header.size();
	 * for (i = 2; i >= 0 && i <= 64; i++) { WebElement ele =
	 * DriverManager.getDriver()
	 * .findElement(By.xpath("(//datatable-header-cell[@role='columnheader'])[" + i
	 * + "]")); if
	 * (ele.getAttribute("title").trim().equalsIgnoreCase("Location Barcode")) {
	 * WebElement ele1 = DriverManager.getDriver()
	 * .findElement(By.xpath("(//div[@class='datatable-body-cell-label']//div)[" + i
	 * + "-1]")); if (ele1.getText().trim().equals(LocationBarcode)) {
	 * FrameworkLogger.log(LogType.PASS, "Location Barcode is displayed"); } else {
	 * FrameworkLogger.log(LogType.FAIL, "Location Barcode is NOT displayed"); } }
	 * if (ele.getAttribute("title").trim().equalsIgnoreCase("Item Barcode")) {
	 * WebElement ele2 = DriverManager.getDriver()
	 * .findElement(By.xpath("(//div[@class='datatable-body-cell-label']//div)[" + i
	 * + "-1]")); if
	 * (ele2.getAttribute("title").trim().equalsIgnoreCase(ItemBarcode)) {
	 * FrameworkLogger.log(LogType.PASS, "Item Barcode is displayed"); } else {
	 * FrameworkLogger.log(LogType.FAIL, "Item Barcode is NOT displayed"); } } } }
	 * 
	 * /** Function to select first row in inventory details page
	 * 
	 * public static void setByselectinvfirstrow() { WebElement element =
	 * DriverManager.getDriver().findElement(byselectinvfirstrow);
	 * SeleniumActions.click(byselectinvfirstrow, "select inventory first row");
	 * FrameworkLogger.log(LogType.INFO, "Select particular inventory"); }
	 * 
	 * if(iselepresent)
	 * 
	 * {CommonMethods.waitForPageLoading();SeleniumActions.click(
	 * byConfirmaction,"Confirm button");}else{System.out.println("Ele not present")
	 * ;}}catch(
	 * 
	 * Exception e){System.out.println(e); }
	 */

	@And("Refresh browser")
	public void refreshTheBrowser() {
		DriverManager.getDriver().navigate().refresh();
	}
	/*
	 * @And("Navigate to ASNs") public void navigate_to_asn() {
	 * HomePage.navigate_to_ASNs(); ASNs.verifyASNsPageDisplayed(); }
	 */

	/*
	 * @And("Navigate to ILPNs") public void navigate_to_ILPNs() {
	 * HomePage.navigate_to_ILPNs(); ILPNs.verifyPageDisplayed(); }
	 */

	/*
	 * @And("Navigate to WM Mobile") public void navigate_to_wmMobile() {
	 * HomePage.navigate_to_wmmobile(); WMMobile.verifyPageDisplayed(); }
	 */

	/*
	 * @And("Navigate to Storeage Location") public void
	 * navigate_to_storeage_location() { HomePage.navigate_to_StorageLocation();
	 * StorageLocation.verifyStorageLocationsPageDisplayed(); }
	 */

	/*
	 * @And("Enter Details at Create ASN Pop-up") public void enterDateInASNPopUp()
	 * { ASNs.enterDateInASNPopUp(); PurchaseOrderLineLookup.verifyPageDisplayed();
	 * }
	 */

	/*
	 * @And("Search PO at Purchase Order Line Lookup screen") public void
	 * searchPOAtPOLine() { PurchaseOrderLineLookup
	 * .searchPO(Variables.get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "PO_ID").toString()); //
	 * PurchaseOrderLineLookup.searchPO(getDataFromFeature("getdata(PO_ID)")); }
	 */

	/*
	 * @And("Search ASN at ASNs") public void searchASNinAsns() {
	 * ASNs.searchASN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "ASN").toString()); }
	 */

	/*
	 * @And("Search Wave run at Wave Runs") public void searchWaveRuninWaveRuns() {
	 * WaveRunsPage.searchWaveRuns(Variables.get(CurrentThreadInstance.
	 * getCurrentScenarioId() + "WaveRun").toString()); }
	 */

	/*
	 * @And("Verify ASN details are displayed") public static void
	 * verifyASNDetailsDisplayed() { ASNs.verifyASNDetailsDisplayed((String)
	 * Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN")); }
	 */

	/*
	 * @And("Update Quantity of LPNs") public static void updateQuantityOfLpns() {
	 * ASNs.updateQuantityOfLpns(1); }
	 */

	/*
	 * @And("Store ASN number in runtime variable") public static void
	 * captureASNNumber() { ASNs.captureASNNumber(); }
	 */
	/*
	 * @And("Search ASN at ILPNs") public void searchASNinILPNs() {
	 * ILPNs.searchASN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "ASN").toString()); }
	 */

	/*
	 * @And("Search iLPN at ILPNs") public void searchiLPNinILPNs() {
	 * ILPNs.searchLPN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "LPN" + 1).toString()); }
	 */

	/*
	 * @And("Store iLPNs to runtime variables as list") public static void
	 * storeILPNsToList() { ILPNs.storeILPNsToList(); }
	 */

	/*
	 * @And("Verify exported excel values") public static void excelValidation() {
	 * ILPNs.excelValidation(); }
	 */

	/*
	 * @And("Search menu {string} at WM Mobile") public void
	 * searchMenuWmMobile(String strText) { WMMobile.searchMenu(strText); }
	 */

	/*
	 * @And("Receive LPNs at WM Mobile using ASN") public void receiveLpns() {
	 * ReceiveLPNLevel.verifyPageDisplayed(); List<String> listOFiLPNs =
	 * (List<String>) Variables .get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "listOFiLPNs"); ReceiveLPNLevel.receiveLPNs(listOFiLPNs);
	 * CommonMethods.waitForPageLoading(); }
	 */

	/*
	 * @And("Verify receiving ASN") public void verifyReceivingASN() {
	 * ASNs.verifyReceivingASN(); }
	 */

	/*
	 * @And("Verify receiving ASN wo buttonpopup") public void
	 * verifyReceivingASNWoButtonpopup() { ASNs.verifyReceivingASNwobuttonpopup(); }
	 */

	/*
	 * @And("Validate ASN status {string}") public void validate_asn_status(String
	 * ASNStatus) { ASNs.verifyASNStatus(ASNStatus); }
	 */

	/*
	 * @And("Put away LPNs") public void putAwayLPNs() {
	 * SystemDirected.verifyPageDisplayed(); List<String> listOFiLPNs = new
	 * ArrayList<>(); if (Variables.get(CurrentThreadInstance.getCurrentScenarioId()
	 * + "listOFiLPNs") instanceof List<?>) { listOFiLPNs = (List<String>)
	 * Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "listOFiLPNs");
	 * } SystemDirected.putAwayLPNs(listOFiLPNs); }
	 */

	/*
	 * @And("Putaway LPN User Directed") public void putaway_lpn_user_directed() {
	 * String strLPN = Variables.get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "LPN" + 0).toString(); UserDirected.putawayLPN(strLPN); }
	 */

	/*
	 * @And("Putaway LPN System Directed") public void putaway_lpn_system_directed()
	 * { String strLPN = Variables.get(CurrentThreadInstance.getCurrentScenarioId()
	 * + "LPN" + 1).toString(); SystemDirected.putawayLPN(strLPN); }
	 */

	/*
	 * @And("Navigate back to Parent window") public static void
	 * backToParentWindow() {
	 * SeleniumActions.switchWindowWithHandle(Variables.get("mainwindow").toString()
	 * ); }
	 */

	/*
	 * @And("Wait for page loading") public static void waitForPageLoading() {
	 * CommonMethods.waitForPageLoading(); }
	 */

	/*
	 * @And("Update Business Unit {string}") public void update_business_unit(String
	 * strText) { HomePage.updateBusinessUnit(getDataFromFeature(strText)); }
	 */

	/*
	 * @And("Complete ATStandardReceiving with produtstatus") public void
	 * completeATStandardReceivingWithProdutstatus() {
	 * ReceiveLPNLevel.searchASN(Variables.get(CurrentThreadInstance.
	 * getCurrentScenarioId() + "ASN").toString());
	 * ReceiveLPNLevel.enterLPN(ExcelUtil1.convert_variable_to_timestamp(
	 * getDataFromFeature("getdata(LPNId)")));
	 * ReceiveLPNLevel.enterScanItem(getDataFromFeature("getdata(ItemID_Line1)"));
	 * ReceiveLPNLevel.searchInventory("F");
	 * ReceiveLPNLevel.searchProductStatus("A"); }
	 */

	/*
	 * @And("Complete ATStandardReceiving and Validate Quantity exceeds error")
	 * public void
	 * complete_at_standard_receiving_and_validate_quantity_exceeds_error() {
	 * ReceiveLPNLevel.searchASN(Variables.get(CurrentThreadInstance.
	 * getCurrentScenarioId() + "ASN").toString()); float iReceiveFloat =
	 * Integer.valueOf(getDataFromFeature("getdata(OrdQty_Line1)")) /
	 * Integer.valueOf(getDataFromFeature("getdata(QtyToAssign_Line1_Valid)")); int
	 * iRecieveLoop = (int) iReceiveFloat; for (int iReceive = 0; iReceive <=
	 * iRecieveLoop; iReceive++) { if (iReceive < iRecieveLoop) {
	 * FrameworkLogger.log(LogType.PASS, iReceive + " Loop " + iRecieveLoop);
	 * ReceiveLPNLevel.atStandardReceiving(null, iReceive,
	 * getDataFromFeature("getdata(QtyToAssign_Line1_Valid)"));
	 * ReceiveLPNLevel.verifyErrorNotDisplayed(); } if (iReceive == iRecieveLoop) {
	 * FrameworkLogger.log(LogType.PASS, iReceive + " error Loop " + iRecieveLoop);
	 * ReceiveLPNLevel.atStandardReceiving(null, iReceive,
	 * getDataFromFeature("getdata(QtyToAssign_Line1_InValid)"));
	 * ReceiveLPNLevel.verifyErrorDisplayed(); } } }
	 */

	/*
	 * @And("Complete ATStandardReceiving duplicate lines") public void
	 * complete_at_standard_receiving_duplicate_lines() {
	 * ReceiveLPNLevel.searchASN(Variables.get(CurrentThreadInstance.
	 * getCurrentScenarioId() + "ASN").toString());
	 * ReceiveLPNLevel.atStandardReceiving(null, 1,
	 * getDataFromFeature("getdata(OrdQty_Line1)"));
	 * ReceiveLPNLevel.atStandardReceiving(null, 2,
	 * getDataFromFeature("getdata(OrdQty_Line2)"));
	 * ReceiveLPNLevel.verifyErrorNotDisplayed(); }
	 */

	/*
	 * @And("Complete ATStandardReceiving") public void
	 * complete_at_standard_receiving() {
	 * ReceiveLPNLevel.searchASN(Variables.get(CurrentThreadInstance.
	 * getCurrentScenarioId() + "ASN").toString());
	 * ReceiveLPNLevel.atStandardReceiving(null, 1,
	 * getDataFromFeature("getdata(OrdQty_Line1)"));
	 * ReceiveLPNLevel.verifyErrorNotDisplayed(); }
	 */

	/*
	 * @And("Complete ATStandardReceiving With Serial Number") public void
	 * complete_at_standard_receiving_serial_number() {
	 * ReceiveLPNLevel.searchASN(Variables.get(CurrentThreadInstance.
	 * getCurrentScenarioId() + "ASN").toString()); ReceiveLPNLevel.enterLPN(null,
	 * 1);
	 * ReceiveLPNLevel.enterScanItem(getDataFromFeature("getdata(ItemID_Line1)"));
	 * ReceiveLPNLevel.searchProductStatus(null);
	 * ReceiveLPNLevel.searchProductStatus(null);
	 * ReceiveLPNLevel.enterQuantity(Integer.parseInt(getDataFromFeature(
	 * "getdata(OrdQty_Line1)"))); int iRecieveLoop =
	 * Integer.parseInt(getDataFromFeature("getdata(OrdQty_Line1)")); String
	 * strSerial = RandomUtils.generateString_WithTimeStamp("SN0", "yyMMddmm"); for
	 * (int iReceive = 1; iReceive <= iRecieveLoop; iReceive++) { String strSerial1
	 * = strSerial + iReceive; ReceiveLPNLevel.enterSerialNumber(strSerial1);
	 * Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "SerialNumber" +
	 * iReceive, strSerial1); } ReceiveLPNLevel.verifyErrorNotDisplayed(); }
	 */

	/*
	 * @And("Complete AT BlindReceiving") public void complete_at_blind_receiving()
	 * { ReceiveLPNLevel.searchASN(null); ReceiveLPNLevel.enterLPN(null, 1);
	 * ReceiveLPNLevel.enterScanItem(getDataFromFeature("getdata(ItemID_Line1)"));
	 * ReceiveLPNLevel.enterBatchnumber(getDataFromFeature("getdata(BatchNo_Line1)")
	 * ); ReceiveLPNLevel.enterQuantity(Integer.parseInt(getDataFromFeature(
	 * "getdata(OrdQty_Line1)"))); }
	 */

	/*
	 * @And("Verify Inventry updated") public void verify_inventry_updated() {
	 * SeleniumActions.switchToWindowUsingIndex(0);
	 * HomePage.navigate_to_StorageLocation();
	 * StorageLocation.saveCurrentQuantity("CurrentQtyUpdated"); if
	 * (Integer.parseInt(Variables.get(CurrentThreadInstance.getCurrentScenarioId()
	 * + "CurrentQtyBeforeUpdate") .toString()) < Integer.parseInt(
	 * Variables.get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "CurrentQtyUpdated").toString())) { FrameworkLogger.log(LogType.PASS,
	 * "Current Quantity value is updated"); SeleniumActions.switchToLastWindow();
	 * SeleniumActions.closeBrowser(); SeleniumActions.switchToLastWindow(); } else
	 * { FrameworkLogger.log(LogType.FAIL, "Current Quantity is not updated"); } }
	 */

	/*
	 * @And("Validate popup message {string}") public void
	 * validate_popup_message(String strMsg) {
	 * PopupWrapper.validatePopupMessage(strMsg); }
	 */

	/*
	 * @And("Verify Blind receiving") public void verify_blind_receiving() {
	 * PopupWrapper.BlindPopupMessage(); }
	 */

	/*
	 * @And("Verify variance and Accept") public void verify_variance_and_accept() {
	 * PopupWrapper.validateVarianceMessage("Variance exists for ASN " +
	 * Variables.get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "ASN").toString() + "."); }
	 */

	/*
	 * @And("Positive Quantity Adjustment") public void
	 * positive_quantity_adjustment() { ModifyiLPN.verifyPageDisplayed(); String
	 * strLPN = Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "LPN" +
	 * 1).toString(); ModifyiLPN.searchLPN(strLPN);
	 * ModifyiLPN.readCurrentQuantity(); int iQuantityValue = Integer
	 * .parseInt(Variables.get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "CurrentQty").toString()) +
	 * Integer.parseInt(getDataFromFeature("getdata(PositiveQtyIncrement)"));
	 * Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "AdjustedValue",
	 * iQuantityValue); ModifyiLPN.updateQuantity(iQuantityValue);
	 * ModifyiLPN.updateCodesQuantity(); SeleniumActions.closeBrowser();
	 * SeleniumActions.switchToLastWindow(); }
	 */

	/*
	 * @And("Negative Quantity Adjustment") public void
	 * negative_quantity_adjustment() { ModifyiLPN.verifyPageDisplayed(); String
	 * strLPN = Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "LPN" +
	 * 1).toString(); ModifyiLPN.searchLPN(strLPN);
	 * ModifyiLPN.readCurrentQuantity(); int iCurrentQuantity = Integer
	 * .parseInt(Variables.get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "CurrentQty").toString()); if (iCurrentQuantity >
	 * Integer.parseInt(getDataFromFeature("getdata(NegativeQtyDecrement)"))) { int
	 * iQuantityValue = iCurrentQuantity -
	 * Integer.parseInt(getDataFromFeature("getdata(NegativeQtyDecrement)"));
	 * Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "AdjustedValue",
	 * iQuantityValue); ModifyiLPN.updateQuantity(iQuantityValue);
	 * ModifyiLPN.updateCodesQuantity(); } else { FrameworkLogger.log(LogType.FAIL,
	 * Integer.parseInt(getDataFromFeature("getdata(NegativeQtyDecrement)")) +
	 * "requested quantity cannot be updated"); } SeleniumActions.closeBrowser();
	 * SeleniumActions.switchToLastWindow();
	 *
	 * }
	 */

	/*
	 * @And("Validate Quantity Adjustment") public void
	 * validate_quantity_adjustment() {
	 * ILPNs.searchLPN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "LPN" + 1).toString()); ILPNs.navigateToLocationInventory();
	 * ILPNs.validateCurrentQuantity(); }
	 */

	/*
	 * @And("Search Display location at Location Inventory") public void
	 * search_display_location_at_location_inventory() {
	 * LocationInventory.searchDisplayLocation(getDataFromFeature(
	 * "getdata(DisplayLocation)"), true);
	 *
	 * }
	 */

	/*
	 * @And("Search Display location With {string} in Location Inventory") public
	 * void searchDisplayLocationWithInLocationInventory(String location) {
	 * LocationInventory.searchDisplayLocation(getDataFromFeature(location), false);
	 * }
	 */

	/*
	 * @And("Select Storeage Location on Location Inventory") public void
	 * select_storeage_location_on_location_inventory() {
	 * SeleniumActions.click(By.xpath("//span[@title='" +
	 * Variables.get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "SelectedLocation").toString() +
	 * "' and @data-component-id='DisplayLocation']"), "Location Inventory Card"); }
	 */

	/*
	 * @And("Positive Quantity Adjustment at Pick Location") public void
	 * positive_quantity_adjustment_at_pick_location() {
	 * LocationInventory.selectAdjustInventory();
	 * AdjustPopup.addAdjustment(getDataFromFeature("getdata(AddQuantity)"),
	 * getDataFromFeature("getdata(ReasonCode)")); }
	 */

	/*
	 * @And("Negative Quantity Adjustment at Pick Location") public void
	 * negative_quantity_adjustment_at_pick_location() {
	 * LocationInventory.selectAdjustInventory();
	 * AdjustPopup.removeAdjustment(getDataFromFeature("getdata(RemoveQuantity)"),
	 * getDataFromFeature("getdata(ReasonCode)")); }
	 */
	/*
	 * @And("Navigate to Original Orders2") public void
	 * navigate_to_original_orders2() { HomePage.navigate_to_OriginalOrder2();
	 * OriginalOrdersPage.verifyOriginalOrders2PageDisplayed(); }
	 */
	/*
	 * @And("Navigate to Orders") public void navigate_to_orders() {
	 * HomePage.navigate_to_Orders();
	 * OriginalOrdersPage.verifyOrdersPageDisplayed(); }
	 */
	/*
	 * @And("Navigate to Wave Runs") public void navigate_to_wave_runs() {
	 * HomePage.navigate_to_waveRuns(); WaveRunsPage.verifyWaveRunsPageDisplayed();
	 * }
	 */
	/*
	 * @And("Clear Notifications") public void clear_notifications() {
	 * HomePage.clickAlertNotificationIcon(); ;
	 * NotificationPage.clearAllNotifications();
	 * HomePage.clickAlertNotificationIcon(); }
	 */
	/*
	 * @And("Verify notification message {string}") public void
	 * verify_notification_message(String string) { GeneralUtils.wait(1 * 1000); //
	 * HomePage.openAlertNotification();
	 * NotificationPage.verifyNotificationMessage(string);
	 *
	 * }
	 */
	/*
	 * @And("Verify notification export ASN message {string}") public void
	 * verifyNotificationExportASN(String strMessage) { }
	 *
	 * @And("Verify notification message {string}") public void
	 * verify_notification_message(String string) {
	 * NotificationPage.verifyNotificationMessage(); }
	 *
	 * @And("Verify notification export ASN message {string}") public void
	 * verifyNotificationExportASN(String string) {
	 *
	 * GeneralUtils.wait(1 * 1000); HomePage.openAlertNotification();
	 * NotificationPage.verifyNotificationMessage(strMessage); }
	 */
	/*
	 * @And("Close alert Notification window") public void
	 * close_alert_notification_window() { HomePage.clickAlertNotificationIcon(); }
	 */
	/*
	 * @And("Download Original Order") public void download_original_order() {
	 * ExcelUtil1.deleteExistingFile("OriginalOrder.xlsx");
	 * NotificationPage.downloadOriginalOrder(); HomePage.openAlertNotification();
	 * ExcelUtil1.verifyFilePresent("OriginalOrder.xlsx"); }
	 */

	/*
	 * @And("Update Original Order") public void update_original_order() {
	 * ExcelUtil1.verifyFilePresent("OriginalOrder.xlsx"); String strOrderValue =
	 * ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature(
	 * "getdata(OriginalOrderID)"));
	 * ExcelUtil1.writeCellValueForColumn("OriginalOrder.xlsx", "OriginalOrder",
	 * "OriginalOrderId", strOrderValue);
	 * ExcelUtil1.writeCellValueForColumn("OriginalOrder.xlsx", "OriginalOrderLine",
	 * "OriginalOrder.OriginalOrderId", strOrderValue);
	 * ExcelUtil1.emptyCellValueForColumn("OriginalOrder.xlsx", "OriginalOrderLine",
	 * "BatchNumber"); }
	 *
	 * @And("Import Data Loader {string}") public void import_data_loader(String
	 * strFileName) { // ExcelUtil1.selectFiletoImport1(strFileName); //
	 * OriginalOrdersPage.selectFiletoImport(strFileName);
	 * CommonPage.selectFileToImport(strFileName); }
	 *
	 * @And("Verify Imported Orders") public void verify_imported_orders() {
	 * OriginalOrdersPage.filterOriginalOrder(
	 * Variables.get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "OriginalOrder").toString()); }
	 *
	 * @And("Validate Positive Quantity Adjustment") public void
	 * validate_positive_quantity_adjustment() {
	 * LocationInventory.searchDisplayLocation(
	 * Variables.get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "SelectedLocation").toString(), false);
	 * LocationInventory.getCurrentQuantity(); int iCurrentQty = Integer
	 * .parseInt(Variables.get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "CurrentQuantityBefore") .toString().replace(" UNIT", "")); int
	 * iCurrentQtyUpdated = Integer
	 * .parseInt(Variables.get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "CurrentQuantityPresent") .toString().replace(" UNIT", "")); int
	 * iAdjustedValue =
	 * Integer.parseInt(getDataFromFeature("getdata(AddQuantity)")); if
	 * (iCurrentQtyUpdated == (iCurrentQty + iAdjustedValue)) {
	 * FrameworkLogger.log(LogType.PASS, "Current quantity is updated to " +
	 * Variables .get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "CurrentQuantityPresent").toString()); } else {
	 * FrameworkLogger.log(LogType.FAIL,
	 * "Current quantity is not updated,Before update value : " + iCurrentQty +
	 * " After update value : " + iCurrentQtyUpdated); } }
	 *
	 * @And("Validate Negative Quantity Adjustment") public void
	 * validate_negative_quantity_adjustment() {
	 * LocationInventory.searchDisplayLocation(
	 * Variables.get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "SelectedLocation").toString(), false);
	 * LocationInventory.getCurrentQuantity(); int iCurrentQty = Integer
	 * .parseInt(Variables.get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "CurrentQuantityBefore") .toString().replace(" UNIT", "")); int
	 * iCurrentQtyUpdated = Integer
	 * .parseInt(Variables.get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "CurrentQuantityPresent") .toString().replace(" UNIT", "")); int
	 * iAdjustedValue =
	 * Integer.parseInt(getDataFromFeature("getdata(RemoveQuantity)")); if
	 * (iCurrentQtyUpdated == (iCurrentQty - iAdjustedValue)) {
	 * FrameworkLogger.log(LogType.PASS, "Current quantity is updated to " +
	 * Variables .get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "CurrentQuantityPresent").toString()); } else {
	 * FrameworkLogger.log(LogType.FAIL,
	 * "Current quantity is not updated,Before update value : " + iCurrentQty +
	 * " After update value : " + iCurrentQtyUpdated); } }
	 *
	 * @And("Select Order for RunWave") public void select_order_for_run_wave() {
	 * OrdersPage.selectOrder("Released"); //
	 * OriginalOrdersPage.selectOrder("Released"); }
	 *
	 * @And("Validate Orders status {string}") public void
	 * validate_orders_status(String strOrderStatus) {
	 * OrdersPage.verifyOrderStatus(strOrderStatus); //
	 * OriginalOrdersPage.verifyOrderStatus(strOrderStatus); }
	 *
	 * @And("Validate Orderslines status {string}") public void
	 * validate_orderslines_status(String strOrderStatus) { //
	 * OriginalOrdersPage.verifyOrderLinesStatus(strOrderStatus);
	 * OrdersPage.verifyOrderLinesStatus(strOrderStatus); }
	 *
	 * @And("Execute RunWave") public void execute_run_wave() {
	 * OrdersPage.executeRunWave(); // OriginalOrdersPage.executeRunWave(); }
	 *
	 * @And("Filter Original Orders2") public void filter_original_orders2() {
	 * OriginalOrdersPage.filterOriginalOrder(null); }
	 *
	 * @And("Validate Wave run status till {string}") public void
	 * validate_wave_run_status_till(String strStatus) {
	 * WaveRunsPage.waitAndVerifyWaveStatus(strStatus); }
	 *
	 * @And("Search Order at Orders") public void search_order_at_orders() {
	 * OrdersPage.searchOrdersRuns(
	 * Variables.get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "OriginalOrder").toString()); }
	 *
	 * @And("Get and Search ASN at ASNs {string}") public void
	 * getAndSearchASNAtASNsGetdataASN(String strText) {
	 * ASNs.searchASN(getDataFromFeature(strText)); }
	 *
	 * @And("Verify ASN details are displayed via {string}") public void
	 * verifyASNDetailsAreDisplayedViaGetdataASN(String strText) {
	 * ASNs.verifyASNDetailsDisplayed(getDataFromFeature(strText)); }
	 *
	 * @And("Download ASN file") public void downloadASNFile() {
	 * ExcelUtil1.deleteExistingFile("ASN.xlsx");
	 * NotificationPage.downloadASNfile(); HomePage.openAlertNotification();
	 * ExcelUtil1.verifyFilePresent("ASN.xlsx"); }
	 *
	 * @And("Import Data Loader for ASN") public void importDataLoaderForASN() {
	 * ASNs.selectFiletoImport(); }
	 *
	 * @And("Select Order for PickPack") public void selectOrderForPickPack() {
	 * OriginalOrdersPage.selectOrderforpickpack(); }
	 *
	 * @And("Verify task status and Set the oLPN number") public void
	 * verifyTaskStatusAndSetTheOLPNNumber() { OrdersPage.copyoLPN(); }
	 *
	 * @And("Pick Pack oLPN User directed") public void pickPackOLPNUserDirected() {
	 * String strolpn = Variables.get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "taskoLPN").toString(); UserDirected.pickpackoLPN(strolpn); }
	 *
	 * @And("Search Current Location With {string} in iLPNs Page") public void
	 * searchCurrentLocationWithInILPNsPage(String text) {
	 * ILPNs.searchCurrentLocation(getDataFromFeature(text)); }
	 *
	 * @And("Move iLPN from Storage location to Damage location") public void
	 * moveILPNFromStorageLocationToDamageLocation() { String iLPN = (String)
	 * Variables.get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "ILPNIdAtFirstIndex"); String quantity = (String) Variables
	 * .get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "ILPNQuantityAtFirstIndex"); String damageLocation =
	 * getDataFromFeature("getdata(DamageLocation)");
	 *
	 * UserDirected.searchLPN(iLPN); UserDirected.enterQuantity(quantity);
	 * UserDirected.enterScanLocation(damageLocation);
	 * SeleniumActions.switchToLastWindow(); SeleniumActions.closeBrowser();
	 * SeleniumActions.switchToLastWindow(); }
	 *
	 * @And("Move iLPN from Damage location to Storage location") public void
	 * moveILPNFromDamageLocationToStorageLocation() { String iLPN = (String)
	 * Variables.get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "ILPNIdAtFirstIndex"); String quantity = (String) Variables
	 * .get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "ILPNQuantityAtFirstIndex"); String storageLocation = (String) Variables
	 * .get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "ILPNCurrentLocationAtFirstIndex");
	 *
	 * UserDirected.searchLPN(iLPN); UserDirected.enterQuantity(quantity);
	 * UserDirected.enterScanLocation(storageLocation);
	 * TasksPage.clickConfirmInPopupIfDisplayed();
	 * SeleniumActions.switchToLastWindow(); SeleniumActions.closeBrowser();
	 * SeleniumActions.switchToLastWindow(); }
	 *
	 * @Then("Verify iLPN moved to Damage location") public void
	 * verifyILPNMovedToDamageLocation() { CommonMethods.waitForPageLoading();
	 * String iLPN = (String)
	 * Variables.get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "ILPNIdAtFirstIndex"); String quantity = (String) Variables
	 * .get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "ILPNQuantityAtFirstIndex"); String storageLocation = (String) Variables
	 * .get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "ILPNCurrentLocationAtFirstIndex"); String damageLocation =
	 * getDataFromFeature("getdata(DamageLocation)");
	 * SeleniumActions.switchToWindowUsingIndex(0);
	 * LocationInventory.clickClearAllButton(); ILPNs.searchLPNID(iLPN);
	 * ILPNs.verifyILPNAtFirstIndex(iLPN);
	 * ILPNs.verifyILPNQuantityAtFirstIndex(quantity);
	 * ILPNs.verifyILPNCurrentLocationAtFirstIndex(damageLocation);
	 * ILPNs.verifyILPNPreviousLocationAtFirstIndex(storageLocation); }
	 *
	 * @Then("Verify iLPN moved to Storage location") public void
	 * verifyILPNMovedToStorageLocation() { String iLPN = (String)
	 * Variables.get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "ILPNIdAtFirstIndex"); String quantity = (String) Variables
	 * .get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "ILPNQuantityAtFirstIndex"); String storageLocation = (String) Variables
	 * .get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "ILPNCurrentLocationAtFirstIndex"); String damageLocation =
	 * getDataFromFeature("getdata(DamageLocation)");
	 * SeleniumActions.switchToWindowUsingIndex(0);
	 * LocationInventory.clickClearAllButton(); ILPNs.searchLPNID(iLPN);
	 * ILPNs.verifyILPNAtFirstIndex(iLPN);
	 * ILPNs.verifyILPNQuantityAtFirstIndex(quantity);
	 * ILPNs.verifyILPNCurrentLocationAtFirstIndex(storageLocation);
	 * ILPNs.verifyILPNPreviousLocationAtFirstIndex(damageLocation); }
	 *
	 * @And("Store iLPN Details to run time Variables") public void
	 * storeILPNDetailsToRunTimeVariables() {
	 * ILPNs.storeILPNIdAtFirstIndexToString();
	 * ILPNs.storeILPNQuantityAtFirstIndexToString();
	 * ILPNs.storeILPNCurrentLocationAtFirstIndexToString(); }
	 *
	 * @And("Store iLPN ID to runtime variable as String") public static void
	 * storeILPNIdToString() { ILPNs.storeILPNIdAtFirstIndexToString(); }
	 *
	 * @And("Store iLPN Quantity to runtime variable as String") public static void
	 * storeILPNQuantityToString() { ILPNs.storeILPNQuantityAtFirstIndexToString();
	 * }
	 *
	 * @And("Store iLPN Current Location to runtime variable as String") public
	 * static void storeILPNCurrentLocationToString() {
	 * ILPNs.storeILPNCurrentLocationAtFirstIndexToString(); }
	 *
	 * @And("Select the location and select cycle count from the three dot bottom menu"
	 * ) public void selectTheLocationAndSelectCycleCountFromTheThreeDotBottomMenu()
	 * { LocationInventory.selectLocationAndSelectCycleCountFromBottomMenu(); }
	 *
	 * @And("Update Business Unit in Pop-up {string}") public void
	 * updateBusinessUnitInPopUpGetdataBUID(String strText) {
	 * HomePage.updateBusinessUnitInPopup(getDataFromFeature(strText)); }
	 *
	 * @And("Advance ASN Filter by ASN Level & Status") public void
	 * filter_asn_by_status() {
	 * ASNs.filterASNByLevel(getDataFromFeature("getdata(ASNLevel)"));
	 * ASNs.filterASNByStatus(getDataFromFeature("getdata(ASNStatus)")); }
	 *
	 * @And("Download ASN Order") public void download_asn_order() {
	 * ExcelUtil1.deleteExistingFile("ASN.xlsx");
	 * NotificationPage.downloadAsnOrder(); HomePage.openAlertNotification();
	 * ExcelUtil1.verifyFilePresent("ASN.xlsx"); }
	 *
	 * @And("Update ASN Order") public void update_asn_order() {
	 * ExcelUtil1.verifyFilePresent("ASN.xlsx"); String strAsnValue =
	 * ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(AsnId)")
	 * ); ExcelUtil1.writeCellValueForColumn("ASN.xlsx", "Asn", "AsnId",
	 * strAsnValue); ExcelUtil1.writeCellValueForColumn("ASN.xlsx", "AsnLine",
	 * "AsnId", strAsnValue); }
	 *
	 * @And("Update ASN without PO and valid Item {string}") public void
	 * update_asn_without_po_and_valid_item(String strFileName) {
	 * ExcelUtil1.writeCellValueForColumn1(strFileName, "AsnLine",
	 * "PurchaseOrderLineId", ""); ExcelUtil1.writeCellValueForColumn1(strFileName,
	 * "AsnLine", "PurchaseOrderId", "");
	 * ExcelUtil1.writeCellValueForColumn1(strFileName, "AsnLine", "ItemId",
	 * getDataFromFeature("getdata(ItemID_Line1)")); String strAsnValue =
	 * ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(AsnId)")
	 * ); ExcelUtil1.writeCellValueForColumn(strFileName, "Asn", "AsnId",
	 * strAsnValue); ExcelUtil1.writeCellValueForColumn(strFileName, "AsnLine",
	 * "AsnId", strAsnValue); }
	 *
	 * @And("Import ASN Data Loader") public void import_asn_data_loader() {
	 * ASNs.selectFiletoImport(); }
	 *
	 * @And("Verify Imported ASN Orders") public void verify_imported_asn_orders() {
	 * ASNs.filterAsnOrder(Variables.get(CurrentThreadInstance.getCurrentScenarioId(
	 * ) + "ASN").toString()); }
	 *
	 * @And("Complete ATStandardReceiving with Invalid Item and Verify error message"
	 * ) public void complete_at_standard_receiving_with_invalid_item() {
	 * ReceiveLPNLevel.searchASN(Variables.get(CurrentThreadInstance.
	 * getCurrentScenarioId() + "ASN").toString()); ReceiveLPNLevel.enterLPN(null,
	 * 1); ReceiveLPNLevel.enterScanItem(getDataFromFeature(
	 * "getdata(InvalidItemID_Line1)"));
	 * PopupWrapper.validateInvalidItemPopupMessage(); }
	 *
	 * @And("Validate Invalid Item Error") public void verify_invalid_item_error() {
	 * PopupWrapper.validateInvalidItemPopupMessage(); }
	 *
	 * @And("Navigate to Tasks") public void navigateToTasks() {
	 * HomePage.navigateToTasks(); TasksPage.verifyTasksPageDisplayed();
	 * LocationInventory.clickClearAllButton(); }
	 *
	 * @Then("Verify task created with status ReadyForAssignment for the selected location"
	 * ) public void
	 * verifyTaskCreatedWithStatusReadyForAssignmentForTheSelectedLocation() {
	 * CommonMethods.waitForPageLoading();
	 * TasksPage.verifyReadyForAssignmentButtonAtFirstIndex();
	 * TasksPage.verifyTransactionTypeAtFirstIndex(); String location = (String)
	 * Variables .get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "WithoutCycleCountLocationAtFirstIndex");
	 * TasksPage.verifySourceLocationAtFirstIndex(location);
	 * TasksPage.storeTaskId(); }
	 *
	 * @And("Click Submit in confirmation screen with cycle count {string}") public
	 * void clickSubmitInConfirmationScreenWithCycleCount(String count) {
	 * HomePage.clickSubmitOnCycleCountConfirmationScreen(getDataFromFeature(count))
	 * ; }
	 *
	 * @And("Enter the tasks details in cycle count screen and complete the process"
	 * ) public void enterTheTasksDetailsInCycleCountScreenAndCompleteTheProcess() {
	 * String taskId = (String)
	 * Variables.get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "TaskIdAtFirstIndex"); String location = (String) Variables
	 * .get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "WithoutCycleCountLocationAtFirstIndex"); String ilpn = (String) Variables
	 * .get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "WithoutCycleCountILPINIdAtFirstIndex"); String item = (String) Variables
	 * .get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "WithoutCycleCountItemNameAtFirstIndex"); String batchNumber = (String)
	 * Variables .get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "BatchNumberInPopup"); String quantity = (String) Variables
	 * .get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "WithoutCycleCountILPINQuantityAtFirstIndex"); TasksPage.enterTask(taskId);
	 * TasksPage.clickGoButton(); TasksPage.enterScanLocation(location);
	 * TasksPage.clickGoButton(); TasksPage.enterILPN(ilpn);
	 * TasksPage.clickGoButton(); TasksPage.enterScanItem(item);
	 * TasksPage.clickGoButton();
	 * TasksPage.enterBatchNumberIfDisplayed(batchNumber);
	 * TasksPage.enterQuantity(quantity); TasksPage.clickGoButton();
	 * TasksPage.clickEndILPNButton(); TasksPage.clickEndCountButton();
	 * TasksPage.clickConfirmInPopupIfDisplayed(); }
	 *
	 * @And("Click on ClearAll button") public void clickOnClearAllButton() {
	 * LocationInventory.clickClearAllButton(); }
	 *
	 * @And("Complete item and quantity") public void completeItemAndQuantity() {
	 * WMMobile.completeItemandQty(); }
	 *
	 * @And("Verify prompts olpn is packed and click ok") public void
	 * verifyPromptsOlpnIsPackedAndClickOk() { WMMobile.pickpackprompt(); }
	 *
	 * @Then("Verify Order status to packed") public void
	 * verifyOrderStatusToPacked() { OriginalOrdersPage.selectOrderforpickpack();
	 * OriginalOrdersPage.verifyOrderStatus("Packed"); }
	 *
	 * @And("Search ASNStatus at ASNs from Variables") public void
	 * searchASNStatusAtASNsFromVariables() { ASNs.searchASN((String)
	 * Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "strAsnId"));
	 * ASNs.verifyASNDetailsDisplayed( (String)
	 * Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "strAsnId"));
	 * ASNs.verifyASNStatus("In Transit"); }
	 *
	 * @And("Verify import notification message {string}") public void
	 * verify_notification_import(String string) { GeneralUtils.wait(1 * 1000);
	 * HomePage.refreshAlertNotification(); HomePage.refreshAlertNotification();
	 * NotificationPage.verifyNotificationMessage(string); }
	 *
	 * @And("Select First Order in Screen") public void
	 * select_first_order_in_screen() { OrdersPage.SelectAllocatedOrder(); }
	 *
	 * @And("Select First Packed Order in Screen") public void
	 * select_first_packed_order_in_screen() { OrdersPage.SelectPackedOrder(); ; }
	 *
	 * @Then("Validate error has one cubiscan product") public void
	 * validateErrorHasOneCubiscanProduct() {
	 * ReceiveLPNLevel.ValidateCubiscanAlert(); }
	 *
	 * @And("Complete ATStandardReceiving with tolerance") public void
	 * completeATStandardReceivingWithTolerance() {
	 * ReceiveLPNLevel.searchASN(Variables.get(CurrentThreadInstance.
	 * getCurrentScenarioId() + "ASN").toString());
	 * ReceiveLPNLevel.enterLPN(ExcelUtil1.convert_variable_to_timestamp(
	 * getDataFromFeature("getdata(LPNId)")));
	 * ReceiveLPNLevel.enterScanItem(getDataFromFeature("getdata(ItemID_Line1)"));
	 * ReceiveLPNLevel.searchInventory(getDataFromFeature(getData("inventory_Line1")
	 * )); ReceiveLPNLevel.searchProductStatus(getDataFromFeature(getData(
	 * "ProductStatus_Line1")));
	 * ReceiveLPNLevel.searchCOOrigin(getDataFromFeature(getData("CoOrigin_Line1")))
	 * ;
	 * ReceiveLPNLevel.validateQtyError(getDataFromFeature(getData("OrdQty_Line1")),
	 * "No Error");
	 * ReceiveLPNLevel.enterLPN(ExcelUtil1.convert_variable_to_timestamp(
	 * getDataFromFeature("getdata(LPNId)")));
	 * ReceiveLPNLevel.enterScanItem(getDataFromFeature("getdata(ItemID_Line2)"));
	 * ReceiveLPNLevel.searchInventory(getDataFromFeature(getData("inventory_Line2")
	 * )); ReceiveLPNLevel.searchProductStatus(getDataFromFeature(getData(
	 * "ProductStatus_Line2")));
	 * ReceiveLPNLevel.searchCOOrigin(getDataFromFeature(getData("CoOrigin_Line2")))
	 * ;
	 * ReceiveLPNLevel.validateQtyError(getDataFromFeature(getData("OrdQty_Line2")),
	 * "RCV::177");
	 * ReceiveLPNLevel.enterLPN(ExcelUtil1.convert_variable_to_timestamp(
	 * getDataFromFeature("getdata(LPNId)")));
	 * ReceiveLPNLevel.enterScanItem(getDataFromFeature("getdata(ItemID_Line3)"));
	 * ReceiveLPNLevel.searchInventory(getDataFromFeature(getData("inventory_Line3")
	 * )); ReceiveLPNLevel.searchProductStatus(getDataFromFeature(getData(
	 * "ProductStatus_Line3")));
	 * ReceiveLPNLevel.searchCOOrigin(getDataFromFeature(getData("CoOrigin_Line3")))
	 * ;
	 * ReceiveLPNLevel.validateQtyError(getDataFromFeature(getData("OrdQty_Line3")),
	 * "RCV::175"); }
	 *
	 * @And("Validate Variance Warning Code") public void
	 * validateVarianceWarningCode() {
	 * PopupWrapper.validateVarianceWarningCode("RCV::237"); }
	 *
	 * @And("Validate item variances and lpn in ASN screen") public void
	 * validateItemVariancesAndLpnInASNScreen() {
	 * PopupWrapper.validateitemandlpnVariance();
	 *
	 * }
	 *
	 * @And("Complete ATStandardReceiving entering batch number") public void
	 * completeATStandardReceivingEnteringBatchNumber() {
	 * ReceiveLPNLevel.completeAtStandardReceivingWithBatch(); }
	 *
	 * @And("Validate batchNumber and ExpiryDate in LocationInventory") public void
	 * validateBatchNumberAndExpiryDateInLocationInventory() {
	 * ILPNs.searchinventory();
	 * ILPNs.ValidateBatchNumandASNExpiryDate(getDataFromFeature(
	 * "getdata(BatchNo_Line1)"), "null"); }
	 *
	 * @And("Validate batchNumber and ExpiryDate is displayed in LocationInventory")
	 * public void validateBatchNumberAndExpiryDateIsDisplayedInLocationInventory()
	 * { ILPNs.searchinventory();
	 * ILPNs.ValidateBatchNumandASNExpiryDate(getDataFromFeature(
	 * "getdata(BatchNo_Line1)"), getDataFromFeature(getData("ExpiryDate_Line1")));
	 * }
	 *
	 * @And("Navigate to Batch Master") public void navigateToBatchMaster() {
	 * HomePage.navigateToBatchMaster();
	 * BatchMasterPage.verifyBatchMasterPageDisplayed(); }
	 *
	 * @And("Store Batch Details to run time Variables") public void
	 * storeBatchDetailsToRunTimeVariables() { BatchMasterPage.storeBatchDetails();
	 * HomePage.navigateToInventoryDetails();
	 * InventoryDetailsPage.findBatchNumberWhoIsHavingValidItem(); }
	 *
	 * @And("Verify Held condition code has a value for the selected Batch Number")
	 * public void verifyHeldConditionCodeHasAValueForTheSelectedBatchNumber() {
	 * BatchMasterPage.verifyHeldConditionCodeHasAValueForTheSelectedBatchNumber();
	 * }
	 *
	 * @And("Click on Hold for the selected Batch Number") public void
	 * clickOnHoldForTheSelectedBatchNumber() {
	 * BatchMasterPage.clickMoreButtonAtRightSideForBatchNumber();
	 * BatchMasterPage.clickHoldButtonAtRightSideForBatchNumber();
	 * BatchMasterPage.clickYesButtonInHoldPopup(); }
	 *
	 * @And("Click on Release for the selected Batch Number") public void
	 * clickOnReleaseForTheSelectedBatchNumber() {
	 * LocationInventory.clickClearAllButton(); String batchNumber = (String)
	 * Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "BatchNumber");
	 * BatchMasterPage.searchBatchNumber(batchNumber);
	 * BatchMasterPage.clickCloseButtonAtRightSideForBatchNumber();
	 * BatchMasterPage.clickMoreButtonAtRightSideForBatchNumber();
	 * BatchMasterPage.clickReleaseButtonAtRightSideForBatchNumber();
	 * BatchMasterPage.clickYesButtonInHoldPopup(); }
	 *
	 * @And("Click on Recall for the selected Batch Number") public void
	 * clickOnRecallForTheSelectedBatchNumber() {
	 * BatchMasterPage.clickRecallButtonAtRightSideForBatchNumber();
	 * BatchMasterPage.clickYesButtonInHoldPopup(); }
	 *
	 * @Then("Verify that filtered results displayed with Held status also") public
	 * void verifyThatFilteredResultsDisplayedWithHeldStatusAlso() {
	 * BatchMasterPage.verifyAllBatchNumbersAreDisplayed(); }
	 *
	 * @And("Navigate to Inventory Details") public void
	 * navigateToInventoryDetails() { HomePage.navigateToInventoryDetails();
	 * InventoryDetailsPage.verifyInventoryDetailsPageDisplayed(); }
	 *
	 * @And("Filter by Batch Number details") public void
	 * filterByBatchNumberDetails() {
	 * InventoryDetailsPage.filterByBatchNumberDetails(); }
	 *
	 * @Then("Verify that all the entries in inventory is locked with the correct Held condition code"
	 * ) public void
	 * verifyThatAllTheEntriesInInventoryIsLockedWithTheCorrectHeldConditionCode() {
	 * InventoryDetailsPage.
	 * verifyThatAllTheEntriesInInventoryIsLockedWithTheCorrectHeldConditionCode();
	 * }
	 *
	 * @Then("Verify that all the entries in inventory has no condition code")
	 * public void verifyThatAllTheEntriesInInventoryHasNoConditionCode() {
	 * InventoryDetailsPage.verifyThatAllTheEntriesInInventoryHasNoConditionCode();
	 * }
	 *
	 * @And("Deselect byStatusReleasedCheckbox on BatchMasterPage") public void
	 * deselectByStatusReleasedCheckboxOnBatchMasterPage() {
	 * BatchMasterPage.unSelectStatusReleasedCheckbox(); }
	 *
	 * @And("Search itemfeild in BatchMaster") public void
	 * searchItemfeildInBatchMaster() {
	 * ASNs.searchitem(getDataFromFeature(getData("ItemID_Line1"))); }
	 *
	 * @And("Deselect byStatusHeldCheckbox on BatchMasterPage") public void
	 * deselectByStatusHeldCheckboxOnBatchMasterPage() {
	 * BatchMasterPage.unSelectStatusHeldCheckbox(); }
	 *
	 * @Then("Verify the task has been completed") public void
	 * verifyTheTaskHasBeenCompleted() { TasksPage.verifyTheTaskHasBeenCompleted();
	 * }
	 *
	 * @And("Navigate to Inventory Count") public void navigateToInventoryCount() {
	 * // SeleniumActions.switchToWindowUsingIndex(0);
	 * HomePage.navigateToInventoryCount(); }
	 *
	 * @And("Verify Item with batchnum and Expirationdate in BatchMaster") public
	 * void verifyItemWithBatchnumAndExpirationdateInBatchMaster() { }
	 */
//Duplicate declaration
	/*
	 * @And("Update ASN export file for cubisian") public void
	 * updateASNExportFileForCubisian() {
	 * ExcelUtil1.verifyFilePresentfromuserdir(CurrentThreadInstance.
	 * getCurrentScenarioName()+".xlsx"); String AsnIdValue =
	 * ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(ASN)"));
	 * Variables.set(CurrentThreadInstance.getCurrentScenarioId()+"ASN",AsnIdValue
	 * ); String strAsnIdValue = (String)
	 * Variables.get(CurrentThreadInstance.getCurrentScenarioId()+"ASN");
	 * ExcelUtil1.writeCellValueForColumnwoAppend(System.getProperty("user.dir") +
	 * "\\TestData\\Web_excelfiles\\", CurrentThreadInstance.getCurrentScenarioName()+"
	 * .xlsx","Asn","AsnId",strAsnIdValue);
	 * ExcelUtil1.writeCellValueForColumnwoAppend(System.getProperty("user.dir") +
	 * "\\TestData\\Web_excelfiles\\", CurrentThreadInstance.getCurrentScenarioName()+"
	 * .xlsx", "Asn", "AsnStatus","1000");
	 * ExcelUtil1.writeCellValueForColumnwoAppend(System.getProperty("user.dir") +
	 * "\\TestData\\Web_excelfiles\\", CurrentThreadInstance.getCurrentScenarioName()+"
	 * .xlsx", "AsnLine", "AsnId",strAsnIdValue);
	 * ExcelUtil1.deleteRowsfromSheet(System.getProperty("user.dir") +
	 * "\\TestData\\Web_excelfiles\\", CurrentThreadInstance.getCurrentScenarioName()+"
	 * .xlsx", "Lpn"); ExcelUtil1.deleteRowsfromSheet(System.getProperty("user.dir")
	 * +
	 * "\\TestData\\Web_excelfiles\\", CurrentThreadInstance.getCurrentScenarioName()+"
	 * .xlsx", "LpnDetail"); }
	 */
	// Duplicate declaration
	/*
	 * @And("Import Data Loader for ASN in testdata") public void
	 * importDataLoaderForASNInTestdata() {
	 * ASNs.selectFiletoImportfromtestdatadir(); }
	 */

	/*
	 * @And("Update ASN export file with batch number") public void
	 * updateASNExportFileWithBatchNumber() {
	 * ExcelUtil1.verifyFilePresentfromuserdir(CurrentThreadInstance.
	 * getCurrentScenarioName() + ".xlsx"); String AsnIdValue =
	 * ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(ASN)"));
	 * Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ASN",
	 * AsnIdValue); String strAsnIdValue = (String)
	 * Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN");
	 * ExcelUtil1.writeCellValueForColumnwoAppend(CurrentThreadInstance.
	 * getCurrentScenarioName() + ".xlsx", "Asn", "AsnId", strAsnIdValue);
	 * ExcelUtil1.writeCellValueForColumnwoAppend(CurrentThreadInstance.
	 * getCurrentScenarioName() + ".xlsx", "Asn", "AsnStatus", "1000");
	 * ExcelUtil1.writeCellValueForColumnboolean(CurrentThreadInstance.
	 * getCurrentScenarioName() + ".xlsx", "Asn", "VerificationAttempted", "FALSE");
	 * ExcelUtil1.writeCellValueForColumnwoAppend(CurrentThreadInstance.
	 * getCurrentScenarioName() + ".xlsx", "Asn", "ReceivedLpns", "0.000");
	 * ExcelUtil1.writeCellValueForColumnwoAppend(CurrentThreadInstance.
	 * getCurrentScenarioName() + ".xlsx", "AsnLine", "AsnId", strAsnIdValue);
	 * ExcelUtil1.writeCellValueForColumnwoAppend(CurrentThreadInstance.
	 * getCurrentScenarioName() + ".xlsx", "AsnLine", "BatchNumber",
	 * getDataFromFeature(getData("BatchNo_Line1")));
	 * ExcelUtil1.deleteRowsfromSheet(CurrentThreadInstance.getCurrentScenarioName()
	 * + ".xlsx", "Lpn");
	 * ExcelUtil1.deleteRowsfromSheet(CurrentThreadInstance.getCurrentScenarioName()
	 * + ".xlsx", "LpnDetail");
	 *
	 * }
	 *
	 * @Then("Verify the Count status as booked") public void
	 * verifyTheCountStatusAsBooked() {
	 * InventoryCountPage.verifyCountStatusAsBooked(); }
	 *
	 * @And("Verify the count details in Inventory Count details page") public void
	 * verifyTheCountDetailsInInventoryCountDetailsPage() {
	 * InventoryCountPage.clickCountRunId();
	 * InventoryCountDetailsPage.verifyTheCountDetailsInInventoryCountDetailsPage();
	 * }
	 *
	 * @Then("Verify that filtered results displayed with {string} status also")
	 * public void verifyThatFilteredResultsDisplayedWithStatusAlso(String status) {
	 * BatchMasterPage.verifyAllBatchNumbersAreDisplayed(); }
	 *
	 * @Then("Verify that selected Batch Number is removed from the {string} status list"
	 * ) public void verifyThatSelectedBatchNumberIsRemovedFromTheStatusList(String
	 * status) {
	 * BatchMasterPage.verifyThatSelectedBatchNumberIsRemovedInTheFilteredResults(
	 * status); }
	 *
	 * @Then("Verify that all the entries in inventory is locked with the correct condition codes"
	 * ) public void
	 * verifyThatAllTheEntriesInInventoryIsLockedWithTheCorrectConditionCodes() {
	 * InventoryDetailsPage.
	 * verifyThatAllTheEntriesInInventoryIsLockedWithTheCorrectConditionCodes(); }
	 *
	 * @And("Complete ATStandardReceiving for multiple product status") public void
	 * complete_at_standard_receiving_with_ItemId_And_product_status1() {
	 * ReceiveLPNLevel.searchASN(Variables.get(CurrentThreadInstance.
	 * getCurrentScenarioId() + "ASN").toString()); String strProductStatusCount =
	 * getDataFromFeature("getdata(ProductStatusCount)"); for (int i = 1; i <=
	 * Integer.parseInt(strProductStatusCount); i++) {
	 * ReceiveLPNLevel.enterLPN(null, 1);
	 * ReceiveLPNLevel.enterScanItem(getDataFromFeature("getdata(ItemID_Line" + i +
	 * ")")); ReceiveLPNLevel.enterInventoryItemId(null);
	 * ReceiveLPNLevel.enterProductStatus(getDataFromFeature(
	 * "getdata(ProductStatusId_Line" + i + ")"));
	 * ReceiveLPNLevel.enterQuantity(Integer.valueOf(getDataFromFeature(
	 * "getdata(OrdQty_Line" + i + ")"))); } }
	 *
	 * @And("Validate Product Status of each LPN") public void
	 * validate_product_status_of_each_LPN() { List<String> listOFiLPNs =
	 * (List<String>) Variables .get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "listOFiLPNs"); int i = 1; for (String iLpn : listOFiLPNs) {
	 * ILPNs.openSlideOption(iLpn); ILPNs.clickDetails();
	 * ILPNs.expandInventoryDetails();
	 * ILPNs.verifyProductStatus(getDataFromFeature("getdata(ProductStatusId_Line" +
	 * i + ")")); FrameworkLogger.log(LogType.PASS, "Product status of LPN " + iLpn
	 * + " is " + getDataFromFeature("getdata(ProductStatusId_Line" + i + ")"));
	 * ILPNs.closeILPN(); ILPNs.closeSlideOption(); i++; } }
	 *
	 * @And("Complete AT Pick To oLPN") public void complete_at_pick_to_o_lpn() {
	 * String strolpn = Variables.get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "taskoLPN").toString(); UserDirected.pickpackoLPN(strolpn);
	 * WMMobile.completeItemandQty(); SeleniumActions.switchToLastWindow();
	 * SeleniumActions.closeBrowser(); SeleniumActions.switchToLastWindow(); }
	 *
	 * @And("Store oLPN number in runtime variable") public void
	 * store_o_lpn_number_in_runtime_variable() { OrdersPage.copyoLPN(); }
	 *
	 * @And("Validate Task Details status {string}") public void
	 * validate_task_details_status(String strStatus) {
	 * TasksPage.verifyTaskDetailsStatus(strStatus); }
	 *
	 * @And("Complete Ship Confirm") public void complete_ship_confirm() {
	 * OrdersPage.verifyReceivingASN(); }
	 *
	 * @And("Update ASN export file for cubisian") public void
	 * updateASNExportFileForCubisian() {
	 * ExcelUtil1.verifyFilePresentfromuserdir(CurrentThreadInstance.
	 * getCurrentScenarioName() + ".xlsx"); String AsnIdValue =
	 * ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(ASN)"));
	 * Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ASN",
	 * AsnIdValue); String strAsnIdValue = (String)
	 * Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN");
	 * ExcelUtil1.writeCellValueForColumnwoAppend(CurrentThreadInstance.
	 * getCurrentScenarioName() + ".xlsx", "Asn", "AsnId", strAsnIdValue);
	 * ExcelUtil1.writeCellValueForColumnwoAppend(CurrentThreadInstance.
	 * getCurrentScenarioName() + ".xlsx", "Asn", "AsnStatus", "1000");
	 * ExcelUtil1.writeCellValueForColumnwoAppend(CurrentThreadInstance.
	 * getCurrentScenarioName() + ".xlsx", "AsnLine", "AsnId", strAsnIdValue);
	 * ExcelUtil1.deleteRowsfromSheet(CurrentThreadInstance.getCurrentScenarioName()
	 * + ".xlsx", "Lpn");
	 * ExcelUtil1.deleteRowsfromSheet(CurrentThreadInstance.getCurrentScenarioName()
	 * + ".xlsx", "LpnDetail");
	 *
	 * }
	 *
	 * @And("Complete ATStandardReceiving after error displayed") public void
	 * completeATStandardReceivingAfterErrorDisplayed() {
	 * ReceiveLPNLevel.searchASN(Variables.get(CurrentThreadInstance.
	 * getCurrentScenarioId() + "ASN").toString());
	 * ReceiveLPNLevel.enterLPN(ExcelUtil1.convert_variable_to_timestamp(
	 * getDataFromFeature("getdata(LPNId)")));
	 * ReceiveLPNLevel.enterScanItem(getDataFromFeature("getdata(ItemID_Line3)"));
	 * ReceiveLPNLevel.searchInventory(getDataFromFeature(getData("inventory_Line3")
	 * )); ReceiveLPNLevel.searchProductStatus(getDataFromFeature(getData(
	 * "ProductStatus_Line3")));
	 * ReceiveLPNLevel.searchCOOrigin(getDataFromFeature(getData("CoOrigin_Line3")))
	 * ;
	 * ReceiveLPNLevel.validateQtyError(getDataFromFeature(getData("OrdQty_Line4")),
	 * "RCV::143"); }
	 *
	 * @And("Update Business Unit {string} in WM Mobile") public void
	 * updateBusinessUnitGetdataBUIDInWMMobile(String strText) {
	 * HomePage.updateBusinessUnitInWMMobile(getDataFromFeature(strText)); }
	 *
	 * @And("Navigate to Inventory Management") public void
	 * navigateToInventoryManagement() { HomePage.navigateToInventoryManagement(); }
	 *
	 * @And("Create iLPN") public void createILPN() { CreateILPN.createILPN(); }
	 *
	 * @Then("Verify iLPN Inventory Details") public void
	 * verifyILPNInventoryDetails() { ILPNs.verifyILPNDetails(); }
	 *
	 * @And("Navigate to PutAway Planning Strategy Page") public void
	 * navigateToPutAwayPlanningStrategyPage() {
	 * HomePage.navigateToPutAwayPlanningStrategyPage();
	 * PutAwayPlanningStrategyPage.verifyPutAwayPlanningStrategyPage(); }
	 *
	 * @And("Click on View button for FNPutAwayPlanningStrategy Item") public void
	 * clickOnViewButtonForFNPutAwayPlanningStrategyItem() {
	 * PutAwayPlanningStrategyPage.clickCloseIconForFNPutAwayPlanningStrategy();
	 * PutAwayPlanningStrategyPage.clickViewButton(); }
	 *
	 * @And("Click on Continue button") public void clickOnContinueButton() {
	 * PutAwayPlanningStrategyPage.clickContinueButton(); }
	 */
	/*
	 * @And("Filter by Batch Number and Item ID") public void
	 * filterByBatchNumberAndItemID() {
	 * InventoryDetailsPage.searchBatchNumber(getDataFromFeature(
	 * "getdata(BatchNo_Line1)"));
	 * InventoryDetailsPage.searchItemId(getDataFromFeature("getdata(ItemID_Line1)")
	 * ); }
	 *
	 * @And("Verify Batch number is displayed in Released status") public void
	 * verifyBatchNumberInReleasedStatus() {
	 * BatchMasterPage.storeBatchNumberStatus(); }
	 *
	 * @And("Verify notification export Batch Master {string}") public void
	 * verifyNotificationExportBatchMaster(String string) { GeneralUtils.wait(1 *
	 * 1000); HomePage.openAlertNotification();
	 * NotificationPage.verifyNotificationMessage(string); }
	 *
	 * @And("Download Batch Master file") public void downloadBatchMasterFile() {
	 * ExcelUtil1.deleteExistingFile("BatchMaster.xlsx");
	 * NotificationPage.downloadBatchMasterfile(); HomePage.openAlertNotification();
	 * ExcelUtil1.verifyFilePresent("BatchMaster.xlsx"); }
	 *
	 * @And("Update Batch Master export file") public void
	 * updateBatchMasterExportFile() {
	 * ExcelUtil1.verifyFilePresent("BatchMaster.xlsx"); String BatchNumberId =
	 * ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature(
	 * "getdata(BatchMasterID)")); String ItemId =
	 * getDataFromFeature("getdata(ItemID_Line1)");
	 * Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ItemId",
	 * ItemId); ExcelUtil1.writeCellValueForColumn("BatchMaster.xlsx",
	 * "BatchMaster", "BatchNumberId", BatchNumberId);
	 * ExcelUtil1.writeCellValueForColumn1("BatchMaster.xlsx", "BatchMaster",
	 * "Status", getDataFromFeature("getdata(BatchMasterStatus)")); }
	 *
	 * @And("Create new Batch number if it doesnot exists") public void
	 * createNewBatchNumber() { if
	 * (Variables.get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "isBatchNumberFound").toString() == "false") {
	 * FrameworkLogger.log(LogType.INFO,
	 * "Batch Number doesn't exists, Need to create new Batch Number");
	 * BatchMasterPage.clickExportDataLoader();
	 * verifyNotificationExportBatchMaster("File BatchMaster.xlsx from BatchMaster is exported successfully."
	 * ); downloadBatchMasterFile(); updateBatchMasterExportFile();
	 * navigateToBatchMaster(); clear_notifications();
	 * close_alert_notification_window(); BatchMasterPage.clickImportDataLoader();
	 * BatchMasterPage.selectFiletoImport(); waitForPageLoading();
	 * verifyNotificationExportBatchMaster("File BatchMaster.xlsx from BatchMaster is imported successfully."
	 * ); close_alert_notification_window();
	 * InventoryDetailsPage.filterByBatchNumberDetails(); } else {
	 * FrameworkLogger.log(LogType.INFO, "Batch Number already exists"); } }
	 *
	 * @And("Filter by Location Details") public void filterByLocationDetails() {
	 * InventoryDetailsPage.minimizeFilterButton();
	 * InventoryDetailsPage.searchItemId(getDataFromFeature("getdata(ItemID_Line1)")
	 * ); InventoryDetailsPage.enterDisplayLocation(getDataFromFeature(
	 * "getdata(Display_Location)"));
	 * InventoryDetailsPage.filterInventoryContainerType(getDataFromFeature(
	 * "getdata(InventoryContainerType)"));
	 * InventoryDetailsPage.searchBatchNumber(getDataFromFeature(
	 * "getdata(BatchNo_Line1)")); }
	 *
	 * @And("Verify Inventory is Available for the Batch Number") public void
	 * verifyInventoryIsAvailable() { InventoryDetailsPage.storeInventoryDetails();
	 * }
	 *
	 * @And("Create new Inventory if it doesnot exists") public void
	 * createNewInventory() { if
	 * ((Variables.get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "isBatchNumberFound").toString() == "false") ||
	 * (Variables.get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "isInventoryPresent") .toString() == "false")) {
	 * FrameworkLogger.log(LogType.INFO,
	 * "Inventory is not present, Need to create new Inventory");
	 * HomePage.navigate_to_ASNs(); ASNs.verifyASNsPageDisplayed();
	 * ASNs.searchASN(getDataFromFeature("getdata(ASN)"));
	 *
	 * clear_notifications(); close_alert_notification_window();
	 * BatchMasterPage.clickExportDataLoader(); waitForPageLoading();
	 * verifyNotificationExportBatchMaster("File Asn.xlsx from Asn is exported successfully."
	 * ); download_asn_order(); if
	 * (Variables.get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "isBatchNumberFound") .toString() == "false") {
	 * update_asn_with_batchNumber_valid_item(
	 * Variables.get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "BatchNumber").toString()); } else {
	 * update_asn_with_batchNumber_valid_item(getDataFromFeature(
	 * "getdata(BatchNo_Line1)")); } HomePage.navigate_to_ASNs();
	 * clear_notifications(); close_alert_notification_window();
	 * BatchMasterPage.clickImportDataLoader(); ASNs.selectFiletoImport();
	 * waitForPageLoading();
	 * verifyNotificationExportBatchMaster("File ASN.xlsx from Asn is imported successfully."
	 * ); close_alert_notification_window(); searchASNinAsns();
	 * HomePage.navigate_to_wmmobile();
	 * searchMenuWmMobile(getDataFromFeature("getdata(WM_Receiving)"));
	 * complete_at_standard_receiving();
	 * WMMobile.searchMenu(getDataFromFeature("getdata(WM_PutAway)"));
	 * moveILPNFromDamageLocationToStorageLocation(); } else {
	 * FrameworkLogger.log(LogType.INFO, "Inventory already exists"); } }
	 *
	 * @And("Update ASN with BatchNumber and valid Item") public void
	 * update_asn_with_batchNumber_valid_item(String batchNumber) {
	 * ExcelUtil1.writeCellValueForColumn1("ASN.xlsx", "AsnLine", "BatchNumber",
	 * batchNumber); ExcelUtil1.writeCellValueForColumn1("ASN.xlsx", "AsnLine",
	 * "ItemId", getDataFromFeature("getdata(ItemID_Line1)")); String strAsnValue =
	 * ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(AsnId)")
	 * ); ExcelUtil1.writeCellValueForColumn("ASN.xlsx", "Asn", "AsnId",
	 * strAsnValue); ExcelUtil1.writeCellValueForColumn("ASN.xlsx", "AsnLine",
	 * "AsnId", strAsnValue); }
	 *
	 * @And("Filter Original Orders2 by Order ID") public void
	 * filter_original_orders2_Order_ID() {
	 * OriginalOrdersPage.filterOriginalOrder(getDataFromFeature(
	 * "getdata(Original_Order_ID)")); }
	 *
	 * @And("Verify Original Order is Available for the Inventory") public void
	 * verifyOriginalOrderIsAvailable() {
	 * OriginalOrdersPage.isOriginalOrderAvailable(getDataFromFeature(
	 * "getdata(Original_Order_ID)")); }
	 *
	 * @And("Verify Order specifies the Item and the Batch") public void
	 * verifyOrderHasItemAndBatch() { OriginalOrdersPage.selectDetailsInOrderLine();
	 * OriginalOrdersPage.expandOrderLineNeed();
	 * OriginalOrdersPage.orderHasItemAndBatchNumber(getDataFromFeature(
	 * "getdata(Original_Order_ID)")); }
	 *
	 * @And("Update Original Order with Batch Number") public void
	 * update_original_order_with_batch_number() {
	 * ExcelUtil1.verifyFilePresent("OriginalOrder.xlsx"); String strOrderValue =
	 * ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature(
	 * "getdata(OriginalOrderID)"));
	 * ExcelUtil1.writeCellValueForColumn("OriginalOrder.xlsx", "OriginalOrder",
	 * "OriginalOrderId", strOrderValue);
	 * ExcelUtil1.writeCellValueForColumn("OriginalOrder.xlsx", "OriginalOrderLine",
	 * "OriginalOrder.OriginalOrderId", strOrderValue);
	 * ExcelUtil1.writeCellValueForColumn1("OriginalOrder.xlsx",
	 * "OriginalOrderLine", "BatchNumber",
	 * getDataFromFeature("getdata(BatchNo_Line1)"));
	 * ExcelUtil1.writeCellValueForColumn1("OriginalOrder.xlsx",
	 * "OriginalOrderLine", "OrderedQuantity",
	 * getDataFromFeature("getdata(OrderedQuantity)")); }
	 *
	 * @And("Update Original Order with New Batch Number") public void
	 * update_original_order_with_new_batch_number() {
	 * ExcelUtil1.verifyFilePresent("OriginalOrder.xlsx"); String strOrderValue =
	 * ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature(
	 * "getdata(OriginalOrderID)"));
	 * ExcelUtil1.writeCellValueForColumn("OriginalOrder.xlsx", "OriginalOrder",
	 * "OriginalOrderId", strOrderValue);
	 * ExcelUtil1.writeCellValueForColumn("OriginalOrder.xlsx", "OriginalOrderLine",
	 * "OriginalOrder.OriginalOrderId", strOrderValue);
	 * ExcelUtil1.writeCellValueForColumn1("OriginalOrder.xlsx",
	 * "OriginalOrderLine", "BatchNumber",
	 * Variables.get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "BatchNumber").toString());
	 * ExcelUtil1.writeCellValueForColumn1("OriginalOrder.xlsx",
	 * "OriginalOrderLine", "OrderedQuantity",
	 * getDataFromFeature("getdata(OrderedQuantity)")); }
	 *
	 * @And("Create new Original Order if it doesnot exists") public void
	 * createNewOriginalOrder() { if
	 * ((Variables.get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "isOriginalOrderPresent") .toString() == "false") ||
	 * (Variables.get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "hasItemAndBatch") .toString() == "false") ||
	 * (Variables.get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "isBatchNumberFound") .toString() == "false")) {
	 * FrameworkLogger.log(LogType.INFO,
	 * "Order doesn't exists or meets criteria, Need to create new Original order");
	 * filter_original_orders2_Order_ID(); clear_notifications();
	 * close_alert_notification_window(); BatchMasterPage.clickExportDataLoader();
	 * waitForPageLoading();
	 * verifyNotificationExportBatchMaster("File OriginalOrder.xlsx from OriginalOrder is exported successfully."
	 * ); // download_original_order(); if
	 * (Variables.get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "isBatchNumberFound") .toString() == "false") {
	 * update_original_order_with_new_batch_number(); } else {
	 * update_original_order_with_batch_number(); } navigate_to_original_orders2();
	 * clear_notifications(); close_alert_notification_window();
	 * BatchMasterPage.clickImportDataLoader(); ExcelUtil1.selectFiletoImport(null);
	 * // Update Filename that need to be imported by removing null //
	 * OriginalOrdersPage.selectFiletoImport(); waitForPageLoading();
	 * verifyNotificationExportBatchMaster("File OriginalOrder.xlsx from OriginalOrder is imported successfully."
	 * ); close_alert_notification_window(); verify_imported_orders();
	 * Variables.set(CurrentThreadInstance.getCurrentScenarioId() +
	 * "NewOriginalOrderCreated", "true"); } else {
	 * FrameworkLogger.log(LogType.INFO, "Order already exists");
	 * filter_original_orders2_Order_ID(); } }
	 *
	 * @And("Execute RunWave from Original Orders") public void
	 * execute_run_wave_original_order() { OriginalOrdersPage.clickMoreActions();
	 * OriginalOrdersPage.executeRunWaveForOrder(); }
	 *
	 * @And("Verify wave Run specifies the Correct Quantity and the Batch") public
	 * void verifyWaveRunHasQuantityAndBatch() {
	 * WaveRunsPage.selectDetailsInOrderLine();
	 * WaveRunsPage.expandContainerOrQuantity();
	 * WaveRunsPage.checkContainerQuantity(); WaveRunsPage.expandItem();
	 * WaveRunsPage.AllocationHasItemAndBatchNumber();
	 * WaveRunsPage.closeAllocation(); }
	 *
	 * @And("Verify On Hand Quantity is UnChanged and Allocated Quantity is Changed"
	 * ) public void verifyOnHandQuantityAndAllocatedQuantity() {
	 * InventoryDetailsPage.storeOnHandAndAllocatedQuantityAfterWave();
	 * InventoryDetailsPage.verifyOnHandQuantityAfterWave();
	 * InventoryDetailsPage.verifyAllocatedQuantityAfterWave();
	 * CommonMethods.waitForPageLoading(); }
	 *
	 * @And("Unplan the Selected Wave") public void unplan_wave_from_wave_run() {
	 * WaveRunsPage.unplanWave(); }
	 *
	 * @And("Verify On Hand Quantity and Allocated Quantity After Cancel WaveRun")
	 * public void verifyInventoryQuantityAfterCancelWaveRun() {
	 * InventoryDetailsPage.storeOnHandAndAllocatedQuantityAfterWave();
	 * InventoryDetailsPage.verifyOnHandQuantityAfterWave();
	 * InventoryDetailsPage.verifyAllocatedQuantityAfterCancelWave(); }
	 *
	 * @And("Validate Original Orders status {string}") public void
	 * validate_original_orders_status(String strOrderStatus) { if
	 * (Variables.get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "NewOriginalOrderCreated") .toString() == "true") { strOrderStatus =
	 * Variables.get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "OriginalOrder").toString(); } OrdersPage.verifyOrderStatus(strOrderStatus);
	 * }
	 *
	 * @And("Navigate to Last window") public void navigateToLastWindow() {
	 * CommonMethods.waitForPageLoading(); SeleniumActions.switchToLastWindow();
	 * CommonMethods.waitForPageLoading(); }
	 *
	 * @And("Navigate window using index id {string}") public void
	 * navigateWindowUsingIndexId(String index) {
	 * CommonMethods.waitForPageLoading();
	 * SeleniumActions.switchToWindowUsingIndex(Integer.parseInt(index));
	 * CommonMethods.waitForPageLoading(); }
	 *
	 * @Then("Verify Rule details") public void verifyRuleDetails() {
	 * PutAwayPlanningStrategyPage.verifyRules(); }
	 */
	/*
	 * @Then("Verify Determination Mode") public void verifyDeterminationMode() {
	 * PutAwayPlanningStrategyPage.verifyDeterminationMode(); }
	 *
	 * @Then("Verify PutWay Zone as {string}") public void
	 * verifyPutWayZoneAsGetdataBUID(String text) {
	 * PutAwayPlanningStrategyPage.verifyPutAwayZone(getDataFromFeature(text)); }
	 *
	 * @And("Finish PutWay Zone process") public void finishPutWayZoneProcess() {
	 * PutAwayPlanningStrategyPage.clickFinishButton();
	 * PutAwayPlanningStrategyPage.clickFinishButton2();
	 * PutAwayPlanningStrategyPage.clickFinishButton3(); }
	 *
	 * @Then("Verify Location displayed as {string}") public void
	 * verifyLocationDisplayedAsGetdataLocation(String text) {
	 * StorageLocation.verifyLocationAtFirstIndex(getDataFromFeature(text)); }
	 *
	 * @Then("Verify ILPN Details in ILPN Page") public void
	 * verifyILPNDetailsInILPNPage() { String location = (String)
	 * Variables.get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "CurrentLocation"); location = location.replaceAll("-", "");
	 * ILPNs.verifyILPNStatusCodeAtFirstIndex(getDataFromFeature(getData(
	 * "StatusCode"))); ILPNs.verifyILPNCurrentLocationAtFirstIndex(location);
	 * ILPNs.verifyILPNCurrentLocationTypeAtFirstIndex(getDataFromFeature(getData(
	 * "CurrentLocationTypeId"))); }
	 *
	 * @And("Verify Product status and Inventory type in Inventory Details Page")
	 * public void verifyProductStatusAndInventoryTypeInInventoryDetailsPage() {
	 * HeaderPanelPage.clickRelatedLinksButton();
	 * HeaderPanelPage.clickInventoryDetailsLink();
	 * InventoryDetailsPage.verifyInventoryType();
	 * InventoryDetailsPage.verifyProductStatus(); }
	 *
	 * @And("Enter ILPN and Location in FN PutAway System Directed Page") public
	 * void enterILPNAndLocationInFNPutAwaySystemDirectedPage() {
	 * FNPutAwaySystemDirected.enterILPNAndLocationInFNPutAwaySystemDirectedPage();
	 * }
	 *
	 * @And("Search Put Allocation Zone with {string}") public void
	 * searchPutAllocationZoneWith(String text) {
	 * LeftPanelPage.searchPutAllocationZone(getDataFromFeature(text)); }
	 *
	 * @Then("Verify Batch number status as {string}") public void
	 * verifyBatchNumberStatusAs(String status) { if
	 * (status.equalsIgnoreCase("Released")) {
	 * BatchMasterPage.verifyBatchNumbersAreDisplayedWhichAreOnlyInReleasedStatus();
	 * } else if (status.equalsIgnoreCase("Held")) {
	 * BatchMasterPage.verifyBatchNumbersAreDisplayedWhichAreOnlyInHeldStatus(); } }
	 *
	 * @Then("Verify Batch numbers with all status") public void
	 * verifyBatchNumbersWithAllStatus() {
	 * BatchMasterPage.verifyAllBatchNumbersAreDisplayed(); }
	 */
	// Duplicate method
	/*
	 * @And("Complete ATStandardReceiving after error displayed") public void
	 * completeATStandardReceivingAfterErrorDisplayed() {
	 * ReceiveLPNLevel.searchASN(Variables.get(CurrentThreadInstance.
	 * getCurrentScenarioId()+"ASN").toString());
	 * ReceiveLPNLevel.enterLPN(ExcelUtil1.convert_variable_to_timestamp(
	 * getDataFromFeature("getdata(LPNId)")));
	 * ReceiveLPNLevel.enterScanItem(getDataFromFeature("getdata(ItemID_Line3)"));
	 * ReceiveLPNLevel.searchinventory(getDataFromFeature(getData("inventory_Line3")
	 * )); ReceiveLPNLevel.searchproductStatus(getDataFromFeature(getData(
	 * "ProductStatus_Line3")));
	 * ReceiveLPNLevel.searchCOOrigin(getDataFromFeature(getData("CoOrigin_Line3")))
	 * ;
	 * ReceiveLPNLevel.validateQtyError(getDataFromFeature(getData("OrdQty_Line4")),
	 * "RCV::143"); }
	 */

	/*
	 * @And("Search with Location Filter {string}") public void
	 * searchWithLocationFilterGetdataLocation(String text) {
	 * LocationInventory.searchLocation(getDataFromFeature(text)); }
	 *
	 * @And("Search with Item Filter {string}") public void
	 * searchWithItemFilterGetdataItem(String text) {
	 * LocationInventory.searchItem(getDataFromFeature(text));
	 *
	 * }
	 *
	 * @And("Store quantity to variable as String") public void
	 * storeQuantityToVariableAsString() {
	 *
	 * StorageLocation.storeOnHandQuantityToString(); }
	 *
	 * @Then("Verify OnhandQuantity stored to varaible") public void
	 * verifyOnhandQuantityStoredToVaraible() { String text = (String)
	 * Variables.get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "CurrentOnhandQuantity"); StorageLocation.verifyOnHandQuantityToString(text);
	 * }
	 *
	 * @And("Select Cycle count in WM Mobile") public void
	 * selectCycleCountInWMMobile() { WMMobile.CycleCount(); }
	 *
	 * @And("Store Batch number to varaiable") public void
	 * storeBatchNumberToVaraiable() { StorageLocation.storeBatchNumberToString(); }
	 *
	 * @Then("Verify batch number stored") public void verifyBatchNumberStored() {
	 * String text = (String)
	 * Variables.get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "CurrentBatchNumber"); StorageLocation.verifyBatchNumberToString(text); }
	 *
	 * @And("Scan Location in Cycle count {string}") public void
	 * scanLocationInCycleCount(String text) {
	 * LocationInventory.EnterLocation(getDataFromFeature(text)); }
	 *
	 * @And("Scan Item in Cycle count {string}") public void
	 * scanItemInCycleCount(String text) {
	 * LocationInventory.EnterItem(getDataFromFeature(text)); }
	 *
	 * @And("Enter Quantity details in cycle count screen") public void
	 * enterQuantityDetailsInCycleCountScreen() { String actualQuantity = (String)
	 * Variables .get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "CurrentOnhandQuantity"); int quantityValue =
	 * Integer.parseInt((actualQuantity).trim()); int quantityUpdated =
	 * quantityValue - 1; TasksPage.enterQuantity(String.valueOf(quantityUpdated));
	 * TasksPage.clickGoButton();
	 *
	 * }
	 *
	 * @And("Enter Batch Number in cycle count screen") public void
	 * enterBatchNumberInCycleCountScreen() { String text = (String)
	 * Variables.get(CurrentThreadInstance.getCurrentScenarioId() +
	 * "CurrentBatchNumber"); TasksPage.enterBatchNumber(text);
	 * TasksPage.clickGoButton();
	 *
	 * }
	 *
	 * @And("Click on Confirm in POPup") public void clickOnConfirmInPOPup() {
	 * InventoryDetailsPage.clickConfirmButton(); }
	 *
	 * @And("Click on End count") public void clickOnEndCount() {
	 * InventoryDetailsPage.clickEndCountButton(); }
	 *
	 * @And("Switch to last window") public void switchToLastWindow() {
	 * SeleniumActions.closeBrowser(); SeleniumActions.switchToLastWindow(); }
	 *
	 * @And("Search with Quick select filter") public void
	 * searchWithQuickSelectFilter() { InventoryCountPage.clickQuickSelect(); }
	 */

	/*
	 * @And("Create {string} iLPNs") public void createILPNs(String count) {
	 * CreateILPN.createILPNs(Integer.valueOf(getDataFromFeature(count))); }
	 *
	 * @And("Click on View button for {string} PutAway Priority") public void
	 * clickOnViewButtonForPutAwayPriority(String putAway) { if
	 * (putAway.equalsIgnoreCase("UNIT")) {
	 * PutAwayPlanningStrategyPage.clickCloseIconForUnitPutAwayPriorityItem(); }
	 * else if (putAway.equalsIgnoreCase("LPN")) {
	 * PutAwayPlanningStrategyPage.clickCloseIconForLPNPutAwayPriorityItem(); }
	 * PutAwayPlanningStrategyPage.clickViewButton2(); }
	 *
	 * @And("Click on Finish button") public void clickOnFinishButton() {
	 * PutAwayPlanningStrategyPage.clickFinishButton(); }
	 *
	 * @And("Create {string} iLPNs with Batch Number") public void
	 * createGetdataILPNCountILPNsWithBatchNumber(String count) {
	 * CreateILPN.createILPNsWithBachNumber(Integer.valueOf(getDataFromFeature(count
	 * ))); }
	 *
	 *
	 * @And("Create {string} iLPNs with Serial Number") public void
	 * createGetdataILPNCountILPNsWithSerialNumber(String count) {
	 * CreateILPN.createILPNsWithSerialNumber(Integer.valueOf(getDataFromFeature(
	 * count))); }
	 *
	 * @And("Create {string} iLPNs") public void createILPNs(String count) {
	 * CreateILPN.createILPNs(Integer.valueOf(getDataFromFeature(count))); }
	 *
	 * @And("Click on View button for {string} PutAway Priority") public void
	 * clickOnViewButtonForPutAwayPriority(String putAway) {
	 * if(putAway.equalsIgnoreCase("UNIT")){
	 * PutAwayPlanningStrategyPage.clickCloseIconForUnitPutAwayPriorityItem(); }else
	 * if(putAway.equalsIgnoreCase("LPN")){
	 * PutAwayPlanningStrategyPage.clickCloseIconForLPNPutAwayPriorityItem(); }
	 * PutAwayPlanningStrategyPage.clickViewButton2(); }
	 *
	 * @And("Click on Finish button") public void clickOnFinishButton() {
	 * PutAwayPlanningStrategyPage.clickFinishButton(); }
	 *
	 * @And("Create {string} iLPNs with Batch Number") public void
	 * createGetdataILPNCountILPNsWithBatchNumber(String count) {
	 * CreateILPN.createILPNsWithBachNumber(Integer.valueOf(getDataFromFeature(count
	 * ))); }
	 *
	 * @And("Create {string} iLPNs with Serial Number") public void
	 * createGetdataILPNCountILPNsWithSerialNumber(String count) {
	 * CreateILPN.createILPNsWithSerialNumber(Integer.valueOf(getDataFromFeature(
	 * count))); }
	 *
	 */
	private static final By byASNTextField = By.xpath("//input[@data-component-id='acceptasn_barcodetextfield_asn']");
	private static final By byScanILPNTextFiled = By
			.xpath("//input[@placeholder='Scan iLPN' or @placeholder='Scan LPN']");
	private static final By byScanItemTextField = By.xpath("//input[@placeholder='Scan Item']");
	private static final By byQuantityTextField = By
			.xpath("//input[contains(@data-component-id,'naturalquantityfield_unit')]");
	private static final By bySerialNumberTextField = By.xpath("//input[@placeholder='Serial Number']");
	private static final By byScanPalletTextField = By.xpath("//input[@placeholder='Scan Pallet']");
	private static final By byScanLocationTextFiled = By.xpath("//input[@placeholder='Scan Location']");
	private static final By byLocationField = By
			.xpath("//ion-col[contains(@data-component-id,'barcodetextfield_location')]");
	private static final By byExpectedContainerField = By
			.xpath("//ion-col[contains(@data-component-id,'barcodetextfield_expectedcontainer')]");
	private static final By byGoButton = By.xpath("//ion-button[contains(@data-component-id,'_go')]");
	private static final By byExpiryDate = By.xpath("//input[contains(@data-component-id,'_inputDate')]");
	private static final By byBatchNumberTextField = By.xpath("//input[contains(@data-component-id,'batchnumber')]");
	private static final By byScanContainerTextFiled = By.xpath("//input[@placeholder='Scan Container']");
	private static final By byInventoryTypeIdTextField = By
			.xpath("//input[contains(@data-component-id,'inventorytypeid')]");
	private static final By byProductStatusIdTextField = By
			.xpath("//input[contains(@data-component-id,'productstatusid')]");
	private static final By byCountryOfOriginTextField = By
			.xpath("//input[contains(@data-component-id,'countryoforigin')]");
	private static final By byVerifyASNButton = By.xpath("//span[text()='Verify ASN']");
	private static final By byReasonCodeTextField = By.xpath("//input[contains(@data-component-id,'reasoncode')]");
	private static final By byReferenceCodeTextField = By
			.xpath("//input[contains(@data-component-id,'referencecode')]");
	private static final By bySecondaryReferenceCodeTextField = By
			.xpath("//input[contains(@data-component-id,'secondaryreferencecode')]");
	private static final By byExitField = By.xpath("//ion-button[@data-component-id='action_exit_button']");

	private static final By byILPNSPage = By.xpath("//span[contains(text(),'ILPNs')]");
	private static final By byASNField = By.xpath("//ion-input[@data-component-id='AsnId']/input");
	private static final By byiLPNField = By.xpath("//ion-input[@data-component-id='IlpnId']/input");
	private static final By byExpandASNfield = By
			.xpath("//span[@title='ASN']/following-sibling::ion-button[@data-component-id='expand-button']");
	private static final By byExpandILPNfield = By
			.xpath("//span[@title='ILPN']/following-sibling::ion-button[@data-component-id='expand-button']");
	// private static final By byExpandInventoryitemsfield =
	// By.xpath("//span[text()='INVENTORY DETAILS']");
	private static final By byILPNSCard = By.xpath("//*[contains(text(),'ILPN :')]");
	private static final By byselectAllRowsBtn = By.xpath("//button[@data-component-id='selectAllRows']");
	private static final By byexportBtn = By.xpath("//button[@data-component-id='export']");
	private static final By byExportJobBtn = By.xpath("//ion-button[contains(text(),'Export Job')]");
	private static final By byCloseExportBtn = By.xpath("//button//ion-icon[@name='close']");
	private static final By byILPNS = By.xpath("//span[@data-component-id='IlpnId']");
	private static final By byDetailBtn = By.xpath("//ion-button[@data-component-id='Details']");
	private static final By byLocationInventryLink = By.xpath("//span[contains(text(),'Location inventory')]");
	private static final By byCurrentQuantityText = By.xpath("//*[contains(@data-component-id,'UNIT')]");
	private static final By byILPNIdAtFirstIndex = By
			.xpath("//span[contains(text(),'ILPN :')]//following-sibling::span[1]");
	private static final By byILPNQuantityAtFirstIndex = By
			.xpath("//span[contains(text(),\"ILPN's total quantity :\")]//following-sibling::span[1]");
	private static final By byILPNCurrentLocationAtFirstIndex = By
			.xpath("//span[contains(text(),'Current location :')]//following-sibling::span[1]");
	private static final By byILPNCurrentLocationTypeAtFirstIndex = By
			.xpath("//span[contains(text(),'Current location type :')]//following-sibling::span[1]");
	private static final By byILPNStatusCodeAtFirstIndex = By
			.xpath("//span[contains(text(),'LPN status code :')]//following-sibling::span[1]");
	private static final By byILPNPreviousLocationAtFirstIndex = By
			.xpath("//span[contains(text(),'Previous Location :')]//following-sibling::span[1]");
	private static final By byCurrentLocationTextField = By
			.xpath("//ion-input[@data-component-id='CurrentLocationId']//input");
	private static final By byExpandCurrentLocationField = By.xpath(
			"//span[@title='Current location']/following-sibling::ion-button[@data-component-id='expand-button']");
	private static final By byILPNStatusAtFirstIndex = By.xpath("//div[@data-component-id='IlpnStatusDescription']");
	private static final By byILPNPreviousDisplayLocationAtFirstIndex = By
			.xpath("//span[contains(text(),'Previous Display Location :')]//following-sibling::span[1]");
	private static final By byILPNTotalQuantityAtFirstIndex = By
			.xpath("//span[contains(text(),'total quantity :')]//following-sibling::span[1]");
	private static final By byParentLPNAtFirstIndex = By
			.xpath("//span[contains(text(),'Parent LPN :')]//following-sibling::span[1]");

	// private static final By byInventoryDetails =
	// By.xpath("//span[contains(text(),'INVENTORY DETAILS')]");
	// private static final By byProductStatus =
	// By.xpath("//span[contains(@data-component-id,'Productstatus')]");
	// private static final By byCloseInventoryDetails =
	// By.xpath("//button//ion-icon[@name='close']");
	// private static final By bySlideOptionDetailBtn =
	// By.xpath("//button[@data-component-id='Details']");
	// private static final By byCloseSlideOption =
	// By.xpath("//div[contains(@class,'slideOptionList')]/button[@data-component-id='action-open']");
	// private static final By byleftarrowbutton =
	// By.xpath("//div[contains(@class,'list-card-action-left-arrow')]");
	// private static final By byDetailBtnleftarrow =
	// By.xpath("//img[contains(@src,'Icon_Details.svg')]");
	// private static final By bylocationitemvalue =
	// By.xpath("//div[@class='datatable-body-cell-label']//div/a[@data-component-id='link']");
	private static final By byInventoryDetailsButton = By.xpath("//div[@data-component-id='Inventorydetails']//span");
	private static final By byProductStatusCellValue = By
			.xpath("(//div[contains(@class,'datatable-row-group')]//datatable-body-cell[4])/div/div");
	private static final By byInventoryTypeCellValue = By
			.xpath("(//div[contains(@class,'datatable-row-group')]//datatable-body-cell[5])/div/div");
	private static final By byRelatedLinks = By.xpath("//*[contains(text(),'Related Links')]");
	private static final By byInventoryDetailsLink = By.xpath("//*[text()='Inventory details']");
	private static final By byILPNStatusNotAllocatedCheckbox = By
			.xpath("//ion-checkbox[@data-component-id='NotAllocated']");
	private static final By byILPNListWithoutCurrentLocation = By
			.xpath("//span[contains(text(),'Current location :')]//following-sibling::span[@title='']");
	private static final By byILPNWithoutCurrentLocationAtFirstIndex = By.xpath(
			"(//span[contains(text(),'Current location :')]//following-sibling::span[@title=''])[1]//ancestor::div[2]//preceding-sibling::div[1]//div[3]//span[@data-component-id='IlpnId']");
	private static final By byItemsList = By.xpath("//a[@data-component-id='DisplayItem']");

//    private static final By byleftarrowbutton = By.xpath("//div[contains(@class,'list-card-action-left-arrow')]");
//    private static final By byDetailBtnleftarrow = By.xpath("//img[contains(@src,'Icon_Details.svg')]");
//    private static final By bylocationitemvalue = By.xpath("//div[@class='datatable-body-cell-label']//div/a[@data-component-id='link']");
//    locator which might need corrections in future
//    private static final By byILPNIdAtFirstIndex=By.xpath("(//span[contains(text(),'ILPN :')])[1]//following-sibling::span[1]");
//    private static final By byILPNQuantityAtFirstIndex=By.xpath("(//span[contains(text(),\"ILPN's total quantity :\")])[1]//following-sibling::span[1]");
//    private static final By byILPNCurrentLocationAtFirstIndex=By.xpath("(//span[contains(text(),'Current location :')])[1]//following-sibling::span[1]");
//    private static final By byILPNPreviousLocationAtFirstIndex=By.xpath("(//span[contains(text(),'Previous Location :')])[1]//following-sibling::span[1]");

	private static final By byLPNStatus = By.xpath("//ion-checkbox[@data-component-id='\" + strLPNStatus + \"']");

	private static final By byLPNItemId = By.xpath("//ion-input[@data-component-id='\" + strLPNItemID + \"']");

	private static final By byLPNCurrentLocation = By
			.xpath("//ion-checkbox[@data-component-id='\" + strLPNStatus + \"']");

	private static final By byExpandLPNStatusfield = By
			.xpath("//span[@title='LPN status']/following-sibling::ion-button[@data-component-id='expand-button']");

	private static final By byExpandItemfield = By
			.xpath("//span[@title='Item']/following-sibling::ion-button[@data-component-id='expand-button']");

	private static final By bySearchItemIDField = By.xpath("//ion-input[@data-component-id='ItemId']/input");

	private static final By byFirstILPNsCard = By.xpath(
			"(//div[@data-component-id='IlpnStatusDescription' and @title = 'Not Allocated'])[1]/ancestor::card-view//span[@data-component-id='IlpnTypeDescription']");

	private static final By byExpandILPNCurrentLocationfield = By.xpath(
			"//span[@title='Current location']/following-sibling::ion-button[@data-component-id='expand-button']");

	private static final By byCurrentDisplayLocationILPNCard = By
			.xpath("//span[@data-component-id='CurrentDisplayLocation']");

	private static final By byCurrentLocationCheckbox = By.xpath("//ion-col[@class='checkbox-container md hydrated']");

	private static final By byClearAllFilterBtn = By.xpath("//button[@data-component-id='clear-all-btn']");

	private static final By byParentLPNIdILPNsCard1 = By.xpath("(//span[@data-component-id='ParentLpnId'])[1]");
	private static final By byParentLPNIdILPNsCard2 = By.xpath("(//span[@data-component-id='ParentLpnId'])[2]");
	private static final By byParentLPNIdILPNsCard3 = By.xpath("(//span[@data-component-id='ParentLpnId'])[3]");

	private static final By bySlideILPNsCard1Btn = By
			.xpath("(//div[contains(@class,'list-card-action-left-arrow')])[1]");
	private static final By bySlideILPNsCard2Btn = By
			.xpath("(//div[contains(@class,'list-card-action-left-arrow')])[2]");
	private static final By bySlideILPNsCard3Btn = By
			.xpath("(//div[contains(@class,'list-card-action-left-arrow')])[3]");

	private static final By bySlideCardDetailsBtn = By.xpath("//button[@data-component-id='Details']");
	private static final By byExpandInventoryDetailsSection = By.xpath("//div[@data-component-id='Inventorydetails']");

	private static final By byInventoryDetails = By.xpath("//span[contains(text(),'INVENTORY DETAILS')]");
	private static final By byProductStatus = By.xpath("//span[contains(@data-component-id,'Productstatus')]");
	private static final By byCloseInventoryDetails = By.xpath("//button//ion-icon[@name='close']");
	private static final By bySlideOptionDetailBtn = By.xpath("//button[@data-component-id='Details']");
	private static final By byCloseSlideOption = By
			.xpath("//div[contains(@class,'slideOptionList')]/button[@data-component-id='action-open']");
	private static final By byleftarrowbutton = By.xpath("//div[contains(@class,'list-card-action-left-arrow')]");
	private static final By byDetailBtnleftarrow = By.xpath("//img[contains(@src,'Icon_Details.svg')]");
	private static final By bylocationitemvalue = By
			.xpath("//div[@class='datatable-body-cell-label']//div/a[@data-component-id='link']");
	private static final By byExpandInventoryitemsfield = By.xpath("//span[text()='INVENTORY DETAILS']");
	private static final By byfilterWithNotAllocated = By.xpath("//ion-checkbox[@data-component-id='NotAllocated']");

	private static final By byILPNS1 = By.xpath("(//span[@data-component-id='IlpnId'])[1]");
	private static final By byILPNS2 = By.xpath("(//span[@data-component-id='IlpnId'])[2]");
	private static final By byilpnstatusDescription = By.xpath("//div[@data-component-id='IlpnStatusDescription']");
	private static final By byRelatedlinksInventoryDetails = By.xpath("//a[contains(text(),'Inventory details')]");
	private static final By byNorecordsmsg = By.xpath("//ion-label[text()=' No Records found ']");

	public static void verifyPageDisplayed() {
		SeleniumActions.verifyElementVisible(byILPNSPage, 20, "ILPNs page");
	}

	public static void searchASN(String strText) {
		CommonMethods.waitForPageLoading();
		if (DriverManager.getDriver().findElements(byASNField).size() < 1) {
			SeleniumActions.click(byExpandASNfield, "Expand icon");
		}
		SeleniumActions.getElement(byASNField).clear();
		SeleniumActions.sendTextToElement(byASNField, strText, "ASN search field");
		CommonMethods.waitForPageLoading();
		KeyboardActions.pressEnterKey(byASNField);
		CommonMethods.waitForPageLoading();
	}

	public static void searchLPN(String strText) {
		CommonMethods.waitForPageLoading();
		if (DriverManager.getDriver().findElements(byiLPNField).size() < 1) {
			SeleniumActions.click(byExpandILPNfield, "Expand icon");
		}
		SeleniumActions.getElement(byiLPNField).clear();
		SeleniumActions.sendTextToElement(byiLPNField, strText, "LPN search field");
		CommonMethods.waitForPageLoading();
		KeyboardActions.pressEnterKey(byiLPNField);
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(By.xpath("//span[contains(text(),'" + strText + "')]"), "LPN Card");
	}

	public static void storeILPNsToList() {
		List<WebElement> listOfElements = DriverManager.getDriver().findElements(byILPNS);
		List<String> listOfILPNs = new ArrayList<>();
		for (WebElement element : listOfElements) {
			listOfILPNs.add(element.getText().trim());
		}
		System.out.println("iLPNS stored in variables:- " + listOfILPNs);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "listOFiLPNs", listOfILPNs);
	}

	public static void excelValidation() {
		List<String> listOfILPNs = (List<String>) Variables
				.get(CurrentThreadInstance.getCurrentScenarioId() + "listOFiLPNs");
		File fileLatestDownload = GeneralUtils
				.getLatestFilefromDir("C:\\Users\\" + GeneralUtils.getCurrentUser() + "\\Downloads", "ILpn.*.csv");
		List<String> listOfLPNsAtCSV = CommonMethods.getColumnValuesFromCsv(fileLatestDownload.getPath(), "ILPN");
		Collections.sort(listOfILPNs);
		Collections.sort(listOfLPNsAtCSV);
		if (listOfILPNs.equals(listOfLPNsAtCSV)) {
			System.out.println("LPNs are exported as expected!");
			FrameworkLogger.log(LogType.PASS, "LPNs are exported as expected!");
		} else {
			System.out
					.println("Exported LPNs " + listOfLPNsAtCSV + " are not matching with UI LPNs list " + listOfILPNs);
			FrameworkLogger.log(LogType.FAIL,
					"Exported LPNs " + listOfLPNsAtCSV + " are not matching with UI LPNs list " + listOfILPNs);
		}
	}

	/**
	 * Function to verify LPN Details displayed/visible in the screen
	 */
	public static void verifyLPNDetailsDisplayed() {
		CommonMethods.waitForPageLoading();
		By by = By.xpath("//span[contains(text(),'"
				+ Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "LPN" + 1).toString() + "')]");
		SeleniumActions.verifyElementVisible(by, 5, "LPN Details");
	}

	public static void navigateToLocationInventory() {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byDetailBtn, "Details Button");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byLocationInventryLink, "Location Inventory Link");
		CommonMethods.waitForPageLoading();
	}

	public static void validateCurrentQuantity() {
		CommonMethods.waitForPageLoading();
		String strCurrentQuantity = SeleniumActions.getText(byCurrentQuantityText);
		if (strCurrentQuantity != null && !strCurrentQuantity.trim().isEmpty()) {
			strCurrentQuantity.replace(" UNIT", "");
			if (strCurrentQuantity
					.equals(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "AdjustedValue").toString())) {
			}
			FrameworkLogger.log(LogType.PASS, "Current Quantity is " + strCurrentQuantity);
		} else {
			FrameworkLogger.log(LogType.FAIL, "Current Quantity is null or empty");
		}
	}

	public static void storeILPNIdAtFirstIndexToString() {
		WebElement element = DriverManager.getDriver().findElement(byILPNIdAtFirstIndex);
		String text = element.getText().trim();
		FrameworkLogger.log(LogType.INFO, "ILPN Id stored in variable:- " + text);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ILPNIdAtFirstIndex", text);
	}

	public static void storeILPNQuantityAtFirstIndexToString() {
		WebElement element = DriverManager.getDriver().findElement(byILPNQuantityAtFirstIndex);
		String text = element.getText().trim();
		FrameworkLogger.log(LogType.INFO, "ILPN Quantity stored in variable:- " + text);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ILPNQuantityAtFirstIndex", text);
	}

	public static void storeILPNCurrentLocationAtFirstIndexToString() {
		WebElement element = DriverManager.getDriver().findElement(byILPNCurrentLocationAtFirstIndex);
		String text = element.getText().trim();
		text = text.replaceAll("-", "");
		FrameworkLogger.log(LogType.INFO, "ILPN Current Location stored in variable:- " + text);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ILPNCurrentLocationAtFirstIndex", text);
	}

	/**
	 * Function to search Current location
	 * 
	 * @param strText - location value which need to be searched
	 */
	public static void searchCurrentLocation(String strText) {
		CommonMethods.waitForPageLoading();
		if (DriverManager.getDriver().findElements(byCurrentLocationTextField).size() < 1) {
			SeleniumActions.click(byExpandCurrentLocationField, "Expand icon");
		}
		SeleniumActions.sendTextToElement(byCurrentLocationTextField, strText, "Current Location Text field");
		CommonMethods.waitForPageLoading();
		KeyboardActions.pressEnterKey(byCurrentLocationTextField);
		CommonMethods.waitForPageLoading();

	}

	/**
	 * Function to search iLPN
	 *
	 * @param strText - lpn value which need to be searched
	 */
	public static void searchLPNID(String strText) {
		CommonMethods.waitForPageLoading();
		if (DriverManager.getDriver().findElements(byiLPNField).size() < 1) {
			SeleniumActions.click(byExpandILPNfield, "Expand icon");
		}
		SeleniumActions.getElement(byiLPNField).clear();
		SeleniumActions.sendTextToElement(byiLPNField, strText, "LPN search field");
		CommonMethods.waitForPageLoading();
		KeyboardActions.pressEnterKey(byiLPNField);
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to verify iLPN at first index
	 * 
	 * @param iLPN - value which need to be verified
	 */
	public static void verifyILPNAtFirstIndex(String iLPN) {
		String actualILPN = SeleniumActions.getAtrribute(byILPNIdAtFirstIndex, "title", 20);
		actualILPN = actualILPN.trim();
		if (iLPN.equals(actualILPN)) {
			FrameworkLogger.log(LogType.PASS, "iLPN Verification passed : " + iLPN);
		} else {
			FrameworkLogger.log(LogType.FAIL,
					"iLPN Verification failed. Expected : " + iLPN + " , Actual :" + actualILPN);
		}
	}

	/**
	 * Function to verify quantity at first index
	 * 
	 * @param quantity - value which need to be verified
	 */
	public static void verifyILPNQuantityAtFirstIndex(String quantity) {
		String actualQuantity = SeleniumActions.getAtrribute(byILPNQuantityAtFirstIndex, "title", 20);
		actualQuantity = actualQuantity.trim();
		if (quantity.equals(actualQuantity)) {
			FrameworkLogger.log(LogType.PASS, "Quantity Verification passed : " + quantity);
		} else {
			FrameworkLogger.log(LogType.FAIL,
					"Quantity Verification failed. Expected : " + quantity + " , Actual :" + actualQuantity);
		}
	}

	/**
	 * Function to verify current location at first index
	 * 
	 * @param location - value which need to be verified
	 */
	public static void verifyILPNCurrentLocationAtFirstIndex(String location) {
		// String actualLocation =
		// SeleniumActions.getAtrribute(byILPNCurrentLocationAtFirstIndex, "title", 20);
		String actualLocation = DriverManager.getDriver().findElement(byILPNCurrentLocationAtFirstIndex).getText();
		actualLocation = actualLocation.replaceAll("-", "");
		if (location.equals(actualLocation)) {
			FrameworkLogger.log(LogType.PASS, "Current Location Verification passed : " + location);
		} else {
			FrameworkLogger.log(LogType.FAIL,
					"Current Location Verification failed. Expected :" + location + " , Actual :" + actualLocation);
		}
	}

	/**
	 * Function to verify previous location at first index
	 * 
	 * @param location - value which need to be verified
	 */
	public static void verifyILPNPreviousLocationAtFirstIndex(String location) {
		// String actualLocation =
		// SeleniumActions.getAtrribute(byILPNPreviousLocationAtFirstIndex, "title",
		// 20);
		String actualLocation = DriverManager.getDriver().findElement(byILPNPreviousLocationAtFirstIndex).getText();
		actualLocation = actualLocation.replaceAll("-", "");
		if (location.equals(actualLocation)) {
			FrameworkLogger.log(LogType.PASS, "Previous Location Verification passed : " + location);
		} else {
			FrameworkLogger.log(LogType.FAIL,
					"Previous Location Verification failed. Expected :" + location + " , Actual :" + actualLocation);
		}
	}

	/**
	 * Function to open slide options in ILPN Page
	 */
	public static void openSlideOption(String strILpn) {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(
				By.xpath("(//span[contains(text(),'" + strILpn + "')]//following::slider-actions)[1]//button"),
				"Open Slide Option of " + strILpn);
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
	 * Function to click Details in ILPN Slide Screen
	 */
	public static void clickDetails() {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(bySlideOptionDetailBtn, "Details Button");
	}

	/**
	 * Function to expand Inventory Details
	 */
	/*
	 * public static void expandInventoryDetails() {
	 * CommonMethods.waitForPageLoading();
	 * CommonMethods.scrollByParticularElement(byInventoryDetails,
	 * "Inventory Details"); SeleniumActions.click(byInventoryDetails,
	 * "Inventory Details"); CommonMethods.waitForPageLoading(); }
	 */
	/**
	 * Function to verify Product Status in Inventory Details
	 * 
	 * @param strProductStatus - Product status that needs to be verified
	 */
	/*
	 * public static void verifyProductStatus(String strProductStatus) { String
	 * strExpectedProductStatus = getProductStatusDescription(strProductStatus);
	 * CommonMethods.waitForPageLoading(); if
	 * (!SeleniumActions.getText(By.xpath("//div[contains(@data-component-id,'" +
	 * strExpectedProductStatus + "')]")) .isEmpty()) {
	 * FrameworkLogger.log(LogType.PASS, "Expected Product status " +
	 * strExpectedProductStatus + " is displayed"); } else {
	 * FrameworkLogger.log(LogType.FAIL, "Expected Product status " +
	 * strExpectedProductStatus + " is not displayed"); } }
	 */
	/**
	 * Function for each product description
	 */
	/*
	 * public static String getProductStatusDescription(String strProductStatus) {
	 * // remaining product statuses to be added based on the usage in test case
	 * String strProductDescription; char strChar; strChar =
	 * strProductStatus.charAt(0); switch (String.valueOf(strChar).toUpperCase()) {
	 * case "A": strProductDescription = "Available"; break; case "D":
	 * strProductDescription = "Damaged"; break; case "E": strProductDescription =
	 * "Expired"; break; case "H": strProductDescription = "On Hold"; break; case
	 * "I": strProductDescription = "Inspection"; break; case "R":
	 * strProductDescription = "Return"; break; default: throw new
	 * IllegalArgumentException("Product Status NOT supported"); } return
	 * strProductDescription; }
	 */
	/**
	 * Function to capture LPN value from ILPNS screen
	 */

	/*
	 * public static void captureILPNSNumber() { String strILPNS =
	 * SeleniumActions.getText(byILPNS); if (strILPNS != null &&
	 * !strILPNS.trim().isEmpty()) {
	 * Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN",
	 * strILPNS.replace("LPN ID: ", "")); } else { FrameworkLogger.log(LogType.FAIL,
	 * "LPN is null or empty"); } }
	 * 
	 * public static void filterLPNByStatus(String strText) { String strLPNStatus =
	 * strText; // String strLPNId; CommonMethods.waitForPageLoading();
	 * SeleniumActions.click(By.xpath("//ion-checkbox[@data-component-id='" +
	 * strLPNStatus + "']"), "ILPN Status"); // CommonMethods.waitForPageLoading();
	 * /* strLPNId = SeleniumActions.getText(byFirstLPNId);
	 * CommonMethods.waitForPageLoading();
	 */
	/*
	 * }
	 * 
	 * public static void filterLPNByItem(String strText) { String strLPNItemId =
	 * strText; if
	 * (DriverManager.getDriver().findElements(bySearchItemIDField).size() < 1) {
	 * SeleniumActions.click(byExpandItemfield, "Expand icon"); }
	 * SeleniumActions.getElement(bySearchItemIDField).clear();
	 * SeleniumActions.sendTextToElement(bySearchItemIDField, strLPNItemId,
	 * "LPN Item ID search field"); CommonMethods.waitForPageLoading();
	 * KeyboardActions.pressEnterKey(bySearchItemIDField);
	 * CommonMethods.waitForPageLoading(); SeleniumActions.click(byFirstILPNsCard,
	 * "ILPNS First Card"); }
	 * 
	 * public static void filterLPNByLPNValue(String strText) { String strILPNS =
	 * SeleniumActions.getText(byILPNS);
	 * 
	 * // CommonMethods.waitForPageLoading(); /* if
	 * (DriverManager.getDriver().findElements(byiLPNField).size() < 1) {
	 * SeleniumActions.click(byExpandItemfield, "Expand icon"); }
	 */
	/*
	 * CommonMethods.waitForPageLoading(); if (strILPNS != null &&
	 * !strILPNS.trim().isEmpty()) {
	 * Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN",
	 * strILPNS.replace("LPN ID: ", "")); } else { FrameworkLogger.log(LogType.FAIL,
	 * "LPN is null or empty"); } SeleniumActions.getElement(byiLPNField).clear();
	 * SeleniumActions.sendTextToElement(byiLPNField, strILPNS, "LPN search field");
	 * KeyboardActions.pressEnterKey(byiLPNField); //
	 * CommonMethods.waitForPageLoading(); }
	 */
	/**
	 * Function to verify ILPNs Current Display Location
	 * 
	 * @param strExpected - LPNs Current Display Location that need to be verified
	 */
	/*
	 * public static void verifyILPNsCurrentDisplayLocation(String strExpected) {
	 * String strStatus = getILPNsCurrentDisplayLocation(); if
	 * (!strStatus.isEmpty()) { SeleniumActions.verifyTextEquals(strStatus,
	 * strExpected); } }
	 * 
	 * public static String getILPNsCurrentDisplayLocation() { String
	 * strILPNsCurrentLocationDisplay =
	 * SeleniumActions.getText(byCurrentDisplayLocationILPNCard); if
	 * (strILPNsCurrentLocationDisplay != null &&
	 * !strILPNsCurrentLocationDisplay.trim().isEmpty()) { return
	 * strILPNsCurrentLocationDisplay.trim(); } else {
	 * FrameworkLogger.log(LogType.FAIL,
	 * "Current Display Location is null or empty"); } return ""; }
	 * 
	 * public static void filterLPNCurrentLocationIsNull() { if
	 * (DriverManager.getDriver().findElements(byCurrentLocationCheckbox).size() <
	 * 1) { SeleniumActions.click(byExpandILPNCurrentLocationfield, "Expand icon");
	 * } SeleniumActions.checkSingleCheckbox(byCurrentLocationCheckbox,
	 * "Checked Current Location is Null");
	 * 
	 * }
	 * 
	 * public static void clearFilterMenuILPNs() {
	 * CommonMethods.waitForPageLoading();
	 * SeleniumActions.click(byClearAllFilterBtn,
	 * "Clear all filtered in ILPNS menu");
	 * 
	 * }
	 */
	/**
	 * Function to verify Parent LPN for multiple card
	 */
	/*
	 * public static void validateParentLPNinILPNs() {
	 * CommonMethods.waitForPageLoading(); String strParentLpnIdCard1 =
	 * SeleniumActions.getText(byParentLPNIdILPNsCard1);
	 * Variables.set(CurrentThreadInstance.getCurrentScenarioId() +
	 * "ParentLpnIdCard1", strParentLpnIdCard1); String strParentLpnIdCard2 =
	 * SeleniumActions.getText(byParentLPNIdILPNsCard2);
	 * Variables.set(CurrentThreadInstance.getCurrentScenarioId() +
	 * "ParentLpnIdCard2", strParentLpnIdCard2); String strParentLpnIdCard3 =
	 * SeleniumActions.getText(byParentLPNIdILPNsCard3);
	 * Variables.set(CurrentThreadInstance.getCurrentScenarioId() +
	 * "ParentLpnIdCard3", strParentLpnIdCard3);
	 * 
	 * /* if (strParentLpnIdCard1 == strParentLpnIdCard2) {
	 * FrameworkLogger.log(LogType.PASS, "Both Parent LPN is "+strParentLpnIdCard1);
	 * } else { FrameworkLogger.log(LogType.FAIL,
	 * "Both Parent LPN is different from Parent LPN 1 and Parent LPN 2"); }
	 * 
	 * if (strParentLpnIdCard2 != strParentLpnIdCard3) {
	 * FrameworkLogger.log(LogType.PASS, "Parent LPN 3 is "+strParentLpnIdCard3); }
	 * else { FrameworkLogger.log(LogType.FAIL,
	 * "Both Parent LPN is having same Parent LPN"); }
	 */

	/*
	 * if(strParentLpnIdCard1!=null&&!strParentLpnIdCard1.trim().isEmpty())
	 * 
	 * { if (strParentLpnIdCard1.equalsIgnoreCase(strParentLpnIdCard2)) {
	 * FrameworkLogger.log(LogType.PASS, "Parent LPN Id : " + strParentLpnIdCard1);
	 * } else { FrameworkLogger.log(LogType.FAIL,
	 * "Parent LPN Id is different, Actual : " + strParentLpnIdCard1 + "Expected : "
	 * + strParentLpnIdCard2); } }else { FrameworkLogger.log(LogType.FAIL,
	 * "Parent LPN Id is null or empty");
	 * 
	 * }
	 * 
	 * if(strParentLpnIdCard3!=null&&!strParentLpnIdCard3.trim().isEmpty()) { if
	 * (strParentLpnIdCard3.equalsIgnoreCase(strParentLpnIdCard2)) {
	 * FrameworkLogger.log(LogType.FAIL, "Parent LPN Id is same, Actual : " +
	 * strParentLpnIdCard3 + "Expected : " + strParentLpnIdCard2); } else {
	 * FrameworkLogger.log(LogType.PASS, "Parent LPN Id : " + strParentLpnIdCard3);
	 * } }else { FrameworkLogger.log(LogType.FAIL,
	 * "Parent LPN Id is null or empty");
	 * 
	 * }
	 * 
	 * }
	 */
	/**
	 * Function to Validate variance message
	 * 
	 * @param strMsg - variance message
	 */
	/*
	 * public static void validateVarianceMessage(String strMsg) { String
	 * strAlertmessage = SeleniumActions.getText(byVarianceText); if
	 * (strAlertmessage != null && !strAlertmessage.trim().isEmpty()) { if
	 * (strAlertmessage.equalsIgnoreCase(strMsg)) {
	 * FrameworkLogger.log(LogType.PASS, "Variance message " + strAlertmessage );
	 * SeleniumActions.click(byVarianceAcceptButton, "Accept button");
	 * CommonMethods.waitForPageLoading(); } else {
	 * FrameworkLogger.log(LogType.FAIL, "Variance message is different, Actual : "+
	 * strAlertmessage + "Expected : " +strMsg); } }else {
	 * FrameworkLogger.log(LogType.FAIL, "Variance message is null or empty");
	 * 
	 * } }
	 */

	/**
	 * Function to verify LPN Inventory card is opening the details.
	 */
	/*
	 * public static void verifyInventoryDetailCard1() {
	 * SeleniumActions.click(bySlideILPNsCard1Btn,
	 * "Slide button card 1 is clicked");
	 * SeleniumActions.click(bySlideCardDetailsBtn, "Details button is clicked");
	 * SeleniumActions.click(byExpandInventoryDetailsSection,
	 * "Expand Inventory Details"); CommonMethods.waitForPageLoading();
	 * 
	 * }
	 */
	/**
	 * Function to verify LPN Inventory card is opening the details.
	 */
	/*
	 * public static void verifyInventoryDetailCard2() {
	 * SeleniumActions.click(bySlideILPNsCard2Btn,
	 * "Slide button card 2 is clicked");
	 * SeleniumActions.click(bySlideCardDetailsBtn, "Details button is clicked");
	 * SeleniumActions.click(byExpandInventoryDetailsSection,
	 * "Expand Inventory Details"); CommonMethods.waitForPageLoading();
	 * 
	 * }
	 */
	/**
	 * Function to verify LPN Inventory card is opening the details.
	 */
	/*
	 * public static void verifyInventoryDetailCard3() {
	 * SeleniumActions.click(bySlideILPNsCard3Btn,
	 * "Slide button card 3 is clicked");
	 * SeleniumActions.click(bySlideCardDetailsBtn, "Details button is clicked");
	 * SeleniumActions.click(byExpandInventoryDetailsSection,
	 * "Expand Inventory Details"); CommonMethods.waitForPageLoading();
	 * 
	 * }
	 * 
	 * public static void validateBatchNumberInLPNInventoryTable(String BatchNo) {
	 * SeleniumActions.verifyElementExist(bylocationitemvalue, 5,
	 * "Item Value should be displayed"); By by =
	 * By.xpath("(//datatable-header-cell[@role='columnheader'])"); List<WebElement>
	 * header = DriverManager.getDriver().findElements(by); int i = header.size();
	 * for (i = 2; i >= 0 && i <= 26; i++) { WebElement ele =
	 * DriverManager.getDriver()
	 * .findElement(By.xpath("(//datatable-header-cell[@role='columnheader'])[" + i
	 * + "]")); if
	 * (ele.getAttribute("title").trim().equalsIgnoreCase("Batch number")) {
	 * WebElement ele1 = DriverManager.getDriver()
	 * .findElement(By.xpath("(//div[@class='datatable-body-cell-label']//div)[" + i
	 * + "-1]")); if (ele1.getText().trim().equals(BatchNo)) {
	 * FrameworkLogger.log(LogType.PASS, "Batch Number displayed as expected " +
	 * ele1 + "," + BatchNo); } else { FrameworkLogger.log(LogType.FAIL,
	 * "Batch Number NOT displayed" + ele1 + "," + BatchNo); } } }
	 * 
	 * }
	 * 
	 * public static void validateExpiryDateInLPNInventoryTable(String
	 * ExpirationDate) { SeleniumActions.verifyElementExist(bylocationitemvalue, 5,
	 * "Item Value should be displayed"); By by =
	 * By.xpath("(//datatable-header-cell[@role='columnheader'])"); List<WebElement>
	 * header = DriverManager.getDriver().findElements(by); int i = header.size();
	 * for (i = 2; i >= 0 && i <= 26; i++) { WebElement ele =
	 * DriverManager.getDriver()
	 * .findElement(By.xpath("(//datatable-header-cell[@role='columnheader'])[" + i
	 * + "]")); if
	 * (ele.getAttribute("title").trim().equalsIgnoreCase("Expiration date")) {
	 * WebElement ele2 = DriverManager.getDriver()
	 * .findElement(By.xpath("(//div[@class='datatable-body-cell-label']//div)[" + i
	 * + "-1]")); if (ele2.getText().trim().equals(ExpirationDate)) {
	 * FrameworkLogger.log(LogType.PASS, "Expiry date is not null"); } else {
	 * FrameworkLogger.log(LogType.FAIL, "Expiry date is null"); } } } }
	 * 
	 * public static void validateOnHandQuantityAndInventoryContainer(String
	 * OnHandQty, String InventoryContainer) {
	 * SeleniumActions.verifyElementExist(bylocationitemvalue, 5,
	 * "Item Value should be displayed"); By by =
	 * By.xpath("(//datatable-header-cell[@role='columnheader'])"); List<WebElement>
	 * header = DriverManager.getDriver().findElements(by); int i = header.size();
	 * for (i = 2; i >= 0 && i <= 26; i++) { WebElement ele =
	 * DriverManager.getDriver()
	 * .findElement(By.xpath("(//datatable-header-cell[@role='columnheader'])[" + i
	 * + "]")); if
	 * (ele.getAttribute("title").trim().equalsIgnoreCase("On hand quantity (Units)"
	 * )) { WebElement ele1 = DriverManager.getDriver()
	 * .findElement(By.xpath("(//div[@class='datatable-body-cell-label']//div)[" + i
	 * + "-1]")); if (ele1.getText().trim().equals(OnHandQty)) {
	 * FrameworkLogger.log(LogType.PASS, "On hand quantity displayed"); } else {
	 * FrameworkLogger.log(LogType.FAIL, "On hand quantity NOT displayed"); } } if
	 * (ele.getAttribute("title").trim().equalsIgnoreCase("Inventory container")) {
	 * WebElement ele2 = DriverManager.getDriver()
	 * .findElement(By.xpath("(//div[@class='datatable-body-cell-label']//div)[" + i
	 * + "-1]")); if (ele2.getText().trim().equals(InventoryContainer)) {
	 * FrameworkLogger.log(LogType.PASS, "Inventory container is not null"); } else
	 * { FrameworkLogger.log(LogType.FAIL, "Inventory container is null"); } } } }
	 * 
	 * public static void
	 * ValidateProductStatus_InventoryTypeAndCountryOfOrigin(String ProductStatus,
	 * String InventoryType, String CountryOfOrigin) {
	 * SeleniumActions.verifyElementExist(bylocationitemvalue, 5,
	 * "Item Value should be displayed"); By by =
	 * By.xpath("(//datatable-header-cell[@role='columnheader'])"); List<WebElement>
	 * header = DriverManager.getDriver().findElements(by); int i = header.size();
	 * for (i = 2; i >= 0 && i <= 26; i++) { WebElement ele =
	 * DriverManager.getDriver()
	 * .findElement(By.xpath("(//datatable-header-cell[@role='columnheader'])[" + i
	 * + "]")); if
	 * (ele.getAttribute("title").trim().equalsIgnoreCase("Product status")) {
	 * WebElement ele1 = DriverManager.getDriver()
	 * .findElement(By.xpath("(//div[@class='datatable-body-cell-label']//div)[" + i
	 * + "-1]")); if (ele1.getText().trim().equals(ProductStatus)) {
	 * FrameworkLogger.log(LogType.PASS, "Product status displayed"); } else {
	 * FrameworkLogger.log(LogType.FAIL, "Product status NOT displayed"); } } if
	 * (ele.getAttribute("title").trim().equalsIgnoreCase("Inventory type")) {
	 * WebElement ele2 = DriverManager.getDriver()
	 * .findElement(By.xpath("(//div[@class='datatable-body-cell-label']//div)[" + i
	 * + "-1]")); if (ele2.getText().trim().equals(InventoryType)) {
	 * FrameworkLogger.log(LogType.PASS, "Inventory type is displayed"); } else {
	 * FrameworkLogger.log(LogType.FAIL, "Inventory type is NOT displayed"); } } if
	 * (ele.getAttribute("title").trim().equalsIgnoreCase("Country of origin")) {
	 * WebElement ele3 = DriverManager.getDriver()
	 * .findElement(By.xpath("(//div[@class='datatable-body-cell-label']//div)[" + i
	 * + "-1]")); if (ele3.getText().trim().equals(CountryOfOrigin)) {
	 * FrameworkLogger.log(LogType.PASS, "COO is displayed"); } else {
	 * FrameworkLogger.log(LogType.FAIL, "COO is NOT displayed"); } } } }
	 */
	/**
	 * Function to close ILPN screen
	 */
	/*
	 * public static void closeILPN() {
	 * SeleniumActions.click(byCloseInventoryDetails, "Close Inventory Details");
	 * CommonMethods.waitForPageLoading(); }
	 */
	/**
	 * Function to validate batch number and Expiry date in Location Inventory
	 * screen
	 */
	/*
	 * public static void validateBatchNumandASNExpiryDate(String batchNo, String
	 * expiryDate) { SeleniumActions.verifyElementExist(bylocationitemvalue, 5,
	 * "Item Value shouldbe displayed"); By by =
	 * By.xpath("(//datatable-header-cell[@role='columnheader'])"); List<WebElement>
	 * header = DriverManager.getDriver().findElements(by); int i = header.size();
	 * for (i = 2; i >= 0 && i <= 15; i++) { WebElement ele =
	 * DriverManager.getDriver()
	 * .findElement(By.xpath("(//datatable-header-cell[@role='columnheader'])[" + i
	 * + "]")); if
	 * (ele.getAttribute("title").trim().equalsIgnoreCase("Batch number")) {
	 * WebElement ele1 = DriverManager.getDriver()
	 * .findElement(By.xpath("(//div[@class='datatable-body-cell-label']//div)[" + i
	 * + "-1]")); if (ele1.getText().trim().equals(batchNo)) {
	 * FrameworkLogger.log(LogType.PASS, "Batch Number displayed as expected" + ele1
	 * + "," + batchNo); } else { FrameworkLogger.log(LogType.FAIL,
	 * "Batch Number NOT displayed as expected" + ele1 + "," + batchNo); } } if
	 * (ele.getAttribute("title").trim().equalsIgnoreCase("Expiration date")) {
	 * WebElement ele2 = DriverManager.getDriver()
	 * .findElement(By.xpath("(//div[@class='datatable-body-cell-label']//div)[" + i
	 * + "-1]")); String s = ele2.getAttribute("title"); String s2 = ele2.getText();
	 * if (s.equals(expiryDate)) {
	 * 
	 * FrameworkLogger.log(LogType.PASS, "Expiry date is displayed as expected" + s2
	 * + "" + expiryDate + "" + s); } else { FrameworkLogger.log(LogType.FAIL,
	 * "Expiry date is not displayed as expected" + s2 + "" + expiryDate + "" + s);
	 * } } } }
	 * 
	 * public static void searchinventory() { CommonMethods.waitForPageLoading();
	 * SeleniumActions.click(byleftarrowbutton, "Details button displayed");
	 * CommonMethods.waitForPageLoading();
	 * SeleniumActions.click(byDetailBtnleftarrow, "Go to LPN deatils");
	 * CommonMethods.waitForPageLoading();
	 * SeleniumActions.click(byExpandInventoryitemsfield, "Expand icon");
	 * CommonMethods.waitForPageLoading(); }
	 */
	/**
	 * Function to verify ILPN Details
	 */
	/*
	 * public static void verifyILPNDetails() { CommonMethods.waitForPageLoading();
	 * SeleniumActions.click(byDetailBtn, "Details button ");
	 * CommonMethods.waitForPageLoading();
	 * SeleniumActions.click(byInventoryDetailsButton, "Inventory Details Button");
	 * CommonMethods.waitForPageLoading();
	 * CommonMethods.scrollByParticularElement(byProductStatus, "Product Status");
	 * CommonMethods.waitForPageLoading(); String productStatus =
	 * getDataFromFeature("getdata(ProductStatus)"); String inventoryType =
	 * getDataFromFeature("getdata(InventoryTypeId)"); String actualProductStatus =
	 * SeleniumActions.getAtrribute(byProductStatusCellValue, "title", 20); String
	 * actualInventoryType = SeleniumActions.getAtrribute(byInventoryTypeCellValue,
	 * "title", 20); if (productStatus.equals(actualProductStatus.trim())) {
	 * FrameworkLogger.log(LogType.PASS, "Product Status Verification passed : " +
	 * actualProductStatus); } else { FrameworkLogger.log(LogType.FAIL,
	 * "Product Status Verification failed. Expected :+" + productStatus +
	 * " , Actual :" + actualProductStatus); } if
	 * (inventoryType.equals(actualInventoryType.trim())) {
	 * FrameworkLogger.log(LogType.PASS, "Inventory Type Verification passed : " +
	 * actualInventoryType); } else { FrameworkLogger.log(LogType.FAIL,
	 * "Inventory Type Verification failed. Expected :+" + inventoryType +
	 * " , Actual :" + actualInventoryType); }
	 * SeleniumActions.click(byCloseInventoryDetails, "Close icon");
	 * CommonMethods.waitForPageLoading(); }
	 */
	/**
	 * Function to verify statusCode at first index
	 * 
	 * @param statusCode - value which need to be verified
	 */
	/*
	 * public static void verifyILPNStatusCodeAtFirstIndex(String statusCode) {
	 * String actualstatusCode =
	 * SeleniumActions.getAtrribute(byILPNStatusCodeAtFirstIndex, "title", 20);
	 * actualstatusCode = actualstatusCode.trim(); if
	 * (statusCode.equals(actualstatusCode)) { FrameworkLogger.log(LogType.PASS,
	 * "Status code Verification passed : " + statusCode); } else {
	 * FrameworkLogger.log(LogType.FAIL,
	 * "Status code Verification failed. Expected : " + statusCode + " , Actual :" +
	 * actualstatusCode); } }
	 */
	/**
	 * Function to click ILPN Card in ASN>ILPN
	 */
	/*
	 * public static void clickILPNCardInILPN(String ILPN) {
	 * CommonMethods.waitForPageLoading(); SeleniumActions.click(
	 * By.xpath("//span[contains(text(),'" + ILPN +
	 * "')]//following::div/span[contains(text(),'Parent LPN')]"), "Parent LPN");
	 * CommonMethods.waitForPageLoading(); SeleniumActions.click(byDetailBtn,
	 * "Details Button"); CommonMethods.waitForPageLoading(); }
	 */

	/**
	 * Function to verify multiple lpns
	 * 
	 * @param lpns - lpns value which need to be verified
	 */
	/*
	 * public static void verifyMultipleLPNs(List<String> lpns) { List<WebElement>
	 * elements = DriverManager.getDriver().findElements(byILPNS); List<String>
	 * actualLPNs = new ArrayList<>(); for (WebElement e : elements) {
	 * actualLPNs.add(e.getText()); } if (lpns.equals(actualLPNs)) {
	 * FrameworkLogger.log(LogType.PASS, "LPNs Verification passed : " + lpns); }
	 * else { FrameworkLogger.log(LogType.FAIL,
	 * "LPNs Verification failed. Expected :" + lpns + " , Actual :" + actualLPNs);
	 * } }
	 * 
	 * private static final By bylocationitemvalue = By .xpath(
	 * "//div[@class='datatable-body-cell-label']//div/a[@data-component-id='link']"
	 * ); // Commented below code by lohith on 13 Nov 2023 during merge // private
	 * static final By byselectinvfirstrow = By.xpath(
	 * "(//div[contains(@class,'datatable-row-group')]//datatable-body-cell[1])[1]/div/label"
	 * );// Need // private static final By byselectFirstItem = By.xpath(
	 * "(//div[@class='datatable-body-cell-label']//label//input[@type='checkbox'])[1]"
	 * ); // private static final By bylocationitemvalue = By.xpath(
	 * "//div[@class='datatable-body-cell-label']//div/a[@data-component-id='link']"
	 * ); private static final By byInventoryContainerCellValue = By .xpath(
	 * "((//div[contains(@class,'datatable-row-center')])[2]//datatable-body-cell)[7]/div[1]/div"
	 * ); private static final By byLPNStatusCellValue = By .xpath(
	 * "((//div[contains(@class,'datatable-row-center')])[2]//datatable-body-cell)[8]/div[1]/div"
	 * ); private static final By byOnHandQuantityCellValue = By .xpath(
	 * "((//div[contains(@class,'datatable-row-center')])[2]//datatable-body-cell)[10]/div[1]/div"
	 * ); private static final By byInventoryTypeCellValue = By .xpath(
	 * "((//div[contains(@class,'datatable-row-center')])[2]//datatable-body-cell)[34]/div[1]/div"
	 * ); private static final By byProductStatusCellValue = By .xpath(
	 * "((//div[contains(@class,'datatable-row-center')])[2]//datatable-body-cell)[35]/div[1]/div"
	 * ); private static final By byCompleteCountAction =
	 * By.xpath("//span[text()='Continue Count Action']");
	 * 
	 * /** Function to Extract list of Serail Numbers to Variables
	 */
	/*
	 * public static void extractListOfSerialNumbers() { String items =
	 * getDataFromFeature("getdata(Items)"); String inventoryType =
	 * getDataFromFeature("getdata(InventoryType)"); String productStatus =
	 * getDataFromFeature("getdata(ProductStatus)"); String lpnStatus =
	 * getDataFromFeature("getdata(LPNStatus)"); String quantity = null; String
	 * locationBarCode = null; String item = null; int j, k = 0; for (int i = 0; i <
	 * items.split(",").length; i++) { j = i + 1; k = i + 2; item =
	 * getDataFromFeature("getdata(Item" + j + ")"); locationBarCode =
	 * getDataFromFeature("getdata(LocationBarCode" + j + ")"); quantity =
	 * getDataFromFeature("getdata(Quantity" + j + ")");
	 * 
	 * String actualLPNStatus = DriverManager.getDriver().findElement(By.xpath(
	 * "((//div[contains(@class,'datatable-row-center')])[" + k +
	 * "]//datatable-body-cell)[8]/div[1]/div")) .getText();
	 * CommonMethods.verifyTextContains(actualLPNStatus, lpnStatus,
	 * "LPN Status CellValue", false);
	 * 
	 * 
	 * String actualOnHandQuantity = DriverManager.getDriver()
	 * .findElement(By.xpath("((//div[contains(@class,'datatable-row-center')])[" +
	 * k + "]//datatable-body-cell)[10]/div[1]/div")) .getText();
	 * actualOnHandQuantity = actualOnHandQuantity.replaceAll("UNIT", "").trim();
	 * CommonMethods.verifyValue(actualOnHandQuantity, quantity,
	 * "OnHandQuantity CellValue", "GreaterThanOrEqual"); }
	 */
	/**
	 * Function to verify Tasks Page is displayed
	 */
	/*
	 * public static void verifyTasksPageDisplayed() {
	 * SeleniumActions.verifyElementVisible(byTasksPage, 20, " Tasks page"); }
	 * 
	 *//**
		 * Function to click ReadyForAssignment Checkbox
		 */
	/*
	 * public static void clickReadyForAssignmentCheckbox() {
	 * SeleniumActions.click(byTaskStatusReadyForAssignmentCheckbox,
	 * "ReadyForAssignment checkbox"); }
	 * 
	 *//**
		 * Function to verify ReadyForAssignmentButton At FirstIndex
		 */
	/*
	 * public static void verifyReadyForAssignmentButtonAtFirstIndex() {
	 * SeleniumActions.verifyElementVisible(byReadyForAssignmentButtonAtFirstIndex,
	 * 20, " ReadyForAssignment Button AtFirstIndex"); }
	 * 
	 *//**
		 * Function to verify Transaction Type At FirstIndex
		 */
	/*
	 * public static void verifyTransactionTypeAtFirstIndex() {
	 * SeleniumActions.verifyElementVisible(byTransactionTypeAtFirstIndex, 20,
	 * " Transaction Type as Cycle count"); }
	 * 
	 *//**
		 * Function to verify source location at first index
		 *
		 * @param location - value which need to be verified at first index
		 */
	/*
	 * public static void verifySourceLocationAtFirstIndex(String location) { String
	 * actualLocation = SeleniumActions.getAtrribute(bySourceLocationAtFirstIndex,
	 * "title", 20); actualLocation = actualLocation.replaceAll("-", "").trim(); if
	 * (location.equals(actualLocation)) { FrameworkLogger.log(LogType.PASS,
	 * "Source Location Verification passed : " + location); } else {
	 * FrameworkLogger.log(LogType.FAIL,
	 * "Source Location Verification failed. Expected :+" + location + " , Actual :"
	 * + actualLocation); } }
	 * 
	 *//**
		 * Function to enter scan location
		 * 
		 * @param text - value which need to be entered
		 *//*
			 * public static void enterScanLocation(String text) {
			 * SeleniumActions.sendTextToElement(byScanLocationTextFiled, text,
			 * "Scan location field"); }
			 * 
			 * 
			 * 
			 * private static final By byselectinvfirstrow = By .xpath(
			 * "(//div[contains(@class,'datatable-row-group')]//datatable-body-cell[1])[1]/div/label"
			 * );// Need private static final By byselectFirstItem = By .xpath(
			 * "(//div[@class='datatable-body-cell-label']//label//input[@type='checkbox'])[1]"
			 * ); private static final By bylocationitemvalue = By .xpath(
			 * "//div[@class='datatable-body-cell-label']//div/a[@data-component-id='link']"
			 * ); private static final By byInventoryContainerCellValue = By .xpath(
			 * "((//div[contains(@class,'datatable-row-center')])[2]//datatable-body-cell)[7]/div[1]/div"
			 * ); private static final By byLPNStatusCellValue = By .xpath(
			 * "((//div[contains(@class,'datatable-row-center')])[2]//datatable-body-cell)[8]/div[1]/div"
			 * ); private static final By byOnHandQuantityCellValue = By .xpath(
			 * "((//div[contains(@class,'datatable-row-center')])[2]//datatable-body-cell)[10]/div[1]/div"
			 * ); private static final By byInventoryTypeCellValue = By .xpath(
			 * "((//div[contains(@class,'datatable-row-center')])[2]//datatable-body-cell)[34]/div[1]/div"
			 * ); private static final By byProductStatusCellValue = By .xpath(
			 * "((//div[contains(@class,'datatable-row-center')])[2]//datatable-body-cell)[35]/div[1]/div"
			 * ); private static final By byItemCellValue = By .xpath(
			 * "((//div[contains(@class,'datatable-row-center')])[2]//datatable-body-cell)[30]/div[1]/div"
			 * ); private static final By byLocationBarCodeCellValue = By .xpath(
			 * "((//div[contains(@class,'datatable-row-center')])[2]//datatable-body-cell)[33]/div[1]/div"
			 * );
			 */
}