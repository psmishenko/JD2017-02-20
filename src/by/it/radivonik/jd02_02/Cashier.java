package by.it.radivonik.jd02_02;

/**
 * Created by Radivonik on 31.03.2017.
 * Класс, реализующий функционал кассира
 */
public class Cashier extends Thread {
    private int num;

    public Cashier(int num) {
        super("Кассир № " + num);
        this.num = num;
    }

    @Override
    public void run() {
        Buyer b;
        System.out.print(getState(this + " открыл кассу",true));
        while ((b = QueueBuyers.extract()) != null) {
//            System.out.println(this + " обслуживает " + b);
            synchronized (b) {
                Helper.sleep(Helper.getRandom(2000,5000));
                String check = getState(this.toString(),false) + getState("ЧЕК " + b + ":",false);
                double itogo = 0;
                for (Good good: b.goods) {
                    check = check + getState(String.format("%-15s %6.2f",good.getName(),good.getPrice()),false);
                    itogo += good.getPrice();
                }
                Dispatcher.addSumItogo(itogo);
                check = check + getState(String.format("%-15s %6.2f","ИТОГО",itogo),true);
                System.out.print(check);
                b.notify();
            }
//            System.out.println(this + " завершил обслуживание " + b);
            if (! Dispatcher.isCashierCanBuyer(this))
                break;
        }
        System.out.print(getState(this + " закрыл кассу",true));
    }

    @Override
    public String toString() {
        return getName();
    }

    private String getState(String str, boolean printExt) {
        String res;
        int n = (num-1) % 5;
        String[] strArg = new String[7];
        for (int i = 0; i < strArg.length; i++)
            strArg[i] = " ";
        strArg[n] = str;
        if (printExt) {
            strArg[5] = "В очереди: " + QueueBuyers.getCount();
            strArg[6] = "Общая выручка: " + String.format("%7.2f", Dispatcher.getSumItogo());
        }
        res = String.format("%-25s%-25s%-25s%-25s%-25s%-20s%-20s\n",strArg[0],strArg[1],strArg[2],strArg[3],strArg[4],strArg[5],strArg[6]);
        return res;
    }

    public int getNum() {
        return num;
    }
}
