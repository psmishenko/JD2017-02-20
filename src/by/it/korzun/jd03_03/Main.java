package by.it.korzun.jd03_03;

import by.it.korzun.jd03_03.beans.Brigade;
import by.it.korzun.jd03_03.beans.Specialization;
import by.it.korzun.jd03_03.beans.Staff;
import by.it.korzun.jd03_03.dao.DAO;

import java.sql.SQLException;

public class Main {
    static void showStaff(){
        DAO dao = DAO.getInstance();
        for(Staff staff: dao.staff.getAll("")){
            System.out.println(staff);
        }
    }

    public static void main(String[] args) throws SQLException{
        DAO dao = DAO.getInstance();

        Staff newStaff = new Staff(0, "Kirill", 3);

        System.out.println("Специализации:");
        for(Specialization spec: dao.spec.getAll("")){
            System.out.println(spec);
        }

        System.out.println("Специализации персонала:");
        showStaff();

        dao.staff.create(newStaff);
        System.out.println("Create:");
        showStaff();

        newStaff.setName("NeKirill");
        if(dao.staff.update(newStaff)) {
            System.out.println("Update: " + newStaff);
        }

        dao.staff.delete(new Staff(11, "neKirill", 4));
        if(dao.staff.delete(newStaff)) {
            System.out.println("Delete:");
            showStaff();
        }

        System.out.println("Бригады:");
        for(Brigade brigade: dao.brigade.getAll("")){
            System.out.println(brigade);
        }

    }
}
