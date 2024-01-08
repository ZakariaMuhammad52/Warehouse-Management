@DFN
Feature: Routing_Test_Cases
##List of Test Cases covered
## TC    TS No.	Test Case Name
## 001.  1          FN-ROUTING-04: Routing runs per weight of orders
## 002.  2          FN-ROUTING-05- Test route per volume of the order
## 003.  3          FN-ROUTING-01 : Configure routing so the ship via determination is based on oLPN size and destination(ITS-ROUTING-01)
## 004.  4          FN-ROUTING-03 : Create route per postal code range and test with multiple orders
## 005.  5          FN-ROUTING-07: Interface selects the ship via so no routing is needed (ITS-ROUTING-07)
## 006.  6          FN-ROUTING-06 -Test route per order type
## 007.  7          FN-ROUTING-08-Combination of all previous scenarios ROUTING-01 to ROUTING-07(ITS-ROUTING-08)


  # Test data : 					Values which are pased as part of test data
# Pre-requiste Steps : 	Steps which are required to be performed/validated to prepare AUT for executing the scenario
# Test Case : 					DFN
  @Routing
  Scenario: FN-ROUTING-04: Routing runs per weight of orders (ITS-ROUTING-04)
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Edit OrgProfile
    And Navigate to Items Page
    And Search Item With "getdata(Item)"
    And Verify Multiple Items with "getdata(Items)"
    And Update ASN file with LPN "AsnROUTING04.xlsx"
    And Navigate to ASNs
    And Clear Notifications
    And Click "byImportDataLoaderBtn" on "ASNs"
    And Import Data Loader "AsnROUTING04.xlsx"
    And Wait for page loading
    And Verify notification message 'File AsnROUTING04.xlsx from Asn is imported successfully.'
    And Search ASN at ASNs
    And Verify ASN details are displayed
    And Validate ASN status "In Transit"
    And Verify Inventory Details for multiple ilpns
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
    And Expand Filter
    And Search with Item Filter "getdata(Item)"
    And Navigate to Original Orders2
    And Update Two Original Order with Two Lines 'FN-ROUTING-04-Order.xlsx'
    And Clear Notifications
    And Click "byImportDataLoaderBtn" on "OriginalOrdersPage"
    And Import Data Loader "FN-ROUTING-04-Order.xlsx"
    And Wait for page loading
    And Verify notification message 'File FN-ROUTING-04-Order.xlsx from OriginalOrder is imported successfully.'
    And Click "byRefreshBtn" on "OriginalOrdersPage"
    And Verify Imported Orders with variable name "OriginalOrder1"
    And Verify Imported Orders with variable name "OriginalOrder2"
    And Navigate to Order Planning Strategy
    And View FNROUTING wave Strategy "getdata(Strategy)"
    And Select Order Selection Criteria For Routing
    And Wait for page loading
    And Navigate to Routing Strategy
    And View ATROUTING Strategy "getdata(ATRoutingStrategy)"
    Then Set Routing Criteria For Routing And Verify Destination Country Rule
    And Navigate to Ship Via
    And Wait for page loading
    Then Check Ship Vias And Verify the CarrierID "getdata(CarrierID1)"
    Then Check Ship Vias And Verify the CarrierID "getdata(CarrierID2)"
    And Navigate to Original Orders2
    And Execute RunWave 'getdata(Strategy)' by Selecting Multiple orders "OriginalOrder"
    And Navigate to Wave Runs
    And Search Wave run at Wave Runs
    And Validate Wave run status till "Completed"
    And Click on Row At First Index
    And Click "byRelatedLinks" on "WaveRunsPage"
    And Wait for page loading
    And Click on oLPNs Links
    And Verify Multiple oLPNs Statuses with variable "getdata(OLPNStatuses)"
    And Validate OrderID And ShipVia Details Of OLPN In RoutingLaneOption "getdata(CarrierID1)" "OriginalOrder1"
    And Validate OrderID And ShipVia Details Of OLPN In RoutingLaneOption "getdata(CarrierID2)" "OriginalOrder2"

  @Routing
  Scenario: FN-ROUTING-05 : Test route per volume of the order (ITS-ROUTING-05)
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Edit OrgProfile
    And Navigate to Items Page
    And Search Item With "getdata(Item)"
    And Verify Multiple Items with "getdata(Items)"
    And Update ASN file with LPN "FN-ROUTING-05-ASN.xlsx"
    And Navigate to ASNs
    And Clear Notifications
    And Click "byImportDataLoaderBtn" on "ASNs"
    And Import Data Loader "FN-ROUTING-05-ASN.xlsx"
    And Wait for page loading
    And Verify notification message 'File FN-ROUTING-05-ASN.xlsx from Asn is imported successfully.'
    And Search ASN at ASNs
    And Verify ASN details are displayed
    And Validate ASN status "In Transit"
    And Verify Inventory Details for multiple ilpns
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
    And Navigate to Original Orders2
    And Update Two Original Order with Two Lines 'FN-ROUTING-05-originalorder.xlsx'
    And Clear Notifications
    And Click "byImportDataLoaderBtn" on "OriginalOrdersPage"
    And Import Data Loader "FN-ROUTING-05-originalorder.xlsx"
    And Wait for page loading
    And Verify notification message 'File FN-ROUTING-05-originalorder.xlsx from OriginalOrder is imported successfully.'
    And Click "byRefreshBtn" on "OriginalOrdersPage"
    And Verify Imported Orders with variable name "OriginalOrder1"
    And Verify Imported Orders with variable name "OriginalOrder2"
    And Navigate to Order Planning Strategy
    And View FNROUTING wave Strategy "getdata(Strategy)"
    And Select Order Selection Criteria For Routing
    And Wait for page loading
    And Navigate to Routing Strategy
    And View ATROUTING Strategy "getdata(ATRoutingStrategy)"
    Then Set Routing Criteria For Routing And Verify Destination Country Rule
    And Navigate to Ship Via
    And Wait for page loading
    Then Check Ship Vias And Verify the CarrierID "getdata(CarrierID1)"
    Then Check Ship Vias And Verify the CarrierID "getdata(CarrierID2)"
    And Navigate to Original Orders2
    And Execute RunWave 'getdata(Strategy)' by Selecting Multiple orders "OriginalOrder"
    And Navigate to Wave Runs
    And Search Wave run at Wave Runs
    And Validate Wave run status till "Completed"
    And Click on Row At First Index
    And Click "byRelatedLinks" on "WaveRunsPage"
    And Wait for page loading
    And Click on oLPNs Links
    And Verify Multiple oLPNs Statuses with variable "getdata(OLPNStatuses)"
    And Validate OrderID And ShipVia Details Of OLPN In RoutingLaneOption "getdata(CarrierID1)" "OriginalOrder1"
    And Validate OrderID And ShipVia Details Of OLPN In RoutingLaneOption "getdata(CarrierID2)" "OriginalOrder2"


    # Test data : 					Values which are pased as part of test data
