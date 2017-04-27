package by.it.radivonik.jd02_10;

import by.it.radivonik.jd02_10.beans.Naklads;

/**
 * Created by Radivonik on 19.04.2017.
 */
public class Runner {
    public static void main(String[] args) {
        String filexml = System.getProperty("user.dir") + "/src/by/it/radivonik/jd02_10/naklads.xml";
        String filejson = System.getProperty("user.dir") + "/src/by/it/radivonik/jd02_10/naklads.json";

        System.out.println("Вариант A (POJO<->JSON)");
        new TaskA().run(Naklads.class, filejson);

        System.out.println("\nВариант B (XML<->JSON)");
        new TaskB().run(Naklads.class, filexml);

        System.out.println("\nВариант C (Converter<T>)");
        new TaskC().run(filexml, filejson);
    }
}

