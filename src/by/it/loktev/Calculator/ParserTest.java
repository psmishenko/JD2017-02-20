package by.it.loktev.Calculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {
    @Test
    public void parseAndCalc() throws Exception {

        String expression="2+3";
        String goodresult="5.0";

        String realresult=Parser.parseAndCalc(expression,false).toString();


        assertEquals(realresult,goodresult);

    }


}