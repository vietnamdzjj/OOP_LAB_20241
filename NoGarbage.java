package hust.soict.globalict.garbage;

import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
    public static void main(String[] args) {
        try {
            String filename = "test.exe"; // Specify the correct file path
            byte[] inputBytes = Files.readAllBytes(Paths.get(filename));
            long startTime, endTime;

            startTime = System.currentTimeMillis();

            // Using StringBuilder instead of "+"
            StringBuilder outputString = new StringBuilder();
            for (byte b : inputBytes) {
                outputString.append((char) b);
            }

            endTime = System.currentTimeMillis();
            System.out.println("Time taken: " + (endTime - startTime) + " ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
