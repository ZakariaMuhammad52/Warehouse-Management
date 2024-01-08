
@DFN
Feature: Inventory_Test_Cases
##List of Test Cases covered
## TC    TS No.	Test Case Name
## 001.  1 	 		FN-COUNT-07 : Plan and perform a count of LOT tracked items (ITS-INV-21)
## 002.  2	 		FN-COUNT-02- Plan count in any location with items inside (ITS-INV-16)
## 003.  3			FN-COUNT-06: Perform a count of serialized item (E2E) with a variance.(ITS-INV-20)
## 004.  4			FN-COUNT-05- Plan a count of serialized item (E2E) (ITS-INV-19)
## 005.  5			FN-COUNT-04 -Count identifies variance. Variance accepted by completing recount task and confirming the same variance (ITS-INV-18)
## 006.  6			DFN-INVENTORY-03 -Pack stock in a pick location without an iLPN into an iLPN (ITS-INV-09)
## 007.  7			DFN-ADJ-05-Product Status Adjustment iLPN (ITS-INV-05)
## 008.  8			DFN-SNAPSHOT-01 - Stock Snapshot no Batch (ITS-INV-10)
## 009.  9			DFN-SNAPSHOT-02 - Stock Snapshot Batches (ITS-INV-11)
## 0010.  10		DFN-INVENTORY-01 Enter in iLPN Screen Select 3 LPNs, one for each facility status Change the LPN Type on all and ensure all are on the LPNs are properly updated
## 0011.  11		FN-COUNT-03 : Count Identifies Variance but Variance Rejected at Final Confirmation After Completing Recount Task

# Test data : 					Values which are pased as part of test data
# Pre-requiste Steps : 	Steps which are required to be performed/validated to prepare AUT for executing the scenario
# Test Case : 					DFN-INVENTORY-02 - Move iLPN out of location (ITS-INV-01)

# 1. FN-COUNT-07 : Plan and perform a count of LOT tracked items
# Jira Id - MAWMTF01-66
# Test cases covered : 1
  @INVPlanAndPerformCount
  Scenario: FN-COUNT-07-Plan and perform a count of LOT tracked items
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Wait for page loading
    And Edit OrgProfile
    And Navigate to Items Page
    And Update ItemId 'COUNT07Item.xlsx'
    And Clear Notifications
    And Click on Import DataLoader
    And Import Data Loader 'COUNT07Item.xlsx'
    And Verify notification message 'File COUNT07Item.xlsx from Item is imported successfully.'
    And Search Item With variable "Item"
    And Verify Item with variable "Item"
    And Update Location in "Count07Location.xlsx"
    And Navigate to Storeage Location
    And Click on Import DataLoader
    And Import Data Loader "Count07Location.xlsx"
    And Search Location with variable "Location" value
    And Store "MaxWeight" and "MaxVolume" from location popup
    And Add Item with variable 'Item' to Location
    And Store "CurrentWeight" and "CurrentVolume" from location capacity usage page
    And Store "AvailableWeight" and "AvailableVolume" for location
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Navigate to Inventory Management
    And Create "getdata(LPNCount)" iLPN with Batch Number
    And Close browser window And Switch to Last Window
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT User Directed Putaway' at WM Mobile
    And Enter ILPN and Location AT User Directed PutAway
    And Close browser window And Switch to Last Window
    And Navigate to Inventory Details
    #And Expand Filter
    And Search with Location
    And Search with Item Filter
    And Store quantity to variable as String
    And Store Batch number to varaiable
    And Store Expiry date to variable
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'Cycle Count' at WM Mobile
    And Scan Location in Cycle count
    And Click on Confirm in POPup
    And Scan Item in Cycle count
    And Enter Quantity details in cycle count screen
    And Click on Confirm in POPup
    And Scan Item in Cycle count
    And Enter Batch Number in cycle count screen
    And Enter Expiry date in cycle count screen
    And Enter Quantity details in cycle count screen
    And Click on End count
    And Close browser window And Switch to Last Window
    And Navigate to Inventory Count
    And Search with Location
    And Search with Quick select filter
    And Select Today from Quick select filter
    Then Verify the Count status as booked
    And Navigate to PIX Visibility
    And Select Inventory Adjustment checkbox
    And Search with Quick select filter
    And Select Today from Quick select filter
    And Search with Item Filter
    Then Verify PixData status as "getdata(PixStatus)"
    And Expand PIX Visibility arrow button
    And Select PIX Visibility button
    Then Verify PixData for lot of tracked items