# Pre-requiste Steps : MAWMTF01-159	Steps which are required to be performed/validated to prepare AUT for executing the scenario
# Test Case : FN-ROUTING-01-TestScenarioDefinition
  @Routing
  Scenario: FN-ROUTING-01 : Configure routing so the ship via determination is based on oLPN size and destination(ITS-ROUTING-01)
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Edit OrgProfile
    And Navigate to Items Page
    And Search Item With "getdata(Item)"
    And Verify Item with "Item"
    And Navigate to LANE Page
    And Search Lane With 'getdata(LaneItem)'
    And Click on Row At First Index
    And Click "byRelatedLinks" on "HeaderPanelPage"
    And Click "byRoutingLaneOptionLink" on "HeaderPanelPage"
    And Search Carrier With 'getdata(Carrier)'
    And Verify Carrier Id 'getdata(Carrier3)' and 'getdata(Carrier4)' exist
        ##Import ASN
    And Navigate to ASNs
    And Update Asn and two Lpn "FN-ASN-ROUTING-01.xlsx"
    And Clear Notifications
    And Click "byImportDataLoaderButton" on "HeaderPanelPage"
    And Import Data Loader "FN-ASN-ROUTING-01.xlsx"
    And Verify notification message 'File FN-ASN-ROUTING-01.xlsx from Asn is imported successfully.'
    And Search ASN at ASNs
    Then Verify ASN details are displayed
     ##Receive ASN
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT Standard Receiving' at WM Mobile
    And Complete ATStandardReceiving with ASN and multiple LPNs
    And Close browser window And Switch to Last Window
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT System Directed Putaway' at WM Mobile
    And Enter Multiple ILPNs and Location in AT System Directed Putaway Page with "listOfILPNs"
    And Close browser window And Switch to Last Window
    And Navigate to ASNs
    And Wait for page loading
    And Search ASN at ASNs
    And Validate ASN status "Verified"
        ##Import order
    And Navigate to Original Orders2
    And Update Two Original Order with Two Lines 'FN-ORDER-ROUTING.xlsx'
    And Clear Notifications
    And Click "byImportDataLoaderBtn" on "OriginalOrdersPage"
    And Import Data Loader "FN-ORDER-ROUTING.xlsx"
    And Wait for page loading
    And Verify notification message 'File FN-ORDER-ROUTING.xlsx from OriginalOrder is imported successfully.'
    And Click "byRefreshBtn" on "OriginalOrdersPage"
    And Verify Imported Orders with variable name "OriginalOrder1"
    And Verify Imported Orders with variable name "OriginalOrder2"
      ##Run WAVE
    And Execute RunWave 'getdata(Strategy)' by Selecting Multiple orders "OriginalOrder"
    And Navigate to Wave Runs
    And Search Wave run at Wave Runs
    And Validate Wave run status till "Completed"
    And Click on Row At First Index
    And Click "byRelatedLinks" on "WaveRunsPage"
    And Wait for page loading
    And Click on oLPNs Links
    And Validate Carrier Shipment Details for ATL1E and ATL2E

     # Test data : 					Values which are pased as part of test data
