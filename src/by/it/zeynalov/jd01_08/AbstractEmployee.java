package by.it.zeynalov.jd01_08;

public abstract class AbstractEmployee implements Employee {
    private String name;          //имя
    private int age;              //возраст
    private float workExperience; //стаж работы

    public AbstractEmployee(String name, int age, float workExperience) {
        this.name = name;
        this.age = age;
        this.workExperience = workExperience;
    }

    public String getName() {
        return name;
    }

    @Override
    public void goWork() {
        System.out.println(name + " Пришел на работу");
    }

    @Override
    public void endWork() {
        System.out.println(name + " Закончил работу");
    }

    @Override
    public void cofeeBreak() {
        System.out.println(name + " На обеде");
    }

    @Override
    public void getWage() {
        System.out.println(name + " Получил зарплату");
    }

    @Override
    public void signDocument() {
        System.out.println(name + " Подписал документы");
    }

    @Override
    public void smoke() {
        System.out.println(name + " Пошел на перекур");
    }

    @Override
    public void miting() {
        System.out.println(name + " На совещании");
    }

    public void quit(boolean wish) {
        if (wish) {
            System.out.println(name + " Уволился по собственному желанию");
        }
    }

    public void printInfo() {
        System.out.println("Имя: " + name + " Возраст: " + age + " Стаж работы: " + workExperience);
    }
}
