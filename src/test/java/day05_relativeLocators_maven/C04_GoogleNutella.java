package day05_relativeLocators_maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_GoogleNutella {

    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

       //2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");

       //3- cookies uyarisini kabul ederek kapatin
        //driver.findElement(By.xpath("(//div[@class='QS5gu sy4vM'])[2]")).click();

       //4- Sayfa basliginin “Google” ifadesi icerdigini test edin

        String expectedIcerik="Google";
        String actualTitle= driver.getTitle();

        if (actualTitle.contains(expectedIcerik)){
            System.out.println("Title testi PASSED");
        }else{
            System.out.println("Title testi FAILED");
        }
        //Title testi PASSED

       //5- Arama cubuguna “Nutella” yazip aratin
        WebElement aramaKutusu=driver.findElement(By.xpath("//*[@name='q']"));

        //Nutella yazısını yazdıracağız
        aramaKutusu.sendKeys("Nutella");
        aramaKutusu.submit();//araması için enter tuşunu gönderme

       //6- Bulunan sonuc sayisini yazdirin
        WebElement sonucYaziElementi= driver.findElement(By.id("result-stats"));

        //web elementi direk yazdıramıyoruz, getText ile sout yapılır
        System.out.println(sonucYaziElementi.getText());
        //Yaklaşık 126.000.000 sonuç bulundu (0,47 saniye) döndürür

       //7- sonuc sayisinin 10 milyon’dan fazla oldugunu (text'i) test edin
        //bize verilen text, sonuç yazısının içerisinden 126.000.000 nasıl alabiliriz
        //sonuç yazısı hem string hem de sayı ifadelerinden oluştuğu için yazının içinden sayıyı almalıyız

        //text i string bir veriable la atarız, kaydederiz
        String sonucYazisiStr= sonucYaziElementi.getText();
        //string olan text timizi split kullanarak space lerden ayırıp,böleriz array e atarız
        String[] sonucYaziKelimeleriArr = sonucYazisiStr.split(" ");
        //bulduğumuz sonuç kacıncı element olur
        String sonucSayiAdediStr=sonucYaziKelimeleriArr[1]; // 126.000.000
        //rakam olmayanlardan kurtulma (126.000.000)
        sonucSayiAdediStr = sonucSayiAdediStr.replaceAll("\\D",""); // "162000000"
       // "126000000" hala string olduğu için Integer.parseInt ile int çevrilir
      int sonucSayisiInt= Integer.parseInt(sonucSayiAdediStr);

      if (sonucSayisiInt>10000000){
          System.out.println("sonuc sayisi testi PASSED");
      }else{
          System.out.println("Sonuc sayisi testi FAILED");
      }
       //8- Sayfayi kapatin
       Thread.sleep(3000);
       driver.close();

        /*
          Title testi PASSED
          Yaklaşık 126.000.000 sonuç bulundu (0,47 saniye)
          sonuc sayisi testi PASSED

         */
    }
}
