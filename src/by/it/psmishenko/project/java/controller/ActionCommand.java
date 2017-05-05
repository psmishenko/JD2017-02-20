package by.it.psmishenko.project.java.controller;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by user on 05.05.2017.
 */
 interface ActionCommand {
    String execute(HttpServletRequest request);
}
