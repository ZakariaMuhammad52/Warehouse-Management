@DFN
Feature: Wave_Test_Cases
##List of Test Cases covered
## TC    TS No.	Test Case Name
## 001.  FN-WAVE-01-Wave multiple orders (ITS-WAVE-01)
## 002.  FN-WAVE-02 - Wave multiple orders with rule criteria (ITS-WAVE-02)
## 003.  FN-WAVE-03 -Wave multiple orders following priority sequence under wave capacity (ITS-WAVE-03)


# 1. FN-WAVE-01-Wave multiple orders
# Jira Id - MAWMTF01-90
# Test cases covered : 1
  @Wave
  Scenario: FN-WAVE-01-Wave multiple orders
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Edit OrgProfile
    And Navigate to Items Page
    And Search Item With "getdata(Items)"
    And Verify Multiple Items with "getdata(Items)"
    And Update ASN for Wave multiple orders with ILPN level with three line 'Wave01ASN.xlsx'
    And Navigate to ASNs
    And Clear Notifications
    And Click "byImportDataLoaderButton" on "HeaderPanelPage" WaitForPageLoading
    And Import Data Loader "Wave01ASN.xlsx"
    And Verify notification message 'File Wave01ASN.xlsx from Asn is imported successfully.'
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
    And Search Item With "getdata(Items)"
    And Search LocationBarcode With "getdata(LocationBarCode)"
    And Verify Multiple Items details in Inventory Details page
    And Navigate to Original Orders2
    And Clear Notifications
    And Update Order for Wave multiple orders with ILPN level with three line 'Wave01Order.xlsx'
    And Click "byImportDataLoaderButton" on "HeaderPanelPage" WaitForPageLoading
    And Import Data Loader "Wave01Order.xlsx"
    And Verify notification message 'File Wave01Order.xlsx from OriginalOrder is imported successfully.'
    And Search Order with variable "Orders"
    And Verify Multiple Orders with variable "Orders"
    And Verify Multiple Order Statuses with variable "getdata(BeforeOrderStatuses)"
    And Navigate to OrderLines Page
    And Search Order with variable "Orders"
    And Verify OrderLineNeed and OrderLineAttributes for multiple orders with variable "Orders"
    And Navigate to Original Orders2
    And Search Order with variable "Orders"
    And Complete "ATStandardOrderStrategy" Order strategy
    And Navigate to Wave Runs
    And Search Wave run at Wave Runs
    And Validate Wave run status till "Completed"
    And Navigate to Original Orders2
    And Search Order with variable "Orders"
    And Verify Multiple Order Statuses with variable "getdata(AfterOrderStatuses)"

# 2. FN-WAVE-02-Wave multiple orders with rule criteria
# Jira Id - MAWMTF01-91
# Test cases covered : 1
  @Wave
  Scenario: FN-WAVE-02-Wave multiple orders with rule criteria
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Edit OrgProfile
    And Navigate to Items Page
    And Search Item With "getdata(Items)"
    And Verify Multiple Items with "getdata(Items)"
    And Update ASN for Wave multiple orders with rule criteria in "Wave02ASN.xlsx"
    And Navigate to ASNs
    And Clear Notifications
    And Click "byImportDataLoaderButton" on "HeaderPanelPage" WaitForPageLoading
    And Import Data Loader "Wave02ASN.xlsx"
    And Verify notification message 'File Wave02ASN.xlsx from Asn is imported successfully.'
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
    And Search Item With "getdata(Items)"
    And Search LocationBarcode With "getdata(LocationBarCode)"
    And Verify Multiple Items details in Inventory Details page
    And Navigate to Original Orders2
    And Clear Notifications
    And Update Order for Wave multiple orders with rule criteria in "Wave02Order.xlsx"
    And Click "byImportDataLoaderButton" on "HeaderPanelPage" WaitForPageLoading
    And Import Data Loader "Wave02Order.xlsx"
    And Verify notification message 'File Wave02Order.xlsx from OriginalOrder is imported successfully.'
    And Search Order with variable "Orders"
    And Verify Multiple Orders with variable "Orders"
    And Verify Multiple Priorities with variable "getdata(Priorities)"
    And Verify Multiple Order Statuses with variable "getdata(BeforeOrderStatuses)"
    And Navigate to OrderLines Page
    And Search Order with variable "Orders"
    And Verify OrderLineNeed and OrderLineAttributes for multiple orders with variable "Orders"
    And Navigate to Order Planning Strategy Page
    And Verify FNWAVETwoOrderStrategy in Order Planning Strategy Page
    And Click on FNWAVETwoOrderStrategy in Order Planning Strategy Page
    And Click on RunWave
    And Store RunWaveId
    And Navigate to Wave Runs
    And Search Wave run at Wave Runs
    And Validate Wave run status till "Completed"
    And Navigate to Original Orders2
    And Search Order with variable "Orders"
    And Verify Multiple Order Statuses with variable "getdata(AfterOrderStatuses)"

# 3. FN-WAVE-03-Wave multiple orders following priority sequence under wave capacity
# Jira Id - MAWMTF01-92
# Test cases covered : 1
  @Wave
  Scenario: FN-WAVE-03-Wave multiple orders following priority sequence under wave capacity
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Edit OrgProfile
    And Navigate to Items Page
    And Search Item With "getdata(Items)"
    And Verify Multiple Items with "getdata(Items)"
    And Update ASN for Wave multiple orders with rule criteria in "Wave03ASN.xlsx"
    And Navigate to ASNs
    And Clear Notifications
    And Click "byImportDataLoaderButton" on "HeaderPanelPage" WaitForPageLoading
    And Import Data Loader "Wave03ASN.xlsx"
    And Verify notification message 'File Wave03ASN.xlsx from Asn is imported successfully.'
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
    And Search Item With "getdata(Items)"
    And Search LocationBarcode With "getdata(LocationBarCode)"
    And Verify Multiple Items details in Inventory Details page
    And Navigate to Original Orders2
    And Clear Notifications
    And Update Order for Wave multiple orders with rule criteria in "Wave03Order.xlsx"
    And Click "byImportDataLoaderButton" on "HeaderPanelPage" WaitForPageLoading
    And Import Data Loader "Wave03Order.xlsx"
    And Verify notification message 'File Wave03Order.xlsx from OriginalOrder is imported successfully.'
    And Search Order with variable "Orders"
    And Verify Multiple Orders with variable "Orders"
    And Verify Multiple Priorities with variable "getdata(Priorities)"
    And Verify Multiple Order Statuses with variable "getdata(BeforeOrderStatuses)"
    And Navigate to OrderLines Page
    And Search Order with variable "Orders"
    And Verify OrderLineNeed and OrderLineAttributes for multiple orders with variable "Orders"
    And Navigate to Order Planning Strategy Page
    And Verify FNWAVEThreeOrderStrategy in Order Planning Strategy Page
    And Click on FNWAVEThreeOrderStrategy in Order Planning Strategy Page
    And Click on RunWave
    And Store RunWaveId
    And Navigate to Wave Runs
    And Search Wave run at Wave Runs
    And Validate Wave run status till "Completed"
    And Navigate to Original Orders2
    And Search Order with variable "Orders"
    And Verify Multiple Order Statuses with variable "getdata(AfterOrderStatuses)"
