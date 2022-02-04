package br.ce.wcaquino.appium.core;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriveFactory {
    
    public static AndroidDriver<MobileElement> driver;
    public static WebDriverWait driveWait;

    public static AndroidDriver<MobileElement> getDriver(){
        if(driver == null){
            createDriver();
        }
        return driver;
    }

    public static void createDriver(){
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, Constants.APK_APPIUM);
        // desiredCapabilities.setCapability("ensureWebviewsHavePages", true);
        // desiredCapabilities.setCapability("noReset", true);
        // desiredCapabilities.setCapability("autoGrantPermissions", true);


        try {
            driver = new AndroidDriver<MobileElement>(new URL(Constants.SPEC), desiredCapabilities);
        }catch (MalformedURLException e){
            e.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public static void killDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }

    public static WebDriverWait getDriverWait() {        
        return driveWait = new WebDriverWait(driver, 20);
    }
}
