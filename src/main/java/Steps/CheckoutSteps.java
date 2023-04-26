package Steps;

import Pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import java.io.IOException;

import static Pages.CheckoutPage.*;
import static Pages.Page.closeBrowser;
import static Utils.Utils.getProperty;

public class CheckoutSteps {

    @Given("The user is checkout page")
    public void theClientIsInCheckoutPage() throws IOException {
        LoginPage.goToChallenge(getProperty("challenge.Checkout.url"));
    }

    @When("The user completes all the checkout fields")
    public void theUserCompleteAll() throws IOException {
        CompleteAllTheFields();
    }


    @When("uncheckmark the checkbox same address")
    public void uncheckmarCheckbox() throws IOException {
        if (isCheckBoxSelected()){
            clickOnCheckBox();
        }
    }

    @When("checkmark the checkbox same address")
    public void checkmarCheckbox() throws IOException {
        if (!isCheckBoxSelected()){
            clickOnCheckBox();
        }
    }

    @When("The user submit the form")
    public void theUserSubmit() throws IOException {
        clickOnSubmitButton();
    }

    @When("The user accept the alert")
    public void theUserAcceptTheAlert() throws IOException {
        acceptTheAlert();
    }


    @Then("The user see that the order confirmation number is not empty")
    public void theUserSeeAOrderConfirmation() throws IOException {
        Assert.assertNotNull(getOrderNumber(), "the order is empty");
        closeBrowser();
    }

    @Then("The user see that the alert is gone")
    public void theUserSeeAlertIsGone() throws IOException {
        Assert.assertFalse(alertIsVisible());
        closeBrowser();
    }

    @Then("The user see cart total is correct")
    public void theUserSeeTotalCart() throws IOException {
        Assert.assertTrue(totalAndItemPriceAretheSame());
        closeBrowser();
    }


}