# 2. FN-COUNT-02- Plan count in any location with items inside
# Jira Id - MAWMTF01-62
# Test cases covered : 1
  @INVPlanAndPerformCount
  Scenario: FN-COUNT-02-Plan count in any location with items inside
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Wait for page loading
    And Edit OrgProfile
    And Navigate to Inventory Details
    ##And Expand Filter
    And Search with Location Filter "getdata(Location)"
    And Search with Item Filter "getdata(EnterItem)"
    And Store quantity to variable as String
    And Store Batch number to varaiable
    And Store Expiry date to variable
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'FN Cycle Count' at WM Mobile
    And Scan Location in Cycle count "getdata(ScanLocation)"
    And Click on Confirm in POPup
    And Scan Item in Cycle count "getdata(Item)"
    And Enter Batch Number in cycle count screen
    And Enter Expiry date in cycle count screen
    And Enter Quantity details in cycle count screen
    And Click on Confirm in POPup
    And Click on End count
    And Close browser window And Switch to Last Window
    And Navigate to Inventory Count
    And Search with Location Filter "getdata(Location)"
    And Click on Count Run ID
    And Navigate back to Inventory Count window
    And Expand side arrow button
    And Create Cycle Count task
    And Click on Yes button
    And Navigate to Tasks
    And Select Cycle count checkbox filter
    And Search with Quick select filter
    And Select Today from Quick select filter
    And Navigate to Inventory Count
    And Search with Location Filter "getdata(Location)"
    And Navigate to Tasks
    And Select Cycle count checkbox filter
    And Search with Quick select filter
    And Select Today from Quick select filter
    And Expand side arrow button
    And Click on More Actions button
    And Click on Cancel option
    And Click on Yes button

#3. FN-COUNT-06-Perform a count of serialized item with a variance
# Jira Id - MAWMTF01-65
# Test cases covered : 1
  Scenario: FN-COUNT-06-Perform a count of serialized item with a variance
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Wait for page loading
    And Edit OrgProfile
    And Update ASN for Item Count in "COUNT06ASN.xlsx"
    And Navigate to ASNs
    And Clear Notifications
    And Click "byImportDataLoaderButton" on "HeaderPanelPage" WaitForPageLoading
    And Import Data Loader "COUNT06ASN.xlsx"
    And Verify notification message 'File COUNT06ASN.xlsx from Asn is imported successfully.'
    And Search ASN at ASNs
    Then Verify ASN details are displayed
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT Standard Receiving' at WM Mobile
    And Complete ATStandardReceiving with ASN and single LPNs with multiple Serial Numbers
    And Search menu 'AT User Directed Putaway' at WM Mobile
    And Enter ILPN and Location in AT User Directed PutAway of Count Item
    And Close browser window And Switch to Last Window
    And Navigate to ASNs
    And Wait for page loading
    And Search ASN at ASNs
    And Validate ASN status "Verified"
    And Click "byRelatedLinks" on "HeaderPanelPage"
    And Click "byLPNInventory" on "HeaderPanelPage"
    And Validate ILPN status "Consumed"
    And Navigate to Inventory Details
    #And Expand Filter
    And Search with Location Filter "getdata(Location)"
    And Search with Item Filter "getdata(Item)"
    And Store quantity to variable as String
    And Select Particular inventory
    And Store Serial Numbers to runtime variables as list
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'Cycle Count' at WM Mobile
    And Complete Cycle count with Quantitymismatch and Serial Number
    And Click on End count
    And Close browser window And Switch to Last Window
    And Navigate to Inventory Count
    And Search with Location Filter "getdata(Location)"
    And Search with Quick select filter
    And Select Today from Quick select filter
    And Verify the Count status as booked
    And Navigate to PIX Visibility
    And Select Inventory Adjustment checkbox
    And Search with Quick select filter
    And Select Today from Quick select filter
    And Search with Item Filter "getdata(Item)"
    And Expand PIX Visibility arrow button
    And Select PIX Visibility button
    And Get generated PIX Data JSON View for the cycle count

