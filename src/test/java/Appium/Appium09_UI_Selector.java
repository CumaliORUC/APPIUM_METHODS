package Appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium09_UI_Selector {
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

        //UiSelector da ' kullanamiyorsunuz " kullanmak gerekiyor   driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/addButton\")");
        //resorceId() ile
        // driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/addButton\")").click();
        // className
        // driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\")").click();

        //className() text ile beraber
        //  driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").text(\"Add gesture\")").click();

        //className() index() ile
        //  driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").index(1)").click();
        //  driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").index(1)").click();

//        List<MobileElement> buttons = driver.findElementsByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\")");
//        for (MobileElement button : buttons) {
//             if (button.getText().equals("Add gesture")){
//                 button.click();
//                 break;
//             }
//        }
        //UiSelector ile kullanivabilecek methodlar

        System.out.println(driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/addButton\").checkable(false)").getAttribute("checkable"));

        System.out.println(driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/addButton\").clickable(true)").getAttribute("clickable"));
    }
}