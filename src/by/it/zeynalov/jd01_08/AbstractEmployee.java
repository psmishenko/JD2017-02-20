package by.it.zeynalov.jd01_08;

public abstract class AbstractEmployee implements Employee {
    private String name;          //имя
    private int age;              //возраст
    private float workExperience; //стаж работы
    private int daysOfVacation;   //сколько дней отпуска
    private float bonus;          //премия

    public AbstractEmployee(String name,
                            int age,
                            float workExperience,
                            int daysOfVacation,
                            float bonus) {
        this.name = name;
        this.age = age;
        this.workExperience = workExperience;
        this.daysOfVacation = daysOfVacation;
        this.bonus = bonus;
    }

    public String getName() {
        return name;
    }

    @Override
    public void goWork(boolean goWork) {
        if (goWork) {
            System.out.println(name + " Пришел на работу");
        } else {
            System.out.println(name + " Его нету на работе");
        }
    }

    @Override
    public void endWork(boolean endWork) {
        if (endWork) {
            System.out.println(name + " Закончил работу");
        } else {
            System.out.println(name + " Еще на работе");
        }
    }

    @Override
    public void cofeeBreak(boolean cofeeBreak) {
        if (cofeeBreak = true) {
            System.out.println(name + " На обеде");
        } else {
            System.out.println(name + " Нету его на обеде");
        }
    }

    @Override
    public void getWage(boolean getWage) {
        if (getWage) {
            System.out.println(name + " Получил зарплату");
        } else {
            System.out.println(name + " Еще не получил зарплату");
        }
    }

    @Override
    public void signDocument(boolean signDocument) {
        if (signDocument) {
            System.out.println(name + " Подписал документы");
        } else {
            System.out.println(name + " Документы не подписал");
        }
    }

    @Override
    public void smoke(boolean smoke) {
        if (smoke) {
            System.out.println(name + " Пошел на перекур");
        } else {
            System.out.println(name + " Не курит");
        }
    }

    @Override
    public void miting(boolean miting) {
        if (miting) {
            System.out.println(name + " На совещании");
        } else {
            System.out.println(name + " Нету на совещании");
        }
    }

    public void quit(boolean quit) {
    }

    public void printInfo() {
        System.out.println("Имя: " + name + " Возраст: " + age + " Стаж работы: " +
                workExperience + " Дней отпуска: " + daysOfVacation + " Премия: " + bonus);
    }
}
