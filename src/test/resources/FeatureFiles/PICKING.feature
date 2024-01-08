@DFNPICKING
Feature: Picking_Test_Cases
##List of Test Cases covered
## TC    TS No.	Test Case Name
## 001.  1         FN-PICKING-02 - Create at least two orders single piece for the same client.Select proper task group and get the task. Proceed with picking. No shorts

# Test data : 					Values which are pased as part of test data 
# Pre-requiste Steps : 	Steps which are required to be performed/validated to prepare AUT for executing the scenario 
# Test Case : 					FN-PICKING-02 - Test Picking Single Order Tote (ITS-PICK-PACK-01)

  @PickingTwoOrder
  Scenario: FN-PICKING-02 - Create at least two orders single piece for the same client.Select proper task group and get the task. Proceed with picking. No shorts
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Edit OrgProfile
    And Navigate to Items Page
    And Search Item With 'getdata(Item)'
    And Verify Item Id exist
    And Navigate to ASNs
    And Update ASN file with LPN 'PICKING02ASN.xlsx'
    And Clear Notifications
    And Click "byImportDataLoaderButton" on "HeaderPanelPage" WaitForPageLoading
    And Import Data Loader 'PICKING02ASN.xlsx'
    And Wait for page loading
    And Verify notification message 'File PICKING02ASN.xlsx from Asn is imported successfully.'
    And Search ASN at ASNs
    And Wait for page loading
    And Verify ASN details are displayed
    And Validate ASN status "In Transit"
    And Verify ILPN linked to ASN with variable  "LPN"
    And Verify Ilpn status as "In Transit"
    And Verify SKU ,Product status, Quantity and Inventory type in LPNPopup Page
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT Standard Receiving' at WM Mobile
    And Complete ATStandardReceiving with ASN and LPN
    And Click ok in popup message in WM mobile
    And Click on Menu in WM mobile
    And Confirm prompt in WM mobile
    And Search menu 'AT System Directed Putaway' at WM Mobile
    And Putaway LPN AT System Directed
    And Close browser window And Switch to Last Window
    And Navigate to Inventory Details
    And Search Inventory Container with variable 'LPN'
    And Search Item With 'getdata(Item)'
    And Verify OnHandQuantity in Inventory details page
    And Click "byRefreshButton" on "RightNavigationBar" WaitForPageLoading
    #And Navigate to Inventory Details
#    And Search Inventory Container with variable 'LPN'
#    And Search Item With 'getdata(Item)'
#    And Verify OnHandQuantity in Inventory details page
    And Navigate to Original Orders2
    And Clear Notifications
    And Update Order for two orders single piece for the same client in "PICKING02Order.xlsx"
    And Click "byImportDataLoaderButton" on "HeaderPanelPage" WaitForPageLoading
    And Import Data Loader "PICKING02Order.xlsx"
    And Verify notification message 'File PICKING02Order.xlsx from OriginalOrder is imported successfully.'
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
    And Validate Task status "Ready For Assign..."
    And Click on Row At First Index
    And Assign Task to current user
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'Enter Task' at WM Mobile
    And Enter the tasks details in Pick to Tote screen and complete the process with scan location
    And Close browser window And Switch to Last Window
    And Click "byRefreshButton" on "RightNavigationBar" WaitForPageLoading
    And Validate Task status "Completed"
    And Navigate to ILPNs
    And Search LPN with Variable Name "ToteId"
    And Verify Ilpn status as "getdata(ToteStatus)"




 
