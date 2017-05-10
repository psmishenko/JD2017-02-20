package by.it.psmishenko.project.java.controller;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by user on 05.05.2017.
 */
enum  Actions {
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
    ALLBOOKS {
        {
            this.command = new CmdAllbooks();
        }
    },
    ADDBOOK {
        {
            this.command = new CmdAddbook();
        }
    },
    ABOUTUS {
        {
            this.command = new CmdAboutus();
        }
    },
    ERROR {
        {
            this.command = new CmdError();
        }
    };

    public Action command;
    static  Action defineFrom(HttpServletRequest request){
        String command = request.getParameter("command");
        Action res;
        try {
            res = Actions.valueOf(command.toUpperCase()).command;
        }catch (IllegalArgumentException e){
            res = Actions.ERROR.command;
        }
       return  res;
    }
}
