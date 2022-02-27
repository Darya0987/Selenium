package ActionClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Practice1 {
    @Test
    public void DragAndDropPractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://demoqa.com/droppable");
        driver.manage().window().maximize();
        WebElement draggable=driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement blueBox=driver.findElement(By.xpath("//div[@class='drop-box ui-droppable']"));
        Actions actions=new Actions(driver);
        String actualMessage= BrowserUtils.getTextMethod(blueBox);
        String expectedMessage="Drop here";
        Assert.assertEquals(actualMessage,expectedMessage);
        actions.dragAndDrop(draggable,blueBox).perform();
        Thread.sleep(3000);
        blueBox=driver.findElement(By.xpath("//div[@class='drop-box ui-droppable ui-state-highlight']"));

        String actualAfterDragAndDrop=BrowserUtils.getTextMethod(blueBox);
        String expectedAfterDragAndDrop="Dropped!";
        Assert.assertEquals(actualAfterDragAndDrop,expectedAfterDragAndDrop);

        String actualcssValue= blueBox.getCssValue("background-color");
        String expectedCssValue="rgba(70, 130, 180, 1)";
        Assert.assertEquals(actualcssValue,expectedCssValue);

    }
    @Test
    public void ClickAndHoldPractice(){
        /*
        1)Navigate to the website :"https://demoqa.com/droppable"
        2)Click Accept
        3)ClickAndHold notAccepted box and release to Drop box
        4)validate the background is still white and message is still Drop here
        5)ClickAndHold acceptable box and release to Drop box
        6)Validate the background is blue and message is dropped
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://demoqa.com/droppable");
        driver.manage().window().maximize();
        WebElement accept=driver.findElement(By.xpath("//a[@id='droppableExample-tab-accept']"));
        accept.click();
        WebElement notAcceptedBox=driver.findElement(By.id("notAcceptable"));
        WebElement otherBox= driver.findElement(By.xpath("//div[@id='acceptDropContainer']//div[@id='droppable']"));
        Actions actions=new Actions(driver);
        actions.clickAndHold(notAcceptedBox).moveToElement(otherBox).release().perform();
    }
}
