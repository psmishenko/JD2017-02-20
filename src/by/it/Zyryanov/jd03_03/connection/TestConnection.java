package by.it.Zyryanov.jd03_03.connection;


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
