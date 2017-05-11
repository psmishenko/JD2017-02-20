package by.it.vedom.project.java.controller;

import javax.servlet.http.HttpServletRequest;

enum Actions {
    SIGNUP {
        {
            this.command=new CmdSignUp();
        }
    },
    LOGIN {
        {
            this.command=new CmdLogin();
        }
    },
    PROFILE {
        {
            this.command=new CmdProfile();
        }
    },
    SEARCH {
        {
            this.command = new CmdSearch();
        }
    },
    ADDPROD {
        {
            this.command=new CmdAddProd();
        }
    },
    ERROR {
        {
            this.command=new CmdError();
        }
    };

    public Action command;

    static Action defineFrom(HttpServletRequest request){
        String command=request.getParameter("command");
        Action res;
        try {
            res=Actions.valueOf(command.toUpperCase()).command;
        }
        catch (IllegalArgumentException e) {
            res=Actions.ERROR.command;
        }
        return res;
    }
}