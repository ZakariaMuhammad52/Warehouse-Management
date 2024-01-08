package web.Pages;

import com.dhl.driver.DriverManager;
import com.dhl.enums.KeyboardKeys;
import com.dhl.reports.FrameworkLogger;
import com.dhl.reports.LogType;
import com.dhl.testdata.TestData_Json;
import com.dhl.utils.CurrentThreadInstance;
import com.dhl.utils.Variables;
import com.dhl.web.utils.KeyboardActions;
import com.dhl.web.utils.SeleniumActions;
import org.openqa.selenium.By;
import stepdefinitions.CommonMethods;

public class Routing extends TestData_Json {
    private static final By byNameFilter = By.xpath("//ion-input[@data-component-id='RoutingStrategyId']/input");
    private static final By byExpandNameField = By.xpath("//span[@title='Name']/following-sibling::ion-button[@data-component-id='expand-button']");
    private static final By byViewButton = By.xpath("//ion-button[@data-component-id='View']");
    private static final By bySetRoutingCriteria = By.xpath("//ion-label[@data-component-id='SetRoutingCriteria']");
    private static final By byViewButton_ExpandArrow = By.xpath("//button[@data-component-id='View']");
    private static final By byOrderSelectionCriteria = By.xpath("//ion-label[@data-component-id='OrderSelectionCriteria']");
    private static final By byValueInSelectionCriteria = By.xpath("(//input[@data-component-id='view-label-display'])[4]");
    private static final By byFNParcelDeterminationStrategy = By.xpath("//span[contains(text(),'FNParcelDeterminationStrategy')]");
    private static final By bySetParcelResource = By.xpath("//ion-label[@data-component-id='SetParcelResource']");
    private static final By byBacktoParcelStrategy = By.xpath("(//li[@data-component-id='Parcel...Strategy'])[3]/a");
    private static final By byBacktoParcelStrategy1 = By.xpath("(//li[@data-component-id='Parcel...Strategy'])[2]/a");
    private static final By byRoutingStrategyLabel2Navigation = By.xpath("(//a[@title='Routing Strategy'])[3]");
    private static final By byRoutingStrategyLabel1Navigation = By.xpath("(//a[@title='Routing Strategy'])[1]");
    private static final By byShipViaId = By.xpath("//input[@data-component-id='ShipViaId']");

    /**
     * Function to return the routing criteria
     * @param criteria - criteria name
     *
     */
    private static By byRoutingCriteriaInSetRoutingCriteria(String criteria){
        By routingCritera = By.xpath("//span[contains(text(),'Routing Criteria')]/parent::div//span[@title='"+criteria+"'][1]");
        return routingCritera;
    }

    /**
     * Function to expand side button for  routing criteria
     * @param criteria - criteria name
     *
     */
    private static By byExpandSideButton(String criteria){
        By expandButton = By.xpath("//span[@title='"+criteria+"']/parent::div//parent::div//following-sibling::slider-actions//button[@data-component-id='action-closed']");
        return expandButton;
    }

