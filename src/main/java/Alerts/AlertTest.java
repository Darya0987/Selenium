package Alerts;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertTest {

    @Test
    public void ValidateAlert(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://sweetalert.js.org/");
        driver.manage().window().maximize();
        WebElement button= driver.findElement(By.xpath("//h5[contains(text(),'Normal alert')] //..//button"));
        button.click();
        Alert alert=driver.switchTo().alert();
        String actualText=alert.getText();
        String expectedText="Oops, something went wrong!";
        Assert.assertEquals(actualText,expectedText);
        alert.accept();
    }
    @Test
    public void ValidateHTMLAlert(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://sweetalert.js.org/");
        driver.manage().window().maximize();
        WebElement button= driver.findElement(By.xpath("//button[contains(@onclick,'swal')]"));
        button.click();
        Alert alert=driver.switchTo().alert();
        alert.accept();

    }
    @Test
    public void ValidateText(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://sweetalert.js.org/");
        driver.manage().window().maximize();
        WebElement button= driver.findElement(By.xpath("//button[contains(@onclick,'swal')]"));
        button.click();
        WebElement text=driver.findElement(By.xpath("//div[.='Something went wrong!']"));
        String actualText= BrowserUtils.getTextMethod(text);
        String expectedText="Something went wrong!";
        Assert.assertEquals(actualText,expectedText);
        WebElement OKbutton=driver.findElement(By.xpath("//button[.='OK']"));
        OKbutton.click();
    }
}
