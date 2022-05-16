package Appium;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;

import java.net.MalformedURLException;

public class ReusableMethod extends AppiumBase{
    AndroidDriver driver=androidDriver();

    public ReusableMethod() throws MalformedURLException, InterruptedException {
    }

    public void scrollUp() {

        TouchAction touchAction=new TouchAction(driver);
        Dimension dimension=driver.manage().window().getSize();

        int x= (int) (dimension.width*0.5);
        int y= (int) (dimension.height*0.8);

        int x1= (int) (dimension.width*0.5);
        int y1= (int) (dimension.height*0.2);

        touchAction.press(PointOption.point(x,y)).moveTo(PointOption.point(x1,y1)).perform();
    }

    public void scrollUp_with_UISelector(String text) {
        //UI Scrollable Methodu ile; bu method sadece Android driver ile çalışır.
        // Bunun için daha once oğrendiğimiz UI Selector ü kullanırız.
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"))");
    }
}
