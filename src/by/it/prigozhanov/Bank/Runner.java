package by.it.prigozhanov.Bank;

/**
 * Created by v-omf on 3/31/2017.
 *
 * @author v-omf
 */
public class Runner {

    public static void main(String[] args) {
        Client client;
        int num = 1;
        new Observer().start();
        new Inform(1).start();
        while (Observer.numberOfClients < Observer.plan) {
            client = new Client(10000, num);
            client.start();
            Helper.sleep(Helper.getRandom(200, 2000));
            num++;
        }

    }

}
