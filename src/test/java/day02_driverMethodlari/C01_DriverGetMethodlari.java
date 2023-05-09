package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_DriverGetMethodlari {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");


        WebDriver driver = new ChromeDriver();  //boş bir driver oluşur

        // bilgisayarimizdaki Chrome browser'in otomasyonla calisacak bir kopyasini olusturur
        //bilgisayarımızdaki normal browser'den farkı bu chromenin uzaktan kontrol edildiğini gösterir
        // Chrome disinda bir browser kullanmak istersek o browser'in driver'ini indirip
        //(selenium.dev/+Browser/safari indirilir)
        // System.setProperty("webdriver.safari.driver","safari driver'in dosya yolu")
        //WebDriver driver = new SafariDriver();

        // Olusturdugumuz driver objesi bizim elimiz, gozumuz gibidir

        driver.get("https://www.wisequarter.com");// istenen url'ye bizi goturur (wisequarter ın)
        // www yazmasak da calisir ancak https:// (heçtitipies) yazmazsak calismaz

        System.out.println(driver.getTitle()); // bize title'i (başlığı) dondurur
        // IT Bootcamp, Distance education method - Wise Quarter Course

        System.out.println(driver.getCurrentUrl()); // gidilen url'i dondurur
        // https://wisequarter.com/

        System.out.println(driver.getPageSource());//String getirir
        // gidilen web sayfasinin kaynak kodlarini dondurur

        System.out.println(driver.getWindowHandle()); // B5C6BBDE9C288E0ADB980B8C2C1A666A
        // acilan her bir pencereye verilen unique hash code degeridir

        System.out.println(driver.getWindowHandles()); // [BF8E71E46E92421DEFD0C6847D0D9D00]
        // eger driver calisirken birden fazla pencere veya tab olusturduysa
        // acilan tum windows/tab'lerin unique hash code'larini bir set olarak dondurur


        Thread.sleep(3000); // mili saniye olarak yazdigimiz sayi suresince kodu bekletir
        driver.close(); // acilan browser'i kapatir
        //amazona gidecek 5 sn bekleyecek ve kapatacak (son iki kod için)


    }
}
