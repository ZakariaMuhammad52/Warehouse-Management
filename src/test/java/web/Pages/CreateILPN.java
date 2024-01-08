package web.Pages;

import org.openqa.selenium.By;

import com.dhl.reports.FrameworkLogger;
import com.dhl.reports.LogType;
import com.dhl.testdata.TestData_Json;
import com.dhl.utils.CurrentThreadInstance;
import com.dhl.utils.Variables;
import com.dhl.web.utils.SeleniumActions;

import stepdefinitions.CommonMethods;
import stepdefinitions.ExcelUtil1;

@SuppressWarnings("unused")
public class CreateILPN extends TestData_Json {

	private static final By byCreateILPNPage = By.xpath("//ion-title[@data-component-id='seedcreateilpnid']");
	private static final By byCreateILPNItem = By.xpath("//ion-item[@data-component-id='createilpn']");
	private static final By byILPNTextField = By.xpath("//input[@placeholder='Scan iLPN']");
	private static final By byItemTextField = By.xpath("//input[@placeholder='Scan Item']");
	private static final By byInventoryTypeIdTextField = By
			.xpath("//input[contains(@data-component-id,'inventorytypeid')]");
	private static final By byProductStatusIdTextField = By
			.xpath("//input[contains(@data-component-id,'productstatusid')]");
	private static final By byReasonCodeTextField = By.xpath("//input[contains(@data-component-id,'reasoncode')]");
	private static final By byGoButton = By.xpath("//ion-button[contains(@data-component-id,'_go')]");
	private static final By byReferenceCodeTextField = By
			.xpath("//input[contains(@data-component-id,'referencecode')]");
	private static final By bySecondaryReferenceCodeTextField = By
			.xpath("//input[contains(@data-component-id,'secondaryreferencecode')]");
	private static final By byScanLocationTextFiled = By.xpath("//input[@placeholder='Scan Location']");
	private static final By byScanILPNTextFiled = By.xpath("//input[@placeholder='Scan iLPN']");
	private static final By byScanItemTextField = By.xpath("//input[@placeholder='Scan Item']");
	private static final By byQuantityTextField = By
			.xpath("//input[contains(@data-component-id,'naturalquantityfield_unit')]");

	/**
	 * Function to verify Page is displayed
	 */
	public static void verifyPageDisplayed() {
		SeleniumActions.verifyElementVisible(byCreateILPNPage, 20, "Create iLPN Id page");
	}

