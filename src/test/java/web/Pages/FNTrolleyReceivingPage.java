package web.Pages;

import com.dhl.reports.FrameworkLogger;
import com.dhl.reports.LogType;
import com.dhl.testdata.TestData_Json;
import com.dhl.utils.CurrentThreadInstance;
import com.dhl.utils.Variables;

@SuppressWarnings("unused")
public class FNTrolleyReceivingPage extends TestData_Json {

	/**
	 * Function to complete FN Trolley Receiving
	 */
	public static void completeFNTrolleyReceiving() {
		String asnId = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ASN");
		String inventoryType = getDataFromFeature("getdata(InventoryType)");
		String productStatus = getDataFromFeature("getdata(ProductStatus)");
		String countryOfOrigin = getDataFromFeature("getdata(CountryOfOrigin)");
		String quantity = getDataFromFeature("getdata(Quantity)");
		String pallet = asnId.replaceAll("AS", "PL");
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "PALLET", pallet);
		String batchNumber = asnId.replaceAll("AS", "BN");
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "BatchNumber", batchNumber);
		String date = getDataFromFeature("getdata(ExpiryDate)");
		CommonWMMobilePage.enterASN(asnId);
		CommonWMMobilePage.clickGoButton();
		String lpn = null;
		String item = null;
		for (int i = 1; i <= 3; i++) {
			lpn = asnId.replaceAll("AS", "LP") + i;
			FrameworkLogger.log(LogType.INFO, i + " = LPN Id stored in variable:- " + lpn);
			Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN" + i, lpn);
			CommonWMMobilePage.enterScanILPN(lpn);
			CommonWMMobilePage.clickGoButton();
			item = getDataFromFeature("getdata(Item" + i + ")");
			CommonWMMobilePage.enterScanItem(item);
			CommonWMMobilePage.clickGoButton();
			if (item.equalsIgnoreCase("R01-ITM03")) {
				CommonWMMobilePage.clickGoButton();
				CommonWMMobilePage.clickGoButton();
			} else if (item.equalsIgnoreCase("R01ITM04")) {
				CommonWMMobilePage.enterBatchNumber(batchNumber);
				CommonWMMobilePage.clickGoButton();
				CommonWMMobilePage.enterExpiryDate(date);
				CommonWMMobilePage.clickGoButton();
			} else if (item.equalsIgnoreCase("FN02BOOK1")) {
				CommonWMMobilePage.clickGoButton();
				CommonWMMobilePage.clickGoButton();
				CommonWMMobilePage.clickGoButton();
			}
			CommonWMMobilePage.enterQuantity(quantity);
			CommonWMMobilePage.clickGoButton();
			CommonPopupPage.verifyPopupMessageContains(lpn);
			CommonPopupPage.clickOkButton();
			CommonWMMobilePage.enterScanPallet(pallet);
			CommonWMMobilePage.clickGoButton();
		}
		CommonWMMobilePage.clickVerifyASNButton();

	}

	/**
	 * Function to Pop-up screen confirming verification attempted for ASN is
	 * displayed.
	 * @params asnId - Value to verify
	 */
	public static void verifyASNIsDisplayedInConfirmationPopup(String asnId) {
		CommonPopupPage.verifyPopupMessageContains(asnId);
	}
}
