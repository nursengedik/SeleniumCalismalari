package day04_xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Xpath {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

       //2- Add Element butonuna basin
        //burada webelement oluşturup kaydetmeden de yapabiliriz, yani istenen elementi locator (lokeyt edip)
        //click tuşuna bastık

        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();

       //3- Delete butonu’nun gorunur oldugunu test edin
        //öncelikle sayfadan locator edip,xpath ini bulup kaydederiz çünkü testte kullanacağız
        WebElement deleteButtonElementi=driver.findElement(By.xpath("//button[@class='added-manually']"));
        //xpath parantezi içine html kodlarından 1 of 1 olanı yazarız

        //görünür olduğunu test etme
        if (deleteButtonElementi.isDisplayed()){//eğer delete butonu görünüyorsa
            System.out.println("Delete button testi PASSED");
        }else {
            System.out.println("Delete button testi FAILED");
        }

        Thread.sleep(3000);
        //4- Delete tusuna basin
        deleteButtonElementi.click();

       //5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin
        WebElement addElementsElementi=driver.findElement(By.xpath("//h3"));

      // driver.findElement(By.tagName("h3")); böyle de yapabilirdik

        //görünür olduğunu test etme
        if (addElementsElementi.isDisplayed()){//eğer add butonu görünüyorsa
            System.out.println("Add/Remove Elements testi PASSED");
        }else {
            System.out.println("Add/Remove Elements testi FAILED");
        }

       /*
         Delete button testi PASSED
         Add/Remove Elements testi PASSED
       */

        Thread.sleep(3000);
        driver.close();

    }
}
