package Addresses;

import Util.MemoryScanner;

import java.util.List;
import java.util.Map;

public class PlayerLocation {

    private long baseAddress;

    public PlayerLocation(MemoryScanner _memoryScanner, Map<AddressIdentifier, Long> addresses) {

        List<Long> result = _memoryScanner.scanInt(27117968);
        if (result.size() != 1) {
            System.out.println("Error finding player location address");
        }
        baseAddress = result.get(0);

        addresses.put(AddressIdentifier.PLAYER_X, baseAddress + 0x80);
        addresses.put(AddressIdentifier.PLAYER_Y, baseAddress + 0x84);
        addresses.put(AddressIdentifier.PLAYER_Z, baseAddress + 0x88);

    }


}
