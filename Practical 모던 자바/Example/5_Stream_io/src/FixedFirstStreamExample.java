import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FixedFirstStreamExample {

    public static void main(String[] args) {
        List<String> firstList = new ArrayList<String>();

        firstList.add("1");
        firstList.add("2");
        firstList.add("3");
        firstList.add("4");
        firstList.add("5");
        firstList.add("6");
        firstList.add("7");
        firstList.add("8");
        firstList.add("9");
        System.out.println("First List : " + firstList);

        // 스트림의 크기를 출력한다.
        Stream<String> firstStream = firstList.stream();
        System.out.println(firstStream.count());

        // 스트림 데이터를 5개로 제한한 후 그 값을 출력한다.
        firstStream = firstList.stream(); // 다시 Stream 객체 생성. 올바른 예는 아니다.
        Stream<String> limitedStream = firstStream.limit(5);
        limitedStream.forEach(System.out::println);




    }

}
