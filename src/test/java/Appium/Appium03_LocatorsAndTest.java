package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

/*
//    lunch GestureTool app
//    click addGesture button
//    send text to name box "testing"
//    click done
//    verify testing gesture is created
    */
public class Appium03_LocatorsAndTest {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Emulator");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"7.1.1");
        //eger appActivity ve appPackage kullanacaksaniz app path gerekli degil
        desiredCapabilities.setCapability(MobileCapabilityType.APP,"C:/Users/TR/Desktop/IT COURSE/APPIUM_PRACTISE/src/apps/gestureTool.apk");
        //http://localhost:4723/wd/hub
        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);

        Thread.sleep(5000);
        //id ile bulduk
        // driver.findElementById("com.davemac327.gesture.tool:id/addButton").click();
        // id bu sekildede yazabilirsiniz
        // driver.findElementById("addButton").click();
        //xpath index ile bulduk
        // driver.findElementByXPath("(//android.widget.Button)[2]").click();
        //xpath text
       /* lunch GestureTool app
        click test button
        verify title "Test a gesture"
        close app
         */
        Thread.sleep(3000);
        String expectedTitle = "Test a gesture";
        String actualTitle = driver.findElementById("android:id/title").getText();

        Assert.assertEquals(actualTitle,expectedTitle);

        //session kapat
        driver.quit();
    }
}
