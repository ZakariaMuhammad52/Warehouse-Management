package stepdefinitions;

import com.dhl.api.utils.ApiUtils;
import com.dhl.api.utils.RequestBuilder;
import com.dhl.reports.FrameworkLogger;
import com.dhl.reports.LogType;
import com.dhl.testdata.TestData_Json;
import com.dhl.utils.CurrentThreadInstance;
import com.dhl.utils.RandomUtils;
import com.dhl.utils.Variables;
import io.cucumber.java.en.And;
import web.Pages.LeftPanelPage;
import web.Pages.OrderLinePopupPage;

import java.io.IOException;
import java.util.HashMap;

public class WMS_CreatePO_API extends TestData_Json {
	
    public String convert_variable_to_timestamp(String strInput) {
        String strDateFormat = strInput.substring(strInput.indexOf("<")+1, strInput.indexOf(">"));
        String strPrefix = strInput.substring(0, strInput.indexOf("<"));
        return RandomUtils.generateString_WithTimeStamp(strPrefix, strDateFormat);
    }

    @And("Generate PO ID {string} using timestamp and update request body")
    public void generatePOID(String strData) {
        String strKey=CurrentThreadInstance.getCurrentScenarioId()+"PO_ID";
        if (strData.toLowerCase().matches("getdata(.*)")) {
            strKey = CurrentThreadInstance.getCurrentScenarioId()+strData
                    .substring(strData.toLowerCase().indexOf("getdata(") + "getdata(".length())
                    .replace(")", "");
            		System.out.println("Test Data Key: " + strKey);
        }
        strData = getDataFromFeature(strData);
        if (strData.matches(".*<.*>")) {
            Variables.set(strKey, convert_variable_to_timestamp(strData));
            FrameworkLogger.log(LogType.INFO, strKey + " : " + convert_variable_to_timestamp(strData));
        } else {
            Variables.set(strKey, strData);
            FrameworkLogger.log(LogType.INFO, strKey + " : " + strData);
        }
        HashMap<String, Object> mapOfParams = new HashMap<>();
        mapOfParams.put("{PO_ID}",Variables.get(strKey).toString());
        String strUpdatedRequestBody = ApiUtils.constructRequestBody(RequestBuilder.getCurrentRequestbodycontent(),
                mapOfParams);
        RequestBuilder.setRequestBody(strUpdatedRequestBody);
    }
    
    @And("Generate PO ID {string} using timestamp and update request body1")
    public void generatePOID1(String strData) {
        strData = getDataFromFeature(strData);
        if (strData.matches(".*<.*>")) {
            Variables.set(CurrentThreadInstance.getCurrentScenarioId()+"PO_ID", convert_variable_to_timestamp(strData));
        } else {
            Variables.set(CurrentThreadInstance.getCurrentScenarioId()+"PO_ID", strData);
        }
        HashMap<String, Object> mapOfParams = new HashMap<>();
        mapOfParams.put("{PO_ID}",Variables.get("PO_ID").toString());
        String strUpdatedRequestBody = ApiUtils.constructRequestBody(RequestBuilder.getCurrentRequestbodycontent(),
                mapOfParams);
        RequestBuilder.setRequestBody(strUpdatedRequestBody);
    }
    @And("Generate PO ID {string} using timestamp and update request body without variables")
    public void generatePOID_WithoutVariables(String strData) {
        strData = getDataFromFeature(strData);
        if (strData.matches(".*<.*>")) {
            strData=convert_variable_to_timestamp(strData);
        }
        HashMap<String, Object> mapOfParams = new HashMap<>();
        mapOfParams.put("{PO_ID}",strData);
        String strUpdatedRequestBody = ApiUtils.constructRequestBody(RequestBuilder.getCurrentRequestbodycontent(),
                mapOfParams);
        RequestBuilder.setRequestBody(strUpdatedRequestBody);
    }

    @And("Store test data of Create PO API into Runtime Variables")
    public void store_data_into_variables() {
        HashMap<String, Object> mapOfScData = CurrentThreadInstance.getCurrentScenarioData();
        for (String eachKey : mapOfScData.keySet()) {
            Object objLocal = mapOfScData.get(eachKey);
            if (!eachKey.equals("PO_ID")) {
                Variables.set(eachKey, objLocal);
            }
        }
        Variables.storeVariablesIntoTextFile();
    }


