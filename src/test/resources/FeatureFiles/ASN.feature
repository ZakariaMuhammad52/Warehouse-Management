@DFN
Feature: ASN_Test_Cases
##List of Test Cases covered
## TC    TS No.	Test Case Name
## 001.  1          DFN-ASN-CONFIRM-01 - Process Unexpected Return ASN and Verify It (ITS-ASN-01)

# 1. DFN-ASN-CONFIRM-01-Process Unexpected Return ASN and Verify It
# Jira Id - MAWMTF01-48
# Test cases covered : 1
  @ASN
  Scenario: DFN-ASN-CONFIRM-01-Process Unexpected Return ASN and Verify It
  Given Open the browser and launch the application
  And Login to WMS Manhattan
  And Wait for page loading
  And Edit OrgProfile
  And Navigate to WM Mobile
    And Update ORG Profile in WM Mobile
  And Search menu 'AT BlindReceiving' at WM Mobile
  And Click "byGoButton" on "TasksPage" WaitForPageLoading
  And Store generated ASN number in runtime variable
  And Enter LPN in AT Blind Receipt WM Mobile menu
  And Scan Item in Cycle count "getdata(Item)"
  And Enter Batch Number manually "getdata(BatchNumber)"
  And Enter Batch Expiration date manually "getdata(ExpirationDate)"
  And Enter Quantity manually "getdata(Quantity)"
  And Verify ASN in WM Mobile
  And Click on Yes button in Proceed for ASN Verification
  And Click on OK button
  And Close browser window And Switch to Last Window
  And Navigate to ASNs
  And Filter by stored ASN number
  And Select  LPN (Inventory) link
  And Check Inventory details heading
  Then Verify Inventory details
  