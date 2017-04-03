package by.it.loktev.jd02_03;

public interface IUseBacket {

    void takeBacket(); // взял корзину

    void putGoodToBacket(Good good, double quantity); // положил выбранный товар в корзину

    void backBacket(); // взял корзину

    double getBacketPrice();

}
