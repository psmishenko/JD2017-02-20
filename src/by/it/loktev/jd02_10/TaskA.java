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

        Circle c1=new Circle();
        c1.setCenterx(200);
        c1.setCentery(250);
        c1.setRadius(110);
        c1.setFill("white");
        c1.setStroke("black");

        p.squareOrCircleOrText.add(s1);
        p.squareOrCircleOrText.add(c1);

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


