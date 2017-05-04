package by.it.korzun.jd03_02;

import by.it.korzun.jd03_02.beans.Staff;
import by.it.korzun.jd03_02.crud.StaffCRUD;

import java.sql.SQLException;

public class ShowStaff {
    public static void show(){
        try {
            int i = 1;
            while(StaffCRUD.read(i) != null) {
                Staff test = StaffCRUD.read(i);
                System.out.println(test.toString());
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
