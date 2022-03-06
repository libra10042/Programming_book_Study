import java.util.Arrays;
import java.util.List;

public class StreamFlatMapExample {
    // 다중 배열 처리 예
    public static void main(String[] args) {
        String[][] rawData = new String[][]{
//                {"a", "b"}, {"c", "d"}, {"e", "a"}, {"a", "h"}, {"i", "j"}
                {"a", "b", "c", "d", "e"}, {"c", "d"}, {"e", "a", "d"}, {"a", "h"}, {"i", "j"}


        };

        List<String[]> rawList = Arrays.asList(rawData);

        rawList.stream()
                // a를 핕러링한다.
                .filter(array -> "a".equals(array[0].toString())
                        || "a".equals(array[1].toString()))
                // 결과값을 출력한다.
                .forEach(array -> System.out.println("{" + array[0] + ", " + array[1] + "}"));

    }

    // 2차원 배열의 데이터 중 "a" 값을 찾기 위한 것이다.
    // 위 코딩은 배열의 크기가 얼마나 될지 미리 예측 가능할 때만 사용이 가능하다.

}
