package by.it.Zyryanov.jd02_02;


import java.util.ArrayList;
import java.util.List;

public class Basket {

    List<Good> listOfGoodsInBasket = new ArrayList<>();

    public double receipt;

    void takeBasket(){
        Runner.numberOfBaskets--;
        System.out.println("корзинок осталось: " + Runner.numberOfBaskets);
        int sleepTime = Helper.getRandom(100, 200);
        Helper.sleep(sleepTime);
    }



    void putGoodsintoBasket(Good good){
        listOfGoodsInBasket.add(good);
        System.out.println("положил " + good + " в корзинку");
    }


    void sumOfGoods(Good good){
        receipt = receipt + good.getPrice();
    }

    public double getReceipt() {
        return receipt;
    }

    public List<Good> getListOfGoodsInBasket() {
        return listOfGoodsInBasket;
    }
}
