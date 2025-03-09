import org.openqa.selenium.remote.DesiredCapabilities;

public class PrepareDevice {
    private static DesiredCapabilities capabilities;
    public static DesiredCapabilities setDeviceCapabilities() {
        capabilities.setCapability("Appium:automationName", "UiAutomator2");
        capabilities.setCapability("Appium:platformName", "Android");
        capabilities.setCapability("Appium:platformVersion", "11.0");
        capabilities.setCapability("app", "resources/General-Store.apk");
        capabilities.setCapability("noReset", "true");

        return capabilities;
    }
}
