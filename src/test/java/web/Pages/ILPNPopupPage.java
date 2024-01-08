package web.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.dhl.reports.FrameworkLogger;
import com.dhl.reports.LogType;
import com.dhl.testdata.TestData_Json;
import com.dhl.utils.CurrentThreadInstance;
import com.dhl.utils.Variables;
import com.dhl.web.utils.SeleniumActions;

import stepdefinitions.CommonMethods;

@SuppressWarnings("unused")
public class ILPNPopupPage extends TestData_Json {

	private static final By byInventoryDetailsLabel = By.xpath("//span[text()='INVENTORY DETAILS']");
	private static final By byCountryOfOriginCellValue = By
			.xpath("((//div[contains(@class,'datatable-row-center')])[2]//datatable-body-cell)[6]/div[1]/div"); // Need
	private static final By byInventoryTypeCellValue = By
			.xpath("((//div[contains(@class,'datatable-row-center')])[2]//datatable-body-cell)[5]/div[1]/div");// Need
	private static final By byProductStatusTypeCellValue = By
			.xpath("((//div[contains(@class,'datatable-row-center')])[2]//datatable-body-cell)[4]/div[1]/div");// Need
	private static final By byBatchNumberCellValue = By
			.xpath("((//div[contains(@class,'datatable-row-center')])[2]//datatable-body-cell)[3]/div[1]/div");// Need
	private static final By byInventorycontainerCellValue = By
			.xpath("((//div[contains(@class,'datatable-row-center')])[2]//datatable-body-cell)[25]/div[1]/div");// Need
	private static final By byInventoryparentLPNCellValue = By
			.xpath("((//div[contains(@class,'datatable-row-center')])[2]//datatable-body-cell)[16]/div[1]/div");// Ne<<<<<<<
	private static final By byItemLPNCellValue = By
			.xpath("((//div[contains(@class,'datatable-row-center')])[2]//datatable-body-cell)[30]/div[1]/div");// Need

	private static final By byLPNAttributesLabel = By.xpath("//span[text()='LPN ATTRIBUTES']");
	private static final By byEstimatedWeight = By
			.xpath("//span[contains(text(),'Estimated weight :')]/following-sibling::span[1]");
	private static final By byVolume = By.xpath("//span[contains(text(),'Volume :')]/following-sibling::span[1]");

	private static final By byOnhandQuantityCellValue = By
			.xpath("((//div[contains(@class,'datatable-row-center')])[2]//datatable-body-cell)[10]/div[1]/div");// Need
	private static final By byAllocatedQtyCellValue = By
			.xpath("((//div[contains(@class,'datatable-row-center')])[2]//datatable-body-cell)[12]/div[1]/div");// Need
	private static final By byInventoryTypeCellValueinpop = By
			.xpath("((//div[contains(@class,'datatable-row-center')])[2]//datatable-body-cell)[34]/div[1]/div");// Need
	private static final By byProductStatusTypeCellValueinpop = By
			.xpath("((//div[contains(@class,'datatable-row-center')])[2]//datatable-body-cell)[35]/div[1]/div");// Need
	private static final By byCountryOfOriginCellValueinpop = By
			.xpath("((//div[contains(@class,'datatable-row-center')])[2]//datatable-body-cell)[36]/div[1]/div");// Need
	private static final By byBatchNumberCellValueinpop = By
			.xpath("((//div[contains(@class,'datatable-row-center')])[2]//datatable-body-cell)[31]/div[1]/div");// Need
	private static final By byExpiryDateCellValueinpop = By
			.xpath("((//div[contains(@class,'datatable-row-center')])[2]//datatable-body-cell)[24]/div[1]/div");// Need
	private static final By byOnHandQuantityCellValue = By
			.xpath("((//div[contains(@class,'datatable-row-center')])[2]//datatable-body-cell)[16]/div[1]/div");

	private static final By byItemInInventoryDetails_LPNpopup = By
			.xpath("//span[text()='Item ']/parent::span/ancestor::div[@role='table']//a");
	private static final By byExpiryDateCellValue = By
			.xpath("((//div[contains(@class,'datatable-row-center')])[2]//datatable-body-cell)[7]/div[1]/div"); // Need

