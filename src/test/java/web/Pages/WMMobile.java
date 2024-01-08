package web.Pages;

import com.dhl.reports.FrameworkLogger;
import com.dhl.reports.LogType;
import org.openqa.selenium.By;

import com.dhl.testdata.TestData_Json;
import com.dhl.web.utils.KeyboardActions;
import com.dhl.web.utils.SeleniumActions;

import stepdefinitions.CommonMethods;

@SuppressWarnings("unused")
public class WMMobile extends TestData_Json {
	private static final By byWMMobilePage = By.xpath("//ion-title[@data-component-id='menu']");
	private static final By bySearchField = By.xpath("//input[@type='search']");
	private static final String strXpathMenuLabel = "//ion-label[normalize-space(text())='{menulabel}']";  // no found mapping object
	private static final By byWMLOcation = By.xpath("//*[contains(@data-component-id,'barcodetextfield_location')]");
	private static final By byWMItem = By.xpath("//*[contains(@data-component-id,'barcodetextfield_item')]");
	private static final By byWMQty = By.xpath("//*[contains(@data-component-id,'barcodetextfield_need')]");
	private static final By byWMScanItem = By.xpath("//*[contains(@data-component-id,'barcodetextfield_scanitem')]");
	private static final By byWMScanQty = By.xpath("//*[contains(@data-component-id,'naturalquantityfield_units')]");
	private static final By byWMScanQtyGo = By.xpath("//*[contains(@data-component-id,'naturalquantityfield_go')]");
	private static final By byWMScanITMGo = By.xpath("//*[contains(@data-component-id,'barcodetextfield_go')]");
	
	
	
	private static final By bypickpackprompt = By.xpath("//div[contains(text(),'PPK::0045')]"); // Need to finetune xpath
	private static final By bypromptok = By.xpath("//span[text()='Ok']");
	private static final By bypromptcomfirm = By.xpath("//span[text()='Confirm']");
	private static final By bycyclecount = By.xpath("//ion-item[contains(@data-component-id,'cyclecount')]");
	private static final By byExpiryDate = By
			.xpath("//input[contains(@data-component-id,'acceptdateattributes_inputDate')]");
	private static final By byEnterExpiryDate = By.xpath("//input[contains(@data-component-id,'_inputDate')]");
	private static final By byQuantityTextField = By
			.xpath("//input[contains(@data-component-id,'_naturalquantityfield_unit')]");
	private static final By byBackButton = By.xpath("//ion-button[contains(@data-component-id,'action_submenu_back_button')]");
	private static final By byExitButtonOrMenu = By.xpath("//ion-button[contains(@data-component-id,'action_exit_button')]");
	private static final By byEndILPNButton = By.xpath("//button[contains(@data-component-id,'action_endilpn_button')]");

	/**
	 * Function to verify WM Mobile page is displayed
	 * 
	 */
	public static void verifyPageDisplayed() {
		SeleniumActions.verifyElementVisible(byWMMobilePage, 20, "WM Mobile page");
	}

