package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase3 {
    @Test
    public void validateWebsite(){
        WebDriver driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete11%2fWebOrders%2fProcess.aspx");
        driver.manage().window().maximize();
        WebElement userName = driver.findElement(By.name("ctl00$MainContent$username"));
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("test");
        WebElement logIn = driver.findElement(By.name("ctl00$MainContent$login_button"));
        logIn.click();

        WebElement viewAllOrders = driver.findElement(By.xpath("//a[@href='Default.aspx']"));
        viewAllOrders.click();
        String viewallordersValue= driver.findElement(By.xpath("//a[@href=\"Default.aspx\"]")).getAttribute("href");
        boolean actualviewallorders= viewallordersValue.endsWith("Default.aspx");
        boolean expectviewallorders= true;
        Assert.assertEquals(actualviewallorders,expectviewallorders);

        WebElement viewAllproducts = driver.findElement(By.xpath("//a[@href='Products.aspx']"));
        viewAllproducts.click();
        String viewallPRODUCTSsValue= driver.findElement(By.xpath("//a[@href=\"Products.aspx\"]")).getAttribute("href");
        boolean actualviewallPRODUCTS= viewallPRODUCTSsValue.endsWith("Products.aspx");
        boolean expectviewallPRODUCTS= true;
        Assert.assertEquals(actualviewallPRODUCTS,expectviewallPRODUCTS);


        WebElement order = driver.findElement(By.xpath("//a[@href='Process.aspx']"));
        order.click();
        String orderValue= driver.findElement(By.xpath("//a[@href=\"Process.aspx\"]")).getAttribute("href");
        boolean actualorder= orderValue.endsWith("Process.aspx");
        boolean expectorder= true;
        Assert.assertEquals(actualorder,expectorder);
    }
}
