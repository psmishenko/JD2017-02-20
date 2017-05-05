package by.it.tereshko.project.java.controller;

import com.sun.deploy.net.HttpRequest;

interface ActionCommand {

    String execute(HttpRequest request);

}
