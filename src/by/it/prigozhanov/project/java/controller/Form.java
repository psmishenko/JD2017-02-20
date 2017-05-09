package by.it.prigozhanov.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

/**
 * Created by v-omf on 5/6/2017!
 */
public class Form {
    static String getString(HttpServletRequest request,String parameter, String pattern) throws ParseException {
        String value=request.getParameter(parameter);
        if ((value!=null) && value.matches(parameter)) {
            return value;
        } else {
            throw new ParseException("Incorrect String:" + parameter, 1);
        }

    }


}
