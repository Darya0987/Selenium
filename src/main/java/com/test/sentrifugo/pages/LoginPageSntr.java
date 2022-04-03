package com.test.sentrifugo.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LoginPageSntr {
    public LoginPageSntr(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    //We are going to store our element locations and methods here.
    @FindBy(xpath = "//input[@id='username']")
    WebElement userName;
    @FindBy(xpath = "//input[@id='password']")
    WebElement password;
    @FindBy(xpath = "//input[@id='loginsubmit']")
    WebElement loginButton;
    //    public void logIn(){
//        userName.sendKeys("EM01");
//        password.sendKeys("sentrifugo");
//        loginButton.click();
//    }
    public void dynamicLogin(String userName, String password){
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
        loginButton.submit();
    }

}
