package by.it.psmishenko.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;


public class Form {
    static String getString(HttpServletRequest request, String param,String pattern) throws ParseException {
        String value = request.getParameter(param);
        if((value!=null)&&value.matches(pattern)){
            return value;
        }else {
            throw new ParseException("Incorrect String:"+param,-1);
        }
    }
    static  boolean isPost(HttpServletRequest request){
        return request.getMethod().toUpperCase().equals("POST");
    }
    static int getInt(HttpServletRequest request, String parameter) throws ParseException {
        String value=request.getParameter(parameter);
        return Integer.parseInt(value);
    }

}
