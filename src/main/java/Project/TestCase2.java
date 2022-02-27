package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase2 {
     /*
    Test Scenario
  Navigate to "http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?"
  Input username "Tester"
  Input password "Test"
  Click login button
  Click "View all products" button
  Validate "View all products" is selected.
  Validate header is equals to "List of Products"
  Validate the url has "Products" keyword
     */

    @Test
    public void validateIsSelected(){
        WebDriver driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete11%2fWebOrders%2fProcess.aspx");
        driver.manage().window().maximize();

        WebElement userName = driver.findElement(By.name("ctl00$MainContent$username"));
        userName.sendKeys("Tester");

        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("test");

        WebElement logIn = driver.findElement(By.name("ctl00$MainContent$login_button"));
        logIn.click();

        WebElement allProducts = driver.findElement(By.xpath("//a[.='View all products']"));
        allProducts.click();

        String  actualAllProductIsSelected = driver.getCurrentUrl();
        String  expectedAllProductsIsSelected = "http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Products.aspx";

        Assert.assertEquals(actualAllProductIsSelected,expectedAllProductsIsSelected);


//        String actual = driver.getTitle();
//        String expected = "Web Orders";
//        Assert.assertEquals(actualTitle,expectedTitle);

    }

    @Test
    public void testHeader(){
        WebDriver driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete11%2fWebOrders%2fProcess.aspx");
        driver.manage().window().maximize();

        WebElement userName = driver.findElement(By.name("ctl00$MainContent$username"));
        userName.sendKeys("Tester");

        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("test");

        WebElement logIn = driver.findElement(By.name("ctl00$MainContent$login_button"));
        logIn.click();

        WebElement allProducts = driver.findElement(By.xpath("//a[.='View all products']"));
        allProducts.click();

        WebElement listOfProducts = driver.findElement(By.tagName("h2"));

        String expectedHeader = listOfProducts.getText();
        String actualHeader = "List of Products";

        Assert.assertEquals(expectedHeader,actualHeader);
    }

    @Test
    public void containsProduct(){

        WebDriver driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete11%2fWebOrders%2fProcess.aspx");
        driver.manage().window().maximize();

        WebElement userName = driver.findElement(By.name("ctl00$MainContent$username"));
        userName.sendKeys("Tester");

        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("test");

        WebElement logIn = driver.findElement(By.name("ctl00$MainContent$login_button"));
        logIn.click();

        WebElement allProducts = driver.findElement(By.xpath("//a[.='View all products']"));
        allProducts.click();

        String  URL = driver.getCurrentUrl();

        boolean actualURL = URL.toLowerCase().contains("products");
        boolean expectedURL = true;

        Assert.assertEquals(actualURL,expectedURL);

    }

}
