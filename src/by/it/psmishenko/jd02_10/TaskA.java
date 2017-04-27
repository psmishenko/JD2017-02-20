package by.it.psmishenko.jd02_10;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.math.BigInteger;

/**
 * Created by GN on 22.04.2017.
 */
public class TaskA {
   static void runTaskA(){
        Readers readers = new Readers();
        Reader r1 = new Reader();
        Reader r2 = new Reader();

        r1.setName("Vasya"); r2.setName("Petya");
        r1.setAge(BigInteger.valueOf(11)); r2.setAge(BigInteger.valueOf(99));
        r1.setID(BigInteger.valueOf(19291919));r2.setID(BigInteger.valueOf(1111111));
        readers.getReader();
        readers.reader.add(r1); readers.reader.add(r2);
        System.out.println("---POJO---\n"+readers);

        Gson gson=new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        String taskAJSON = gson.toJson(readers);
        System.out.println("---toJSON--- \n"+taskAJSON);
        Readers readers1 = gson.fromJson(taskAJSON,Readers.class);
        System.out.println("---fromJSON--- \n"+readers1);
    }
}
