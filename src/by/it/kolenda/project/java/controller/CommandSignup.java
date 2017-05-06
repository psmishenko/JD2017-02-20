package by.it.kolenda.project.java.controller;

import javax.servlet.http.HttpServletRequest;


public class CommandSignup implements ActionComand{

    @Override
    public String execute(HttpServletRequest request) {
        return "/index.jsp";
    }
}

