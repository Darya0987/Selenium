package Homework1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase1 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");

        WebElement fullNameBox=driver.findElement(By.xpath("//input[@id='userName']"));
        fullNameBox.sendKeys("Ahmet Baldir");

        WebElement emailbox = driver.findElement(By.xpath("//input[@type='email']"));
        emailbox.sendKeys("ahmet@gmail.com");

        WebElement currentaddress = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        currentaddress.sendKeys("50123 midway ");

        WebElement permanentaddress = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permanentaddress.sendKeys("50123 midway permanent ");

        WebElement button = driver.findElement(By.xpath("//button[@id='submit']"));
        button.click();         //it didn't work because of the advertisement was blocking the submit
//button.(check the sublime)

        WebElement button1= driver.findElement(By.xpath("//button[@id='submit']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button1);
        button1.click();

        WebElement nameValidation= driver.findElement(By.xpath("//p[@id='name']"));
        System.out.println(nameValidation.getText());
        String expectedValidation="Name:Ahmet Baldir"  ;
        String actualValidation=nameValidation.getText();
        if(expectedValidation.equals(actualValidation)){
            System.out.println("pass");
        }else{
            System.out.println("fail");
        }

    }
}
