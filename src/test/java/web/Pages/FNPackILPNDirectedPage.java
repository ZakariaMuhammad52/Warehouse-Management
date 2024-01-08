package web.Pages;

import org.openqa.selenium.By;

import com.dhl.reports.FrameworkLogger;
import com.dhl.reports.LogType;
import com.dhl.testdata.TestData_Json;
import com.dhl.utils.CurrentThreadInstance;
import com.dhl.utils.Variables;
import com.dhl.web.utils.SeleniumActions;

import stepdefinitions.CommonMethods;
import stepdefinitions.ExcelUtil1;

@SuppressWarnings("unused")
public class FNPackILPNDirectedPage extends TestData_Json {

	private static final By byFNPackILPNDirected = By.xpath("//ion-item[@data-component-id='fnpackilpndirected']");

	/**
	 * Function to click FN PackILPN Directed item
	 */
	public static void clickFNPackILPNDirected() {
		CommonMethods.scrollByParticularElement(byFNPackILPNDirected, "FNPackILPNDirected Item");
		SeleniumActions.click(byFNPackILPNDirected, "FNPackILPNDirected Item");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to complete FN PackILPN Directed Process
	 */
	public static void completeFNPackILPNDirectedProcess() {
		String lpn = ExcelUtil1.convert_variable_to_timestamp(getDataFromFeature(getData("LPN")));
		FrameworkLogger.log(LogType.INFO, "LPN Id stored in variable:- " + lpn);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "LPN1", lpn);
		String location = getDataFromFeature("getdata(Location)");
		location = location.replaceAll("-", "");
		String quantity = getDataFromFeature("getdata(Quantity)");
		String item = getDataFromFeature("getdata(Item)");
		item = item.replaceAll("-", "");
		String message = getDataFromFeature("getdata(Message)");
		CommonWMMobilePage.enterScanILPN(lpn);
		CommonWMMobilePage.clickGoButton();
		CommonPopupPage.verifyPopupMessageContains(message);
		CommonPopupPage.clickConfirmButton();
		CommonWMMobilePage.enterScanLocation(location);
		CommonWMMobilePage.clickGoButton();
		CommonWMMobilePage.enterScanItem(item);
		CommonWMMobilePage.clickGoButton();
		CommonWMMobilePage.enterQuantity(quantity);
		CommonWMMobilePage.clickGoButton();
	}
}
