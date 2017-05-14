package by.it.radivonik.project.java.controller;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Radivonik on 06.05.2017.
 */
public abstract class AbstractAction {
    abstract AbstractAction execute(HttpServletRequest req);

    @Override
    public String toString() {
        String name = this.getClass().getSimpleName();
        name = name.replace("Cmd","");
        return name;
    }

    public String getJsp() {
        return "/" + this.toString().toLowerCase() + ".jsp";
    }
}