	/**
	 * Function to click Inventory Details Label
	 */
	public static void clickInventoryDetailsLabel() {
		CommonMethods.scrollByParticularElement(byInventoryDetailsLabel, "Inventory Details label");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byInventoryDetailsLabel, "Inventory Details label");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to verify Inventory Type
	 * 
	 * @param text - value to verify
	 */
	public static void verifyInventoryType(String text) {
		String actualText = SeleniumActions.getText(byInventoryTypeCellValue);
		if (actualText != null && !actualText.trim().isEmpty()) {
			if (actualText.contains(text)) {
				FrameworkLogger.log(LogType.PASS, "InventoryType CellValue verification passed. " + actualText);
			} else {
				FrameworkLogger.log(LogType.FAIL,
						"InventoryType CellValue verification failed. Expected : " + text + ", Actual : " + actualText);
			}
		} else {
			FrameworkLogger.log(LogType.FAIL, "InventoryType CellValue verification failed. value is null or empty");
		}
	}

	/**
	 * Function to verify ProductStatus
	 * 
	 * @param text - value to verify
	 */
	public static void verifyProductStatus(String text) {
		String actualText = SeleniumActions.getText(byProductStatusTypeCellValue);
		if (actualText != null && !actualText.trim().isEmpty()) {
			if (actualText.contains(text)) {
				FrameworkLogger.log(LogType.PASS, "ProductStatus CellValue verification passed. " + actualText);
			} else {
				FrameworkLogger.log(LogType.FAIL,
						"ProductStatus CellValue verification failed. Expected : " + text + ", Actual : " + actualText);
			}
		} else {
			FrameworkLogger.log(LogType.FAIL, "ProductStatus CellValue verification failed. value is null or empty");
		}
	}

	/**
	 * Function to verify BatchNumber params text - value to verify
	 * @param text - value to verify
	 */
	public static void verifyBatchNumber(String text) {
		String actualText = SeleniumActions.getText(byBatchNumberCellValue).trim();
		SeleniumActions.verifyTextEquals(actualText, text);
	}

	/**
	 * Function to verify CountryOfOrigin params text - value to verify
	 * @param text - value to verify
	 */
	public static void verifyCountryOfOrigin(String text) {
		String actualText = SeleniumActions.getText(byCountryOfOriginCellValue).trim();
		SeleniumActions.verifyTextEquals(actualText, text);
	}

	/**
	 * Function to verifyContainer params text - value to verify
	 * @param text - value to verify
	 */
	public static void verifyInventorycontainer(String text) {
		CommonMethods.scrollByParticularElement(byInventorycontainerCellValue, "byInventorycontainerCellValue");
		String actualText = SeleniumActions.getText(byInventorycontainerCellValue);
		if (actualText != null && !actualText.trim().isEmpty()) {
			if (actualText.contains(text)) {
				FrameworkLogger.log(LogType.PASS, "InventoryContainer CellValue verification passed. " + actualText);
			} else {
				FrameworkLogger.log(LogType.FAIL, "InventoryContainer CellValue verification failed. Expected : " + text
						+ ", Actual : " + actualText);
			}
		} else {
			FrameworkLogger.log(LogType.FAIL,
					"InventoryContainer CellValue verification failed. value is null or empty");
		}
	}

	/**
	 * Function to verifyParentLPN params text - value to verify
	 * @param text - value to verify
	 */
	public static void verifyParentContainer(String text) {
		String actualText = SeleniumActions.getText(byInventoryparentLPNCellValue);
		if (actualText != null && !actualText.trim().isEmpty()) {
			if (actualText.contains(text)) {
				FrameworkLogger.log(LogType.PASS,
						"Parent InventoryContainer CellValue verification passed. " + actualText);
			} else {
				FrameworkLogger.log(LogType.FAIL, "Parent InventoryContainer CellValue verification failed. Expected : "
						+ text + ", Actual : " + actualText);
			}
		} else {
			FrameworkLogger.log(LogType.FAIL,
					"Parent InventoryContainer CellValue verification failed. value is null or empty");
		}
	}

	/**
	 * Function to click LPNAttributes Label
	 */
	public static void clickLPNAttributesLabel() {
		CommonMethods.scrollByParticularElement(byLPNAttributesLabel, "LPNAttributes label");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byLPNAttributesLabel, "LPNAttributes label");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to get EstimatedWeight
	 */
	public static String getEstimatedWeight() {
		return SeleniumActions.getText(byEstimatedWeight).trim();
	}

	/**
	 * Function to get Volume
	 */
	public static String getVolume() {
		return SeleniumActions.getText(byVolume).trim();
	}

