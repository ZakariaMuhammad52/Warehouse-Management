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
import com.dhl.testdata.TestData_Json;
import com.dhl.utils.CurrentThreadInstance;
import com.dhl.utils.GeneralUtils;
import com.dhl.utils.Variables;
import com.dhl.web.utils.KeyboardActions;
import com.dhl.web.utils.SeleniumActions;

import stepdefinitions.CommonMethods;

@SuppressWarnings("unused")
public class ILPNs extends TestData_Json {

    private static final By byASNField = By.xpath("//ion-input[contains(@data-component-id,'AsnId')]/input");
    private static final By byExpandASNfield = By
            .xpath("//span[@title='ASN']/following-sibling::ion-button[contains(@data-component-id,'expand-button')]");
    private static final By byExpandILPNfield = By
            .xpath("//span[@title='ILPN']/following-sibling::ion-button[contains(@data-component-id,'expand-button')]");
    private static final By byExpandInventoryitemsfield = By.xpath("//span[text()='INVENTORY DETAILS']");
    private static final By byexportBtn = By.xpath("//button[contains(@data-component-id,'export')]");
    private static final By byExportJobBtn = By.xpath("//ion-button[contains(text(),'Export Job')]");
    private static final By byCloseExportBtn = By.xpath("//button//ion-icon[@name='close']");
    private static final By byDetailBtn = By.xpath("//ion-button[contains(@data-component-id,'Details')]");
    private static final By byCurrentQuantityText = By.xpath("//*[contains(@data-component-id,'UNIT')]");
    private static final By byCurrentLocationTextField = By
            .xpath("//ion-input[contains(@data-component-id,'CurrentLocationId')]//input");
    private static final By byCloseInventoryDetails = By.xpath("//button//ion-icon[@name='close']");
    private static final By byCloseSlideOption = By
            .xpath("//div[contains(@class,'slideOptionList')]/button[contains(@data-component-id,'action-open')]");
    private static final By bylocationitemvalue = By
            .xpath("//div[@class='datatable-body-cell-label']//div/a[@data-component-id='DisplayItem-card-view']");
    private static final By byDetailBtnleftarrow = By.xpath("//img[contains(@src,'Icon_Details.svg')]");
    /*
     * locator which might need corrections in future
     */
    private static final By byILPNIdAtFirstIndex = By
            .xpath("(//span[contains(text(),'ILPN :')])[1]//following-sibling::span[1]");
    private static final By byILPNCurrentLocationAtFirstIndex = By
            .xpath("(//span[contains(text(),'Current location :')])[1]//following-sibling::span[1]");
    private static final By byILPNPreviousLocationAtFirstIndex = By
            .xpath("(//span[contains(text(),'Previous Location :')])[1]//following-sibling::span[1]");
    private static final By byExpandLPNStatusfield = By
            .xpath("//span[@title='LPN status']/following-sibling::ion-button[contains(@data-component-id,'expand-button')]");
    private static final By byExpandItemfield = By
            .xpath("//span[@title='Item']/following-sibling::ion-button[contains(@data-component-id,'expand-button')]");
    private static final By bySearchItemIDField = By.xpath("//ion-input[@data-component-id='ItemId-lookup-dialog-filter-input']/input");
    private static final By byExpandILPNCurrentLocationfield = By.xpath(
            "//span[@title='Current location']/following-sibling::ion-button[contains(@data-component-id,'expand-button')]");
    private static final By byCurrentDisplayLocationILPNCard = By
            .xpath("//span[@data-component-id='CurrentDisplayLocation-card-view']");
    private static final By byCurrentLocationCheckbox = By.xpath("//ion-col[@class='checkbox-container md hydrated']");
    private static final By byClearAllFilterBtn = By.xpath("//button[@data-component-id='clear-all-btn-filter-panel']");
    private static final By byParentLPNIdILPNsCard1 = By.xpath("(//span[contains(@data-component-id,'ParentLpnId')])[1]");
    private static final By byParentLPNIdILPNsCard2 = By.xpath("(//span[contains(@data-component-id,'ParentLpnId')])[2]");
    private static final By byParentLPNIdILPNsCard3 = By.xpath("(//span[contains(@data-component-id,'ParentLpnId')])[3]");
    private static final By bySlideILPNsCard1Btn = By
            .xpath("(//div[contains(@class,'list-card-action-left-arrow')])[1]");
    private static final By bySlideILPNsCard2Btn = By
            .xpath("(//div[contains(@class,'list-card-action-left-arrow')])[2]");
    private static final By bySlideILPNsCard3Btn = By
            .xpath("(//div[contains(@class,'list-card-action-left-arrow')])[3]");
    private static final By bySlideCardDetailsBtn = By.xpath("//button[contains(@data-component-id,'Details')]");
    private static final By byExpandInventoryDetailsSection = By.xpath("//div[contains(@data-component-id,'Inventorydetails')]");
    private static final By byInventoryDetails = By.xpath("//span[contains(text(),'INVENTORY DETAILS')]");
    private static final By byProductStatus = By.xpath("//span[contains(@data-component-id,'Productstatus')]");
    private static final By byleftarrowbutton = By.xpath("//div[contains(@class,'list-card-action-left-arrow')]");
    private static final By byfilterWithNotAllocated = By.xpath("//ion-checkbox[contains(@data-component-id,'NotAllocated')]");
    private static final By byILPNS1 = By.xpath("(//span[contains(@data-component-id,'IlpnId')])[1]");
    private static final By byILPNS2 = By.xpath("(//span[contains(@data-component-id,'IlpnId')])[2]");
    private static final By byilpnstatusDescription = By.xpath("//div[@data-component-id='IlpnStatusDescription-card-view']");
    private static final By byRelatedlinksInventoryDetails = By.xpath("//a[contains(text(),'Inventory details')]");
    private static final By byNorecordsmsg = By.xpath("//ion-label[text()=' No Records found ']");
    private static final By byEditLpnSizeTypeId = By.xpath("//ion-input[contains(@data-component-id,'LpnSizeTypeId')]/input");
    private static final By byEditPalletCHEPBtn = By.xpath("//button[@data-component-id='Pallet,CHEP-dropdown-list']");
    private static final By byEditPalletEuroBtn = By.xpath("//button[@data-component-id='Pallet,Euro-dropdown-list']");
    private static final By byEditBoxMediumBtn = By.xpath("//button[@data-component-id='Box,Medium-dropdown-list']");
    private static final By bySubmitBtn = By.xpath("//ion-button[contains(@data-component-id,'submit-btn')]");
    private static final By byLPNAttributes = By.xpath("//span[contains(text(),'LPN ATTRIBUTES')]");
    private static final By byLPNAttributesLPNSizeTypeId = By
            .xpath("//span[contains(text(),'LPN size type :')]//following-sibling::span[1]");
    private static final By byILPNSPage = By.xpath("//span[contains(text(),'ILPNs')]");
    private static final By byiLPNField = By.xpath("//ion-input[@data-component-id='IlpnId-filter']/input");
    private static final By byILPNSCard = By.xpath("//*[contains(text(),'ILPN :')]");
    private static final By byselectAllRowsBtn = By.xpath("//button[contains(@data-component-id,'selectAllRows')]");
    private static final By byILPNS = By.xpath("//span[contains(@data-component-id,'IlpnId')]");
    private static final By byLocationInventryLink = By.xpath("//span[contains(text(),'Location inventory')]");
    private static final By byILPNQuantityAtFirstIndex = By
            .xpath("//span[contains(text(),\"ILPN's total quantity :\")]//following-sibling::span[1]");
    private static final By byILPNCurrentLocationTypeAtFirstIndex = By
            .xpath("//span[contains(text(),'Current location type :')]//following-sibling::span[1]");
    private static final By byILPNStatusCodeAtFirstIndex = By
            .xpath("//span[contains(text(),'LPN status code :')]//following-sibling::span[1]");
    private static final By byExpandCurrentLocationField = By.xpath(
            "//span[@title='Current location']/following-sibling::ion-button[contains(@data-component-id,'expand-button')]");
    private static final By byILPNStatusAtFirstIndex = By.xpath("//div[contains(@data-component-id,'IlpnStatusDescription')]");
    private static final By byILPNPreviousDisplayLocationAtFirstIndex = By
            .xpath("//span[contains(text(),'Previous Display Location :')]//following-sibling::span[1]");
    private static final By byILPNTotalQuantityAtFirstIndex = By
            .xpath("//span[contains(text(),'total quantity :')]//following-sibling::span[1]");
    private static final By byParentLPNAtFirstIndex = By
            .xpath("//span[contains(text(),'Parent LPN :')]//following-sibling::span[1]");
    private static final By byInventoryDetailsButton = By.xpath("//div[@data-component-id='Inventorydetails']//span");
    private static final By byProductStatusCellValue = By
            .xpath("(//div[contains(@class,'datatable-row-group')]//datatable-body-cell[4])/div/div");
    private static final By byInventoryTypeCellValue = By
            .xpath("(//div[contains(@class,'datatable-row-group')]//datatable-body-cell[5])/div/div");
    private static final By byRelatedLinks = By.xpath("//*[contains(text(),'Related Links')]");
    private static final By byInventoryDetailsLink = By.xpath("//*[text()='Inventory details']");
    private static final By byILPNListWithoutCurrentLocation = By
            .xpath("//span[contains(text(),'Current location :')]//following-sibling::span[@title='']");
    private static final By byILPNWithoutCurrentLocationAtFirstIndex = By.xpath(
            "(//span[contains(text(),'Current location :')]//following-sibling::span[@title=''])[1]//ancestor::div[2]//preceding-sibling::div[1]//div[3]//span[@data-component-id='IlpnId']");
    private static final By byItemsList = By.xpath("//a[@data-component-id='DisplayItem-card-view']");
    private static final String latestFilePathDir1 = "C:\\Users\\" + GeneralUtils.getCurrentUser() + "\\Downloads";
    private static final  String latestFilePathDir2 = "ILpn.*.csv";
    private static final By byCurrentLocation = By.xpath("//span[contains(text(),'Current location :')]//following-sibling::span[1]");
    private static final By byInventoryColumn = By.xpath("(//datatable-header-cell[@role='columnheader'])");

