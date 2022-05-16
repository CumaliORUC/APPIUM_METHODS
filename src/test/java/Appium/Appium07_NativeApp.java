package Appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

public class Appium07_NativeApp {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Emulator");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"7.1.1");
        //http://chromedriver.chromium.org/download      bu linkten chrome versiyin builgisine ulasiyoruz
        //https://chromedriver.storage.googleapis.com/index.html  bu linkten butun versiyonlara ulasiyoruz

        desiredCapabilities.setCapability("appPackage","com.android.chrome");
        desiredCapabilities.setCapability("appActivity","com.google.android.apps.chrome.Main");
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        //remote device on chrome  https://developer.chrome.com/docs/devtools/remote-debugging/
        //chrome://inspect#devices  on chrome browser
        //getContextHandles() mevcut olan app turlerini Set konteynira ekliyoruz

        //input[@placeholder='Search Amazon']

        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        Thread.sleep(5000);
        driver.get("https://www.amazon.com/");
        System.out.println("1 "+driver.getContext());

//getContextHandles() mevcut olab app turlerini Set konteynira ekliyoruz
        Set contextNames = driver.getContextHandles();
        //burda mevcut app tururnu(context) bir bir yazdiriyoruz
        for (Object contextName : contextNames) {
            System.out.println(contextName);//NATIVE_APP   CHROMIUM
            Thread.sleep(3000);
//            if (contextName.toString().contains("WEBVIEW")){
//                //alttaki kodda hangi app turunde calisacaksak onu set ediyoruz
//                driver.context((String) contextName);//WEBAPP DEVAM EDECEGIM
//                Thread.sleep(10000);
//            }
        }
        //artik set ettigimiz context ile test devam ediyiruz.
        System.out.println("2 "+driver.getContext());//
        driver.findElementByXPath("//android.view.View[@content-desc='Sign In ›']").click();
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElementByXPath("//android.view.View[@text='Welcome']").isDisplayed());

        System.out.println("3 "+driver.getContext());//
        driver.quit();
    }
}