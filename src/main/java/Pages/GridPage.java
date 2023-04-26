package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GridPage extends Page {

    private static final String LIST_PRODUCTS_NAMES = "//*[@data-test-id='item-name']";
    private static final String LIST_PRODUCTS_PRICES = "//*[@id='item-price']";
    private static final String LIST_PRODUCTS_IMAGES = "//*[@id='menu']/*/img";
    private static final String LIST_PRODUCTS_BUTTONS = "//*[@data-test-id='add-to-order']";


    public static String getProductName(int index) {
        List<WebElement> itemList = driver.findElements(By.xpath(LIST_PRODUCTS_NAMES));
        return itemList.get(index).getText();
    }

    public static String getProductPrice(int index) {
        List<WebElement> itemList = driver.findElements(By.xpath(LIST_PRODUCTS_PRICES));
        return itemList.get(index).getText();
    }

    public static boolean isAnEmptyItem(List<WebElement> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).getText().equalsIgnoreCase("")) {
                return true;
            }
        }
        return false;
    }

    public static boolean isAnEmptyName() {
        List<WebElement> itemList = driver.findElements(By.xpath(LIST_PRODUCTS_NAMES));
        return isAnEmptyItem(itemList);
    }

    public static boolean isAnEmptyPrice() {
        List<WebElement> itemList = driver.findElements(By.xpath(LIST_PRODUCTS_PRICES));
        return isAnEmptyItem(itemList);
    }


    public static boolean allElementsAreCompleted() {
        int sizenames= driver.findElements(By.xpath(LIST_PRODUCTS_NAMES)).size();
        int sizePrice= driver.findElements(By.xpath(LIST_PRODUCTS_PRICES)).size();
        int sizeImage= driver.findElements(By.xpath(LIST_PRODUCTS_IMAGES)).size();
        int sizeButtons= driver.findElements(By.xpath(LIST_PRODUCTS_BUTTONS)).size();

        if(sizenames==sizePrice&&sizeImage==sizeButtons&&sizenames==sizeButtons&&!isAnEmptyName()&&!isAnEmptyPrice()){
            return true;
        }else{
            return false;
        }

    }


}
