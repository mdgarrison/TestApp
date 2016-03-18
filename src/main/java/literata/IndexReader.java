package literata;

import java.io.FileInputStream;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.ByteBuffer;
import java.util.*;

public class IndexReader {
    Path indexPath;
    int arrayNdx = 0;
    FileInputStream InputStream = null;
    byte[] streamData;
    String signature;
    Integer version;
    Integer numEntries;
    String extensionSignature;
    Integer extensionSize;
    List<IndexEntry> mIndexEntryList = new ArrayList<IndexEntry>();
    
    public IndexReader() {
        
        System.out.println("IndexReader()");
        processIndex();
    }
    
    private void acquireIndexPath() {
        try {
            indexPath = Paths.get(".git/index");
            System.out.println("Found the index!");
        }
        catch (Exception e) {
            System.out.println("Didn't find the index");
        }
    }

    private void readIndexFile() {
        try {
            streamData = Files.readAllBytes(indexPath);
            System.out.println("Fetched the index!");
            System.out.println("Length = " + streamData.length);
        }
        catch (IOException ioe) {
        }
    }
        
    private void processIndex() {
        acquireIndexPath();
        readIndexFile();
        parseIndex();
    }

     private void parseIndex() {
        arrayNdx = parseIndexSignature(arrayNdx);
        arrayNdx = parseVersion(arrayNdx);
        arrayNdx = parseNumEntries(arrayNdx);
        arrayNdx = parseEntries(arrayNdx, numEntries);
    }

   private int parseIndexSignature(int ndx) {
        signature = String.format("%c%c%c%c", streamData[ndx], streamData[ndx + 1], streamData[ndx + 2], streamData[ndx + 3]);
        System.out.println(String.format(" Signature: %s", signature));
        return ndx + 4;
    }

    private int parseVersion(int ndx) {
        version = IndexUtilities.arrayBytesToInt(streamData, ndx);
        System.out.println(String.format("   Version: %d", version));
        return ndx + 4;
    }

    private int parseNumEntries(int ndx) {
        numEntries = IndexUtilities.arrayBytesToInt(streamData, ndx);
        System.out.println(String.format("NumEntries: %s", numEntries));
        return ndx + 4;
    }
                
    private int parseEntries(int ndx, int count) {
        for (int i = 0; i < count; i++) {
            IndexEntry ie = new IndexEntry();
            ie.parse(streamData, ndx);
            ndx += ie.entrySize;
        }
        System.out.println(String.format("Processed %d entries", count));
        return ndx;
    }
}
