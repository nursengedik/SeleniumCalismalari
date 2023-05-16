package seleniumSoruları;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_S31_WebDriverMethodları {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

       // 2. Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını
       // doğrulayın (verify), eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.

       // Youtube web sayfasına gidin
        driver.get("https://www.youtube.com");

        //sayfa başlığının “youtube” olup olmadığını doğrulayın (verify),
        // eğer değilse doğru başlığı (Actual Title) konsolda yazdirin.
        //System.out.println(driver.getTitle());//YouTube

        String expectedTitle="youtube";
        String actualTitle=driver.getTitle();//başlığı getirecek
        if (actualTitle.equals(expectedTitle)){//eşit ise
            System.out.println("Sayfanın başlığı : youtube");
        }else {//eşit değilse
            System.out.println("Sayfanın başlığı : " + actualTitle);
        }

        // 3. Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa
       // doğru URL'yi yazdırın.
       //System.out.println(driver.getCurrentUrl());//url'i döndürür - https://www.youtube.com/

        String expectedURL="youtube";
        String actualURL=driver.getCurrentUrl();
        if (actualURL.contains(expectedURL)){
            System.out.println("Sayfa URL'i youtube içeriyor");
        }else {
            System.out.println("Sayfa URL : " + actualURL);
        }

        // 4. Daha sonra Amazon sayfasina gidin https://www.amazon.com/
        //youtube'den sonra amazona gitme
        driver.navigate().to("https://www.amazon.com/");

       // 5. Youtube sayfasina geri donun
        //tekrar geri dönme
        driver.navigate().back();

       // 6. Sayfayi yenileyin
        driver.navigate().refresh();

       // 7. Amazon sayfasina donun
        //tekrar ileri gitme
        driver.navigate().forward();

       // 8. Sayfayi tamsayfa yapin
        driver.manage().window().maximize();

       // 9. Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın,
        // Yoksa doğru başlığı(Actual Title) yazdırın.
        //System.out.println(driver.getTitle());//Amazon.com. Spend less. Smile more.

        String expectedBaslık="Amazon";
        String actualBaslık=driver.getTitle();
        if (actualBaslık.contains(expectedBaslık)){
            System.out.println("Sayfa başlığı Amazon içeriyor");
        }else {
            System.out.println("Sayfanın başlığı : " + actualBaslık);
        }
        //Sayfa başlığı Amazon içeriyor

       // 10.Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse
       // doğru URL'yi yazdırın
        //System.out.println(driver.getCurrentUrl());//https://www.amazon.com/

        String expectedURL2="https://www.amazon.com/";//istenen değer
        String actualURL2=driver.getCurrentUrl();//beklenen değer
        if (actualURL2.equals(expectedURL2)){
            System.out.println("Sayfanın URL : " + expectedURL2);
        }else {
            System.out.println("Sayfanın URL : " + actualURL2);
        }

       // 11.Sayfayi kapatin
        Thread.sleep(3000);
        driver.close();
    }
}
