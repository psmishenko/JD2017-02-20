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

    public int getAge() {
        return age;
    }

    public float getWorkExperience() {
        return workExperience;
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

    @Override
    public void report() {
    }

    public void printInfo() {
        System.out.println("Имя: " + name + " Возраст: " + age + " Стаж работы: " + workExperience);
    }
}
