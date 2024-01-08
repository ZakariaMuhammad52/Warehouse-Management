package web.Pages;

import com.dhl.reports.FrameworkLogger;
import com.dhl.reports.LogType;
import com.dhl.testdata.TestData_Json;
import com.dhl.utils.CurrentThreadInstance;
import com.dhl.utils.Variables;
import com.dhl.web.utils.SeleniumActions;
import org.openqa.selenium.By;
import stepdefinitions.CommonMethods;

@SuppressWarnings("unused")
public class OrderPlanningStrategyPage extends TestData_Json {

	private static final By byFNWAVE02OrderStrategy = By.xpath("//span[@title='FNWAVE02OrderStrategy']");
	private static final By byOrderSelectionCriteria = By.xpath("//ion-label[@data-component-id='OrderSelectionCriteria-step-indicator']");
	private static final By byOrderSelectionRules = By.xpath("//ion-label[contains(@data-component-id,'OrderSelectionRules')]");
	private static final By byCloseIconAtFirstIndex = By.xpath(
			"//span[contains(@data-component-id,'SelectionCriteriaId')]//ancestor::div[2]//following-sibling::slider-actions[1]//button");
	private static final By byOrderSelectionCapacities = By.xpath("//ion-label[contains(@data-component-id,'OrderSelectionCapacities')]");
	private static final By byOrderSelectionSequencingCriteria = By.xpath("//ion-label[contains(@data-component-id,'OrderSelectionSequencingCriteria')]");
	private static final By byFNWAVE03OrderStrategy = By.xpath("//span[@title='FNWAVE03OrderStrategy']");
	private static final By byRoutingStrategy = By.xpath("//*[contains(text(),'Name :')]//ancestor::card-view//*[@tabindex='0']//*[contains(@data-component-id,'RoutingStrategyId')]");
	private static final By byRouting = By.xpath("//ion-label[contains(@data-component-id,'Routing')]");

