package by.it.prigozhanov.matlab3;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by v-omf on 3/28/2017.
 *
 * @author v-omf
 */
public class Util {
    static String root = System.getProperty("user.dir");
    static String path = root + "/src/by/it/prigozhanov/matlab3/";
    static String fileNameOut = path + "Vars.txt";


    static void upload(Map<String, Var> map) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(fileNameOut))) {
            Iterator<Map.Entry<String, Var>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                pw.printf("%s=%s\n", pair.getKey(), pair.getValue().toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void load() {
       try (FileReader fr = new FileReader(fileNameOut)){
           while (fr.ready()) {
               fr.read();
           }
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }
    }
}
