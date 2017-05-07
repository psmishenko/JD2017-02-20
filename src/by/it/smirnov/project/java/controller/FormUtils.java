package by.it.smirnov.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

/**
 * Created by aleksey.smirnov on 06.05.2017.
 */
public class FormUtils {

    static String getString(HttpServletRequest request, String parameter, String pattern) throws ParseException {
        String value=request.getParameter(parameter);
        if ((value!=null) && ((pattern.length() == 0) || (value.matches(pattern)))){
            return value;
        }
        else {
            throw new ParseException("Incorrect String:"+parameter,-1);
        }
    }
}
