package web.Pages;

import com.dhl.driver.DriverManager;
import com.dhl.reports.FrameworkLogger;
import com.dhl.reports.LogType;
import com.dhl.testdata.TestData_Json;
import com.dhl.utils.ConfigurationUtils;
import com.dhl.utils.CurrentThreadInstance;
import com.dhl.utils.Variables;
import com.dhl.web.utils.KeyboardActions;
import com.dhl.web.utils.SeleniumActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import stepdefinitions.CommonMethods;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("unused")
public class PixVisibilityPage extends TestData_Json {

	private static final By byAddAdjustType = By.xpath("//span[@data-component-id='AdjustedType' and @title='ADD']");
	private static final By bySubtractAdjustType = By.xpath("//span[@data-component-id='AdjustedType' and @title='SUBTRACT']");
	private static final By byItemId = By.xpath("//ion-input[contains(@data-component-id,'ItemId')]/input");
	private static final By byCreatedBy = By.xpath("//ion-input[contains(@data-component-id,'CreatedBy')]/input");
	private static final By byExpandItemfield = By.xpath("//span[contains(@title,'Item')]/following-sibling::ion-button[contains(@data-component-id,'expand-button')]");
	private static final By byExpandCreatedByfield = By.xpath("//span[contains(@title,'Created by')]/following-sibling::ion-button[contains(@data-component-id,'expand-button')]");
	private static final By byInventorySummaryAvail = By.xpath("//span[contains(text(),'InvSync_Summary_Avail')]");
	private static final By byProcessedDate = By.xpath("//span[contains(text(),'Processed date')]/following-sibling::span");
	private static final By byPixStatus = By.xpath("//div[contains(@data-component-id,'StatusId')]");
	private static final By bySUBTRACT = By.xpath("(//span[contains(text(),'SUBTRACT')]//following::div/span[contains(text(),'Inventory Adjustment')])[1]");
	/**
	 * Function to verify RowCount
	 * @param count  row count to veify
	 */
	public static void verifyRowCount(int count) {
		int actualCount=CommonPage.getRowCount();
		SeleniumActions.verifyTextEquals(String.valueOf(actualCount), String.valueOf(count),false);
	}

	/**
	 * Function to verify AdjustTypes
	 */
	public static void verifyAdjustTypes() {
		SeleniumActions.verifyElementVisible(byAddAdjustType,10, "byAddAdjustType");
		SeleniumActions.verifyElementVisible(bySubtractAdjustType,10, "bySubtractAdjustType");
	}


	/**
	 * Function to Verify verifyPixDataForAdjustment
	 * @param - adjustment
	 */
	public static void verifyPixDataForAdjustment(String adjustProductStatus) {
		List<WebElement> rowElements = CommonPage.getRowElements();
		int expectedRowCount=0;
		if(adjustProductStatus.equalsIgnoreCase("Damaged")){
			expectedRowCount=2;
		}
		if(adjustProductStatus.equalsIgnoreCase("Available")){
			expectedRowCount=2;
		}
		if(adjustProductStatus.equalsIgnoreCase("Inspection")){
			expectedRowCount=4;
		}
		int rowCount=rowElements.size();
		if (rowCount==expectedRowCount) {
			FrameworkLogger.log(LogType.PASS,"Row count Verification Passed for PixData. RowCount: "+rowCount);
		} else {
			FrameworkLogger.log(LogType.FAIL,"Row count Verification Failed for PixData. Expected RowCount: "+expectedRowCount+", Actual RowCount: "+rowCount);
		}

		for(int i=0;i<2;i++) {
			rowElements.get(i).click();
			CommonMethods.waitForPageLoading();
			FooterPanelPage.clickPixDataButton();
			ViewJsonPage.verifyContent(adjustProductStatus, i+1);
			CommonPopupPage.clickCloseIcon();
			rowElements = CommonPage.getRowElements();
		}
	}

