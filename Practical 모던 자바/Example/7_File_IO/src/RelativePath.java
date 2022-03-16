import java.nio.file.Path;
import java.nio.file.Paths;

public class RelativePath {
    // 상대 경로 관련 정보 출력 예
    public static void main(String[] args) {
        // 상대 경로 생성
        Path path = Paths.get("../sally/bar");

        System.out.format("toString : %s\n", path.toString());

        System.out.format("getFileName : %s\n", path.getFileName());
        System.out.format("getName : %s\n", path.getName(0));
        System.out.format("getNameCount : %s\n", path.getNameCount());
        System.out.format("subPath(0, 2) : %s\n", path.getParent());
        System.out.format("getRoot : %s\n", path.getRoot());

    }
}
