package Assessment;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.lang.ArithmeticException;

public class MyUnitTest extends ArithmeticOperations {

    @Test
    public void test_Sum_Two_Numbers(){
        MyUnitTest myUnit = new MyUnitTest();
        int result = myUnit.getSum(100, 50);
        Assert.assertEquals(150, result);
    }

    @Test
    public void test_Sum_IntMaxValue_With_Number(){
        MyUnitTest myUnit = new MyUnitTest();
        int result = myUnit.getSum(Integer.MAX_VALUE, 1);
        Assert.assertEquals(Integer.MIN_VALUE, result);
    }

    @Test
    public void test_Sum_IntMinValue_With_MaxValue(){
        MyUnitTest myUnit = new MyUnitTest();
        int result = myUnit.getSum(Integer.MIN_VALUE, Integer.MAX_VALUE);
        Assert.assertEquals(-1, result);
    }

    @Test
    public void test_Sum_IntMinValue_With_Number(){
        MyUnitTest myUnit = new MyUnitTest();
        int result = myUnit.getSum(Integer.MIN_VALUE, 1);
        Assert.assertEquals(-2147483647, result);
    }

    @Test
    public void test_Sum_MinusValue_With_MinusValue(){
        MyUnitTest myUnit = new MyUnitTest();
        int result = myUnit.getSum(-100, -50);
        Assert.assertEquals(-150, result);
    }

    @Test
    public void test_Difference_Two_Numbers(){
        MyUnitTest myUnit = new MyUnitTest();
        int result = myUnit.getDifference(10, 5);
        Assert.assertEquals(5, result);
    }

    @Test
    public void test_Difference_IntMaxValue_IntMinValue(){
        MyUnitTest myUnit = new MyUnitTest();
        int result = myUnit.getDifference(Integer.MAX_VALUE, Integer.MIN_VALUE);
        Assert.assertEquals(-1, result);
    }

    @Test
    public void test_Difference_Zero_Number(){
        MyUnitTest myUnit = new MyUnitTest();
        int result = myUnit.getDifference(0, 5);
        Assert.assertEquals(-5, result);
    }

    @Test
    public void test_Product_Two_Numbers(){
        MyUnitTest myUnit = new MyUnitTest();
        int result = myUnit.getProduct(10, 5);
        Assert.assertEquals(50, result);
    }

    @Test
    public void test_Product_Two_MinusValues(){
        MyUnitTest myUnit = new MyUnitTest();
        int result = myUnit.getProduct(-10, -5);
        Assert.assertEquals(50, result);
    }

    @Test
    public void test_Product_Number_Zero(){
        MyUnitTest myUnit = new MyUnitTest();
        int result = myUnit.getProduct(10, 0);
        Assert.assertEquals(0, result);
    }

    @Test
    public void test_Product_MinusValue_Number(){
        MyUnitTest myUnit = new MyUnitTest();
        int result = myUnit.getProduct(-10, 5);
        Assert.assertEquals(-50, result);
    }

    @Test
    public void test_Division_Two_Numbers(){
        MyUnitTest myUnit = new MyUnitTest();
        int result = myUnit.getDivision(10,2);
        Assert.assertEquals(5, result);
    }

    @Test
    public void test_Division_Divide_by_Zero() throws ArithmeticException{
        MyUnitTest myUnit = new MyUnitTest();
        try {

            int result = myUnit.getDivision(1, 0);

        }catch (ArithmeticException e){

            Assert.assertEquals(2, 2);
            System.out.println("Division by zero.");

        }
    }

    @Test
    public void test_Remaining_Value(){
        MyUnitTest myUnit = new MyUnitTest();
        int result = myUnit.getRem(15, 2);
        Assert.assertEquals(1, result);
    }

    @Test
    public void test_Remaining_Value_Zero(){
        MyUnitTest myUnit = new MyUnitTest();
        int result = myUnit.getRem(15, 5);
        Assert.assertEquals(0, result);
    }
}
