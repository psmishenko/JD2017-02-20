package by.it.korzun.jd01_08;


public class Runner {
    private static void formatOut(String[] mass){
        System.out.printf("%-8s %-15s %-20s %-20s %-20s\n", mass[0], mass[1], mass[2], mass[3], mass[4]);
    }

    public static void main(String[] args) {
        Tanker tanker = new Tanker("Pobeda");
        System.out.println(tanker.getName() + ": ");
        formatOut(tanker.formatShowState());
        tanker.setFullOfCargo();
        formatOut(tanker.formatShowState());
        tanker.setOilFulled();
        formatOut(tanker.formatShowState());
        tanker.refuel();
        formatOut(tanker.formatShowState());
        tanker.setInThePort(false);
        formatOut(tanker.formatShowState());
        tanker.setStanding(true);
        formatOut(tanker.formatShowState());
        tanker.setEmpty(true);
        formatOut(tanker.formatShowState());

        PassengerShip passengerShip = new PassengerShip("beda", 234);
        System.out.println("\n" + passengerShip.getName() + ": ");
        formatOut(passengerShip.formatShowState());
        passengerShip.setFullOfCargo();
        formatOut(passengerShip.formatShowState());
        passengerShip.refuel();
        formatOut(passengerShip.formatShowState());
        passengerShip.setInThePort(false);
        formatOut(passengerShip.formatShowState());
        passengerShip.setStanding(true);
        formatOut(passengerShip.formatShowState());
        passengerShip.setPassengersCount();
        formatOut(passengerShip.formatShowState());

        System.out.println("\nРезультат работы toString: " + passengerShip);
    }
}
