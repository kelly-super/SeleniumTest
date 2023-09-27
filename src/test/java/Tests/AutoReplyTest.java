package Tests;

import Data.DataReader;
import TestComponents.BaseTest;
import io.cucumber.java.it.Date;
import org.bouncycastle.dvcs.DVCSRequestInfo;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class AutoReplyTest extends BaseTest {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeTest
    public void loginForum() throws IOException, InterruptedException{
         driver = initializeDriver();
        driver.get("http://bbs.skykiwi.com/forum.php");
        wait = new WebDriverWait(driver,Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("登录")));
        driver.findElement(By.linkText("登录")).click();

        driver.findElement(By.id("username")).sendKeys("kellycc677@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Z1x2c3v4");
        driver.findElement(By.id("rememberPasswd")).click();
        driver.findElement(By.id("agreePolicy")).click();
        driver.findElement(By.id("btnLoginAct")).click();
        System.out.println("current url = "+ driver.getCurrentUrl());
    }
    //Auto reply to my article
    @Test
    public void autoReply() throws IOException, InterruptedException {

        driver.findElement(By.id("qmenu")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("qmenu_menu")));

        driver.findElement(By.linkText("帖子")).click();

        driver.findElement(By.linkText("我的帖子")).click();

        List<WebElement> rows = driver.findElements(By.xpath("//table//tbody//tr//th"));
        String parentURL = driver.getWindowHandle();

        for (WebElement row : rows) {
            if (row.getText().contains("铝合金")) {
                row.findElement(By.tagName("a")).click();
                break;
            }
        }
        Set<String> s=driver.getWindowHandles();

// Now iterate using Iterator
        Iterator<String> I1= s.iterator();
        while(I1.hasNext()) {

            String child_window = I1.next();
            System.out.println("testing====="+child_window);
            if (!parentURL.equals(child_window)) {
                driver.switchTo().window(child_window);
            }
        }
        Thread.sleep(3);
        driver.findElement(By.id("post_reply")).click();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

         wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fwin_reply")));
         driver.findElement(By.id("postmessage")).sendKeys("auto reply ="+dtf.format(now));
         driver.findElement(By.id("postsubmit")).click();

         driver.switchTo().window(parentURL);
         driver.navigate().refresh();
    }

    @Test
    public void deleteTheCollectArticles() throws InterruptedException {
        driver.findElement(By.id("qmenu")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("qmenu_menu")));

        driver.findElement(By.linkText("收藏")).click();
        WebElement ul = driver.findElement(By.id("favorite_ul"));
        List<WebElement> rows = ul.findElements(By.tagName("li"));
        for (WebElement row : rows) {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("ajaxwaitid")));
           wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("删除")));
            row.findElement(By.linkText("删除")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("deletesubmitbtn")));
            driver.findElement(By.name("deletesubmitbtn")).click();

        }

    }
    @Test
    public void deleteAllTheSelectedFavorate(){
        driver.findElement(By.id("qmenu")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("qmenu_menu")));
        driver.findElement(By.linkText("收藏")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("favorite_ul")));
        JavascriptExecutor je = (JavascriptExecutor)driver;
        WebElement element = driver.findElement(By.id("chkall"));
        je.executeScript("arguments[0].scrollIntoView()",element);
        element.click();
        driver.findElement(By.name("delsubmit")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("fwin")));
        driver.findElement(By.id("fwin_dialog_submit")).click();
    }


}
