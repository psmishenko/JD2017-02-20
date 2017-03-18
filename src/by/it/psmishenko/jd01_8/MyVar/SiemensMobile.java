package by.it.psmishenko.jd01_8.MyVar;

/**
 *  Var5: interface Mobile <-- abstract class Siemens Mobile <-- class Model.
 */
public abstract class SiemensMobile implements Mobile {
    private boolean isTurnedOn;
    private boolean isTurnedOff;
    private String name;

    public SiemensMobile(String name) {
        this.name = name;
        this.isTurnedOff = true;
        this.isTurnedOn = false;
    }

    public abstract void showState();

    public boolean isTurnedOn() {
        return isTurnedOn;
    }

    public boolean isTurnedOff() {
        return isTurnedOff;
    }
    @Override
    public void turnOn() {
        isTurnedOff = false;
        isTurnedOn = true;
    }

    @Override
    public void turnOff() {
        isTurnedOff = true;
        isTurnedOn = false;
    }
    @Override
    public void call() {
        if(isTurnedOn())  System.out.println(getName()+" : Производим звонок");
        else System.out.println("Включите мобильный!");
    }

    public String getName(){return name;}
}
