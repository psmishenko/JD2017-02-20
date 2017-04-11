package by.it.radivonik.jd02_03;

/**
 * Created by Radivonik on 31.03.2017.
 * Интерфейс, определяющий действия с корзиной
 */
public interface IUseBasket {
    void takeBasket();       // взятие корзины
    void putGoodsToBasket(); // помещение выбранного товара в корзину
    void backBasket();       // возврат корзины
}
