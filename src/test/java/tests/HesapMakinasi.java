package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class HesapMakinasi {
    AndroidDriver<AndroidElement> driver; // Anadroid cihazlardaki islemleri yapabilmemizi saglayan driver objesi


  //  AndroidDriver<MobileElement> driver2; // Anadroid cihazlardaki islemleri yapabilmemizi saglayan driver objesi
    //   IOSDriver<IOSElement> iosDriver; // Ios cihazlardaki islemleri yapabilmemizi saglayan driver objesi
  //  AppiumDriver<MobileElement> appiumDriver; // her iki platformda da islemleri yapabilmemezi saglayan driver objesi



    @Test
    public void ilkHesapAppTest() throws MalformedURLException {
    // kullanici gerekli kurulumlari yapar
        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 2");// capabilities.setCapability("deviceName","Pixel 2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\ahmet\\IdeaProjects\\Appium_T127\\Apps\\Calculator_8.4 (503542421)_Apkpure.apk");
        // UiAutomator 2 otomasyon ismi sadece android 6 dan yuksek olan android sistemleri icin calisir
        // UiAutomator otomasyon ismi sadece android 6 ve 6 dan dusuk olan android sistemleri icin calisir
        driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


     // uygulamanin yuklendigini dogrular(isInstalled)
        Assert.assertTrue( driver.isAppInstalled("com.google.android.calculator"));
     // uygulamanin acildigini dogrular
       Assert.assertTrue(driver.findElementById("com.google.android.calculator:id/clr").isDisplayed());
     // 200 un 7 katininin 1400 oldugunu hesap makinasindan dogrulayalim
        driver.findElementByAccessibilityId("2").click();
        driver.findElementByAccessibilityId("0").click();
        driver.findElementByAccessibilityId("0").click();
        driver.findElementByAccessibilityId("multiply").click();
        driver.findElementByAccessibilityId("7").click();
        driver.findElementByAccessibilityId("equals").click();
        String sonuc=driver.findElementById("com.google.android.calculator:id/result_final").getText(); // 1400
        System.out.println(sonuc); //1400
        Assert.assertEquals(Integer.parseInt(sonuc),1400);

    }
}
