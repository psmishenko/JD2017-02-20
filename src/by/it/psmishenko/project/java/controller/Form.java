package by.it.psmishenko.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

/**
 * Created by GN on 06.05.2017.
 */
public class Form {
    static String getString(HttpServletRequest request, String param,String pattern) throws ParseException {
        String value = request.getParameter(param);
        if((value!=null)&&value.matches(pattern)){
            return value;
        }else {
            throw new ParseException("Incorrect String:"+param,-1);
        }
    }
    // getInt
}
