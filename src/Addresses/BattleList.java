package Addresses;

import Util.MemoryScanner;

import java.util.List;
import java.util.Map;

public class BattleList implements IAddress {
    @Override
    public void scan(MemoryScanner _memoryScanner, Map<AddressIdentifier, Long> addresses) {
        List<Long> result = _memoryScanner.scanInt(26819664, true);
        if (result.size() != 1) {
            System.out.println("Error finding player Battlelist address");
        }
        long baseAddress = result.get(0);


        System.out.println("battlelist start" + String.format("0x%08X", baseAddress + 0x30));
        System.out.println("battlelist count" + String.format("0x%08X", baseAddress + 0x38));
        addresses.put(AddressIdentifier.BATTLELIST_COLLECTION_START, baseAddress + 0x30);

        addresses.put(AddressIdentifier.BATTLELIST_COUNT, baseAddress + 0x38);

        addresses.put(AddressIdentifier.RED_SQUARE, baseAddress + 0x4C);
    }
}
