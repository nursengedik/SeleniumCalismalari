package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_WebElementMethodlari {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // amazon anasayfaya gidip arama kutusunu locate
        driver.get("https://www.amazon.com");

        //arama kutusunu locator (lokyt) etme
        WebElement aramaKutusuElementi =driver.findElement(By.id("twotabsearchtextbox"));

        System.out.println(aramaKutusuElementi.isDisplayed());//arama kutusu görünüyor mu -true döndürür

        System.out.println(aramaKutusuElementi.isEnabled());//ulaşılabiliyor mu, etkileşime açık olup oladığını sorar-true

        System.out.println(aramaKutusuElementi.getText());//o elementin üzerinde yazı varsa onu getirir, her elementin
        //  üzerinde yazı olmak zorunda değildir, çalıştırınca hiçlik döndürdü


        aramaKutusuElementi.sendKeys("Nutella");//arama kutusuna Nutella yazısını göndeririz, yani aratır
        Thread.sleep(2000);//2 sn bekler
        aramaKutusuElementi.clear();//arama kutusuna Nutella yı yazdırır sonra da siler

        //boyutlarla ilgili çok test yapılmaz
        System.out.println(aramaKutusuElementi.getSize());//arama kutusunun boyutlarını verir - (618, 38)
        System.out.println(aramaKutusuElementi.getSize().height);// arama kutusunun yüksekliğini verir - 38

        System.out.println(aramaKutusuElementi.getTagName());//arama kutusunun tagname nedir - input
        System.out.println(aramaKutusuElementi.getAttribute("class"));//class attribute nün değeri nedir
        //nav-input nav-progressive-attribute

        System.out.println(aramaKutusuElementi.getLocation());//nerede olduğunu piksel olarak konumu verir(279, 11)
        System.out.println(aramaKutusuElementi.getRect().getDimension());//dikdörtgen olarak özelliklerini buluyor(618, 38)

        //is.Selected() web elementi seçmek için kullanılır
        Thread.sleep(3000);
        driver.close();

    }
}
