package setup;

import org.openqa.selenium.remote.DesiredCapabilities;

public class PrepareDevice {
    private static DesiredCapabilities capabilities;
    public static DesiredCapabilities setDeviceCapabilities() {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appium:platformName", "Android");
        capabilities.setCapability("appium:platformVersion", "11.0");
        capabilities.setCapability("appium:app", "resources/General-Store.apk");
        capabilities.setCapability("appium:noReset", "true");

        return capabilities;
    }
}
