@DFN
Feature: Alloc

##List of Test Cases covered
## TC    TS No.	Test Case Name
## 001.  FN-ALLOC-06 -Allocate one specific batch when waving order (ITS-ALLOC-06 )
## 002.  FN-ALLOC-07 -Allocate multiple specific batches for the same SKU when waving order ( ITS-ALLOC-07 )
## 003.  FN-ALLOC-05 - Allocate single specific serial number for and order for an item that tracks serial numbers inbound and outbound (ITS-ALLOC-05)
## 004.  FN-ALLOC-09 - Allocate multiple specific serial numbers for and order for an item that tracks serial numbers inbound and outbound. (ITS-ALLOC-09)
## 005.  FN-ALLOC-04 - Allocate with shortage and accept (no goods avail for replen) - partial allocation (ITS-ALLOC-04)
## 006.  FN-ALLOC-03 - Allocate with shortage and deselect (no goods avail for replen) (ITS-ALLOC-03)
## 007.  FN-ALLOC-02 -Allocate by FEFO(ITS-ALLOC-02)

#1. FN-ALLOC-06-Allocate one specific batch when waving order
#Jira id- MAWMTF01-54
#Test case covered: 1
  @ALLOC
  Scenario: FN-ALLOC-06-Allocate one specific batch when waving order
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Edit OrgProfile
    And Navigate to Batch Master
    And Filter by Batch Number ItemID and Location
#   create inventory for Batch
    And Update ASN with one line And Batch Number "ALLOC06.xlsx"
    And Clear Notifications
    And Navigate to ASNs
    And Click "byImportDataLoaderBtn" on "ASNs"
    And Import Data Loader "ALLOC06.xlsx"
    And Wait for page loading
    And Verify notification message 'File ALLOC06.xlsx from Asn is imported successfully.'
    And Search ASN at ASNs
    And Verify ASN details are displayed
    And Validate ASN status "In Transit"
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT Standard Receiving' at WM Mobile
    And Complete ATStandardReceiving with Batches
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
    And Navigate to ASNs
    And Wait for page loading
    And Search ASN at ASNs
    And Validate ASN status "Verified"
    And Click "byRelatedLinks" on "HeaderPanelPage"
    And Click "byLPNInventory" on "HeaderPanelPage"
    And Validate ILPN status "Consumed"
#    Store Inventory Details
    And Navigate to Inventory Details
    And Store Inventory Details for the Batch Number
#   create Original Order
    And Navigate to Original Orders2
    And Update Original Order with one line with Batch "OriginalOrder.xlsx"
    And Clear Notifications
    And Click "byImportDataLoaderBtn" on "OriginalOrdersPage"
    And Import Data Loader "OriginalOrder.xlsx"
    And Wait for page loading
    And Verify notification message 'File OriginalOrder.xlsx from OriginalOrder is imported successfully.'
    And Click "byRefreshBtn" on "OriginalOrdersPage"
    And Verify Imported Orders
    And Click "byRelatedLinks" on "HeaderPanelPage"
    And Wait for page loading
    And Click "byOrderLines" on "OrdersPage"
    And Wait for page loading
    And Verify Item ,Batch and Quantity For Order Lines
    And Navigate to Original Orders2
    And Verify Imported Orders
    And Execute RunWave
    And Navigate to Wave Runs
    And Search Wave run at Wave Runs
    And Validate Wave run status till "Completed"
    And Click "byRelatedLinks" on "HeaderPanelPage"
    And Wait for page loading
    And Click "byAllocations" on "WaveRunsPage"
    And Verify wave Run specifies the Correct Quantity and the Batch in Allocations
    And Navigate to Inventory Details
    Then Verify On Hand Quantity is UnChanged and Allocated Quantity is Changed for Batch
    And Navigate to Wave Runs
    And Search Wave run at Wave Runs
    Then Unplan the Selected Wave
    And Validate Wave run status till "Cancelled"
    And Navigate to Inventory Details
    Then Verify On Hand Quantity and Allocated Quantity After Cancel WaveRun For Batch
    And Navigate to Original Orders2
    And Verify Imported Orders
    And Validate Orders status "Released"

