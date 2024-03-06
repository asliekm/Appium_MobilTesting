package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KiwiPage;
import utils.Driver;
import utils.ResuableMethods;

public class KiwiApp {
   AndroidDriver<AndroidElement>driver=Driver.getAndroidDriver();
   /* Hali hazirda testlerimizde kullanacak oldugumuz driver i Driver clasinda olsuturdugumuz icin,olusturulan driveri
   bu scope icerisinde Android Element olarak dondurulmesini istedigimizden, driver clasindaki static methodumuzu buradaki bos drivera atama yaparak
   bu sayfada kullanacak oldugumuz drivera bir tanimlama atamasi yapmis oluruz.
    */
    KiwiPage page=new KiwiPage();


    @Test
    public void kiwiAppTest() throws InterruptedException {
// uygulamanin yuklendigi dogrulanir
        Assert.assertTrue(driver.isAppInstalled("com.skypicker.main"));
// uygulamanin basariyla acildigi dogrulanir
       Assert.assertTrue(page.misafirButonu.isDisplayed());
// misafir olarak devam et e tiklanir
        page.misafirButonu.click();
        Thread.sleep(1000);
// ardinda gelecek olan 3 adimada yesil butona basilarak devam edilir
       for (int i=0; i<3; i++){
           ResuableMethods.koordinatTiklamaMethodu(541,1700,1000);
       }
       Thread.sleep(2500);
// Trip type,one way olarak secilir
        ResuableMethods.koordinatTiklamaMethodu(300,617,1000);
        ResuableMethods.koordinatTiklamaMethodu(508,1461,1000);
// kalkis ulkesi secenegine tiklanir ve default olan ulke kaldirilir
        ResuableMethods.koordinatTiklamaMethodu(504,782,1000);
        ResuableMethods.koordinatTiklamaMethodu(1019,139,1000);
// kalkis yapilacak ulke/sehir girilir ve sec e tiklanir
        if (!driver.isKeyboardShown()){
            page.kalkisTextKutusu.sendKeys("Ankara");
        } else {
            driver.getKeyboard().pressKey("Istanbul");
        }
        Thread.sleep(1500);
        ResuableMethods.koordinatTiklamaMethodu(482,289,1000);
        page.chooseButton.click();
        Thread.sleep(1000);

// varis ulkesi secenegine tiklanir ve gidilecek ulke girilir
        ResuableMethods.koordinatTiklamaMethodu(508,917,1000);
        driver.getKeyboard().pressKey("Antalya");
        Thread.sleep(1500);
        ResuableMethods.koordinatTiklamaMethodu(482,289,1000);
        page.chooseButton.click();
        Thread.sleep(1000);
// gidis tarihi eylul ayinin 21 i olarak secilir ve set date e tiklanir
        ResuableMethods.koordinatTiklamaMethodu(537,1048,1000);

// search butonuna tiklanir
// en  ucuz ve aktarmasiz filtrelemeleri yapilir
// gelen bilet fiyati kaydedilir ve kullanicin telefonuna sms olarak gonderilir
    }
}
