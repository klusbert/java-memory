package Util;

import com.sun.jna.Library;
import com.sun.jna.Native;

import java.io.FileNotFoundException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;

public class Memory {
    interface CLibrary extends Library {
        static CLibrary clib = (CLibrary) Native.loadLibrary("c", CLibrary.class);

        int open(CharSequence path, int flags, int perm);

        int lseek(int fd, long offset, int whence);

        int read(int fd, byte[] buf, int n);
    }

    private int _linuxProcess;
    private int _processId;

    public Memory(int processId) {
        _processId = processId;
        _linuxProcess = CLibrary.clib.open("/proc/" + processId + "/mem", 2, 0);

    }

    public byte[] readBytes(long address, int length) {

        byte[] buffer = new byte[length];
        CLibrary.clib.lseek(_linuxProcess, address, 0);
        CLibrary.clib.read(_linuxProcess, buffer, length);

        return buffer;
    }

    /**
     * Read single byte from destination address.
     *
     * @param address
     * @return
     */
    public byte readByte(long address) {
        return readBytes(address, 1)[0];
    }

    /**
     * Read short(2 bytes) from destination address.
     *
     * @param address
     * @return
     */
    public int readShort(long address) {
        byte[] buffer = readBytes(address, 2);

        ByteBuffer wrapped = ByteBuffer.wrap(buffer);
        wrapped.order(ByteOrder.LITTLE_ENDIAN);

        return wrapped.getShort();
    }

    /**
     * Read int(4 bytes) from destination address.
     *
     * @param address
     * @return
     */
    public int readInt(long address) {
        byte[] buffer = readBytes(address, 4);

        ByteBuffer wrapped = ByteBuffer.wrap(buffer);
        wrapped.order(ByteOrder.LITTLE_ENDIAN);

        return wrapped.getInt();

    }

    /**
     * Read long(8 bytes) from destination address.
     *
     * @param address
     * @return
     */
    public long readLong(long address) {
        byte[] buffer = readBytes(address, 8);
        ByteBuffer wrapped = ByteBuffer.wrap(buffer);
        wrapped.order(ByteOrder.LITTLE_ENDIAN);

        return wrapped.getLong();
    }

}
