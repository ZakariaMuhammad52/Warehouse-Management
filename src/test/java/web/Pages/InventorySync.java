package web.Pages;

import com.dhl.driver.DriverManager;
import com.dhl.reports.FrameworkLogger;
import com.dhl.reports.LogType;
import com.dhl.testdata.TestData_Json;
import com.dhl.web.utils.KeyboardActions;
import com.dhl.web.utils.SeleniumActions;
import org.openqa.selenium.By;
import stepdefinitions.CommonMethods;

public class InventorySync extends TestData_Json {
    private static final By byOpenSlideOption = By.xpath("//slider-actions[contains(@data-component-id,'Slide-Actions')]//button[contains(@data-component-id,'action-closed')]");
    private static final By byCloseSlideOption = By.xpath("//div[contains(@class,'slideOptionList')]/button[contains(@data-component-id,'action-open')]");
    private static final By byEditConfiguration = By.xpath("//slider-actions[contains(@data-component-id,'Slide-Actions')]//button[contains(@data-component-id,'Edit')]");
    private static final By bySearchItemTextField = By.xpath("//input[@placeholder='Item']");
    private static final By bySearchItemLookUp = By.xpath("//button[contains(@data-component-id,'ItemIdSearch')]");
    private static final By bySubmitBtn = By.xpath("//ion-button[contains(@data-component-id,'submit-btn')]");
    private static final By byGroupByItem = By.xpath("//span[text()='Group by item attributes ']//preceding::ion-checkbox[@aria-checked='true']");
    private static final By bySaveBtn = By.xpath("//ion-button[contains(text(),'SAVE')]");
    private static final By byCloseConfiguration = By.xpath("//button//ion-icon[@name='close']");
    private static final By byRunInventorySync = By.xpath("//button[contains(@data-component-id,'Run')]");
    private static final By byRunSuccessMessage = By.xpath("//div[contains(text(),'Successfully submitted request for processing (DCI::435)')]");
    private static final By byInventorySyncPage = By.xpath("//span[contains(text(),'Inventory Sync')]");

    /**
     * Function to check Inventory Sync Page is Displayed
     */
    public static void verifyInventorySyncPageDisplayed() {
        SeleniumActions.verifyElementVisible(byInventorySyncPage, 20, "Inventory Sync page");
    }

    /**
     * Function to open slide options in Inventory Sync Page
     */
    public static void openSlideOption() {
        CommonMethods.waitForPageLoading();
        SeleniumActions.click(byOpenSlideOption, "Open Slide Option of Inventory Sync");
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to close slide options in Inventory Sync Page
     */
    public static void closeSlideOption() {
        CommonMethods.waitForPageLoading();
        SeleniumActions.click(byCloseSlideOption, "Close Slide Option of Inventory Sync");
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to search Item in configuration window
     * @param strItemText -  which need to searched
     */
    public static void searchItem(String strItemText) {
        String strItem;
        CommonMethods.waitForPageLoading();
        if (strItemText != null && !strItemText.trim().isEmpty()) {  strItem= strItemText;} else {  strItem = SeleniumActions.getText(bySearchItemTextField); }
        CommonMethods.waitForPageLoading();
        SeleniumActions.getElement(bySearchItemTextField).clear();
        SeleniumActions.sendTextToElement(bySearchItemTextField, strItem, "ItemId search field");
        CommonMethods.waitForPageLoading();
        SeleniumActions.click(bySearchItemLookUp, "Lookup Item");
        CommonMethods.waitForPageLoading();
        SeleniumActions.click(By.xpath("//div[contains(text(),'" + strItem + "')]"), "Item ID Radio Button");
        CommonMethods.waitForPageLoading();
        SeleniumActions.click(bySubmitBtn, "Submit button");
        CommonMethods.waitForPageLoading();

    }

    /**
     * Function to select groupby Item checkbox
     */
    public static void enableGroupByItem() {
        CommonMethods.waitForPageLoading();
        if(!SeleniumActions.isElementEnabled(byGroupByItem,1)){
            SeleniumActions.click(byGroupByItem, "Close Slide Option of Inventory Sync");
            CommonMethods.waitForPageLoading();
        }
        FrameworkLogger.log(LogType.PASS, "Group By Item Attribute is enabled");
    }

    /**
     * Function to select save configuration
     */
    public static void saveConfiguration() {
        CommonMethods.waitForPageLoading();
        SeleniumActions.click(bySaveBtn, "click Save button");
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to close configuration screen
     */
    public static void closeConfiguration() {
        SeleniumActions.click(byCloseConfiguration, "Close Inventory Details");
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to run Inventory Sync
     */
    public static void runInventorySync() {
        SeleniumActions.click(byRunInventorySync, "Run Inventory Sync");
        CommonMethods.waitForPageLoading();

    }

    /**
     * Function to Verify Success Message is displayed
     *
     */
    public static void verifySuccessMessage() {
        SeleniumActions.verifyElementVisible(byRunSuccessMessage, 20, "Successfully Submitted");

    }

}
