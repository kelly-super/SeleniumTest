package PageObjects;


import Utilites.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends Wait {
    WebDriver driver;

    public CartPage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css=".cartSection h3")
    List<WebElement> cartProducts;

    @FindBy(css=".totalRow button")
    WebElement checkoutEle;




    public Boolean VerifyProductDisplay(String productName){
        Boolean match  = cartProducts.stream().anyMatch(product->
                product.getText().equalsIgnoreCase(productName));
        return match;
    }

    public CheckoutPage goToCheckout(){
        checkoutEle.click();
        return new CheckoutPage(driver);
    }
}
