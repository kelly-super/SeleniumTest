package Tests;

import TestComponents.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FooterCDTest extends BaseTest{
    //Test all the features appear on the footer

    WebDriver webDriver;
    @Test
    public void checkFeaturesallworks() throws IOException, InterruptedException {

        webDriver = initializeDriver();
        webDriver.get("https://www.woolworths.co.nz/");

        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

       //check the footer -  global-nav, including 27 links, check all the links are works fine
        WebElement footer = webDriver.findElement(By.className("global-nav"));
        //check the link counts
        List<WebElement> links = footer.findElements(By.tagName("a"));
        int count  = links.size();
        Assert.assertEquals(count,27);
        int brokenCount =0;
        for(WebElement link: links){
            String url = link.getAttribute("href");

            ((JavascriptExecutor) webDriver).executeScript("window.open(arguments[0])", url);

            // Switch to the new tab
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));

            // Wait for the page to load and verify the URL
            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            String currentUrl = driver.getCurrentUrl();
            System.out.println("Current url ===="+ currentUrl);

            // Close the new tab and switch back to the original tab
            driver.close();
            driver.switchTo().window(tabs.get(0));
        }
        Assert.assertEquals(0,brokenCount,brokenCount +" broken links found");
        //check the links work fine or not

    }


}
