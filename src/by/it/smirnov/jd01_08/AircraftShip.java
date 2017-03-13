package by.it.smirnov.jd01_08;

/**
 * Класс Авианосец (AbstractShip + IRunWay)
 */
public class AircraftShip extends AbstractShip implements IRunWay {
    private double runwayLength; // длина взлетнопосадочной полосы
    private double runwayWidth; // ширина взлетнопосадочной полосы
    private boolean lighting; // освещение взлетнопосадочной полосы

    public AircraftShip (String name, int yearOfConstruction, double length, double width, double capacity,
                         double runwayLength, double runwayWidth) {
        super(name, yearOfConstruction, length, width, capacity);
        this.runwayLength = runwayLength;
        this.runwayWidth = runwayWidth;
    }

    public double getRunwayLength(){  // длина взлетнопосадочной полосы
        return runwayLength;
    }
    public double getRunwayWidth(){  // ширина взлетнопосадочной полосы
        return runwayWidth;
    }

    public void runwayLightingOn(){ // включить освещение взлетнопосадочной полосы
        lighting = true;
    }

    public void runwayLightingOff(){ // выключить освещение взлетнопосадочной полосы
        lighting = false;
    }

    public String getRunwayLighting(){  // отчет о состоянии освещения взлетнопосадочной полосы
        return "Освещение взлетно-посадочной полосы " + (lighting ? "включено" : "отключено");
    }

    @Override
    public String toString() {
        return String.format("Авианесущий крейсер: %s%nГод постройки: %d%nВозраст, лет: %d",
                getShipName(), getShipYearOfConstruction(),getShipAge());
    }

    @Override
    public String getShipState() { // отчет об состоянии судна
        int motion = getShipMotion();
        return String.format("Авианесущий крейсер под названием \"%s\" %d года постройки (длина: %6.2fм; ширина: %6.2fм) %s. %s.%n",
                getShipName(), getShipYearOfConstruction(), getShipLength(), getShipWidth(),
                (motion == 0) ? "стоит на месте" : (motion == 1) ? "движется вперед" : "движется назад" ,
                getRunwayLighting());
    }


}
