package web.Pages;

import com.dhl.driver.DriverManager;
import com.dhl.reports.FrameworkLogger;
import com.dhl.reports.LogType;
import com.dhl.testdata.TestData_Json;
import com.dhl.utils.CurrentThreadInstance;
import com.dhl.utils.Variables;
import com.dhl.web.utils.SeleniumActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import stepdefinitions.CommonMethods;
import java.util.List;

public class AllocationPage extends TestData_Json {

    private static final By byexpandContainerQuantity = By.xpath("//span[contains(text(),'Container/Quantity')]");
    private static final By byContent = By.xpath("//*[contains(@data-component-id,'AllocationUomTypeId')]");
    private static final By byAllocationUOM = By.xpath("//*[text()='Allocation UOM :']");
    private static final By byReplenishmentType = By.xpath("//span[@title='Replenishment']");
    private static final By byPickPackType = By.xpath("//span[@title='Pick/Pack']");
    private static final By byAllocationResultText = By.xpath("//span[contains(text(),'Allocation result for OrderLine')]");
    private static final By byCompleteOrderText = By.xpath("//span[contains(text(),'Complete Order')]");

    /**
     * Function to verify the Allocation UOM
     */
    public static void verifyAllocationUOM() {
        CommonMethods.waitForPageLoading();
        SeleniumActions.click(byexpandContainerQuantity, "Expand Container/Quantity Tab");
        CommonMethods.waitForPageLoading();
        CommonMethods.scrollByParticularElement(byAllocationUOM, "Allocation UOM");
        String allocationUOM = getDataFromFeature("getdata(Allocationuom)");
        String text = SeleniumActions.getText(byContent);
        SeleniumActions.verifyTextEquals(allocationUOM, text, false);
    }

    /**
     * Function to verify verifyAllocationDetails
     */
    public static void verifyAllocationDetails() {
        String inventoryType = getDataFromFeature("getdata(InventoryTypeID)");
        String productStatus = getDataFromFeature("getdata(ProductStatusID)");
        String item = getDataFromFeature("getdata(Item)");
        List<WebElement> rowElements = CommonPage.getRowElements();
        for (int i = 0; i < rowElements.size(); i++) {
            CommonMethods.scrollByParticularElement(rowElements.get(i), "element");
            rowElements.get(i).click();
            CommonMethods.waitForPageLoading();
            FooterPanelPage.clickDetailsButton();
            CommonMethods.waitForPageLoading();
            AllocationPopupPage.clickItemHeaderLabel();
            AllocationPopupPage.verifyInventoryType(inventoryType);
            AllocationPopupPage.verifyProductStatus(productStatus);
            AllocationPopupPage.verifyItem(item);
            CommonPopupPage.clickCloseIcon();
            CommonMethods.waitForPageLoading();
            rowElements.get(i).click();
            CommonMethods.waitForPageLoading();
        }
        String quantity=null;
        int totalQuantity=0;
        String totalOriginalQuantity=null;
        // Verify quantity and original quantity is equal
        for (int i = 0; i < rowElements.size(); i++) {
            CommonMethods.scrollByParticularElement(rowElements.get(i), "element");
            rowElements.get(i).click();
            CommonMethods.waitForPageLoading();
            FooterPanelPage.clickDetailsButton();
            CommonMethods.waitForPageLoading();
            AllocationPopupPage.clickContainerQuantityHeaderLabel();
            quantity=AllocationPopupPage.getQuantity();
            totalOriginalQuantity=AllocationPopupPage.getOriginalQuantity();
            CommonPopupPage.clickCloseIcon();
            CommonMethods.waitForPageLoading();
            rowElements.get(i).click();
            CommonMethods.waitForPageLoading();
            totalQuantity= Integer.parseInt(quantity)+totalQuantity;
        }
        CommonMethods.verifyValue(String.valueOf(totalQuantity), totalOriginalQuantity,"Quantity","Equal");
    }


    /**
     * Function to verify Replenishment Count
     */
    public static void verifyReplenishmentCount(String count) {
        int actualCount = DriverManager.getDriver().findElements(byReplenishmentType).size();
        CommonMethods.verifyValue(String.valueOf(actualCount), count, "Replenishment Count", "GreaterThanOrEqual");
    }

    /**
     * Function to verify PickPack Count
     */
    public static void verifyPickPackCount(String count) {
        int actualCount = DriverManager.getDriver().findElements(byPickPackType).size();
        CommonMethods.verifyValue(String.valueOf(actualCount), count, "PickPack Count", "GreaterThanOrEqual");
    }

    /**
     * Function to verify Allocation Result Message in message Logging
     */
    public static void verifyAllocationResultForOrderLine() {
        WebElement element = DriverManager.getDriver().findElement(byAllocationResultText);
        String actualText = element.getText();
        String orderLine = Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "orderLine").toString();
        String originalOrder = Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder").toString();
        String orderedQuantity = getDataFromFeature("getdata(OrderedQuantity)");
        String allocatedQuantity = getDataFromFeature("getdata(OrdQty_Line)");
        String itemID = Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "Item").toString();

        String expectedText = "Allocation result for OrderLine "+orderLine+" for Order " +originalOrder+": Item: "
                + itemID + ", Ordered quantity: "+orderedQuantity+".0000, Allocated quantity: "+allocatedQuantity+".0000";
        SeleniumActions.verifyTextEquals(actualText, expectedText);

        FrameworkLogger.log(LogType.INFO, "Verify the message line starting with the text Allocation result for OrderLine :- " + actualText);

    }

    /**
     * Function to verify Complete Order Message in message Logging
     */
    public static void verifyCompleteOrderWithOrderIDdeselected() {
        WebElement element = DriverManager.getDriver().findElement(byCompleteOrderText);
        String actualText = element.getText();
        String originalOrder = Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder").toString();
        String expectedText = "Complete Order " + originalOrder + " deselected due to the 'Deselect Need' shortage option";
        SeleniumActions.verifyTextEquals(actualText, expectedText);

        FrameworkLogger.log(LogType.INFO, "Verify the message line starting with the text Complete Order deselected :- " + actualText);

    }
    public static void verifyReplenishmentDetails(){
        List<WebElement> types = DriverManager.getDriver().findElements(byReplenishmentType);
        //String actualValue = SeleniumActions.getText(byReplenishmentType);
            for (int i = 0; i < types.size(); i++) {
                if (types.get(i).getText().equalsIgnoreCase(getDataFromFeature(getData("Type")))) {
                    CommonMethods.scrollByParticularElement(types.get(i), "Replenishment");
                    SeleniumActions.clickByJS(types.get(i), "Replenishment");
                    //types.get(i).click();
                    FooterPanelPage.clickDetailsButton();
                    CommonMethods.waitForPageLoading();
                    AllocationPopupPage.clickItemHeaderLabel();
                    AllocationPopupPage.verifyBatchNumber_ItemLabel("BatchNo1");
                    CommonPopupPage.clickCloseIcon();
                    CommonMethods.waitForPageLoading();
                }
            }
    }
}
