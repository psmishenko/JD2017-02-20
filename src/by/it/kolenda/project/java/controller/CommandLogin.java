package by.it.kolenda.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

public class CommandLogin extends Action {

    @Override
    public Action execute(HttpServletRequest request){
        try {
            String test=Form.getString(request,"login",Pattern.LOGIN);
            request.setAttribute(Messages.MSG_MESSAGE,"test="+test);
        } catch (ParseException e) {
            request.setAttribute(Messages.MSG_ERROR,"error");
        }
        return null;
    }
}
