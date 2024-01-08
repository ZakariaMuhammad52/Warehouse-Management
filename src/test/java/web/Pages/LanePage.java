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

import static com.dhl.web.utils.SeleniumActions.getText;
import static com.dhl.web.utils.SeleniumActions.isElementVisible;

@SuppressWarnings("unused")
public class LanePage extends TestData_Json {
    private static final By byShipViaValue = By
            .xpath("//card-view[@class='dm-fill-space card-views']//div[contains(@class,'card-row primary selected-card')]//div//div//span[contains(@data-component-id,'ShipViaId')]");
    private static final By byExpandCartonAttributeIcon =By
            .xpath("//div[@class='expand-header-container ng-star-inserted']/span[contains(text(),'Carton Attributes')]");
    private static final By byWeight =By
            .xpath("//div[@class='labelHeader']/div[contains(@data-component-id,'EstimatedWeight')]");
    private static final By byVolume =By
            .xpath("//div[@class='labelHeader']/div[contains(@data-component-id,'EstimatedVolume')]");
    private static final By byCloseDetailsPageIcon =By.xpath("//modal-header[@class='draghandle']//ion-icon[@name='close']");
    private static final By byShipViaATL1E =By.xpath("//card-view[@class='dm-fill-space card-views']//div[contains(@class,'card-row primary')]//div//div//span[contains(@data-component-id,'ShipViaId')][@title='ATL1E']");
    private static final By byShipViaATL2E =By.xpath("//card-view[@class='dm-fill-space card-views']//div[contains(@class,'card-row primary')]//div//div//span[contains(@data-component-id,'ShipViaId')][@title='ATL2E']");
    private static final By byShipViaATL4E =By.xpath("//card-view[@class='dm-fill-space card-views']//div[contains(@class,'card-row primary')]//div//div//span[contains(@data-component-id,'ShipViaId')][@title='ATL4E']");
    private static final By byContainerType =By.xpath("//div[@class='labelHeader']/div[contains(@data-component-id,'ContainerTypeId')]");
    private static final By byShipmentId =By.xpath("//card-view[@class='dm-fill-space card-views']//div[contains(@class,'card-row primary selected-card')]//div//div//span[contains(@data-component-id,'ShipmentId')]");
    private static final By byOlpnId =By.xpath("//card-view[@class='dm-fill-space card-views']//div[contains(@class,'card-row primary selected-card')]//div//div//span[contains(@data-component-id,'OlpnId')]");
    private static final By byShipViaATL5E =By.xpath("//card-view[@class='dm-fill-space card-views']//div[contains(@class,'card-row primary')]//div//div//span[contains(@data-component-id,'ShipViaId')][@title='ATL5E']");
    private static final By byShipmentRowAtFirstIndex = By
            .xpath("(//card-view[@class='dm-fill-space card-views']//div[contains(@class,'card-row primary')])[1]");// Need
    private static final By bySelectedShipViaATL4E =By
            .xpath("//card-view[@class='dm-fill-space card-views']//div[contains(@class,'card-row primary selected-card')]//div//div//span[contains(@data-component-id,'ShipViaId')][@title='ATL4E']");
    private static final By byExpandDeliveryIcon =By.xpath("//div[@class='expand-header-container ng-star-inserted']/span[contains(text(),'Delivery')]");
    private static final By byState =By
            .xpath("//div[@class='labelHeader']/div[contains(@data-component-id,'DestinationAddress.State')]");
    private static final By byPostalCode =By
            .xpath("//div[@class='labelHeader']/div[contains(@data-component-id,'DestinationAddress.PostalCode')]");
    private static final By byNavigationLinkOlpns =By.xpath("//dm-breadcrumb/div[@class='breadcrumb-container ng-star-inserted']/ul/li[contains(@data-component-id,'oLPNs')]");
    private static final By byCountry =By.xpath("//div[@class='labelHeader']/div[contains(@data-component-id,'DestinationAddress.Country')]");
    private static final By byNavigationLaneLink =By.xpath("//ul/li[contains(@data-component-id,'Lane-breadcrumb-component')]");
    private static final By byATDHLENZRow =By.xpath("(//card-view[@class='dm-fill-space card-views']//div[contains(@class,'card-row primary')])//span[@title='ATDHLENZ']");
    private static final By byATL7ERow=By.xpath("(//card-view[@class='dm-fill-space card-views']//div[contains(@class,'card-row primary')])//span[@title='ATL7E']");
    private static final By byContainerTypeValue =By.xpath("//card-view[@class='dm-fill-space card-views']//div[contains(@class,'card-row primary selected-card')]//div//div//span[contains(@data-component-id,'ContainerTypeId')]");
    private static final By byAUVIC =By.xpath("//span[@title='AU_VIC']");
    private static final By byEditBtn = By.xpath("//ion-button[contains(@data-component-id,'Edit')]");
    private static final By bySaveContinueBtn = By.xpath("//button[contains(@data-component-id,'saveandcontinue')]");
    private static final By bySaveClose =By.xpath("//button[contains(@data-component-id,'SaveAndClose')]");
    private static final By byCountryId =By.xpath("//span[contains(@data-component-id,'CountryId')]");
    private static final By byFromPostalCode1 =By.xpath("//span[@title='3000']");
    private static final By byToPostalCode1 =By.xpath("//span[@title='3999']");
    private static final By byFromPostalCode2 =By.xpath("//span[@title='8000']");
    private static final By byToPostalCode2 =By.xpath("//span[@title='8999']");
    private static final By byAU_QLD =By.xpath("//span[@title='AU_QLD']");
    private static final By byQLDFromPostalCode1 =By.xpath("//span[@title='4000']");
    private static final By byQLDToPostalCode1 =By.xpath("//span[@title='4999']");
    private static final By byQLDFromPostalCode2 =By.xpath("//span[@title='9000']");
    private static final By byQLDToPostalCode2 =By.xpath("//span[@title='9999']");

