package by.it.prigozhanov.project.java.controller;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by v-omf on 5/11/2017.
 *
 * @author v-omf
 */
public class CommandHome extends Action {
    @Override
    Action execute(HttpServletRequest request) {
        if (request.getParameter("findcars") !=null) {
            return Actions.CARS.command;
        } else return Actions.HOME.command;

    }
}
