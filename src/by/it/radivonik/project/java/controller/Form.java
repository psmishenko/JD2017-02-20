package by.it.radivonik.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

/**
 * Created by Radivonik on 06.05.2017.
 */
public class Form {
    static String getString(HttpServletRequest req, String param, String pattern) throws ParseException  {
        String value = req.getParameter(param);
        if (value != null && value.matches(pattern))
            return value;
        else
            throw new ParseException("Incorrect string: " + param, 1);
    }
}
