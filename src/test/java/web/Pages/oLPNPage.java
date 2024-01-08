package web.Pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.dhl.driver.DriverManager;
import com.dhl.reports.FrameworkLogger;
import com.dhl.reports.LogType;
import com.dhl.testdata.TestData_Json;
import com.dhl.utils.CurrentThreadInstance;
import com.dhl.utils.Variables;
import com.dhl.web.utils.KeyboardActions;
import com.dhl.web.utils.SeleniumActions;

import stepdefinitions.CommonMethods;

@SuppressWarnings("unused")
public class oLPNPage extends TestData_Json {

	private static final By byOLPN = By.xpath("//span[contains(@data-component-id,'OlpnId')]");
	private static final By byOLPNStatusesList = By.xpath("//div[contains(@data-component-id,'StatusDescription')]");
	private static final By byCancelOLPN = By.xpath("//ion-button[contains(@data-component-id,'CanceloLPN')]");
	private static final By byReasonCodeDrop = By.xpath("//ion-input[contains(@data-component-id,'ReasonCode')]");
	private static final By byReasonCode = By
			.xpath("//ion-list//button[contains(@data-component-id,'CancelShortageRequirement')]");
	private static final By byOLPNSizesList = By.xpath("//*[contains(@data-component-id,'ContainerSizeId')]");
	private static final By byOrderIdField = By.xpath("//a[contains(@data-component-id,'OrderId')]");
	private static final By byContainerIdField = By.xpath("//span[contains(@data-component-id,'ContainerTypeId')]");
	private static final By byLpnQtyField = By.xpath("//span[contains(@data-component-id,'TotalLpnQty')]");
	private static final By byContainerIdField1 = By
			.xpath("(//span[contains(@data-component-id,'ContainerTypeId')])[1]");
	private static final By byOLPNSizesList1 = By.xpath("(//*[contains(@data-component-id,'ContainerSizeId')])[1]");

	private static final By byOrderTextField = By
			.xpath("//ion-input[contains(@data-component-id,'OriginalOrderId')]/input");
	private static final By byExpandOrderField = By.xpath(
			"//span[@title='Original order']/following-sibling::ion-button[contains(@data-component-id,'expand-button')]");
	private static final By byShipmentIDField = By.xpath("//a[contains(@data-component-id,'ShipmentId')]");
	private static final By byOrderIdFieldInDetailsPage = By.xpath("(//a[contains(@data-component-id,'OrderId')])[3]");
	private static final By byCloseOlpnDetailsButton = By.xpath("//button[contains(@data-component-id,'close-icon')]");
	private static final By byOrderType = By.xpath("//card-panel//*[contains(@data-component-id,'OrderType')]");
	private static final By byCardViewOrderId = By.xpath("//card-view//*[contains(@data-component-id,'OrderId')]");

