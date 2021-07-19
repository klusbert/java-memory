package Objects;

import Addresses.AddressIdentifier;
import Util.Memory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BattleList {

    private Client client;
    private Memory memory;

    public BattleList(Client _client) {
        this.client = _client;
        this.memory = client.getMemory();
    }

    public void readBattleList() {
        int head = memory.readInt(client.getAddress(AddressIdentifier.BATTLELIST_COLLECTION_START));


        System.out.println("Curently " + memory.readInt(client.getAddress(AddressIdentifier.BATTLELIST_COUNT)));

        System.out.println("Root start" + String.format("0x%08X", head));
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> read = new ArrayList<>();
        read.add(head);
        readTreeNode(head, map, read);


        System.out.println(map.size());
    }


    private void readTreeNode(int node, Map<Integer, Integer> map, List<Integer> read) {

        int leftOffset = 0x8;

        int parentOffset = 0x18;
        int rightOffset = 0x10;


        int creatureIDOffset = 0x20;
        int creatureStuctureOffset = 0x28;


        int leftNode = memory.readInt(node + leftOffset);
        int rightNode = memory.readInt(node + rightOffset);
        int parentNode = memory.readInt(node + parentOffset);

        int creatureId = memory.readInt(node + creatureIDOffset);
        int creatureStucture = memory.readInt(node + creatureStuctureOffset);
        byte byte1 = memory.readByte(node);


        if (leftNode > 0 && !read.contains(leftNode)) {
            read.add(leftNode);
            readTreeNode(leftNode, map, read);
        }
        if (rightNode > 0 && !read.contains(rightNode)) {
            read.add(rightNode);
            readTreeNode(rightNode, map, read);
        }
        if (parentNode > 0 && !read.contains(parentNode)) {
            read.add(parentNode);
            readTreeNode(parentNode, map, read);
        }


        if (creatureId > 1000) {
            System.out.println(creatureId);
            map.put(creatureId, creatureStucture);
        }


    }

    public int getBattleListCount() {
        return memory.readInt(client.getAddress(AddressIdentifier.BATTLELIST_COUNT));
    }
}
