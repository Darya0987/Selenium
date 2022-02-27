package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertion {
    public double getMulti(double number1,double number2){
        return number1*number2;
    }
    @Test
    public void validateMultiplication(){

        double actualResult=getMulti(5,6);
        double expectedResult=30;
        Assert.assertEquals(actualResult,expectedResult);
    }

    public double getDivision(double num1,double num2){
        if(num1>num2){
            return num1/num2;
        }
        return num2/num1;
    }
    public int substraction(int num1,int num2){
        if(num1>=num2){
            return num1-num2;
        }
        return num2-num1;
    }
    @Test
    public void validateDivision(){
       double actualResult=getDivision(8,2);
       double expectedResult=4;
       Assert.assertEquals(actualResult,expectedResult);
    }
    @Test
    public void validateSubstraction(){
        int actualResult=substraction(65,43);
        int expectedResult=22;
        Assert.assertEquals(actualResult,expectedResult);
    }


    }

