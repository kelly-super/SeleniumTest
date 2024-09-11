package TestComponents;

import PageObjects.GlobalObject;
import PageObjects.LoginPage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class BaseTest  {

    public WebDriver driver;
    public LoginPage loginPage;
    public GlobalObject globalObject;
    public static Properties properties;

    public Properties getProperties()throws IOException {

        if( properties==null)
        {
            properties = new Properties();
            FileInputStream fis = new FileInputStream("src/main/resources/GlobalData.properties");
            properties.load(fis);
        }
        return properties;

    }

    public WebDriver initializeDriver() throws IOException {
        Properties prop =getProperties();
        String browserName = prop.getProperty("browser");
        String url = prop.getProperty("url");
        String userEmail = prop.getProperty("userEmail");
        String password = prop.getProperty("password");
//        String chromepath = prop.getProperty("chromepath");
//        System.setProperty("webdriver.chrome.driver",chromepath);
//        globalObject = new GlobalObject();
//        globalObject.setBrowser(browserName);
//        globalObject.setUrl(url);
//        globalObject.setUserEmail(userEmail);
//        globalObject.setPassword(password);

        if(browserName.contains("chrome")){

//            ChromeOptions options = new ChromeOptions();
//           // WebDriverManager.chromedriver().setup();
//            if(browserName.contains("headless")){
//                options.addArguments("headless");
//            }
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        }else if(browserName.equalsIgnoreCase("firefox")){

        }else if(browserName.equalsIgnoreCase("edge")){
            System.setProperty("webdriver.edge.driver","edge.exe");
            driver = new EdgeDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.manage().window().maximize();

        return driver;
    }

    public LoginPage launchApplication() throws IOException {
        driver = initializeDriver();
        loginPage = new LoginPage(driver);
        loginPage.goTo();
        return loginPage;
    }

    public List<HashMap<String,String>> getJsonDataToMap(String filePath) throws IOException {
        String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> data = mapper.readValue(jsonContent,new TypeReference<List<HashMap<String,String>>>(){});

        return data;
    }


    public  String getScreenshot(String testCaseName,WebDriver driver) throws IOException {
        TakesScreenshot ts =(TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png");
        FileUtils.copyFile(source,file);
        return System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown(){
     //  driver.quit();
    }

}
