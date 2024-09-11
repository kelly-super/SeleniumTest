package PageObjects;


import Utilites.Wait;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TurnUpTMPage extends Wait {
    WebDriver driver;
    public TurnUpTMPage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[contains(text(),'Create New')]")
    WebElement cteateNew_button;
    @FindBy(xpath="//span[@class='k-dropdown-wrap k-state-default']")
    WebElement typeCodeDropdown;
    @FindBy(id="Code")
    WebElement codeTextbox;
    @FindBy(id="Description")
    WebElement descriptionTextbox;
    @FindBy(css="input[type='text'].k-formatted-value.k-input")
    WebElement priceTagOverlap;
    @FindBy(id="Price")
    WebElement priceTextbox;
    @FindBy(xpath="//span[contains(text(),'Go to the last page')]")
    WebElement goTolastPage;

    /*
    * To locate the edit/delete in the last row of the table, we can use xpath and css selector methed
    * xpath: WebElement editButton = driver.findElement(By.xpath("//table/tbody/tr[last()]/td/a[contains(@class, 'k-grid-Edit')]"));
    * css Selector: WebElement editButton = driver.findElement(By.cssSelector("table tbody tr:last-child a.k-grid-Edit"));
     */
    @FindBy(xpath="//table/tbody/tr[last()]/td/a[contains(@class, 'k-grid-Edit')]")
    WebElement lastRecordEditButton;
    @FindBy(xpath="//table/tbody/tr[last()]/td/a[contains(@class, 'k-grid-Delete')]")
    WebElement lastRecordDeleteButton;

    @FindBy(id="SaveButton")
    WebElement saveButton;

    /*To locate the element containing the text"1 - 10 of 1841 items",
    * we can use different stragegies with selenium such as By.className, By.xpath or By.cssSelector
    * By className: WebElement pagerInfo = driver.findElement(By.className("k-pager-info"));
    * By xpath: WebElement pagerInfo = driver.findElement(By.xpath("//span[contains(@class, 'k-pager-info')]"));
    * By cssSelector: WebElement pagerInfo = driver.findElement(By.cssSelector("span.k-pager-info.k-label"));
     */
    @FindBy(xpath="//span[contains(@class,'k-pager-info')]")
    WebElement item_count;

    @FindBy(xpath="//a[contains(@class,'k-pager-refresh')]")
    WebElement refresh_button;

    WebElement typeCodeOption;

    public void createNewAction(WebDriver driver)
    {
        cteateNew_button.click();
    }
    public void goToTheLastPage(WebDriver driver)
    {
        goTolastPage.click();
    }
    public void inputNewRecorInfod (String method, String typecode, String code, String desp, String price)
    {

        //Wait.WaitToBeVisible(driver, "xpath", "//*[@id=\"TimeMaterialEditForm\"]/div/div[1]/div/span[1]/span/span[2]/span", 3);
        typeCodeDropdown.click();
        if (typecode == "T")
        {
           // Wait.WaitToBeVisible(driver, "xpath", "//*[@id=\"TypeCode_listbox\"]/li[2]", 3);
            typeCodeOption = driver.findElement(By.xpath("//ul[@id='TypeCode_listbox']//li[text()='Time']"));
        }
        else
        {
          //  Wait.WaitToBeVisible(driver, "xpath", "//*[@id=\"TypeCode_listbox\"]/li[1]", 3);
            typeCodeOption = driver.findElement(By.xpath("//ul[@id='TypeCode_listbox']//li[text()='Material']"));
        }
        typeCodeOption.click();
        codeTextbox.clear();
        codeTextbox.sendKeys(code);
        descriptionTextbox.clear();
        descriptionTextbox.sendKeys(desp);
        if(method=="edit"){
            priceTagOverlap.click();
            priceTextbox.clear();
        }
        priceTagOverlap.click();
        priceTextbox.sendKeys(price);

        //  driver.FindElement(saveButton).Click();

    }
    public void SaveNewRecord(WebDriver driver)
    {
        saveButton.click();
    }

    public void ClickTheLastRecordEditButton(WebDriver driver)
    {
        lastRecordEditButton.click();
    }

    public void DeleteTheLastRecord(WebDriver driver) {
        lastRecordDeleteButton.click();
        Alert simpleAlert = driver.switchTo().alert();
        simpleAlert.accept();
    }

    public int getItemCount(WebDriver driver)
    {
        int count = 0;
        waitForElementToBeVisible(driver,item_count);
        String item_content = item_count.getText();
        System.out.println("item_content = "+item_content);
        if(item_content!=""&& item_content!=null){
            String sub_item_content = item_content.substring(item_content.indexOf("f"));
            sub_item_content = sub_item_content.replace("f","").replace("items","").replace(" ", "");
            count = Integer.parseInt(sub_item_content);
        }

        return count;
    }
public void clickRefreshButton(){
        refresh_button.click();
}

    public String getTheLastRecordTypeCode(WebDriver driver)
    {
        WebElement _typeCode = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[2]"));
        return _typeCode.getText();
    }
    public String getTheLastRecordCode(WebDriver driver)
    {
        WebElement _code = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[1]"));
        return _code.getText();
    }
    public String getTheLastRecordDescription(WebDriver driver)
    {
        WebElement _description = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[3]"));
        return _description.getText();
    }
    public String getTheLastRecordPrice(WebDriver driver)
    {
        WebElement _price = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[4]"));
        return _price.getText();
    }
}
