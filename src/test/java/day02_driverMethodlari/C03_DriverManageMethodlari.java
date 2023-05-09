package day02_driverMethodlari;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_DriverManageMethodlari {

    public static void main(String[] args) throws InterruptedException {

        //System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe"); yazmasak da driver çalışır

        /*
           Selenium 4.7 versiyonu ile kendi driver'ini sisteme ekledi
           Kodlar calismaya basladiginda biz driver icin yol gostermezsek
           Selenium kendi driver'ini devreye sokuyor
           Ama baslangicta driver ayari aradigi icin biraz yavas calisiyor

           driver.manage().window().istenen ayar ile window'umuzu istedigimiz boyuta getirebilir
           veya window'un konum ve buyukluk bilgilerine ulasabiliriz

           Biz genelde bir teste baslamadan once
           window'u maximize yapmayi tercih ederiz

           (sebebi, window'u maximize yapmazsak bazı sayfalarda butonlar görünür olmayabilir,
           bu durumda da istediğimiz testleri yapamayabiliriz)
         */

        WebDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //15 sn boyunca sayfaların açılmasını ve ögelerin bulunmasını bekler,
        // bulamayınca hata verir, sayfa açılamıyor, ögeler bulunamıyor der

        /*
            implicitlyWait bir websayfasi acilincaya veya
            aradigimiz elementler bulununcaya kadar
            driver'in bekleyecegi maximum sureyi belirler

            Thread.sleep() ise aradığımız elementi bulamasa da
            belirttiğimiz sürece bekler

         */

        driver.get("https://www.amazon.com");

        System.out.println("Baslangicta konum : "+driver.manage().window().getPosition()); // (10, 10)
        System.out.println("Baslangicta boyut : "+driver.manage().window().getSize());// (1050, 708)

        Thread.sleep(1000);
        driver.manage().window().maximize();//(maksimayz) tam sayfa yapma
        System.out.println("Maximize konum : "+driver.manage().window().getPosition()); //-8,-8 pozisyon bilgisini getirir
        System.out.println("Maximize boyut : "+driver.manage().window().getSize());//1382, 744 - güncel olanı getirir

        Thread.sleep(1000);
        driver.manage().window().fullscreen();//menüleri kaldırarak tam ekran yapar ona göre aşağıdaki bilgileri getirir
        System.out.println("Fullscreen konum : "+driver.manage().window().getPosition()); //0,0
        System.out.println("Fullscreen boyut : "+driver.manage().window().getSize());//1366, 768

        Thread.sleep(1000);
        driver.manage().window().minimize();//(minimayz)
        System.out.println("Minimize konum : "+driver.manage().window().getPosition()); //10, 10
        System.out.println("Minimize boyut : "+driver.manage().window().getSize());//1050, 708

        // pencereyi istedigimiz boyut ve konuma getirelim

        Thread.sleep(1000);
        driver.manage().window().setPosition(new Point(50,50));
        driver.manage().window().setSize(new Dimension(500,500));

        //istediğimiz değerleri girip yazdırıp çalıştırırız

        System.out.println("istedigimiz konum : "+driver.manage().window().getPosition()); //50, 50
        System.out.println("istedigimiz boyut : "+driver.manage().window().getSize());//516, 500


        Thread.sleep(3000);
        driver.close();


    }
}
