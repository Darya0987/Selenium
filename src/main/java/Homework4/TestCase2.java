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

public class TestCase2 {
    /*
    Navigate to Navigate to
"http://uitestpractice.com/Students/Select#"
Validate the values for Multiple Select are :
          India
United States of America
China
England
          Select China and England
Validate "China England" is displayed
Deselect all the countries
Select All the countries
Validate "India United states of America China
England" is
displayed
Deselect the China with index number
Deselect the England with value
Steps
     */

    @Test
    public void select() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://uitestpractice.com/Students/Select#");
        driver.manage().window().maximize();

        List<WebElement> validateCountries = driver.findElements(By.xpath("//select[@id='countriesSingle']//option"));
        String actualValues = "";
        for(int i=0; i<validateCountries.size(); i++){
            if(i<validateCountries.size()-1){
                actualValues+= BrowserUtils.getTextMethod(validateCountries.get(i))+", ";
            }else{
                actualValues+=BrowserUtils.getTextMethod(validateCountries.get(i));
            }
        }
        String expectedValues = "India, United states of America, China, England";
        Assert.assertEquals(actualValues,expectedValues);

        WebElement MultiSelectBox= driver.findElement(By.xpath("//select[@id='countriesMultiple']"));
        BrowserUtils.selectBy(MultiSelectBox, "china", "value");
        BrowserUtils.selectBy(MultiSelectBox, "England", "text");

        WebElement ChinaAndEnglanddisplayed= driver.findElement(By.xpath("//div[@id='result']"));
        boolean isdisplayed=ChinaAndEnglanddisplayed.isDisplayed();
        Assert.assertTrue(isdisplayed);

        Select allCountries=new Select(MultiSelectBox);
        Thread.sleep(2000);
        allCountries.deselectAll();

        BrowserUtils.selectBy(MultiSelectBox, "india", "value");
        Thread.sleep(2000);
        BrowserUtils.selectBy(MultiSelectBox, "United states of America", "text");
        Thread.sleep(2000);
        BrowserUtils.selectBy(MultiSelectBox, "china", "value");
        Thread.sleep(2000);
        BrowserUtils.selectBy(MultiSelectBox, "England", "text");

        WebElement ValidateAllCountriesDisplayed= driver.findElement(By.xpath("//select[@id='countriesMultiple']"));
        boolean areTheyDisplayed=ValidateAllCountriesDisplayed.isDisplayed();
        Assert.assertTrue(areTheyDisplayed);

        Thread.sleep(2000);
        Select CountryBox=new Select(MultiSelectBox);
        Thread.sleep(2000);
        CountryBox.deselectByIndex(2);
        CountryBox.deselectByValue("england");
    }
}
