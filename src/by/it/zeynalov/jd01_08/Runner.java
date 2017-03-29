package by.it.zeynalov.jd01_08;

public class Runner {
    public static void main(String[] args) {

        AbstractEmployee director = new Director("Bob Dank", 32, 6.5f);
        director.printInfo();
        director.goWork();
        director.cofeeBreak();
        director.quit(false);
        director.miting();
        director.endWork();

        System.out.println("-----------------------------------------");

        AbstractEmployee driver = new Driver("Frank Senator", 23, 1.0f);
        driver.printInfo();
        driver.goWork();
        driver.cofeeBreak();
        driver.quit(false);
        driver.smoke();
        driver.getWage();
        driver.endWork();
    }
}
