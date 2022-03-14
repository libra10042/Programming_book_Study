package stream_parallel;

import javax.management.MBeanAttributeInfo;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class InsideParallelStream3 {
    // 병렬 스트림 API 기반으로 스레드 풀 제어 예
    public static void main(String[] args) throws Exception{
        List<Integer> intList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // 별도의 스레드 풀 생성
        ForkJoinPool customPool = new ForkJoinPool(2);
        customPool.submit(() -> {
            // 스레드 풀 크기를 구한다.
            System.out.printf("## Thread Pool Size : %s\n", customPool.getParallelism());

            intList.parallelStream().forEach(value -> {
                // 현재 스레드 이름을 구함.
                String threadName = Thread.currentThread().getName();

                LocalDateTime currentTime = LocalDateTime.now();
                System.out.printf(currentTime.format(formatter) + " -> Thread Name : %s, Stream value : %s\n", threadName, value);


                // 시간 확인을 위해 2초간 sleep
                try{
                    TimeUnit.SECONDS.sleep(2);
                }catch(InterruptedException E){}
            });
        }).get();

    }

}
