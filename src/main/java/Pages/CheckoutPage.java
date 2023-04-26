package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

import static Utils.Utils.getProperty;

public class CheckoutPage extends Page{

    private static final String FULL_NAME_CHECKOUT = "fname";
    private static final String EMAIL_CHECKOUT = "email";
    private static final String ADRESS_CHECKOUT = "adr";
    private static final String CITY_CHECKOUT = "city";
    private static final String STATE_CHECKOUT = "state";
    private static final String ZIP_CHECKOUT = "zip";
    private static final String NAME_ON_CARD_CHECKOUT = "cname";
    private static final String CREDIT_CARD_NUMBER_CHECKOUT = "ccnum";
    private static final String EXP_MONTH_CHECKOUT = "expmonth";
    private static final String EXP_MONTH_CHECKOUT_OPTION = "//option[contains(text(),'%')]";
    private static final String EXP_YEAR_CHECKOUT = "expyear";
    private static final String CVV_CHECKOUT = "cvv";
    private static final String CHECKBOX_SAME_AS_BILLING_CHECKOUT = "//input[@name='sameadr']";
    private static final String SUBMIT_BUTTON = "//button[contains(text(),'Continue to checkout')]";
    private static final String ORDER_NUMBER = "//P[@data-id='ordernumber']";

    private static final String LIST_ITEMS = "//html/body/div[2]/div[2]/div/p";


    public static void CompleteAllTheFields() throws IOException {
        driver.findElement(By.id(FULL_NAME_CHECKOUT)).sendKeys(getProperty("checkout.fullName"));
        driver.findElement(By.id(EMAIL_CHECKOUT)).sendKeys(getProperty("checkout.email"));
        driver.findElement(By.id(ADRESS_CHECKOUT)).sendKeys(getProperty("checkout.address"));
        driver.findElement(By.id(CITY_CHECKOUT)).sendKeys(getProperty("checkout.city"));
        driver.findElement(By.id(STATE_CHECKOUT)).sendKeys(getProperty("checkout.state"));
        driver.findElement(By.id(ZIP_CHECKOUT)).sendKeys(getProperty("checkout.zip"));
        driver.findElement(By.id(NAME_ON_CARD_CHECKOUT)).sendKeys(getProperty("checkout.nameOnCard"));
        driver.findElement(By.id(CREDIT_CARD_NUMBER_CHECKOUT)).sendKeys(getProperty("checkout.creditCardNumber"));
        driver.findElement(By.id(EXP_MONTH_CHECKOUT)).click();
        driver.findElement(By.xpath(EXP_MONTH_CHECKOUT_OPTION.replace("%",getProperty("checkout.expMonth")))).click();
        driver.findElement(By.id(EXP_YEAR_CHECKOUT)).sendKeys(getProperty("checkout.expYear"));
        driver.findElement(By.id(CVV_CHECKOUT)).sendKeys(getProperty("checkout.cvv"));
    }


    public static boolean isCheckBoxSelected()  {
        return driver.findElement(By.xpath(CHECKBOX_SAME_AS_BILLING_CHECKOUT)).isSelected();
    }

    public static void clickOnCheckBox()  {
        driver.findElement(By.xpath(CHECKBOX_SAME_AS_BILLING_CHECKOUT)).click();
    }

    public static void clickOnSubmitButton(){
        driver.findElement(By.xpath(SUBMIT_BUTTON)).click();
    }

    public static String getOrderNumber(){
        try {
            String[] order = driver.findElement(By.xpath(ORDER_NUMBER)).getText().split(":");
            return order[1].trim();
        }catch (Exception ex){
            return null;
        }
    }

    public static void acceptTheAlert(){
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public static String getAlertText(){
        try {
            Alert alert = driver.switchTo().alert();
            return alert.getText();
        }catch (Exception ex){
            return null;
        }
    }

    public static boolean alertIsVisible(){
       if(getAlertText()!=null){
           return true;
       }else{
           return false;
       }
    }



    public static boolean totalAndItemPriceAretheSame(){
        List<WebElement> list = driver.findElements(By.xpath(LIST_ITEMS));
        int sizeList = list.size();
        int total;
        int suma=0;
        int sizeItem =0;
        String price[];

        for (int i=0; i<sizeList-1; i++){
            sizeItem = list.get(i).getText().length();
            price =list.get(i).getText().split("\\$");
            suma = suma + Integer.parseInt(price[1]);
        }
        total = Integer.parseInt(list.get(sizeList-1).getText().split("\\$")[1]);
        if (total == suma){
            return true;
        }else{
            return false;
        }
    }




    }
