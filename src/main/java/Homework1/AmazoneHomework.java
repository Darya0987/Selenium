package Homework1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazoneHomework {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= new ChromeDriver();
        driver.get("https://www.amazon.com/");
        System.out.println(driver.getCurrentUrl());
        driver.manage().window().maximize();
        WebElement hello=driver.findElement(By.xpath("//a[@data-nav-ref='nav_ya_signin']"));
        hello.click();
        WebElement accountCreate=driver.findElement(By.id("createAccountSubmit"));
        accountCreate.click();
        Thread.sleep(1000);
        WebElement name= driver.findElement(By.name("customerName"));
        name.sendKeys("Darya Kovalyova");
        WebElement email= driver.findElement(By.id("ap_email"));
        email.sendKeys("sretvane@gmail.com");
        WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("1422Jasmina");
        WebElement repeatPassword=driver.findElement(By.xpath("//input[@name='passwordCheck']"));
        repeatPassword.sendKeys("1422Jasmina");
        Thread.sleep(3000);
        WebElement continueButton=driver.findElement(By.xpath("//input[@id='continue']"));
        continueButton.click();
    }
}
