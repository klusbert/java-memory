package Addresses;

public class Address {
    private long memoryAddress;
    private AddressIdentifier identifier;

    public Address(long _memoryAddress, AddressIdentifier _identifier) {

        this.identifier = _identifier;
        this.memoryAddress = _memoryAddress;
    }
}
