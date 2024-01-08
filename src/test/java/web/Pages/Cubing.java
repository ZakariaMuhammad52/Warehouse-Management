package web.Pages;

import com.dhl.testdata.TestData_Json;
import org.openqa.selenium.By;

import com.dhl.driver.DriverManager;
import com.dhl.enums.KeyboardKeys;
import com.dhl.reports.FrameworkLogger;
import com.dhl.reports.LogType;
import com.dhl.testdata.TestData_Json;
import com.dhl.utils.CurrentThreadInstance;
import com.dhl.utils.GeneralUtils;
import com.dhl.utils.Variables;
import com.dhl.web.utils.KeyboardActions;
import com.dhl.web.utils.SeleniumActions;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import stepdefinitions.CommonMethods;
import stepdefinitions.ExcelUtil1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cubing extends TestData_Json {
    private static final By byNameFilter = By.xpath("//ion-input[@data-component-id='CubingStrategyId-filter']/input");
    private static final By byExpandNameField = By.xpath("//span[@title='Name']/following-sibling::ion-button[contains(@data-component-id,'expand-button')]");
    private static final By byViewButton = By.xpath("//ion-button[contains(@data-component-id,'View')]");
    private static final By byCubeToCapacityCriteria = By.xpath("//ion-label[contains(@data-component-id,'Cube-to-CapacityCriteria')]");
    private static final By byExpandSideButton = By.xpath("(//button[@data-component-id='action-closed-card-view'])[2]");
    private static final By byCubingMethod = By.xpath("//ion-label[@data-component-id='CubingMethod-step-indicator']");
    private static final By byResidualCubingParameters = By.xpath("//ion-label[@data-component-id='ResidualCubingParameters-step-indicator']");
    private static final By byverifyContainerTypePage = By.xpath("//span[@data-component-id='ContainerType-navbar-section-nosubtitle']");
    private static final By byContainerType = By.xpath("//ion-input[contains(@data-component-id,'ContainerTypeId')]/input");
    private static final By byExpandContainerType = By.xpath("//span[@title='Container Type']/following-sibling::ion-button[contains(@data-component-id,'expand-button')]");
    private static final By byContainerSizeDefinition = By.xpath("//ion-label[contains(@data-component-id,'ContainerSizeDefinition')]");
    private static final By byOriginalOrderField = By.xpath("//ion-input[@data-component-id='OriginalOrderId-filter']/input");
    private static final By byExpandOriginalOrderfield = By.xpath("//span[@title='Original order']/following-sibling::ion-button[contains(@data-component-id,'expand-button')]");
    private static final By byFNCUBING02OrderStrategy = By.xpath("//span[contains(text(),'FNCUBING02OrderStrategy')]");
    private static final By byFNCUBING01OrderStrategy = By.xpath("//span[contains(text(),'FNCUBING01OrderStrategy')]");

    private static final By byFNCUBING04OrderStrategy = By.xpath("//span[contains(text(),'FNCUBING04OrderStrategy')]");
    private static final By byselectFNCUBING03RETAIL = By.xpath("//span[contains(text(),'FNCUBING03RETAIL')]");
    private static final By bybackToCubingStrategy = By.xpath("(//a[contains(text(),'Cubing Strategy')])[5]");
    private static final By byExpandSideButton1 = By.xpath("(//button[@data-component-id='action-closed-card-view'])[1]");
    private static final By byExpandSideButton3 = By.xpath("(//button[@data-component-id='action-closed-card-view'])[3]");
    private static final By byFNCUBING0301 = By.xpath("//span[contains(text(),'FNCUBING0301')]");
    private static final By byFNCUBING0302 = By.xpath("//span[contains(text(),'FNCUBING0302')]");
    private static final By byFNCUBING0303 = By.xpath("//span[contains(text(),'FNCUBING0303')]");
    private static final By byExpandSideButton4 = By.xpath("(//button[@data-component-id='action-closed-card-view'])[4]");
    private static final By byResidualCubingEnabledField = By.xpath("//input[contains(@data-component-id,'EnableResidualCubing')]");
    private static final By byCubeToCapacityLogicField = By.xpath("//input[contains(@data-component-id,'CubingMethod')]");
    private static final By byResidualParameters_ContainerTypeField = By.xpath("//input[contains(@data-component-id,'ContainerTypeId')]");
    private static final By byResidualParameters_UseItemUnitWeightVolumeField = By.xpath("//input[contains(@data-component-id,'UseItemUnitWeightVolume')]");
    private static final By bybackToContainerType = By.xpath("(//a[contains(text(),'Container Type')])[2]");
    private static final By bybackToCubingStrategy1 = By.xpath("(//a[contains(text(),'Cubing Strategy')])[4]");
    private static final By byBreakByCriteria = By.xpath("//ion-label[contains(@data-component-id,'Break-byCriteria')]");
    private static final By byBreakByAtrributeConfig = By.xpath("//input[contains(@data-component-id,'Field-view-label')]");
    private static final By bySetOrderCriteria = By.xpath("//ion-label[contains(@data-component-id,'SetOrderCriteria')]");
    private static final By byFNCUBING06OrderStrategy = By.xpath("//span[contains(text(),'FNCUBING06OrderStrategy')]");
    private static final By bySelectionRules = By.xpath("//ion-label[contains(@data-component-id,'Selectionrules')]");
    private static final By bySetInventoryCriteria = By.xpath("//ion-label[contains(@data-component-id,'Setinventorycriteria')]");
    private static final By byOrderCriteriaSideArrow = By.xpath("(//button[@data-component-id='action-closed-card-view'])[3]");
    private static final By byOrderCriteriaViewButton = By.xpath("(//button[contains(@data-component-id,'View')])[2]");
    private static final By byAllocationZonePriorities = By.xpath("//ion-label[contains(@data-component-id,'AllocationZonePriorities')]");
    private static final By byBackToAllocationStrategy = By.xpath("(//li[contains(@data-component-id,'Allocat...Strategy')])[5]/a");
    private static final By byCubeByUOMCriteria = By.xpath("//ion-label[contains(@data-component-id,'Cube-by-UOMCriteria')]");
    private static final By byCubingCriteriaRules = By.xpath("//ion-label[contains(@data-component-id,'CubingCriteriaRules')]");
    private static final By byRunWaveBtn = By.xpath("//ion-button[contains(@data-component-id,'RunWave')]");
    private static final By byAllocationStrategy1 = By.xpath("(//span[contains(@data-component-id,'OrderCriteriaId')])[1]");
    private static final By byAllocationStrategy2 = By.xpath("(//span[contains(@data-component-id,'OrderCriteriaId')])[2]");
    private static final By ByInventoryCriteria = By.xpath("//span[contains(@data-component-id,'AllocationInventoryCriteriaId')]");
    private static final By byFNCUBING03B2B = By.xpath("//span[contains(text(),'FNCUBING03B2B')]");
    private static final By byFNCUBING03B2C = By.xpath("//span[contains(text(),'FNCUBING03B2C')]");
    private static final By ByZoneId = By.xpath("//span[contains(@data-component-id,'ZoneId')]");
    private static final By ByAllocationUomId1 = By.xpath("(//span[contains(@data-component-id,'AllocationUomId')])[1]");
    private static final By ByAllocationUomId2 = By.xpath("(//span[contains(@data-component-id,'AllocationUomId')])[2]");

    private static final By ByAllocationUomId = By.xpath("(//span[contains(@data-component-id,'AllocationUomId')])");
    private static final By byListContainer = By.xpath("//ion-reorder-group//*[contains(@class,'card-row primary')]");
    private static final By byContainerTypeId = By.xpath("//ion-grid//input[contains(@data-component-id,'ContainerTypeId')]");
    private static final By byCubingStrategy = By.xpath("(//ul//*[@title='Cubing Strategy'])[3]");
    private static final By byExpandSideButton5 = By.xpath("(//button[@data-component-id='action-closed-card-view'])[5]");
    private static final By byExpandSideButton6 = By.xpath("(//button[@data-component-id='action-closed-card-view'])[6]");
    /**
     * Function to Filter cubing strategy by name
     * @param  strText- Pass the search value
     */
    public static void filterByNameCubingStrategy(String strText) {
        CommonMethods.waitForPageLoading();
        if (DriverManager.getDriver().findElements(byNameFilter).size() < 1) {
            SeleniumActions.click(byExpandNameField, "Expand icon");
        }
        CommonMethods.waitForPageLoading();
        SeleniumActions.getElement(byNameFilter).clear();
        SeleniumActions.sendTextToElement(byNameFilter, strText, "Name search field");
        CommonMethods.waitForPageLoading();
        KeyboardActions.pressEnterKey(byNameFilter);
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to Click on view button
     */
    public static void selectViewButton() {
        SeleniumActions.click(byViewButton, "View button");
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to Select cube to capacity criteria button
     */
    public static void selectCubeToCapacityCriteria() {
        SeleniumActions.click(byCubeToCapacityCriteria, "CubeToCapacityCriteria button");
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to Expand side arrow
     */
    public static void ExpandSideArrow() {
        SeleniumActions.click(byExpandSideButton, "Expand Side Arrow");
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to Select cubing method
     */
    public static void selectCubingMethod() {
        SeleniumActions.click(byCubingMethod, "Cubing Method");
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to Click on residual cubing parameter
     */
    public static void selectResidualCubingParameters() {
        SeleniumActions.click(byResidualCubingParameters, "ResidualCubingParameters");
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to Verify container  type is visible
     */
    public static void verifyContainerTypePage() {
        SeleniumActions.verifyElementVisible(byverifyContainerTypePage, 20, "Container Type Page");
    }

    /**
     * Function to filter container type
     * @param strText- pass container type
     */
    public static void filterByContainerType(String strText) {
        CommonMethods.waitForPageLoading();
        if (DriverManager.getDriver().findElements(byContainerType).size() < 1) {
            SeleniumActions.click(byExpandContainerType, "Expand icon");
        }
        SeleniumActions.getElement(byContainerType).clear();
        SeleniumActions.sendTextToElement(byContainerType, strText, "Container Type field");
        CommonMethods.waitForPageLoading();
        KeyboardActions.pressEnterKey(byContainerType);
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to click on container size defination
     *
     */
    public static void selectContainerSizeDefinition() {
        SeleniumActions.click(byContainerSizeDefinition, "selectContainerSizeDefinition");
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to Select multiple orders
     *
     */
    public static void selectMult1ipleOrders() {
        if (DriverManager.getDriver().findElements(byOriginalOrderField).size() < 1) {
            SeleniumActions.click(byExpandOriginalOrderfield, "Expand icon");
        }
        String text1 = Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder1").toString();
        String text2= "*";
        SeleniumActions.sendTextToElement(byOriginalOrderField, text1, "Original Order search field");
        KeyboardActions.pressKeyboardKey(KeyboardKeys.BACKSPACE);
        SeleniumActions.sendTextToElement(byOriginalOrderField, text2, "Original Order search field");
        KeyboardActions.pressEnterKey(byOriginalOrderField);
        CommonMethods.waitForPageLoading();
        CommonPage.clickRowAtFirstIndex();
        CommonPage.clickRowAtSecondIndex();
        CommonPage.clickRowAtThirdIndex();
    }

    /**
     * Function to Select order at first row
     *
     */
    public static void selectOrder() {
        if (DriverManager.getDriver().findElements(byOriginalOrderField).size() < 1) {
            SeleniumActions.click(byExpandOriginalOrderfield, "Expand icon");
        }
        String text1 = Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder").toString();
        SeleniumActions.getElement(byOriginalOrderField).clear();
        SeleniumActions.sendTextToElement(byOriginalOrderField, text1, "Original Order search field");
        KeyboardActions.pressEnterKey(byOriginalOrderField);
        CommonMethods.waitForPageLoading();
        CommonPage.clickRowAtFirstIndex();
    }

    /**
     * Function to click on FN cubing02 order strategy
     *
     */
    public static void selectFNCUBING02OrderStrategy() {
        SeleniumActions.click(byFNCUBING02OrderStrategy, "FNCUBING02OrderStrategy");
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to click on FN cubing01 order strategy
     *
     */
    public static void selectFNCUBING01OrderStrategy() {
        SeleniumActions.click(byFNCUBING01OrderStrategy, "FNCUBING01OrderStrategy");
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to click on FN cubing03 retail
     *
     */
    public static void selectFNCUBING03RETAIL() {
        SeleniumActions.click(byselectFNCUBING03RETAIL, "selectFNCUBING03RETAIL");
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to click on FN cubing04 order strategy
     *
     */
    public static void selectFNCUBING04OrderStrategy() {
        SeleniumActions.click(byFNCUBING04OrderStrategy, "FNCUBING04OrderStrategy");
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to go back to cubing strategy
     *
     */
    public static void backToCubingStrategy() {
        SeleniumActions.click(bybackToCubingStrategy, "backToCubingStrategy");
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to expand side arrow 1
     *
     */
    public static void expandSideArrow1() {
        SeleniumActions.click(byExpandSideButton1, "Expand Side Arrow1");
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to expand side arrow 3
     *
     */
    public static void expandSideArrow3() {
        SeleniumActions.click(byExpandSideButton3, "Expand Side Arrow3");
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to expand side arrow 4
     *
     */
    public static void expandSideArrow4() {
        SeleniumActions.click(byExpandSideButton4, "Expand Side Arrow4");
        CommonMethods.waitForPageLoading();
    }
    /**
     * Function to select FN cubing0301
     *
     */
    public static void selectFNCUBING0301() {
        SeleniumActions.click(byFNCUBING0301, "FNCUBING0301");
        CommonMethods.waitForPageLoading();
    }
    /**
     * Function to select FN cubing0302
     *
     */
    public static void selectFNCUBING0302() {
        SeleniumActions.click(byFNCUBING0302, "FNCUBING0302");
        CommonMethods.waitForPageLoading();
    }
    /**
     * Function to select FN cubing0303
     *
     */
    public static void selectFNCUBING0303() {
        SeleniumActions.click(byFNCUBING0303, "FNCUBING0303");
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to go back to container type
     */
    public static void backToContainerType() {
        SeleniumActions.click(bybackToContainerType, "backToContainerType");
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to go back to container type
     */
    public static void backToCubingStrategy1() {
        SeleniumActions.click(bybackToCubingStrategy1, "backToCubingStrategy");
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to select 2 orders
     */
    public static void selectTwoOrders() {
        if (DriverManager.getDriver().findElements(byOriginalOrderField).size() < 1) {
            SeleniumActions.click(byExpandOriginalOrderfield, "Expand icon");
        }
        SeleniumActions.getElement(byOriginalOrderField).clear();
        String text1 = Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder1").toString();
        String text2= "*";
        SeleniumActions.sendTextToElement(byOriginalOrderField, text1, "Original Order search field");
        KeyboardActions.pressKeyboardKey(KeyboardKeys.BACKSPACE);
        SeleniumActions.sendTextToElement(byOriginalOrderField, text2, "Original Order search field");
        KeyboardActions.pressEnterKey(byOriginalOrderField);
        CommonMethods.waitForPageLoading();
        CommonPage.clickRowAtFirstIndex();
        CommonPage.clickRowAtSecondIndex();
    }

    /**
     * Function to verify cubing method parameters
     */
    public static void verifyCubingMethodParameters(){
        String actualResidualCubing = SeleniumActions.getAtrribute(byResidualCubingEnabledField, "value", 10);
        SeleniumActions.verifyTextEquals(actualResidualCubing, getDataFromFeature("getdata(ResidualCubingEnabled)"), false);

        String actualCubeToCapacityLogic = SeleniumActions.getAtrribute(byCubeToCapacityLogicField, "value", 10);
        SeleniumActions.verifyTextEquals(actualCubeToCapacityLogic, getDataFromFeature("getdata(CubeToCapacity)"), false);
    }

    /**
     * Function to verify residential parameters
     */
    public static void verifyResidentialParameters(){
        String actualContainerType = SeleniumActions.getAtrribute(byResidualParameters_ContainerTypeField, "value", 10);
        SeleniumActions.verifyTextEquals(actualContainerType, getDataFromFeature("getdata(ContainerType)"), false);

        String actualUseItemUnitWeight = SeleniumActions.getAtrribute(byResidualParameters_UseItemUnitWeightVolumeField, "value", 10);
        SeleniumActions.verifyTextEquals(actualUseItemUnitWeight, getDataFromFeature("getdata(UseItemUnitWeight)"), false);
    }

    /**
     * Function to verify config details of break by attribute
     */
    public static void verifyBreakByAttributeConfig(){
        SeleniumActions.click(byBreakByCriteria,"Break by criteria");
        String actualbrkByattributeConfig = SeleniumActions.getText(byBreakByAtrributeConfig);
        CommonMethods.waitForPageLoading();
        SeleniumActions.verifyTextEquals(actualbrkByattributeConfig,getDataFromFeature("getdata(BreakByAttribute)"),false);
    }

    /**
     * Function to Select FN cubing06 order strategy
     */
    public static void selectFNCUBING06OrderStrategy() {
        CommonMethods.waitForPageLoading();
        SeleniumActions.click(byFNCUBING06OrderStrategy, "FNCUBING0O6rderStrategy");
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to select order criteria
     */
    public static void selectSetOrderCriteria() {
        SeleniumActions.click(bySetOrderCriteria, "SetOrderCriteria");
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to click on selection rule
     */
    public static void selectSelectionRules() {
        SeleniumActions.click(bySelectionRules, "SelectionRules");
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to go click on set inventory criteria
     */
    public static void selectSetInventoryCriteria() {
        SeleniumActions.click(bySetInventoryCriteria, "SetInventoryCriteria");
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to click on order criteria side arrow
     */
    public static void selectOrderCriteriaSideArrow() {
        SeleniumActions.click(byOrderCriteriaSideArrow, "OrderCriteriaSideArrow");
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to click on order criteria view button
     */
    public static void selectOrderCriteriaViewButton() {
        SeleniumActions.click(byOrderCriteriaViewButton, "OrderCriteriaViewButton");
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to click on allocation zone priorities
     */
    public static void selectAllocationZonePriorities() {
        SeleniumActions.click(byAllocationZonePriorities, "OrderCriteriaViewButton");
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to go back to allocation strategy
     */
    public static void selectBackToAllocationStrategy() {
        SeleniumActions.click(byBackToAllocationStrategy, "BackToAllocationStrategy");
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to click on cube by UOM criteria
     */
    public static void selectCubeByUOMCriteria() {
        SeleniumActions.click(byCubeByUOMCriteria, "CubeByUOMCriteria");
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to click on cubing criteria rules
     */
    public static void selectCubingCriteriaRules() {
        SeleniumActions.click(byCubingCriteriaRules, "CubingCriteriaRules");
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to click on run wave
     */
    public static void runWave() {
        SeleniumActions.click(byRunWaveBtn, "RunWave button");
        CommonMethods.waitForPageLoading();
        OriginalOrdersPage.getWavenumber();
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to verify text equals of allocation strategy
     */
    public static void verifyAllocationStrategy(){
        String actualAllocationStrategy1 = SeleniumActions.getText(byAllocationStrategy1);
        SeleniumActions.verifyTextEquals(actualAllocationStrategy1, getDataFromFeature("getdata(AllocationStrategy1)"), false);

        String actualAllocationStrategy2 = SeleniumActions.getText(byAllocationStrategy2);
        SeleniumActions.verifyTextEquals(actualAllocationStrategy2, getDataFromFeature("getdata(AllocationStrategy2)"), false);
    }

    /**
     * Function to verify text equals of selection rules
     */
    public static void verifySelectionRules(){
        By actualSelectionRules = By.xpath("(//input[@data-component-id='view-label-display'])[4]");
        String actualAttribute = SeleniumActions.getAtrribute(actualSelectionRules, "value", 10);
        SeleniumActions.verifyTextEquals(actualAttribute, getDataFromFeature("getdata(SelectionRules)"), false);

    }

    /**
     * Function to verify text equals of inventory criteria
     */
    public static void verifyInventoryCriteria(){
        String actualInventoryCriteria = SeleniumActions.getText(ByInventoryCriteria);
        SeleniumActions.verifyTextEquals(actualInventoryCriteria, getDataFromFeature("getdata(InventoryCriteria)"), false);

    }

    /**
     * Function to verify text equals for selection rule
     */
    public static void verifySelectionRules2(){
        By actualSelectionRules = By.xpath("(//input[@data-component-id='view-label-display'])[4]");
        String actualAttribute = SeleniumActions.getAtrribute(actualSelectionRules, "value", 10);
        SeleniumActions.verifyTextEquals(actualAttribute, getDataFromFeature("getdata(SelectionRules2)"), false);

    }

    /**
     * Function to verify text equals of inventory criteria
     */
    public static void verifyInventoryCriteria2(){
        String actualInventoryCriteria2 = SeleniumActions.getText(ByInventoryCriteria);
        SeleniumActions.verifyTextEquals(actualInventoryCriteria2, getDataFromFeature("getdata(InventoryCriteria2)"), false);

    }

    /**
     * Function to verify text equals of allocation priorities
     */
    public static void VerifyAllocationZonePriorities(){
        String actualAllocationZoneId = SeleniumActions.getText(ByZoneId);
        String actualAllocationUomId = SeleniumActions.getText(ByAllocationUomId);
        SeleniumActions.verifyTextEquals(actualAllocationZoneId, getDataFromFeature("getdata(AllocationZoneId)"),  false);

        SeleniumActions.verifyTextEquals(actualAllocationUomId, getDataFromFeature("getdata(AllocationUomId2)"), false);

    }

    /**
     * Function to verify text equals for multiple allocation priorities
     */
    public static void VerifyAllocationZonePrioritiesForTwoRecord(){
        String actualAllocationZoneId = SeleniumActions.getText(ByZoneId);
        String actualAllocationUomId1 = SeleniumActions.getText(ByAllocationUomId1);

        CommonMethods.waitForPageLoading();
        SeleniumActions.verifyTextEquals(actualAllocationZoneId, getDataFromFeature("getdata(AllocationZoneId)"), false);
        CommonMethods.waitForPageLoading();
        SeleniumActions.verifyTextEquals(actualAllocationUomId1, getDataFromFeature("getdata(AllocationUomId1)"), false);
        CommonMethods.waitForPageLoading();
        CommonMethods.scrollByParticularElement(ByAllocationUomId2, "Item CellValue");
        String actualAllocationUomId2 = SeleniumActions.getText(ByAllocationUomId2);
        SeleniumActions.verifyTextEquals(actualAllocationUomId2, getDataFromFeature("getdata(AllocationUomId2)"),  false);

    }

    /**
     * Function to Verify all FNCubing Retails values displying on cube to capacity page
     */
    public static void verifyFNCUBINRETAILDisplay() {
        CommonMethods.waitForPageLoading();
        SeleniumActions.verifyElementVisible(byselectFNCUBING03RETAIL, 10,"FNCUBING03RETAIL");
        SeleniumActions.verifyElementVisible(byFNCUBING03B2B, 10,"FNCUBING03B2B");
        SeleniumActions.verifyElementVisible(byFNCUBING03B2C, 10,"FNCUBING03B2C");
    }

    /**
     * Function to Verify Cubing Method and Cubing parameters for each cube to capacity criteria
     */
    public static void verifyCubingMethodAndCubingParameterForEachCubeToCapacityCriteria(){
        String containerTypeList= getDataFromFeature("getData(ListOfContainerType)");
        List<String> expectedContainerType = new ArrayList<String>(Arrays.asList(containerTypeList.split(",")));
        List<WebElement> elements=SeleniumActions.getElements(byListContainer);
        List<String> actualContainer = new ArrayList<>();
        CommonMethods.waitForPageLoading();
        for(int i=0;i<elements.size();i++) {
            final By bySlider = By.xpath("(//ion-item//slider-actions//button[@data-component-id='action-closed'])[" + (i+1) + "]");
            final By byView = By.xpath("//*[contains(@class,'slideOptionList')]//*[@data-component-id='View']");

            CommonMethods.scrollByParticularElement(bySlider, "Scroll to capacity criteria");
            CommonMethods.waitForPageLoading();
            SeleniumActions.click(bySlider, "Click on Action closed icon");
            CommonMethods.waitForPageLoading();
            SeleniumActions.click(byView, "Click on View Icon");
            CommonMethods.waitForPageLoading();
            Cubing.selectCubingMethod();
            Cubing.verifyCubingMethodParameters();
            Cubing.selectResidualCubingParameters();
            CommonMethods.waitForPageLoading();
            String actualContainerType= SeleniumActions.getText(byContainerTypeId);
            if(expectedContainerType.contains(actualContainerType))
            {
                FrameworkLogger.log(LogType.PASS, "Container Type Verification passed : " + actualContainerType);
             } else {
            FrameworkLogger.log(LogType.FAIL, "Container Type Verification failed. Expected :" + actualContainerType
                    + " , Actual :" + expectedContainerType);
            }

            String actualUseItemUnitWeight = SeleniumActions.getAtrribute(byResidualParameters_UseItemUnitWeightVolumeField, "value", 10);
            SeleniumActions.verifyTextEquals(actualUseItemUnitWeight, getDataFromFeature("getdata(UseItemUnitWeight)"), false);
            SeleniumActions.click(byCubingStrategy,"Cubing Strategy");
            CommonMethods.waitForPageLoading();
            Cubing.selectCubeToCapacityCriteria();
            CommonMethods.waitForPageLoading();

        }

    }

    /**
     * Function to select 3 records of order
     */
    public static void selectThreeOrders() {
        if (DriverManager.getDriver().findElements(byOriginalOrderField).size() < 1) {
            SeleniumActions.click(byExpandOriginalOrderfield, "Expand icon");
        }
        SeleniumActions.getElement(byOriginalOrderField).clear();
        String text1 = Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder1").toString();
        String text2= "*";
        SeleniumActions.sendTextToElement(byOriginalOrderField, text1, "Original Order search field");
        KeyboardActions.pressKeyboardKey(KeyboardKeys.BACKSPACE);
        SeleniumActions.sendTextToElement(byOriginalOrderField, text2, "Original Order search field");
        KeyboardActions.pressEnterKey(byOriginalOrderField);
        CommonMethods.waitForPageLoading();
        CommonPage.clickRowAtFirstIndex();
        CommonPage.clickRowAtSecondIndex();
        CommonPage.clickRowAtThirdIndex();
    }
    /**
     * Function to expand side arrow 5
     *
     */
    public static void expandSideArrow5() {
        SeleniumActions.click(byExpandSideButton5, "Expand Side Arrow5");
        CommonMethods.waitForPageLoading();
    }
    /**
     * Function to expand side arrow 6
     *
     */
    public static void expandSideArrow6() {
        CommonMethods.scrollByParticularElement(byExpandSideButton6, "Expand button");
        CommonMethods.waitForPageLoading();
        SeleniumActions.click(byExpandSideButton6, "Expand Side Arrow6");
        CommonMethods.waitForPageLoading();
    }
}