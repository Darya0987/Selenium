package SlectClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Locale;

public class DreamCars {
    @Test
    public void Tesla(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://www.cars.com/");
        driver.manage().window().maximize();

        WebElement car= driver.findElement(By.xpath("//select[@id='make-model-search-stocktype']"));
        BrowserUtils.selectBy(car,"Used cars","text");

        WebElement model=driver.findElement(By.xpath("//select[@id='makes']"));
        BrowserUtils.selectBy(model,"Tesla","text");

        WebElement modelCar=driver.findElement(By.xpath("//select[@id='models']"));
        BrowserUtils.selectBy(modelCar,"0","index");

        WebElement price=driver.findElement(By.xpath("//select[@id='make-model-max-price']"));
        BrowserUtils.selectBy(price,"10","index");

        WebElement distance=driver.findElement(By.xpath("//select[@id='make-model-maximum-distance']"));
        BrowserUtils.selectBy(distance,"7","index");

        WebElement button=driver.findElement(By.xpath("//button[.='Search']"));
        button.click();

        WebElement header=driver.findElement(By.xpath("//h1"));
        String actual = header.getText().trim();
        String expected = "Used Tesla for sale";
        Assert.assertEquals(actual, expected);

        List<WebElement> validationForHeaders= driver.findElements(By.xpath("//h2[@class='title']"));
        for(WebElement car1:validationForHeaders){
            boolean contains=car.getText().trim().toLowerCase().contains("tesla");
            Assert.assertTrue(contains);
        }

    }
}
