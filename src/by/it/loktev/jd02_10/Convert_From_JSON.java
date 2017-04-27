package by.it.loktev.jd02_10;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Convert_From_JSON<T> implements Convert_From<T> {

    public T run(String s, Class cls){
        Gson gson=new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        return (T)gson.fromJson(s, cls);
    }

}
