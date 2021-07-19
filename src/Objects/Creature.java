package Objects;

public class Creature {

    private long address;
    private Client client;

    public Creature(Client _client, long _address) {
        this.client = _client;
        this.address = _address;
    }
}
