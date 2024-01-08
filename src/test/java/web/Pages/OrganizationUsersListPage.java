package web.Pages;

import com.dhl.testdata.TestData_Json;
import com.dhl.web.utils.SeleniumActions;
import org.openqa.selenium.By;
import stepdefinitions.CommonMethods;

@SuppressWarnings("unused")
public class OrganizationUsersListPage extends TestData_Json {

	private static final By byRoles= By.xpath("//button[@data-component-id='Roles']//img");

	/**
	 * Function to click CloseIcon For PrimaryOrganizationId
	 */
	public static void clickCloseIconForPrimaryOrganizationId() {
		String id = getDataFromFeature("getdata(PrimaryOrganizationId)");
		CommonMethods.scrollByParticularElement(By.xpath("//form[@id='wizardForm']//span[@title='"+id+"']//ancestor::div[contains(@class,'dm-flex-col-layout')]//following-sibling::slider-actions[1]//button"), "CloseIcon For PrimaryOrganizationId");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(By.xpath("//form[@id='wizardForm']//span[@title='"+id+"']//ancestor::div[contains(@class,'dm-flex-col-layout')]//following-sibling::slider-actions[1]//button"), "CloseIcon For PrimaryOrganizationId");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to click Roles
	 */
	public static void clickRoles() {
		SeleniumActions.click(byRoles, "Roles");
		CommonMethods.waitForPageLoading();
	}

}