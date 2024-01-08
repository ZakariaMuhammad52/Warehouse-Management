package web.Pages;

import com.dhl.driver.DriverManager;
import com.dhl.reports.FrameworkLogger;
import com.dhl.reports.LogType;
import com.dhl.testdata.TestData_Json;
import com.dhl.utils.CurrentThreadInstance;
import com.dhl.utils.Variables;
import com.dhl.web.utils.KeyboardActions;
import com.dhl.web.utils.SeleniumActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import stepdefinitions.CommonMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unused")
public class ContainerTypePage extends TestData_Json {

	private static final By byMaxNoUnits_containerSizeDefinition = By.xpath("//span[@data-component-id='MaxCubingUnits-card-view']");
	private static final By byMaxWeight_containerSizeDefinition = By.xpath("//span[@data-component-id='MaxCubingWeight-card-view']");
	private static final By byMaxVolume_containerSizeDefinition = By.xpath("//span[@data-component-id='MaxCubingVolume-card-view']");
	private static final By bylistcontainer = By.xpath("//ion-reorder-group//*[contains(@class,'card-row primary')]");
	private static final By byContainerSizes = By.xpath("//*[@data-component-id='ContainerSizeId-card-view']");
	private static final By byContainerNoOfUnits = By.xpath("//*[@data-component-id='MaxCubingUnits-card-view']");
	private static final By byContainerWeight = By.xpath("//*[@data-component-id='MaxCubingWeight-card-view']");
	private static final By byOkBtn = By.xpath("//ion-button[@data-component-id='ok-btn-modal-wizard']");
	private static final By byCloseSliderBtn = By.xpath("//button[contains(@class,'swipe-releaved')]");
	private static final By byView = By.xpath("//*[contains(@class,'slideOptionList')]//*[@data-component-id='View-swipe-panel']");
	private static final By byContainerTextField = By.xpath("//ion-input[@data-component-id='ContainerTypeId-filter']/input");
	private static final By byExpandContainerTypeField = By
			.xpath("//span[@title='Container Type']/following-sibling::ion-button[contains(@data-component-id,'expand-button')]");
	private static final By byExteriorVolumeoftheContainer= By.xpath("//input[contains(@data-component-id,'ExternalVolume')]");
	/**
	 * Function to Verify Container size definition details
	 */
	public static void verifyContainerSizeDefinitionDetails(){
		String actualUnit = SeleniumActions.getText(byMaxNoUnits_containerSizeDefinition);
		String actualWeight = SeleniumActions.getText(byMaxWeight_containerSizeDefinition);
		String actualVolume = SeleniumActions.getText(byMaxVolume_containerSizeDefinition);
		SeleniumActions.verifyTextEquals(actualUnit,getDataFromFeature("getdata(MaxUnitOfContainer)"),false);
		SeleniumActions.verifyTextEquals(actualWeight,getDataFromFeature("getdata(MaxWeightOfContainer)"),false);
		SeleniumActions.verifyTextEquals(actualVolume,getDataFromFeature("getdata(MaxVolumeOfContainer)"),false);
	}

