package web.Pages;

import com.dhl.testdata.TestData_Json;
import com.dhl.web.utils.SeleniumActions;
import org.openqa.selenium.By;
import stepdefinitions.CommonMethods;

@SuppressWarnings("unused")
public class PurchaseOrderLineLookup extends TestData_Json {

    private static final By byTitleBarPopUp = By.xpath("//ion-title[@data-component-id='purchaseorderlinelookup-header']");
    private static final By byPOField = By.xpath("//ion-input[@data-component-id='PurchaseOrderId-dynamic-ui-builder-textbox']/input");
    private static final By bytSearchBtn = By.xpath("//ion-button[@data-component-id='search-btn-form']");
    private static final By byPOlineCheckbox = By.xpath("//input[@data-component-id='polinecheckbox-table-container']");
    private static final By byAddtoasnBtn = By.xpath("//ion-button[@data-component-id='ADDTOASN-footer-panel']");    //addtoasn-btn - Old value change observed on 19 July 2023
    private static final By byOkBtn = By.xpath("//ion-button[@data-component-id='ok-btn-summary']");
    private static final By bysaveandfinishBtn = By.xpath("//ion-button[@data-component-id='SAVEANDFINISH-footer-panel']");    //saveandfinish-btn - old value change observed on 19 July 2023
    private static final By byQtyToAssignField = By.xpath("//input[@name='QuantityToAssign']");
    private static final By byQtyToAssignMaxError = By.xpath("//span[@data-component-id='ShippedlargerthanOrderquantity-table']");
    private static final By byQtyToAssignEmptyError = By.xpath("//span[@data-component-id='RequiredField-table']");    

    
	/**
	 * Function to verify Purchase Order Line lookup page is displayed  
	 */
    public static void verifyPageDisplayed() {
        SeleniumActions.verifyElementVisible(byTitleBarPopUp, 20, "Purchase Order Line Lookup page");
    }
    
	/**
	 * Function to search specific Purchase Order  
	 * @param strText - Purchase Order need to be searched
	 */
    public static void searchPO(String strText) {
        SeleniumActions.sendTextToElement(byPOField, strText, "PO search field");
        SeleniumActions.click(bytSearchBtn, "Search button");
        CommonMethods.waitForPageLoading();
    }
}