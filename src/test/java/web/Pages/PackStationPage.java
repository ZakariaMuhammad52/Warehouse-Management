package web.Pages;

import com.dhl.driver.DriverManager;
import com.dhl.testdata.TestData_Json;
import com.dhl.utils.CurrentThreadInstance;
import com.dhl.utils.Variables;
import com.dhl.web.utils.KeyboardActions;
import com.dhl.web.utils.SeleniumActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import stepdefinitions.CommonMethods;
import java.util.List;

@SuppressWarnings("unused")
public class PackStationPage extends TestData_Json {

	private static final By bySelectTextField = By.xpath("//input[@placeholder='Select']");
	private static final By byStartPackingButton = By.xpath("//*[contains(@data-component-id,'ps-startpacking-btn')]");
	private static final By byToteTextField = By.xpath("//ion-input[contains(@class,'toteScan-input-field')]/input");
	private static final By byItemTextField = By.xpath("//ion-input[contains(@data-component-id,'item-input')]/input");
	private static final By byRightTickIcon = By.xpath("//ion-button[contains(@data-component-id,'packitem-btn')]//ion-img");
	private static final By byVerifyOlPNTextField = By.xpath("//ion-input[@data-component-id='verifyOLPN-input-content']/input");
	private static final By byConfirmButton = By.xpath("//*[contains(@data-component-id,'ps-confirm-btn')]");
	private static final By byOLPNsList= By.xpath("//div[@data-component-id='InventoryMove.OlpnId-table']/span");
	private static final By byPackedCellValueList= By.xpath("//div[@data-component-id='PackedQty-table']/span");
	private static final By bySerialNumberTextField = By.xpath("//ion-input[@data-component-id='serialnumber-input-form']/input");
	private static final By byPlusIcon = By.xpath("//ion-button[contains(@data-component-id,'incrementquantity-btn')]//ion-icon");
	private static final By byDisplayAllocatedQty = By.xpath("(//div[@data-component-id='DisplayAllocatedQty-table']/span)[1]");
	private static final By byInventoryMove = By.xpath("(//div[@data-component-id='InventoryMove.OlpnId-table']/span)[1]");
	/**
	 * Function to selectPackingStation
	 * @param station - value to be select
	 */
	public static void selectPackingStation(String station) {
		SeleniumActions.clear(bySelectTextField, "Select Text field");
		CommonMethods.waitForPageLoading();
		SeleniumActions.sendTextToElement(bySelectTextField, station, "Select Text field");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(By.xpath("//*[@title='"+station+"']"), "Station");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byStartPackingButton, "Start packing button");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to enter Tote
	 * @param text - value which need to be entered
	 */
	public static void enterTote(String text) {
		SeleniumActions.clear(byToteTextField,"Tote Text field");
		CommonMethods.waitForPageLoading();
		SeleniumActions.sendTextToElement(byToteTextField, text, "Tote Text field");
		CommonMethods.waitForPageLoading();
		KeyboardActions.pressEnterKey(byToteTextField);
		CommonMethods.waitForPageLoading();
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to enter Item
	 * @param text - value which need to be entered
	 */
	public static void enterItem(String text) {
		SeleniumActions.sendTextToElement(byItemTextField, text, "Item Text field");
		CommonMethods.waitForPageLoading();
		KeyboardActions.pressTabKey(byItemTextField);
		CommonMethods.waitForPageLoading();
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to enter VerifyOLPN TextField
	 * @param text - value which need to be entered
	 */
	public static void enterVerifyOLPNTextField(String text) {
		SeleniumActions.sendTextToElement(byVerifyOlPNTextField, text, "VerifyOLPN Text field");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click Confirm button
	 */
	public static void clickConfirmButton() {
		SeleniumActions.click(byConfirmButton, "Confirm button");
		CommonMethods.waitForPageLoading();
	}
	/**
	 * Function to click RightTick Icon
	 */
	public static void clickRightTickIcon() {
		SeleniumActions.click(byRightTickIcon, "RightTick Icon");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to completePackingForMultipleOLpns
	 */
	public static void completePackingForMultipleOLpns() {
		String item = getDataFromFeature("getdata(Item)");
		String confirmMessage = getDataFromFeature("getdata(ConfirmMessage)");
		String tote= (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ToteId");
		List<String> listOfOLPNs = (List<String>) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "listOfOLPNs");
		enterTote(tote);
		List<WebElement> listOfOLPNsElements = DriverManager.getDriver().findElements(byOLPNsList);
		for(int i=listOfOLPNs.size()-1;i>=0;i--){
			String olpn=listOfOLPNs.get(i);
			SeleniumActions.clickByJS(listOfOLPNsElements.get(0),"olpn element");
			CommonMethods.waitForPageLoading();
			clickRightTickIcon();
			enterVerifyOLPNTextField(olpn);
			clickConfirmButton();
			CommonPopupPage.verifyToastMessageContains(confirmMessage);
			listOfOLPNsElements = DriverManager.getDriver().findElements(byOLPNsList);
		}
	}


	/**
	 * Function to complete Packing ForMultipleItems WithSerialNumber
	 */
	public static void completePackingForMultipleItemsWithSerialNumber() {
		int itemsCount = Integer.parseInt(getDataFromFeature("getdata(ItemCount)"));
		String confirmMessage = getDataFromFeature("getdata(ConfirmMessage)");
		String orderedQuantity = getDataFromFeature("getdata(OrderedQuantity)");
		String tote= (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "ToteId");
		List<String> listOfOLPNs = (List<String>) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "listOfOLPNs");
		String olpn=listOfOLPNs.get(0);
		List<String> listOfSerialNumbers = (List<String>) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "listOfSerialNumbers");
		enterTote(tote);
		for(int i=1;i<=itemsCount;i++){
			String item = getDataFromFeature("getdata(Item" + i + ")");
			item=item.replaceAll("-","");
			enterItem(item);
			clickRightTickIcon();
			enterVerifyOLPNTextField(olpn);
			clickConfirmButton();
			String serialNumberRequired = getDataFromFeature("getdata(SerialNumberRequiredForItem" + i + ")");
			if(serialNumberRequired.equalsIgnoreCase("Yes")){
				for (int j = 0; j < Integer.parseInt(orderedQuantity); j++) {
					enterSerialNumber(listOfSerialNumbers.get(j));
					CommonPopupPage.clickGoButton();
				}
				clickConfirmButton();
			}
		}
		CommonPopupPage.verifyToastMessageContains(confirmMessage);
	}

	/**
	 * Function to enter SerialNumber
	 * @param text - value which need to be entered
	 */
	public static void enterSerialNumber(String text) {
		SeleniumActions.sendTextToElement(bySerialNumberTextField, text, "SerialNumber Text field");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to complete Packing ForMultipleItems WithSerialNumber ForMultipleTotes
	 */
	public static void completePackingForMultipleItemsWithSerialNumberForMultipleTotes() {
		int itemsCount = Integer.parseInt(getDataFromFeature("getdata(ItemCount)"));
		String confirmMessage = getDataFromFeature("getdata(ConfirmMessage)");
		List<String> listOfTotes = (List<String>) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "listOfTotes");
		List<String> listOfSerialNumbers = (List<String>) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + "listOfSerialNumbers");
		int s=0;
		for(int t=0;t<listOfTotes.size();t++) {
			String tote = listOfTotes.get(t);
			enterTote(tote);
			for (int i = 1; i <= itemsCount; i++) {
				String item = getDataFromFeature("getdata(Item" + i + ")");
				item = item.replaceAll("-", "");
				enterItem(item);
				int orderedQuantity = Integer.parseInt(DriverManager.getDriver().findElement(byDisplayAllocatedQty).getText());
				String olpn=DriverManager.getDriver().findElement(byInventoryMove).getText();
				if (orderedQuantity>1){
					for(int k=2;k<=orderedQuantity;k++){
						clickPlusIcon();
					}
				}
				clickRightTickIcon();
				enterVerifyOLPNTextField(olpn);
				clickConfirmButton();
				if (DriverManager.getDriver().findElements(bySerialNumberTextField).size()>0) {
					for (int j = 0; j < orderedQuantity; j++) {
						enterSerialNumber(listOfSerialNumbers.get(s));
						CommonPopupPage.clickGoButton();
						s=s+1;
					}
					clickConfirmButton();
				}
			}
			CommonPopupPage.verifyToastMessageContains(confirmMessage);
		}
	}

	/**
	 * Function to click Plus Icon
	 */
	public static void clickPlusIcon() {
		SeleniumActions.click(byPlusIcon, "Plus Icon");
		CommonMethods.waitForPageLoading();
	}
}
