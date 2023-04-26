package Pages;

import org.openqa.selenium.By;
import java.io.IOException;

import static Utils.Utils.*;

public class LoginPage extends Page {
    private static final String USER_FIELD_LOGIN = "username";
    private static final String PASS_FIELD_LOGIN = "password";
    private static final String LOGIN_BUTTON = "signin-button";
    private static final String MESSAGE_ERROR_LOGIN_WRONG_OR_BLANK = "//h2[@id='message']";


    public static void login() throws IOException {
        waitToElementById(driver, 10, USER_FIELD_LOGIN);
        fillUserAndPass(getProperty("challenge.user"), getProperty("challenge.pass"));
        clickOnSignInButton();
    }

    public static void clickOnSignInButton() {
        driver.findElement(By.id(LOGIN_BUTTON)).click();
    }

    public static void fillUserAndPass(String user, String pass) {
        //fill user
        driver.findElement(By.id(USER_FIELD_LOGIN)).sendKeys(user);
        //fill password
        driver.findElement(By.id(PASS_FIELD_LOGIN)).sendKeys(pass);
    }

    public static void goToChallenge(String path) throws IOException {
        goToUrl(getProperty("challenge.Base.url") + path);
    }

    public static boolean isTheErrorLoginVisible() {
        try {
            waitToElementByXpath(driver, 10, MESSAGE_ERROR_LOGIN_WRONG_OR_BLANK );
            driver.findElement(By.xpath(MESSAGE_ERROR_LOGIN_WRONG_OR_BLANK)).isDisplayed();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public static void loginWithInvalidCredencials() throws IOException {
        waitToElementById(driver, 10, USER_FIELD_LOGIN);
        fillUserAndPass(getProperty("challenge.user")+"string", getProperty("challenge.pass")+"string");
        clickOnSignInButton();
    }

    public static void loginWithBlanks() throws IOException {
        waitToElementById(driver, 10, USER_FIELD_LOGIN);
        clickOnSignInButton();
    }

}
