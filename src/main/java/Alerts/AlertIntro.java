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

public class AlertIntro {
    @Test
    public void JSAlertAcceptMethod(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
        WebElement button= driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        button.click();
        Alert alert=driver.switchTo().alert();
        String actualText=alert.getText();
        String expectedText="I am a JS Alert";
        Assert.assertEquals(actualText,expectedText);
        alert.accept();
        WebElement message=driver.findElement(By.xpath("//p[@id='result']"));
        String actualMessage= BrowserUtils.getTextMethod(message);
        String expectedMessage="You successfully clicked an alert";

    }
    @Test
    public void JSAlertDismissMethod(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
        WebElement clickForJS=driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        clickForJS.click();
        Alert alert=driver.switchTo().alert();
        String actualText= alert.getText();
        String expectedText="I am a JS Confirm";
        Assert.assertEquals(actualText,expectedText);
        alert.dismiss();
        WebElement message= driver.findElement(By.xpath("//p[@id='result']"));
        String actualMessage=BrowserUtils.getTextMethod(message);
        String expectedMessage="You clicked: Cancel";
        Assert.assertEquals(actualMessage,expectedMessage);
    }
    @Test
    public void AlertSendKeys(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
        WebElement box=driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        box.click();
        Alert alert=driver.switchTo().alert();
        alert.sendKeys("darya");
        alert.accept();
        WebElement message= driver.findElement(By.xpath("//p[@id='result']"));
        String actualMessage=BrowserUtils.getTextMethod(message);
        String expectedMessage="You entered: darya";
        Assert.assertEquals(actualMessage,expectedMessage);

    }
}
