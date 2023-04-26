package Pages;

import org.openqa.selenium.By;

import java.io.IOException;

import static Utils.Utils.getProperty;

public class SearchPage extends Page{

    private static final String SEARCH_FIELD = "//input[@name='searchWord']";
    private static final String SEARCH_BUTTON = "//button[@type='submit']";
    private static final String MSSG = "result";


    public static void search(String word) {
        driver.findElement(By.xpath(SEARCH_FIELD)).sendKeys(word);
        driver.findElement(By.xpath(SEARCH_BUTTON)).click();
    }

    public static boolean isMessageVisible(String word) {
        return driver.findElement(By.id(MSSG)).isDisplayed() && driver.findElement(By.xpath(MSSG)).getText().contains("Found one result for " + word );
    }



}
