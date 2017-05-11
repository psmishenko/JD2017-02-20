package by.it.smirnov.project.java.controller;

import by.it.smirnov.project.java.filters.ICookies;
import by.it.smirnov.project.java.log.SingleLogger;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

/**
 * Created by aleksey.smirnov on 05.05.2017.
 */
enum Actions {
    SIGNUP {{this.command = new CommandAddUser();}},
    LOGIN {{this.command = new CommandLogin();}},
    LOGOUT {{this.command = new CommandLogout();}},
    BANKS {{this.command = new CommandBanks();}},
    ADDBANK {{this.command = new CommandAddBank();}},
    USERS {{this.command = new CommandUsers();}},
    ADDUSER {{this.command = new CommandAddUser();}},
    SDELS {{this.command = new CommandSdels();}},
    ADDSDEL {{this.command = new CommandAddSdel();}},
    VALUTS {{this.command = new CommandValuts();}},
    ADDVALUT {{this.command = new CommandAddValut();}},
    COUNTRYS {{this.command = new CommandCountrys();}},
    ADDCOUNTRY {{this.command = new CommandAddCountry();}},
    OPERTYPES {{this.command = new CommandOperTypes();}},
    ADDOPERTYPE {{this.command = new CommandAddOperType();}},
    ROLES {{this.command = new CommandRoles();}},
    ADDROLE {{this.command = new CommandAddRole();}},
    GROUPBANKS {{this.command = new CommandGroupBanks();}},
    ADDGROUPBANK {{this.command = new CommandAddGroupBank();}},
    LIMITS {{this.command = new CommandLimits();}},
    ADDLIMIT {{this.command = new CommandAddLimit();}},
    KURSVALUTS {{this.command = new CommandKursValuts();}},
    ADDKURSVALUT {{this.command = new CommandAddKursValut();}},
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
                (session == null || session.getAttribute("user") == null)) {
                res = Actions.LOGIN.command;
                request.setAttribute("clearform",Boolean.TRUE);
            } else {
                res = Actions.valueOf(command.toUpperCase()).command;
            }

        } catch (Exception e) {
            SingleLogger.getInstance().error(e.toString());
            res = Actions.ERROR.command;
        }
        return res;
    }
}
