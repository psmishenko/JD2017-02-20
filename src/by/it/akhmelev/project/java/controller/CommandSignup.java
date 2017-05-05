package by.it.akhmelev.project.java.controller;

import javax.servlet.http.HttpServletRequest;

public class CommandSignup implements ActionCommand{
    @Override
    public String execute(HttpServletRequest request) {
        return "/signup.jsp";
    }
}
