package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;
import java.sql.DriverManager;

public class Page {
    /**
     * In this case, having only one Page is not worth it, but when you have more pages, you can use this base class to inherit useful methods common to all
     */

    static WebDriver driver = null;

    public static void goToUrl(String url) throws IOException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    public static void closeBrowser() throws IOException {
        driver.quit();
    }
}