#4. FN-COUNT-05-Plan a count of serialized item
# Jira Id - MAWMTF01-63
# Test cases covered : 1
  @INVPlanAndPerformCount
  Scenario: FN-COUNT-05-Plan a count of serialized item
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Wait for page loading
    And Edit OrgProfile
    And Navigate to Inventory Details
 ##   And Expand Filter
    And Search with Location Filter "getdata(Location)"
    And Search with Item Filter "getdata(EnterItem)"
    And Store quantity to variable as String
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'Cycle Count' at WM Mobile
    And Complete Cycle count with Quantitymismatch
    And Click on End count
    And Close browser window And Switch to Last Window
    And Navigate to Inventory Count
    And Search with Location Filter "getdata(Location)"
    And Search with Quick select filter
    And Select Today from Quick select filter
    And Click on Count Run ID
    And Expand side arrow button
    And Click details button
    Then Verify Original and count quantity matches with No Varaince

# 5. FN-COUNT-04-Count identifies variance. Variance accepted by completing recount task and confirming the same variance.
# Jira Id - MAWMTF01-71
# Test cases covered : 1
  @INVPlanAndPerformCount
  Scenario: FN-COUNT-04-Count identifies variance. Variance accepted by completing recount task and confirming the same variance
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Edit OrgProfile
    And Navigate to Inventory Details
#    And Expand Filter
    And Search with Location Filter "getdata(Location)"
    And Search with Item Filter "getdata(EnterItem)"
    And Store quantity to variable as String
    And Store Batch number to varaiable
    And Store Expiry date to variable
    And Verify Inventory Details Location Barcode
    And Verify Inventory Details All Cell Value for ListOfItems
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'FN Cycle Count' at WM Mobile
    And Scan Location in Cycle count "getdata(ScanLocation)"
    And Click on Confirm in POPup
    And Scan Item in Cycle count "getdata(Item)"
    And Enter Batch Number in cycle count screen
    And Enter Expiry date in cycle count screen
    And Enter Quantity details in cycle count screen
    And Click on Confirm in POPup
    And Click on End count
    And Close browser window And Switch to Last Window
    And Navigate to Inventory Count
    And Search with Location Filter "getdata(Location)"
    And Search with Quick select filter
    And Select Today from Quick select filter
    And Expand side arrow button
    And Create Cycle Count task
    And Click on Yes button
    And Navigate to Tasks
    And Select Cycle count checkbox filter
    And Search with Quick select filter
    And Select Today from Quick select filter
    And Store Taskid to variable
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'Enter Task' at WM Mobile
    And Enter Taskid
    And Verify Excluded User Error Message "is marked as an excluded user for this task execution. (TSK::178)"
    And Close browser window And Switch to Last Window
    And SignOut And Login With Other credentials
    And Wait for page loading
    And Edit OrgProfile
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'Enter Task' at WM Mobile
    And Enter Taskid
#    And Scan Location in SeedCycleCountId
    And Enter Scan Location "getdata(ScanLocation)"
    And Scan Item in Cycle count "getdata(Item)"
    And Enter Quantity details in cycle count screen
    And Click on Confirm in POPup
    And Scan Item in Cycle count "getdata(Item)"
    And Enter Batch Number in cycle count screen
    And Enter Expiry date in SeedCycle count screen
    #And Enter Expiry date in cycle count screen
    And Enter Quantity details in cycle count screen
    And Click on End count
    And Close browser window And Switch to Last Window
    And Navigate to Tasks
    And Filter by Task
    And Validate Task status "Completed"
    And Navigate to Inventory Details
 ##   And Expand Filter
    And Search with Location Filter "getdata(Location)"
    And Search with Item Filter "getdata(EnterItem)"
    And Verify Quantity Adjustment
    And Navigate to PIX Visibility
    And Select Inventory Adjustment checkbox
    And Search with Item Filter "getdata(EnterItem)"
    And Search with Quick select filter
    And Select Today from Quick select filter
    And Expand PIX Visibility arrow button
    And Select PIX Visibility button
    And Get generated PIX Data JSON View for the cycle count

