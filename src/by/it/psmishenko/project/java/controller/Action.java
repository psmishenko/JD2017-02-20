package by.it.psmishenko.project.java.controller;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by GN on 06.05.2017.
 */
 abstract class Action {
    abstract Action execute(HttpServletRequest request);

    @Override
    public String toString() {
        String name = this.getClass().getSimpleName();
        name = name.replace("Cmd","");
        return name;
    }
    public  String getJSP(){
        return "/"+this.toString().toLowerCase()+".jsp";
    }
}