	/**
	 * Function to search and select menu item searched
	 * 
	 * @param strText - menu name to be searched
	 */
	public static void searchMenu(String strText) {
		SeleniumActions.getElement(bySearchField).clear();
		CommonMethods.waitForPageLoading();
		SeleniumActions.sendTextToElement(bySearchField, strText, "WM Mobile search field");
		CommonMethods.waitForPageLoading();
		KeyboardActions.pressEnterKey(bySearchField);
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(By.xpath(strXpathMenuLabel.replace("{menulabel}", strText)), strText);
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to complete item and quantity
	 */
	public static void completeItemandQty() {
		SeleniumActions.getText(byWMLOcation);
		String strWmQty = SeleniumActions.getText(byWMQty);
		String strwmitemValue = SeleniumActions.getText(byWMItem);
		CommonMethods.waitForPageLoading();
		SeleniumActions.sendTextToElement(byWMScanItem, strwmitemValue, "Scan Item");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byWMScanITMGo, "Item Go Button");
		CommonMethods.waitForPageLoading();
		SeleniumActions.sendTextToElement(byWMScanQty, strWmQty, "Scan Qty");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byWMScanQtyGo, "Item Go Button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to pick pack and prompt
	 */
	public static void pickpackprompt() {

		SeleniumActions.getText(byWMLOcation);
		String strWmQty = SeleniumActions.getText(byWMQty);
		String strwmitemValue = SeleniumActions.getText(byWMItem);
		SeleniumActions.sendTextToElement(byWMScanItem, strwmitemValue, "Scan Item");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byWMScanITMGo, "Item Go Button");
		CommonMethods.waitForPageLoading();
		SeleniumActions.sendTextToElement(byWMScanQty, strWmQty, "Scan Qty");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byWMScanQtyGo, "Item Go Button");
		CommonMethods.waitForPageLoading();
		if (SeleniumActions.getText(bypickpackprompt).contains("PPK::0045")) {
			SeleniumActions.click(bypromptok, "Order is packed");
			SeleniumActions.closeBrowser();
			SeleniumActions.switchToWindowUsingIndex(0);
		}
	}

	/**
	 * Function to click on cycle count
	 */
	public static void cycleCount() {
		SeleniumActions.getElement(bycyclecount).click();
		KeyboardActions.pressEnterKey(bycyclecount);
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to enter expiry date
	 * @param day - day
	 * @param last2 - yaer
	 * @param month - month
	 */
	public static void enterExpiryDate(String day, String month, String last2) {
		SeleniumActions.sendTextToElement(byExpiryDate, day + month + last2, "Expiry Date field");
		System.out.println(day + month + last2);
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to enter expiry date
	 * @param date - date but year as 2 digit
	 */
	public static void enterExpiryDateWithYearAsTwoDigits(String date) {
		String day = date.split("/")[0];
		String month = date.split("/")[1];
		String year = date.split("/")[2].substring(2, 4);
		SeleniumActions.sendTextToElement(byEnterExpiryDate, day + month + year, "Expiry Date Text field");
		CommonMethods.waitForPageLoading();
	}
	/**
	 * Function to enter quantity
	 * @param strText - qantity to be serach
	 */
	public static void enterQuantitymanually(String strText) {
		SeleniumActions.sendTextToElement(byQuantityTextField, strText, "Enter Quantity Manually");
		CommonMethods.waitForPageLoading();
		KeyboardActions.pressEnterKey(byQuantityTextField);
	}
	/**
	 * Function to click on back arrow button
	 */
	public static void clickBackArrowOrButton(){
		SeleniumActions.click(byBackButton,"Back arrow or button");
		FrameworkLogger.log(LogType.PASS, "Back arrow or button");
	}

	/**
	 * Function to click on exit button or menu
	 */
	public static void clickExitButtonOrMenu() {
		SeleniumActions.click(byExitButtonOrMenu, "Exit Button or Menu");
		FrameworkLogger.log(LogType.PASS, "Clicked Exit Button or Menu");
	}

	/**
	 * Function to click on confirm propmt
	 */
	public static void confirmPrompt() {
		SeleniumActions.click(bypromptcomfirm, "Confirm prompt");
		FrameworkLogger.log(LogType.PASS, "Clicked on confirm button in prompt");
	}
	/**
	 * Function to enter expiry date in seed cycle
	 * @param day - day
	 * @param month - month
	 * @param last2 - year
	 */
	public static void enterExpiryDateinSeedCycle(String day, String month, String last2) {
		SeleniumActions.sendTextToElement(byExpiryDate, month + day + last2, "Expiry Date field");
		System.out.println( month + day + last2);
		CommonMethods.waitForPageLoading();
	}
	/**
	 * Function to click on end ILPN button
	 */
	public static void clickEndILPNButton() {
		SeleniumActions.click(byEndILPNButton, "Confirm prompt");
		FrameworkLogger.log(LogType.PASS, "Clicked on End ILPN Button");
	}

}