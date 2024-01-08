@DFNGoldenFlow
Feature: Golden_Flow_Test_Cases

##List of Test Cases
## TC    TS No.	Test Case Name
## 001.  1 	 		ITS-RCV-01 - Create PO via EDI
## 002.  1	 		DFN-RECEIVING-02 - PO ASN Receiving (ITS-RCV-02)
## 003.  1			FN-PUTAWAY-01 Undirected Putaway (ITS-PUTAWAY-01)
## 004.  1			FN-PUTAWAY-04 System Directed Putaway (ITS-PUTAWAY-02)
## 005.  2			DFN-RECEIVING-03 - Standard ASN receiving duplicated lines (ITS-RCV-03)
## 006.  3			DFN-RECEIVING-06 - Standard ASN receiving with serial numbers E2E (ITS-RCV-05 )
## 007.  4			DFN-ADJ-01 - Quantity Adjustment Positive iLPN (ITS-INV-02)
## 008.  5			DFN-ADJ-02 - Quantity Adjustment Negative iLPN (ITS-INV-03)
## 009.  6			DFN-ADJ-03 - Quantity Adjustment Positive Pick Location no iLPN (ITS-INV-04)
## 010.  7			DFN-ADJ-04 - Quantity Adjustment Negative Pick Location no iLPN (ITS-INV-05)
## 011.  8			DFN-RECEIVING-01 - Blind receiving (ITS-RCV-06)
## 012.  9			DFN-ORDEXP-01 - Export Original Order (ITS-ORDER-02)
## 013.  9			ITS-ORDER-03 - Import a new Original Order
## 014.  9			FN-ALLOC-01 - Run Wave (ITS-ALLOC-01)
## 015.  9			FN-PICKING-01 - Test Picking Single Order Tote (ITS-PICK-PACK-01)
## 016.  10			DFN-INVENTORY-02 - Move iLPN out of location (ITS-INV-01)
## 017.  11			ITS-RCV-04 - Standard ASN Receiving - Test Validation
## 018.  12			FN-COUNTS-01 - Count correct no deviation (ITS-INV-07)

# 1. DFN - RECEIVING and PUTAWAY - ASN Receiving - Directed and Undirected Putaway
# Jira Id - MAWMTF01-10 : Sub Task ID - MAWMTF01-20, MAWMTF01-3, MAWMTF01-4, MAWMTF01-2
# Test cases covered : 4
  @CreatePORecieveASN&Putaway @Receiving
   Scenario: DFN-RECEIVING and PUTAWAY - ASN Receiving - Directed and Undirected Putaway
  # ITS-RCV-01 - Create PO via EDI
	    Given Httpmethod is "POST" and Api endpoint is "/oauth/token"
	    And Set base url "getdata(auth_host)" to API
	    And Set Header 'Content-Type' with value as 'application/x-www-form-urlencoded'
	    And Set Header 'Authorization' with value as 'Basic b21uaWNvbXBvbmVudC4xLjAuMDpiNHM4cmdUeWc1NVhZTnVu'
	    And Get access token using username and password
	    Given Httpmethod is "POST" and Api endpoint is "/receiving/api/receiving/purchaseOrder/save"
	    And Set base url "getdata(app_host)" to API
	    And Set Header 'selectedLocation' with value as 'getdata(L2-ORG)'
	    And Set Header 'selectedOrganization' with value as 'getdata(L2-ORG)'
	    And Set Header 'selectedBusinessUnit' with value as 'getdata(BUID)'
	    And Set bearer token 'var(access_token)' to API
	    And Set Requestbody from file "CreatePO.json"
	    And Generate PO ID 'getdata(PO_ID)' using timestamp and update request body
	    And Update Request body using table as key value pair
	      | key                      | value                              |
	      | {L2-ORG}                 | getdata(L2-ORG)                    |
	      | {LineID_L1}              | getdata(LineID_Line1)              |
	      | {ItemID_L1}              | getdata(ItemID_Line1)              |
	      | {OrdQty_L1}              | getdata(OrdQty_Line1)              |	         
	      | {InventoryTypeId_L1}     | getdata(InventoryTypeId_Line1)     |
	      | {ProductStatusId_L1}     | getdata(ProductStatusId_Line1)     |
	      | {BatchNumber_L1}         | getdata(BatchNo_Line1)             |
	      | {InventoryAttribute1_L1} | getdata(InventoryAttribute1_Line1) |
	      | {InventoryAttribute2_L1} | getdata(InventoryAttribute2_Line1) |
	      | {InventoryAttribute3_L1} | getdata(InventoryAttribute3_Line1) |
	      | {InventoryAttribute4_L1} | getdata(InventoryAttribute4_Line1) |
	      | {InventoryAttribute5_L1} | getdata(InventoryAttribute5_Line1) |
	      | {CountryOfOrigin_L1}     | getdata(CountryOfOrigin_Line1)     |	      
	    And Store test data of Create PO API into Runtime Variables
	    When API send "POST" request
	    Then Verify the response code is "200"
	    Given Open the browser and launch the application
	    And Login to WMS Manhattan
	    And Edit OrgProfile
      ##And Update Business Unit 'getdata(BUID)'
	    And Navigate to Purchase Orders
	    And Search Purchase Order 
	    And Click "byRelatedLinks" on "PurchaseOrders"
	    And Click "byPurchaseOrderLine" on "PurchaseOrders"
