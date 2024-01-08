@DFN
Feature: CUBING_Test_Cases
##List of Test Cases covered
## TC    TS No.	Test Case Name
## 001.  1          FN-CUBING-01-Wave multiple orders and cubing generated different container size for oLPNs (ITS-CUBING-01)
## 002.  2          FN-CUBING-02 : Cubing multiple oLPNs same order
## 003.  3          FN-CUBING-03 : Selection of oLPN Type based on order-customer
## 004.  4          FN-CUBING-04 : Cubing by Quantity
## 005.  5          FN-CUBING-05 - Cubing by Break Attribute
## 006.  6          FN-CUBING-06 : Cubing by orignial carton/mixture of orignial and non-original

# 1. FN-CUBING-01-Wave multiple orders and cubing generated different container size for oLPNs
# Jira Id - MAWMTF01-93
# Test cases covered : 1
  @CUBING
  Scenario: FN-CUBING-01-Wave multiple orders and cubing generated different container size for oLPNs
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Edit OrgProfile
    And Navigate to Items Page
    And Search Item With "getdata(Item)"
    And Verify Multiple Items with "getdata(Items)"
    And Update ASN export file with LPN "AsnLpn.xlsx"
    And Navigate to ASNs
    And Click "byImportDataLoaderBtn" on "ASNs"
    And Import Data Loader "AsnLpn.xlsx"
    And Wait for page loading
    And Verify notification message 'File AsnLpn.xlsx from Asn is imported successfully.'
    And Search ASN at ASNs
    And Verify ASN details are displayed
    And Validate ASN status "In Transit"
    And Verify Inventory Details for multiple ilpns
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT Standard Receiving' at WM Mobile
    And Complete ATStandardReceiving with LPNs
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
    And Search menu 'AT User Directed Putaway' at WM Mobile
    And Enter ILPN and Location in AT User Directed PutAway
    And Close browser window And Switch to Last Window
    And Navigate to Inventory Details
    And Verify Inventory Details All Cell Value for ListOfItems
    And Navigate to Original Orders2
    And Clear Notifications
    And Update Order for three orders single piece for the same client in "OrdersCubing01.xlsx"
    And Click "byImportDataLoaderBtn" on "OriginalOrdersPage"
    And Import Data Loader "OrdersCubing01.xlsx"
    And Wait for page loading
    And Verify notification message 'File OrdersCubing01.xlsx from OriginalOrder is imported successfully.'
    And Click "byRefreshBtn" on "OriginalOrdersPage"
    And Search Order with variable "Orders"
    And Verify Order Line Details for imported Orders "Orders"
    And Navigate to Order Planning Strategy
    And View FNCUBING wave Strategy "getdata(WaveStrategy)"
    And Select Order Selection Criteria
    And Wait for page loading
    And Navigate to Cubing Strategy
    And View FNCubing Cubing Strategy "getdata(CubingStrategy)"
    And Verify Cubing method parameters in cube to capacity
    And Verify Residential parameters in cube to capacity
    And Navigate to Container Type
    And View Container Size Definition "getdata(ContainerType1)"
    Then verify Container Size Definition details for multiple container
    And Wait for page loading
    And Navigate back to Original Orders
    And Wait for page loading
    And Search Order with variable "Orders"
    And Complete "FNCUBING01OrderStrategy" Order strategy
    And Navigate to Wave Runs
    And Click "byRefreshButton" on "RightNavigationBar" WaitForPageLoading
    And Search Wave run at Wave Runs
    And Validate Wave run status till "Completed"
    And Click on Row At First Index
    And Click on Related Links
    And Click on oLPNs Links
    Then Verify Row count as 3
    And Wait for page loading
    And Navigate to Original Orders2
    And Search Order with variable "Orders"
    Then Verify Each OLPNs Container sizes based on the container quantity for "Orders"


  Scenario: FN-CUBING-02 : Cubing multiple oLPNs same order
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Edit OrgProfile
    And Navigate to Items Page
    And Search Item With "getdata(Item)"
    And Update ASN file with LPN "AsnCUBING02.xlsx"
    And Navigate to ASNs
    And Click "byImportDataLoaderBtn" on "ASNs"
    And Import Data Loader "AsnCUBING02.xlsx"
    And Wait for page loading
    And Verify notification message 'File AsnCUBING02.xlsx from Asn is imported successfully.'
    And Search ASN at ASNs
    And Verify ASN details are displayed
    And Validate ASN status "In Transit"
    And Verify ILPN linked to ASN with variable  "LPN"
    And Verify Product status and Inventory type for multiple lpns in LPNPopup Page
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT Standard Receiving' at WM Mobile
    And Complete ATStandardReceiving with ASN and LPN
    And Click ok in popup message in WM mobile
    And Click on Menu in WM mobile
    And Confirm prompt in WM mobile
    And Search menu 'AT User Directed Putaway' at WM Mobile
    And Complete ATUserDirectedPutAway with single LPN
    And Close browser window And Switch to Last Window
    And Navigate to Inventory Details
    And Search with Item Filter "getdata(Item)"
    And Filter by Inventory Details with InventoryReservation and Location Type
    And Verify LPN details in Inventory Details page with location
    And Navigate to Original Orders2
    And Update Original Order with one line 'OrdersCUBING02.xlsx'
    And Click "byImportDataLoaderBtn" on "OriginalOrdersPage"
    And Import Data Loader "OrdersCUBING02.xlsx"
    And Wait for page loading
    And Verify notification message 'File OrdersCUBING02.xlsx from OriginalOrder is imported successfully.'
    And Search Order with variable "OriginalOrder"
    And Verify Multiple Orders with variable "OriginalOrder"
    And Navigate to OrderLines Page
    And Search Order with variable "OriginalOrder"
    And Verify OrderLineNeed and OrderLineAttributes for multiple orders with variable "OriginalOrder"
    And Navigate to Original Orders2
    And Search Order with variable "OriginalOrder"
    And Validate Orders status "Released"
    And Navigate to Order Planning Strategy
    And View FNCUBING wave Strategy "getdata(WaveStrategy)"
    And Select selection criteria, cubing and verify Selected Cubing Strategy
    And Wait for page loading
    And Navigate to Cubing Strategy
    And View FNCubing Cubing Strategy "getdata(CubingStrategy)"
    And Verify Cubing method parameters in cube to capacity
    And Verify Residential parameters in cube to capacity
    And Navigate to Container Type
    And View Container Size Definition "getdata(ContainerTypeID)"
    And verify Container Size Definition details for multiple container
    And Navigate back to Original Orders
    And Execute FNCUBINGIIOrderStrategy RunWave for Orders
    And Navigate to Wave Runs
    And Click "byRefreshButton" on "RightNavigationBar" WaitForPageLoading
    And Search Wave run at Wave Runs
    And Validate Wave run status till "Completed"
    And Click on Row At First Index
    And Click on Related Links
    And Click on oLPNs Links
    Then Verify Row count as 3
    And Wait for page loading
    And Store Multiple OLPNs to variable
    And Verify Multiple OLPNS size and quantity

  Scenario: FN-CUBING-03 : Selection of oLPN Type based on order-customer
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Edit OrgProfile
    And Navigate to Items Page
    And Search Item With "getdata(Item)"
    And Update ASN file with LPN "AsnCUBING03.xlsx"
    And Navigate to ASNs
    And Click "byImportDataLoaderBtn" on "ASNs"
    And Import Data Loader "AsnCUBING03.xlsx"
    And Wait for page loading
    And Verify notification message 'File AsnCUBING03.xlsx from Asn is imported successfully.'
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
    And Close browser window And Switch to Last Window
    And Navigate to Inventory Details
    And Search with Item Filter "getdata(Items)"
    And Search LocationBarcode With "getdata(LocationBarCode)"
    And Verify multiple Ilpns Data In Inventory Details_with ListOfItems
    And Navigate to Original Orders2
    And Update Order for three orders single piece for the same client in "OrdersCUBING03.xlsx"
