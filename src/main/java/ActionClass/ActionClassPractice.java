package ActionClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class ActionClassPractice {
    @Test
    public void ContextClick(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        WebElement contextMenu=driver.findElement(By.partialLinkText("Context"));
        contextMenu.click();
        WebElement box= driver.findElement(By.id("hot-spot"));
       Actions actions=new Actions(driver);
       actions.contextClick(box).perform();
    }
    @Test
    public void HoverOver() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        WebElement hover=driver.findElement(By.linkText("Hovers"));
        hover.click();
        Actions actions=new Actions(driver);
        List<WebElement> names=driver.findElements(By.tagName("h5"));
        List<WebElement> pictures= driver.findElements(By.xpath("//div[@class='figure']/img"));
        List<String> expectedNames= Arrays.asList("name: user1","name: user2","name: user3");
        for(int i=0;i< names.size();i++){
            Thread.sleep(2000);
            actions.moveToElement(pictures.get(i)).perform();
            Assert.assertEquals(BrowserUtils.getTextMethod(names.get(i)),expectedNames.get(i));
            System.out.println(BrowserUtils.getTextMethod(names.get(i)));
        }
    }
    @Test
    public void doubleClick(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://demo.guru99.com/test/simple_context_menu.html");
        driver.manage().window().maximize();
        WebElement doubleClickButton=driver.findElement(By.tagName("button"));
        Actions actions=new Actions(driver);
        //actions.doubleClick(doubleClickButton).perform();
        //actions.doubleClick(driver.findElement(By.tagName("button"))).perform();
        WebElement rightClick= driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
        Actions actions1=new Actions(driver);


    }
    @Test
    public void doubleClickPractice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://selenium08.blogspot.com/2019/11/double-click.html");
        driver.manage().window().maximize();
        WebElement button=driver.findElement(By.xpath("//button[.='Double-Click me to see Alert message']"));
        Actions actions=new Actions(driver);
        actions.doubleClick(button).perform();

    }
    @Test
    public void dragAndDrop() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        driver.manage().window().maximize();
//        WebElement acceptCookies= driver.findElement(By.id("onetrust-accept-btn-handler"));
//        Thread.sleep(3000);
//        acceptCookies.click();
        Actions actions = new Actions(driver);
//        for(int i = 0; i<5;i++){
//            actions.sendKeys(Keys.ARROW_DOWN).perform();
//        }
        WebElement draggable=driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement orangeBox=driver.findElement(By.xpath("//div[@class='test2']"));
        String actualMessage=BrowserUtils.getTextMethod(orangeBox);
        String expectedMessage="... Or here.";
        Assert.assertEquals(actualMessage,expectedMessage);
        actions.dragAndDrop(draggable,orangeBox).perform();
        Thread.sleep(3000);
        orangeBox=driver.findElement(By.xpath("//div[@class='test2']"));
        String actualAfterDragAndDrop=BrowserUtils.getTextMethod(orangeBox);
        String expectedAfterDragAndDrop="You did great!";
        Assert.assertEquals(actualAfterDragAndDrop,expectedAfterDragAndDrop);

        String actualcssValue= orangeBox.getCssValue("background-color");
        String expectedCssValue="rgba(238, 111, 11, 1)";
        Assert.assertEquals(actualcssValue,expectedCssValue);

    }
    @Test
    public void ClickAndHold(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        driver.manage().window().maximize();
        WebElement blueBox=driver.findElement(By.xpath("//div[@class='test1']"));
        String actualBlueBoxMessage=BrowserUtils.getTextMethod(blueBox);
        String expectedBlueBoxMessage="Drag the small circle here ...";
        Assert.assertEquals(actualBlueBoxMessage,expectedBlueBoxMessage);
        WebElement draggable=driver.findElement(By.xpath("//div[@id='draggable']"));
        Actions actions=new Actions(driver);
        actions.clickAndHold(draggable).moveToElement(blueBox).release().perform();
    }
    @Test
    public void MoveByOffSet(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
        driver.manage().window().maximize();
        WebElement slider=driver.findElement(By.xpath("//input"));
        Actions actions=new Actions(driver);
        actions.clickAndHold(slider).moveByOffset(30,0).perform();

    }
    @Test
    public void sliderShortCut() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
        driver.manage().window().maximize();
        WebElement slider=driver.findElement(By.xpath("//input"));
        WebElement range=driver.findElement(By.xpath("//span[@id='range']"));
        String myRange="5";
        while(range.getText().trim().equals(myRange)){
           Thread.sleep(3000);
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
    }
    @Test
    public void task(){
        /*
        TASK FOR STUDENTS:
1)navigate to the Website "https://text-compare.com/"
2)Type with the Keys --> "Good Bye Keys"
3)with CTRL(COMMAND)+A --> select all text
4)Copy this text CTRL(COMMAND) + C --> it will copy the text
5)Go to the second box and paste CTRL(COMMAND) + V-->it will paste the text
6) Validate this two boxes text are matching
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://text-compare.com/");
        //driver.manage().window().maximize();
        WebElement box=driver.findElement(By.xpath("//textarea[@name='text1']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(box).click()
                .keyDown(Keys.SHIFT)
                .sendKeys("g").keyUp(Keys.SHIFT)
                .sendKeys("ood").sendKeys(Keys.SPACE)
                .keyDown(Keys.SHIFT)
                .sendKeys("b").keyUp(Keys.SHIFT)
                .sendKeys("ey").sendKeys(Keys.SPACE)
                .keyDown(Keys.SHIFT)
                .sendKeys("k").keyUp(Keys.SHIFT)
                .sendKeys("eys").keyDown(Keys.CONTROL)
                .sendKeys("a").keyUp(Keys.CONTROL)
                .keyDown(Keys.CONTROL)
                .sendKeys("c").keyUp(Keys.CONTROL)
                .perform();
        WebElement box2=driver.findElement(By.xpath("//textarea[@name='text2']"));
        Actions actions1=new Actions(driver);
        actions.moveToElement(box2).click()
                .keyDown(Keys.CONTROL)
               .sendKeys("v").keyUp(Keys.CONTROL).perform();

        String str=box.getText();
        String str2= box2.getText();
        if(str.equals(str2)){
            System.out.println("It's same");
        }else{
            System.out.println("Not same");
        }
    }
    @Test
    public void MoveByOffSetPractice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("http://www.techtorialacademy.com/");
        WebElement contactUs=driver.findElement(By.xpath("//div[@class='navigation hidden-xs']//a[.='Contact Us']"));
        Point coordinatesOfContactUs=contactUs.getLocation();
        int xCoord=coordinatesOfContactUs.getX();
        int yCoord=coordinatesOfContactUs.getY();
        Actions actions=new Actions(driver);
        actions.moveByOffset(xCoord,yCoord).click().perform();


    }
}
