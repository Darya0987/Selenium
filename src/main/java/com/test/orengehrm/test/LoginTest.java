package com.test.orengehrm.test;


import Utils.ConfigReader;
import com.test.orengehrm.DataForNegativeTest;
import com.test.orengehrm.TestBase;
import com.test.orengehrm.pages.LoginPage;
import com.test.sentrifugo.pages.LoginPageSntr;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    LoginPage loginPage;
    @BeforeMethod
    public void initializePage(){
       loginPage=new LoginPage(driver);
    }
//    WebDriver driver;
//
//    @BeforeMethod
//    public void setup() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
//        driver.manage().window().maximize();
//        System.out.println("i am running before every test annotation");
//    }

    @Test
    public void validateLoginPositive() {
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
//        driver.manage().window().maximize();
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.login("Admin", "admin123");
        loginPage.login(ConfigReader.readProperty("orangehrmusername"),ConfigReader.readProperty("orangehrmpassword"));
//        String actualUrl = driver.getCurrentUrl();
//        String expectedUrl = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/index.php/auth/login");
    }

    @Test(dataProvider = "LoginNegativeTestScenario",dataProviderClass = DataForNegativeTest.class)
    public void validateLoginNegative1(String username, String password, String expectedMessage) {
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
//        driver.manage().window().maximize();

//        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
//        String actualErrorMessage = loginPage.getErrorMessage();
//        String expectedErrorMessage = expectedMessage;
        Assert.assertEquals(loginPage.getErrorMessage(), expectedMessage);
    }

    @Test
    public void validateLoginNegative2() {
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
//        driver.manage().window().maximize();
//        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("", "");
        String actualErrorMessage = loginPage.getErrorMessage();
        String expectedErrorMessage = "Username cannot be empty";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
        String actualColorOfErrorMessage = loginPage.getColorOfTheErrorMessage();
        String expectedColorOfErrorMessage = "rgba(221, 119, 0, 1)";
        Assert.assertEquals(actualColorOfErrorMessage, expectedColorOfErrorMessage);
    }

//    @AfterMethod
//    public void tearDown() {
//        System.out.println("I am running after each test annotation");
//        driver.quit();
//
//    }
}
