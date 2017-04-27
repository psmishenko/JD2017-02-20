package by.it.loktev.jd02_10;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TaskA {

    public static void run() {

        Picture p=new Picture();

        Square s1=new Square();
        s1.setLeft(100);
        s1.setTop(50);
        s1.setWidth(80);
        s1.setHeight(30);
        s1.setFill("yellow");
        s1.setStroke("blue");

        p.addSquare(s1);

        Square s2=new Square();
        s2.setLeft(101);
        s2.setTop(51);
        s2.setWidth(81);
        s2.setHeight(31);
        s2.setFill("cyan");
        s2.setStroke("black");

        p.addSquare(s2);

        System.out.println("=== тестовый POJO-объект:");
        System.out.println(p.toString());

        Gson gson=new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        String pictureJSON=gson.toJson(p);
        System.out.println("=== JSON-представление:");
        System.out.println(pictureJSON);

        Picture p2=gson.fromJson(pictureJSON, Picture.class);
        System.out.println("=== восстановленный из JSON POJO-объект:");
        System.out.println(p2.toString());

    }
}


