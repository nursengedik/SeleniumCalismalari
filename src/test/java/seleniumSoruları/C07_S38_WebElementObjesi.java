package seleniumSoruları;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_S38_WebElementObjesi {

    public static void main(String[] args) throws InterruptedException {

        //Amazon Arama Testi

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

       //2- https://www.amazon.com adresine gidin
        driver.get("https://www.amazon.com");

       //3- amazon arama kutusunu locate edin
        //Webelementin locator'ını alarak locate (lokeyt) edip kaydederiz
        WebElement aramaKutusuElementi=driver.findElement(By.id("twotabsearchtextbox"));

       //4- arama kutusuna “Nutella” yazdirin
        //Webelement methodlarını kullanarak aramaKutusuElementi'mize Nutella yazdıracağız
        aramaKutusuElementi.sendKeys("Nutella");

       //5- arama islemini yapabilmek icin ENTER tusuna basin
        aramaKutusuElementi.submit();

        Thread.sleep(3000);
        driver.close();
    }
}
