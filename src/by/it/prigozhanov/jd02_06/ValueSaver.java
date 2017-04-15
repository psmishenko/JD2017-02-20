package by.it.prigozhanov.jd02_06;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by v-omf on 3/28/2017.
 *
 * @author v-omf
 */
public class ValueSaver {
    static String root = System.getProperty("user.dir");
    static String path = root + "/src/by/it/prigozhanov/jd02_06/";
    static String fileName = path + "Vars.txt";
    static Map<String, Var> loadedMap = new HashMap<>();


    private ValueSaver() {
    }

    static void loadToFile(Map<String, Var> map) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))) {
            Iterator<Map.Entry<String, Var>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                pw.printf("%s=%s\n", pair.getKey(), pair.getValue().toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void uploadFromFile() {
        StringBuilder sb = new StringBuilder();
       try (FileReader fr = new FileReader(fileName)){

           while (fr.ready()) {
               sb.append((char)fr.read());
           }
           Pattern p1 = Pattern.compile(Expressions.VARIABLE);
           Pattern p2 = Pattern.compile(Expressions.ANY);
           String[] part = sb.toString().split("\n");
           for (int i = 0; i < part.length; i++) {
               Matcher m1 = p1.matcher(part[i]);
               Matcher m2 = p2.matcher(part[i]);
               if (m1.find()) {
                   if (m2.find()) {
                       loadedMap.put(m1.group(), VarFactory.createVar(m2.group()));
                   }
               }
           }

       } catch (FileNotFoundException e) {
           System.out.println("Файл не найден");
           Logger.getLogger().logError(e, false);
       } catch (IOException e) {
           System.out.println("Ошибка ввода вывода");
           Logger.getLogger().logError(e, false);
       }
    }


}
