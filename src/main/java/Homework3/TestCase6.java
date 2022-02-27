package Homework3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase6 {
    /*
    Navigate to "https://demos.telerik.com/kendoui/websushi#"
Add Shiromi and Ebi Rolls into the cart
Click checkout button
Validate total price is 17
Increase the count of Ebi Roll with 2
Validate total is $25
Click order now
Validate cart is 0
     */
    @Test
    public void validateCart(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://demos.telerik.com/kendo-ui/websushi#");
        driver.manage().window().maximize();
        WebElement addToCart=driver.findElement(By.xpath("//a[@href='#/menu/8']//following-sibling::button"));
        addToCart.click();
        WebElement addToCart1=driver.findElement(By.xpath("//a[@href='#/menu/14']//following-sibling::button"));
        addToCart1.click();
        WebElement price=driver.findElement(By.xpath("//p[@class='total-price']"));
        String actualPrice= price.getText().trim().replace("$","");
        String expectedPrice="17.00";
        Assert.assertEquals(actualPrice,expectedPrice);
        WebElement addToCartOneMOre=driver.findElement(By.xpath("//a[@href='#/menu/14']//following-sibling::button"));
        addToCartOneMOre.click();
        WebElement priceNew=driver.findElement(By.xpath("//p[@class='total-price']"));
        String actualPriceNew= price.getText().trim().replace("$","");
        String expectedPriceNew="25.00";
        Assert.assertEquals(actualPriceNew,expectedPriceNew);
        WebElement checkout= driver.findElement(By.xpath("//a[@id='checkout']"));
        checkout.click();
        WebElement order=driver.findElement(By.xpath("//button[@class='order-now']"));
        order.click();
        WebElement cart=driver.findElement(By.xpath("//span[@data-bind='text: cart.contentsCount']"));
        String actualItem=cart.getText();
        String expectedItem="0";
        Assert.assertEquals(actualItem,expectedItem);
    }
}
