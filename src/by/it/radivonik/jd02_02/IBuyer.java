package by.it.radivonik.jd02_02;

/**
 * Created by Radivonik on 31.03.2017.
 * Интерфейс, определяющий функционал покупателя
 */
public interface IBuyer {
    void enterToMarket(); // вход в магазин
    void chooseGoods();   // выбор товара
    void goToQueue();     // постановка в очередь
    void goToOut();       // выход из магазина
}