#	    And Verify Purchase Order Lines 
	# DFN-RECEIVING-02_PO ASN Receiving (ITS-RCV-02)
	    And Navigate to ASNs
	    And Click "byCreateASNFromPO" on "ASNs"
	    And Verify "Create ASN Pop-up" element "byCreateASNFromPOScreen" exist on "ASNs"
	    And Enter Details at Create ASN Pop-up
	    And Search PO at Purchase Order Line Lookup screen
	    And Select checkbox "byPOlineCheckbox" on "PurchaseOrderLineLookup"
	    And Wait for page loading
	    And Click "byAddtoasnBtn" on "PurchaseOrderLineLookup"
	    And Click "byOkBtn" on "PurchaseOrderLineLookup"
	    And Wait for page loading
	    And Store ASN number in runtime variable
	    And Click "bysaveandfinishBtn" on "PurchaseOrderLineLookup"
	    And Wait for page loading
	    And Search ASN at ASNs
	    And Validate ASN status "In Transit"
	    And Navigate to WM Mobile
	    And Update ORG Profile in WM Mobile
	    And Search menu 'AT Standard Receiving' at WM Mobile
	    And Complete ATStandardReceiving and Validate Quantity exceeds error 
	    And Navigate to ASNs
	    And Search ASN at ASNs
	    And Validate ASN status "In Receiving"
	    And Verify receiving ASN
	    And Wait for page loading
	    And Search ASN at ASNs
	    And Validate ASN status "Verified"
	# FN-PUTAWAY-01_Undirected Putaway (ITS-PUTAWAY-01)
	    And Navigate to WM Mobile
	    And Update ORG Profile in WM Mobile 
	    And Search menu 'AT User Directed Putaway' at WM Mobile
	    And Putaway LPN User Directed
	    And Close browser window And Switch to Last Window
	    And Verify Inventry updated	    
	# FN-PUTAWAY-04_System Directed Putaway (ITS-PUTAWAY-02)  
	    And Navigate to WM Mobile
	    And Update ORG Profile in WM Mobile
	    And Search menu 'AT System Directed Putaway' at WM Mobile
	    And Putaway LPN System Directed	  
	    And Close browser window And Switch to Last Window	    
	    And Verify Inventry updated
    
