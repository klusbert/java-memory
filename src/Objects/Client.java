package Objects;

import Addresses.AddressIdentifier;
import Addresses.PlayerLocation;
import Util.Memory;
import Util.MemoryScanner;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Client {
    private Memory memory;
    private MemoryScanner memoryScanner;

    public PlayerLocation playerLocation;
    private Map<AddressIdentifier, Long> addresses;

    public Client(int _tibiaPid) {
        memory = new Memory(_tibiaPid);
        memoryScanner = new MemoryScanner(_tibiaPid);

        addresses = new HashMap<AddressIdentifier, Long>();
        playerLocation = new PlayerLocation(memoryScanner, addresses);

    }


    public Memory getMemory() {
        return memory;
    }
}
