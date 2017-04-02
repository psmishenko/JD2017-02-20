package by.it.radivonik.jd02_01;

/**
 * Created by Radivonik on 29.03.2017.
 * Интерфейс, определяющий функционал покупателя
 */
public interface IBuyer {
    void enterToMarket(); // вход в магазин
    void chooseGoods();   // выбор товара
    void goToOut();       // выход из магазина
}
