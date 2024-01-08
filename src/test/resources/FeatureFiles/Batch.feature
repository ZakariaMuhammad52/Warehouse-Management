@DFNBatch
Feature: Batch_Test_Cases

##List of Test Cases covered
## TC    TS No.	Test Case Name
## 001.  1          FN-BATCH-01 -Batch master status changes from Release to Held ( ITS-INV-12 )
## 002.  1          FN-BATCH-02 -Batch master changes from Release to Recalled ( ITS-INV-13 )
## 003.  1          FN-BATCH-03 -Batch master status changes from Held to Release ( ITS-INV-14 )
## 004.  1          FN-BATCH-04 -Batch master changes from Recalled to Released ( ITS-INV-15 )

# 1. FN-BATCH-Scenarios Release-Held, Held-Release, Release-Recall, Recall-Release
# Jira Id - MAWMTF01-41 :Sub Tasks- MAWMTF01-37	,MAWMTF01-38, MAWMTF01-39, MAWMTF01-40
# Test cases covered : 4
  @Batch
  Scenario: FN-BATCH-Scenarios Release-Held, Held-Release, Release-Recall, Recall-Release
    Given Open the browser and launch the application
    And Login to WMS Manhattan
    And Edit OrgProfile
    And Navigate to Batch Master
    And Select checkbox "byStatusReleasedCheckbox" on "BatchMasterPage"
    Then Verify Batch number status as "Released"
    And Store Batch Details to run time Variables
    And Navigate to Batch Master
    And Verify Held condition code has a value for the selected Batch Number
    And Click on Hold for the selected Batch Number
    Then Verify that selected Batch Number is removed from the "Released" status list
    And Deselect byStatusReleasedCheckbox on BatchMasterPage
    Then Verify Batch numbers with all status
    And Select checkbox "byStatusHeldCheckbox" on "BatchMasterPage"
    Then Verify Batch number status as "Held"
    And Navigate to Inventory Details
    And Filter by Batch Number details
    Then Verify that all the entries in inventory is locked with the correct Held condition code
    And Navigate to Batch Master
    And Select checkbox "byStatusHeldCheckbox" on "BatchMasterPage"
    Then Verify Batch number status as "Held"
    And Click on Release for the selected Batch Number
    Then Verify that selected Batch Number is removed from the "Held" status list
    And Deselect byStatusHeldCheckbox on BatchMasterPage
    Then Verify Batch numbers with all status
    And Select checkbox "byStatusReleasedCheckbox" on "BatchMasterPage"
    Then Verify Batch number status as "Released"
    And Navigate to Inventory Details
    And Filter by Batch Number details
    Then Verify that all the entries in inventory has no condition code
    And Navigate to Batch Master
    And Verify Held condition code has a value for the selected Batch Number
    And Click on Recall for the selected Batch Number
    Then Verify that selected Batch Number is removed from the "Released" status list
    And Deselect byStatusReleasedCheckbox on BatchMasterPage
    Then Verify that filtered results displayed with Held status also
    And Select checkbox "byStatusHeldCheckbox" on "BatchMasterPage"
    Then Verify Batch number status as "Held"
    And Navigate to Inventory Details
    And Filter by Batch Number details
    Then Verify that all the entries in inventory is locked with the correct condition codes
    And Navigate to Batch Master
    And Select checkbox "byStatusHeldCheckbox" on "BatchMasterPage"
    Then Verify Batch number status as "Held"
    And Click on Release for the selected Batch Number
    Then Verify that selected Batch Number is removed from the "Held" status list
    And Deselect byStatusHeldCheckbox on BatchMasterPage
    Then Verify Batch numbers with all status
    And Select checkbox "byStatusReleasedCheckbox" on "BatchMasterPage"
    Then Verify Batch number status as "Released"
    And Navigate to Inventory Details
    And Filter by Batch Number details
    Then Verify that all the entries in inventory has no condition code