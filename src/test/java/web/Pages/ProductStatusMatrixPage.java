package web.Pages;

import com.dhl.testdata.TestData_Json;
import com.dhl.web.utils.SeleniumActions;
import org.openqa.selenium.By;
import stepdefinitions.CommonMethods;

@SuppressWarnings("unused")
public class ProductStatusMatrixPage extends TestData_Json {

	private static final By byRole= By.xpath("//mat-select[@placeholder='Role']");
	private static final By byMove1= By.xpath("//td[3][contains(text(),'A')]//following-sibling::td[1][contains(text(),'D')]");
	private static final By byMove2= By.xpath("//td[3][contains(text(),'D')]//following-sibling::td[1][contains(text(),'I')]");
	private static final By byMove3= By.xpath("//td[3][contains(text(),'D')]//following-sibling::td[1][contains(text(),'A')]");

	/**
	 * Function to select Role
	 * @param role - role to select
	 */
	public static void selectRole(String role) {
		SeleniumActions.click(byRole, "Role dropdown");
		CommonMethods.waitForPageLoading();
		SeleniumActions.click(By.xpath("//span[contains(text(),'"+role+"')]"), "Role ID");
		CommonMethods.waitForPageLoading();
	}

	/**
	 * Function to verify User Has ValidMoves
	 */
	public static void verifyUserHasValidMoves() {
		SeleniumActions.verifyElementVisible(byMove1,10, "Move1");
		SeleniumActions.verifyElementVisible(byMove2,10, "Move2");
		CommonMethods.verifyElementNotVisible(byMove3, "Move3");
	}
}