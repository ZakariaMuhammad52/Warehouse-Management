package web.Pages;

import java.util.ArrayList;
import java.util.List;

import com.dhl.reports.FrameworkLogger;
import com.dhl.reports.LogType;
import com.dhl.testdata.TestData_Json;
import com.dhl.utils.CurrentThreadInstance;
import com.dhl.utils.Variables;

import stepdefinitions.CommonMethods;
import stepdefinitions.ExcelUtil1;

@SuppressWarnings("unused")
public class ATStandardReceiving extends TestData_Json {

	/**
	 * Function to complete ATStandardReceiving with asn and lpn
	 * @param asn- Give generated asn id
	 * @param lpn- Give generated lpn id
	 */
	public static void completeATStandardReceiving(String asn, String lpn) {
		CommonWMMobilePage.enterASN(asn);
		CommonWMMobilePage.clickGoButton();
		CommonWMMobilePage.enterScanILPN(lpn);
		CommonWMMobilePage.clickGoButton();
		CommonWMMobilePage.clickVerifyASNButton();
		CommonPopupPage.verifyPopupMessageContains(asn);
	}

	/**
	 * Function to complete ATStandardReceiving with single asn and double lpn
	 * @param asn- Give generated asn id
	 * @param lpn1- Give generated lpn id1
	 * @param lpn2- Give generated lpn id2
	 */
	public static void completeATStandardReceivingWithTwoLpn(String asn, String lpn1, String lpn2) {
		CommonWMMobilePage.enterASN(asn);
		CommonWMMobilePage.clickGoButton();
		CommonWMMobilePage.enterScanILPN(lpn1);
		CommonWMMobilePage.clickGoButton();
		CommonWMMobilePage.enterScanILPN(lpn2);
		CommonWMMobilePage.clickGoButton();
		CommonWMMobilePage.clickVerifyASNButton();
		CommonPopupPage.verifyPopupMessageContains(asn);
	}

	/**
	 * Function to process ATStandardReceiving with single asn and double lpn
	 * @param asn- Give generated asn id
	 *  @param lpn1- Give generated lpn id1
	 *  @param lpn2- Give generated lpn id2
	 */
	public static void processATStandardReceivingWithTwoLpnHalfway(String asn, String lpn1, String lpn2) {
		CommonWMMobilePage.enterASN(asn);
		CommonWMMobilePage.clickGoButton();
		CommonWMMobilePage.enterScanILPN(lpn1);
		CommonWMMobilePage.clickGoButton();
		CommonWMMobilePage.enterScanILPN(lpn2);
		CommonWMMobilePage.clickGoButton();
		CommonWMMobilePage.clickExit();
		CommonPopupPage.clickConfirmButton();
	}

	/**
	 * Function to complete ATStandardReceiving with WithMultipleLPNs
	 * @param asn- Give generated asn id
	 * @param lpns- Give generated list of lpn ids
	 */
	public static void completeATStandardReceivingWithMultipleLPNs(String asn, List<String> lpns) {
		CommonWMMobilePage.enterASN(asn);
		CommonWMMobilePage.clickGoButton();
		CommonMethods.waitForPageLoading();
		for (String lpn : lpns) {
			CommonWMMobilePage.enterScanILPN(lpn);
			CommonWMMobilePage.clickGoButton();
			CommonMethods.waitForPageLoading();
		}
		CommonMethods.waitForPageLoading();
		CommonWMMobilePage.clickVerifyASNButton();
		CommonPopupPage.verifyPopupMessageContains(asn);
	}

