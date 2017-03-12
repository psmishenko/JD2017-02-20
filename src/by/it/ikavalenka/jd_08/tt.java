package by.it.ikavalenka.jd_08;

/**
 * Created by USER on 10.03.2017.
 */
public class tt extends AbstractGun {

    @Override
    public void shooting() {
        System.out.println("2 shots per second");
    }

    @Override
    public void reload() {
        System.out.println("2 sec");
    }

    @Override
    public void aim() {
        System.out.println("15 bullets");

    }

    @Override
    public void score() {
        System.out.println("100s");

    }

    @Override
    public void force() {
        System.out.println("50J");

    }

    @Override
    public void speed() {
        System.out.println("15km/h");

    }

    @Override
    public void range() {
        System.out.println("30meters");

    }

    @Override
    public void hand() {
        System.out.println("multi Hand");
    }
}
