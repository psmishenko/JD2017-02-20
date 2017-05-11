package by.it.Zyryanov.jd03_01;

/**
 * Created by georgijzyranov on 11.05.17.
 */
public class Runner {
    public static void main(String[] args) {
        C_Init.create();
        C_Reset.reset();
        dbTableCreator.create();
        A_AddRoles.add();
        A_AddUser.add();
        A_AddData.add();
        B_ShowUsers.show();
        dbDropper.drop();
    }
}
