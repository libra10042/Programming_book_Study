import java.util.Arrays;
import java.util.List;

public class ReduceDebugging {
    // reduce 메서드에서 전달되는 x,y 값을 출력한다.
    public static int debugArguments(int x, int y){
        System.out.printf("x = %s, y = %s, sum = %s\n", x, y, x + y);
        return x + y;
    }

    // reduce 메서드 디버깅을 위한 예
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        // 메서드 참조로 정의
        int sum = intList.stream()
                .reduce(0, ReduceDebugging::debugArguments);
        System.out.printf("Final sum : %\n", sum);

    }


}
