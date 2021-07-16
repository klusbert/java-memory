package Addresses;

import Util.MemoryScanner;

import java.util.List;
import java.util.Map;

public class Inventory implements IAddress {


    @Override
    public void scan(MemoryScanner _memoryScanner, Map<AddressIdentifier, Long> addresses) {
        List<Long> result = _memoryScanner.scanInt(26883408, true);
        if (result.size() != 1) {
            System.out.println("Error finding player Inventory address");
        }
        long baseAddress = result.get(0);

        addresses.put(AddressIdentifier.INVENTORY, baseAddress + 0xB0);
    }
}