package by.it.psmishenko.matlab;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by GN on 05.04.2017.
 */
public class ParserTest{
    // Для каждого типа операции со скаляром (+ -* /) реализован соответствующий тест парсерана JUnit
    @Test
    public void number() throws Exception {
        Parser parser=new Parser();
        String expression1="A=5*2-2+6/3";
        String res=parser.calc(expression1).toString();
        String control1="10.0";
        assertTrue(res.equals(control1));
    }
    //Для каждого типа операции свекторами реализован соответствующий тест JUnit
    @org.junit.Test
    public void vector() throws Exception {
        Parser parser=new Parser();
        String expression="A={1,2}+{3,4}-{1,2}*{4,5}";
        String res=parser.calc(expression).toString();
        String control="{-10.0,-8.0}";
        assertEquals(res,control);
        //
        String expression1="A={1,2}/2+5*{1,2}";
        String res1=parser.calc(expression1).toString();
        String control1="{5.5,11.0}";
        assertEquals(res1,control1);

    }
//Для каждого допустимого типа операции сматрицами был реализован соответствующий тест JUnit
    @org.junit.Test
    public void matrix() throws Exception {
        Parser parser=new Parser();
        String expression="A={{1,2},{3,4}}+{{1,2},{3,4}}-{{1,2},{3,4}}";
        String res=parser.calc(expression).toString();
        String control="{{1.0,2.0},{3.0,4.0}}";
        assertEquals(res,control);
        //
        String expression1="A={{1,2},{3,4}}*{{1,2},{3,4}}*5*{1,2}";
        String res1=parser.calc(expression1).toString();
        String control1="{135.0,295.0}";
        assertEquals(res1,control1);
    }
    //Для каждого типа переменных был реализован соответствующий тест создания и вывода переменной в JUnit
    @org.junit.Test
    public void createVarAndToString() throws Exception {
        String expression = "5";
        Var varF = new VarF(expression);
        assertEquals("5.0", varF.toString());

        String expression1 = "{1,2}";
        Var varV = new VarV(expression1);
        assertEquals("{1.0,2.0}", varV.toString());

        String expression2 = "{{1,2},{3,4}}";
        Var varM = new VarM(expression2);
        assertEquals("{{1.0,2.0},{3.0,4.0}}", varM.toString());
    }
}