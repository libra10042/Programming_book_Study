import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

public class StreamDistinctExample2 {

    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> key){
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(key.apply(t), Boolean.TRUE) == null;
    }

    public void test(){

        List<Person2> person2List = new ArrayList<>();
        person2List.add(new Person2("장윤기", "25"));
        person2List.add(new Person2("장윤기", "25"));
        person2List.add(new Person2("장윤기", "25"));
        person2List.add(new Person2("장윤기", "25"));
        person2List.add(new Person2("장윤기", "25"));

        //distinctByKey로 필터링.
        person2List.stream().filter(distinctByKey(b -> (b.getName() + b.getAge())))
                .forEach(System.out::println);

    }

    // 스트림 객체의 데이터 중복 제거 예.
    public static void main(String[] args) {
        new StreamDistinctExample2().test();
    }

}