	/**
	 * Function to capture OLPNs
	 */
	public static void storeOLPNs() {
		List<WebElement> elements = SeleniumActions.getElements(byOLPN);
		List<String> listOfOLPNs = new ArrayList<>();
		for (int i = 0; i < elements.size(); i++) {
			String value = elements.get(i).getText().trim();
			listOfOLPNs.add(value);
		}
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "listOfOLPNs", listOfOLPNs);
		FrameworkLogger.log(LogType.INFO, "Set value for listOfOLPNs : " + listOfOLPNs);
	}

	/**
	 * Function to verify multiple oLPN Statuses
	 *
	 * @param Statuses - Statuses value which need to be verified
	 */
	public static void verifyMultipleOLPNStatuses(String Statuses) {
		List<String> expectedStatuses = new ArrayList<String>(Arrays.asList(Statuses.split(",")));
		List<WebElement> elements = DriverManager.getDriver().findElements(byOLPNStatusesList);
		List<String> actualStatuses = new ArrayList<>();
		for (WebElement e : elements) {
			actualStatuses.add(e.getText());
		}
		if (expectedStatuses.equals(actualStatuses)) {
			FrameworkLogger.log(LogType.PASS, "oLPN Statuses Verification passed : " + expectedStatuses);
		} else {
			FrameworkLogger.log(LogType.FAIL, "oLPN Statuses Verification failed. Expected :" + expectedStatuses
					+ " , Actual :" + actualStatuses);
		}
	}

	/**
	 * Function to Click on Cancel OLPN Button with selecting the reason code
	 */
	public static void clickOnCancelOLPNButtonWithReasonCode() {
		SeleniumActions.click(byCancelOLPN, "Cancel OLPN");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byReasonCodeDrop, "Click On Reason Code Option");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(byReasonCode, "Reason Code");
		CommonMethods.waitForPageLoading();
		CommonPopupPage.clickSubmitButton();
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to verify Container Sizes based on the quantity for order id
	 * 
	 * @param Orders - value of orders
	 */
	public static void verifyMultipleOLPNSSizesBasedOnTheQuantityForOrders(String Orders) {
		String listOfOrders = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + Orders);
		List<String> expectedListOrders = new ArrayList<String>(Arrays.asList(listOfOrders.split(",")));
		for (String singleOrder : expectedListOrders) {
			final By byListOfOrder = By.xpath("(//*[@title='" + singleOrder + "'])[1]");

			CommonMethods.waitForPageLoading();
			if (DriverManager.getDriver().findElements(byOrderTextField).size() < 1) {
				SeleniumActions.click(byExpandOrderField, "Expand icon");
			}
			SeleniumActions.getElement(byOrderTextField).clear();
			SeleniumActions.sendTextToElement(byOrderTextField, singleOrder, "Order ID Text Field");
			CommonMethods.waitForPageLoading();
			KeyboardActions.pressEnterKey(byOrderTextField);
			CommonMethods.waitForPageLoading();
			String expectedOrderId = SeleniumActions.getText(By.xpath("(//*[@title='" + singleOrder + "'])[1]"));
			CommonPage.clickRowAtFirstIndex();
			CommonMethods.waitForPageLoading();
			HeaderPanelPage.clickRelatedLinksButton();
			;
			CommonMethods.waitForPageLoading();
			HeaderPanelPage.clickOLPNSLink();
			CommonMethods.waitForPageLoading();
			String actualOrderSize = SeleniumActions.getText(byOLPNSizesList);
			String actualOrderQuantity = SeleniumActions.getText(byLpnQtyField);
			String actualOrdeId = SeleniumActions.getText(By.xpath("(//*[@title='" + singleOrder + "'])[1]"));
			if (actualOrderSize.equalsIgnoreCase("SML")) {
				SeleniumActions.verifyTextEquals(actualOrderQuantity, getDataFromFeature("getdata(MaxUnit1)"), false);
				SeleniumActions.verifyTextEquals(actualOrdeId, expectedOrderId, false);
			} else if (actualOrderSize.equalsIgnoreCase("MED")) {
				SeleniumActions.verifyTextEquals(actualOrderQuantity, getDataFromFeature("getdata(MaxUnit2)"), false);
				SeleniumActions.verifyTextEquals(actualOrdeId, expectedOrderId, false);
			} else if (actualOrderSize.equalsIgnoreCase("LRG")) {
				SeleniumActions.verifyTextEquals(actualOrderQuantity, getDataFromFeature("getdata(MaxUnit3)"), false);
				SeleniumActions.verifyTextEquals(actualOrdeId, expectedOrderId, false);
			}
			HomePage.navigate_to_OriginalOrder2();
			CommonMethods.waitForPageLoading();
			OriginalOrdersPage.verifyOriginalOrders2PageDisplayed();
			CommonMethods.waitForPageLoading();

		}

	}

	/**
	 * Function to Validate OrderID In OLPN Page For Multiple OLPNS In An Order
	 * 
	 * @param ExpectedOrderID - expected orderid value
	 */
	public static void validateOLPNsOrderID(String ExpectedOrderID) {

		List<WebElement> elements = DriverManager.getDriver().findElements(byOrderIdField);
		for (WebElement e : elements) {
			String ActualOrderID = e.getText().trim();
			SeleniumActions.verifyTextEquals(ActualOrderID, ExpectedOrderID);
		}
	}

	/**
	 * Function to Validate ContainerType In OLPN Page For Multiple OLPNS In AN
	 * Order
	 * 
	 * @param ExpectedContainerType -container type value
	 */
	public static void validateContainerTypeInOLPNPage(String ExpectedContainerType) {
		List<WebElement> elements = DriverManager.getDriver().findElements(byContainerIdField);
		for (WebElement e : elements) {
			String ActualContainerType = e.getText().trim();
			SeleniumActions.verifyTextEquals(ActualContainerType, ExpectedContainerType);
		}
	}

	/**
	 * Function to Validate ContainerSize In OLPN Page For Multiple OLPNS In An
	 * Order
	 * 
	 * @param ExpectedContainerSize -container size value
	 */
	public static void validateContainerSizeInOLPNPage(String ExpectedContainerSize) {
		List<WebElement> elements = DriverManager.getDriver().findElements(byOLPNSizesList);
		for (WebElement e : elements) {
			String ActualContainerSize = e.getText().trim();
			SeleniumActions.verifyTextEquals(ActualContainerSize, ExpectedContainerSize);
		}
	}

	/**
	 * Function to Validate LPNQuantity In OLPN Page For Multiple OLPNS In An Order
	 * 
	 * @param ExpectedLPNQuantity - lpn qantity
	 */
	public static void validateLPNQuantityInOLPNPage(String ExpectedLPNQuantity) {
		List<WebElement> elements = DriverManager.getDriver().findElements(byLpnQtyField);
		for (WebElement e : elements) {
			String ActualLPNQuantity = e.getText().trim();
			SeleniumActions.verifyTextEquals(ActualLPNQuantity, ExpectedLPNQuantity);
		}
	}

	/**
	 * Function to verify 2 similar olpns with same quantity and similar olpns with
	 * different quantity
	 */
	public static void verifyTwoSameOLpnsWithSameQuantityAndOneWithDiffQuantity() {
		List<WebElement> containerSize = DriverManager.getDriver().findElements(byOLPNSizesList);
		List<WebElement> totalLPNQty = DriverManager.getDriver().findElements(byLpnQtyField);
		int count = 0;
		for (int i = 0; i < containerSize.size(); i++) {
			if (containerSize.get(i).getText().equalsIgnoreCase("MED")) {
				SeleniumActions.verifyTextEquals(totalLPNQty.get(i).getText(), getDataFromFeature("getdata(MaxUnit2)"),
						false);
				count++;
			}
			if (containerSize.get(i).getText().equalsIgnoreCase("LRG")) {
				SeleniumActions.verifyTextEquals(totalLPNQty.get(i).getText(),
						getDataFromFeature("getdata(LrgExpQuantity)"), false);
				count++;
			}
		}
		if (count == 3) {
			FrameworkLogger.log(LogType.PASS, "Container size and quantity Verification passed");
		} else {
			FrameworkLogger.log(LogType.FAIL, "Container size and quantity Verification failed");
		}

	}

	/**
	 * Function to Verify oLPNs of each order has unique container type, and
	 * container size is per cube to capacity calculation
	 * 
	 * @param Orders - order value
	 */
	public static void validateAllOlpnsOfEachOderWithContainerTypeContainerSizeAndCubeValue(String Orders) {
		String listOfOrders = (String) Variables.get(CurrentThreadInstance.getCurrentScenarioId() + Orders);
		List<String> expectedOrders = new ArrayList<String>(Arrays.asList(listOfOrders.split(",")));
		for (String singleOrder : expectedOrders) {
			final By byListOfOrder = By.xpath("(//*[@title='" + singleOrder + "'])[1]");

			CommonMethods.waitForPageLoading();
			if (DriverManager.getDriver().findElements(byOrderTextField).size() < 1) {
				SeleniumActions.click(byExpandOrderField, "Expand icon");
			}
			SeleniumActions.getElement(byOrderTextField).clear();
			SeleniumActions.sendTextToElement(byOrderTextField, singleOrder, "Order ID Text Field");
			CommonMethods.waitForPageLoading();
			KeyboardActions.pressEnterKey(byOrderTextField);
			CommonMethods.waitForPageLoading();
			String actualOrderType = SeleniumActions.getText(byOrderType);
			CommonMethods.waitForPageLoading();
			CommonPage.clickRowAtFirstIndex();
			CommonMethods.waitForPageLoading();
			HeaderPanelPage.clickRelatedLinksButton();
			HeaderPanelPage.clickOLPNSLink();
			CommonMethods.waitForPageLoading();
			if (actualOrderType.equals(getDataFromFeature("getdata(OrderType1)"))) {
				List<WebElement> elementsContainerID = DriverManager.getDriver().findElements(byContainerIdField);
				String containerTypeList = getDataFromFeature("getdata(CubingValues3)");
				List<String> expectedcontainerType = new ArrayList<String>(Arrays.asList(containerTypeList.split(",")));
				for (WebElement e : elementsContainerID) {
					String ActualContainerType = e.getText().trim();
					if (expectedcontainerType.contains(ActualContainerType)) {
						FrameworkLogger.log(LogType.PASS,
								"Container Type Verification passed : " + ActualContainerType);
					} else {
						FrameworkLogger.log(LogType.FAIL, "Container Type Verification failed. Expected :"
								+ ActualContainerType + " , Actual :" + expectedcontainerType);
					}

				}

				List<WebElement> elementsSize = DriverManager.getDriver().findElements(byOLPNSizesList);
				String containersizeList = getDataFromFeature("getdata(ContainerSize1)");
				List<String> expectedcontainersize = new ArrayList<String>(Arrays.asList(containersizeList.split(",")));
				for (WebElement e : elementsSize) {
					String ActualContainersize = e.getText().trim();
					if (expectedcontainersize.contains(ActualContainersize)) {
						FrameworkLogger.log(LogType.PASS,
								"Container Size Verification passed : " + ActualContainersize);
					} else {
						FrameworkLogger.log(LogType.FAIL, "Container Size Verification failed. Expected :"
								+ ActualContainersize + " , Actual :" + expectedcontainersize);
					}

				}
				List<WebElement> elementLPNQuantity = DriverManager.getDriver().findElements(byLpnQtyField);
				String containerquantityList = getDataFromFeature("getdata(LPNQuantity1)");
				List<String> expectedcontainerquantity = new ArrayList<String>(
						Arrays.asList(containerquantityList.split(",")));
				for (WebElement e : elementLPNQuantity) {
					String ActualContainerquantity = e.getText().trim();
					if (expectedcontainerquantity.contains(ActualContainerquantity)) {
						FrameworkLogger.log(LogType.PASS,
								"LPN Quantity Verification passed : " + ActualContainerquantity);
					} else {
						FrameworkLogger.log(LogType.FAIL, "LPN Type Verification failed. Expected :"
								+ ActualContainerquantity + " , Actual :" + expectedcontainerquantity);
					}

				}
			} else if (actualOrderType.equals(getDataFromFeature("getdata(OrderType2)"))) {

				List<WebElement> elementsContainerID = DriverManager.getDriver().findElements(byContainerIdField);
				String containerTypeList = getDataFromFeature("getdata(CubingValues2)");
				List<String> expectedcontainerType = new ArrayList<String>(Arrays.asList(containerTypeList.split(",")));
				for (WebElement e : elementsContainerID) {
					String ActualContainerType = e.getText().trim();
					if (expectedcontainerType.contains(ActualContainerType)) {
						FrameworkLogger.log(LogType.PASS,
								"Container Type Verification passed And Value is: " + ActualContainerType);
					} else {
						FrameworkLogger.log(LogType.FAIL, "Container Type Verification failed. Expected :"
								+ ActualContainerType + " , Actual :" + expectedcontainerType);
					}

				}

				List<WebElement> elementsSize = DriverManager.getDriver().findElements(byOLPNSizesList);
				String containersizeList = getDataFromFeature("getdata(ContainerSize2)");
				List<String> expectedcontainersize = new ArrayList<String>(Arrays.asList(containersizeList.split(",")));
				for (WebElement e : elementsSize) {
					String ActualContainersize = e.getText().trim();
					if (expectedcontainersize.contains(ActualContainersize)) {
						FrameworkLogger.log(LogType.PASS,
								"Container Size Verification passed : " + ActualContainersize);
					} else {
						FrameworkLogger.log(LogType.FAIL, "Container Size Verification failed. Expected :"
								+ ActualContainersize + " , Actual :" + expectedcontainersize);
					}

				}
				List<WebElement> elementLPNQuantity = DriverManager.getDriver().findElements(byLpnQtyField);
				String containerquantityList = getDataFromFeature("getdata(LPNQuantity2)");
				List<String> expectedcontainerquantity = new ArrayList<String>(
						Arrays.asList(containerquantityList.split(",")));
				for (WebElement e : elementLPNQuantity) {
					String ActualContainerquantity = e.getText().trim();
					if (expectedcontainerquantity.contains(ActualContainerquantity)) {
						FrameworkLogger.log(LogType.PASS,
								"LPN Quantity Verification passed : " + ActualContainerquantity);
					} else {
						FrameworkLogger.log(LogType.FAIL, "LPN Type Verification failed. Expected :"
								+ ActualContainerquantity + " , Actual :" + expectedcontainerquantity);
					}

				}

			} else if (actualOrderType.equals(getDataFromFeature("getdata(OrderType3)"))) {
				List<WebElement> elementsContainerID = DriverManager.getDriver().findElements(byContainerIdField);
				String containerTypeList = getDataFromFeature("getdata(CubingValues1)");
				List<String> expectedcontainerType = new ArrayList<String>(Arrays.asList(containerTypeList.split(",")));
				for (WebElement e : elementsContainerID) {
					String ActualContainerType = e.getText().trim();
					if (expectedcontainerType.contains(ActualContainerType)) {
						FrameworkLogger.log(LogType.PASS,
								"Container Type Verification passed And Value is: " + ActualContainerType);
					} else {
						FrameworkLogger.log(LogType.FAIL, "Container Type Verification failed. Expected :"
								+ ActualContainerType + " , Actual :" + expectedcontainerType);
					}

				}

				List<WebElement> elementsSize = DriverManager.getDriver().findElements(byOLPNSizesList);
				String containersizeList = getDataFromFeature("getdata(OlpnSizes)");
				List<String> expectedcontainersize = new ArrayList<String>(Arrays.asList(containersizeList.split(",")));
				for (WebElement e : elementsSize) {
					String ActualContainersize = e.getText().trim();
					if (expectedcontainersize.contains(ActualContainersize)) {
						FrameworkLogger.log(LogType.PASS,
								"Container Size Verification passed : " + ActualContainersize);
					} else {
						FrameworkLogger.log(LogType.FAIL, "Container Size Verification failed. Expected :"
								+ ActualContainersize + " , Actual :" + expectedcontainersize);
					}

				}
				List<WebElement> elementLPNQuantity = DriverManager.getDriver().findElements(byLpnQtyField);
				String containerquantityList = getDataFromFeature("getdata(OlpnContainerUnits)");
				List<String> expectedcontainerquantity = new ArrayList<String>(
						Arrays.asList(containerquantityList.split(",")));
				for (WebElement e : elementLPNQuantity) {
					String ActualContainerquantity = e.getText().trim();
					if (expectedcontainerquantity.contains(ActualContainerquantity)) {
						FrameworkLogger.log(LogType.PASS,
								"LPN Quantity Verification passed : " + ActualContainerquantity);
					} else {
						FrameworkLogger.log(LogType.FAIL, "LPN Type Verification failed. Expected :"
								+ ActualContainerquantity + " , Actual :" + expectedcontainerquantity);
					}

				}

			}
			HomePage.navigate_to_OriginalOrder2();
			CommonMethods.waitForPageLoading();
			OriginalOrdersPage.verifyOriginalOrders2PageDisplayed();
			CommonMethods.waitForPageLoading();
		}

	}

	/**
	 * Function to Validate ContainerSize In OLPN Page For Multiple OLPNS In An
	 * Order
	 */
	public static void validateContainerSizeInOLPNPageformultipleolpn() {
		List<WebElement> elements = DriverManager.getDriver().findElements(byOLPNSizesList);
		String containersizeList = getDataFromFeature("getdata(ContainerSize)");
		List<String> expectedcontainersize = new ArrayList<String>(Arrays.asList(containersizeList.split(",")));
		for (WebElement e : elements) {
			String ActualContainersize = e.getText().trim();
			if (expectedcontainersize.contains(ActualContainersize)) {
				FrameworkLogger.log(LogType.PASS, "Container S Verification passed : " + ActualContainersize);
			} else {
				FrameworkLogger.log(LogType.FAIL, "Container Type Verification failed. Expected :" + ActualContainersize
						+ " , Actual :" + expectedcontainersize);
			}

		}
	}

	/**
	 * Function to Validate LPNQuantity In OLPN Page For Multiple OLPNS In An Order
	 */
	public static void validateLPNQuantityInOLPNPageformultipleolpn() {
		List<WebElement> element = DriverManager.getDriver().findElements(byLpnQtyField);
		String containerquantityList = getDataFromFeature("getdata(TotalLpn)");
		List<String> expectedcontainerquantity = new ArrayList<String>(Arrays.asList(containerquantityList.split(",")));
		for (WebElement e : element) {
			String ActualContainerquantity = e.getText().trim();
			if (expectedcontainerquantity.contains(ActualContainerquantity)) {
				FrameworkLogger.log(LogType.PASS, "LPN Quantity Verification passed : " + ActualContainerquantity);
			} else {
				FrameworkLogger.log(LogType.FAIL, "LPN Type Verification failed. Expected :" + ActualContainerquantity
						+ " , Actual :" + expectedcontainerquantity);
			}

		}

	}

	/**
	 * Function to validate container type on olpn page
	 * 
	 * @param ExpectedContainerType - value of container type
	 */
	public static void validateContainerType1InOLPNPage(String ExpectedContainerType) {
		List<WebElement> elements = DriverManager.getDriver().findElements(byContainerIdField1);
		for (WebElement e : elements) {
			String ActualContainerType = e.getText().trim();
			SeleniumActions.verifyTextEquals(ActualContainerType, ExpectedContainerType);
		}
	}

	public static void validateContainerSize1InOLPNPage(String ExpectedContSize) {
		List<WebElement> elements = DriverManager.getDriver().findElements(byOLPNSizesList1);
		for (WebElement e : elements) {
			String ActualContainerSize = e.getText().trim();
			SeleniumActions.verifyTextEquals(ActualContainerSize, ExpectedContSize);
		}

	}

	/**
	 * Function to validate total lpn quantity with multiple olpn
	 */
	public static void validateTotalLPNQuantityInOLPNPageformultipleolpn() {
		List<WebElement> element = DriverManager.getDriver().findElements(byLpnQtyField);
		String expectedcontainerquantity = getDataFromFeature("getdata(Totalcount)");
		// String Totalcount= getDataFromFeature("getdata(Totalcount)");
		// expectedcontainerquantity = new
		// ArrayList<String>(Arrays.asList(containerquantityList.split(",")));
		int sum = 0;
		for (WebElement e : element) {
			String ActualContainerquantity = e.getText().trim();
			int i = Integer.parseInt(ActualContainerquantity);
			System.out.println("Value" + i);
			sum += i;
			System.out.println(sum);

		}
		String Actualquantity = Integer.toString(sum);
		if (expectedcontainerquantity.contains(Actualquantity)) {
			FrameworkLogger.log(LogType.PASS, "LPN Quantity Verification passed : " + Actualquantity);
		} else {
			FrameworkLogger.log(LogType.FAIL, "LPN Type Verification failed. Expected :" + Actualquantity
					+ " , Actual :" + expectedcontainerquantity);
		}

	}

	/**
	 * Function to capture Total LPNQuantity
	 */
	public static void storeTotalLPNQuantity() {
		List<WebElement> elements = SeleniumActions.getElements(byLpnQtyField);
		List<String> listOfTotalLPNQuantity = new ArrayList<>();
		for (int i = 0; i < elements.size(); i++) {
			String value = elements.get(i).getText().trim();
			listOfTotalLPNQuantity.add(value);
		}
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "listOfTotalLPNQuantity", listOfTotalLPNQuantity);
		FrameworkLogger.log(LogType.INFO, "Set value for listOfTotalLPNQuantity : " + listOfTotalLPNQuantity);
	}

	/**
	 * Function to capture OLPNs and Total LPNQuantity
	 */
	public static void storeOLPNsAndTotalLPNQuantity() {
		List<WebElement> olpnElements = SeleniumActions.getElements(byOLPN);
		List<WebElement> lpnQuantityElements = SeleniumActions.getElements(byLpnQtyField);
		HashMap<String, String> olpnAndQuantityHashMap = new HashMap<String, String>();

		List<String> listOfOLPNs = new ArrayList<>();
		for (int i = 0; i < olpnElements.size(); i++) {
			String key = olpnElements.get(i).getText().trim();
			String value = lpnQuantityElements.get(i).getText().trim();
			olpnAndQuantityHashMap.put(key, value);
		}
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "olpnAndQuantityHashMap", olpnAndQuantityHashMap);
		FrameworkLogger.log(LogType.INFO, "Set value for olpnAndQuantityHashMap : " + olpnAndQuantityHashMap);

	}

	/**
	 * Function to verify shipment ID
	 */
	public static void verifyShipmentIDIsShowing() {
		SeleniumActions.verifyElementVisible(byShipmentIDField, 10, "Shipment ID");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to validate olpns order id on details page
	 */
	public static void validateOLPNsOrderIDInDetailspage(String ExpectedOrderID) {

		List<WebElement> elements = DriverManager.getDriver().findElements(byOrderIdFieldInDetailsPage);
		for (WebElement e : elements) {
			String ActualOrderID = e.getText().trim();
			SeleniumActions.verifyTextEquals(ActualOrderID, ExpectedOrderID);
		}
	}

	/**
	 * Function to cclose olpn details page
	 */
	public static void closeOlpnDetailsPage() {
		SeleniumActions.click(byCloseOlpnDetailsButton, "Close Olpn Button");
		CommonMethods.waitForPageLoading();
	}
}