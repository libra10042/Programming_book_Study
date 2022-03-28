package 파일관리;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
* java.io의 RandomAccessFile 사용 예
* */
public class RandomAccessFileOld {
    public static void main(String[] args) {
        if(args.length < 1){
            System.out.println("Usage : java RandomAccessFileOld <file>");
            return;
        }

        File file = new File(args[0]);

        try(RandomAccessFile randomFile = new RandomAccessFile(file, "rw")){
            int i = 0;

            try{
                // 데이터를 저장한다.
                randomFile.write("RandomAccessFile 예제입니다.".getBytes());
                // 포지션을 8칸 앞으로 이동한다.
                randomFile.seek(randomFile.getFilePointer()-8);
                // 데이터를 저장한다.
                randomFile.write("위치가 변경되었습니다.".getBytes());
                // 포지션을 파일의 제일 앞으로 이동한다.
                randomFile.seek(0);
                // 파일을 읽어 들이면서 결과를 출력한다.
                while ((i = randomFile.read()) != -1) {
                    System.out.println((char) i);

                }

            }catch(IOException e){
                e.printStackTrace();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
