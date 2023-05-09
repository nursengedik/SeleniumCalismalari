package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_Sayfa27 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

       //2. Amazon soyfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com/");

       //3. Sayfanin konumunu ve boyutlarini yazdirin
        System.out.println("Sayfanın konumu : " + driver.manage().window().getPosition());
        System.out.println("Sayfanın boyutları : " + driver.manage().window().getSize());
        Thread.sleep(1000);

       //4. Sayfayi simge durumuna getirin
        driver.manage().window().minimize();

       //5. simge durumunda 3 saniye bekleyip sayfayi maximize yapin
        Thread.sleep(3000);
        driver.manage().window().minimize();

       //6. Sayfanin konumunu ve boyutlarini maximize durumunda yazdirin
        //sayfayı en son maximize durumuna getirdiğimiz için direk boyutlarını alırız
        System.out.println("Maximize sayfanın konumu : " + driver.manage().window().getPosition());
        System.out.println("Maximize sayfanın boyutları : " + driver.manage().window().getSize() );
        Thread.sleep(1000);

       //7. Sayfayi fullscreen yapin
        driver.manage().window().fullscreen();
        Thread.sleep(1000);

       //8. Sayfanin konumunu ve boyutlarini fullscreen durumunda yazdirin
        System.out.println("Fullscreen sayfanın konumu : " + driver.manage().window().getPosition());
        System.out.println("Fullscreen sayfanın boyutları : " + driver.manage().window().getSize());
        Thread.sleep(1000);

       //9. Sayfayi kapatin
        driver.close();
    }
}