	/**
	 * Function to verify LPNVolumeIs GreaterThan Location AvailableVolume
	 */
	public static void verifyLPNVolumeIsGreaterThanLocationAvailableVolume() {
		CommonPage.clickRowAtFirstIndex();
		FooterPanelPage.clickDetailsButton();
		clickLPNAttributesLabel();
		Float availableVolumeValue = (Float) Variables
				.get(CurrentThreadInstance.getCurrentScenarioId() + "AvailableVolume");
		Float lpnVolumeValue = Float.valueOf(getVolume().replaceAll(",", ""));
		if (getDataFromFeature(getData("ItemVolumeUOM")).equalsIgnoreCase("cucm")) {
			lpnVolumeValue = (float) (lpnVolumeValue / 28316.846592);
		}
		if (lpnVolumeValue > availableVolumeValue) {
			FrameworkLogger.log(LogType.PASS, "LPN Volume is greater than Location available Volume. AvailableVolume: "
					+ availableVolumeValue + ", lpnVolumeValue: " + lpnVolumeValue);
		} else {
			FrameworkLogger.log(LogType.FAIL,
					"LPN Volume is NOT greater than Location available Volume. AvailableVolume: " + availableVolumeValue
							+ ", lpnVolumeValue: " + lpnVolumeValue);
		}
		CommonPopupPage.clickCloseIcon();
	}

	/**
	 * Function to verify LPN WeightAndVolume Are LessThan Location Available
	 * WeightAndVolume
	 */
	public static void verifyLPNWeightAndVolumeAreLessThanLocationAvailableWeightAndVolume() {
		CommonPage.clickRowAtFirstIndex();
		FooterPanelPage.clickDetailsButton();
		clickLPNAttributesLabel();
		Float availableWeightValue = (Float) Variables
				.get(CurrentThreadInstance.getCurrentScenarioId() + "AvailableWeight");
		Float availableVolumeValue = (Float) Variables
				.get(CurrentThreadInstance.getCurrentScenarioId() + "AvailableVolume");
		Float lpnWeightValue = Float.valueOf(ILPNPopupPage.getEstimatedWeight());
		Float lpnVolumeValue = Float.valueOf(getVolume().replaceAll(",", ""));
		if (getDataFromFeature(getData("ItemVolumeUOM")).equalsIgnoreCase("cucm")) {
			lpnVolumeValue = (float) (lpnVolumeValue / 28316.846592);
		}
		if (lpnWeightValue < availableWeightValue && lpnVolumeValue < availableVolumeValue) {
			FrameworkLogger.log(LogType.INFO,
					"LPN Weight and Volume are Less than Location available Weight and Volume. LPN WeightValue: "
							+ lpnWeightValue + ", LPN VolumeValue: " + lpnVolumeValue);
			FrameworkLogger.log(LogType.PASS,
					"LPN Weight and Volume are Less than Location available Weight and Volume. AvailableWeight: "
							+ availableWeightValue + ", AvailableVolume: " + availableVolumeValue);
		} else {
			FrameworkLogger.log(LogType.INFO,
					"LPN Weight and Volume are NOT Less than Location available Weight and Volume. LPN WeightValue: "
							+ lpnWeightValue + ", LPN VolumeValue: " + lpnVolumeValue);
			FrameworkLogger.log(LogType.FAIL,
					"LPN Weight and Volume are NOT Less than Location available Weight and Volume. AvailableWeight: "
							+ availableWeightValue + ", AvailableVolume: " + availableVolumeValue);
		}
		CommonPopupPage.clickCloseIcon();
	}

	/**
	 * Function to verifyContainer params text - value to verify
	 * @param text - value to verify
	 */
	public static void verifyOnHandQuantity(String text) {
		String actualText = SeleniumActions.getText(byOnhandQuantityCellValue);
		if (actualText != null && !actualText.trim().isEmpty()) {
			if (actualText.contains(text)) {
				FrameworkLogger.log(LogType.PASS, "On Hand Quantity CellValue verification passed. " + actualText);
			} else {
				FrameworkLogger.log(LogType.FAIL, "On Hand Quantity CellValue verification failed. Expected : " + text
						+ ", Actual : " + actualText);
			}
		} else {
			FrameworkLogger.log(LogType.FAIL, "On Hand Quantity CellValue verification failed. value is null or empty");
		}
	}

	/**
	 * Function to verifyContainer params text - value to verify
	 * @param text - value to verify
	 */
	public static void verifyItem(String text) {
		String actualText = SeleniumActions.getText(byItemLPNCellValue);
		if (actualText != null && !actualText.trim().isEmpty()) {
			if (actualText.contains(text)) {
				FrameworkLogger.log(LogType.PASS, "ITEM CellValue verification passed. " + actualText);
			} else {
				FrameworkLogger.log(LogType.FAIL,
						"ITEM CellValue verification failed. Expected : " + text + ", Actual : " + actualText);
			}
		} else {
			FrameworkLogger.log(LogType.FAIL, "ITEM CellValue verification failed. value is null or empty");
		}
	}

