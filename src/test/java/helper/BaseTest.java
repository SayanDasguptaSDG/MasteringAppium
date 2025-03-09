import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
    AppiumDriver driver;
    AppiumDriverLocalService service;
    DesiredCapabilities capabilities;

    private static final String APPIUM_MAIN_JS_PATH = "C:\\Users\\sayan\\AppData\\Roaming\\npm\\node_modules\\appium\\lib\\main.js";
    private static final String IP_ADDRESS = "127.0.0.1";
    private static final int PORT = 4723;
    private static final String DEVICE_TYPE = "ANDROID";
    private static final int IMPLICITLY_WAIT_TIME = 15;

    BaseTest(AppiumDriver driver) {
        this.driver = driver;
    }

    @BeforeSuite
    public void setup() throws MalformedURLException {
        capabilities = PrepareDevice.setDeviceCapabilities();
        service = PrepareAppiumService.setAppiumService(APPIUM_MAIN_JS_PATH, IP_ADDRESS, PORT);
        service.start();
        if(DEVICE_TYPE == "ANDROID") {
            driver = new AndroidDriver(new URL("http://" + IP_ADDRESS + ":" + PORT), capabilities);
        } else {
            //IOS
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_TIME));
    }

    @AfterTest
    public void teardown() {
        driver.quit();
        service.close();
    }

}
