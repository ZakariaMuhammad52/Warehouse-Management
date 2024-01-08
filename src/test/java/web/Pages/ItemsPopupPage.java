package web.Pages;

import com.dhl.utils.CurrentThreadInstance;
import com.dhl.utils.Variables;
import com.jayway.jsonpath.JsonPath;
import org.openqa.selenium.By;
import com.dhl.reports.FrameworkLogger;
import com.dhl.reports.LogType;
import com.dhl.testdata.TestData_Json;
import com.dhl.web.utils.SeleniumActions;
import stepdefinitions.CommonMethods;

@SuppressWarnings("unused")
public class ItemsPopupPage extends TestData_Json {
	private static final By bySpecificationsLabel = By.xpath("//span[normalize-space()='Specifications']");
	private static final By byProductClass = By.xpath("//div[@data-component-id='ProductClassDescription-list-expand']");
	private static final By byDimensionsLabel = By.xpath("//span[normalize-space()='Dimensions']");
	private static final By byDimensionUomId = By.xpath("//div[@data-component-id='OriginalDimensionUomId-list-expand']");
	private static final By byVolumeUomId = By.xpath("//div[@data-component-id='OriginalVolumeUomId-list-expand']");
	private static final By byWeightUomId = By.xpath("//div[@data-component-id='OriginalWeightUomId-list-expand']");
	private static final By byTrackBatchNumber = By.xpath("//div[@data-component-id='TrackBatchNumber-list-expand']");
	private static final By byAttributeGroupId = By.xpath("//span[@data-component-id='AttributeGroupId-list-details']");
	private static final By byTrackingAttributesLabel = By.xpath("//span[normalize-space()='Tracking Attributes']");

	/**
	 * Function to verify productClass
	 * 
	 * @param text - value to verify
	 */
	public static void verifyProductClassValue(String text) {

		String productClass = SeleniumActions.getText(byProductClass);
		if (productClass.equalsIgnoreCase(text)) {
			FrameworkLogger.log(LogType.PASS, "Product class Verification passed : " + productClass);
		} else {
			FrameworkLogger.log(LogType.FAIL,
					"Product class Verification failed. Expected :" + text + " , Actual :" + productClass);
		}
	}

	/**
	 * Function to click Specification Label
	 */
	public static void clickSpecificationLabel() {
		SeleniumActions.click(bySpecificationsLabel, "click Specification Label");
		CommonMethods.waitForPageLoading();
	}


