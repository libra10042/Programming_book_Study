import java.util.stream.Stream;

public class StreamOfExample {
    // of 메서드로 스트림 객체 생성하는 예
    public static void main(String[] args) {
        Stream<Person2> stream = Stream.of(new Person2("장윤기", "45"),
                                new Person2("장윤기", "45"),
                                new Person2("장윤기", "45"),
                                new Person2("장윤기", "45"));


        stream.forEach(System.out::println);
    }


}
