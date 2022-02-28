import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FirstStreamExample {

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

        System.out.println("First List: " + firstList);

        // 스트림 객체를 생성한다.
        Stream<String> firstStream = firstList.stream();
        // 스트림 객체의 크기를 조회한다. ( 최종 연산 )
        System.out.println("Stream 항목 개수 : " + firstStream.count());

        // 스트림에서 앞에서 5개의 데이터를 한정해서 새로운 스르림 객체를 생성한다.
        Stream<String> limitedStream = firstStream.limit(5);
        limitedStream.forEach(System.out::println);

        // 에러 발생.

    }

}
