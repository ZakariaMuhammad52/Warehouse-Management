@DFNReceiving
Feature:RCV
##List of Test Cases covered
## TC    TS No.	Test Case Name
## 001.   	  DFN-RECEIVING-04 -Standard ASN receiving with cubiscan one product ( ITS-RCV-07 )
## 002.  	  DFN-RECEIVING-05 -Standard ASN receiving with tolerance ( ITS-RCV-08 )
## 003.  	  DFN-RECEIVING-07 -Standard ASN receiving with serial numbers outbound (no ask) (ITS-RCV-09 )
## 004.       DFN-RECEIVING-08 -Standard ASN receiving with not annouced LOT but without Expiration Date ( ITS-RCV-10 )
## 005.       DFN-RECEIVING-09 -Standard ASN receiving with annouced LOT but without Expiration Date ( ITS-RCV-11 )
## 006.       DFN-RECEIVING-10 -Standard ASN receiving with not annouced LOT with Expiration Date ( ITS-RCV-12 )
## 007.       DFN-RECEIVING-11 -Standard ASN receiving with annouced LOT with Expiration Date ( ITS-RCV-13 )
## 008.       DFN-RECEIVING-12 -Standard ASN receiving with LOT in the system (ITS-RCV-14 )
## 009.       DFN-RECEIVING-13 - Standard ASN receiving multiple product statuses (ITS-RCV-15)
## 010.       DFN-RECEIVING-14 -Standard Trolley Receiving (ITS-RCV-16)
## 011.       DFN-RECEIVING-15 - Standard pre-announced LPN receiving (ITS-RCV-17)
## 012.       DFN-RECEIVING-16 -Standard LPN Level ASN Receiving with Parent LPN (ITS-RCV-18 )
## 013.       DFN-RECEIVING-17 -Standard LPN Level ASN Receiving (ITS-RCV-19)

# Test Case : DFN-RECEIVING-04-Standard ASN receiving with cubiscan one product
# 1. DFN-RECEIVING-04-Standard ASN receiving with cubiscan one product
# Jira Id - MAWMTF01-28
# Test cases covered : 1
  @StdReceiving @ReceivingCubiscan
  Scenario: DFN-RECEIVING-04-Standard ASN receiving with cubiscan one product
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Edit OrgProfile
    And Navigate to ASNs
    And Update ASN export file 'RCV04.xlsx'
    And Clear Notifications
    And Click "byImportDataLoaderBtn" on "ASNs"
    And Import Data Loader 'RCV04.xlsx'
    And Wait for page loading
    And Verify notification message 'File RCV04.xlsx from Asn is imported successfully.'
    And Search ASN at ASNs
    And Verify ASN details are displayed
    And Validate ASN status "In Transit"
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT Standard Receiving' at WM Mobile
    And Complete ATStandardReceiving with produtstatus
    Then Validate error has one cubiscan product
    And Search ASN at ASNs
    And Verify ASN details are displayed
    And Validate ASN status "In Receiving"
    And Verify receiving ASN
    And Wait for page loading
    And Search ASN at ASNs
    And Validate ASN status "Verified"
    And Click "byRelatedLinks" on "ASNs"
    And Click "byLPNInventory" on "ASNs"
    And Store iLPNs to runtime variables as list
    And Navigate to ASNs
    And Search ASN at ASNs
    And Validate ASN status "Verified"
    And Click "byRelatedLinks" on "ASNs"
    And Click "byLPNs" on "ASNs"
    And Validate LPN status and inventory details of LPN


