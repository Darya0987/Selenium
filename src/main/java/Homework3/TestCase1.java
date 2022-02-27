package Homework3;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase1 {
    /* Navigate to "https://demos.telerik.com/kendoui/websushi#"
    Click on top of Shiromi picture
    Click > arrow
    validate next item is Tekka maki
    Click < arrow
    Validate the item is Shiromi
    Validate number of item 0 in the cart*/
    @Test
    public void validateItem() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://demos.telerik.com/kendo-ui/websushi#");
        driver.manage().window().maximize();
        WebElement shiromi= driver.findElement(By.xpath("//img[@title='Shiromi']"));
        BrowserUtils.ClickWithJS(driver,shiromi);
        Thread.sleep(3000);
        WebElement arrowNext=driver.findElement(By.xpath("//a[@id='navigate-next']"));
        arrowNext.click();
        Thread.sleep(3000);
        WebElement tekkaMaki=driver.findElement(By.xpath("//h1[@data-bind='text: current.name']"));
        String actualName=tekkaMaki.getText();
        String expectedName="Tekka maki";
        Assert.assertEquals(actualName,expectedName);
        WebElement arrowPrev=driver.findElement(By.xpath("//a[@id='navigate-prev']"));
        arrowPrev.click();
        Thread.sleep(3000);
        WebElement validateShiromi=driver.findElement(By.xpath("//h1[@data-bind='text: current.name']"));
        String actualName1=validateShiromi.getText();
        String expectedName1="Shiromi";
        Assert.assertEquals(actualName1,expectedName1);
        Thread.sleep(2000);
        WebElement cart=driver.findElement(By.xpath("//span[@data-bind='text: cart.contentsCount']"));
        String actualItem=cart.getText();
        String expectedItem="0";
        Assert.assertEquals(actualItem,expectedItem);

    }
}
