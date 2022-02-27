package Homework3;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.table.TableRowSorter;

public class TestCase2 {
    /*Navigate to "https://demos.telerik.com/kendoui/websushi#"
    Click Add to cart for Edamame
    Validate Item number is 1
    Validate price of the product is $4
    Click empty cart
    Validate item number is 0 */
    @Test
    public void validateItem() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://demos.telerik.com/kendo-ui/websushi#");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        WebElement edamameAddToCart = driver.findElement(By.xpath("//a[@href='#/menu/4']//following-sibling::button"));
        edamameAddToCart.click();
        WebElement cart=driver.findElement(By.xpath("//span[@data-bind='text: cart.contentsCount']"));
        String actualItem=cart.getText();
        String expectedItem="1";
        Assert.assertEquals(actualItem,expectedItem);
        WebElement price=driver.findElement(By.xpath("//p[@class='total-price']"));
        String actualPrice=price.getText().trim().replace("$","");
        String expectedPrice="4.00";
        Assert.assertEquals(actualPrice,expectedPrice);
        Thread.sleep(2000);
        WebElement cart1=driver.findElement(By.xpath("//a[@id='empty-cart']"));
        BrowserUtils.ClickWithJS(driver,cart1);
        WebElement cartEmpty=driver.findElement(By.xpath("//span[@data-bind='text: cart.contentsCount']"));
        String actualItem1=cart.getText();
        String expectedItem1="0";
        Assert.assertEquals(actualItem1,expectedItem1);

    }

}
