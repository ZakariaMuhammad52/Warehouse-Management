package web.Pages;

import com.dhl.driver.DriverManager;
import com.dhl.testdata.TestData_Json;
import com.dhl.utils.CurrentThreadInstance;
import com.dhl.utils.Variables;
import com.dhl.web.utils.KeyboardActions;
import com.dhl.web.utils.SeleniumActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import stepdefinitions.CommonMethods;

@SuppressWarnings("unused")
public class InventoryCountPage extends TestData_Json {
    private static final By byInventoryCountPage = By.xpath("//span[contains(text(),' Inventory Count')]");
    private static final By byTaskId = By.xpath("//ion-input[contains(@data-component-id,'TaskId')]/input");
    private static final By byCountStatusAsBooked = By.xpath("//div[@title='Booked'][contains(text(),'Booked')]");
    private static final By byCountRunId = By.xpath("//a[contains(@data-component-id,'CountRunId')]");
    private static final By byQuickSelect = By.xpath("//ion-col[@data-component-id='quickselect']");
    private static final By byTodayFromQuickSelect = By.xpath("//ion-item[@data-component-id='TODAY']");
    private static final By byInventoryAdjustmentPIXVisibilty = By.xpath("//ion-checkbox[@data-component-id='InventoryAdjustment']");
    private static final By byExpandarrowButtonINPIXVisibility = By.xpath("//button[@data-component-id='action-closed']/div");
    private static final By byPIXVisibiltybutton = By.xpath("//button[@data-component-id='PIXData']/div");
    private static final By goBackToInventoryCount = By.xpath("(//a[@title='Inventory Count'])[1]");
    private static final By CreateCycleCountTask = By.xpath("//button[@data-component-id='CreateCountTask']");
    private static final By bySelectCycleCountCheckbox = By.xpath("//ion-checkbox[@data-component-id='CycleCount']");
    private static final By byCountStatusAsPendingBooking = By.xpath("//div[@title='Pending Booking'][contains(text(),'Pending Booking')]");
    private static final By byCountStatusAsBookingRejected = By.xpath("//div[@title='Booking Rejected'][contains(text(),'Booking Rejected')]");
    private static final By byCountRunIdFilter = By.xpath("//ion-input[@data-component-id='CountRunId']/input[@class='native-input sc-ion-input-md']");
    private static final By byCreateCountTask = By.xpath("//ion-button[@data-component-id='CreateCountTask']");

    /**
     * Function to verify Inventory Count Page is displayed
     */
    public static void verifyInventoryCountPage() {
        SeleniumActions.verifyElementVisible(byInventoryCountPage, 20, "Inventory Count Page");
    }

    /**
     * Function to verify Count as Booked
     */
    public static void verifyCountStatusAsBooked() {
        SeleniumActions.verifyElementVisible(byCountStatusAsBooked, 20, "CountStatus as Booked");
    }

    /**
     * Function to click Count RunId
     */
    public static void clickCountRunId() {
        SeleniumActions.click(byCountRunId, "Count Run Id");
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to enter taskId
     * @param taskId - value which need to be entered
     */
    public static void enterTask(String taskId) {
        SeleniumActions.sendTextToElement(byTaskId, taskId, "TaskId Text Field");
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to search taskId
     *
     * @param taskId - value which need to be searched
     */
    public static void searchTask(String taskId) {
        enterTask(taskId);
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to click quickSelect
     *
     */
    public static void clickQuickSelect() {
        SeleniumActions.getElement(byQuickSelect).click();
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to Select Today from quickSelect
     *
     */
    public static void SelectTodayFromQuickSelect() {
        SeleniumActions.getElement(byTodayFromQuickSelect).click();
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to Select Inventory Adjustment PIX Visibility
     *
     */
    public static void SelectInventoryAdjustmentPIXVisibility() {
        SeleniumActions.getElement(byInventoryAdjustmentPIXVisibilty).click();
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to expand PIX Visibility Arrow Button
     *
     */
    public static void expandPIXVisibilityArrowButton() {
            SeleniumActions.getElement(byExpandarrowButtonINPIXVisibility).click();
            CommonMethods.waitForPageLoading();
        }

    /**
     * Function to Select PIX Visibility Button
     *
     */
    public static void SelectPIXVisibilitywButton() {
        SeleniumActions.getElement(byPIXVisibiltybutton).click();
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to go back to inventory count
     *
     */
    public static void goBackToInventoryCount() {
        SeleniumActions.getElement(goBackToInventoryCount).click();
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to click create cycle count task
     *
     */
    public static void CreateCycleCountTask() {
        SeleniumActions.getElement(CreateCycleCountTask).click();
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to click cycle count checkbox
     *
     */
    public static void SelectCycleCountCheckbox() {
        SeleniumActions.getElement(bySelectCycleCountCheckbox).click();
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to click Count Status Pending Booking
     *
     */
    public static void VerifyCountStatusAsPendingBooking() {
        SeleniumActions.getElement(byCountStatusAsPendingBooking).click();
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to click Count Status Booking rejected
     *
     */
    public static void VerifyCountStatusAsBookingRejected() {
        SeleniumActions.getElement(byCountStatusAsBookingRejected).click();
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to set count run
     *
     */
    public static void SetCountRunID() {
        WebElement element = DriverManager.getDriver().findElement(byCountRunId);
        String text=element.getText().trim();
        System.out.println("byTaskIdAtFirstIndex stored in variable:- " + text);
        Variables.set(CurrentThreadInstance.getCurrentScenarioId()+"Count Run Id", text);
    }

    /**
     * Function to filter count run
     *
     */
    public static void filterCountRunID() {
        String countRunID = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "Count Run Id");
        CommonMethods.waitForPageLoading();
        SeleniumActions.sendTextToElement(byCountRunIdFilter, countRunID, "CountRunIDFilterTextBox");
        KeyboardActions.pressEnterKey(byCountRunIdFilter);
    }

    /**
     * Function to click on create count run
     *
     */
    public static void CreateCountTask() {
        SeleniumActions.getElement(byCreateCountTask).click();
        CommonMethods.waitForPageLoading();
    }

}