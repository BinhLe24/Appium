package src.api_learning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import src.driver.DriverFactory;
import src.driver.Platform;

public class XPathLearning {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);

        try {
            //Navigate to login screen
            MobileElement navLoginBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginBtnElem.click();
            //Find all matching elements| Sharing about the trick with findElements

            //Find login info text by UISelector

            //Debug purpose ONLY
            Thread.sleep(3000);

        } catch (Exception e) {
            e.printStackTrace();
        }
        appiumDriver.quit();
    }
}