    /**
     * Function to verify ILPN Page displayed
     */
    public static void verifyPageDisplayed() {
        SeleniumActions.verifyElementVisible(byILPNSPage, 20, "ILPNs page");
    }

    /**
     * Function to search ASN
     * @param strText - value to verify
     */
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

    /**
     * Function to search LPN
     * @param strText - value to verify
     */
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

    /**
     * Function to get all ILPNs to list
     *
     */
    public static void storeILPNsToList() {
        List<WebElement> listOfElements = DriverManager.getDriver().findElements(byILPNS);
        List<String> listOfILPNs = new ArrayList<>();
        for (WebElement element : listOfElements) {
            listOfILPNs.add(element.getText().trim());
        }
        System.out.println("iLPNS stored in variables:- " + listOfILPNs);
        Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "listOFiLPNs", listOfILPNs);
    }

    /**
     * Function to verify the excel
     *
     */
    public static void excelValidation() {
        List<String> listOfILPNs = (List<String>) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "listOFiLPNs");
        File fileLatestDownload = GeneralUtils.getLatestFilefromDir(latestFilePathDir1, latestFilePathDir2);
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
    /**
     * Function to navigate to location inventory
     *
     */
    public static void navigateToLocationInventory() {
        CommonMethods.waitForPageLoading();
        SeleniumActions.click(byDetailBtn, "Details Button");
        CommonMethods.waitForPageLoading();
        SeleniumActions.click(byLocationInventryLink, "Location Inventory Link");
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to validate the current quantity
     *
     */
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

    /**
     * Function to store ILPNID at first index
     *
     */
    public static void storeILPNIdAtFirstIndexToString() {
        WebElement element = DriverManager.getDriver().findElement(byILPNIdAtFirstIndex);
        String text = element.getText().trim();
        FrameworkLogger.log(LogType.INFO, "ILPN Id stored in variable:- " + text);
        Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ILPNIdAtFirstIndex", text);
    }

    /**
     * Function to store ILPNquantity at first index
     *
     */
    public static void storeILPNQuantityAtFirstIndexToString() {
        WebElement element = DriverManager.getDriver().findElement(byILPNQuantityAtFirstIndex);
        String text = element.getText().trim();
        FrameworkLogger.log(LogType.INFO, "ILPN Quantity stored in variable:- " + text);
        Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ILPNQuantityAtFirstIndex", text);
    }

    /**
     * Function to store ILPN location at first index
     *
     */
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
        SeleniumActions.click(bySlideCardDetailsBtn, "Details Button");
    }

    /**
     * Function to expand Inventory Details
     */
    public static void expandInventoryDetails() {
        CommonMethods.waitForPageLoading();
        CommonMethods.scrollByParticularElement(byInventoryDetails, "Inventory Details");
        SeleniumActions.click(byInventoryDetails, "Inventory Details");
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to verify Product Status in Inventory Details
     *
     * @param strProductStatus - Product status that needs to be verified
     */
    public static void verifyProductStatus(String strProductStatus) {
        String strExpectedProductStatus = getProductStatusDescription(strProductStatus);
        CommonMethods.waitForPageLoading();
        if (!SeleniumActions.getText(By.xpath("//div[contains(@data-component-id,'" + strExpectedProductStatus + "')]"))
                .isEmpty()) {
            FrameworkLogger.log(LogType.PASS, "Expected Product status " + strExpectedProductStatus + " is displayed");
        } else {
            FrameworkLogger.log(LogType.FAIL,
                    "Expected Product status " + strExpectedProductStatus + " is not displayed");
        }
    }

    /**
     * Function for each product description
     * @param strProductStatus - Product status that needs to be verified
     */
    public static String getProductStatusDescription(String strProductStatus) {
        // remaining product statuses to be added based on the usage in test case
        String strProductDescription;
        char strChar;
        strChar = strProductStatus.charAt(0);
        switch (String.valueOf(strChar).toUpperCase()) {
            case "A":
                strProductDescription = "Available";
                break;
            case "D":
                strProductDescription = "Damaged";
                break;
            case "E":
                strProductDescription = "Expired";
                break;
            case "H":
                strProductDescription = "On Hold";
                break;
            case "I":
                strProductDescription = "Inspection";
                break;
            case "R":
                strProductDescription = "Return";
                break;
            default:
                throw new IllegalArgumentException("Product Status NOT supported");
        }
        return strProductDescription;
    }

    /**
     * Function to capture LPN value from ILPNS screen
     */
    public static void captureILPNSNumber() {
        String strILPNS = SeleniumActions.getText(byILPNS);
        if (strILPNS != null && !strILPNS.trim().isEmpty()) {
            Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN", strILPNS.replace("LPN ID: ", ""));
        } else {
            FrameworkLogger.log(LogType.FAIL, "LPN is null or empty");
        }
    }

    /**
     * Function to filter LPN by status
     * @param strText -  status that needs to be filter
     */
    public static void filterLPNByStatus(String strText) {
        String strLPNStatus = strText;
        CommonMethods.waitForPageLoading();
        SeleniumActions.click(By.xpath("//ion-checkbox[@data-component-id='" + strLPNStatus + "']"), "ILPN Status");
    }

    /**
     * Function to filter LPN by item
     * @param strText -  Item that needs to be filter
     */
    public static void filterLPNByItem(String strText) {
        String strLPNItemId = strText;
        if (DriverManager.getDriver().findElements(bySearchItemIDField).size() < 1) {
            SeleniumActions.click(byExpandItemfield, "Expand icon");
        }
        SeleniumActions.getElement(bySearchItemIDField).clear();
        SeleniumActions.sendTextToElement(bySearchItemIDField, strLPNItemId, "LPN Item ID search field");
        CommonMethods.waitForPageLoading();
        KeyboardActions.pressEnterKey(bySearchItemIDField);
        CommonMethods.waitForPageLoading();
        //SeleniumActions.click(byFirstILPNsCard, "ILPNS First Card");
    }

    /**
     * Function to filter LPN by lpn value
     * @param strText -  value that needs to be filter
     */
    public static void filterLPNByLPNValue(String strText) {
        String strILPNS = SeleniumActions.getText(byILPNS);
        CommonMethods.waitForPageLoading();
        if (strILPNS != null && !strILPNS.trim().isEmpty()) {
            Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN", strILPNS.replace("LPN ID: ", ""));
        } else {
            FrameworkLogger.log(LogType.FAIL, "LPN is null or empty");
        }
        SeleniumActions.getElement(byiLPNField).clear();
        SeleniumActions.sendTextToElement(byiLPNField, strILPNS, "LPN search field");
        KeyboardActions.pressEnterKey(byiLPNField);
    }

    /**
     * Function to verify ILPNs Current Display Location
     *
     * @param strExpected - LPNs Current Display Location that need to be verified
     */
    public static void verifyILPNsCurrentDisplayLocation(String strExpected) {
        String strStatus = getILPNsCurrentDisplayLocation();
        if (!strStatus.isEmpty()) {
            SeleniumActions.verifyTextEquals(strStatus, strExpected);
        }
    }
    /**
     * Function to get the current displayed location of ilpn
     *
     */
    public static String getILPNsCurrentDisplayLocation() {
        String strILPNsCurrentLocationDisplay = SeleniumActions.getText(byCurrentDisplayLocationILPNCard);
        if (strILPNsCurrentLocationDisplay != null && !strILPNsCurrentLocationDisplay.trim().isEmpty()) {
            return strILPNsCurrentLocationDisplay.trim();
        } else {
            FrameworkLogger.log(LogType.FAIL, "Current Display Location is null or empty");
        }
        return "";
    }

    public static void filterLPNCurrentLocationIsNull() {
        if (DriverManager.getDriver().findElements(byCurrentLocationCheckbox).size() < 1) {
            SeleniumActions.click(byExpandILPNCurrentLocationfield, "Expand icon");
        }
        SeleniumActions.checkSingleCheckbox(byCurrentLocationCheckbox, "Checked Current Location is Null");

    }

    /**
     * Function to clear filter menu
     *
     */
    public static void clearFilterMenuILPNs() {
        CommonMethods.waitForPageLoading();
        SeleniumActions.click(byClearAllFilterBtn, "Clear all filtered in ILPNS menu");
    }

    /**
     * Function to verify Parent LPN for multiple card
     */
    public static void validateParentLPNinILPNs() {
        CommonMethods.waitForPageLoading();
        String strParentLpnIdCard1 = SeleniumActions.getText(byParentLPNIdILPNsCard1);
        Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ParentLpnIdCard1", strParentLpnIdCard1);
        String strParentLpnIdCard2 = SeleniumActions.getText(byParentLPNIdILPNsCard2);
        Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ParentLpnIdCard2", strParentLpnIdCard2);
        String strParentLpnIdCard3 = SeleniumActions.getText(byParentLPNIdILPNsCard3);
        Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ParentLpnIdCard3", strParentLpnIdCard3);

        if (strParentLpnIdCard1 != null && !strParentLpnIdCard1.trim().isEmpty()) {
            if (strParentLpnIdCard1.equalsIgnoreCase(strParentLpnIdCard2)) {
                FrameworkLogger.log(LogType.PASS, "Parent LPN Id : " + strParentLpnIdCard1);
            } else {
                FrameworkLogger.log(LogType.FAIL, "Parent LPN Id is different, Actual : " + strParentLpnIdCard1
                        + "Expected : " + strParentLpnIdCard2);
            }
        } else {
            FrameworkLogger.log(LogType.FAIL, "Parent LPN Id is null or empty");

        }

        if (strParentLpnIdCard3 != null && !strParentLpnIdCard3.trim().isEmpty()) {
            if (strParentLpnIdCard3.equalsIgnoreCase(strParentLpnIdCard2)) {
                FrameworkLogger.log(LogType.FAIL,
                        "Parent LPN Id is same, Actual : " + strParentLpnIdCard3 + "Expected : " + strParentLpnIdCard2);
            } else {
                FrameworkLogger.log(LogType.PASS, "Parent LPN Id : " + strParentLpnIdCard3);
            }
        } else {
            FrameworkLogger.log(LogType.FAIL, "Parent LPN Id is null or empty");

        }

    }

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
    public static void verifyInventoryDetailCard1() {
        SeleniumActions.click(bySlideILPNsCard1Btn, "Slide button card 1 is clicked");
        SeleniumActions.click(bySlideCardDetailsBtn, "Details button is clicked");
        SeleniumActions.click(byExpandInventoryDetailsSection, "Expand Inventory Details");
        CommonMethods.waitForPageLoading();

    }

    /**
     * Function to verify LPN Inventory card is opening the details.
     */
    public static void verifyInventoryDetailCard2() {
        SeleniumActions.click(bySlideILPNsCard2Btn, "Slide button card 2 is clicked");
        SeleniumActions.click(bySlideCardDetailsBtn, "Details button is clicked");
        SeleniumActions.click(byExpandInventoryDetailsSection, "Expand Inventory Details");
        CommonMethods.waitForPageLoading();

    }

    /**
     * Function to verify LPN Inventory card is opening the details.
     */
    public static void verifyInventoryDetailCard3() {
        SeleniumActions.click(bySlideILPNsCard3Btn, "Slide button card 3 is clicked");
        SeleniumActions.click(bySlideCardDetailsBtn, "Details button is clicked");
        SeleniumActions.click(byExpandInventoryDetailsSection, "Expand Inventory Details");
        CommonMethods.waitForPageLoading();

    }

    /**
     * Function to validate batch no from inventory table
     * @param BatchNo - pass the batch no which need to validate
     */
    public static void validateBatchNumberInLPNInventoryTable(String BatchNo) {
        SeleniumActions.verifyElementExist(bylocationitemvalue, 5, "Item Value should be displayed");
//        By by = By.xpath("(//datatable-header-cell[@role='columnheader'])");
        List<WebElement> header = DriverManager.getDriver().findElements(byInventoryColumn);
        int i = header.size();
        for (i = 2; i >= 0 && i <= 26; i++) {
            WebElement ele = DriverManager.getDriver()
                    .findElement(By.xpath("(//datatable-header-cell[@role='columnheader'])[" + i + "]"));
            if (ele.getAttribute("title").trim().equalsIgnoreCase("Batch number")) {
                WebElement ele1 = DriverManager.getDriver()
                        .findElement(By.xpath("(//div[@class='datatable-body-cell-label']//div)[" + i + "-1]"));
                if (ele1.getText().trim().equals(BatchNo)) {
                    FrameworkLogger.log(LogType.PASS, "Batch Number displayed as expected " + ele1 + "," + BatchNo);
                } else {
                    FrameworkLogger.log(LogType.FAIL, "Batch Number NOT displayed" + ele1 + "," + BatchNo);
                }
            }
        }

    }

    /**
     * Function to validate ExpirationDate from inventory table
     * @param ExpirationDate - pass the ExpirationDate which need to validate
     */
    public static void validateExpiryDateInLPNInventoryTable(String ExpirationDate) {
        SeleniumActions.verifyElementExist(bylocationitemvalue, 5, "Item Value should be displayed");
        List<WebElement> header = DriverManager.getDriver().findElements(byInventoryColumn);
        int i = header.size();
        for (i = 2; i >= 0 && i <= 26; i++) {
            WebElement ele = DriverManager.getDriver()
                    .findElement(By.xpath("(//datatable-header-cell[@role='columnheader'])[" + i + "]"));
            if (ele.getAttribute("title").trim().equalsIgnoreCase("Expiration date")) {
                WebElement ele2 = DriverManager.getDriver()
                        .findElement(By.xpath("(//div[@class='datatable-body-cell-label']//div)[" + i + "-1]"));
                if (ele2.getText().trim().equals(ExpirationDate)) {
                    FrameworkLogger.log(LogType.PASS, "Expiry date is not null");
                } else {
                    FrameworkLogger.log(LogType.FAIL, "Expiry date is null");
                }
            }
        }
    }

    /**
     * Function to validate InventoryContainer and on hand quantity
     * @param OnHandQty - pass the OnHandQty which need to validate
     * @param InventoryContainer - pass the InventoryContainer which need to validate
     */
    public static void validateOnHandQuantityAndInventoryContainer(String OnHandQty, String InventoryContainer) {
        SeleniumActions.verifyElementExist(bylocationitemvalue, 5, "Item Value should be displayed");

        List<WebElement> header = DriverManager.getDriver().findElements(byInventoryColumn);
        int i = header.size();
        for (i = 2; i >= 0 && i <= 26; i++) {
            WebElement ele = DriverManager.getDriver()
                    .findElement(By.xpath("(//datatable-header-cell[@role='columnheader'])[" + i + "]"));
            if (ele.getAttribute("title").trim().equalsIgnoreCase("On hand quantity (Units)")) {
                WebElement ele1 = DriverManager.getDriver()
                        .findElement(By.xpath("(//div[@class='datatable-body-cell-label']//div)[" + i + "-1]"));
                if (ele1.getText().trim().equals(OnHandQty)) {
                    FrameworkLogger.log(LogType.PASS, "On hand quantity displayed");
                } else {
                    FrameworkLogger.log(LogType.FAIL, "On hand quantity NOT displayed");
                }
            }
            if (ele.getAttribute("title").trim().equalsIgnoreCase("Inventory container")) {
                WebElement ele2 = DriverManager.getDriver()
                        .findElement(By.xpath("(//div[@class='datatable-body-cell-label']//div)[" + i + "-1]"));
                if (ele2.getText().trim().equals(InventoryContainer)) {
                    FrameworkLogger.log(LogType.PASS, "Inventory container is not null");
                } else {
                    FrameworkLogger.log(LogType.FAIL, "Inventory container is null");
                }
            }
        }
    }

    /**
     * Function to validate product status and on inventory type and country origin
     * @param ProductStatus - pass the ProductStatus which need to validate
     * @param InventoryType - pass the InventoryType which need to validate
     * @param CountryOfOrigin - pass the CountryOfOrigin which need to validate
     */
    public static void ValidateProductStatus_InventoryTypeAndCountryOfOrigin(String ProductStatus, String InventoryType,
                                                                             String CountryOfOrigin) {
        SeleniumActions.verifyElementExist(bylocationitemvalue, 5, "Item Value should be displayed");

        List<WebElement> header = DriverManager.getDriver().findElements(byInventoryColumn);
        int i = header.size();
        for (i = 2; i >= 0 && i <= 26; i++) {
            WebElement ele = DriverManager.getDriver()
                    .findElement(By.xpath("(//datatable-header-cell[@role='columnheader'])[" + i + "]"));
            if (ele.getAttribute("title").trim().equalsIgnoreCase("Product status")) {
                WebElement ele1 = DriverManager.getDriver()
                        .findElement(By.xpath("(//div[@class='datatable-body-cell-label']//div)[" + i + "-1]"));
                if (ele1.getText().trim().equals(ProductStatus)) {
                    FrameworkLogger.log(LogType.PASS, "Product status displayed");
                } else {
                    FrameworkLogger.log(LogType.FAIL, "Product status NOT displayed");
                }
            }
            if (ele.getAttribute("title").trim().equalsIgnoreCase("Inventory type")) {
                WebElement ele2 = DriverManager.getDriver()
                        .findElement(By.xpath("(//div[@class='datatable-body-cell-label']//div)[" + i + "-1]"));
                if (ele2.getText().trim().equals(InventoryType)) {
                    FrameworkLogger.log(LogType.PASS, "Inventory type is displayed");
                } else {
                    FrameworkLogger.log(LogType.FAIL, "Inventory type is NOT displayed");
                }
            }
            if (ele.getAttribute("title").trim().equalsIgnoreCase("Country of origin")) {
                WebElement ele3 = DriverManager.getDriver()
                        .findElement(By.xpath("(//div[@class='datatable-body-cell-label']//div)[" + i + "-1]"));
                if (ele3.getText().trim().equals(CountryOfOrigin)) {
                    FrameworkLogger.log(LogType.PASS, "COO is displayed");
                } else {
                    FrameworkLogger.log(LogType.FAIL, "COO is NOT displayed");
                }
            }
        }
    }

    /**
     * Function to close ILPN screen
     */
    public static void closeILPN() {
        SeleniumActions.click(byCloseInventoryDetails, "Close Inventory Details");
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to validate batch number and Expiry date
     * screen
     * @param batchNo - pass the batchNo which need to validate
     * @param expiryDate - pass the expiryDate which need to validate
     */
    public static void validateBatchNumandASNExpiryDate(String batchNo, String expiryDate) {
        SeleniumActions.verifyElementExist(bylocationitemvalue, 5, "Item Value shouldbe displayed");

        List<WebElement> header = DriverManager.getDriver().findElements(byInventoryColumn);
        int i = header.size();
        for (i = 2; i >= 0 && i <= 15; i++) {
            WebElement ele = DriverManager.getDriver()
                    .findElement(By.xpath("(//datatable-header-cell[@role='columnheader'])[" + i + "]"));
            if (ele.getAttribute("title").trim().equalsIgnoreCase("Batch number")) {
                WebElement ele1 = DriverManager.getDriver()
                        .findElement(By.xpath("(//div[@class='datatable-body-cell-label']//div)[" + i + "-1]"));
                if (ele1.getText().trim().equals(batchNo)) {
                    FrameworkLogger.log(LogType.PASS, "Batch Number displayed as expected" + ele1 + "," + batchNo);
                } else {
                    FrameworkLogger.log(LogType.FAIL, "Batch Number NOT displayed as expected" + ele1 + "," + batchNo);
                }
            }
            if (ele.getAttribute("title").trim().equalsIgnoreCase("Expiration date")) {
                WebElement ele2 = DriverManager.getDriver()
                        .findElement(By.xpath("(//div[@class='datatable-body-cell-label']//div)[" + i + "-1]"));
                String s = ele2.getAttribute("title");
                String s2 = ele2.getText();
                if (s.equals(expiryDate)) {

                    FrameworkLogger.log(LogType.PASS,
                            "Expiry date is displayed as expected" + s2 + "" + expiryDate + "" + s);
                } else {
                    FrameworkLogger.log(LogType.FAIL,
                            "Expiry date is not displayed as expected" + s2 + "" + expiryDate + "" + s);
                }
            }
        }
    }

    /**
     * Function to search the inventory
     */
    public static void searchinventory() {
        CommonMethods.waitForPageLoading();
        SeleniumActions.click(byleftarrowbutton, "Details button displayed");
        CommonMethods.waitForPageLoading();
        SeleniumActions.click(byDetailBtnleftarrow, "Go to LPN deatils");
        CommonMethods.waitForPageLoading();
        SeleniumActions.click(byExpandInventoryitemsfield, "Expand icon");
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to verify ILPN Details
     */
    public static void verifyILPNDetails() {
        CommonMethods.waitForPageLoading();
        SeleniumActions.click(byDetailBtn, "Details button ");
        CommonMethods.waitForPageLoading();
        SeleniumActions.click(byInventoryDetailsButton, "Inventory Details Button");
        CommonMethods.waitForPageLoading();
        CommonMethods.scrollByParticularElement(byProductStatus, "Product Status");
        CommonMethods.waitForPageLoading();
        String productStatus = getDataFromFeature("getdata(ProductStatus)");
        String inventoryType = getDataFromFeature("getdata(InventoryTypeId)");
        String actualProductStatus = SeleniumActions.getAtrribute(byProductStatusCellValue, "title", 20);
        String actualInventoryType = SeleniumActions.getAtrribute(byInventoryTypeCellValue, "title", 20);
        if (productStatus.equals(actualProductStatus.trim())) {
            FrameworkLogger.log(LogType.PASS, "Product Status Verification passed : " + actualProductStatus);
        } else {
            FrameworkLogger.log(LogType.FAIL, "Product Status Verification failed. Expected :+" + productStatus
                    + " , Actual :" + actualProductStatus);
        }
        if (inventoryType.equals(actualInventoryType.trim())) {
            FrameworkLogger.log(LogType.PASS, "Inventory Type Verification passed : " + actualInventoryType);
        } else {
            FrameworkLogger.log(LogType.FAIL, "Inventory Type Verification failed. Expected :+" + inventoryType
                    + " , Actual :" + actualInventoryType);
        }
        SeleniumActions.click(byCloseInventoryDetails, "Close icon");
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to verify statusCode at first index
     *
     * @param statusCode - value which need to be verified
     */
    public static void verifyILPNStatusCodeAtFirstIndex(String statusCode) {
        String actualstatusCode = SeleniumActions.getAtrribute(byILPNStatusCodeAtFirstIndex, "title", 20);
        actualstatusCode = actualstatusCode.trim();
        if (statusCode.equals(actualstatusCode)) {
            FrameworkLogger.log(LogType.PASS, "Status code Verification passed : " + statusCode);
        } else {
            FrameworkLogger.log(LogType.FAIL,
                    "Status code Verification failed. Expected : " + statusCode + " , Actual :" + actualstatusCode);
        }
    }

    /**
     * Function to validate on hand quntity and inventory container
     * screen
     * @param OnHandQty - pass the OnHandQty which need to validate
     * @param InventoryContainer - pass the InventoryContainer which need to validate
     */
    public static void ValidateOnHandQuantityAndInventoryContainer(String OnHandQty, String InventoryContainer) {
        SeleniumActions.verifyElementExist(bylocationitemvalue, 5, "Item Value shouldbe displayed");

        List<WebElement> header = DriverManager.getDriver().findElements(byInventoryColumn);
        int i = header.size();
        for (i = 2; i >= 0 && i <= 27; i++) {
            WebElement ele = DriverManager.getDriver()
                    .findElement(By.xpath("(//datatable-header-cell[@role='columnheader'])[" + i + "]"));
            if (ele.getAttribute("title").trim().equalsIgnoreCase("On hand quantity")) {
                WebElement ele1 = DriverManager.getDriver()
                        .findElement(By.xpath("(//div[@class='datatable-body-cell-label']//div)[" + i + "-1]"));
                if (ele1.getText().trim().equals(OnHandQty)) {
                    FrameworkLogger.log(LogType.PASS, "On hand quantity displayed");
                } else {
                    FrameworkLogger.log(LogType.FAIL, "On hand quantity NOT displayed");
                }
            }
            if (ele.getAttribute("title").trim().equalsIgnoreCase("Inventory container")) {
                WebElement ele2 = DriverManager.getDriver()
                        .findElement(By.xpath("(//div[@class='datatable-body-cell-label']//div)[" + i + "-1]"));
                if (ele2.getAttribute("title").trim().equalsIgnoreCase(InventoryContainer)) {
                    FrameworkLogger.log(LogType.PASS, "Inventory container is not null");
                } else {
                    FrameworkLogger.log(LogType.FAIL, "Inventory container is null");
                }
            }
        }
    }

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
     * Function to verify current locationType type at first index
     *
     * @param locationType - value which need to be verified
     */
    public static void verifyILPNCurrentLocationTypeAtFirstIndex(String locationType) {
//        String actualLocationType = SeleniumActions.getAtrribute(byILPNCurrentLocationTypeAtFirstIndex, "title", 20);
        String actualLocationType = DriverManager.getDriver().findElement(byILPNCurrentLocationTypeAtFirstIndex)
                .getText();
        actualLocationType = actualLocationType.replaceAll("-", "");
        if (locationType.equals(actualLocationType)) {
            FrameworkLogger.log(LogType.PASS, "Current locationType type Verification passed : " + locationType);
        } else {
            FrameworkLogger.log(LogType.FAIL, "Current locationType type Verification failed. Expected :" + locationType
                    + " , Actual :" + actualLocationType);
        }
    }

    /**
     * Function to click Related Links
     */
    public static void clickRelatedLinksButton() {
        CommonMethods.waitForPageLoading();
        SeleniumActions.click(byRelatedLinks, "Related Links");
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to click InventoryDetails Link
     */
    public static void clickInventoryDetailsLink() {
        CommonMethods.waitForPageLoading();
        SeleniumActions.click(byInventoryDetailsLink, "Inventory Details Link");
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to verify ILPNs Displayed Without CurrentLocation In ILPNPage
     */
    public static void verifyILPNsDisplayedWithoutCurrentLocationInILPNPage() {
        List<WebElement> listOfILPNs = DriverManager.getDriver().findElements(byILPNListWithoutCurrentLocation);
        if (listOfILPNs.size() > 0) {
            FrameworkLogger.log(LogType.PASS, "ILPNS displayed without Current location");
        } else {
            FrameworkLogger.log(LogType.FAIL,
                    "Test data not available, ILPNS should be displayed without Current location. But ILPs are displayed with current location");
        }
        CommonMethods.scrollByParticularElement(byILPNWithoutCurrentLocationAtFirstIndex, "ILPN");
        String ilpn = SeleniumActions.getText(byILPNWithoutCurrentLocationAtFirstIndex);
        Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN1", ilpn);
    }

    /**
     * Function to verify Linked LPN count for Same pallet
     * @param count - pass the count which need to validate
     */
    public static void verifyLinkedLPNCountForSamePallet(int count) {
        String pallet = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "PALLET");
        List<WebElement> listOfILPNs = DriverManager.getDriver()
                .findElements(By.xpath("//span[@title='" + pallet + "']"));
        if (listOfILPNs.size() == count) {
            FrameworkLogger.log(LogType.PASS, "Linked ILPN count for same pallet is matched: " + count);
        } else {
            FrameworkLogger.log(LogType.FAIL, "Linked ILPN count for same pallet is not matched. Expected: " + count
                    + ", Actual : " + listOfILPNs.size() + ", Pallet : " + pallet);
        }
    }

    /**
     * Function to verify previousLocation for each LPN
     *  @param count - pass the count which need to validate
     */
    public static void verifyPreviousLocationForEachLPN(int count) {
        String previousLocation = getDataFromFeature(getData("PreviousLocation"));
        List<WebElement> listOfElements = DriverManager.getDriver().findElements(
                By.xpath("//span[contains(text(),'Previous Display Location :')]//following-sibling::span[@title='"
                        + previousLocation + "']"));
        if (listOfElements.size() == count) {
            FrameworkLogger.log(LogType.PASS, "Previous Location for each ILPN matched: " + count);
        } else {
            FrameworkLogger.log(LogType.FAIL, "Previous Location for each ILPN is not matched. Expected: " + count
                    + "Actual : " + listOfElements.size() + ", PreviousLocation : " + previousLocation);
        }
    }

    /**
     * Function to verify current Location for each LPN
     */
    public static void verifyCurrentLocationForEachLPN() {
        List<WebElement> listOfElements = DriverManager.getDriver()
                .findElements(byCurrentLocation);
        for (int i = 0; i < listOfElements.size(); i++) {
            String actualLocation = listOfElements.get(i).getAttribute("title");
            actualLocation = actualLocation.replaceAll("-", "");
            String location = (String) Variables
                    .get(CurrentThreadInstance.getCurrentScenarioId() + "CurrentLocation" + (i + 1));
            if (location.equals(actualLocation)) {
                FrameworkLogger.log(LogType.PASS, "Current Location Verification passed : " + location);
            } else {
                FrameworkLogger.log(LogType.FAIL,
                        "Current Location Verification failed. Expected :" + location + " , Actual :" + actualLocation);
            }
        }
    }

    /**
     * Function to verify InventoryDetails For EachLPN
     */
    public static void verifyInventoryDetailsForEachLPN() {
        String pallet = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "PALLET");
        String batchNumber = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "BatchNumber");
        String inventoryType = getDataFromFeature("getdata(InventoryType)");
        String productStatus = getDataFromFeature("getdata(ProductStatusDescription)");
        String countryOfOrigin = getDataFromFeature("getdata(CountryOfOrigin)");
        List<WebElement> listOfILPNs = DriverManager.getDriver()
                .findElements(By.xpath("//span[@title='" + pallet + "']"));
        List<WebElement> listOfItems = DriverManager.getDriver().findElements(byItemsList);
        String item = null;

        for (int i = 0; i < listOfILPNs.size(); i++) {
            item = listOfItems.get(i).getAttribute("title");
            CommonMethods.scrollByParticularElement(listOfILPNs.get(i), "element");
            listOfILPNs.get(i).click();
            CommonMethods.waitForPageLoading();
            FooterPanelPage.clickDetailsButton();
            CommonMethods.waitForPageLoading();
            ILPNPopupPage.clickInventoryDetailsLabel();
            CommonMethods.waitForPageLoading();
            if (item.equalsIgnoreCase("R01-ITM03")) {
                ILPNPopupPage.verifyInventoryType(inventoryType);
                ILPNPopupPage.verifyProductStatus(productStatus);
            } else if (item.equalsIgnoreCase("R01-ITM04")) {
                ILPNPopupPage.verifyBatchNumber(batchNumber);
            } else if (item.equalsIgnoreCase("FN02-BOOK-1")) {
                ILPNPopupPage.verifyInventoryType(inventoryType);
                ILPNPopupPage.verifyProductStatus(productStatus);
                ILPNPopupPage.verifyCountryOfOrigin(countryOfOrigin);
            }
            CommonPopupPage.clickCloseIcon();
            listOfILPNs.get(i).click();
            CommonMethods.waitForPageLoading();
        }
    }

    /**
     * Function to verify Receiving ASN Details
     */
    public static void verifyReceivingASNDetails() {
        String pallet = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "PALLET");
        List<WebElement> listOfILPNs = DriverManager.getDriver()
                .findElements(By.xpath("//span[@title='" + pallet + "']"));
        for (WebElement e : listOfILPNs) {
            e.click();
            CommonMethods.waitForPageLoading();
            FooterPanelPage.clickDetailsButton();
            CommonMethods.waitForPageLoading();
            ILPNPopupPage.clickInventoryDetailsLabel();
            CommonMethods.waitForPageLoading();
            CommonPopupPage.clickCloseIcon();
        }

        if (listOfILPNs.size() == 3) {
            FrameworkLogger.log(LogType.PASS, "All ILPNS are linked same pallet");
        } else {
            FrameworkLogger.log(LogType.FAIL,
                    "All ILPNS are NOT linked same pallet. Count of LPNs linked to same pallet: " + listOfILPNs.size()
                            + ", Pallet : " + pallet);
        }
    }

    /*
     * Function to verify LPN status displayed
     *
     * @param strExpected - LPN status that need to be verified
     *
     * @param lineQuantity - LPN Line Number
     */
    public static void verifyLPNStatus(String strExpected, int lineQuantity) {
        String strStatus = getILPNStatus(lineQuantity);
        if (!strStatus.isEmpty()) {
            SeleniumActions.verifyTextEquals(strStatus, strExpected);
        }
    }

    /**
     * Function to get current LPN status from ASN window
     *
     * @param lineQuantity - LPN Line Number
     */
    public static String getILPNStatus(int lineQuantity) {
        String strStatus = SeleniumActions
                .getText(By.xpath("(//div[contains(@data-component-id,'IlpnStatusDescription')])[" + lineQuantity + "]"));
        if (strStatus != null && !strStatus.trim().isEmpty()) {
            return strStatus.trim();
        } else {
            FrameworkLogger.log(LogType.FAIL, "LPN Status description is null or empty");
        }
        return "";
    }

    /**
     * Function to verify status at first index
     *
     * @param status - value which need to be verified
     */
    public static void verifyILPNStatusAtFirstIndex(String status) {
        String actualStatus = SeleniumActions.getAtrribute(byILPNStatusAtFirstIndex, "title", 20);
        actualStatus = actualStatus.trim();
        if (status.equals(actualStatus)) {
            FrameworkLogger.log(LogType.PASS, "Status  Verification passed : " + status);
        } else {
            FrameworkLogger.log(LogType.FAIL,
                    "Status  Verification failed. Expected : " + status + " , Actual :" + actualStatus);
        }
    }

    /**
     * Function to verify previous Display location at first index
     *
     * @param location - value which need to be verified
     */
    public static void verifyILPNPreviousDisplayLocationAtFirstIndex(String location) {
//        String actualLocation = SeleniumActions.getAtrribute(byILPNPreviousDisplayLocationAtFirstIndex, "title", 20);
        String actualLocation = DriverManager.getDriver().findElement(byILPNPreviousDisplayLocationAtFirstIndex)
                .getText();
        actualLocation = actualLocation.replaceAll("-", "");
        if (location.equals(actualLocation)) {
            FrameworkLogger.log(LogType.PASS, "Previous Display Location Verification passed : " + location);
        } else {
            FrameworkLogger.log(LogType.FAIL, "Previous Display Location Verification failed. Expected :" + location
                    + " , Actual :" + actualLocation);
        }
    }

    /**
     * Function to verify status of ILPN
     * @param actStatus - pass the actual status which need to validate
     *
     * @param strLPN - value of lpn
     */
    public static void verifystastusofEachLPN(String strLPN, String actStatus) {
        String palletID = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "BatchNumber");
        if (SeleniumActions.getText(byILPNS).trim().equalsIgnoreCase(strLPN)) {
            SeleniumActions.getText(byilpnstatusDescription).trim().equalsIgnoreCase(actStatus);
            SeleniumActions.click(byILPNS, "click ILPN");
            SeleniumActions.click(byRelatedLinks, "Clicked on Related Links");
            SeleniumActions.click(byRelatedlinksInventoryDetails, "Clicked on Inventory Details");
            FrameworkLogger.log(LogType.PASS, "LPN status is displayed as expected");
        } else {
            FrameworkLogger.log(LogType.FAIL, "LPN status is not displayed as expected");
        }
    }

    /**
     * Function to verify inventory details of LPN
     * @param palletID - pass the palletID which need to validate
     * @param strLPN - value of lpn
     */
    public static void verifyinventorydetailsofLPN(String strLPN, String palletID) {
        CommonMethods.waitForPageLoading();
        ILPNPopupPage.verifyInventorycontainer(strLPN);
        ILPNPopupPage.verifyParentContainer(palletID);
    }

    /**
     * Function to verify inventory details of parent container
     * @param palletID - pass the palletID which need to validate
     *  @param strLPN - value of lpn
     */
    public static void verifyinventorydetailsofparentContainer(String strLPN, String palletID) {
        if (strLPN.equals(palletID) && SeleniumActions.isElementPresent(byNorecordsmsg, 3)) {
            FrameworkLogger.log(LogType.PASS, "Inventory details are not prent for Parent container" + palletID);
        } else {
            FrameworkLogger.log(LogType.FAIL, "Inventory details are present for parent container" + palletID);
        }
    }

    /**
     * Function to get current ASN status from ASN window
     */
    public static String getlpnStatusAtILPNs() {
        String strStatus = SeleniumActions.getText(byilpnstatusDescription);
        if (strStatus != null && !strStatus.trim().isEmpty()) {
            return strStatus.trim();
        } else {
            FrameworkLogger.log(LogType.FAIL, "ASN Status description is null or empty");
        }
        return "";
    }

    /**
     * Function to filter which is not allocated
     */
    public static void filterWithNotAllocated() {
        SeleniumActions.getElement(byfilterWithNotAllocated).click();
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to capture the ILPN number
     */
    public static void captureILPNSNumbers() {
        String strILPNS1 = SeleniumActions.getText(byILPNS1);
        String strILPNS2 = SeleniumActions.getText(byILPNS2);
        if (strILPNS1 != null && !strILPNS1.trim().isEmpty() && strILPNS2 != null && !strILPNS2.trim().isEmpty()) {
            Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN", strILPNS1.replace("LPN ID: ", ""));
            Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN1", strILPNS2.replace("LPN ID: ", ""));
        } else {
            FrameworkLogger.log(LogType.FAIL, "LPN is null or empty");
        }
    }

    public static void captureNewILPNSNumbers() {
        String strILPNS3 = SeleniumActions.getText(byILPNS1);
        String strILPNS4 = SeleniumActions.getText(byILPNS2);
        if (strILPNS3 != null && !strILPNS3.trim().isEmpty() && strILPNS4 != null && !strILPNS4.trim().isEmpty()) {
            Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN2", strILPNS3.replace("LPN ID: ", ""));
            Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN3", strILPNS4.replace("LPN ID: ", ""));
        } else {
            FrameworkLogger.log(LogType.FAIL, "LPN is null or empty");
        }
    }

    /**
     * Function to verify value at first index
     *
     * @param value - value which need to be verified
     */
    public static void verifyILPNTotalQuantityAtFirstIndex(String value) {
        String actualValue = SeleniumActions.getAtrribute(byILPNTotalQuantityAtFirstIndex, "title", 20);
        actualValue = actualValue.trim();
        if (value.equals(actualValue)) {
            FrameworkLogger.log(LogType.PASS, "TotalQuantity value  Verification passed : " + value);
        } else {
            FrameworkLogger.log(LogType.FAIL,
                    "TotalQuantity value  Verification failed. Expected : " + value + " , Actual :" + actualValue);
        }
    }

    /**
     * Function to verify ILPN status displayed
     *
     * @param strExpected - ILPN status that need to be verified
     */
    public static void verifyILPNStatusAtILPNs(String strExpected) {
        String strStatus = getlpnStatusAtILPNs();
        if (!strStatus.isEmpty()) {
            SeleniumActions.verifyTextEquals(strStatus, strExpected);
        }
    }

    /**
     * Function to validate product status and inventory type
     * @param InventoryType - Pass the inventory type
     * @param ProductStatus - pass product status
     * */
    public static void validateProductStatusAndInventoryType(String ProductStatus, String InventoryType) {
        SeleniumActions.verifyElementExist(bylocationitemvalue, 5, "Item Value should be displayed");

        List<WebElement> header = DriverManager.getDriver().findElements(byInventoryColumn);
        int i = header.size();
        for (i = 2; i >= 0 && i <= 26; i++) {
            WebElement ele = DriverManager.getDriver()
                    .findElement(By.xpath("(//datatable-header-cell[@role='columnheader'])[" + i + "]"));
            if (ele.getAttribute("title").trim().equalsIgnoreCase("Product status")) {
                WebElement ele1 = DriverManager.getDriver()
                        .findElement(By.xpath("(//div[@class='datatable-body-cell-label']//div)[" + i + "-1]"));
                if (ele1.getText().trim().equals(ProductStatus)) {
                    FrameworkLogger.log(LogType.PASS, "Element Product status is displayed : " + ProductStatus);
                } else {
                    FrameworkLogger.log(LogType.FAIL,
                            "Element Product status NOT displayed. Expected : " + ProductStatus + ", Actual :" + ele1);
                }
            }
            if (ele.getAttribute("title").trim().equalsIgnoreCase("Inventory type")) {
                WebElement ele2 = DriverManager.getDriver()
                        .findElement(By.xpath("(//div[@class='datatable-body-cell-label']//div)[" + i + "-1]"));
                if (ele2.getAttribute("title").trim().equalsIgnoreCase(InventoryType)) {
                    FrameworkLogger.log(LogType.PASS, "Element Inventory type is displayed : " + InventoryType);
                } else {
                    FrameworkLogger.log(LogType.FAIL, "Element Inventory type is NOT displayed. Expected : "
                            + InventoryType + ", Actual :" + ele2);
                }
            }
        }
    }
    /**
     * Function to validate product status and inventory type
     * @param InventoryType - Pass the inventory type
     * @param ProductStatus - pass product status
     * */

    public static void ValidateProductStatusAndInventoryType(String ProductStatus, String InventoryType) {
        SeleniumActions.verifyElementExist(bylocationitemvalue, 5, "Item Value should be displayed");

        List<WebElement> header = DriverManager.getDriver().findElements(byInventoryColumn);
        int i = header.size();
        for (i = 2; i >= 0 && i <= 26; i++) {
            WebElement ele = DriverManager.getDriver()
                    .findElement(By.xpath("(//datatable-header-cell[@role='columnheader'])[" + i + "]"));
            if (ele.getAttribute("title").trim().equalsIgnoreCase("Product status")) {
                WebElement ele1 = DriverManager.getDriver()
                        .findElement(By.xpath("(//div[@class='datatable-body-cell-label']//div)[" + i + "-1]"));
                if (ele1.getText().trim().equals(ProductStatus)) {
                    FrameworkLogger.log(LogType.PASS, "Product status displayed");
                } else {
                    FrameworkLogger.log(LogType.FAIL, "Product status NOT displayed");
                }
            }
            if (ele.getAttribute("title").trim().equalsIgnoreCase("Inventory type")) {
                WebElement ele2 = DriverManager.getDriver()
                        .findElement(By.xpath("(//div[@class='datatable-body-cell-label']//div)[" + i + "-1]"));
                if (ele2.getAttribute("title").trim().equalsIgnoreCase(InventoryType)) {
                    FrameworkLogger.log(LogType.PASS, "Inventory type is displayed");
                } else {
                    FrameworkLogger.log(LogType.FAIL, "Inventory type is NOT displayed");
                }
            }
        }
    }

    /**
     * Function to verify ParentAndChildLpnDetails In ILPNPage
     */
    public static void verifyParentAndChildLpnDetailsInILPNPage() {
        String lpn1Id = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "lpn1Id");
        String lpn2Id = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "lpn2Id");
        String parentlpnId = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "parentlpnId");

        LeftPanelPage.searchLPN(lpn1Id);
        ILPNs.verifyILPNAtFirstIndex(lpn1Id);
        ILPNs.verifyParentLPNAtFirstIndex(parentlpnId);

        LeftPanelPage.searchLPN(lpn2Id);
        ILPNs.verifyILPNAtFirstIndex(lpn2Id);
        ILPNs.verifyParentLPNAtFirstIndex(parentlpnId);

        LeftPanelPage.searchLPN(parentlpnId);
        ILPNs.verifyILPNAtFirstIndex(parentlpnId);
        ILPNs.verifyParentLPNAtFirstIndex("");
    }

    /**
     * Function to verify Parent LPN at first index
     *
     * @param parentLPN - value which need to be verified
     */
    public static void verifyParentLPNAtFirstIndex(String parentLPN) {
        String actualILPN = DriverManager.getDriver().findElement(byParentLPNAtFirstIndex).getText();
        actualILPN = actualILPN.trim();
        if (parentLPN.equals(actualILPN)) {
            FrameworkLogger.log(LogType.PASS, "Parent LPN Verification passed : " + parentLPN);
        } else {
            FrameworkLogger.log(LogType.FAIL,
                    "Parent LPN Verification failed. Expected : " + parentLPN + " , Actual :" + actualILPN);
        }
    }

    /**
     * Function to verify ILPNs Linked To ASN ATPalletPutAwaySystemDirected
     *
     * @param text - value which need to be used to compare
     */
    public static void verifyILPNsLinkedToASNATPalletPutAwaySystemDirected(String text) {
        String parentlpnId = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "parentlpnId");
        String lpn1Id = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "lpn1Id");
        String lpn2Id = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "lpn2Id");

        List<WebElement> elements = DriverManager.getDriver().findElements(byILPNS);
        List<String> listOfLPNs = new ArrayList<>();
        for (WebElement element : elements) {
            listOfLPNs.add(element.getText().trim());
        }
        if (text.equalsIgnoreCase("Before")) {
            if (listOfLPNs.contains(lpn1Id) && listOfLPNs.contains(lpn2Id) && listOfLPNs.contains(lpn1Id)) {
                FrameworkLogger.log(LogType.PASS, "LPNs Verification Passed. " + listOfLPNs);

            } else {
                FrameworkLogger.log(LogType.FAIL, "LPNs Verification Failed. " + listOfLPNs);
            }
        }
        if (text.equalsIgnoreCase("After")) {
            if (listOfLPNs.contains(parentlpnId)) {
                FrameworkLogger.log(LogType.FAIL,
                        "Parent LPN Verification Failed. It should not display, but its displayed: " + parentlpnId);
            } else {
                FrameworkLogger.log(LogType.PASS,
                        "Parent LPN Verification Passed. it should be disappeared. it is expected behaviour");
            }
        }

    }

    /**
     * Function to verify multiple lpns
     *
     * @param lpns - lpns value which need to be verified
     */
    public static void verifyMultipleLPNs(List<String> lpns) {
        List<WebElement> elements = DriverManager.getDriver().findElements(byILPNS);
        List<String> actualLPNs = new ArrayList<>();
        for (WebElement e : elements) {
            actualLPNs.add(e.getText());
        }
        if (lpns.equals(actualLPNs)) {
            FrameworkLogger.log(LogType.PASS, "LPNs Verification passed : " + lpns);
        } else {
            FrameworkLogger.log(LogType.FAIL,
                    "LPNs Verification failed. Expected :" + lpns + " , Actual :" + actualLPNs);
        }
    }

    /**
     * Function to click ILPN Card in ASN>ILPN
     */
    public static void clickILPNCardInILPN(String ILPN) {
        CommonMethods.waitForPageLoading();
        SeleniumActions.click(
                By.xpath("//span[contains(text(),'" + ILPN + "')]//following::div/span[contains(text(),'Parent LPN')]"),
                "Parent LPN");
        CommonMethods.waitForPageLoading();
        SeleniumActions.click(byDetailBtn, "Details Button");
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to click LPN Size Details - Box, Medium
     */
    public static void clickLPNSizeBoxMedium() {
        CommonMethods.waitForPageLoading();
        SeleniumActions.click(byEditLpnSizeTypeId, "LPN Size Type Details");
        CommonMethods.waitForPageLoading();
        GeneralUtils.wait(5 * 1000);
        SeleniumActions.click(byEditBoxMediumBtn, "Select Box,Medium button");
        CommonMethods.waitForPageLoading();
        SeleniumActions.click(bySubmitBtn, "Submit button");
    }

    /**
     * Function to click LPN Size Details - Pallet, CHEP
     */
    public static void clickLPNSizePalletCHEP() {
        CommonMethods.waitForPageLoading();
        SeleniumActions.click(byEditLpnSizeTypeId, "LPN Size Type Details");
        CommonMethods.waitForPageLoading();
        GeneralUtils.wait(5 * 1000);
        SeleniumActions.click(byEditPalletCHEPBtn, "Select Pallet,CHEP button");
        CommonMethods.waitForPageLoading();
        SeleniumActions.click(bySubmitBtn, "Submit button");
    }

    /**
     * Function to click LPN Size Details - Pallet, Euro
     */
    public static void clickLPNSizePalletEuro() {
        CommonMethods.waitForPageLoading();
        SeleniumActions.click(byEditLpnSizeTypeId, "LPN Size Type Details");
        CommonMethods.waitForPageLoading();
        GeneralUtils.wait(5 * 1000);
        SeleniumActions.click(byEditPalletEuroBtn, "Select Pallet,Euro button");
        CommonMethods.waitForPageLoading();
        SeleniumActions.click(bySubmitBtn, "Submit button");
    }

    /**
     * Function to expand LPN Attributes
     */
    public static void expandLPNAttributes() {
        CommonMethods.waitForPageLoading();
        CommonMethods.scrollByParticularElement(byLPNAttributes, "Inventory Details");
        SeleniumActions.click(byLPNAttributes, "Inventory Details");
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to check Item in Allocations
     *
     * @param expectedLPNSizeType - LPN Size Type to be verified
     */
    public static void validateLPNSizeType(String expectedLPNSizeType) {
        String actualLPNSizeType;
        CommonMethods.waitForPageLoading();
        CommonMethods.scrollByParticularElement(byLPNAttributesLPNSizeTypeId, "LPN Size Type");
        actualLPNSizeType = SeleniumActions.getText(byLPNAttributesLPNSizeTypeId).trim();
        SeleniumActions.verifyTextEquals(actualLPNSizeType, expectedLPNSizeType);
    }

    /**
     * Function to close ILPN Details
     */
    public static void closeILPNDetails() {
        CommonMethods.waitForPageLoading();
        SeleniumActions.click(byCloseExportBtn, "Close ILPN Details Popup");
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to click ILPN Card in ASN>ILPN
     */
    public static void selectILPNCardInILPN(String ILPN) {
        CommonMethods.waitForPageLoading();
        SeleniumActions.click(
                By.xpath("//span[contains(text(),'" + ILPN + "')]//following::div/span[contains(text(),'Parent LPN')]"),
                "Parent LPN");
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to verify Batch number in ILPN details page
     *
     * @param - batchNumber
     */
    public static void verifyBatchInILPNDetails(String batchNumber) {
        CommonMethods.waitForPageLoading();
        SeleniumActions.click(byDetailBtn, "Details button ");
        CommonMethods.waitForPageLoading();
        SeleniumActions.click(byInventoryDetailsButton, "Inventory Details Button");
        CommonMethods.waitForPageLoading();
        CommonMethods.scrollByParticularElement(byProductStatus, "Product Status");
        CommonMethods.waitForPageLoading();
        if (SeleniumActions.isElementPresent(By.xpath("//div[@data-component-id='" + batchNumber + "']"), 4)) {
            FrameworkLogger.log(LogType.PASS, " Batch Number is displayed as Expected");

        } else {
            FrameworkLogger.log(LogType.FAIL, " Batch Number is Not displayed as Expected");
        }
        CommonMethods.waitForPageLoading();
        SeleniumActions.click(byCloseExportBtn, "Close ILPN Details Popup");
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to verify InventoryDetails For EachLPN with Batch number
     */
    public static void verifyInventoryDetailsForEachLPNWithBatchNumber() {
        String inventoryType = getDataFromFeature("getdata(InventoryTypeID)");
        String productStatus = getDataFromFeature("getdata(ProductStatusID)");
        List<WebElement> rowElements = CommonPage.getRowElements();
        for (int i = 0; i < rowElements.size(); i++) {
            CommonMethods.scrollByParticularElement(rowElements.get(i), "element");
            rowElements.get(i).click();
            CommonMethods.waitForPageLoading();
            FooterPanelPage.clickDetailsButton();
            CommonMethods.waitForPageLoading();
            ILPNPopupPage.clickInventoryDetailsLabel();
            CommonMethods.waitForPageLoading();
            String batchNumber = getDataFromFeature("getdata(BatchNo" + (i + 1) + ")");
            String quantity = getDataFromFeature("getdata(Quantity" + (i + 1) + ")");
            String expiryDate = getDataFromFeature("getdata(ExpiryDate" + (i + 1) + ")");
            ILPNPopupPage.verifyBatchNumber(batchNumber);
            ILPNPopupPage.verifyInventoryType(inventoryType);
            ILPNPopupPage.verifyProductStatus(productStatus);
            ILPNPopupPage.verifyOnHandQuantityCellValue(quantity);
            ILPNPopupPage.verifyExpiryDateCellValue(expiryDate);
            CommonPopupPage.clickCloseIcon();
            CommonMethods.waitForPageLoading();
            rowElements.get(i).click();
            CommonMethods.waitForPageLoading();
        }
    }

    /**
     * Function to verify InventoryDetails For Multiple ILPNs
     */
    public static void verifyInventoryDetailsForMultipleIlpn() {
        List<WebElement> elements = CommonPage.getRowElements();
        for (WebElement e : elements) {
            CommonMethods.scrollByParticularElement(e, "element");
            e.click();
            CommonMethods.waitForPageLoading();
            FooterPanelPage.clickDetailsButton();
            CommonMethods.waitForPageLoading();
            CommonMethods.scrollByParticularElement(byExpandInventoryitemsfield, "Expand icon");
            SeleniumActions.click(byExpandInventoryitemsfield, "Expand icon");
            CommonMethods.waitForPageLoading();
            String productStatus = getDataFromFeature("getdata(ProductStatus)");
            String inventoryType = getDataFromFeature("getdata(InventoryType)");
            String actualProductStatus = SeleniumActions.getAtrribute(byProductStatusCellValue, "title", 20);
            String actualInventoryType = SeleniumActions.getAtrribute(byInventoryTypeCellValue, "title", 20);
            if (productStatus.equals(actualProductStatus.trim())) {
                FrameworkLogger.log(LogType.PASS, "Product Status Verification passed : " + actualProductStatus);
            } else {
                FrameworkLogger.log(LogType.FAIL, "Product Status Verification failed. Expected :+" + productStatus + " , Actual :" + actualProductStatus);
            }
            if (inventoryType.equals(actualInventoryType.trim())) {
                FrameworkLogger.log(LogType.PASS, "Inventory Type Verification passed : " + actualInventoryType);
            } else {
                FrameworkLogger.log(LogType.FAIL, "Inventory Type Verification failed. Expected :+" + inventoryType + " , Actual :" + actualInventoryType);
            }
            CommonPopupPage.clickCloseIcon();
            e.click();
            CommonMethods.waitForPageLoading();
        }
    }

    /**
     * Function to verify ILPNS status Inventory Details of ILPN without with Parent LPN
     */
    public static void verifyILPStatusAndInventoryDetailsWithoutParentILPN(){
        List<WebElement> elements = CommonPage.getRowElements();
        System.out.println("elements="+elements);
        int lpnId=0;
        for (WebElement e : elements) {
            CommonMethods.scrollByParticularElement(e, "element");
            SeleniumActions.click(e, "select lpn");
            CommonMethods.waitForPageLoading();
            FooterPanelPage.clickDetailsButton();
            CommonMethods.waitForPageLoading();
            CommonMethods.scrollByParticularElement(byExpandInventoryitemsfield, "Expand icon");
            SeleniumActions.click(byExpandInventoryitemsfield, "Expand icon");
            CommonMethods.waitForPageLoading();
            String productStatus = getDataFromFeature("getdata(ProductStatus)");
            String inventoryType = getDataFromFeature("getdata(InventoryType)");
            String actualProductStatus = SeleniumActions.getAtrribute(byProductStatusCellValue, "title", 20);
            String actualInventoryType = SeleniumActions.getAtrribute(byInventoryTypeCellValue, "title", 20);
            if (productStatus.equals(actualProductStatus.trim())) {
                FrameworkLogger.log(LogType.PASS, "Product Status Verification passed : " + actualProductStatus);
            } else {
                FrameworkLogger.log(LogType.FAIL, "Product Status Verification failed. Expected :+" + productStatus + " , Actual :" + actualProductStatus);
            }
            if (inventoryType.equals(actualInventoryType.trim())) {
                FrameworkLogger.log(LogType.PASS, "Inventory Type Verification passed : " + actualInventoryType);
            } else {
                FrameworkLogger.log(LogType.FAIL, "Inventory Type Verification failed. Expected :+" + inventoryType + " , Actual :" + actualInventoryType);
            }
            ILPNPopupPage.verifyOnHandQuantityCellValue(getDataFromFeature("getdata(OrderedQuantity)"));
            List<String> listOFiLPNs = (List<String>) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "listOFiLPNs");
            System.out.println("listOFiLPNs.get(lpnId).trim()="+listOFiLPNs.get(lpnId).trim());
            ILPNPopupPage.verifyInventorycontainer(listOFiLPNs.get(lpnId).trim());
            CommonPopupPage.clickCloseIcon();
            SeleniumActions.click(e, "select lpn");
            CommonMethods.waitForPageLoading();
            lpnId++;
        }
    }
}