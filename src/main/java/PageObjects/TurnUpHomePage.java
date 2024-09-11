package PageObjects;


import Utilites.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TurnUpHomePage extends Wait {
    WebDriver driver;
    public TurnUpHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//li[@class='dropdown']//a[text()='Administration ']")
    WebElement administratorTab;
    @FindBy(xpath="//ul[@class='dropdown-menu']//a[text()='Time & Materials']")
    WebElement materialAndTimeOption;
    @FindBy(xpath="//form[@id='logoutForm']//a[starts-with(text(),'Hello')]")
    WebElement helloUser;

    public void NavigateToTMPage()
    {
        administratorTab.click();
        materialAndTimeOption.click();
    }
    public String getSuccessMessage(){
        return helloUser.getText();
    }
}
