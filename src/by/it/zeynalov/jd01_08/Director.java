package by.it.zeynalov.jd01_08;

public class Director extends AbstractEmployee {
    public Director(String name, int age, float workExperience) {
        super(name, age, workExperience);
    }

    public  void quit(AbstractEmployee employee) {
        if(!(employee instanceof Director)) {
            System.out.println(getName() + " Уволил сотрудника " + employee.getName());
        }else {
            System.out.println(getName() + " Не может уволить такого сотрудника");
        }
    }
}
