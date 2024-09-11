package AppiumTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class LoginTest {

   // WebDriver webDriver;
   static AppiumDriver appDriver;
   // AndroidDriver andDriver;

    public  static void main() throws MalformedURLException {
        DesiredCapabilities  cap = new DesiredCapabilities();
        cap.setCapability("deviceName","pixel_5");
        cap.setCapability("udid","emulator-5554");
        cap.setCapability("platformName","Android");
        cap.setCapability("appPackage","D:\\Kelly\\Test\\Android-MyDemoAppRN.1.3.0.build-244.apk");

        URL url = new URL("http://127:0:0:1:4723/");
        appDriver = new AppiumDriver(url,cap);

    }
}
