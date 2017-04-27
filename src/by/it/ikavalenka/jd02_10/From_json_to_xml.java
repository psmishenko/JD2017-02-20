package by.it.ikavalenka.jd02_10;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by USER on 25.04.2017.
 */
public class From_json_to_xml {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        InternetShop internetShop = new InternetShop()
        {
            {
                Administrator adm = new Administrator("zAds36", "CatalogAll", 12, "none", "Order#1", 123, "Normal", 123, "Single", "NONE");
//                this.add(adm);
            }
        };

        String json = gson.toJson(internetShop);
    }
}

