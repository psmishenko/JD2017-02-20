package by.it.smirnov.jd02_06_matlab.Parser;

import by.it.smirnov.jd02_06_matlab.Vars.Var;
import by.it.smirnov.jd02_06_matlab.Vars.VarF;
import by.it.smirnov.jd02_06_matlab.Vars.VarM;
import by.it.smirnov.jd02_06_matlab.Vars.VarV;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Тесты парсера и констркукторов Var
 */
public class ParserTest {
    @Test
    public void calcVarFAddVarF() throws Exception {
        Parser parser=new Parser(null,null,null,null);
        String expression="2+6.5";
        String res=parser.calcExpression(expression).toString();
        String control="8.50";
        assertTrue(res.equals(control));
    }

    @Test
    public void calcVarFSubVarF() throws Exception {
        Parser parser=new Parser(null,null,null,null);
        String expression="1.8-5";
        String res=parser.calcExpression(expression).toString();
        String control="-3.20";
        assertTrue(res.equals(control));
    }

    @Test
    public void calcVarFMulVarF() throws Exception {
        Parser parser=new Parser(null,null,null,null);
        String expression="17.5*2.5";
        String res=parser.calcExpression(expression).toString();
        String control="43.75";
        assertTrue(res.equals(control));
    }

    @Test
    public void calcVarFDivVarF() throws Exception {
        Parser parser=new Parser(null,null,null,null);
        String expression="22.2/2";
        String res=parser.calcExpression(expression).toString();
        String control="11.10";
        assertTrue(res.equals(control));
    }


    @Test
    public void calcVarVAddVarV() throws Exception {
        Parser parser=new Parser(null,null,null,null);
        String expression="{1,2}+{3,4}";
        String res=parser.calcExpression(expression).toString();
        String control="{4.00,6.00}";
        assertEquals(res, control);
    }

    @Test
    public void calcVarVSubVarV() throws Exception {
        Parser parser=new Parser(null,null,null,null);
        String expression="{10,20}-{5.5,26}";
        String res=parser.calcExpression(expression).toString();
        String control="{4.50,-6.00}";
        assertEquals(res, control);
    }

    @Test
    public void calcVarVMulVarV() throws Exception {
        Parser parser=new Parser(null,null,null,null);
        String expression="{3.5,4}*{2,2.5}";
        String res=parser.calcExpression(expression).toString();
        String control="17.00";
        assertEquals(res, control);
    }

    @Test
    public void calcVarVDivVarF() throws Exception {
        Parser parser=new Parser(null,null,null,null);
        String expression="{7,4}/2";
        String res=parser.calcExpression(expression).toString();
        String control="{3.50,2.00}";
        assertEquals(res, control);
    }

    @Test
    public void calcVarFAddVarV() throws Exception {
        Parser parser=new Parser(null,null,null,null);
        String expression="2.5+{3,4}";
        String res=parser.calcExpression(expression).toString();
        String control="{5.50,6.50}";
        assertEquals(res, control);
    }

    @Test
    public void calcVarVSubVarF() throws Exception {
        Parser parser=new Parser(null,null,null,null);
        String expression="{5.5,26}-0.5";
        String res=parser.calcExpression(expression).toString();
        String control="{5.00,25.50}";
        assertEquals(res, control);
    }

    @Test
    public void calcVarFMulVarV() throws Exception {
        Parser parser=new Parser(null,null,null,null);
        String expression="2.0*{2,2.5}";
        String res=parser.calcExpression(expression).toString();
        String control="{4.00,5.00}";
        assertEquals(res, control);
    }

    @Test
    public void calcVarMAddVarF() throws Exception {
        Parser parser=new Parser(null,null,null,null);
        String expression="{{2,4},{5.5,8}}+2.5";
        String res=parser.calcExpression(expression).toString();
        String control="{{4.50,6.50},{8.00,10.50}}";
        assertEquals(res, control);
    }

    @Test
    public void calcVarMSubVarF() throws Exception {
        Parser parser=new Parser(null,null,null,null);
        String expression="{{2,4},{5,8.2}}-2";
        String res=parser.calcExpression(expression).toString();
        String control="{{0.00,2.00},{3.00,6.20}}";
        assertEquals(res, control);
    }

    @Test
    public void calcVarMMulVarF() throws Exception {
        Parser parser=new Parser(null,null,null,null);
        String expression="{{1,8},{2,4}}*3";
        String res=parser.calcExpression(expression).toString();
        String control="{{3.00,24.00},{6.00,12.00}}";
        assertEquals(res, control);
    }

    @Test
    public void calcVarMDivVarF() throws Exception {
        Parser parser=new Parser(null,null,null,null);
        String expression="{{2,6},{1,10}}/2";
        String res=parser.calcExpression(expression).toString();
        String control="{{1.00,3.00},{0.50,5.00}}";
        assertEquals(res, control);
    }

    @Test
    public void calcVarMAddVarM() throws Exception {
        Parser parser=new Parser(null,null,null,null);
        String expression="{{2,4},{5.5,8}}+{{2.5,3},{2,1.5}}";
        String res=parser.calcExpression(expression).toString();
        String control="{{4.50,7.00},{7.50,9.50}}";
        assertEquals(res, control);
    }

    @Test
    public void calcVarMSubVarM() throws Exception {
        Parser parser=new Parser(null,null,null,null);
        String expression="{{2,4,5},{5.5,8,4}}-{{2.9,3,8},{9,0.5,8}}";
        String res=parser.calcExpression(expression).toString();
        String control="{{-0.90,1.00,-3.00},{-3.50,7.50,-4.00}}";
        assertEquals(res, control);
    }

    @Test
    public void calcVarMMulVarM() throws Exception {
        Parser parser=new Parser(null,null,null,null);
        String expression="{{2,4,5},{5.5,8,4}}*{{2.5,3},{2,1.5},{5,1.1}}";
        String res=parser.calcExpression(expression).toString();
        String control="{{38.00,17.50},{49.75,32.90}}";
        assertEquals(res, control);
    }


    @Test
    public void testVarF() throws Exception {
        String expression="17.5";
        Var var=new VarF(expression);
        String control="17.50";
        assertEquals(var.toString(), control);
    }

    @Test
    public void testVarV() throws Exception {
        String expression="{4,7,9.1}";
        Var var=new VarV(expression);
        String control="{4.00,7.00,9.10}";
        assertEquals(var.toString(), control);
    }

    @Test
    public void testVarM() throws Exception {
        String expression="{{5,1.2,12},{0.5,5,99}}";
        Var var=new VarM(expression);
        String control="{{5.00,1.20,12.00},{0.50,5.00,99.00}}";
        assertEquals(var.toString(), control);
    }

}