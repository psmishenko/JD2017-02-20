package by.it.sorokoee.calculator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by DELL_PC on 06.04.2017.
 */
public class ParserTest {
    @Test
    public void calc() throws Exception {
        Parser parser=new Parser();
        String expression="A=2+6*3";
        String res=parser.calc(expression).toString();
        String control="20.0";
        assertTrue(res.equals(control));
    }

}