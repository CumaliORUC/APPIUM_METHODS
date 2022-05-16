package Appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium05_Calculator {
    @Test
    public void test() throws InterruptedException, MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Emulator");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.1");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:/Users/TR/Desktop/IT COURSE/APPIUM_PRACTICE/src/apps/Calculator (1).apk");
        //noReset
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
//http://localhost:4723/wd/hub
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);

        Thread.sleep(4000);

        AndroidElement divide=driver.findElementById("com.google.android.calculator:id/op_div");
        AndroidElement multiple=driver.findElementById("com.google.android.calculator:id/op_mul");
        AndroidElement equalSign=driver.findElementById("com.google.android.calculator:id/eq");

        AndroidElement num8=driver.findElementById("com.google.android.calculator:id/digit_8");
        AndroidElement num5=driver.findElementById("com.google.android.calculator:id/digit_5");
        AndroidElement num4=driver.findElementById("com.google.android.calculator:id/digit_4");
        AndroidElement num9=driver.findElementById("com.google.android.calculator:id/digit_9");

        AndroidElement preresult=driver.findElementById("com.google.android.calculator:id/result_preview");

        num8.click();
        multiple.click();
        num5.click();
        divide.click();
        num4.click();
        String expectedResult=preresult.getText();

        equalSign.click();
        AndroidElement final_result=driver.findElementById("com.google.android.calculator:id/result_final");

        String actualResult=final_result.getText();
        Assert.assertEquals(expectedResult,actualResult);
    }
}