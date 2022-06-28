package NIO.WatchService;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;

import static java.nio.file.StandardWatchEventKinds.*;

public class Example1 {

    private final WatchService watcher;
    private final Map<WatchKey, Path> keys;
    //Creates a WatchServices and registers the given directory
    Example1(Path dir) throws IOException{
        this.watcher = FileSystems.getDefault().newWatchService();
        this.keys =  new HashMap<WatchKey, Path>();

        walkAndRegisterDirectories(dir);
    }
    //Register the given directory with the WatchServices; This function will be called by Filevisitor

    private void registerDirectory(Path dir) throws IOException{
        WatchKey key = dir.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
        keys.put(key, dir);
    }
    //Register  the given directory, and all its subdirectories, with the WatchServices

    private void walkAndRegisterDirectories(final Path start) throws IOException {
        //Register diretory and subdirectories
        Files.walkFileTree(start, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
                    throws IOException {
                registerDirectory(dir);
                return FileVisitResult.CONTINUE;
            }
        });

    }
        //Process all events for keys queued to the watcher
        void processEvents(){
            for (;;){
                //wait for key to be signalled
                WatchKey key;
                try {
                    key = watcher.take();
                }catch (InterruptedException x) {
                    return;
                }

                Path dir = keys.get(key);
                if (dir == null) {
                    System.err.println("Watch not recognized!!");
                    continue;
                }
                for (WatchEvent<?> event : key.pollEvents()) {

                    WatchEvent.Kind kind = event.kind();

                    //Context for directory entry event is the file name of entry
                    @SuppressWarnings("unchecked")
                    Path name = ((WatchEvent<Path>)event).context();
                    Path child = dir.resolve(name);

                    //print out event
                    System.out.format("%s: %s\n", event.kind().name(),child);

                    //if directory is created, and watching recurcively,
                    //then register it and its sub-directories
                    if(kind == ENTRY_CREATE) {
                        try{
                            if (Files.isDirectory(child)){
                                walkAndRegisterDirectories(child);
                            }
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                    }

                }
                //reset key and remove from set if directory no longer accessible
                boolean valid = key.reset();
                if (!valid){
                    keys.remove(key);

                    //all directories are inaccessible
                    if (keys.isEmpty()){
                        break;
                    }
                }
            }
        }

    public static void main(String[] args) throws IOException {
        Path dir = Paths.get("C:\\Java");
        new Example1(dir).processEvents();
    }


}

