package by.it.radivonik.project.java.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Radivonik on 05.05.2017.
 */
public enum Actions {
    INDEX { { this.command = new CmdIndex(); } },
    ERROR { { this.command = new CmdError(); } },
    LOGIN { { this.command = new CmdLogin(); } },
    LOGOUT { { this.command = new CmdLogout(); } },
    USERLIST { { this.command = new CmdUserList(); } },
    USEREDIT { { this.command = new CmdUserEdit(); } },
    TOVARLIST { { this.command = new CmdTovarList(); } },
    TOVAREDIT { { this.command = new CmdTovarEdit(); } },
    KLIENTLIST { { this.command = new CmdKlientList(); } },
    KLIENTEDIT { { this.command = new CmdKlientEdit(); } },
    AVTOLIST { { this.command = new CmdAvtoList(); } },
    AVTOEDIT { { this.command = new CmdAvtoEdit(); } },
    SKLADLIST { { this.command = new CmdSkladList(); } },
    SKLADEDIT { { this.command = new CmdSkladEdit(); } },
    NAKLADLIST { { this.command = new CmdNakladList(); } },
    NAKLADEDIT { { this.command = new CmdNakladEdit(); } };

    public AbstractAction command;

    static AbstractAction defineFrom(HttpServletRequest req) {
        String command = req.getParameter("command");
        if (command == null)
            command = "index";
        AbstractAction res;
        try {
            HttpSession session = req.getSession(false);
            res = Actions.valueOf(command.toUpperCase()).command;
            if (res != LOGIN.command && (session == null || session.getAttribute("userActive") == null)) {
                if (session != null)
                    session.setAttribute(FormUtils.actionPrevName, res);
                res = Actions.LOGIN.command;
            }
        } catch (IllegalArgumentException e) {
            res = Actions.ERROR.command;
        }
        return res;
    }
}
