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

// Trip type,one way olarak secilir
// kalkis ulkesi secenegine tiklanir ve default olan ulke kaldirilir
// kalkis yapilacak ulke/sehir girilir ve sec e tiklanir
// varis ulkesi secenegine tiklanir ve gidilecek ulke girilir
// gidis tarihi eylul ayinin 21 i olarak secilir ve set date e tiklanir
// search butonuna tiklanir
// en  ucuz ve aktarmasiz filtrelemeleri yapilir
// gelen bilet fiyati kaydedilir ve kullanicin telefonuna sms olarak gonderilir
    }
}
