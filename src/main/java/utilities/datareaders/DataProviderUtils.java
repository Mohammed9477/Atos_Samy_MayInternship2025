package utilities.datareaders;
import org.testng.annotations.DataProvider;
import utilities.config.LoadProperties;
import java.io.IOException;
import java.util.Iterator;
import java.util.Locale;

public class DataProviderUtils {
    static String signInDataFilePath = LoadProperties.SignInDataPath;
    static String contactUsDataFilePath = LoadProperties.ContactUSDataPath;
    static String signUpDataFilePath = LoadProperties.SignUpDataPath;
    static String productDataFilePath = LoadProperties.ProductDataPath;
    static String checkoutDataFilePath = LoadProperties.CheckoutDataPath;
    public static final String ContactUSDataPath = "src/test/resources/contactUs.json";
    static final String name = "signinData";
    @DataProvider(name = name)
    public static Iterator<Object[]> signinData() throws IOException {
        signInDataFilePath = validateFilePath(signInDataFilePath);
        return readData(signInDataFilePath);
    }


    @DataProvider(name = "contactusData")
    public static Iterator<Object[]> contactusData() throws IOException {
        return readData(validateFilePath(ContactUSDataPath));
    }

    @DataProvider(name = "paymentData")
    public static Iterator<Object[]> paymentData() throws IOException {
        return readData(validateFilePath(checkoutDataFilePath));
    }


    @DataProvider(name = "signUpData")
    public static Iterator<Object[]> signUpData() throws IOException {
        return readData(validateFilePath(signUpDataFilePath));
    }


    @DataProvider(name = "productData")
    public static Iterator<Object[]> productData() throws IOException {
        return readData(validateFilePath(productDataFilePath));
    }


    private static String validateFilePath(String filePath) {
        if (filePath == null || filePath.isEmpty()) {
            throw new IllegalArgumentException("File path cannot be null or empty");
        }
        return filePath.toLowerCase(Locale.ROOT);
    }


    private static Iterator<Object[]> readData(String filePath) throws IOException {
        if (filePath.endsWith(".csv")) {
            return CSVReaderUtil.readCSV(filePath);
        } else if (filePath.endsWith(".xlsx")) {
            return ExcelReaderUtil.readExcel(filePath);
        } else if (filePath.endsWith(".json")) {
            return JSONReaderUtil.readJson(filePath);
        } else {
            throw new IllegalArgumentException("Unsupported file format: " + filePath);
        }
    }


    private static Iterator<Object[]> readJsonData(String filePath) throws IOException {
        return JSONReaderUtil.readJson(validateFilePath(filePath));
    }
}