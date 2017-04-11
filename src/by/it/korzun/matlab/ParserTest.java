package by.it.korzun.matlab;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {
    @Test
    public void floatVarOperations()throws Exception{
        Parser parser = new Parser();
        String firstExpectation = "7.3";
        Var res = parser.parseString("A=2+5.3",false);
        assertEquals(firstExpectation, res.toString());

        String secondExpectation = "25.55";
        res = parser.parseString("B=A*3.5", false);
        assertEquals(secondExpectation, res.toString());

        String thirdExpectation = "25.0";
        res = parser.parseString("B1=B+0.11*-5", false);
        assertEquals(thirdExpectation, res.toString());

        String forthExpectation = "2.65";
        res = parser.parseString("B2=A/2-1", false);
        assertEquals(forthExpectation, res.toString());
    }

    @Test
    public void vectorVarOperationsAndBrackets()throws Exception{
        Parser parser = new Parser();
        String firstExpectation = "40.15";
        parser.parseString("A=7.3",false);
        parser.parseString("B=25.55", false);
        Var res = parser.parseString("C=B+(A*2)",false);
        assertEquals(firstExpectation, res.toString());

        String secondExpectation = "10.0";
        res = parser.parseString("D=((C-0.15)-20)/(7-5)", false);
        assertEquals(secondExpectation, res.toString());

        String thirdExpectation = "[10.0, 15.0]";
        res = parser.parseString("E={2,3}*(D/2)", false);
        assertEquals(thirdExpectation, res.toString());
    }

    @Test
    public void matrixVarOperationsAndBrackets()throws Exception{
        Parser parser = new Parser();
        String firstExpectation = "[[10.0, 15.0], [20.0, 24.0]]";
        Var res = parser.parseString("F={{9,14},{19,23}}+1",false);
        assertEquals(firstExpectation, res.toString());

        String secondExpectation = "[[9.0, 14.0], [19.0, 23.0]]";
        res = parser.parseString("G=F-1", false);
        assertEquals(secondExpectation, res.toString());

        String thirdExpectation = "[83.0, 149.0]";
        res = parser.parseString("H=G*{3,4}", false);
        assertEquals(thirdExpectation, res.toString());
    }

}