package by.it.radivonik.project.java.controller;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Radivonik on 05.05.2017.
 */
public enum Actions {
    ERROR {
        { this.command = new CmdError(); }
    },
    LOGIN {
        { this.command = new CmdLogin(); }
    },
    PROFILE {
        { this.command = new CmdProfile(); }
    },
    LOGOUT {
        { this.command = new CmdLogout(); }
    },
    USERLIST {
        { this.command = new CmdUserList(); }
    },
    USEREDIT {
        { this.command = new CmdUserEdit(); }
    },
    TOVARLIST {
        { this.command = new CmdTovarList(); }
    },
    TOVAREDIT {
        { this.command = new CmdTovarEdit(); }
    };

    public AbstractAction command;

    static AbstractAction defineFrom(HttpServletRequest req) {
        String command = req.getParameter("command").toUpperCase();
        if (command == null)
            command = "index";
        AbstractAction res;

        try {
            res = Actions.valueOf(command).command;
        }
        catch (IllegalArgumentException e) {
            res = Actions.ERROR.command;
        }
        return res;
    }
}
