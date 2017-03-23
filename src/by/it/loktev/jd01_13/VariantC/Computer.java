package by.it.loktev.jd01_13.VariantC;

abstract public class Computer extends ElectronicDevice implements IRunProgram {

    public Computer(String name, double weight){
       super(name,weight);
    }

    // можно было не реализовывать run в этом классе, а только в дочерних;
    // но нужно же и показать вызов super.метод()
    public void run(String path) throws RunException {
        System.out.println("Готовимся к запуску программы "+path+"...");
        if ( Math.random()<((this instanceof Notebook)?0.5:0.1) )
        {
            System.out.println("УПС! НЕ ХВАТИЛО ПАМЯТИ!");
            throw new RunException("Не хватило памяти для запуска программы "+path);
        }
    }

    abstract public void repairBroken();
    abstract public void repairBroken(double price);

    public void runScreenSaver(String path){
        System.out.println("включаем скринсейвер...");
        run(path); // позднее связывание
    }

    @Override
    public void switchOff(){
        System.out.println("выключаем компьютер "+name);
    }

}
