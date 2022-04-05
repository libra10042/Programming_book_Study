package FileTree;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

/*
* Watcher API를 이용한 디렉터리 모니터링
* */
public class WatchingDirectory {

    public static void main(String[] args) throws IOException {
        // 1. 모니터링을 하는 WatchService 객체를 생성
        WatchService watchService = FileSystems.getDefault().newWatchService();

        // 2. 모니터링 대상 경로를 생성하고 WatchService에 등록한다.
        Path logsDir = Paths.get("C:/temp/logs");
        logsDir.register(watchService,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_MODIFY,
                StandardWatchEventKinds.ENTRY_DELETE);

        // 3. 모니터링 대상 경로를 생성하고 WatchService 에 추가로 등록한다.
        Path propertiesDir = Paths.get("C:/temp/properties");
        propertiesDir.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);

        // 4. 변경 감지 프로그램 작성
        while(true){
            try {
                // 5. 키 값 조회
                WatchKey changeKey = watchService.take();
                List<WatchEvent<?>> watchEvents = changeKey.pollEvents();

                // 6. 키에 해당하는 변경 목록 조회
                for(WatchEvent<?> watchEvent : watchEvents){
                    WatchEvent<Path> pathEvent = (WatchEvent<Path>) watchEvent;
                    Path path = pathEvent.context();
                    WatchEvent.Kind<Path> eventKind = pathEvent.kind();
                    System.out.println(eventKind + " for path: " + path);
                }
                // 변경 키 초기화
                changeKey.reset();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }

    }
}
