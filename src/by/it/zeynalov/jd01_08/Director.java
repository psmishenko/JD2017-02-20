package by.it.zeynalov.jd01_08;

public class Director extends AbstractEmployee {
    public Director(String name, int age, float workExperience) {
        super(name, age, workExperience);
    }

    /*public void dismiss(Employee emp) {
        emp.quit(false);
        System.out.println("Уволил сотрудника");
    }*/

    @Override
    public void quit(boolean wish) {
        if(wish == false) {
            System.out.println(getName() + " Уволил сотрудника");
        }
    }
}
