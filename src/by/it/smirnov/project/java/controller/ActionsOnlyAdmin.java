package by.it.smirnov.project.java.controller;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

import static by.it.smirnov.project.java.controller.Actions.*;

/**
 * Created by aleksey.smirnov on 15.05.2017.
 */
public class ActionsOnlyAdmin {
    static List<Actions> actionList;
    static {
        actionList = new ArrayList<Actions>();
        actionList.add(ACTIONBANK);
        actionList.add(ACTIONUSER);
        actionList.add(ACTIONVALUT);
        actionList.add(ACTIONCOUNTRY);
        actionList.add(ACTIONOPERTYPE);
        actionList.add(ACTIONROLE);
        actionList.add(ACTIONGROUPBANK);
        actionList.add(ACTIONLIMIT);
        actionList.add(ACTIONKURSVALUT);

    }

    static boolean getActionLaw (HttpSession session, Actions action){
        return (session !=null &&  session.getAttribute("admin") != null && (Integer)session.getAttribute("admin") == 1) ||
                !actionList.contains(action);
    }


}