# Pre-requiste Steps : MAWMTF01-160	Steps which are required to be performed/validated to prepare AUT for executing the scenario
# Test Case : FN-ROUTING-03-TestScenarioDefinition
  @Routing
  Scenario: FN-ROUTING-03 : Create route per postal code range and test with multiple orders (ITS-ROUTING-03)
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Edit OrgProfile
    And Navigate to Items Page
    And Search Item With "getdata(Items)"
    And Verify Item Id exist
    And Navigate to LANE Page
    And Search Lane With 'getdata(LaneItem1)'
    And Click on Row At First Index
    And Click "byRelatedLinks" on "HeaderPanelPage"
    And Click on Routing Lane Option Links
    And Search Carrier With 'getdata(Carrier)'
    And Verify Carrier Id 'getdata(Carrier1)' and 'getdata(Carrier2)' exist in Lane Page
    And Navigate to LANE Page
    And Search Lane With 'getdata(LaneItem2)'
    And Click on Row At First Index
    And Click "byRelatedLinks" on "HeaderPanelPage"
    And Click on Routing Lane Option Links
    And Search Carrier With 'getdata(Carrier)'
    And Verify Carrier Id 'getdata(Carrier3)' and 'getdata(Carrier4)' exist
        ##Import ASN
    And Navigate to ASNs
    And Update Asn and two Lpn "FN-ROUTING-03-ASN.xlsx"
    And Clear Notifications
    And Click "byImportDataLoaderButton" on "HeaderPanelPage"
    And Import Data Loader "FN-ROUTING-03-ASN.xlsx"
    And Verify notification message 'FN-ROUTING-03-ASN.xlsx from Asn is imported successfully.'
    And Search ASN at ASNs
    Then Verify ASN details are displayed
     ##Receive ASN
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT Standard Receiving' at WM Mobile
    And Complete ATStandardReceiving with two LPN
    And Click "byVerifyASNButton" on "UserDirected"
    And Validate popup message "Verification request has been submitted for ASN"
    And Close browser window And Switch to Last Window
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT System Directed Putaway' at WM Mobile
    And Enter ILPN and Location For Two LPNs in FN PutAway System Directed Page
    And Close browser window And Switch to Last Window
    And Navigate to ASNs
    And Wait for page loading
    And Search ASN at ASNs
    And Validate ASN status "Verified"
        ##Import order
    And Navigate to Original Orders2
    And Update Two Original Order with Two Lines 'FN-ROUTING-03-Order.xlsx'
    And Clear Notifications
    And Click "byImportDataLoaderBtn" on "OriginalOrdersPage"
    And Import Data Loader "FN-ROUTING-03-Order.xlsx"
    And Wait for page loading
    And Verify notification message 'FN-ROUTING-03-Order.xlsx from OriginalOrder is imported successfully.'
    And Click "byRefreshBtn" on "OriginalOrdersPage"
    And Verify Imported Orders with variable name "OriginalOrder1"
    And Verify Imported Orders with variable name "OriginalOrder2"
          ##Run WAVE
    And Execute RunWave 'getdata(Strategy)' by Selecting Multiple orders "OriginalOrder"
    And Navigate to Wave Runs
    And Search Wave run at Wave Runs
    And Click on Row At First Index
    And Validate Wave run status till "Completed"
    And Click on Row At First Index
    And Click "byRelatedLinks" on "WaveRunsPage"
    And Wait for page loading
    And Click on oLPNs Links
    And Validate Carrier Shipment Details for ATL4E and ATL5E

    # Test data : Values which are pased as part of test data
