package by.it.radivonik.calculator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Radivonik on 09.04.2017.
 */
public class VarTest {
    @Test
    public void createVarA1() throws Exception {
        String res = Var.createVar("5.3").toString();
        assertEquals(res, "5.3");
    }

    @Test
    public void createVarA2() throws Exception {
        String res = Var.createVar("A").toString();
        assertEquals(res, "7.3");
    }

    @Test
    public void createVarA3() throws Exception {
        String res = Var.createVar("B").toString();
        assertEquals(res, "25.55");
    }

    @Test
    public void createVarA4() throws Exception {
        String res = Var.createVar("B1").toString();
        assertEquals(res, "25.0");
    }

    @Test
    public void createVarA5() throws Exception {
        String res = Var.createVar("B2").toString();
        assertEquals(res, "2.65");
    }

    @Test
    public void createVarB1() throws Exception {
        String res = Var.createVar("C").toString();
        assertEquals(res, "40.15");
    }

    @Test
    public void createVarB2() throws Exception {
        String res = Var.createVar("D").toString();
        assertEquals(res, "10.0");
    }

    @Test
    public void createVarB3() throws Exception {
        String res = Var.createVar("E").toString();
        assertEquals(res, "{10.0,15.0}");
    }

    @Test
    public void createVarC1() throws Exception {
        String res = Var.createVar("M").toString();
        assertEquals(res, "{{4.0,8.0,12.0,16.0},{-4.4,-8.8,-13.2,-13.6}}");
    }
}