import java.util.ArrayList;
import java.util.List;

public class StreamSortedExample {
    // 스트림 정렬 사용 예
    public static void main(String[] args) {
        List<Person2> person2List = new ArrayList<>();
        person2List.add(new Person2("장윤기", "45"));
        person2List.add(new Person2("장윤기", "45"));
        person2List.add(new Person2("장윤기", "45"));
        person2List.add(new Person2("장윤기", "45"));


        person2List.stream().sorted().forEach(System.out::println);
    }

}
