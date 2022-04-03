package com.test.orengehrm.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PimPage {
    /*
    1)Click PIM on the mainpage
    2)Click Add button under PIM
    3)Fill the boxes
    4)Click Save Button
    5)Wait for the next direction
     */
    public PimPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "btnAdd")
    WebElement addButton;
    @FindBy(id = "firstName")
    WebElement firstName;
    @FindBy(id = "lastName")
    WebElement lastName;
    @FindBy(id = "employeeId")
    WebElement employeeId;
    @FindBy(id = "photofile")
    WebElement chooseFile;
    @FindBy(id = "btnSave")
    WebElement saveButton;
    @FindBy(name = "personal[txtEmpFirstName]")
    WebElement validationName;
    @FindBy(name = "personal[txtEmpLastName]")
    WebElement validationLastName;
    @FindBy(name = "personal[txtEmployeeId]")
    WebElement validationEmployeeId;
    @FindBy(id = "btnSave")
    WebElement editButton;
    @FindBy(id = "personal_optGender_2")
    WebElement femaleButton;
    @FindBy(id = "personal_cmbNation")
    WebElement nationality;
    @FindBy(id = "personal_DOB")
    WebElement dob;
    @FindBy(id = "personal_cmbMarital")
    WebElement maritalStatus;

    public void addEmployeeForPIM(String name,String lastName,String employeeId,String uploadFile) throws InterruptedException {
        addButton.click();
        this.firstName.sendKeys(name);
        this.lastName.sendKeys(lastName);
        this.employeeId.sendKeys(employeeId);
        this.chooseFile.sendKeys(uploadFile);
        Thread.sleep(1000);
        saveButton.click();
        Thread.sleep(1000);
    }
    public String validateFirstName(){
        return validationName.getAttribute("value");
    }
    public String validateLastName(){
        return validationLastName.getAttribute("value");
    }
    public boolean validateEmployeeId(String employeeId){
        return validationEmployeeId.getAttribute("value").endsWith(employeeId);
    }
    public void editPersonalDetails(String nation,String dateOfBirth,String maritalStatus){
        editButton.click();
        femaleButton.click();
        BrowserUtils.selectBy(nationality,nation,"text");
        this.dob.clear();
        this.dob.sendKeys(dateOfBirth);
        BrowserUtils.selectBy(this.maritalStatus,maritalStatus,"text");
        saveButton.click();
    }

    public String validateTheNationality(){
        Select select = new Select(nationality);
        return select.getFirstSelectedOption().getText().trim();
    }
}
