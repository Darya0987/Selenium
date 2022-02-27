package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestNGWithRealWebsite {
    @Test
    public void validateWebsite(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://demo.opencart.com/admin/");
        driver.manage().window().maximize();
//        String actualWebsite=driver.getCurrentUrl();
//        String expectedWebsite="https://demo.opencart.com/admin/";
//        Assert.assertEquals(actualWebsite,expectedWebsite);
        WebElement logginButton= driver.findElement(By.xpath("//button[@type='submit']"));
        logginButton.click();
        WebElement catalogBar= driver.findElement(By.id("menu-catalog"));
        boolean actualCatalog=catalogBar.isDisplayed();
        boolean expectedCatalog=true;
        Assert.assertEquals(actualCatalog, true,"Catalog is not there");
        catalogBar.click();
    }
    @Test
    public void validateProductsBarisDisplayed(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://demo.opencart.com/admin/");
        driver.manage().window().maximize();
        WebElement logginButton= driver.findElement(By.xpath("//button[@type='submit']"));
        logginButton.click();
        WebElement catalogBar= driver.findElement(By.id("menu-catalog"));
        catalogBar.click();
        WebElement productBar= driver.findElement(By.xpath("//a[.='Products']"));

        productBar.click();
    }
    @Test
    public void validateOnOfBoxes() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://demo.opencart.com/admin/");
        driver.manage().window().maximize();
        WebElement logginButton= driver.findElement(By.xpath("//button[@type='submit']"));
        logginButton.click();
        WebElement catalogBar= driver.findElement(By.id("menu-catalog"));
        catalogBar.click();
        WebElement productBar= driver.findElement(By.xpath("//a[.='Products']"));
        Thread.sleep(1000);
        productBar.click();
        List<WebElement> boxes=driver.findElements(By.xpath("//input[@type='checkbox']"));
        for(int i=1;i<boxes.size();i++){
            Thread.sleep(500);
            boxes.get(i).click();
        }
    }
}
