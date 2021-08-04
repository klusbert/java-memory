package Addresses;

import Util.MemoryScanner;

import java.util.List;
import java.util.Map;

public class Inventory implements IAddress {


    @Override
    public void scan(MemoryScanner _memoryScanner, Map<AddressIdentifier, Long> addresses) {
        List<Long> result = _memoryScanner.scanInt(26887504, true);
        if (result.size() != 1) {
            System.out.println("Error finding player Inventory address");
        }
        long baseAddress = result.get(0);

        addresses.put(AddressIdentifier.INVENTORY, baseAddress + 0xB0);

        System.out.println("Inventory start" + String.format("0x%08X", baseAddress + 0xB0));

    }
}