    @And("Generate ITEM ID {string} using timestamp and update request body")
    public void generateItemID(String strData) {
        String strKey=CurrentThreadInstance.getCurrentScenarioId()+"ITEM_ID";
        if (strData.toLowerCase().matches("getdata(.*)")) {
            strKey = CurrentThreadInstance.getCurrentScenarioId()+strData
                    .substring(strData.toLowerCase().indexOf("getdata(") + "getdata(".length())
                    .replace(")", "");
            System.out.println("Test Data Key: " + strKey);
        }
        strData = getDataFromFeature(strData);
        if (strData.matches(".*<.*>")) {
            Variables.set(strKey, convert_variable_to_timestamp(strData));
            FrameworkLogger.log(LogType.INFO, strKey + " : " + convert_variable_to_timestamp(strData));
        } else {
            Variables.set(strKey, strData);
            FrameworkLogger.log(LogType.INFO, strKey + " : " + strData);
        }
        HashMap<String, Object> mapOfParams = new HashMap<>();
        mapOfParams.put("{ITEM_ID}",Variables.get(strKey).toString());
        mapOfParams.put("{PrimaryBarCode}",Variables.get(strKey).toString().replaceAll("-",""));
        String strUpdatedRequestBody = ApiUtils.constructRequestBody(RequestBuilder.getCurrentRequestbodycontent(),
                mapOfParams);
        RequestBuilder.setRequestBody(strUpdatedRequestBody);
    }

    @And("Generate Original order ID {string} using timestamp and update request body")
    public void generateOriginalOrderID(String strData) {
        String strKey=CurrentThreadInstance.getCurrentScenarioId()+"OriginalOrder_ID";
        if (strData.toLowerCase().matches("getdata(.*)")) {
            strKey = CurrentThreadInstance.getCurrentScenarioId()+strData
                    .substring(strData.toLowerCase().indexOf("getdata(") + "getdata(".length())
                    .replace(")", "");
            System.out.println("Test Data Key: " + strKey);
        }
        strData = getDataFromFeature(strData);
        if (strData.matches(".*<.*>")) {
            Variables.set(strKey, convert_variable_to_timestamp(strData));
            FrameworkLogger.log(LogType.INFO, strKey + " : " + convert_variable_to_timestamp(strData));
        } else {
            Variables.set(strKey, strData);
            FrameworkLogger.log(LogType.INFO, strKey + " : " + strData);
        }
        HashMap<String, Object> mapOfParams = new HashMap<>();
        mapOfParams.put("{OriginalOrder_ID}",Variables.get(strKey).toString());
        String strUpdatedRequestBody = ApiUtils.constructRequestBody(RequestBuilder.getCurrentRequestbodycontent(),
                mapOfParams);
        RequestBuilder.setRequestBody(strUpdatedRequestBody);
    }
    @And("Validate Ordered Quantity in Second Line Order with data in Json {string}")
    public void validateOrderedQuantityInSecondLineOrderWithDataInJson(String fileName) throws IOException {
        OrderLinePopupPage.verifyOrderedQuantityForSecondLineOrder(fileName);
    }

    @And("Update Request Body with Original Order Id with variable {string}")
    public void updateRequestBodyWithOriginalOrderIdWithVariable(String order) {
        HashMap<String, Object> mapOfParams = new HashMap<>();
        mapOfParams.put("{OriginalOrder_ID}",Variables.get(CurrentThreadInstance.getCurrentScenarioId() + order).toString());
        String strUpdatedRequestBody = ApiUtils.constructRequestBody(RequestBuilder.getCurrentRequestbodycontent(),
                mapOfParams);
        RequestBuilder.setRequestBody(strUpdatedRequestBody);
    }

    @And("Validate Updated Ordered Quantity with RESET ACTION on Second OrderLine with data in Json {string}")
    public void validateUpdatedOrderedQuantityWithRESETACTIONOnSecondOrderLineWithDataInJson(String fileName) throws IOException{
        OrderLinePopupPage.verifyUpdatedOrderedQuantityWithResetActionOnSecondOrderLine(fileName);
    }

