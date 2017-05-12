package by.it.prigozhanov.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

/**
 * Created by v-omf on 5/6/2017!
 */
public class Form {
    static String getString(HttpServletRequest request,String parameter, String pattern) throws ParseException {
        String value=request.getParameter(parameter);
        if ((value!=null) && value.matches(pattern)) {
            return value;
        } else {
            throw new ParseException("Incorrect String:" + parameter, 1);
        }

    }

    static int getInt(HttpServletRequest request, String parameter) throws ParseException {
        String value=request.getParameter(parameter);
        return Integer.parseInt(value);
    }

    static double getDouble(HttpServletRequest request, String parameter) throws ParseException {
        String value=request.getParameter(parameter);
        return Double.parseDouble(value);
    }

    static boolean isPost(HttpServletRequest request) {
        return request.getMethod().toUpperCase().equals("POST");
    }


}