# 2. DFN-RECEIVING 03 Standard ASN receiving duplicated lines
# Jira Id - MAWMTF01-12 
# Test cases covered : 1 
  @CreatePORecieveASN @Receiving
   Scenario: DFN-RECEIVING 03 Standard ASN receiving duplicated lines
  # Create 2 line Purchase Order via API
	    Given Httpmethod is "POST" and Api endpoint is "/oauth/token"
	    And Set base url "getdata(auth_host)" to API
	    And Set Header 'Content-Type' with value as 'application/x-www-form-urlencoded'
	    And Set Header 'Authorization' with value as 'Basic b21uaWNvbXBvbmVudC4xLjAuMDpiNHM4cmdUeWc1NVhZTnVu'
	    And Get access token using username and password
	    Given Httpmethod is "POST" and Api endpoint is "/receiving/api/receiving/purchaseOrder/save"
	    And Set base url "getdata(app_host)" to API
	    And Set Header 'selectedLocation' with value as 'getdata(L2-ORG)'
	    And Set Header 'selectedOrganization' with value as 'getdata(L2-ORG)'
	    And Set Header 'selectedBusinessUnit' with value as 'getdata(BUID)'
	    And Set bearer token 'var(access_token)' to API
	    And Set Requestbody from file "CreatePO2Line.json"
	    And Generate PO ID 'getdata(PO_ID)' using timestamp and update request body
	    And Update Request body using table as key value pair
	      | key                      | value                              |
	      | {L2-ORG}                 | getdata(L2-ORG)                    |
	      | {LineID_L1}              | getdata(LineID_Line1)              |
	      | {ItemID_L1}              | getdata(ItemID_Line1)              |
	      | {OrdQty_L1}              | getdata(OrdQty_Line1)              |
	      | {QuantityUomId_L1}       | getdata(QuantityUomId_Line1)       |
	      | {StandardPackQuantity_L1}| getdata(StandardPackQuantity_Line1)|		      	                
	      | {InventoryTypeId_L1}     | getdata(InventoryTypeId_Line1)     |
	      | {ProductStatusId_L1}     | getdata(ProductStatusId_Line1)     |
	      | {BatchNumber_L1}         | getdata(BatchNo_Line1)             |
	      | {InventoryAttribute1_L1} | getdata(InventoryAttribute1_Line1) |
	      | {InventoryAttribute2_L1} | getdata(InventoryAttribute2_Line1) |
	      | {InventoryAttribute3_L1} | getdata(InventoryAttribute3_Line1) |
	      | {InventoryAttribute4_L1} | getdata(InventoryAttribute4_Line1) |
	      | {InventoryAttribute5_L1} | getdata(InventoryAttribute5_Line1) |
	      | {CountryOfOrigin_L1}     | getdata(CountryOfOrigin_Line1)     |	    
	      | {LineID_L2}              | getdata(LineID_Line2)              |
	      | {ItemID_L2}              | getdata(ItemID_Line2)              |
	      | {OrdQty_L2}              | getdata(OrdQty_Line2)              |	
	      | {QuantityUomId_L2}       | getdata(QuantityUomId_Line2)       |
	      | {StandardPackQuantity_L2}| getdata(StandardPackQuantity_Line2)|	      	                
	      | {InventoryTypeId_L2}     | getdata(InventoryTypeId_Line2)     |
	      | {ProductStatusId_L2}     | getdata(ProductStatusId_Line2)     |
	      | {BatchNumber_L2}         | getdata(BatchNo_Line2)             |
	      | {InventoryAttribute1_L2} | getdata(InventoryAttribute1_Line2) |
	      | {InventoryAttribute2_L2} | getdata(InventoryAttribute2_Line2) |
	      | {InventoryAttribute3_L2} | getdata(InventoryAttribute3_Line2) |
	      | {InventoryAttribute4_L2} | getdata(InventoryAttribute4_Line2) |
	      | {InventoryAttribute5_L2} | getdata(InventoryAttribute5_Line2) |
	      | {CountryOfOrigin_L2}     | getdata(CountryOfOrigin_Line2)     |	   
	    And Store test data of Create PO API into Runtime Variables
	    When API send "POST" request
	    Then Verify the response code is "200"
	# Verifying the Purchase Order created 
	    Given Open the browser and launch the application
	    And Login to WMS Manhattan
	    And Edit OrgProfile
	    And Navigate to Purchase Orders
	    And Search Purchase Order 
	    And Click "byRelatedLinks" on "PurchaseOrders"
	    And Click "byPurchaseOrderLine" on "PurchaseOrders"
#	    And Verify Purchase Order Lines 
#	# RECEIVING 03 Standard ASN receiving duplicated lines 
	    And Navigate to ASNs
	    And Click "byCreateASNFromPO" on "ASNs"
	    And Verify "Create ASN Pop-up" element "byCreateASNFromPOScreen" exist on "ASNs"
	    And Enter Details at Create ASN Pop-up
	    And Search PO at Purchase Order Line Lookup screen
	    And Select checkbox "byPOlineCheckbox" on "PurchaseOrderLineLookup"
	    And Wait for page loading
	    And Click "byAddtoasnBtn" on "PurchaseOrderLineLookup"
	    And Click "byOkBtn" on "PurchaseOrderLineLookup"
	    And Wait for page loading
	    And Store ASN number in runtime variable
	    And Click "bysaveandfinishBtn" on "PurchaseOrderLineLookup"
	    And Wait for page loading
	    And Search ASN at ASNs
	    And Validate ASN status "In Transit"
	    And Navigate to WM Mobile
	    And Update ORG Profile in WM Mobile
	    And Search menu 'AT Standard Receiving' at WM Mobile
      And Complete ATStandardReceiving duplicate lines 
      And Click "byVerifyASNButton" on "UserDirected"
      And Validate popup message "Verification request has been submitted for ASN"   
      And Close browser window And Switch to Last Window
      And Navigate to ASNs	  
	    And Wait for page loading
	    And Search ASN at ASNs
	    And Validate ASN status "Verified"    
	    
