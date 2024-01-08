@WMS
Feature: DFN_Order_Test_Cases

##List of Test Cases covered
## TC    TS No.	Test Case Name
## 001.  1 	 		DFN-ORDERSTATUS-01-Run a normal order via standard process with no special peculiarities. Cancel the order. Ensure that all fields in PIX620 are generated correctly.

# Pre-requiste Steps :
# 1  One Item is predefined for use with the scenario. Item D01-ORDCONF-0100 is set up to track Inventory Type and Product Status
# 2  iLPN level ASN Loaded to Receive Stock for test containing item D01-ORDCONF-0100 to meet the demand
# 3  ASN has been received and verified.
# 4  One order is loaded into MAWM containing demand for the SKU
# 5  The AT Standard Order Planning Strategy is used for this test
# 6  Task creation rules have been configured to support the Pick to oLPN process.

   @ORDER
   Scenario: DFN-ORDERSTATUS-01-Run a normal order via standard process with no special peculiarities. Cancel the order. Ensure that all fields in PIX620 are generated correctly.
      Given Open the browser and launch the application
      And Login to WMS Manhattan
      And Edit OrgProfile
      And Navigate to Items Page
      And Search Item With "getdata(Item)"
      And Verify Item with 'getdata(Item)'
      And Update ASN for normal order via standard process with no special peculiarities in "ORDERSTATUS-01ASN.xlsx"
      And Navigate to ASNs
      And Clear Notifications
      And Click "byImportDataLoaderButton" on "HeaderPanelPage" WaitForPageLoading
      And Import Data Loader "ORDERSTATUS-01ASN.xlsx"
      And Verify notification message 'File ORDERSTATUS-01ASN.xlsx from Asn is imported successfully.'
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
      And Navigate to Original Orders2
      And Clear Notifications
      And Update Original Orders in "ORDERSTATUS-01-originalorder.xlsx"
      And Click "byImportDataLoaderButton" on "HeaderPanelPage" WaitForPageLoading
      And Import Data Loader "ORDERSTATUS-01-originalorder.xlsx"
      And Verify notification message 'File ORDERSTATUS-01-originalorder.xlsx from OriginalOrder is imported successfully.'
      And Navigate to OrderLines Page
      And Search Order with variable "Orders"
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
      And Navigate to Wave Runs Homepage
      And Click on Row At First Index
      And Click on Related Links
      And Click on oLPNs Links
      And Click on Row At First Index
      And Click on cancel OLPN button
      And Navigate to Orders
      And Click on Row At First Index
      Then Validate Orders status "Cancelled"
      And Navigate to PIX Visibility
      And Select checkbox "byInvDeAllocAvailableSpecificationCheckbox" on "LeftPanelPage"
      And Wait for page loading
      And Click on Row At First Index
      And Click On Pix Data Button
      Then Verify Pix Visibility Data
