package Objects;

import Util.Memory;

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




        return "";
    }


}
