package by.it.prigozhanov.jd02_01;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by v-omf on 3/31/2017.
 *
 * @author v-omf
 */
public class Basket {
    private int buyerNumber;
    private int goodCounter=0;
    private List<Good> bascketList = new ArrayList<>();

    public Basket(int num) {
        buyerNumber = num;
    }

    void putGoodToBucket(Good good) {
        bascketList.add(good);
        System.out.println("( Покупатель № " + buyerNumber +" ) " + "положил в корзину продукт: " + good.getName() + " цена: " + good.getPrice() + "$");
        goodCounter++;
    }



    @Override
    public String toString() {
        return bascketList.toString();
    }

}
