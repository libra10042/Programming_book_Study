package FileTree;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/*
* FileVisitor를 이용한 목록 조회 예제
* */
public class PrintAllFiles {
    // 특정 디렉터리 하위의 전체 디렉터리와 파일 목록을 출력한다.
    public static void main(String[] args) {
        Path dirPath = Paths.get("C:/windows");

        try{
            // 익명 클래스로 정의해서 FileVisitor 인터페이스를 구현하였다.
            Files.walkFileTree(dirPath, new FileVisitor<Path>() {
                // 디렉터리에 진입하기 전에 호출된다.
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    return FileVisitResult.CONTINUE;
                }

                // 디렉터리에 진입한 후에 호출된다.
                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException{
                    System.out.format("디렉터리 : %s%n", dir);
                    return FileVisitResult.CONTINUE;
                }

                // 파일에 접근하면서 호출된다.
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attr) throws IOException{
                    if(attr.isSymbolicLink()){
                        System.out.format("심볼릭 링크 : %s", file);
                    }else if(attr.isRegularFile()){
                        System.out.format("일반 파일 : %s", file);
                    }else {
                        System.out.format("기타 파일 : %s%n", file);
                    }
                    System.out.println("(" + attr.size() + "바이트)");
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    System.err.println(exc);
                    return FileVisitResult.CONTINUE;

                }
            });
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
