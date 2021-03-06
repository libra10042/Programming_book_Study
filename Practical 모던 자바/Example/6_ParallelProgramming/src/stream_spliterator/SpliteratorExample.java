package stream_spliterator;

import java.util.List;
import java.util.Spliterator;

public class SpliteratorExample {
    // Spliterator 사용 예
    public static void main(String[] args) {
        //List 객체를 생성한다.
        List<HelloPerson> personList = HelloPerson.getSampleDate();

        // Spliterator 객체를 생성한다.
        Spliterator<HelloPerson> spliterator = personList.spliterator();

        // 순차 처리한다.
        spliterator.forEachRemaining((person) -> System.out.printf("안녕~ %s\n", person));
    }
}
