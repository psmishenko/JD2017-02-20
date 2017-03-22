package by.it.loktev.jd01_13.VariantC;

public class ElectronicDevice {

    protected String name;

    private double weight;

    public ElectronicDevice(){
        this.name="unnamed";
        this.weight=0;
    }

    public ElectronicDevice(String name, double weight){
        this.name=name;
        this.weight=weight;
    }

    @Override
    public String toString(){
        return "name="+this.name+" weight="+this.weight;
    }

    public void switchOff(){
        System.out.println("выключаем прибор "+name);
    }

}
