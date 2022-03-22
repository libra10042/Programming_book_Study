package 파일관리;

/*
* 파일 생성 시 OpenOption 을 이용하는 예
* */

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FilePermission {

    public static void main(String[] args) {
        if(args.length < 1){
            System.out.println("Usage : java FilePermission <file>");
        }

        // 파일을 생성할 때 사용할 옵션을 지정한다.
        // 없으면 생성하고 있으면 파일의 제일 윗부분에 데이터를 추가한다.
        Set<OpenOption> options = new HashSet<OpenOption>();
        options.add(StandardOpenOption.APPEND);
        options.add(StandardOpenOption.CREATE);


        // 파일 생성 시 퍼미션을 지정한다.
        // 소유자에게는 읽고 쓰기, 그룹에는 읽기 외에는 권한을 부여하지 않는다.
        Set<PosixFilePermission> perms = PosixFilePermissions.fromString("rw-r-----");
        FileAttribute<Set<PosixFilePermission>> attr = PosixFilePermissions.asFileAttribute(perms);


        // 저장할 데이터를 작성한다.
        String s = "안녕하세요. 인사이트 출판사입니다.";
        byte data[] = s.getBytes();
        ByteBuffer bb = ByteBuffer.wrap(data);

        System.out.println(bb);
        Path file = Paths.get(args[0]);

        // SeekableByteChannel을 이용해서 저장한다.
        try(SeekableByteChannel sbc = Files.newByteChannel(file, options, attr)){
            sbc.write(bb);
        }catch(IOException e){
            e.printStackTrace();
        }



    }


}
