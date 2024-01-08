package web.Pages;

import com.dhl.reports.FrameworkLogger;
import com.dhl.reports.LogType;
import com.dhl.testdata.TestData_Json;
import com.dhl.web.utils.SeleniumActions;
import org.openqa.selenium.By;

@SuppressWarnings("unused")
public class InventoryCountDetailsPage extends TestData_Json {
    private static final By byInventoryCountDetailsPage = By.xpath("//span[contains(text(),' Inventory Count Detail')]");
    private static final By byCountStatusAsBooked = By.xpath("//span[@data-component-id='Status'][contains(text(),'Booked')]");
    private static final By byOriginalQuantity = By.xpath("//span[@data-component-id='OriginalQuantity']");
    private static final By byCountQuantity = By.xpath("//span[@data-component-id='CountQuantity']");
    private static final By byVarianceValue = By.xpath("//span[@data-component-id='VarianceValue']");

    /**
     * Function to verify Inventory Count Detail Page is displayed
     */
    public static void verifyInventoryCountDetailsPage() {
        SeleniumActions.verifyElementVisible(byInventoryCountDetailsPage, 20, " Inventory Count Details Page");
    }

    /**
     * Function to verify Count as Booked
     */
    public static void verifyCountStatusAsBooked() {
        SeleniumActions.verifyElementVisible(byCountStatusAsBooked, 20, "CountStatus as Booked");
    }

    /**
     * Function to verify the Count details like originalQuantity, countQuantity, varianceValue in inventory Count Detail Page
     */
    public static void verifyTheCountDetailsInInventoryCountDetailsPage(){
        verifyCountStatusAsBooked();
        String originalQuantity=SeleniumActions.getAtrribute(byOriginalQuantity,"title",20);
        int originalQuantityValue=Integer.parseInt((originalQuantity).trim());
        String countQuantity=SeleniumActions.getAtrribute(byCountQuantity,"title",20);
        int countQuantityValue=Integer.parseInt((countQuantity).trim());
        if (originalQuantityValue==countQuantityValue) {
            FrameworkLogger.log(LogType.PASS, "Original Quantity is Equal to Count Quantity Verification passed : "+originalQuantityValue);
        } else {
            FrameworkLogger.log(LogType.FAIL, "Original Quantity is Equal to Count Quantity Verification failed. Expected :+"+originalQuantityValue+" , Actual :"+countQuantityValue);
        }

        String variance=SeleniumActions.getAtrribute(byVarianceValue,"title",20);
        int varianceValue=Integer.parseInt((variance).trim());
        if (varianceValue==0) {
            FrameworkLogger.log(LogType.PASS, "Variance Value is Equal Zero Verification passed : "+varianceValue);
        } else {
            FrameworkLogger.log(LogType.FAIL, "Variance Value is Equal Zero Verification failed. Expected : "+0+" , Actual :"+varianceValue);
        }
    }
}
