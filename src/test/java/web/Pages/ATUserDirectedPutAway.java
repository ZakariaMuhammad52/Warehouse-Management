package web.Pages;

import java.util.List;

import com.dhl.testdata.TestData_Json;

@SuppressWarnings("unused")
public class ATUserDirectedPutAway extends TestData_Json {

	/**
	 * Function to complete ATUserDirectedPutAway with multiple lpns
	 * @param lpns- Give generated list of lpns
	 */
	public static void completeATUserDirectedPutAwayWithMultipleLPNs(List<String> lpns) {
		String quantity = null;
		String location = null;
		for (int i = 0; i < lpns.size(); i++) {
			CommonWMMobilePage.enterScanContainer(lpns.get(i));
			CommonWMMobilePage.clickGoButton();
			quantity = getDataFromFeature("getdata(Quantity" + (i + 1) + ")");
			location = getDataFromFeature("getdata(LocationBarCode" + (i + 1) + ")");
			CommonWMMobilePage.enterQuantity(quantity);
			CommonWMMobilePage.clickGoButton();
			CommonWMMobilePage.enterScanLocation(location);
			CommonWMMobilePage.clickGoButton();
			 CommonPopupPage.clickConfirmButton();
		}
	}

	/**
	 * Function to complete ATUserDirectedPutAway with single lpn
	 * @param lpn- Give generated lpn
	 */
	public static void completeATUserDirectedPutAway(String lpn) {
		CommonWMMobilePage.enterScanContainer(lpn);
		CommonWMMobilePage.clickGoButton();
		String quantity = getDataFromFeature("getdata(Quantity)");
		String location = getDataFromFeature("getdata(LocationBarCode)");
		CommonWMMobilePage.enterQuantity(quantity);
		CommonWMMobilePage.clickGoButton();
		CommonWMMobilePage.enterScanLocation(location);
		CommonWMMobilePage.clickGoButton();
		CommonPopupPage.clickConfirmButton();
	}
}