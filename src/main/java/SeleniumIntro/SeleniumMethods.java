package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumMethods {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        driver.navigate().to("https://www.google.com/");

        //Thread.sleep(3000);
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        //System.out.println(driver.getPageSource());
       driver.navigate().to("https://www.techtorialacademy.com/");
       //Thread.sleep(3000);
        driver.navigate().back();
        //Thread.sleep(3000);
        driver.navigate().forward();
        //Thread.sleep(3000);
        driver.navigate().refresh();
        driver.close();
    }
}
