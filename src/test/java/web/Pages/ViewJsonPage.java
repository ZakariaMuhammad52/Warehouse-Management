package web.Pages;

import com.dhl.driver.DriverManager;
import com.dhl.reports.FrameworkLogger;
import com.dhl.reports.LogType;
import com.dhl.testdata.TestData_Json;
import com.dhl.utils.CurrentThreadInstance;
import com.dhl.utils.Variables;
import com.dhl.web.utils.SeleniumActions;
import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import stepdefinitions.CommonMethods;

import java.util.*;

@SuppressWarnings("unused")
public class ViewJsonPage extends TestData_Json {


	private static final By byContent = By.xpath("//div[@class='content']/modal-content/json-view/textarea");
	private static final By byPixStatus = By.xpath("//div[@data-component-id='StatusId-card-view']");

	/**
	 * Function to verify content
	 */
	public static void verifyContent(String adjustProductStatus, int i) {
		String lpn= (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "LPN");
		String sku = getDataFromFeature("getdata(SKU)");
		String productStatusId =null;
		if(adjustProductStatus.equalsIgnoreCase("Damaged")){
			productStatusId = getDataFromFeature("getdata(ProductStatusId1)");
		}
		if(adjustProductStatus.equalsIgnoreCase("Inspection")){
			productStatusId = getDataFromFeature("getdata(ProductStatusId2)");
		}
		String inventoryAdjustmentType =null;
		if(i%2==0){
			inventoryAdjustmentType ="SUBTRACT";
			productStatusId =productStatusId.split("-")[1];
		}else {
			inventoryAdjustmentType ="ADD";
			productStatusId =productStatusId.split("-")[0];
		}
		String reasonCodeId = getDataFromFeature("getdata(ReasonCodeId)");
		String referenceCode = getDataFromFeature("getdata(ReferenceCode)");
		String quantity = getDataFromFeature("getdata(OnHandQuantity)");
		String text= SeleniumActions.getAtrribute(byContent,"value",10);
		SeleniumActions.verifyTextContains(text,  "IlpnId\": \""+lpn+"",false);
		SeleniumActions.verifyTextContains(text,  "Description\": \""+sku+"",false);
		SeleniumActions.verifyTextContains(text,  "ProductStatusId\": \""+productStatusId+"",false);
		SeleniumActions.verifyTextContains(text,  "InventoryAdjustmentType\": \""+inventoryAdjustmentType+"",false);
		SeleniumActions.verifyTextContains(text,  "ReferenceText\": \""+referenceCode+"",false);
		SeleniumActions.verifyTextContains(text,  "Quantity\": \""+quantity+"",false);
	}

