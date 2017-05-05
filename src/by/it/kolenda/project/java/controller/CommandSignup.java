package by.it.kolenda.project.java.controller;

import com.sun.deploy.net.HttpRequest;

/**
 * Created by user on 05.05.2017.
 */
public class CommandSignup implements ActionComand{

    @Override
    public String execute(HttpRequest request) {
        return "/index.jsp";
    }
}