#    And Update Original Orders with three lines "OrdersCUBING03.xlsx"
    And Click "byImportDataLoaderBtn" on "OriginalOrdersPage"
    And Import Data Loader "OrdersCUBING03.xlsx"
    And Wait for page loading
    And Verify notification message 'File OrdersCUBING03.xlsx from OriginalOrder is imported successfully.'
    And Click "byRefreshBtn" on "OriginalOrdersPage"
    And Search Order with variable "Orders"
    And Verify Order Line Need And Attribute Details for imported Orders "Orders"
    And Navigate to Order Planning Strategy
    And View FNCUBING wave Strategy "getdata(WaveStrategy)"
    And Select Order Selection Criteria
    And Wait for page loading
    And Navigate to Cubing Strategy
    And View FNCubing Cubing Strategy "getdata(CubingStrategy)"
    And Select Cube To Capacity Criteria
    Then Verify Cubing method parameters and residential parameters for each cube to capacity criteria type
    And Navigate Container Type
    Then verify Container Size Definition details for multiple container type
    And Navigate to Original Orders2
    And Wait for page loading
    And Search Order with variable "Orders"
    And Complete "FNCUBING03OrderStrategy" Order strategy
    And Navigate to Wave Runs
    And Wait for page loading
    And Click "byRefreshButton" on "RightNavigationBar" WaitForPageLoading
    And Wait for page loading
    And Search Wave run at Wave Runs
    And Validate Wave run status till "Completed"
    And Click on Row At First Index
    And Click on Related Links
    And Click on oLPNs Links
    And Wait for page loading
    And Store Multiple OLPNs to variable
    And Navigate to Original Orders2
    And Search Order with variable "Orders"
    And Verify Each OLPN has unique container type and size as per the cube capacity for "Orders"


  Scenario: FN-CUBING-04 : Cubing by Quantity
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Edit OrgProfile
    And Navigate to Items Page
    And Search Item With "getdata(Item)"
    And Update ASN file with LPN "AsnCUBING04.xlsx"
    And Navigate to ASNs
    And Click "byImportDataLoaderBtn" on "ASNs"
    And Import Data Loader "AsnCUBING04.xlsx"
    And Wait for page loading
    And Verify notification message 'File AsnCUBING04.xlsx from Asn is imported successfully.'
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
    And Close browser window And Switch to Last Window
    And Navigate to Inventory Details
    And Search with Item Filter "getdata(Item)"
    And Search LocationBarcode With "getdata(LocationBarCode)"
    And Verify Inventory Details All Cell Value for ListOfItems
    And Navigate to Original Orders2
    And Update Original Order with one line "OrdersCUBING04.xlsx"
    And Click "byImportDataLoaderBtn" on "OriginalOrdersPage"
    And Import Data Loader "OrdersCUBING04.xlsx"
    And Wait for page loading
    And Verify notification message 'File OrdersCUBING04.xlsx from OriginalOrder is imported successfully.'
    And Click "byRefreshBtn" on "OriginalOrdersPage"
    And Verify Imported Orders
    And Click "byRelatedLinks" on "HeaderPanelPage"
    And Wait for page loading
    And Click "byOrderLines" on "OrdersPage"
    And Wait for page loading
    And Verify OrderLineNeed and OrderLineAttributes for multiple orders with variable "OriginalOrder"
    And Navigate to Original Orders2
    And Search Order with variable "OriginalOrder"
    And Validate Orders status "Released"
    And Navigate to Order Planning Strategy
    And View FNCUBING wave Strategy "getdata(WaveStrategy)"
    And Select selection criteria, cubing and verify Selected Cubing Strategy
    And Wait for page loading
    And Navigate to Cubing Strategy
    And View FNCubing Cubing Strategy "getdata(CubingStrategy)"
    And Verify Cubing method parameters in cube to capacity
    And Verify Residential parameters in cube to capacity
    And Navigate to Container Type
    And View Container Size Definition "getdata(ContainerTypeId)"
    And verify Container Size Definition details
    And Navigate back to Original Orders
    And Filter Original Orders2
    And Execute RunWave from Original Orders in Cubing04
    And Navigate to Wave Runs
    And Search Wave run at Wave Runs
    And Validate Wave run status till "Completed"
    And Select First Row
    And Click "byRelatedLinks" on "WaveRunsPage"
    And Wait for page loading
    And Select Olpns Option
    And Wait for page loading
    And validate OLPNs count 4
    And Verify Multiple oLPNs Statuses with variable "getdata(OLPNStatuses)"
    And Verify OrderID For OLPNs In OLPN Page "OriginalOrder"
    And Verify Container Details In OLPN Page

  Scenario: FN-CUBING-05 - Cubing by Break Attribute
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Edit OrgProfile
    And Navigate to Items Page
    And Search Item With 'getdata(Items)'
    And Verify Multiple Items with 'getdata(Items)'
    And Navigate to ASNs
    And Update ASN File With Four LPNs'CUBING05ASN.xlsx'
    And Clear Notifications
    And Click "byImportDataLoaderButton" on "HeaderPanelPage" WaitForPageLoading
    And Import Data Loader 'CUBING05ASN.xlsx'
    And Wait for page loading
    And Verify notification message 'File CUBING05ASN.xlsx from Asn is imported successfully.'
    And Search ASN at ASNs
    And Wait for page loading
    And Verify ASN details are displayed
    And Validate ASN status "In Transit"
    And Verify ILPNs linked to ASN with variable  "listOfILPNs"
    And Verify Product status and Inventory type for multiple lpns in LPNPopup Page
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT Standard Receiving' at WM Mobile
    And Complete ATStandardReceiving with ASN and multiple LPNs
    And Click ok in popup message in WM mobile
    And Click on Menu in WM mobile
    And Confirm prompt in WM mobile
    And Search menu 'AT User Directed Putaway' at WM Mobile
    And Complete ATUserDirectedPutAway with multiple LPNs
    And Close browser window And Switch to Last Window
    And Navigate to Inventory Details
    And Search Item With 'getdata(Item)'
    And Filter by Inventory Details with InventoryReservation and Location Type
    And Verify multiple Ilpns Data In Inventory Details_with ListOfItems
    And Navigate to Original Orders2
    And Clear Notifications
    And Update order File With order in four rows "CUBING05Order.xlsx"
    And Click "byImportDataLoaderButton" on "HeaderPanelPage" WaitForPageLoading
    And Import Data Loader "CUBING05Order.xlsx"
    And Verify notification message 'File CUBING05Order.xlsx from OriginalOrder is imported successfully.'
