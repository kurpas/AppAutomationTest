package Pages;

import org.openqa.selenium.By;

import static Utils.Utils.getProperty;
import static Utils.Utils.waitToElementByXpath;

public class HomePage extends Page{
    private static final String WELCOME_TITLE = "//h2[contains(text(),'Welcome!')]";
    private static final String WELCOME_USERNAME = "//p[contains(text(),'%')]";

    public static boolean isTheUserLoggedIn() {
        try {
            waitToElementByXpath(driver, 10, WELCOME_TITLE );
            driver.findElement(By.xpath(WELCOME_USERNAME.replace("%",getProperty("challenge.user")))).isDisplayed();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
