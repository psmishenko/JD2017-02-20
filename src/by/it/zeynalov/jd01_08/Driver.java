package by.it.zeynalov.jd01_08;

public class Driver extends AbstractEmployee{
    public Driver(String name, int age, float workExperience) {
        super(name, age, workExperience);
    }

    @Override
    public void quit(boolean wish) {
        if(wish == false) {
            System.out.println(getName() + " Не имеет право увольнять сотрудников");
        }
    }

    @Override
    public void cofeeBreak() {
        System.out.println(getName() + " Работает без обеда");
    }
}
