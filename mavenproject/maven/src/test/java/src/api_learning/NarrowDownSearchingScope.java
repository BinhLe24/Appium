package src.api_learning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import src.driver.DriverFactory;
import src.driver.Platform;

import java.time.Duration;
import java.util.List;

public class NarrowDownSearchingScope {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);
        //Get Mobile Screen
        try {
            Dimension windowSize = appiumDriver.manage().window().getSize();
            int screenHeight = windowSize.getHeight();
            int screenWidth = windowSize.getWidth();

            //Calculator Touch Points
            int xStartPoint = 50 * screenWidth / 100;
            int xEndPoint = 50 * screenWidth / 100;
            int yStartPoint = 0;
            int yEndPoint = 10 * screenHeight / 100;

            //Convert Point To Coordinate
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
            List<MobileElement> notificationsElem =
                    appiumDriver.findElements(MobileBy.xpath("//android.widget.LinearLayout[@resource-id=\"com.android.systemui:id/quick_qs_panel\"]//android.widget.Switch\n"));
                    if (notificationsElem.isEmpty()){
                        throw new RuntimeException("[ERR] There is no notification");
                    }else {
                        for (MobileElement notificationElem : notificationsElem) {
                            MobileElement notificationLabelElem = notificationElem.findElement(MobileBy.id("com.android.systemui:id/tile_label"));
                            System.out.println(notificationLabelElem.getText());
                        }
                    }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        appiumDriver.quit();
    }
}