# 3. DFN-RECEIVING 06 Standard ASN receiving with serial numbers E2Es
# Jira Id - MAWMTF01-13 
# Test cases covered : 1
  @CreatePORecieveASNSerial&Putaway @Receiving  
  Scenario: DFN-RECEIVING 06 Standard ASN receiving with serial numbers E2E
  # Create Purchase Order via API
	    Given Httpmethod is "POST" and Api endpoint is "/oauth/token"
	    And Set base url "getdata(auth_host)" to API
	    And Set Header 'Content-Type' with value as 'application/x-www-form-urlencoded'
	    And Set Header 'Authorization' with value as 'Basic b21uaWNvbXBvbmVudC4xLjAuMDpiNHM4cmdUeWc1NVhZTnVu'
	    And Get access token using username and password
	    Given Httpmethod is "POST" and Api endpoint is "/receiving/api/receiving/purchaseOrder/save"
	    And Set base url "getdata(app_host)" to API
	    And Set Header 'selectedLocation' with value as 'getdata(L2-ORG)'
	    And Set Header 'selectedOrganization' with value as 'getdata(L2-ORG)'
	    And Set Header 'selectedBusinessUnit' with value as 'getdata(BUID)'
	    And Set bearer token 'var(access_token)' to API
	    And Set Requestbody from file "CreatePO.json"
	    And Generate PO ID 'getdata(PO_ID)' using timestamp and update request body
	    And Update Request body using table as key value pair
	      | key                      | value                              |
	      | {L2-ORG}                 | getdata(L2-ORG)                    |
	      | {LineID_L1}              | getdata(LineID_Line1)              |
	      | {ItemID_L1}              | getdata(ItemID_Line1)              |
	      | {OrdQty_L1}              | getdata(OrdQty_Line1)              |	      	            
	      | {InventoryTypeId_L1}     | getdata(InventoryTypeId_Line1)     |
	      | {ProductStatusId_L1}     | getdata(ProductStatusId_Line1)     |
	      | {BatchNumber_L1}         | getdata(BatchNo_Line1)             |
	      | {InventoryAttribute1_L1} | getdata(InventoryAttribute1_Line1) |
	      | {InventoryAttribute2_L1} | getdata(InventoryAttribute2_Line1) |
	      | {InventoryAttribute3_L1} | getdata(InventoryAttribute3_Line1) |
	      | {InventoryAttribute4_L1} | getdata(InventoryAttribute4_Line1) |
	      | {InventoryAttribute5_L1} | getdata(InventoryAttribute5_Line1) |
	      | {CountryOfOrigin_L1}     | getdata(CountryOfOrigin_Line1)     |	      
	    And Store test data of Create PO API into Runtime Variables
	    When API send "POST" request
	    Then Verify the response code is "200"
#	# Verifying the Purchase Order created 
	    Given Open the browser and launch the application
	    And Login to WMS Manhattan
	    And Edit OrgProfile
	    And Navigate to Purchase Orders
	    And Search Purchase Order 	  
	    And Click "byRelatedLinks" on "PurchaseOrders"
	    And Click "byPurchaseOrderLine" on "PurchaseOrders"
#	    And Verify Purchase Order Lines 
#	# DFN-RECEIVING-06 Standard ASN receiving with serial numbers E2E
	    And Navigate to ASNs
	    And Click "byCreateASNFromPO" on "ASNs"
	    And Verify "Create ASN Pop-up" element "byCreateASNFromPOScreen" exist on "ASNs"
	    And Enter Details at Create ASN Pop-up
	    And Search PO at Purchase Order Line Lookup screen
	    And Select checkbox "byPOlineCheckbox" on "PurchaseOrderLineLookup"
	    And Wait for page loading
	    And Click "byAddtoasnBtn" on "PurchaseOrderLineLookup"
	    And Click "byOkBtn" on "PurchaseOrderLineLookup"
	    And Wait for page loading
	    And Store ASN number in runtime variable
	    And Click "bysaveandfinishBtn" on "PurchaseOrderLineLookup"
	    And Wait for page loading
	    And Search ASN at ASNs
	    And Validate ASN status "In Transit"
	    And Navigate to WM Mobile
	    And Update ORG Profile in WM Mobile
	    And Search menu 'AT Standard Receiving' at WM Mobile
	    And Complete ATStandardReceiving With Serial Number 
	    And Click "byVerifyASNButton" on "UserDirected"
      And Validate popup message "Verification request has been submitted for ASN"   
      And Close browser window And Switch to Last Window
      And Navigate to ASNs	  
	    And Wait for page loading
	    And Search ASN at ASNs
	    And Validate ASN status "Verified"
	# System Directed Putaway 
	    And Navigate to WM Mobile
	    And Update ORG Profile in WM Mobile
	    And Search menu 'AT System Directed Putaway' at WM Mobile
	    And Putaway LPN System Directed	  	    
	    And Close browser window And Switch to Last Window	
	    And Verify Inventry updated


