package by.it.radivonik.project.java.controller;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Radivonik on 05.05.2017.
 */
public enum Actions {
    SIGNUP {
        {
            this.command = new CommandSignUp();
        }
    },
    LOGIN {
        {
            this.command = new CommandLogin();
        }
    },
    LOGOUT {
        {
            this.command = new CommandLogout();
        }
    },
    ERROR {
        {
            this.command = new CommandError();

        }
    };

    public Action command;

    static Action defineFrom(HttpServletRequest req) {
        String command = req.getParameter("command").toUpperCase();
        Action res;

        try {
            res = Actions.valueOf(command).command;
        }
        catch (IllegalArgumentException e) {
            res = Actions.ERROR.command;
        }
        return res;
    }
}
