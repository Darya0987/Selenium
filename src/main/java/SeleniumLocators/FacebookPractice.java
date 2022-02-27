package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookPractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= new ChromeDriver();
       driver.get("https://www.facebook.com/");
        System.out.println(driver.getCurrentUrl());
        driver.manage().window().maximize();
        String actualURL=driver.getCurrentUrl();
        String expectedURL="https://www.facebook.com/";
        if(actualURL.equals(expectedURL)){
            System.out.println("Correct website");
        }else{
            System.out.println("wrong website");
        }
        System.out.println(driver.getCurrentUrl());
        WebElement button1= driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
        boolean validationbutton=button1.isDisplayed();
        boolean expectedbutton=true;
        if(validationbutton==expectedbutton){
            System.out.println("Button is display");
        }else{
            System.out.println("button is nor displayed");
        }
        button1.click();
        Thread.sleep(1000);
        WebElement firstName= driver.findElement(By.name("firstname"));
        firstName.sendKeys("Darya");

        WebElement lastName= driver.findElement(By.name("lastname"));
        lastName.sendKeys("Karpova");

        WebElement email= driver.findElement(By.name("reg_email__"));
        email.sendKeys("stervane@gmail.com");

        WebElement reEmail=driver.findElement(By.name("reg_email_confirmation__"));
        reEmail.sendKeys("stervane@gmail.com");

        WebElement password= driver.findElement(By.name("reg_passwd__"));
        password.sendKeys("stervane1234");

        WebElement month= driver.findElement(By.id("month"));
        month.sendKeys("Apr");

        WebElement birthday= driver.findElement(By.name("birthday_day"));
        birthday.sendKeys("14");

        WebElement year= driver.findElement(By.name("birthday_year"));
        year.sendKeys("1987");

        WebElement sex= driver.findElement(By.xpath("//input[@name='sex' and @value='1']"));
        sex.click();
        WebElement signup=driver.findElement(By.name("websubmit"));
        signup.click();



    }
}
