package JavaScriptExecutor;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaScript {
    @Test
    public void TitleMethod(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.techtorialacademy.com/");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle()+"from driver");
//        JavascriptExecutor javascriptExecutor=(JavascriptExecutor) driver;
//        String title=javascriptExecutor.executeScript("return document.title").toString();
//        System.out.println(title+"from javaScript");
        String actualTitle= BrowserUtils.GetTitleWithJS(driver);
        String expectedTitle="Home Page - Techtorial";
        Assert.assertEquals(actualTitle,expectedTitle);
    }
    @Test
    public void browserBox(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.techtorialacademy.com/");
        driver.manage().window().maximize();
       // JavascriptExecutor javascriptExecutor=(JavascriptExecutor) driver;
        WebElement browserCourse=driver.findElement(By.xpath("//a[.='Browse Course']"));
       // javascriptExecutor.executeScript("arguments[0].click()",browserCourse);
        BrowserUtils.ClickWithJS(driver,browserCourse);
    }
    @Test
    public void ClickWithJS(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.techtorialacademy.com/");
        driver.manage().window().maximize();
        WebElement login=driver.findElement(By.xpath("//div[@class='navigation hidden-xs']//a[.='Student login']"));
        BrowserUtils.ClickWithJS(driver,login);
    }
    @Test//***
    public void ScrollIntoView(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.techtorialacademy.com/");
        WebElement copyright= driver.findElement(By.xpath("//p[contains(text(),'Copy')]"));
        JavascriptExecutor js=(JavascriptExecutor) driver;
       // js.executeScript("arguments[0].scrollIntoView(true)",copyright);

    }
    @Test
    public void scroll(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.techtorialacademy.com/");
        WebElement browser= driver.findElement(By.xpath("//a[contains(text(),'Browse Course')]"));
        BrowserUtils.ClickWithJS(driver,browser);
        WebElement copyright= driver.findElement(By.xpath("//p[contains(text(),'© Copyrights 2021 Techtorial - All Rights Reserved')]"));
        BrowserUtils.ScrollWithJS(driver,copyright);
//        JavascriptExecutor js=(JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView(true)",copyright);
        WebElement getStart=driver.findElement(By.xpath("//h4[.='On-Campus Course']//..//a"));
        BrowserUtils.ClickWithJS(driver,getStart);
    }
    @Test
    public void ScrollWithXandYCordinantTest(){
        //This is an interview question(POINT CLASS)
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.techtorialacademy.com/");
        WebElement copyright= driver.findElement(By.xpath("//p[contains(text(),'Copy')]"));
//        JavascriptExecutor js=(JavascriptExecutor) driver;
//        Point location= copyright.getLocation();
//        System.out.println(location.getX());
//        System.out.println(location.getY());
//        int xCord= location.getX();
//        int yCord= location.getY();
//        js.executeScript("window.scrollTo("+xCord+","+yCord+")");
        BrowserUtils.ScrollWithXandYCord(driver,copyright);
    }


}

