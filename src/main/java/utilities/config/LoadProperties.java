package utilities.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/** Utility class: final = no inheritance, private constructor = no instantiation **/
public final class LoadProperties {
    private static final Properties environmentSetup = loadProperties("src/main/resources/environmentSetUp.properties");
    public static final String URL = environmentSetup.getProperty("URL");
    public static final String BROWSER = environmentSetup.getProperty("Browser");
    public static final String SignInDataPath = environmentSetup.getProperty("SignInDataPath");
    public static final String ContactUSDataPath = environmentSetup.getProperty("ContactUsDataPath");
    public static final String SignUpDataPath = environmentSetup.getProperty("SignUpDataPath");
    public static final String ProductDataPath = environmentSetup.getProperty("ProductDataPath");
    public static final String CheckoutDataPath = environmentSetup.getProperty("CheckoutDataPath");
    public static final String downloadPath = environmentSetup.getProperty("downloadPath");
    //public static final String CartDataPath = environmentSetup.getProperty("CartDataPath");


    private LoadProperties() {
        // Prevent instantiation
    }
    public static Properties loadProperties(String path) {
        Properties pro = new Properties();
        try (FileInputStream stream = new FileInputStream(path)) {
            pro.load(stream);
        } catch (IOException e) {
            System.out.println("Error loading properties file: " + e.getMessage());
        }
        return pro;
    }
    public static String getProperty(String key) {
        return environmentSetup.getProperty(key);
    }
}
