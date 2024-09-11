package PageObjects;


import Utilites.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TurnUpLoginPage extends Wait {
    WebDriver driver;
    public TurnUpLoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "UserName")
    WebElement userEmail_input;
    @FindBy(id="Password")
    WebElement password_input;

    /*
    * we can use 2 options to locate the log in button
    * xpath: By.xpath("//input[@type='submit' and @value='Log in']")
    * css Selector: By.cssSelector("input[type='submit'][value='Log in']")
     */
    @FindBy(xpath="//input[@type='submit' and @value='Log in']")
    WebElement login_button;

    public void LoginAction(WebDriver driver,String username, String password){
        userEmail_input.sendKeys(username);
        password_input.sendKeys(password);
        login_button.click();
    }


}