#6. DFN-INVENTORY-03-Pack stock in a pick location without an iLPN into an iLPN
# Jira Id - MAWMTF01-45
# Test cases covered : 1
  @INVPlanAndPerformCount
  Scenario: DFN-INVENTORY-03-Pack stock in a pick location without an iLPN into an iLPN
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Edit OrgProfile
    And Navigate to Inventory Details
    And Select checkbox "byInventoryContainerTypeLocationCheckbox" on "LeftPanelPage"
    And Search Item With "getdata(Item)"
    And Search Location with "getdata(Location)"
    And Store Quantity to variable "Before Quantity"
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Navigate to Inventory Management
    And Click on FNPackILPNDirected
    And Complete FNPackILPNDirected Process
    And Close browser window And Switch to Last Window
    And Navigate to ILPNs
    And Search iLPN at ILPNs
    And Verify LPN Status as "getdata(Status)"
    And Verify LPN Status Code as "getdata(StatusCode)"
    And Verify LPN Total Quantity as "getdata(TotalQuantity)"
    And Navigate to Inventory Details
    And Select checkbox "byInventoryContainerTypeLocationCheckbox" on "LeftPanelPage"
    And Search Item With "getdata(Item)"
    And Search Location with "getdata(Location)"
    And Store Quantity to variable "After Quantity"
    And Verify Quantity is matched with Difference

# 7. DFN-ADJ-05-Product Status Adjustment iLPN
# Jira Id - MAWMTF01-85
# Test cases covered : 1
  @INVPlanAndPerformCount
  Scenario: DFN-ADJ-05-Product Status Adjustment iLPN
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Edit OrgProfile
    And Navigate to Items Page
    And Search Item With "getdata(Item)"
    And Verify Item with "getdata(Item)"
    And Update ASN for Product Status Adjustment iLPN in "INV05ASN.xlsx"
    And Navigate to ASNs
    And Clear Notifications
    And Click "byImportDataLoaderButton" on "HeaderPanelPage" WaitForPageLoading
    And Import Data Loader "INV05ASN.xlsx"
    And Verify notification message 'File INV05ASN.xlsx from Asn is imported successfully.'
    And Search ASN at ASNs
    Then Verify ASN details are displayed
    And Verify ILPN linked to ASN with variable  "LPN"
    And Verify Product status and Inventory type in LPNPopup Page
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT Standard Receiving' at WM Mobile
    And Complete ATStandardReceiving with ASN and LPN
    And Close browser window And Switch to Last Window
    And Navigate to Inventory Details
    And Search Inventory Container with variable "LPN"
    Then Verify LPN details in Inventory Details page
    And Verify the inventory attributes for non serial number item
    And Navigate to Manage User
    And Search with UserId
    And Store RoleId to variable "RoleId"
    And Navigate to Product status matrix
    And Navigate to Last window
    And Select user "RoleId"
    And Verify user have valid moves
    And Close browser window And Switch to Last Window
    And Navigate to Inventory Details
    And Search Inventory Container with variable "LPN"
    And Adjust Product status to 'getdata(AdjustProductStatus1)'
    And Navigate to PIX Visibility
    And Select checkbox "byInventoryAdjustmentCheckbox" on "LeftPanelPage"
    And Search Inbound LPNID with Variable Name "LPN"
    Then Verify PixData for "getdata(AdjustProductStatus1)"
    And Navigate to Inventory Details
    And Search Inventory Container with variable "LPN"
    And Adjust Product status to 'getdata(AdjustProductStatus2)'
    And Adjust Product status to 'getdata(AdjustProductStatus3)'
    And Navigate to PIX Visibility
    And Select checkbox "byInventoryAdjustmentCheckbox" on "LeftPanelPage"
    And Search Inbound LPNID with Variable Name "LPN"
    Then Verify PixData for "getdata(AdjustProductStatus3)"

# 8. DFN-SNAPSHOT-01 - Stock Snapshot no Batch
# Jira Id - MAWMTF01-46
# Test cases covered : 1
  @Snapshot
  Scenario: DFN-SNAPSHOT-01 - Stock Snapshot no Batch
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Edit OrgProfile
#   Create Inventory
    And Update ASN with orders tracking Country of origin and Product status and Inventory Type in "SNAPSHOT_01_ASN.xlsx"
    And Navigate to ASNs
    And Clear Notifications
    And Click "byImportDataLoaderButton" on "HeaderPanelPage" WaitForPageLoading
    And Import Data Loader "SNAPSHOT_01_ASN.xlsx"
    And Verify notification message 'File SNAPSHOT_01_ASN.xlsx from Asn is imported successfully.'
    And Search ASN With variable "ASNs"
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT Standard Receiving' at WM Mobile
    And Complete ATStandardReceiving with Country Of Origin
    And Close browser window And Switch to Last Window
    And Navigate to ASNs
    And Wait for page loading
    And Search ASN With variable "ASNs"
    And Select First Row
    And Select Second Row
    And Select Third Row
    And Click "byRelatedLinks" on "HeaderPanelPage"
    And Click "byLPNInventory" on "HeaderPanelPage"
    And Store iLPNs to runtime variables as list
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT System Directed Putaway' at WM Mobile
    And Complete ATSystemDirectedPutAway with Multiple LPN
    And Close browser window And Switch to Last Window