	/**
	 * Function to click FNWAVE02OrderStrategy
	 */
	public static void clickFNWAVE02OrderStrategy() {
		CommonMethods.scrollByParticularElement(byFNWAVE02OrderStrategy,"FNWAVE02OrderStrategy");
		SeleniumActions.click(byFNWAVE02OrderStrategy, "FNWAVE02OrderStrategy");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click OrderSelectionCriteria
	 */
	public static void clickOrderSelectionCriteria() {
		CommonMethods.scrollByParticularElement(byOrderSelectionCriteria,"OrderSelectionCriteria");
		SeleniumActions.click(byOrderSelectionCriteria, "OrderSelectionCriteria");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click OrderSelectionRules
	 */
	public static void clickOrderSelectionRules() {
		CommonMethods.scrollByParticularElement(byOrderSelectionRules,"OrderSelectionRules");
		SeleniumActions.click(byOrderSelectionRules, "OrderSelectionRules");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click CloseIcon AtFirstIndex
	 */
	public static void clickCloseIconAtFirstIndex() {
		SeleniumActions.click(byCloseIconAtFirstIndex, "Close Icon At FirstIndex");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to complete FNWAVEThreeOrderStrategy InOrderPlanningStrategyPage
	 */
	public static void verifyFNWAVEThreeOrderStrategyInOrderPlanningStrategyPage() {
		clickFNWAVE03OrderStrategy();
		FooterPanelPage.clickMoreButton();
		FooterPanelPage.clickViewButton();
		clickOrderSelectionCriteria();
		clickCloseIconAtFirstIndex();
		PutAwayPlanningStrategyPage.clickViewButton();
		clickOrderSelectionRules();

		String rule1 = getDataFromFeature("getdata(Rule1)");

		String a1=rule1.split(",")[0];
		String b1= rule1.split(",")[1];
		String c1=rule1.split(",")[2];
		String attribute1=rule1.split(",")[3];
		String operator1= rule1.split(",")[4];
		String value1=rule1.split(",")[5];
		FrameworkLogger.log(LogType.INFO, "Rule1 : " + rule1);
		CommonPage.verifyRules(a1,b1,c1, attribute1,operator1,Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder").toString());
        clickOrderSelectionCapacities();
		String selectionCapabilitiesRule = getDataFromFeature("getdata(Rule2)");
		String maxNumOfOrders=selectionCapabilitiesRule.split(",")[0];
		FrameworkLogger.log(LogType.INFO, "SelectionCapabilities Rule: " + selectionCapabilitiesRule);
		CommonPage.verifySelectionCapacities(maxNumOfOrders);
		clickOrderSelectionSequencingCriteria();
		String sequencingCriteriaRule1 = getDataFromFeature("getdata(Rule3)");
		String e1=sequencingCriteriaRule1.split(",")[0];
		String f1= sequencingCriteriaRule1.split(",")[1];
		String criteria1=sequencingCriteriaRule1.split(",")[2];
		String sequencing1=sequencingCriteriaRule1.split(",")[3];
		FrameworkLogger.log(LogType.INFO, "Sequencing Criteria Rule 1: " + sequencingCriteriaRule1);
		CommonPage.verifySequencingCriteria(e1,f1,criteria1,sequencing1);
		String sequencingCriteriaRule2 = getDataFromFeature("getdata(Rule4)");
		String e2=sequencingCriteriaRule1.split(",")[0];
		String f2= sequencingCriteriaRule1.split(",")[1];
		String criteria2=sequencingCriteriaRule1.split(",")[2];
		String sequencing2=sequencingCriteriaRule1.split(",")[3];
		FrameworkLogger.log(LogType.INFO, "Sequencing Criteria Rule 2: " + sequencingCriteriaRule2);
		CommonPage.verifySequencingCriteria(e2,f2,criteria2,sequencing2);
		CommonPage.clickClose2Icon();
		CommonPage.clickCloseIcon();
		CommonMethods.waitForPageLoading();
	}
	/**
	 * Function to complete FNWAVETwoOrderStrategy InOrderPlanningStrategyPage
	 */
	public static void verifyFNWAVETwoOrderStrategyInOrderPlanningStrategyPage() {
		clickFNWAVE02OrderStrategy();
		FooterPanelPage.clickMoreButton();
		FooterPanelPage.clickViewButton();
		clickOrderSelectionCriteria();
		clickCloseIconAtFirstIndex();
		PutAwayPlanningStrategyPage.clickViewButton();
		clickOrderSelectionRules();

		String rule1 = getDataFromFeature("getdata(Rule1)");
		String a1=rule1.split(",")[0];
		String b1= rule1.split(",")[1];
		String c1=rule1.split(",")[2];
		String attribute1=rule1.split(",")[3];
		String operator1= rule1.split(",")[4];
		String value1=rule1.split(",")[5];
		FrameworkLogger.log(LogType.INFO, "Rule1 : " + rule1);

		CommonPage.verifyRules(a1,b1,c1, attribute1,operator1,value1);
		String rule2 = getDataFromFeature("getdata(Rule2)");
		String a2=rule2.split(",")[0];
		String b2= rule2.split(",")[1];
		String c2=rule2.split(",")[2];
		String attribute2=rule2.split(",")[3];
		String operator2= rule2.split(",")[4];
		String value2=rule2.split(",")[5];
		FrameworkLogger.log(LogType.INFO, "Rule2 : " + rule2);
		CommonPage.verifyRules(a2,b2,c2, attribute2,operator2,value2);
		CommonPage.clickClose2Icon();
		CommonPage.clickCloseIcon();
		CommonMethods.waitForPageLoading();
	}
	/**
	 * Function to click Order Selection Capacities
	 */
	public static void clickOrderSelectionCapacities() {
		CommonMethods.scrollByParticularElement(byOrderSelectionCapacities,"OrderSelectionCapacities");
		SeleniumActions.click(byOrderSelectionCapacities, "OrderSelectionCapacities");
		CommonMethods.waitForPageLoading();
	}
	/**
	 * Function to click Order Selection SEquencing Criteria
	 */
	public static void clickOrderSelectionSequencingCriteria() {
		CommonMethods.scrollByParticularElement(byOrderSelectionSequencingCriteria,"Order Selection Sequencing Criteria");
		SeleniumActions.click(byOrderSelectionSequencingCriteria, "Order Selection Sequencing Criteria");
		CommonMethods.waitForPageLoading();
	}
	/**
	 * Function to click FNWAVE03OrderStrategy
	 */
	public static void clickFNWAVE03OrderStrategy() {
		CommonMethods.scrollByParticularElement(byFNWAVE03OrderStrategy,"FNWAVE03OrderStrategy");
		SeleniumActions.click(byFNWAVE03OrderStrategy, "FNWAVE03OrderStrategy");
		CommonMethods.waitForPageLoading();
	}
	/**
	 * Function to Edit FNWAVEThreeOrderStrategy InOrderPlanningStrategyPage
	 */
	public static void editFNWAVEThreeOrderStrategyInOrderPlanningStrategyPage() {
		clickFNWAVE03OrderStrategy();
		FooterPanelPage.clickMoreButton();
		FooterPanelPage.clickViewButton();
		clickOrderSelectionCriteria();
		clickCloseIconAtFirstIndex();
		PutAwayPlanningStrategyPage.clickViewButton();
		clickOrderSelectionRules();

		String rule1 = getDataFromFeature("getdata(Rule1)");

		String a1 = rule1.split(",")[0];
		String b1 = rule1.split(",")[1];
		String c1 = rule1.split(",")[2];
		String attribute1 = rule1.split(",")[3];
		String operator1 = rule1.split(",")[4];
		String value1 = rule1.split(",")[5];
		FrameworkLogger.log(LogType.INFO, "Rule1 : " + rule1);
		CommonPage.editRules(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "OriginalOrder").toString());
	}

	/**
	 * Function to Select the Routing and Verify AT Routing Strategy on Order Planning Strategy Page
	 * button
	 */
	public static void selectRoutingAndVerifyAtRoutingStrategy() {
		CommonMethods.scrollByParticularElement(byRouting, "Routing Option");
		SeleniumActions.click(byRouting, "Routing Option");
		CommonMethods.waitForPageLoading();
		String strtext = SeleniumActions.getText(byRoutingStrategy);
		if (strtext.equals(getDataFromFeature(getDataFromFeature("getdata(ATRoutingStrategy)")))) {
			FrameworkLogger.log(LogType.PASS, "Routing Strategy Verification passed : " + strtext);
		} else {
			FrameworkLogger.log(LogType.FAIL, "Routing Strategy Verification failed. Expected :" + getDataFromFeature("getdata(ATRoutingStrategy)")
					+ " , Actual :" + strtext);
		}

	}
	}
