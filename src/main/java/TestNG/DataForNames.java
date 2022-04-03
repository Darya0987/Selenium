package TestNG;

import org.testng.annotations.DataProvider;

public class DataForNames {
    @DataProvider(name="FullNameTest")

    public Object[][]getData(){
        return new  Object[][]{
                {"darya","kovalyova","darya kovalyova"},
                {"eric","eric1","eric eric1"},
                {"enes","enes5","enes enes5"},
                {"david","david2","david david2"},
                {"olivia","sharapova","olivia sharapova"}
        };
    }
}
