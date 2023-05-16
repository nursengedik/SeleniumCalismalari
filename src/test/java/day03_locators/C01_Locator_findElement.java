package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Locator_findElement {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        // arama kutusuna Nutella yazdirip

        /*
            Test otomasyonu yaparken
            bir webelementi kullanmak istersek 2 seye ihtiyacimiz var
            1- o webelementi benzersiz olarak tarif edebilecegimiz bir locator
            2- bu locator'i soyledigimizde bize web elementi bulup getirecek method

            ornegin amazon sitesindeki arama kutusunun unique tarif edicisi olarak
            id = "twotabsearchtextbox" kullanabiliriz
         */
         //locator sırası ile Ctrl+C,F,V
        // driver a id si "twotabsearchtextbox" olan elementi bulup getir demek için "findElement (By by)"
        // (bu elementi bul) methodunu kullanıyoruz ve bize WebElement getiriyor ve biz bunu kaydetmek istiyorsak
        //eşitliğin sol tarafına WebElement data türünde bir obje oluşturmamız gerekir
        //findElement(By by) methodu, bulayım da neyle bulayım yani locator ı (lokeytırı) ne ve parametreleri girilir

        //Selenium bize 6 tane locator ayarlamış : id, className, LinkText (linkin yazısı), partialLinkText (linkin
        // yazısının bir kısmı veya parçacıkları), name, tagName (<a) bunun dışında 7. ve 8. en güçlü olanlar var
        //xpath ve cssSelector (en çok xpath kullanılır sonra cssSelector)

        //arama kutusunu id ile tarif edeceğiz
        //biz driver a, findElement ile git bu elementi bul getir diyoruz,(By.id("twotabsearchtextbox")) By id
        //özelliği ile

        WebElement aramaKutusuElementi = driver.findElement(By.id("twotabsearchtextbox"));
        //data turu   objenin adi       =  findElement : webelementi bulan method
        //                                 By : webelementi bulacagimiz locator'in turunu yazdigimiz method
        //                                 twotabsearchtextbox : unique tarif icin id attribute (etribüt) degeri

        //driver a findElement yani şu elementi getir, hangi özelliğiyle id siyle,peki id si ne?
        // "twotabsearchtextbox" bu işlemle aramaKutusu benim class ıma tarif edilmiş durumdadır,
        // arama kutusu ile ilgili istediğimiz işlemleri
        //yapabiliriz, sadece o elementi bulup kaydettik ama görevimizi bitirmedik

          /*
            findElement() verdigimiz locator turu ve o lacator icin verdigimiz degere gore
            webelement'i arar
            locator icin verdigimiz deger hataliysa veya
            locator stratejisinde hata yaptiysak
            aranan web elementi implicitlyWait olarak tanimladigimiz
            maximum sure boyunca arar
            bulamadigi icin "NoSuchElementException" firlatir ve
            kodlarin kalanini calistirmaz
            Bir kod çalıştığında"NoSuchElementException" hatası alıyorsak
            locator da bir hata var demektir
         */

        //aramaKutusuElementi ne Nutella yazısını göndermeliyiz
        aramaKutusuElementi.sendKeys("Nutella");
        // istenen webelement'e istenen yaziyi gonderir

        // Enter tusuna basarak arama yapin
        aramaKutusuElementi.submit();//submit enter tuşu için kullanılır
        // istenen web elementi uzerinde enter tusuna basar


        Thread.sleep(7000);
        driver.close();
    }
}