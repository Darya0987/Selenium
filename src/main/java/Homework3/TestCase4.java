package Homework3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestCase4 {
    /*
    Navigate to "https://demos.telerik.com/kendoui/websushi#"
Validate price of all the products are less than $25
     */
    @Test
    public void validatePrice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://demos.telerik.com/kendo-ui/websushi#");
        driver.manage().window().maximize();
        List<WebElement> pricesForAll= driver.findElements(By.xpath("//li//span[2]"));
        List list = new ArrayList();
        int actualCount = 0;
        for (WebElement element: pricesForAll){
            if (Double.parseDouble(element.getText().trim())<25){
                actualCount++;
            }
        }
        int expectedCount=19;

        Assert.assertEquals(actualCount,expectedCount);

    }


    }

