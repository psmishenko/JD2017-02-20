package by.it.prigozhanov.Bank;

/**
 * Created by v-omf on 3/31/2017.
 *
 * @author v-omf
 */
public class Cashier extends Thread {
    private int num;

    public Cashier(int num) {
        super("[ Оператор №: " + num + " ] " );
        this.num = num;
        System.out.println(this + "готов к работе");
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void run() {
        Client client;
        while ((client = ClientsQueue.extract()) != null) {
            System.out.println(this + "выполняет работу");
        }
        System.out.println(this + "закончил работу");
    }
}