	/**
	 * Function to complete ATStandardReceiving with WithMultipleLPNs
	 * WithSerialNumbers
	 */
	public static void completeATStandardReceivingWithMultipleLPNsWithSerialNumbers() {
		int lpnCount = Integer.parseInt(getDataFromFeature("getdata(LPNCount)"));
		String asn = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN");
		String lpn = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(LPN)"));
		List<String> listOfILPNs = new ArrayList<>();
		List<String> listOfSerialNumbers = new ArrayList<>();
		CommonWMMobilePage.enterASN(asn);
		CommonWMMobilePage.clickGoButton();
		for (int i = 1; i <= lpnCount; i++) {
			Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN" + i, (lpn + i));
			FrameworkLogger.log(LogType.INFO, "Set value for LPN" + i + ": " + (lpn + i));
			listOfILPNs.add(lpn + i);
			String item = getDataFromFeature("getdata(Item" + i + ")").replaceAll("-", "");
			String quantity = getDataFromFeature("getdata(Quantity" + i + ")");
			String serialNumberRequired = getDataFromFeature("getdata(SerialNumberRequiredForItem" + i + ")");
			CommonWMMobilePage.enterScanILPN(lpn + i);
			CommonWMMobilePage.clickGoButton();
			CommonWMMobilePage.enterScanItem(item);
			CommonWMMobilePage.clickGoButton();
			CommonWMMobilePage.clickGoButton();
			CommonWMMobilePage.clickGoButton();
			CommonWMMobilePage.enterQuantity(quantity);
			CommonWMMobilePage.clickGoButton();
			if (serialNumberRequired.equalsIgnoreCase("Yes")) {
				String serialNumber = "SN" + ExcelUtil1.convert_variable_to_timestamp("<ddmmhhss>");
				for (int j = 1; j <= Integer.parseInt(quantity); j++) {
					listOfSerialNumbers.add(serialNumber + j);
					CommonWMMobilePage.enterSerialNumber(serialNumber + j);
					CommonWMMobilePage.clickGoButton();
				}
			}
		}
		CommonWMMobilePage.clickVerifyASNButton();
		CommonPopupPage.verifyPopupMessageContains(asn);
		CommonPopupPage.clickOkButton();
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "listOfILPNs", listOfILPNs);
		FrameworkLogger.log(LogType.INFO, "Set value for listOfILPNs : " + listOfILPNs);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "listOfSerialNumbers", listOfSerialNumbers);
		FrameworkLogger.log(LogType.INFO, "Set value for listOfSerialNumbers : " + listOfSerialNumbers);
	}



	/**
	 * Function to complete ATStandardReceiving with WithMultipleLPNs WithSerialNumbers WithBatchNumbers
	 */
	public static void completeATStandardReceivingWithMultipleLPNsWithBatchAndSerialNumbers() {
		int lpnCount = Integer.parseInt(getDataFromFeature("getdata(LPNCount)"));
		String asn = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN");
		String lpn = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(LPN)"));
		String serialNumberRequired = getDataFromFeature("getdata(SerialNumberRequiredForItem)");
		List<String> listOfILPNs = new ArrayList<>();
		List<String> listOfSerialNumbers = new ArrayList<>();
		CommonWMMobilePage.enterASN(asn);
		CommonWMMobilePage.clickGoButton();
		CommonWMMobilePage.enterScanILPN(lpn);
		CommonWMMobilePage.clickGoButton();
		CommonWMMobilePage.enterScanItem(getDataFromFeature("getdata(Item)").replaceAll("-", ""));
		CommonWMMobilePage.clickGoButton();
		CommonWMMobilePage.clickGoButton();
		CommonWMMobilePage.clickGoButton();
		CommonWMMobilePage.clickGoButton();
		CommonWMMobilePage.enterQuantity(getDataFromFeature("getdata(Quantity)"));
		CommonWMMobilePage.clickGoButton();
			if(serialNumberRequired.equalsIgnoreCase("Yes")){
				String serialNumber = "SN"+ExcelUtil1.convert_variable_to_timestamp("<ddmmhhss>");
				for (int j = 1; j <= Integer.parseInt(getDataFromFeature("getdata(Quantity)")); j++) {
					listOfSerialNumbers.add(serialNumber + j);
					CommonWMMobilePage.enterSerialNumber(serialNumber + j);
					Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "serialNumber" + j, (serialNumber + j));
					FrameworkLogger.log(LogType.INFO, "Set value for Serial Number : " + (serialNumber + j));
					CommonWMMobilePage.clickGoButton();
				}
			}
		CommonWMMobilePage.clickVerifyASNButton();
		CommonPopupPage.verifyPopupMessageContains(asn);
		CommonPopupPage.clickOkButton();
//		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "listOfILPNs", listOfILPNs);
//		FrameworkLogger.log(LogType.INFO, "Set value for listOfILPNs : " + listOfILPNs);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "listOfSerialNumbers", listOfSerialNumbers);
		FrameworkLogger.log(LogType.INFO, "Set value for listOfSerialNumbers : " + listOfSerialNumbers);
	}

	/**
	 * Function to complete ATStandardReceiving with single LPNs and multiple SerialNumbers
	 */
	public static void completeATStandardReceivingWithSingleLPNsWithMultipleSerialNumbers() {
		//int lpnCount = Integer.parseInt(getDataFromFeature("getdata(LPNCount)"));
		String asn = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN");
		String lpn = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature("getdata(LPN)"));
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN", lpn);
		String serialNumberRequired = getDataFromFeature("getdata(SerialNumberRequiredForItem)");
		List<String> listOfCountSerialNumbers = new ArrayList<>();
		CommonWMMobilePage.enterASN(asn);
		CommonWMMobilePage.clickGoButton();
		CommonWMMobilePage.enterScanILPN(lpn);
		CommonWMMobilePage.clickGoButton();
		CommonWMMobilePage.enterScanItem(getDataFromFeature("getdata(Item)").replaceAll("-", ""));
		CommonWMMobilePage.clickGoButton();
		CommonWMMobilePage.clickGoButton();
		CommonWMMobilePage.clickGoButton();
		CommonWMMobilePage.enterQuantity(getDataFromFeature("getdata(Quantity)"));
		CommonWMMobilePage.clickGoButton();
		if(serialNumberRequired.equalsIgnoreCase("Yes")){
			String serialNumber = "SN"+ExcelUtil1.convert_variable_to_timestamp("<ddmmhhss>");
			for (int j = 1; j <= Integer.parseInt(getDataFromFeature("getdata(Quantity)")); j++) {
				listOfCountSerialNumbers.add(serialNumber + j);
				CommonWMMobilePage.enterSerialNumber(serialNumber + j);
				Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "serialNumber" + j, (serialNumber + j));
				FrameworkLogger.log(LogType.INFO, "Set value for Serial Number : " + (serialNumber + j));
				CommonWMMobilePage.clickGoButton();
			}
		}
		CommonWMMobilePage.clickVerifyASNButton();
		CommonPopupPage.verifyPopupMessageContains(asn);
		CommonPopupPage.clickOkButton();
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "listOfCountSerialNumbers", listOfCountSerialNumbers);
		FrameworkLogger.log(LogType.INFO, "Set value for listOfCountSerialNumbers : " + listOfCountSerialNumbers);
		CommonWMMobilePage.clickExit();
		CommonPopupPage.clickConfirmButton();
	}

}