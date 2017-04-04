package by.it.prigozhanov.Bank;

import java.util.ArrayDeque;

/**
 * Created by v-omf on 3/31/2017.
 *
 * @author v-omf
 */
public class ClientsQueue {
    protected static ArrayDeque<Client> clients = new ArrayDeque<>();

    protected static void add(Client client) {
        clients.addLast(client);
    }

    protected static Client extract() {
        return clients.pollFirst();
    }

    protected static int getSize() {
        return clients.size();
    }
}