#2. FN-ALLOC-07 -Allocate multiple specific batches for the same SKU when waving order
#Jira id- MAWMTF01-53
#Test case covered: 1
  @ALLOC
  Scenario: FN-ALLOC-07-Allocate multiple specific batches for the same SKU when waving order
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Edit OrgProfile
    # Verify Setup steps
    # Batch Master
    And Navigate to Batch Master
    And Filter by Batch Number ItemID and Location
#   create inventory for Batch
    And Update ASN with two lines "ALLOC07.xlsx"
    And Clear Notifications
    And Navigate to ASNs
    And Click "byImportDataLoaderBtn" on "ASNs"
    And Import Data Loader "ALLOC07.xlsx"
    And Wait for page loading
    And Verify notification message 'File ALLOC07.xlsx from Asn is imported successfully.'
    And Search ASN at ASNs
    And Verify ASN details are displayed
    And Validate ASN status "In Transit"
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT Standard Receiving' at WM Mobile
    And Complete ATStandardReceiving with Batches
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
    And Navigate to ASNs
    And Wait for page loading
    And Search ASN at ASNs
    And Validate ASN status "Verified"
    And Click "byRelatedLinks" on "HeaderPanelPage"
    And Click "byLPNInventory" on "HeaderPanelPage"
    And Validate ILPN status "Consumed"
#    Store Inventory Details
    And Navigate to Inventory Details
    And Store Inventory Details for the Batch Number
#   create Original Order
    And Navigate to Original Orders2
    And Update Original Order with two lines "OriginalOrderTwoLines.xlsx"
    And Clear Notifications
    And Click "byImportDataLoaderBtn" on "OriginalOrdersPage"
    And Import Data Loader "OriginalOrderTwoLines.xlsx"
    And Wait for page loading
    And Verify notification message 'File OriginalOrderTwoLines.xlsx from OriginalOrder is imported successfully.'
    And Click "byRefreshBtn" on "OriginalOrdersPage"
    And Verify Imported Orders
    And Click "byRelatedLinks" on "HeaderPanelPage"
    And Wait for page loading
    And Click "byOrderLines" on "OrdersPage"
    And Wait for page loading
    And Verify Item ,Batch and Quantity For Order Lines
    And Navigate to Original Orders2
    And Verify Imported Orders
    And Execute RunWave
    And Navigate to Wave Runs
    And Search Wave run at Wave Runs
    And Validate Wave run status till "Completed"
    And Click "byRelatedLinks" on "HeaderPanelPage"
    And Wait for page loading
    And Click "byAllocations" on "WaveRunsPage"
    And Verify wave Run specifies the Correct Quantity and the Batch in Allocations
    And Navigate to Inventory Details
    Then Verify On Hand Quantity is UnChanged and Allocated Quantity is Changed for Batch
    And Navigate to Wave Runs
    And Search Wave run at Wave Runs
    Then Unplan the Selected Wave
    And Validate Wave run status till "Cancelled"
    And Navigate to Inventory Details
    Then Verify On Hand Quantity and Allocated Quantity After Cancel WaveRun For Batch
    And Navigate to Original Orders2
    And Verify Imported Orders
    And Validate Orders status "Released"

#3. FN-ALLOC-05 - Allocate single specific serial number for and order for an item that tracks serial numbers inbound and outbound
#Jira id- MAWMTF01-58
#Test case covered: 1
  @ALLOC
  Scenario: FN-ALLOC-05-Allocate single specific serial number for and order for an item that tracks serial numbers inbound and outbound
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Edit OrgProfile
#  Setup steps
#   create inventory
    And Update ASN with ItemID Quantity Status And No Batch "ALLOC05.xlsx"
    And Clear Notifications
    And Navigate to ASNs
    And Click "byImportDataLoaderButton" on "HeaderPanelPage" WaitForPageLoading
    And Import Data Loader "ALLOC05.xlsx"
    And Wait for page loading
    And Verify notification message 'File ALLOC05.xlsx from Asn is imported successfully.'
    And Search ASN at ASNs
    And Verify ASN details are displayed
    And Validate ASN status "In Transit"
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT Standard Receiving' at WM Mobile
    And Complete ATStandardReceiving With Serial Number in ALLOC    
