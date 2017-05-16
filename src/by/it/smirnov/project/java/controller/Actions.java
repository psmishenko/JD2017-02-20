package by.it.smirnov.project.java.controller;

import by.it.smirnov.project.java.filters.ICookies;
import by.it.smirnov.project.java.log.SingleLogger;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static by.it.smirnov.project.java.controller.ActionsOnlyAdmin.getActionLaw;

/**
 * Created by aleksey.smirnov on 05.05.2017.
 */
enum Actions {
    SIGNUP {{this.command = new CommandActionUser();}},
    LOGIN {{this.command = new CommandLogin();}},
    LOGOUT {{this.command = new CommandLogout();}},
    BANKS {{this.command = new CommandBanks();}},
    ACTIONBANK {{this.command = new CommandActionBank();}},
    USERS {{this.command = new CommandUsers();}},
    ACTIONUSER {{this.command = new CommandActionUser();}},
    SDELS {{this.command = new CommandSdels();}},
    ACTIONSDEL {{this.command = new CommandActionSdel();}},
    VALUTS {{this.command = new CommandValuts();}},
    ACTIONVALUT {{this.command = new CommandActionValut();}},
    COUNTRYS {{this.command = new CommandCountrys();}},
    ACTIONCOUNTRY {{this.command = new CommandActionCountry();}},
    OPERTYPES {{this.command = new CommandOperTypes();}},
    ACTIONOPERTYPE {{this.command = new CommandActionOperType();}},
    ROLES {{this.command = new CommandRoles();}},
    ACTIONROLE {{this.command = new CommandActionRole();}},
    GROUPBANKS {{this.command = new CommandGroupBanks();}},
    ACTIONGROUPBANK {{this.command = new CommandActionGroupBank();}},
    LIMITS {{this.command = new CommandLimits();}},
    ACTIONLIMIT {{this.command = new CommandActionLimit();}},
    KURSVALUTS {{this.command = new CommandKursValuts();}},
    ACTIONKURSVALUT {{this.command = new CommandActionKursValut();}},
    MAIN {{this.command = new CommandMain();}},
    ERROR {{this.command = new CommandError();}};

    public Action command;
    static Action defineFrom(HttpServletRequest request){
        String command=request.getParameter("command");
        Action res;
        try {
            HttpSession session = request.getSession(false);
            if (session == null) {
                Cookie[] cookies = request.getCookies();
                String login = "";
                String password = "";
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equalsIgnoreCase(ICookies.LOGIN)) login = cookie.getValue();
                    if (cookie.getName().equalsIgnoreCase(ICookies.PASSWORD)) password = cookie.getValue();
                }
                if (login.length() > 0 && password.length() > 0) {
                    session = FormUtils.getSession(request, login, password);
                }
            }
            if ((Actions.valueOf(command.toUpperCase())!=LOGIN) &&
                (session == null || session.getAttribute("currentuser") == null)) {
                res = Actions.LOGIN.command;
                request.setAttribute("clearform",Boolean.TRUE);
            } else {
                if (getActionLaw(session,Actions.valueOf(command.toUpperCase()))) {
                    res = Actions.valueOf(command.toUpperCase()).command;
                } else {
                    res = Actions.LOGOUT.command;
                }
            }

        } catch (Exception e) {
            SingleLogger.getInstance().error(e.toString());
            res = Actions.ERROR.command;
        }
        return res;
    }
}
