package by.it.korzun.jd03_02.TestCRUD;

import by.it.korzun.jd03_02.beans.Staff;
import by.it.korzun.jd03_02.crud.StaffCRUD;

import java.sql.SQLException;

public class TestStaff {
    public static void main(String[] args) throws SQLException {
        StaffCRUD staffCRUD = new StaffCRUD();
        Staff staff = new Staff(0,"Pasha",1);
        System.out.println(staff);
        if (staffCRUD.create(staff))
            System.out.println("CREATE: " + staff);
        staff = staffCRUD.read(3);
        if (staff != null)
            System.out.println("READ: " + staff);
        staff.setName("NePasha");
        if (staffCRUD.update(staff))
            System.out.println("UPDATE: " + staff);
        if (staffCRUD.delete(staff))
            System.out.println("DELETE: " + staff);
    }
}
