package web.Pages;

import com.dhl.testdata.TestData_Json;
import com.dhl.utils.CurrentThreadInstance;
import com.dhl.utils.Variables;

@SuppressWarnings("unused")
public class FNTrolleyPutAwayPage extends TestData_Json {

	/**
	 * Function to complete FN Trolley PutAway
	 */
	public static void completeFNTrolleyPutAway() {
		String pallet = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "PALLET");
		CommonWMMobilePage.enterScanContainer(pallet);
		CommonWMMobilePage.clickGoButton();
		String lpn = null;
		String location = null;
		for (int i = 1; i <= 3; i++) {
			location = CommonWMMobilePage.getLocationText().replaceAll("-", "");
			Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "CurrentLocation" + i, location);
			CommonWMMobilePage.enterScanLocation(location);
			CommonWMMobilePage.clickGoButton();
			lpn = CommonWMMobilePage.getExpectedContainerText().trim();
			CommonWMMobilePage.enterScanContainer(lpn);
			CommonWMMobilePage.clickGoButton();
		}
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
