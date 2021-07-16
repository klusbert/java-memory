package Addresses;

import Util.MemoryScanner;

import java.util.Map;

public class AddressScanner {
    public AddressScanner(MemoryScanner _memoryScanner, Map<AddressIdentifier, Long> addresses) {
        new PlayerLocation().scan(_memoryScanner, addresses);
        new Inventory().scan(_memoryScanner, addresses);
        new PlayerExperience().scan(_memoryScanner, addresses);
    }
}
