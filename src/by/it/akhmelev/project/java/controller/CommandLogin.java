package by.it.akhmelev.project.java.controller;

import javax.servlet.http.HttpServletRequest;

public class CommandLogin implements ActionCommand{
    @Override
    public String execute(HttpServletRequest request) {
        return "/login.jsp";
    }
}
