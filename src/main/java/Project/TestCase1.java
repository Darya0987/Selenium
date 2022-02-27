package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase1 {
    @Test
    public void validateWebsite(){
        WebDriver driver=new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete11%2fWebOrders%2fProcess.aspx");
        driver.manage().window().maximize();
        String actualTitle=driver.getTitle();
        String expectedTitle="Web Orders Login";
        Assert.assertEquals(actualTitle,expectedTitle);
        WebElement name=driver.findElement(By.name("ctl00$MainContent$username"));
        name.sendKeys("Tester");
        WebElement password=driver.findElement(By.name("ctl00$MainContent$password"));
        password.sendKeys("test");
        WebElement button= driver.findElement(By.id("ctl00_MainContent_login_button"));
        button.click();
        String actualTitle1= driver.getTitle();
        String expectedTitle1="Web Orders";
        Assert.assertEquals(actualTitle1,expectedTitle1);
        WebElement allProductsButton=driver.findElement(By.xpath("//a[@href=\"Default.aspx\"]"));
        allProductsButton.click();
        WebElement header = driver.findElement(By.tagName("h2"));

        String actualHeader = header.getText();
        String expectedHeader = "List of All Orders";

        Assert.assertEquals(actualHeader,expectedHeader);




    }
}
