package Steps;

import Pages.LoginPage;
import Pages.ProductsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.jodah.failsafe.internal.util.Assert;

import java.io.IOException;

public class LoginSteps {

    @Given("The user is in Sauce demo")
    public void theClientIsInSauceDemoPage() throws IOException {
        LoginPage.goToSaucedemo();
    }

    @When("The user login")
    public void theUserLogin() throws IOException {
        LoginPage.login();
    }

    @When("The user try to login")
    public void theUserTryToLogin() throws IOException {
        LoginPage.loginWithInvalidCredencials();
    }

    @Then("The user is logged in")
    public void theUserIsLoggedIn() throws IOException {
        Assert.isTrue(ProductsPage.isTheNewElementVisible(), "the products page title is not visible");
        LoginPage.closeBrowser();
    }

    @Then("The user see a error message")
    public void theUserSeeAErrorMessage() throws IOException {
        Assert.isTrue(LoginPage.isTheErrorLoginVisible(), "the error message is not visible");
        LoginPage.closeBrowser();
    }


}
