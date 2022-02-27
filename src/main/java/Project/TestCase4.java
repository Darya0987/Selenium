package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestCase4 {
    @Test
    public void newOrderAddedSuccessfully() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete11%2fWebOrders%2fProcess.aspx");
        driver.manage().window().maximize();

        WebElement userName = driver.findElement(By.name("ctl00$MainContent$username"));
        userName.sendKeys("Tester");

        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("test");

        WebElement logIn = driver.findElement(By.name("ctl00$MainContent$login_button"));
        logIn.click();

        WebElement order = driver.findElement(By.xpath("//a[.='Order']"));
        order.click();

        WebElement screenSaver = driver.findElement(By.name("ctl00$MainContent$fmwOrder$ddlProduct"));
        screenSaver.sendKeys("ScreenSaver");

        WebElement quantity = driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity"));
        quantity.sendKeys("5");

        WebElement customerName = driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName"));
        customerName.sendKeys("Techtorial Academy");

        WebElement street = driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox2"));
        street.sendKeys("2200 E devon");

        WebElement city = driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox3"));
        city.sendKeys("Des Plaines");

        WebElement state = driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox4"));
        state.sendKeys("Illinois");

        WebElement zip = driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5"));
        zip.sendKeys("60018");

        WebElement cardType = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$cardList' and @value='MasterCard']"));
        cardType.click();

        WebElement cardNumber = driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6"));
        cardNumber.sendKeys("444993876233");

        WebElement cardExpirationDate = driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox1"));
        cardExpirationDate.sendKeys("03/21");

        WebElement processButton = driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton"));
        processButton.click();

        WebElement processed = driver.findElement(By.tagName("strong"));
        boolean actualIsDisplayed = processed.isDisplayed();
        boolean expectedIsDisplayed = true;

        Assert.assertEquals(actualIsDisplayed, expectedIsDisplayed);

    }


    @Test
    public void allInputsAreMatching() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete11%2fWebOrders%2fProcess.aspx");
        driver.manage().window().maximize();

        WebElement userName = driver.findElement(By.name("ctl00$MainContent$username"));
        userName.sendKeys("Tester");

        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("test");

        WebElement logIn = driver.findElement(By.name("ctl00$MainContent$login_button"));
        logIn.click();

        WebElement order = driver.findElement(By.xpath("//a[.='Order']"));
        order.click();

        WebElement screenSaver = driver.findElement(By.name("ctl00$MainContent$fmwOrder$ddlProduct"));
        screenSaver.sendKeys("ScreenSaver");

        WebElement quantity = driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity"));
        quantity.sendKeys("5");

        WebElement customerName = driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName"));
        customerName.sendKeys("Techtorial Academy");

        WebElement street = driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox2"));
        street.sendKeys("2200 E devon");

        WebElement city = driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox3"));
        city.sendKeys("Des Plaines");

        WebElement state = driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox4"));
        state.sendKeys("Illinois");

        WebElement zip = driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5"));
        zip.sendKeys("60018");

        WebElement cardType = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$cardList' and @value='MasterCard']"));
        cardType.click();

        WebElement cardNumber = driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6"));
        cardNumber.sendKeys("444993876233");

        WebElement cardExpirationDate = driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox1"));
        cardExpirationDate.sendKeys("03/21");

        WebElement processButton = driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton"));
        processButton.click();

        WebElement newAllOrders = driver.findElement(By.xpath("//a[.='View all orders']"));
        newAllOrders.click();


        List<WebElement> allInputs = driver.findElements(By.xpath("//tbody/tr[2]/td"));
        List<String> actualAllInputs = new ArrayList<>();
        for (int i = 1; i < allInputs.size() - 1; i++) {
            actualAllInputs.add(allInputs.get(i).getText());
        }

        List<String> expectedAllInputs = new ArrayList<>();
        expectedAllInputs.add("Techtorial Academy");
        expectedAllInputs.add("ScreenSaver");
        expectedAllInputs.add("5");
        expectedAllInputs.add("02/12/2022");
        expectedAllInputs.add("2200 E devon");
        expectedAllInputs.add("Des Plaines");
        expectedAllInputs.add("Illinois");
        expectedAllInputs.add("60018");
        expectedAllInputs.add("MasterCard");
        expectedAllInputs.add("444993876233");
        expectedAllInputs.add("03/21");

        Assert.assertEquals(actualAllInputs, expectedAllInputs);

    }
}