	/**
	 * Function to click Dimensions Label
	 */
	public static void clickDimensionsLabel() {
		SeleniumActions.click(byDimensionsLabel, "Dimensions Label");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to verify Attribute Values For NormalItemTemplate
	 */
	public static void verifyAttributeValuesForNormalItemTemplate(String template) {
		CommonPage.clickRowAtFirstIndex();
		FooterPanelPage.clickDetailsButton();
		String json=(String) Variables.get(CurrentThreadInstance.getCurrentScenarioId()+template);

		clickDimensionsLabel();
		String expectedDimensionUomId = JsonPath.read(json, "$.DimensionUomId");
		String actualDimensionUomId = SeleniumActions.getText(byDimensionUomId);
		SeleniumActions.verifyTextEquals(actualDimensionUomId, expectedDimensionUomId,false);

		String expectedVolumeUomId = JsonPath.read(json, "$.VolumeUomId");
		String actualVolumeUomId = SeleniumActions.getText(byVolumeUomId);
		SeleniumActions.verifyTextEquals(actualVolumeUomId, expectedVolumeUomId,false);

		String expectedWeightUomId = JsonPath.read(json, "$.WeightUomId");
		String actualWeightUomId = SeleniumActions.getText(byWeightUomId);
		SeleniumActions.verifyTextEquals(actualWeightUomId, expectedWeightUomId,false);

		clickSpecificationLabel();
		String expectedProductClass = JsonPath.read(json, "$.ProductClass");
		String actualProductClass = SeleniumActions.getText(byProductClass);
		SeleniumActions.verifyTextContains(actualProductClass, expectedProductClass,true);
		CommonPopupPage.clickCloseIcon();
	}

	/**
	 * Function to verify Attribute Values For BatchTRK ItemTemplate
	 */
	public static void verifyAttributeValuesForBatchTRKItemTemplate(String template) {
		CommonPage.clickRowAtFirstIndex();
		FooterPanelPage.clickDetailsButton();
		String json=(String) Variables.get(CurrentThreadInstance.getCurrentScenarioId()+template);

		clickDimensionsLabel();
		String expectedDimensionUomId = JsonPath.read(json, "$.DimensionUomId");
		String actualDimensionUomId = SeleniumActions.getText(byDimensionUomId);
		SeleniumActions.verifyTextEquals(actualDimensionUomId, expectedDimensionUomId,false);

		String expectedVolumeUomId = JsonPath.read(json, "$.VolumeUomId");
		String actualVolumeUomId = SeleniumActions.getText(byVolumeUomId);
		SeleniumActions.verifyTextEquals(actualVolumeUomId, expectedVolumeUomId,false);

		String expectedWeightUomId = JsonPath.read(json, "$.WeightUomId");
		String actualWeightUomId = SeleniumActions.getText(byWeightUomId);
		SeleniumActions.verifyTextEquals(actualWeightUomId, expectedWeightUomId,false);

		clickSpecificationLabel();
		String expectedProductClass = JsonPath.read(json, "$.ProductClass");
		if(expectedProductClass.equalsIgnoreCase("BATCHTRK")){
			expectedProductClass="Batch Tracked Products";
		}
		String actualProductClass = SeleniumActions.getText(byProductClass);
		SeleniumActions.verifyTextContains(actualProductClass, expectedProductClass,true);

		clickTrackingAttributesLabel();
		boolean expectedTrackBatchNumberStatus = JsonPath.read(json, "$.TrackBatchNumber");
		String expectedTrackBatchNumber="";
		if(expectedTrackBatchNumberStatus){
			expectedTrackBatchNumber="Yes";
		}else{
			expectedTrackBatchNumber="No";
		}
		String actualTrackBatchNumber = SeleniumActions.getText(byTrackBatchNumber);
		SeleniumActions.verifyTextContains(actualTrackBatchNumber, expectedTrackBatchNumber,true);
		CommonPopupPage.clickCloseIcon();
	}

	/**
	 * Function to verify Attribute Values For SerialTRK ItemTemplate
	 */
	public static void verifyAttributeValuesForSerialTRKItemTemplate(String template) {
		CommonPage.clickRowAtFirstIndex();
		FooterPanelPage.clickDetailsButton();
		String json=(String) Variables.get(CurrentThreadInstance.getCurrentScenarioId()+template);

		String expectedAttributeGroupId = JsonPath.read(json, "$.AttributeGroupId");
		String actualAttributeGroupId = SeleniumActions.getText(byAttributeGroupId);
		SeleniumActions.verifyTextContains(actualAttributeGroupId, expectedAttributeGroupId,true);

		clickDimensionsLabel();
		String expectedDimensionUomId = JsonPath.read(json, "$.DimensionUomId");
		String actualDimensionUomId = SeleniumActions.getText(byDimensionUomId);
		SeleniumActions.verifyTextEquals(actualDimensionUomId, expectedDimensionUomId,false);

		String expectedVolumeUomId = JsonPath.read(json, "$.VolumeUomId");
		String actualVolumeUomId = SeleniumActions.getText(byVolumeUomId);
		SeleniumActions.verifyTextEquals(actualVolumeUomId, expectedVolumeUomId,false);

		String expectedWeightUomId = JsonPath.read(json, "$.WeightUomId");
		String actualWeightUomId = SeleniumActions.getText(byWeightUomId);
		SeleniumActions.verifyTextEquals(actualWeightUomId, expectedWeightUomId,false);

		clickSpecificationLabel();
		String expectedProductClass = JsonPath.read(json, "$.ProductClass");
		String actualProductClass = SeleniumActions.getText(byProductClass);
		SeleniumActions.verifyTextContains(actualProductClass, expectedProductClass,true);
		CommonPopupPage.clickCloseIcon();
	}

	/**
	 * Function to click TrackingAttributes Label
	 */
	public static void clickTrackingAttributesLabel() {
		SeleniumActions.click(byTrackingAttributesLabel, "TrackingAttributes Label");
		CommonMethods.waitForPageLoading();
	}
}