	/**
	 * Function to get PIX JSON View Data in PIX Visibility Slide Screen
	 */
	public static void getJSONViewPIXData() {
		CommonMethods.waitForPageLoading();

		String jsonText= SeleniumActions.getAtrribute(byContent,"value",10);
		JSONObject jsonObject = (JSONObject) JSONValue.parse(jsonText);

		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "jsonObject", jsonObject);

//		to display individual json attributes
//        Set<String> keySet = jsonObject.keySet();
//        for (String key : keySet) {
//            Object value = jsonObject.get(key);
//            System.out.printf("%s=%s (%s)\n", key, value, value.getClass()
//                    .getSimpleName());
//        }
	}

	/**
	 * Function to Store PIX Data SubItem Field Attributes
	 */
	public static void storePIXDataSubItemFieldAttributes(int i) {
		CommonMethods.waitForPageLoading();

		JSONObject jsonObject = (JSONObject) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "jsonObject");
		JSONObject subItemFields = (JSONObject) jsonObject.get("SubItemFields");

		String inventoryTypeId = subItemFields.get("InventoryTypeId").toString();
		String productStatusId = subItemFields.get("ProductStatusId").toString();
		String countryOfOrigin = subItemFields.get("CountryOfOrigin").toString();
		String itemBatchNumberId = subItemFields.get("ItemBatchNumberId").toString();

		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "inventoryTypeId" + i, inventoryTypeId);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "productStatusId" + i, productStatusId);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "countryOfOrigin" + i, countryOfOrigin);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "itemBatchNumberId" + i, itemBatchNumberId);

	}

	/**
	 * Function to verify Data in PIX Visibility Screen
	 */
	public static void verifyPixDataContent() {
		String PIXSpecification = getDataFromFeature("getdata(PIXSpecification)");
		String Description = getDataFromFeature("getdata(Description)");
		String ItemID = getDataFromFeature("getdata(Item)");
		String InventoryTypeId = getDataFromFeature("getdata(InventoryTypeID)");
		String ProductStatus = getDataFromFeature("getdata(ProductStatusID)");
		String OriginalOrder = getDataFromFeature("getdata(OriginalOrder)");
		String text= SeleniumActions.getAtrribute(byContent,"value",10);
		SeleniumActions.verifyTextContains(text,  "PIXSpecification\": \""+PIXSpecification+"",false);
		SeleniumActions.verifyTextContains(text,  "Description\": \""+Description+"",false);
		CommonMethods.verifyTextNotContains(text, "OriginalOrder\": \""+OriginalOrder+"", "OriginalOrder", false);
		SeleniumActions.verifyTextContains(text,  "InventoryTypeId\": \""+InventoryTypeId+"",false);
		SeleniumActions.verifyTextContains(text,  "ProductStatus\": \""+ProductStatus+"",false);

	}

	/**
	 * Function to get count of Items
	 */
	public static void getCountPixAttribute() {
		CommonMethods.waitForPageLoading();
		JSONObject jsonObject = (JSONObject) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "jsonObject");
		JSONObject attributeName = (JSONObject) jsonObject.get("AttributeName");
		int resultCountAttributeName = attributeName.size();
		Variables.set(CurrentThreadInstance.getCurrentScenarioId()+"resultCountAttributeName", resultCountAttributeName);
	}

	/**
	 * Function to Store PIX Data InventoryAttributes
	 */
	public static void storePIXDataInventoryAttributes(int i) {
		CommonMethods.waitForPageLoading();

		JSONObject jsonObject = (JSONObject) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "jsonObject");
		JSONObject inventoryAttributes = (JSONObject) jsonObject.get("InventoryAttributes");
		JSONObject attributeName = (JSONObject) jsonObject.get("AttributeName");
		JSONObject attributeValue = (JSONObject) jsonObject.get("AttributeValue");
		JSONObject adjustmentType = (JSONObject) jsonObject.get("AdjustmentType");

		//int resultCountInventoryAttributes = inventoryAttributes.size();
		//int resultCountAttributeName = attributeName.size();
		//Variables.set(CurrentThreadInstance.getCurrentScenarioId()+"resultCountAttributeName", resultCountAttributeName);
		//int resultCountAttributeValue = attributeValue.size();
		//int resultCountAdjustmentType = adjustmentType.size();


		Map<String, String> mapAttributeList = new HashMap<>();
			/*for (i = 0; i <= inventoryAttributes.size(); i++) {
				String key1 = "attributeName" + i;
				String key2 = "attributeValue" + i;
				String key3 = "adjustmentType" + i;

				Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "attributeName" + i, inventoryAttributes.get("AttributeName"));
				Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "attributeValue" + i, inventoryAttributes.get("AttributeValue"));
				Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "adjustmentType" + i, inventoryAttributes.get("AdjustmentType"));

				mapAttributeList.put(key1, (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId()+ "attributeName" + i));
				mapAttributeList.put(key2, (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId()+ "attributeValue" + i));
				mapAttributeList.put(key3, (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId()+ "adjustmentType" + i));
			}*/
			for (i = 0; i <= inventoryAttributes.size(); i++) {
				String key1 = "attributeName" + i;
				Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "attributeName" + i, attributeName.get("AttributeName"));
				mapAttributeList.put(key1, (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId()+ "attributeName" + i));
				FrameworkLogger.log(LogType.INFO, "Attribute Name " + Variables.get(CurrentThreadInstance.getCurrentScenarioId()+ "attributeName" + i));
			}
			for (i = 0; i <= inventoryAttributes.size(); i++) {
				String key2 = "attributeValue" + i;
				Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "attributeValue" + i, attributeName.get("AttributeValue"));
				mapAttributeList.put(key2, (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId()+ "attributeValue" + i));
				FrameworkLogger.log(LogType.INFO, "Attribute Value " + Variables.get(CurrentThreadInstance.getCurrentScenarioId()+ "attributeValue" + i));
			}
			for (i = 0; i <= inventoryAttributes.size(); i++) {
				String key3 = "adjustmentType" + i;
				Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "adjustmentType" + i, attributeName.get("AdjustmentType"));
				mapAttributeList.put(key3, (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId()+ "adjustmentType" + i));
				FrameworkLogger.log(LogType.INFO, "Adjustment Type " + Variables.get(CurrentThreadInstance.getCurrentScenarioId()+ "adjustmentType" + i));
			}
		}


				/*List<JSONObject> listOfInventoryAttributes = (List<JSONObject>) jsonObject.get("InventoryAttributes");
		//listOfInventoryAttributes.get(0).get("AttributeName").toString();
		for( JSONObject attribute : listOfInventoryAttributes){
			String attributeNameId = attribute.get("AttributeName").toString();
			String attributeValueId = attribute.get("AttributeValue").toString();
			String adjustmentType = attribute.get("AdjustmentType").toString();


		}*/


	/**
	 * Function to verify content For Count07Scenario
	 */
	public static void verifyContentForCount07Scenario() {
		String item = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "Item");
		String batchNumber = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "CurrentBatchNumber");
   		String inventoryAdjustmentType = getDataFromFeature("getdata(InventoryAdjustmentType)");
		String inventoryAdjustmentQuantity = getDataFromFeature("getdata(InventoryAdjustmentQuantity)");
		String text = SeleniumActions.getAtrribute(byContent, "value", 10);
		SeleniumActions.verifyTextContains(text, "ItemId\": \"" + item + "",  false);
		SeleniumActions.verifyTextContains(text, "ItemBatchNumberId\": \"" + batchNumber + "",  false);
		SeleniumActions.verifyTextContains(text, "InventoryAdjustmentQty\": \"" + inventoryAdjustmentQuantity + "",  false);
		SeleniumActions.verifyTextContains(text,  "InventoryAdjustmentType\": \""+inventoryAdjustmentType+"",false);
	}

}