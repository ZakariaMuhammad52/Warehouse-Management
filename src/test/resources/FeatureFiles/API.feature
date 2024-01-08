@DFN
Feature: API

##List of Test Cases
## TC    TS No.	Test Case Name
## 001.  1 	 	DFN-ITEM-01-Send a new NORMAL item via interface
## 002.  2 	 	DFN-ITEM-02-Send a new Batch Tracked item via interface
## 003.  3 	 	DFN-ITEM-03-Send a new Serial Tracked item via interface
## 004.  4 	 	DFN-ORDER-PR-01-Configure a standard order profile (header) and test
## 005.  5 	 	DFN-ORDER-PR-02-Configure a standard order profile (line) and test
## 006.  6	 	DFN-API-ORDER-UPDATE-01-Send an order with API with 2 or more lines Once order is in, remove one line and resend the order
## 007.  7 	 	DFN-API-ASN-01 - API Modify ASN - Load an ASN with two items via API then update it to remove one ASN Line
## 008.  8 	 	DFN-ORDER-PR-03- Configure a standard order profile (notes) and test

  @APITesting
  Scenario: DFN-ITEM-01-Send a new NORMAL item via interface
    Given Httpmethod is "POST" and Api endpoint is "/oauth/token"
    And Set base url "getdata(auth_host)" to API
    And Set Header 'Content-Type' with value as 'application/x-www-form-urlencoded'
    And Set Header 'Authorization' with value as 'Basic b21uaWNvbXBvbmVudC4xLjAuMDpiNHM4cmdUeWc1NVhZTnVu'
    And Get access token using username and password
    Given Httpmethod is "POST" and Api endpoint is "/item-master/api/item-master/item/save"
    And Set base url "getdata(app_host)" to API
    And Set Header 'selectedLocation' with value as 'getdata(L2-ORG)'
    And Set Header 'selectedOrganization' with value as 'getdata(L2-ORG)'
    And Set Header 'selectedBusinessUnit' with value as 'getdata(BUID)'
    And Set bearer token 'var(access_token)' to API
    And Set Requestbody from file "DFNITEM01.json"
    And Generate ITEM ID 'getdata(ITEM_ID)' using timestamp and update request body
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Edit OrgProfile
    And Navigate to Item Template Page
    And Click "byNormalItemTemplate" on "ItemTemplatePage" WaitForPageLoading
    And Click "byViewIonButton" on "FooterPanelPage" WaitForPageLoading
    And Store Item Template data to variable "NormalItemTemplateData"
    And Navigate to Items Page
    And Search Item With variable "ITEM_ID"
    And Verify NoRecords found label displayed
    When API send "POST" request
    Then Verify the response code is "200"
    Then Verify the expected value 'getdata(Value)' equals in response using the jsonpath 'getdata(JsonPath)'
    And Click "byRefreshButton" on "RightNavigationBar" WaitForPageLoading
    Then Verify Item with variable "ITEM_ID"
    And Verify Attribute values for Normal Item Template with variable "NormalItemTemplateData"

  @APITesting
  Scenario: DFN-ITEM-02-Send a new Batch Tracked item via interface
    Given Httpmethod is "POST" and Api endpoint is "/oauth/token"
    And Set base url "getdata(auth_host)" to API
    And Set Header 'Content-Type' with value as 'application/x-www-form-urlencoded'
    And Set Header 'Authorization' with value as 'Basic b21uaWNvbXBvbmVudC4xLjAuMDpiNHM4cmdUeWc1NVhZTnVu'
    And Get access token using username and password
    Given Httpmethod is "POST" and Api endpoint is "/item-master/api/item-master/item/save"
    And Set base url "getdata(app_host)" to API
    And Set Header 'selectedLocation' with value as 'getdata(L2-ORG)'
    And Set Header 'selectedOrganization' with value as 'getdata(L2-ORG)'
    And Set Header 'selectedBusinessUnit' with value as 'getdata(BUID)'
    And Set bearer token 'var(access_token)' to API
    And Set Requestbody from file "DFNITEM02.json"
    And Generate ITEM ID 'getdata(ITEM_ID)' using timestamp and update request body
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Edit OrgProfile
    And Navigate to Item Template Page
    And Click "byBatchTRKItemTemplate" on "ItemTemplatePage" WaitForPageLoading
    And Click "byViewIonButton" on "FooterPanelPage" WaitForPageLoading
    And Store Item Template data to variable "BatchTRKItemTemplateData"
    And Navigate to Items Page
    And Search Item With variable "ITEM_ID"
    And Verify NoRecords found label displayed
    When API send "POST" request
    Then Verify the response code is "200"
    Then Verify the expected value 'getdata(Value)' equals in response using the jsonpath 'getdata(JsonPath)'
    And Click "byRefreshButton" on "RightNavigationBar" WaitForPageLoading
    Then Verify Item with variable "ITEM_ID"
    And Verify Attribute values for BatchTRK Item Template with variable "BatchTRKItemTemplateData"

  @APITesting
  Scenario: DFN-ITEM-03-Send a new Serial Tracked item via interface
    Given Httpmethod is "POST" and Api endpoint is "/oauth/token"
    And Set base url "getdata(auth_host)" to API
    And Set Header 'Content-Type' with value as 'application/x-www-form-urlencoded'
    And Set Header 'Authorization' with value as 'Basic b21uaWNvbXBvbmVudC4xLjAuMDpiNHM4cmdUeWc1NVhZTnVu'
    And Get access token using username and password
    Given Httpmethod is "POST" and Api endpoint is "/item-master/api/item-master/item/save"
    And Set base url "getdata(app_host)" to API
    And Set Header 'selectedLocation' with value as 'getdata(L2-ORG)'
    And Set Header 'selectedOrganization' with value as 'getdata(L2-ORG)'
    And Set Header 'selectedBusinessUnit' with value as 'getdata(BUID)'
    And Set bearer token 'var(access_token)' to API
    And Set Requestbody from file "DFNITEM03.json"
    And Generate ITEM ID 'getdata(ITEM_ID)' using timestamp and update request body
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Edit OrgProfile
    And Navigate to Item Template Page
    And Click "bySerialTRKItemTemplate" on "ItemTemplatePage" WaitForPageLoading
    And Click "byViewIonButton" on "FooterPanelPage" WaitForPageLoading
    And Store Item Template data to variable "SerialTRKItemTemplateData"
    And Navigate to Items Page
    And Search Item With variable "ITEM_ID"
    And Verify NoRecords found label displayed
    When API send "POST" request
    Then Verify the response code is "200"
    Then Verify the expected value 'getdata(Value)' equals in response using the jsonpath 'getdata(JsonPath)'
    And Click "byRefreshButton" on "RightNavigationBar" WaitForPageLoading
    Then Verify Item with variable "ITEM_ID"
    And Verify Attribute values for SerialTRK Item Template with variable "SerialTRKItemTemplateData"

  @APITesting
  Scenario: DFN-ORDER-PR-01-Configure a standard order profile (header) and test
    Given Httpmethod is "POST" and Api endpoint is "/oauth/token"
    And Set base url "getdata(auth_host)" to API
    And Set Header 'Content-Type' with value as 'application/x-www-form-urlencoded'
    And Set Header 'Authorization' with value as 'Basic b21uaWNvbXBvbmVudC4xLjAuMDpiNHM4cmdUeWc1NVhZTnVu'
    And Get access token using username and password
    Given Httpmethod is "POST" and Api endpoint is "/dcorder/api/dcorder/originalOrder/bulkImport"
    And Set base url "getdata(app_host)" to API
    And Set Header 'selectedLocation' with value as 'getdata(L2-ORG)'
    And Set Header 'selectedOrganization' with value as 'getdata(L2-ORG)'
    And Set Header 'selectedBusinessUnit' with value as 'getdata(BUID)'
    And Set bearer token 'var(access_token)' to API
    And Set Requestbody from file "DFNOrderPR01.json"
    And Generate Original order ID 'getdata(OriginalOrder_ID)' using timestamp and update request body
    And Update item in Json with respect to testdata 'getdata(Item_ID)'
    And Update Profile Org Details in Json
    Given Open the browser and launch the application
    And Login to WMS Manhattan via SSO Login
    And Edit OrgProfile
    And Navigate to Order Template Page
    And Click "byOriginalOrderHeader" on "OrderTemplatePage" WaitForPageLoading
    And Click "byViewIonButton" on "FooterPanelPage" WaitForPageLoading
    And Verify Order Template data and entity id and store to variable "OrderTemplate"
    And Store Order Template sample data  to variable "HeaderOrderTemplateData"
    And Navigate to Original Orders2
    And Search Order with variable "OriginalOrder_ID"
    And Verify NoRecords found label displayed
    When API send "POST" request
    Then Verify the response code is 'getdata(ResponceCode)'
    Then Verify the expected value 'getdata(Value)' equals in response using the jsonpath 'getdata(JsonPath)'
    And Click "byRefreshButton" on "RightNavigationBar" WaitForPageLoading
    Then Verify Order with variable "OriginalOrder_ID"
    And Verify Extended Attribute values for Original order header with variable "HeaderOrderTemplateData"

  @APITesting
  Scenario: DFN-ORDER-PR-02-Configure a standard order profile (line) and test
    Given Httpmethod is "POST" and Api endpoint is "/oauth/token"
    And Set base url "getdata(auth_host)" to API
    And Set Header 'Content-Type' with value as 'application/x-www-form-urlencoded'
    And Set Header 'Authorization' with value as 'Basic b21uaWNvbXBvbmVudC4xLjAuMDpiNHM4cmdUeWc1NVhZTnVu'
    And Get access token using username and password
    Given Httpmethod is "POST" and Api endpoint is "/dcorder/api/dcorder/originalOrder/bulkImport"
    And Set base url "getdata(app_host)" to API
    And Set Header 'selectedLocation' with value as 'getdata(L2-ORG)'
    And Set Header 'selectedOrganization' with value as 'getdata(L2-ORG)'
    And Set Header 'selectedBusinessUnit' with value as 'getdata(BUID)'
    And Set bearer token 'var(access_token)' to API
    And Set Requestbody from file "DFNOrderPR02.json"
    And Generate Original order ID 'getdata(OriginalOrder_ID)' using timestamp and update request body
    And Update item in Json with respect to testdata 'getdata(Item_ID)'
    And Update Profile Org Details in Json
    Given Open the browser and launch the application
    And Login to WMS Manhattan via SSO Login
