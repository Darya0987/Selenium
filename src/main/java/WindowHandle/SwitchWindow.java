package WindowHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class SwitchWindow {
    @Test
    public void practice1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement clickHere=driver.findElement(By.xpath("//a[.='Click Here']"));
        BrowserUtils.ClickWithJS(driver,clickHere);
        WebElement header=driver.findElement(By.xpath("//h3[.='New Window"));
        header.getText();
    }
    @Test
    public void switchingWindow(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
        System.out.println(driver.getWindowHandle());
        WebElement clickHere=driver.findElement(By.xpath("//a[.='Click Here']"));
        BrowserUtils.ClickWithJS(driver,clickHere);
        System.out.println(driver.getWindowHandles());
        //WebElement header=driver.findElement(By.xpath("//h3[.='New Window"));
        String mainPageId=driver.getWindowHandle();
        Set<String> allPagesId=driver.getWindowHandles();
        //this implementation just for 2 tabs

        for(String id:allPagesId){
            System.out.println(id);
            if(!id.equals(mainPageId)){
                driver.switchTo().window(id);
            }
        }
        WebElement header=driver.findElement(By.xpath("//h3[.='New Window']"));
        System.out.println(header.getText());
        String actualText= header.getText();
        String expectedText="New Window";
        Assert.assertEquals(actualText,expectedText);
    }
    @Test
    public void SwitchWindowPractice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        System.out.println(driver.getWindowHandle());
        WebElement button=driver.findElement(By.xpath("//h3[.='Button2']//..//button"));
        BrowserUtils.ClickWithJS(driver,button);
        System.out.println(driver.getWindowHandles());
        String mainPageId=driver.getWindowHandle();
        BrowserUtils.SwitchOnlyFor2Tabs(driver,mainPageId);
//        Set<String> allPagesId=driver.getWindowHandles();
//        for(String id:allPagesId){
//            System.out.println(id);
//            if(!id.equals(mainPageId)){
//                driver.switchTo().window(id);
//            }
//        }
        WebElement header=driver.findElement(By.xpath("//h1[@class='post-title entry-title']"));
        System.out.println(header.getText());
        String actualText= header.getText();
        String expectedText="AlertsDemo";
        Assert.assertEquals(actualText,expectedText);
        WebElement clickHere=driver.findElement(By.xpath("alertBox"));
        clickHere.click();

    }
}
