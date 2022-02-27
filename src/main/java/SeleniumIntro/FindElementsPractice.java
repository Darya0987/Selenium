package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElementsPractice {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.yahoo.com/");
        driver.manage().window().maximize();
        WebElement newsBlock= driver.findElement(By.id("root_2"));
        newsBlock.click();

        List<WebElement> allHeaders= driver.findElements(By.xpath("//h3"));
        int counter=0;
        for(int i=0;i<allHeaders.size();i++){
            if(allHeaders.get(i).getText().contains("COVID")) {
                System.out.println(allHeaders.get(i).getText());
                counter++;
            }
        }
        System.out.println(counter);
    }
}
