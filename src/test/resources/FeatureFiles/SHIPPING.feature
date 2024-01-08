@DFN
Feature: Shipping_Test_Cases
##List of Test Cases covered
## TC    TS No.	Test Case Name
## 001.  1          FN-SHIPPING-01 : Process order without serial number until shipping Ship confirm
## 002.  2          FN-SHIPPING-02 : Process order with serial number until shipping Ship confirm
## 003.  3          DFN-ORDCONF-01 : Run a normal order via standard process with no special peculiarities Close it and ship confirm (ITS-ORDER-04)
## 004.  4          FN-SHIPPING-03 : Process order with LOT tracked items Ship confirm (ITS-SHIP-03)

# Test data : 					Values which are pased as part of test data 
# Pre-requiste Steps : 	Steps which are required to be performed/validated to prepare AUT for executing the scenario 
# Test Case : 					DFN
  @Shipping
  Scenario: FN-SHIPPING-01 : Process order without serial number until shipping Ship confirm
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Edit OrgProfile
##   create inventory for Item
    And Update ASN for Product Status Adjustment iLPN in "FNSHIPPING01.xlsx"
    And Navigate to ASNs
    And Clear Notifications
    And Click "byImportDataLoaderButton" on "HeaderPanelPage" WaitForPageLoading
    And Import Data Loader "FNSHIPPING01.xlsx"
    And Verify notification message 'File FNSHIPPING01.xlsx from Asn is imported successfully.'
    And Search ASN at ASNs
    Then Verify ASN details are displayed
    And Verify ILPN linked to ASN with variable  "LPN"
    And Verify Product status and Inventory type in LPNPopup Page
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT Standard Receiving' at WM Mobile
    And Complete ATStandardReceiving with ASN and LPN
    And Close browser window And Switch to Last Window
    And Navigate to ASNs
    And Wait for page loading
    And Search ASN at ASNs
    And Validate ASN status "Verified"
    And Click "byRelatedLinks" on "HeaderPanelPage"
    And Click "byLPNInventory" on "HeaderPanelPage"
    And Store iLPNs to runtime variables as list
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT User Directed Putaway' at WM Mobile
    And Enter ILPN and Location in AT User Directed PutAway
#    And Search menu 'AT System Directed Putaway' at WM Mobile
#    And Putaway LPN AT System Directed
    And Close browser window And Switch to Last Window
    And Navigate to ASNs
    And Wait for page loading
    And Search ASN at ASNs
    And Validate ASN status "Verified"
    And Click "byRelatedLinks" on "HeaderPanelPage"
    And Click "byLPNInventory" on "HeaderPanelPage"
    And Validate ILPN status "Consumed"
##  create Original Order
    And Navigate to Original Orders2
    And Update Original Order with Order ID and Item "OriginalOrderShipping01.xlsx"
    And Click "byImportDataLoaderBtn" on "OriginalOrdersPage"
    And Import Data Loader "OriginalOrderShipping01.xlsx"
    And Wait for page loading
    And Verify notification message 'File OriginalOrderShipping01.xlsx from OriginalOrder is imported successfully.'
    And Click "byRefreshBtn" on "OriginalOrdersPage"
    And Verify Imported Orders
    And Validate Orders status "Released"
    And Click "byRelatedLinks" on "HeaderPanelPage"
    And Wait for page loading
    And Click "byOrderLines" on "OrdersPage"
    And Wait for page loading
#    Execute Wave
    And Navigate to Original Orders2
    And Verify Imported Orders
    And Execute RunWave
    And Navigate to Wave Runs
    And Search Wave run at Wave Runs
    And Validate Wave run status till "Completed"
    And Select First Row
    And Click "byRelatedLinks" on "HeaderPanelPage"
    And Wait for page loading
    And Click on oLPNs Links
    And Wait for page loading
    And Validate OLPNS statuses "Created"
    And Store OLPN number in runtime variable as List
#    Assign task
    And Navigate to Wave Runs Homepage
    And Click on Row At First Index
    And Click on Related Links
    And Click on Tasks Link
    And Store Taskid to variable
    And Validate Task status "Ready For Assign..."
    And Click on Row At First Index
    And Assign Task to current user
#    pickPack OLPN
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT Pick to OLPN' at WM Mobile
    And Complete Packing in AT Pick OLPN
    And Close browser window And Switch to Last Window
    And Navigate to Wave Runs
    And Search Wave run at Wave Runs
    And Select First Row
    And Click "byRelatedLinks" on "HeaderPanelPage"
    And Wait for page loading
    And Click on oLPNs Links
    And Wait for page loading
    And Validate OLPNS statuses "Packed"
