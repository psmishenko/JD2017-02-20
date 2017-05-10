package by.it.radivonik.project.java.controller;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Radivonik on 05.05.2017.
 */
public enum Actions {
    SIGNUP {
        {
            this.command = new CmdSignUp();
        }
    },
    LOGIN {
        {
            this.command = new CmdLogin();
        }
    },
    PROFILE {
        {
            this.command = new CmdProfile();
        }
    },
    LOGOUT {
        {
            this.command = new CmdLogout();
        }
    },
    ERROR {
        {
            this.command = new CmdError();

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
