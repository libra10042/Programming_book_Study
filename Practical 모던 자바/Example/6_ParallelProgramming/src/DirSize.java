import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class DirSize {

    // 재귀 호출되는 메서드
    protected Long compute(Path path){
        long fileSize = 0;

        try {
            List<Path> fileList = Files.list(path).collect(Collectors.toList());

            for(Path file : fileList){
                if(Files.isDirectory(file)){
                    fileSize += compute(file);


                }else{
                    fileSize += Files.size(file);
                }
            }

        }catch(IOException e){
            e.printStackTrace();
        }
        return fileSize;
    }

    // 재귀 호출 처리하는 예
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        Path rootPath = Paths.get("C:\\Program Files");

        DirSize dirSize = new DirSize();
        System.out.printf("합계 : %s\n ", dirSize.compute(rootPath));

        long endTime = System.currentTimeMillis();

        System.out.printf("처리 시간 : " + (endTime - startTime));


    }


}
