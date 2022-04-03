package com.test.orengehrm.test;

import com.test.orengehrm.TestBase;
import com.test.orengehrm.pages.LoginPage;
import com.test.orengehrm.pages.MainPage;
import com.test.orengehrm.pages.PimPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PimTest extends TestBase {
    LoginPage loginPage;
    MainPage mainPage;
    PimPage pimPage;

    @BeforeMethod
    public void initializingPages() {
         loginPage = new LoginPage(driver);
         mainPage = new MainPage(driver);
         pimPage = new PimPage(driver);
    }


        @Test
        public void ValidateTheCreationOfEmployee () throws InterruptedException {
            loginPage.login("Admin", "admin123");
            mainPage.clickPimButton();
            pimPage.addEmployeeForPIM("darya", "ko", "1987", "C:\\Users\\moham\\OneDrive\\Desktop\\USA.jpg");
            Assert.assertEquals(pimPage.validateFirstName(), "darya");
            Assert.assertEquals(pimPage.validateLastName(), "ko");
            Assert.assertTrue(pimPage.validateEmployeeId("1987"));
        }
    @Test
    public void ValidatePersonalDetailElement() throws InterruptedException {
        loginPage.login("Admin","admin123");
        mainPage.clickPimButton();
        pimPage.addEmployeeForPIM("darya","ko","1987","C:\\Users\\moham\\OneDrive\\Desktop\\USA.jpg");
        pimPage.editPersonalDetails("Russian","1987-04-14","Married");
        Assert.assertEquals(pimPage.validateTheNationality(),"Russian");
    }


}

