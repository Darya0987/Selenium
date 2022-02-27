package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsIntro {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();

        WebElement header= driver.findElement(By.id("techtorial1"));
        String actualText=header.getText();//from system
        String expectedText="Techtorial Academy";//from the business requirement
        if(actualText.equals(expectedText)){
            System.out.println("passed");
        }else{
            System.out.println("failed");
        }
        WebElement paragraph= driver.findElement(By.id("details2"));
        System.out.println(paragraph.getText());


        //LOCATOR: classname
        WebElement tools=driver.findElement(By.className("group_checkbox"));
        System.out.println(tools.getText());
        //LOCATOR:name
        WebElement firstName=driver.findElement(By.name("firstName"));
        firstName.sendKeys("Darya");

        WebElement lastName=driver.findElement(By.name("lastName"));
        lastName.sendKeys("Kovalyova");
        WebElement phone=driver.findElement(By.name("phone"));
        phone.sendKeys("12345");

        WebElement email=driver.findElement(By.name("userName"));
        email.sendKeys("sterva87");

        WebElement javaBox=driver.findElement(By.id("cond1"));
        javaBox.click();
        System.out.println(javaBox.isDisplayed());//true or false
        System.out.println( javaBox.isSelected());//true or false

        WebElement testNGBox =driver.findElement(By.id("cond3"));
        testNGBox.click();
        System.out.println(testNGBox.isDisplayed());//true or false
        System.out.println( testNGBox.isSelected());//true or false

        WebElement cucumberBox=driver.findElement(By.id("cond4"));
        cucumberBox.click();
        System.out.println(cucumberBox.isDisplayed());//true or false
        System.out.println( cucumberBox.isSelected());//true or false


    }
}
