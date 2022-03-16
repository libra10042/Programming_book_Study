import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ToRealPath {
    // toRealPath 사용 예
    public static void main(String[] args) {
        try{
            // 심볼릭 링크를 실제 경로로 전환해서 객체 생성.
            Path path = Paths.get("C:\\tools\\downloads").toRealPath();
            print(path);

            // 심볼릭 링크 경로를 객체 생성
            path = Paths.get("C:\\tools\\downloads");
            print(path);

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void print(Path path){
        System.out.format("toString : %s\n", path.toString());
        System.out.format("getFileName : %s\n", path.getFileName());
        System.out.format("toString : %s\n", path.getName(0));
        System.out.format("toString : %s\n", path.getNameCount());
        System.out.format("toString : %s\n", path.subpath(0, 2));
        System.out.format("toString : %s\n", path.getParent());
        System.out.format("toString : %s\n", path.getRoot());



    }

}
