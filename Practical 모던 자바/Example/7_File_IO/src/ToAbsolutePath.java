import java.nio.file.Path;
import java.nio.file.Paths;


public class ToAbsolutePath {
    // 상대 경로와 절대 경로 정보 출력 예
    public static void main(String[] args) {
        Path path = Paths.get("../sally/bar");
        // 상대 경로 기준으로 출련한다.
        print(path);

        Path fullPath = path.toAbsolutePath();
        // 절대 경로 기준으로 출력한다.
        print(fullPath);

    }

    // Path 객체의 정보를 출력한다.
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
