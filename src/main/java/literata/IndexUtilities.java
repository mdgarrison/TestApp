package literata;

import java.io.FileInputStream;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class IndexUtilities {
    final protected static char[] hexArray = "0123456789ABCDEF".toCharArray();
    
    public static String byteToHex(byte b) {
        char[] hexChars = new char[2];
        hexChars[0] = hexArray[(b & 0xFF) >>> 4];
        hexChars[1] = hexArray[b & 0x0F];
        
        return new String(hexChars);
    }
    public static Short arrayBytesToShort(byte[] byteArray, int aI) {
        Short result;
        byte[] arrayBytes = { byteArray[aI], byteArray[aI + 1] };
        ByteBuffer wrapped = ByteBuffer.wrap(arrayBytes);
        result = new Short(wrapped.getShort());
        return result;
    }

    public static Integer arrayBytesToInt(byte[] byteArray, int aI) {
        Integer result;
        byte[] arrayBytes = { byteArray[aI], byteArray[aI + 1], byteArray[aI + 2], byteArray[aI + 3] };
        ByteBuffer wrapped = ByteBuffer.wrap(arrayBytes);
        result = new Integer(wrapped.getInt());
        return result;
    }
    
    public static String byteToString(byte b) {
        byte[] temp = new byte[] {b};
        String result = new String(temp, StandardCharsets.UTF_8);
        return result;
    }
    
    public static String arrayBytesToSha1String(byte[] byteArray, int aI) {
        String result;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 20; i++)
        {
            sb.append(byteToHex(byteArray[aI + i]));
        }
        result = sb.toString();
        return result;
    }
    
    public static String arrayBytesToString(byte[] byteArray, int aI) {
        String result;
        StringBuilder sb = new StringBuilder();

        while (byteArray[aI] != 0)
        {
            sb.append((char) byteArray[aI++]);
        }
        result = sb.toString();
        return result;
    }
    
    public static Integer indexPaddingLength(int startNdx, int endNdx) {
        Integer result;
        int curSize = endNdx - startNdx;
        int modSize = curSize % 8;
        int padSize = 8 - modSize;

        result = new Integer(padSize);
        return result;
    }
    
    public static void dumpArrayBytes(byte[] byteArray, int ndx) {
        System.out.println(String.format("%02x %02x %02x %02x %02x %02x %02x %02x %02x %02x %02x %02x %02x %02x %02x %02x %02x %02x %02x %02x", 
        byteArray[ndx +  0], byteArray[ndx +  1], byteArray[ndx +  2], byteArray[ndx +  3],
        byteArray[ndx +  4], byteArray[ndx +  5], byteArray[ndx +  6], byteArray[ndx +  7],
        byteArray[ndx +  8], byteArray[ndx +  9], byteArray[ndx + 10], byteArray[ndx + 11],
        byteArray[ndx + 12], byteArray[ndx + 13], byteArray[ndx + 14], byteArray[ndx + 15],
        byteArray[ndx + 16], byteArray[ndx + 17], byteArray[ndx + 18], byteArray[ndx + 19]));
    }
}