# Pre-requiste Steps : MAWMTF01-161	Steps which are required to be performed/validated to prepare AUT for executing the scenario
# Test Case : FN-ROUTING-07-TestScenarioDefinition
  @Routing
  Scenario: FN-ROUTING-07: Interface selects the ship via so no routing is needed (ITS-ROUTING-07)
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Edit OrgProfile
    And Navigate to Items Page
    And Search Item With "getdata(Item)"
    And Verify Item with "Item"
    And Navigate to LANE Page
    And Search Lane With 'getdata(LaneItem1)'
    And Click on Row At First Index
    And Click "byRelatedLinks" on "HeaderPanelPage"
    And Click "byRoutingLaneOptionLink" on "HeaderPanelPage"
    And Search Carrier With 'getdata(Carrier)'
    And Verify Carrier Id 'getdata(Carrier1)' and 'getdata(Carrier2)' exist
    And Navigate to LANE Page
    And Search Lane With 'getdata(LaneItem2)'
    And Click on Row At First Index
    And Click "byRelatedLinks" on "HeaderPanelPage"
    And Click "byRoutingLaneOptionLink" on "HeaderPanelPage"
    And Search Carrier With 'getdata(Carrier)'
    And Verify Carrier Id 'getdata(Carrier3)' and 'getdata(Carrier4)' exist
        ##Import ASN
    And Navigate to ASNs
    And Update Asn and two Lpn "FN-ASN-ROUTING-07-TestScenarioDefinition.xlsx"
    And Clear Notifications
    And Click "byImportDataLoaderButton" on "HeaderPanelPage"
    And Import Data Loader "FN-ASN-ROUTING-07-TestScenarioDefinition.xlsx"
    And Verify notification message 'File FN-ASN-ROUTING-07-TestScenarioDefinition.xlsx from Asn is imported successfully.'
    And Search ASN at ASNs
    Then Verify ASN details are displayed
     ##Receive ASN
    And Navigate to WM Mobile
    And Wait for page loading
    And Update ORG Profile in WM Mobile
    And Search menu 'AT Standard Receiving' at WM Mobile
    And Complete ATStandardReceiving with ASN and multiple LPNs
    And Close browser window And Switch to Last Window
    And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
    And Search menu 'AT System Directed Putaway' at WM Mobile
    And Enter Multiple ILPNs and Location in AT System Directed Putaway Page with "listOfILPNs"
    And Close browser window And Switch to Last Window
    And Navigate to ASNs
    And Wait for page loading
    And Search ASN at ASNs
    And Validate ASN status "Verified"
        ##Import order
    And Navigate to Original Orders2
    And Update one OriginalOrder with one Orderline "FN-ORDER-ROUTING-07-TestScenarioDefinition.xlsx"
    And Clear Notifications
    And Click "byImportDataLoaderBtn" on "OriginalOrdersPage"
    And Import Data Loader "FN-ORDER-ROUTING-07-TestScenarioDefinition.xlsx"
    And Wait for page loading
    And Verify notification message 'File FN-ORDER-ROUTING-07-TestScenarioDefinition.xlsx from OriginalOrder is imported successfully.'
    And Click "byRefreshBtn" on "OriginalOrdersPage"
    And Verify Imported Orders with variable name "OriginalOrder1"

        ##Run WAVE
    And Execute RunWave 'getdata(Strategy)' by Selecting Multiple orders "OriginalOrder"
    And Navigate to Wave Runs
    And Search Wave run at Wave Runs
    And Validate Wave run status till "Completed"
    And Click on Row At First Index
    And Click "byRelatedLinks" on "WaveRunsPage"
    And Wait for page loading
    And Click on oLPNs Links
    And Validate Carrier Shipment Details for ATL4E
    And Navigate to Shipments Page
    And Search Shipment With "ShipmentId" in Shipment Page
    And Click "byRelatedLinks" on "HeaderPanelPage"
    And Click "byOLPNLink" on "HeaderPanelPage"
    And Validate Carrier ATL4E in Shipment Page with "OlpnID"


  Scenario: FN-ROUTING-06 -Test route per order type (ITS-ROUTING-06)
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Edit OrgProfile
    And Navigate to Items Page
    And Search Item With "getdata(Item)"
    And Verify Item Id exist
    And Verify Multiple Items with "getdata(Items)"
    And Update ASN file with LPN "FNROUTING06Asn.xlsx"
    And Navigate to ASNs
    And Clear Notifications
    And Click "byImportDataLoaderBtn" on "ASNs"
    And Import Data Loader "FNROUTING06Asn.xlsx"
    And Wait for page loading
    And Verify notification message 'File FNROUTING06Asn.xlsx from Asn is imported successfully.'
    And Search ASN at ASNs
    And Verify ASN details are displayed
    And Validate ASN status "In Transit"
    And Verify Inventory Details for multiple ilpns
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
    And Expand Filter
