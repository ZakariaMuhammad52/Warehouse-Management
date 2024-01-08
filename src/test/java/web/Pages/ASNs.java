package web.Pages;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.dhl.constants.FrameworkConstants;
import com.jayway.jsonpath.JsonPath;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

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

import stepdefinitions.CommonMethods;
import stepdefinitions.ExcelUtil1;

@SuppressWarnings("unused")
public class ASNs extends TestData_Json {

	private static final By byASNsPage = By.xpath("//span[contains(text(),'ASNs')]");
	private static final By byBatchMasterPage = By.xpath("//span[contains(text(),'Batch Master')]");
	private static final By byRefreshBtn = By.xpath("//ion-button[contains(@data-component-id,'refresh')]");
	private static final By byCreateASNFromPO = By.xpath("//*[contains(text(),'Create ASN from PO')]");
	private static final By byCreateASNFromPOScreen = By.xpath("//ion-title[text()='CREATE ASN FROM PO']");
	private static final By byASNField = By.xpath("//ion-input[contains(@data-component-id,'AsnId')]/input");
	private static final By byExpandASNfield = By
			.xpath("//span[@title='ASN']/following-sibling::ion-button[contains(@data-component-id,'expand-button')]");
	private static final By byASNidPopUp = By
			.xpath("//div[@role='dialog']//ion-input[contains(@data-component-id,'AsnId')]/input");
	private static final By byEstimatedDeliveryDate = By
			.xpath("//ion-input[contains(@data-component-id,'EstimatedDeliveryDate')]/input");
	private static final By bySubmitBtn = By.xpath("//ion-button[contains(@data-component-id,'submit-btn')]");
	private static final By byASNCard = By.xpath("//*[contains(text(),'ASN :')]");
	private static final By byRelatedLinks = By.xpath("//*[contains(text(),'Related Links')]");
	private static final By byASNDetails = By.xpath("//*[text()='ASN Details']");
	private static final By byASNBreadCrumb = By.xpath("//a[text()='ASNs']");
	private static final By byMoreActionsBtn = By.xpath("//ion-button[@data-component-id='more-actions']");
	private static final By byCreateiLPNBtn = By.xpath("//ion-button[contains(@data-component-id,'CreateiLPNs')]"); //not used
	private static final By byCreateiLPNsCheckbox = By
			.xpath("//div[@class='create-ilpn-data-table']//datatable-header-cell//input"); //not used
	private static final By byCreateiLPNsBtn = By.xpath("//ion-button[@data-component-id='create-ilpn-btn']"); //not used
	private static final By byQuantityToLPN = By.xpath("//input[@name='QuantityToCartonize']");
	private static final By byASNId = By.xpath("//span[contains(@data-component-id,'tcasnid')]/parent::*");
	private static final By byDateSelectionPopUp = By.xpath("//ion-modal//single-date-selection");
	private static final By byVerifyASNBtn = By.xpath("//button[contains(@data-component-id,'VerifyASN')]");
	private static final By byVerifyASNBtnPopup = By.xpath("//ion-button[contains(@data-component-id,'verify-btn')]");
	private static final By byASNStatusDescription = By.xpath("//div[contains(@data-component-id,'AsnStatusDescription')]");
	private static final By byExportDataLoaderBtn = By.xpath("//button[contains(@data-component-id,'ExportDataLoader')]");
	private static final By byImportDataLoaderBtn = By.xpath("//button[contains(@data-component-id,'ImportDataLoader')]");
	private static final By byChooseFileBtn = By.xpath("//label[contains(text(),'Choose File')]");
	private static final By byChooseFile = By.id("documentInputId");
	private static final By bySaveBtn = By.xpath("//ion-button[contains(text(),'SAVE')]");
	private static final By byLPNInventory = By.xpath("//a[text()='LPN (Inventory)']");
	private static final By byFilterClearAllBtn = By.xpath("//button[contains(@data-component-id,'clear-all-btn')]");
	private static final By byLPNinventory = By.xpath("//a[text()='LPN (Inventory)']");
	private static final By byItmField = By.xpath("//ion-input[contains(@data-component-id,'ItemId')]/input");
	private static final By byExpandITMIdfield = By
			.xpath("//span[@title='Item ID']/following-sibling::ion-button[contains(@data-component-id,'expand-button')]");
	private static final By byFirstASNId = By.xpath("(//span[contains(@data-component-id,'AsnId')])[1]");
	private static final By bySelectAllRowBtn = By
			.xpath("//button[contains(@data-component-id,'selectAllRows') or contains(@data-component-id,'deselectAllRows')]");
	private static final By byRelatedLinkLPNInventory = By
			.xpath("//ion-list[@class='md list-md hydrated']//*[contains(text(),'LPN (Inventory)')]");
	private static final By byRelatedLinkASNDetails = By
			.xpath("//ion-list[@class='md list-md hydrated']//*[contains(text(),'ASN Details')]");
	private static final By bySlideASNsCard1Btn = By
			.xpath("(//div[contains(@class,'list-card-action-left-arrow')])[1]");
	private static final By bySlideCardDetailsBtn = By.xpath("//button[contains(@data-component-id,'Details')]");
	private static final By byExpandInventoryAttributesSection = By
			.xpath("//span[contains(text(),'Inventory Attributes')]");
	private static final By byInventoryAttributesProductStatus = By
			.xpath("(//div[contains(@data-component-id,'ProductStatusId')])[2]");
	private static final By byInventoryAttributesInventoryType = By
			.xpath("(//div[contains(@data-component-id,'InventoryTypeId')])[2]");
	private static final By byInventoryAttributesBatchNumber = By.xpath("//div[contains(@data-component-id,'BatchNumber')]");
	private static final By byASNsCreateIlpnsBtn = By
			.xpath("//div[@class='action-list']//button[contains(@data-component-id,'CreateiLPNs')]");
	private static final By byAsnDetailCreateIlpnsHeader = By.xpath("//span[contains(@data-component-id,'asndetails')]");
	private static final By byCreateiLPNsDataCheckbox = By
			.xpath("//div[@class='create-ilpn-data-table']//datatable-body-cell//input");
	private static final By byStdLPNQtyColumn = By
			.xpath("(//div[@class='create-ilpn-data-table']//datatable-body-cell//input)[3]");
	private static final By byExpirationDateColumn = By.xpath("//span[contains(@data-component-id,'opencalender')]");
	private static final By byLPNs = By.xpath("//a[text()='LPN']");
	private static final By byASNNumber = By.xpath("//ion-col[contains(@data-component-id,'acceptlpn_barcodetextfield_asn')]");
	private static final By byEnterLNP = By.xpath("//input[contains(@data-component-id,'acceptlpn_barcodetextfield_lpn')]");
	private static final By byBatchNumberTextField = By.xpath("//input[contains(@data-component-id,'batchnumber')]");
	private static final By byVerifyASN = By.xpath("//button[contains(@data-component-id,'action_verifyasn_button')]");
	private static final By byYesVerifyASN = By
			.xpath("//ion-button[contains(@data-component-id,'variancesummary_booleanfield_yes')]");
	private static final By byInventoryDetailsSection = By.xpath("//div[contains(@data-component-id,'Inventorydetails')]");
	private static final By byILPNCurrentBatchNumber = By.xpath("//div[@data-component-id='JH271231']"); // Invalid
	// Xpath
	private static final By byASNsDetailsCreateIlpnsBtn = By
			.xpath("//ion-button[contains(@data-component-id,'create-ilpn-btn')]");
	private static final By byASNsDetailsCreateIlpnsAcceptBtn = By.xpath(
			"//ion-button[@class='accept-btn right ng-star-inserted md button button-solid ion-activatable ion-focusable hydrated']");
	private static final By byWarningDescriptionLabel = By.xpath("//th[@class='descWidth']");
	private static final By byIlpnspagination = By.xpath("//a[text()='LPNs']");
	private static final By byAsnIdOnAsnDetails = By.xpath("//modal-content//*[contains(@data-component-id,'AsnId')]");
	private static final By byQuantityOnAsnDetails = By.xpath("//modal-content//*[contains(@data-component-id,'ShippedQuantityInBridgedUomWithoutUomId')]");
	private static final By byItemDetails = By.xpath("//div//span[contains(@data-component-id,'ItemId')]");
	private static final By byAsnIds = By.xpath("//span[contains(@data-component-id,'AsnId')]");
	private static final By bySelectTextField = By.xpath("//input[@placeholder='Select']");
	private static final By byOriginalOrdersIds = By.xpath("//span[contains(@data-component-id,'OriginalOrderId')]");


