package day05_relativeLocators_maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_MavenIlkClass {

    public static void main(String[] args) {

        //projemize pom.xml e </dependencies> ile selenium jar dosyaları yükledikten sonra chromedriver.exe dosya
        //yolunu sistemimize göstermeye gerek yok

        //maven ı projemize tanıtma
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");

        driver.close();


    }
}