# 2. DFN-RECEIVING-05-Standard ASN receiving with tolerance
# Jira Id - MAWMTF01-30
# Test cases covered : 1
  @StdReceiving @ReceivingTolerance
  Scenario: DFN-RECEIVING-05-Standard ASN receiving with tolerance
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Edit OrgProfile
    And Navigate to ASNs
    And Update ASN export file 'RCV05.xlsx' with multiple ASNId for ASNLine
    And Clear Notifications
    And Click "byImportDataLoaderBtn" on "ASNs"
    And Import Data Loader 'RCV05.xlsx'
    And Wait for page loading
    And Verify notification message 'File RCV05.xlsx from Asn is imported successfully.'
    And Search ASN at ASNs
    And Verify ASN details are displayed
    And Validate ASN status "In Transit"
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT Standard Receiving' at WM Mobile
    And Complete ATStandardReceiving with tolerance
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT Standard Receiving' at WM Mobile
    And Complete ATStandardReceiving after error displayed
    And Navigate to ASNs
    And Search ASN at ASNs
    And Verify ASN details are displayed
    And Validate ASN status "In Receiving"
    And Verify receiving ASN wo buttonpopup
    And Validate item variances and lpn in ASN screen
    And Validate Variance Warning Code
    And Verify variance and Accept
    And Wait for page loading
    And Search ASN at ASNs
    And Validate ASN status "Verified"
    And Click "byRelatedLinks" on "ASNs"
    And Click "byLPNInventory" on "ASNs"
    And Store iLPNs to runtime variables as list
    And Navigate to ASNs
    And Search ASN at ASNs
    And Validate ASN status "Verified"
    And Click "byRelatedLinks" on "ASNs"
    And Click "byLPNs" on "ASNs"
    And Validate LPN status and inventory details of LPN


# 3. DFN-RECEIVING-07-Standard ASN receiving with serial numbers outbound (no ask)
# Jira Id - MAWMTF01-35
# Test cases covered : 1
  @StdReceiving @ReceivingSerialNumberOutbound
  Scenario: DFN-RECEIVING-07-Standard ASN receiving with serial numbers outbound (no ask)
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Edit OrgProfile
    And Navigate to ASNs
    And Update ASN import file with item outbound 'RCV07.xlsx'
    And Clear Notifications
    And Click "byImportDataLoaderBtn" on "ASNs"
    And Import Data Loader 'RCV07.xlsx'
    And Wait for page loading
    And Verify notification message 'File RCV07.xlsx from Asn is imported successfully.'
    And Search ASN at ASNs
    And Verify ASN details are displayed
    And Click "byRelatedLinks" on "ASNs"
    And Click "byASNDetails" on "ASNs"
    And Wait for page loading
    And Verify ASN item outbound in ASN Details page
    And Verify Attribute Group item outbound in Items page
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT Standard Receiving' at WM Mobile
    And Complete ATStandardReceiving with Item Serial Number Outbound
    And Navigate to ASNs
    And Search ASN at ASNs
    And Validate ASN status "Verified"
    And Click "byRelatedLinks" on "ASNs"
    And Click "byLPNinventory" on "ASNs"
    And Wait for page loading
    And Verify Ilpn details of item outbound in ILPNs


#4. Test Case : DFN-RECEIVING-08 -Standard ASN receiving with not annouced LOT but without Expiration Date ( ITS-RCV-10 )
# Jira Id - MAWMTF01-31
# Test cases covered : 1
  @StdReceiving @ReceivingNotLOTWithoutExpDate
    Scenario: DFN-RECEIVING-08-Standard ASN receiving with not annouced LOT but without Expiration Date
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Edit OrgProfile
    And Navigate to ASNs
    And Update ASN export file 'RCV08.xlsx'
    And Clear Notifications
    And Click "byImportDataLoaderBtn" on "ASNs"
    And Import Data Loader 'RCV08.xlsx'
    And Wait for page loading
    And Verify notification message 'File RCV08.xlsx from Asn is imported successfully.'
    And Search ASN at ASNs
    And Verify ASN details are displayed
    And Validate ASN status "In Transit"
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT Standard Receiving' at WM Mobile
    And Complete ATStandardReceiving entering batch number
    And Search ASN at ASNs
    And Verify ASN details are displayed
    And Validate ASN status "Verified"
    And Click "byRelatedLinks" on "ASNs"
    And Click "byLPNinventory" on "ASNs"
    And Validate batchNumber and ExpiryDate in LocationInventory

