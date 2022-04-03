package com.test.sentrifugo.test;

import com.test.sentrifugo.pages.LoginPageSntr;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestSntr {
    //    @Test
//    public void validateSuperAdmin(){
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.navigate().to("http://demo.sentrifugo.com/index.php/");
//        driver.manage().window().maximize();
//
//        WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
//        userName.sendKeys("EM01");
//
//        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
//        password.sendKeys("sentrifugo");
//
//        WebElement loginButton = driver.findElement(By.xpath("//input[@id='loginsubmit']"));
//        loginButton.submit();
//    }
    @Test
    public void validateSuperAdmin(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://demo.sentrifugo.com/index.php/");
        driver.manage().window().maximize();
        LoginPageSntr loginPage = new LoginPageSntr(driver);
        loginPage.dynamicLogin("EM05","sentrifugo");
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "http://demo.sentrifugo.com/index.php/index/welcome";
        Assert.assertEquals(actualURL,expectedURL);
    }
    @Test
    public void validateManagement(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://demo.sentrifugo.com/index.php/");
        driver.manage().window().maximize();
        LoginPageSntr loginPage = new LoginPageSntr(driver);
        loginPage.dynamicLogin("EM02","sentrifugo");
        String actualURL = driver.getTitle();
        String expectedURL = "Sentrifugo - Open Sourse HRMS";
        Assert.assertEquals(actualURL,expectedURL);
    }
}
