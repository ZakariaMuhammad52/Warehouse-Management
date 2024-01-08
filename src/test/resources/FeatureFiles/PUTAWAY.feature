@DFN
Feature: Putaway_Test_Cases
##List of Test Cases covered
## TC    TS No.	Test Case Name
## 001.  FN-PUTAWAY-07 -Putaway by Product Status - Product Status 'Q' (ITS-PUTAWAY-07)
## 002.  FN-PUTAWAY-06 - Putaway by Product Family Type - Product Class 'Books'(ITS-PUTAWAY-06)
## 003.  FN-PUTAWAY-10 - Trolley Putaway of Multiple iLPNs (ITS-PUTAWAY-10)
## 004.  FN-PUTAWAY-03 -Putaway to pallet stock directed (ITS-PUTAWAY-04)
## 005.  FN-PUTAWAY-02 -Putaway to pick location directed (ITS-PUTAWAY-03)
## 006.  FN-PUTAWAY-09 - Putaway based on Volume (ITS-PUTAWAY-09)
## 007.  FN-PUTAWAY-12 - Putaway to Multi-SKU Location(ITS-PUTAWAY-12)
## 008.  FN-PUTAWAY-13 - Putaway of Pallet containing multiple iLPNs to a single location (ITS-PUTAWAY-13)
## 009.  FN-PUTAWAY-08-Receive large LPN in any way preferred,Ensure your preferred location is too small to fit the LPN by volume.

# Test data : 					Values which are pased as part of test data 
# Pre-requiste Steps : 	Steps which are required to be performed/validated to prepare AUT for executing the scenario 
# Test Case : 					DFN
#FN-PUTAWAY-07 -Putaway by Product Status - Product Status 'Q' (ITS-PUTAWAY-07)

# 1. FN-PUTAWAY-07-Putaway_by_Product_Status_Product_Status_Q
# Jira Id - MAWMTF01-55
# Test cases covered : 1
  @PutAWAY
  Scenario: FN-PUTAWAY-07-Putaway_by_Product_Status_Product_Status_Q
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Edit OrgProfile
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Navigate to Inventory Management
    And Create iLPN
    And Close browser window And Switch to Last Window
    And Navigate to ILPNs
    And Search iLPN at ILPNs
    Then Verify iLPN Inventory Details
    And Navigate to PutAway Planning Strategy Page
    And Click on View button for "FN" PutAway Planning Strategy Item
    And Click on Continue button
    And Click on View button for "QR" PutAway Planning Criteria Item
    And Click on Continue button
    Then Verify Rule details
    And Click on Continue button
    And Click on View button for First PutAway
    Then Verify Determination Mode as 'getdata(DeterminationMode)'
    And Click on Continue button
    Then Verify PutWay Zone as 'getdata(PutawayZone)'
    And Finish PutWay Zone process
    And Navigate to Storeage Location
    And Search Put Allocation Zone with 'getdata(PutAllocationZone)'
    Then Verify Location displayed as 'getdata(Location)'
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'FN Putaway System Directed' at WM Mobile
    And Enter ILPN and Location in FN PutAway System Directed Page
    And Close browser window And Switch to Last Window
    And Navigate to ILPNs
    And Search iLPN at ILPNs
    Then Verify ILPN Details in ILPN Page
    And Verify Product status and Inventory type in Inventory Details Page

