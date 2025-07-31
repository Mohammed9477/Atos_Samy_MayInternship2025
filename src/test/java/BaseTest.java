import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utilities.driverManger.DriverManger;

public class BaseTest {

    @BeforeSuite
    public void initSuite() {
        DriverManger.initiation();  // Launch browser once before all tests
    }

    @AfterSuite
    public void tearDownSuite() {
        DriverManger.closeDriver(); // Quit browser after all tests
    }
}
