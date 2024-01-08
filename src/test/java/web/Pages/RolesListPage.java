package web.Pages;

import com.dhl.reports.FrameworkLogger;
import com.dhl.reports.LogType;
import com.dhl.testdata.TestData_Json;
import com.dhl.utils.CurrentThreadInstance;
import com.dhl.utils.Variables;
import com.dhl.web.utils.SeleniumActions;
import org.openqa.selenium.By;

@SuppressWarnings("unused")
public class RolesListPage extends TestData_Json {

	private static final By byRoleId= By.xpath("//span[@data-component-id='RoleId']");

	/**
	 * Function to store RoleId
	 */
	public static void storeRoleId(String name) {
		String roleId= SeleniumActions.getText(byRoleId).trim();
		Variables.set(CurrentThreadInstance.getCurrentScenarioId() + name, roleId);
		FrameworkLogger.log(LogType.INFO, "Set value for "+name +": "+ roleId);
	}

}