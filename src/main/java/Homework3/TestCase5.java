package Homework3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase5 {
    /*
    Navigate to "https://demos.telerik.com/kendoui/websushi#"
Add 3 items to your cart
Click X button on the top added items
Validate items number is 2
     */
    @Test
    public void validateItem() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://demos.telerik.com/kendo-ui/websushi#");
        driver.manage().window().maximize();

        WebElement addToCart= driver.findElement(By.xpath("//a[@href='#/menu/2']//following-sibling::button"));
        addToCart.click();
        Thread.sleep(2000);

        WebElement addToCart1= driver.findElement(By.xpath("//a[@href='#/menu/7']//following-sibling::button"));
        addToCart1.click();
        Thread.sleep(2000);

        WebElement addToCart2= driver.findElement(By.xpath("//a[@href='#/menu/9']//following-sibling::button"));
        addToCart2.click();
        Thread.sleep(2000);
        WebElement removeItem= driver.findElement(By.xpath("//a[@data-bind='click: removeFromCart']"));
        removeItem.click();
        Thread.sleep(2000);

        WebElement cart1=driver.findElement(By.xpath("//span[@data-bind='text: cart.contentsCount']"));
        String actualItem1=cart1.getText();
        String expectedItem1="2";
        Assert.assertEquals(actualItem1,expectedItem1);

    }
}
