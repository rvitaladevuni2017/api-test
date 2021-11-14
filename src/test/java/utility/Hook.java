package utility;

import com.relevantcodes.extentreports.ExtentTest;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import static utility.ComplexReportFactory.closeTest;
import static utility.ComplexReportFactory.getTest;


public class Hook {
    private ExtentTest test;

    @Before()
    public void setUp(Scenario scenario) {
        test = getTest(scenario.getName());
    }

    @After
    public void tearDown() {
        closeTest(test);
    }
}
