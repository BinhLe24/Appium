package src.api_learning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import src.driver.AppPackages;
import src.driver.DriverFactory;
import src.driver.Platform;

import java.time.Duration;

public class HandleMultipleApps {

    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);
        try {
            //Navigate to log-in form
            MobileElement navLoginBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginBtnElem.click();

            //Find Login form element
            MobileElement emailInputElem = appiumDriver.findElement(MobileBy.AccessibilityId("input-email"));
            MobileElement passwordInputElem = appiumDriver.findElement(MobileBy.AccessibilityId("input-password"));
            MobileElement loginBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("button-LOGIN"));

            //Interact with login form | fill username & password
            emailInputElem.sendKeys("binh@sth.com");
            passwordInputElem.sendKeys("12345678");
            loginBtnElem.click();

            //Run app in background
            //appiumDriver.runAppInBackground(Duration.ofSeconds(3));

            //Open Setting app
            appiumDriver.activateApp(AppPackages.SETTINGS);
            appiumDriver.findElement(MobileBy.xpath("//*[@text='Network & internet']")).click();
            appiumDriver.findElement(MobileBy.xpath("//*[@text='Internet']")).click();
            boolean isWifiOff = appiumDriver.findElements(MobileBy.xpath("//*[@text='Add network']")).isEmpty();
            int timeToToggle = isWifiOff ? 1 : 2;
            MobileElement toggleElem = appiumDriver.findElement(MobileBy.id("android:id/switch_widget"));
            for (int toggleTime = 0; toggleTime < timeToToggle; toggleTime++) {
                toggleElem.click();
            }

            //Come back to the main app
            appiumDriver.activateApp(AppPackages.WEBDRIVER_IO);
            appiumDriver.findElement(MobileBy.xpath("//*[@text='OK']")).click();

            //Debug Purpose Only
            Thread.sleep(2000);

        } catch (Exception e){
            e.printStackTrace();
        }
        appiumDriver.quit();
    }
}
