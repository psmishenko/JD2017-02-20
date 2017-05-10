package by.it.zeynalov.project.java.Controller;

import javax.servlet.http.HttpServletRequest;

public abstract class Action {

    abstract Action execute(HttpServletRequest request);

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
