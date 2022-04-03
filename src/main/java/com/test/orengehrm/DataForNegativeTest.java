package com.test.orengehrm;

import org.testng.annotations.DataProvider;

public class DataForNegativeTest {
    @DataProvider(name = "LoginNegativeTestScenario")
    public Object[][] getNegativeScenarioData(){
        return new Object[][]{
                {"Admin","wrongPassword","Invalid credentials"},
                {"wrongUsername","admin123","Invalid credentials"},
                {"wrongUsername","wrongPassword","Invalid credentials"}
        };
    }
    @DataProvider(name = "UserRoles")
    public Object[][] getUserRolesData(){
        return new Object[][]{
                {"Admin"},
                {"ESS"}
        };

    }
}
