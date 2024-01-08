@DFN
Feature: Task_Test_Cases
##List of Test Cases covered
## TC    TS No.	Test Case Name
## 001.  1          FN-TASK-03 : Configure system to generate iLPN pick for full iLPN allocation
## 002.  2          FN-TASK-01 Configure system to generate list pick (oLPN single pick)
## 003.  3          FN-TASK-02 : Configure system to generate the trolley picks from pick location
## 004.  4          FN-TASK-04 : Configure system to generate iLPN pick for full iLPN allocation of replens
## 005.  5          FN-TASK-05 : Configure system to generate partial iLPN pick for unit/case replens

  @Task
  Scenario: FN-TASK-03 : Configure system to generate iLPN pick for full iLPN allocation
    Given Open the browser and launch the application
    And Login to WMS Manhattan without passowrd
##    And Update Business Unit 'getdata(BUID)'
    And Edit OrgProfile
    And Navigate to Items Page
    And Search Item With "getdata(Items)"
    And Verify Multiple Items with "getdata(Items)"
    And Update LPN level ASN with one line in "Task03ASN.xlsx"
    And Navigate to ASNs
    And Clear Notifications
    And Click "byImportDataLoaderBtn" on "ASNs"
    And Import Data Loader "Task03ASN.xlsx"
    And Verify notification message 'File Task03ASN.xlsx from Asn is imported successfully.'
    And Search ASN at ASNs
    Then Verify ASN details are displayed
    And Verify ILPNs linked to ASN with variable  "listOfILPNs"
    And Verify Product status and Inventory type for multiple lpns in LPNPopup Page
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT Standard Receiving' at WM Mobile
    And Complete ATStandardReceiving with ASN and multiple LPNs
    And Close browser window And Switch to Last Window
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT User Directed Putaway' at WM Mobile
    And Complete ATUserDirectedPutAway with multiple LPNs
    And Close browser window And Switch to Last Window
    And Navigate to Inventory Details
#    And Expand Filter
    And Search with Item Filter "getdata(Items)"
    And Search LocationBarcode With "getdata(LocationBarCode)"
    And Verify Multiple Items details in Inventory Details page
    And Navigate to Original Orders2
    And Clear Notifications
    And Update Order Single line in "Task03Order.xlsx"
    And Click "byImportDataLoaderBtn" on "ASNs"
    And Import Data Loader "Task03Order.xlsx"
    And Verify notification message 'File Task03Order.xlsx from OriginalOrder is imported successfully.'
    And Search Order with variable "Orders"
    And Verify Multiple Orders with variable "Orders"
    And Verify Multiple Order Statuses with variable "getdata(BeforeOrderStatuses)"
    And Navigate to OrderLines Page
    And Search Order with variable "Orders"
    And Verify OrderLineNeed and OrderLineAttributes for multiple orders with variable "Orders"
    And Navigate to Original Orders2
    And Verify Imported Orders with variable name "Orders"
    ##And Execute RunWave from Original Orders
    And Execute RunWave from OriginalOrders for ATStandardOrderStrategy
    And Navigate to Wave Runs
    And Search Wave run at Wave Runs
    And Validate Wave run status till "Completed"
    And Select First Row
    And Click "byRelatedLinks" on "WaveRunsPage"
    And Wait for page loading
    And Click "byAllocations" on "WaveRunsPage"
    And Wait for page loading
    #And Refresh browser
    And Wait for page loading
    And Click "byRefreshButton" on "RightNavigationBar" WaitForPageLoading
    And Verify Wave Run for pickpack specifies correct Quantity
    And Navigate to Wave Runs
    And Search Wave run at Wave Runs
    And Select First Row
    And Click "byRelatedLinks" on "HeaderPanelPage"
    And Wait for page loading
    And Click on oLPNs Links
    And Click "byRefreshButton" on "RightNavigationBar" WaitForPageLoading
    And Select First Row
    And Wait for page loading
    And Validate OLPNS statuses "Created"
    And Store OLPN number in runtime variable as List
    And Click "byRelatedLinks" on "WaveRunsPage"
    And Wait for page loading
    And Click on Task Link
    #And Click on Tasks Link
    And Click "byRefreshButton" on "RightNavigationBar" WaitForPageLoading
#    And Click "byTasks" on "WaveRunsPage"
    And Wait for page loading
    And Validate Task status "Ready For Assign..."
    And Store Task number in runtime variable

