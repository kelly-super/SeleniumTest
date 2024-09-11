package PageObjects;


import Utilites.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends Wait {
    WebDriver driver;

    public CheckoutPage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".action__submit")
    WebElement submit;

    @FindBy(css="[placeholder='Select Country']")
    WebElement country;

    @FindBy(xpath="//button[contains(@class,'ta-item')][2]")
    WebElement selectCountry;

    By results = By.cssSelector(".ta-results");

    public void setSelectCountry(String countryName){
         Actions s = new Actions(driver);
         s.sendKeys(country,countryName).build().perform();
         waitForElementToBeVisible(driver,results);
         selectCountry.click();
    }
    public  ConfirmationPage submitOrder(){
        submit.click();
        return new ConfirmationPage(driver);
    }


}
