package Utilities;

import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;


public class MobileDriver {
    private MobileDriver() {

    }

    private static AndroidDriver androidDriver;
//    private static IOSDriver iosDriver;


    public static AndroidDriver getAndroidDriver() {
        URL serverUrl = null;
        try {
            serverUrl = new URL("http://0.0.0.0:4723/wd/hub");
        } catch (MalformedURLException e) {
            System.out.println("Appium Server Is Not Running!!");
            e.printStackTrace();
        }

        if (androidDriver == null) {



            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_2");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
//            capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
//            capabilities.setCapability("fullReset", false);
            capabilities.setCapability("appPackage", "bbc.mobile.news.uk");
            capabilities.setCapability("appActivity", "bbc.mobile.news.v3.ui.splash.SplashActivity");
            capabilities.setCapability(MobileCapabilityType.APP,System.getProperty("user.dir")+"\\src\\test\\resources\\BBC.apk");
            // capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");


            assert serverUrl != null;

            androidDriver = new AndroidDriver(serverUrl, capabilities);
        }


        return androidDriver;
    }

    public static void getRunningDriver(){


    }
    public static void closeAndroidDriver() {

        if (androidDriver != null) {
            androidDriver.resetApp();
        }
        System.out.println("Application Closed!!");
    }
}
