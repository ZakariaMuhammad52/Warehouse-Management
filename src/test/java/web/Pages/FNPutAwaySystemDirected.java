package web.Pages;

import com.dhl.testdata.TestData_Json;
import com.dhl.utils.CurrentThreadInstance;
import com.dhl.utils.Variables;
import stepdefinitions.CommonMethods;
import java.util.List;

@SuppressWarnings("unused")
public class FNPutAwaySystemDirected extends TestData_Json {

	/**
	 * Function to enter ILPN and Location in FN PutAway System Directed Page
	 */
	public static void enterILPNAndLocationInFNPutAwaySystemDirectedPage() {
		String ilpn = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "LPN1");
		CommonWMMobilePage.enterScanContainer(ilpn);
		CommonWMMobilePage.enterScanContainer(ilpn);
		CommonWMMobilePage.clickGoButton();
		String location = CommonWMMobilePage.getLocationText();
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "DisplayLocation", location);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "CurrentLocation", location);
		location = location.replaceAll("-", "");
		CommonWMMobilePage.enterScanLocation(location);
		CommonWMMobilePage.clickGoButton();
		CommonMethods.waitForPageLoading();
		//SeleniumActions.closeBrowser();

	}
	public static void enterILPNAndLocationForTwoLPNInFNPutAwaySystemDirectedPage() {
		String ilpn = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "LPN1");
		CommonWMMobilePage.enterScanContainer(ilpn);
		CommonWMMobilePage.clickGoButton();
		String location = CommonWMMobilePage.getLocationText();
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "DisplayLocation", location);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "CurrentLocation", location);
		location = location.replaceAll("-", "");
		CommonWMMobilePage.enterScanLocation(location);
		CommonWMMobilePage.clickGoButton();
		CommonMethods.waitForPageLoading();
		//SeleniumActions.closeBrowser();
		String ilpn2 = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "LPN2");
		CommonWMMobilePage.enterScanContainer(ilpn2);
		CommonWMMobilePage.clickGoButton();
		String location1 = CommonWMMobilePage.getLocationText();
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "DisplayLocation", location1);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "CurrentLocation", location1);
		location1 = location1.replaceAll("-", "");
		CommonWMMobilePage.enterScanLocation(location1);
		CommonWMMobilePage.clickGoButton();
		CommonMethods.waitForPageLoading();

	}
	public static void enterMultipleILPNAndLocationForATSystemDirected(List<String> lpns)  {
		CommonMethods.waitForPageLoading();
		System.out.println("lpns="+lpns.size());
		for(int i=0;i<=lpns.size();i++){
			int a=i+1;

			System.out.println("Variables.get.getCurrentScenarioId() ="+(String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "LPN" + a));
			CommonWMMobilePage.enterScanContainer((String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "LPN" + a));

			CommonMethods.waitForPageLoading();
			CommonWMMobilePage.clickGoButton();
			CommonMethods.waitForPageLoading();
			String location = CommonWMMobilePage.getLocationText();
			Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "DisplayLocation", location);
			Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "CurrentLocation", location);
			location = location.replaceAll("-", "");
			CommonWMMobilePage.enterScanLocation(location);
			CommonMethods.waitForPageLoading();
			CommonWMMobilePage.clickGoButton();
			CommonMethods.waitForPageLoading();
			if(i==8){
				break;
			}
		}
	}
}