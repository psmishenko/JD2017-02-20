package by.it.psmishenko.jd03_3;


import by.it.psmishenko.jd03_3.beans.Role;
import by.it.psmishenko.jd03_3.beans.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GN on 04.05.2017.
 */
public class ShowUsers {
    static void showAllUsers(List<User> users, List<Role> roles){
        StringBuilder res = new StringBuilder();
        res.append(String.format("%10s%20s%20s%30s%20s\n","User ID","Login","Password","Email","Role (ID)"));
        for (int i = 0; i <users.size() ; i++) {
            String roleString = "";
            for (int j = 0; j <roles.size() ; j++) {
                if(roles.get(j).getId()==users.get(i).getId()) roleString = roles.get(j).getRole();
            }
            res.append(String.format("%10s%20s%20s%30s%20s\n",users.get(i).getId(),users.get(i).getLogin()
            ,users.get(i).getPassword(),users.get(i).getEmail(),roleString+"("+users.get(i).getFk_roles()+")"));
        }
        res.append("Кол-во пользователей - "+users.size()+"\nКол-во возможных ролей - "+roles.size());
        System.out.println(res);
    }
}
