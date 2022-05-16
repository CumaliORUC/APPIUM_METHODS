package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.util.List;

public class Appium_reviewScroll extends AppiumBase {

    @Test
    public void test() throws MalformedURLException, InterruptedException {
        ReusableMethod reusableMethod=new ReusableMethod();

        AndroidDriver driver=androidDriver();

        driver.findElementByXPath("//android.widget.TextView[@text='API Demos']").click(); //api Demos clicked
        reusableMethod.scrollUp();
        Thread.sleep(3000);
        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();  //Views clicked

        do {
            reusableMethod.scrollUp();
        } while (driver.findElementsByXPath("//android.widget.TextView[@text='WebView']").size()==0);
        driver.findElementByXPath("//android.widget.TextView[@text='WebView']").click();

        System.out.println(driver.findElementByXPath("(//android.webkit.WebView)[1]").getText());
        //driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"\")";
        //driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/addButton\")").click();
    }

    @Test
    public void test02() throws MalformedURLException, InterruptedException {
        ReusableMethod reusableMethod=new ReusableMethod();
        AndroidDriver driver=androidDriver();

        driver.findElementByXPath("//android.widget.TextView[@text='API Demos']").click();
        Thread.sleep(3000);
        reusableMethod.scrollUp_with_UISelector("Views");
        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();

        reusableMethod.scrollUp_with_UISelector("WebView");
        driver.findElementByXPath("//android.widget.TextView[@text='WebView']").click();
        Thread.sleep(3000);
        System.out.println(driver.findElementByXPath("(//android.webkit.WebView)[1]").getText());

        Assert.assertTrue(driver.findElementByXPath("(//android.webkit.WebView)[1]").getText().contains("Hello"));
    }

}
