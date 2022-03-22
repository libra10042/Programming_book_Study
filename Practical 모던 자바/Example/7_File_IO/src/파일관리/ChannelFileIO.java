package 파일관리;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/*
* FileChannel과 Files를 이용해서 파일 처리하는 예
* */
public class ChannelFileIO {
    public static void main(String[] args) {
        if(args.length < 2){
            System.out.println("Usage : java ChannelFileIO <source><target>");
        }
        Path sourcePath = Paths.get(args[0]);
        Path targetPath = Paths.get(args[1]);


        // SeekableByteChannel을 이용하였다.
        try(SeekableByteChannel inputChannel = Files.newByteChannel(sourcePath, StandardOpenOption.READ);
            SeekableByteChannel outChannel = Files.newByteChannel(targetPath, StandardOpenOption.CREATE_NEW);){
            ByteBuffer buf = ByteBuffer.allocate(1024);

            // 파일에서 데이터를 읽어 들인다. 버퍼의 크기만큼 읽어서 저장한다.
            while(inputChannel.read(buf) != 0){
                // 파일에 데이터를 저장한다.
                outChannel.write(buf);

                // ...

                // ByteBuffer 값을 초기화한다.
                buf.rewind();
            }
        }catch(IOException e){
            e.printStackTrace();
        }

    }

}
