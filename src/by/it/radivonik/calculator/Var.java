package by.it.radivonik.calculator;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Radivonik on 13.03.2017.
 */
public class Var implements IVariable {
    public static Map<String,Var> vars = new HashMap<>();

    @Override
    public void fromString(String str) {

    }

    @Override
    public String toString() {
        return super.toString();
    }
}
