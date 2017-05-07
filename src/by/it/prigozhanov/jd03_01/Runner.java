package by.it.prigozhanov.jd03_01;

/**
 * Created by v-omf on 5/1/2017.
 *
 * @author v-omf
 */
public class Runner {
    public static void main(String[] args) {
        C_Reset.reset();
        C_Init.initialize();
        A_AddCar.add();
        B_AddRoles.add();
        A_AddUser.add();
        B_ShowUsers.show();
    }

}
