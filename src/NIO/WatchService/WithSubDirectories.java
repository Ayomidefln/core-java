package NIO.WatchService;

import java.nio.file.*;

public class WithSubDirectories {
    public static void main(String[] args) {
        Path path = Paths.get("C:\\Java");

        try (WatchService watchService = FileSystems.getDefault().newWatchService()) {
            WatchKey key = path.register(watchService,
                    StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_MODIFY,
                    StandardWatchEventKinds.ENTRY_DELETE);
            startListerning(watchService);


        }catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Completed");
    }

    private static void startListerning(WatchService watchService)
    throws InterruptedException{
        while (true){
            WatchKey queuedKey = watchService.take();
            for (WatchEvent<?> watchEvent : queuedKey.pollEvents()) {
                System.out.printf("kind=%s, count=%d, context=%s Context type=%s%n",
                        watchEvent.kind(),
                        watchEvent.count(),watchEvent.context(),
                        ((Path) watchEvent.context()).getClass());
                //do something useful with the modified file/folder here
                if (!queuedKey.reset()){
                    break;
                }
            }
        }
    }
}
