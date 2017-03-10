package by.it.loktev.jd01_08;

abstract public class Computer extends ElectronicDevice implements IRunProgram {

    public Computer(String name, double weight){
       super(name,weight);
    }

    abstract public void repairBroken();
    abstract public void repairBroken(double price);

}
