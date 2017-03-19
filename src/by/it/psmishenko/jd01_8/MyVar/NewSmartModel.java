package by.it.psmishenko.jd01_8.MyVar;

/**
 * Created by GN on 18.03.2017.
 */
public class NewSmartModel extends SiemensMobile {

    public NewSmartModel(String name) {
        super(name);
    }
    @Override
    public void setRington() {
        if (isTurnedOff()) System.out.println("Включите сматрфон!");
        else System.out.println(getName()+" : Устанавливаем mp3 рингтон");
    }

    @Override
    public void sendTextMessage() {
        if(isTurnedOn()) System.out.println(getName()+" : Посылаем instant-сообщение");
        else System.out.println("Включите смартфон!");
    }

    @Override
    public void setDateAndTime() {
        if(!isTurnedOff()) {
            System.out.println(getName()+": Синхронизация даты и времени с time.com :"+ new java.util.Date ().toString ());
        }
    }
    @Override
    public void showState() {
        System.out.println(this.toString());
    }
    @Override
    public String toString() {
        String state = "Смартфон "+getName()+" выключен";
        if(isTurnedOn())state="Смартфон включен";
        return state;
    }

    }