# 4. DFN-RECEIVING 01 - Blind receiving
# Jira Id - MAWMTF01-17 
# Test cases covered : 1
  @BlindReceiving @Receiving  
  Scenario: DFN-RECEIVING 01 - Blind receiving
      Given Open the browser and launch the application
      And Login to WMS Manhattan
	    And Edit OrgProfile
	    And Navigate to WM Mobile
	    And Update ORG Profile in WM Mobile
	    And Search menu 'AT BlindReceiving' at WM Mobile
	    And Complete AT BlindReceiving
	    And Click "byVerifyASNButton" on "UserDirected"
	    And Verify Blind receiving
	    And Navigate to ASNs
	    And Search ASN at ASNs
	    And Validate ASN status "In Receiving"
	    And Verify receiving ASN
	    And Verify variance and Accept
	    And Wait for page loading
	    And Search ASN at ASNs
	    And Validate ASN status "Verified"
    
	    
# 5. DFN-ADJ 01 Quantity Adjustment Positive iLPN
# Jira Id - MAWMTF01-9 
# Test cases covered : 1
  @PositiveQtyAdj @Inv  
  Scenario: DFN-ADJ 01 Quantity Adjustment Positive iLPN
# Pre-Req step - Create PO via EDI
	    Given Httpmethod is "POST" and Api endpoint is "/oauth/token"
	    And Set base url "getdata(auth_host)" to API
	    And Set Header 'Content-Type' with value as 'application/x-www-form-urlencoded'
	    And Set Header 'Authorization' with value as 'Basic b21uaWNvbXBvbmVudC4xLjAuMDpiNHM4cmdUeWc1NVhZTnVu'
	    And Get access token using username and password
	    Given Httpmethod is "POST" and Api endpoint is "/receiving/api/receiving/purchaseOrder/save"
	    And Set base url "getdata(app_host)" to API
	    And Set Header 'selectedLocation' with value as 'getdata(L2-ORG)'
	    And Set Header 'selectedOrganization' with value as 'getdata(L2-ORG)'
	    And Set Header 'selectedBusinessUnit' with value as 'getdata(BUID)'
	    And Set bearer token 'var(access_token)' to API
	    And Set Requestbody from file "CreatePO.json"
	    And Generate PO ID 'getdata(PO_ID)' using timestamp and update request body
	    And Update Request body using table as key value pair
	      | key                      | value                              |
	      | {L2-ORG}                 | getdata(L2-ORG)                    |
	      | {LineID_L1}              | getdata(LineID_Line1)              |
	      | {ItemID_L1}              | getdata(ItemID_Line1)              |
	      | {OrdQty_L1}              | getdata(OrdQty_Line1)              |	         
	      | {InventoryTypeId_L1}     | getdata(InventoryTypeId_Line1)     |
	      | {ProductStatusId_L1}     | getdata(ProductStatusId_Line1)     |
	      | {BatchNumber_L1}         | getdata(BatchNo_Line1)             |
	      | {InventoryAttribute1_L1} | getdata(InventoryAttribute1_Line1) |
	      | {InventoryAttribute2_L1} | getdata(InventoryAttribute2_Line1) |
	      | {InventoryAttribute3_L1} | getdata(InventoryAttribute3_Line1) |
	      | {InventoryAttribute4_L1} | getdata(InventoryAttribute4_Line1) |
	      | {InventoryAttribute5_L1} | getdata(InventoryAttribute5_Line1) |
	      | {CountryOfOrigin_L1}     | getdata(CountryOfOrigin_Line1)     |	      
	    And Store test data of Create PO API into Runtime Variables
	    When API send "POST" request
	    Then Verify the response code is "200"	
	    Given Open the browser and launch the application
	    And Login to WMS Manhattan
	    And Edit OrgProfile
	    And Navigate to Purchase Orders
	    And Search Purchase Order  
	    And Click "byRelatedLinks" on "PurchaseOrders"
	    And Click "byPurchaseOrderLine" on "PurchaseOrders"
	# Pre-Req step - PO ASN Receiving
	    And Navigate to ASNs
	    And Click "byCreateASNFromPO" on "ASNs"
	    And Verify "Create ASN Pop-up" element "byCreateASNFromPOScreen" exist on "ASNs"
	    And Enter Details at Create ASN Pop-up
	    And Search PO at Purchase Order Line Lookup screen
	    And Select checkbox "byPOlineCheckbox" on "PurchaseOrderLineLookup"
	    And Wait for page loading
	    And Click "byAddtoasnBtn" on "PurchaseOrderLineLookup"
	    And Click "byOkBtn" on "PurchaseOrderLineLookup"
	    And Wait for page loading
	    And Store ASN number in runtime variable
	    And Click "bysaveandfinishBtn" on "PurchaseOrderLineLookup"
	    And Wait for page loading
	    And Search ASN at ASNs
	    And Validate ASN status "In Transit"
	    And Navigate to WM Mobile
	    And Update ORG Profile in WM Mobile
	    And Search menu 'AT Standard Receiving' at WM Mobile
	    And Complete ATStandardReceiving 
	    And Click "byVerifyASNButton" on "UserDirected"
      And Validate popup message "Verification request has been submitted for ASN"   
      And Close browser window And Switch to Last Window
      And Navigate to ASNs	  
	    And Wait for page loading
	    And Search ASN at ASNs
	    And Validate ASN status "Verified"
