package Iframe;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class IframeTask {
    /*
TASK:
    1)Navigate to the website "https://skpatro.github.io/demo/iframes/"
    2)Click Pavilion and click selenium-java and validate the header
    3)Go back to mainPage and click category1
    4)from new webpage validate the title is ending with "qavalidation"
    5)Go back to mainppage and click Category3
    6)validate the new url is equal to "https://qavalidation.com/category/softwaretesting/"
 */
    @Test
    public void ValidateTitle() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://skpatro.github.io/demo/iframes/");
        driver.manage().window().maximize();
        WebElement pavilion=driver.findElement(By.xpath("//a[.='Pavilion']"));
        pavilion.click();
        BrowserUtils.switchByTitle(driver,"Home - qavalidation");
        WebElement selenium=driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium']//.."));
        Actions actions = new Actions(driver);
        actions.moveToElement(selenium).perform();
        WebElement seleniumJava=driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium-Java']//.."));
        actions.click(seleniumJava).perform();
        WebElement header= driver.findElement(By.tagName("h1"));
        String actualHeader= BrowserUtils.getTextMethod(header);
        String expectedHeader="Selenium-Java Tutorial – Basic to Advance";
        Assert.assertEquals(actualHeader,expectedHeader);
        BrowserUtils.switchByTitle(driver,"iframes");
        Thread.sleep(2000);
        driver.switchTo().frame("Frame1");
        WebElement category=driver.findElement(By.xpath("//a[.='Category1']"));
        category.click();
        BrowserUtils.switchByTitle(driver,"qavalidation");
        Assert.assertTrue(driver.getTitle().endsWith("qavalidation"));
        BrowserUtils.switchByTitle(driver,"iframes");
        driver.switchTo().frame("Frame2");
        WebElement category3=driver.findElement(By.xpath("//a[.='Category3']"));
        category3.click();
        BrowserUtils.switchByTitle(driver,"SoftwareTesting Archives - qavalidation");
        Assert.assertTrue(driver.getCurrentUrl().equals("https://qavalidation.com/category/softwaretesting/"));

    }

}
