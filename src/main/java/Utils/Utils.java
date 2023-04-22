package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Utils {

    public static String getProperty(String propertyName) throws IOException {
        Properties propiedades = new Properties();
        propiedades.load(new FileReader("src/main/resources/data.properties"));
        return propiedades.getProperty(propertyName);
    }

    public static void waitToElementById(WebDriver driver, int timeoutInSeconds, String locator) throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
    }

    public static void waitToElementByXpath(WebDriver driver, int timeoutInSeconds, String locator) throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

}
