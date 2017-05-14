package by.it.ikavalenka.jd03_02.CRUD;

import by.it.ikavalenka.jd03_02.beans.administrator;
import by.it.ikavalenka.jd03_02.CRUD.RoleCRUD;
import java.sql.SQLException;

/**
 * Created by USER on 13.05.2017.
 */
public class TestAdm {
    public static void main(String[] args) throws SQLException {
        RoleCRUD roleCRUD = new RoleCRUD();
        administrator administrator = new administrator(1,483,456,"CatalogSwcond",555,12);
        System.out.println(administrator);
        if (roleCRUD.create(administrator))
            System.out.println("Creating" + administrator);
        administrator = roleCRUD.read(administrator);
        if (administrator!=null)
            System.out.println("Reading:" + administrator);
        administrator.setCatalog("Catalog");
        if (roleCRUD.update(administrator))
            System.out.println("UPDATING" + administrator);
        if (roleCRUD.delete(administrator))
            System.out.println("DELETING" + administrator);
    }
}