package setup;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;

public class PrepareAppiumService {
    private static AppiumDriverLocalService service;
    public static AppiumDriverLocalService setAppiumService(String APPIUM_MAIN_JS_PATH, String IP_ADDRESS, String PORT) {
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File(APPIUM_MAIN_JS_PATH))
                .withIPAddress(IP_ADDRESS)
                .usingPort(Integer.parseInt(PORT))
                .build();

        return service;
    }
}
