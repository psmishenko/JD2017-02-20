package by.it.psmishenko.matlab;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by GN on 05.04.2017.
 */
public class ParserTest {
    @Test
    public void number() throws Exception {
        Parser parser=new Parser();
        String expression1="A=5*2-2+6/3";
        String res=parser.calc(expression1).toString();
        String control1="10.0";
        assertTrue(res.equals(control1));
    }
    @org.junit.Test
    public void vector() throws Exception {
        Parser parser=new Parser();
        String expression="A={1,2}+{3,4}-{1,2}*{4,5}";
        String res=parser.calc(expression).toString();
        String control="{-10.0,-8.0}";
        assertEquals(res,control);
    }

    @org.junit.Test
    public void matrix() throws Exception {
        Parser parser=new Parser();
        String expression="A={{1,2},{3,4}}+{{1,2},{3,4}}-{{1,2},{3,4}}";
        String res=parser.calc(expression).toString();
        String control="{{1.0,2.0},{3.0,4.0}}";
        assertEquals(res,control);
    }
}