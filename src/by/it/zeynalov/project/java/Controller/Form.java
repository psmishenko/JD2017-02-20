package by.it.zeynalov.project.java.Controller;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

public class Form {

    static String getString(HttpServletRequest request, String parameter, String pattern) throws ParseException {
        String value = request.getParameter(parameter); //парсим String, возможно будет int  и т.д.
        if ((value != null) && value.matches(pattern)) {
            return value;
        } else {
            throw new ParseException("Incorrect String" + parameter, -1);
        }
    }

    static boolean isPost(HttpServletRequest request) {
        return request.getMethod().toUpperCase().equals("POST");
    }

}
