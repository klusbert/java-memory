package Objects;

import Addresses.AddressIdentifier;
import Addresses.AddressScanner;
import Util.Memory;
import Util.MemoryScanner;

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


    public Client(int _tibiaPid) {
        memory = new Memory(_tibiaPid);
        memoryScanner = new MemoryScanner(_tibiaPid);

        addresses = new HashMap<AddressIdentifier, Long>();
        addressScanner = new AddressScanner(memoryScanner, addresses);


        player = new Player(this);
        inventory = new Inventory(this);

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

    public static List<Client> getClients() {


        return null;
    }

}
