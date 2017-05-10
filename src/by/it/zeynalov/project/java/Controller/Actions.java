package by.it.zeynalov.project.java.Controller;

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
    PROFILE{
        {
            this.command = new CmdProfile();
        }
    },
    ERROR {
        {
            this.command = new CmdError();
        }
    };

    public Action command;

    static Action defineForm(HttpServletRequest request) {
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
