package by.it.Zyryanov.jd01_08;


public class Runner {



    public static void main(String[] args) {

        AstonMartin_DB11 astonMartin_db11 = new AstonMartin_DB11("Синий");
        astonMartin_db11.startEngine();
        astonMartin_db11.go();
        astonMartin_db11.turnACOn();
        astonMartin_db11.lockDoors();
        astonMartin_db11.showState();
        astonMartin_db11.getSpeed();
        System.out.println();
        System.out.println("----------------------");
        astonMartin_db11.turnACOff();
        astonMartin_db11.stopEngine();
        astonMartin_db11.unlockDoors();
        astonMartin_db11.showState();
        astonMartin_db11.getSpeed();
    }
}
