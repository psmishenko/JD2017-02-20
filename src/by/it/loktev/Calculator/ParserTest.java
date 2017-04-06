package by.it.loktev.Calculator;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class ParserTest {

    static private HashMap<String,Var> varsReal;

    private void testParser(String exprStr, String goodResStr) throws CalculatorException {
        String realResStr = Parser.parseAndCalc(exprStr,false).toString();
        assertEquals(realResStr,goodResStr);
    }

    @Test
    public void varTest1() throws CalculatorException {
        testParser((new VarF("3.8")).toString(),"3.8");
    }

    @Test
    public void varTest2() throws CalculatorException {
        testParser((new VarV("{55.2,33.33,8,3.3}")).toString(),"{55.2,33.33,8.0,3.3}");
    }

    @Test
    public void varTest3() throws CalculatorException {
        testParser((new VarM("{{5.2,3.3},{8,1.3},{1,2.2}}")).toString(),"{{5.2,3.3},{8.0,1.3},{1.0,2.2}}");
    }

    @Test
    public void parserTest1() throws CalculatorException {
        testParser("2+3","5.0");
    }

    @Test
    public void parserTest2() throws CalculatorException {
        testParser("6+3*4/6-1","7.0");
    }

    @Test
    public void parserTest3() throws CalculatorException {
        testParser("{5,7}+3","{8.0,10.0}");
    }

    @Test
    public void parserTest4() throws CalculatorException {
        testParser("{5,7}+{1,3}","{6.0,10.0}");
    }

    @Test
    public void parserTest5() throws CalculatorException {
        testParser("{5,7}*2","{10.0,14.0}");
    }

    @Test
    public void parserTest6() throws CalculatorException {
        testParser("{{5.2,3.3},{8,1.3},{1,2.2}} * {{2},{3}}","{{20.299999999999997},{19.9},{8.600000000000001}}");
    }

    @Test
    public void parserTest7() throws CalculatorException {
        testParser("{{5.2,3.3},{8,1.3},{1,2.2}} * {2,3}","{20.299999999999997,19.9,8.600000000000001}");
    }

    @Test
    public void parserTest8() throws CalculatorException {
        testParser("{{5.2,3.3},{8,1.3},{1,2.2}} + 1","{{6.2,4.3},{9.0,2.3},{2.0,3.2}}");
    }

    @Test
    public void parserTest9() throws CalculatorException {
        testParser("-9-0.9","-9.9");
    }

    @Test
    public void parserTest10() throws CalculatorException {
        testParser("(6+3)*2","18.0");
    }

    @Test
    public void parserTest11() throws CalculatorException {
        testParser("(6+3)*(2+1)","27.0");
    }

    @Test
    public void parserTest12() throws CalculatorException {
        testParser("-(6+3)*4/(7-1)","-6.0");
    }

    @Test
    public void parserTest13() throws CalculatorException {
        testParser("2*(3+4*(1+5))","54.0");
    }

    @BeforeClass
    public static void prepareStorage() throws CalculatorException {
        Storage.setTestMode();
        Parser.parseAndCalc("aaa=5+2 ",false);
        Parser.parseAndCalc("ccc=8 ",false);
        Parser.parseAndCalc("bbb=7+1*2 ",false);
        Parser.parseAndCalc("ddd={2.2,3.3} ",false);
        Parser.parseAndCalc("eee={{2.2,3.3},{7.7,6.6}} ",false);
    }


    @Test
    public void storageTest1() throws CalculatorException {
        testParser("aaa","7.0");
    }

    @Test
    public void storageTest2() throws CalculatorException {
        testParser("bbb","9.0");
    }

    @Test
    public void storageTest3() throws CalculatorException {
        testParser("ccc","8.0");
    }

    @Test
    public void storageTest4() throws CalculatorException {
        testParser("ddd","{2.2,3.3}");
    }

    @Test
    public void storageTest5() throws CalculatorException {
        testParser("eee","{{2.2,3.3},{7.7,6.6}}");
    }

    @Test
    public void storageTest6() throws CalculatorException {
        testParser("aaa*(1+bbb)","70.0");
    }


        /*
        System.out.println("=== тест исключений:");

        try {
            oneRes(Parser.parseAndCalc(" aaa+eee ",false));
        } catch (CalculatorException e) {
            System.out.println("исключение: "+e);
        }

        try {
            oneRes(Parser.parseAndCalc(" 5/0",false));
        } catch (CalculatorException e) {
            System.out.println("исключение: "+e);
        }

        try {
            oneRes(Parser.parseAndCalc(" (5+2",false));
        } catch (CalculatorException e) {
            System.out.println("исключение: "+e);
        }

        try {
            oneRes(Parser.parseAndCalc(" {5,7}+{1,3,8} ",false));
        } catch (CalculatorException e) {
            System.out.println("исключение: "+e);
        }

        try {
            oneRes(Parser.parseAndCalc(" {{5.2,3.3},{8,1.3},{1,2.2}} * {{2},{3},{4}} ",false));
        } catch (CalculatorException e) {
            System.out.println("исключение: "+e);
        }
         */


}