#1. Test Case : FN-TASK-01 : Configure system to generate list pick (oLPN single pick) (ITS-TASK-01)
# Jira Id - MAWMTF01-100
# Test cases covered : 1
  @Task @ConfigureSystem
  Scenario: FN-TASK-01 Configure system to generate list pick (oLPN single pick)
    Given Open the browser and launch the application
    And Login to WMS Manhattan
##    And Update Business Unit 'getdata(BUID)'
    And Edit OrgProfile
    And Navigate to Items Page
    And Update ItemId Item Master of Task import file with file by 'TASK01ItemMaster.xlsx'
    And Clear Notifications
    And Click "byImportDataLoaderBtn" on "ASNs" WaitForPageLoading  
    And Import Data Loader 'TASK01ItemMaster.xlsx'
    And Wait for page loading
    And Verify notification message 'File TASK01ItemMaster.xlsx from Item is imported successfully.'
    And Search Item With 'getdata(ItemIdStarting)'
    And Verify Item Id exist
    And Navigate to ASNs
    And Update ASN import file with Item Id LPN Task by file 'TASK01ASN.xlsx'
    And Clear Notifications
    And Click "byImportDataLoaderBtn" on "ASNs" WaitForPageLoading
    And Import Data Loader 'TASK01ASN.xlsx'
    And Wait for page loading
    And Verify notification message 'File TASK01ASN.xlsx from Asn is imported successfully.'
    And Search ASN at ASNs
    And Wait for page loading
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT Standard Receiving' at WM Mobile
    And Complete ATStandardReceiving with ASN and LPN
    And Close browser window And Switch to Last Window
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT System Directed Putaway' at WM Mobile
    And Complete ATSystemDirectedPutAway with single LPN
    And Close browser window And Switch to Last Window
    And Navigate to Inventory Details
    And Verify Single Item Task Details at Inventory Details
    And Navigate to Original Orders2
    And Update Original Order 2.0 import file with Task Single Item Id  by file 'TASK01OriginalOrder.xlsx'
    And Clear Notifications
    And Click "byImportDataLoaderBtn" on "ASNs" WaitForPageLoading
    And Import Data Loader 'TASK01OriginalOrder.xlsx'
    And Wait for page loading
    And Verify notification message 'File TASK01OriginalOrder.xlsx from OriginalOrder is imported successfully.'
    And Click "byRefreshBtn" on "OriginalOrdersPage" WaitForPageLoading
    And Verify Imported Orders
    And Click "byRelatedLinks" on "OrdersPage" WaitForPageLoading
    And Click "byOrderLines" on "OrdersPage" WaitForPageLoading
    And Validate Orderslines status "READY"
    And Verify Item Id and Order Quantity at Original Order 2.0 in Order Lines Page
    And Validate Orders status "Released"
    And Execute RunWave
    And Navigate to Wave Runs
    And Search Wave run at Wave Runs
    And Validate Wave run status till "Completed"
    And Select Wave Run card
    And Click "byRelatedLinks" on "WaveRunsPage" WaitForPageLoading
    And Click "byAllocations" on "WaveRunsPage" WaitForPageLoading
    And Wait for page loading
    And Verify wave Run specifies the Correct Quantity and the Container in Wave Allocations
    And Navigate to Wave Runs Homepage
    And Select Wave Run card
    And Click "byRelatedLinks" on "WaveRunsPage"
    And Click on oLPNs Links
    And Wait for page loading
    And Validate OLPN status "Created"
    And Navigate to Wave Runs Homepage
    And Select Wave Run card
    And Click "byRelatedLinks" on "WaveRunsPage"
    And Click on Tasks Links
    And Wait for page loading
    And Validate Task status "Ready For Assign..."
    And Store Task number in runtime variable
    And Navigate to Wave Runs Homepage
    And Select Wave Run card
    And Click "byRelatedLinks" on "WaveRunsPage"
    And Click on Task Details Links
    And Validate Task Details status "Created"
    And Select Task card
    And Verify Task specifies the Correct Inventory and the Container in Task Details

  Scenario: FN-TASK-02 : Configure system to generate the trolley picks from pick location
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Edit OrgProfile
    And Navigate to Items Page
    And Search Item With "getdata(Items)"
    #And Verify Multiple Items with "getdata(Items)"
    And Update Asn and two Lpn "AsnTASK02.xlsx"
    And Navigate to ASNs
    And Clear Notifications
    And Click "byImportDataLoaderBtn" on "ASNs" WaitForPageLoading
    And Import Data Loader "AsnTASK02.xlsx"
    And Verify notification message 'File AsnTASK02.xlsx from Asn is imported successfully.'
    And Search ASN at ASNs
    And Verify ASN details are displayed
    And Validate ASN status "In Transit"
    And Click "byRelatedLinks" on "ASNs"
    And Click "byLPNInventory" on "ASNs"
    And Select First Row
    And Verify iLPN Inventory Details
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT Standard Receiving' at WM Mobile
    And Complete ATStandardReceiving with two LPN
    And Click "byVerifyASNButton" on "UserDirected"
    And Validate popup message "Verification request has been submitted for ASN"
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
    And Search menu 'AT System Directed Putaway' at WM Mobile
    And Enter ILPN and Location For Two LPNs in FN PutAway System Directed Page
    And Close browser window And Switch to Last Window
    And Navigate to Inventory Details
    #And Expand Filter
    And Search with Item Filter "getdata(Items)"
    And Navigate to Original Orders2
    And Update Original Order for two Orders 'TASK02OriginalOrder.xlsx'
    And Click "byImportDataLoaderBtn" on "OriginalOrdersPage" WaitForPageLoading
    And Import Data Loader "TASK02OriginalOrder.xlsx"
    And Wait for page loading
    And Verify notification message 'File TASK02OriginalOrder.xlsx from OriginalOrder is imported successfully.'
    And Click "byRefreshBtn" on "OriginalOrdersPage"
    And Verify the two Imported Orders
    And Click "byRelatedLinks" on "HeaderPanelPage"
    And Wait for page loading
    And Click "byOrderLines" on "OrdersPage"
    And Wait for page loading
    And Verify Order Line Need and Order Line Attributes
    And Execute AT Pick Cart Strategy RunWave for Orders
    And Navigate to Wave Runs
    And Search Wave run at Wave Runs
    And Validate Wave run status till "Completed"
    And Select First Row
    And Click "byRelatedLinks" on "WaveRunsPage"
    And Click on Allocations Link
    And Select First Row
    And Click "byRelatedLinks" on "WaveRunsPage"
    And Wait for page loading
    And Click "byAllocations" on "WaveRunsPage"
    And Select Details in Allocations page
    #And Verify two wave Runs for Relenishment and pickpack specifiesCorrect Quantity Item and Batch Number
    And Navigate to Wave Runs Homepage
    And Click "byRelatedLinks" on "WaveRunsPage"
    And Wait for page loading
    And Select Olpns Option
    And Wait for page loading
    And Navigate to Wave Runs Homepage
    And Select Wave Run card
    And Click "byRelatedLinks" on "WaveRunsPage"
    And Click on Tasks Links
    And Wait for page loading

  Scenario: FN-TASK-04 : Configure system to generate iLPN pick for full iLPN allocation of replens
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Edit OrgProfile
    And Navigate to Items Page
    And Search Item With "getdata(Items)"
    #And Verify Multiple Items with "getdata(Items)"
    And Update ASN file with LPN "AsnTASK04.xlsx"
    And Navigate to ASNs
    And Clear Notifications
    And Click "byImportDataLoaderBtn" on "ASNs"
    And Import Data Loader "AsnTASK04.xlsx"
    And Verify notification message 'File AsnTASK04.xlsx from Asn is imported successfully.'
    And Search ASN at ASNs
    And Verify ASN details are displayed
    And Validate ASN status "In Transit"
    And Click "byRelatedLinks" on "ASNs"
    And Click "byLPNInventory" on "ASNs"
    And Select First Row
    And Verify iLPN Inventory Details
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT Standard Receiving' at WM Mobile
    And Complete ATStandardReceiving with ASN and LPN
    #And Click "byVerifyASNButton" on "UserDirected"
    #And Validate popup message "Verification request has been submitted for ASN"
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
    And Complete ATUserDirectedPutAway with single LPN
    And Close browser window And Switch to Last Window
    And Navigate to Inventory Details
    #And Expand Filter
    And Search with Item Filter "getdata(Items)"
    And Navigate to Original Orders2
    And Update Original Order with one line 'TASK04OriginalOrder.xlsx'
    And Click "byImportDataLoaderBtn" on "OriginalOrdersPage"
    And Import Data Loader "TASK04OriginalOrder.xlsx"
    And Wait for page loading
    And Verify notification message 'File TASK04OriginalOrder.xlsx from OriginalOrder is imported successfully.'
    And Click "byRefreshBtn" on "OriginalOrdersPage"
    And Verify Imported Orders
    And Click "byRelatedLinks" on "HeaderPanelPage"
    And Wait for page loading
    And Click "byOrderLines" on "OrdersPage"
    And Wait for page loading
    And Verify Order Line Need and Order Line Attributes
    And Navigate to Original Orders2
    And Execute AT FP Strategy RunWave for Orders
    And Navigate to Wave Runs
    And Search Wave run at Wave Runs
    And Validate Wave run status till "Completed"
    And Select First Row
    And Click "byRelatedLinks" on "WaveRunsPage"
    And Click on Allocations Link
    And Select First Row
    And Click "byRelatedLinks" on "WaveRunsPage"
    And Wait for page loading
    And Click "byAllocations" on "WaveRunsPage"
    And Select Details in Allocations page
    #And Verify two wave Runs for Relenishment and pickpack specifiesCorrect Quantity Item and Batch Number
    And Navigate to Wave Runs Homepage
    And Click "byRelatedLinks" on "WaveRunsPage"
    And Wait for page loading
    And Select Olpns Option
    And Wait for page loading
    And Navigate to Wave Runs Homepage
    And Select Wave Run card
    And Click "byRelatedLinks" on "WaveRunsPage"
    And Click on Tasks Links

  @Task
  Scenario: FN-TASK-05 : Configure system to generate partial iLPN pick for unit/case replens
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Edit OrgProfile
    And Navigate to Items Page
    And Edit ItemId Item Master of Inventory import file with file by 'FN-TASK-05Item.xlsx'
    And Clear Notifications
    And Click "byImportDataLoaderBtn" on "ASNs" WaitForPageLoading
    And Import Data Loader "FN-TASK-05Item.xlsx"
    And Verify notification message 'File FN-TASK-05Item.xlsx from Item is imported successfully.'
    And Search Item With variable "Item"
    Then Verify Item with variable "Item"
    And Update ASN for normal order via standard process with Newly Generated ItemId in "FN-TASK-05-ASN.xlsx"
    And Navigate to ASNs
    And Clear Notifications
    And Click "byImportDataLoaderBtn" on "ASNs"
    And Import Data Loader "FN-TASK-05-ASN.xlsx"
    Then Verify notification message 'File FN-TASK-05-ASN.xlsx from Asn is imported successfully.'
    And Search ASN at ASNs
    And Verify ASN details are displayed
    Then Validate ASN status "In Transit"
    And Wait for page loading
    And Verify ILPN linked to ASN with variable  "LPN"
    And Verify Product status and Inventory type in LPNPopup Page
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT Standard Receiving' at WM Mobile
    And Complete ATStandardReceiving with ASN and LPN
    And Close browser window And Switch to Last Window
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT System Directed Putaway' at WM Mobile
    And Complete ATSystemDirectedPutAway with single LPN
    And Close browser window And Switch to Last Window
    And Navigate to Inventory Details
    And Search Item With variable "Item"
    And Navigate to Original Orders2
    And Clear Notifications
    And Update Original Orders in "FN-TASK-05originalorder.xlsx"
    And Click "byImportDataLoaderBtn" on "ASNs"
    And Import Data Loader "FN-TASK-05originalorder.xlsx"
    And Verify notification message 'File FN-TASK-05originalorder.xlsx from OriginalOrder is imported successfully.'
    And Navigate to Original Orders2
    And Search Order with variable "Orders"
    And Complete "ATStandardOrderStrategy" Order strategy
    And Navigate to Wave Runs
    And Search Wave run at Wave Runs
    Then Validate Wave run status till "Completed"
    And Click on Row At First Index
    And Click on Related Links
    And Click on Allocations Link
    And Click on Row At First Index
    And Click on details button For Allocations
    Then Expand Container Quantity section And Verify Allocation UOM
    And Click on Row At First Index
    And Click on Row At Second Index
    And Click on details button For Allocations
    Then Expand Container Quantity section And Verify Allocation UOM
    And Navigate to Wave Runs Homepage
    And Click on Row At First Index
    And Click on Related Links
    And Click on oLPNs Links
    And Click on Row At First Index
    And Navigate to Wave Runs Homepage
    And Click on Row At First Index
    And Click on Related Links
    And Click on Tasks Link
    Then Verify Labor Activity For Each Tasks

