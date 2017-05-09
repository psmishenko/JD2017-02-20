package by.it.korzun.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

public class CmdLogin extends Action{


    @Override
    public Action execute(HttpServletRequest request) {
        try {
            String test = Form.getString(request, "login", Pattern.LOGIN);
            request.setAttribute(Messages.MSG_MESSAGE, "test = " + test);
        } catch (ParseException e) {
            request.setAttribute(Messages.MSG_ERROR, "test = error");
        }
        return null;
    }
}
