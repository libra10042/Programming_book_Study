import java.util.ArrayList;
import java.util.List;

public class StreamDistinctExample {
    public void test(){
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("cj", "46"));
        personList.add(new Person("cj", "46"));
        personList.add(new Person("cj", "46"));
        personList.add(new Person("cj", "46"));
        personList.add(new Person("cj", "46"));
        personList.add(new Person("cj", "46"));
        personList.add(new Person("cj", "46"));
        personList.add(new Person("cj", "46"));
        personList.add(new Person("cj", "46"));
        personList.add(new Person("cj", "46"));

        personList.stream().distinct().forEach(System.out::println);

    }

    public static void main(String[] args) {
        new StreamDistinctExample().test();
    }

}
