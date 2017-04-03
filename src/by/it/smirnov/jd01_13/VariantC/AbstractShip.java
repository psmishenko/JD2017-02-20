package by.it.smirnov.jd01_13.VariantC;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Абстрактный класс корабля
 */
public class AbstractShip implements IShip {
    private String name;  // наименование судна
    private int yearOfConstruction;  // год постройки
    private double length;  // длина судна
    private double width;  // ширина судна
    private double capacity;  // грузоподъемность судна, т.
    private int motion;  // статус движения судна
    private boolean isUpAnchor;

    public AbstractShip (String name, int yearOfConstruction, double length, double width, double capacity) {
        this.name = name;
        this.yearOfConstruction = yearOfConstruction;
        this.length = length;
        this.width = width;
        this.capacity = capacity;
        this.motion = 0;
        this.isUpAnchor = true;
    }

    public String getShipName(){ // наименование судна
        return name;
    }

    public int getShipYearOfConstruction(){  // год постройки
        return yearOfConstruction;
    }

    public int getShipAge(){  // возраст судна
        return (new GregorianCalendar().get(Calendar.YEAR)) - yearOfConstruction;
    }

    public double getShipLength(){  // длина судна
        return length;
    }

    public double getShipWidth(){  // ширина судна
        return width;
    }

    public double getShipCapacity(){  // грузоподъемность судна, т.
        return capacity;
    }

    public int getShipMotion(){  // статус движения судна
        return motion;
    }

    public boolean getUpAnchor(){  // грузоподъемность судна, т.
        return isUpAnchor;
    }

    public String getShipState() { // отчет об состоянии судна
      return String.format("Судно под названием \"%s\" %d года постройки (длина: %6.2fм; ширина: %6.2fм; грузоподъемность: %6.2fт) %s, якорь %s.%n",
              name, yearOfConstruction, length, width, capacity,
              (motion == 0) ? "стоит на месте" : (motion == 1) ? "движется вперед" : "движется назад",
              (isUpAnchor) ? "поднят" : "опущен");
    }

    public void forward() throws AnchorException{ // начать движение вперед
        if (!isUpAnchor) throw new AnchorException("Приведение корабля в движение невозможно. Поднимите якорь.");
        motion = 1;
    }

    public void backward() throws AnchorException{ // начать движение назад
        if (!isUpAnchor) throw new AnchorException("Приведение корабля в движение невозможно. Поднимите якорь.");
        motion = -1;
    }

    public void stop(){ // остановить судно
        motion = 0;
    }

    public void downAnchor() throws AnchorException{
        if (motion!=0) throw new AnchorException("Действие c якорем невозможно. Корабль в движении.");
        isUpAnchor = false;
    }

    public void upAnchor(){
        isUpAnchor = true;
    }

    @Override
    public String toString() {
        return String.format("Название судна: %s%nГод постройки: %d",
                        name, yearOfConstruction);
    }

}