	/**
	 * Function to Verify Container size definition details for multiple container
	 */
	public static void verifyContainerSizeDefinitionDetailsForMultipleContainer() {
		List<WebElement> elements = SeleniumActions.getElements(bylistcontainer);
		List<String> actualContainer = new ArrayList<>();
		CommonMethods.waitForPageLoading();
		//Verify All the Container Sizes
		List<WebElement> elementConainerSize = DriverManager.getDriver().findElements(byContainerSizes);
		String listOfOLPNSizes = getDataFromFeature("getdata(OlpnSizes)");
		List<String> expectedOLPNSize = new ArrayList<String>(Arrays.asList(listOfOLPNSizes.split(",")));
		for (WebElement e : elementConainerSize) {
			String actualOLPNSize = e.getText().trim();
			if (expectedOLPNSize.contains(actualOLPNSize)) {
				FrameworkLogger.log(LogType.PASS, "OLPN Size Verification passed : " + actualOLPNSize);
			} else {
				FrameworkLogger.log(LogType.FAIL, "OLPN Size Verification failed. Expected :" + actualOLPNSize
						+ " , Actual :" + expectedOLPNSize);
			}
		}
		//Verify All the Container No Of Units
		List<WebElement> elementContainerUnits = DriverManager.getDriver().findElements(byContainerNoOfUnits);
		String listOfOLPNUnits = getDataFromFeature("getdata(OlpnContainerUnits)");
		List<String> expectedUnits = new ArrayList<String>(Arrays.asList(listOfOLPNUnits.split(",")));
		for (WebElement e : elementContainerUnits) {
			String actualUnits = e.getText().trim();
			if (expectedUnits.contains(actualUnits)) {
				FrameworkLogger.log(LogType.PASS, "Container No Of Units Verification passed : " + actualUnits);
			} else {
				FrameworkLogger.log(LogType.FAIL, "Container No Of Units Verification failed. Expected :" + actualUnits
						+ " , Actual :" + expectedUnits);
			}
		}
		//Verify container cubing weight
		List<WebElement> elementContainerWeights = DriverManager.getDriver().findElements(byContainerWeight);
		String listOfCubingWeight = getDataFromFeature("getdata(ContainerWeights)");
		List<String> expectedWeights= new ArrayList<String>(Arrays.asList(listOfCubingWeight.split(",")));
		for (WebElement e : elementContainerWeights) {
			String actualWeight = e.getText().trim();
			if (expectedWeights.contains(actualWeight)) {
				FrameworkLogger.log(LogType.PASS, "Container Weight Verification passed : " + actualWeight);
			} else {
				FrameworkLogger.log(LogType.FAIL, "Container Weight Verification failed. Expected :" + actualWeight
						+ " , Actual :" + expectedWeights);
			}
		}
		for (int i = 0; i < elements.size(); i++) {
			final By byslider = By.xpath("(//ion-item//slider-actions//button[contains(@data-component-id,'action-closed')])[" + (i + 1) + "]");
			CommonMethods.scrollByParticularElement(byslider, "Inventory Attributes");
			CommonMethods.waitForPageLoading();
			SeleniumActions.click(byslider, "Click on Action closed icon");
			CommonMethods.waitForPageLoading();
			SeleniumActions.click(byView, "Click on View Icon");
			CommonMethods.waitForPageLoading();
			SeleniumActions.click(byOkBtn, "Click on Ok Button");
			CommonMethods.waitForPageLoading();
			SeleniumActions.click(byCloseSliderBtn, "Click on Action closed icon");
			CommonMethods.waitForPageLoading();
		}
	}

		/**
		 * Function to Verify Container size's dimension, maximum weight/quantity are displaying for each container type
		 */
		public static void verifyContainerTypeDetailsForEachContainerTypeId(){
			String cubingValues= getDataFromFeature("getdata(CubingValues)");
			List<String> expectedContainerType = new ArrayList<String>(Arrays.asList(cubingValues.split(",")));

			for (String singleContainerType: expectedContainerType) {
				final By byListOfContainerType = By.xpath("(//*[@title='" + singleContainerType + "'])[1]");

				CommonMethods.waitForPageLoading();
				if (DriverManager.getDriver().findElements(byContainerTextField).size() < 1) {
					SeleniumActions.click(byExpandContainerTypeField, "Expand icon");
				}
				SeleniumActions.getElement(byContainerTextField).clear();
				SeleniumActions.sendTextToElement(byContainerTextField, singleContainerType, "Container Type Text Field");
				CommonMethods.waitForPageLoading();
				KeyboardActions.pressEnterKey(byContainerTextField);
				CommonMethods.waitForPageLoading();
				SeleniumActions.click(byListOfContainerType, "Select the Container Type");
				Cubing.selectViewButton();
				CommonMethods.waitForPageLoading();
				Cubing.selectContainerSizeDefinition();
				CommonMethods.waitForPageLoading();
				if(singleContainerType.equals(getDataFromFeature("getdata(CubingValues1)"))){
					verifyContainerSizeDefinitionDetailsForMultipleContainer();
				}
				HomePage.navigate_Back_to_ContainerType();
				Cubing.verifyContainerTypePage();
				CommonMethods.waitForPageLoading();
			}

		}

	/**
	 * Function to Verify Exterior volume of the Container for Large Box
	 */
	public static void verifyExteriorVolumeOfTheContainerForLargeBox() {
		CommonMethods.scrollByParticularElement(byExteriorVolumeoftheContainer, "Exterior volume of the Container");
		CommonMethods.waitForPageLoading();
		String actualVol = SeleniumActions.getAtrribute(byExteriorVolumeoftheContainer, "value", 10);
		SeleniumActions.verifyTextEquals(actualVol, getDataFromFeature("getdata(ExteriorVolumeoftheContainerForLarge)"), false);
		CommonMethods.waitForPageLoading();
	}
	/**
	 * Function to Verify Exterior volume of the Container for Giant box
	 */
	public static void verifyExteriorVolumeOfTheContainerForGiantox() {
		CommonMethods.scrollByParticularElement(byExteriorVolumeoftheContainer, "Exterior volume of the Container");
		CommonMethods.waitForPageLoading();
		String actualVol = SeleniumActions.getAtrribute(byExteriorVolumeoftheContainer, "value", 10);
		SeleniumActions.verifyTextEquals(actualVol, getDataFromFeature("getdata(ExteriorVolumeoftheContainerForGiant)"), false);
		CommonMethods.waitForPageLoading();
	}
	}

