package by.it.zagursky.jd02_03.src.buyer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by dzenyaa on 31.03.2017.
 */
public class Backet {
    private  final  Deque<Good> products=new ArrayDeque<>();

    String name;
    Backet(int name )
    {
        this.name="корзина №"+name;
    }
    void put_g(Good good)
    {
        products.addLast(good);
    }
    Good exist_g()
    {
        return products.pollFirst();
    }
    int get_count( ){return products.size();}


}
