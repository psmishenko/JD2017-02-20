package by.it.radivonik.project.java.controller;

import com.sun.deploy.net.HttpRequest;

/**
 * Created by Radivonik on 05.05.2017.
 */
public class CommandSignup implements ActionCommand {
    @Override
    public String execute(HttpRequest req) {
        return "/signup.jsp";
    }
}
