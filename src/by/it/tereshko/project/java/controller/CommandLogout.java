package by.it.tereshko.project.java.controller;

import com.sun.deploy.net.HttpRequest;

public class CommandLogout implements ActionCommand {

    @Override
    public String execute(HttpRequest request) {
        return "/logout.jsp";
    }

}
