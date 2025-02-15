package config;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumConfig {

    public static AppiumDriver<AndroidElement> driver;
//    {
//        "platformName": "Android",
//            "deviceName": "Pixel",
//            "platformVersion": "13.0",
//            "appPackage": "com.telran.ilcarro",
//            "appActivity": ".SplashActivity"
//    }
    @BeforeMethod
    public void setUp(){
        DesiredCapabilities desiredCapabilities= new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability(  "deviceName", "Pixel");
        desiredCapabilities.setCapability("platformVersion", "13.0");
      //  desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.0",);
        desiredCapabilities.setCapability("appPackage", "com.telran.ilcarro");
        desiredCapabilities.setCapability( "appActivity", ".SplashActivity");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"Appium");
        String urlNex5 = "http:localhost:4723/wd/hub"; // путь к нашему эммулятору
        try {
            driver = new AppiumDriver<>(new URL(urlNex5),desiredCapabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }
    @AfterMethod
    public void tearDown(){
     //   driver.quit();
    }
}
