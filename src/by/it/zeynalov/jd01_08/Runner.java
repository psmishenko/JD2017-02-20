package by.it.zeynalov.jd01_08;

public class Runner {
    public static void main(String[] args) {

        AbstractEmployee director = new Director("Bob Dank", 32, 6.5f);
        AbstractEmployee driver = new Driver("Frank Senator", 23, 1.0f, 250.0);
        AbstractEmployee programmer = new Programmer("Sam Vinchester", 21, 2.5f, 400.0, 15);


        director.printInfo();
        director.goWork();
        director.cofeeBreak();
        ((Director) director).quit(driver);
        director.miting();
        director.endWork();

        System.out.println("-----------------------------------------");

        driver.printInfo();
        driver.goWork();
        driver.cofeeBreak();
        driver.smoke();
        driver.getWage();
        driver.endWork();

        System.out.println("-----------------------------------------");

        programmer.printInfo();
        programmer.goWork();
        programmer.cofeeBreak();
        programmer.smoke();
        programmer.signDocument();
        programmer.miting();
        programmer.smoke();
        programmer.report();
        programmer.endWork();

    }
}