#   ship the order
    And Navigate to Orders
    And Search Order at Orders
    And Validate Orders status "Packed"
    And Select First Packed Order in Screen
    And Complete Ship Confirm
    And Wait and Validate Order status is "Shipped"

  @Shipping
  Scenario: FN-SHIPPING-02 : Process order with serial number until shipping Ship confirm
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Edit OrgProfile
#    And Wait for page loading
#    And Update Business Unit 'getdata(BUID)'
##   create inventory for Item
    And Update ASN for Item Shipping in "FNSHIPPING02ASN.xlsx"
    And Navigate to ASNs
    And Clear Notifications
    And Click "byImportDataLoaderButton" on "HeaderPanelPage" WaitForPageLoading
    And Import Data Loader "FNSHIPPING02ASN.xlsx"
    And Verify notification message 'File FNSHIPPING02ASN.xlsx from Asn is imported successfully.'
    And Search ASN at ASNs
    Then Verify ASN details are displayed
    And Verify ILPN linked to ASN with variable  "LPN"
    And Verify Product status and Inventory type in LPNPopup Page
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT Standard Receiving' at WM Mobile
    And Complete ATStandardReceiving with ASN and multiple LPNs with Serial Numbers and Batch Number
    And Close browser window And Switch to Last Window
    And Navigate to ASNs
    And Wait for page loading
    And Search ASN at ASNs
    And Validate ASN status "Verified"
    And Click "byRelatedLinks" on "HeaderPanelPage"
    And Click "byLPNInventory" on "HeaderPanelPage"
    And Store iLPNs to runtime variables as list
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT User Directed Putaway' at WM Mobile
    And Enter ILPN and Location in AT User Directed PutAway of Shipping Item
    And Close browser window And Switch to Last Window
    And Navigate to ASNs
    And Wait for page loading
    And Search ASN at ASNs
    And Validate ASN status "Verified"
    And Click "byRelatedLinks" on "HeaderPanelPage"
    And Click "byLPNInventory" on "HeaderPanelPage"
    And Validate ILPN status "Consumed"
#  create Original Order
    And Navigate to Original Orders2
    And Update Original Order with Order ID and Item "FNSHIPPING02Order.xlsx"
    And Click "byImportDataLoaderBtn" on "OriginalOrdersPage"
    And Import Data Loader "FNSHIPPING02Order.xlsx"
    And Wait for page loading
    And Verify notification message 'File FNSHIPPING02Order.xlsx from OriginalOrder is imported successfully.'
    And Click "byRefreshBtn" on "OriginalOrdersPage"
    And Verify Imported Orders with variable name "OriginalOrder"
    And Validate Orders status "Released"
    And Click "byRelatedLinks" on "HeaderPanelPage"
    And Wait for page loading
    And Click "byOrderLines" on "OrdersPage"
    And Wait for page loading
#    Execute Wave
    And Navigate to Original Orders2
    And Verify Imported Orders with variable name "OriginalOrder"
    And Execute RunWave
    And Navigate to Wave Runs
    And Search Wave run at Wave Runs
    And Validate Wave run status till "Completed"
    And Select First Row
    And Click "byRelatedLinks" on "HeaderPanelPage"
    And Wait for page loading
    And Click on oLPNs Links
    And Wait for page loading
    And Validate OLPNS statuses "Created"
    And Store OLPN number in runtime variable as List
    And Navigate to Wave Runs Homepage
    And Select First Row
    And Click "byRelatedLinks" on "HeaderPanelPage"
    And Wait for page loading
    And Click on Tasks Link
    And Select First Row
    And Store Taskid to variable
    And Validate Task status "Ready For Assign..."
    And Assign Task to current user
#    pickPack OLPN
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT Pick to OLPN' at WM Mobile
    And Complete Packing in AT Pick OLPN With Serial Number
    And Close browser window And Switch to Last Window
    And Navigate to Wave Runs Homepage
    And Select First Row
    And Click "byRelatedLinks" on "HeaderPanelPage"
    And Wait for page loading
    And Click on oLPNs Links
    And Wait for page loading
    And Click "byRefreshButton" on "RightNavigationBar" WaitForPageLoading
    And Validate OLPNS statuses "Packed"
