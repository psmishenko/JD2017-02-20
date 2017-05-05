package by.it.kolenda.project.java.controller;

import com.sun.deploy.net.HttpRequest;


public class CommandLogout implements ActionComand{

    @Override
    public String execute(HttpRequest request) {
        return "/index.jsp";
    }
}
