package Steps;

import Pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.io.IOException;

import static Pages.Page.closeBrowser;
import static Pages.SearchPage.*;
import static Utils.Utils.getProperty;

public class SearchSteps {

    @Given("The user is search page")
    public void theClientIsInSearchPage() throws IOException {
        LoginPage.goToChallenge(getProperty("challenge.Search.url"));
    }

    @When("The user search result for Automation")
    public void theUserSearch() throws IOException {
        search(getProperty("search.criteria"));
    }

    @When("The user presses search without entering any search criteria")
    public void theUserSearchBlank() throws IOException {
        search("");
    }



    @Then("The user sees the message for Automation results")
    public void theUserSeeAlertIsGone() throws IOException {
        Assert.assertTrue(isMessageVisible(getProperty("search.criteria")));
        closeBrowser();
    }

    @Then("The user sees the message Please provide a search word")
    public void theUserSeeProvideWord() throws IOException {
        Assert.assertTrue(isMessageProvideWordVisible());
        closeBrowser();
    }

}
