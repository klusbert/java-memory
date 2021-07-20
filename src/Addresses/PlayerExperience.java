package Addresses;

import Util.MemoryScanner;

import java.util.List;
import java.util.Map;

public class PlayerExperience implements IAddress {


    @Override
    public void scan(MemoryScanner _memoryScanner, Map<AddressIdentifier, Long> addresses) {
        List<Long> result = _memoryScanner.scanInt(26812944, true);
        if (result.size() != 1) {
            System.out.println("Error finding player location address");
        }

        long baseAddress = result.get(0);
        addresses.put(AddressIdentifier.PLAYER_EXPERIENCE, baseAddress + 0x28);
    }
}
