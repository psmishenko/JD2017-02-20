package by.it.psmishenko.project.java.controller;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by user on 05.05.2017.
 */
public class CommandLogin implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        return "/login.jsp";
    }
}
