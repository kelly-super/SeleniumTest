package PageObjects;

import Utilites.CommonFunction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class  LoginPage extends CommonFunction {
    WebDriver driver;
    public LoginPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "userEmail")
    WebElement userEmail;
    @FindBy(id="userPassword")
    WebElement password;
    @FindBy(id = "login")
    WebElement submit;
    @FindBy(className = "forgot-password-link")
    WebElement forgotPassword;
    @FindBy(css="[class*='flyInOut']")
    WebElement errorMessage;

    public ProductCatalogue loginFeacture(String username, String psd){
        userEmail.sendKeys(username);
        password.sendKeys(psd);
        submit.click();
        ProductCatalogue productCatalogue = new ProductCatalogue(driver);
        return productCatalogue;
    }

    public String getErrorMessage(){
        waitForElementToAppear(errorMessage);
        return errorMessage.getText();
    }
    public void forgotPasswordFeacture(){
        forgotPassword.click();
    }

    public void goTo(){
        driver.get("https://rahulshettyacademy.com/client");
    }
}
