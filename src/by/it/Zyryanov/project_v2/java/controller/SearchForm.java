package by.it.Zyryanov.project_v2.java.controller;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

/**
 * Created by georgijzyranov on 09.05.17.
 */
public class SearchForm { static String getString(HttpServletRequest request, String parameter) throws ParseException {
    String value=request.getParameter(parameter);
    if (value!=null) {
        return value;
    }
    else {
        throw new ParseException("Incorrect String:"+parameter,-1);
    }
}
}
