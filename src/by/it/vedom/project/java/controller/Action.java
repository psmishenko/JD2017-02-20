package by.it.vedom.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public abstract class Action {

    abstract Action execute(HttpServletRequest request) throws SQLException;

    @Override
    public String toString() {
        String name = this.getClass().getSimpleName();
        name = name.replace("Cmd", "");
        return name;
    }

    public String getJsp() {
        return "/" + this.toString().toLowerCase() + ".jsp";
    }

}
