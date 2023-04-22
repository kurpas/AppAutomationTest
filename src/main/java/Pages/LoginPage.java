package Pages;

import org.openqa.selenium.By;
import java.io.IOException;

import static Utils.Utils.*;

public class LoginPage extends Page {
    private static final String USER_FIELD_LOGIN = "user-name";
    private static final String PASS_FIELD_LOGIN = "password";
    private static final String LOGIN_BUTTON = "login-button";
    private static final String MESSAGE_ERROR_LOGIN = "//div[@class='error-message-container error']";


    public static void login() throws IOException {
        waitToElementById(driver, 10, USER_FIELD_LOGIN);
        fillUserAndPass(getProperty("saucedemo.user"), getProperty("saucedemo.pass"));
        clickOnLoginButton();
    }

    public static void clickOnLoginButton() {
        driver.findElement(By.id(LOGIN_BUTTON)).click();
    }

    public static void fillUserAndPass(String user, String pass) {
        //fill user
        driver.findElement(By.id(USER_FIELD_LOGIN)).sendKeys(user);
        //fill password
        driver.findElement(By.id(PASS_FIELD_LOGIN)).sendKeys(pass);
    }

    public static void goToSaucedemo() throws IOException {
        goToUrl(getProperty("saucedemo.url"));
    }

    public static boolean isTheErrorLoginVisible() {
        try {
            waitToElementByXpath(driver, 10, MESSAGE_ERROR_LOGIN );
            driver.findElement(By.xpath(MESSAGE_ERROR_LOGIN)).isDisplayed();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public static void loginWithInvalidCredencials() throws IOException {
        waitToElementById(driver, 10, USER_FIELD_LOGIN);
        fillUserAndPass(getProperty("saucedemo.user")+"string", getProperty("saucedemo.pass")+"string");
        clickOnLoginButton();
    }

}
