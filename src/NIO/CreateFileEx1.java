package NIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreateFileEx1 {
    public static void main(String[] args) {
        Path run = Paths.get("C:/Java/Input2.txt");
        try {
            Files.createFile(run);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
