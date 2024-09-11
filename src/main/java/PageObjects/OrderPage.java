package PageObjects;


import Utilites.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrderPage extends Wait {

    WebDriver driver;

    @FindBy(css="tr td:nth-child(3)")
    List<WebElement> productNames;

    @FindBy(css=".totalRow button")
    WebElement checkoutEle;

    public OrderPage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public Boolean verifyOrderDisplay(String productname){
        Boolean match = productNames.stream().anyMatch(product->product.getText().equalsIgnoreCase(productname));
        return match;
    }

}
