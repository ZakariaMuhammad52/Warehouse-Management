package web.Pages;

import com.dhl.driver.DriverManager;
import com.dhl.reports.FrameworkLogger;
import com.dhl.reports.LogType;
import com.dhl.testdata.TestData_Json;
import com.dhl.web.utils.KeyboardActions;
import com.dhl.web.utils.SeleniumActions;
import org.openqa.selenium.By;
import stepdefinitions.CommonMethods;

public class ShipViaPage extends TestData_Json {
    private static final By byShipViaIDFilter = By.xpath("//ion-input[contains(@data-component-id,'ShipViaId')]/input");
    private static final By byExpandNameField = By.xpath("//span[@title='Name']/following-sibling::ion-button[contains(@data-component-id,'expand-button')]");
    private static final By byShipViaID = By.xpath("//span[contains(@data-component-id,'ShipViaId')]");
    private static final By byShipViaPage = By
            .xpath("//*[@title='Ship Via']");
    private static final By byCarrierField = By.xpath("//ion-input[contains(@data-component-id,'CarrierId.CarrierId')]/input");
    private static final By byExpandCarrierField = By.xpath("//span[@title='Carrier ID']/following-sibling::ion-button[contains(@data-component-id,'expand-button')]");

    private static final By byExpandShipViaField = By.xpath("//span[@title='Ship Via ID']/following-sibling::ion-button[contains(@data-component-id,'expand-button')]");
    public static void filterByShipViaID(String strText) {
        CommonMethods.waitForPageLoading();
        if (DriverManager.getDriver().findElements(byShipViaIDFilter).size() < 1) {
            SeleniumActions.click(byExpandShipViaField, "Expand icon");
        }
        CommonMethods.waitForPageLoading();
        SeleniumActions.getElement(byShipViaIDFilter).clear();
        SeleniumActions.sendTextToElement(byShipViaIDFilter, strText, "Ship via ID field");
        CommonMethods.waitForPageLoading();
        KeyboardActions.pressEnterKey(byShipViaIDFilter);
        CommonMethods.waitForPageLoading();
    }
    /**
     * Function to Verify Ship id
     */
    public static void verifyShipID(String shipViaID){
        String actualShidViaID = SeleniumActions.getText(byShipViaID);
        SeleniumActions.verifyTextEquals(actualShidViaID, shipViaID,false);
    }

    /**
     * Function to Verify Ship Via Page
     */
    public static void verifyShipViaPage() {
        SeleniumActions.verifyElementVisible(byShipViaPage, 20, "Ship Via Page");
    }

    /**
     * Function to Search the Carrier ID
     * button
     */
    public static void filterByCarrierID(String strText) {
        CommonMethods.waitForPageLoading();
        if (DriverManager.getDriver().findElements(byCarrierField).size() < 1) {
            SeleniumActions.click(byExpandCarrierField, "Expand icon");
        }
        SeleniumActions.getElement(byCarrierField).clear();
        SeleniumActions.sendTextToElement(byCarrierField, strText, "Carrier ID search field");
        CommonMethods.waitForPageLoading();
        KeyboardActions.pressEnterKey(byCarrierField);
        CommonMethods.waitForPageLoading();
    }

    /** Function to verify Carrier at first index
     * @param carrier - value which need to be verified
     */
    public static void verifyCarrierAtFirstIndex(String carrier) {
        carrier = carrier.trim();
        String actualItem = DriverManager.getDriver().findElement(byShipViaID)
                .getText();
        actualItem = actualItem.trim();
        if (carrier.equals(actualItem)) {
            FrameworkLogger.log(LogType.PASS, "carrierID Verification passed : " + carrier);
        } else {
            FrameworkLogger.log(LogType.FAIL, "carrierID Verification failed. Expected :" + carrier
                    + " , Actual :" + actualItem);
        }
    }

}