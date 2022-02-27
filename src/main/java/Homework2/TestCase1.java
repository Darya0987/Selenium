package Homework2;

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

public class TestCase1 {
    /*
    Navigate to "https://www.saucedemo.com/"
Enter username "standard_user"
Enter password "secret_sauce"
Click Login button
Select Name (Z-A) from drop down box
Validate the products are displayed in descending order
Steps
     */
    @Test
    public void validateNames(){
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
//        chooseName.click();
        Actions actions = new Actions(driver);
        actions.moveToElement(chooseName).perform();
        WebElement namesAtoZ= driver.findElement(By.xpath("//option[@value='za']"));
        namesAtoZ.click();
//        actions.moveToElement(namesAtoZ).perform();
        List<WebElement> descendingname= driver.findElements(By.className("inventory_item_name"));
        List<String> actualDescendingOrder= new LinkedList<>();
        List<String> expectedDescendingOrder= new ArrayList<>();
        for (int i=0; i<descendingname.size(); i++){
            actualDescendingOrder.add(descendingname.get(i).getText().trim());
            expectedDescendingOrder.add(descendingname.get(i).getText().trim());
            Collections.sort(expectedDescendingOrder);
            Collections.reverse(expectedDescendingOrder);
            //  Assert.assertEquals(actualDescendingOrder,expectedDescendingOrder);
        }
        Assert.assertEquals(actualDescendingOrder,expectedDescendingOrder);

    }
}
