package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_findElements {

    public static void main(String[] args) throws InterruptedException {

        //1- Bir test class’i olusturun ilgili ayarlari yapin

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2- https://www.automationexercise.com/ adresine gidin
        driver.get("https://www.automationexercise.com/");

        //3- Category bolumundeki elementleri locate edin
        // öncelikle manuel olarak istenen sayfaya gitmeliyiz, CATEGORY den birinin üzerine gelinir ve sağ tuş
        // İncele (İnspect) denir, html kodlarından Ctrl+F ile classname ı ("panel-title") yazıp kontrol edilir,
        // kategorileri veriyorsa classname locator olarak kullanılır, yani biz bu classname locator ını kullanarak
        // ve panel-title değeriyle locate edebilirim. panel-title By.classname de boşluk içermediği için
        // kullanılabilir 3 element getireceği için findElements kullanılır

        List<WebElement> categoryElementsList =driver.findElements(By.className("panel-title"));

        //4- Category bolumunde 3 element oldugunu test edin

        int expectedSize=3;
        int actualSize=categoryElementsList.size();

        if (expectedSize==actualSize){
            System.out.println("Category element testi PASSED");
        }else {
            System.out.println("Category element testi FAILED");
        }

        //5- Category isimlerini yazdirin

        /*  System.out.println(categoryElementsList);
            Normalde bir list direk yazdirilabilir
            Ancak findElements() ile bulunan elementler WebElement oldugundan direk YAZDIRILAMAZ
            bir for-each loop kullanilarak listenin elementleri yazdirilabilir
         */

        for (WebElement eachElement :categoryElementsList //WebElement lerle ugraşacağım, adı eachElement olsun,
        ) {                                      //bunları da categoryElementsList tinden alacağım
            System.out.println(eachElement.getText());//herbir eachElement in getText ini al, yani herbir webelementi
            //getir onun üzerindeki yazıyı getText ile al

        }
        //Run ettiğimizde

         /*
           Category element testi PASSED
           WOMEN
           MEN
           KIDS     bize döndürür
         */

        //6- Sayfayi kapatin
        Thread.sleep(3000);
        driver.close();
    }
}