	/**
	 * Function to Verify ASN Page is displayed
	 */
	public static void verifyASNsPageDisplayed() {
		SeleniumActions.verifyElementVisible(byASNsPage, 20, "ASNs page");
	}

	/**
	 * Function to Batch Master Page is displayed
	 */
	public static void verifyBatchMasterPageDisplayed() {
		SeleniumActions.verifyElementVisible(byBatchMasterPage, 20, "ASNs page");
	}

	/**
	 * Function to select current Date in ASN popup window
	 */
	public static void enterDateInASNPopUp() {
		SeleniumActions.click(byEstimatedDeliveryDate, "Estimated delivery date field");
		SearchContext shadowElement = SeleniumActions.expandShadowRoot(SeleniumActions.getElement(byDateSelectionPopUp));
		WebElement eleFooter = shadowElement.findElement(By.cssSelector("modal-container > div > modal-footer"));
		List<WebElement> listOfBtns = eleFooter.findElements(By.cssSelector("button"));
		SeleniumActions.clickElementInListUsingText(listOfBtns, "APPLY");
		SeleniumActions.click(bySubmitBtn, "Submit button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to search ASN in ASN window
	 *
	 * @param strText - ASN which need to searched
	 */
	public static void searchASN(String strText) {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byFilterClearAllBtn, "Clear All Filter button");
		CommonMethods.waitForPageLoading();
		if (DriverManager.getDriver().findElements(byASNField).size() < 1) {
			SeleniumActions.click(byExpandASNfield, "Expand icon");
		}
		SeleniumActions.getElement(byASNField).clear();
		SeleniumActions.sendTextToElement(byASNField, strText, "ASN search field");
		CommonMethods.waitForPageLoading();
		KeyboardActions.pressEnterKey(byASNField);
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(By.xpath("//span[contains(text(),'" + strText + "')]"), "ASN Card");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to search Item field in BatchMaster window
	 *
	 * @param strText - ASN which need to searched
	 */
	public static void searchitem(String strText) {
		CommonMethods.waitForPageLoading();
		if (DriverManager.getDriver().findElements(byItmField).size() < 1) {
			SeleniumActions.click(byExpandITMIdfield, "Expand icon");
		}
		SeleniumActions.getElement(byItmField).clear();
		SeleniumActions.sendTextToElement(byItmField, strText, "ASN search field");
		CommonMethods.waitForPageLoading();
		KeyboardActions.pressEnterKey(byItmField);
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(By.xpath("//span[contains(text(),'" + strText + "')]"), "ASN Card");
	}

	/**
	 * Function to verify ASN Details displayed/visible in the screen
	 * @param strText - ASN which need to searched
	 */
	public static void verifyASNDetailsDisplayed(String strText) {
		CommonMethods.waitForPageLoading();
		By by = By.xpath("//span[contains(text(),'" + strText + "')]");
		SeleniumActions.verifyElementVisible(by, 5, "ASN Details");
	}

	/**
	 * Function to update LPN quantity
	 *
	 * @param iQuantity - LPN quantity to be updated
	 */
	public static void updateQuantityOfLpns(int iQuantity) {
		String strQuantity = String.valueOf(iQuantity);
		List<WebElement> listOfElements = DriverManager.getDriver().findElements(byQuantityToLPN);
		for (WebElement element : listOfElements) {
			element.clear();
			element.sendKeys(strQuantity);
			System.out.println("Quantity updated as: " + strQuantity);
		}
	}

	/**
	 * Function to verify receiving ASN is performed by selecting 'Verify ASN'
	 * button
	 */
	public static void verifyReceivingASN() {

		SeleniumActions.click(byMoreActionsBtn, "More actions");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byVerifyASNBtn, "Verify ASN action");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byVerifyASNBtnPopup, "Verify button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to verify ASN status displayed
	 *
	 * @param strExpected - ASN status that need to be verified
	 */
	public static void verifyASNStatus(String strExpected) {
		String strStatus = getASNStatus();
		if (!strStatus.isEmpty()) {
			SeleniumActions.verifyTextEquals(strStatus, strExpected);
		}
	}

	/**
	 * Function to capture ASN value from ASN screen
	 */
	public static void captureASNNumber() {
		String strASN = SeleniumActions.getText(byASNId);
		if (strASN != null && !strASN.trim().isEmpty()) {
			Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ASN", strASN.replace("ASN ID: ", ""));
		} else {
			FrameworkLogger.log(LogType.FAIL, "ASN is null or empty");
		}
	}

	/**
	 * Function to get current ASN status from ASN window
	 */
	public static String getASNStatus() {
		String strStatus = SeleniumActions.getText(byASNStatusDescription);
		if (strStatus != null && !strStatus.trim().isEmpty()) {
			return strStatus.trim();
		} else {
			FrameworkLogger.log(LogType.FAIL, "ASN Status description is null or empty");
		}
		return "";
	}

	/**
	 * Function to import file
	 * @param strASNLevel - Give ASn level from testdata
	 */
	public static void filterASNByLevel(String strASNLevel) {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(By.xpath("//ion-checkbox[contains(@data-component-id,'" + strASNLevel + "')]"), "ASN Level");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to select status filter under ASN
	 *
	 * @param strASNStatus - which need to searched
	 */
	public static void filterASNByStatus(String strASNStatus) {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(By.xpath("//ion-checkbox[contains(@data-component-id,'" + strASNStatus + "')]"), "ASN status");
		CommonMethods.waitForPageLoading();
		String strASNNumber = SeleniumActions.getText(byFirstASNId);
		searchASN(strASNNumber);
	}

	/**
	 * Function to select ASN file to import
	 */
	public static void selectFiletoImport() {
		SeleniumActions.click(byChooseFileBtn, "click Choose File button");
		GeneralUtils.wait(5 * 1000);
		String demo = System.getProperty("user.home") + "\\Downloads\\";
		ExcelUtil1.sendTextWithRobot(demo + "Asn.xlsx");
		GeneralUtils.wait(5 * 1000);
		KeyboardActions.pressKeyboardKeyWithRobot(KeyboardKeys.ENTER);
		GeneralUtils.wait(5 * 1000);
		SeleniumActions.click(bySaveBtn, "click Save button");
	}

	/**
	 * Function to search ASN in ASN window
	 *
	 * @param strText - which need to searched
	 */
	public static void filterAsnOrder(String strText) {
		String strOrderNumber;
		CommonMethods.waitForPageLoading();
		if (strText != null && !strText.trim().isEmpty()) {
			strOrderNumber = strText;
		} else {
			strOrderNumber = SeleniumActions.getText(byFirstASNId);
		}
		CommonMethods.waitForPageLoading();
		if (DriverManager.getDriver().findElements(byASNField).size() < 1) {
			SeleniumActions.click(byExpandASNfield, "Expand icon");
		}
		SeleniumActions.getElement(byASNField).clear();
		SeleniumActions.sendTextToElement(byASNField, strOrderNumber, "ASN search field");
		CommonMethods.waitForPageLoading();
		KeyboardActions.pressEnterKey(byASNField);
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(By.xpath("//span[contains(text(),'" + strOrderNumber + "')]"), "ASN Order Card");
	}

	/**
	 * Function to verify receiving ASN is performed by selecting 'Verify ASN'
	 * button
	 */
	public static void verifyReceivingASNwobuttonpopup() {
		SeleniumActions.click(byMoreActionsBtn, "More actions");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byVerifyASNBtn, "Verify ASN action");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to Store the generated ASN no
	 * button
	 */
	public static void storeGeneratedAsnNumberToString() {
		WebElement element = DriverManager.getDriver().findElement(byASNNumber);
		String text = element.getText().trim();
		FrameworkLogger.log(LogType.INFO, "ASN number in variable:- " + text);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ASNNumber", text);
	}

	/**
	 * Function to Search LPN
	 *
	 * @param strText - which need to searched
	 */
	public static void enterLNP(String strText) {
		CommonMethods.waitForPageLoading();
		SeleniumActions.sendTextToElement(byEnterLNP, strText, "Enter LPN field");
		CommonMethods.waitForPageLoading();
		KeyboardActions.pressEnterKey(byEnterLNP);
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to Search Batch number
	 *
	 * @param strText - which need to searched
	 */
	public static void enterBatchNumberManually(String strText) {
		CommonMethods.waitForPageLoading();
		SeleniumActions.sendTextToElement(byBatchNumberTextField, strText, "Enter Batch Number Manually");
		CommonMethods.waitForPageLoading();
		KeyboardActions.pressEnterKey(byBatchNumberTextField);
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to select LPN Inventory from related link.
	 */
	public static void selectLPNInventoryRelatedLink() {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byRelatedLinks, "Select Related Links");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byRelatedLinkLPNInventory, "Select LPN (Inventory) link");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to select ASN card in ASN window
	 *
	 * @param strText - ASN which need to searched
	 */
	public static void selectASNCard(String strText) {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(bySelectAllRowBtn, "Select ASN Card");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(By.xpath("//span[contains(text(),'" + strText + "')]"), "ASN Card");
	}

	/**
	 * Function to select LPN Inventory from related link.
	 */
	public static void selectASNDetailRelatedLink() {
		SeleniumActions.click(byRelatedLinks, "Select Related Links");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byRelatedLinkASNDetails, "Select ASN Details link");
	}

	/**
	 * Function to verify LPN Inventory card is opening the details.
	 */
	public static void verifyInventoryAttributesCard1() {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(bySlideASNsCard1Btn, "Slide button card 1 is clicked");
		SeleniumActions.click(bySlideCardDetailsBtn, "Details button is clicked");
		SeleniumActions.click(byExpandInventoryAttributesSection, "Expand Iniventory Attributes");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to Verify ASN Line Inventory Attribute is displayed
	 */
	public static void verifyAsnLineInventoryAttributeDisplayed() {
		SeleniumActions.verifyElementVisible(byInventoryAttributesProductStatus, 20,
				"ASN Line Inventory Attribute of Product Status");
		SeleniumActions.verifyElementVisible(byInventoryAttributesInventoryType, 20,
				"ASN Line Inventory Attribute of Inventory Type");
		SeleniumActions.verifyElementVisible(byInventoryAttributesBatchNumber, 20,
				"ASN Line Inventory Attribute of Batch Number");
	}

	/**
	 * Function to select ASNs breadcrumb.
	 */
	public static void selectASNsBreadcrumb() {
		SeleniumActions.click(byASNBreadCrumb, "Back to ASNs main page");
	}

	/**
	 * Function to verify receiving ASN is performed by selecting 'Create ILPNs'
	 * button
	 */
	public static void selectCreateILPNs() {
		SeleniumActions.click(bySlideASNsCard1Btn, "Slide button card 1 is clicked");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byMoreActionsBtn, "More actions");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byASNsCreateIlpnsBtn, "Create ILPNs action");
		CommonMethods.waitForPageLoading();
		SeleniumActions.verifyElementVisible(byAsnDetailCreateIlpnsHeader, 20, "ASN Details at Create ILPNs page");
	}

	/**
	 * Function to Verify Create ILPNs is displayed
	 * @param strText- Give Standerd LPN quantity for search
	 */
	public static void updateASNDetailsTable(String strText) {
		SeleniumActions.checkSingleCheckbox(byCreateiLPNsDataCheckbox, "Select a checkbox");
		SeleniumActions.getElement(byStdLPNQtyColumn).clear();
		SeleniumActions.sendTextToElement(byStdLPNQtyColumn, strText, "Standard LPN Quantity");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byExpirationDateColumn, "Open Calendar");
	}

	/**
	 * Function to Verify ASN is displayed
	 */
	public static void verifyASN() {
		CommonMethods.waitForPageLoading();
		SeleniumActions.getElement(byVerifyASN).click();
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click verify ASN button is displayed
	 */
	public static void yesbuttonVerifyASN() {
		SeleniumActions.getElement(byYesVerifyASN).click();
	}

	/**
	 * Function to Search ASN number
	 *
	 * @param text - which need to searched
	 */
	public static void enterASNnumber(String text) {
		if (DriverManager.getDriver().findElements(byASNField).size() < 1) {
			SeleniumActions.click(byExpandASNfield, "Expand icon");
		}
		SeleniumActions.sendTextToElement(byASNField, text, "ASN Number field");
		CommonMethods.waitForPageLoading();
		KeyboardActions.pressEnterKey(byASNField);
	}

	/**
	 * Function to select LPNs in LPN and verify LPNs displayed
	 * @param strLPN - Give LPN
	 * @param i -  give index no
	 */
	public static void selectLPNAndVerifyLPNPresent(String strLPN, int i) {

		By by = By.xpath("(//div[@class='dm-flex-col-layout dm-fill-space ng-star-inserted'])");
		List<WebElement> header = DriverManager.getDriver().findElements(by);
		WebElement ele = DriverManager.getDriver().findElement(By.xpath(
				"(//div[@class='dm-flex-col-layout dm-fill-space ng-star-inserted']//div/span[contains(@data-component-id,'LpnId')])["
						+ i + "]"));
		if (ele.getText().trim().equalsIgnoreCase(strLPN)) {
			SeleniumActions.click(ele, "select lpn");
			SeleniumActions.click(byRelatedLinks, "Click on Related Links");
			SeleniumActions.click(byRelatedLinkLPNInventory, "click LPN()inventory");
			FrameworkLogger.log(LogType.PASS, "Clicked on LPN1");
		} else {
			FrameworkLogger.log(LogType.FAIL, "Not Clicked on LPN1");
		}
	}

	/**
	 * Function to Expand Inventory Details
	 */
	public static void inventoryDetailsHeading() {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(bySlideCardDetailsBtn, "Details button is clicked");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byInventoryDetailsSection, "Expand Inventory Details");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to verify ASN batch number
	 * @param locationType- Give locationType
	 */
	public static void verifyAsnBatchNumber(String locationType) {
		String actualBatchNumber = SeleniumActions.getAtrribute(byILPNCurrentBatchNumber, "title", 20);
		actualBatchNumber = actualBatchNumber.trim();
		if (locationType.equals(actualBatchNumber)) {
			FrameworkLogger.log(LogType.PASS, "Current Batch Number Verification passed : " + actualBatchNumber);
		} else {
			FrameworkLogger.log(LogType.FAIL, "Current Batch Number Verification failed. Expected :" + locationType
					+ " , Actual :" + actualBatchNumber);
		}
	}

	/**
	 * Function to verify CREATE ILPNS RESULTS message is displayed
	 *
	 */
	public static void verifyCreateILPNsResult() {
		String strLPNInformation = SeleniumActions.getText(byWarningDescriptionLabel);
		if (strLPNInformation != null && !strLPNInformation.trim().isEmpty()) {
			FrameworkLogger.log(LogType.PASS, strLPNInformation
					+ "Quantity to create LPNs is not divisible by Standard LPN Quantity is Displayed");
			SeleniumActions.click(byASNsDetailsCreateIlpnsAcceptBtn, "Accept button");
		} else {
			FrameworkLogger.log(LogType.FAIL,
					"Quantity to create LPNs is not divisible by Standard LPN Quantity message is not displayed");
		}
	}

	/**
	 * Function to click ILPN pagination
	 *
	 */
	public static void clickLPNSpagination() {
		SeleniumActions.verifyElementVisible(byIlpnspagination, 2, "LPNs pagination");
		SeleniumActions.click(byIlpnspagination, "Clicked on LPNS pagination");
	}

	/**
	 * Function to select current Date in ASN popup window
	 */
	public static void enterExpirationDateInCreateIlpnTablePopUp() {
		SeleniumActions.click(byExpirationDateColumn, "Advanced Date Time selection popup");
		SearchContext shadowElement = SeleniumActions
				.expandShadowRoot(SeleniumActions.getElement(byDateSelectionPopUp));
		WebElement eleFooter2 = shadowElement
				.findElement(By.cssSelector("modal-container > div > div > modal-content"));
		List<WebElement> listOfBtns2 = eleFooter2.findElements(By.cssSelector("button"));
		SeleniumActions.clickElementInListUsingText(listOfBtns2, "30");
		WebElement eleFooter3 = shadowElement
				.findElement(By.cssSelector("modal-container > div > modal-footer > div > div.right"));
		List<WebElement> listOfBtns3 = eleFooter3.findElements(By.cssSelector("button"));
		SeleniumActions.clickElementInListUsingText(listOfBtns3, "APPLY");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to select ASNs breadcrumb.
	 */
	public static void selectConfirmCreateIlpns() {
		SeleniumActions.click(byASNsDetailsCreateIlpnsBtn, "confirm create Ilpns");
	}

	/**
	 * Function to Verify ASN Data with Json
	 * @param filename- Give file name
	 */
	public static void verifyAsnDataWithJson(String filename) throws IOException, IOException {
		String jsonPath = new String(Files.readAllBytes(Paths.get(FrameworkConstants.getApiRequestsDirectory()+filename)));
		String expectedAsnId= (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId()+"ASN_ID");
		FrameworkLogger.log(LogType.INFO, "Asn Id from Json : " + expectedAsnId);
		String expectedQuantity = JsonPath.read(jsonPath, "$.data[0].AsnLine[0].ShippedQuantity");
		FrameworkLogger.log(LogType.INFO, "Shipped quantity from Json : " + expectedQuantity);
		String actualAsnId = SeleniumActions.getText(byAsnIdOnAsnDetails);
		SeleniumActions.verifyTextContains(actualAsnId, expectedAsnId,false);
		String actualQuantity = SeleniumActions.getText(byQuantityOnAsnDetails);
		SeleniumActions.verifyTextEquals(actualQuantity, expectedQuantity,false);
		CommonPopupPage.clickCloseIcon();
	}

	/**
	 * Function to Verify ASN Id And Shipped Quantity For Multiple ASN Id
	 * @param filename- give file name
	 * @param asn-   give generated ASN id
	 */
	public static void verifyASNIDAndShippedQuantityForMultipleAsns(String filename,String asn) throws IOException {

		List<WebElement> elements=CommonPage.getRowElements();
		for(WebElement e:elements){
			CommonMethods.scrollByParticularElement(e,"Order Row element");
			e.click();
			CommonMethods.waitForPageLoading();
			FooterPanelPage.clickDetailsButton();
			String jsonPath = new String(Files.readAllBytes(Paths.get(FrameworkConstants.getApiRequestsDirectory()+filename)));
			String expectedAsnId= (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId()+"ASN_ID");
			FrameworkLogger.log(LogType.INFO, "Asn Id from Json : " + expectedAsnId);
			String expectedQuantity = JsonPath.read(jsonPath, "$.data[0].AsnLine[0].ShippedQuantity");
			FrameworkLogger.log(LogType.INFO, "Shipped quantity from Json : " + expectedQuantity);
			String actualAsnId = SeleniumActions.getText(byAsnIdOnAsnDetails);
			SeleniumActions.verifyTextContains(actualAsnId, expectedAsnId,false);
			String actualQuantity = SeleniumActions.getText(byQuantityOnAsnDetails);
			SeleniumActions.verifyTextEquals(actualQuantity, expectedQuantity,false);
			CommonPopupPage.clickCloseIcon();
			e.click();
			CommonMethods.waitForPageLoading();
		}
	}

	/**
	 * Function to Verify ASN Inventory Attributes
	 */
	public static void verifyAsnLineInventoryAttribute() {
		SeleniumActions.verifyElementVisible(byInventoryAttributesProductStatus, 20,
				"ASN Line Inventory Attribute of Product Status");
		SeleniumActions.verifyElementVisible(byInventoryAttributesInventoryType, 20,
				"ASN Line Inventory Attribute of Inventory Type");
		SeleniumActions.verifyElementVisible(byItemDetails, 20,
				"ASN Line Item");
	}

	/**
	 * Function to Verify Multiple ASN
	 * @param asnsIdValue - List of ASN id
	 */
	public static void verifyMultipleASNDisplayed(List<String> asnsIdValue) {
		Collections.reverse(asnsIdValue);
		CommonMethods.waitForPageLoading();
		List<WebElement> elements = DriverManager.getDriver().findElements(byAsnIds);
		List<String> actualAsns = new ArrayList<>();
		for (WebElement e : elements) {
			CommonMethods.waitForPageLoading();
			actualAsns.add(e.getText());
			CommonMethods.waitForPageLoading();
		}
		if (asnsIdValue.equals(actualAsns)) {
			FrameworkLogger.log(LogType.PASS, "ASNs Verification passed : " + asnsIdValue);
		} else {
			FrameworkLogger.log(LogType.FAIL,
					"ASNs Verification failed. Expected :" + asnsIdValue + " , Actual :" + actualAsns);
		}

	}

	/**
	 * Function to search multiple ASN in ASN page
	 * @param strText- Give strText to be searched
	 */
	public static void searchMultipleASN(String strText) {
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byFilterClearAllBtn, "Clear All Filter button");
		CommonMethods.waitForPageLoading();
		if (DriverManager.getDriver().findElements(byASNField).size() < 1) {
			SeleniumActions.click(byExpandASNfield, "Expand icon");
		}
		SeleniumActions.getElement(byASNField).clear();
		SeleniumActions.sendTextToElement(byASNField, strText, "ASN search field");
		CommonMethods.waitForPageLoading();
		KeyboardActions.pressEnterKey(byASNField);
		CommonMethods.waitForPageLoading();
	}
}