#   ship the order
    And Navigate to Wave Runs Homepage
    And Select First Row
    And Click "byRelatedLinks" on "HeaderPanelPage"
    And Wait for page loading
    And Click on Orders Link
    And Validate Orders status "Packed"
    And Select First Packed Order in Screen
    And Complete action Ship Confirm
    And Wait and Validate Order status is "Shipped"
    And Navigate to Olpns 2.0
    And Wait for page loading
    And Click on ClearAll button
    And Search Order with variable "OriginalOrder" in OLPNS2 page
    And Verify each Serial Number in OLPN 2.0 Cardview


  @ORDER
  Scenario: DFN-ORDCONF-01 : Run a normal order via standard process with no special peculiarities Close it and ship confirm
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Edit OrgProfile
    And Navigate to Items Page
    And Search Item With "getdata(Items)"
    And Verify Item Id exist
         ##Import ASN
    And Update ASN file with Single Asn and Single LPN "ASNMAWMTF01123.xlsx"
    And Navigate to ASNs
    And Clear Notifications
    And Click "byImportDataLoaderButton" on "HeaderPanelPage"
    And Import Data Loader "ASNMAWMTF01123.xlsx"
    And Verify notification message 'File ASNMAWMTF01123.xlsx from Asn is imported successfully.'
    And Search ASN at ASNs
    Then Verify ASN details are displayed
      ##Receive ASN
    And Navigate to WM Mobile
    And Wait for page loading
    And Update ORG Profile in WM Mobile
    And Search menu 'AT Standard Receiving' at WM Mobile
    And Complete ATStandardReceiving with ASN and LPN
    And Close browser window And Switch to Last Window
    And Navigate to WM Mobile
    And Wait for page loading
    And Update ORG Profile in WM Mobile
    And Wait for page loading
    And Search menu 'AT System Directed Putaway' at WM Mobile
    And Complete ATSystemDirectedPutAway with single LPN
    And Close browser window And Switch to Last Window
    And Navigate to ASNs
    And Search ASN at ASNs
    Then Validate ASN status "Verified"
    And Click "byRelatedLinks" on "ASNs"
    And Click "byLPNInventory" on "ASNs"
    And Select First Row
    And Navigate to Inventory Details
    And Filter by Inventory Details with Item ID 'getdata(Item)'
    And Verify OnHandQuantity in Inventory details page
      ##Import order
    And Navigate to Original Orders2
    And Update one OriginalOrder with one Orderline "ASNORDER_MAWMTF01-123.xlsx"
    And Clear Notifications
    And Click "byImportDataLoaderBtn" on "OriginalOrdersPage"
    And Import Data Loader "ASNORDER_MAWMTF01-123.xlsx"
    And Wait for page loading
    And Verify notification message 'File ASNORDER_MAWMTF01-123.xlsx from OriginalOrder is imported successfully.'
    And Click "byRefreshBtn" on "OriginalOrdersPage"
    And Verify Imported Orders with variable name "OriginalOrder1"
    And Click "byRelatedLinks" on "OrdersPage"
    And Wait for page loading
    And Click "byOrderLines" on "OrdersPage"
    And Wait for page loading
    And Verify Item and Quantity with variable "OriginalOrder1" and Order size 1
    And Navigate to Original Orders2
    And Verify Imported Orders with variable name "OriginalOrder1"
      ##Run WAVE
    And Execute RunWave
    And Navigate to Wave Runs
    And Search Wave run at Wave Runs
    And Validate Wave run status till "Completed"
    And Click on Row At First Index
    And Click "byRelatedLinks" on "WaveRunsPage"
    And Wait for page loading
    And Click on oLPNs Links
    And Click on Row At First Index
    And Validate OLPN status "Created"
    And Store OLPN number in runtime variable
    And Wait for page loading
    And Navigate to Wave Runs
    And Search Wave run at Wave Runs
    And Click on Row At First Index
    And Click "byRelatedLinks" on "WaveRunsPage"
    And Wait for page loading
    And Click on Tasks Link
    And Click on Row At First Index
    And Store Taskid to variable
    And Validate Task status "Ready For Assign..."
    And Assign Task to current user
      ##pick-pack order
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT Pick to OLPN' at WM Mobile
    And Complete 'getdata(oLPNCount)' Packing in AT Pick OLPN
    And Close browser window And Switch to Last Window
    And Click "byRefreshButton" on "RightNavigationBar" WaitForPageLoading
    And Navigate to Wave Runs
    And Search Wave run at Wave Runs
    And Click on Row At First Index
    And Click "byRelatedLinks" on "WaveRunsPage"
    And Wait for page loading
    And Click on oLPNs Links
    And Click on Row At First Index
    And Validate OLPN status "Packed"
      ##ship the order
    And Navigate to Orders
    And Search Order with variable "OriginalOrder1" in Order Page
    And Select First Packed Order in Screen
    And Complete Ship Confirm
    And Wait and Validate Order status is "Shipped"
      ##verify oLpns details with Inventory Type F and Product Status A
    And Navigate to OLPNS 2.0
    And Click on ClearAll button
    And Search Order with variable "OriginalOrder1" in OLPNS2 page
    And Select First Shipped Order OLPNS2 page
    When Click on Details Button in OLPNS2 page
    And Wait for page loading
    Then Validate Inventory Type and Product Status under OLPN Details

  @ORDER
  Scenario: FN-SHIPPING-03 : Process order with LOT tracked items Ship confirm
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Edit OrgProfile
    And Navigate to Items Page
    And Search Item With "getdata(Items)"
    And Verify Item Id exist
      ##Import ASN
    And Update ASN file with Single Asn and Single LPN "FN-SHIPPING-03-asn_final.xlsx"
    And Navigate to ASNs
    And Clear Notifications
    And Click "byImportDataLoaderButton" on "HeaderPanelPage"
    And Import Data Loader "FN-SHIPPING-03-asn_final.xlsx"
    And Verify notification message 'File FN-SHIPPING-03-asn_final.xlsx from Asn is imported successfully.'
    And Search ASN at ASNs
    Then Verify ASN details are displayed
      ##Receive ASN
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT Standard Receiving' at WM Mobile
    And Complete ATStandardReceiving with ASN and LPN
    And Close browser window And Switch to Last Window
    And Navigate to WM Mobile
    And Wait for page loading
    And Update ORG Profile in WM Mobile
    And Wait for page loading
    And Search menu 'AT System Directed Putaway' at WM Mobile
    And Complete ATSystemDirectedPutAway with single LPN
    And Close browser window And Switch to Last Window
    And Navigate to ASNs
    And Search ASN at ASNs
    Then Validate ASN status "Verified"
    And Click "byRelatedLinks" on "ASNs"
    And Click "byLPNInventory" on "ASNs"
    And Select First Row
    Then Validate BatchNumber 'getdata(BatchNumber)' in iLPN Inventory Details
    And Navigate to Inventory Details
    And Filter by Inventory Details with Item ID 'getdata(Item)'
    And Verify OnHandQuantity in Inventory details page
      ##Import order
    And Navigate to Original Orders2
    And Update one OriginalOrder with one Orderline "FN-SHIPPING-03-Order.xlsx"
    And Clear Notifications
    And Click "byImportDataLoaderBtn" on "OriginalOrdersPage"
    And Import Data Loader "FN-SHIPPING-03-Order.xlsx"
    And Wait for page loading
    And Verify notification message 'File FN-SHIPPING-03-Order.xlsx from OriginalOrder is imported successfully.'
    And Click "byRefreshBtn" on "OriginalOrdersPage"
    And Verify Imported Orders with variable name "OriginalOrder1"
    And Click "byRelatedLinks" on "OrdersPage"
    And Wait for page loading
    And Click "byOrderLines" on "OrdersPage"
    And Wait for page loading
    And Verify Item and Quantity with variable "OriginalOrder1" and Order size 1
    And Navigate to Original Orders2
    And Verify Imported Orders with variable name "OriginalOrder1"
      ##Run WAVE
    And Execute RunWave
    And Navigate to Wave Runs
    And Search Wave run at Wave Runs
    And Click on Row At First Index
    And Validate Wave run status till "Completed"
    And Click "byRelatedLinks" on "WaveRunsPage"
    And Wait for page loading
    And Click on oLPNs Links
    And Click on Row At First Index
    And Validate OLPN status "Created"
    And Store OLPN number in runtime variable
    And Wait for page loading
    And Navigate to Wave Runs
    And Search Wave run at Wave Runs
    And Click on Row At First Index
    And Click "byRelatedLinks" on "WaveRunsPage"
    And Wait for page loading
    And Click on Tasks Link
    And Click on Row At First Index
    And Store Taskid to variable
    And Validate Task status "Ready For Assign..."
    And Assign Task "Ready For Assign..." to current user "keerthi.p@dhl.com"
      ##pick-pack order
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT Pick to OLPN' at WM Mobile
    And Complete 'getdata(oLPNCount)' Packing in AT Pick OLPN
    And Close browser window And Switch to Last Window
    And Click "byRefreshButton" on "RightNavigationBar" WaitForPageLoading
    And Navigate to Wave Runs
    And Search Wave run at Wave Runs
    And Click on Row At First Index
    And Click "byRelatedLinks" on "WaveRunsPage"
    And Wait for page loading
    And Click on oLPNs Links
    And Click on Row At First Index
    And Validate OLPN status "Packed"
      ##ship the order
    And Navigate to Orders
    And Search Order with variable "OriginalOrder1" in Order Page
    And Select First Packed Order in Screen
    And Complete Ship Confirm
    And Wait and Validate Order status is "Shipped"
      ##verify oLpns details with Batch number , Inventory Type F and Product Status A
    And Navigate to OLPNS 2.0
    And Click on ClearAll button
    And Search Order with variable "OriginalOrder1" in OLPNS2 page
    And Select First Shipped Order OLPNS2 page
    When Click on Details Button in OLPNS2 page
    And Wait for page loading
    Then Validate BatchNumber 'getdata(BatchNumber)' in OLPN Details