##    And Click "byEndScan" on "ReceiveLPNLevel" WaitForPageLoading
    And Click "byVerifyASNButton" on "UserDirected" WaitForPageLoading
    And Validate popup message "Verification request has been submitted for ASN"
    And Close browser window And Switch to Last Window
    And Navigate to ASNs
    And Wait for page loading
    And Search ASN at ASNs
    And Validate ASN status "Verified"
    And Click "byRelatedLinks" on "HeaderPanelPage" WaitForPageLoading
    And Click "byLPNInventory" on "HeaderPanelPage" WaitForPageLoading
    And Store iLPNs to runtime variables as list
	# User Directed Putaway
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT User Directed Putaway' at WM Mobile
    And Enter ILPN and Location in AT User Directed PutAway
    And Close browser window And Switch to Last Window
    And Navigate to ASNs
    And Wait for page loading
    And Search ASN at ASNs
    And Validate ASN status "Verified"
    And Click "byRelatedLinks" on "HeaderPanelPage" WaitForPageLoading
    And Click "byLPNInventory" on "HeaderPanelPage" WaitForPageLoading
    And Validate ILPN status "Consumed"
#   create Original Order
    And Navigate to Original Orders2
    And Update Original Order with serial number "OriginalOrderWithAttributes.xlsx"
    And Clear Notifications
    And Click "byImportDataLoaderBtn" on "OriginalOrdersPage" WaitForPageLoading
    And Import Data Loader "OriginalOrderWithAttributes.xlsx"
    And Wait for page loading
    And Verify notification message 'File OriginalOrderWithAttributes.xlsx from OriginalOrder is imported successfully.'
    And Click "byRefreshBtn" on "OriginalOrdersPage" WaitForPageLoading
    And Verify Imported Orders
    And Click "byRelatedLinks" on "HeaderPanelPage" WaitForPageLoading
    And Wait for page loading
    And Click "byOrderLines" on "OrdersPage"
    And Wait for page loading
    And Verify Item ID Quantity And Serial Number for the Order
    And Navigate to Original Orders2
    And Verify Imported Orders
    ##And Execute RunWave from Original Orders
    And Execute RunWave
    And Navigate to Wave Runs
    And Search Wave run at Wave Runs
    And Validate Wave run status till "Completed"
    And Click "byRelatedLinks" on "HeaderPanelPage" WaitForPageLoading
    And Wait for page loading
    And Click "byAllocations" on "WaveRunsPage"
    And Verify wave Run specifies the Correct Quantity Item and Serial Number
#    check original order has serial number after wave
    And Navigate to Original Orders2
    And Verify Imported Orders
    And Validate Orders status "Allocated"
    And Click "byRelatedLinks" on "HeaderPanelPage" WaitForPageLoading
    And Wait for page loading
    And Click "byOrderLines" on "OrdersPage" WaitForPageLoading
    And Wait for page loading
    And Validate Orderslines statuses "ALLOCATED"
    And Verify Item ID Quantity And Serial Number for the Order
#    Unplan wave
    And Navigate to Wave Runs
    And Search Wave run at Wave Runs
    Then Unplan the Selected Wave
    And Validate Wave run status till "Cancelled"
#    check original order has serial number after unplan wave
    And Navigate to Original Orders2
    And Verify Imported Orders
    And Validate Orders status "Released"
    And Click "byRelatedLinks" on "HeaderPanelPage" WaitForPageLoading 
    And Click "byOrderLines" on "OrdersPage" WaitForPageLoading
    And Wait for page loading
    And Validate Orderslines statuses "READY"
    And Verify Item ID Quantity And Serial Number for the Order

