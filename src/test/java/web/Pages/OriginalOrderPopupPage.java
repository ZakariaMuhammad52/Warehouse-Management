package web.Pages;

import com.dhl.driver.DriverManager;
import com.dhl.testdata.TestData_Json;
import com.dhl.utils.CurrentThreadInstance;
import com.dhl.utils.Variables;
import com.dhl.web.utils.SeleniumActions;
import com.jayway.jsonpath.JsonPath;
import org.openqa.selenium.By;
import stepdefinitions.CommonMethods;

@SuppressWarnings("unused")
public class OriginalOrderPopupPage extends TestData_Json {

	private static final By byExtStrategyAtrributesLabel = By.xpath("//span[contains(text(),'{Extended.DhlStrategyAttributes}')]");
	private static final By byExtCustomerRefLabel = By.xpath("//span[contains(text(),'{Extended.DhlCustomerReferences}')]");
	private static final By byCusterReference1 = By.xpath("//div[@data-component-id='Extended.DhlCustRef1']");
	private static final By byCusterReference2 = By.xpath("//div[@data-component-id='Extended.DhlCustRef2']");
	private static final By byCusterReference3 = By.xpath("//div[@data-component-id='Extended.DhlCustRef3']");
	private static final By byOrderPlanningStrategyAtt1 = By.xpath("//div[@data-component-id='Extended.DhlOrdPlanStratAttr1']");
	private static final By byPriority = By.xpath("//form//span[@data-component-id='Priority']");
	private static final By byOrderNoteLabel = By.xpath("//span[contains(text(),'Order Note')]");
	private static final By byOrderLineNoteLabel = By.xpath("//span[contains(text(),'Order Line Note')]");

