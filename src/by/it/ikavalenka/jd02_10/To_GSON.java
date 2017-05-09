package by.it.ikavalenka.jd02_10;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by USER on 25.04.2017.
 */
public class To_GSON {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        Administrator adm = new Administrator("zAds36","CatalogAll",12,"none","Order#1",123,"Normal",123,"Single","NONE");


        String json = gson.toJson(adm);
        System.out.println(json);

        Administrator adminTestPresent = gson.fromJson(json,Administrator.class);
        System.out.println(adminTestPresent.toString());


    }
}
