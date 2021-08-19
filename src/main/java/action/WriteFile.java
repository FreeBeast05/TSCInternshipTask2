package action;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {

    public static void write(String line, String path){
        try (BufferedWriter writer = new BufferedWriter( new FileWriter(path, true))){
            writer.write(line + "\n");
        }
        catch (IOException e){
            System.out.println("Возникла ошибка записи  в " + path);
        }
    }
}
