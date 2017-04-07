package by.it.smirnov.jd02_03;

import java.util.Set;

/**
 * Класс кассира
 */
public class Cashier extends Thread {
    private String name;
    private Buyer currBuyer;

    public Cashier(int number) {
        name = "Кассир №"+number;
    }

    @Override
    public String toString() {
        return name;
    }
    @Override
    public void run() {
        Buyer b;
        while ((b= QueueBuyers.extract())!=null) {
            System.out.println(this + " обслуживается " + b);
            currBuyer = b;
            Helper.sleep(Helper.getRandom(2000,2000));
            System.out.println(getCheck(b));
            System.out.println(this + " завершил обслуживание " + b);
            currBuyer = null;
            synchronized (b) {
                b.setWait(false);
                b.notify();
            }
        }
        Dispatcher.stopCashier(this);
    }

    /**
     * Имя обслуживаемого покупателя
     * @return имя
     */
    String getBuyerName() {
        return currBuyer == null ? "-" : currBuyer.getName();
    }

    /**
     * Формирование чека покупателя
     * @param buyer покупатель
     * @return чек
     */
    String getCheck(Buyer buyer) {
        StringBuilder sb = new StringBuilder();
        Set<Good> listGoods = buyer.getListGoods();
        sb.append("ЧЕК ("+this+" / "+ buyer.getName() +"):\n");
        sb.append("╔══════════════════════╦═══════════╗\n");
        sb.append("║        ТОВАР         ║ СТОИМОСТЬ ║\n");
        sb.append("╠══════════════════════╬═══════════╣\n");
        Double summ = 0d;
        for (Good good : listGoods) {
            sb.append(String.format("║ %-20s ║ %9.2f ║\n", good.getName(), good.getPrice()));
            summ += good.getPrice();
        }
        sb.append("╠══════════════════════╬═══════════╣\n");
        sb.append(String.format("║ %-20s ║ %9.2f ║\n", "ИТОГО:", summ));
        sb.append("╚══════════════════════╩═══════════╝\n");
        synchronized (Dispatcher.monitorReceipts) {
            Dispatcher.receipts += summ;
        }
        return sb.toString();
    }

}
