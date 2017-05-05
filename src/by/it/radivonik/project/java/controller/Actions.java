package by.it.radivonik.project.java.controller;

import sun.rmi.log.LogInputStream;

/**
 * Created by Radivonik on 05.05.2017.
 */
public enum Actions {
    SIGNUP {
        {
            this.command = new CommandSignup();
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

    public String jsp = "/error.jsp";
    private ActionCommand command;
    public ActionCommand getCurrentCommand() {
        return command;
    }
}
