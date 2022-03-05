import java.util.Arrays;
import java.util.stream.Stream;

public class ArrayToStreamExample {

    //  배열을 스트림으로 변환하는 애
    public static void main(String[] args) {
        Person2[] person2List = { new Person2("장윤기", "45"),
                    new Person2("장윤기", "45"),
                    new Person2("장윤기", "45"),
                    new Person2("장윤기", "45"),
                    new Person2("장윤기", "45")};

        Stream<Person2> stream = Arrays.stream(person2List);
        stream.forEach(System.out::println);
        stream.forEach(System.out::println);
    }

}
