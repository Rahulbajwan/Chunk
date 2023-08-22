import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class reciever {
    public static void main(String[] args) {
        String outputFilePath = "received_output.ext"; 
        
        try {
            File outputFile = new File(outputFilePath);
            FileOutputStream fos = new FileOutputStream(outputFile);
            int chunkIndex = 0;
            
            while (true) {
                String chunkFileName = "chunk_" + chunkIndex + ".chunk";
                File chunkFile = new File(chunkFileName);
                
                if (!chunkFile.exists()) {
                    break;
                }
                
                FileInputStream fis = new FileInputStream(chunkFile);
                byte[] buffer = new byte[(int) chunkFile.length()];
                fis.read(buffer);
                fos.write(buffer);
                fis.close();
                
                chunkFile.delete(); 
                chunkIndex++;
            }
            
            fos.close();
            System.out.println("Chunks received and combined into the output file.");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

