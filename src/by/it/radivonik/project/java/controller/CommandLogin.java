package by.it.radivonik.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

/**
 * Created by Radivonik on 05.05.2017.
 */
public class CommandLogin extends Action {
    @Override
    public Action execute(HttpServletRequest req) {
        try {
            String test = Form.getString(req, "login", Pattern.LOGIN);
            req.setAttribute(Messages.MSG_MESSAGE,"test="+test);
        }
        catch (ParseException e) {
            req.setAttribute(Messages.MSG_ERROR,"error");
        }
        return null;
    }
}
