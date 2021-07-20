import Addresses.AddressIdentifier;
import Objects.Client;
import Objects.Creature;

import java.util.List;

public class Program {


    private static Client client;

    public static void main(String[] args) {
        int processId = 48764;


        List<Client> clients = Client.getClients();
        if (clients.size() > 0) {
            client = clients.get(0);
            client.selectClient();

            client.getWindowTitle();

            System.out.println(client);

            List<Creature> creatures = client.getBattleList().readBattleList();
            for (Creature c : creatures) {
                System.out.println(c.getLocation());
                c.getName();
            }

        }


    }
}
