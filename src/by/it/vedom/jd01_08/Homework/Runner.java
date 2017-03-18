package by.it.vedom.jd01_08.Homework;

public class Runner {
    public static void main(String[] args) {
        Student studentOne = new CorrespondenceStudent("Ivanov"); // Task C
        studentOne.goToUniversity();
        studentOne.showInfo();
        Student studentTwo = new CorrespondenceStudent("Petrov");
        studentTwo.passExams();
        studentTwo.showInfo();
        Student studentThree = new CorrespondenceStudent("Sidorov");
        studentThree.refuseEntry();
        studentThree.showInfo();
    }
}
