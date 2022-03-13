import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class FutureExample {

    // 제곱을 계산하는 Callable 객체를 생성한다.
    public Callable<Long> calSquare(long value){
        Callable<Long> callable = new Callable<Long>(){

            @Override
            public Long call() throws Exception {

                Long returnValue = value * value;
                TimeUnit.SECONDS.sleep(1);
                System.out.println(value + "의 제곱근은 " + returnValue);
                return returnValue;
            }
        };
        return callable;
    }

    public void executeTest(){
        List<Long> sampleDataList = Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L);
        List<Future<Long>> futureList = new ArrayList<>();

        // 스레드 풀을 생성한다. 고정 스레드 풀을 이용하였다.
        ExecutorService servicePool = Executors.newFixedThreadPool(4);

        // Callable 객체를 생성한 후 스레드 풀에 등록한다.
        // 등록한 스레드에 대해 Future 객체를 리턴받는다.
        for(Long sampleValue : sampleDataList){
            Future<Long> future = servicePool.submit(calSquare(sampleValue));
            futureList.add(future);
        }

        Long sumValue = 0L;

        // Future 목록의 결과를 반환한다 .
        for(Future<Long> future : futureList){
            try{
                // 결과를 읽어 들일 때까지 대기한다.
                // 대기하는 동안, 스레드가 계산을 하고 값을 리턴한다.
                sumValue += future.get();
            }catch(ExecutionException | InterruptedException e){
                e.printStackTrace();
            }

        }
        System.out.println("최종 합계 : " + sumValue);

        servicePool.shutdown();
    }

    public static void main(String[] args) {
        FutureExample futureExample = new FutureExample();
        futureExample.executeTest();
    }

}
