package Objects;

import Addresses.AddressIdentifier;
import Addresses.AddressScanner;
import Util.Memory;
import Util.MemoryScanner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Client {
    private Memory memory;
    private MemoryScanner memoryScanner;

    private AddressScanner addressScanner;
    private Map<AddressIdentifier, Long> addresses;
    private Player player;
    private Inventory inventory;
    private BattleList battleList;


    public Client(int _tibiaPid) {
        memory = new Memory(_tibiaPid);
        memoryScanner = new MemoryScanner(_tibiaPid);

        addresses = new HashMap<AddressIdentifier, Long>();
        addressScanner = new AddressScanner(memoryScanner, addresses);


        player = new Player(this);
        inventory = new Inventory(this);
        battleList = new BattleList(this);

    }

    public long getAddress(AddressIdentifier identifier) {
        return addresses.get(identifier);
    }

    public Memory getMemory() {
        return memory;
    }

    public Player getPlayer() {
        return player;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public BattleList getBattleList() {
        return battleList;
    }

    public static List<Client> getClients() {


        Process process = null;
        try {
            process = Runtime.getRuntime().exec("ps -o command");
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader r = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line = null;

        while (true) {
            try {
                if (!((line = r.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(line);
        }

        return null;
    }

}
