package by.it.smirnov.project.java.controller;

import by.it.smirnov.project.java.log.SingleLogger;

import javax.servlet.http.HttpServletRequest;

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
    ERROR {{this.command = new CommandError();}};

    public Action command;
    static Action defineFrom(HttpServletRequest request){
        String command=request.getParameter("command");
        Action res;
        try {
            res = Actions.valueOf(command.toUpperCase()).command;
        } catch (IllegalArgumentException e) {
            SingleLogger.getInstance().error(e.toString());
            res = Actions.ERROR.command;
        }
        return res;
    }
}
