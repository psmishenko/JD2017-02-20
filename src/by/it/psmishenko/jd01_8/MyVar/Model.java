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

    @Override
    public void setRington() {
        if (isTurnedOff()) System.out.println("Включите мобильный!");
        else System.out.println(getName()+" : Устанавливаем рингтон");
    }

    @Override
    public void sendTextMessage() {
        if(isTurnedOn()) System.out.println(getName()+" : Посылаем СМС");
        else System.out.println("Включите мобильный!");
    }

    @Override
    public void setDateAndTime() {
        if(!isTurnedOff()) {
            System.out.println(getName()+" : Устанавливаем дату и время :"+ new java.util.Date ().toString ());
        }
    }

}
