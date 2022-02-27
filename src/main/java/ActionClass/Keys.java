package ActionClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Keys {
    @Test
    public void ActionKeys() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);
        WebElement googleSearchBox = driver.findElement(By.name("q"));
        actions.moveToElement(googleSearchBox).click()
                .keyDown(org.openqa.selenium.Keys.SHIFT)
                .sendKeys("s").keyUp(org.openqa.selenium.Keys.SHIFT)
                .sendKeys("elenium").doubleClick()
                .keyDown(org.openqa.selenium.Keys.CONTROL).sendKeys("c")
                .keyUp(org.openqa.selenium.Keys.CONTROL)
                .sendKeys(org.openqa.selenium.Keys.ARROW_RIGHT)
                .keyDown(org.openqa.selenium.Keys.CONTROL).sendKeys("v")
                .keyUp(org.openqa.selenium.Keys.CONTROL)
                .sendKeys(org.openqa.selenium.Keys.ENTER).perform();
    }
}
