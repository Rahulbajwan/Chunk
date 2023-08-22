import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class sender {
    public static void main(String[] args) {
        String inputFilePath = "your_input_file.ext"; 
        int chunkSize = 1024 * 1024; 
        
        try {
            File inputFile = new File(inputFilePath);
            FileInputStream fis = new FileInputStream(inputFile);
            byte[] buffer = new byte[chunkSize];
            int bytesRead;
            int chunkIndex = 0;
            
            while ((bytesRead = fis.read(buffer)) > 0) {
                String chunkFileName = "chunk_" + chunkIndex + ".chunk";
                FileOutputStream fos = new FileOutputStream(chunkFileName);
                fos.write(buffer, 0, bytesRead);
                fos.close();
                chunkIndex++;
            }
            
            fis.close();
            System.out.println("File split into chunks successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
