package Steps;

import Pages.LoginPage;
import Pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.io.IOException;

import static Pages.Page.closeBrowser;
import static Utils.Utils.getProperty;

public class LoginSteps {

    @Given("The user is login page")
    public void theClientIsInLoginPage() throws IOException {
        LoginPage.goToChallenge(getProperty("challenge.Login.url"));
    }

    @When("The user logs in")
    public void theUserLogin() throws IOException {
        LoginPage.login();
    }

    @When("The user enter wrong username and password")
    public void theUserTryInvalidate() throws IOException {
        LoginPage.loginWithInvalidCredencials();
    }


    @When("The user leaves the user and password fields blank")
    public void theUserTryBlank() throws IOException {
        LoginPage.loginWithBlanks();
    }

    @Then("The user is logged in")
    public void theUserIsLoggedIn() throws IOException {
        Assert.assertTrue(HomePage.isTheUserLoggedIn());
        closeBrowser();
    }

    @Then("The user see a error message")
    public void theUserSeeAErrorMessage() throws IOException {
        Assert.assertTrue(LoginPage.isTheErrorLoginVisible());
        closeBrowser();
    }



}
