package Homework4;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase3 {
    /*
    Navigate to "https://www.cars.com/"
Select "Certified Cars" from drop down
Select "Toyota" from All Makes
Select "Corolla" from drop down
Select max price is "$30000"
Select 40 miles from drop down box
Insert 60018 as zip code
Click search button
Validate title has Certified Used
Validate "Certified Used Toyota Corolla for Sale" is
displayed
Steps
Validate 40 miles selected in dropdown once you click
search button
Validate Certified Pre-Owned selected in radio button
Validate Toyota is selected in checkbox
Validate Corolla is selected in drop down

     */
    @Test
    public void cars() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.cars.com/");
        driver.manage().window().maximize();

        WebElement new_used = driver.findElement(By.xpath("//select[@id='make-model-search-stocktype']"));
        BrowserUtils.selectBy(new_used,"cpo","value");
        Thread.sleep(500);

        WebElement make = driver.findElement(By.xpath("//select[@id='makes']"));
        BrowserUtils.selectBy(make,"toyota","value");
        Thread.sleep(400);

        WebElement model = driver.findElement(By.xpath("//select[@id='models']"));
        BrowserUtils.selectBy(model,"Corolla","text");
        Thread.sleep(400);

        WebElement MaxPrice= driver.findElement(By.xpath("//select[@id='make-model-max-price']"));
        BrowserUtils.selectBy(MaxPrice, "30000", "value");
        Thread.sleep(4000);

        WebElement distance = driver.findElement(By.xpath("//select[@id='make-model-maximum-distance']"));
        BrowserUtils.selectBy(distance,"40","value");
        Thread.sleep(400);

        WebElement zipCode= driver.findElement(By.xpath("//input[@id='make-model-zip']"));
        zipCode.clear();
        zipCode.sendKeys("60018");

        WebElement searchButton = driver.findElement(By.xpath("//button[@data-linkname='search-cpo-make']"));
        searchButton.click();
        Thread.sleep(400);

//        WebElement validateCertifiedUsed=driver.findElement(By.xpath("//h1[contains(text(),'Toyota Certified Used Corolla')]"));
//        String actualText=validateCertifiedUsed.getText();
//        String expectedText="Toyota Certified Used Corolla";
//        Assert.assertEquals(actualText,expectedText);
//        Thread.sleep(4000);

        String ValidateCertifiedUsedForSaleDisplayed=driver.getTitle();
        Assert.assertTrue(driver.getTitle().equals("Certified used Toyota Corolla for Sale Near Me | Cars.com"));

        WebElement validateHeader=driver.findElement(By.xpath("//h1[.='Certified used Toyota Corolla for sale']"));
        boolean isdisplayed=validateHeader.isDisplayed();
        Assert.assertTrue(isdisplayed);

        WebElement validateDistance= driver.findElement(By.xpath("//select[@id='location-distance']//option[.='40 miles']"));
        String actualText=BrowserUtils.getTextMethod(validateDistance);
        String expectedText="40 miles";
        Assert.assertEquals(actualText,expectedText);

        WebElement validateCarName= driver.findElement(By.xpath("//select[@id='make_select']//option[. ='Toyota']"));
        String actualCarName=BrowserUtils.getTextMethod(validateDistance);
        String expectedCarName="Toyota";
        Assert.assertEquals(actualText,expectedText);

        WebElement validateCarModel= driver.findElement(By.xpath("//label[@for='active_filter_tags-models-toyota-corolla']"));
        String actualCarModel=BrowserUtils.getTextMethod(validateDistance);
        String expectedCarModel="Corolla";
        Assert.assertEquals(actualText,expectedText);









    }
}
