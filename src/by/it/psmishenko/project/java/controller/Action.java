package by.it.psmishenko.project.java.controller;

import javax.servlet.http.HttpServletRequest;


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