#	    DFN-ADJ-01 - Quantity Adjustment Positive iLPN
	    And Navigate to WM Mobile
	    And Update ORG Profile in WM Mobile
	    And Search menu 'FN Modify iLPN' at WM Mobile
	    And Positive Quantity Adjustment
	    And Wait for page loading
	    And Navigate to ILPNs
	    And Validate Quantity Adjustment
  
# 6. DFN-ADJ 02 Quantity Adjustment Negative iLPN
# Jira Id - MAWMTF01-11 
# Test cases covered : 1
  @BNegativeQtyAdj @Inv  
  Scenario: DFN-ADJ 02 Quantity Adjustment Negative iLPN
  # Pre-Req - Create PO via EDI
	    Given Httpmethod is "POST" and Api endpoint is "/oauth/token"
	    And Set base url "getdata(auth_host)" to API
	    And Set Header 'Content-Type' with value as 'application/x-www-form-urlencoded'
	    And Set Header 'Authorization' with value as 'Basic b21uaWNvbXBvbmVudC4xLjAuMDpiNHM4cmdUeWc1NVhZTnVu'
	    And Get access token using username and password
	    Given Httpmethod is "POST" and Api endpoint is "/receiving/api/receiving/purchaseOrder/save"
	    And Set base url "getdata(app_host)" to API
	    And Set Header 'selectedLocation' with value as 'getdata(L2-ORG)'
	    And Set Header 'selectedOrganization' with value as 'getdata(L2-ORG)'
	    And Set Header 'selectedBusinessUnit' with value as 'getdata(BUID)'
	    And Set bearer token 'var(access_token)' to API
	    And Set Requestbody from file "CreatePO.json"
	    And Generate PO ID 'getdata(PO_ID)' using timestamp and update request body
	    And Update Request body using table as key value pair
	      | key                      | value                              |
	      | {L2-ORG}                 | getdata(L2-ORG)                    |
	      | {LineID_L1}              | getdata(LineID_Line1)              |
	      | {ItemID_L1}              | getdata(ItemID_Line1)              |
	      | {OrdQty_L1}              | getdata(OrdQty_Line1)              |	         
	      | {InventoryTypeId_L1}     | getdata(InventoryTypeId_Line1)     |
	      | {ProductStatusId_L1}     | getdata(ProductStatusId_Line1)     |
	      | {BatchNumber_L1}         | getdata(BatchNo_Line1)             |
	      | {InventoryAttribute1_L1} | getdata(InventoryAttribute1_Line1) |
	      | {InventoryAttribute2_L1} | getdata(InventoryAttribute2_Line1) |
	      | {InventoryAttribute3_L1} | getdata(InventoryAttribute3_Line1) |
	      | {InventoryAttribute4_L1} | getdata(InventoryAttribute4_Line1) |
	      | {InventoryAttribute5_L1} | getdata(InventoryAttribute5_Line1) |
	      | {CountryOfOrigin_L1}     | getdata(CountryOfOrigin_Line1)     |	      
	    And Store test data of Create PO API into Runtime Variables
	    When API send "POST" request
	    Then Verify the response code is "200"	
	    Given Open the browser and launch the application
	    And Login to WMS Manhattan
	    And Edit OrgProfile
	    And Navigate to Purchase Orders
	    And Search Purchase Order 
	    And Click "byRelatedLinks" on "PurchaseOrders"
	    And Click "byPurchaseOrderLine" on "PurchaseOrders"
	# Pre-Req - PO ASN Receiving 
	    And Navigate to ASNs
	    And Click "byCreateASNFromPO" on "ASNs"
	    And Verify "Create ASN Pop-up" element "byCreateASNFromPOScreen" exist on "ASNs"
	    And Enter Details at Create ASN Pop-up
	    And Search PO at Purchase Order Line Lookup screen
	    And Select checkbox "byPOlineCheckbox" on "PurchaseOrderLineLookup"
	    And Wait for page loading
	    And Click "byAddtoasnBtn" on "PurchaseOrderLineLookup"
	    And Click "byOkBtn" on "PurchaseOrderLineLookup"
	    And Wait for page loading
	    And Store ASN number in runtime variable
	    And Click "bysaveandfinishBtn" on "PurchaseOrderLineLookup"
	    And Wait for page loading
	    And Search ASN at ASNs
	    And Validate ASN status "In Transit"
	    And Navigate to WM Mobile
	    And Update ORG Profile in WM Mobile
	    And Search menu 'AT Standard Receiving' at WM Mobile
	    And Complete ATStandardReceiving 
	    And Click "byVerifyASNButton" on "UserDirected"
      And Validate popup message "Verification request has been submitted for ASN"  
      And Close browser window And Switch to Last Window
      And Navigate to ASNs	  
	    And Wait for page loading
	    And Search ASN at ASNs
	    And Validate ASN status "Verified"
	    And Navigate to WM Mobile
	    And Update ORG Profile in WM Mobile
	    And Search menu 'FN Modify iLPN' at WM Mobile
	    And Negative Quantity Adjustment
	    And Navigate to ILPNs
	    And Validate Quantity Adjustment
  
