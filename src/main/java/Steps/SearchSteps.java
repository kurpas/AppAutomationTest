package Steps;

import Pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.io.IOException;

import static Pages.CheckoutPage.CompleteAllTheFields;
import static Pages.CheckoutPage.alertIsVisible;
import static Pages.Page.closeBrowser;
import static Pages.SearchPage.isMessageVisible;
import static Pages.SearchPage.search;
import static Utils.Utils.getProperty;

public class SearchSteps {

    @Given("The user is search page")
    public void theClientIsInCheckoutPage() throws IOException {
        LoginPage.goToChallenge(getProperty("challenge.Search.url"));
    }

    @When("The user search result for Automation")
    public void theUserSearch() throws IOException {
        search(getProperty("search.criteria"));
    }

    @Then("The user sees the message for Automation results")
    public void theUserSeeAlertIsGone() throws IOException {
        Assert.assertTrue(isMessageVisible(getProperty("search.criteria")));
        closeBrowser();
    }

}