# 2. FN-PUTAWAY-06-Putaway_by_Product_Family_Type_Product_Class_Books
# Jira Id - MAWMTF01-67
# Test cases covered : 1
  @PutAWAY
  Scenario: FN-PUTAWAY-06-Putaway_by_Product_Family_Type_Product_Class_Books
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Edit OrgProfile
    And Navigate to PutAway Planning Strategy Page
    And Click on View button for "FN" PutAway Planning Strategy Item
    And Click on Continue button
    And Click on View button for "Books" PutAway Planning Criteria Item
    And Click on Continue button
    Then Verify Rule details
    And Click on Continue button
    And Click on View button for First PutAway
    Then Verify Determination Mode as 'getdata(DeterminationMode)'
    And Click on Continue button
    Then Verify PutWay Zone as 'getdata(PutawayZone)'
    And Finish PutWay Zone process
    And Navigate to ILPNs
    And Select checkbox "byILPNStatusNotAllocatedCheckbox" on "ILPNs"
    And Search Item With 'getdata(Item)'
    Then Verify ILPNs displayed without current location in ILPN Page
    And Navigate to Items Page
    And Search Item With 'getdata(Item)'
    Then Verify Product class value as 'getdata(ProductClass)'
    And Navigate to Storeage Location
    And Search Put Allocation Zone with 'getdata(PutAllocationZone)'
    Then Verify Matching Criteria data displayed
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'FN Putaway System Directed' at WM Mobile
    And Enter ILPN and Location in FN PutAway System Directed Page
    And Close browser window And Switch to Last Window
    And Navigate to ILPNs
    And Search iLPN at ILPNs
    Then Verify ILPN Current Location
    And Navigate to Storeage Location
    And Search Display location
    And Verify PutAllocation Zone as 'getdata(PutAllocationZone)' in Location Popup Page

# 3. FN-PUTAWAY-10-Trolley Putaway of Multiple iLPNs
# Jira Id - MAWMTF01-57
# Test cases covered : 1
  @PutAWAY
  Scenario: FN-PUTAWAY-10-Trolley Putaway of Multiple iLPNs
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Edit OrgProfile
    And Update ASN with three lines "PUTAWAY10ASN.xlsx" 
    And Navigate to ASNs
    And Clear Notifications
    And Click "byImportDataLoaderButton" on "HeaderPanelPage" WaitForPageLoading
    And Import Data Loader "PUTAWAY10ASN.xlsx"
    And Verify notification message 'File PUTAWAY10ASN.xlsx from Asn is imported successfully.'
    And Search ASN at ASNs
    And Verify ASN details are displayed
    And Verify Product status and Inventory type in ASN Details Page
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'FN Trolley Receiving' at WM Mobile
    And Complete FN Trolley Receiving
    Then Verification attempted for ASN is displayed
    And Close browser window And Switch to Last Window
    And Navigate to ASNs
    And Search ASN at ASNs
    Then Validate ASN status "Verified"
    And Verify 'getdata(ProductStatusCount)' LPNs are liked to same pallet
    And Verify Inventory details for each LPN
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'FN Putaway Trolley' at WM Mobile
    And Complete FN Trolley PutAway
    And Close browser window And Switch to Last Window
    And Navigate to ASNs
    And Search ASN at ASNs
    And Click "byRelatedLinks" on "HeaderPanelPage"
    And Click "byLPNInventory" on "HeaderPanelPage"
    And Verify PutAway ASN details

# 4. DFN-PUTAWAY-03-Putaway to pallet stock directed
# Jira Id - MAWMTF01-49
# Test cases covered : 1
  @PutAWAY
  Scenario: DFN-PUTAWAY-03-Putaway to pallet stock directed
  # ITS-PUTAWAY-04 - Process a putaway
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Edit OrgProfile
    And Navigate to ILPNs
    And Filter ILPNS by 'getdata(strLPNStatus)' and 'getdata(strLPNItemID)'
    And Store ILPNS number in runtime variable
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT System Directed Putaway' at WM Mobile
    And Putaway LPN AT System Directed
    And Validate ILPNs Current Display Location
    #And Validate ILPNs Current Display Location 'getdata(strDisplayLocation)'
    #And Complete AT System Directed Putaway
    #And Navigate to ILPNs
    #And Search iLPN at ILPNs
    #And Verify iLPN in Current Display Location at ILPNS


