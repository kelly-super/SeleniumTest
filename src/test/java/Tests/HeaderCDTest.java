package Tests;

import TestComponents.BaseTest;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class HeaderCDTest extends BaseTest {

    WebDriver webDriver;
    public void CheckAllLinks() throws IOException {
        webDriver = initializeDriver();
        WebElement Header = webDriver.findElement(By.tagName("global-nav-header"));
        WebElement site_link = webDriver.findElement(By.className("site-link"));
        site_link.click();

        WebElement Logo_image = Header.findElement(By.className("site-logo"));



    }
}
