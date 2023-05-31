package techproed.day04_locators_xpath_css;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_WebElementLocatotor {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // https://www.amazon.com sayfasına gidiniz
        driver.get("https://www.amazon.com");

        // arama kutusuna "city bike" yazıp aratın
        driver.findElement(By.id("twotabsearchtextbox") ).sendKeys("city bike", Keys.ENTER);

        // sonuc yazısını yazdırın
       List <WebElement> sonucYazisi = (List<WebElement>) driver.findElements(By.className("sg-col-inner"));
        System.out.println(sonucYazisi.get(0).getText());


        // sonuc sayısını yazdırın
        String[]sonucSayisi = sonucYazisi.get(0).getText().split(" ");
        System.out.println("Sonuc sayisi =" +sonucSayisi[2]);

        //xpath ile list kulllanmadan tek seferde locate aldik
        WebElement sonucyazisiXpath =driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        System.out.println("Xpath ile sonus yazisi ="+sonucyazisiXpath.getText());





        // ilk ürünün locatini alın
        List<WebElement> urunler = driver.findElements(By.className("s-image") );
        WebElement ilkUrun=urunler.get(0);


        // ilk ürünün, görünür olup olmadıgını true, false seklinde yazdırın
        System.out.println(ilkUrun.isDisplayed());

        // ilk ürünün, erisilebilir olup olmadıgını true, false seklinde yazdırın
        System.out.println(ilkUrun.isEnabled());

        // ilk ürünün, secilebilir olup olmadıgını true, false seklinde yazdırın
        System.out.println(ilkUrun.isSelected());// false doner cunku WebElement secilme ozelligine sahip degil

        // ilk urune tıklayın
        ilkUrun.click();

        // webelementin uzerine tiklar


        // sayfayı kapatın
        driver.close();
        /*
        //ARAMA KUTUSUNUN HTML KODLARI
        <input type="text" id="twotabsearchtextbox" value="" name="field-keywords" autocomplete="off"
         placeholder="Search Amazon" class="nav-input nav-progressive-attribute" dir="auto"
         tabindex="0" aria-label="Search Amazon" spellcheck="false">
         */
        //Relative Xpath syntax -->  //tagname[@attributeName='attributeValue']

        //input[@type='text']
        //                           (//input[@type='text'])[1]
        /*
       Aldigimiz xpath unique olmadigi zaman xpath' imizi parantez icine alarak index belirtebiliriz.
        Boylelikle webelementi List' e atip istedigimiz elementi almakla ugrasmayiz
        Xpathi ın degısık kullanma yolları vardır
         */

    }
}
