package stepdefinitions;

import com.dhl.driver.DriverManager;
import com.dhl.reports.FrameworkLogger;
import com.dhl.reports.LogType;
import com.dhl.testdata.TestData_Json;
import com.dhl.utils.GeneralUtils;
import com.dhl.csv.utils.ReadCSV;
import com.dhl.web.utils.KeyboardActions;
import com.dhl.web.utils.SeleniumActions;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import static com.dhl.web.utils.MouseActions.JSExecutor;
import static com.dhl.web.utils.SeleniumActions.getElement;

public class CommonMethods extends TestData_Json {
    private static final By byPleaseWait = By.xpath("//*[contains(text(),'Please Wait')]");
    private static final By byLoading = By.xpath("//*[contains(text(),'Loading')]");
    private static final By byShowingLabel = By.xpath("//span[starts-with(text(), 'Showing')]");

    public static void waitForPageLoading() {
        SeleniumActions.waitForPageLoading();
        GeneralUtils.wait(2000);
        SeleniumActions.setImplicitTimeout(0); //Setting to 0 will check one time only when using FindElement
        if (DriverManager.getDriver().findElements(byPleaseWait).size() > 0) {
            SeleniumActions.explicityWaitTillInvisibilityOfElement(byPleaseWait, 20);
        } else if (DriverManager.getDriver().findElements(byLoading).size() > 0) { SeleniumActions.explicityWaitTillInvisibilityOfElement(byLoading, 20);
        }
        SeleniumActions.setBackFrameworkImplicitTimeout();//Setting back to default framework timeout at framework config
    }

