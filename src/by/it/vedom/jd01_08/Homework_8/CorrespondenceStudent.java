package by.it.vedom.jd01_08.Homework_8;

public class CorrespondenceStudent extends Student {

    public CorrespondenceStudent(String name) {
        super(name);
    }

    @Override
    public void showInfo() {
        String visit;
        if(this.isGoToClasses()){
            visit = "это студент дневной формы обучения";
        }
        else visit = "это студент заочной формы обучения";

        String isTheStudent;
        if(this.isGetMatrks()) {
            isTheStudent = "это студен дневной или заочной формы обучения";
        }
        else isTheStudent = "это не студент";

        System.out.printf("Студент %s. Возможны 2 варианта: \nЛибо %s, либо %s\n", this.getName(), visit, isTheStudent);
    }




}
