package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeSelenium {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        driver.navigate().to("https://www.google.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.navigate().to("https://www.guru99.com/java-oops-concept.html");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.navigate().to("https://quizizz.com/join/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.navigate().back();
        //Thread.sleep(3000);
        driver.navigate().forward();
        //Thread.sleep(3000);
        driver.navigate().refresh();
        driver.quit();

    }
}