#    And Login to WMS Manhattan
    And Edit OrgProfile
    And Navigate to Order Template Page
    And Click "byOriginalOrderLine" on "OrderTemplatePage" WaitForPageLoading
    And Click "byViewIonButton" on "FooterPanelPage" WaitForPageLoading
    And Verify Order Template data and entity id and store to variable "OrderTemplate"
    And Store Order Template sample data  to variable "LineOrderTemplateData"
    And Navigate to Original Orders2
    And Search Order with variable "OriginalOrder_ID"
    And Verify NoRecords found label displayed
    When API send "POST" request
    Then Verify the response code is "500"
    Then Verify the expected value 'getdata(Value)' equals in response using the jsonpath 'getdata(JsonPath)'
    And Click "byRefreshButton" on "RightNavigationBar" WaitForPageLoading
    Then Verify Order with variable "OriginalOrder_ID"
    And Verify Extended Attribute values are empty in Original order popup
    And Navigate to OrderLines Page
    And Search Order with variable "OriginalOrder_ID"
    And Verify OrderLineNeed and OrderLineAttributes for order with order template json "LineOrderTemplateData"
    And Validate Order line data with Json "DFNOrderPR02.json"


  @APITesting
  Scenario: DFN-API-ORDER-UPDATE-01-Send an order with API with 2 or more lines Once order is in, remove one line and resend the order
    Given Httpmethod is "POST" and Api endpoint is "/oauth/token"
    And Set base url "getdata(auth_host)" to API
    And Set Header 'Content-Type' with value as 'application/x-www-form-urlencoded'
    And Set Header 'Authorization' with value as 'Basic b21uaWNvbXBvbmVudC4xLjAuMDpiNHM4cmdUeWc1NVhZTnVu'
    And Get access token using username and password
    Given Httpmethod is "POST" and Api endpoint is "/dcorder/api/dcorder/originalOrder/bulkImport"
    And Set base url "getdata(app_host)" to API
    And Set Header 'selectedLocation' with value as 'getdata(L2-ORG)'
    And Set Header 'selectedOrganization' with value as 'getdata(L2-ORG)'
    And Set Header 'selectedBusinessUnit' with value as 'getdata(BUID)'
    And Set bearer token 'var(access_token)' to API
    And Set Requestbody from file "DFN-API-ORDER-UPDATE-01_InitialUpload.json"
    And Generate Original order ID 'getdata(OriginalOrder_ID)' using timestamp and update request body
    And Update Profile Org Details in Json
    Given Open the browser and launch the application    
    And Login to WMS Manhattan
    And Edit OrgProfile
    And Navigate to Original Orders2
    And Search Order with variable "OriginalOrder_ID"
    And Verify NoRecords found label displayed
    When API send "POST" request
    Then Verify the response code is "500"
    Then Verify the expected value 'getdata(Value)' equals in response using the jsonpath 'getdata(JsonPath)'
    And Click "byRefreshButton" on "RightNavigationBar" WaitForPageLoading
    Then Verify Order with variable "OriginalOrder_ID"
    And Click on Row At First Index
    And Click "byRelatedLinks" on "OrdersPage"
    And Wait for page loading
    And Click "byOrderLines" on "OrdersPage"
    And Wait for page loading
    And Validate Ordered Quantity in Second Line Order with data in Json "DFN-API-ORDER-UPDATE-01_InitialUpload.json"
        ##Update the Orderes Qty with RESET for Second Order Line
    And Set Requestbody from file "DFN-API-ORDER-UPDATE-01_Update.json"
    And Update Request Body with Original Order Id with variable "OriginalOrder_ID"
    And Update Profile Org Details in Json
    When API send "POST" request
    Then Verify the response code is "500"
    Then Verify the expected value 'getdata(Value)' equals in response using the jsonpath 'getdata(JsonPath)'
    And Navigate to Original Orders2
    And Click on ClearAll button
    And Search Order with variable "OriginalOrder_ID"
    And Click on Row At First Index
    And Click "byRelatedLinks" on "OrdersPage"
    And Wait for page loading
    And Click "byOrderLines" on "OrdersPage"
    And Wait for page loading
    And Validate Updated Ordered Quantity with RESET ACTION on Second OrderLine with data in Json "DFN-API-ORDER-UPDATE-01_Update.json"

  @APITesting
  Scenario: DFN-API-ASN-01 - API Modify ASN - Load an ASN with two items via API then update it to remove one ASN Line
    Given Httpmethod is "POST" and Api endpoint is "/oauth/token"
    And Set base url "getdata(auth_host)" to API
    And Set Header 'Content-Type' with value as 'application/x-www-form-urlencoded'
    And Set Header 'Authorization' with value as 'Basic b21uaWNvbXBvbmVudC4xLjAuMDpiNHM4cmdUeWc1NVhZTnVu'
    And Get access token using username and password
    Given Httpmethod is "POST" and Api endpoint is "/receiving/api/receiving/asn/bulkImport"
    And Set base url "getdata(app_host)" to API
    And Set Header 'selectedLocation' with value as 'getdata(L2-ORG)'
    And Set Header 'selectedOrganization' with value as 'getdata(L2-ORG)'
    And Set Header 'selectedBusinessUnit' with value as 'getdata(BUID)'
    And Set bearer token 'var(access_token)' to API
    And Set Requestbody from file "DFN-API-ASN-01-0002InitialASNUpload.json"
    And Generate ASN ID 'getdata(ASN_ID)' using timestamp and update request body
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Edit OrgProfile
    And Navigate to ASNs
    And Search ASN With variable "ASN_ID"
    Then Verify NoRecords found label displayed
    When API send "POST" request
    Then Verify the response code is "500"
    Then Verify the expected value 'getdata(Value)' equals in response using the jsonpath 'getdata(JsonPath)'
    And Click "byRefreshButton" on "RightNavigationBar" WaitForPageLoading
    And Click on Row At First Index
    Then Validate ASN status "In Transit"
    And Navigate To ASN Details Page
    Then Verify ASNID and ShippedQuantity for multiple ASNs with File "DFN-API-ASN-01-0002InitialASNUpload.json" and Variable "ASN_ID"
    And Navigate to ASNs
    Given Httpmethod is "POST" and Api endpoint is "/oauth/token"
    And Set base url "getdata(auth_host)" to API
    And Set Header 'Content-Type' with value as 'application/x-www-form-urlencoded'
    And Set Header 'Authorization' with value as 'Basic b21uaWNvbXBvbmVudC4xLjAuMDpiNHM4cmdUeWc1NVhZTnVu'
    And Get access token using username and password
    Given Httpmethod is "POST" and Api endpoint is "/receiving/api/receiving/asn/bulkImport"
    And Set base url "getdata(app_host)" to API
    And Set Header 'selectedLocation' with value as 'getdata(L2-ORG)'
    And Set Header 'selectedOrganization' with value as 'getdata(L2-ORG)'
    And Set Header 'selectedBusinessUnit' with value as 'getdata(BUID)'
    And Set bearer token 'var(access_token)' to API
    And Set Requestbody from file "DFN-API-ASN-01-0002UpdateASNUpload.json"
    And Update ASN ID With Variable "ASN_ID" in request body
    When API send "POST" request
    Then Verify the response code is "500"
    Then Verify the expected value 'getdata(Value)' equals in response using the jsonpath 'getdata(JsonPath)'
    And Click "byRefreshButton" on "RightNavigationBar" WaitForPageLoading
    And Search ASN With variable "ASN_ID"
    And Click on Row At First Index
    Then Validate ASN status "In Transit"
    And Navigate To ASN Details Page
    And Click on Row At First Index
    Then Validate ASN data with Json "DFN-API-ASN-01-0002UpdateASNUpload.json"

  @APITesting
  Scenario: DFN-ORDER-PR-03- Configure a standard order profile (notes) and test
    Given Httpmethod is "POST" and Api endpoint is "/oauth/token"
    And Set base url "getdata(auth_host)" to API
    And Set Header 'Content-Type' with value as 'application/x-www-form-urlencoded'
    And Set Header 'Authorization' with value as 'Basic b21uaWNvbXBvbmVudC4xLjAuMDpiNHM4cmdUeWc1NVhZTnVu'
    And Get access token using username and password
    Given Httpmethod is "POST" and Api endpoint is "/dcorder/api/dcorder/originalOrder/bulkImport"
    And Set base url "getdata(app_host)" to API
    And Set Header 'selectedLocation' with value as 'getdata(L2-ORG)'
    And Set Header 'selectedOrganization' with value as 'getdata(L2-ORG)'
    And Set Header 'selectedBusinessUnit' with value as 'getdata(BUID)'
    And Set bearer token 'var(access_token)' to API
    And Set Requestbody from file "DFNOrderPR03.json"
    And Generate Original order ID 'getdata(OriginalOrder_ID)' using timestamp and update request body
    And Update item in Json with respect to testdata 'getdata(Item_ID)'
    And Update Profile Org Details in Json
    Given Open the browser and launch the application
    And Login to WMS Manhattan via SSO Login
    And Edit OrgProfile
    And Navigate to Order Template Page
    And Click "byATOOTSNote" on "OrderTemplatePage" WaitForPageLoading
    And Click "byViewIonButton" on "FooterPanelPage" WaitForPageLoading
    And Verify Order Template data and entity id and store to variable "TSNoteOrderTemplate"
    And Store Order Template sample data  to variable "ATOOTSNoteTemplateData"
    And Click "byRefreshButton" on "RightNavigationBar" WaitForPageLoading
    And Click "byATOOUCNote" on "OrderTemplatePage" WaitForPageLoading
    And Click "byViewIonButton" on "FooterPanelPage" WaitForPageLoading
    And Verify Order Template data and entity id and store to variable "UCNoteOrderTemplate"
    And Store Order Template sample data  to variable "ATOOUCNoteTemplateData"
    And Navigate to Original Orders2
    And Search Order with variable "OriginalOrder_ID"
    And Verify NoRecords found label displayed
    When API send "POST" request
    Then Verify the response code is "500"
    Then Verify the expected value 'getdata(Value)' equals in response using the jsonpath 'getdata(JsonPath)'
    And Click "byRefreshButton" on "RightNavigationBar" WaitForPageLoading
    Then Verify Order with variable "OriginalOrder_ID"
    And Verify Extended Attribute values are empty in Original order popup
    And Verify order notes data with order notes templates with variable "ATOOTSNoteTemplateData" "ATOOUCNoteTemplateData"
    And Navigate to OrderLines Page
    And Search Order with variable "OriginalOrder_ID"
    And Click on Row At First Index
    And Verify order lines note data with order notes templates with variable "ATOOTSNoteTemplateData" "ATOOUCNoteTemplateData"
    And Click order line header in order line popup
    And Validate Order line data with Json "DFNOrderPR03.json"