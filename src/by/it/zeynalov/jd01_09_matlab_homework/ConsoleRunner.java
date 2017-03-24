package by.it.zeynalov.jd01_09_matlab_homework;

public class ConsoleRunner {
    public static void main(String[] args) throws MathException {
        VarF ff = new VarF(20);
        VarF fd = new VarF("555");
        VarF gd = (VarF) ff.sub(fd);
        System.out.println(gd);
    }
}
