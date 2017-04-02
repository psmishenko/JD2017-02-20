package by.it.smirnov.jd02_01;

/**
 * Интерфейс покупателя
 */
public interface IBuyer {
    /**
     * Вошел в магазин
     */
    void enterToMarket();
    /**
     * Делает покупки
     */
    void chooseGood();
    /**
     * Встал в очередь
     */
    void gotoQueue();
    /**
     * Вышел из магазина
     */
    void goToOut();

}
