import java.util.Arrays;
import java.util.List;

public class StreamMatchExample {
    // 스트틺의 데이터 비교 기능을 사용한 예
    public static void main(String[] args) {
        List<Integer> numberList = Arrays.asList(1, 3, 5, 6, 9, 11);

        // allMatch 예제
        boolean answer1 = numberList.stream().allMatch(number -> number < 10);
        System.out.printf("10보다 모두 작은가요? : %s\n", answer1);


        // anyMatch 에제
        boolean answer2 = numberList.stream().anyMatch(number -> number % 3 ==0);
        System.out.printf("3의 배수가 있나요? : %s\n", answer2);


        // noneMatch 예제
        boolean answer3 = numberList.stream().noneMatch(number -> number % 2 == 0);
        System.out.printf("양수가 없나요 : %s\n", answer3);




    }

}
