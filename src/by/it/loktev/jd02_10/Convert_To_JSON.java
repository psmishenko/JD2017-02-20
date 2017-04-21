package by.it.loktev.jd02_10;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Convert_To_JSON<T> implements Convert_To<T> {

    public String run(T obj, Class cls){
        Gson gson=new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        return gson.toJson(obj);
    }

}
