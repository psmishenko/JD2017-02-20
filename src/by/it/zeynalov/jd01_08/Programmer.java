package by.it.zeynalov.jd01_08;

public class Programmer extends AbstractEmployee{
    private double workDay;
    private double bonus;
    public Programmer(String name, int age, float workExperience, double bonus, double workDay) {
        super(name, age, workExperience);
        this.bonus = bonus;
        this.workDay = workDay;
    }

    @Override
    public void cofeeBreak() {
        System.out.println(getName() + " Слишком много работы, работаю без обеда");
    }

    @Override
    public void report() {
        System.out.println( getName() + " Сдал отчет о проделанной работе");
    }
}
