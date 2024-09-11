package Tests;

import TestComponents.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import PageObjects.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class EndToEndTest extends BaseTest {


    @Test(dataProvider = "getData",groups = {"Purchase"})
    public void submitOrder(HashMap<Object,Object> inputData) throws IOException, InterruptedException {

        /*ProductCatalogue productCatalogue = launchApplication().loginFeacture(inputData.get("userEmail").toString(),inputData.get("password").toString());
        List<WebElement> products = productCatalogue.getProductList();
        productCatalogue.addProductToCart(inputData.get("productName").toString());
        CartPage cartPage = productCatalogue.goToCart();
        Boolean match = cartPage.VerifyProductDisplay(inputData.get("productName").toString());
        Assert.assertTrue(match);
        CheckoutPage checkoutPage = cartPage.goToCheckout();
        checkoutPage.setSelectCountry("india");
        ConfirmationPage confirmationPage = checkoutPage.submitOrder();
        String confirmMessage = confirmationPage.verifyConfirmationMessage();
        Assert.assertEquals(confirmMessage,"THANKYOU FOR THE ORDER.");*/

    }
    @Test(dependsOnMethods = {"submitOrder"})
    public  void  orderHistoryTest() throws IOException {
     /*   ProductCatalogue productCatalogue = launchApplication().loginFeacture(userEmail,psd);
        OrderPage orderPage = productCatalogue.goToOrder();
        Assert.assertTrue( orderPage.verifyOrderDisplay(productName));*/
    }

    @DataProvider
    public Object[][]  getData() throws IOException {

       /* HashMap<Object,Object> map = new HashMap<Object,Object>();
        map.put("userEmail","kellycc677@gmail.com");
        map.put("password","123456");
        map.put("productName","ZARA COAT 3");

        HashMap<Object,Object> map1 = new HashMap<Object,Object>();
        map1.put("userEmail","hello888@gmail.com");
        map1.put("password","123456");
        map1.put("productName","ADIDAS ORIGINAL");*/
       List<HashMap<String,String>> data = getJsonDataToMap("D:\\Kelly\\SeleniumTest\\src\\test\\java\\Data\\PurchaseOrder.json");

        return new Object[][]{{data.get(0)},{data.get(1)}};
 }



}
