package web.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.dhl.constants.FrameworkConstants;
import com.dhl.driver.DriverManager;
import com.dhl.reports.FrameworkLogger;
import com.dhl.reports.LogType;
import com.dhl.testdata.TestData_Json;
import com.dhl.web.utils.SeleniumActions;

import stepdefinitions.CommonMethods;

@SuppressWarnings("unused")
public class CommonPage extends TestData_Json {

	private static final By byRowAtFirstIndex = By
			.xpath("(//card-view[contains(@class,'card-views')]//div[contains(@class,'card-row')])");// finetuned



	private static final By byUploadDocument = By.xpath("//*[@id='documentInputId']");
	private static final By bySaveBtn = By.xpath("//ion-button[contains(text(),'SAVE')]");
	private static String ImportFilePath = FrameworkConstants.getTestDataDirPath() + "ImportFiles/";
	private static final By byOkbutton = By.xpath("//span[contains(text(),'Ok')]");
	private static final By byDetailsbutton = By.xpath("//button[@data-component-id='Details']");
	private static final By byaddinfobutton = By.xpath("//span[text()='Additional Information']");
	private static final By byCloseIcon = By.xpath("//img[@name='close']");
	private static final By byClose2Icon = By.xpath("(//img[@name='close'])[2]");
	private static final By byRowList = By
			.xpath("//card-view[@class='dm-fill-space card-views']//div[contains(@class,'card-row primary')]");
	private static final By byNoRecordsFoundLabel = By.xpath("//ion-label[contains(text(),'No Records found')]");
	private static final By byCheckboxAtFirstIndex = By
			.xpath("(//label[contains(@class, 'datatable-checkbox')]//input)[1]");
	private static final By byThreeDots = By.xpath("//ion-icon[@class='dmuiIcon filter-arrow md hydrated']");
	private static final By byViewButton = By.xpath("//button[@data-component-id='View']");
	private static final By byContinueButton = By.xpath("//button[contains(text(),'Continue')]");

	private static final By byMaxNumberofOrdersField = By.xpath("//input[@data-component-id='MaxOrders']");

	private static final By byRowAtSecondIndex = By
			.xpath("(//card-view[contains(@class,'card-views')]//div[contains(@class,'card-row')])[2]");// finetuned



	private static final By byRowAtThirdIndex = By
			.xpath("(//card-view[contains(@class,'card-views')]//div[contains(@class,'card-row')])[3]");// finetuned



	private static final By byRowAtFourthIndex = By
			.xpath("(//card-view[@class='dm-fill-space card-views']//div[contains(@class,'card-row primary')])[4]");
	private static final By byEditButton = By.xpath("//button[contains(@data-component-id,'edit')]");// finetuned
																								// xpath
	private static final By bySaveandCloseButton = By.xpath("//button[contains(@data-component-id,'SaveAndClose')]");// finetuned


	private static final By byValueEditField = By.xpath("//input[@placeholder='Enter Value']");
	private static final By byConfirmMessage = By.xpath("//div[contains(text(),'submitted')]");
	private static final By bySortButton = By.xpath("//ion-button[@data-component-id='Sort-Button']");
	private static final By byClickokButton = By.xpath("//ion-button[@data-component-id='ok-btn']");

