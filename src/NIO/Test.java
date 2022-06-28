package NIO;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Test {
    public static void main(String[] args) {
        //Get file Path
        Path run = Paths.get("C:\\Java\\input.txt");
        System.out.println(run.getFileName());
        System.out.println(run.getParent());
        System.out.println(run.getFileSystem());
        System.out.println(run.getNameCount());
        System.out.println(run.getName(0));
    }

}
