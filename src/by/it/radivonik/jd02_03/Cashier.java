package by.it.radivonik.jd02_03;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by Radivonik on 31.03.2017.
 * Класс, реализующий функционал кассира
 */
public class Cashier implements Runnable {
    private String name;
    private int num;

    public Cashier(int num) {
        name = "Кассир №" + num;
        this.num = num;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void run() {
        Buyer buyer;
        System.out.print(getState(this + " открыл кассу",true));
        while ((buyer = QueueBuyers.extract()) != null || DispatcherCashiers.getCountBuyersComplet() == 0) {
//            System.out.println(this + " обслуживает " + b);
            if ( buyer != null ) {
                synchronized (buyer) {
                    Helper.sleep(Helper.getRandom(2000, 5000));
                    String check = getState(this.toString(), false) + getState("ЧЕК " + buyer + ":", false);
                    double itogo = 0;
                    check = check + getState("------------------------",false);
                    for (Good good : buyer.goods) {
                        check = check + getState(String.format("|%-15s %6.2f|", good.getName(), good.getPrice()), false);
                        itogo += good.getPrice(); // подсчет суммы итого
                    }
                    DispatcherCashiers.addSumItogo(itogo);
                    check = check + getState("------------------------",false);
                    check = check + getState(String.format("|%-15s %6.2f|", "ИТОГО", itogo), true);
                    check = check + getState("------------------------",false);
                    System.out.print(check);
                    DispatcherCashiers.addCountBuyersCoplete(1);
                    buyer.notify();
                }
            }
//            System.out.println(this + " завершил обслуживание " + b);
            if (!DispatcherCashiers.isCashierCanWork(this))
                break;
        }
        DispatcherCashiers.freeCashier(this);
        System.out.print(getState(this + " закрыл кассу",true));
    }

    // Вывод строки состояния с нужными отступами
    private String getState(String str, boolean printExt) {
        String res;
        int n = (num-1) % 5;
        String[] strArg = new String[9];
        for (int i = 0; i < strArg.length; i++)
            strArg[i] = " ";
        strArg[n] = str;
        if (printExt) {
            strArg[5] = "В очереди: " + QueueBuyers.getCount();
            strArg[6] = "Касс: " + DispatcherCashiers.getCountCashiersWork();
            strArg[7] = "Выбирают товар: " + DispatcherBuyers.getCountBuyersChoosGoods();
            strArg[8] = "Выручка: " + String.format("%7.2f", DispatcherCashiers.getSumItogo());
        }
        res = String.format(
                "%-25s%-25s%-25s%-25s%-25s%-15s%-9s%-19s%-18s\n",
                strArg[0],strArg[1],strArg[2],strArg[3],strArg[4],strArg[5],strArg[6],strArg[7],strArg[8]);
        return res;
    }

    public int getNum() {
        return num;
    }


}
