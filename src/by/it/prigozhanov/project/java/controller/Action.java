package by.it.prigozhanov.project.java.controller;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by v-omf on 5/6/2017!
 */
public abstract class Action {

    abstract Action execute(HttpServletRequest request);

    @Override
    public String toString() {
        String name=this.getClass().getSimpleName();
        name=name.replace("Command","");
        return name;
    }

    public String getJsp() {
        return "/"+this.toString().toLowerCase() + ".jsp";
    }

}
