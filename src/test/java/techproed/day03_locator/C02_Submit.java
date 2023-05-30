package techproed.day03_locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Submit {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //Amazon sayfasına gidelim
        //Arama kutusunu locate edip iphone aratalım
        //Sayfayı kapatalım
        driver.get("https://www.amazon.com");
        WebElement aramaKutusu =  driver.findElement(By.name("field-keywords"));
        aramaKutusu.sendKeys("samsung");
        Thread.sleep(4000);
        aramaKutusu.submit();// submit = keys.ENTER demek

        driver.close();
    }
}
