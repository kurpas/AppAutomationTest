package Pages;

import org.openqa.selenium.By;

import static Utils.Utils.waitToElementByXpath;

public class ProductsPage extends Page{
    private static final String PRODUCTS_TITLE = "//span[@class='title']";

    public static boolean isTheNewElementVisible() {
        try {
            waitToElementByXpath(driver, 10, PRODUCTS_TITLE );
            driver.findElement(By.xpath(PRODUCTS_TITLE)).isDisplayed();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