    public static List<String> getColumnValuesFromCsv(String strFilePath, String strColName) {
        List<String> listOfValuesAtCSV = new ArrayList<>();
        try {
            ReadCSV.readAllUsingOpenCsv(strFilePath);
            listOfValuesAtCSV = ReadCSV.getSpecificColumnValues(strColName);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listOfValuesAtCSV;
    }

    /**
     * Function to scroll to particular element
     * by  - the element until which we need to scroll
     * strElementname - name of the element
     */
    // NOTE: Existing framework method is not working, so written this method.
    public static void scrollByParticularElement(By by, String strElementname) {
        try {
            //WebElement eleToScroll = getElement(by);
            WebElement eleToScroll = DriverManager.getDriver().findElement(by);
            JSExecutor().executeScript("arguments[0].scrollIntoView(true);", eleToScroll);
            CommonMethods.waitForPageLoading();
            FrameworkLogger.log(LogType.PASS, "Screen scroll to " + strElementname + " element");
        } catch (ElementNotInteractableException var3) {
            FrameworkLogger.log(LogType.FAIL, "Screen not scroll to " + strElementname + " element");
        } catch (Exception var4) {
            FrameworkLogger.log(LogType.FAIL, "Page scroll to particular element not performed due to " + var4.toString());
        }
    }

    /**
     * Function to uncheck the single check box
     * NOTE: Existing framework method is not working, so written this method.
     */
    public static void uncheckSingleCheckbox(By by, String strCheckBoxName) {
        try {
            WebElement element = getElement(by);
            String status=element.getAttribute("aria-checked");
            if (status.equalsIgnoreCase("true")) {
                SeleniumActions.click(getElement(by), strCheckBoxName);
                FrameworkLogger.log(LogType.PASS, strCheckBoxName+" is unchecked successfully");
                CommonMethods.waitForPageLoading();
            } else {
                FrameworkLogger.log(LogType.PASS, String.format(strCheckBoxName + " checkbox is already unchecked for element \"" + by + "\""));
            }
        } catch (NoSuchElementException var3) {
            FrameworkLogger.log(LogType.FAIL, strCheckBoxName + " element is not found for element \"" + by + "\"");
        }
    }

    /**
     * Function to Verify MatchingCriteria Data Displayed
     */
    public static void verifyMatchingCriteriaDataDisplayed() {
        if (DriverManager.getDriver().findElements(byShowingLabel).size()>0) {
            FrameworkLogger.log(LogType.PASS, "Matching Criteria Data Displayed");
        } else {
            FrameworkLogger.log(LogType.FAIL, "Matching Criteria Data should be Displayed, but No Records Displayed");
        }
    }

    public static void scrollByParticularElement(WebElement element, String strElementname) {
        try {
            JSExecutor().executeScript("arguments[0].scrollIntoView(true);", element);
            CommonMethods.waitForPageLoading();
            FrameworkLogger.log(LogType.PASS, "Screen scroll to " + strElementname + " element");
        } catch (ElementNotInteractableException var3) {
            FrameworkLogger.log(LogType.FAIL, "Screen not scroll to " + strElementname + " element");
        } catch (Exception var4) {
            FrameworkLogger.log(LogType.FAIL, "Page scroll to particular element not performed due to " + var4.toString());
        }
    }

    /**
     * Verification of Actual and Expected values of numeric data
     *
     * @param strActValue - Actual Value
     * @param strExpValue - Expected Value
     * @param operation  - comparision type
     * @return - boolean
     */
    public static boolean verifyValue(String strActValue, String strExpValue, String verificationName, String operation) {
        boolean isTrue = false;
        if(operation.equalsIgnoreCase("GreaterThanOrEqual")){
            if(Integer.parseInt(strActValue)>=Integer.parseInt(strExpValue)){
                isTrue = true;
            }
        }
        if(operation.equalsIgnoreCase("GreaterThan")){
            if(Integer.parseInt(strActValue)>Integer.parseInt(strExpValue)){
                isTrue = true;
            }
        }
        if(operation.equalsIgnoreCase("Equal")){
            if(Integer.parseInt(strActValue)==Integer.parseInt(strExpValue)){
                isTrue = true;
            }
        }
        if (isTrue) {
            FrameworkLogger.log(LogType.PASS,
                    verificationName+ " verification passed. Expected value: " + strExpValue +" "+operation+" Actual Value: "+strActValue);
        } else {
            FrameworkLogger.log(LogType.FAIL,
                    verificationName+ " verification failed. Expected value: " + strExpValue +" NOT "+operation+" Actual Value: "+strActValue);
        }
        return isTrue;
    }

    /**
     * Function for commonSearch
     * @param e1 - element icon which need to be expanded
     * @param e2 - element which need to entered
     * @param strText - value which need to searched
     * @param elementName - name of the element
     */
    public static void commonSearch(By e1, By e2, String strText, String elementName) {
        CommonMethods.waitForPageLoading();
        if (DriverManager.getDriver().findElements(e2).size() < 1) {
            SeleniumActions.click(e1, elementName +" expand icon");
        }
        SeleniumActions.getElement(e2).clear();
        SeleniumActions.sendTextToElement(e2, strText, elementName +" Text field");
        CommonMethods.waitForPageLoading();
        KeyboardActions.pressEnterKey(e2);
        CommonMethods.waitForPageLoading();
    }


    /**
     * Explicitly wait for element to be visible until timeout in seconds
     * @param by         - 'By' for the element
     * @param strEleName - Web element's name
     */
    public static void verifyElementNotVisible(By by, String strEleName) {
        if (DriverManager.getDriver().findElements(by).size()<=0) {
            FrameworkLogger.log(LogType.PASS,
                    strEleName + " is not visible, This is expected.");
        } else {
            FrameworkLogger.log(LogType.FAIL, strEleName + " is visible, This is NOT expected. Element should not visible");
        }
    }

    /**
     * Function for createDuplicateTab
     */
    public static void createDuplicateTab(){
        Actions actions=new Actions(DriverManager.getDriver());
        actions.keyDown(Keys.ALT).sendKeys("d").perform();
        actions.keyDown(Keys.ENTER).perform();
        actions.keyUp(Keys.ALT).keyUp(Keys.ENTER).build().perform();

//        action_chains = ActionChains(driver)
//        action_chains.key_down(Keys.ALT).send_keys('d').perform()
//        action_chains.key_down(Keys.ENTER).perform()
//        action_chains.key_up(Keys.ALT).key_up(Keys.ENTER).perform()
    }

    /**
     * Verification of Actual and Expected value using not contains method
     *
     * @param strActValue - Actual Value
     * @param strExpValue - Expected Value
     * @param ignoreCase  - Boolean (True or False)
     * @return - boolean
     */
    public static boolean verifyTextNotContains(String strActValue, String strExpValue, String verificationName, boolean ignoreCase) {
        boolean isTrue = false;
        if (ignoreCase) {
            if (strActValue.toLowerCase().contains(strExpValue.toLowerCase()))
                isTrue = true;
        } else {
            if (strActValue.contains(strExpValue))
                isTrue = true;
        }
        if (isTrue) {
            FrameworkLogger.log(LogType.FAIL,
                    verificationName+ " verification failed. Expected text \"" + strExpValue + "\" is not contains in actual \"" + strActValue + "\"");

        } else {
            FrameworkLogger.log(LogType.PASS,
                    verificationName+ " verification passed. Expected text \"" + strExpValue + "\" is contains in actual text");
        }
        return isTrue;
    }
    /**
     * Common Wait which waits for
     *
     */
    public static void waitForPageLoadAndToLoadWebElements() {
        SeleniumActions.waitForPageLoading();
        GeneralUtils.wait(2000);
    }
}