package CucumberStepDefinitions;

import PageObjects.TurnUpHomePage;
import PageObjects.TurnUpLoginPage;
import TestComponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

public class TurnUpLoginTestStepDefinitionsImpl extends BaseTest {

    TurnUpLoginPage turnUpLoginPage;
    TurnUpHomePage turnUpHomePage;
    WebDriver driver;
    String turnup_username;
    //initilize the logger
    private static final Logger logger = LogManager.getLogger(TurnUpLoginTestStepDefinitionsImpl.class);

    @Given("the user navigates to the login page")
    public void the_user_navigates_to_the_login_page() throws IOException {
        logger.info("the user navigates to the login page");
        driver = initializeDriver();
        String url = getProperties().getProperty("turnup_url");
        System.out.println("url = "+ url);
        driver.navigate().to(url);

    }
    @When("user enters valid credentials and click the login button")
    public void user_enters_valid_credentials_and_click_the_login_button() throws IOException {
        logger.info("user enters valid credentials and click the login button");
        turnup_username = getProperties().getProperty("turnup_username");
        String turnup_password = getProperties().getProperty("turnup_password");
        turnUpLoginPage = new TurnUpLoginPage(driver);
        turnUpLoginPage.LoginAction(driver,turnup_username,turnup_password);

    }
    @Then("the user should be redirected to the homepage")
    public void the_user_should_be_redirected_to_the_homepage() {

        turnUpHomePage = new TurnUpHomePage(driver);
        String message =turnUpHomePage.getSuccessMessage();
        if(!message.contains(turnup_username)){
            logger.info(turnup_username +"login failed");
            Assert.fail();
        }
        logger.info("test pass");
    }

}