# 7. DFN-ADJ 03 Quantity Adjustment Positive Pick Location no iLPN
# Jira Id - MAWMTF01-18 
# Test cases covered : 1
  @PositivePickLocation @Inv  
  Scenario: DFN-ADJ 03 Quantity Adjustment Positive Pick Location no iLPN
      Given Open the browser and launch the application
      And Login to WMS Manhattan
	    And Edit OrgProfile
	    And Navigate to Location Inventory
	    And Search Display location at Location Inventory
	    And Select Storeage Location on Location Inventory
	    And Click "byRelatedLinks" on "LocationInventory"  
	    And Click "byInventoryDetails" on "LocationInventory"
	    And Select checkbox "byInventryDetailsCheckbox" on "LocationInventory"
	    And Positive Quantity Adjustment at Pick Location
	    And Navigate to Location Inventory
	    And Validate Positive Quantity Adjustment

# 8. DFN-ADJ 04 Quantity Adjustment Negative Pick Location no iLPN
# Jira Id - MAWMTF01-19 
# Test cases covered : 1
  @NegativePickLocation @Inv  
  Scenario: DFN-ADJ 04 Quantity Adjustment Negative Pick Location no iLPN
      Given Open the browser and launch the application
      And Login to WMS Manhattan
	    And Edit OrgProfile
	    And Navigate to Location Inventory
	    And Search Display location at Location Inventory
	    And Select Storeage Location on Location Inventory
	    And Click "byRelatedLinks" on "LocationInventory"  
	    And Click "byInventoryDetails" on "LocationInventory"
	    And Select checkbox "byInventryDetailsCheckbox" on "LocationInventory"
	    And Negative Quantity Adjustment at Pick Location
	    And Navigate to Location Inventory
	    And Validate Negative Quantity Adjustment
	    
# 9. DFN-Export_Import Original Order2_Runwave and Picking Single Order
# Jira Id - MAWMTF01-52 : Sub Task ID - MAWMTF01-5, MAWMTF01-6, MAWMTF01-7, MAWMTF01-8  
# Test cases covered : 4
  @ExportOriginalOrder @Order  
  Scenario: DFN-Export_Import Original Order2_Runwave and Picking Single Order
      Given Open the browser and launch the application
      And Login to WMS Manhattan
	    And Edit OrgProfile
##  ITS-ORDER-03 - Import a new Original Order 
	    And Update Original Order
	    And Navigate to Original Orders2	   
	    And Clear Notifications
	    And Click "byImportDataLoaderBtn" on "OriginalOrdersPage"  
	    And Import Data Loader "OriginalOrder.xlsx"
	    And Wait for page loading
	    And Verify notification message 'File OriginalOrder.xlsx from OriginalOrder is imported successfully.'
	    And Click "byRefreshBtn" on "OriginalOrdersPage"
	    And Verify Imported Orders
##  DFN-ORDEXP-01 - Export Original Order
	    And Clear Notifications
	    And Click "byExportDataLoaderBtn" on "OriginalOrdersPage" 
      And Wait for page loading
	    And Verify notification message 'File OriginalOrder.xlsx from OriginalOrder is exported successfully.'
##  FN-ALLOC-01 - Run Wave    
	    And Navigate to Orders
	    And Select Order for RunWave
	    And Validate Orders status "Released"	 
			And Execute RunWave
	    And Navigate to Wave Runs
	    And Search Wave run at Wave Runs
	    And Validate Wave run status till "Completed"	
	    And Navigate to Orders
	    And Search Order at Orders
	    And Validate Orders status "Allocated"	 
	    And Click "byRelatedLinks" on "OrdersPage" 
	    And Click "byOrderLines" on "OrdersPage" 
	    And Search Order at Orders
	    And Validate Orderslines status "ALLOCATED"	