	/**
	 * Function to click Row At FirstIndex
	 */
	public static void clickRowAtFirstIndex() {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byRowAtFirstIndex, "Row At FirstIndex");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to select file to import params importFileName - file to import
	 */
	public static void selectFileToImport(String importFileName) {
		String FilePath = ImportFilePath + importFileName;
		System.out.println("file location : " + FilePath);
		WebElement upload = DriverManager.getDriver().findElement(byUploadDocument);
		upload.sendKeys(FilePath);
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(bySaveBtn, "click Save button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click on ok button
	 */
	public static void clickOkButton() {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byOkbutton, "OK button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click on details button
	 */
	public static void clickDetailsbutton() {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byDetailsbutton, "Clicked on details button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click on additional information button
	 */
	public static void clickAddinfobutton() {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byaddinfobutton, "Clicked on additional information button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click close icon
	 */
	public static void clickCloseIcon() {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byCloseIcon, "Close icon");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click close2 icon
	 */
	public static void clickClose2Icon() {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byClose2Icon, "Close2 icon");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function get Row Count
	 *
	 * @return - number of rows in the page
	 */
	public static int getRowCount() {
		CommonMethods.waitForPageLoading();
		return DriverManager.getDriver().findElements(byRowList).size();
	}

	/**
	 * Function to get Row Elements
	 *
	 * @return - number of row Elements in the page
	 */
	public static List<WebElement> getRowElements() {
		CommonMethods.waitForPageLoading();
		return DriverManager.getDriver().findElements(byRowList);
	}

	/**
	 * Function verifyNoRecordsLabelDisplayed
	 */
	public static void verifyNoRecordsLabelDisplayed() {
		SeleniumActions.verifyElementVisible(byNoRecordsFoundLabel, 20, "No Records Label");
	}

	/**
	 * Function to select checkbox At FirstIndex
	 */
	public static void selectCheckBoxAtFirstIndex() {
		SeleniumActions.click(byCheckboxAtFirstIndex, "checkbox At FirstIndex");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to select 3 dots
	 */
	public static void selectThreeDots() {
		SeleniumActions.click(byThreeDots, "ThreeDots button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to select view button
	 */
	public static void selectViewButton() {
		SeleniumActions.click(byViewButton, "View button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to select continue button
	 */
	public static void selectContinueButton() {
		SeleniumActions.click(byContinueButton, "Continue button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click row at 2nd index
	 */
	public static void clickRowAtSecondIndex() {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byRowAtSecondIndex, "Row At SecondIndex");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click row at 3rd index
	 */
	public static void clickRowAtThirdIndex() {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byRowAtThirdIndex, "Row At ThirdIndex");

		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click row at 4th index
	 */
	public static void clickRowAtFourthIndex() {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byRowAtFourthIndex, "Row At FourthIndex");

		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click MenuWithTitle
	 * @param title- give menu with title
	 */
	public static void clickMenuWithTitle(String title) {
		SeleniumActions.click(By.xpath("//a[@title='" + title + "']"), "MenuWithTitle");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click MenuWith Link
	 *
	 * @param link- give menu with link
	 */
	public static void clickMenuWithLink(String link) {
		SeleniumActions.click(By.xpath("//a[text()='" + link + "']"), "MenuWith Link");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to verify Rules
	 */
	public static void verifyRules(String c1, String c2, String c3, String attribute, String operator, String value) {
		By byAttributeTextField = By.xpath("(//input[@data-component-id='view-label-display'])[" + (c1) + "]");
		By byOperatorTextField = By.xpath("(//input[@data-component-id='view-label-display'])[" + (c2) + "]");
		By byValueTextField = By.xpath("(//input[@data-component-id='view-label-display'])[" + (c3) + "]");

		String actualAttribute = SeleniumActions.getAtrribute(byAttributeTextField, "value", 10);
		String actualOperator = SeleniumActions.getAtrribute(byOperatorTextField, "value", 10);
		String actualValue = SeleniumActions.getAtrribute(byValueTextField, "value", 10);
		SeleniumActions.verifyTextEquals(actualAttribute, attribute, false);
		SeleniumActions.verifyTextEquals(actualOperator, operator, false);
		SeleniumActions.verifyTextEquals(actualValue, value, false);
	}

	/**
	 * Function to Edit Rules
	 * @param value -order value
	 */
	public static void editRules(String value) {
		SeleniumActions.click(byEditButton, "Clicked on Edit button");
		SeleniumActions.clear(byValueEditField, value);
		SeleniumActions.sendTextToElement(byValueEditField, value, "Order Value starts with");
		SeleniumActions.click(bySaveandCloseButton, "Save and Close button");
		String actualValue = SeleniumActions.getAtrribute(byValueEditField, "value", 10);
	}

	/**
	 * Function to verify Selection Capacities
	 * @param expValue- give expected value of orders
	 */
	public static void verifySelectionCapacities(String expValue) {
		String actualValue = SeleniumActions.getAtrribute(byMaxNumberofOrdersField, "value", 10);
		SeleniumActions.verifyTextEquals(actualValue, expValue, false);
	}

	/**
	 * Function to verify Sequencing Criteria Rules
	 */
	public static void verifySequencingCriteria(String c1, String c2, String criteria, String sequencing) {
		By byCriteriaTextField = By.xpath("(//input[@data-component-id='view-label-display'])[" + (c1) + "]");
		By bySequencingTextField = By.xpath("(//input[@data-component-id='view-label-display'])[" + (c2) + "]");

		String actualCriteria = SeleniumActions.getAtrribute(byCriteriaTextField, "value", 10);
		String actualSequencing = SeleniumActions.getAtrribute(bySequencingTextField, "value", 10);
		SeleniumActions.verifyTextEquals(actualCriteria, criteria, false);
		SeleniumActions.verifyTextEquals(actualSequencing, sequencing, false);

	}

	/**
	 * Function to verifyRowCount
	 * 
	 * @param count - value to verify
	 */
	public static void verifyRowCount(int count) {
		int actualCount = getRowCount();
		CommonMethods.verifyValue(String.valueOf(actualCount), String.valueOf(count), "Row Count", "Equal");
	}

	/**
	 * Function to verify Confirm Message Contains
	 * 
	 * @params message - value to verify
	 */
	public static void verifyConfirmMessageContains(String message) {
		String actualMessage = SeleniumActions.getText(byConfirmMessage);
		if (actualMessage != null && !actualMessage.trim().isEmpty()) {
			if (actualMessage.contains(message)) {
				FrameworkLogger.log(LogType.PASS, "Verification of Confirm message passed. " + actualMessage);
			} else {
				FrameworkLogger.log(LogType.FAIL, "Verification of Confirm message failed. Expected : " + message
						+ ", Actual : " + actualMessage);
			}
		} else {
			FrameworkLogger.log(LogType.FAIL,
					"Verification of Confirm message failed. Confirm message is null or empty");
		}
	}
	/**
	 * Function to sort columns
	 *
	 */
	public static void clickSortButton() {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(bySortButton, "Sort by Created Time");
		CommonMethods.waitForPageLoading();
	}


	/**
	 * Function to verify Value in Rules
	 * @param column- pass the column index
	 * @param  value- Pass the expected value
	 *
	 */
	public static void verifyValueInRules(String column, String value) {
		By byValueTextField = By.xpath("(//input[@data-component-id='view-label-display'])[" + (column) + "]");
		String actualValue = SeleniumActions.getAtrribute(byValueTextField, "value", 10);
		SeleniumActions.verifyTextEquals(actualValue, value, false);
	}


	/**
	 * Function to select ok button
	 */
	public static void clickonOkbutton() {
		SeleniumActions.click(byClickokButton, "ok button");
		CommonMethods.waitForPageLoading();
	}
}
