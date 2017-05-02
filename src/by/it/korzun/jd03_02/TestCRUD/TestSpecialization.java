package by.it.korzun.jd03_02.TestCRUD;

import by.it.korzun.jd03_02.beans.Specialization;
import by.it.korzun.jd03_02.crud.SpecCRUD;

import java.sql.SQLException;

public class TestSpecialization {
    public static void main(String[] args) throws SQLException {
        SpecCRUD specCRUD = new SpecCRUD();
        Specialization specialization = new Specialization(0,"Cleanerer");
        System.out.println(specialization);
        if (specCRUD.create(specialization))
            System.out.println("CREATE: " + specialization);
    }
}