#    And Expand Filter
    And Search with Item Filter "getdata(Item)"
    And Filter by Inventory Details with InventoryReservation and Location Type
    And Verify multiple Ilpns Data In Inventory Details_with ListOfItems
    And Navigate to Original Orders2
    And Update Two Original Order with Two Lines 'FNROUTING06Orders.xlsx'
    And Clear Notifications
    And Click "byImportDataLoaderBtn" on "OriginalOrdersPage"
    And Import Data Loader "FNROUTING06Orders.xlsx"
    And Wait for page loading
    And Verify notification message 'File FNROUTING06Orders.xlsx from OriginalOrder is imported successfully.'
    And Click "byRefreshBtn" on "OriginalOrdersPage"
    And Verify Imported Orders with variable name "OriginalOrder1"
    And Validate Orders status "Released"
    And Verify Imported Orders with variable name "OriginalOrder2"
    And Validate Orders status "Released"
    And Navigate to OrderLines Page
    And Search Order with variable "OriginalOrder1"
    And Verify OrderLineNeed and OrderLineAttributes for multiple orders with variable "listOfOrders"
    And Search Order with variable "OriginalOrder2"
    And Verify OrderLineNeed and OrderLineAttributes for multiple orders with variable "listOfOrders"
    And Navigate to Order Planning Strategy
    And View FNROUTING wave Strategy "getdata(Strategy)"
    And Select Order Selection Criteria For Routing
    And Wait for page loading
    And Navigate to Routing Strategy
    And View ATROUTING Strategy "getdata(CSRoutingStrategy)"
    And Select Parcel Determination Strategy
    Then Verify Parcel Determination Strategy
    And Navigate to Parcel Determination Strategy
    And View FNParcelDeterminationStrategy
    And Select and View Parcel resources
    And Select and Verify Order Selection Criteria
    And Select and View Second Parcel resource
    And Select and Verify Order Selection Criteria For Second Resource
    And Navigate to Original Orders2
    And Run FNCUBING Wave for two Orders
    And Navigate to Wave Runs
    And Search Wave run at Wave Runs
    And Validate Wave run status till "Completed"
    And Click on Row At First Index
    And Click "byRelatedLinks" on "WaveRunsPage"
    And Wait for page loading
    And Click on oLPNs Links
    And Verify Multiple oLPNs Statuses with variable "getdata(OLPNStatuses)"
    And Validate OrderID And ShipVia Details Of OLPN In RoutingLaneOption "getdata(ShipViaId2)" "OriginalOrder1"
    And Validate OrderID And ShipVia Details Of OLPN In RoutingLaneOption "getdata(ShipViaId1)" "OriginalOrder2"

    # Test data : Values which are pased as part of test data
