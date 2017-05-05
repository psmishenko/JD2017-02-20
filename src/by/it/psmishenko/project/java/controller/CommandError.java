package by.it.psmishenko.project.java.controller;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by user on 05.05.2017.
 */
 class CommandError implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        return "/error.jsp";
    }
}
