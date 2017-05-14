package by.it.korzun.project.java.controller;

import javax.servlet.http.HttpServletRequest;

enum Actions {
    INDEX{
        {
            this.command = new CmdIndex();
        }
    },
    SIGNUP{
        {
            this.command = new CmdSignUp();
        }
    },
    LOGIN{
        {
            this.command = new CmdLogin();
        }
    },
    PROFILE{
        {
            this.command = new CmdProfile();
        }
    },
    CREATEBRIGADE{
        {
            this.command = new CmdCreateBrigade();
        }
    },
    UPDATEBRIGADE{
        {
            this.command = new CmdUpdateBrigade();
        }
    },
    REMOVEBRIGADE{
        {
            this.command = new CmdRemoveBrigade();
        }
    },
    CREATEFLIGHT{
        {
            this.command = new CmdCreateFlight();
        }
    },
    UPDATEFLIGHT{
        {
            this.command = new CmdUpdateFlight();
        }
    },
    REMOVEFLIGHT{
        {
            this.command = new CmdRemoveFlight();
        }
    },
    STAFF{
        {
            this.command = new CmdStaff();
        }
    },
    DISPATCHER{
        {
            this.command = new CmdDispatcher();
        }
    },
    ADMIN{
        {
            this.command = new CmdAdmin();
        }
    },
    ERROR{
        {
            this.command = new CmdError();
        }
    };

    public Action command;
    static Action defineFrom(HttpServletRequest request){
        String command = request.getParameter("command");
        if(command == null){
            command = "index";
        }
        Action res;
        try {
            res = Actions.valueOf(command.toUpperCase()).command;
        }catch (IllegalArgumentException e){
            res = Actions.ERROR.command;
        }
        return res;
    }
}
