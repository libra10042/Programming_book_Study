import java.util.Arrays;
import java.util.List;

public class StreamFlatMapExample2 {
    // flatMap 을 이용한 데이터 평면화
    public static void main(String[] args) {
        String[][] rawData = new String[][]{
                {"a", "b"}, {"c", "d"}, {"e", "a"}, {"a", "h"}, {"i", "j"}
        };

        List<String[]> rawList = Arrays.asList(rawData);

        rawList.stream()
                // 배열을 펼친다.
                .flatMap(array -> Arrays.stream(array))
                // a캐릭터를 필터링한다.
                .filter(data -> "a".equals(data.toString()))
                // 결과를 출력한다.
                .forEach(data -> System.out.println(data));


    }

}
