
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import utilities.DriverManger;

public class BaseTest {
    @BeforeTest
    public void init(){
     DriverManger.initiation();
    }


    @AfterTest
    public void tearDown(){
        DriverManger.closeDriver();

    }
}
