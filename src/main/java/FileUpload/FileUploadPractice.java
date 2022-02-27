package FileUpload;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadPractice {
    @Test
    public void ValidateFileUpload(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/upload");
        WebElement chooseFile=driver.findElement(By.id("file-upload"));
        chooseFile.sendKeys("C:\\Users\\moham\\OneDrive\\Desktop\\USA.jpg");
        WebElement uploadButton= driver.findElement(By.id("file-submit"));
        uploadButton.click();
        WebElement message1=driver.findElement(By.tagName("h3"));
        String actualMessage1= BrowserUtils.getTextMethod(message1);
        String expectedMessage1="File Uploaded!";
        Assert.assertEquals(actualMessage1,expectedMessage1);
        WebElement message2=driver.findElement(By.id("uploaded-files"));
        String actualMessage2=BrowserUtils.getTextMethod(message2);
        String expectedMessage2="usa.png";
        Assert.assertEquals(actualMessage2,expectedMessage2);

    }
}
