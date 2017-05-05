package by.it.tereshko.project.java.controller;

import com.sun.deploy.net.HttpRequest;

public class CommandSignup implements ActionCommand {

    @Override
    public String execute(HttpRequest request) {
        return "/signup.jsp";
    }

}