#4. FN-ALLOC-09 - Allocate multiple specific serial numbers for and order for an item that tracks serial numbers inbound and outbound.
#Jira id- MAWMTF01-59
#Test case covered: 1
  @ALLOC
  Scenario: FN-ALLOC-09-Allocate multiple specific serial numbers for and order for an item that tracks serial numbers inbound and outbound
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Edit OrgProfile
#  Setup steps
#   create inventory
    And Update ASN with ItemID Quantity Status And No Batch "ALLOC09.xlsx"   
    And Navigate to ASNs
    And Clear Notifications
    And Click "byImportDataLoaderButton" on "HeaderPanelPage" WaitForPageLoading
    And Import Data Loader "ALLOC09.xlsx"
    And Wait for page loading
    And Verify notification message 'File ALLOC09.xlsx from Asn is imported successfully.'
    And Search ASN at ASNs
    And Verify ASN details are displayed
    And Validate ASN status "In Transit"
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT Standard Receiving' at WM Mobile
    And Complete ATStandardReceiving With Serial Number in ALLOC
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
    # User Directed Putaway
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT User Directed Putaway' at WM Mobile
    And Enter ILPN and Location in AT User Directed PutAway
#    And Navigate window using index id '0'
		And Close browser window And Switch to Last Window
    And Navigate to ASNs
    And Wait for page loading
    And Search ASN at ASNs
    And Validate ASN status "Verified"
    And Click "byRelatedLinks" on "HeaderPanelPage"
    And Click "byLPNInventory" on "HeaderPanelPage"
    And Validate ILPN status "Consumed"
#   create Original Order
    And Navigate to Original Orders2
    And Update Original Order with serial number two lines "OriginalOrderWithAttributesTwoLines.xlsx"
    And Clear Notifications
    And Click "byImportDataLoaderBtn" on "OriginalOrdersPage"
    And Import Data Loader "OriginalOrderWithAttributesTwoLines.xlsx"
    And Wait for page loading
    And Verify notification message 'File OriginalOrderWithAttributesTwoLines.xlsx from OriginalOrder is imported successfully.'
    And Click "byRefreshBtn" on "OriginalOrdersPage"
    And Verify Imported Orders
    And Click "byRelatedLinks" on "HeaderPanelPage"
    And Wait for page loading
    And Click "byOrderLines" on "OrdersPage"
    And Wait for page loading
    And Verify Item ID Quantity And Serial Number for the Order
    And Navigate to Original Orders2
    And Verify Imported Orders
    ##And Execute RunWave from Original Orders
    And Execute RunWave
    And Navigate to Wave Runs
    And Search Wave run at Wave Runs
    And Validate Wave run status till "Completed"
    And Click "byRelatedLinks" on "HeaderPanelPage"
    And Wait for page loading
    And Click "byAllocations" on "WaveRunsPage"
    And Verify wave Run specifies the Correct Quantity Item and Serial Number
#    check original order has serial number after wave
    And Navigate to Original Orders2
    And Verify Imported Orders
    And Validate Orders status "Allocated"
    And Click "byRelatedLinks" on "HeaderPanelPage"
    And Wait for page loading
    And Click "byOrderLines" on "OrdersPage"
    And Wait for page loading
    And Validate Orderslines statuses "ALLOCATED"
    And Verify Item ID Quantity And Serial Number for the Order
#    Unplan wave
    And Navigate to Wave Runs
    And Search Wave run at Wave Runs
    Then Unplan the Selected Wave
    And Validate Wave run status till "Cancelled"
