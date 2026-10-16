import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.URI;
import java.time.Duration;

public class FirstTest {
    public static void main(String[] args) throws Exception {

        // 1. Which phone and which app to open
        UiAutomator2Options options = new UiAutomator2Options()
                .setDeviceName("emulator-5554")
                .setAppPackage("com.android.settings")
                .setAppActivity(".Settings");

        // 2. Connect to the Appium server
        AndroidDriver driver = new AndroidDriver(
                URI.create("http://127.0.0.1:4723").toURL(), options);

        // 3. Wait up to 10 seconds for elements to appear
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 4. Tap "Network & internet"
        driver.findElement(AppiumBy.xpath("//*[@text='Network & internet']")).click();

        // 5. Check the new page opened
        boolean pageOpened = driver.findElement(
                AppiumBy.xpath("//*[@text='Airplane mode']")).isDisplayed();

        if (pageOpened) {
            System.out.println("PASS: Network & internet page opened");
        } else {
            System.out.println("FAIL: Page did not open");
        }

        // 6. Close the session
        driver.quit();
    }
}