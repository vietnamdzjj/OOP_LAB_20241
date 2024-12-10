package hust.soict.globalict.garbage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
public class NoGarbage {

    public static void main(String[] aStrings) {
        String filename = System.getProperty("user.dir")+File.separator+"test.txt";
        byte[] inputBytes = { 0 };
        long startTime = System.currentTimeMillis();
        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
            StringBuilder outpStringBuilder = new StringBuilder();
            for(byte b: inputBytes){
                outpStringBuilder.append((char)b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }
}