package Homework2;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TestCase2 {
    @Test
    public void validatePrice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        WebElement userName=driver.findElement(By.xpath("//input[@id='user-name']"));
        userName.sendKeys("standard_user");
        WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");
        WebElement login=driver.findElement(By.xpath("//input[@id='login-button']"));
        login.click();
        WebElement chooseName=driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(chooseName).perform();
        WebElement price= driver.findElement(By.xpath("//option[@value='lohi']"));
        BrowserUtils.selectBy(price,"lohi","value");
        List<WebElement> allprices= driver.findElements(By.className("inventory_item_price"));
        List<Double> actualpricesOrder= new LinkedList<>();
        List<Double> expectedpricesOrder= new ArrayList<>();
        for (int i=0; i<allprices.size(); i++){
            actualpricesOrder.add(Double.parseDouble(allprices.get(i).getText().substring(1)));
            expectedpricesOrder.add(Double.parseDouble(allprices.get(i).getText().substring(1)));
            Collections.sort(expectedpricesOrder);
        }
        System.out.println(actualpricesOrder);
        System.out.println(expectedpricesOrder);
        Assert.assertEquals(actualpricesOrder,expectedpricesOrder);
    }
    }

