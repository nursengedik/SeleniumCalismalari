package seleniumSoruları;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_S23_WebDriverMethodları {

    public static void main(String[] args) throws InterruptedException {

        //önce gerekli ayarlamaları yapıp driver objesi oluşturalım
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver =new ChromeDriver();

       // 3. Amazon sayfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com/");

       // 4. Sayfa basligini(title) yazdirin
        System.out.println(driver.getTitle());
        //Amazon.com. Spend less. Smile more.

       // 5. Sayfa basliginin “Amazon” icerdigini test edin
        //sayfa başlıgının Amazon kelimesini içerip içermediğini test edeceğiz, eşit olmasını değil

        String expectedIcerik="Amazon";
        //sayfa başlığını nereden nasıl alacaksak actual değere o yazılır
        String actualTitle=driver.getTitle();

        if (actualTitle.contains(expectedIcerik)){
            System.out.println("Title Amazon içeriyor, test PASSED");
        }else {
            System.out.println("Title Amazon içermiyor, test FAILED");
        }
        //Title Amazon içeriyor, test PASSED

       // 6. Sayfa adresini(url) yazdirin
        System.out.println("Sayfa url : " + driver.getCurrentUrl());
        //Sayfa url : https://www.amazon.com/

        // 7. Sayfa url’inin “amazon” icerdigini test edin.
        String expectedURL="amazon";
        String actualURL=driver.getCurrentUrl();//url'yi buradan alacğım
        if (actualURL.contains(expectedURL)){
            System.out.println("Sayfa URL amazon içeriyor, test PASSED");
        }else {
            System.out.println("Sayfa URL amazon içermiyor, test FAILED");
        }
        //Sayfa URL amazon içeriyor, test PASSED


       // 8. Sayfa handle degerini yazdirin
        System.out.println(driver.getWindowHandle());
        //F0B05E092EFC4E3C2AD6FDC45A7C7053

       // 9. Sayfa HTML kodlarinda “alisveris” kelimesi gectigini test edin
        //sayfa HTML'e kodlarını driver.getPageSource(); methodu ile ulaşırız

        String expectedHTML="alisveris";
        String actualHTML=driver.getPageSource();
        if (actualHTML.contains(expectedHTML)){
            System.out.println("Sayfa HTML kodları alisveris içeriyor, test PASSED");
        }else {
            System.out.println("Sayfa HTML kodları alisveris içermiyor, test FAILED");
        }
        //Sayfa HTML kodları alisveris içermiyor, test FAILED


       // 10. Sayfayi kapatin.
        Thread.sleep(3000);
        driver.close();
    }









}