# Pre-requiste Steps : MAWMTF01-163	Steps which are required to be performed/validated to prepare AUT for executing the scenario
# Test Case : FN-ROUTING-08-TestScenarioDefinition
  @Routing
  Scenario: FN-ROUTING-08-Combination of all previous scenarios ROUTING-01 to ROUTING-07(ITS-ROUTING-08)
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Edit OrgProfile
    And Navigate to Transportation Zone
    And Validate PostCode Range for country VIC and QLD
    And Navigate to Items Page
    And Search Item With "getdata(Item1)"
    And Verify Item Id exist
    And Click on ClearAll button
    And Search Item With "getdata(Item2)"
    And Verify Item Id exist
    And Click on ClearAll button
    And Search Item With "getdata(Item3)"
    And Verify Item Id exist
    And Click on ClearAll button
    And Search Item With "getdata(Item4)"
    And Verify Item Id exist
    And Click on ClearAll button
    And Search Item With "getdata(Item5)"
    And Verify Item Id exist
    And Click on ClearAll button
    And Search Item With "getdata(Item6)"
    And Verify Item Id exist
    And Navigate to LANE Page
    And Search Lane With 'getdata(LaneItem1)'
    And Click on Row At First Index
    And Click "byRelatedLinks" on "HeaderPanelPage"
    And Click on Routing Lane Option Links
    And Search Carrier With 'getdata(Carrier)'
    And Verify Carrier Id 'getdata(Carrier3)' and 'getdata(Carrier4)' exist
    And Verify Carrier Id 'getdata(Carrier3)' and 'getdata(Carrier7)' exist
    And Click on ClearAll button
    And Click Navigate Lane Link
    And Click on ClearAll button
    And Search Lane With 'getdata(LaneItem2)'
    And Click on Row At First Index
    And Click "byRelatedLinks" on "HeaderPanelPage"
    And Click on Routing Lane Option Links
    And Search Carrier With 'getdata(Carrier)'
    And Verify Carrier Id 'getdata(Carrier5)' and 'getdata(Carrier6)' exist
    And Click on ClearAll button
    And Click Navigate Lane Link
    And Click on ClearAll button
    And Search Lane With 'getdata(LaneItem3)'
    And Click on Row At First Index
    And Click "byRelatedLinks" on "HeaderPanelPage"
    And Click on Routing Lane Option Links
    And Search Carrier With 'getdata(Carrier)'
    And Verify Carrier Id 'getdata(Carrier8)' and 'getdata(Carrier9)' exist
    And Click on ClearAll button
    And Click Navigate Lane Link
    And Click on ClearAll button
    And Search Lane With 'getdata(LaneItem4)'
    And Click on Row At First Index
    And Click "byRelatedLinks" on "HeaderPanelPage"
    And Click on Routing Lane Option Links
    And Search Carrier With 'getdata(Carrier)'
    And Verify Carrier Id 'getdata(Carrier10)' and 'getdata(Carrier11)' exist
          ##Import ASN
    And Navigate to ASNs
    And Update Mutiple ASN with Multiple Lpn "FN-ASNROUTING-08-TestScenarioDefinition.xlsx"
    And Clear Notifications
    And Click "byImportDataLoaderButton" on "HeaderPanelPage"
    And Import Data Loader "FN-ASNROUTING-08-TestScenarioDefinition.xlsx"
    And Verify notification message 'File FN-ASNROUTING-08-TestScenarioDefinition.xlsx from Asn is imported successfully.'
    And Search Multiple ASN at ASNs
    Then Verify Multiple ASN details are displayed with variable "ListOfASNsValues"
    And Verify ILPNs linked to ASN with variable  "ListOfLPNValues"
          ##Receive ASN
    And Navigate to WM Mobile
    And Wait for page loading
    And Update ORG Profile in WM Mobile
    And Search menu 'AT Standard Receiving' at WM Mobile
    And Complete ATStandardReceiving with Multiple ASN and Multiple LPN
    And Click on Action Menu Icon in WM Mobile Page
    And Search menu 'AT System Directed Putaway' at WM Mobile
    And Enter Multiple ILPNs and Location in AT System Directed Putaway Page with "ListOfLPNValues"
    And Close browser window And Switch to Last Window
          ##Import order
    And Navigate to Original Orders2
    And Update Multiple OriginalOrder with Multiple Orderline in "FN-ORDERROUTING-08-TestScenarioDefinition.xlsx"
    And Clear Notifications
    And Click "byImportDataLoaderBtn" on "OriginalOrdersPage"
    And Import Data Loader "FN-ORDERROUTING-08-TestScenarioDefinition.xlsx"
    And Wait for page loading
    And Verify notification message 'File FN-ORDERROUTING-08-TestScenarioDefinition.xlsx from OriginalOrder is imported successfully.'
    And Click "byRefreshBtn" on "OriginalOrdersPage"
    And Search Original Order with variable name "OriginalOrder"
    Then Verify Multiple OriginalOrders details are displayed with variable "ListOrderValues"
          ##Run WAVE
    And Execute RunWave 'getdata(Strategy)' by Selecting Multiple orders "OriginalOrder"
    And Navigate to Wave Runs
    And Search Wave run at Wave Runs
    And Validate Wave run status till "Completed"
    And Click on Row At First Index
    And Click "byRelatedLinks" on "WaveRunsPage"
    And Wait for page loading
    And Click on oLPNs Links
    And Validate Carrier Shipment Details in Carton Attributes
    And Validate Country and Postcode for Shipvis ATL7E and ATDHLENZ


  Scenario: FN-ROUTING-05 : Test route per volume of the order (ITS-ROUTING-05)
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Edit OrgProfile
    And Navigate to Items Page
    And Search Item With "getdata(Item)"
    And Verify Item Id exist
    And Verify Multiple Items with "getdata(Items)"
    And Update ASN file with LPN "FN-ROUTING-05-ASN.xlsx"
    And Navigate to ASNs
    And Clear Notifications
    And Click "byImportDataLoaderBtn" on "ASNs"
    And Import Data Loader "FN-ROUTING-05-ASN.xlsx"
    And Wait for page loading
    And Verify notification message 'File FN-ROUTING-05-ASN.xlsx from Asn is imported successfully.'
    And Search ASN at ASNs
    And Verify ASN details are displayed
    And Validate ASN status "In Transit"
    And Verify Inventory Details for multiple ilpns
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
    And Expand Filter
    And Search with Item Filter "getdata(Item)"
    And Search with Location Filter "getdata(Location)"
    And Filter by Inventory Details with InventoryReservation and Location Type
    And Verify multiple Ilpns Data In Inventory
    And Navigate to Original Orders2
    And Update Two Original Order with Two Lines 'ROUTING05Orders.xlsx'
    And Clear Notifications
    And Click "byImportDataLoaderBtn" on "OriginalOrdersPage"
    And Import Data Loader "ROUTING05Orders.xlsx"
    And Wait for page loading
    And Verify notification message 'File ROUTING05Orders.xlsx from OriginalOrder is imported successfully.'
    And Click "byRefreshBtn" on "OriginalOrdersPage"
    And Verify Imported Orders with variable name "OriginalOrder1"
    And Validate Orders status "Released"
    And Verify Imported Orders with variable name "OriginalOrder2"
    And Validate Orders status "Released"
    And Navigate to OrderLines Page
    And Search Order with variable "OriginalOrder1"
    And Verify OrderLineNeed and OrderLineAttributes for multiple orders with variable "listOfOrders"
    And Search Order with variable "OriginalOrder2"
    And Verify OrderLineNeed and OrderLineAttributes for multiple orders with variable "listOfOrders"
    And Navigate to Order Planning Strategy
    And View FNROUTING wave Strategy "getdata(Strategy)"
    And Select Order Selection Criteria For Routing
    And Wait for page loading
    And Navigate to Routing Strategy
    And View ATROUTING Strategy "getdata(ATRoutingStrategy)"
    Then Set Routing Criteria For Routing And Verify Destination Country Rule
    And Navigate to Ship Via
    And Wait for page loading
    Then Check Ship Vias And Verify the ShipViaID "getdata(CarrierID1)"
    Then Check Ship Vias And Verify the ShipViaID "getdata(CarrierID2)"
    And Navigate to Original Orders2
    And Run FNROUTING Wave for two Orders
    And Navigate to Wave Runs
    And Search Wave run at Wave Runs
    And Wait for wave to load
    And Validate Wave run status till "Completed"
    And Click on Row At First Index
    And Click "byRelatedLinks" on "WaveRunsPage"
    And Wait for page loading
    And Click on oLPNs Links
    And Verify Multiple oLPNs Statuses with variable "getdata(OLPNStatuses)"
    And Validate OrderID And ShipVia Details Of OLPN In RoutingLaneOption "getdata(CarrierID1)" "OriginalOrder1"
    And Validate OrderID And ShipVia Details Of OLPN In RoutingLaneOption "getdata(CarrierID2)" "OriginalOrder2"
    And Navigate to Container Type Page
    And View Container Size Definition "getdata(ContainerTypeId)"
    And Verify Exterior volume of the Container

  @Routing
  Scenario: FN-ROUTING-02 : Routing runs per country (ITS-ROUTING-02)
    Given Open the browser and launch the application
