package by.it.smirnov.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by aleksey.smirnov on 06.05.2017.
 */
public abstract class Action {
    abstract Action execute(HttpServletRequest request, HttpServletResponse response);
    @Override
    public String toString() {
        String name = this.getClass().getSimpleName();
        name = name.replace("Command","");
        return name;
    }

    public String getJsp(){
        return "/"+this.toString().toLowerCase()+".jsp";
    }
}
