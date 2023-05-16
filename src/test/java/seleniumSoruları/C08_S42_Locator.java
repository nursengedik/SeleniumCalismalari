package seleniumSoruları;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C08_S42_Locator {

    public static void main(String[] args) {

       //Automation Exercise Category Testi
       //1- Bir test class’i olusturun ilgili ayarlari yapin

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

       //2- https://www.automationexercise.com/ adresine gidin
        driver.get("https://www.automationexercise.com/");

       //3- Category bolumundeki elementleri locate edin
        //WebElement
       //4- Category bolumunde 3 element oldugunu test edin
       //5- Category isimlerini yazdirin
       //6- Sayfayi kapatin
    }
}
