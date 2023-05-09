package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_DriverNavigateMethodlari {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver");//sistem ayarları yapılır
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //navigate = yol gösteren
        //biz navigate ile ileri, geri ve yenileme işlemleri yapabiliyoruz

        //get ile navigate komutlarını kullanırken get komutu daha hızlı çalıştığı için tercih edilir
        //navigate komutu ise daha çok bağımlı durumlarda tercih edilir

        driver.get("https://www.amazon.com");
        Thread.sleep(2000);

        //amazondan sonra wisequartere gitmek istersek navigate kullanılır
        driver.navigate().to("https://www.wisequarter.com");
        Thread.sleep(2000);

        //amazona sonra da wisequarter a gittikten sonra yeniden amazon a dönmek istiyorsak adres girmemize gerek yok
        driver.navigate().back();//back = geri
        Thread.sleep(2000);

        //yeniden wisequarter a dönmek istiyorsam
        driver.navigate().forward();// forward = ileri
        Thread.sleep(2000);

        //istersek sayfayı yenileyebiliriz
        driver.navigate().refresh();// refresh = yenile
        Thread.sleep(2000);

        driver.close();
    }
}
