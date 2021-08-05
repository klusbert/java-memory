package Addresses;

import Util.MemoryScanner;

import java.util.List;
import java.util.Map;

public class BattleList implements IAddress {
    @Override
    public void scan(MemoryScanner _memoryScanner, Map<AddressIdentifier, Long> addresses) {
        List<Long> result = _memoryScanner.scanInt(26823760, true);
        if (result.size() != 1) {
            System.out.println("Error finding player Battlelist address");
        }
        long baseAddress = result.get(0);


        addresses.put(AddressIdentifier.BATTLELIST_COLLECTION_START, baseAddress + 0x30);
        addresses.put(AddressIdentifier.BATTLELIST_COUNT, baseAddress + 0x38);
        addresses.put(AddressIdentifier.TARGET_HOVER, baseAddress + 0x44);
        addresses.put(AddressIdentifier.RED_SQUARE, baseAddress + 0x4C);
    }
}