    /**
     * Function to filter name of routing strategy
     * @param strText - routing strategy name
     *
     */
    public static void filterByNameRoutingStrategy(String strText) {
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
     * Function to selectview button
     *
     */
    public static void selectViewButton() {
        SeleniumActions.click(byViewButton, "View button");
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to click on set routing criteria
     *
     */
    public static void clickSetRoutingCriteria() {
        SeleniumActions.click(bySetRoutingCriteria, "Set Routing Criteria");
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to view routing criteria
     * @param criteria - criteria name to view
     *
     */
    public static void viewRoutingCriteria(String criteria){
        String actualRoutingCriteria = SeleniumActions.getText(byRoutingCriteriaInSetRoutingCriteria(getDataFromFeature("getdata("+criteria+")")));
        SeleniumActions.verifyTextEquals(actualRoutingCriteria,getDataFromFeature("getdata("+criteria+")"),false);

        SeleniumActions.click(byExpandSideButton(getDataFromFeature("getdata("+criteria+")")),"Clicked expand button for "+getDataFromFeature("getdata("+criteria+")"));
        CommonMethods.waitForPageLoading();
        SeleniumActions.click(byViewButton_ExpandArrow,"Clicked View in expand arrow");
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to click on order selection criteria
     *
     */
    public static void clickOrderSelectionCriteria(){
        SeleniumActions.click(byOrderSelectionCriteria,"Clicked order selection criteria");
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to cverify shipped order country
     * @param country - country name
     *
     */
    public static void verifyShippedOrdersCountry(String country){
        String actualValue = SeleniumActions.getAtrribute(byValueInSelectionCriteria,"value",10);
        SeleniumActions.verifyTextEquals(actualValue,getDataFromFeature("getdata("+country+")"),false);
    }

    /**
     * Function to click on FN parcel determination strategy
     *
     */
    public static void clickFNParcelDeterminationStrategy() {
        SeleniumActions.click(byFNParcelDeterminationStrategy, "FNParcelDeterminationStrategy");
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to click on set parcel resource
     *
     */
    public static void clickSetParcelResource() {
        SeleniumActions.click(bySetParcelResource, "SetParcelResource");
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to verify ship via details
     *
     */
    public static void verifyShipViaDetails(){

//        By byValueTextField = By.xpath("//input[@data-component-id='ShipViaId']");
        String actualAttribute = SeleniumActions.getAtrribute(byShipViaId, "value", 10);
        SeleniumActions.verifyTextEquals(actualAttribute, getDataFromFeature("getdata(ShipViaId1)"),  false);
    }

    /**
     * Function to verify order selection rule value
     *
     */
    public static void verifyOrderSelectionRuleValue(){

//       By byValueTextField = By.xpath("(//input[@data-component-id='view-label-display'])[4]");
        String actualAttribute = SeleniumActions.getAtrribute(byValueInSelectionCriteria, "value", 10);
        SeleniumActions.verifyTextEquals(actualAttribute, getDataFromFeature("getdata(OrderSelectionRuleValue1)"),  false);
        Routing.selectBackToParcelStrategy();
    }

    /**
     * Function to navigate to parcel strategy
     *
     */
    public static void selectBackToParcelStrategy() {
        SeleniumActions.click(byBacktoParcelStrategy, "Back to Parcel Determination Strategy");
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to verify ship via details for second resource
     *
     */
    public static void verifyShipViaDetailsForSecondResource(){

//        By byValueTextField = By.xpath("//input[@data-component-id='ShipViaId']");
        String actualAttribute = SeleniumActions.getAtrribute(byShipViaId, "value", 10);
        SeleniumActions.verifyTextEquals(actualAttribute, getDataFromFeature("getdata(ShipViaId2)"), false);
    }

    /**
     * Function to verify order selection rule value for second resource
     *
     */
    public static void verifyOrderSelectionRuleValueForSecondResource(){

//        By byValueTextField = By.xpath("(//input[@data-component-id='view-label-display'])[4]");
        String actualAttribute = SeleniumActions.getAtrribute(byValueInSelectionCriteria, "value", 10);
        SeleniumActions.verifyTextEquals(actualAttribute, getDataFromFeature("getdata(OrderSelectionRuleValue2)"), false);
        Routing.selectBackToParcelStrategy1();
    }

    /**
     * Function to navigate to parcel strategy
     *
     */
    public static void selectBackToParcelStrategy1() {
        SeleniumActions.click(byBacktoParcelStrategy1, "Back to Parcel Determination Strategy");
        CommonMethods.waitForPageLoading();
    }

    public static void clickRoutingCriteriaLabel2Navigation(){
        SeleniumActions.click(byRoutingStrategyLabel2Navigation,"Navigated back to routing strategy second page");
        CommonMethods.waitForPageLoading();
    }
    public static void clickRoutingCriteriaLabel1Navigation(){
        SeleniumActions.click(byRoutingStrategyLabel1Navigation,"Navigated back to routing strategy page");
        CommonMethods.waitForPageLoading();
    }
}