package ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExtentReportDemo {

    ExtentReports extent;

    @BeforeTest
    public void config(){
        String path = System.getProperty("user.dir")+"\\reports\\report.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Selenium Test Report");
        reporter.config().setDocumentTitle("Test Result");
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester","kelly");

    }
    @Test
    public void initialDemo(){
        extent.createTest("Initial Demo");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/client");
        System.out.println(driver.getTitle());
        extent.flush();
    }
}