    /**
     * Function to verify  Carrier ID is displayed in row
     * @param carrier1,carrrier2- Pass the value for carrier
     *
     */
    public static void verifyCarrierIDDisplayed(String carrier1, String carrier2) {

        By bycarrierRowAtFirstIndex =By.xpath("//div/a[contains(text(),'"+carrier1+"')]");
        By bycarrierRowAtSecondIndex = By.xpath("//div/a[contains(text(),'"+carrier2+"')]");
        SeleniumActions.verifyElementVisible(bycarrierRowAtFirstIndex, 20, "carrier 1 card displayed");
        CommonMethods.scrollByParticularElement(bycarrierRowAtSecondIndex, "Scroll to carrier 2 card");
        SeleniumActions.verifyElementVisible(bycarrierRowAtSecondIndex, 20, "carrier 2 card displayed");
    }
    /**
     * Function to verify Lane Carrier Shipment details in Routing Lane Options
     */
    public static void verifyCarrierShipmentDetailsInRoutingLaneOption(){
        List<WebElement> elements = CommonPage.getRowElements();
        if( SeleniumActions.isElementVisible(byShipViaATL1E, 10) & SeleniumActions.isElementVisible(byShipViaATL2E, 10) )
        {
            for (WebElement e : elements)
            {
                CommonMethods.scrollByParticularElement(e, "element");
                SeleniumActions.click(e, "select olpn");
                CommonMethods.waitForPageLoading();
                String shipViaValue =  SeleniumActions.getText(byShipViaValue).trim();
                if(shipViaValue.contains(getDataFromFeature("getdata(Carrier1)"))) {
                    FooterPanelPage.clickDetailsButton();
                    SeleniumActions.click(byExpandCartonAttributeIcon, "Expand Carton Attribute");
                    CommonMethods.waitForPageLoading();
                    int volume= Integer.parseInt(SeleniumActions.getText(byVolume).trim().replaceAll(",", ""));
                    double weight = Double.parseDouble(SeleniumActions.getText(byWeight).trim());
                    if(weight < 125){
                        FrameworkLogger.log(LogType.PASS, "For AT2LE Weight < 125kg passed : " + weight);
                    }else{
                        FrameworkLogger.log(LogType.FAIL, "For AT2LE Weight not < 125kg failed : " + weight);
                    }
                    if(volume < 1000000){
                        FrameworkLogger.log(LogType.PASS, "For AT2LE volume < 1000000 passed : " + volume);
                    }else{
                        FrameworkLogger.log(LogType.FAIL, "For AT2LE volume not < 1000000 failed : " + volume);
                    }
                }else if(shipViaValue.contains(getDataFromFeature("getdata(Carrier2)"))) {
                    FooterPanelPage.clickDetailsButton();
                    SeleniumActions.click(byExpandCartonAttributeIcon, "Expand Carton Attribute");
                    CommonMethods.waitForPageLoading();
                    int volume= Integer.parseInt(SeleniumActions.getText(byVolume).trim().replaceAll(",", ""));
                    double weight = Double.parseDouble(SeleniumActions.getText(byWeight).trim());
                    if(weight > 125){
                        FrameworkLogger.log(LogType.PASS, "For AT1LE Weight > 125kg passed : " + weight);
                    }else{
                        FrameworkLogger.log(LogType.FAIL, "For AT1LE Weight not > 125kg failed : " + weight);
                    }
                    if(volume > 1000000){
                        FrameworkLogger.log(LogType.PASS, "For AT1LE volume > 1000000 passed : " + volume);
                    }else{
                        FrameworkLogger.log(LogType.FAIL, "For AT1LE volume not > 1000000 failed : " + volume);
                    }
                }
                CommonMethods.waitForPageLoading();
                SeleniumActions.click(byCloseDetailsPageIcon, "Close Icon OLPNs Details Page");
                CommonMethods.waitForPageLoading();
                CommonMethods.scrollByParticularElement(e, "element");
                CommonMethods.waitForPageLoading();
                SeleniumActions.click(e, "Deselect olpn");
                CommonMethods.waitForPageLoading();
            }
        }else{
            FrameworkLogger.log(LogType.FAIL, "For AT1LE  AT2LE  not Present failed : ");
        }
    }
    /**
     * Function to verify Lane Carrier ATL4E Shipment details in Routing Lane Options
     */
    public static void verifyCarrierShipmentATL4EDetailsInRoutingLaneOption() {

        List<WebElement> elements = CommonPage.getRowElements();
        if (SeleniumActions.isElementVisible(byShipViaATL4E, 10)) {
            for (WebElement e : elements) {
                CommonMethods.scrollByParticularElement(e, "element");
                SeleniumActions.click(byShipViaATL4E, "select olpn");
                CommonMethods.waitForPageLoading();
                String shipViaValue = SeleniumActions.getText(byShipViaATL4E).trim();
                String shipmentId = SeleniumActions.getText(byShipmentId).trim();
                String olpnId = SeleniumActions.getText(byOlpnId).trim();
                System.out.println("shipmentId=" + shipmentId);
                System.out.println("olpnId=" + olpnId);
                Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ShipmentId", shipmentId);
                Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "OlpnID", olpnId);
                if (shipViaValue.contains(getDataFromFeature("getdata(Carrier2)"))) {
                    FooterPanelPage.clickDetailsButton();
                    SeleniumActions.click(byExpandCartonAttributeIcon, "Expand Carton Attribute");
                    CommonMethods.waitForPageLoading();
                    int volume = Integer.parseInt(SeleniumActions.getText(byVolume).trim().replaceAll(",", ""));
                    double weight = Double.parseDouble(SeleniumActions.getText(byWeight).trim());
                    if (weight > 50 & weight == 60) {
                        FrameworkLogger.log(LogType.PASS, "For ATL4E Weight > 50 and Weight = 60 passed : " + weight);
                    } else {
                        FrameworkLogger.log(LogType.FAIL, "For ATL4E Weight not > 50 and Weight not = 60 failed : " + weight);
                    }
                    if (volume == 50000) {
                        FrameworkLogger.log(LogType.PASS, "For ATL4E volume = 50000 passed : " + volume);
                    } else {
                        FrameworkLogger.log(LogType.FAIL, "For ATL4E volume not = 50000 failed : " + volume);
                    }
                    CommonMethods.waitForPageLoading();
                    if (SeleniumActions.isElementVisible(byContainerType, 10)) {

                        FrameworkLogger.log(LogType.PASS, "For ATL4E Container Type is not Allocated : passed : ");
                    } else {
                        FrameworkLogger.log(LogType.FAIL, "For ATL4E Container Type is  Allocated : Fail : ");
                    }
                    CommonMethods.waitForPageLoading();
                    SeleniumActions.click(byCloseDetailsPageIcon, "Close Icon OLPNs Details Page");
                    CommonMethods.waitForPageLoading();
                }
            }
        }
    }
    /**
     * Function to verify  Carrier ID is displayed in row
     * @param carrier1,carrrier2- Pass the value for carrier
     *
     */
    public static void verifyCarrierIDDisplayedAtSecondAndThirdIndex(String carrier1, String carrier2) {

        By bycarrierRowAtSecondIndex = By.xpath("//card-view[@class='dm-fill-space card-views']//div[contains(@class,'card-row primary')]//div/a[@title='"+carrier2+"']");
        By bycarrierRowAtThirdIndex = By.xpath("//card-view[@class='dm-fill-space card-views']//div[contains(@class,'card-row primary')]//div/a[@title='"+carrier1+"']");
        CommonMethods.scrollByParticularElement(bycarrierRowAtSecondIndex, "Scroll to carrier 2 card");
        SeleniumActions.verifyElementVisible(bycarrierRowAtSecondIndex, 20, "carrier 2 card displayed");
        CommonMethods.scrollByParticularElement(bycarrierRowAtThirdIndex, "Scroll to carrier 1 card");
        SeleniumActions.verifyElementVisible(bycarrierRowAtThirdIndex, 20, "carrier 1 card displayed");
    }
    /**
     * Function to verify Lane Carrier ATL4E, ATL5E Shipment details in Routing Lane Options
     */
    public static void verifyCarrierShipmentDetailsForATL4EAndATL5EInRoutingLaneOption() {
        List<WebElement> elements = CommonPage.getRowElements();
        if (SeleniumActions.isElementVisible(byShipViaATL4E, 10) & SeleniumActions.isElementVisible(byShipViaATL5E, 10)) {
            System.out.println("Carrier ATL4E Destined to VIC AND Carrier ATL5E Destined to QLD are Existing");
            for (WebElement e : elements) {
                CommonMethods.scrollByParticularElement(e, "element");
                SeleniumActions.click(e, "select olpn");
                CommonMethods.waitForPageLoading();
                String shipViaValue = SeleniumActions.getText(byShipViaValue).trim();
                if (shipViaValue.contains(getDataFromFeature("getdata(Carrier1)"))) {
                    FooterPanelPage.clickDetailsButton();
                    SeleniumActions.click(byExpandCartonAttributeIcon, "Expand Carton Attribute");
                    CommonMethods.waitForPageLoading();
                    int volume = Integer.parseInt(SeleniumActions.getText(byVolume).trim().replaceAll(",", ""));
                    double weight = Double.parseDouble(SeleniumActions.getText(byWeight).trim());
                    if (weight > 50) {
                        FrameworkLogger.log(LogType.PASS, "For ATL4E Weight > 50kg passed : " + weight);
                    } else {
                        FrameworkLogger.log(LogType.FAIL, "For AT4LE Weight not > 50kg failed : " + weight);
                    }
                } else if (shipViaValue.contains(getDataFromFeature("getdata(Carrier5)"))) {
                    FooterPanelPage.clickDetailsButton();
                    SeleniumActions.click(byExpandCartonAttributeIcon, "Expand Carton Attribute");
                    CommonMethods.waitForPageLoading();
                    int volume = Integer.parseInt(SeleniumActions.getText(byVolume).trim().replaceAll(",", ""));
                    double weight = Double.parseDouble(SeleniumActions.getText(byWeight).trim());
                    if (volume < 250000) {
                        FrameworkLogger.log(LogType.PASS, "For ATL5E volume < 250000 passed : " + volume);
                    } else {
                        FrameworkLogger.log(LogType.FAIL, "For ATL5E volume not < 250000 failed : " + volume);
                    }
                }
                CommonMethods.waitForPageLoading();
                SeleniumActions.click(byCloseDetailsPageIcon, "Close Icon OLPNs Details Page");
                CommonMethods.waitForPageLoading();
                CommonMethods.scrollByParticularElement(e, "element");
                CommonMethods.waitForPageLoading();
                SeleniumActions.click(e, "Deselect olpn");
                CommonMethods.waitForPageLoading();
            }
        }else{
            FrameworkLogger.log(LogType.FAIL, "For ATL4E  not Present failed : ");
        }
    }

    /**
     * Function to verify Carrier Shipment Details In Shipment Page
     * @param - olpnId parameter to verify olpnid details
     */
    public static void verifyCarrierShipmentDetailsInShipmentPage(String olpnId){
        CommonMethods.waitForPageLoadAndToLoadWebElements();
        if(SeleniumActions.isElementVisible(By.xpath("//card-view[@class='dm-fill-space card-views']//div[contains(@class,'card-row primary')]//div//div//span[@title='"+olpnId+"']"), 10))
        {
            By byOlpnRowAtIndex =By.xpath("//card-view[@class='dm-fill-space card-views']//div[contains(@class,'card-row primary')]//div//div//span[@title='"+olpnId+"']");
            CommonMethods.scrollByParticularElement(byOlpnRowAtIndex,"Shipment page Row At FirstIndex");
            SeleniumActions.click(byOlpnRowAtIndex, "Shipment page Row At FirstIndex");
            By byOlpnValueRow =By.xpath("//card-view[@class='dm-fill-space card-views']//div[contains(@class,'card-row primary selected-card')]//div//div//span[@title='"+olpnId+"']");
            CommonMethods.waitForPageLoadAndToLoadWebElements();
            if( SeleniumActions.isElementVisible(byOlpnValueRow, 10)   &  SeleniumActions.isElementVisible(bySelectedShipViaATL4E, 10)    ){
                FrameworkLogger.log(LogType.PASS, "Olpn & ShipViaATL4E Exist in Shipment Page passed : ");
            }else{
                FrameworkLogger.log(LogType.FAIL, "Olpn & ShipViaATL4E  doesn't not Exist in Shipment Page failed : ");
            }
        }else{
            FrameworkLogger.log(LogType.FAIL, "Olpn value doesn't not Exist in Shipment Page failed : ");
        }
    }

    /**
     * Function to verify Carrier Shipment order and ship via routing lane option
     * @param  carrier - give the carrier
     * @param  order - give the order
     */
    public static void verifyCarrierShipmentOrderIDAndShipViaInRoutingLaneOption(String carrier, String order) {
        By bycarrierRowAtFirstIndex = By.xpath("//card-view[@class='dm-fill-space card-views']//div[contains(@class,'card-row primary')]//div/span[@title='" + carrier + "']");

        SeleniumActions.click(bycarrierRowAtFirstIndex, "select olpn");
        CommonMethods.waitForPageLoading();
        FooterPanelPage.clickDetailsButton();
        CommonMethods.waitForPageLoading();
        String shipViaValue = SeleniumActions.getText(byShipViaValue).trim();
        if (shipViaValue.contains(carrier)) {
            FrameworkLogger.log(LogType.PASS, "Verification Passed For " + carrier);
        } else {
            FrameworkLogger.log(LogType.FAIL, "Verification Failed For " + carrier);
        }
        oLPNPage.validateOLPNsOrderIDInDetailspage((String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + order));
        oLPNPage.verifyShipmentIDIsShowing();
        oLPNPage.closeOlpnDetailsPage();
        FooterPanelPage.clickDeselectButton();
    }
    /**
     * Function to verify Lane Carrier Shipment details in Carton Attributes
     */
    public static void verifyMultipleShipmentInCartonAttribute(){
        List<WebElement> elements = CommonPage.getRowElements();
        String containerType;
        int b=0;
        for (WebElement e : elements)
        {
            SeleniumActions.click(e, "select olpn");
            CommonMethods.waitForPageLoading();
            String shipViaValue =  SeleniumActions.getText(byShipViaValue).trim();
            if (shipViaValue.contains(getDataFromFeature("getdata(Carrier1)"))) {
                FooterPanelPage.clickDetailsButton();
                if(b==0) {
                    SeleniumActions.click(byExpandCartonAttributeIcon, "Expand Carton Attribute");
                    CommonMethods.waitForPageLoading();
                    int volume = Integer.parseInt(SeleniumActions.getText(byVolume).trim().replaceAll(",", ""));
                    double weight = Double.parseDouble(SeleniumActions.getText(byWeight).trim());
                    if (volume > 1000000 || weight > 125) {
                        FrameworkLogger.log(LogType.PASS, "For AT1LE Either weight > 125kg or volume > 1000000  passed : " + weight);
                    } else {
                        FrameworkLogger.log(LogType.FAIL, "For AT1LE neither weight > 125kg nor volume > 1000000 failed : " + weight);
                    }
                    b++;
                }

            }else if(shipViaValue.contains(getDataFromFeature("getdata(Carrier2)"))) {
                FooterPanelPage.clickDetailsButton();
                SeleniumActions.click(byExpandCartonAttributeIcon, "Expand Carton Attribute");
                CommonMethods.waitForPageLoading();
                int volume= Integer.parseInt(SeleniumActions.getText(byVolume).trim().replaceAll(",", ""));
                double weight = Double.parseDouble(SeleniumActions.getText(byWeight).trim());
                if(weight < 125 || volume < 1000000){
                    FrameworkLogger.log(LogType.PASS, "For ATL2E weight < 125 || volume < 1000000 passed : " + weight);
                }else{
                    FrameworkLogger.log(LogType.FAIL, "For ATL2E NOT weight < 125 || volume < 1000000 failed : " + weight);
                }
            }else if(shipViaValue.contains(getDataFromFeature("getdata(Carrier3)"))) {
                FooterPanelPage.clickDetailsButton();
                SeleniumActions.click(byExpandCartonAttributeIcon, "Expand Carton Attribute");
                CommonMethods.waitForPageLoading();
                int volume= Integer.parseInt(SeleniumActions.getText(byVolume).trim().replaceAll(",", ""));
                double weight = Double.parseDouble(SeleniumActions.getText(byWeight).trim());
                if(weight < 50){
                    FrameworkLogger.log(LogType.PASS, "For ATL3E weight < 50 passed : " + weight);
                }else{
                    FrameworkLogger.log(LogType.FAIL, "For ATL3E NOT weight < 50 failed : " + weight);
                }
            }else if(shipViaValue.contains(getDataFromFeature("getdata(Carrier4)"))) {
                FooterPanelPage.clickDetailsButton();
                SeleniumActions.click(byExpandCartonAttributeIcon, "Expand Carton Attribute");
                CommonMethods.waitForPageLoading();
                int volume= Integer.parseInt(SeleniumActions.getText(byVolume).trim().replaceAll(",", ""));
                double weight = Double.parseDouble(SeleniumActions.getText(byWeight).trim());
                if(weight > 50){
                    FrameworkLogger.log(LogType.PASS, "For ATL4E weight > 50 passed : " + weight);
                }else{
                    FrameworkLogger.log(LogType.FAIL, "For ATL4E NOT weight > 50 failed : " + weight);
                }
            }else if(shipViaValue.contains(getDataFromFeature("getdata(Carrier5)"))) {
                FooterPanelPage.clickDetailsButton();
                SeleniumActions.click(byExpandCartonAttributeIcon, "Expand Carton Attribute");
                CommonMethods.waitForPageLoading();
                int volume= Integer.parseInt(SeleniumActions.getText(byVolume).trim().replaceAll(",", ""));
                double weight = Double.parseDouble(SeleniumActions.getText(byWeight).trim());
                if(volume < 250000){
                    FrameworkLogger.log(LogType.PASS, "For ATL5E volume < 250000 passed : " + weight);
                }else{
                    FrameworkLogger.log(LogType.FAIL, "For ATL5E NOT volume < 250000 failed : " + weight);
                }
            }else if(shipViaValue.contains(getDataFromFeature("getdata(Carrier6)"))) {
                FooterPanelPage.clickDetailsButton();
                SeleniumActions.click(byExpandCartonAttributeIcon, "Expand Carton Attribute");
                CommonMethods.waitForPageLoading();
                int volume= Integer.parseInt(SeleniumActions.getText(byVolume).trim().replaceAll(",", ""));
                double weight = Double.parseDouble(SeleniumActions.getText(byWeight).trim());
                if(volume > 250000){
                    FrameworkLogger.log(LogType.PASS, "For ATL6E volume > 250000 passed : " + weight);
                }else{
                    FrameworkLogger.log(LogType.FAIL, "For ATL6E NOT volume > 250000 failed : " + weight);
                }
            }else if(shipViaValue.contains(getDataFromFeature("getdata(Carrier12)"))) {
                FooterPanelPage.clickDetailsButton();
                SeleniumActions.click(byExpandCartonAttributeIcon, "Expand Carton Attribute");
                CommonMethods.waitForPageLoading();
                double weight = Double.parseDouble(SeleniumActions.getText(byWeight).trim());
                if(weight < 125) {
                    FrameworkLogger.log(LogType.PASS, "For ATDHLENZ weight < 125  passed : " + weight);
                }else{
                    FrameworkLogger.log(LogType.FAIL, "For ATDHLENZ NOT weight < 125  failed : " + weight);
                }
            }else if(shipViaValue.contains(getDataFromFeature("getdata(Carrier9)"))) {
                FooterPanelPage.clickDetailsButton();
                SeleniumActions.click(byExpandCartonAttributeIcon, "Expand Carton Attribute");
                CommonMethods.waitForPageLoading();
                double weight = Double.parseDouble(SeleniumActions.getText(byWeight).trim());
                if(weight > 125 & weight < 999) {
                    FrameworkLogger.log(LogType.PASS, "For ATDGFNZLTL weight > 125 & weight < 999  passed : " + weight);
                }else{
                    FrameworkLogger.log(LogType.FAIL, "For ATDGFNZLTL NOT weight > 125 & weight < 999  failed : " + weight);
                }
            }else if(shipViaValue.contains(getDataFromFeature("getdata(Carrier7)"))) {
                FooterPanelPage.clickDetailsButton();
                SeleniumActions.click(byExpandCartonAttributeIcon, "Expand Carton Attribute");
                CommonMethods.waitForPageLoading();
            }
            CommonMethods.waitForPageLoading();
            SeleniumActions.click(byCloseDetailsPageIcon, "Close Icon OLPNs Details Page");
            CommonMethods.waitForPageLoading();
            SeleniumActions.click(e, "Deselect olpn");
            CommonMethods.waitForPageLoading();
        }
    }

    /**
     * Function to click Navigation Lane Link
     */
    public static void clickNavigationLaneLink() {
        CommonMethods.waitForPageLoading();
        SeleniumActions.click(byNavigationLaneLink, "Navigation Lane Link");
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to validate ATL7E and ATDHLENZ
     */
    public static void verifyATL7EAndATDHLENZ() {
        CommonMethods.waitForPageLoading();
        CommonMethods.scrollByParticularElement(byATDHLENZRow, "Scroll to carrier 2 card");
        SeleniumActions.click(byATDHLENZRow, "Navigation Lane Link");
        CommonMethods.waitForPageLoading();
        HeaderPanelPage.clickRelatedLinksButton();
        HeaderPanelPage.clickOrderLink();
        CommonPage.clickRowAtFirstIndex();
        FooterPanelPage.clickDetailsButton();
        SeleniumActions.click(byExpandDeliveryIcon, "Expand Carton Attribute");
        CommonMethods.waitForPageLoading();
        String country = SeleniumActions.getText(byCountry).trim();
        if(country.equalsIgnoreCase("NZ")){
            FrameworkLogger.log(LogType.PASS, "For ATDHLENZ country IS NZ passed : " );
        }else{
            FrameworkLogger.log(LogType.FAIL, "For ATDHLENZ country IS NOT  NZ  failed : " );
        }
        CommonMethods.waitForPageLoading();
        SeleniumActions.click(byCloseDetailsPageIcon, "Close Icon OLPNs Details Page");
        CommonMethods.waitForPageLoading();
        HomePage.navigate_to_waveRuns();
        WaveRunsPage.verifyWaveRunsPageDisplayed();
        WaveRunsPage.searchWaveRuns(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "WaveRun").toString());
        CommonPage.clickRowAtFirstIndex();
        HeaderPanelPage.clickRelatedLinksButton();
        CommonMethods.waitForPageLoading();
        HeaderPanelPage.clickOLPNSLink();
        CommonMethods.scrollByParticularElement(byATL7ERow, "Scroll to ATL7E");
        SeleniumActions.click(byATL7ERow, "click on ATL7ER");
        CommonMethods.waitForPageLoading();
        HeaderPanelPage.clickRelatedLinksButton();
        HeaderPanelPage.clickOrderLink();
        CommonPage.clickRowAtFirstIndex();
        FooterPanelPage.clickDetailsButton();
        SeleniumActions.click(byExpandDeliveryIcon, "Expand Carton Attribute");
        CommonMethods.waitForPageLoading();
        String state = SeleniumActions.getText(byState).trim();
        int postCode = Integer.parseInt((SeleniumActions.getText(byPostalCode).trim()));
        if(state.equalsIgnoreCase("VIC")){
            FrameworkLogger.log(LogType.PASS, "For ATL7E state IS VIC passed : " );
        }else{
            FrameworkLogger.log(LogType.FAIL, "For ATL7E state NOT VIC failed : " );
        }
        if(postCode >= 3000 & postCode <= 3999 || postCode >= 8000 & postCode <= 8999 ){
            FrameworkLogger.log(LogType.PASS, "For ATL7E postCode within range passed : ");
        }else{
            FrameworkLogger.log(LogType.FAIL, "For ATL7E postCode NOT within range  failed : ");
        }
        CommonMethods.waitForPageLoading();
        SeleniumActions.click(byCloseDetailsPageIcon, "Close Icon OLPNs Details Page");
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to click edit button
     */
    public static void clickEditButton() {
        SeleniumActions.click(byEditBtn, "Details button");
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to click save continue button
     */
    public static void clickSaveContinueButton() {
        SeleniumActions.click(bySaveContinueBtn, "Details button");
        CommonMethods.waitForPageLoading();
    }
    /**
     * Function to validate post code in transport zone
     */
    public static void verifyPostCodeInTranportationZone() {
        CommonMethods.waitForPageLoading();
        CommonMethods.scrollByParticularElement(byAUVIC, "Scroll to AU_VIC card");
        CommonMethods.waitForPageLoading();
        SeleniumActions.click(byAUVIC, "Navigation AUVIC Link");
        CommonMethods.waitForPageLoading();
        clickEditButton();
        CommonMethods.waitForPageLoading();
        clickSaveContinueButton();
        CommonMethods.waitForPageLoading();
        clickSaveContinueButton();
        CommonMethods.waitForPageLoading();
       if( SeleniumActions.getText(byCountryId).equalsIgnoreCase("AU") ){
           FrameworkLogger.log(LogType.PASS, "For Country  is VIC passed : " +byCountryId);
       }else{
           FrameworkLogger.log(LogType.FAIL, "For Country  is not VIC failed : " +byCountryId);
       }
        CommonMethods.waitForPageLoading();
        if( SeleniumActions.getText(byFromPostalCode1).equalsIgnoreCase("3000") ){
            FrameworkLogger.log(LogType.PASS, "For byFromPostalCode1  is 3000 passed : " +byFromPostalCode1);
        }else{
            FrameworkLogger.log(LogType.FAIL, "For byFromPostalCode1  is not 3000 failed : " +byFromPostalCode1);
        }
        CommonMethods.waitForPageLoading();
        if( SeleniumActions.getText(byToPostalCode1).equalsIgnoreCase("3999") ){
            FrameworkLogger.log(LogType.PASS, "For byToPostalCode1  is 3999 passed : " +byToPostalCode1);
        }else{
            FrameworkLogger.log(LogType.FAIL, "For byToPostalCode1  is not 3999 failed : " +byToPostalCode1);
        }
        CommonMethods.waitForPageLoading();
        if( SeleniumActions.getText(byFromPostalCode2).equalsIgnoreCase("8000") ){
            FrameworkLogger.log(LogType.PASS, "For byFromPostalCode2  is 8000 passed : " +byFromPostalCode2);
        }else{
            FrameworkLogger.log(LogType.FAIL, "For byFromPostalCode2  is not 8000 failed : " +byFromPostalCode2);
        }
        CommonMethods.waitForPageLoading();
        if( SeleniumActions.getText(byToPostalCode2).equalsIgnoreCase("8999") ){
            FrameworkLogger.log(LogType.PASS, "For byToPostalCode2  is 8999 passed : " +byToPostalCode2);
        }else{
            FrameworkLogger.log(LogType.FAIL, "For byToPostalCode2  is not 8999 failed : " +byToPostalCode2);
        }
        CommonMethods.waitForPageLoading();
        SeleniumActions.click(bySaveClose,"Save and Close Button");
        CommonMethods.waitForPageLoading();
        CommonMethods.scrollByParticularElement(byAU_QLD, "Scroll to AU_QLD card");
        CommonMethods.waitForPageLoading();
        SeleniumActions.click(byAU_QLD, "Navigation byAU_QLD Link");
        CommonMethods.waitForPageLoading();
        clickEditButton();
        CommonMethods.waitForPageLoading();
        clickSaveContinueButton();
        CommonMethods.waitForPageLoading();
        clickSaveContinueButton();
        CommonMethods.waitForPageLoading();
        if( SeleniumActions.getText(byCountryId).equalsIgnoreCase("AU") ){
            FrameworkLogger.log(LogType.PASS, "For Country  is VIC passed : " +byCountryId);
        }else{
            FrameworkLogger.log(LogType.FAIL, "For Country  is not VIC failed : " +byCountryId);
        }
        CommonMethods.waitForPageLoading();
        if( SeleniumActions.getText(byQLDFromPostalCode1 ).equalsIgnoreCase("4000") ){
            FrameworkLogger.log(LogType.PASS, "For byQLDFromPostalCode1  is 4000 passed : " +byQLDFromPostalCode1);
        }else{
            FrameworkLogger.log(LogType.FAIL, "For byQLDFromPostalCode1  is not 4000 failed : " +byQLDFromPostalCode1);
        }
        CommonMethods.waitForPageLoading();
        if( SeleniumActions.getText(byQLDToPostalCode1).equalsIgnoreCase("4999") ){
            FrameworkLogger.log(LogType.PASS, "For byQLDToPostalCode1  is 4999 passed : " +byQLDToPostalCode1);
        }else{
            FrameworkLogger.log(LogType.FAIL, "For byQLDToPostalCode1  is not 4999 failed : " +byQLDToPostalCode1);
        }
        CommonMethods.waitForPageLoading();
        if( SeleniumActions.getText(byQLDFromPostalCode2).equalsIgnoreCase("9000") ){
            FrameworkLogger.log(LogType.PASS, "For byQLDFromPostalCode2  is 9000 passed : " +byQLDFromPostalCode2);
        }else{
            FrameworkLogger.log(LogType.FAIL, "For byQLDFromPostalCode2  is not 9000 failed : " +byQLDFromPostalCode2);
        }
        CommonMethods.waitForPageLoading();
        if( SeleniumActions.getText(byQLDToPostalCode2).equalsIgnoreCase("9999") ){
            FrameworkLogger.log(LogType.PASS, "For byQLDToPostalCode2  is 9999 passed : " +byQLDToPostalCode2);
        }else{
            FrameworkLogger.log(LogType.FAIL, "For byQLDToPostalCode2  is not 9999 failed : " +byQLDToPostalCode2);
        }
        CommonMethods.waitForPageLoading();
        SeleniumActions.click(bySaveClose,"Save and Close Button");
        CommonMethods.waitForPageLoading();

    }
}