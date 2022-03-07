import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamFindExample {

    // 스트림의 데이터 찾기 기능을 사용한 예
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        Optional<Integer> result = list.stream().parallel().filter(num -> num < 4).findAny();

        System.out.println(result.get());

    }
}
