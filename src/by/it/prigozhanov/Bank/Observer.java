package by.it.prigozhanov.Bank;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by v-omf on 3/31/2017.
 *
 * @author v-omf
 */
public class Observer extends Thread {
    protected static int plan = 10;
    protected static int currentClientsInBank = 0;
    protected static int numberOfClients = 0;
    protected static int numberOfCashiers=0;

    private List<Cashier>  cashiers = new ArrayList<>();

    @Override
    public void run() {
        while (numberOfClients < plan) {
            if (numberOfCashiers * 5 < ClientsQueue.getSize()) {
                Cashier cashier = new Cashier(numberOfCashiers+1);
                cashier.start();
                cashiers.add(cashier);
                numberOfCashiers++;
            }
        }

    }
}