#    check original order has serial number after unplan wave
    And Navigate to Original Orders2
    And Verify Imported Orders
    And Validate Orders status "Released"
    And Click "byRelatedLinks" on "HeaderPanelPage"
    And Wait for page loading
    And Click "byOrderLines" on "OrdersPage"
    And Wait for page loading
    And Validate Orderslines statuses "READY"
    And Verify Item ID Quantity And Serial Number for the Order

#5. FN-ALLOC-04 - Allocate with shortage and accept (no goods avail for replen) - partial allocation
#Jira id- MAWMTF01-61
#Test case covered: 1
  @ALLOC                      
  Scenario: FN-ALLOC-04-Allocate with shortage and accept (no goods avail for replen)-partial allocation
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Edit OrgProfile
#  Setup steps
#   create inventory
    And Update ASN with ItemID Quantity Status And No Batch "ALLOC04.xlsx"
    And Clear Notifications
    And Navigate to ASNs
    And Click "byImportDataLoaderBtn" on "ASNs"
    And Import Data Loader "ALLOC04.xlsx"
    And Wait for page loading
    And Verify notification message 'File ALLOC04.xlsx from Asn is imported successfully.'
    And Search ASN at ASNs
    And Verify ASN details are displayed
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
    And Click "byRelatedLinks" on "ASNs"
    And Click "byLPNInventory" on "ASNs"
    And Store iLPNs to runtime variables as list
    # User Directed Putaway
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT User Directed Putaway' at WM Mobile
    And Enter ILPN and Location in AT User Directed PutAway
    And Close browser window And Switch to Last Window
    And Navigate to ASNs
    And Wait for page loading
    And Search ASN at ASNs
    And Validate ASN status "Verified"
    And Click "byRelatedLinks" on "ASNs"
    And Click "byLPNInventory" on "ASNs"
    And Validate ILPN status "Consumed"
#    Store Inventory Details
    And Navigate to Inventory Details
    And Store On hand and Allocated Quantity
#  create Original Order
    And Navigate to Original Orders2
    And Update Original Order with Order Quantity greater than On hand Quantity "OriginalOrderOneLineNoBatch.xlsx"
    And Clear Notifications
    And Click "byImportDataLoaderBtn" on "OriginalOrdersPage"
    And Import Data Loader "OriginalOrderOneLineNoBatch.xlsx"
    And Wait for page loading
    And Verify notification message 'File OriginalOrderOneLineNoBatch.xlsx from OriginalOrder is imported successfully.'
    And Click "byRefreshBtn" on "OriginalOrdersPage"
    And Verify Imported Orders
    And Click "byRelatedLinks" on "OrdersPage"
    And Wait for page loading
    And Click "byOrderLines" on "OrdersPage"
    And Wait for page loading
    And Verify Item and Quantity value For Order Lines
    And Navigate to Original Orders2
    And Verify Imported Orders
    ##And Execute RunWave from Original Orders
    And Execute RunWave with Partial Allocate
    And Navigate to Wave Runs
    And Search Wave run at Wave Runs
    And Validate Wave run status till "Completed"
    And Click "byRelatedLinks" on "WaveRunsPage"
    And Wait for page loading
    And Click "byAllocations" on "WaveRunsPage"
    And Verify wave Run specifies the Correct Quantity Item and No Serial Number for One Order
#   check original order has serial number after wave
    And Navigate to Original Orders2
    And Verify Imported Orders
    And Validate Orders status "Released"
    And Maximum Order status "Allocated"
    And Click "byRelatedLinks" on "OrdersPage"
    And Wait for page loading
    And Click "byOrderLines" on "OrdersPage"
    And Wait for page loading
    And Validate Ordersline status is "READY" and "ALLOCATED"
    And Verify Item ID Quantity And Wave Processing for the Allocated Order Line
    And Verify Item ID Quantity And Wave Processing for the Ready Order Line
    And Navigate to Wave Runs
    And Search Wave run at Wave Runs
    Then Unplan the Selected Wave
    And Validate Wave run status till "Cancelled"
    And Navigate to Original Orders2
    And Verify Imported Orders
    And Validate Orders status "Released"
    And Maximum Order status "Released"
    And Click "byRelatedLinks" on "OrdersPage"
    And Wait for page loading
    And Click "byOrderLines" on "OrdersPage"
    And Wait for page loading
    And Validate Orderslines statuses "READY"

