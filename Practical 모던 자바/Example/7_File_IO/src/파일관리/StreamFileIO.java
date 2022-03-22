package 파일관리;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
* Files를 이용한 Input/Output Stream 기반의 파일 처리예
* */
public class StreamFileIO {

    public static void main(String[] args) {
        if(args.length < 2){
            System.out.println("Usage : java StreamFileIO <source> <target>");
            return;
        }

        Path sourcePath = Paths.get(args[0]);
        Path targetPath = Paths.get(args[1]);

        // InputStream, OutputStream 을 이용해서 파일을 처리한다.
        try(InputStream input = Files.newInputStream(sourcePath); BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            OutputStream out = Files.newOutputStream(targetPath); BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out))) {
                String line = null;

                // 파일에서 데이터를 읽어 들인다. 한 줄씩 읽어 들이는 예제이다.
                while((line =reader.readLine())!=null){
                    System.out.println(line);

                    // 특정한 비즈니스 로직을 구현한다.
                    // ...

                    // 데이터를 파일에 저장한다.
                    writer.write(line, 0, line.length());
                }
        }catch(IOException e){
            e.printStackTrace();
        }
    }


}
