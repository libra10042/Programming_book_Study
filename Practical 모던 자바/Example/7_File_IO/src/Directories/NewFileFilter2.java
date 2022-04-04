package Directories;

import java.io.IOException;
import java.nio.file.*;

public class NewFileFilter2 {
    public static void main(String[] args) {
        Path dir = Paths.get("C:/Windows");

        // 필터를 정의한다.
        DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>(){
            public boolean accept(Path file){
                return (Files.isDirectory(file));
            }
        };

        // DirectoryStream.Filter를 기준으로 목록을 조회한다.
        try(DirectoryStream<Path> stream = Files.newDirectoryStream(dir, filter)){
            for(Path file : stream){
                System.out.println(file.getFileName());
            }
        }catch(IOException | DirectoryIteratorException x){
            System.err.println(x);
        }



    }
}
