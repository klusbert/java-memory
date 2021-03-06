package Objects;

import Addresses.AddressIdentifier;
import Addresses.PlayerExperience;
import Util.Memory;

public class Player extends Creature {
    private Client client;
    private Memory memory;


    public Player(Client _client, long address, long id) {
        super(_client, address, id);
        this.client = _client;
        this.memory = client.getMemory();
    }


    public Location getLocation() {
        long x = client.getAddress(AddressIdentifier.PLAYER_X);
        long y = client.getAddress(AddressIdentifier.PLAYER_Y);
        long z = client.getAddress(AddressIdentifier.PLAYER_Z);

        return new Location(memory.readInt(x), memory.readInt(y), memory.readInt(z));
    }

    public Integer getExperience() {
        return memory.readInt(client.getAddress(AddressIdentifier.PLAYER_EXPERIENCE));
    }

    public Integer getFoodStatus() {
        return memory.readInt(client.getAddress(AddressIdentifier.FOOD));
    }

    public Integer getPlayerLevel() {
        return memory.readInt(client.getAddress(AddressIdentifier.PLAYER_LEVEL));
    }

    public Integer getRedSquare() {
        return memory.readInt(client.getAddress(AddressIdentifier.RED_SQUARE));
    }
}
