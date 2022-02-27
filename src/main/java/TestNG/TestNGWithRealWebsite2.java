package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class TestNGWithRealWebsite2 {
    @Test
    public void validationOfAscendingOrder() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://demo.opencart.com/admin/");
        driver.manage().window().maximize();
        WebElement loginButton=driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        WebElement catalogBar=driver.findElement(By.id("menu-catalog"));
        catalogBar.click();
        Thread.sleep(1000);
        WebElement options=driver.findElement(By.xpath("//a[.='Options']"));
        options.click();
        Thread.sleep(1000);
        WebElement optionNameButton= driver.findElement(By.xpath("//a[.='Option Name']"));
        optionNameButton.click();
        List<WebElement> allOptions=driver.findElements(By.xpath("//tbody/tr/td[2]"));
        Set<String> actualOptionsOrder=new LinkedHashSet<>();//it accepts insertion osder
        Set<String> expectedOptionsOrder=new TreeSet<>();// ascending order
        for (WebElement option:allOptions){
            actualOptionsOrder.add(option.getText().trim());
            expectedOptionsOrder.add(option.getText().trim());
        }
        Assert.assertEquals(actualOptionsOrder,expectedOptionsOrder);
    }
    @Test
    public void validationOfDescendingOrderOptions() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://demo.opencart.com/admin/");
        driver.manage().window().maximize();
        WebElement loginButton=driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        WebElement catalogBar=driver.findElement(By.id("menu-catalog"));
        catalogBar.click();
        Thread.sleep(1000);
        WebElement options=driver.findElement(By.xpath("//a[.='Options']"));
        options.click();
        Thread.sleep(1000);
        WebElement optionNameButton= driver.findElement(By.xpath("//a[.='Option Name']"));
        optionNameButton.click();
        List<WebElement> descendingAllOptions=driver.findElements(By.xpath("//tbody/tr/td[2]"));
        List<String> actualDescendingOrder=new LinkedList<>();
        List<String> expectedDescendingOrder=new ArrayList<>();
        for(int i=0;i<descendingAllOptions.size();i++){
            actualDescendingOrder.add(descendingAllOptions.get(i).getText().trim());
            expectedDescendingOrder.add(descendingAllOptions.get(i).getText().trim());
            Collections.sort(expectedDescendingOrder);
            Collections.reverse(expectedDescendingOrder);
        }
        Assert.assertEquals(actualDescendingOrder,expectedDescendingOrder);
    }
    @Test
    public void validateSortButton() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://demo.opencart.com/admin/");
        driver.manage().window().maximize();
        WebElement loginButton=driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        WebElement catalogBar=driver.findElement(By.id("menu-catalog"));
        catalogBar.click();
        Thread.sleep(1000);
        WebElement options=driver.findElement(By.xpath("//a[.='Options']"));
        options.click();
        Thread.sleep(1000);
        WebElement options1=driver.findElement(By.xpath("//a[.='Sort Order']"));
        options1.click();
        Thread.sleep(1000);
        List<WebElement> descendingAllOptions=driver.findElements(By.xpath("//tbody/tr/td[3]"));
        List<String> actualDescendingOrder=new LinkedList<>();
        List<String> expectedDescendingOrder=new ArrayList<>();
        for(int i=0;i<descendingAllOptions.size();i++){
            actualDescendingOrder.add(descendingAllOptions.get(i).getText().trim());
            expectedDescendingOrder.add(descendingAllOptions.get(i).getText().trim());
            Collections.sort(expectedDescendingOrder);
            Collections.reverse(expectedDescendingOrder);
        }
        Assert.assertEquals(actualDescendingOrder,expectedDescendingOrder);
    }
}
