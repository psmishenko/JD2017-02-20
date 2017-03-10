package by.it.loktev.jd01_08;

public class Notebook extends Computer implements ICharge {

    double powerVoltage;

    public Notebook(String name, double weight, double powerVoltage){
        super(name,weight);
        this.powerVoltage=powerVoltage;
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
    public void run(String path){
        System.out.println("Запускаем программу под windows: "+path);
    }

    @Override
    public void chargeStart(){
        System.out.println("ноут подключен к розетке - заряжаемся");
    }

    @Override
    public void chargeEnd(){
        System.out.println("ноут отключен от розетки");
    }

}
