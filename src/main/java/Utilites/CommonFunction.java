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

public class CommonFunction {

    WebDriver driver;
    public CommonFunction(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //the cart function in the header
    @FindBy(css="[routerlink*='cart']")
    WebElement cartHeader;

    //the order function in the header
    @FindBy(css="[routerlink*='order']")
    WebElement orderHeader;

    public void waitForElementToAppear(By findBy){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }
    public void waitForElementToAppear(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToDisappear(WebElement elemet) throws InterruptedException {
      //  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      //  wait.until(ExpectedConditions.invisibilityOf(elemet));
        Thread.sleep(1000);
    }
    public  CartPage goToCart(){
        cartHeader.click();
        CartPage cartPage = new CartPage(driver);
        return cartPage;
    }

    public OrderPage goToOrder(){
        orderHeader.click();
        OrderPage orderPage = new OrderPage(driver);
        return orderPage;
    }
}
