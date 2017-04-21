package by.it.smirnov.jd02_10.task_c.Converter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Класс вспомогательных функций JSON
 */
public class JSONHelper {
    private static Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();

    public static Object fromJSON(Class beanClass, String txtData) {
        return gson.fromJson(txtData, beanClass);
    }

    public static String toJSON(Object bean) {
        return gson.toJson(bean);
    }

}
