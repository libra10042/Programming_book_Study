import java.nio.file.Path;
import java.nio.file.Paths;

public class JoinPath {
    // 경로에 정보 추가하는 예
    public static void main(String[] args) {
        // 기존 경로를 구한다.
        Path path = Paths.get("c:\\windows\\system32");
        System.out.println(path);

        // drivers 경로를 추가한다.
        Path resolvedPath = path.resolve("drivers");
        System.out.println(resolvedPath);

        // 절대 경로로 이동한다.
        Path annotherPath = resolvedPath.resolve("c:\\windows");
        System.out.println(annotherPath);

    }

}
