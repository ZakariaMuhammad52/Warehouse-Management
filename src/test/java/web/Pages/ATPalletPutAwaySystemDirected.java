package web.Pages;

import com.dhl.testdata.TestData_Json;
import com.dhl.utils.CurrentThreadInstance;
import com.dhl.utils.Variables;

@SuppressWarnings("unused")
public class ATPalletPutAwaySystemDirected extends TestData_Json {

	/**
	 * Function to complete ATPallet PutAway SystemDirected
	 * @param lpn- Give lpn for scan
	 */
	public static void completeATPalletPutAwaySystemDirected(String lpn) {
		CommonWMMobilePage.enterScanContainer(lpn);
		CommonWMMobilePage.clickGoButton();
		String location = CommonWMMobilePage.getLocationText();
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "DisplayLocation", location);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "CurrentLocation", location);
		location = location.replaceAll("-", "");
		CommonWMMobilePage.enterScanLocation(location);
		CommonWMMobilePage.clickGoButton();
	}
}