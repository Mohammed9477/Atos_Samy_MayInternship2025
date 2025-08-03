package utilities.commonHelper;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import utilities.config.LoadProperties;
import utilities.driverManger.DriverManger;

import java.io.File;
import java.util.List;

public class AssertionHelper {
    //static String downloadDirectory = LoadProperties.downloadPath;
    static String downloadDirectory = DriverManger.getDownloadPath();
    // Assert element is present and displayed
    public static void assertElementPresent(WebDriver driver, By locator) {
        try {
            boolean isDisplayed = ElementHelper.waitForVisibility(driver, locator).isDisplayed();
            Assert.assertTrue(isDisplayed, "❌ Element not displayed: " + locator);
        } catch (NoSuchElementException e) {
            Assert.fail("❌ Element not found: " + locator);
        }
    }

    // Assert current URL matches expected URL
    public static void assertUrl(WebDriver driver, String expectedUrl) {
        String actualUrl = ElementHelper.getCurrentUrl(driver);
        Assert.assertEquals(actualUrl, expectedUrl,
                "❌ Expected URL: " + expectedUrl + " but found: " + actualUrl);
    }

    // Assert that object is not null
    public static void assertNotNull(Object object, String message) {
        Assert.assertNotNull(object, "❌ " + message);
    }

    // Assert that object is null
    public static void assertNull(Object object, String message) {
        Assert.assertNull(object, "❌ " + message);
    }

    // Assert a condition is true
    public static void assertTrue(boolean condition, String message) {
        Assert.assertTrue(condition, "❌ " + message);
    }

    // Assert a condition is false
    public static void assertFalse(boolean condition, String message) {
        Assert.assertFalse(condition, "❌ " + message);
    }

    // Assert equality for strings with better messages
    public static void assertEqual(String actual, String expected) {
        Assert.assertEquals(actual, expected,
                "❌ Expected: [" + expected + "] but found: [" + actual + "]");
    }
    // Assert equality for numbers
    public static void assertEqual(Number actual, Number expected) {
        Assert.assertEquals(actual, expected,
                "❌ Expected: [" + expected + "] but found: [" + actual + "]");
    }
    // Assert text of a web element matches expected value
    public static void assertElementText(WebDriver driver, By locator, String expectedText) {
        String actualText = ElementHelper.waitForVisibility(driver, locator).getText();
        Assert.assertEquals(actualText.trim(), expectedText.trim(),
                "❌ Text mismatch! Expected: [" + expectedText + "] but found: [" + actualText + "]");
    }
//    public static void assertAllElementsContainKeyword(WebDriver driver, By locator, String keyword) {
//        List<WebElement> elements = ElementHelper.findElements(driver, locator);
//        String normalizedKeyword = keyword.replaceAll("[-\\s]", "").toLowerCase();
//
//        for (WebElement element : elements) {
//            String actualText = element.getText();
//            String normalizedText = actualText.replaceAll("[-\\s]", "").toLowerCase();
//
//            Assert.assertTrue(normalizedText.contains(normalizedKeyword),
//                    "❌ Keyword [" + keyword + "] not found in result: " + actualText);
//        }
//
//        System.out.println("✅ All search results contain the keyword: " + keyword);
//    }
public static void assertAllElementsContainKeyword(WebDriver driver, By productCards, By overlayNameLocator, String keyword) {
    Actions actions = new Actions(driver);
    List<WebElement> cards = ElementHelper.findElements(driver, productCards);
    String normalizedKeyword = keyword.replaceAll("[-\\s]", "").toLowerCase();

    for (WebElement card : cards) {
        actions.moveToElement(card).perform(); // hover to reveal overlay

        WebElement nameElement = card.findElement(overlayNameLocator);
        String actualName = nameElement.getText().trim();
        String normalizedName = actualName.replaceAll("[-\\s]", "").toLowerCase();

        Assert.assertTrue(normalizedName.contains(normalizedKeyword),
                "❌ Product name does not match. Expected keyword [" + keyword + "] but got [" + actualName + "]");
    }

    System.out.println("✅ All hovered overlay product names contain the keyword: " + keyword);
}

 //assert file downloaded successfully
    public static void assertFileExists(String fileName) {
        File file = new File(downloadDirectory + File.separator + fileName);
        int timeoutSeconds = 10;
        int waited = 0;

        while (!file.exists() && waited < timeoutSeconds) {
            try {
                Thread.sleep(1000); // wait 1 sec
                waited++;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        //java.io.File file = new java.io.File(downloadDirectory + "/" + fileName);
        Assert.assertTrue(file.exists() ,
                "❌ File not downloaded: " + fileName + " at path: " + downloadDirectory);
    }

    public static void assertFileExists(String expectedFileName, String extension, int timeoutSeconds, boolean deleteAfter) {
        // Load download path from properties file
        //String downloadDirectory = PropertiesLoader.loadProperty("download.folder.path");

        File downloadDir = new File(downloadDirectory);
        if (!downloadDir.exists()) {
            throw new IllegalArgumentException("Download directory does not exist: " + downloadDirectory);
        }

        File[] files;
        boolean found = false;
        long startTime = System.currentTimeMillis();

        while (System.currentTimeMillis() - startTime < timeoutSeconds * 1000L) {
            files = downloadDir.listFiles();
            if (files == null) break;

            for (File file : files) {
                String name = file.getName();
                boolean isMatching = name.contains(expectedFileName)
                        && name.endsWith(extension)
                        && !name.endsWith(".crdownload");

                if (isMatching) {
                    found = true;
                    if (deleteAfter) {
                        file.delete();
                    }
                    break;
                }
            }

            if (found) break;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Interrupted while waiting for file download", e);
            }
        }

        Assert.assertTrue(found,
                "❌ File not downloaded: " + expectedFileName + extension + " in folder: " + downloadDirectory);
    }

}