#5.Test Case : 	DFN-RECEIVING-09 -Standard ASN receiving with annouced LOT but without Expiration Date ( ITS-RCV-11 )
# Jira Id - MAWMTF01-32
# Test cases covered : 1
  @StdReceiving @ReceivingWithLOTWithOutExpDate
  Scenario: DFN-RECEIVING-09-Standard ASN receiving with annouced LOT but without Expiration Date
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
    And Complete ATStandardReceiving entering batch number
    And Navigate to ASNs
    And Search ASN at ASNs
    And Verify ASN details are displayed
    And Validate ASN status "Verified"
    And Click "byRelatedLinks" on "ASNs"
    And Click "byLPNinventory" on "ASNs"
    And Validate batchNumber and ExpiryDate is displayed in LocationInventory


#6. Test Case : DFN-RECEIVING-10 -Standard ASN receiving with not annouced LOT with Expiration Date ( ITS-RCV-12 )
# Jira Id - MAWMTF01-33
# Test cases covered : 1
  @StdReceiving @ReceivingWithoutLOTWithExpDate
  Scenario: DFN-RECEIVING-10-Standard ASN receiving with not annouced LOT with Expiration Date
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Edit OrgProfile
    And Navigate to ASNs
    And Update ASN export file "RCV10.xlsx"
    And Clear Notifications
    And Click "byImportDataLoaderBtn" on "ASNs"
    And Import Data Loader 'RCV10.xlsx'
    And Wait for page loading
    And Verify notification message 'File RCV10.xlsx from Asn is imported successfully.'
    And Search ASN at ASNs
    And Verify ASN details are displayed
    And Validate ASN status "In Transit"
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT Standard Receiving' at WM Mobile
    And Complete ATStandardReceiving entering batch number
    And Search ASN at ASNs
    And Verify ASN details are displayed
    And Validate ASN status "Verified"
    And Click "byRelatedLinks" on "ASNs"
    And Click "byLPNinventory" on "ASNs"
    And Validate batchNumber and ExpiryDate is displayed in LocationInventory

#7. Test Case : DFN-RECEIVING-11 -Standard ASN receiving with annouced LOT with Expiration Date ( ITS-RCV-13 )
# Jira Id - MAWMTF01-34
# Test cases covered : 1
  @StdReceiving @ReceivingWithLOTExpDate
  Scenario: DFN-RECEIVING-11-Standard ASN receiving with annouced LOT with Expiration Date
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Edit OrgProfile
    And Navigate to ASNs
    And Update ASN import file with batch number and expiry date 'RCV11.xlsx'
    And Clear Notifications
    And Click "byImportDataLoaderBtn" on "ASNs"
    And Import Data Loader 'RCV11.xlsx'
    And Wait for page loading    
    And Verify notification message 'File RCV11.xlsx from Asn is imported successfully.'
    And Search ASN at ASNs
    And Verify ASN details are displayed
    And Validate ASN status "In Transit"
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT Standard Receiving' at WM Mobile
    And Complete ATStandardReceiving entering batch number
    And Search ASN at ASNs
    And Verify ASN details are displayed
    And Validate ASN status "Verified"
    And Click "byRelatedLinks" on "ASNs"
    And Click "byLPNinventory" on "ASNs"
    And Validate batchNumber and ExpiryDate is displayed in LocationInventory