# 5. FN-PUTAWAY-02-Putaway to pick location directed
# Jira Id - MAWMTF01-44
# Test cases covered : 1
  @PutAWAY
  Scenario: FN-PUTAWAY-02-Putaway to pick location directed
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Edit OrgProfile
    And Update ASN with one quantity "PUTAWAY02ASN.xlsx"
    And Navigate to ASNs
    And Click "byImportDataLoaderButton" on "HeaderPanelPage" WaitForPageLoading
    And Import Data Loader "PUTAWAY02ASN.xlsx"
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT Standard Receiving' at WM Mobile
    And Complete ATStandardReceiving entering batch number
    And Navigate to ILPNs
    And Search LPN with Variable Name "LPN"
    And Verify ILPN Details "Before" AT System Directed PutAway
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT System Directed Putaway' at WM Mobile
    And Putaway LPN AT System Directed
    And Close browser window And Switch to Last Window
    And Navigate to ILPNs
    And Search LPN with Variable Name "LPN"
    And Verify ILPN Details "After" AT System Directed PutAway

# 6. FN-PUTAWAY-09-Putaway based on Volume
# Jira Id - MAWMTF01-72
# Test cases covered : 1
  @PutAWAY
  Scenario: FN-PUTAWAY-09-Putaway based on Volume
    Given Open the browser and launch the application
    And Login to WMS Manhattan via SSO Login
    And Edit OrgProfile
    And Navigate to Items Page
    And Update ItemId for Putaway based on volume in 'PUTAWAY09Item.xlsx'
    And Clear Notifications
    And Click "byImportDataLoaderButton" on "HeaderPanelPage" WaitForPageLoading
    And Import Data Loader 'PUTAWAY09Item.xlsx'
    And Verify notification message 'File PUTAWAY09Item.xlsx from Item is imported successfully.'
    And Search Item With variable "Item"
    And Verify Item with variable "Item"
    And Update Location in "PUTAWAY09Location.xlsx"
    And Navigate to Storeage Location
    And Click "byImportDataLoaderButton" on "HeaderPanelPage" WaitForPageLoading
    And Import Data Loader "PUTAWAY09Location.xlsx"
    And Search Location with variable "Location" value
    And Store "MaxWeight" and "MaxVolume" from location popup
    And Add Item with variable 'Item' to Location
    And Store "CurrentWeight" and "CurrentVolume" from location capacity usage page
    And Store "AvailableWeight" and "AvailableVolume" for location
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Navigate to Inventory Management
    And Create 'getdata(LPNCount)' iLPNs with Serial Number
    And Close browser window And Switch to Last Window
    And Navigate to ILPNs
    And Search LPN with Variable Name "LPN1"
    Then Verify LPN Volume is Greater than Location available Volume
    And Search LPN with Variable Name "LPN2"
    Then Verify LPN Weight and Volume are Less than Location available Weight and Volume
    And Navigate to PutAway Planning Strategy Page
    And Click on View button for "getdata(PlanningStrategyItem)" PutAway Planning Strategy Item
    And Click on Continue button
    And Click on View button for "getdata(PlanningCriteriaItem)" PutAway Planning Criteria Item
    And Click on Continue button
    Then Verify Rule details
    And Click on Continue button
    And Click on View button for "getdata(PutawayPriority1)" PutAway Priority
    Then Verify Determination Mode as 'getdata(DeterminationMode)'
    And Click on Continue button
    Then Verify PutWay Zone as 'getdata(PutawayZone1)' at index '1'
    Then Verify PutWay Zone as 'getdata(PutawayZone2)' at index '2'
    And Click on Finish button
    And Click on View button for "getdata(PutawayPriority2)" PutAway Priority
    Then Verify Determination Mode as 'getdata(DeterminationMode)'
    And Click on Continue button
    Then Verify PutWay Zone as 'getdata(PutawayZone4)' at index '1'
    Then Verify PutWay Zone as 'getdata(PutawayZone5)' at index '2'
    And Finish PutWay Zone process
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT System Directed Putaway' at WM Mobile
    Then Verify "LPN1" is redirected to "getdata(Location1)" location
    And Search menu 'AT System Directed Putaway' at WM Mobile
    And Verify "LPN2" is redirected to "getdata(Location2)" location

