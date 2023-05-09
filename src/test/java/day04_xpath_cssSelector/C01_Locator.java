package day04_xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_Locator {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //	1- https://www.amazon.com/ sayfasına gidin.
        driver.get("https://www.amazon.com/");

       //  2- Arama kutusuna “city bike” yazip aratin
        //öncelikle arama kutusuna gidilir yani locator (lokeyt) edilir daha sonra arama kutusuna city bike yazdırılır
        WebElement aramaKutusuElementi = driver.findElement(By.id("twotabsearchtextbox"));//locator ettik

        aramaKutusuElementi.sendKeys("city bike" + Keys.ENTER); //city bike yaz enter tuşunu çalıştır
        //enter tuşu için submit() yerine Keys. dediğimizde klavyemizdeki tuşlar gelir ve kullanılır

        //	3- Görüntülenen sonuçların sayısını yazdırın
        //city bike yazdırdığımızda 244 sonuç buluyor ve bu yazıyı nasıl yazdırabiliriz
        //bu webelementini locator edip tag ını ve değerini bulur kaydederiz
        WebElement aramaSonucuElementi = driver.findElement(By.className("sg-col-inner"));

        //sonuç yazısını yazdırırız ama webelementler direk yazdırılamaz
        System.out.println(aramaSonucuElementi.getText());
        //sayfada bulduğu sonuç cümlesini getirir - 1-16 of 244 results for "city bike"

        //	4- Listeden ilk urunun resmine tıklayın.
        List<WebElement> urunResimElementleriList = driver.findElements(By.className("s-image"));
        //ürünleri listeleyip kaydettik

        //ilk ürünün resmini alıp tıklamak
        urunResimElementleriList.get(0).click();



        Thread.sleep(4000);
        driver.close();
    }
}
