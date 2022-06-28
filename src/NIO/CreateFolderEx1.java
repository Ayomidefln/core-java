package NIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreateFolderEx1 {
    public static void main(String[] args) throws IOException {
        Path run = Paths.get("C:/Java/NIO");
        Files.createDirectory(run);
    }
}
