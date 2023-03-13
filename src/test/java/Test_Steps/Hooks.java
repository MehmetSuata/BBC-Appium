package Test_Steps;

import Utilities.MobileDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.net.MalformedURLException;

import java.util.concurrent.TimeUnit;

public class Hooks {

    protected AndroidDriver driver;
    @Before
    public void setUp() throws MalformedURLException {
        if(driver==null){
        driver= MobileDriver.getAndroidDriver();}
        else{
            MobileDriver.getAndroidDriver();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        MobileDriver.closeAndroidDriver();

    }
}
