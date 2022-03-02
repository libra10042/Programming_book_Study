import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamMapExample2 {

    // 기본형 데이터를 이용한  map 처리 예
    public static void main(String[] args) {
        List<Person2> personList = new ArrayList<>();
        personList.add(new Person2("장윤기", "45"));
        personList.add(new Person2("장윤기", "45"));
        personList.add(new Person2("장윤기", "45"));
        personList.add(new Person2("장윤기", "45"));
        personList.add(new Person2("장윤기", "45"));


        // Stream<Person2> -> IntStream으로 변환.
        IntStream intStream = personList.stream().mapToInt((Person2 p) -> Integer.parseInt(p.getAge()));

        intStream.forEach(System.out::println);

    }

}
