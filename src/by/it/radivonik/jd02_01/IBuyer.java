package by.it.radivonik.jd02_01;

/**
 * Created by Radivonik on 29.03.2017.
 */
public interface IBuyer {
    void enterToMarket(); // вошел в магазин (мгновенно)
    void chooseGoods(); // выбрал товар (от 0,5 до 2 секунд)
    void goToOut(); // отправился на выход (мгновенно)
}
