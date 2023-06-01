package techproed.day05_XpathCssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class C03_relativeLocators {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
/*
    i)Benzer ozelliklere sahip webelementler icin relative locator kullanabiliriz
   ii)Syntax ==> driver.findElement(with(By.tagname).below().above().to_left_of().to_right_of().near()) gibi
      methodlar ile benzer ozelliklere sahip webelementleri locatini almadan o webelemente ulasabiliriz
 */
        // https://www.amazon.com sayfasına gidiniz
        driver.get("https://www.amazon.com");

        // arama kutusuna "city bike"  yazıp aratın
        WebElement aramaKutusu2 = driver.findElement(By.xpath("//input[@type='text']"));
        aramaKutusu2.sendKeys("city bike", Keys.ENTER);

        //relative locator kullanarak hybrid bike altindaki elemente tiklayalim
        WebElement hybridBikes = driver.findElement(By.xpath("//span[text()='Hybrid Bikes']"));
        WebElement electiricBike = driver.findElement(with(By.tagName("a")).below(hybridBikes));
        electiricBike.click();



    }
}
