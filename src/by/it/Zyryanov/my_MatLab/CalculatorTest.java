package by.it.Zyryanov.my_MatLab;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class CalculatorTest {
    @org.junit.Test
    public void calculate() throws Exception {
        Calculator calculator=new Calculator();
        String expression="A=2+6/3";
        String res=calculator.calculate(expression).toString();
        String control="4.0";
        assertTrue(res.equals(control));
    }
    @org.junit.Test
    public void vector() throws Exception {
        Calculator calculator=new Calculator();
        String expression="A={1,2}+{3,4}";
        String res=calculator.calculate(expression).toString();
        String control="{4.0,6.0}";
        assertEquals(res,control);
    }
}