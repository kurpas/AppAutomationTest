package Pages;

import org.openqa.selenium.By;

import java.io.IOException;

import static Utils.Utils.*;

public class SearchPage extends Page{

    private static final String SEARCH_FIELD = "//input[@name='searchWord']";
    private static final String SEARCH_BUTTON = "//button[@type='submit']";
    private static final String MSSG = "result";
    private static final String MSSG2 = "//p[contains(text(),'%')]";


    public static void search(String word) {
        driver.findElement(By.xpath(SEARCH_FIELD)).sendKeys(word);
        driver.findElement(By.xpath(SEARCH_BUTTON)).click();
    }

    public static boolean isMessageVisible(String word) throws IOException {
        waitToElementByXpath(driver, 10, MSSG2.replace("%",getProperty("search.criteria")));
        return driver.findElement(By.id(MSSG)).isDisplayed() && driver.findElement(By.id(MSSG)).getText().contains("Found one result for " + word );
    }

    public static boolean isMessageProvideWordVisible() throws IOException {
        waitToElementByXpath(driver, 10, MSSG2.replace("%","Please provide a search word."));
        return driver.findElement(By.xpath(MSSG2.replace("%","Please provide a search word."))).isDisplayed() ;
    }

}