#6. FN-ALLOC-03 - Allocate with shortage and deselect (no goods avail for replen)
#Jira id- MAWMTF01-60
#Test case covered: 1
  @ALLOC
  Scenario: FN-ALLOC-03-Allocate with shortage and deselect
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Edit OrgProfile
    And Navigate to Items Page
    And Update ItemId 'ALLOC03Item.xlsx'
    And Clear Notifications
    And Click on Import DataLoader
    And Import Data Loader 'ALLOC03Item.xlsx'
    And Verify notification message 'File ALLOC03Item.xlsx from Item is imported successfully.'
    And Search Item With variable "Item"
    And Verify Item with variable "Item"
    And Update Location in "PUTAWAY09Location.xlsx"
    And Navigate to Storeage Location
    And Click on Import DataLoader
    And Import Data Loader "PUTAWAY09Location.xlsx"
    And Search Location with variable "Location" value
    And Store "MaxWeight" and "MaxVolume" from location popup
    And Add Item 'Item' to the Location
    And Store "CurrentWeight" and "CurrentVolume" from location capacity usage page
    And Store "AvailableWeight" and "AvailableVolume" for location
    And Update ASN with ItemID Quantity Status "ALLOC03.xlsx"
    And Clear Notifications
    And Navigate to ASNs
    And Click "byImportDataLoaderBtn" on "ASNs"
    And Import Data Loader "ALLOC03.xlsx"
    And Wait for page loading
    And Verify notification message 'File ALLOC03.xlsx from Asn is imported successfully.'
    And Search ASN at ASNs
    And Verify ASN details are displayed
    And Validate ASN status "In Transit"
    And Verify ASN Details in Related Links
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT Standard Receiving' at WM Mobile
#    And Complete ATStandardReceiving without LPNs
    And Complete ATStandardReceiving with produtstatus and Inventory type
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
    And Enter ILPN and Location in FN PutAway System Directed Page
    And Close browser window And Switch to Last Window
    And Navigate to Inventory Details
#    And Expand Filter
    And Search with Item Filter
    And Filter by Inventory Details with InventoryReservation and Location Type
    And Verify multiple Ilpns Data In Inventory Details_with Items
    And Navigate to Original Orders2
    And Update Original Order with Order and Item "OriginalOrderFNALLOC03.xlsx"
    And Clear Notifications
    And Click "byImportDataLoaderBtn" on "OriginalOrdersPage"
    And Import Data Loader "OriginalOrderFNALLOC03.xlsx"
    And Wait for page loading
    And Verify notification message 'File OriginalOrderFNALLOC03.xlsx from OriginalOrder is imported successfully.'
    And Navigate to OrderLines Page
    And Search Order with variable "OriginalOrder"
    And Verify OrderLineNeed and OrderLineAttributes for multiple orders with variable "OriginalOrder"
    And Store Order Line ID
    And Navigate to Original Orders2
    And Search Order with variable "OriginalOrder"
    And Validate Orders status "Released"
    And Click "byRefreshBtn" on "OriginalOrdersPage"
