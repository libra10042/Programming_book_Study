package stream_parallel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
// 스트림 병렬 처리에서 기본값으로 사용하는 ForkJoinPool 의 common Pool 개수를 조정ㅎ서 동시 처리 개수를 관리하는 예제.
public class InsideParallelStream2 {
    // 병렬 스트림 API 사용 예
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // 스레드 개수 2개로 설정
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "2");

        System.out.printf("## Thread Pool Size : %s\n", ForkJoinPool.getCommonPoolParallelism());

        intList.parallelStream().forEach(value -> {
            // 현재 스레드 이름을 구함
            String threadName = Thread.currentThread().getName();

            LocalDateTime currentTime = LocalDateTime.now();

            System.out.printf(currentTime.format(formatter) + " -> Thread Name : %s, Stream Value : %s\n", threadName, value);

            // 시간 확인을 위한 2초간 sleep 함.
            try{
                TimeUnit.SECONDS.sleep(2);
            }catch(InterruptedException e){}


        });


    }
}
