package by.it.ikavalenka.jd_08;

/**
 * Created by USER on 10.03.2017.
 */
public class Ak47 extends AbstractAutomats {
    private int  service;

    public Ak47(int service) {
        super(service);
        this.service = service;
    }

    @Override
    public void shooting() {
        for (int i = 0; i <service ; i++) {
            System.out.println("30 coutries");

        }
    }

    @Override
    public void reload() {
        System.out.println("10 sec");

    }

    @Override
    public void aim() {
        System.out.println("40");

    }

    @Override
    public void score() {
        System.out.println("300");

    }

    @Override
    public void force() {
        System.out.println("150J");

    }

    @Override
    public void speed() {
        System.out.println("40 km/h");

    }

    @Override
    public void range() {
        System.out.println(" 50 meters");

    }

    @Override
    public void magazine() {
        System.out.println("30 bullets");

    }
}
