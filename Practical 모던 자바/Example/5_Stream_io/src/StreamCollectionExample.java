import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamCollectionExample {

    public static void main(String[] args) {
        List<Person2> person2List = new ArrayList<>();

        person2List.add(new Person2("장윤기 ", "45"));
        person2List.add(new Person2("장윤기 ", "45"));
        person2List.add(new Person2("장윤기 ", "45"));
        person2List.add(new Person2("장윤기 ", "45"));
        person2List.add(new Person2("장윤기 ", "45"));
        person2List.add(new Person2("장윤기 ", "45"));

        // 최종결과를 List 객체로 리턴한다.
        List<Person2> sortedList = person2List.stream().sorted().collect(Collectors
                .toList());

        for(Person2 person2 : sortedList){
            System.out.println(person2);
        }


    }
}
