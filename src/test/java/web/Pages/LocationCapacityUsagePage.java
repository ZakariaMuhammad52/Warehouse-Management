package web.Pages;

import com.dhl.reports.FrameworkLogger;
import com.dhl.reports.LogType;
import com.dhl.testdata.TestData_Json;
import com.dhl.utils.CurrentThreadInstance;
import com.dhl.utils.Variables;
import com.dhl.web.utils.SeleniumActions;
import org.openqa.selenium.By;

@SuppressWarnings("unused")
public class LocationCapacityUsagePage extends TestData_Json {
	private static final By byCurrentWeight = By
			.xpath("//span[@data-component-id='CurrentWeight-card-view']");
	private static final By byCurrentVolume = By
			.xpath("//span[@data-component-id='CurrentVolume-card-view']");

	/**
	 * Function to get Current Weight
	 * @return
	 */
	public static String getCurrentWeight() {
		return SeleniumActions.getText(byCurrentWeight).trim();
	}

	/**
	 * Function to get Current Volume
	 * @return
	 */
	public static String getCurrentVolume() {
		return SeleniumActions.getText(byCurrentVolume).trim();
	}

	/**
	 * Function to store CurrentWeight And CurrentVolume From Location
	 */
	public static void storeCurrentWeightAndCurrentVolumeFromLocationPopup(String CurrentWeight, String CurrentVolume ) {
		CommonPage.clickRowAtFirstIndex();
		HeaderPanelPage.clickRelatedLinksButton();
		HeaderPanelPage.clickLocationCapacityUsageLink();
		String	CurrentWeightValue =getCurrentWeight();
		String CurrentVolumeValue =getCurrentVolume();
		FrameworkLogger.log(LogType.INFO,
				"CurrentWeight stored in variable, variable name: " + CurrentWeight + ", variable value: " + CurrentWeightValue);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + CurrentWeight, CurrentWeightValue);
		FrameworkLogger.log(LogType.INFO,
				"CurrentWeight stored in variable, variable name: " + CurrentVolume + ", variable value: " + CurrentVolumeValue);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + CurrentVolume, CurrentVolumeValue);
	}
}
