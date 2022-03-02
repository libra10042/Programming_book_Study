import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamMapExample {

    // 스트림 map 메서드 사용 예
    public static void main(String[] args) {
        List<Person2> personList = new ArrayList<>();
        personList.add(new Person2("장윤기", "45"));
        personList.add(new Person2("장윤기", "45"));
        personList.add(new Person2("장윤기", "45"));
        personList.add(new Person2("장윤기", "45"));
        personList.add(new Person2("장윤기", "45"));


        // Stream<Person2> -> Stream<String>으로 변환한다.
        Stream<String> personStream = personList.stream().map((Person2 p) -> p.toString());

        personStream.forEach(System.out::println);

    }
}