#    And Login to WMS Manhattan
    And Login to WMS Manhattan via SSO Login
    And Edit OrgProfile
    And Navigate to Items Page
    And Search Item With 'getdata(Item)'
    And Verify Item Id exist
    And Navigate to ASNs
    And Update ASN file with LPN 'ROUTING02ASN.xlsx'
    And Clear Notifications
    And Click "byImportDataLoaderBtn" on "ASNs"
    And Import Data Loader "ROUTING02ASN.xlsx"
    And Wait for page loading
    And Verify notification message 'File ROUTING02ASN.xlsx from Asn is imported successfully.'
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
    And Search menu 'AT User Directed Putaway' at WM Mobile
    And Complete ATUserDirectedPutAway with single LPN
    And Close browser window And Switch to Last Window
    And Navigate to Inventory Details
    And Expand Filter
    And Search with Item Filter "getdata(Item)"
    And Filter by Inventory Details with InventoryReservation and Location Type
    And Verify LPN details in Inventory Details page with location
    And Verify OnHandQuantity in Inventory details page
    And Navigate to Original Orders2
    And Clear Notifications
    And Update Order for three orders single piece for the same client in "ROUTING02Order.xlsx"
    And Click "byImportDataLoaderButton" on "HeaderPanelPage" WaitForPageLoading
    And Import Data Loader "ROUTING02Order.xlsx"
    And Verify notification message 'File ROUTING02Order.xlsx from OriginalOrder is imported successfully.'
    And Select checkbox "byMaximumStatusReleasedCheckbox" on "LeftPanelPage"
    And Search Order with variable "OriginalOrder1"
    And Verify Order with variable "OriginalOrder1"
    And Search Order with variable "OriginalOrder2"
    And Verify Order with variable "OriginalOrder2"
    And Search Order with variable "OriginalOrder3"
    And Verify Order with variable "OriginalOrder3"
    And Search Order with variable "Orders"
    And Verify Multiple Order Statuses with variable "getdata(BeforeOrderStatuses)"
    And Navigate to OrderLines Page
    And Search Order with variable "Orders"
    And Verify OrderLineNeed and OrderLineAttributes for multiple orders with variable "Orders"
    And Navigate to Order Planning Strategy
    And View FNROUTING wave Strategy "getdata(WaveStrategy)"
    And Select Order Selection Criteria For Routing
    And Wait for page loading
    And Navigate to Routing Strategy
    And View ATROUTING Strategy "getdata(ATRoutingStrategy)"
    And Set routing criteria for ATrouting and verify display of criterias
    And Navigate to Ship Via from routing
    And Search ship via ID "getdata(ShipViaID1)"
    And Verify display of shipvia ID "ShipViaID1"
    And Search ship via ID "getdata(ShipViaID2)"
    And Verify display of shipvia ID "ShipViaID2"
    And Navigate to Original Orders2
    And Search Order with variable "Orders"
    And Complete "FNROUTINGOrderStrategy" Order strategy
    And Navigate to Wave Runs
    And Search Wave run at Wave Runs
    And Click "byRefreshButton" on "RightNavigationBar" WaitForPageLoading
    And Search Wave run at Wave Runs
    And Validate Wave run status till "Completed"
    And Click on Row At First Index
    And Click on Related Links
    And Click on oLPNs Links
    Then Verify Row count as 3
    And Wait for page loading
    And Store Multiple OLPNs to variable
    And Verify Multiple oLPNs Statuses with variable "getdata(OLPNStatuses)"
    And Verify shipVia ID of OLPNs