#8. Test Case : DFN-RECEIVING-12 -Standard ASN receiving with LOT in the system (ITS-RCV-14 )
# Jira Id - MAWMTF01-36
# Test cases covered : 1
  @ASNReceiving @ReceivingWithLOT
  Scenario: DFN-RECEIVING-12-Standard ASN receiving with LOT in the system
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Edit OrgProfile
    And Navigate to ASNs
    And Update ASN export file with batch number 'RCV12.xlsx'
    And Clear Notifications
    And Click "byImportDataLoaderBtn" on "ASNs"
    And Import Data Loader 'RCV12.xlsx'
    And Wait for page loading
    And Verify notification message 'File RCV12.xlsx from Asn is imported successfully.'
    And Search ASN at ASNs
    And Verify ASN details are displayed
    And Validate ASN status "In Transit"
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT Standard Receiving' at WM Mobile
    And Complete ATStandardReceiving entering batch number
    And Search ASN at ASNs
    And Verify ASN details are displayed
    And Validate ASN status "Verified"
    And Click "byRelatedLinks" on "ASNs"
    And Click "byLPNinventory" on "ASNs"
    And Validate batchNumber and ExpiryDate is displayed in LocationInventory

#9. Test Case : DFN-RECEIVING-13 - Standard ASN receiving multiple product statuses (ITS-RCV-15)
# Jira Id - MAWMTF01-29
# Test cases covered : 1
  @ASNReceiving @ReceivingMultiProdStatus
  Scenario: DFN-RECEIVING-13-Standard ASN receiving multiple product statuses
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
      Given Open the browser and launch the application
      And Login to WMS Manhattan
      And Edit OrgProfile
      And Navigate to Purchase Orders
      And Search Purchase Order
      And Click "byRelatedLinks" on "PurchaseOrders"
      And Click "byPurchaseOrderLine" on "PurchaseOrders"
##	RECEIVING 13 Standard ASN receiving multiple statuses
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
      And Complete ATStandardReceiving for multiple product status
      And Click "byVerifyASNButton" on "UserDirected"
      And Validate popup message "Verification request has been submitted for ASN"
      And Close browser window And Switch to Last Window
      And Navigate to ASNs
      And Wait for page loading
      And Search ASN at ASNs
      And Validate ASN status "Verified"
      And Click "byRelatedLinks" on "ASNs"
      And Click "byLPNInventory" on "ASNs"
      And Store iLPNs to runtime variables as list
      And Validate Product Status of each LPN  


#10. Test Case : DFN-RECEIVING-14-Standard Trolley Receiving (ITS-RCV-16)
# Jira Id - MAWMTF01-42
# Test cases covered : 1
  @ASNReceiving @ReceivingTrolley
  Scenario: DFN-RECEIVING-14-Standard Trolley Receiving
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Edit OrgProfile
    And Navigate to ASNs
    And Update ASN Value and Asn Line Id Value by file 'RCV14.xlsx'
    And Clear Notifications
    And Click "byImportDataLoaderBtn" on "ASNs"
    And Import Data Loader 'RCV14.xlsx'
    And Wait for page loading
    And Verify notification message 'File RCV14.xlsx from Asn is imported successfully.'
    And Search ASN at ASNs
    And Wait for page loading
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'FN Trolley Receiving' at WM Mobile
    And Complete FN Trolley Receiving Line 1
    And Complete FN Trolley Receiving Line 2
    And Complete FN Trolley Receiving Line 3
    And Navigate to ASN Related Link LPN Inventory
    And Wait for page loading
    And Verify ASN>ILPNs details are displayed
    And Verify Parent LPN of multiple card
    And Verify LPN Details for multiple ILPN

