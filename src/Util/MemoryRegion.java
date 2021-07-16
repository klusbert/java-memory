package Util;

public class MemoryRegion {
    private long startAddress;
    private long endAddress;


    private byte[] memoryBuffer;


    public MemoryRegion(String start, String end) {

        startAddress = Long.parseLong(start, 16);
        endAddress = Long.parseLong(end, 16);
    }

    public void storeMemoryBuffer(Memory memory) {

        this.memoryBuffer = memory.readBytes(this.getStartAddress(), this.getSize());
    }

    public long getStartAddress() {
        return startAddress;
    }

    public long getEndAddress() {
        return endAddress;
    }

    public int getSize() {
        return (int) (endAddress - startAddress);
    }

    public byte[] getMemoryBuffer() {
        return memoryBuffer;
    }

}
