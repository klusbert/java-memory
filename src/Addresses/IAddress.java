package Addresses;

import Util.MemoryScanner;

import java.util.Map;

public interface IAddress {
    public void scan(MemoryScanner _memoryScanner, Map<AddressIdentifier, Long> addresses);

}