#   Run Inventory Sync
    And Navigate to Inventory Sync
    And Click "byOpenSlideOption" on "InventorySync"
    And Click "byEditConfiguration" on "InventorySync"
    And Update Configuration on generate inventory pix
    And Click "byOpenSlideOption" on "InventorySync"
    And Click on Run button
#    Pix Visibility
    And Navigate to PIX Visibility
    And Search with Quick select filter
    And Select Today from Quick select filter
    And Add Filter for Specification and Item
    And Store generated PIX Data JSON View for the configured Item
    And Validate generated PIX has No Batch Number
    And Validate generated PIX are broken by attributes

# 9. DFN-SNAPSHOT-02 - Stock Snapshot Batches
# Jira Id - MAWMTF01-47
# Test cases covered : 1
  @Snapshot
  Scenario: DFN-SNAPSHOT-02 - Stock Snapshot Batches
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Edit OrgProfile
    #   Create Inventory
    And Update ASN with Multiple LPN tracking Batch number in "SNAPSHOT_02_ASN.xlsx"
    And Navigate to ASNs
    And Clear Notifications
    And Click "byImportDataLoaderButton" on "HeaderPanelPage" WaitForPageLoading
    And Import Data Loader "SNAPSHOT_02_ASN.xlsx"
    And Verify notification message 'File SNAPSHOT_02_ASN.xlsx from Asn is imported successfully.'
    And Search ASN With variable "ASN"
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT Standard Receiving' at WM Mobile
    And Complete ATStandardReceiving with ASN and multiple LPNs
    And Close browser window And Switch to Last Window
    And Navigate to ASNs
    And Wait for page loading
    And Search ASN With variable "ASN"
    And Validate ASN status "Verified"
    And Select First Row
    And Click "byRelatedLinks" on "HeaderPanelPage"
    And Click "byLPNInventory" on "HeaderPanelPage"
    And Store iLPNs to runtime variables as list
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT System Directed Putaway' at WM Mobile
    And Complete ATSystemDirectedPutAway with Multiple LPN
    And Close browser window And Switch to Last Window
    #   Run Inventory Sync
    And Navigate to Inventory Sync
    And Click "byOpenSlideOption" on "InventorySync"
    And Click "byEditConfiguration" on "InventorySync"
    And Update Configuration on generate inventory pix
    And Click "byOpenSlideOption" on "InventorySync"
    And Click on Run button
    And Navigate to PIX Visibility
    And Search with Quick select filter
    And Select Today from Quick select filter
    And Add Filter for Specification and Item
    And Store generated PIX Data JSON View for the configured Item
    And Validate generated PIX is broken by Batch Number

