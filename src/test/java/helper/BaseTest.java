package helper;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import setup.PrepareAppiumService;
import setup.PrepareDevice;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
    public AndroidDriver driver;
    public AppiumDriverLocalService service;
    public DesiredCapabilities capabilities;

    private static final String APPIUM_MAIN_JS_PATH = "C:\\Users\\sayan\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js";
    private static final String IP_ADDRESS = "127.0.0.1";
    private static final String PORT = "4723";
    private static final int IMPLICITLY_WAIT_TIME = 15;

    public void scrollTillFound(String element) {
        driver.findElement(AppiumBy.androidUIAutomator
                ("new UiScrollable(new UiSelector())." +
                        "scrollIntoView(text(\"" + element + "\"));"));
    }

    @BeforeSuite
    public void setup() throws MalformedURLException {
        capabilities = PrepareDevice.setDeviceCapabilities();
        service = PrepareAppiumService.setAppiumService(APPIUM_MAIN_JS_PATH, IP_ADDRESS, PORT);
        service.start();
        driver = new AndroidDriver(new URL("http://" + IP_ADDRESS + ":" + PORT), capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_TIME));
    }

    @AfterTest
    public void teardown() {
        driver.quit();
        service.close();
    }
}
