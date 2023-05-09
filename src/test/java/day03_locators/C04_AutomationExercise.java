package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C04_AutomationExercise {

    public static void main(String[] args) throws InterruptedException {

        //1- Bir test class’i olusturun ilgili ayarlari yapin
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2- https://www.automationexercise.com/ adresine gidin
        driver.get("https://www.automationexercise.com/");

        //3- Sayfada 147 adet link bulundugunu test edin.
        //birden fazla elementi bize döndüreceği için WebElement e değil List e kayıt ederiz

        List<WebElement> sayfadakiLinkElementleri =driver.findElements(By.tagName("a"));//Linkleri tagname den bulabiliriz
                                                                                       //linklerin tagname a dır
        int expectedLinkSayisi=147;
        int actualLinkSayisi=sayfadakiLinkElementleri.size();//güncel olanı sayfadan, driver dan, webelementten ya da
                                                            //listten alabiliriz, güncel olarak bulunan likleri listte
                                                           //kaydettik, list in boyutunu size ile alırsak kaç tane link
                                                          //olduğunu test edebiliriz
        if (expectedLinkSayisi==actualLinkSayisi){
            System.out.println("Link sayisi testi PASSED");
        }else{
            System.out.println("Link sayisi testi FAILED");
        }

        //4- Products linkine tiklayin
        //öncelikle anasayfaya gidilir ve Products bulunur ve html kodları açılır,
        //Products ın tag ı <a olduğu için linktir
        //linktir, linktext i kullanabiliriz

        //önce Products elementini kaydederiz, değerini html kod sayfasında olduğu gibi yazarız
        WebElement productsLinkElementi=driver.findElement(By.partialLinkText(" Products"));


        //tıklayın dediği için
        productsLinkElementi.click();

        //5- special offer yazisinin gorundugunu test
        // locator (lokeyt) etmemizi istemiyor, görünüp görünmediğini test etmemizi istiyor
        WebElement specialOfferElementi= driver.findElement(By.id("sale_image"));

        if (specialOfferElementi.isDisplayed()){
            System.out.println("Special offer testi PASSED");
        }else{
            System.out.println("special offer testi FAILED");
        }

        //6- Sayfayi kapatin
        driver.close();

        // Run edince
        /*
           Link sayisi testi PASSED
           Special offer testi PASSED


         */
    }
}