package by.it.psmishenko.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

/**
 * Created by user on 05.05.2017.
 */
public class CmdLogin extends Action {
    @Override
    public Action execute(HttpServletRequest request) {

        try {
            String test = Form.getString(request,"login",Pattern.LOGIN);
            request.setAttribute(Messages.MSG_MESSAGE,"test="+test);
        } catch (ParseException e) {
            request.setAttribute(Messages.MSG_ERROR,"error");
        }
        return null;
    }
}
