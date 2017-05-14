package by.it.tereshko.project.java.controller;

import javax.servlet.http.HttpServletRequest;

enum Actions {

    INDEX {
        {
            this.command = new CmdIndex();
        }
    },

    EDITUSERS {
        {
            this.command = new CmdEditUsers();
        }
    },

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

    CREATEAD {
        {
            this.command = new CmdCreateAd();
        }
    },

    ERROR {
        {
            this.command = new CmdError();
        }
    };

    public Action command;

    static Action defineFrom(HttpServletRequest request) {
        String command = request.getParameter("command");
        if (command == null) {
            command = "index";
        }
        Action res;
        try {
            res = Actions.valueOf(command.toUpperCase()).command;
        } catch (IllegalArgumentException e) {
            res = Actions.ERROR.command;
        }
        return res;
    }

}