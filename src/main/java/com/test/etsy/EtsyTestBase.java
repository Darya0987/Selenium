package com.test.etsy;

import Utils.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class EtsyTestBase {
    public WebDriver driver;
    @BeforeMethod
    public void setup(){

        driver = Driver.getDriver();
        driver.get("https://www.etsy.com/");

    }

    @AfterMethod
    public void tearDown(){

       // Driver.tearDown();
    }
}
