package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_IlkTest {
    public static void main(String[] args) throws InterruptedException {

        // once gerekli ayarlamalari yapip driver objesi olusturmaliyiz
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");

        WebDriver driver= new ChromeDriver();// driverimiz oluştu ve istediğimiz yere gidebiliriz
        //WebDriver driver= new WebDriver() objemiz newWebDriver i kabul etmez


        //3. Amazon sayfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com/");// istenen url'ye bizi goturur


        //4. Sayfa basligini(title) yazdirin
        System.out.println("Sayfa basligi : " + driver.getTitle());
        //Sayfa basligi : Amazon.com. Spend less. Smile more.

        //5. Sayfa basliginin “Amazon” icerdigini test edin
        //sayfa başlığının eşittir Amazon olmasını değil Amazon içerip içermediğini test etmek istiyoruz

        //yazilim testi beklenen degerlerin gerceklesip gerceklesmedigini test etmektir
        //test edebilmek için her zaman iki değere ihtiyacımız var: Expected Result ve Actual Result
        //yani istenen ve beklenen değerler


        String expectedIcerik = "Amazon";//bize testte denilen istenen değerlerdir
        String actualTitle = driver.getTitle();//sayfa başlığını getTitle() methodu ile alırız
        //actual her zaman driver ile gidip sayfadan  aldığımız değerler gerçek değerlerdir


        if (actualTitle.contains(expectedIcerik)){//actualTitle contains(expectedIcerik) yani amazonu içeriyorsa
            System.out.println("Title Amazon iceriyor, Test PASSED");//test başarılı, geçti yazdır
        }else {
            System.out.println("Title Amazon icermiyor, Test FAILED");//test başarısız yazdırır
        }
        //Title Amazon iceriyor, Test PASSED


        //6. Sayfa adresini(url) yazdirin
        System.out.println("Sayfa url :" + driver.getCurrentUrl());
        //Sayfa url :https://www.amazon.com/

        //7. Sayfa url’inin “amazon” icerdigini test edin.

        expectedIcerik = "amazon";
        String actualUrl= driver.getCurrentUrl();

        if (actualUrl.contains(expectedIcerik)){
            System.out.println("Url amazon iceriyor, URL test PASSED");
        } else {
            System.out.println("Url amazon icermiyor, URL test FAILED");
        }
        //Url amazon iceriyor, URL test PASSED

        //8. Sayfa handle degerini yazdirin
        System.out.println("Sayfanın handle değeri: " + driver.getWindowHandle());
        //Sayfanın handle değeri: 827B6C5177BA47243E072EC9FD46BAC9

        //9. Sayfa HTML kodlarinda “alisveris” kelimesi gectigini test edin

        expectedIcerik="alisveris";
        String actualPageSource= driver.getPageSource();//PageSource : sayfa kaynağı demek

        if (actualPageSource.contains(expectedIcerik)){
            System.out.println("Sayfa kaynak kodlari alisveris iceriyor, test PASSED");
        }else {
            System.out.println("Sayfa kaynak kodlari alisveris icermiyor, test FAILED");
        }

        //Sayfa kaynak kodlari alisveris icermiyor, test FAILED

        //10. Sayfayi kapatin.
        Thread.sleep(3000);//3 sn bekle demektir, yazdığımızda sleep in altını kırmızı ile çizer, nedeni
        //ya bekleyemezsem diye, mausla üzerine gelinir ve Add exception to method signature seçilir, yani
        //bekleyemediğinde ya da uyuyamadığında exception fırlat denir ve main methodun yanında throws ile yazar
        driver.close();

    }
}
