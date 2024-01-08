package web.Pages;

import com.dhl.testdata.TestData_Json;
import com.dhl.web.utils.SeleniumActions;
import org.openqa.selenium.By;
import stepdefinitions.CommonMethods;

@SuppressWarnings("unused")
public class AssignItemToLocationPopupPage extends TestData_Json {

	private static final By byItemNameTextField = By.xpath("//input[@placeholder='Item name']");
	private static final By bySearchIcon = By.xpath("//button[@data-component-id='ItemIdSearch']");

	/**
	 * Function to search Item name
	 *
	 * @param strText - value which need to searched
	 */
	public static void searchItemName(String strText) {
		SeleniumActions.getElement(byItemNameTextField).clear();
		SeleniumActions.sendTextToElement(byItemNameTextField, strText, "Location Text field");
		CommonMethods.waitForPageLoading();
		clickSearchIcon();
	}

	/**
	 * Function to click Search icon
	 */
	public static void clickSearchIcon() {
		SeleniumActions.click(bySearchIcon, "Search icon");
		CommonMethods.waitForPageLoading();
	}

}
