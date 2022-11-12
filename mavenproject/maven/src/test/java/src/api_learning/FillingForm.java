package src.api_learning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import src.driver.DriverFactory;
import src.driver.Platform;

import java.time.Duration;
import java.util.List;

public class FillingForm {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);

        try {
            //Navigate to Form screen
            MobileElement navFormsBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("Forms"));
            navFormsBtnElem.click();

            //Wait until we are on the new screen after Navigating
            WebDriverWait wait = new WebDriverWait(appiumDriver, 5L);
            wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy
                    .AndroidUIAutomator("new UiSelector().textContains(\"Form Components\")")));

            //Input field
            MobileElement inputField = appiumDriver.findElement(MobileBy.AccessibilityId("text-input"));
            inputField.sendKeys("My text");

            //Switch
            MobileElement switchButton = appiumDriver.findElement(MobileBy.AccessibilityId("switch"));
            switchButton.click();

            //Dropdown
            MobileElement dropDownElem = appiumDriver.findElement(MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"Dropdown\"]/android.view.ViewGroup/android.widget.EditText"));
            dropDownElem.click();
            WebDriverWait wait2 = new WebDriverWait(appiumDriver, 5L);
            wait2.until(ExpectedConditions.visibilityOfElementLocated(MobileBy
                    .AndroidUIAutomator("new UiSelector().textContains(\"Select an item\")")));
            MobileElement optionElem = appiumDriver.findElement(MobileBy.
                    AndroidUIAutomator("new UiSelector().textContains(\"Appium is awesome\")"));
            optionElem.click();

            //SwipeVertically
            Dimension windowSize = appiumDriver.manage().window().getSize();
            int screenHeight = windowSize.getHeight();
            int screenWidth = windowSize.getWidth();

            int xStartPoint = 50 * screenWidth / 100;
            int xEndPoint = 50 * screenWidth / 100;
            int yStartPoint = 50 * screenHeight / 100;
            int yEndPoint = 10 * screenHeight / 100;

            PointOption startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
            PointOption endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);

            //Touch Action
            TouchAction touchAction = new TouchAction(appiumDriver);
            touchAction
                    .press(startPoint)
                    .waitAction(new WaitOptions().withDuration(Duration.ofMillis(500)))
                    .moveTo(endPoint)
                    .release()
                    .perform();

            //Find Active button and Click
            appiumDriver.findElement(MobileBy.AccessibilityId("button-Active")).click();

            //OK button
            WebDriverWait wait1 = new WebDriverWait(appiumDriver, 5L);
            wait1.until(ExpectedConditions.visibilityOfElementLocated(MobileBy
                    .AndroidUIAutomator("new UiSelector().textContains(\"This button is\")")));
            appiumDriver.findElement(MobileBy.id("android:id/button1")).click();

            //Debug purpose ONLY
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
