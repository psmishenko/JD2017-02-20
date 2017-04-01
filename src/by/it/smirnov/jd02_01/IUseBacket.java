package by.it.smirnov.jd02_01;

/**
 * Интерфейс использование корзинки
 */
public interface IUseBacket {
    /**
     * Взял корзинку
     */
    void takeBacket();
    /**
     * Положил в корзинку товар
     * @param good товар
     */
    void putGoodsToBacket(Good good);
    /**
     * Вернул корзинку
     */
    void backBacket();
}
