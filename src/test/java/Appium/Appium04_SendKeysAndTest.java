package Appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium04_SendKeysAndTest {
    @Test
    public void test() throws InterruptedException, MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Emulator");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.1");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:/Users/TR/Desktop/IT COURSE/APPIUM_PRACTICE/src/apps/gestureTool.apk");
        //noReset
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
//http://localhost:4723/wd/hub
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
 /*
//    lunch GestureTool app
//    click addGesture button
//    send text to name box "testing"
//    click done
//    verify testing gesture is created
     */
        Thread.sleep(4000);

        driver.findElementById("com.davemac327.gesture.tool:id/addButton").click();
        Thread.sleep(2000);
        driver.findElementById("com.davemac327.gesture.tool:id/gesture_name").sendKeys("test");

        driver.findElementById("com.davemac327.gesture.tool:id/gestures_overlay").click();
        Thread.sleep(2000);

        driver.findElementById("com.davemac327.gesture.tool:id/done").click();
        Thread.sleep(2000);
        String expectedText = "test";
        String actualText = driver.findElementByXPath("//android.widget.TextView[@text='test']").getText();
        Assert.assertEquals(actualText,expectedText);





    }
}
