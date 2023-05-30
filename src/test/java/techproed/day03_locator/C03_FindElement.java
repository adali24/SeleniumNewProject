package techproed.day03_locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C03_FindElement {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Amazon sayfasına gidelim
        //Sayfadaki linklerin sayısını ve linkleri yazdıralım
        driver.get("https://amazon.com");
        /*
findelement ile bir webelemente ulaşabilirken, birden fazla webelement için findelements() methodunu kullanırız.
Bu webelementlerin sayısına ulaşmak için ya da bu web elementlerin yazısını konsola yazdırabilmek için
List<Webelement> linklerLlistesi=driver.findelements(By.locator("locator değeri")) olarak kullanırız.
Oluşturmuş olduğumuz List'i loop ile konsola yazdırabiliriz
 */
        List<WebElement> linklerListesi = driver.findElements(By.tagName("a"));
        System.out.println("Linklerin sayisi = "+ linklerListesi.size());
        /*
        for (WebElement w:linklerListesi){
            if (!w.getText().isEmpty()){ // bos olan linkleri listeden cikarmak icin if () yaptik
                System.out.println(w.getText());
            }
        }
         */

        // lambda ile yazdiralim
        linklerListesi.forEach(link -> {if (!link.getText().isEmpty())
        {System.out.println(link.getText());}});

        //Shop deals in Electronics webElementin yazisini yazdir
        System.out.println("*************************************");
        System.out.println(driver.findElement(By.id("nav-link-accountList-nav-line-1")).getText());
        WebElement webElementYazisi =driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        System.out.println(webElementYazisi.getText());


        driver.close();
    }

}
