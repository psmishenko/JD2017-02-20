package by.it.Zyryanov.project_v2.java.connection;


public class TestConnection {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("ошибка");
        }


    }
}
