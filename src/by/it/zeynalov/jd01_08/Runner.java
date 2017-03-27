package by.it.zeynalov.jd01_08;

public class Runner {
    public static void main(String[] args) {

       AbstractEmployee employee = new Director("Bob Dank", 32, 6.5f, 45, 3.500f);
       employee.printInfo();
       employee.goWork(true);
       employee.quit(true);
       employee.endWork(false);
    }
}
