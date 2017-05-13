package by.it.psmishenko.project.java.controller;

import javax.servlet.http.HttpServletRequest;


enum  Actions {
    INDEX {
        {
            this.command = new CmdIndex();
        }
    },
    HOME {
        {
            this.command = new CmdHome();
        }
    },
    EDITUSERS {
        {
            this.command = new CmdEditusers();
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
        if(command==null){
            command = "index";
        }
        Action res;
        try {
            res = Actions.valueOf(command.toUpperCase()).command;
        }catch (IllegalArgumentException e){
            res = Actions.ERROR.command;
        }
       return  res;
    }
}
