package web.Pages;

import com.dhl.reports.FrameworkLogger;
import com.dhl.reports.LogType;
import com.dhl.testdata.TestData_Json;
import com.dhl.utils.CurrentThreadInstance;
import com.dhl.utils.Variables;
import com.dhl.web.utils.SeleniumActions;
import org.openqa.selenium.By;


@SuppressWarnings("unused")
public class ItemTemplatePage extends TestData_Json {
	private static final By byNormalItemTemplate = By.xpath("//span[@title='NORMAL']");
	private static final By byItemTemplateData = By.xpath("//div[contains(@class,'textarea')]//input");
	private static final By byBatchTRKItemTemplate = By.xpath("//span[@title='BATCHTRK']");
	private static final By bySerialTRKItemTemplate = By.xpath("//span[@title='SERIALTRK']");

	/**
	 * Function to store item template data
	 */
	public static void storeItemTemplateData(String name) {
		String value=SeleniumActions.getAtrribute(byItemTemplateData,"value",10);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + name, value);
		FrameworkLogger.log(LogType.INFO, "Item Template data set to variable: "+name+", value : "+value);
		CommonPopupPage.clickCloseIcon();
	}
}