# 10. DFN-INVENTORY-01 : Enter in iLPN Screen Select 3 LPNs, one for each facility status Change the LPN Type on all and ensure all are on the LPNs are properly updated
# Jira Id - MAWMTF01-130
# Test cases covered : 1
  @Inventory
  Scenario: DFN-INVENTORY-01 Enter in iLPN Screen Select 3 LPNs, one for each facility status Change the LPN Type on all and ensure all are on the LPNs are properly updated
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Edit OrgProfile
    And Navigate to Items Page
    And Update ItemId Item Master of Inventory import file with file by 'INVENTORY01ItemMaster.xlsx'
    And Clear Notifications
    And Click "byImportDataLoaderButton" on "HeaderPanelPage" WaitForPageLoading
    And Import Data Loader 'INVENTORY01ItemMaster.xlsx'
    And Wait for page loading
    And Wait for page loading
    And Verify notification message 'File INVENTORY01ItemMaster.xlsx from Item is imported successfully.'
    And Search Item With 'getdata(ItemIdStarting)'
    And Verify Item Id exist
    And Navigate to ASNs
    And Update ASN import file with Item Id LPN Inventory by file 'INVENTORY01ASN.xlsx'
    And Clear Notifications
    And Click "byImportDataLoaderButton" on "HeaderPanelPage" WaitForPageLoading
    And Import Data Loader 'INVENTORY01ASN.xlsx'
    And Wait for page loading
    And Verify notification message 'File INVENTORY01ASN.xlsx from Asn is imported successfully.'
    And Search ASN at ASNs
    And Wait for page loading
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT Standard Receiving' at WM Mobile
    And Process ATStandardReceiving with Item with two LPN Halfway
    And Search menu 'AT User Directed Putaway' at WM Mobile
    And Complete ATUserDirectedPutAway with inventory single LPN
    And Close browser window And Switch to Last Window
    And Navigate to ILPNs
    And Search ASN at ILPNs
    And Verify Status of multiple LPN card
    And Complete Edit LPN Size Type in each ILPN
    And Verify each LPN Size Type in ILPN Card

#  11. FN-COUNT-03 : Count Identifies Variance but Variance Rejected at Final Confirmation After Completing Recount Task
# Jira Id - MAWMTF01-68
# Test cases covered : 1
  @INVPlanAndPerformCount
  Scenario: FN-COUNT-03 : Count Identifies Variance but Variance Rejected at Final Confirmation After Completing Recount Task
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Wait for page loading
    And Edit OrgProfile
    And Navigate to Inventory Details
    And Search with Location Filter "getdata(Location)"
    And Search with Item Filter "getdata(EnterItem)"
    And Store quantity to variable as String
    And Store Batch number to varaiable
    And Store Expiry date to variable
    And Store Inventory Container ILPN To Variable
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'FN Cycle Count' at WM Mobile
    And Scan Location in Cycle count "getdata(ScanLocation)"
    And Click on Confirm in POPup
    And Enter Inventory Container ILPN
    And Scan Item in Cycle count "getdata(Item)"
    And Enter Batch Number in cycle count screen
    And Enter Expiry date in cycle count screen
    And Click Popup Confirm
    And Enter Quantity details in cycle count screen
    And Click on Confirm in POPup
    And Click On End ILPN Button
    And Click on Confirm in POPup
    And Click on End count
    And Click on Confirm in POPup
    And Close browser window And Switch to Last Window
    And Navigate to Inventory Count
    And Search with Location Filter "getdata(Location)"
    And Verify the Inventory Count Pending Booking Status
    And Click on Row At First Index
    And Create Cycle Count task
    And Click on Yes button
    And Click "byRefreshButton" on "RightNavigationBar" WaitForPageLoading
    And Verify the Inventory Count Booking Rejected Status
    And Navigate to Tasks
    And Select Cycle count checkbox filter
    And Search with Quick select filter
    And Select Today from Quick select filter
    And Store Taskid to variable
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'Enter Task' at WM Mobile
    And Enter Taskid
    And Verify Excluded User Error Message "is marked as an excluded user for this task execution. (TSK::178)"
    And Close browser window And Switch to Last Window
    And SignOut And Login With Other credentials
    And Wait for page loading
    And Edit OrgProfile
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'Enter Task' at WM Mobile
    And Enter Taskid
    And Enter Scan Location "getdata(ScanLocation)"
    And Enter Inventory Container ILPN
    And Scan Item in Cycle count "getdata(Item)"
    And Enter correct Quantity in cycle count screen
    And Click On End ILPN Button
    And Click on End count
    And Close browser window And Switch to Last Window
    And Navigate to Tasks
    And Select Cycle count checkbox filter
    And Search with Quick select filter
    And Select Today from Quick select filter
    And Filter TaskID In UI Page
    And Filter Completed Task Status
    And Verify Task Status "Completed"
    And Navigate to Inventory Count
    And Search with Location Filter "getdata(Location)"
    And Search with Quick select filter
    And Select Today from Quick select filter
    And Verify the Count status as booked
    And Store CountRunID To Variable
    And Navigate To Inventory Count Details
    And Filter Inventory Count Run ID
    And Validate Original Quantity And Count Quantity Match
    And Validate Variance Quantity Is Zero