    @And("Generate ASN ID {string} using timestamp and update request body")
    public void generateASNID(String strData) {
        String strKey=CurrentThreadInstance.getCurrentScenarioId()+"ASN_ID";
        String strKeybuid= getDataFromFeature("getdata(BUID)");
        String strKeyfacility= getDataFromFeature("getdata(facility)");
        String strKeyitemid1= getDataFromFeature("getdata(ItemId1)");
        String strKeyitemid2= getDataFromFeature("getdata(ItemId2)");
        if (strData.toLowerCase().matches("getdata(.*)")) {
            strKey = CurrentThreadInstance.getCurrentScenarioId()+strData
                    .substring(strData.toLowerCase().indexOf("getdata(") + "getdata(".length())
                    .replace(")", "");
            System.out.println("Test Data Key: " + strKey);
        }
        strData = getDataFromFeature(strData);
        if (strData.matches(".*<.*>")) {
            Variables.set(strKey, convert_variable_to_timestamp(strData));
            FrameworkLogger.log(LogType.INFO, strKey + " : " + convert_variable_to_timestamp(strData));
        } else {
            Variables.set(strKey, strData);
            FrameworkLogger.log(LogType.INFO, strKey + " : " + strData);
        }
        HashMap<String, Object> mapOfParams = new HashMap<>();
        mapOfParams.put("{ASN_ID}",Variables.get(strKey).toString());
        mapOfParams.put("BUID",strKeybuid);
        mapOfParams.put("facility",strKeyfacility);
        mapOfParams.put("ItemId1",strKeyitemid1);
        mapOfParams.put("ItemId2",strKeyitemid2);
        String strUpdatedRequestBody = ApiUtils.constructRequestBody(RequestBuilder.getCurrentRequestbodycontent(),
                mapOfParams);
        RequestBuilder.setRequestBody(strUpdatedRequestBody);
    }

    @And("Update ASN ID With Variable {string} in request body")
    public void updateASNIDWithVariable(String strData) {
        String strKey= (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId()+strData);
        String strKeybuid= getDataFromFeature("getdata(BUID)");
        String strKeyfacility= getDataFromFeature("getdata(facility)");
        String strKeyitemid2= getDataFromFeature("getdata(ItemId2)");
        HashMap<String, Object> mapOfParams = new HashMap<>();
        mapOfParams.put("ASN_ID",strKey);
        mapOfParams.put("BUID",strKeybuid);
        mapOfParams.put("facility",strKeyfacility);
        mapOfParams.put("ItemId2",strKeyitemid2);
        String strUpdatedRequestBody = ApiUtils.constructRequestBody(RequestBuilder.getCurrentRequestbodycontent(),
                mapOfParams);
        RequestBuilder.setRequestBody(strUpdatedRequestBody);
    }
    @And("Update item in Json with respect to testdata {string}")
    public void updateItemIDINJsonFromTestData(String strData) {
        strData = getDataFromFeature(strData);
        HashMap<String, Object> mapOfParams = new HashMap<>();
        mapOfParams.put("{Item_ID}",strData);
        String strUpdatedRequestBody = ApiUtils.constructRequestBody(RequestBuilder.getCurrentRequestbodycontent(),
                mapOfParams);
        RequestBuilder.setRequestBody(strUpdatedRequestBody);
    }

    @And("Update Profile Org Details in Json")
    public void updateProfileOrgDetailsinJson() {
        String strKeybuid= getDataFromFeature("getdata(BUID)");
        String strKeyfacility= getDataFromFeature("getdata(L0-ORG)");
        HashMap<String, Object> mapOfParams = new HashMap<>();
        mapOfParams.put("{BUID}",strKeybuid);
        mapOfParams.put("{facility}",strKeyfacility);
        String strUpdatedRequestBody = ApiUtils.constructRequestBody(RequestBuilder.getCurrentRequestbodycontent(),
                mapOfParams);
        RequestBuilder.setRequestBody(strUpdatedRequestBody);
    }
}