	/**
	 * Function to return column data of note type
	 * @param row - note type id row index
	 */
	private static By byNoteTypeColumnData(int row){
		By byNoteType = By.xpath("//div[contains(@data-component-id,'NoteTypeId--"+row+"')]");
		return byNoteType;
	}
	/**
	 * Function to return column data of note code
	 * @param row - note code id row index
	 */
	private static By byNoteCodeColumnData(int row){
		By byNoteCode = By.xpath("//div[contains(@data-component-id,'NoteCodeId--"+row+"')]");
		return byNoteCode;
	}
	/**
	 * Function to return column data of note
	 * @param row - note text row index
	 */
	private static By byNoteColumnData(int row){
		By byNoteText = By.xpath("//div[contains(@data-component-id,'NoteText--"+row+"')]");
		return byNoteText;
	}
	/**
	 * Function to return column data
	 * @param row - note row index
	 */
	private static By byVisibilityIdColumnData(int row){
		By byVisibilityId = By.xpath("//div[contains(@data-component-id,'VisibilityId--"+row+"')]");
		return byVisibilityId;
	}
	/**
	 * Function to click extended customer referance lable
	 *
	 */
	public static void clickExtendedCustomerReferenceLabel() {
		SeleniumActions.click(byExtCustomerRefLabel, "click Extented customer reference Label");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click extended strategy attribute lable
	 *
	 */
	public static void clickExtendedStrategyAttributesLabel() {
		SeleniumActions.click(byExtStrategyAtrributesLabel, "click Extented Strategy Attribute Label");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to Verify attribute values for original order header template
	 *
	 * @param template - Current Scenario templatename which will be stored in json string variable
	 *
	 */
	public static void verifyAttributeValuesForOriginalOrderHeaderTemplateInOriginalOrder(String template) {
		CommonPage.clickRowAtFirstIndex();
		FooterPanelPage.clickDetailsButton();
		String json=(String) Variables.get(CurrentThreadInstance.getCurrentScenarioId()+template);

		String expectedPriority = JsonPath.read(json, "$.Priority");
		String actualPriority = SeleniumActions.getText(byPriority);
		SeleniumActions.verifyTextEquals(actualPriority, expectedPriority,false);

		clickExtendedCustomerReferenceLabel();
		String expectedCustomerRef1 = JsonPath.read(json, "$.DhlCustRef1");
		String actualCustomerRef1 = SeleniumActions.getText(byCusterReference1);
		SeleniumActions.verifyTextEquals(actualCustomerRef1, expectedCustomerRef1,false);

		String expectedCustomerRef2 = JsonPath.read(json, "$.DhlCustRef2");
		String actualCustomerRef2 = SeleniumActions.getText(byCusterReference2);
		SeleniumActions.verifyTextEquals(actualCustomerRef2, expectedCustomerRef2,false);

		String expectedCustomerRef3 = JsonPath.read(json, "$.DhlCustRef3");
		String actualCustomerRef3 = SeleniumActions.getText(byCusterReference3);
		SeleniumActions.verifyTextEquals(actualCustomerRef3, expectedCustomerRef3,false);

		clickExtendedStrategyAttributesLabel();
		String expectedOrderPlanStrategyAtt1 = JsonPath.read(json, "$.DhlOrdPlanStratAttr1");
		String actualOrderPlanStrategyAtt1 = SeleniumActions.getText(byOrderPlanningStrategyAtt1);
		SeleniumActions.verifyTextEquals(actualOrderPlanStrategyAtt1, expectedOrderPlanStrategyAtt1,true);
		CommonPopupPage.clickCloseIcon();
	}

	/**
	 * Function to verify extended attribute values for original order line template
	 *
	 */
	public static void verifyExtendedAttributeValuesForOriginalOrderLineTemplateInOriginalOrder() {
		CommonPage.clickRowAtFirstIndex();
		FooterPanelPage.clickDetailsButton();

		clickExtendedCustomerReferenceLabel();
		String actualCustomerRef1 = DriverManager.getDriver().findElement(byCusterReference1).getText();
		SeleniumActions.verifyTextEquals(actualCustomerRef1, "",false);

		String actualCustomerRef2 = DriverManager.getDriver().findElement(byCusterReference2).getText();
		SeleniumActions.verifyTextEquals(actualCustomerRef2, "",false);

		String actualCustomerRef3 = DriverManager.getDriver().findElement(byCusterReference3).getText();
		SeleniumActions.verifyTextEquals(actualCustomerRef3, "",false);

		clickExtendedStrategyAttributesLabel();
		String actualOrderPlanStrategyAtt1 = DriverManager.getDriver().findElement(byOrderPlanningStrategyAtt1).getText();
		SeleniumActions.verifyTextEquals(actualOrderPlanStrategyAtt1, "",false);
		CommonPopupPage.clickCloseIcon();
	}

	/**
	 * Function to verify order notes with order notes template
	 * @param template1 - template name
	 * @param template2 - template name
	 */
	public static void verifyOrderNotesDataWithOrderNotesTemplate(String template1,String template2) {
		CommonMethods.waitForPageLoading();
//		CommonPage.clickRowAtFirstIndex();
		FooterPanelPage.clickDetailsButton();

		clickOrderNoteLabel();
		String tsNote_json=(String) Variables.get(CurrentThreadInstance.getCurrentScenarioId()+template1);
		String ucNote_json=(String) Variables.get(CurrentThreadInstance.getCurrentScenarioId()+template2);

		String expectedNoteType_TS = JsonPath.read(tsNote_json, "$.NoteTypeId");
		String actualNoteType_TS = SeleniumActions.getText(byNoteTypeColumnData(0));
		SeleniumActions.verifyTextEquals(actualNoteType_TS, expectedNoteType_TS,false);

		String expectedNoteType_UC = JsonPath.read(ucNote_json, "$.NoteTypeId");
		String actualNoteType_UC = SeleniumActions.getText(byNoteTypeColumnData(1));
		SeleniumActions.verifyTextEquals(actualNoteType_UC, expectedNoteType_UC,false);

		String expectedNoteCode_TS = JsonPath.read(tsNote_json, "$.NoteCodeId");
		String actualNoteCode_TS = SeleniumActions.getText(byNoteCodeColumnData(0));
		SeleniumActions.verifyTextEquals(actualNoteCode_TS, expectedNoteCode_TS,false);

		String expectedNoteCode_UC = JsonPath.read(ucNote_json, "$.NoteCodeId");
		String actualNoteCode_UC = SeleniumActions.getText(byNoteCodeColumnData(1));
		SeleniumActions.verifyTextEquals(actualNoteCode_UC, expectedNoteCode_UC,false);

		String expectedNote_TS = JsonPath.read(tsNote_json, "$.NoteText");
		String actualNote_TS = SeleniumActions.getText(byNoteColumnData(0));
		SeleniumActions.verifyTextEquals(actualNote_TS, expectedNote_TS,false);

		String expectedNoteText_UC = JsonPath.read(ucNote_json, "$.NoteText");
		String actualNoteText_UC = SeleniumActions.getText(byNoteColumnData(1));
		SeleniumActions.verifyTextEquals(actualNoteText_UC, expectedNoteText_UC,false);

		String expectedVisiblityId_TS = JsonPath.read(tsNote_json, "$.VisiblityId");
		String actualVisiblityId_TS = SeleniumActions.getText(byVisibilityIdColumnData(0));
		SeleniumActions.verifyTextEquals(actualVisiblityId_TS, expectedVisiblityId_TS,false);

		String expectedVisiblityId_UC = JsonPath.read(ucNote_json, "$.VisiblityId");
		String actualVisiblityId_UC = SeleniumActions.getText(byVisibilityIdColumnData(1));
		SeleniumActions.verifyTextEquals(actualVisiblityId_UC, expectedVisiblityId_UC,false);
		CommonPopupPage.clickCloseIcon();
	}

	/**
	 * Function to click on order note label
	 *
	 */
	public static void clickOrderNoteLabel() {
		SeleniumActions.click(byOrderNoteLabel, "click order note Label");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click order line lable
	 *
	 */
	public static void clickOrderLineNoteLabel() {
		SeleniumActions.click(byOrderLineNoteLabel, "click order line note Label");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to  verify order line note data with order notes template
	 * @param template2 - template name
	 * @param template1 - template name
	 */
	public static void verifyOrderLineNotesDataWithOrderNotesTemplate(String template1,String template2) {
		CommonMethods.waitForPageLoading();
//		CommonPage.clickRowAtFirstIndex();
		FooterPanelPage.clickDetailsButton();

		clickOrderLineNoteLabel();
		String tsNote_json = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + template1);
		String ucNote_json = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + template2);

		String expectedNoteType_TS = JsonPath.read(tsNote_json, "$.NoteTypeId");
		String actualNoteType_TS = SeleniumActions.getText(byNoteTypeColumnData(0));
		SeleniumActions.verifyTextEquals(actualNoteType_TS, expectedNoteType_TS,  false);

		String expectedNoteType_UC = JsonPath.read(ucNote_json, "$.NoteTypeId");
		String actualNoteType_UC = SeleniumActions.getText(byNoteTypeColumnData(1));
		SeleniumActions.verifyTextEquals(actualNoteType_UC, expectedNoteType_UC,  false);

		String expectedNoteCode_TS = JsonPath.read(tsNote_json, "$.NoteCodeId");
		String actualNoteCode_TS = SeleniumActions.getText(byNoteCodeColumnData(0));
		SeleniumActions.verifyTextEquals(actualNoteCode_TS, expectedNoteCode_TS,  false);

		String expectedNoteCode_UC = JsonPath.read(ucNote_json, "$.NoteCodeId");
		String actualNoteCode_UC = SeleniumActions.getText(byNoteCodeColumnData(1));
		SeleniumActions.verifyTextEquals(actualNoteCode_UC, expectedNoteCode_UC,  false);

		String expectedNote_TS = JsonPath.read(tsNote_json, "$.NoteText");
		String actualNote_TS = SeleniumActions.getText(byNoteColumnData(0));
		SeleniumActions.verifyTextEquals(actualNote_TS, expectedNote_TS,  false);

		String expectedNoteText_UC = JsonPath.read(ucNote_json, "$.NoteText");
		String actualNoteText_UC = SeleniumActions.getText(byNoteColumnData(1));
		SeleniumActions.verifyTextEquals(actualNoteText_UC, expectedNoteText_UC, false);

		String expectedVisiblityId_TS = JsonPath.read(tsNote_json, "$.VisiblityId");
		String actualVisiblityId_TS = SeleniumActions.getText(byVisibilityIdColumnData(0));
		SeleniumActions.verifyTextEquals(actualVisiblityId_TS, expectedVisiblityId_TS, false);

		String expectedVisiblityId_UC = JsonPath.read(ucNote_json, "$.VisiblityId");
		String actualVisiblityId_UC = SeleniumActions.getText(byVisibilityIdColumnData(1));
		SeleniumActions.verifyTextEquals(actualVisiblityId_UC, expectedVisiblityId_UC, false);
//		CommonPopupPage.clickCloseIcon();
	}

}
