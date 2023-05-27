package techproed.day02_DriverMethods;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C3_ManegeMethods {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Browser'ın konumunu yazdıralım
        System.out.println("Sayfanin konumu = "+driver.manage().window().getPosition());

        //Browser'ın boyutlarını yazdıralım
        System.out.println("Sayfanin boruylari = "+driver.manage().window().getSize());


        //Browser'ı maximize yapalım
        driver.manage().window().maximize();

        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com/");

        //Browser'ın konumunu yazdıralım
        System.out.println("Sayfanin konumu = "+driver.manage().window().getPosition());


        //Browser'ın boyutlarını yazdıralım
        System.out.println("Sayfanin boruylari = "+driver.manage().window().getSize());
        Thread.sleep(3000);

        //Sayfayı minimize yapalım
        driver.manage().window().minimize();
        Thread.sleep(3000);



        //Sayfayı fullScreen yapalım
        driver.manage().window().fullscreen();

        driver.manage().window().setPosition(new Point(50,50)); //istedigimiz konuma getirir
        driver.manage().window().setSize(new Dimension(600,600));//istediğimiz size'a getirir

        //sayfayı kapatınız
        driver.close();



    }
}
