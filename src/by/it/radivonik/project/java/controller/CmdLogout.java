package by.it.radivonik.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Radivonik on 05.05.2017.
 */
public class CmdLogout extends AbstractAction {
    @Override
    public AbstractAction execute(HttpServletRequest req) {
        HttpSession session = req.getSession();
        session.removeAttribute("userActive");
        session.invalidate();
        return Actions.INDEX.command;
    }
}