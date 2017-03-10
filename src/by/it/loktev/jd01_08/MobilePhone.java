package by.it.loktev.jd01_08;

public class MobilePhone extends Computer implements ICharge {

    private Boolean canGSM;
    private Boolean canGPS;

    public MobilePhone(String name, double weight, Boolean canGSM, Boolean canGPS){
        super(name,weight);
        this.canGSM=canGSM;
        this.canGPS=canGPS;
    }

    @Override
    public String toString(){
        return super.toString()+" GSM="+(this.canGSM?"да":"нет")+" GPS="+(this.canGPS?"да":"нет");
    }

    @Override
    public void repairBroken(){
        System.out.println("сломался - несём в ремонт");
    }

    @Override
    public void repairBroken(double price){
        System.out.println("сломался - несём в ремонт, затратили "+price);
    }

    @Override
    public void run(String path){
        System.out.println("Запускаем программу под android: "+path);
    }

    @Override
    public void chargeStart(){
        System.out.println("мобильник подключен к розетке - заряжаемся");
    }

    @Override
    public void chargeEnd(){
        System.out.println("мобильник отключен от розетки");
    }

}
