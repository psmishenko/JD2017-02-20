package by.it.smirnov.jd01_08;

/**
 * Базовый интерфейс корабля
 */
public interface IShip {
    public String getShipName(); // наименование судна
    public int getShipAge();  // возраст судна
    public int getShipYearOfConstruction();  // год постройки
    public double getShipLength();  // длина судна
    public double getShipWidth();  // ширина судна
    public double getShipCapacity();  // грузоподъемность судна, т.
    public String getShipState(); // отчет об состоянии судна
    public int getShipMotion();  // статус движения судна

    public void forward(); // начать движение вперед
    public void backward(); // начать движение назад
    public void stop(); // остановить судно
}
