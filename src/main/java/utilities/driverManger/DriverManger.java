package utilities.driverManger;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utilities.config.LoadProperties;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class DriverManger {
      static WebDriver driver ;
     // get it from properities file
      static String BrowserName= LoadProperties.BROWSER;
      static String URL=LoadProperties.URL;
      static ChromeOptions options = new ChromeOptions();
      private static final String downloadPath = System.getProperty("user.home") + File.separator + "Downloads";

    public  static  void initiation() {

        if (BrowserName.trim().equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            //String downloadPath = System.getProperty("Mohamed Samy") + File.separator + "downloads";
            File downloadDir = new File(downloadPath);
            if (!downloadDir.exists()) downloadDir.mkdir();

//            Map<String, Object> prefs = new HashMap<>();
//
//            prefs.put("profile.default_content_settings.popups", 0);
//            prefs.put("download.directory_upgrade", true);
//            prefs.put("download.default_directory", downloadPath);
//            prefs.put("download.prompt_for_download", false);
//
//            prefs.put("credentials_enable_service", false);
//            // safe browsing
//            prefs.put("safebrowsing.enabled", "false");
//
//            prefs.put("profile.password_manager_enabled", false);

            //options.setExperimentalOption("prefs", prefs);

            //options.addArguments("--incognito");
            options.setExperimentalOption("prefs", getChromePrefs(downloadPath));
            //options.addArguments("--incognito");
            driver = new ChromeDriver(options);
            /// //////////////////


        } else if (BrowserName.trim().equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (BrowserName.trim().equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else if (BrowserName.trim().equalsIgnoreCase("remote")) {

  //      driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"));
        }else{
            System.out.print(" browser name not correct!!");
        }
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    public  static WebDriver  getDriver(){
        if (driver==null){
            initiation();
        }
        return driver;
    }
    public static String getDownloadPath() {
        return downloadPath;
    }
    // Inside DriverManager.java

    private static Map<String, Object> getChromePrefs(String downloadPath) {
        File downloadDir = new File(downloadPath);
        if (!downloadDir.exists()) downloadDir.mkdir();

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_settings.popups", 0);
        prefs.put("download.directory_upgrade", true);
        prefs.put("download.default_directory", downloadPath);
        prefs.put("download.prompt_for_download", false);
        prefs.put("credentials_enable_service", false);
        prefs.put("safebrowsing.enabled", "false");
        prefs.put("profile.password_manager_enabled", false);

        return prefs;
    }

    public static  void  closeDriver(){
        driver.quit();
    }
}