##  FN-PICKING-01 - Test Picking Single Order Tote  	    
	    And Navigate to Orders
	    And Search Order at Orders
	    And Select First Order in Screen
		  And Click "byRelatedLinks" on "OrdersPage"
		  And Click "byTaskDetails" on "OrdersPage"
		  And Validate Task Details status "Created"
		  And Store oLPN number in runtime variable
		  And Navigate to WM Mobile
		  And Update ORG Profile in WM Mobile
		  And Search menu 'AT Pick to OLPN' at WM Mobile
		  And Complete AT Pick To oLPN
		  And Click "byRefreshBtn" on "OrdersPage"
		  And Validate Task Details status "Completed"
		  And Navigate to Orders
		  And Search Order at Orders
	    And Validate Orders status "Packed"
	    And Select First Packed Order in Screen
	    And Complete Ship Confirm
##	    And Validate Orders status "Shipped"
   
# 10. ITS-RCV-04-Standard ASN Receiving-Test Validation
# Jira Id - MAWMTF01-14 
# Test cases covered : 1
  @Receiving  
  Scenario: ITS-RCV-04-Standard ASN Receiving-Test Validation
      Given Open the browser and launch the application
      And Login to WMS Manhattan
	    And Edit OrgProfile
	    And Navigate to ASNs
	    And Update ASN without PO and valid Item "ITSRCV04.xlsx"
	    And Clear Notifications
	    And Click "byImportDataLoaderBtn" on "ASNs"
	    And Import Data Loader "ITSRCV04.xlsx"
	    And Wait for page loading
	    And Verify notification message 'File ITSRCV04.xlsx from Asn is imported successfully.'	  
	    And Search ASN at ASNs
	    And Navigate to WM Mobile
	    And Update ORG Profile in WM Mobile
	    And Search menu 'AT Standard Receiving' at WM Mobile
	    And Complete ATStandardReceiving with Invalid Item and Verify error message  
	  
# 11. FN-COUNTS 01 Count correct no deviation
# Jira Id - MAWMTF01-15 
# Test cases covered : 1
  @Counts  
  Scenario: FN-COUNTS 01 Count correct no deviation
      Given Open the browser and launch the application
      And Login to WMS Manhattan
	  	And Edit OrgProfile
	  	And Navigate to Location Inventory
	  	And Search Display location With 'getdata(DisplayLocation)' in Location Inventory
	  	And Select checkbox "byILPNStatusNotAllocatedCheckbox" on "LocationInventory"
	  	And Select the location and select cycle count from the three dot bottom menu
	  	And Click Submit in confirmation screen with cycle count 'getdata(CycleCount)'
	  	And Navigate to Tasks
	  	And Select checkbox "byTaskStatusReadyForAssignmentCheckbox" on "TasksPage"
	  	Then Verify task created with status ReadyForAssignment for the selected location
	  	And Navigate to WM Mobile
	  	And Update ORG Profile in WM Mobile
	  	And Search menu 'Enter Task' at WM Mobile
	  	And Enter the tasks details in cycle count screen and complete the process
	  	Then Verify the task has been completed
	    And Close browser window And Switch to Last Window
	    And Navigate to Inventory Count
	  	Then Verify the Count status as booked
	  	And Verify the count details in Inventory Count details page	  	
	
# 12. DFN-INVENTORY-02 - Move iLPN out of location
# Jira Id - MAWMTF01-16 
# Test cases covered : 1
  @INVMoveLPNOutLocation
  Scenario: DFN-INVENTORY-02 - Move iLPN out of location
	  Given Open the browser and launch the application
	  And Login to WMS Manhattan
	  And Edit OrgProfile
	  And Navigate to Location Inventory
	  And Click "byRelatedLinks" on "LocationInventory"
	  And Click "byiLPNS" on "LocationInventory"
	  And Wait for page loading
	  And Select checkbox "byILPNStatusNotAllocatedCheckbox" on "LocationInventory"
	  And Search Current Location With 'getdata(DisplayLocation)' in iLPNs Page
	  And Store iLPN Details to run time Variables
	  And Navigate to WM Mobile
	  And Update ORG Profile in WM Mobile
	  And Search menu 'AT User Directed Putaway' at WM Mobile
	  And Move iLPN from Storage location to Damage location
	  And Close browser window And Switch to Last Window
	  Then Verify iLPN moved to Damage location
	  And Navigate to WM Mobile
	  And Update ORG Profile in WM Mobile
	  And Search menu 'AT User Directed Putaway' at WM Mobile
	  And Move iLPN from Damage location to Storage location
	  And Close browser window And Switch to Last Window
	  Then Verify iLPN moved to Storage location