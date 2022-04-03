package com.test.orengehrm.test;

import Utils.ConfigReader;
import com.test.orengehrm.DataForNegativeTest;
import com.test.orengehrm.TestBase;
import com.test.orengehrm.pages.AdminPage;
import com.test.orengehrm.pages.LoginPage;
import com.test.orengehrm.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AdminTest extends TestBase {
    @Test
    public void validateTheCreationOfEmployeeMessage() throws InterruptedException{
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login("Admin","admin123");
        MainPage mainPage=new MainPage(driver);
        mainPage.clickAdminButton();
        AdminPage adminPage=new AdminPage(driver);
        adminPage.sendingAllInformationForEmployee();
        Assert.assertTrue(adminPage.validationTheEmployeeIsCreated("daryakovne4"));

    }


    @Test(dataProvider = "UserRoles",dataProviderClass = DataForNegativeTest.class)
    public void validateSelectRoleFunction(String roleName){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login(ConfigReader.readProperty("orangehrmusername"),ConfigReader.readProperty("orangehrmpassword"));
        MainPage mainPage=new MainPage(driver);
        mainPage.clickAdminButton();
        AdminPage adminPage=new AdminPage(driver);
        adminPage.selectUserRole(roleName,driver);
        Assert.assertTrue(adminPage.validateRoleText(roleName));

    }
//    @Test
//    public void validateSelectRoleFunction2(){
//        LoginPage loginPage=new LoginPage(driver);
//        loginPage.login(ConfigReader.readProperty("orangehrmusername"),ConfigReader.readProperty("orangehrmpassword"));
//        MainPage mainPage=new MainPage(driver);
//        mainPage.clickAdminButton();
//        AdminPage adminPage=new AdminPage(driver);
//        adminPage.selectUserRole("ESS",driver);
//        Assert.assertTrue(adminPage.validateRoleText2("ESS"));
//    }
}
