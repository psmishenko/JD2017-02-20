package by.it.prigozhanov.Bank;

/**
 * Created by v-omf on 3/31/2017.
 *
 * @author v-omf
 */
public class Client extends Thread implements IClient {
    private double accaunt;

    public Client(double accaunt, int num) {
        super("[ Client №: " + num + " ] ");
        this.accaunt = accaunt;
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void run() {
        enterToBank();
    }

    @Override
    public void enterToBank() {
        Observer.numberOfClients++;
        System.out.println(this + "зашёл в банк");
        ClientsQueue.add(this);
        System.out.println(this + "встал в очередь");
    }

    @Override
    public void withdrow() {

    }

    @Override
    public void addCredit() {

    }

    @Override
    public void transaction() {

    }

    @Override
    public void pay() {

    }

    @Override
    public void exchange() {

    }


    @Override
    public void goOutFromBank() {

    }
}
