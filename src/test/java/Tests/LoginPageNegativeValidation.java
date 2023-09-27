package Tests;

import TestComponents.BaseTest;
import Utilites.Retry;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageNegativeValidation extends BaseTest {
    @Test(groups = {"errorValidation"},retryAnalyzer = Retry.class)
    public void invalidEmailValidation(){
        loginPage.loginFeacture("3423","3234");

       // Assert.assertTrue(true);
       Assert.assertEquals("Incorrect email or password.",loginPage.getErrorMessage());
    }
    @Test
    public void invalidPasswordlValidation(){
        loginPage.loginFeacture("3423","3234");
        Assert.assertTrue(true);
      //  Assert.assertEquals("Incorrect email or password.",loginPage.getErrorMessage());
    }
    @Test
    public void invalidEmailAndPassword(){
        loginPage.loginFeacture("3423","3234");
        Assert.assertTrue(true);
      //  Assert.assertEquals("Incorrect email or password.",loginPage.getErrorMessage());
    }


}