	/**
	 * Function to verify Inventory Details Item on popup
	 * @param text - value to verify
	 */
	public static void verifyItemForInventoryDeatilsINLPNpopup(String text) {
		String actualText = SeleniumActions.getText(byItemInInventoryDetails_LPNpopup);
		if (actualText != null && !actualText.trim().isEmpty()) {
			if (actualText.contains(text)) {
				FrameworkLogger.log(LogType.PASS, "ITEM CellValue verification passed. " + actualText);
			} else {
				FrameworkLogger.log(LogType.FAIL,
						"ITEM CellValue verification failed. Expected : " + text + ", Actual : " + actualText);
			}
		} else {
			FrameworkLogger.log(LogType.FAIL, "ITEM CellValue verification failed. value is null or empty");
		}
	}

	/**
	 * Function to verifyProduct Status params text - value to verify
	 * @param text - value to verify
	 */
	public static void verifyProductStatusinpop(String text) {
		String actualText = SeleniumActions.getText(byProductStatusTypeCellValueinpop);
		if (actualText != null && !actualText.trim().isEmpty()) {
			if (actualText.contains(text)) {
				FrameworkLogger.log(LogType.PASS, "Product Status CellValue verification passed. " + actualText);
			} else {
				FrameworkLogger.log(LogType.FAIL, "Product Status CellValue verification failed. Expected : " + text
						+ ", Actual : " + actualText);
			}
		} else {
			FrameworkLogger.log(LogType.FAIL, "Product Status CellValue verification failed. value is null or empty");
		}
	}

	/**
	 * Function to verifyAllocated Quantity params text - value to verify
	 * @param text - value to verify
	 */
	public static void verifyAllocatedQty(String text) {
		String actualText = SeleniumActions.getText(byAllocatedQtyCellValue);
		if (actualText != null && !actualText.trim().isEmpty()) {
			if (actualText.contains(text)) {
				FrameworkLogger.log(LogType.PASS, "Allocated Quantity CellValue verification passed. " + actualText);
			} else {
				FrameworkLogger.log(LogType.FAIL, "Allocated Quantity  CellValue verification failed. Expected : "
						+ text + ", Actual : " + actualText);
			}
		} else {
			FrameworkLogger.log(LogType.FAIL,
					"Allocated Quantity  CellValue verification failed. value is null or empty");
		}
	}

	/**
	 * Function to verify Inventory Type params text - value to verify
	 * @param text - value to verify
	 */
	public static void verifyInventorytypeinpop(String text) {
		String actualText = SeleniumActions.getText(byInventoryTypeCellValueinpop);
		if (actualText != null && !actualText.trim().isEmpty()) {
			if (actualText.contains(text)) {
				FrameworkLogger.log(LogType.PASS, "InventoryTypeC CellValue verification passed. " + actualText);
			} else {
				FrameworkLogger.log(LogType.FAIL, "InventoryType  CellValue verification failed. Expected : " + text
						+ ", Actual : " + actualText);
			}
		} else {
			FrameworkLogger.log(LogType.FAIL, "InventoryType  CellValue verification failed. value is null or empty");
		}
	}

	/**
	 * Function to VERify Batch Number params text - value to verify
	 * @param text - value to verify
	 */
	public static void verifyBatchnumber(String text) {
		String actualText = SeleniumActions.getText(byBatchNumberCellValueinpop);

		if (actualText.contains(text)) {
			FrameworkLogger.log(LogType.PASS, "BatchNumber CellValue verification passed. " + actualText);
		} else {
			FrameworkLogger.log(LogType.FAIL,
					"BatchNumber  CellValue verification failed. Expected : " + text + ", Actual : " + actualText);
		}

	}

	/**
	 * Function to VERify Expiry Date params text - value to verify
	 *@param text - value to verif
	 */
	public static void verifyExpiryDate(String text) {
		String actualText = SeleniumActions.getText(byExpiryDateCellValueinpop);

		if (actualText.contains(text)) {
			FrameworkLogger.log(LogType.PASS, "Expiry Date CellValue verification passed. " + actualText);
		} else {
			FrameworkLogger.log(LogType.FAIL,
					"Expiry Date  CellValue verification failed. Expected : " + text + ", Actual : " + actualText);
		}

	}

