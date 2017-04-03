package by.it.zeynalov.jd01_08;

public class Driver extends AbstractEmployee {
    private double bonus;
    public Driver(String name, int age, float workExperience, double bonus) {
        super(name, age, workExperience);
        this.bonus = bonus;
    }

    @Override
    public void cofeeBreak() {
        System.out.println(getName() + " Работает без обеда");
    }


    public void printInfo() {
        System.out.println("Имя: " + getName() + " Возраст: " + getAge() + " Стаж работы: " + getWorkExperience() + " Премия " + bonus);
    }
}
