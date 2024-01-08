package web.Pages;

import com.dhl.driver.DriverManager;
import com.dhl.reports.FrameworkLogger;
import com.dhl.reports.LogType;
import com.dhl.testdata.TestData_Json;
import com.dhl.web.utils.KeyboardActions;
import com.dhl.web.utils.SeleniumActions;
import org.openqa.selenium.By;
import stepdefinitions.CommonMethods;

public class RoutingStrategyPage extends TestData_Json {

    private static final By bysetRoutingCriteria = By.xpath("//*[@data-component-id='SetRoutingCriteria-step-indicator']");
//    private static final By byselectRoutingCriteria = By.xpath("(//*[(text()=' Routing Criteria : ')]//ancestor::card-view//*[@title='AT LTL Australia'])[1]");
    private static final By byOpenSlideOptionForATLTLAU = By.xpath(
            "//*[@title='AT LTL Australia']//ancestor::ion-item//slider-actions[contains(@data-component-id,'Slide-Actions')]//button[@data-component-id='action-closed-card-view']");
    private static final By byRoutingStrategyTextbox = By.xpath("//ion-input[contains(@data-component-id,'RoutingStrategyId')]/input");
    private static final By byExpandNameField = By.xpath("//span[@title='Name']/following-sibling::ion-button[contains(@data-component-id,'expand-button')]");
    private static final By byParcelDeterminationStrategy = By.xpath("//ion-label[contains(@data-component-id,'ParcelDeterminationStrategy')]");
    private static final By byBackToRoutingStrategy = By.xpath("(//li[contains(@data-component-id,'RoutingStrategy')]/a)[2]");
    private static final By byParcelStrategyId = By.xpath("//input[contains(@data-component-id,'ParcelStrategyId')]");
    private static final By byCountrytext = By.xpath("(//input[contains(@data-component-id,'view-label-display')])[4]");



    /**
     * Function to Select Routing Criteria
     */
    public static void selectRoutingCriteria() {
        SeleniumActions.click(bysetRoutingCriteria, "SelectRoutingCriteria button");
        CommonMethods.waitForPageLoading();
    }
    /**
     * Function to Open Slide Option
     */
    public static void openSlideOption() {
        CommonMethods.waitForPageLoading();
        SeleniumActions.click(byOpenSlideOptionForATLTLAU, "Open Slide option");
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to Open Slide Option
     */
    public static void verifyCountryRule() {
//        final By byCountrytext = By.xpath("(//input[@data-component-id='view-label-display'])[4]");
        CommonMethods.waitForPageLoading();
        String strText = SeleniumActions.getText(byCountrytext);
        System.out.println(strText);
        FrameworkLogger.log(LogType.PASS,
                strText+ " verification passed. Expected text \"" + strText + "\" is contains in actual text");
        SeleniumActions.verifyTextContains(getDataFromFeature("getData(CountryRule)"),strText,  false);
    }

    /**
     * Function to filter routing strategy
     * @param strText - routing strategy name to filter
     *
     */
    public static void filterByNameRoutingStrategy(String strText) {
        CommonMethods.waitForPageLoading();
        if (DriverManager.getDriver().findElements(byRoutingStrategyTextbox).size() < 1) {
            SeleniumActions.click(byExpandNameField , "Expand icon");
        }
        SeleniumActions.getElement(byRoutingStrategyTextbox).clear();
        SeleniumActions.sendTextToElement(byRoutingStrategyTextbox, strText, "Name search field");
        CommonMethods.waitForPageLoading();
        KeyboardActions.pressEnterKey(byRoutingStrategyTextbox);
        CommonMethods.waitForPageLoading();
    }
    /**
     * Function to selct parcel determination strategy
     *
     */
    public static void selectParcelDeterminationStrategy() {
        SeleniumActions.click(byParcelDeterminationStrategy, "ParcelDeterminationStrategy button");
        CommonMethods.waitForPageLoading();
    }

    /**
     * Function to verify parcel determination strategy
     *
     */
    public static void verifyParcelDeterminationStrategy(){

//        By byValueTextField = By.xpath("//input[@data-component-id='ParcelStrategyId']");
        String actualAttribute = SeleniumActions.getAtrribute(byParcelStrategyId, "value", 10);
        SeleniumActions.verifyTextEquals(actualAttribute, getDataFromFeature("getdata(ParcelDeterminationStrategy)"), false);
       RoutingStrategyPage.selectBackToRoutingStrategy();
    }

    /**
     * Function to navigate to routing strategy
     *
     */
    public static void selectBackToRoutingStrategy() {
        SeleniumActions.click(byBackToRoutingStrategy, "BackToRoutingStrategy button");
        CommonMethods.waitForPageLoading();
    }
}
