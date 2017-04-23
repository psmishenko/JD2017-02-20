package by.it.radivonik.jd02_09;

/**
 * Created by Radivonik on 19.04.2017.
 */
public class Runner {
    public static void main(String[] args) {
        String filexml = System.getProperty("user.dir") + "/src/by/it/radivonik/jd02_09/naklads.xml";

        System.out.println("Вариант A (XML+XSL->HTML)");
        new TaskA().run(filexml);

        System.out.println("\nВариант B (Демарашализация/Марашализация созданных вручную классов Java beans)");
        new TaskBC().run(by.it.radivonik.jd02_09.beans.manual.Naklads.class, filexml);

        System.out.println("\nВариант C (Демарашализация/Марашализация автоматически сгенерированных классов Java beans)");
        new TaskBC().run(by.it.radivonik.jd02_09.beans.Naklads.class, filexml);
    }
}