# 7. FN-PUTAWAY-12-Putaway to Multi-SKU Location
# Jira Id - MAWMTF01-69
# Test cases covered : 1
  @PutAWAY
  Scenario: FN-PUTAWAY-12-Putaway to Multi-SKU Location
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Edit OrgProfile
    And Navigate to Items Page
    And Update ItemId for three Items 'PUTAWAY12Item.xlsx'
    And Clear Notifications
    And Click "byImportDataLoaderButton" on "HeaderPanelPage" WaitForPageLoading
    And Import Data Loader 'PUTAWAY12Item.xlsx'
    And Verify notification message 'File PUTAWAY12Item.xlsx from Item is imported successfully.'
    And Search Item With variable "Item1"
    And Verify Item with variable "Item1"
    And Update Location in "PUTAWAY12Location.xlsx"
    And Navigate to Storeage Location
    And Click "byImportDataLoaderButton" on "HeaderPanelPage" WaitForPageLoading
    And Import Data Loader "PUTAWAY12Location.xlsx"
    And Search Location with variable "Location" value
    And Expand side arrow button
    And Click details button
    And Expand Location Information section
    Then Verify Max Items in Location Information
    And Search Location with variable "Location" value
    And Select First Row
    And Add Item with variable 'Item1' to Location
    And Select First Row
    And Add Item with variable 'Item3' to Location
    And Navigate to ASNs
    And Update ASN With Four LPNs'PUTAWAY12ASN.xlsx'
    And Clear Notifications
    And Click "byImportDataLoaderButton" on "HeaderPanelPage" WaitForPageLoading
    And Import Data Loader 'PUTAWAY12ASN.xlsx'
    And Wait for page loading
    And Verify notification message 'File PUTAWAY12ASN.xlsx from Asn is imported successfully.'
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
    And Close browser window And Switch to Last Window
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT System Directed Putaway' at WM Mobile
    Then Verify LPNs are directed as per Location available capacity

