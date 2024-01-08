package web.Pages;

import com.dhl.reports.FrameworkLogger;
import com.dhl.reports.LogType;
import com.dhl.testdata.TestData_Json;
import com.dhl.utils.CurrentThreadInstance;
import com.dhl.utils.Variables;
import stepdefinitions.ExcelUtil1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("unused")
public class PickToTotePage extends TestData_Json {

	/**
	 * Function to complete PickToTotePage
	 */
	public static void completePickToTote() {
		String taskId = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "TaskIdAtFirstIndex");
		String toteId = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(ToteId)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ToteId", toteId);
		FrameworkLogger.log(LogType.INFO, "Set value for ToteId : " + toteId);
		String location = getDataFromFeature("getdata(LocationBarCode)");
		String item = getDataFromFeature("getdata(Item)");
		String quantity = getDataFromFeature("getdata(ToteQuantity)");
		String message = getDataFromFeature("getdata(Message)");
		String destinationLocation = getDataFromFeature("getdata(DestinationLocation)");

		CommonWMMobilePage.enterTask(taskId);
		CommonWMMobilePage.clickGoButton();
		CommonWMMobilePage.enterScanTote(toteId);
		CommonWMMobilePage.clickGoButton();
		CommonWMMobilePage.enterScanLocation(location);
		CommonWMMobilePage.clickGoButton();
		item = item.replaceAll("-", "");
		CommonWMMobilePage.enterScanItem(item);
		CommonWMMobilePage.clickGoButton();
		CommonWMMobilePage.enterQuantity(quantity);
		CommonWMMobilePage.clickGoButton();
		CommonPopupPage.verifyPopupMessageContains(message);
		CommonPopupPage.clickOkButton();
		CommonWMMobilePage.enterScanLocation(destinationLocation);
		CommonWMMobilePage.clickGoButton();
	}

	/**
	 * Function to complete pick to tote with scan location
	 *
	 */
	public static void completePickToTote_withScanLocation() {
		String taskId = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "TaskIdAtFirstIndex");
		String toteId = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(ToteId)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ToteId", toteId);
		FrameworkLogger.log(LogType.INFO, "Set value for ToteId : " + toteId);
		//String location = getDataFromFeature("getdata(LocationBarCode)");
		String item = getDataFromFeature("getdata(Item)");
		String quantity = getDataFromFeature("getdata(ToteQuantity)");
		String message = getDataFromFeature("getdata(Message)");
		String destinationLocation = getDataFromFeature("getdata(DestinationLocation)");

		CommonWMMobilePage.enterTask(taskId);
		CommonWMMobilePage.clickGoButton();
		CommonWMMobilePage.enterScanTote(toteId);
		CommonWMMobilePage.clickGoButton();
		SystemDirected.enterScanReserveLocation();
		item=item.replaceAll("-","");
		CommonWMMobilePage.enterScanItem(item);
		CommonWMMobilePage.clickGoButton();
		CommonWMMobilePage.enterQuantityField(quantity);
		CommonWMMobilePage.clickGoButton();
		CommonPopupPage.verifyPopupMessageContains(message);
		CommonPopupPage.clickOkButton();
		CommonWMMobilePage.enterScanLocation(destinationLocation);
		CommonWMMobilePage.clickGoButton();
	}
	/**
	 * Function to Pop-up screen confirming verification attempted for ASN is
	 * displayed. params asnId - Value to verify
	 */
	public static void verifyASNIsDisplayedInConfirmationPopup(String asnId) {
		CommonPopupPage.verifyPopupMessageContains(asnId);
	}

	/**
	 * Function to complete PickToTote WithMultipleItems WithSerialNumber
	 */
	public static void completePickToToteWithMultipleItemsWithSerialNumber() {
		String taskId = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "TaskIdAtFirstIndex");
		String toteId = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(ToteId)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ToteId", toteId);
		FrameworkLogger.log(LogType.INFO, "Set value for ToteId : " + toteId);
		List<String> listOfSerialNumbers = (List<String>) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "listOfSerialNumbers");

		int itemCount = Integer.parseInt(getDataFromFeature("getdata(ItemCount)"));
		String message = getDataFromFeature("getdata(Message)");
		String destinationLocation = getDataFromFeature("getdata(DestinationLocation)");

		CommonWMMobilePage.enterTask(taskId);
		CommonWMMobilePage.clickGoButton();
		CommonWMMobilePage.enterScanTote(toteId);
		CommonWMMobilePage.clickGoButton();
		for (int i = 1; i <= itemCount; i++) {
			String location = CommonWMMobilePage.getLocationText();
			location = location.replaceAll("-", "");
			CommonWMMobilePage.enterScanLocation(location);
			CommonWMMobilePage.clickGoButton();
			String item = CommonWMMobilePage.getItemText();
			item = item.replaceAll("-", "");
			CommonWMMobilePage.enterScanItem(item);
			CommonWMMobilePage.clickGoButton();
			String quantity = CommonWMMobilePage.getQuantityNeedText();
			quantity = (quantity.replaceAll("UNIT", "")).trim();
			CommonWMMobilePage.enterQuantity(quantity);
			CommonWMMobilePage.clickGoButton();
			String serialNumberRequired = getDataFromFeature("getdata(SerialNumberRequiredForItem" + i + ")");
			if (serialNumberRequired.equalsIgnoreCase("Yes")) {
				for (int j = 0; j < Integer.parseInt(quantity); j++) {
					CommonWMMobilePage.enterSerialNumber(listOfSerialNumbers.get(j));
					CommonWMMobilePage.clickGoButton();
				}
				CommonPopupPage.clickOkButton();
			}
		}
		CommonWMMobilePage.enterScanLocation(destinationLocation);
		CommonWMMobilePage.clickGoButton();
	}

	/**
	 * Function to complete PickToTote WithMultipleItems WithSerialNumber For Multiple Tasks
	 */
	public static void completePickToToteWithMultipleItemsWithSerialNumberForMultipleTasks() {
		List<String> listOfTasks = (List<String>) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "listOfTasks");
		Collections.reverse(listOfTasks);
		String toteId = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(ToteId)"));
		List<String> listOfTotes = new ArrayList<>();
		List<String> listOfSerialNumbers = (List<String>) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "listOfSerialNumbers");
		int taskCount = Integer.parseInt(getDataFromFeature("getdata(TaskCount)"));
		int itemCount = Integer.parseInt(getDataFromFeature("getdata(ItemCount)"));
		String message = getDataFromFeature("getdata(Message)");
		String destinationLocation = getDataFromFeature("getdata(DestinationLocation)");
		int s=0;
		for (int t = 1; t <= taskCount; t++) {
			String taskId = listOfTasks.get(t - 1);
			CommonWMMobilePage.enterTask(taskId);
			CommonWMMobilePage.clickGoButton();
			Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ToteId" + t, toteId + t);
			FrameworkLogger.log(LogType.INFO, "Set value for ToteId" + t + ": "+toteId + t);
			listOfTotes.add(toteId+t);
			CommonWMMobilePage.enterScanTote(toteId + t);
			CommonWMMobilePage.clickGoButton();
			for (int i = 1; i <= itemCount; i++) {
				String location = CommonWMMobilePage.getLocationText();
				location = location.replaceAll("-", "");
				CommonWMMobilePage.enterScanLocation(location);
				CommonWMMobilePage.clickGoButton();
				String item = CommonWMMobilePage.getItemText();
				item = item.replaceAll("-", "");
				CommonWMMobilePage.enterScanItem(item);
				CommonWMMobilePage.clickGoButton();
				String quantity = CommonWMMobilePage.getQuantityNeedText();
				quantity = (quantity.replaceAll("UNIT", "")).trim();
				CommonWMMobilePage.enterQuantity(quantity);
				CommonWMMobilePage.clickGoButton();
				String serialNumberRequired = getDataFromFeature("getdata(SerialNumberRequiredForItem" + i + ")");
				if (serialNumberRequired.equalsIgnoreCase("Yes")) {
					for (int j = 0; j < Integer.parseInt(quantity); j++) {
						CommonWMMobilePage.enterSerialNumber(listOfSerialNumbers.get(s));
						CommonWMMobilePage.clickGoButton();
						s=s+1;
					}
					CommonPopupPage.clickOkButton();
				}
			}
			CommonWMMobilePage.enterScanLocation(destinationLocation);
			CommonWMMobilePage.clickGoButton();
		}
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "listOfTotes",listOfTotes);
	}
}