	/**
	 * Function to verify OnHandQuantityCellValue
	 * 
	 * @param text - value to verif
	 */
	public static void verifyOnHandQuantityCellValue(String text) {
		CommonMethods.scrollByParticularElement(byOnHandQuantityCellValue, "byOnHandQuantityCellValue");
		String actualText = SeleniumActions.getText(byOnHandQuantityCellValue);
		if (actualText != null && !actualText.trim().isEmpty()) {
			if (Integer.parseInt(actualText) == (Integer.parseInt(text))) {
				FrameworkLogger.log(LogType.PASS, "OnHandQuantity CellValue verification passed. " + actualText);
			} else {
				FrameworkLogger.log(LogType.FAIL, "OnHandQuantity CellValue verification failed. Expected : " + text
						+ ", Actual : " + actualText);
			}
		} else {
			FrameworkLogger.log(LogType.FAIL, "OnHandQuantity CellValue verification failed. value is null or empty");
		}
	}

	/**
	 * Function to verify ProductStatus And InventoryType In LPNPopupPage
	 */
	public static void verifyProductStatusAndInventoryTypeInLPNPopupPage() {
		CommonPage.clickRowAtFirstIndex();
		FooterPanelPage.clickDetailsButton();
		ILPNPopupPage.clickInventoryDetailsLabel();
		String inventoryType = getDataFromFeature("getdata(InventoryTypeID)");
		String productStatus = getDataFromFeature("getdata(ProductStatus)");
		verifyProductStatus(productStatus);
		verifyInventoryType(inventoryType);
		CommonPopupPage.clickCloseIcon();
	}

	/**
	 * Function to verify SKU product status, quantity and inventory type
	 */
	public static void verifySKUProductStatusQuantityAndInventoryTypeInLPNPopupPage() {
		CommonPage.clickRowAtFirstIndex();
		FooterPanelPage.clickDetailsButton();
		ILPNPopupPage.clickInventoryDetailsLabel();
		String inventoryType = getDataFromFeature("getdata(InventoryTypeID)");
		String productStatus = getDataFromFeature("getdata(ProductStatus)");
		String onHandQuantity = getDataFromFeature("getdata(QuantityLPNINVPopup)");
		String item = getDataFromFeature("getdata(Item)");
		verifyProductStatus(productStatus);
		verifyInventoryType(inventoryType);
		verifyOnHandQuantity(onHandQuantity);
		verifyItemForInventoryDeatilsINLPNpopup(item);
		CommonPopupPage.clickCloseIcon();
	}

	/**
	 * Function to verify ProductStatus And InventoryType for multiple lpns In
	 * LPNPopupPage
	 */
	public static void verifyProductStatusAndInventoryTypeForMultipleLpnsInLPNPopupPage() {
		List<WebElement> elements = CommonPage.getRowElements();
		for (WebElement e : elements) {
			CommonMethods.scrollByParticularElement(e, "Row element");
			e.click();
			CommonMethods.waitForPageLoading();
			FooterPanelPage.clickDetailsButton();
			ILPNPopupPage.clickInventoryDetailsLabel();
			String inventoryType = getDataFromFeature("getdata(InventoryTypeID)");
			String productStatus = getDataFromFeature("getdata(ProductStatus)");
			verifyProductStatus(productStatus);
			verifyInventoryType(inventoryType);
			CommonPopupPage.clickCloseIcon();
			elements = CommonPage.getRowElements();
			e.click();
		}

	}

	/**
	 * Function to validate if volume is greater that location volume
	 */
	public static void validateLPNVolumeIsGreaterThanLocationAvailableVolume() {
		CommonPage.clickRowAtFirstIndex();
		FooterPanelPage.clickDetailsButton();
		clickLPNAttributesLabel();
		Float availableVolumeValue = (Float) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "AvailableVolume");
		Float lpnVolumeValue = Float.valueOf(getVolume().replaceAll(",", ""));
		if (lpnVolumeValue > availableVolumeValue) {
			FrameworkLogger.log(LogType.PASS,
					"LPN Volume is greater than Location available Volume. AvailableVolume: " + availableVolumeValue + ", lpnVolumeValue: " + lpnVolumeValue);
		} else {
			FrameworkLogger.log(LogType.FAIL,
					"LPN Volume is NOT greater than Location available Volume. AvailableVolume: " + availableVolumeValue + ", lpnVolumeValue: " + lpnVolumeValue);
		}
		CommonPopupPage.clickCloseIcon();
	}
	/**
	 * Function to verify ExpiryDateCellValue
	 * @param text - value to verify
	 */
	public static void verifyExpiryDateCellValue(String text) {
		String actualText = SeleniumActions.getText(byExpiryDateCellValue).trim();
		SeleniumActions.verifyTextEquals(actualText, text);

	}
}
