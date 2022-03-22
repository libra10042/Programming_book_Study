package 파일관리;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/*
* 작은 파일을 읽어들일 때만 사용할 수 있는 방법이다.
* 주의해서 사용해야 한다.
* */
public class SmallFileIO {

    // 파일의 전체 내용을 바이트 배열로 읽어들인다.
    public static byte[] readAllFromFile(Path filePath) throws Exception {
        byte[] fileArray = Files.readAllBytes(filePath); // 주의해서 사용해야 한다.
        return fileArray;
    }

    // 파일에 전체 데이터를 한번에 저장한다.
    public static void writeAllToFile(Path filePath, byte[] fileArray) throws IOException {
        Files.write(filePath, fileArray, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
    }


    public static void main(String[] args) {
        if(args.length < 1){
            System.out.println("Usage : java SmallFileIO <path>");
            return;
        }
        String filePath = args[0];

        try{
            // 파일을 한번에 읽어 들인다.
            byte[] fileContents = readAllFromFile(Paths.get(filePath));

            // 데이터를 처리하는 로직을 구현한다.
            // ...

            // 파일을 한번에 저장한다.
            writeAllToFile(Paths.get(filePath), fileContents);

        }catch(IOException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
