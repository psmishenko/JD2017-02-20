package by.it.smirnov.jd01_13.VariantC;

/**
 * Базовый интерфейс корабля
 */
public interface IShip {
    /**
     * Возвращает наименование судна
     */
    public String getShipName();
    /**
     * Возвращает возраст судна
     */
    public int getShipAge();
    /**
     * Возвращает год постройки
     */
    public int getShipYearOfConstruction();
    /**
     * Возвращает длину судна
     */
    public double getShipLength();
    /**
     * Возвращает ширину судна
     */
    public double getShipWidth();
    /**
     * Возвращает грузоподъемность судна, т.
     */
    public double getShipCapacity();
    /**
     * Отчет об состоянии судна
     */
    public String getShipState();
    /**
     * Возвращает статус движения судна
     */
    public int getShipMotion();

    /**
     * Команда: начать движение вперед
     */
    public void forward() throws AnchorException;
    /**
     * Команда: начать движение назад
     */
    public void backward() throws AnchorException;
    /**
     * Команда: остановить судно
     */
    public void stop();
    /**
     * Команда: бросить якорь
     */
    public void downAnchor() throws AnchorException;
    /**
     * Команда: поднять якорь
     */
    public void upAnchor();
}
