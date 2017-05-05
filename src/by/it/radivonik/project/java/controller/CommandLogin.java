package by.it.radivonik.project.java.controller;

import com.sun.deploy.net.HttpRequest;

/**
 * Created by Radivonik on 05.05.2017.
 */
public class CommandLogin implements ActionCommand {
    @Override
    public String execute(HttpRequest req) {
        return "/login.jsp";
    }
}