	/**
	 * Function to select Specification on PIX Visibility
	 * @param strSpecification -  which need to searched
	 */
	public static void filterBySpecification(String strSpecification) {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(By.xpath("//ion-checkbox[@data-component-id='" + strSpecification + "']"), "PIX Specification");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to enter ItemID on PIX Visibility
	 * @param strTemID -  which need to searched
	 */
	public static void filterByItemID(String strTemID) {
		CommonMethods.waitForPageLoading();
		if (DriverManager.getDriver().findElements(byItemId).size() < 1) {
			SeleniumActions.click(byExpandItemfield, "Expand icon");
		}
		SeleniumActions.sendTextToElement(byItemId, strTemID, "Item ID search field");
		CommonMethods.waitForPageLoading();
		KeyboardActions.pressEnterKey(byItemId);
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to enter CreatedBy on PIX Visibility
	 */
	public static void filterByCreatedBy() {
		CommonMethods.waitForPageLoading();
		if (DriverManager.getDriver().findElements(byCreatedBy).size() < 1) {
			SeleniumActions.click(byExpandCreatedByfield, "Expand icon");
		}
		SeleniumActions.sendTextToElement(byCreatedBy, ConfigurationUtils.getFrameworkConfig("appusername"), "Created by search field");
		CommonMethods.waitForPageLoading();
		KeyboardActions.pressEnterKey(byCreatedBy);
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to get count of Items
	 */
	public static void get_count_of_Items() {
		CommonMethods.waitForPageLoading();
		Variables.set(CurrentThreadInstance.getCurrentScenarioId()+"count", DriverManager.getDriver().findElements(byInventorySummaryAvail).size());
	}

	/**
	 * Function to open slide options in PIX Visibility
	 */
	public static void openSlideOption(int i) {
		CommonMethods.waitForPageLoading();
		CommonMethods.scrollByParticularElement(By.xpath("(//span[contains(text(),'InvSync_Summary_Avail')]//following::slider-actions)[" +i +"]//button"), "Slide Option");
		SeleniumActions.click(By.xpath("(//span[contains(text(),'InvSync_Summary_Avail')]//following::slider-actions)[" +i +"]//button"), "Open Slide Option of " +i +"record");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to get count of Items
	 */
	public static void get_latest_processed_Date() {
		CommonMethods.waitForPageLoading();
		String processedDate = (SeleniumActions.getText(byProcessedDate)).trim();
		int resultCount = DriverManager.getDriver().findElements(By.xpath("//span[@data-component-id='ProcessedDateTime' and contains(text(),'"+processedDate+"')]")).size();
		Variables.set(CurrentThreadInstance.getCurrentScenarioId()+"resultCount", resultCount);
	}


	/**
	 * Function to compare PIX Broken by Attributes
	 */
	public static void comparePIXBrokenByAttributes(int count) {
		ArrayList<String> pixAttributes = new ArrayList<>();
		for(int i=1;i<= count;i++){
			pixAttributes.add(
					(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "inventoryTypeId" +i +"").toString()) +
							(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "productStatusId" +i +"").toString()) +
							(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "countryOfOrigin" +i +"").toString()));
		}

		boolean isPIXAttributesBroken = compareList(pixAttributes);
		String isPIXAttributeBroken = String.valueOf(isPIXAttributesBroken);


		if((isPIXAttributeBroken == "false")){
			FrameworkLogger.log(LogType.PASS,"PIX Data is broken by Attributes");
		} else {
			FrameworkLogger.log(LogType.FAIL,"PIX Data is not broken by attributes. PIX Data is duplicated");
		}

	}

	/**
	 * Function to store Batch Number in List
	 */
	public static List<String> storeBatchNumberInList(int count) {

		List<String> batchNumber = new ArrayList<>();
		for(int i=1;i<= count;i++){
			if (!(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "itemBatchNumberId" +i +"").equals(""))){
				batchNumber.add(Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "itemBatchNumberId" +i +"").toString());
			}
		}
		return batchNumber;

	}

	/**
	 * Function to verify batch number value is null
	 * @param count- batch number count
	 */
	public static void verifyBatchNumberIsNull(int count) {
		List<String> batchNumber = storeBatchNumberInList(count);
		if(batchNumber.isEmpty()) {
			FrameworkLogger.log(LogType.PASS,"Item Batch Number is Empty");
		}
		else{
			FrameworkLogger.log(LogType.FAIL,"Item Batch Number is not Empty");
		}
	}

	/**
	 * Function to verify batch number value is Unique
	 * @param count - batch number count
	 */
	public static void verifyBatchNumberIsUnique(int count) {
		List<String> batchNumber = storeBatchNumberInList(count);
		boolean isBatchNumber = compareList(batchNumber);
		String isItemBatchNumber = String.valueOf(isBatchNumber);

		if((isItemBatchNumber == "false")){
			FrameworkLogger.log(LogType.PASS,"PIX Data is broken by Batch Number");
		} else {
			FrameworkLogger.log(LogType.FAIL,"PIX Data is not broken by Batch Number. PIX Data is duplicated");
		}
	}

	/**
	 * Function to compare List value
	 * @param str -  List which need to compared with
	 */
	public static boolean compareList(List<String> str) {
		boolean isSame = false;
		int size = str.size();
		int count =1;

		for(int i=0;i< size-1;i++){
			for(int j = i+1; j < size;j++){
				if(str.get(i).equals(str.get(j))) {
					count = count +1;
				}
			}
		}
		if (count >1){
			isSame = true;
		}
		return isSame;
	}

	/**
	 * Function to click First Pix Visibility
	 */
	public static void clickFirstPixVisibilityCard() {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(bySUBTRACT, "Inventory Adjustment");
		CommonMethods.waitForPageLoading();
	}


	/**
	 * Function to verify PixDataStatus
	 * @param - status, text to verify
	 */
	public static void verifyPixDataStatus(String status) {
		List<WebElement> elements = DriverManager.getDriver().findElements(byPixStatus);
		List<String> actualStatus = new ArrayList<>();
		for (WebElement e : elements) {
			actualStatus.add(e.getText());
		}
		if (actualStatus.contains(status)) {
			FrameworkLogger.log(LogType.PASS, "PixDataStatus Verification passed : " + status);
		} else {
			FrameworkLogger.log(LogType.FAIL,
					"PixDataStatus Verification failed. Expected :" + status + " , Actual :" + actualStatus);
		}
	}
}