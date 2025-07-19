package utilities;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name = "usersData")
    public Object[][] usersData() {
        return CSVReader.readCSV("src/main/resources/usersData.csv");
    }
}
