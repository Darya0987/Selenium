package Homework4;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestCase4 {
    /*
    Steps-Multiple CheckBox
  Navigate to "https://www.cars.com/"
  Select "Certified Cars" from drop-down -->New Cars
  Select "Lexus" from All Makes
  Select "ES 350" from drop-down
  Select max price is "$50000"
  Select 50 miles from drop-down box
  Insert 60016 as zip code
  Click search button
  Get count of all the cars which is displayed on first page
  Validate count of the cars is not more than 20
  Get all car names in first page
  Validate All car names has "Lexus ES 350"
  Get the Mile distance from zip code for every car
  Validate mile distance is no more than 50 mil in first page
  Select Sort By --> Price:Highest in drop-down
  Validate the highest price is not more than $50000
     */
    @Test
    public void lexus() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.cars.com/");
        driver.manage().window().maximize();
        WebElement new_used = driver.findElement(By.xpath("//select[@id='make-model-search-stocktype']"));
        BrowserUtils.selectBy(new_used,"all","value");
        Thread.sleep(500);
        WebElement make = driver.findElement(By.xpath("//select[@id='makes']"));
        BrowserUtils.selectBy(make,"Lexus","text");
        Thread.sleep(500);
        WebElement model = driver.findElement(By.xpath("//select[@id='models']"));
        BrowserUtils.selectBy(model,"  ES 350","text");
        Thread.sleep(500);
        WebElement maxPrice = driver.findElement(By.xpath("//select[@id='make-model-max-price']"));
        BrowserUtils.selectBy(maxPrice,"$50,000","text");
        Thread.sleep(500);
        WebElement distance = driver.findElement(By.xpath("//select[@id='make-model-maximum-distance']"));
        BrowserUtils.selectBy(distance,"50","value");
        Thread.sleep(500);
        WebElement zipCode = driver.findElement(By.xpath("//input[@id='make-model-zip']"));
        zipCode.clear();
        Thread.sleep(500);
        zipCode.sendKeys("60016");
        Thread.sleep(500);
        WebElement searchButton = driver.findElement(By.xpath("//button[@data-linkname='search-all-make']"));
        searchButton.click();
        Thread.sleep(500);
        List<WebElement> allCars = driver.findElements(By.xpath("//a[@class='vehicle-card-link js-gallery-click-link']")); //20 elements
        int actualCarNumber=0;
        for(int i=0; i<allCars.size(); i++){
            actualCarNumber++;
            String lexus = BrowserUtils.getTextMethod(allCars.get(i));
            //String lexus1 = allCars.get(i).getText().trim(); instead of line 79
            System.out.println(lexus);
            boolean actualES350 = lexus.contains("Lexus ES 350");
            Assert.assertTrue(actualES350);
        }
        Assert.assertTrue(actualCarNumber<=20);
        List<WebElement> allDistances = driver.findElements(By.xpath("//div[@class='miles-from ']")); // 40 elements
        for(int i=0; i<allDistances.size(); i++){
            if(allDistances.get(i).isDisplayed()){
                //System.out.println(BrowserUtils.getTextMethod(allDistances.get(i)));
                int actualMilesAway = Integer.parseInt(BrowserUtils.getTextMethod(allDistances.get(i)).
                        //  "17 mi. from 60016" -->"17 mi. from "-->"17"-->17 (int)           [A-Za-z]
                                replace("60016","").replaceAll("[^0-9]",""));
                System.out.println(actualMilesAway);
                Assert.assertTrue(actualMilesAway<=50);
            }
        }
        WebElement sortBy = driver.findElement(By.xpath("//select[@id='sort-dropdown']"));
        BrowserUtils.selectBy(sortBy,"Highest price","text");
        List<WebElement> prices = driver.findElements(By.xpath("//span[@class='primary-price']"));
        double highestPrice = Double.parseDouble(BrowserUtils.getTextMethod(prices.get(0)).replaceAll("[^0-9]",""));
        //double highestPrice1 = Double.parseDouble(BrowserUtils.getTextMethod(prices.get(0)).replace("$","").replace(",", ""));
        Assert.assertTrue(highestPrice<=50000);

    }
}
