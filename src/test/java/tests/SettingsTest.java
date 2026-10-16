package tests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.URI;
import java.time.Duration;

public class SettingsTest {

    AndroidDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        UiAutomator2Options options = new UiAutomator2Options()
                .setDeviceName("emulator-5554")
                .setAppPackage("com.android.settings")
                .setAppActivity(".Settings");

        driver = new AndroidDriver(URI.create("http://127.0.0.1:4723").toURL(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void openNetworkAndInternet() {
        driver.findElement(AppiumBy.xpath("//*[@text='Network & internet']")).click();

        boolean shown = driver.findElement(AppiumBy.xpath("//*[@text='Airplane mode']")).isDisplayed();
        Assert.assertTrue(shown, "Network & internet page did not open");
    }

    @Test
    public void openDisplay() {
        driver.findElement(AppiumBy.xpath("//*[@text='Display']")).click();

        boolean shown = driver.findElement(AppiumBy.xpath("//*[@text='Dark theme']")).isDisplayed();
        Assert.assertTrue(shown, "Display page did not open");
    }

    @Test
    public void backButtonReturnsToSettings() {
        driver.findElement(AppiumBy.xpath("//*[@text='Network & internet']")).click();

        driver.pressKey(new KeyEvent(AndroidKey.BACK));

        boolean shown = driver.findElement(AppiumBy.xpath("//*[@text='Network & internet']")).isDisplayed();
        Assert.assertTrue(shown, "Back button did not return to Settings home");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}