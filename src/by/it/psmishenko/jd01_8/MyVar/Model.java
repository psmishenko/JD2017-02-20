package by.it.psmishenko.jd01_8.MyVar;

/**
 * Var5: interface Mobile <-- abstract class Siemens Mobile <-- class Model.
 */
public class Model extends SiemensMobile {
    public Model(String name) {
        super(name);
    }

    @Override
    public void showState() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        String state="Мобильный "+getName()+" выключен";
        if (this.isTurnedOn()) {
            state = "Мобильный "+getName()+" включен";}
        return state;
    }
}
