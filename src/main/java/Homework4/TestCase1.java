package Homework4;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestCase1 {
    /*
   Steps
 Navigate to "http://uitestpractice.com/Students/Select#"
 Validate India is selected by default on drop-down box
 Validate the size of the drop-down box is 4
 Validate the values for drop-down box are : "India, United states of America, China, England"
 Select the China with index number
 Select the England with value
 Select the United States with visible text
    */
    @Test
    public void select() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://uitestpractice.com/Students/Select#");
        driver.manage().window().maximize();
        WebElement dropDownElement = driver.findElement(By.id("countriesSingle"));
        Select country = new Select(dropDownElement);
        String actualIndia = BrowserUtils.getTextMethod(country.getFirstSelectedOption());
        String expectedIndia = "India";
        Assert.assertEquals(actualIndia,expectedIndia);
        List<WebElement> dropDown = driver.findElements(By.xpath("//select[@id='countriesSingle']//option"));
        int actualCount=0;
        for(int i=0; i<dropDown.size(); i++){
            actualCount++;
        }
        int expectedCount = 4;
        Assert.assertEquals(actualCount,expectedCount);
        String actualValues = "";
        for(int i=0; i<dropDown.size(); i++){
            if(i<dropDown.size()-1){
                actualValues+=BrowserUtils.getTextMethod(dropDown.get(i))+", ";
            }else{
                actualValues+=BrowserUtils.getTextMethod(dropDown.get(i));
            }
        }
        //System.out.println(actualValues);
        String expectedValues = "India, United states of America, China, England";
        Assert.assertEquals(actualValues,expectedValues);
        BrowserUtils.selectBy(dropDownElement,"2","index");
        Thread.sleep(1000);
        BrowserUtils.selectBy(dropDownElement,"england","value");
        Thread.sleep(1000);
        BrowserUtils.selectBy(dropDownElement,"United states of America","text");

    }
}
