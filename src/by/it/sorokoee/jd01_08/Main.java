package by.it.sorokoee.jd01_08;

public class Main {
    public static void main(String[] args) {
        Lamp lamp = new TableLamp();
        System.out.println(lamp.showState());
        lamp.on();
        System.out.println(lamp.showState());
        lamp.off();
        System.out.println(lamp.showState());
        Lamp lampDimmer = new TableLamp(32);
        lampDimmer.on();
        System.out.println(((TableLamp) lampDimmer).showState((TableLamp)lampDimmer));
        lampDimmer.off();
        System.out.println(((TableLamp) lampDimmer).showState());
    }
}
