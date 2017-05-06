package by.it.kolenda.project.java.controller;

import java.text.ParseException;

public class Form {

    static String getString(HTTPServletRequest request, String parameter, String pattern);
    String value=request.getParameter(paremeter);
    if ((value !==null) && value.matches(pattern)){
        return value}
        else

    {
        throw new ParseException("Incorrect String:" + parameter, -1);
    }



}
