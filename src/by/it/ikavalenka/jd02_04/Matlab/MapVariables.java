package by.it.ikavalenka.jd02_04.Matlab;

import java.util.Map;
import java.util.TreeMap;


public class MapVariables {

    private static Map<String, Var> map = new TreeMap<>();

    public static Map<String, Var> getMap() {
        return map;
    }

    public static void addVariable (String var, Var value){
        map.put(var, value);
    }
}
