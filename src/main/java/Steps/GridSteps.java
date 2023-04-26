package Steps;

import Pages.HomePage;
import Pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import java.io.IOException;

import static Pages.GridPage.*;
import static Pages.Page.closeBrowser;
import static Utils.Utils.getProperty;

public class GridSteps {

    @Given("The user is grid page")
    public void theClientIsInLoginPage() throws IOException {
        LoginPage.goToChallenge(getProperty("challenge.Grid.url"));
    }

    @Then("The user see the position 7 is Super Pepperoni")
    public void theUserseeSuperPepperoni() throws IOException {
        Assert.assertTrue(getProductName(6).equalsIgnoreCase("Super Pepperoni"));
    }

    @Then("The user see the position 7 price is 10")
    public void theUserseePrice() throws IOException {
        Assert.assertTrue(getProductPrice(6).equalsIgnoreCase("$10"));
        closeBrowser();
    }

    @Then("The user sees all completed products")
    public void theUserseeCompleted() throws IOException {
        Assert.assertTrue(allElementsAreCompleted());
        closeBrowser();
    }







}
