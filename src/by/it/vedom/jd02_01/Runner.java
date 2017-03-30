package by.it.vedom.jd02_01;

public class Runner {

    public static int countBayers = 0;
    public static int plan = 10;

    public static void main(String[] args) {
        Bayer bayer;
        while(countBayers < plan) {
            int count = Helper.getRandom(2);
            while(count > 0) {
                bayer = new Bayer(++countBayers);
                bayer.start();
                count--;
                if (countBayers == plan) break;
            }
            Helper.sleep(1000);
        }
        System.out.println("--------------------------------");
        System.out.println("Все вышли");
        System.out.println("--------------------------------");
    }
}
