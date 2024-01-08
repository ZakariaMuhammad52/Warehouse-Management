@DFN
Feature: PACKING_Test_Cases
##List of Test Cases covered
## TC    TS No.	Test Case Name
## 001.  1          DFN-PACKING-01-Create one order multi piece, allocate and pick Pack normally (ITS-PACKING-01)
## 002.  2          DFN-PACKING-02: Create at least two orders single piece for the same client. Wave them and pick Pack the goods via Packing Station in separate oLPNs
## 003.  3          DFN-PACKING-03: Create one order multi piece WITH SERIAL NUMBER, allocate and pick Pack in pack station and collect all serial numbers requested
## 004.  4          DFN-PACKING-04 : Create at least two Multi-SKU, multi-units for the same client, both with serial number. Wave them and pick Pack the goods and collect all serial numbers requested

# Test data : 					Values which are pased as part of test data 
# Pre-requiste Steps : 	Steps which are required to be performed/validated to prepare AUT for executing the scenario 
# Test Case : 					DFN-PACKING-01-Create one order multi piece, allocate and pick Pack normally (ITS-PACKING-01)

# 1. DFN-PACKING-01-Create one order multi piece, allocate and pick Pack normally
# Jira Id - MAWMTF01-89
# Test cases covered : 1
  @PACKING @OneOrderMultiPiece
  Scenario: DFN-PACKING-01-Create one order multi piece, allocate and pick Pack normally
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Edit OrgProfile
    And Navigate to Items Page
    #Pre-requisite of Item: if using new item, start upload step below, else just comment below step until end of pre-requisite
    And Update ItemId Item Master import file with file by 'PACKING01ItemMaster.xlsx'
    And Clear Notifications
    And Click "byImportDataLoaderButton" on "HeaderPanelPage" WaitForPageLoading
    And Import Data Loader 'PACKING01ItemMaster.xlsx'
    And Wait for page loading
    And Wait for page loading
    And Wait for page loading
    And Verify notification message 'File PACKING01ItemMaster.xlsx from Item is imported successfully.'
    #End-Prerequisite of Item : Stop comment
    And Search Item With 'getdata(ItemIdStarting)'
    And Verify Item Id exist
    And Navigate to ASNs
    And Update ASN import file with Item Id LPN Packing by file 'PACKING01ASN.xlsx'
    And Clear Notifications
    And Click "byImportDataLoaderButton" on "HeaderPanelPage" WaitForPageLoading
    And Import Data Loader 'PACKING01ASN.xlsx'
    And Wait for page loading
    And Verify notification message 'File PACKING01ASN.xlsx from Asn is imported successfully.'
    And Search ASN at ASNs
    And Wait for page loading
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT Standard Receiving' at WM Mobile
    And Complete ATStandardReceiving with Item Packing
    And Close browser window And Switch to Last Window
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT User Directed Putaway' at WM Mobile
    And Complete ATUserDirectedPutaway with Item Packing for line 1 and line 2
    And Close browser window And Switch to Last Window
    And Navigate to Inventory Details
    And Verify Item Packing Details at Inventory Details
    And Navigate to Original Orders2
    And Update Original Order 2.0 import file with Item Id LPN Packing by file 'PACKING01OriginalOrder.xlsx'
    And Clear Notifications
    And Click "byImportDataLoaderButton" on "HeaderPanelPage" WaitForPageLoading
    And Import Data Loader 'PACKING01OriginalOrder.xlsx'
    And Wait for page loading
    And Verify notification message 'File PACKING01OriginalOrder.xlsx from OriginalOrder is imported successfully.'
    And Click "byRefreshBtn" on "OriginalOrdersPage"
    And Verify Imported Orders
    And Click "byRelatedLinks" on "OrdersPage"
    And Click "byOrderLines" on "OrdersPage"
    And Validate Orderslines status "READY"
    And Verify Item Id and Order Quantity at Original Order 2.0 in Order Lines Page
    And Validate Orders status "Released"
    And Execute RunWave
    And Navigate to Wave Runs
    And Search Wave run at Wave Runs
    And Validate Wave run status till "Completed"
    And Select Wave Run card
    And Click "byRelatedLinks" on "WaveRunsPage"
    And Click "byAllocations" on "WaveRunsPage"
    And Wait for page loading
    And Verify wave Run specifies the Correct Quantity and the Container in Allocations
    And Navigate to Wave Runs Homepage
    And Select Wave Run card
    And Click "byRelatedLinks" on "WaveRunsPage"
    And Click on oLPNs Links
    And Wait for page loading
    And Validate OLPN status "Created"
    And Store OLPN number in runtime variable
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT Pick to OLPN' at WM Mobile
    And Complete 'getdata(oLPNCount)' Packing in AT Pick OLPN
    And Close browser window And Switch to Last Window
    And Click "byRefreshButton" on "RightNavigationBar" WaitForPageLoading
    And Validate OLPN status "Packed"


  @Packing
  Scenario: DFN-PACKING-02: Create at least two orders single piece for the same client. Wave them and pick Pack the goods via Packing Station in separate oLPNs
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Edit OrgProfile
    And Navigate to Items Page
    And Search Item With "getdata(Item)"
    And Verify Item with 'getdata(Item)'
    And Update ASN for two orders single piece for the same client in "PACKING02ASN.xlsx"
    And Navigate to ASNs
    And Clear Notifications
    And Click "byImportDataLoaderButton" on "HeaderPanelPage" WaitForPageLoading
    And Import Data Loader "PACKING02ASN.xlsx"
    And Verify notification message 'File PACKING02ASN.xlsx from Asn is imported successfully.'
    And Search ASN at ASNs
    Then Verify ASN details are displayed
    And Verify ILPN linked to ASN with variable  "LPN"
    And Verify Product status and Inventory type in LPNPopup Page
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT Standard Receiving' at WM Mobile
    And Complete ATStandardReceiving with ASN and LPN
    And Close browser window And Switch to Last Window
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT User Directed Putaway' at WM Mobile
    And Complete ATUserDirectedPutAway with single LPN
    And Close browser window And Switch to Last Window
    And Navigate to Inventory Details
    And Search Item With "getdata(Item)"
    And Search LocationBarcode With "getdata(LocationBarCode)"
    And Verify OnHandQuantity in Inventory details page
    And Navigate to Original Orders2
    And Clear Notifications
    And Update Order for two orders single piece for the same client in "PACKING02Order.xlsx"
    And Click "byImportDataLoaderButton" on "HeaderPanelPage" WaitForPageLoading
    And Import Data Loader "PACKING02Order.xlsx"
    And Verify notification message 'File PACKING02Order.xlsx from OriginalOrder is imported successfully.'
    And Select checkbox "byMaximumStatusReleasedCheckbox" on "LeftPanelPage"
    And Search Order with variable "Orders"
    And Verify Multiple Orders with variable "Orders"
    And Verify Multiple Order Statuses with variable "getdata(BeforeOrderStatuses)"
    And Navigate to OrderLines Page
    And Search Order with variable "Orders"
    And Verify OrderLineNeed and OrderLineAttributes for multiple orders with variable "Orders"
    And Navigate to Original Orders2
    And Search Order with variable "Orders"
    And Complete "ATPickToToteOrderStrategy" Order strategy
    And Navigate to Wave Runs
    And Search Wave run at Wave Runs
    And Validate Wave run status till "Completed"
    And Click on Row At First Index
    And Click on Related Links
    And Click on Allocations Link
    Then Verify Row count as 2
    And Navigate to Wave Runs Homepage
    And Click on Row At First Index
    And Click on Related Links
    And Click on oLPNs Links
    Then Verify Row count as 2
    And Store Multiple OLPNs to variable
    And Navigate to Wave Runs Homepage
    And Click on Row At First Index
    And Click on Related Links
    And Click on Tasks Link
    And Store Taskid to variable
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'Enter Task' at WM Mobile
    And Enter the tasks details in Pick to Tote screen and complete the process
    And Close browser window And Switch to Last Window
    And Click "byRefreshButton" on "RightNavigationBar" WaitForPageLoading
    And Validate Task status "Completed"
    And Navigate to ILPNs
    And Search LPN with Variable Name "ToteId"
    And Verify Ilpn status as "getdata(ToteStatus)"
    And Navigate to Pack station "getdata(PackStation)"
    And Complete Packing for multiple oLPNs
    And Navigate to Wave Runs
    And Search Wave run at Wave Runs
    And Click on Row At First Index
    And Click on Related Links
    And Click on oLPNs Links
    And Verify Multiple oLPNs Statuses with variable "getdata(OLPNStatuses)"
    And Navigate to Wave Runs Homepage
    And Click on Row At First Index
    And Click on Related Links
    And Click on Orders Link
    And Verify Multiple Order Statuses with variable "getdata(AfterOrderStatuses)"

  @Packing
  Scenario: DFN-PACKING-03: Create one order multi piece WITH SERIAL NUMBER, allocate and pick Pack in pack station and collect all serial numbers requested
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Edit OrgProfile
    And Navigate to Items Page
    And Search Item With "getdata(Items)"
    And Verify Multiple Items with "getdata(Items)"
    And Update ASN for one order multi piece with Serial Number in "PACKING03ASN.xlsx"
    And Navigate to ASNs
    And Clear Notifications
    And Click "byImportDataLoaderButton" on "HeaderPanelPage" WaitForPageLoading
    And Import Data Loader "PACKING03ASN.xlsx"
    And Verify notification message 'File PACKING03ASN.xlsx from Asn is imported successfully.'
    And Search ASN at ASNs
    Then Verify ASN details are displayed
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT Standard Receiving' at WM Mobile
    And Complete ATStandardReceiving with ASN and multiple LPNs with Serial Numbers
    And Close browser window And Switch to Last Window
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT User Directed Putaway' at WM Mobile
    And Complete ATUserDirectedPutAway with multiple LPNs
    And Close browser window And Switch to Last Window
    And Navigate to Inventory Details
    And Search Item With "getdata(Items)"
    And Search LocationBarcode With "getdata(LocationBarCodes)"
    And Verify OnHandQuantity in Inventory details page
    And Navigate to Original Orders2
    And Clear Notifications
    And Update Order for one order multi piece with Serial Number in "PACKING03Order.xlsx"
    And Click "byImportDataLoaderButton" on "HeaderPanelPage" WaitForPageLoading
    And Import Data Loader "PACKING03Order.xlsx"
    And Verify notification message 'File PACKING03Order.xlsx from OriginalOrder is imported successfully.'
    And Select checkbox "byMaximumStatusReleasedCheckbox" on "LeftPanelPage"
    And Search Order with variable "Orders"
    And Verify Multiple Orders with variable "Orders"
    And Verify Multiple Order Statuses with variable "getdata(BeforeOrderStatuses)"
    And Navigate to OrderLines Page
    And Search Order with variable "Orders"
    And Verify OrderLineNeed and OrderLineAttributes for multiple orders with variable "Orders"
    And Navigate to Original Orders2
    And Search Order with variable "Orders"
    And Complete "ATPickToToteOrderStrategy" Order strategy
    And Navigate to Wave Runs
    And Search Wave run at Wave Runs
    And Validate Wave run status till "Completed"
    And Click on Row At First Index
    And Click on Related Links
    And Click on Allocations Link
    Then Verify Row count as 2
    And Navigate to Wave Runs Homepage
    And Click on Row At First Index
    And Click on Related Links
    And Click on oLPNs Links
    Then Verify Row count as 1
    And Store Multiple OLPNs to variable
    And Navigate to Wave Runs Homepage
    And Click on Row At First Index
    And Click on Related Links
    And Click on Tasks Link
    And Store Taskid to variable
    And Click on Row At First Index
    And Assign Task to current user
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'Enter Task' at WM Mobile
    And Complete Pick to Tote process with multiple items with serial number
    And Close browser window And Switch to Last Window
    And Click "byRefreshButton" on "RightNavigationBar" WaitForPageLoading
    And Validate Task status "Completed"
    And Navigate to ILPNs
    And Search LPN with Variable Name "ToteId"
    And Verify Ilpn status as "getdata(ToteStatus)"
    And Navigate to Pack station "getdata(PackStation)"
    And Complete Packing for multiple items with serial number
    And Navigate to Wave Runs
    And Search Wave run at Wave Runs
    And Click on Row At First Index
    And Click on Related Links
    And Click on oLPNs Links
    And Verify Multiple oLPNs Statuses with variable "getdata(OLPNStatuses)"
    And Navigate to Wave Runs Homepage
    And Click on Row At First Index
    And Click on Related Links
    And Click on Orders Link
    And Verify Multiple Order Statuses with variable "getdata(AfterOrderStatuses)"

  @Packing
  Scenario: DFN-PACKING-04 : Create at least two Multi-SKU, multi-units for the same client, both with serial number. Wave them and pick Pack the goods and collect all serial numbers requested
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Edit OrgProfile
    And Navigate to Items Page
    And Search Item With "getdata(Items)"
    And Verify Multiple Items with "getdata(Items)"
    And Update ASN for one order multi piece with Serial Number in "PACKING04ASN.xlsx"
    And Navigate to ASNs
    And Clear Notifications
    And Click "byImportDataLoaderButton" on "HeaderPanelPage" WaitForPageLoading
    And Import Data Loader "PACKING04ASN.xlsx"
    And Verify notification message 'File PACKING04ASN.xlsx from Asn is imported successfully.'
    And Search ASN at ASNs
    Then Verify ASN details are displayed
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT Standard Receiving' at WM Mobile
    And Complete ATStandardReceiving with ASN and multiple LPNs with Serial Numbers
    And Close browser window And Switch to Last Window
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT User Directed Putaway' at WM Mobile
    And Complete ATUserDirectedPutAway with multiple LPNs
    And Close browser window And Switch to Last Window
    And Navigate to Inventory Details
    And Search Item With "getdata(Items)"
    And Search LocationBarcode With "getdata(LocationBarCodes)"
    And Verify OnHandQuantity in Inventory details page
    And Navigate to Original Orders2
    And Clear Notifications
    And Update Order for Multi-SKU, multi-units for the same client, both with serial number in "PACKING04Order.xlsx"
    And Click "byImportDataLoaderButton" on "HeaderPanelPage" WaitForPageLoading
    And Import Data Loader "PACKING04Order.xlsx"
    And Verify notification message 'File PACKING04Order.xlsx from OriginalOrder is imported successfully.'
    And Select checkbox "byMaximumStatusReleasedCheckbox" on "LeftPanelPage"
    And Search Order with variable "Orders"
    And Verify Multiple Orders with variable "Orders"
    And Verify Multiple Order Statuses with variable "getdata(BeforeOrderStatuses)"
    And Navigate to OrderLines Page
    And Search Order with variable "Orders"
    And Verify OrderLineNeed and OrderLineAttributes for multiple orders with variable "Orders"
    And Navigate to Original Orders2
    And Search Order with variable "Orders"
    And Complete "ATPickToToteOrderStrategy" Order strategy
    And Navigate to Wave Runs
    And Search Wave run at Wave Runs
    And Validate Wave run status till "Completed"
    And Click on Row At First Index
    And Click on Related Links
    And Click on Allocations Link
    Then Verify Row count as 4
    And Navigate to Wave Runs Homepage
    And Click on Row At First Index
    And Click on Related Links
    And Click on oLPNs Links
    Then Verify Row count as 2
    And Navigate to Wave Runs Homepage
    And Click on Row At First Index
    And Click on Related Links
    And Click on Tasks Link
    And Store Multiple Tasks to variable
    And Click on Row At First Index
    And Click on Row At Second Index
    And Assign Task to current user
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'Enter Task' at WM Mobile
    And Complete Pick to Tote process with multiple items with serial number for multiple Tasks
    And Close browser window And Switch to Last Window
    And Click "byRefreshButton" on "RightNavigationBar" WaitForPageLoading
    And Verify Multiple Tasks status as "getdata(TaskStatuses)"
    And Navigate to ILPNs
    And Click "byRefreshButton" on "RightNavigationBar" WaitForPageLoading
    And Search LPN with Variable Name "ToteId1"
    And Verify Ilpn status as "getdata(ToteStatus)"
    And Search LPN with Variable Name "ToteId2"
    And Verify Ilpn status as "getdata(ToteStatus)"
    And Navigate to Pack station "getdata(PackStation)"
    And Complete Packing for multiple items with serial number for multiple Totes
    And Navigate to Wave Runs
    And Search Wave run at Wave Runs
    And Click on Row At First Index
    And Click on Related Links
    And Click on oLPNs Links
    And Verify Multiple oLPNs Statuses with variable "getdata(OLPNStatuses)"
    And Navigate to Wave Runs Homepage
    And Click on Row At First Index
    And Click on Related Links
    And Click on Orders Link
    And Verify Multiple Order Statuses with variable "getdata(AfterOrderStatuses)"