package Util;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemoryScanner {
    private List<MemoryRegion> _memoryRegions = new ArrayList<>();
    private int _processId;
    private Memory _memory;

    public MemoryScanner(int processId) {
        this._processId = processId;
        this._memory = new Memory(processId);

        try {
            this.enumerateModules();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    private void enumerateModules() throws FileNotFoundException {
        File myObj = new File("/proc/" + _processId + "/maps");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String line = myReader.nextLine();
            String[] attr = line.split(" ");
            if (attr[1].contains("r") && attr[1].contains("w")) {

                String[] region = attr[0].split("-");

                MemoryRegion memoryRegion = new MemoryRegion(region[0], region[1]);
                memoryRegion.storeMemoryBuffer(_memory);
                _memoryRegions.add(memoryRegion);
            }

        }
    }


    public List<Long> scanInt(int value) {
        return scanInt(value, false);
    }

    public List<Long> scanInt(int value, boolean stopAfterFirstResult) {
        ByteBuffer dbuf = ByteBuffer.allocate(4);
        dbuf.order(ByteOrder.LITTLE_ENDIAN);
        dbuf.putInt(value);

        byte[] bytes = dbuf.array();
        return this.scanBytes(bytes, stopAfterFirstResult);
    }


    public List<Long> scanBytes(byte[] value) {
        return scanBytes(value, false);
    }

    public List<Long> scanBytes(byte[] value, boolean stopAfterFirstResult) {
        List<Long> results = new ArrayList<>();
        for (MemoryRegion m : _memoryRegions) {

            byte[] buffer = m.getMemoryBuffer();
            int len = value.length;
            int end = buffer.length - len;

            for (int i = 0; i < end; ++i) {
                int j = 0;
                for (; j < len && buffer[i + j] == value[j]; ++j) ;
                if (j == len) {
                    results.add(m.getStartAddress() + i);
                    // stop scan if we found one result :)
                    if (stopAfterFirstResult)
                        return results;
                }
            }
        }

        return results;
    }
}
