package by.it.loktev.Calculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {

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


        /*
            System.out.println("=== тест работы с переменными:");

            Parser.parseAndCalc("aaa=5+2 ",false);
            Parser.parseAndCalc(" ccc =8 ",false);
            Parser.parseAndCalc("bbb=7+1*2 ",false);
            Parser.parseAndCalc("ddd={2.2,3.3} ",false);
            Parser.parseAndCalc("eee={{2.2,3.3},{7.7,6.6}} ",false);
            Parser.parseAndCalc("printvar",false);
            Parser.parseAndCalc("sortvar",false);
            oneRes(Parser.parseAndCalc(" aaa*(1+bbb) ",false));

            oneRes(Parser.parseAndCalc(" aaa*(1+bbb) ",false));

=== тест работы с переменными:
Переменные в хранилище:
aaa: 7.0
ccc: 8.0
bbb: 9.0
eee: {{2.2,3.3},{7.7,6.6}}
ddd: {2.2,3.3}
Переменные в хранилище по алфавиту:
aaa: 7.0
bbb: 9.0
ccc: 8.0
ddd: {2.2,3.3}
eee: {{2.2,3.3},{7.7,6.6}}
70.0
=== тест работы с автосохранёнными переменными:
Переменные в хранилище по алфавиту:
aaa: 7.0
bbb: 9.0
ccc: 8.0
ddd: {2.2,3.3}
eee: {{2.2,3.3},{7.7,6.6}}
70.0

        }
        catch (CalculatorException e)
        {
            System.out.println("исключение: "+e);
        }

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