	/**
	 * Function to enter iLPN
	 * 
	 * @param text - value which need to be entered
	 */
	public static void enterILPN(String text) {
		SeleniumActions.sendTextToElement(byScanILPNTextFiled, text, "Scan ILPN field");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to enter scan item
	 * 
	 * @param text - value which need to be entered
	 */
	public static void enterScanItem(String text) {
		SeleniumActions.sendTextToElement(byScanItemTextField, text, "Scan Item field");
		CommonMethods.waitForPageLoading();
		if (text != null && !text.trim().isEmpty()) {
			SeleniumActions.getElement(byScanItemTextField).clear();
			SeleniumActions.sendTextToElement(byScanItemTextField, text.replace("-", "").trim(), "Scan Item field");
			CommonMethods.waitForPageLoading();
		} else {
			FrameworkLogger.log(LogType.FAIL, "Scan item is null or empty");
		}
	}

	/**
	 * Function to enter quantity
	 * 
	 * @param text - value which need to be entered
	 */
	public static void enterQuantity(String text) {
		SeleniumActions.sendTextToElement(byQuantityTextField, text, "Quantity field");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to enter InventoryType
	 * 
	 * @param text - value which need to be entered
	 */
	public static void enterInventoryType(String text) {
		SeleniumActions.sendTextToElement(byInventoryTypeIdTextField, text, "InventoryType field");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to enter Product status
	 * 
	 * @param text - value which need to be entered
	 */
	public static void enterProductStatus(String text) {
		SeleniumActions.sendTextToElement(byProductStatusIdTextField, text, "Product status field");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to select Reason code
	 * 
	 * @param text - value which need to selected
	 */
	public static void selectReasonCode(String text) {
		SeleniumActions.sendTextToElement(byReasonCodeTextField, text, "Reason code field");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to enter reference code
	 * 
	 * @param text - value which need to be entered
	 */
	public static void enterReferenceCodeTextField(String text) {
		SeleniumActions.sendTextToElement(byReferenceCodeTextField, text, "ReferenceCode TextField");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to enter secondary reference code
	 * 
	 * @param text - value which need to be entered
	 */
	public static void enterSecondaryReferenceCodeTextField(String text) {
		SeleniumActions.sendTextToElement(bySecondaryReferenceCodeTextField, text, "Secondary ReferenceCode TextField");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click Go button
	 */
	public static void clickGoButton() {
		SeleniumActions.click(byGoButton, "Go button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click Create ILPN Item button
	 */
	public static void clickCreateILPNItem() {
		SeleniumActions.click(byCreateILPNItem, "Create ILPN Item button");
		CommonMethods.waitForPageLoading();
	}

	public static void createILPN() {
		clickCreateILPNItem();
		String ilpn = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(iLPN)"));
		FrameworkLogger.log(LogType.INFO, "ILPN Id stored in variable:- " + ilpn);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN1", ilpn);
		String item = getDataFromFeature("getdata(Item)");
		String inventoryType = getDataFromFeature("getdata(InventoryTypeId)");
		String productStatus = getDataFromFeature("getdata(ProductStatusId)");
		String quantity = getDataFromFeature("getdata(Quantity)");
		String reasonCode = getDataFromFeature("getdata(ReasonCode)");
		String reference = getDataFromFeature("getdata(ReferenceCode)");
		String secondReference = getDataFromFeature("getdata(SecondaryReferenceCode)");
		enterILPN(ilpn);
		CommonMethods.waitForPageLoading();
		clickGoButton();
		CommonMethods.waitForPageLoading();
		enterScanItem(item);
		CommonMethods.waitForPageLoading();
		clickGoButton();
		CommonMethods.waitForPageLoading();
		enterInventoryType(inventoryType);
		CommonMethods.waitForPageLoading();
		clickGoButton();
		CommonMethods.waitForPageLoading();
		enterProductStatus(productStatus);
		CommonMethods.waitForPageLoading();
		clickGoButton();
		CommonMethods.waitForPageLoading();
		enterQuantity(quantity);
		CommonMethods.waitForPageLoading();
		clickGoButton();
		CommonMethods.waitForPageLoading();
		selectReasonCode(reasonCode);
		CommonMethods.waitForPageLoading();
		clickGoButton();
		CommonMethods.waitForPageLoading();
		enterReferenceCodeTextField(reference);
		CommonMethods.waitForPageLoading();
		clickGoButton();
		CommonMethods.waitForPageLoading();
		enterSecondaryReferenceCodeTextField(secondReference);
		CommonMethods.waitForPageLoading();
		clickGoButton();
		CommonMethods.waitForPageLoading();
	}

	public static void createILPNs(int count) {
		clickCreateILPNItem();
		String ilpn = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(iLPN)"));
		for (int i = 1; i <= count; i++) {
			FrameworkLogger.log(LogType.INFO, "ILPN Id stored in variable:- " + ilpn + i);
			Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN" + i, ilpn + i);
			String item = getDataFromFeature("getdata(Item" + i + ")").replaceAll("-", "");
			String inventoryType = getDataFromFeature("getdata(InventoryTypeId" + i + ")");
			String productStatus = getDataFromFeature("getdata(ProductStatusId" + i + ")");
			String quantity = getDataFromFeature("getdata(Quantity" + i + ")");
			String reasonCode = getDataFromFeature("getdata(ReasonCode" + i + ")");
			String reference = getDataFromFeature("getdata(ReferenceCode)");
			String secondReference = getDataFromFeature("getdata(SecondaryReferenceCode)");
			CommonWMMobilePage.enterScanILPN(ilpn + i);
			CommonWMMobilePage.clickGoButton();
			CommonWMMobilePage.enterScanItem(item);
			CommonWMMobilePage.clickGoButton();
			CommonWMMobilePage.enterInventoryType(inventoryType);
			CommonWMMobilePage.clickGoButton();
			CommonWMMobilePage.enterProductStatus(productStatus);
			CommonWMMobilePage.clickGoButton();
			CommonWMMobilePage.enterQuantity(quantity);
			CommonWMMobilePage.clickGoButton();
			CommonWMMobilePage.selectReasonCode(reasonCode);
			CommonWMMobilePage.clickGoButton();
			CommonWMMobilePage.enterReferenceCodeTextField(reference);
			CommonWMMobilePage.clickGoButton();
			CommonWMMobilePage.enterSecondaryReferenceCodeTextField(secondReference);
			CommonWMMobilePage.clickGoButton();
		}
	}


	public static void createILPNsWithBachNumber(int count) {
		clickCreateILPNItem();
		String ilpn = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(iLPN)"));
		for (int i = 1; i <= count; i++) {
			FrameworkLogger.log(LogType.INFO, "ILPN Id stored in variable:- " + ilpn + i);
			Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN" + i, ilpn + i);
//			String item = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId()+ "Item");
//			item = item.replaceAll("-", "");
			String item = getDataFromFeature("getdata(Item" + i + ")").replaceAll("-", "");
			String inventoryType = getDataFromFeature("getdata(InventoryTypeId" + i + ")");
			String productStatus = getDataFromFeature("getdata(ProductStatusId" + i + ")");
			String quantity = getDataFromFeature("getdata(Quantity" + i + ")");
			String reasonCode = getDataFromFeature("getdata(ReasonCode" + i + ")");
			String reference = getDataFromFeature("getdata(ReferenceCode)");
			String secondReference = getDataFromFeature("getdata(SecondaryReferenceCode)");
			String batchNumber = (ilpn + i).replaceAll("LP", "BN");
			String date = getDataFromFeature("getdata(ExpiryDate)");
			CommonWMMobilePage.enterScanILPN(ilpn + i);
			CommonWMMobilePage.clickGoButton();
			CommonWMMobilePage.enterScanItem(item);
			CommonWMMobilePage.clickGoButton();
			CommonWMMobilePage.enterBatchNumber(batchNumber);
			CommonWMMobilePage.clickGoButton();
			CommonWMMobilePage.enterExpiryDate(date);
			CommonWMMobilePage.clickGoButton();
			CommonWMMobilePage.enterInventoryType(inventoryType);
			CommonWMMobilePage.clickGoButton();
			CommonWMMobilePage.enterProductStatus(productStatus);
			CommonWMMobilePage.clickGoButton();
			CommonWMMobilePage.enterQuantity(quantity);
			CommonWMMobilePage.clickGoButton();
			CommonWMMobilePage.selectReasonCode(reasonCode);
			CommonWMMobilePage.clickGoButton();
			CommonWMMobilePage.enterReferenceCodeTextField(reference);
			CommonWMMobilePage.clickGoButton();
			CommonWMMobilePage.enterSecondaryReferenceCodeTextField(secondReference);
			CommonWMMobilePage.clickGoButton();
		}
	}

	/**
	 * Function to verify LPN Is RedirectedToLocation
	 *
	 * @param count - serial number count
	 */
	public static void createILPNsWithSerialNumber(int count) {
		clickCreateILPNItem();
		String ilpn = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(LPN)"));
		String item = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId()+"Item");;
		item= item.replaceAll("-", "");
		for (int i = 1; i <= count; i++) {
			FrameworkLogger.log(LogType.INFO, "ILPN Id stored in variable:- " + ilpn + i);
			Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN" + i, ilpn + i);
			String inventoryType = getDataFromFeature("getdata(InventoryTypeId" + i + ")");
			String productStatus = getDataFromFeature("getdata(ProductStatusId" + i + ")");
			String quantity = getDataFromFeature("getdata(Quantity" + i + ")");
			String reasonCode = getDataFromFeature("getdata(ReasonCode" + i + ")");
			String serialNumber = (ilpn + i).replaceAll("LP", "SN");
			CommonWMMobilePage.enterScanILPN(ilpn + i);
			CommonWMMobilePage.clickGoButton();
			CommonWMMobilePage.enterScanItem(item);
			CommonWMMobilePage.clickGoButton();
			CommonWMMobilePage.enterInventoryType(inventoryType);
			CommonWMMobilePage.clickGoButton();
			CommonWMMobilePage.enterProductStatus(productStatus);
			CommonWMMobilePage.clickGoButton();
			CommonWMMobilePage.enterQuantity(quantity);
			CommonWMMobilePage.clickGoButton();
			for (int j = 1; j <= Integer.parseInt(quantity); j++) {
				CommonWMMobilePage.enterSerialNumber(serialNumber + j);
				CommonWMMobilePage.clickGoButton();
				CommonPopupPage.clickConfirmButton();
			}
			CommonWMMobilePage.selectReasonCode(reasonCode);
			CommonWMMobilePage.clickGoButton();
			CommonWMMobilePage.clickGoButton();
			CommonWMMobilePage.clickGoButton();
		}
	}
	public static void createILPNWithBachNumber(int count) {
		clickCreateILPNItem();
		String ilpn = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(iLPN)"));
		for (int i = 1; i <= count; i++) {
			FrameworkLogger.log(LogType.INFO, "ILPN Id stored in variable:- " + ilpn + i);
			Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN" + i, ilpn + i);
			String item = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId()+ "Item");
			item = item.replaceAll("-", "");
			//String item = getDataFromFeature("getdata(Item" + i + ")").replaceAll("-", "");
			String inventoryType = getDataFromFeature("getdata(InventoryTypeId" + i + ")");
			String productStatus = getDataFromFeature("getdata(ProductStatusId" + i + ")");
			String quantity = getDataFromFeature("getdata(Quantity" + i + ")");
			String reasonCode = getDataFromFeature("getdata(ReasonCode" + i + ")");
			String reference = getDataFromFeature("getdata(ReferenceCode)");
			String secondReference = getDataFromFeature("getdata(SecondaryReferenceCode)");
			String batchNumber = (ilpn + i).replaceAll("LP", "BN");
			String date = getDataFromFeature("getdata(ExpiryDate)");
			CommonWMMobilePage.enterScanILPN(ilpn + i);
			CommonWMMobilePage.clickGoButton();
			CommonWMMobilePage.enterScanItem(item);
			CommonWMMobilePage.clickGoButton();
			CommonWMMobilePage.enterBatchNumber(batchNumber);
			CommonWMMobilePage.clickGoButton();
			CommonWMMobilePage.enterExpiryDate(date);
			CommonWMMobilePage.clickGoButton();
			CommonWMMobilePage.enterQuantity(quantity);
			CommonWMMobilePage.clickGoButton();
			CommonWMMobilePage.selectReasonCode(reasonCode);
			CommonWMMobilePage.clickGoButton();
			CommonWMMobilePage.enterReferenceCodeTextField(reference);
			CommonWMMobilePage.clickGoButton();
			CommonWMMobilePage.enterSecondaryReferenceCodeTextField(secondReference);
			CommonWMMobilePage.clickGoButton();
		}
	}
}
