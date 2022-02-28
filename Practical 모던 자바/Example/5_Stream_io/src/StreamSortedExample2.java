import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StreamSortedExample2 {
    private static Collections comparable;

    // 스트림 객체를 정렬하는 예
    public static void main(String[] args) {
        List<Person2> personList = new ArrayList<>();
        personList.add(new Person2("홍길동", "45"));
        personList.add(new Person2("이길동", "85"));
        personList.add(new Person2("김길동", "75"));
        personList.add(new Person2("박길동", "65"));
        personList.add(new Person2("최길동", "15"));
        personList.add(new Person2("조길동", "25"));
        personList.add(new Person2("모길동", "35"));

        // 역방향으로 정렬한다. (Comparable 해야 한다.)
        personList.stream().sorted(comparable.reverseOrder())
                .forEach(System.out::println);

        System.out.println("--------------------------");

        // 나이순으로 정렬한다.
        personList.stream().sorted(Comparator.comparing(Person2::getAge))
                .forEach(System.out::println);

        System.out.println("--------------------------");

        //이름순으로 정렬한다.
        personList.stream().sorted(Comparator.comparing(Person2::getName))
                        .forEach(System.out::println);
        System.out.println("--------------------------");


    }

}
