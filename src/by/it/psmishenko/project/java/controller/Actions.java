package by.it.psmishenko.project.java.controller;

/**
 * Created by user on 05.05.2017.
 */
enum  Actions {
    SIGNUP {
        {
            this.command = new CommandSignup();
        }
    },
    LOGIN {
        {
            this.command = new CommandLogin();
        }
    },
    LOGOUT {
        {
            this.command = new CommandLogout();
        }
    },
    ERROR {
        {
            this.command = new CommandError();
        }
    };
    public String jsp = "/error.jsp";
    public ActionCommand command;
    public ActionCommand getCurrentCommand(){
        return command;
    }
}
