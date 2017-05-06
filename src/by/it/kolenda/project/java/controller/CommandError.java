package by.it.kolenda.project.java.controller;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by user on 05.05.2017.
 */
public class CommandError extends Action {
    @Override
    public String execute(HttpServletRequest request) {
        return "/index.jsp";
    }
}
