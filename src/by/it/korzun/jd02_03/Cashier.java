package by.it.korzun.jd02_03;

public class Cashier implements Runnable{
    private String name;
    int num;

    public Cashier(int number) {
        name = "Кассир №" + number + " ";
        num = number - 1;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void run() {
        Buyer b;
        System.out.println(this + " открыл кассу");
        Dispatcher.openedCashiers[num] = "Открыта";
        Dispatcher.getStatus();
        while ((b = QueueBuyers.extract()) != null){
            System.out.println(this + " обслуживается: " + b);
            int timeout = Helper.getRandom(2000, 5000);
            Helper.sleep(timeout, false);
            synchronized (b){
                b.setiWait(false);
                b.notify();
            }
            System.out.println(this + " завершил обслуживание: " + b);
            synchronized (b) {
                System.out.println(Helper.sep);
                System.out.printf("Чек: %s:\n", b);
                double sum = 0;
                for (int i = 0; i < b.listOfGoods.size(); i++) {
                    System.out.printf("%-10s -   %-3.2f\n", b.listOfGoods.get(i).getName(), b.listOfGoods.get(i).getPrice());
                    sum += b.listOfGoods.get(i).getPrice();
                }
                System.out.printf("Сумма: %.2f\n", sum);
                Dispatcher.profit += sum;
                System.out.println(Helper.sep);
            }
        }
        System.out.println(this + " закрыл кассу");
        Dispatcher.openedCashiers[num] = "Закрыта";
        Dispatcher.getStatus();
        Dispatcher.cashiers.remove(Thread.currentThread());

    }
}
