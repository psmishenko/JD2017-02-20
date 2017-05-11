package by.it.Zyryanov.project_v2.java.controller;

import javax.servlet.http.HttpServletRequest;

enum Actions {
    SIGNUP {
        {
            this.command = new CmdSignup();
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
    ERROR {
        {
            this.command = new CmdError();
        }
    },
    SEARCH {
        {
            this.command = new CmdSearch();
        }
    };

    public Action command;

    static Action defineFrom(HttpServletRequest request) {
        String command = request.getParameter("command");
        Action res;
        try {
            res = Actions.valueOf(command.toUpperCase()).command;
        } catch (IllegalArgumentException e) {
            res = Actions.ERROR.command;
        }
        return res;
    }

}



