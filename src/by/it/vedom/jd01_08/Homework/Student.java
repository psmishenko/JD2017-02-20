package by.it.vedom.jd01_08.Homework;

public abstract class Student implements Enrollee {

    public  boolean isGoToClasses; // студент ходит на пары
    public boolean isGetMatrks; // студент получает оценки

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name; // имя зачисленного студента

    public Student(String name) {
        this.name = name;
        this.isGetMatrks = true;
        this.isGoToClasses = true;

    }

    public boolean isGetMatrks() {
        return isGetMatrks;
    }

    public void setGetMatrks(boolean getMatrks) {
        isGetMatrks = getMatrks;
    }

    public boolean isGoToClasses() {
        return isGoToClasses;
    }

    public void setGoToClasses(boolean goToClasses) {
        isGoToClasses = goToClasses;
    }

    public abstract void showInfo();

    // Task B
    public void showInfo(String word) {
        System.out.println(word);
    }

    @Override
    public void goToUniversity() {
        isGoToClasses = true;

    }

    @Override
    public void passExams() {
        isGoToClasses = true;
        isGetMatrks = true;
    }

    // отчислиться
    @Override
    public void refuseEntry() {
        isGetMatrks = false;
        isGoToClasses = false;
    }
}
