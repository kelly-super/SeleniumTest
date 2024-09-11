package Utilites;

import PageObjects.CartPage;
import PageObjects.OrderPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Wait {

   /* WebDriver driver;
    public Wait(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }*/

    //the cart function in the header
   /* @FindBy(css="[routerlink*='cart']")
    WebElement cartHeader;

    //the order function in the header
    @FindBy(css="[routerlink*='order']")
    WebElement orderHeader;*/

    public static void waitForElementToBeVisible(WebDriver driver,By findBy){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }
    public static void waitForElementToBeVisible(WebDriver driver,WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementToDisappear(WebDriver driver,WebElement elemet) throws InterruptedException {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      wait.until(ExpectedConditions.invisibilityOf(elemet));
      Thread.sleep(1000);
    }
    /*public  CartPage goToCart(){
        cartHeader.click();
        CartPage cartPage = new CartPage(driver);
        return cartPage;
    }

    public OrderPage goToOrder(){
        orderHeader.click();
        OrderPage orderPage = new OrderPage(driver);
        return orderPage;
    }*/
}
