package web.Pages;

import com.dhl.testdata.TestData_Json;
import com.dhl.web.utils.SeleniumActions;
import org.openqa.selenium.By;
import stepdefinitions.CommonMethods;

@SuppressWarnings("unused")
public class AdjustProductStatusPopup extends TestData_Json {

    private static final By byReasonCodeField = By.xpath("//autocomplete[@formcontrolname='ReasonCode']//input");
    private static final By byNewProductStatusDropdown = By.xpath("//ion-input[contains(@data-component-id,'ToProductStatusId')]/input");
    private static final By byNewProductStatusTextField = By.xpath("//ion-searchbar[contains(@data-component-id,'searchbar')]//input");
    private static final By byDamagedItemInNewProductStatus = By.xpath("//button[contains(@data-component-id,'Damaged')]//p");
    private static final By byReasonCodeDropdown = By.xpath("//ion-input[contains(@data-component-id,'ReasonCode')]/input");
    private static final By byProdStatChangeItemInReasonCode = By.xpath("//button[contains(@data-component-id,'PS-ProdStatChange')]//p");
    private static final By byReferenceCodeTextField = By.xpath("//ion-input[contains(@data-component-id,'ReferenceText')]//input");

    /**
     * Function to select ProductStatus
     */
    public static void selectProductStatus(String text) {
        SeleniumActions.click(byNewProductStatusDropdown, "NewProductStatus Dropdown");
        CommonMethods.waitForPageLoading();
		SeleniumActions.sendTextToElement(byNewProductStatusTextField,text,"Product status");
        CommonMethods.waitForPageLoading();
		SeleniumActions.click(By.xpath("//button[@data-component-id='"+text+"']//p"), text+ "Item in NewProductStatus Dropdown");
        CommonMethods.waitForPageLoading();
    }

	/**
	 * Function to select ReasonCode
	 */
	public static void selectReasonCode(String text) {
		SeleniumActions.click(byReasonCodeDropdown, "ReasonCode Dropdown");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(By.xpath("//button[@data-component-id='"+text+"']//p"), text+ "Item in NewProductStatus Dropdown");
		CommonMethods.waitForPageLoading();
	}

    /**
     * Function to enter ReferenceCode
     * @param strText - value which need to searched
     */
    public static void enterReferenceCode(String strText) {
        SeleniumActions.clear(byReferenceCodeTextField, "ReferenceCode Text field");
        CommonMethods.waitForPageLoading();
        SeleniumActions.sendTextToElement(byReferenceCodeTextField, strText, "ReferenceCode Text field");
    }
}
