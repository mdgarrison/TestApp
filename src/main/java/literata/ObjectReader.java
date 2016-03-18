package literata;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.Inflater;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.ByteBuffer;
import java.util.*;

public class ObjectReader {
    Path indexPath;
    int arrayNdx = 0;
    FileInputStream mInputStream = null;
    byte[] streamData;
    String signature;
    Integer version;
    Integer numEntries;
    String extensionSignature;
    Integer extensionSize;
    List<IndexEntry> mIndexEntryList = new ArrayList<IndexEntry>();
    
    public ObjectReader() {
        System.out.println("ObjectReader()");
        acquireObjectPath("Howdy");
        readObjectFile();
    }
    
    private void acquireObjectPath(String sha1String) {
        try {
            indexPath = Paths.get(".git/objects/1b/cf6039140c302e21caa62a406f30cd6cf19bb2");
            System.out.println("Found the object!");
        }
        catch (Exception e) {
            System.out.println("Didn't find the object");
        }
    }

    private void readObjectFile() {
        try {
            streamData = Files.readAllBytes(indexPath);
            System.out.println("Fetched the object!");
            System.out.println("Length = " + streamData.length);
            Inflater decompressor = new Inflater();
            decompressor.setInput(streamData, 0, streamData.length);
            byte[] result = new byte[1000];
            int resultLength = decompressor.inflate(result);
            decompressor.end();
            System.out.println("Decompressed Length = " + resultLength);
            String outputString = new String(result, 0, resultLength, "UTF-8");
            IndexUtilities.dumpArrayBytes(result, 0);
        }
        catch (IOException ioe) {
        }
        catch (java.util.zip.DataFormatException dfe) {
        }
    }
}
