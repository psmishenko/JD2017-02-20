package by.it.ikavalenka.jd_08;

/**
 * Created by USER on 11.03.2017.
 */
public class Runner {
    public static void main(String[] args) {
       // AbstractAutomats AK_50 = new Ak47();
        Ak47 ak_50 =new Ak47(4);
        Weapon mak = new tt();
        AbstractAutomats cr =new Ak47(1);

        //ak_50.aim();
       // ak_50.force();
        //ak_50.reload();
        mak.speed();
        mak.range();
        mak.aim();
       // ak50.magazine();
       ak_50.shooting();
       cr.magazine();
    }
}
