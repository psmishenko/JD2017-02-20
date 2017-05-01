package by.it.psmishenko.jd03_1;

/**
 * Created by GN on 01.05.2017.
 */
public class Runner {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        TestConnection.testCon();
    /*  int idRoleAdm =  AddRoles.AddNewRole("Admin"); // Создаём  роли (возвр. значение - Roles.ID)
       int idRoleUser =  AddRoles.AddNewRole("User");
      //  int idGuest = AddRoles.AddNewRole("Guest");
     int idAdm =  CreateUser.createOneUser("Admin1","admin1","admin1@mail.ru",idRoleAdm); // создание поьзователей (в.з. users.ID)
      int idUser1 =  CreateUser.createOneUser("User1","user1","user1@mail.ru",idRoleUser);
       int idUser2 = CreateUser.createOneUser("User2","user2","user2@mail.ru",idRoleUser);
        AddData.AddNewData("S.King","LOL",1999,"123-3321-111",1234321,idUser1);
        AddData.AddNewData("S.King","LOLOLOLO",1978,"123-31121-111",1234121,idUser2);*/
        ShowUsers.showAllUsers();
    }
}
