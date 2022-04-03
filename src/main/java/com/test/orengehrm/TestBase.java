package com.test.orengehrm;

import Utils.BrowserUtils;
import Utils.ConfigReader;
import Utils.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    public WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = Driver.getDriver();
        driver.get(ConfigReader.readProperty("urlorangehrm"));


    }

    @AfterMethod
    public void tearDown(ITestResult result){
        if(!result.isSuccess()){
            BrowserUtils.getScreenshot(driver,"OrangeHrmScreenshot");
        }
        Driver.tearDown();
    }
}
