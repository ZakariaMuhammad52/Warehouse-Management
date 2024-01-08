package web.Pages;

import com.dhl.reports.FrameworkLogger;
import com.dhl.reports.LogType;
import com.dhl.utils.CurrentThreadInstance;
import com.dhl.utils.Variables;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;

import com.dhl.testdata.TestData_Json;
import com.dhl.web.utils.KeyboardActions;
import com.dhl.web.utils.SeleniumActions;

import stepdefinitions.CommonMethods;
import stepdefinitions.ExcelUtil1;

import java.util.List;

public class PickPackLPNPage extends TestData_Json{

    private static final By byATPickOLPN = By.xpath("//ion-item[@data-component-id='atpickolpn']");

    //private static final By byScanItemText = By.xpath("//*[contains(@data-component-id,'acceptitem_barcodetextfield_item')]");

    //private static final By byScanItemInput = By.xpath("//input[contains(@data-component-id,'acceptitem_barcodetextfield_scanitem')]");
    //private static final By byGoButton = By.xpath("//ion-button[contains(@data-component-id,'barcodetextfield_go')]");

    private static final By byInformationMessageLabel = By.xpath("//div[@class='alert-wrapper ion-overlay-wrapper sc-ion-alert-md']");
    private static final By byInformationOkButton = By.xpath("//button[contains(@class,'alert-button ion-focusable ion-activatable sc-ion-alert-md')]");




    /**
     * Function to verify AT Pick OLPN Page is displayed
     */
    public static void verifyAtPickOlpnPageDisplayed() {
        SeleniumActions.verifyElementVisible(byATPickOLPN, 20, "AT Pick 0LPN page");
    }

    /**
     * Function to complete FN PackILPN Directed Process
     */
    public static void completeATPickOlpnProcess(int count) {
        CommonWMMobilePage.enterScanOLPN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "OLPN").toString());
        CommonWMMobilePage.clickGoButton();
        String item = null;
        String quantity = null;
        for (int i = count; i >= 1; i--) {
            item = CommonWMMobilePage.getItemText().replaceAll("-", "");
            Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "CurrentItem" + i, item);
            CommonWMMobilePage.enterScanItem(item);
            CommonWMMobilePage.clickGoButton();
            quantity = CommonWMMobilePage.getQuantityNeedText().trim();
            CommonWMMobilePage.enterQuantity(quantity);
            CommonWMMobilePage.clickGoButton();
        }
    }


    /*
    public static void enterScanItem() {
        String strScanItem = SeleniumActions.getText(byScanItemText);
        if (strScanItem != null && !strScanItem.trim().isEmpty()) {
            //Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "Item", strScanItem.trim());
            SeleniumActions.getElement(byScanItemInput).clear();
            String strSysScanItem = strScanItem.replace("-", "");
            SeleniumActions.sendTextToElement(byScanItemInput, strSysScanItem.trim(), "Scan Item field");
            SeleniumActions.click(byGoButton, "Go button");
            CommonMethods.waitForPageLoading();
        } else {
            FrameworkLogger.log(LogType.FAIL, "Scan Item is null or empty");
        }
    }*/

    /**
     * Function to verify request verify End of OLPN submitted message is displayed
     *
     */
    public static void verifyInformationEndOfOlpn() {
        String strOLPNInformation = SeleniumActions.getText(byInformationMessageLabel);
        if (strOLPNInformation != null && !strOLPNInformation.trim().isEmpty()) {
            FrameworkLogger.log(LogType.PASS, strOLPNInformation + " OLPN has been submitted successfully.");
            SeleniumActions.click(byInformationOkButton, "Ok button");
        } else {
            FrameworkLogger.log(LogType.FAIL, "Information End of OLPN message is not displayed");
        }
    }

    /**
     * Function to Pack All OLPNs
     */
    public static void completeAllATPickOlpn(int count) {
        for (int i = 1; i <= count; i++) {
            CommonWMMobilePage.enterScanOLPN(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "OLPN" +i +"").toString());
            CommonWMMobilePage.clickGoButton();
            CommonWMMobilePage.enterScanItem(CommonWMMobilePage.getItemText().replaceAll("-", ""));
            CommonWMMobilePage.clickGoButton();
            CommonWMMobilePage.enterQuantity(CommonWMMobilePage.getQuantityNeedText().trim());
            CommonWMMobilePage.clickGoButton();
            verifyInformationEndOfOlpn();
        }
    }

    /**
     * Function to Pack All OLPNs with individual serial number
     */
    public static void completeATPickToOlpnWithSerialNumber() {
        List<String> listOFoLPNs = (List<String>) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "OLPN");
        String serialNumberRequired = getDataFromFeature("getdata(SerialNumberRequiredForItem)");
        PickPackLPNPage.verifyAtPickOlpnPageDisplayed();
        int j = 1;
            for (String oLPN : listOFoLPNs) {
                CommonMethods.waitForPageLoading();
                CommonWMMobilePage.enterScanOLPN(oLPN);
                FrameworkLogger.log(LogType.INFO, "Set value for oLPN : " + oLPN);
                CommonWMMobilePage.clickGoButton();
                CommonWMMobilePage.enterScanItem(CommonWMMobilePage.getItemText().replaceAll("-", ""));
                CommonWMMobilePage.clickGoButton();
                CommonWMMobilePage.enterQuantity(CommonWMMobilePage.getQuantityNeedText().trim());
                CommonWMMobilePage.clickGoButton();

                if (serialNumberRequired.equalsIgnoreCase("Yes")) {
                    CommonWMMobilePage.enterSerialNumber((String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "serialNumber" + j));
                    FrameworkLogger.log(LogType.INFO, "Set value for Serial Number : " + Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "serialNumber" + j));
                    CommonWMMobilePage.clickGoButton();
                    PickPackLPNPage.verifyInformationEndOfOlpn();
                }
                j++;

            }
        }

}
