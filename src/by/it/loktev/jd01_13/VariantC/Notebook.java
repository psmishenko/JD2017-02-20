package by.it.loktev.jd01_13.VariantC;

public class Notebook extends Computer implements ICharge {

    double powerVoltage;

    private int batteryLevel;

    public Notebook(String name, double weight, double powerVoltage){
        super(name,weight);
        this.powerVoltage=powerVoltage;
        this.batteryLevel=0;
        setBatteryLevel(70);
    }

    @Override
    public String toString(){
        return super.toString()+" powerVoltage="+this.powerVoltage;
    }

    @Override
    public void repairBroken(){
        System.out.println("сломался - разбираем вручную и чиним");
    }

    @Override
    public void repairBroken(double price){
        System.out.println("сломался - разбираем вручную и чиним, затратили "+price);
    }

    @Override
    public void run(String path) throws RunException {
        try {
            super.run(path);
        }
        catch ( RunException re ){
            // предположим, что в некоторых случаях мы можем освободить память
            if ( Math.random()<0.5 )
                throw re; // не получилось освободить - пробрасываем исключение выше, больше ничего предпринять не можем
            System.out.println("удалось освободить память!!! пробуем запустить программу ещё раз...");
            super.run(path); // и тут уж будь что будет
        }
        changeBatteryLevel(-5);
        System.out.println("Запускаем программу под windows: "+path+", осталось заряда "+getBatteryLevel());
    }

    @Override
    public void pause(){
        System.out.println("Программа под windows - пауза");
    }

    @Override
    public void resume(){
        System.out.println("Программа под windows - продолжение");
    }

    @Override
    public void chargeStart(){
        System.out.println("ноут подключен к розетке - заряжаемся");
        setBatteryLevel(100);
    }

    @Override
    public void chargeEnd(){
        System.out.println("ноут отключен от розетки");
    }

    @Override
    public int getBatteryLevel(){
        return batteryLevel;
    }

    @Override
    public void setBatteryLevel(int level){
        batteryLevel=level;
    }

    @Override
    public void changeBatteryLevel(int delta){
        batteryLevel+=delta;
    }

    @Override
    public void switchOff(){
        System.out.println("выключаем ноутбук "+name);
    }

}
