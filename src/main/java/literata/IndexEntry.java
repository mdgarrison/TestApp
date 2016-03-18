package literata;

import java.io.FileInputStream;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.ByteBuffer;

public class IndexEntry {
    public int cTimeSeconds;
    public int cTimeNanoSecondFractions;
    public int mTimeSeconds;
    public int mTimeNanoSecondFractions;
    public int dev;
    public int ino;
    public int mode;
    public int uid;
    public int gid;
    public int fileSize;
    public String sha1;
    public short flags;
    public String pathName;
    public int pathNameLength = 0;
    public int initialArrayIndex = 0;
    public int arrayIndex = 0;
    public int indexOffset = 0;
    public int entrySize = 0;
    public int padSize = 0;
    
    public IndexEntry() {
    }
    
    public int parse(byte[] bArray, int ndx) {
        int result = 0;
        initialArrayIndex = ndx;
        arrayIndex = initialArrayIndex;
        cTimeSeconds = IndexUtilities.arrayBytesToInt(bArray, arrayIndex);
        arrayIndex += 4;
        cTimeNanoSecondFractions = IndexUtilities.arrayBytesToInt(bArray, arrayIndex);
        arrayIndex += 4;
        mTimeSeconds = IndexUtilities.arrayBytesToInt(bArray, arrayIndex);
        arrayIndex += 4;
        mTimeNanoSecondFractions = IndexUtilities.arrayBytesToInt(bArray, arrayIndex);
        arrayIndex += 4;
        dev = IndexUtilities.arrayBytesToInt(bArray, arrayIndex);
        arrayIndex += 4;
        ino = IndexUtilities.arrayBytesToInt(bArray, arrayIndex);
        arrayIndex += 4;
        mode = IndexUtilities.arrayBytesToInt(bArray, arrayIndex);
        arrayIndex += 4;
        uid = IndexUtilities.arrayBytesToInt(bArray, arrayIndex);
        arrayIndex += 4;
        gid = IndexUtilities.arrayBytesToInt(bArray, arrayIndex);
        arrayIndex += 4;
        fileSize = IndexUtilities.arrayBytesToInt(bArray, arrayIndex);
        arrayIndex += 4;
        sha1 = IndexUtilities.arrayBytesToSha1String(bArray, arrayIndex);
        arrayIndex += 20;
        flags = IndexUtilities.arrayBytesToShort(bArray, arrayIndex);
        arrayIndex += 2;
        pathName = IndexUtilities.arrayBytesToString(bArray, arrayIndex);
        System.out.println(String.format("%s 0x%04x %s", sha1.toLowerCase(), flags, pathName));
        arrayIndex += pathName.length();
        
        padSize = IndexUtilities.indexPaddingLength(initialArrayIndex, arrayIndex);
        arrayIndex += padSize;
        entrySize = 62 + pathName.length() + padSize;
        return arrayIndex;
    }
    
    
}
