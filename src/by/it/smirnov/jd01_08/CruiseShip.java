package by.it.smirnov.jd01_08;

/**
 * Класс Круизный лайнер (от Ship)
 */
public class CruiseShip extends Ship {
    private int countCabins;
    private int countPassenger;
    public CruiseShip (String name, int yearOfConstruction, double length, double width, double capacity,
                       int countCabins, int countPassenger ) {
        super(name, yearOfConstruction, length, width, capacity);
        this.countCabins = countCabins;
        this.countPassenger = countPassenger;
    }

    @Override
    public String toString() {
        return String.format("Круизный лайнер: %s%nГод постройки: %d%nВозраст, лет: %d",
                getShipName(), getShipYearOfConstruction(),getShipAge());
    }

    @Override
    public String getShipState() { // отчет об состоянии судна
        int motion = getShipMotion();
        return String.format("Круизный лайнер под названием \"%s\" %d года постройки (длина: %6.2fм; ширина: %6.2fм; " +
                        "кол-во кают: %d; кол-во пассажиров: %d) %s.%n",
                getShipName(), getShipYearOfConstruction(), getShipLength(), getShipWidth(), countCabins, countPassenger,
                (motion == 0) ? "стоит на месте" : (motion == 1) ? "движется вперед" : "движется назад" );
    }

}