#11. Test Case : DFN-RECEIVING-15-Standard pre-announced LPN receiving (ITS-RCV-17)
# Jira Id - MAWMTF01-56
# Test cases covered : 1
  @ASNReceiving @ReceivingPreLPN
  Scenario: DFN-RECEIVING-15-Standard pre-announced LPN receiving
  # ITS-RCV 15 -Standard pre-announced LPN receiving
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Edit OrgProfile
    And Navigate to ASNs
    And Update ASN import file with batch number and expiry date 'RCV15.xlsx'
    And Clear Notifications
    And Click "byImportDataLoaderBtn" on "ASNs"
    And Import Data Loader 'RCV15.xlsx'
    And Wait for page loading
    And Verify notification message 'File RCV15.xlsx from Asn is imported successfully.'
    And Search ASN at ASNs
    And Verify ASN details are displayed
    And Click "byRelatedLinks" on "ASNs"
    And Click "byASNDetails" on "ASNs"
    And Wait for page loading
    And Verify ASN content details in ASN Details page
    #And Verify Detail page
    And Update Create ILPN detail
    And Search ASN at ASNs
    And Click "byRelatedLinks" on "ASNs"
    And Click "byLPNinventory" on "ASNs"
    And Wait for page loading
    And Store iLPN ID to runtime variable as String
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'FN Standard Receiving' at WM Mobile
    And Complete FN Standard Receiving
    And Navigate to ASN Homepage
    And Search ASN at ASNs
    And Click "byRelatedLinks" on "ASNs"
    And Click "byLPNinventory" on "ASNs"
    And Wait for page loading
    And Verify Ilpn details in ILPNs

#12. Test Case : DFN-RECEIVING-16 -Standard LPN Level ASN Receiving with Parent LPN
# Jira Id - MAWMTF01-43
# Test cases covered : 1
  @ASNReceiving @ReceivingPreLPN
  Scenario: DFN-RECEIVING-16 -Standard LPN Level ASN Receiving with Parent LPN
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Edit OrgProfile
    And Navigate to ASNs
    And Update ASN export file with LPN Receiving Parent LPN 'RCV16.xlsx'
    And Clear Notifications
    And Click "byImportDataLoaderBtn" on "ASNs"
    And Import Data Loader 'RCV16.xlsx'
    And Wait for page loading
    And Verify notification message 'File RCV16.xlsx from Asn is imported successfully.'
    And Search ASN at ASNs
    And Verify ASN details are displayed
    And Validate ASN status "In Transit"
    And Click "byRelatedLinks" on "ASNs"
    And Click "byLPNs" on "ASNs"
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'FN LPN Receiving' at WM Mobile
    And Complete FN LPN Receiving with Container
    And Close browser window And Switch to Last Window
    And Navigate to ASNs
    And Search ASN at ASNs
    And Verify ASN details are displayed
    And Validate ASN status "Verified"
    And Click "byRelatedLinks" on "ASNs"
    And Click "byLPNs" on "ASNs"
    And Validate LPN status and inventory details of first LPN and second LPN
    And Validate LPN status and inventory details of parent Container

#13.Test Case : DFN-RECEIVING-17-Standard LPN Level ASN Receiving (ITS-RCV-19)
# Jira Id - MAWMTF01-64
# Test cases covered : 1
  @ASNReceiving @ReceivingPreLPN
  Scenario: DFN-RECEIVING-17-Standard LPN Level ASN Receiving
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Edit OrgProfile
    And Navigate to ASNs
    And Update ASN export file with LPN Receiving no Parent LPN 'RCV17.xlsx'
    And Clear Notifications
    And Click "byImportDataLoaderBtn" on "ASNs"
    And Import Data Loader 'RCV17.xlsx'
    And Wait for page loading
    And Verify notification message 'File RCV17.xlsx from Asn is imported successfully.'
    And Search ASN at ASNs
    And Verify ASN details are displayed
    And Validate ASN status "In Transit"
    And Click "byRelatedLinks" on "ASNs"
    And Click "byLPNInventory" on "ASNs"
    And Store iLPNs to runtime variables as list
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'FN LPN Receiving' at WM Mobile
    And Complete FN LPN Receiving without parent Container
    And Navigate to ASNs
    And Search ASN at ASNs
    And Verify ASN details are displayed
    And Validate ASN status "Verified"
    And Click "byRelatedLinks" on "ASNs"
    And Click "byLPNInventory" on "ASNs"
    And Validate LPN status and inventory details of LPN with no parent