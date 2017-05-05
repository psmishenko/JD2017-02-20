package by.it.radivonik.project.java.controller;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Radivonik on 05.05.2017.
 */
public class CommandError implements ActionCommand {
    @Override
    public String execute(HttpServletRequest req) {
        return "/error.jsp";
    }
}
