package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathPractice {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.get("file:///C:/Users/moham/OneDrive/Desktop/Techtorial%20(2).html");
        WebElement javaLink=driver.findElement(By.xpath("//a[@href='https://www.oracle.com/java/']"));
        javaLink.click();
    }
}
