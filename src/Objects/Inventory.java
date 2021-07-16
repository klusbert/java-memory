package Objects;

import Addresses.AddressIdentifier;
import Util.Memory;

public class Inventory {
    private Client client;
    private Memory memory;

    public Inventory(Client _client) {
        this.client = _client;
        this.memory = client.getMemory();
    }

    public int getInventoryCount() {
        return memory.readInt(client.getAddress(AddressIdentifier.INVENTORY));
    }
}
