package by.it.smirnov.jd01_08;

/**
 * Created by aleksey.smirnov on 12.03.2017.
 */
public class Runner {
    public static void main(String[] args) {
        // Авианосец
        AircraftShip admiralKuznetsov = new AircraftShip("Адмирал Кузнецов", 1987,
                306.45, 71.96, 120, 201.1, 19.6);
        System.out.println(admiralKuznetsov);
        System.out.print(admiralKuznetsov.getShipState());
        admiralKuznetsov.forward();
        System.out.print(admiralKuznetsov.getShipState());
        admiralKuznetsov.stop();
        admiralKuznetsov.runwayLightingOn();
        System.out.print(admiralKuznetsov.getShipState());
        admiralKuznetsov.backward();
        System.out.print(admiralKuznetsov.getShipState());
        System.out.println();

        // Простой корабль
        IShip ship = new Ship("Победа", 1965,
                57.1, 8.03, 4.5);
        System.out.println(ship);
        System.out.print(ship.getShipState());
        ship.forward();
        System.out.print(ship.getShipState());
        ship.stop();
        System.out.print(ship.getShipState());
        System.out.println();

        // Круизный лайнер
        IShip cruiseShip = new CruiseShip("Sirena", 2004,
                267.8, 53.2, 52, 524, 1318);
        System.out.println(cruiseShip);
        System.out.print(cruiseShip.getShipState());
        cruiseShip.forward();
        System.out.print(cruiseShip.getShipState());
        cruiseShip.stop();
        System.out.print(cruiseShip.getShipState());

    }
}
