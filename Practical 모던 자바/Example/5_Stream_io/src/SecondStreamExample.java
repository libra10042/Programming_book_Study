import java.util.ArrayList;
import java.util.List;

public class SecondStreamExample {

    // 스트림 API의 파이프라인 예제.
    public static void main(String[] args) {
        List<String> firstList = new ArrayList<String>();

        firstList.add("1");
        firstList.add("2");
        firstList.add("3");
        firstList.add("4");
        firstList.add("5");
        firstList.add("6");
        firstList.add("7");
        firstList.add("8");
        firstList.add("9");
        System.out.println("First List : " + firstList);

        // 스트림 데이터의 크기를 출력한다.
        System.out.println(firstList.stream().count());

        // 스트림 데이터를 5개로 제한한 후 그 값을 출력한다.
        firstList.stream().limit(5).forEach(System.out::println);





    }

}
