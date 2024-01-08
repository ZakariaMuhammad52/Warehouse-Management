package web.Pages;

import com.dhl.reports.FrameworkLogger;
import com.dhl.reports.LogType;
import com.dhl.testdata.TestData_Json;
import com.dhl.utils.CurrentThreadInstance;
import com.dhl.utils.Variables;
import com.dhl.web.utils.SeleniumActions;
import org.openqa.selenium.By;


@SuppressWarnings("unused")
public class OrderTemplatePage extends TestData_Json {

	private static final By byOrderTemplate_ViewPopup = By.xpath("//div[contains(@class,'textbox')]//input");
	private static final By byEntityID_ViewPopup = By.xpath("//div//input[@data-component-id='EntityId-view-label-display']");
	private static final By byOrderTemplateData = By.xpath("//div[contains(@class,'textarea')]//input");
	private static final By byOriginalOrderHeader = By.xpath("//span[@title='ATOriginalOrderHeader']");
	private static final By byOriginalOrderLine = By.xpath("//span[@title='ATOriginalOrderLIne']");
	private static final By byATOOTSNote = By.xpath("//span[@title='ATOOTSNote']");
	private static final By byATOOUCNote = By.xpath("//span[@title='ATOOUCNote']");
	/**
	 * Function to Store sample data of order template
	 *
	 * @param name - Variable to store the order template
	 */
	public static void storeOrderTemplateSampleData(String name) {
		String value=SeleniumActions.getAtrribute(byOrderTemplateData,"value",10);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + name, value);
		FrameworkLogger.log(LogType.INFO, "Normal Order Template data set to variable: "+name+", value : "+value);
		CommonPopupPage.clickCloseIcon();
	}

	/**
	 * Function to Verify the stored order template and entity
	 *
	 * @param orderTemplateStr - Store Order template in orderTemplateStr variable
	 *  @param  orderTemplateEntity -  Store Entity ID in orderTemplateEntity
	 */
	public static void storeOrderTemplateAndEntityDataAndVerify(String orderTemplateStr, String orderTemplateEntity) {
		String orderTempStr=SeleniumActions.getAtrribute(byOrderTemplate_ViewPopup,"value",10);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + orderTemplateStr, orderTempStr);
		FrameworkLogger.log(LogType.INFO, " Order Template data set to variable: "+orderTemplateStr+", value : "+orderTempStr);
		String orderTempEnty=SeleniumActions.getAtrribute(byEntityID_ViewPopup,"value",10);
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + orderTemplateEntity, orderTempEnty);
		FrameworkLogger.log(LogType.INFO, " Order Template Entity ID set to variable: "+orderTemplateEntity+", value : "+orderTempEnty);
		SeleniumActions.verifyTextEquals(orderTempStr,getDataFromFeature("getdata("+orderTemplateStr+")"));
		SeleniumActions.verifyTextEquals(orderTempEnty,getDataFromFeature("getdata(EntityID)"));
	}

}
