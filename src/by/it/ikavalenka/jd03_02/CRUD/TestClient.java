package by.it.ikavalenka.jd03_02.CRUD;
        import by.it.ikavalenka.jd03_02.beans.client;
        import by.it.ikavalenka.jd03_02.CRUD.ClientCRUD;

        import java.sql.SQLException;

/**
 * Created by USER on 13.05.2017.
 */
public class TestClient {
    public static void main(String[] args) throws SQLException {
        ClientCRUD clientCRUD = new ClientCRUD();
        client client = new client(12,123,123,12,"fdd");
        System.out.println(client);
        if (clientCRUD.create(client))
            System.out.println("CREATE:" +client);
        client=clientCRUD.read(client);
        if (client!=null)
            System.out.println("Read"+client);
        client.setCost_order("2331");
        if (clientCRUD.update(client))
            System.out.println("Update"+client);
        if (clientCRUD.delete(client))
            System.out.println("Delete"+client);

    }
}