#    And Verify Imported Orders
#    And Click "byRelatedLinks" on "HeaderPanelPage"
#    And Wait for page loading
#    And Click "byOrderLines" on "OrdersPage"
#    And Wait for page loading
#    And Verify Order Line Need and Order Line Attributes
    And Navigate to Original Orders2
    And Verify Imported Orders
    And Execute RunWave from Original Orders for ATStandardOrderStrategyDeselectShort
    And Navigate to Wave Runs
    And Search Wave run at Wave Runs
    And Wait for wave to load
    And Wait for wave to load
    And Validate Wave run status till "Cancelled"
    And Select First Row
    And Click "byRelatedLinks" on "HeaderPanelPage"
    And Wait for page loading
    And Select to the Message Logging
    And Wait for page loading
    And Click "byRefreshButton" on "RightNavigationBar" WaitForPageLoading
    And Verify message line starting with the text Allocation result for OrderLine
    And Verify message line starting with the text Complete Order deselected
    And Navigate to Original Orders2
    And Verify Imported Orders
    And Validate Orders status "Released"
    And Click "byRelatedLinks" on "HeaderPanelPage"
    And Wait for page loading
    And Click "byOrderLines" on "OrdersPage"
    And Wait for page loading
    And Select First Row
    And Validate Orderslines status "READY"

#7. FN-ALLOC-02 -Allocate by FEFO
#Jira id- MAWMTF01-88
#Test case covered: 1
  @ALLOC
  Scenario: FN-ALLOC-02-Allocate by FEFO
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Edit OrgProfile
    And Navigate to ASNs
    And Update  ILPN level ASN with three line And Batch Number and ExpiryDate "ALLOC02ASN.xlsx"
    And Clear Notifications
    And Click "byImportDataLoaderButton" on "HeaderPanelPage" WaitForPageLoading
    And Import Data Loader "ALLOC02ASN.xlsx"
    And Wait for page loading
    And Verify notification message 'File ALLOC02ASN.xlsx from Asn is imported successfully.'
    And Search ASN at ASNs
    And Verify ASN details are displayed
    And Validate ASN status "In Transit"
    And Verify ILPNs linked to ASN with variable  "listOfILPNs"
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
    And Search Inventory Container with variable "lpns"
    And Verify Multiple Items details in Inventory Details page
    And Navigate to ASNs
    And Search ASN at ASNs
    And Validate ASN status "Verified"
    And Click "byRelatedLinks" on "HeaderPanelPage" WaitForPageLoading
    And Click "byLPNInventory" on "HeaderPanelPage" WaitForPageLoading
    And Verify Inventory details for each LPN with Batch Number
    And Navigate to Original Orders2
    And Update Original Order with one line "ALLOC02Order.xlsx"
    And Clear Notifications
    And Click "byImportDataLoaderButton" on "HeaderPanelPage" WaitForPageLoading
    And Import Data Loader "ALLOC02Order.xlsx"
    And Verify notification message 'File ALLOC02Order.xlsx from OriginalOrder is imported successfully.'
    And Click "byRefreshBtn" on "OriginalOrdersPage"
    And Verify Imported Orders
    And Click "byRelatedLinks" on "HeaderPanelPage" WaitForPageLoading
    And Click "byOrderLines" on "HeaderPanelPage" WaitForPageLoading
    And Verify OrderLineNeed and OrderLineAttributes for order
    And Navigate to Original Orders2
    And Verify Imported Orders
    And Execute RunWave
    And Navigate to Wave Runs
    And Search Wave run at Wave Runs
    And Validate Wave run status till "Completed"
    And Click on Row At First Index
    And Click "byRelatedLinks" on "HeaderPanelPage" WaitForPageLoading
    And Click "byAllocations" on "HeaderPanelPage" WaitForPageLoading
    And Verify atleast '1' pick_pack is created
    And Verify Replenishment details
    And Verify Allocation details
    And Navigate to Wave Runs
    And Search Wave run at Wave Runs
    #And Click on Row At First Index
    And Unplan the Selected Wave
    And Validate Wave run status till "Cancelled"
    And Navigate to Original Orders2
    And Verify Imported Orders
    And Validate Orders status "Released"
#    And Navigate to Original Orders2
#    And Verify Imported Orders
#    And Validate Orders status "Allocated"
#    And Click "byRelatedLinks" on "HeaderPanelPage" WaitForPageLoading
#    And Click "byOrderLines" on "HeaderPanelPage" WaitForPageLoading
#    And Validate Orderslines statuses "ALLOCATED"
