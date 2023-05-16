package seleniumSoruları;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_S30_WebDriverMethodları {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

       // 2.ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin
       //(title) “facebook” oldugunu dogrulayin (verify), degilse dogru basligi yazdirin.
        //ChromeDriver kullanarak, facebook sayfasina gidin
        driver.get("https://www.facebook.com");

        //sayfa başlığının (title) “facebook” oldugunu dogrulayin
        // System.out.println(driver.getTitle());//Facebook - Giriş Yap veya Kaydol

        String expectedTitle="facebook";
        String actualTitle=driver.getTitle();
        if (actualTitle.equals(expectedTitle)){//eşit mi, aynı mı, eşit ise
            System.out.println("Sayfa başlığı facebook");
        }else {
            System.out.println("Sayfanın başlığı : " + actualTitle);
        }
        //Test FAILED


       // 3.Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa
       //   “actual” URL’i yazdirin.
        //System.out.println(driver.getCurrentUrl());//https://www.facebook.com/

        String expectedURL="facebook";
        String actualURL=driver.getCurrentUrl();
        if (actualURL.contains(expectedURL)){
            System.out.println("Sayfa URL'li facebook içeriyor");
        }else {
            System.out.println(actualURL);
        }

       // 4.https://www.walmart.com/ sayfasina gidin.
        //bir web sayfasındayken başka bir web sayfasına gitmek için  driver.navigate.to() methodunu kullanırız
        driver.navigate().to("https://www.walmart.com/");

       // 5. Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
        //System.out.println(driver.getTitle());//sayfa baçlığını verir - Walmart.com | Save Money. Live Better

        String expectedBaslık="Walmart.com";
        String actualBaslık=driver.getTitle();
        if (actualBaslık.contains(expectedBaslık)) {
            System.out.println("Baslık Walmart.com içeriyor, test PASSED");
        }else {
            System.out.println("Baslık Walmart.com içermiyor, test FAILED");
        }

       // 6. Tekrar “facebook” sayfasina donun
        driver.navigate().back();

       // 7. Sayfayi yenileyin
        driver.navigate().refresh();

       // 8. Sayfayi tam sayfa (maximize)
        driver.manage().window().maximize();

        // 9.Browser’i kapatin

        Thread.sleep(3000);
        driver.close();
    }
}
