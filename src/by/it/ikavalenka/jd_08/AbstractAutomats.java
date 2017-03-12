package by.it.ikavalenka.jd_08;

/**
 * Created by USER on 10.03.2017.
 */
public abstract class AbstractAutomats  implements Weapon{
    private int made;

    public AbstractAutomats(int made) {
        System.out.println("Involke constructor super class");
        this.made = made;
    }

    public int getMade() {
        return made;
    }

    public void setMade(int made) {
        /*for (int i = 0; i < made ; i++) {
            System.out.println("MADE IN USSR");
        }*/
        this.made = made;
    }

    public abstract void magazine();
    public void twoHand(){
        System.out.println("two Hand Gun");
    }
}





