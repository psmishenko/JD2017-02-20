package by.it.korzun.jd01_08;

public class PassengerShip extends CargoShip{
    private int passengersCount;
    PassengerShip(String name, int passengersCount){
        super(name);
        this.passengersCount = passengersCount;
    }

    void setPassengersCount() {
        this.passengersCount = 0;
    }

    @Override
    public void showState() {
        System.out.println(this);
    }

    @Override
    public String[] formatShowState() {
        String []mass = super.formatShowState();
        if(this.passengersCount != 0)
            mass[4] = "На корабле " + this.passengersCount + " пассажиров";
        else
            mass[4] = "На корабле нет пассажиров";
        return mass;
    }

    @Override
    public String toString() {
        String sSwimming;
        if (this.isInThePort())
            sSwimming = "В порту";
        else
            sSwimming = "В пути";

        String sStanding;
        if(this.isStanding())
            sStanding = "Остановился";
        else
            sStanding = "В движении";

        String sFueled;
        if(this.isFueled())
            sFueled = "Заправлен";
        else
            sFueled = "Не заправлен";

        String sFullOfCargo;
        if(this.isFullOfCargo())
            sFullOfCargo = "Полностью загружен";
        else {
            if(isEmpty())
                sFullOfCargo = "Абсолютно пуст";
            else
                sFullOfCargo = "Не полностью загружен";
        }

        String sPassengersCount;
        if(this.passengersCount != 0)
            sPassengersCount = "На корабле " + this.passengersCount + " пассажиров";
        else
            sPassengersCount = "На корабле нет пассажиров";

        return sSwimming + ", " + sStanding + ", " + sFueled + ", " + sPassengersCount + ", " + sFullOfCargo;
    }
}
