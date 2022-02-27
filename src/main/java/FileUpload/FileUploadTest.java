package FileUpload;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadTest {
    /*
1)Navigate to the "https://demo.guru99.com/test/upload/'
2)Upload the usa.png file on the website
3)Click the box (I accept terms of service)
4)validate box is selected
5)Click submit button
6)Validate the message "1 file has been successfully uploaded."
 */
    @Test
    public void ValidateFile(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.navigate().to("https://demo.guru99.com/test/upload/");
        WebElement chooseFile=driver.findElement(By.id("uploadfile_0"));
        chooseFile.sendKeys("C:\\Users\\moham\\OneDrive\\Desktop\\USA.jpg");
        WebElement accept=driver.findElement(By.id("terms"));
        accept.click();
//        WebElement accept1=driver.findElement(By.id("terms"));
//        boolean isSelect=accept1.isSelected();
        Assert.assertTrue(accept.isSelected());//we use just this one
        WebElement submit=driver.findElement(By.id("submitbutton"));
        submit.click();
        WebElement text=driver.findElement(By.xpath("//h3"));
        String actualText= BrowserUtils.getTextMethod(text);
        System.out.println(actualText);
        String expectedText="1 file has been successfully uploaded.";
        Assert.assertEquals(actualText,expectedText);

    }
}
