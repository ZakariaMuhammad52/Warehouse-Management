package web.Pages;

import com.dhl.testdata.TestData_Json;
import com.dhl.utils.CurrentThreadInstance;
import com.dhl.utils.Variables;

import java.util.List;

public class ATSystemDirectedPutAway extends TestData_Json {
    /**
     * Function to complete ATUserDirectedPutAway with single lpn
     * @param lpn - Give generated lpn
     */
    public static void completeATSystemDirectedPutAway(String lpn) {
        CommonWMMobilePage.enterScanContainer(lpn);
        CommonWMMobilePage.clickGoButton();
        String location = CommonWMMobilePage.getLocationText().replaceAll("-", "");
        Variables.set(CurrentThreadInstance.getCurrentScenarioId() + "ScanLocation", location);
        CommonWMMobilePage.enterScanLocation(location);
        CommonWMMobilePage.clickGoButton();
    }

}
