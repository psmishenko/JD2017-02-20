package by.it.zeynalov.jd01_08;

public class Director extends AbstractEmployee {
    public Director(String name, int age, float workExperience, int daysOfVacation, float bonus) {
        super(name, age, workExperience, daysOfVacation, bonus);
    }

    @Override
    public void quit(boolean quit) {
        if(quit) {
            System.out.println(getName() + " Уволил сотрудника");
        }
        super.quit(true);
    }
}
