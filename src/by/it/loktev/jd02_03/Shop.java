package by.it.loktev.jd02_03;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Shop {

    static public AtomicBoolean opened=new AtomicBoolean(); // открыт ли магазин сейчас
    static public AtomicInteger buyersCount=new AtomicInteger(); // количество покупателей сейчас в магазине
    static public volatile double totalPrice2; // общая сумма покупок (касса магазина)

}
