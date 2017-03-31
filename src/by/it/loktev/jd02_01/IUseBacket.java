package by.it.loktev.jd02_01;

public interface IUseBacket {

    void takeBacket(); // взял корзину

    void putGoodToBacket(Good good, double quantity); // положил выбранный товар в корзину

    void backBacket(); // взял корзину

    double getBacketPrice();

}
