package com.test.orengehrm.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AdminPage {
    public AdminPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "btnAdd")
    WebElement addButton;

    @FindBy(id = "systemUser_userType")
    WebElement userRole;

    @FindBy(id = "systemUser_employeeName_empName")
    WebElement employeeName;

    @FindBy(xpath = "//input[@id='systemUser_userName']")
    WebElement userName;

    @FindBy(name = "systemUser[status]")
    WebElement status;

    @FindBy(name = "systemUser[password]")
    WebElement password;

    @FindBy(name = "systemUser[confirmPassword]")
    WebElement confermPassword;

    @FindBy(id = "btnSave")
    WebElement saveButton;

    @FindBy(xpath = "//tr//a[contains(@href,'saveSystemUser')]")
    List<WebElement> allNames;

    @FindBy(id = "searchSystemUser_userType")
    WebElement userRollBox;

    @FindBy(id = "searchBtn")
    WebElement searchBox;
    @FindBy(xpath = "//td[3]")
    List<WebElement> allAdminRolesOnTheTable;


    public void sendingAllInformationForEmployee() throws InterruptedException {
        addButton.click();
        BrowserUtils.selectBy(userRole, "Admin", "text");
        employeeName.sendKeys("Aaliyah Haq");
        userName.sendKeys("daryakovne4");
        BrowserUtils.selectBy(status, "0", "value");
        password.sendKeys("123daryakov");
        Thread.sleep(1000);
        confermPassword.sendKeys("123daryakov");
        Thread.sleep(1000);
        saveButton.click();
        Thread.sleep(1000);
    }

    public boolean validationTheEmployeeIsCreated(String userName) {
        for (WebElement name : allNames) {
            if (name.getText().trim().equals(userName)) {
                return true;
            }
        }
        return false;
    }

    public void selectUserRole(String roleName, WebDriver driver) {
        BrowserUtils.selectBy(userRollBox, roleName, "text");
        BrowserUtils.ClickWithJS(driver, searchBox);
    }

    public boolean validateRoleText(String roleName) {
        for (WebElement role : allAdminRolesOnTheTable) {
            if (!role.getText().trim().equals(roleName)) {
                return false;
            }
        }
        return true;
    }

    }