##    And Select checkbox "byMaximumStatusReleasedCheckbox" on "LeftPanelPage"
    And Search Order with variable "OriginalOrder"
    And Verify Multiple Orders with variable "OriginalOrder"
    And Navigate to OrderLines Page
    And Search Order with variable "OriginalOrder"
    And Verify OrderLineNeed and OrderLineAttributes for multiple orders with variable "OriginalOrder"
    And Navigate to Original Orders2
    And Search Order with variable "OriginalOrder"
    And Validate Orders status "Released"
    And Navigate to Order Planning Strategy
    And View FNCUBING wave Strategy "getdata(WaveStrategy)"
#    And Select Order Selection Criteria
    And Select selection criteria, cubing and verify Selected Cubing Strategy
    And Wait for page loading
    And Navigate to Cubing Strategy
    And View FNCubing Cubing Strategy "getdata(CubingStrategy)"
    And Verify Cubing method parameters in cube to capacity
    And Verify Residential parameters in cube to capacity
    And select BreakByCritera And Verify Configuration
    And Navigate to Container Type
    And View Container Size Definition "getdata(ContainerTypeId)"
    And verify Container Size Definition details
    And Navigate back to Original Orders
    And Search Order with variable "OriginalOrder"
    And Complete "FNCUBING05OrderStrategy" Order strategy
    And Navigate to Wave Runs
    And Search Wave run at Wave Runs
    And Click "byRefreshButton" on "RightNavigationBar" WaitForPageLoading
    And Search Wave run at Wave Runs
    And Validate Wave run status till "Completed"
    And Click on Row At First Index
    And Click on Related Links
    And Click on oLPNs Links
    Then Verify Row count as 2
    And Wait for page loading
    And Store Multiple OLPNs to variable
    And Select First Row
    And verify Product Status And Class List for olpn 'ProductStatusID' 'ProductClass1'
    And Select First Row
    And Select Second Row
    And verify Product Status And Class List for olpn 'ProductStatusID' 'ProductClass2'

  Scenario: FN-CUBING-06 : Cubing by orignial carton/mixture of orignial and non-original
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Edit OrgProfile
    And Navigate to Items Page
    And Search Item With "getdata(Item)"
    And Verify Multiple Items with 'getdata(Items)'
    And Update ASN file with LPN "AsnCUBING06.xlsx"
    And Navigate to ASNs
    And Click "byImportDataLoaderBtn" on "ASNs"
    And Import Data Loader "AsnCUBING06.xlsx"
    And Wait for page loading
    And Verify notification message 'File AsnCUBING06.xlsx from Asn is imported successfully.'
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
    And Search menu 'AT User Directed Putaway' at WM Mobile
    And Complete ATUserDirectedPutAway with single LPN
    And Close browser window And Switch to Last Window
    And Navigate to Inventory Details
    #And Expand Filter
    And Search with Item Filter "getdata(Item)"
    And Filter by Inventory Details with InventoryReservation and Location Type
    And Verify multiple Ilpns Data In Inventory Details_with ListOfItems
    And Navigate to Original Orders2
    And Update Original Orders with three lines "OrdersCUBING06.xlsx"
    And Click "byImportDataLoaderBtn" on "OriginalOrdersPage"
    And Import Data Loader "OrdersCUBING06.xlsx"
    And Wait for page loading
    And Verify notification message 'File OrdersCUBING06.xlsx from OriginalOrder is imported successfully.'
    And Navigate to OrderLines Page
    And Search Order with variable "OriginalOrder1"
    And Verify OrderLineNeed and OrderLineAttributes for multiple orders with variable "listOfOrders"
    And Search Order with variable "OriginalOrder2"
    And Verify OrderLineNeed and OrderLineAttributes for multiple orders with variable "listOfOrders"
    And Search Order with variable "OriginalOrder3"
    And Verify OrderLineNeed and OrderLineAttributes for multiple orders with variable "listOfOrders"
    And Navigate to Original Orders2
    And Search Order with variable "OriginalOrder1"
    And Validate Orders status "Released"
    And Search Order with variable "OriginalOrder2"
    And Validate Orders status "Released"
    And Search Order with variable "OriginalOrder3"
    And Validate Orders status "Released"
    And Click "byRefreshBtn" on "OriginalOrdersPage"
    And Navigate to Order Planning Strategy
    And View FNCUBING wave Strategy
    And Select Order Selection Criteria
    And Wait for page loading
    And Navigate to Allocation Strategy
    And View FNCubing Allocation Strategy "getdata(AllocationStrategy)"
    And Verify Allocation Strategy
    And Verify Inventory Criteria
    And Select Allocation Zone Priorities
    And Verify Allocation Zone Priorities
    And Navigate back to Cubing Strategy
    And View FNCubing Cubing Strategy "getdata(CubingStrategy)"
    And View CubeByUOMCriteria Cubing Method
    And Verify Cubing method parameter in cube to capacity
    And Verify Residential parameters in cube to capacity
    And Navigate Back to Container Type
    And View Container Size Definition "getdata(ContainerTypeId)"
    And verify Container Size Definition details
    And verify Container Size Definition details for multiple container
    And Navigate back to Original Orders
    And Run FNCUBING Wave for three Orders
    And Navigate to Wave Runs
    And Click "byRefreshButton" on "RightNavigationBar" WaitForPageLoading
    And Search Wave run at Wave Runs
    And Wait for wave to load
    #And Wait for wave to load
    #Giving extra time to wait for wave to complete
    And Validate Wave run status till "Completed"
    And Click on Row At First Index
    And Click on Related Links
    And Wait for page loading
    And Click on oLPNs Links
    And Wait for page loading
    And Store Multiple OLPNs to variable
    And Wait for page loading
    And Search Order in OLPNs with variable "OriginalOrder1"
    And Verify Container Details In OLPNs Page for First Order
    And Search Order in OLPNs with variable "OriginalOrder3"
    And Verify Container Details In OLPNs Page for Second Order
    And Search Order in OLPNs with variable "OriginalOrder2"
    And Verify Container Details In OLPNs Page for Third Order

