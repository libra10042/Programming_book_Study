import java.nio.file.Path;
import java.nio.file.Paths;

public class ConvertingPath {
    // 상대 경로를 절대 경ㄹ로로 변경한 예
    public static void main(String[] args) {
        if(args.length < 1){
            System.out.println("usage : ConvertingPath file");
            System.exit(-1);
        }

        // 입력 받은 값을 기준으로 Path를 생성한다.
        Path inputPath = Paths.get(args[0]);
        // Path 정보를 절대 경로로 전환한다.
        Path fullPath = inputPath.toAbsolutePath();

        System.out.println(fullPath);

    }

}
