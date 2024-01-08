package web.Pages;

import com.dhl.testdata.TestData_Json;
import com.dhl.web.utils.SeleniumActions;
import org.openqa.selenium.By;
import stepdefinitions.CommonMethods;

public class AllocationPopupPage extends TestData_Json {

    private static final By byContainerQuantityHeaderLabel = By.xpath("//span[normalize-space()='Container/Quantity']");
    private static final By byItemHeaderLabel = By.xpath("//ion-icon//following-sibling::span[normalize-space()='Item']");
    private static final By byOrderFulfillmentHeaderLabel = By.xpath("//span[normalize-space()='Order Fulfillment']");
    private static final By byOriginalQuantity = By.xpath("//div[contains(@data-component-id,'OriginalQuantity')]");
    private static final By byQuantity = By.xpath("//div[@data-component-id='Quantity-list-expand']");
    private static final By byItem = By.xpath("//div[contains(@data-component-id,'ItemId')]");
    private static final By byProductStatus = By.xpath("//div[@data-component-id='ProductStatusId-list-expand']");
    private static final By byInventoryType = By.xpath("//div[@data-component-id='InventoryTypeId-list-expand']");
    private static final By byBatchNumber = By.xpath("//div[@data-component-id='BatchNumber-list-expand']");
    /**
     * Function to click ContainerQuantityHeader Label
     */
    public static void clickContainerQuantityHeaderLabel() {
        SeleniumActions.click(byContainerQuantityHeaderLabel, "ContainerQuantityHeader Label");
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to click ItemHeader Label
     */
    public static void clickItemHeaderLabel() {
        SeleniumActions.click(byItemHeaderLabel, "ItemHeader Label");
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to click OrderFulfillmentHeader Label
     */
    public static void clickOrderFulfillmentHeaderLabel() {
        SeleniumActions.click(byOrderFulfillmentHeaderLabel, "OrderFulfillmentHeader Label");
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to verify Inventory Type
     * @param text - value to verify
     */
    public static void verifyInventoryType(String text) {
        String actualText = SeleniumActions.getText(byInventoryType);
        SeleniumActions.verifyTextEquals(actualText,text,false);
    }

    /**
     * Function to verify ProductStatus
     * @param text - value to verify
     */
    public static void verifyProductStatus(String text) {
        String actualText = SeleniumActions.getText(byProductStatus);
        SeleniumActions.verifyTextEquals(actualText,text,false);
    }

    /**
     * Function to verify Quantity And OriginalQuantity AreEqual
     */
    public static void verifyQuantityAndOriginalQuantityAreEqual() {
        String quantity = SeleniumActions.getText(byQuantity);
        String originalQuantity = SeleniumActions.getText(byOriginalQuantity);
        CommonMethods.verifyValue(originalQuantity,quantity,"Quantity","Equal");
    }

    /**
     * Function to verify Item
     * @param text - value to verify
     */
    public static void verifyItem(String text) {
        String actualText = SeleniumActions.getText(byItem);
        SeleniumActions.verifyTextEquals(actualText,text,false);
    }

    /**
     * Function to get Quantity
     */
    public static String getQuantity() {
        return SeleniumActions.getText(byQuantity);
    }

    /**
     * Function to get Original Quantity
     */
    public static String getOriginalQuantity() {
        return SeleniumActions.getText(byOriginalQuantity);
    }
    public static void verifyBatchNumber_ItemLabel(String text) {
        String actualText = SeleniumActions.getText(byBatchNumber);
        SeleniumActions.verifyTextEquals(actualText,getDataFromFeature(getData(text)),false);
    }
}
