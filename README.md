# Appium Android Settings Tests

Mobile automation tests for the Android Settings app using Appium, Java and TestNG.

## Tests
| Test | What it checks |
|---|---|
| openNetworkAndInternet | Tapping "Network & internet" opens the page (Airplane mode visible) |
| openDisplay | Tapping "Display" opens the page (Dark theme visible) |
| backButtonReturnsToSettings | Android Back button returns to the Settings home screen |

## Tools
Appium 3, UiAutomator2 driver, Java 21, TestNG, Maven, Android Studio emulator (Pixel 4, Android 11), Appium Inspector

## How to run
1. Start the emulator
2. Start the Appium server: `appium`
3. Run `SettingsTest` as a TestNG test

## What I learned
- Finding locators with Appium Inspector and checking they are unique
- Using @BeforeMethod and @AfterMethod so each test starts fresh and the session always closes
- Using assertions instead of print statements
- Fixing emulator issues on a low-spec laptop (disk space, storage size, ANDROID_HOME)