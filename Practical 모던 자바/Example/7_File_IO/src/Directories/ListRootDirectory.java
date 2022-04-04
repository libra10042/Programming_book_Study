package Directories;

import java.nio.file.FileSystems;
import java.nio.file.Path;

/*
* 파일 NIO 를 이용한 루트 디렉터리 조회
* */
public class ListRootDirectory {

    public static void main(String[] args) {
        // 루트 디렉터리 조회
        Iterable<Path> rootDirs = FileSystems.getDefault().getRootDirectories();

        for(Path rootPath : rootDirs){
            System.out.println(rootPath);
        }
    }

}
