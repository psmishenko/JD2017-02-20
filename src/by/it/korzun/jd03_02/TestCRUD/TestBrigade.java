package by.it.korzun.jd03_02.TestCRUD;

import by.it.korzun.jd03_02.beans.Brigade;
import by.it.korzun.jd03_02.crud.BrigadeCRUD;

import java.sql.SQLException;

public class TestBrigade {
    public static void main(String[] args) throws SQLException {
        BrigadeCRUD brigadeCRUD = new BrigadeCRUD();
        Brigade brigade = new Brigade(0,7,8,9,10,11);
        System.out.println(brigade);
        if (brigadeCRUD.create(brigade))
            System.out.println("CREATE: " + brigade);
        brigade = brigadeCRUD.read(1);
        if (brigade != null)
            System.out.println("READ: " + brigade);
        brigade.setNavigatorID(8);
        if (brigadeCRUD.delete(brigade))
            System.out.println("DELETE: " + brigade);
    }
}
