package by.it.psmishenko.jd01_8.MyVar;

/**
 *  Var5: interface Mobile <-- abstract class Siemens Mobile <-- class Model.
 */
public abstract class SiemensMobile implements Mobile {
    private boolean isTurnedOn=false;
    private boolean isTurnedOff=true;
    private String name;

    public SiemensMobile(String name) {
        this.name = name;
        this.isTurnedOff = false;
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

    @Override
    public void setRington() {
       if (!isTurnedOff())System.out.println(getName()+" : Устанавливаем рингтон");
       if (!isTurnedOff)System.out.println(getName()+" : Устанавливаем рингтон");
       else System.out.println("Включите мобильный!");
    }

    @Override
    public void sendTextMessage() {
       if(isTurnedOn()) System.out.println(getName()+" : Посылаем сообщение");
        else System.out.println("Включите мобильный!");
    }
    public String getName(){return name;}
}
