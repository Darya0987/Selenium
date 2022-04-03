package TestNG;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
//   @DataProvider(name="FullNameTest")
//
//    public Object[][]getData(){
//        return new  Object[][]{
//                {"darya","kovalyova","darya kovalyova"},
//                {"eric","eric1","eric eric1"},
//                {"enes","enes5","enes enes5"},
//                {"david","david2","david david2"},
//                {"olivia","sharapova","olivia sharapova"}
//        };
//    }

     @Test(dataProvider = "FullNameTest",dataProviderClass = DataForNames.class)
    public void test(String username,String lastname,String expectedfullName){
        String userName=username;
        String lastName=lastname;
        String fullName=userName+" "+lastName;
        Assert.assertEquals(fullName,expectedfullName);

    }






}
