package by.it.loktev.jd02_10;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TaskA {

    public static void run() {

        Square square=new Square();
        square.setLeft(100);
        square.setTop(50);
        square.setWidth(80);
        square.setHeight(30);
        square.setFill("yellow");
        square.setStroke("blue");
        System.out.println("=== тестовый POJO-объект:");
        System.out.println(square.toString());

        /*
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        //маршаллизация
        String json = gson.toJson(dev);
        System.out.print(json);
        //демаршаллизация
        Dev dev2=gson.fromJson(json, Dev.class);
        System.out.print("\n\ndev2=" + dev2.toString());
        */
    }
}


