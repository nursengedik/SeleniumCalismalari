package seleniumSoruları;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_S29_DriverManageMethodları {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

       // 2. Amazon soyfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com/");

       // 3. Sayfanin konumunu ve boyutlarini yazdirin
        System.out.println("Sayfanın konumu : " + driver.manage().window().getPosition());//sayfanın konumunu verir
        System.out.println("Sayfanın boyutları : " + driver.manage().window().getSize());//sayfanın boyutlarını verir
       /*
         Sayfanın konumu : (-8, -8)
         Sayfanın boyutları : (1382, 744)
      */

       // 4. Sayfanin konumunu ve boyutunu istediginiz sekilde ayarlayin
        //önce istediğimiz değerleri girip güncelleriz
        driver.manage().window().setPosition(new Point(50,50));//set günceller
        driver.manage().window().setSize(new Dimension(500,500));
        //istediğimiz değerleri girdikten sonra yazdırırız
        System.out.println("Sayfa yeni konum : " + driver.manage().window().getPosition());//get getirir
        System.out.println("Sayfa yeni boyut : " + driver.manage().window().getSize());

       /*
         Sayfa yeni konum : (50, 50)
         Sayfa yeni boyut : (516, 500)
      */

       // 5. Sayfanin sizin istediginiz konum ve boyuta geldigini test edin



       // 8. Sayfayi kapatin
        Thread.sleep(3000);
        driver.close();
    }
}
