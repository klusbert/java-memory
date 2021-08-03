package Objects;

import Addresses.AddressIdentifier;
import Util.Memory;

import java.nio.charset.StandardCharsets;

public class Creature {

    private long address;
    private Client client;
    private long id;
    private Memory memory;

    public Creature(Client _client, long _address, long _id) {
        this.client = _client;
        this.address = _address;
        this.id = _id;
        this.memory = client.getMemory();
    }

    public Location getLocation() {
        int x = memory.readInt(address + 0x40);
        int y = memory.readInt(address + 0x44);
        int z = memory.readInt(address + 0x48);
        return new Location(x, y, z);
    }

    public String getName() {
        int nameStruct = memory.readInt(address + 0x30);
        return memory.readQString(nameStruct);
    }

    public void fullLight() {

        System.out.println("ligh " + String.format("0x%08X", address + 0x60));
        memory.writeInt(address + 0x60, 27);
        memory.writeBytes(address + 0x60 + 0xC, new byte[]{-1, -1, -1, -1, -1, -1});

    }

    @Override
    public String toString() {
        return "Creature{" +
                "id=" + id + ", " +
                "address=" + String.format("0x%08X", address) + ", " +
                "name=" + getName() + ", " +
                "location" + getLocation() +
                '}';
    }
}
