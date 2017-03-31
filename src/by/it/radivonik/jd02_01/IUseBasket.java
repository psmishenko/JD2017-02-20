package by.it.radivonik.jd02_01;

/**
 * Created by Radivonik on 29.03.2017.
 * Интерфейс, определяющий действия с корзиной
 */
public interface IUseBasket {
    void takeBasket();       // взятие корзины
    void putGoodsToBasket(); // помещение выбранного товара в корзину
    void backBasket();       // возврат корзины
}
