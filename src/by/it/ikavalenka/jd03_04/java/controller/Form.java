package by.it.ikavalenka.jd03_04.java.controller;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

/**
 * Created by USER on 06.05.2017.
 */
public class Form {
    static String getString(HttpServletRequest request,String paremeter, String pattern) throws Exception {
        String value = request.getParameter(paremeter);
        if ((value != null) && value.matches(pattern)){
            return  value;
        }
        else{
            throw  new ParseException("Error string" +paremeter,-1);
        }

    }


}
