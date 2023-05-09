package day01_driverOlusturma;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_WebDriverIlkClass {

    public static void main(String[] args) {

         //chromedriver.exe i her class ta ekleyeceğiz
        // her class ta ilk yapmamız gereken bir WebDriver oluşturmak, WebDriver oluşturabilmek için de
        // chromedriver.exe dosyasını bu class a tanıtmamız gerekiyor, her classta da o class a tanıtmak gerekiyor
        //Javadaki System class ından  setProperty özelliğini kullanılarak

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");


         //iki parametre ister
        //2. parametreye chromedriver.exe dosyasının yolu yazılır, dosya yolu chromedriver.exe dosyasının üzerinde
        //sağ tıklanır Copy Path/ Path From Content Root otomatik kopyalama yapar ve 2. parametreye yapıştırılır

        //windows kullanıcılarında sonda .exe olmalı
        //mac kullanıcılarında .exe olmayacak

        WebDriver driver = new ChromeDriver();//boş bir webdriver oluşturur

        // oluşturduğumuz WebDriver resources'ın altındaki chromedriver.exe
        //dosyasını kullanarak Google Chrome'nin bir kopyasını oluşturuyor
        //biz de adına driver dediğimiz objede bunu kaydediyoruz
        //Run tuşuna bastığımızda boş bir chromeDriver objesi oluşturmuş olur

        driver.get("https://www.amazon.com");// istenen url'e bizi goturur







    }
}
