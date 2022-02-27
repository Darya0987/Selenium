package WindowHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {
    @Test
    public void multipleWindowsTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement clickHere=driver.findElement(By.xpath("//a[.='Click Here']"));
        clickHere.click();
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.open('https://www.techtorialacademy.com/')");
        js.executeScript("window.open('https://www.techtorialacademy.com/about-us')");
        js.executeScript("window.open('https://www.techtorialacademy.com/programs')");

        BrowserUtils.switchByTitle(driver,"Home Page - Techtorial");

//        Set<String> allPages=driver.getWindowHandles();
//        for(String id:allPages){
//            driver.switchTo().window(id);
//            if(driver.getTitle().contains("About Us-Techtorial")){
//                break;
//            }
//        }

    }
    /*
    1)navigate to the "https://www.hyrtutorials.com/p/window-handles-practice.html"
    2)Click open multiple tabs under button 4
    3)switch back to Basic Controls and validate the header(Basic Controls)
    4)Fill all the boxes and click register
    5)validate the message"Registration is Successful";
    6)Go back to Alert tabs and click the one of the click me box
    7)Close all the tabs
    8)Enjoy the chocolate if you are top5
     */
    @Test
    public void validateWebSite() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://www.hyrtutorials.com/p/window-handles-practice.html");
        driver.manage().window().maximize();
        WebElement button=driver.findElement(By.xpath("//button[@id='newTabsBtn']"));
        button.click();
        //JavascriptExecutor js=(JavascriptExecutor) driver;
        BrowserUtils.switchByTitle(driver,"Basic Controls - H Y R Tutorials");
        WebElement header= driver.findElement(By.xpath("//h1[@class='post-title entry-title']"));
        String actualHeader= header.getText();
        String expextedHeader="Basic Controls";
        Assert.assertEquals(actualHeader,expextedHeader);
        WebElement firstName= driver.findElement(By.id("firstName"));
        firstName.sendKeys("Darya");
        WebElement lastName= driver.findElement(By.id("lastName"));
        lastName.sendKeys("Kovalyova");
        WebElement radioButton= driver.findElement(By.id("femalerb"));
        radioButton.click();
        WebElement Button= driver.findElement(By.id("englishchbx"));
        Button.click();
        WebElement email= driver.findElement(By.id("email"));
        email.sendKeys("sterva@");
        WebElement password= driver.findElement(By.id("password"));
        password.sendKeys("gbg45");
        WebElement register= driver.findElement(By.id("registerbtn"));
        register.click();
        WebElement message= driver.findElement(By.id("msg"));
        String actualMessage=BrowserUtils.getTextMethod(message);
        String expectedMessage="Registration is Successful";
        Assert.assertEquals(actualMessage,expectedMessage);
        BrowserUtils.switchByTitle(driver,"AlertsDemo");
        WebElement clickme=driver.findElement(By.id("alertBox"));
        clickme.click();
        Thread.sleep(3000);
        driver.quit();


    }
}
