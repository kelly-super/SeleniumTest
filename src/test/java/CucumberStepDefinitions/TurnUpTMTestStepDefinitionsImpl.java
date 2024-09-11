package CucumberStepDefinitions;

import PageObjects.TurnUpHomePage;
import PageObjects.TurnUpLoginPage;
import PageObjects.TurnUpTMPage;
import TestComponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import io.cucumber.datatable.DataTable;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class TurnUpTMTestStepDefinitionsImpl extends BaseTest {

    WebDriver driver;
    TurnUpLoginPage turnUpLoginPage;
    TurnUpHomePage turnUpHomePage;
    TurnUpTMPage turnUpTMPage;
    int item_count=0;

    //initialize the logger
    private static final Logger logger = LogManager.getLogger(TurnUpTMTestStepDefinitionsImpl.class);

    @Given("user login the system with valid credentials")
    public void user_login_the_system_with_valid_credentials() throws IOException {

        logger.info("user login the system with valid credentials");
        String url = getProperties().getProperty("turnup_url");
        driver = initializeDriver();
        driver.navigate().to(url);
        turnUpLoginPage = new TurnUpLoginPage(driver);
        String username = getProperties().getProperty("turnup_username");
        String password = getProperties().getProperty("turnup_password");
        turnUpLoginPage.LoginAction(driver,username,password);

    }
    @Given("I navigate to the Time and Material page")
    public void i_navigate_to_the_time_and_material_page() throws InterruptedException {
        logger.info("I navigate to the Time and Material page");
        turnUpHomePage = new TurnUpHomePage(driver);
        turnUpHomePage.NavigateToTMPage();
        turnUpTMPage = new TurnUpTMPage(driver);

        item_count = turnUpTMPage.getItemCount(driver);
    }
    @When("I click the createNew button and enter the information and save")
    public void i_click_the_create_new_button_and_enter_the_information_and_save(DataTable dataTable) {
        logger.info("I click the createNew button and enter the information and save");
        List<Map<String,String>> infomation = dataTable.asMaps(String.class,String.class);
        String typecode = infomation.get(0).get("typeCode");
        String code = infomation.get(0).get("code");
        String desp = infomation.get(0).get("description");
        String price = infomation.get(0).get("price");
        turnUpTMPage.createNewAction(driver);
        turnUpTMPage.inputNewRecorInfod("create",typecode,code,desp,price);
        turnUpTMPage.SaveNewRecord(driver);
        item_count++;
    }
    @Then("a new record should be created successfully")
    public void a_new_record_should_be_created_successfully(DataTable dataTable) {
        logger.info("a new record should be created successfully");
        List<Map<String,String>> record = dataTable.asMaps(String.class,String.class);
        String recordName = record.get(0).get("record");
        turnUpTMPage.goToTheLastPage(driver);
        String last_code = turnUpTMPage.getTheLastRecordCode(driver);
        Assert.assertEquals(recordName,last_code);
        int current_item_count = turnUpTMPage.getItemCount(driver);
        Assert.assertEquals(current_item_count,item_count);
    }

    @When("I update the information on an existing record")
    public void i_update_the_information_on_an_existing_record() {
        logger.info("I update the information on an existing record");
       // turnUpTMPage = new TurnUpTMPage(driver);
        turnUpTMPage.goToTheLastPage(driver);
        turnUpTMPage.ClickTheLastRecordEditButton(driver);
        turnUpTMPage.inputNewRecorInfod("edit","Test","test","test","$11");
        turnUpTMPage.SaveNewRecord(driver);
    }
    @Then("the record should have the updated information")
    public void the_record_should_have_the_updated_information() {
        logger.info("the record should have the updated information");
        turnUpTMPage.goToTheLastPage(driver);
        int current_item_count = turnUpTMPage.getItemCount(driver);
        String last_code = turnUpTMPage.getTheLastRecordCode(driver);
        Assert.assertEquals("Test",last_code);
        Assert.assertEquals(current_item_count,item_count);
    }

    @When("I delete an existing record")
    public void i_delete_an_existing_record() {
        logger.info("I delete an existing record");
    //    turnUpTMPage= new TurnUpTMPage(driver);
        turnUpTMPage.goToTheLastPage(driver);
        turnUpTMPage.DeleteTheLastRecord(driver);
        --item_count;

    }
    @Then("the record should not be present on the table")
    public void the_record_should_not_be_present_on_the_table() {
        logger.info("the record should not be present on the table");
        turnUpTMPage.clickRefreshButton();
      int current_item_count = turnUpTMPage.getItemCount(driver);
      Assert.assertEquals(current_item_count,item_count);

    }


}
