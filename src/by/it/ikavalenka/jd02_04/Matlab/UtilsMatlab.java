package by.it.ikavalenka.jd02_04.Matlab;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;


public class UtilsMatlab {

    public static String[] convertLineToArray (String s, String regex)throws ArrayIndexOutOfBoundsException,NullPointerException{

        Pattern pat = Pattern.compile(regex);
        String[] array = pat.split(s);

        for (int i = 0; i < array.length; i++) {
            array[i] = array[i].trim();
        }
        return array;
    }



    public static void saveVarsInFile ( File file){

        Map<String, Var> map = MapVariables.getMap();
        try (PrintWriter print = new PrintWriter(new FileWriter(file,true))){
            for (Map.Entry<String, Var> entry : map.entrySet()) {
                print.println(entry.getKey()+" = "+entry.getValue());
            }
        }
        catch (IOException e){
            System.out.println("Writing to file "+file+" failed.");
        }
    }


    public static Map <String, Var> putVarsFromFileIntoMap(){

        Map<String,Var> map = MapVariables.getMap();
        String src = System.getProperty("user.dir") + "/src/by/it/ikavalenka/jd02_04/Matlab/vars.txt";
        File file = new File(src);
        try(BufferedReader r = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = r.readLine())!=null){
                String[] array = UtilsMatlab.convertLineToArray(line, "=");
                String a = array[0].trim();
                Var b = DefineVariable.defineVar(array[1]);
                map.put(a, b);
            }
        }
        catch (IOException e){
            System.out.println(file+" file not read.");
        }
        return map;
    }



    public static void print (Var var) {

        if (var!=null) System.out.println(" = " + var+var.getType());
    }



    public static void printVarList (String line, Map <String, Var> map) throws IOException {

        if (!line.isEmpty()) {
            if ("printvar".equals(line)) UtilsMatlab.ifPrintvar(map);
            else{
                if ("sortvar".equals(line)) UtilsMatlab.ifSortvar(map);
                else {
                    System.out.println("Missed values");
                    printVarList(enterLine(), map);
                }
            }
        }
    }


    public static void ifSortvar(Map<String, Var> map) throws IOException {

        if (!map.isEmpty()) {
            for (String s : map.keySet()) {
                System.out.println(s);
            }
        } else System.out.println("The lis is empty.");
    }


    public static void ifPrintvar(Map<String, Var> map) {

        if (!map.isEmpty()) {
            for (Map.Entry<String, Var> entry : map.entrySet()) {
                System.out.println(entry.getKey()+" = "+entry.getValue());
            }
        } else System.out.println("The lis is empty.");

    }


    public static String enterLine() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }



    public static Var calculateWith2Operands (String s, String[] array) throws ErrorException, ArrayIndexOutOfBoundsException,NullPointerException {

        Var a = DefineVariable.defineVar(array[0]);
        Var b = DefineVariable.defineVar(array[1]);
        return Counting.count(a, b, s);
    }



}