# 8. FN-PUTAWAY-13-Putaway of Pallet containing multiple iLPNs to a single location
# Jira Id - MAWMTF01-73
# Test cases covered : 1
  @PutAWAY
  Scenario: FN-PUTAWAY-13-Putaway of Pallet containing multiple iLPNs to a single location
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Edit OrgProfile
    And Update ASN in "PutAway13ASN.xlsx"
    And Navigate to ASNs
    And Clear Notifications   
    And Click "byImportDataLoaderButton" on "HeaderPanelPage" WaitForPageLoading
    And Import Data Loader "PUTAWAY13ASN.xlsx"
    And Verify notification message 'File PUTAWAY13ASN.xlsx from Asn is imported successfully.'
    And Search ASN at ASNs
    Then Verify ASN details are displayed
    And Verify Parent and Child Lpn details in ILPN Page
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
    And Navigate to PutAway Planning Strategy Page
    And Click on View button for "ATPlt" PutAway Planning Strategy Item
    Then Verify Container planning mode
    And Click "byContinueButtonInRightSide" on "PutAwayPlanningStrategyPage"
    ##And Click on Continue button
    And Click on View button for "ATPlt" PutAway Planning Criteria Item
    And Click "byContinueButtonInRightSide" on "PutAwayPlanningStrategyPage"
    ##And Click on Continue button
    And Click "byContinueButtonInRightSide" on "PutAwayPlanningStrategyPage"
    ##And Click on Continue button
    And Click on View button for First PutAway
    Then Verify Determination Mode as 'getdata(DeterminationMode)'
    And Click "byContinueButtonInRightSide" on "PutAwayPlanningStrategyPage"
    ##And Click on Continue button
    Then Verify PutWay Zone as 'getdata(PutawayZone1)' at index '1'
    Then Verify PutWay Zone as 'getdata(PutawayZone2)' at index '2'
    Then Verify PutWay Zone as 'getdata(PutawayZone3)' at index '3'
    And Finish PutWay Zone process
    And Navigate to ILPNs
    And Click on ClearAll button
    And Search ASN with Variable Name "ASN"
    Then Verify ILPNs linked to ASN "Before" AT Pallet PutAway System Directed
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT Pallet Putaway System Directed' at WM Mobile
    And Completed AT Pallet PutAway System Directed with "LPN"
    And Close browser window And Switch to Last Window
    And Click "byRefreshButton" on "RightNavigationBar" WaitForPageLoading
    Then Verify ILPNs linked to ASN "After" AT Pallet PutAway System Directed

  @PutAWAY
  Scenario: FN-PUTAWAY-08-Receive large LPN in any way preferred,Ensure your preferred location is too small to fit the LPN by volume.
    Given Open the browser and launch the application
    And Login to WMS Manhattan via SSO Login
    And Edit OrgProfile
    And Navigate to Items Page
    And Update ItemId for Putaway based xlsx 'PUTAWAY08Item.xlsx'
    And Clear Notifications
    And Click "byImportDataLoaderButton" on "HeaderPanelPage" WaitForPageLoading
    And Import Data Loader 'PUTAWAY08Item.xlsx'
    And Verify notification message 'File PUTAWAY08Item.xlsx from Item is imported successfully.'
    And Search Item With variable "Item"
    And Verify Item with variable "Item"
    And Update Location in "PUTAWAY08Location.xlsx"
    And Navigate to Storeage Location
    And Click "byImportDataLoaderButton" on "HeaderPanelPage" WaitForPageLoading
    And Import Data Loader "PUTAWAY08Location.xlsx"
    And Search Location with variable "Location" value
    And Store "MaxWeight" and "MaxVolume" from location popup
    And Add Item with variable 'Item' to Location
    And Store "CurrentWeight" and "CurrentVolume" from location capacity usage page
    And Store "AvailableWeight" and "AvailableVolume" for location
    And Navigate to ASNs
    And Update ASN File With two LPNs'PUTAWAY08ASN.xlsx'
    And Clear Notifications
    And Click "byImportDataLoaderButton" on "HeaderPanelPage" WaitForPageLoading
    And Import Data Loader 'PUTAWAY08ASN.xlsx'
    And Wait for page loading
    And Verify notification message 'File PUTAWAY08ASN.xlsx from Asn is imported successfully.'
    And Search ASN at ASNs
    And Wait for page loading
    And Verify ASN details are displayed
    And Validate ASN status "In Transit"
    And Verify ILPNs linked to ASN with variable  "listOfILPNs"
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT Standard Receiving' at WM Mobile
    And Complete ATStandardReceiving with ASN and multiple LPNs
    And Click ok in popup message in WM mobile
    And Click on Menu in WM mobile
    And Confirm prompt in WM mobile
    And Close browser window And Switch to Last Window
    And Navigate to ILPNs
    And Search LPN with Variable Name "ILPN1"
    Then Validate LPN Volume is Greater than Location available Volume
    And Search LPN with Variable Name "ILPN2"
    Then Verify LPN Weight and Volume are Less than Location available Weight and Volume
    And Navigate to PutAway Planning Strategy Page
    And Click on View button for "AT" PutAway Planning Strategy Item
    And Click on Continue button
    And Click on View button for 'getdata(PutawayCriteria)' PutAway Planning Criteria Item
    And Click on Continue button
    Then Verify 'getdata(BUID)' value at column '4' in Selection Rules
    And Click on Continue button
    And Click on View button for 'getdata(PutawayPriority1)' PutAway Priority
    Then Verify Determination Mode as 'getdata(DeterminationMode)'
    And Click on Continue button
    Then Verify PutWay Zone as 'getdata(PutawayZone1)' at index '1'
    Then Verify PutWay Zone as 'getdata(PutawayZone2)' at index '2'
    And Click on Finish button
    And Click on View button for 'getdata(PutawayPriority2)' PutAway Priority
    Then Verify Determination Mode as 'getdata(DeterminationMode)'
    And Click on Continue button
    Then Verify PutWay Zone as 'getdata(PutawayZone4)' at index '1'
    Then Verify PutWay Zone as 'getdata(PutawayZone5)' at index '2'
    And Click first putaway from navigation list
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT System Directed Putaway' at WM Mobile
    Then Verify "ILPN1" is redirected to "R1" location
    And Search menu 'AT System Directed Putaway' at WM Mobile
    And Verify "ILPN2" is redirected to "S1" location

