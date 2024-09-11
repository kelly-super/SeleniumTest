package CucumberStepDefinitions;
import PageObjects.*;
import TestComponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

public class EndToEndTestStepDefinitionsImpl extends BaseTest {
    public LoginPage loginPage;
    public ProductCatalogue productCatalogue;
    public ConfirmationPage confirmationPage;
    @Given("I landed on Ecommerce page")
    public void I_Landed_on_Ecommerce_page() throws IOException {
        loginPage = launchApplication();
    }

    @Given("^Logged in with username (.+) and password (.+)$")
    public void logged_id_username_and_password(String username,String password){
        productCatalogue = loginPage.loginFeacture(username,password);
    }
    @When("^I add product (.+) to Cart$")
    public void I_add_product_to_Cart(String produceName) throws InterruptedException {
        List<WebElement> products = productCatalogue.getProductList();
        productCatalogue.addProductToCart(produceName);

    }

    @When("^Checkout (.+) and submit the order")
    public void checkout_submit_order(String productName){
       /* CartPage cartPage = productCatalogue.goToCart();
        Boolean match = cartPage.VerifyProductDisplay(productName);
        Assert.assertTrue(match);
        CheckoutPage checkoutPage = cartPage.goToCheckout();
        checkoutPage.setSelectCountry("india");
        confirmationPage = checkoutPage.submitOrder();*/
    }

   @Then("{string} message is displayed on the confirmation page")
    public void message_displayed_confirmationPage(String message){
       String confirmMessage = confirmationPage.verifyConfirmationMessage();
       Assert.assertEquals(confirmMessage,"THANKYOU FOR THE ORDER.");
   }
}